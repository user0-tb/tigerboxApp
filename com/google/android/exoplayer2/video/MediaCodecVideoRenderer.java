package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import com.google.android.exoplayer2.C0963C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.C1229Util;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;

public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final int HEVC_MAX_INPUT_SIZE_THRESHOLD = 2097152;
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseHelper frameReleaseHelper;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastBufferPresentationTimeUs;
    private long lastFrameReleaseTimeNs;
    private long lastRenderRealtimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private PlaceholderSurface placeholderSurface;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private VideoSize reportedVideoSize;
    private int scalingMode;
    private Surface surface;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private int videoFrameProcessingOffsetCount;

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    private static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    public String getName() {
        return TAG;
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector) {
        this(context2, mediaCodecSelector, 0);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j) {
        this(context2, mediaCodecSelector, j, (Handler) null, (VideoRendererEventListener) null, 0);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, false, handler, videoRendererEventListener, i, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, factory, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, 30.0f);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Context context2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, float f) {
        super(2, factory, mediaCodecSelector, z, f);
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.frameReleaseHelper = new VideoFrameReleaseHelper(applicationContext);
        Handler handler2 = handler;
        VideoRendererEventListener videoRendererEventListener2 = videoRendererEventListener;
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.joiningDeadlineMs = C0963C.TIME_UNSET;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        this.tunnelingAudioSessionId = 0;
        clearReportedVideoSize();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int supportsFormat(com.google.android.exoplayer2.mediacodec.MediaCodecSelector r11, com.google.android.exoplayer2.Format r12) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r10 = this;
            java.lang.String r0 = r12.sampleMimeType
            boolean r0 = com.google.android.exoplayer2.util.MimeTypes.isVideo(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            int r11 = com.google.android.exoplayer2.RendererCapabilities.CC.create(r1)
            return r11
        L_0x000e:
            com.google.android.exoplayer2.drm.DrmInitData r0 = r12.drmInitData
            r2 = 1
            if (r0 == 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            android.content.Context r3 = r10.context
            java.util.List r3 = getDecoderInfos(r3, r11, r12, r0, r1)
            if (r0 == 0) goto L_0x002a
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x002a
            android.content.Context r3 = r10.context
            java.util.List r3 = getDecoderInfos(r3, r11, r12, r1, r1)
        L_0x002a:
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0035
            int r11 = com.google.android.exoplayer2.RendererCapabilities.CC.create(r2)
            return r11
        L_0x0035:
            boolean r4 = supportsFormatDrm(r12)
            if (r4 != 0) goto L_0x0041
            r11 = 2
            int r11 = com.google.android.exoplayer2.RendererCapabilities.CC.create(r11)
            return r11
        L_0x0041:
            java.lang.Object r4 = r3.get(r1)
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r4 = (com.google.android.exoplayer2.mediacodec.MediaCodecInfo) r4
            boolean r5 = r4.isFormatSupported(r12)
            if (r5 != 0) goto L_0x0067
            r6 = 1
        L_0x004e:
            int r7 = r3.size()
            if (r6 >= r7) goto L_0x0067
            java.lang.Object r7 = r3.get(r6)
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r7 = (com.google.android.exoplayer2.mediacodec.MediaCodecInfo) r7
            boolean r8 = r7.isFormatSupported(r12)
            if (r8 == 0) goto L_0x0064
            r4 = r7
            r3 = 0
            r5 = 1
            goto L_0x0068
        L_0x0064:
            int r6 = r6 + 1
            goto L_0x004e
        L_0x0067:
            r3 = 1
        L_0x0068:
            if (r5 == 0) goto L_0x006c
            r6 = 4
            goto L_0x006d
        L_0x006c:
            r6 = 3
        L_0x006d:
            boolean r7 = r4.isSeamlessAdaptationSupported(r12)
            if (r7 == 0) goto L_0x0076
            r7 = 16
            goto L_0x0078
        L_0x0076:
            r7 = 8
        L_0x0078:
            boolean r4 = r4.hardwareAccelerated
            if (r4 == 0) goto L_0x007f
            r4 = 64
            goto L_0x0080
        L_0x007f:
            r4 = 0
        L_0x0080:
            if (r3 == 0) goto L_0x0085
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x0086
        L_0x0085:
            r3 = 0
        L_0x0086:
            int r8 = com.google.android.exoplayer2.util.C1229Util.SDK_INT
            r9 = 26
            if (r8 < r9) goto L_0x00a1
            java.lang.String r8 = r12.sampleMimeType
            java.lang.String r9 = "video/dolby-vision"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x00a1
            android.content.Context r8 = r10.context
            boolean r8 = com.google.android.exoplayer2.video.MediaCodecVideoRenderer.Api26.doesDisplaySupportDolbyVision(r8)
            if (r8 != 0) goto L_0x00a1
            r3 = 256(0x100, float:3.59E-43)
        L_0x00a1:
            if (r5 == 0) goto L_0x00c7
            android.content.Context r5 = r10.context
            java.util.List r11 = getDecoderInfos(r5, r11, r12, r0, r2)
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x00c7
            java.util.List r11 = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getDecoderInfosSortedByFormatSupport(r11, r12)
            java.lang.Object r11 = r11.get(r1)
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r11 = (com.google.android.exoplayer2.mediacodec.MediaCodecInfo) r11
            boolean r0 = r11.isFormatSupported(r12)
            if (r0 == 0) goto L_0x00c7
            boolean r11 = r11.isSeamlessAdaptationSupported(r12)
            if (r11 == 0) goto L_0x00c7
            r1 = 32
        L_0x00c7:
            int r11 = com.google.android.exoplayer2.RendererCapabilities.CC.create(r6, r7, r1, r4, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.supportsFormat(com.google.android.exoplayer2.mediacodec.MediaCodecSelector, com.google.android.exoplayer2.Format):int");
    }

    /* access modifiers changed from: protected */
    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.getDecoderInfosSortedByFormatSupport(getDecoderInfos(this.context, mediaCodecSelector, format, z, this.tunneling), format);
    }

    private static List<MediaCodecInfo> getDecoderInfos(Context context2, MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        if (str == null) {
            return ImmutableList.m261of();
        }
        List<MediaCodecInfo> decoderInfos = mediaCodecSelector.getDecoderInfos(str, z, z2);
        String alternativeCodecMimeType = MediaCodecUtil.getAlternativeCodecMimeType(format);
        if (alternativeCodecMimeType == null) {
            return ImmutableList.copyOf(decoderInfos);
        }
        List<MediaCodecInfo> decoderInfos2 = mediaCodecSelector.getDecoderInfos(alternativeCodecMimeType, z, z2);
        if (C1229Util.SDK_INT < 26 || !MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) || decoderInfos2.isEmpty() || Api26.doesDisplaySupportDolbyVision(context2)) {
            return ImmutableList.builder().addAll((Iterable) decoderInfos).addAll((Iterable) decoderInfos2).build();
        }
        return ImmutableList.copyOf(decoderInfos2);
    }

    private static final class Api26 {
        private Api26() {
        }

        public static boolean doesDisplaySupportDolbyVision(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null || !display.isHdr()) {
                return false;
            }
            for (int i : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        boolean z3 = getConfiguration().tunneling;
        Assertions.checkState(!z3 || this.tunnelingAudioSessionId != 0);
        if (this.tunneling != z3) {
            this.tunneling = z3;
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.mayRenderFirstFrameAfterEnableIfNotStarted = z2;
        this.renderedFirstFrameAfterEnable = false;
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        clearRenderedFirstFrame();
        this.frameReleaseHelper.onPositionReset();
        this.lastBufferPresentationTimeUs = C0963C.TIME_UNSET;
        this.initialPositionUs = C0963C.TIME_UNSET;
        this.consecutiveDroppedFrameCount = 0;
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = C0963C.TIME_UNSET;
        }
    }

    public boolean isReady() {
        PlaceholderSurface placeholderSurface2;
        if (super.isReady() && (this.renderedFirstFrameAfterReset || (((placeholderSurface2 = this.placeholderSurface) != null && this.surface == placeholderSurface2) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = C0963C.TIME_UNSET;
            return true;
        } else if (this.joiningDeadlineMs == C0963C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = C0963C.TIME_UNSET;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.totalVideoFrameProcessingOffsetUs = 0;
        this.videoFrameProcessingOffsetCount = 0;
        this.frameReleaseHelper.onStarted();
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
        this.joiningDeadlineMs = C0963C.TIME_UNSET;
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        this.frameReleaseHelper.onStopped();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        try {
            super.onReset();
        } finally {
            if (this.placeholderSurface != null) {
                releasePlaceholderSurface();
            }
        }
    }

    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setOutput(obj);
        } else if (i == 7) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
        } else if (i == 10) {
            int intValue = ((Integer) obj).intValue();
            if (this.tunnelingAudioSessionId != intValue) {
                this.tunnelingAudioSessionId = intValue;
                if (this.tunneling) {
                    releaseCodec();
                }
            }
        } else if (i == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodecAdapter codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
            }
        } else if (i != 5) {
            super.handleMessage(i, obj);
        } else {
            this.frameReleaseHelper.setChangeFrameRateStrategy(((Integer) obj).intValue());
        }
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setOutput(java.lang.Object r5) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.view.Surface
            if (r0 == 0) goto L_0x0007
            android.view.Surface r5 = (android.view.Surface) r5
            goto L_0x0008
        L_0x0007:
            r5 = 0
        L_0x0008:
            if (r5 != 0) goto L_0x0026
            com.google.android.exoplayer2.video.PlaceholderSurface r0 = r4.placeholderSurface
            if (r0 == 0) goto L_0x0010
            r5 = r0
            goto L_0x0026
        L_0x0010:
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = r4.getCodecInfo()
            if (r0 == 0) goto L_0x0026
            boolean r1 = r4.shouldUsePlaceholderSurface(r0)
            if (r1 == 0) goto L_0x0026
            android.content.Context r5 = r4.context
            boolean r0 = r0.secure
            com.google.android.exoplayer2.video.PlaceholderSurface r5 = com.google.android.exoplayer2.video.PlaceholderSurface.newInstanceV17(r5, r0)
            r4.placeholderSurface = r5
        L_0x0026:
            android.view.Surface r0 = r4.surface
            if (r0 == r5) goto L_0x006e
            r4.surface = r5
            com.google.android.exoplayer2.video.VideoFrameReleaseHelper r0 = r4.frameReleaseHelper
            r0.onSurfaceChanged(r5)
            r0 = 0
            r4.haveReportedFirstFrameRenderedForCurrentSurface = r0
            int r0 = r4.getState()
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r1 = r4.getCodec()
            if (r1 == 0) goto L_0x0054
            int r2 = com.google.android.exoplayer2.util.C1229Util.SDK_INT
            r3 = 23
            if (r2 < r3) goto L_0x004e
            if (r5 == 0) goto L_0x004e
            boolean r2 = r4.codecNeedsSetOutputSurfaceWorkaround
            if (r2 != 0) goto L_0x004e
            r4.setOutputSurfaceV23(r1, r5)
            goto L_0x0054
        L_0x004e:
            r4.releaseCodec()
            r4.maybeInitCodecOrBypass()
        L_0x0054:
            if (r5 == 0) goto L_0x0067
            com.google.android.exoplayer2.video.PlaceholderSurface r1 = r4.placeholderSurface
            if (r5 == r1) goto L_0x0067
            r4.maybeRenotifyVideoSizeChanged()
            r4.clearRenderedFirstFrame()
            r5 = 2
            if (r0 != r5) goto L_0x007a
            r4.setJoiningDeadlineMs()
            goto L_0x007a
        L_0x0067:
            r4.clearReportedVideoSize()
            r4.clearRenderedFirstFrame()
            goto L_0x007a
        L_0x006e:
            if (r5 == 0) goto L_0x007a
            com.google.android.exoplayer2.video.PlaceholderSurface r0 = r4.placeholderSurface
            if (r5 == r0) goto L_0x007a
            r4.maybeRenotifyVideoSizeChanged()
            r4.maybeRenotifyRenderedFirstFrame()
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.setOutput(java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.surface != null || shouldUsePlaceholderSurface(mediaCodecInfo);
    }

    /* access modifiers changed from: protected */
    public boolean getCodecNeedsEosPropagation() {
        return this.tunneling && C1229Util.SDK_INT < 23;
    }

    /* access modifiers changed from: protected */
    public MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f) {
        PlaceholderSurface placeholderSurface2 = this.placeholderSurface;
        if (!(placeholderSurface2 == null || placeholderSurface2.secure == mediaCodecInfo.secure)) {
            releasePlaceholderSurface();
        }
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues2 = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues2;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues2, f, this.deviceNeedsNoPostProcessWorkaround, this.tunneling ? this.tunnelingAudioSessionId : 0);
        if (this.surface == null) {
            if (shouldUsePlaceholderSurface(mediaCodecInfo)) {
                if (this.placeholderSurface == null) {
                    this.placeholderSurface = PlaceholderSurface.newInstanceV17(this.context, mediaCodecInfo.secure);
                }
                this.surface = this.placeholderSurface;
            } else {
                throw new IllegalStateException();
            }
        }
        return MediaCodecAdapter.Configuration.createForVideoDecoding(mediaCodecInfo, mediaFormat, format, this.surface, mediaCrypto);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int i;
        DecoderReuseEvaluation canReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i2 = canReuseCodec.discardReasons;
        if (format2.width > this.codecMaxValues.width || format2.height > this.codecMaxValues.height) {
            i2 |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            i2 |= 64;
        }
        int i3 = i2;
        String str = mediaCodecInfo.name;
        if (i3 != 0) {
            i = 0;
        } else {
            i = canReuseCodec.result;
        }
        return new DecoderReuseEvaluation(str, format, format2, i, i3);
    }

    /* access modifiers changed from: protected */
    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.buffersInCodecCount = 0;
    }

    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        super.setPlaybackSpeed(f, f2);
        this.frameReleaseHelper.onPlaybackSpeed(f);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0081, code lost:
        if (r3.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_AV1) == false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0024, code lost:
        r10 = ((java.lang.Integer) r10.first).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo r9, com.google.android.exoplayer2.Format r10) {
        /*
            int r0 = r10.width
            int r1 = r10.height
            r2 = -1
            if (r0 == r2) goto L_0x00f1
            if (r1 != r2) goto L_0x000b
            goto L_0x00f1
        L_0x000b:
            java.lang.String r3 = r10.sampleMimeType
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            java.lang.String r5 = "video/avc"
            java.lang.String r6 = "video/hevc"
            r7 = 1
            r8 = 2
            if (r4 == 0) goto L_0x0037
            android.util.Pair r10 = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(r10)
            if (r10 == 0) goto L_0x0036
            java.lang.Object r10 = r10.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r10 == r3) goto L_0x0034
            if (r10 == r7) goto L_0x0034
            if (r10 != r8) goto L_0x0036
        L_0x0034:
            r3 = r5
            goto L_0x0037
        L_0x0036:
            r3 = r6
        L_0x0037:
            r3.hashCode()
            int r10 = r3.hashCode()
            r4 = 4
            switch(r10) {
                case -1664118616: goto L_0x0084;
                case -1662735862: goto L_0x007a;
                case -1662541442: goto L_0x0071;
                case 1187890754: goto L_0x0065;
                case 1331836730: goto L_0x005c;
                case 1599127256: goto L_0x0050;
                case 1599127257: goto L_0x0044;
                default: goto L_0x0042;
            }
        L_0x0042:
            r7 = -1
            goto L_0x008f
        L_0x0044:
            java.lang.String r10 = "video/x-vnd.on2.vp9"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x004e
            goto L_0x0042
        L_0x004e:
            r7 = 6
            goto L_0x008f
        L_0x0050:
            java.lang.String r10 = "video/x-vnd.on2.vp8"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x005a
            goto L_0x0042
        L_0x005a:
            r7 = 5
            goto L_0x008f
        L_0x005c:
            boolean r10 = r3.equals(r5)
            if (r10 != 0) goto L_0x0063
            goto L_0x0042
        L_0x0063:
            r7 = 4
            goto L_0x008f
        L_0x0065:
            java.lang.String r10 = "video/mp4v-es"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x006f
            goto L_0x0042
        L_0x006f:
            r7 = 3
            goto L_0x008f
        L_0x0071:
            boolean r10 = r3.equals(r6)
            if (r10 != 0) goto L_0x0078
            goto L_0x0042
        L_0x0078:
            r7 = 2
            goto L_0x008f
        L_0x007a:
            java.lang.String r10 = "video/av01"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x008f
            goto L_0x0042
        L_0x0084:
            java.lang.String r10 = "video/3gpp"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x008e
            goto L_0x0042
        L_0x008e:
            r7 = 0
        L_0x008f:
            switch(r7) {
                case 0: goto L_0x00ea;
                case 1: goto L_0x00ea;
                case 2: goto L_0x00dd;
                case 3: goto L_0x00ea;
                case 4: goto L_0x009a;
                case 5: goto L_0x00ea;
                case 6: goto L_0x0093;
                default: goto L_0x0092;
            }
        L_0x0092:
            return r2
        L_0x0093:
            int r0 = r0 * r1
            int r9 = getMaxSampleSize(r0, r4)
            return r9
        L_0x009a:
            java.lang.String r10 = com.google.android.exoplayer2.util.C1229Util.MODEL
            java.lang.String r3 = "BRAVIA 4K 2015"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x00dc
            java.lang.String r10 = com.google.android.exoplayer2.util.C1229Util.MANUFACTURER
            java.lang.String r3 = "Amazon"
            boolean r10 = r3.equals(r10)
            if (r10 == 0) goto L_0x00c7
            java.lang.String r10 = com.google.android.exoplayer2.util.C1229Util.MODEL
            java.lang.String r3 = "KFSOWI"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x00dc
            java.lang.String r10 = com.google.android.exoplayer2.util.C1229Util.MODEL
            java.lang.String r3 = "AFTS"
            boolean r10 = r3.equals(r10)
            if (r10 == 0) goto L_0x00c7
            boolean r9 = r9.secure
            if (r9 == 0) goto L_0x00c7
            goto L_0x00dc
        L_0x00c7:
            r9 = 16
            int r10 = com.google.android.exoplayer2.util.C1229Util.ceilDivide((int) r0, (int) r9)
            int r0 = com.google.android.exoplayer2.util.C1229Util.ceilDivide((int) r1, (int) r9)
            int r10 = r10 * r0
            int r10 = r10 * 16
            int r10 = r10 * 16
            int r9 = getMaxSampleSize(r10, r8)
            return r9
        L_0x00dc:
            return r2
        L_0x00dd:
            r9 = 2097152(0x200000, float:2.938736E-39)
            int r0 = r0 * r1
            int r10 = getMaxSampleSize(r0, r8)
            int r9 = java.lang.Math.max(r9, r10)
            return r9
        L_0x00ea:
            int r0 = r0 * r1
            int r9 = getMaxSampleSize(r0, r8)
            return r9
        L_0x00f1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo, com.google.android.exoplayer2.Format):int");
    }

    /* access modifiers changed from: protected */
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        float f2 = -1.0f;
        for (Format format2 : formatArr) {
            float f3 = format2.frameRate;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
        if (C1229Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23((MediaCodecAdapter) Assertions.checkNotNull(getCodec()));
        }
    }

    /* access modifiers changed from: protected */
    public void onCodecReleased(String str) {
        this.eventDispatcher.decoderReleased(str);
    }

    /* access modifiers changed from: protected */
    public void onCodecError(Exception exc) {
        Log.m154e(TAG, "Video codec error", exc);
        this.eventDispatcher.videoCodecError(exc);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation onInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged(formatHolder.format, onInputFormatChanged);
        return onInputFormatChanged;
    }

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (!this.tunneling) {
            this.buffersInCodecCount++;
        }
        if (C1229Util.SDK_INT < 23 && this.tunneling) {
            onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
        }
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(Format format, MediaFormat mediaFormat) {
        int i;
        int i2;
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
        if (this.tunneling) {
            this.currentWidth = format.width;
            this.currentHeight = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
            if (z) {
                i = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
            } else {
                i = mediaFormat.getInteger("width");
            }
            this.currentWidth = i;
            if (z) {
                i2 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
            } else {
                i2 = mediaFormat.getInteger("height");
            }
            this.currentHeight = i2;
        }
        this.currentPixelWidthHeightRatio = format.pixelWidthHeightRatio;
        if (C1229Util.SDK_INT < 21) {
            this.currentUnappliedRotationDegrees = format.rotationDegrees;
        } else if (format.rotationDegrees == 90 || format.rotationDegrees == 270) {
            int i3 = this.currentWidth;
            this.currentWidth = this.currentHeight;
            this.currentHeight = i3;
            this.currentPixelWidthHeightRatio = 1.0f / this.currentPixelWidthHeightRatio;
        }
        this.frameReleaseHelper.onFormatChanged(format.frameRate);
    }

    /* access modifiers changed from: protected */
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b != -75 || s != 60 || s2 != 1 || b2 != 4) {
                    return;
                }
                if (b3 == 0 || b3 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    setHdr10PlusInfoV29(getCodec(), bArr);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean processOutputBuffer(long j, long j2, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        long j4;
        boolean z3;
        long j5 = j;
        MediaCodecAdapter mediaCodecAdapter2 = mediaCodecAdapter;
        int i4 = i;
        long j6 = j3;
        Assertions.checkNotNull(mediaCodecAdapter);
        if (this.initialPositionUs == C0963C.TIME_UNSET) {
            this.initialPositionUs = j5;
        }
        if (j6 != this.lastBufferPresentationTimeUs) {
            this.frameReleaseHelper.onNextFrame(j6);
            this.lastBufferPresentationTimeUs = j6;
        }
        long outputStreamOffsetUs = getOutputStreamOffsetUs();
        long j7 = j6 - outputStreamOffsetUs;
        if (!z || z2) {
            double playbackSpeed = (double) getPlaybackSpeed();
            boolean z4 = getState() == 2;
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            long j8 = (long) (((double) (j6 - j5)) / playbackSpeed);
            if (z4) {
                j8 -= elapsedRealtime - j2;
            }
            if (this.surface != this.placeholderSurface) {
                long j9 = elapsedRealtime - this.lastRenderRealtimeUs;
                if (this.renderedFirstFrameAfterEnable ? this.renderedFirstFrameAfterReset : !z4 && !this.mayRenderFirstFrameAfterEnableIfNotStarted) {
                    j4 = j9;
                    z3 = false;
                } else {
                    j4 = j9;
                    z3 = true;
                }
                if (this.joiningDeadlineMs == C0963C.TIME_UNSET && j5 >= outputStreamOffsetUs && (z3 || (z4 && shouldForceRenderOutputBuffer(j8, j4)))) {
                    long nanoTime = System.nanoTime();
                    notifyFrameMetadataListener(j7, nanoTime, format);
                    if (C1229Util.SDK_INT >= 21) {
                        renderOutputBufferV21(mediaCodecAdapter, i, j7, nanoTime);
                    } else {
                        renderOutputBuffer(mediaCodecAdapter2, i4, j7);
                    }
                    updateVideoFrameProcessingOffsetCounters(j8);
                    return true;
                }
                if (z4 && j5 != this.initialPositionUs) {
                    long nanoTime2 = System.nanoTime();
                    long adjustReleaseTime = this.frameReleaseHelper.adjustReleaseTime((j8 * 1000) + nanoTime2);
                    long j10 = (adjustReleaseTime - nanoTime2) / 1000;
                    long j11 = j10;
                    boolean z5 = this.joiningDeadlineMs != C0963C.TIME_UNSET;
                    if (shouldDropBuffersToKeyframe(j10, j2, z2) && maybeDropBuffersToKeyframe(j5, z5)) {
                        return false;
                    }
                    if (shouldDropOutputBuffer(j11, j2, z2)) {
                        if (z5) {
                            skipOutputBuffer(mediaCodecAdapter2, i4, j7);
                        } else {
                            dropOutputBuffer(mediaCodecAdapter2, i4, j7);
                        }
                        updateVideoFrameProcessingOffsetCounters(j11);
                        return true;
                    }
                    long j12 = j11;
                    if (C1229Util.SDK_INT >= 21) {
                        if (j12 < 50000) {
                            if (adjustReleaseTime == this.lastFrameReleaseTimeNs) {
                                skipOutputBuffer(mediaCodecAdapter2, i4, j7);
                            } else {
                                notifyFrameMetadataListener(j7, adjustReleaseTime, format);
                                renderOutputBufferV21(mediaCodecAdapter, i, j7, adjustReleaseTime);
                            }
                            updateVideoFrameProcessingOffsetCounters(j12);
                            this.lastFrameReleaseTimeNs = adjustReleaseTime;
                            return true;
                        }
                    } else if (j12 < 30000) {
                        if (j12 > 11000) {
                            try {
                                Thread.sleep((j12 - 10000) / 1000);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        }
                        notifyFrameMetadataListener(j7, adjustReleaseTime, format);
                        renderOutputBuffer(mediaCodecAdapter2, i4, j7);
                        updateVideoFrameProcessingOffsetCounters(j12);
                        return true;
                    }
                }
                return false;
            } else if (!isBufferLate(j8)) {
                return false;
            } else {
                skipOutputBuffer(mediaCodecAdapter2, i4, j7);
                updateVideoFrameProcessingOffsetCounters(j8);
                return true;
            }
        } else {
            skipOutputBuffer(mediaCodecAdapter2, i4, j7);
            return true;
        }
    }

    private void notifyFrameMetadataListener(long j, long j2, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, getCodecOutputMediaFormat());
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedTunneledBuffer(long j) throws ExoPlaybackException {
        updateOutputFormatForTime(j);
        maybeNotifyVideoSizeChanged();
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j);
    }

    /* access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    /* access modifiers changed from: protected */
    public void onProcessedOutputBuffer(long j) {
        super.onProcessedOutputBuffer(j);
        if (!this.tunneling) {
            this.buffersInCodecCount--;
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        clearRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropOutputBuffer(long j, long j2, boolean z) {
        return isBufferLate(j) && !z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropBuffersToKeyframe(long j, long j2, boolean z) {
        return isBufferVeryLate(j) && !z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return isBufferLate(j) && j2 > 100000;
    }

    /* access modifiers changed from: protected */
    public void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    /* access modifiers changed from: protected */
    public void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(0, 1);
    }

    /* access modifiers changed from: protected */
    public boolean maybeDropBuffersToKeyframe(long j, boolean z) throws ExoPlaybackException {
        int skipSource = skipSource(j);
        if (skipSource == 0) {
            return false;
        }
        if (z) {
            this.decoderCounters.skippedInputBufferCount += skipSource;
            this.decoderCounters.skippedOutputBufferCount += this.buffersInCodecCount;
        } else {
            this.decoderCounters.droppedToKeyframeCount++;
            updateDroppedBufferCounters(skipSource, this.buffersInCodecCount);
        }
        flushOrReinitializeCodec();
        return true;
    }

    /* access modifiers changed from: protected */
    public void updateDroppedBufferCounters(int i, int i2) {
        this.decoderCounters.droppedInputBufferCount += i;
        int i3 = i + i2;
        this.decoderCounters.droppedBufferCount += i3;
        this.droppedFrames += i3;
        this.consecutiveDroppedFrameCount += i3;
        this.decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedBufferCount);
        int i4 = this.maxDroppedFramesToNotify;
        if (i4 > 0 && this.droppedFrames >= i4) {
            maybeNotifyDroppedFrames();
        }
    }

    /* access modifiers changed from: protected */
    public void updateVideoFrameProcessingOffsetCounters(long j) {
        this.decoderCounters.addVideoFrameProcessingOffset(j);
        this.totalVideoFrameProcessingOffsetUs += j;
        this.videoFrameProcessingOffsetCount++;
    }

    /* access modifiers changed from: protected */
    public void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    public void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    private boolean shouldUsePlaceholderSurface(MediaCodecInfo mediaCodecInfo) {
        return C1229Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || PlaceholderSurface.isSecureSupported(this.context));
    }

    private void releasePlaceholderSurface() {
        Surface surface2 = this.surface;
        PlaceholderSurface placeholderSurface2 = this.placeholderSurface;
        if (surface2 == placeholderSurface2) {
            this.surface = null;
        }
        placeholderSurface2.release();
        this.placeholderSurface = null;
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : C0963C.TIME_UNSET;
    }

    private void clearRenderedFirstFrame() {
        MediaCodecAdapter codec;
        this.renderedFirstFrameAfterReset = false;
        if (C1229Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    /* access modifiers changed from: package-private */
    public void maybeNotifyRenderedFirstFrame() {
        this.renderedFirstFrameAfterEnable = true;
        if (!this.renderedFirstFrameAfterReset) {
            this.renderedFirstFrameAfterReset = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
            this.haveReportedFirstFrameRenderedForCurrentSurface = true;
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.haveReportedFirstFrameRenderedForCurrentSurface) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedVideoSize = null;
    }

    private void maybeNotifyVideoSizeChanged() {
        if (this.currentWidth != -1 || this.currentHeight != -1) {
            VideoSize videoSize = this.reportedVideoSize;
            if (videoSize == null || videoSize.width != this.currentWidth || this.reportedVideoSize.height != this.currentHeight || this.reportedVideoSize.unappliedRotationDegrees != this.currentUnappliedRotationDegrees || this.reportedVideoSize.pixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
                VideoSize videoSize2 = new VideoSize(this.currentWidth, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
                this.reportedVideoSize = videoSize2;
                this.eventDispatcher.videoSizeChanged(videoSize2);
            }
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null) {
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int i = this.videoFrameProcessingOffsetCount;
        if (i != 0) {
            this.eventDispatcher.reportVideoFrameProcessingOffset(this.totalVideoFrameProcessingOffsetUs, i);
            this.totalVideoFrameProcessingOffsetUs = 0;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private static void setHdr10PlusInfoV29(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.setParameters(bundle);
    }

    /* access modifiers changed from: protected */
    public void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface2) {
        mediaCodecAdapter.setOutputSurface(surface2);
    }

    private static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    /* access modifiers changed from: protected */
    public MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues2, float f, boolean z, int i) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, "profile", ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues2.width);
        mediaFormat.setInteger("max-height", codecMaxValues2.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues2.inputSize);
        if (C1229Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            configureTunnelingV21(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize;
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (!(maxInputSize == -1 || (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format)) == -1)) {
                maxInputSize = Math.min((int) (((float) maxInputSize) * INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR), codecMaxInputSize);
            }
            return new CodecMaxValues(i, i2, maxInputSize);
        }
        int length = formatArr.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            Format format2 = formatArr[i3];
            if (format.colorInfo != null && format2.colorInfo == null) {
                format2 = format2.buildUpon().setColorInfo(format.colorInfo).build();
            }
            if (mediaCodecInfo.canReuseCodec(format, format2).result != 0) {
                z |= format2.width == -1 || format2.height == -1;
                i = Math.max(i, format2.width);
                i2 = Math.max(i2, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z) {
            Log.m157w(TAG, "Resolutions unknown. Codec max resolution: " + i + "x" + i2);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i = Math.max(i, codecMaxSize.x);
                i2 = Math.max(i2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.buildUpon().setWidth(i).setHeight(i2).build()));
                Log.m157w(TAG, "Codec max resolution adjusted to: " + i + "x" + i2);
            }
        }
        return new CodecMaxValues(i, i2, maxInputSize);
    }

    /* access modifiers changed from: protected */
    public MediaCodecDecoderException createDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.surface);
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = ((float) i2) / ((float) i);
        for (int i3 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i4 = (int) (((float) i3) * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            if (C1229Util.SDK_INT >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i5, i3);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, (double) format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                try {
                    int ceilDivide = C1229Util.ceilDivide(i3, 16) * 16;
                    int ceilDivide2 = C1229Util.ceilDivide(i4, 16) * 16;
                    if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i6 = z ? ceilDivide2 : ceilDivide;
                        if (!z) {
                            ceilDivide = ceilDivide2;
                        }
                        return new Point(i6, ceilDivide);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    protected static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getCodecMaxInputSize(mediaCodecInfo, format);
        }
        int size = format.initializationData.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += format.initializationData.get(i2).length;
        }
        return format.maxInputSize + i;
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(C1229Util.MANUFACTURER);
    }

    /* access modifiers changed from: protected */
    public boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                deviceNeedsSetOutputSurfaceWorkaround = evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    /* access modifiers changed from: protected */
    public Surface getSurface() {
        return this.surface;
    }

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    private static int getMaxSampleSize(int i, int i2) {
        return (i * 3) / (i2 * 2);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x072d, code lost:
        if (r0.equals("ELUGA_Ray_X") == false) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x08ba, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        /*
            int r0 = com.google.android.exoplayer2.util.C1229Util.SDK_INT
            r1 = 28
            r2 = 7
            r3 = 6
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = -1
            r9 = 0
            r10 = 1
            if (r0 > r1) goto L_0x007a
            java.lang.String r0 = com.google.android.exoplayer2.util.C1229Util.DEVICE
            r0.hashCode()
            int r11 = r0.hashCode()
            switch(r11) {
                case -1339091551: goto L_0x006b;
                case -1220081023: goto L_0x0060;
                case -1220066608: goto L_0x0055;
                case -1012436106: goto L_0x004a;
                case -760312546: goto L_0x003f;
                case -64886864: goto L_0x0034;
                case 3415681: goto L_0x0029;
                case 825323514: goto L_0x001e;
                default: goto L_0x001b;
            }
        L_0x001b:
            r0 = -1
            goto L_0x0075
        L_0x001e:
            java.lang.String r11 = "machuca"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0027
            goto L_0x001b
        L_0x0027:
            r0 = 7
            goto L_0x0075
        L_0x0029:
            java.lang.String r11 = "once"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0032
            goto L_0x001b
        L_0x0032:
            r0 = 6
            goto L_0x0075
        L_0x0034:
            java.lang.String r11 = "magnolia"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x003d
            goto L_0x001b
        L_0x003d:
            r0 = 5
            goto L_0x0075
        L_0x003f:
            java.lang.String r11 = "aquaman"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0048
            goto L_0x001b
        L_0x0048:
            r0 = 4
            goto L_0x0075
        L_0x004a:
            java.lang.String r11 = "oneday"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0053
            goto L_0x001b
        L_0x0053:
            r0 = 3
            goto L_0x0075
        L_0x0055:
            java.lang.String r11 = "dangalUHD"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x005e
            goto L_0x001b
        L_0x005e:
            r0 = 2
            goto L_0x0075
        L_0x0060:
            java.lang.String r11 = "dangalFHD"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0069
            goto L_0x001b
        L_0x0069:
            r0 = 1
            goto L_0x0075
        L_0x006b:
            java.lang.String r11 = "dangal"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0074
            goto L_0x001b
        L_0x0074:
            r0 = 0
        L_0x0075:
            switch(r0) {
                case 0: goto L_0x0079;
                case 1: goto L_0x0079;
                case 2: goto L_0x0079;
                case 3: goto L_0x0079;
                case 4: goto L_0x0079;
                case 5: goto L_0x0079;
                case 6: goto L_0x0079;
                case 7: goto L_0x0079;
                default: goto L_0x0078;
            }
        L_0x0078:
            goto L_0x007a
        L_0x0079:
            return r10
        L_0x007a:
            int r0 = com.google.android.exoplayer2.util.C1229Util.SDK_INT
            r11 = 27
            if (r0 > r11) goto L_0x008b
            java.lang.String r0 = com.google.android.exoplayer2.util.C1229Util.DEVICE
            java.lang.String r12 = "HWEML"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x008b
            return r10
        L_0x008b:
            java.lang.String r0 = com.google.android.exoplayer2.util.C1229Util.MODEL
            r0.hashCode()
            int r12 = r0.hashCode()
            r13 = 8
            switch(r12) {
                case -349662828: goto L_0x00f6;
                case -321033677: goto L_0x00eb;
                case 2006354: goto L_0x00e0;
                case 2006367: goto L_0x00d5;
                case 2006371: goto L_0x00ca;
                case 1785421873: goto L_0x00bf;
                case 1785421876: goto L_0x00b4;
                case 1798172390: goto L_0x00a9;
                case 2119412532: goto L_0x009c;
                default: goto L_0x0099;
            }
        L_0x0099:
            r0 = -1
            goto L_0x0100
        L_0x009c:
            java.lang.String r12 = "AFTEUFF014"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0099
        L_0x00a5:
            r0 = 8
            goto L_0x0100
        L_0x00a9:
            java.lang.String r12 = "AFTSO001"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00b2
            goto L_0x0099
        L_0x00b2:
            r0 = 7
            goto L_0x0100
        L_0x00b4:
            java.lang.String r12 = "AFTEU014"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00bd
            goto L_0x0099
        L_0x00bd:
            r0 = 6
            goto L_0x0100
        L_0x00bf:
            java.lang.String r12 = "AFTEU011"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00c8
            goto L_0x0099
        L_0x00c8:
            r0 = 5
            goto L_0x0100
        L_0x00ca:
            java.lang.String r12 = "AFTR"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00d3
            goto L_0x0099
        L_0x00d3:
            r0 = 4
            goto L_0x0100
        L_0x00d5:
            java.lang.String r12 = "AFTN"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00de
            goto L_0x0099
        L_0x00de:
            r0 = 3
            goto L_0x0100
        L_0x00e0:
            java.lang.String r12 = "AFTA"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00e9
            goto L_0x0099
        L_0x00e9:
            r0 = 2
            goto L_0x0100
        L_0x00eb:
            java.lang.String r12 = "AFTKMST12"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00f4
            goto L_0x0099
        L_0x00f4:
            r0 = 1
            goto L_0x0100
        L_0x00f6:
            java.lang.String r12 = "AFTJMST12"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00ff
            goto L_0x0099
        L_0x00ff:
            r0 = 0
        L_0x0100:
            switch(r0) {
                case 0: goto L_0x08bc;
                case 1: goto L_0x08bc;
                case 2: goto L_0x08bc;
                case 3: goto L_0x08bc;
                case 4: goto L_0x08bc;
                case 5: goto L_0x08bc;
                case 6: goto L_0x08bc;
                case 7: goto L_0x08bc;
                case 8: goto L_0x08bc;
                default: goto L_0x0103;
            }
        L_0x0103:
            int r0 = com.google.android.exoplayer2.util.C1229Util.SDK_INT
            r12 = 26
            if (r0 > r12) goto L_0x08bb
            java.lang.String r0 = com.google.android.exoplayer2.util.C1229Util.DEVICE
            r0.hashCode()
            int r14 = r0.hashCode()
            switch(r14) {
                case -2144781245: goto L_0x089e;
                case -2144781185: goto L_0x0892;
                case -2144781160: goto L_0x0886;
                case -2097309513: goto L_0x087a;
                case -2022874474: goto L_0x086e;
                case -1978993182: goto L_0x0862;
                case -1978990237: goto L_0x0856;
                case -1936688988: goto L_0x084a;
                case -1936688066: goto L_0x083c;
                case -1936688065: goto L_0x082e;
                case -1931988508: goto L_0x0820;
                case -1885099851: goto L_0x0812;
                case -1696512866: goto L_0x0804;
                case -1680025915: goto L_0x07f6;
                case -1615810839: goto L_0x07e8;
                case -1600724499: goto L_0x07da;
                case -1554255044: goto L_0x07cb;
                case -1481772737: goto L_0x07bd;
                case -1481772730: goto L_0x07af;
                case -1481772729: goto L_0x07a1;
                case -1320080169: goto L_0x0793;
                case -1217592143: goto L_0x0785;
                case -1180384755: goto L_0x0777;
                case -1139198265: goto L_0x0769;
                case -1052835013: goto L_0x075b;
                case -993250464: goto L_0x074d;
                case -993250458: goto L_0x073f;
                case -965403638: goto L_0x0731;
                case -958336948: goto L_0x0727;
                case -879245230: goto L_0x0718;
                case -842500323: goto L_0x070a;
                case -821392978: goto L_0x06fc;
                case -797483286: goto L_0x06ee;
                case -794946968: goto L_0x06df;
                case -788334647: goto L_0x06d0;
                case -782144577: goto L_0x06c2;
                case -575125681: goto L_0x06b4;
                case -521118391: goto L_0x06a6;
                case -430914369: goto L_0x0698;
                case -290434366: goto L_0x0689;
                case -282781963: goto L_0x067b;
                case -277133239: goto L_0x066d;
                case -173639913: goto L_0x065f;
                case -56598463: goto L_0x0650;
                case 2126: goto L_0x0642;
                case 2564: goto L_0x0634;
                case 2715: goto L_0x0626;
                case 2719: goto L_0x0618;
                case 3091: goto L_0x060a;
                case 3483: goto L_0x05fc;
                case 73405: goto L_0x05ee;
                case 75537: goto L_0x05e0;
                case 75739: goto L_0x05d2;
                case 76779: goto L_0x05c4;
                case 78669: goto L_0x05b6;
                case 79305: goto L_0x05a8;
                case 80618: goto L_0x059a;
                case 88274: goto L_0x058c;
                case 98846: goto L_0x057e;
                case 98848: goto L_0x0570;
                case 99329: goto L_0x0562;
                case 101481: goto L_0x0554;
                case 1513190: goto L_0x0546;
                case 1514184: goto L_0x0538;
                case 1514185: goto L_0x052a;
                case 2133089: goto L_0x051c;
                case 2133091: goto L_0x050e;
                case 2133120: goto L_0x0500;
                case 2133151: goto L_0x04f2;
                case 2133182: goto L_0x04e4;
                case 2133184: goto L_0x04d6;
                case 2436959: goto L_0x04c8;
                case 2463773: goto L_0x04ba;
                case 2464648: goto L_0x04ac;
                case 2689555: goto L_0x049e;
                case 3154429: goto L_0x0490;
                case 3284551: goto L_0x0482;
                case 3351335: goto L_0x0474;
                case 3386211: goto L_0x0466;
                case 41325051: goto L_0x0458;
                case 51349633: goto L_0x044a;
                case 51350594: goto L_0x043c;
                case 55178625: goto L_0x042e;
                case 61542055: goto L_0x0420;
                case 65355429: goto L_0x0412;
                case 66214468: goto L_0x0404;
                case 66214470: goto L_0x03f6;
                case 66214473: goto L_0x03e8;
                case 66215429: goto L_0x03da;
                case 66215431: goto L_0x03cc;
                case 66215433: goto L_0x03be;
                case 66216390: goto L_0x03b0;
                case 76402249: goto L_0x03a2;
                case 76404105: goto L_0x0394;
                case 76404911: goto L_0x0386;
                case 80963634: goto L_0x0378;
                case 82882791: goto L_0x036a;
                case 98715550: goto L_0x035c;
                case 101370885: goto L_0x034e;
                case 102844228: goto L_0x0340;
                case 165221241: goto L_0x0332;
                case 182191441: goto L_0x0324;
                case 245388979: goto L_0x0316;
                case 287431619: goto L_0x0308;
                case 307593612: goto L_0x02fa;
                case 308517133: goto L_0x02ec;
                case 316215098: goto L_0x02de;
                case 316215116: goto L_0x02d0;
                case 316246811: goto L_0x02c2;
                case 316246818: goto L_0x02b4;
                case 407160593: goto L_0x02a6;
                case 507412548: goto L_0x0298;
                case 793982701: goto L_0x028a;
                case 794038622: goto L_0x027c;
                case 794040393: goto L_0x026e;
                case 835649806: goto L_0x0260;
                case 917340916: goto L_0x0252;
                case 958008161: goto L_0x0244;
                case 1060579533: goto L_0x0236;
                case 1150207623: goto L_0x0228;
                case 1176899427: goto L_0x021a;
                case 1280332038: goto L_0x020c;
                case 1306947716: goto L_0x01fe;
                case 1349174697: goto L_0x01f0;
                case 1522194893: goto L_0x01e1;
                case 1691543273: goto L_0x01d3;
                case 1691544261: goto L_0x01c5;
                case 1709443163: goto L_0x01b7;
                case 1865889110: goto L_0x01a9;
                case 1906253259: goto L_0x019b;
                case 1977196784: goto L_0x018d;
                case 2006372676: goto L_0x0180;
                case 2019281702: goto L_0x0173;
                case 2029784656: goto L_0x0166;
                case 2030379515: goto L_0x0159;
                case 2033393791: goto L_0x014c;
                case 2047190025: goto L_0x013f;
                case 2047252157: goto L_0x0132;
                case 2048319463: goto L_0x0125;
                case 2048855701: goto L_0x0118;
                default: goto L_0x0115;
            }
        L_0x0115:
            r1 = -1
            goto L_0x08a9
        L_0x0118:
            java.lang.String r1 = "HWWAS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0121
            goto L_0x0115
        L_0x0121:
            r1 = 139(0x8b, float:1.95E-43)
            goto L_0x08a9
        L_0x0125:
            java.lang.String r1 = "HWVNS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x012e
            goto L_0x0115
        L_0x012e:
            r1 = 138(0x8a, float:1.93E-43)
            goto L_0x08a9
        L_0x0132:
            java.lang.String r1 = "ELUGA_Prim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x013b
            goto L_0x0115
        L_0x013b:
            r1 = 137(0x89, float:1.92E-43)
            goto L_0x08a9
        L_0x013f:
            java.lang.String r1 = "ELUGA_Note"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0148
            goto L_0x0115
        L_0x0148:
            r1 = 136(0x88, float:1.9E-43)
            goto L_0x08a9
        L_0x014c:
            java.lang.String r1 = "ASUS_X00AD_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0155
            goto L_0x0115
        L_0x0155:
            r1 = 135(0x87, float:1.89E-43)
            goto L_0x08a9
        L_0x0159:
            java.lang.String r1 = "HWCAM-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0162
            goto L_0x0115
        L_0x0162:
            r1 = 134(0x86, float:1.88E-43)
            goto L_0x08a9
        L_0x0166:
            java.lang.String r1 = "HWBLN-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x016f
            goto L_0x0115
        L_0x016f:
            r1 = 133(0x85, float:1.86E-43)
            goto L_0x08a9
        L_0x0173:
            java.lang.String r1 = "DM-01K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x017c
            goto L_0x0115
        L_0x017c:
            r1 = 132(0x84, float:1.85E-43)
            goto L_0x08a9
        L_0x0180:
            java.lang.String r1 = "BRAVIA_ATV3_4K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0189
            goto L_0x0115
        L_0x0189:
            r1 = 131(0x83, float:1.84E-43)
            goto L_0x08a9
        L_0x018d:
            java.lang.String r1 = "Infinix-X572"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0197
            goto L_0x0115
        L_0x0197:
            r1 = 130(0x82, float:1.82E-43)
            goto L_0x08a9
        L_0x019b:
            java.lang.String r1 = "PB2-670M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01a5
            goto L_0x0115
        L_0x01a5:
            r1 = 129(0x81, float:1.81E-43)
            goto L_0x08a9
        L_0x01a9:
            java.lang.String r1 = "santoni"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01b3
            goto L_0x0115
        L_0x01b3:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x08a9
        L_0x01b7:
            java.lang.String r1 = "iball8735_9806"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01c1
            goto L_0x0115
        L_0x01c1:
            r1 = 127(0x7f, float:1.78E-43)
            goto L_0x08a9
        L_0x01c5:
            java.lang.String r1 = "CPH1715"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01cf
            goto L_0x0115
        L_0x01cf:
            r1 = 126(0x7e, float:1.77E-43)
            goto L_0x08a9
        L_0x01d3:
            java.lang.String r1 = "CPH1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01dd
            goto L_0x0115
        L_0x01dd:
            r1 = 125(0x7d, float:1.75E-43)
            goto L_0x08a9
        L_0x01e1:
            java.lang.String r1 = "woods_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01ec
            goto L_0x0115
        L_0x01ec:
            r1 = 124(0x7c, float:1.74E-43)
            goto L_0x08a9
        L_0x01f0:
            java.lang.String r1 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01fa
            goto L_0x0115
        L_0x01fa:
            r1 = 123(0x7b, float:1.72E-43)
            goto L_0x08a9
        L_0x01fe:
            java.lang.String r1 = "EverStar_S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0208
            goto L_0x0115
        L_0x0208:
            r1 = 122(0x7a, float:1.71E-43)
            goto L_0x08a9
        L_0x020c:
            java.lang.String r1 = "hwALE-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0216
            goto L_0x0115
        L_0x0216:
            r1 = 121(0x79, float:1.7E-43)
            goto L_0x08a9
        L_0x021a:
            java.lang.String r1 = "itel_S41"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0224
            goto L_0x0115
        L_0x0224:
            r1 = 120(0x78, float:1.68E-43)
            goto L_0x08a9
        L_0x0228:
            java.lang.String r1 = "LS-5017"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0232
            goto L_0x0115
        L_0x0232:
            r1 = 119(0x77, float:1.67E-43)
            goto L_0x08a9
        L_0x0236:
            java.lang.String r1 = "panell_d"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0240
            goto L_0x0115
        L_0x0240:
            r1 = 118(0x76, float:1.65E-43)
            goto L_0x08a9
        L_0x0244:
            java.lang.String r1 = "j2xlteins"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x024e
            goto L_0x0115
        L_0x024e:
            r1 = 117(0x75, float:1.64E-43)
            goto L_0x08a9
        L_0x0252:
            java.lang.String r1 = "A7000plus"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x025c
            goto L_0x0115
        L_0x025c:
            r1 = 116(0x74, float:1.63E-43)
            goto L_0x08a9
        L_0x0260:
            java.lang.String r1 = "manning"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x026a
            goto L_0x0115
        L_0x026a:
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x08a9
        L_0x026e:
            java.lang.String r1 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0278
            goto L_0x0115
        L_0x0278:
            r1 = 114(0x72, float:1.6E-43)
            goto L_0x08a9
        L_0x027c:
            java.lang.String r1 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0286
            goto L_0x0115
        L_0x0286:
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x08a9
        L_0x028a:
            java.lang.String r1 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0294
            goto L_0x0115
        L_0x0294:
            r1 = 112(0x70, float:1.57E-43)
            goto L_0x08a9
        L_0x0298:
            java.lang.String r1 = "QM16XE_U"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02a2
            goto L_0x0115
        L_0x02a2:
            r1 = 111(0x6f, float:1.56E-43)
            goto L_0x08a9
        L_0x02a6:
            java.lang.String r1 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02b0
            goto L_0x0115
        L_0x02b0:
            r1 = 110(0x6e, float:1.54E-43)
            goto L_0x08a9
        L_0x02b4:
            java.lang.String r1 = "TB3-850M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02be
            goto L_0x0115
        L_0x02be:
            r1 = 109(0x6d, float:1.53E-43)
            goto L_0x08a9
        L_0x02c2:
            java.lang.String r1 = "TB3-850F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02cc
            goto L_0x0115
        L_0x02cc:
            r1 = 108(0x6c, float:1.51E-43)
            goto L_0x08a9
        L_0x02d0:
            java.lang.String r1 = "TB3-730X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02da
            goto L_0x0115
        L_0x02da:
            r1 = 107(0x6b, float:1.5E-43)
            goto L_0x08a9
        L_0x02de:
            java.lang.String r1 = "TB3-730F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02e8
            goto L_0x0115
        L_0x02e8:
            r1 = 106(0x6a, float:1.49E-43)
            goto L_0x08a9
        L_0x02ec:
            java.lang.String r1 = "A7020a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02f6
            goto L_0x0115
        L_0x02f6:
            r1 = 105(0x69, float:1.47E-43)
            goto L_0x08a9
        L_0x02fa:
            java.lang.String r1 = "A7010a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0304
            goto L_0x0115
        L_0x0304:
            r1 = 104(0x68, float:1.46E-43)
            goto L_0x08a9
        L_0x0308:
            java.lang.String r1 = "griffin"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0312
            goto L_0x0115
        L_0x0312:
            r1 = 103(0x67, float:1.44E-43)
            goto L_0x08a9
        L_0x0316:
            java.lang.String r1 = "marino_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0320
            goto L_0x0115
        L_0x0320:
            r1 = 102(0x66, float:1.43E-43)
            goto L_0x08a9
        L_0x0324:
            java.lang.String r1 = "CPY83_I00"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x032e
            goto L_0x0115
        L_0x032e:
            r1 = 101(0x65, float:1.42E-43)
            goto L_0x08a9
        L_0x0332:
            java.lang.String r1 = "A2016a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x033c
            goto L_0x0115
        L_0x033c:
            r1 = 100
            goto L_0x08a9
        L_0x0340:
            java.lang.String r1 = "le_x6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x034a
            goto L_0x0115
        L_0x034a:
            r1 = 99
            goto L_0x08a9
        L_0x034e:
            java.lang.String r1 = "l5460"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0358
            goto L_0x0115
        L_0x0358:
            r1 = 98
            goto L_0x08a9
        L_0x035c:
            java.lang.String r1 = "i9031"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0366
            goto L_0x0115
        L_0x0366:
            r1 = 97
            goto L_0x08a9
        L_0x036a:
            java.lang.String r1 = "X3_HK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0374
            goto L_0x0115
        L_0x0374:
            r1 = 96
            goto L_0x08a9
        L_0x0378:
            java.lang.String r1 = "V23GB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0382
            goto L_0x0115
        L_0x0382:
            r1 = 95
            goto L_0x08a9
        L_0x0386:
            java.lang.String r1 = "Q4310"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0390
            goto L_0x0115
        L_0x0390:
            r1 = 94
            goto L_0x08a9
        L_0x0394:
            java.lang.String r1 = "Q4260"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x039e
            goto L_0x0115
        L_0x039e:
            r1 = 93
            goto L_0x08a9
        L_0x03a2:
            java.lang.String r1 = "PRO7S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03ac
            goto L_0x0115
        L_0x03ac:
            r1 = 92
            goto L_0x08a9
        L_0x03b0:
            java.lang.String r1 = "F3311"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03ba
            goto L_0x0115
        L_0x03ba:
            r1 = 91
            goto L_0x08a9
        L_0x03be:
            java.lang.String r1 = "F3215"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03c8
            goto L_0x0115
        L_0x03c8:
            r1 = 90
            goto L_0x08a9
        L_0x03cc:
            java.lang.String r1 = "F3213"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03d6
            goto L_0x0115
        L_0x03d6:
            r1 = 89
            goto L_0x08a9
        L_0x03da:
            java.lang.String r1 = "F3211"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03e4
            goto L_0x0115
        L_0x03e4:
            r1 = 88
            goto L_0x08a9
        L_0x03e8:
            java.lang.String r1 = "F3116"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03f2
            goto L_0x0115
        L_0x03f2:
            r1 = 87
            goto L_0x08a9
        L_0x03f6:
            java.lang.String r1 = "F3113"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0400
            goto L_0x0115
        L_0x0400:
            r1 = 86
            goto L_0x08a9
        L_0x0404:
            java.lang.String r1 = "F3111"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x040e
            goto L_0x0115
        L_0x040e:
            r1 = 85
            goto L_0x08a9
        L_0x0412:
            java.lang.String r1 = "E5643"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x041c
            goto L_0x0115
        L_0x041c:
            r1 = 84
            goto L_0x08a9
        L_0x0420:
            java.lang.String r1 = "A1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x042a
            goto L_0x0115
        L_0x042a:
            r1 = 83
            goto L_0x08a9
        L_0x042e:
            java.lang.String r1 = "Aura_Note_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0438
            goto L_0x0115
        L_0x0438:
            r1 = 82
            goto L_0x08a9
        L_0x043c:
            java.lang.String r1 = "602LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0446
            goto L_0x0115
        L_0x0446:
            r1 = 81
            goto L_0x08a9
        L_0x044a:
            java.lang.String r1 = "601LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0454
            goto L_0x0115
        L_0x0454:
            r1 = 80
            goto L_0x08a9
        L_0x0458:
            java.lang.String r1 = "MEIZU_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0462
            goto L_0x0115
        L_0x0462:
            r1 = 79
            goto L_0x08a9
        L_0x0466:
            java.lang.String r1 = "p212"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0470
            goto L_0x0115
        L_0x0470:
            r1 = 78
            goto L_0x08a9
        L_0x0474:
            java.lang.String r1 = "mido"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x047e
            goto L_0x0115
        L_0x047e:
            r1 = 77
            goto L_0x08a9
        L_0x0482:
            java.lang.String r1 = "kate"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x048c
            goto L_0x0115
        L_0x048c:
            r1 = 76
            goto L_0x08a9
        L_0x0490:
            java.lang.String r1 = "fugu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x049a
            goto L_0x0115
        L_0x049a:
            r1 = 75
            goto L_0x08a9
        L_0x049e:
            java.lang.String r1 = "XE2X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04a8
            goto L_0x0115
        L_0x04a8:
            r1 = 74
            goto L_0x08a9
        L_0x04ac:
            java.lang.String r1 = "Q427"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04b6
            goto L_0x0115
        L_0x04b6:
            r1 = 73
            goto L_0x08a9
        L_0x04ba:
            java.lang.String r1 = "Q350"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04c4
            goto L_0x0115
        L_0x04c4:
            r1 = 72
            goto L_0x08a9
        L_0x04c8:
            java.lang.String r1 = "P681"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04d2
            goto L_0x0115
        L_0x04d2:
            r1 = 71
            goto L_0x08a9
        L_0x04d6:
            java.lang.String r1 = "F04J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04e0
            goto L_0x0115
        L_0x04e0:
            r1 = 70
            goto L_0x08a9
        L_0x04e4:
            java.lang.String r1 = "F04H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04ee
            goto L_0x0115
        L_0x04ee:
            r1 = 69
            goto L_0x08a9
        L_0x04f2:
            java.lang.String r1 = "F03H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04fc
            goto L_0x0115
        L_0x04fc:
            r1 = 68
            goto L_0x08a9
        L_0x0500:
            java.lang.String r1 = "F02H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x050a
            goto L_0x0115
        L_0x050a:
            r1 = 67
            goto L_0x08a9
        L_0x050e:
            java.lang.String r1 = "F01J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0518
            goto L_0x0115
        L_0x0518:
            r1 = 66
            goto L_0x08a9
        L_0x051c:
            java.lang.String r1 = "F01H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0526
            goto L_0x0115
        L_0x0526:
            r1 = 65
            goto L_0x08a9
        L_0x052a:
            java.lang.String r1 = "1714"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0534
            goto L_0x0115
        L_0x0534:
            r1 = 64
            goto L_0x08a9
        L_0x0538:
            java.lang.String r1 = "1713"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0542
            goto L_0x0115
        L_0x0542:
            r1 = 63
            goto L_0x08a9
        L_0x0546:
            java.lang.String r1 = "1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0550
            goto L_0x0115
        L_0x0550:
            r1 = 62
            goto L_0x08a9
        L_0x0554:
            java.lang.String r1 = "flo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x055e
            goto L_0x0115
        L_0x055e:
            r1 = 61
            goto L_0x08a9
        L_0x0562:
            java.lang.String r1 = "deb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x056c
            goto L_0x0115
        L_0x056c:
            r1 = 60
            goto L_0x08a9
        L_0x0570:
            java.lang.String r1 = "cv3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x057a
            goto L_0x0115
        L_0x057a:
            r1 = 59
            goto L_0x08a9
        L_0x057e:
            java.lang.String r1 = "cv1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0588
            goto L_0x0115
        L_0x0588:
            r1 = 58
            goto L_0x08a9
        L_0x058c:
            java.lang.String r1 = "Z80"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0596
            goto L_0x0115
        L_0x0596:
            r1 = 57
            goto L_0x08a9
        L_0x059a:
            java.lang.String r1 = "QX1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05a4
            goto L_0x0115
        L_0x05a4:
            r1 = 56
            goto L_0x08a9
        L_0x05a8:
            java.lang.String r1 = "PLE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05b2
            goto L_0x0115
        L_0x05b2:
            r1 = 55
            goto L_0x08a9
        L_0x05b6:
            java.lang.String r1 = "P85"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05c0
            goto L_0x0115
        L_0x05c0:
            r1 = 54
            goto L_0x08a9
        L_0x05c4:
            java.lang.String r1 = "MX6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05ce
            goto L_0x0115
        L_0x05ce:
            r1 = 53
            goto L_0x08a9
        L_0x05d2:
            java.lang.String r1 = "M5c"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05dc
            goto L_0x0115
        L_0x05dc:
            r1 = 52
            goto L_0x08a9
        L_0x05e0:
            java.lang.String r1 = "M04"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05ea
            goto L_0x0115
        L_0x05ea:
            r1 = 51
            goto L_0x08a9
        L_0x05ee:
            java.lang.String r1 = "JGZ"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05f8
            goto L_0x0115
        L_0x05f8:
            r1 = 50
            goto L_0x08a9
        L_0x05fc:
            java.lang.String r1 = "mh"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0606
            goto L_0x0115
        L_0x0606:
            r1 = 49
            goto L_0x08a9
        L_0x060a:
            java.lang.String r1 = "b5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0614
            goto L_0x0115
        L_0x0614:
            r1 = 48
            goto L_0x08a9
        L_0x0618:
            java.lang.String r1 = "V5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0622
            goto L_0x0115
        L_0x0622:
            r1 = 47
            goto L_0x08a9
        L_0x0626:
            java.lang.String r1 = "V1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0630
            goto L_0x0115
        L_0x0630:
            r1 = 46
            goto L_0x08a9
        L_0x0634:
            java.lang.String r1 = "Q5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x063e
            goto L_0x0115
        L_0x063e:
            r1 = 45
            goto L_0x08a9
        L_0x0642:
            java.lang.String r1 = "C1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x064c
            goto L_0x0115
        L_0x064c:
            r1 = 44
            goto L_0x08a9
        L_0x0650:
            java.lang.String r1 = "woods_fn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x065b
            goto L_0x0115
        L_0x065b:
            r1 = 43
            goto L_0x08a9
        L_0x065f:
            java.lang.String r1 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0669
            goto L_0x0115
        L_0x0669:
            r1 = 42
            goto L_0x08a9
        L_0x066d:
            java.lang.String r1 = "Z12_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0677
            goto L_0x0115
        L_0x0677:
            r1 = 41
            goto L_0x08a9
        L_0x067b:
            java.lang.String r1 = "BLACK-1X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0685
            goto L_0x0115
        L_0x0685:
            r1 = 40
            goto L_0x08a9
        L_0x0689:
            java.lang.String r1 = "taido_row"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0694
            goto L_0x0115
        L_0x0694:
            r1 = 39
            goto L_0x08a9
        L_0x0698:
            java.lang.String r1 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06a2
            goto L_0x0115
        L_0x06a2:
            r1 = 38
            goto L_0x08a9
        L_0x06a6:
            java.lang.String r1 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06b0
            goto L_0x0115
        L_0x06b0:
            r1 = 37
            goto L_0x08a9
        L_0x06b4:
            java.lang.String r1 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06be
            goto L_0x0115
        L_0x06be:
            r1 = 36
            goto L_0x08a9
        L_0x06c2:
            java.lang.String r1 = "OnePlus5T"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06cc
            goto L_0x0115
        L_0x06cc:
            r1 = 35
            goto L_0x08a9
        L_0x06d0:
            java.lang.String r1 = "whyred"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06db
            goto L_0x0115
        L_0x06db:
            r1 = 34
            goto L_0x08a9
        L_0x06df:
            java.lang.String r1 = "watson"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06ea
            goto L_0x0115
        L_0x06ea:
            r1 = 33
            goto L_0x08a9
        L_0x06ee:
            java.lang.String r1 = "SVP-DTV15"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06f8
            goto L_0x0115
        L_0x06f8:
            r1 = 32
            goto L_0x08a9
        L_0x06fc:
            java.lang.String r1 = "A7000-a"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0706
            goto L_0x0115
        L_0x0706:
            r1 = 31
            goto L_0x08a9
        L_0x070a:
            java.lang.String r1 = "nicklaus_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0714
            goto L_0x0115
        L_0x0714:
            r1 = 30
            goto L_0x08a9
        L_0x0718:
            java.lang.String r1 = "tcl_eu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0723
            goto L_0x0115
        L_0x0723:
            r1 = 29
            goto L_0x08a9
        L_0x0727:
            java.lang.String r2 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x08a9
            goto L_0x0115
        L_0x0731:
            java.lang.String r1 = "s905x018"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x073b
            goto L_0x0115
        L_0x073b:
            r1 = 27
            goto L_0x08a9
        L_0x073f:
            java.lang.String r1 = "A10-70L"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0749
            goto L_0x0115
        L_0x0749:
            r1 = 26
            goto L_0x08a9
        L_0x074d:
            java.lang.String r1 = "A10-70F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0757
            goto L_0x0115
        L_0x0757:
            r1 = 25
            goto L_0x08a9
        L_0x075b:
            java.lang.String r1 = "namath"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0765
            goto L_0x0115
        L_0x0765:
            r1 = 24
            goto L_0x08a9
        L_0x0769:
            java.lang.String r1 = "Slate_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0773
            goto L_0x0115
        L_0x0773:
            r1 = 23
            goto L_0x08a9
        L_0x0777:
            java.lang.String r1 = "iris60"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0781
            goto L_0x0115
        L_0x0781:
            r1 = 22
            goto L_0x08a9
        L_0x0785:
            java.lang.String r1 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x078f
            goto L_0x0115
        L_0x078f:
            r1 = 21
            goto L_0x08a9
        L_0x0793:
            java.lang.String r1 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x079d
            goto L_0x0115
        L_0x079d:
            r1 = 20
            goto L_0x08a9
        L_0x07a1:
            java.lang.String r1 = "panell_dt"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07ab
            goto L_0x0115
        L_0x07ab:
            r1 = 19
            goto L_0x08a9
        L_0x07af:
            java.lang.String r1 = "panell_ds"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07b9
            goto L_0x0115
        L_0x07b9:
            r1 = 18
            goto L_0x08a9
        L_0x07bd:
            java.lang.String r1 = "panell_dl"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07c7
            goto L_0x0115
        L_0x07c7:
            r1 = 17
            goto L_0x08a9
        L_0x07cb:
            java.lang.String r1 = "vernee_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07d6
            goto L_0x0115
        L_0x07d6:
            r1 = 16
            goto L_0x08a9
        L_0x07da:
            java.lang.String r1 = "pacificrim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07e4
            goto L_0x0115
        L_0x07e4:
            r1 = 15
            goto L_0x08a9
        L_0x07e8:
            java.lang.String r1 = "Phantom6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07f2
            goto L_0x0115
        L_0x07f2:
            r1 = 14
            goto L_0x08a9
        L_0x07f6:
            java.lang.String r1 = "ComioS1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0800
            goto L_0x0115
        L_0x0800:
            r1 = 13
            goto L_0x08a9
        L_0x0804:
            java.lang.String r1 = "XT1663"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x080e
            goto L_0x0115
        L_0x080e:
            r1 = 12
            goto L_0x08a9
        L_0x0812:
            java.lang.String r1 = "RAIJIN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x081c
            goto L_0x0115
        L_0x081c:
            r1 = 11
            goto L_0x08a9
        L_0x0820:
            java.lang.String r1 = "AquaPowerM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x082a
            goto L_0x0115
        L_0x082a:
            r1 = 10
            goto L_0x08a9
        L_0x082e:
            java.lang.String r1 = "PGN611"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0838
            goto L_0x0115
        L_0x0838:
            r1 = 9
            goto L_0x08a9
        L_0x083c:
            java.lang.String r1 = "PGN610"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0846
            goto L_0x0115
        L_0x0846:
            r1 = 8
            goto L_0x08a9
        L_0x084a:
            java.lang.String r1 = "PGN528"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0854
            goto L_0x0115
        L_0x0854:
            r1 = 7
            goto L_0x08a9
        L_0x0856:
            java.lang.String r1 = "NX573J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0860
            goto L_0x0115
        L_0x0860:
            r1 = 6
            goto L_0x08a9
        L_0x0862:
            java.lang.String r1 = "NX541J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x086c
            goto L_0x0115
        L_0x086c:
            r1 = 5
            goto L_0x08a9
        L_0x086e:
            java.lang.String r1 = "CP8676_I02"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0878
            goto L_0x0115
        L_0x0878:
            r1 = 4
            goto L_0x08a9
        L_0x087a:
            java.lang.String r1 = "K50a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0884
            goto L_0x0115
        L_0x0884:
            r1 = 3
            goto L_0x08a9
        L_0x0886:
            java.lang.String r1 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0890
            goto L_0x0115
        L_0x0890:
            r1 = 2
            goto L_0x08a9
        L_0x0892:
            java.lang.String r1 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x089c
            goto L_0x0115
        L_0x089c:
            r1 = 1
            goto L_0x08a9
        L_0x089e:
            java.lang.String r1 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x08a8
            goto L_0x0115
        L_0x08a8:
            r1 = 0
        L_0x08a9:
            switch(r1) {
                case 0: goto L_0x08ba;
                case 1: goto L_0x08ba;
                case 2: goto L_0x08ba;
                case 3: goto L_0x08ba;
                case 4: goto L_0x08ba;
                case 5: goto L_0x08ba;
                case 6: goto L_0x08ba;
                case 7: goto L_0x08ba;
                case 8: goto L_0x08ba;
                case 9: goto L_0x08ba;
                case 10: goto L_0x08ba;
                case 11: goto L_0x08ba;
                case 12: goto L_0x08ba;
                case 13: goto L_0x08ba;
                case 14: goto L_0x08ba;
                case 15: goto L_0x08ba;
                case 16: goto L_0x08ba;
                case 17: goto L_0x08ba;
                case 18: goto L_0x08ba;
                case 19: goto L_0x08ba;
                case 20: goto L_0x08ba;
                case 21: goto L_0x08ba;
                case 22: goto L_0x08ba;
                case 23: goto L_0x08ba;
                case 24: goto L_0x08ba;
                case 25: goto L_0x08ba;
                case 26: goto L_0x08ba;
                case 27: goto L_0x08ba;
                case 28: goto L_0x08ba;
                case 29: goto L_0x08ba;
                case 30: goto L_0x08ba;
                case 31: goto L_0x08ba;
                case 32: goto L_0x08ba;
                case 33: goto L_0x08ba;
                case 34: goto L_0x08ba;
                case 35: goto L_0x08ba;
                case 36: goto L_0x08ba;
                case 37: goto L_0x08ba;
                case 38: goto L_0x08ba;
                case 39: goto L_0x08ba;
                case 40: goto L_0x08ba;
                case 41: goto L_0x08ba;
                case 42: goto L_0x08ba;
                case 43: goto L_0x08ba;
                case 44: goto L_0x08ba;
                case 45: goto L_0x08ba;
                case 46: goto L_0x08ba;
                case 47: goto L_0x08ba;
                case 48: goto L_0x08ba;
                case 49: goto L_0x08ba;
                case 50: goto L_0x08ba;
                case 51: goto L_0x08ba;
                case 52: goto L_0x08ba;
                case 53: goto L_0x08ba;
                case 54: goto L_0x08ba;
                case 55: goto L_0x08ba;
                case 56: goto L_0x08ba;
                case 57: goto L_0x08ba;
                case 58: goto L_0x08ba;
                case 59: goto L_0x08ba;
                case 60: goto L_0x08ba;
                case 61: goto L_0x08ba;
                case 62: goto L_0x08ba;
                case 63: goto L_0x08ba;
                case 64: goto L_0x08ba;
                case 65: goto L_0x08ba;
                case 66: goto L_0x08ba;
                case 67: goto L_0x08ba;
                case 68: goto L_0x08ba;
                case 69: goto L_0x08ba;
                case 70: goto L_0x08ba;
                case 71: goto L_0x08ba;
                case 72: goto L_0x08ba;
                case 73: goto L_0x08ba;
                case 74: goto L_0x08ba;
                case 75: goto L_0x08ba;
                case 76: goto L_0x08ba;
                case 77: goto L_0x08ba;
                case 78: goto L_0x08ba;
                case 79: goto L_0x08ba;
                case 80: goto L_0x08ba;
                case 81: goto L_0x08ba;
                case 82: goto L_0x08ba;
                case 83: goto L_0x08ba;
                case 84: goto L_0x08ba;
                case 85: goto L_0x08ba;
                case 86: goto L_0x08ba;
                case 87: goto L_0x08ba;
                case 88: goto L_0x08ba;
                case 89: goto L_0x08ba;
                case 90: goto L_0x08ba;
                case 91: goto L_0x08ba;
                case 92: goto L_0x08ba;
                case 93: goto L_0x08ba;
                case 94: goto L_0x08ba;
                case 95: goto L_0x08ba;
                case 96: goto L_0x08ba;
                case 97: goto L_0x08ba;
                case 98: goto L_0x08ba;
                case 99: goto L_0x08ba;
                case 100: goto L_0x08ba;
                case 101: goto L_0x08ba;
                case 102: goto L_0x08ba;
                case 103: goto L_0x08ba;
                case 104: goto L_0x08ba;
                case 105: goto L_0x08ba;
                case 106: goto L_0x08ba;
                case 107: goto L_0x08ba;
                case 108: goto L_0x08ba;
                case 109: goto L_0x08ba;
                case 110: goto L_0x08ba;
                case 111: goto L_0x08ba;
                case 112: goto L_0x08ba;
                case 113: goto L_0x08ba;
                case 114: goto L_0x08ba;
                case 115: goto L_0x08ba;
                case 116: goto L_0x08ba;
                case 117: goto L_0x08ba;
                case 118: goto L_0x08ba;
                case 119: goto L_0x08ba;
                case 120: goto L_0x08ba;
                case 121: goto L_0x08ba;
                case 122: goto L_0x08ba;
                case 123: goto L_0x08ba;
                case 124: goto L_0x08ba;
                case 125: goto L_0x08ba;
                case 126: goto L_0x08ba;
                case 127: goto L_0x08ba;
                case 128: goto L_0x08ba;
                case 129: goto L_0x08ba;
                case 130: goto L_0x08ba;
                case 131: goto L_0x08ba;
                case 132: goto L_0x08ba;
                case 133: goto L_0x08ba;
                case 134: goto L_0x08ba;
                case 135: goto L_0x08ba;
                case 136: goto L_0x08ba;
                case 137: goto L_0x08ba;
                case 138: goto L_0x08ba;
                case 139: goto L_0x08ba;
                default: goto L_0x08ac;
            }
        L_0x08ac:
            java.lang.String r0 = com.google.android.exoplayer2.util.C1229Util.MODEL
            r0.hashCode()
            java.lang.String r1 = "JSN-L21"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x08ba
            goto L_0x08bb
        L_0x08ba:
            return r10
        L_0x08bb:
            return r9
        L_0x08bc:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.evaluateDeviceNeedsSetOutputSurfaceWorkaround():boolean");
    }

    private final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {
        private static final int HANDLE_FRAME_RENDERED = 0;
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler createHandlerForCurrentLooper = C1229Util.createHandlerForCurrentLooper(this);
            this.handler = createHandlerForCurrentLooper;
            mediaCodecAdapter.setOnFrameRenderedListener(this, createHandlerForCurrentLooper);
        }

        public void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j, long j2) {
            if (C1229Util.SDK_INT < 30) {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (j >> 32), (int) j));
                return;
            }
            handleFrameRendered(j);
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(C1229Util.toLong(message.arg1, message.arg2));
            return true;
        }

        private void handleFrameRendered(long j) {
            if (this == MediaCodecVideoRenderer.this.tunnelingOnFrameRenderedListener && MediaCodecVideoRenderer.this.getCodec() != null) {
                if (j == Long.MAX_VALUE) {
                    MediaCodecVideoRenderer.this.onProcessedTunneledEndOfStream();
                    return;
                }
                try {
                    MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j);
                } catch (ExoPlaybackException e) {
                    MediaCodecVideoRenderer.this.setPendingPlaybackException(e);
                }
            }
        }
    }
}
