package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.C0963C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.C1229Util;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class HlsMediaPeriod implements MediaPeriod, HlsPlaylistTracker.PlaylistEventListener {
    private final Allocator allocator;
    private final boolean allowChunklessPreparation;
    private int audioVideoSampleStreamWrapperCount;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private HlsSampleStreamWrapper[] enabledSampleStreamWrappers;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final HlsExtractorFactory extractorFactory;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private int[][] manifestUrlIndicesPerWrapper;
    /* access modifiers changed from: private */
    public MediaPeriod.Callback mediaPeriodCallback;
    private final TransferListener mediaTransferListener;
    private final int metadataType;
    private int pendingPrepareCount;
    private final PlayerId playerId;
    /* access modifiers changed from: private */
    public final HlsPlaylistTracker playlistTracker;
    private final HlsSampleStreamWrapper.Callback sampleStreamWrapperCallback = new SampleStreamWrapperCallback();
    /* access modifiers changed from: private */
    public HlsSampleStreamWrapper[] sampleStreamWrappers;
    private final IdentityHashMap<SampleStream, Integer> streamWrapperIndices;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    /* access modifiers changed from: private */
    public TrackGroupArray trackGroups;
    private final boolean useSessionKeys;

    public long readDiscontinuity() {
        return C0963C.TIME_UNSET;
    }

    static /* synthetic */ int access$106(HlsMediaPeriod hlsMediaPeriod) {
        int i = hlsMediaPeriod.pendingPrepareCount - 1;
        hlsMediaPeriod.pendingPrepareCount = i;
        return i;
    }

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher3, Allocator allocator2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, boolean z, int i, boolean z2, PlayerId playerId2) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.mediaTransferListener = transferListener;
        this.drmSessionManager = drmSessionManager2;
        this.drmEventDispatcher = eventDispatcher2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.eventDispatcher = eventDispatcher3;
        this.allocator = allocator2;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.allowChunklessPreparation = z;
        this.metadataType = i;
        this.useSessionKeys = z2;
        this.playerId = playerId2;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory2.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        this.streamWrapperIndices = new IdentityHashMap<>();
        this.timestampAdjusterProvider = new TimestampAdjusterProvider();
        this.sampleStreamWrappers = new HlsSampleStreamWrapper[0];
        this.enabledSampleStreamWrappers = new HlsSampleStreamWrapper[0];
        this.manifestUrlIndicesPerWrapper = new int[0][];
    }

    public void release() {
        this.playlistTracker.removeListener(this);
        for (HlsSampleStreamWrapper release : this.sampleStreamWrappers) {
            release.release();
        }
        this.mediaPeriodCallback = null;
    }

    public void prepare(MediaPeriod.Callback callback, long j) {
        this.mediaPeriodCallback = callback;
        this.playlistTracker.addListener(this);
        buildAndPrepareSampleStreamWrappers(j);
    }

    public void maybeThrowPrepareError() throws IOException {
        for (HlsSampleStreamWrapper maybeThrowPrepareError : this.sampleStreamWrappers) {
            maybeThrowPrepareError.maybeThrowPrepareError();
        }
    }

    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray) Assertions.checkNotNull(this.trackGroups);
    }

    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        TrackGroupArray trackGroupArray;
        int[] iArr;
        int i;
        HlsMediaPeriod hlsMediaPeriod = this;
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) Assertions.checkNotNull(hlsMediaPeriod.playlistTracker.getMultivariantPlaylist());
        boolean z = !hlsMultivariantPlaylist.variants.isEmpty();
        int length = hlsMediaPeriod.sampleStreamWrappers.length - hlsMultivariantPlaylist.subtitles.size();
        int i2 = 0;
        if (z) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsMediaPeriod.sampleStreamWrappers[0];
            iArr = hlsMediaPeriod.manifestUrlIndicesPerWrapper[0];
            trackGroupArray = hlsSampleStreamWrapper.getTrackGroups();
            i = hlsSampleStreamWrapper.getPrimaryTrackGroupIndex();
        } else {
            iArr = new int[0];
            trackGroupArray = TrackGroupArray.EMPTY;
            i = 0;
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        for (ExoTrackSelection next : list) {
            TrackGroup trackGroup = next.getTrackGroup();
            int indexOf = trackGroupArray.indexOf(trackGroup);
            if (indexOf == -1) {
                int i3 = z;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = hlsMediaPeriod.sampleStreamWrappers;
                    if (i3 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    } else if (hlsSampleStreamWrapperArr[i3].getTrackGroups().indexOf(trackGroup) != -1) {
                        int i4 = i3 < length ? 1 : 2;
                        int[] iArr2 = hlsMediaPeriod.manifestUrlIndicesPerWrapper[i3];
                        int i5 = 0;
                        while (i5 < next.length()) {
                            arrayList.add(new StreamKey(i4, iArr2[next.getIndexInTrackGroup(i5)]));
                            i5++;
                        }
                    } else {
                        i3++;
                        hlsMediaPeriod = this;
                    }
                }
            } else if (indexOf == i) {
                for (int i6 = 0; i6 < next.length(); i6++) {
                    arrayList.add(new StreamKey(i2, iArr[next.getIndexInTrackGroup(i6)]));
                }
                z3 = true;
            } else {
                z2 = true;
            }
            hlsMediaPeriod = this;
            i2 = 0;
        }
        if (z2 && !z3) {
            int i7 = iArr[0];
            int i8 = hlsMultivariantPlaylist.variants.get(iArr[0]).format.bitrate;
            for (int i9 = 1; i9 < iArr.length; i9++) {
                int i10 = hlsMultivariantPlaylist.variants.get(iArr[i9]).format.bitrate;
                if (i10 < i8) {
                    i7 = iArr[i9];
                    i8 = i10;
                }
            }
            arrayList.add(new StreamKey(0, i7));
        }
        return arrayList;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        boolean z;
        ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[exoTrackSelectionArr2.length];
        int[] iArr2 = new int[exoTrackSelectionArr2.length];
        for (int i = 0; i < exoTrackSelectionArr2.length; i++) {
            iArr[i] = sampleStreamArr2[i] == null ? -1 : this.streamWrapperIndices.get(sampleStreamArr2[i]).intValue();
            iArr2[i] = -1;
            if (exoTrackSelectionArr2[i] != null) {
                TrackGroup trackGroup = exoTrackSelectionArr2[i].getTrackGroup();
                int i2 = 0;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.sampleStreamWrappers;
                    if (i2 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    } else if (hlsSampleStreamWrapperArr[i2].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i] = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        this.streamWrapperIndices.clear();
        int length = exoTrackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr2.length];
        ExoTrackSelection[] exoTrackSelectionArr3 = new ExoTrackSelection[exoTrackSelectionArr2.length];
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new HlsSampleStreamWrapper[this.sampleStreamWrappers.length];
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        while (i4 < this.sampleStreamWrappers.length) {
            for (int i5 = 0; i5 < exoTrackSelectionArr2.length; i5++) {
                ExoTrackSelection exoTrackSelection = null;
                sampleStreamArr4[i5] = iArr[i5] == i4 ? sampleStreamArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    exoTrackSelection = exoTrackSelectionArr2[i5];
                }
                exoTrackSelectionArr3[i5] = exoTrackSelection;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.sampleStreamWrappers[i4];
            HlsSampleStreamWrapper hlsSampleStreamWrapper2 = hlsSampleStreamWrapper;
            int i6 = length;
            int i7 = i4;
            int i8 = i3;
            ExoTrackSelection[] exoTrackSelectionArr4 = exoTrackSelectionArr3;
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr3 = hlsSampleStreamWrapperArr2;
            boolean selectTracks = hlsSampleStreamWrapper.selectTracks(exoTrackSelectionArr3, zArr, sampleStreamArr4, zArr2, j, z2);
            int i9 = 0;
            boolean z3 = false;
            while (true) {
                z = true;
                if (i9 >= exoTrackSelectionArr2.length) {
                    break;
                }
                SampleStream sampleStream = sampleStreamArr4[i9];
                if (iArr2[i9] == i7) {
                    Assertions.checkNotNull(sampleStream);
                    sampleStreamArr3[i9] = sampleStream;
                    this.streamWrapperIndices.put(sampleStream, Integer.valueOf(i7));
                    z3 = true;
                } else if (iArr[i9] == i7) {
                    if (sampleStream != null) {
                        z = false;
                    }
                    Assertions.checkState(z);
                }
                i9++;
            }
            if (z3) {
                hlsSampleStreamWrapperArr3[i8] = hlsSampleStreamWrapper2;
                i3 = i8 + 1;
                if (i8 == 0) {
                    hlsSampleStreamWrapper2.setIsTimestampMaster(true);
                    if (!selectTracks) {
                        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr4 = this.enabledSampleStreamWrappers;
                        if (hlsSampleStreamWrapperArr4.length != 0 && hlsSampleStreamWrapper2 == hlsSampleStreamWrapperArr4[0]) {
                        }
                    }
                    this.timestampAdjusterProvider.reset();
                    z2 = true;
                } else {
                    if (i7 >= this.audioVideoSampleStreamWrapperCount) {
                        z = false;
                    }
                    hlsSampleStreamWrapper2.setIsTimestampMaster(z);
                }
            } else {
                i3 = i8;
            }
            i4 = i7 + 1;
            hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr3;
            length = i6;
            exoTrackSelectionArr3 = exoTrackSelectionArr4;
            sampleStreamArr2 = sampleStreamArr;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr5 = (HlsSampleStreamWrapper[]) C1229Util.nullSafeArrayCopy(hlsSampleStreamWrapperArr2, i3);
        this.enabledSampleStreamWrappers = hlsSampleStreamWrapperArr5;
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(hlsSampleStreamWrapperArr5);
        return j;
    }

    public void discardBuffer(long j, boolean z) {
        for (HlsSampleStreamWrapper discardBuffer : this.enabledSampleStreamWrappers) {
            discardBuffer.discardBuffer(j, z);
        }
    }

    public void reevaluateBuffer(long j) {
        this.compositeSequenceableLoader.reevaluateBuffer(j);
    }

    public boolean continueLoading(long j) {
        if (this.trackGroups != null) {
            return this.compositeSequenceableLoader.continueLoading(j);
        }
        for (HlsSampleStreamWrapper continuePreparing : this.sampleStreamWrappers) {
            continuePreparing.continuePreparing();
        }
        return false;
    }

    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public long seekToUs(long j) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.enabledSampleStreamWrappers;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean seekToUs = hlsSampleStreamWrapperArr[0].seekToUs(j, false);
            int i = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.enabledSampleStreamWrappers;
                if (i >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i].seekToUs(j, seekToUs);
                i++;
            }
            if (seekToUs) {
                this.timestampAdjusterProvider.reset();
            }
        }
        return j;
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.enabledSampleStreamWrappers) {
            if (hlsSampleStreamWrapper.isVideoSampleStream()) {
                return hlsSampleStreamWrapper.getAdjustedSeekPositionUs(j, seekParameters);
            }
        }
        return j;
    }

    public void onPlaylistChanged() {
        for (HlsSampleStreamWrapper onPlaylistUpdated : this.sampleStreamWrappers) {
            onPlaylistUpdated.onPlaylistUpdated();
        }
        this.mediaPeriodCallback.onContinueLoadingRequested(this);
    }

    public boolean onPlaylistError(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z) {
        boolean z2 = true;
        for (HlsSampleStreamWrapper onPlaylistError : this.sampleStreamWrappers) {
            z2 &= onPlaylistError.onPlaylistError(uri, loadErrorInfo, z);
        }
        this.mediaPeriodCallback.onContinueLoadingRequested(this);
        return z2;
    }

    private void buildAndPrepareSampleStreamWrappers(long j) {
        Map<String, DrmInitData> map;
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) Assertions.checkNotNull(this.playlistTracker.getMultivariantPlaylist());
        if (this.useSessionKeys) {
            map = deriveOverridingDrmInitData(hlsMultivariantPlaylist.sessionKeyDrmInitData);
        } else {
            map = Collections.emptyMap();
        }
        Map<String, DrmInitData> map2 = map;
        boolean z = !hlsMultivariantPlaylist.variants.isEmpty();
        List<HlsMultivariantPlaylist.Rendition> list = hlsMultivariantPlaylist.audios;
        List<HlsMultivariantPlaylist.Rendition> list2 = hlsMultivariantPlaylist.subtitles;
        this.pendingPrepareCount = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            buildAndPrepareMainSampleStreamWrapper(hlsMultivariantPlaylist, j, arrayList, arrayList2, map2);
        }
        buildAndPrepareAudioSampleStreamWrappers(j, list, arrayList, arrayList2, map2);
        this.audioVideoSampleStreamWrapperCount = arrayList.size();
        int i = 0;
        while (i < list2.size()) {
            HlsMultivariantPlaylist.Rendition rendition = list2.get(i);
            String str = "subtitle:" + i + ":" + rendition.name;
            int i2 = i;
            HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(str, 3, new Uri[]{rendition.url}, new Format[]{rendition.format}, (Format) null, Collections.emptyList(), map2, j);
            ArrayList arrayList3 = arrayList2;
            arrayList3.add(new int[]{i2});
            arrayList.add(buildSampleStreamWrapper);
            buildSampleStreamWrapper.prepareWithMultivariantPlaylistInfo(new TrackGroup[]{new TrackGroup(str, rendition.format)}, 0, new int[0]);
            i = i2 + 1;
            arrayList2 = arrayList3;
        }
        this.sampleStreamWrappers = (HlsSampleStreamWrapper[]) arrayList.toArray(new HlsSampleStreamWrapper[0]);
        this.manifestUrlIndicesPerWrapper = (int[][]) arrayList2.toArray(new int[0][]);
        this.pendingPrepareCount = this.sampleStreamWrappers.length;
        for (int i3 = 0; i3 < this.audioVideoSampleStreamWrapperCount; i3++) {
            this.sampleStreamWrappers[i3].setIsTimestampMaster(true);
        }
        for (HlsSampleStreamWrapper continuePreparing : this.sampleStreamWrappers) {
            continuePreparing.continuePreparing();
        }
        this.enabledSampleStreamWrappers = this.sampleStreamWrappers;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void buildAndPrepareMainSampleStreamWrapper(com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist r21, long r22, java.util.List<com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper> r24, java.util.List<int[]> r25, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> r26) {
        /*
            r20 = this;
            r0 = r21
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant> r1 = r0.variants
            int r1 = r1.size()
            int[] r2 = new int[r1]
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x000e:
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant> r7 = r0.variants
            int r7 = r7.size()
            r8 = 2
            r9 = 1
            if (r4 >= r7) goto L_0x0047
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant> r7 = r0.variants
            java.lang.Object r7 = r7.get(r4)
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r7 = (com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist.Variant) r7
            com.google.android.exoplayer2.Format r7 = r7.format
            int r10 = r7.height
            if (r10 > 0) goto L_0x0040
            java.lang.String r10 = r7.codecs
            java.lang.String r10 = com.google.android.exoplayer2.util.C1229Util.getCodecsOfType(r10, r8)
            if (r10 == 0) goto L_0x002f
            goto L_0x0040
        L_0x002f:
            java.lang.String r7 = r7.codecs
            java.lang.String r7 = com.google.android.exoplayer2.util.C1229Util.getCodecsOfType(r7, r9)
            if (r7 == 0) goto L_0x003c
            r2[r4] = r9
            int r6 = r6 + 1
            goto L_0x0044
        L_0x003c:
            r7 = -1
            r2[r4] = r7
            goto L_0x0044
        L_0x0040:
            r2[r4] = r8
            int r5 = r5 + 1
        L_0x0044:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x0047:
            if (r5 <= 0) goto L_0x004c
            r1 = r5
            r4 = 1
            goto L_0x0053
        L_0x004c:
            if (r6 >= r1) goto L_0x0052
            int r1 = r1 - r6
            r4 = 0
            r5 = 1
            goto L_0x0054
        L_0x0052:
            r4 = 0
        L_0x0053:
            r5 = 0
        L_0x0054:
            android.net.Uri[] r13 = new android.net.Uri[r1]
            com.google.android.exoplayer2.Format[] r6 = new com.google.android.exoplayer2.Format[r1]
            int[] r7 = new int[r1]
            r10 = 0
            r11 = 0
        L_0x005c:
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant> r12 = r0.variants
            int r12 = r12.size()
            if (r10 >= r12) goto L_0x0088
            if (r4 == 0) goto L_0x006a
            r12 = r2[r10]
            if (r12 != r8) goto L_0x0085
        L_0x006a:
            if (r5 == 0) goto L_0x0070
            r12 = r2[r10]
            if (r12 == r9) goto L_0x0085
        L_0x0070:
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant> r12 = r0.variants
            java.lang.Object r12 = r12.get(r10)
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r12 = (com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist.Variant) r12
            android.net.Uri r14 = r12.url
            r13[r11] = r14
            com.google.android.exoplayer2.Format r12 = r12.format
            r6[r11] = r12
            int r12 = r11 + 1
            r7[r11] = r10
            r11 = r12
        L_0x0085:
            int r10 = r10 + 1
            goto L_0x005c
        L_0x0088:
            r2 = r6[r3]
            java.lang.String r2 = r2.codecs
            int r5 = com.google.android.exoplayer2.util.C1229Util.getCodecCountOfType(r2, r8)
            int r2 = com.google.android.exoplayer2.util.C1229Util.getCodecCountOfType(r2, r9)
            if (r2 == r9) goto L_0x00a0
            if (r2 != 0) goto L_0x00a8
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition> r8 = r0.audios
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x00a8
        L_0x00a0:
            if (r5 > r9) goto L_0x00a8
            int r8 = r2 + r5
            if (r8 <= 0) goto L_0x00a8
            r8 = 1
            goto L_0x00a9
        L_0x00a8:
            r8 = 0
        L_0x00a9:
            if (r4 != 0) goto L_0x00af
            if (r2 <= 0) goto L_0x00af
            r12 = 1
            goto L_0x00b0
        L_0x00af:
            r12 = 0
        L_0x00b0:
            java.lang.String r4 = "main"
            com.google.android.exoplayer2.Format r15 = r0.muxedAudioFormat
            java.util.List<com.google.android.exoplayer2.Format> r14 = r0.muxedCaptionFormats
            r10 = r20
            r11 = r4
            r16 = r14
            r14 = r6
            r17 = r26
            r18 = r22
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper r10 = r10.buildSampleStreamWrapper(r11, r12, r13, r14, r15, r16, r17, r18)
            r11 = r24
            r11.add(r10)
            r11 = r25
            r11.add(r7)
            r7 = r20
            boolean r11 = r7.allowChunklessPreparation
            if (r11 == 0) goto L_0x01bb
            if (r8 == 0) goto L_0x01bb
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            if (r5 <= 0) goto L_0x015c
            com.google.android.exoplayer2.Format[] r5 = new com.google.android.exoplayer2.Format[r1]
            r11 = 0
        L_0x00e0:
            if (r11 >= r1) goto L_0x00ed
            r12 = r6[r11]
            com.google.android.exoplayer2.Format r12 = deriveVideoFormat(r12)
            r5[r11] = r12
            int r11 = r11 + 1
            goto L_0x00e0
        L_0x00ed:
            com.google.android.exoplayer2.source.TrackGroup r1 = new com.google.android.exoplayer2.source.TrackGroup
            r1.<init>(r4, r5)
            r8.add(r1)
            if (r2 <= 0) goto L_0x0128
            com.google.android.exoplayer2.Format r1 = r0.muxedAudioFormat
            if (r1 != 0) goto L_0x0103
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition> r1 = r0.audios
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0128
        L_0x0103:
            com.google.android.exoplayer2.source.TrackGroup r1 = new com.google.android.exoplayer2.source.TrackGroup
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r5 = ":audio"
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.google.android.exoplayer2.Format[] r5 = new com.google.android.exoplayer2.Format[r9]
            r6 = r6[r3]
            com.google.android.exoplayer2.Format r11 = r0.muxedAudioFormat
            com.google.android.exoplayer2.Format r6 = deriveAudioFormat(r6, r11, r3)
            r5[r3] = r6
            r1.<init>(r2, r5)
            r8.add(r1)
        L_0x0128:
            java.util.List<com.google.android.exoplayer2.Format> r0 = r0.muxedCaptionFormats
            if (r0 == 0) goto L_0x0176
            r1 = 0
        L_0x012d:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x0176
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r5 = ":cc:"
            r2.append(r5)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.google.android.exoplayer2.source.TrackGroup r5 = new com.google.android.exoplayer2.source.TrackGroup
            com.google.android.exoplayer2.Format[] r6 = new com.google.android.exoplayer2.Format[r9]
            java.lang.Object r11 = r0.get(r1)
            com.google.android.exoplayer2.Format r11 = (com.google.android.exoplayer2.Format) r11
            r6[r3] = r11
            r5.<init>(r2, r6)
            r8.add(r5)
            int r1 = r1 + 1
            goto L_0x012d
        L_0x015c:
            com.google.android.exoplayer2.Format[] r2 = new com.google.android.exoplayer2.Format[r1]
            r5 = 0
        L_0x015f:
            if (r5 >= r1) goto L_0x016e
            r11 = r6[r5]
            com.google.android.exoplayer2.Format r12 = r0.muxedAudioFormat
            com.google.android.exoplayer2.Format r11 = deriveAudioFormat(r11, r12, r9)
            r2[r5] = r11
            int r5 = r5 + 1
            goto L_0x015f
        L_0x016e:
            com.google.android.exoplayer2.source.TrackGroup r0 = new com.google.android.exoplayer2.source.TrackGroup
            r0.<init>(r4, r2)
            r8.add(r0)
        L_0x0176:
            com.google.android.exoplayer2.source.TrackGroup r0 = new com.google.android.exoplayer2.source.TrackGroup
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = ":id3"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.google.android.exoplayer2.Format[] r2 = new com.google.android.exoplayer2.Format[r9]
            com.google.android.exoplayer2.Format$Builder r4 = new com.google.android.exoplayer2.Format$Builder
            r4.<init>()
            java.lang.String r5 = "ID3"
            com.google.android.exoplayer2.Format$Builder r4 = r4.setId((java.lang.String) r5)
            java.lang.String r5 = "application/id3"
            com.google.android.exoplayer2.Format$Builder r4 = r4.setSampleMimeType(r5)
            com.google.android.exoplayer2.Format r4 = r4.build()
            r2[r3] = r4
            r0.<init>(r1, r2)
            r8.add(r0)
            com.google.android.exoplayer2.source.TrackGroup[] r1 = new com.google.android.exoplayer2.source.TrackGroup[r3]
            java.lang.Object[] r1 = r8.toArray(r1)
            com.google.android.exoplayer2.source.TrackGroup[] r1 = (com.google.android.exoplayer2.source.TrackGroup[]) r1
            int[] r2 = new int[r9]
            int r0 = r8.indexOf(r0)
            r2[r3] = r0
            r10.prepareWithMultivariantPlaylistInfo(r1, r3, r2)
        L_0x01bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaPeriod.buildAndPrepareMainSampleStreamWrapper(com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist, long, java.util.List, java.util.List, java.util.Map):void");
    }

    private void buildAndPrepareAudioSampleStreamWrappers(long j, List<HlsMultivariantPlaylist.Rendition> list, List<HlsSampleStreamWrapper> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        List<HlsMultivariantPlaylist.Rendition> list4 = list;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            String str = list4.get(i).name;
            if (!hashSet.add(str)) {
                List<HlsSampleStreamWrapper> list5 = list2;
                List<int[]> list6 = list3;
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z = true;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (C1229Util.areEqual(str, list4.get(i2).name)) {
                        HlsMultivariantPlaylist.Rendition rendition = list4.get(i2);
                        arrayList3.add(Integer.valueOf(i2));
                        arrayList.add(rendition.url);
                        arrayList2.add(rendition.format);
                        z &= C1229Util.getCodecCountOfType(rendition.format.codecs, 1) == 1;
                    }
                }
                String str2 = "audio:" + str;
                HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(str2, 1, (Uri[]) arrayList.toArray((Uri[]) C1229Util.castNonNullTypeArray(new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), (Format) null, Collections.emptyList(), map, j);
                list3.add(Ints.toArray(arrayList3));
                list2.add(buildSampleStreamWrapper);
                if (this.allowChunklessPreparation && z) {
                    buildSampleStreamWrapper.prepareWithMultivariantPlaylistInfo(new TrackGroup[]{new TrackGroup(str2, (Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    private HlsSampleStreamWrapper buildSampleStreamWrapper(String str, int i, Uri[] uriArr, Format[] formatArr, Format format, List<Format> list, Map<String, DrmInitData> map, long j) {
        HlsChunkSource hlsChunkSource = new HlsChunkSource(this.extractorFactory, this.playlistTracker, uriArr, formatArr, this.dataSourceFactory, this.mediaTransferListener, this.timestampAdjusterProvider, list, this.playerId);
        return new HlsSampleStreamWrapper(str, i, this.sampleStreamWrapperCallback, hlsChunkSource, map, this.allocator, j, format, this.drmSessionManager, this.drmEventDispatcher, this.loadErrorHandlingPolicy, this.eventDispatcher, this.metadataType);
    }

    private static Map<String, DrmInitData> deriveOverridingDrmInitData(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < arrayList.size()) {
            DrmInitData drmInitData = list.get(i);
            String str = drmInitData.schemeType;
            i++;
            int i2 = i;
            while (i2 < arrayList.size()) {
                DrmInitData drmInitData2 = (DrmInitData) arrayList.get(i2);
                if (TextUtils.equals(drmInitData2.schemeType, str)) {
                    drmInitData = drmInitData.merge(drmInitData2);
                    arrayList.remove(i2);
                } else {
                    i2++;
                }
            }
            hashMap.put(str, drmInitData);
        }
        return hashMap;
    }

    private static Format deriveVideoFormat(Format format) {
        String codecsOfType = C1229Util.getCodecsOfType(format.codecs, 2);
        return new Format.Builder().setId(format.f144id).setLabel(format.label).setContainerMimeType(format.containerMimeType).setSampleMimeType(MimeTypes.getMediaMimeType(codecsOfType)).setCodecs(codecsOfType).setMetadata(format.metadata).setAverageBitrate(format.averageBitrate).setPeakBitrate(format.peakBitrate).setWidth(format.width).setHeight(format.height).setFrameRate(format.frameRate).setSelectionFlags(format.selectionFlags).setRoleFlags(format.roleFlags).build();
    }

    private static Format deriveAudioFormat(Format format, Format format2, boolean z) {
        String str;
        int i;
        String str2;
        int i2;
        int i3;
        Metadata metadata;
        String str3;
        int i4 = -1;
        if (format2 != null) {
            str3 = format2.codecs;
            metadata = format2.metadata;
            int i5 = format2.channelCount;
            i2 = format2.selectionFlags;
            int i6 = format2.roleFlags;
            String str4 = format2.language;
            str = format2.label;
            String str5 = str4;
            i = i5;
            i3 = i6;
            str2 = str5;
        } else {
            String codecsOfType = C1229Util.getCodecsOfType(format.codecs, 1);
            Metadata metadata2 = format.metadata;
            if (z) {
                int i7 = format.channelCount;
                int i8 = format.selectionFlags;
                int i9 = format.roleFlags;
                str2 = format.language;
                int i10 = i7;
                str3 = codecsOfType;
                str = format.label;
                i = i10;
                int i11 = i9;
                i2 = i8;
                metadata = metadata2;
                i3 = i11;
            } else {
                str2 = null;
                metadata = metadata2;
                i3 = 0;
                i2 = 0;
                i = -1;
                str3 = codecsOfType;
                str = null;
            }
        }
        String mediaMimeType = MimeTypes.getMediaMimeType(str3);
        int i12 = z ? format.averageBitrate : -1;
        if (z) {
            i4 = format.peakBitrate;
        }
        return new Format.Builder().setId(format.f144id).setLabel(str).setContainerMimeType(format.containerMimeType).setSampleMimeType(mediaMimeType).setCodecs(str3).setMetadata(metadata).setAverageBitrate(i12).setPeakBitrate(i4).setChannelCount(i).setSelectionFlags(i2).setRoleFlags(i3).setLanguage(str2).build();
    }

    private class SampleStreamWrapperCallback implements HlsSampleStreamWrapper.Callback {
        private SampleStreamWrapperCallback() {
        }

        public void onPrepared() {
            if (HlsMediaPeriod.access$106(HlsMediaPeriod.this) <= 0) {
                int i = 0;
                for (HlsSampleStreamWrapper trackGroups : HlsMediaPeriod.this.sampleStreamWrappers) {
                    i += trackGroups.getTrackGroups().length;
                }
                TrackGroup[] trackGroupArr = new TrackGroup[i];
                int i2 = 0;
                for (HlsSampleStreamWrapper hlsSampleStreamWrapper : HlsMediaPeriod.this.sampleStreamWrappers) {
                    int i3 = hlsSampleStreamWrapper.getTrackGroups().length;
                    int i4 = 0;
                    while (i4 < i3) {
                        trackGroupArr[i2] = hlsSampleStreamWrapper.getTrackGroups().get(i4);
                        i4++;
                        i2++;
                    }
                }
                TrackGroupArray unused = HlsMediaPeriod.this.trackGroups = new TrackGroupArray(trackGroupArr);
                HlsMediaPeriod.this.mediaPeriodCallback.onPrepared(HlsMediaPeriod.this);
            }
        }

        public void onPlaylistRefreshRequired(Uri uri) {
            HlsMediaPeriod.this.playlistTracker.refreshPlaylist(uri);
        }

        public void onContinueLoadingRequested(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
            HlsMediaPeriod.this.mediaPeriodCallback.onContinueLoadingRequested(HlsMediaPeriod.this);
        }
    }
}
