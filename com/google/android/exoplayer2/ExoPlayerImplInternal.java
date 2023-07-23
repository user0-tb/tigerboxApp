package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.DefaultMediaClock;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.C1229Util;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender {
    private static final int ACTIVE_INTERVAL_MS = 10;
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final int MSG_ADD_MEDIA_SOURCES = 18;
    private static final int MSG_ATTEMPT_RENDERER_ERROR_RECOVERY = 25;
    private static final int MSG_DO_SOME_WORK = 2;
    private static final int MSG_MOVE_MEDIA_SOURCES = 19;
    private static final int MSG_PERIOD_PREPARED = 8;
    private static final int MSG_PLAYBACK_PARAMETERS_CHANGED_INTERNAL = 16;
    private static final int MSG_PLAYLIST_UPDATE_REQUESTED = 22;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_REMOVE_MEDIA_SOURCES = 20;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEND_MESSAGE = 14;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
    private static final int MSG_SET_FOREGROUND_MODE = 13;
    private static final int MSG_SET_MEDIA_SOURCES = 17;
    private static final int MSG_SET_OFFLOAD_SCHEDULING_ENABLED = 24;
    private static final int MSG_SET_PAUSE_AT_END_OF_WINDOW = 23;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_REPEAT_MODE = 11;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 12;
    private static final int MSG_SET_SHUFFLE_ORDER = 21;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 9;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 10;
    private static final long PLAYBACK_BUFFER_EMPTY_THRESHOLD_US = 500000;
    private static final long PLAYBACK_STUCK_AFTER_MS = 4000;
    private static final String TAG = "ExoPlayerImplInternal";
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private boolean deliverPendingMessageAtStartPositionRequired;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private int enabledRendererCount;
    private boolean foregroundMode;
    /* access modifiers changed from: private */
    public final HandlerWrapper handler;
    private final HandlerThread internalPlaybackThread;
    private boolean isRebuffering;
    private final LivePlaybackSpeedControl livePlaybackSpeedControl;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private final MediaSourceList mediaSourceList;
    private int nextPendingMessageIndexHint;
    private boolean offloadSchedulingEnabled;
    private boolean pauseAtEndOfWindow;
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private boolean pendingPauseAtEndOfPeriod;
    private ExoPlaybackException pendingRecoverableRendererError;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private PlaybackInfoUpdate playbackInfoUpdate;
    private final PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private final Looper playbackLooper;
    private long playbackMaybeBecameStuckAtMs = C0963C.TIME_UNSET;
    private final MediaPeriodQueue queue;
    private final long releaseTimeoutMs;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private final Set<Renderer> renderersToReset;
    private int repeatMode;
    /* access modifiers changed from: private */
    public boolean requestForRendererSleep;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private long setForegroundModeTimeoutMs;
    private boolean shouldContinueLoading;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    public interface PlaybackInfoUpdateListener {
        void onPlaybackInfoUpdate(PlaybackInfoUpdate playbackInfoUpdate);
    }

    public static final class PlaybackInfoUpdate {
        public int discontinuityReason;
        /* access modifiers changed from: private */
        public boolean hasPendingChange;
        public boolean hasPlayWhenReadyChangeReason;
        public int operationAcks;
        public int playWhenReadyChangeReason;
        public PlaybackInfo playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo2) {
            this.playbackInfo = playbackInfo2;
        }

        public void incrementPendingOperationAcks(int i) {
            this.hasPendingChange |= i > 0;
            this.operationAcks += i;
        }

        public void setPlaybackInfo(PlaybackInfo playbackInfo2) {
            this.hasPendingChange |= this.playbackInfo != playbackInfo2;
            this.playbackInfo = playbackInfo2;
        }

        public void setPositionDiscontinuity(int i) {
            boolean z = true;
            if (!this.positionDiscontinuity || this.discontinuityReason == 5) {
                this.hasPendingChange = true;
                this.positionDiscontinuity = true;
                this.discontinuityReason = i;
                return;
            }
            if (i != 5) {
                z = false;
            }
            Assertions.checkArgument(z);
        }

        public void setPlayWhenReadyChangeReason(int i) {
            this.hasPendingChange = true;
            this.hasPlayWhenReadyChangeReason = true;
            this.playWhenReadyChangeReason = i;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector2, TrackSelectorResult trackSelectorResult, LoadControl loadControl2, BandwidthMeter bandwidthMeter2, int i, boolean z, AnalyticsCollector analyticsCollector, SeekParameters seekParameters2, LivePlaybackSpeedControl livePlaybackSpeedControl2, long j, boolean z2, Looper looper, Clock clock2, PlaybackInfoUpdateListener playbackInfoUpdateListener2, PlayerId playerId, Looper looper2) {
        Renderer[] rendererArr2 = rendererArr;
        BandwidthMeter bandwidthMeter3 = bandwidthMeter2;
        AnalyticsCollector analyticsCollector2 = analyticsCollector;
        long j2 = j;
        Clock clock3 = clock2;
        PlayerId playerId2 = playerId;
        Looper looper3 = looper2;
        this.playbackInfoUpdateListener = playbackInfoUpdateListener2;
        this.renderers = rendererArr2;
        this.trackSelector = trackSelector2;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl2;
        this.bandwidthMeter = bandwidthMeter3;
        this.repeatMode = i;
        this.shuffleModeEnabled = z;
        this.seekParameters = seekParameters2;
        this.livePlaybackSpeedControl = livePlaybackSpeedControl2;
        this.releaseTimeoutMs = j2;
        this.setForegroundModeTimeoutMs = j2;
        this.pauseAtEndOfWindow = z2;
        this.clock = clock3;
        this.backBufferDurationUs = loadControl2.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl2.retainBackBufferFromKeyframe();
        PlaybackInfo createDummy = PlaybackInfo.createDummy(trackSelectorResult);
        this.playbackInfo = createDummy;
        this.playbackInfoUpdate = new PlaybackInfoUpdate(createDummy);
        this.rendererCapabilities = new RendererCapabilities[rendererArr2.length];
        for (int i2 = 0; i2 < rendererArr2.length; i2++) {
            rendererArr2[i2].init(i2, playerId2);
            this.rendererCapabilities[i2] = rendererArr2[i2].getCapabilities();
        }
        this.mediaClock = new DefaultMediaClock(this, clock3);
        this.pendingMessages = new ArrayList<>();
        this.renderersToReset = Sets.newIdentityHashSet();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector2.init(this, bandwidthMeter3);
        this.deliverPendingMessageAtStartPositionRequired = true;
        HandlerWrapper createHandler = clock3.createHandler(looper, (Handler.Callback) null);
        this.queue = new MediaPeriodQueue(analyticsCollector2, createHandler);
        this.mediaSourceList = new MediaSourceList(this, analyticsCollector2, createHandler, playerId2);
        if (looper3 != null) {
            this.internalPlaybackThread = null;
            this.playbackLooper = looper3;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.internalPlaybackThread = handlerThread;
            handlerThread.start();
            this.playbackLooper = handlerThread.getLooper();
        }
        this.handler = clock3.createHandler(this.playbackLooper, this);
    }

    public void experimentalSetForegroundModeTimeoutMs(long j) {
        this.setForegroundModeTimeoutMs = j;
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        this.handler.obtainMessage(24, z ? 1 : 0, 0).sendToTarget();
    }

    public void prepare() {
        this.handler.obtainMessage(0).sendToTarget();
    }

    public void setPlayWhenReady(boolean z, int i) {
        this.handler.obtainMessage(1, z ? 1 : 0, i).sendToTarget();
    }

    public void setPauseAtEndOfWindow(boolean z) {
        this.handler.obtainMessage(23, z ? 1 : 0, 0).sendToTarget();
    }

    public void setRepeatMode(int i) {
        this.handler.obtainMessage(11, i, 0).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z) {
        this.handler.obtainMessage(12, z ? 1 : 0, 0).sendToTarget();
    }

    public void seekTo(Timeline timeline, int i, long j) {
        this.handler.obtainMessage(3, new SeekPosition(timeline, i, j)).sendToTarget();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setSeekParameters(SeekParameters seekParameters2) {
        this.handler.obtainMessage(5, seekParameters2).sendToTarget();
    }

    public void stop() {
        this.handler.obtainMessage(6).sendToTarget();
    }

    public void setMediaSources(List<MediaSourceList.MediaSourceHolder> list, int i, long j, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i, j)).sendToTarget();
    }

    public void addMediaSources(int i, List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(18, i, 0, new MediaSourceListUpdateMessage(list, shuffleOrder, -1, C0963C.TIME_UNSET)).sendToTarget();
    }

    public void removeMediaSources(int i, int i2, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(20, i, i2, shuffleOrder).sendToTarget();
    }

    public void moveMediaSources(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(19, new MoveMediaItemsMessage(i, i2, i3, shuffleOrder)).sendToTarget();
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(21, shuffleOrder).sendToTarget();
    }

    public synchronized void sendMessage(PlayerMessage playerMessage) {
        if (!this.released) {
            if (this.playbackLooper.getThread().isAlive()) {
                this.handler.obtainMessage(14, playerMessage).sendToTarget();
                return;
            }
        }
        Log.m157w(TAG, "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean setForegroundMode(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.released     // Catch:{ all -> 0x0043 }
            r1 = 1
            if (r0 != 0) goto L_0x0041
            android.os.Looper r0 = r3.playbackLooper     // Catch:{ all -> 0x0043 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0043 }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x0013
            goto L_0x0041
        L_0x0013:
            r0 = 13
            r2 = 0
            if (r4 == 0) goto L_0x0023
            com.google.android.exoplayer2.util.HandlerWrapper r4 = r3.handler     // Catch:{ all -> 0x0043 }
            com.google.android.exoplayer2.util.HandlerWrapper$Message r4 = r4.obtainMessage(r0, r1, r2)     // Catch:{ all -> 0x0043 }
            r4.sendToTarget()     // Catch:{ all -> 0x0043 }
            monitor-exit(r3)
            return r1
        L_0x0023:
            java.util.concurrent.atomic.AtomicBoolean r4 = new java.util.concurrent.atomic.AtomicBoolean     // Catch:{ all -> 0x0043 }
            r4.<init>()     // Catch:{ all -> 0x0043 }
            com.google.android.exoplayer2.util.HandlerWrapper r1 = r3.handler     // Catch:{ all -> 0x0043 }
            com.google.android.exoplayer2.util.HandlerWrapper$Message r0 = r1.obtainMessage(r0, r2, r2, r4)     // Catch:{ all -> 0x0043 }
            r0.sendToTarget()     // Catch:{ all -> 0x0043 }
            com.google.android.exoplayer2.ExoPlayerImplInternal$$ExternalSyntheticLambda1 r0 = new com.google.android.exoplayer2.ExoPlayerImplInternal$$ExternalSyntheticLambda1     // Catch:{ all -> 0x0043 }
            r0.<init>(r4)     // Catch:{ all -> 0x0043 }
            long r1 = r3.setForegroundModeTimeoutMs     // Catch:{ all -> 0x0043 }
            r3.waitUninterruptibly(r0, r1)     // Catch:{ all -> 0x0043 }
            boolean r4 = r4.get()     // Catch:{ all -> 0x0043 }
            monitor-exit(r3)
            return r4
        L_0x0041:
            monitor-exit(r3)
            return r1
        L_0x0043:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.setForegroundMode(boolean):boolean");
    }

    public synchronized boolean release() {
        if (!this.released) {
            if (this.playbackLooper.getThread().isAlive()) {
                this.handler.sendEmptyMessage(7);
                waitUninterruptibly(new ExoPlayerImplInternal$$ExternalSyntheticLambda0(this), this.releaseTimeoutMs);
                return this.released;
            }
        }
        return true;
    }

    /* renamed from: lambda$release$0$com-google-android-exoplayer2-ExoPlayerImplInternal */
    public /* synthetic */ Boolean mo15638x37739a9a() {
        return Boolean.valueOf(this.released);
    }

    public Looper getPlaybackLooper() {
        return this.playbackLooper;
    }

    public void onPlaylistUpdateRequested() {
        this.handler.sendEmptyMessage(22);
    }

    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(10);
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(16, playbackParameters).sendToTarget();
    }

    public boolean handleMessage(Message message) {
        MediaPeriodHolder readingPeriod;
        int i = 1000;
        try {
            switch (message.what) {
                case 0:
                    prepareInternal();
                    break;
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    stopInternal(false, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 9:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 10:
                    reselectTracksInternal();
                    break;
                case 11:
                    setRepeatModeInternal(message.arg1);
                    break;
                case 12:
                    setShuffleModeEnabledInternal(message.arg1 != 0);
                    break;
                case 13:
                    setForegroundModeInternal(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                case 16:
                    handlePlaybackParameters((PlaybackParameters) message.obj, false);
                    break;
                case 17:
                    setMediaItemsInternal((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    addMediaItemsInternal((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    moveMediaItemsInternal((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    removeMediaItemsInternal(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    setShuffleOrderInternal((ShuffleOrder) message.obj);
                    break;
                case 22:
                    mediaSourceListUpdateRequestedInternal();
                    break;
                case 23:
                    setPauseAtEndOfWindowInternal(message.arg1 != 0);
                    break;
                case 24:
                    setOffloadSchedulingEnabledInternal(message.arg1 == 1);
                    break;
                case 25:
                    attemptRendererErrorRecovery();
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e) {
            e = e;
            if (e.type == 1 && (readingPeriod = this.queue.getReadingPeriod()) != null) {
                e = e.copyWithMediaPeriodId(readingPeriod.info.f148id);
            }
            if (!e.isRecoverable || this.pendingRecoverableRendererError != null) {
                ExoPlaybackException exoPlaybackException = this.pendingRecoverableRendererError;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.pendingRecoverableRendererError;
                }
                Log.m154e(TAG, "Playback error", e);
                stopInternal(true, false);
                this.playbackInfo = this.playbackInfo.copyWithPlaybackError(e);
            } else {
                Log.m158w(TAG, "Recoverable renderer error", e);
                this.pendingRecoverableRendererError = e;
                HandlerWrapper handlerWrapper = this.handler;
                handlerWrapper.sendMessageAtFrontOfQueue(handlerWrapper.obtainMessage(25, e));
            }
        } catch (DrmSession.DrmSessionException e2) {
            handleIoException(e2, e2.errorCode);
        } catch (ParserException e3) {
            if (e3.dataType == 1) {
                i = e3.contentIsMalformed ? PlaybackException.ERROR_CODE_PARSING_CONTAINER_MALFORMED : PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED;
            } else if (e3.dataType == 4) {
                i = e3.contentIsMalformed ? PlaybackException.ERROR_CODE_PARSING_MANIFEST_MALFORMED : PlaybackException.ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED;
            }
            handleIoException(e3, i);
        } catch (DataSourceException e4) {
            handleIoException(e4, e4.reason);
        } catch (BehindLiveWindowException e5) {
            handleIoException(e5, 1002);
        } catch (IOException e6) {
            handleIoException(e6, 2000);
        } catch (RuntimeException e7) {
            if ((e7 instanceof IllegalStateException) || (e7 instanceof IllegalArgumentException)) {
                i = 1004;
            }
            ExoPlaybackException createForUnexpected = ExoPlaybackException.createForUnexpected(e7, i);
            Log.m154e(TAG, "Playback error", createForUnexpected);
            stopInternal(true, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(createForUnexpected);
        }
        maybeNotifyPlaybackInfoChanged();
        return true;
    }

    private void handleIoException(IOException iOException, int i) {
        ExoPlaybackException createForSource = ExoPlaybackException.createForSource(iOException, i);
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            createForSource = createForSource.copyWithMediaPeriodId(playingPeriod.info.f148id);
        }
        Log.m154e(TAG, "Playback error", createForSource);
        stopInternal(false, false);
        this.playbackInfo = this.playbackInfo.copyWithPlaybackError(createForSource);
    }

    private synchronized void waitUninterruptibly(Supplier<Boolean> supplier, long j) {
        long elapsedRealtime = this.clock.elapsedRealtime() + j;
        boolean z = false;
        while (!supplier.get().booleanValue() && j > 0) {
            try {
                this.clock.onThreadBlocked();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = elapsedRealtime - this.clock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void setState(int i) {
        if (this.playbackInfo.playbackState != i) {
            if (i != 2) {
                this.playbackMaybeBecameStuckAtMs = C0963C.TIME_UNSET;
            }
            this.playbackInfo = this.playbackInfo.copyWithPlaybackState(i);
        }
    }

    private void maybeNotifyPlaybackInfoChanged() {
        this.playbackInfoUpdate.setPlaybackInfo(this.playbackInfo);
        if (this.playbackInfoUpdate.hasPendingChange) {
            this.playbackInfoUpdateListener.onPlaybackInfoUpdate(this.playbackInfoUpdate);
            this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        }
    }

    private void prepareInternal() {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        resetInternal(false, false, false, true);
        this.loadControl.onPrepared();
        setState(this.playbackInfo.timeline.isEmpty() ? 4 : 2);
        this.mediaSourceList.prepare(this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void setMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        if (mediaSourceListUpdateMessage.windowIndex != -1) {
            this.pendingInitialSeekPosition = new SeekPosition(new PlaylistTimeline(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), mediaSourceListUpdateMessage.windowIndex, mediaSourceListUpdateMessage.positionUs);
        }
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setMediaSources(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void addMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList2 = this.mediaSourceList;
        if (i == -1) {
            i = mediaSourceList2.getSize();
        }
        handleMediaSourceListInfoRefreshed(mediaSourceList2.addMediaSources(i, mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void moveMediaItemsInternal(MoveMediaItemsMessage moveMediaItemsMessage) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.moveMediaSourceRange(moveMediaItemsMessage.fromIndex, moveMediaItemsMessage.toIndex, moveMediaItemsMessage.newFromIndex, moveMediaItemsMessage.shuffleOrder), false);
    }

    private void removeMediaItemsInternal(int i, int i2, ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.removeMediaSourceRange(i, i2, shuffleOrder), false);
    }

    private void mediaSourceListUpdateRequestedInternal() throws ExoPlaybackException {
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.createTimeline(), true);
    }

    private void setShuffleOrderInternal(ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setShuffleOrder(shuffleOrder), false);
    }

    private void notifyTrackSelectionPlayWhenReadyChanged(boolean z) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlayWhenReadyChanged(z);
                }
            }
        }
    }

    private void setPlayWhenReadyInternal(boolean z, int i, boolean z2, int i2) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.playbackInfoUpdate.setPlayWhenReadyChangeReason(i2);
        this.playbackInfo = this.playbackInfo.copyWithPlayWhenReady(z, i);
        this.isRebuffering = false;
        notifyTrackSelectionPlayWhenReadyChanged(z);
        if (!shouldPlayWhenReady()) {
            stopRenderers();
            updatePlaybackPositions();
        } else if (this.playbackInfo.playbackState == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (this.playbackInfo.playbackState == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setPauseAtEndOfWindowInternal(boolean z) throws ExoPlaybackException {
        this.pauseAtEndOfWindow = z;
        resetPendingPauseAtEndOfPeriod();
        if (this.pendingPauseAtEndOfPeriod && this.queue.getReadingPeriod() != this.queue.getPlayingPeriod()) {
            seekToCurrentPosition(true);
            handleLoadingMediaPeriodChanged(false);
        }
    }

    private void setOffloadSchedulingEnabledInternal(boolean z) {
        if (z != this.offloadSchedulingEnabled) {
            this.offloadSchedulingEnabled = z;
            if (!z && this.playbackInfo.sleepingForOffload) {
                this.handler.sendEmptyMessage(2);
            }
        }
    }

    private void setRepeatModeInternal(int i) throws ExoPlaybackException {
        this.repeatMode = i;
        if (!this.queue.updateRepeatMode(this.playbackInfo.timeline, i)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleModeEnabledInternal(boolean z) throws ExoPlaybackException {
        this.shuffleModeEnabled = z;
        if (!this.queue.updateShuffleModeEnabled(this.playbackInfo.timeline, z)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void seekToCurrentPosition(boolean z) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.f148id;
        long seekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true, false);
        if (seekToPeriodPosition != this.playbackInfo.positionUs) {
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, seekToPeriodPosition, this.playbackInfo.requestedContentPositionUs, this.playbackInfo.discontinuityStartPositionUs, z, 5);
        }
    }

    private void startRenderers() throws ExoPlaybackException {
        this.isRebuffering = false;
        this.mediaClock.start();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.start();
            }
        }
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                ensureStopped(renderer);
            }
        }
    }

    private void attemptRendererErrorRecovery() throws ExoPlaybackException {
        seekToCurrentPosition(true);
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            long readDiscontinuity = playingPeriod.prepared ? playingPeriod.mediaPeriod.readDiscontinuity() : -9223372036854775807L;
            if (readDiscontinuity != C0963C.TIME_UNSET) {
                resetRendererPosition(readDiscontinuity);
                if (readDiscontinuity != this.playbackInfo.positionUs) {
                    this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, readDiscontinuity, this.playbackInfo.requestedContentPositionUs, readDiscontinuity, true, 5);
                }
            } else {
                long syncAndGetPositionUs = this.mediaClock.syncAndGetPositionUs(playingPeriod != this.queue.getReadingPeriod());
                this.rendererPositionUs = syncAndGetPositionUs;
                long periodTime = playingPeriod.toPeriodTime(syncAndGetPositionUs);
                maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
                this.playbackInfo.positionUs = periodTime;
            }
            this.playbackInfo.bufferedPositionUs = this.queue.getLoadingPeriod().getBufferedPositionUs();
            this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
            if (this.playbackInfo.playWhenReady && this.playbackInfo.playbackState == 3 && shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, this.playbackInfo.periodId) && this.playbackInfo.playbackParameters.speed == 1.0f) {
                float adjustedPlaybackSpeed = this.livePlaybackSpeedControl.getAdjustedPlaybackSpeed(getCurrentLiveOffsetUs(), getTotalBufferedDurationUs());
                if (this.mediaClock.getPlaybackParameters().speed != adjustedPlaybackSpeed) {
                    setMediaClockPlaybackParameters(this.playbackInfo.playbackParameters.withSpeed(adjustedPlaybackSpeed));
                    handlePlaybackParameters(this.playbackInfo.playbackParameters, this.mediaClock.getPlaybackParameters().speed, false, false);
                }
            }
        }
    }

    private void setMediaClockPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.removeMessages(16);
        this.mediaClock.setPlaybackParameters(playbackParameters);
    }

    private void notifyTrackSelectionRebuffer() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onRebuffer();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doSomeWork() throws com.google.android.exoplayer2.ExoPlaybackException, java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            com.google.android.exoplayer2.util.Clock r1 = r0.clock
            long r1 = r1.uptimeMillis()
            com.google.android.exoplayer2.util.HandlerWrapper r3 = r0.handler
            r4 = 2
            r3.removeMessages(r4)
            r16.updatePeriods()
            com.google.android.exoplayer2.PlaybackInfo r3 = r0.playbackInfo
            int r3 = r3.playbackState
            r5 = 1
            if (r3 == r5) goto L_0x0208
            com.google.android.exoplayer2.PlaybackInfo r3 = r0.playbackInfo
            int r3 = r3.playbackState
            r6 = 4
            if (r3 != r6) goto L_0x0021
            goto L_0x0208
        L_0x0021:
            com.google.android.exoplayer2.MediaPeriodQueue r3 = r0.queue
            com.google.android.exoplayer2.MediaPeriodHolder r3 = r3.getPlayingPeriod()
            r7 = 10
            if (r3 != 0) goto L_0x002f
            r0.scheduleNextWork(r1, r7)
            return
        L_0x002f:
            java.lang.String r9 = "doSomeWork"
            com.google.android.exoplayer2.util.TraceUtil.beginSection(r9)
            r16.updatePlaybackPositions()
            boolean r9 = r3.prepared
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 0
            if (r9 == 0) goto L_0x00b0
            long r13 = android.os.SystemClock.elapsedRealtime()
            long r13 = r13 * r10
            com.google.android.exoplayer2.source.MediaPeriod r9 = r3.mediaPeriod
            com.google.android.exoplayer2.PlaybackInfo r15 = r0.playbackInfo
            long r7 = r15.positionUs
            long r10 = r0.backBufferDurationUs
            long r7 = r7 - r10
            boolean r10 = r0.retainBackBufferFromKeyframe
            r9.discardBuffer(r7, r10)
            r7 = 0
            r8 = 1
            r9 = 1
        L_0x0055:
            com.google.android.exoplayer2.Renderer[] r10 = r0.renderers
            int r11 = r10.length
            if (r7 >= r11) goto L_0x00b7
            r10 = r10[r7]
            boolean r11 = isRendererEnabled(r10)
            if (r11 != 0) goto L_0x0063
            goto L_0x00ab
        L_0x0063:
            long r4 = r0.rendererPositionUs
            r10.render(r4, r13)
            if (r8 == 0) goto L_0x0072
            boolean r4 = r10.isEnded()
            if (r4 == 0) goto L_0x0072
            r8 = 1
            goto L_0x0073
        L_0x0072:
            r8 = 0
        L_0x0073:
            com.google.android.exoplayer2.source.SampleStream[] r4 = r3.sampleStreams
            r4 = r4[r7]
            com.google.android.exoplayer2.source.SampleStream r5 = r10.getStream()
            if (r4 == r5) goto L_0x007f
            r4 = 1
            goto L_0x0080
        L_0x007f:
            r4 = 0
        L_0x0080:
            if (r4 != 0) goto L_0x008a
            boolean r5 = r10.hasReadStreamToEnd()
            if (r5 == 0) goto L_0x008a
            r5 = 1
            goto L_0x008b
        L_0x008a:
            r5 = 0
        L_0x008b:
            if (r4 != 0) goto L_0x009e
            if (r5 != 0) goto L_0x009e
            boolean r4 = r10.isReady()
            if (r4 != 0) goto L_0x009e
            boolean r4 = r10.isEnded()
            if (r4 == 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r4 = 0
            goto L_0x009f
        L_0x009e:
            r4 = 1
        L_0x009f:
            if (r9 == 0) goto L_0x00a5
            if (r4 == 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r4 != 0) goto L_0x00ab
            r10.maybeThrowStreamError()
        L_0x00ab:
            int r7 = r7 + 1
            r4 = 2
            r5 = 1
            goto L_0x0055
        L_0x00b0:
            com.google.android.exoplayer2.source.MediaPeriod r4 = r3.mediaPeriod
            r4.maybeThrowPrepareError()
            r8 = 1
            r9 = 1
        L_0x00b7:
            com.google.android.exoplayer2.MediaPeriodInfo r4 = r3.info
            long r4 = r4.durationUs
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r8 == 0) goto L_0x00d4
            boolean r7 = r3.prepared
            if (r7 == 0) goto L_0x00d4
            int r7 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r7 == 0) goto L_0x00d2
            com.google.android.exoplayer2.PlaybackInfo r7 = r0.playbackInfo
            long r7 = r7.positionUs
            int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r10 > 0) goto L_0x00d4
        L_0x00d2:
            r4 = 1
            goto L_0x00d5
        L_0x00d4:
            r4 = 0
        L_0x00d5:
            if (r4 == 0) goto L_0x00e5
            boolean r5 = r0.pendingPauseAtEndOfPeriod
            if (r5 == 0) goto L_0x00e5
            r0.pendingPauseAtEndOfPeriod = r12
            com.google.android.exoplayer2.PlaybackInfo r5 = r0.playbackInfo
            int r5 = r5.playbackSuppressionReason
            r7 = 5
            r0.setPlayWhenReadyInternal(r12, r5, r12, r7)
        L_0x00e5:
            r5 = 3
            if (r4 == 0) goto L_0x00f5
            com.google.android.exoplayer2.MediaPeriodInfo r4 = r3.info
            boolean r4 = r4.isFinal
            if (r4 == 0) goto L_0x00f5
            r0.setState(r6)
            r16.stopRenderers()
            goto L_0x013e
        L_0x00f5:
            com.google.android.exoplayer2.PlaybackInfo r4 = r0.playbackInfo
            int r4 = r4.playbackState
            r7 = 2
            if (r4 != r7) goto L_0x0112
            boolean r4 = r0.shouldTransitionToReadyState(r9)
            if (r4 == 0) goto L_0x0112
            r0.setState(r5)
            r4 = 0
            r0.pendingRecoverableRendererError = r4
            boolean r4 = r16.shouldPlayWhenReady()
            if (r4 == 0) goto L_0x013e
            r16.startRenderers()
            goto L_0x013e
        L_0x0112:
            com.google.android.exoplayer2.PlaybackInfo r4 = r0.playbackInfo
            int r4 = r4.playbackState
            if (r4 != r5) goto L_0x013e
            int r4 = r0.enabledRendererCount
            if (r4 != 0) goto L_0x0123
            boolean r4 = r16.isTimelineReady()
            if (r4 == 0) goto L_0x0125
            goto L_0x013e
        L_0x0123:
            if (r9 != 0) goto L_0x013e
        L_0x0125:
            boolean r4 = r16.shouldPlayWhenReady()
            r0.isRebuffering = r4
            r4 = 2
            r0.setState(r4)
            boolean r4 = r0.isRebuffering
            if (r4 == 0) goto L_0x013b
            r16.notifyTrackSelectionRebuffer()
            com.google.android.exoplayer2.LivePlaybackSpeedControl r4 = r0.livePlaybackSpeedControl
            r4.notifyRebuffer()
        L_0x013b:
            r16.stopRenderers()
        L_0x013e:
            com.google.android.exoplayer2.PlaybackInfo r4 = r0.playbackInfo
            int r4 = r4.playbackState
            r7 = 2
            if (r4 != r7) goto L_0x0184
            r4 = 0
        L_0x0146:
            com.google.android.exoplayer2.Renderer[] r7 = r0.renderers
            int r8 = r7.length
            if (r4 >= r8) goto L_0x016b
            r7 = r7[r4]
            boolean r7 = isRendererEnabled(r7)
            if (r7 == 0) goto L_0x0168
            com.google.android.exoplayer2.Renderer[] r7 = r0.renderers
            r7 = r7[r4]
            com.google.android.exoplayer2.source.SampleStream r7 = r7.getStream()
            com.google.android.exoplayer2.source.SampleStream[] r8 = r3.sampleStreams
            r8 = r8[r4]
            if (r7 != r8) goto L_0x0168
            com.google.android.exoplayer2.Renderer[] r7 = r0.renderers
            r7 = r7[r4]
            r7.maybeThrowStreamError()
        L_0x0168:
            int r4 = r4 + 1
            goto L_0x0146
        L_0x016b:
            com.google.android.exoplayer2.PlaybackInfo r3 = r0.playbackInfo
            boolean r3 = r3.isLoading
            if (r3 != 0) goto L_0x0184
            com.google.android.exoplayer2.PlaybackInfo r3 = r0.playbackInfo
            long r3 = r3.totalBufferedDurationUs
            r7 = 500000(0x7a120, double:2.47033E-318)
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x0184
            boolean r3 = r16.isLoadingPossible()
            if (r3 == 0) goto L_0x0184
            r3 = 1
            goto L_0x0185
        L_0x0184:
            r3 = 0
        L_0x0185:
            if (r3 != 0) goto L_0x018a
            r0.playbackMaybeBecameStuckAtMs = r13
            goto L_0x01a8
        L_0x018a:
            long r3 = r0.playbackMaybeBecameStuckAtMs
            int r7 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r7 != 0) goto L_0x0199
            com.google.android.exoplayer2.util.Clock r3 = r0.clock
            long r3 = r3.elapsedRealtime()
            r0.playbackMaybeBecameStuckAtMs = r3
            goto L_0x01a8
        L_0x0199:
            com.google.android.exoplayer2.util.Clock r3 = r0.clock
            long r3 = r3.elapsedRealtime()
            long r7 = r0.playbackMaybeBecameStuckAtMs
            long r3 = r3 - r7
            r7 = 4000(0xfa0, double:1.9763E-320)
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x0200
        L_0x01a8:
            boolean r3 = r16.shouldPlayWhenReady()
            if (r3 == 0) goto L_0x01b6
            com.google.android.exoplayer2.PlaybackInfo r3 = r0.playbackInfo
            int r3 = r3.playbackState
            if (r3 != r5) goto L_0x01b6
            r3 = 1
            goto L_0x01b7
        L_0x01b6:
            r3 = 0
        L_0x01b7:
            boolean r4 = r0.offloadSchedulingEnabled
            if (r4 == 0) goto L_0x01c3
            boolean r4 = r0.requestForRendererSleep
            if (r4 == 0) goto L_0x01c3
            if (r3 == 0) goto L_0x01c3
            r15 = 1
            goto L_0x01c4
        L_0x01c3:
            r15 = 0
        L_0x01c4:
            com.google.android.exoplayer2.PlaybackInfo r4 = r0.playbackInfo
            boolean r4 = r4.sleepingForOffload
            if (r4 == r15) goto L_0x01d2
            com.google.android.exoplayer2.PlaybackInfo r4 = r0.playbackInfo
            com.google.android.exoplayer2.PlaybackInfo r4 = r4.copyWithSleepingForOffload(r15)
            r0.playbackInfo = r4
        L_0x01d2:
            r0.requestForRendererSleep = r12
            if (r15 != 0) goto L_0x01fc
            com.google.android.exoplayer2.PlaybackInfo r4 = r0.playbackInfo
            int r4 = r4.playbackState
            if (r4 != r6) goto L_0x01dd
            goto L_0x01fc
        L_0x01dd:
            if (r3 != 0) goto L_0x01f7
            com.google.android.exoplayer2.PlaybackInfo r3 = r0.playbackInfo
            int r3 = r3.playbackState
            r4 = 2
            if (r3 != r4) goto L_0x01e7
            goto L_0x01f7
        L_0x01e7:
            com.google.android.exoplayer2.PlaybackInfo r3 = r0.playbackInfo
            int r3 = r3.playbackState
            if (r3 != r5) goto L_0x01fc
            int r3 = r0.enabledRendererCount
            if (r3 == 0) goto L_0x01fc
            r3 = 1000(0x3e8, double:4.94E-321)
            r0.scheduleNextWork(r1, r3)
            goto L_0x01fc
        L_0x01f7:
            r3 = 10
            r0.scheduleNextWork(r1, r3)
        L_0x01fc:
            com.google.android.exoplayer2.util.TraceUtil.endSection()
            return
        L_0x0200:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Playback stuck buffering and not loading"
            r1.<init>(r2)
            throw r1
        L_0x0208:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.doSomeWork():void");
    }

    private long getCurrentLiveOffsetUs() {
        return getLiveOffsetUs(this.playbackInfo.timeline, this.playbackInfo.periodId.periodUid, this.playbackInfo.positionUs);
    }

    private long getLiveOffsetUs(Timeline timeline, Object obj, long j) {
        timeline.getWindow(timeline.getPeriodByUid(obj, this.period).windowIndex, this.window);
        if (this.window.windowStartTimeMs == C0963C.TIME_UNSET || !this.window.isLive() || !this.window.isDynamic) {
            return C0963C.TIME_UNSET;
        }
        return C1229Util.msToUs(this.window.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - (j + this.period.getPositionInWindowUs());
    }

    private boolean shouldUseLivePlaybackSpeedControl(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.isAd() || timeline.isEmpty()) {
            return false;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        if (!this.window.isLive() || !this.window.isDynamic || this.window.windowStartTimeMs == C0963C.TIME_UNSET) {
            return false;
        }
        return true;
    }

    private void scheduleNextWork(long j, long j2) {
        this.handler.sendEmptyMessageAtTime(2, j + j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab A[Catch:{ all -> 0x0151 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ae A[Catch:{ all -> 0x0151 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void seekToInternal(com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition r20) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r19 = this;
            r11 = r19
            r0 = r20
            com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate r1 = r11.playbackInfoUpdate
            r8 = 1
            r1.incrementPendingOperationAcks(r8)
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r1 = r1.timeline
            int r4 = r11.repeatMode
            boolean r5 = r11.shuffleModeEnabled
            com.google.android.exoplayer2.Timeline$Window r6 = r11.window
            com.google.android.exoplayer2.Timeline$Period r7 = r11.period
            r3 = 1
            r2 = r20
            android.util.Pair r1 = resolveSeekPositionUs(r1, r2, r3, r4, r5, r6, r7)
            r2 = 0
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 0
            if (r1 != 0) goto L_0x004b
            com.google.android.exoplayer2.PlaybackInfo r7 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r7 = r7.timeline
            android.util.Pair r7 = r11.getPlaceholderFirstMediaPeriodPositionUs(r7)
            java.lang.Object r9 = r7.first
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r9 = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) r9
            java.lang.Object r7 = r7.second
            java.lang.Long r7 = (java.lang.Long) r7
            long r12 = r7.longValue()
            com.google.android.exoplayer2.PlaybackInfo r7 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r7 = r7.timeline
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r8
            r10 = r7
            r17 = r4
        L_0x0047:
            r4 = r12
            r12 = r17
            goto L_0x00a1
        L_0x004b:
            java.lang.Object r7 = r1.first
            java.lang.Object r9 = r1.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            long r9 = r0.windowPositionUs
            int r14 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r14 != 0) goto L_0x005d
            r9 = r4
            goto L_0x005e
        L_0x005d:
            r9 = r12
        L_0x005e:
            com.google.android.exoplayer2.MediaPeriodQueue r14 = r11.queue
            com.google.android.exoplayer2.PlaybackInfo r15 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r15 = r15.timeline
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r7 = r14.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(r15, r7, r12)
            boolean r14 = r7.isAd()
            if (r14 == 0) goto L_0x0093
            com.google.android.exoplayer2.PlaybackInfo r4 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r4 = r4.timeline
            java.lang.Object r5 = r7.periodUid
            com.google.android.exoplayer2.Timeline$Period r12 = r11.period
            r4.getPeriodByUid(r5, r12)
            com.google.android.exoplayer2.Timeline$Period r4 = r11.period
            int r5 = r7.adGroupIndex
            int r4 = r4.getFirstAdIndexToPlay(r5)
            int r5 = r7.adIndexInAdGroup
            if (r4 != r5) goto L_0x008d
            com.google.android.exoplayer2.Timeline$Period r4 = r11.period
            long r4 = r4.getAdResumePositionUs()
            r12 = r4
            goto L_0x008e
        L_0x008d:
            r12 = r2
        L_0x008e:
            r4 = r12
            r12 = r9
            r10 = 1
            r9 = r7
            goto L_0x00a1
        L_0x0093:
            long r14 = r0.windowPositionUs
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 != 0) goto L_0x009b
            r4 = 1
            goto L_0x009c
        L_0x009b:
            r4 = 0
        L_0x009c:
            r17 = r9
            r10 = r4
            r9 = r7
            goto L_0x0047
        L_0x00a1:
            com.google.android.exoplayer2.PlaybackInfo r7 = r11.playbackInfo     // Catch:{ all -> 0x0151 }
            com.google.android.exoplayer2.Timeline r7 = r7.timeline     // Catch:{ all -> 0x0151 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0151 }
            if (r7 == 0) goto L_0x00ae
            r11.pendingInitialSeekPosition = r0     // Catch:{ all -> 0x0151 }
            goto L_0x00bd
        L_0x00ae:
            r0 = 4
            if (r1 != 0) goto L_0x00c0
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo     // Catch:{ all -> 0x0151 }
            int r1 = r1.playbackState     // Catch:{ all -> 0x0151 }
            if (r1 == r8) goto L_0x00ba
            r11.setState(r0)     // Catch:{ all -> 0x0151 }
        L_0x00ba:
            r11.resetInternal(r6, r8, r6, r8)     // Catch:{ all -> 0x0151 }
        L_0x00bd:
            r7 = r4
            goto L_0x013f
        L_0x00c0:
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo     // Catch:{ all -> 0x0151 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r1.periodId     // Catch:{ all -> 0x0151 }
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x0151 }
            if (r1 == 0) goto L_0x0115
            com.google.android.exoplayer2.MediaPeriodQueue r1 = r11.queue     // Catch:{ all -> 0x0151 }
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r1.getPlayingPeriod()     // Catch:{ all -> 0x0151 }
            if (r1 == 0) goto L_0x00e3
            boolean r7 = r1.prepared     // Catch:{ all -> 0x0151 }
            if (r7 == 0) goto L_0x00e3
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x00e3
            com.google.android.exoplayer2.source.MediaPeriod r1 = r1.mediaPeriod     // Catch:{ all -> 0x0151 }
            com.google.android.exoplayer2.SeekParameters r2 = r11.seekParameters     // Catch:{ all -> 0x0151 }
            long r1 = r1.getAdjustedSeekPositionUs(r4, r2)     // Catch:{ all -> 0x0151 }
            goto L_0x00e4
        L_0x00e3:
            r1 = r4
        L_0x00e4:
            long r14 = com.google.android.exoplayer2.util.C1229Util.usToMs(r1)     // Catch:{ all -> 0x0151 }
            com.google.android.exoplayer2.PlaybackInfo r3 = r11.playbackInfo     // Catch:{ all -> 0x0151 }
            long r6 = r3.positionUs     // Catch:{ all -> 0x0151 }
            long r6 = com.google.android.exoplayer2.util.C1229Util.usToMs(r6)     // Catch:{ all -> 0x0151 }
            int r3 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0116
            com.google.android.exoplayer2.PlaybackInfo r3 = r11.playbackInfo     // Catch:{ all -> 0x0151 }
            int r3 = r3.playbackState     // Catch:{ all -> 0x0151 }
            r6 = 2
            if (r3 == r6) goto L_0x0102
            com.google.android.exoplayer2.PlaybackInfo r3 = r11.playbackInfo     // Catch:{ all -> 0x0151 }
            int r3 = r3.playbackState     // Catch:{ all -> 0x0151 }
            r6 = 3
            if (r3 != r6) goto L_0x0116
        L_0x0102:
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo     // Catch:{ all -> 0x0151 }
            long r7 = r0.positionUs     // Catch:{ all -> 0x0151 }
            r0 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r0
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.handlePositionDiscontinuity(r2, r3, r5, r7, r9, r10)
            r11.playbackInfo = r0
            return
        L_0x0115:
            r1 = r4
        L_0x0116:
            com.google.android.exoplayer2.PlaybackInfo r3 = r11.playbackInfo     // Catch:{ all -> 0x0151 }
            int r3 = r3.playbackState     // Catch:{ all -> 0x0151 }
            if (r3 != r0) goto L_0x011e
            r0 = 1
            goto L_0x011f
        L_0x011e:
            r0 = 0
        L_0x011f:
            long r14 = r11.seekToPeriodPosition(r9, r1, r0)     // Catch:{ all -> 0x0151 }
            int r0 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0128
            goto L_0x0129
        L_0x0128:
            r8 = 0
        L_0x0129:
            r10 = r10 | r8
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo     // Catch:{ all -> 0x014e }
            com.google.android.exoplayer2.Timeline r2 = r0.timeline     // Catch:{ all -> 0x014e }
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo     // Catch:{ all -> 0x014e }
            com.google.android.exoplayer2.Timeline r4 = r0.timeline     // Catch:{ all -> 0x014e }
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo     // Catch:{ all -> 0x014e }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r0.periodId     // Catch:{ all -> 0x014e }
            r8 = 1
            r1 = r19
            r3 = r9
            r6 = r12
            r1.updatePlaybackSpeedSettingsForNewPeriod(r2, r3, r4, r5, r6, r8)     // Catch:{ all -> 0x014e }
            r7 = r14
        L_0x013f:
            r0 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r0
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.handlePositionDiscontinuity(r2, r3, r5, r7, r9, r10)
            r11.playbackInfo = r0
            return
        L_0x014e:
            r0 = move-exception
            r7 = r14
            goto L_0x0153
        L_0x0151:
            r0 = move-exception
            r7 = r4
        L_0x0153:
            r14 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r14
            com.google.android.exoplayer2.PlaybackInfo r1 = r1.handlePositionDiscontinuity(r2, r3, r5, r7, r9, r10)
            r11.playbackInfo = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.seekToInternal(com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition):void");
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z) throws ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, j, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod(), z);
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z, boolean z2) throws ExoPlaybackException {
        stopRenderers();
        this.isRebuffering = false;
        if (z2 || this.playbackInfo.playbackState == 3) {
            setState(2);
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder mediaPeriodHolder = playingPeriod;
        while (mediaPeriodHolder != null && !mediaPeriodId.equals(mediaPeriodHolder.info.f148id)) {
            mediaPeriodHolder = mediaPeriodHolder.getNext();
        }
        if (z || playingPeriod != mediaPeriodHolder || (mediaPeriodHolder != null && mediaPeriodHolder.toRendererTime(j) < 0)) {
            for (Renderer disableRenderer : this.renderers) {
                disableRenderer(disableRenderer);
            }
            if (mediaPeriodHolder != null) {
                while (this.queue.getPlayingPeriod() != mediaPeriodHolder) {
                    this.queue.advancePlayingPeriod();
                }
                this.queue.removeAfter(mediaPeriodHolder);
                mediaPeriodHolder.setRendererOffset(MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US);
                enableRenderers();
            }
        }
        if (mediaPeriodHolder != null) {
            this.queue.removeAfter(mediaPeriodHolder);
            if (!mediaPeriodHolder.prepared) {
                mediaPeriodHolder.info = mediaPeriodHolder.info.copyWithStartPositionUs(j);
            } else if (mediaPeriodHolder.hasEnabledTracks) {
                long seekToUs = mediaPeriodHolder.mediaPeriod.seekToUs(j);
                mediaPeriodHolder.mediaPeriod.discardBuffer(seekToUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
                j = seekToUs;
            }
            resetRendererPosition(j);
            maybeContinueLoading();
        } else {
            this.queue.clear();
            resetRendererPosition(j);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private void resetRendererPosition(long j) throws ExoPlaybackException {
        long j2;
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            j2 = j + MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US;
        } else {
            j2 = playingPeriod.toRendererTime(j);
        }
        this.rendererPositionUs = j2;
        this.mediaClock.resetPosition(j2);
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.resetPosition(this.rendererPositionUs);
            }
        }
        notifyTrackSelectionDiscontinuity();
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        setMediaClockPlaybackParameters(playbackParameters);
        handlePlaybackParameters(this.mediaClock.getPlaybackParameters(), true);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters2) {
        this.seekParameters = seekParameters2;
    }

    private void setForegroundModeInternal(boolean z, AtomicBoolean atomicBoolean) {
        if (this.foregroundMode != z) {
            this.foregroundMode = z;
            if (!z) {
                for (Renderer renderer : this.renderers) {
                    if (!isRendererEnabled(renderer) && this.renderersToReset.remove(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void stopInternal(boolean z, boolean z2) {
        resetInternal(z || !this.foregroundMode, false, true, false);
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.loadControl.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        resetInternal(true, false, true, false);
        this.loadControl.onReleased();
        setState(1);
        HandlerThread handlerThread = this.internalPlaybackThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void resetInternal(boolean r34, boolean r35, boolean r36, boolean r37) {
        /*
            r33 = this;
            r1 = r33
            com.google.android.exoplayer2.util.HandlerWrapper r0 = r1.handler
            r2 = 2
            r0.removeMessages(r2)
            r2 = 0
            r1.pendingRecoverableRendererError = r2
            r3 = 0
            r1.isRebuffering = r3
            com.google.android.exoplayer2.DefaultMediaClock r0 = r1.mediaClock
            r0.stop()
            r4 = 1000000000000(0xe8d4a51000, double:4.94065645841E-312)
            r1.rendererPositionUs = r4
            com.google.android.exoplayer2.Renderer[] r4 = r1.renderers
            int r5 = r4.length
            r6 = 0
        L_0x001e:
            java.lang.String r7 = "ExoPlayerImplInternal"
            if (r6 >= r5) goto L_0x0033
            r0 = r4[r6]
            r1.disableRenderer(r0)     // Catch:{ ExoPlaybackException -> 0x002a, RuntimeException -> 0x0028 }
            goto L_0x0030
        L_0x0028:
            r0 = move-exception
            goto L_0x002b
        L_0x002a:
            r0 = move-exception
        L_0x002b:
            java.lang.String r8 = "Disable failed."
            com.google.android.exoplayer2.util.Log.m154e(r7, r8, r0)
        L_0x0030:
            int r6 = r6 + 1
            goto L_0x001e
        L_0x0033:
            if (r34 == 0) goto L_0x0053
            com.google.android.exoplayer2.Renderer[] r4 = r1.renderers
            int r5 = r4.length
            r6 = 0
        L_0x0039:
            if (r6 >= r5) goto L_0x0053
            r0 = r4[r6]
            java.util.Set<com.google.android.exoplayer2.Renderer> r8 = r1.renderersToReset
            boolean r8 = r8.remove(r0)
            if (r8 == 0) goto L_0x0050
            r0.reset()     // Catch:{ RuntimeException -> 0x0049 }
            goto L_0x0050
        L_0x0049:
            r0 = move-exception
            r8 = r0
            java.lang.String r0 = "Reset failed."
            com.google.android.exoplayer2.util.Log.m154e(r7, r0, r8)
        L_0x0050:
            int r6 = r6 + 1
            goto L_0x0039
        L_0x0053:
            r1.enabledRendererCount = r3
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.periodId
            com.google.android.exoplayer2.PlaybackInfo r4 = r1.playbackInfo
            long r4 = r4.positionUs
            com.google.android.exoplayer2.PlaybackInfo r6 = r1.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r6 = r6.periodId
            boolean r6 = r6.isAd()
            if (r6 != 0) goto L_0x0077
            com.google.android.exoplayer2.PlaybackInfo r6 = r1.playbackInfo
            com.google.android.exoplayer2.Timeline$Period r7 = r1.period
            boolean r6 = isUsingPlaceholderPeriod(r6, r7)
            if (r6 == 0) goto L_0x0072
            goto L_0x0077
        L_0x0072:
            com.google.android.exoplayer2.PlaybackInfo r6 = r1.playbackInfo
            long r6 = r6.positionUs
            goto L_0x007b
        L_0x0077:
            com.google.android.exoplayer2.PlaybackInfo r6 = r1.playbackInfo
            long r6 = r6.requestedContentPositionUs
        L_0x007b:
            if (r35 == 0) goto L_0x00af
            r1.pendingInitialSeekPosition = r2
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            com.google.android.exoplayer2.Timeline r0 = r0.timeline
            android.util.Pair r0 = r1.getPlaceholderFirstMediaPeriodPositionUs(r0)
            java.lang.Object r4 = r0.first
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r4 = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) r4
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r5 = r0.longValue()
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.periodId
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x00a9
            r0 = 1
            r22 = r4
            r30 = r5
            r12 = r7
            goto L_0x00b5
        L_0x00a9:
            r22 = r4
            r30 = r5
            r12 = r7
            goto L_0x00b4
        L_0x00af:
            r22 = r0
            r30 = r4
            r12 = r6
        L_0x00b4:
            r0 = 0
        L_0x00b5:
            com.google.android.exoplayer2.MediaPeriodQueue r4 = r1.queue
            r4.clear()
            r1.shouldContinueLoading = r3
            com.google.android.exoplayer2.PlaybackInfo r3 = new com.google.android.exoplayer2.PlaybackInfo
            com.google.android.exoplayer2.PlaybackInfo r4 = r1.playbackInfo
            com.google.android.exoplayer2.Timeline r10 = r4.timeline
            com.google.android.exoplayer2.PlaybackInfo r4 = r1.playbackInfo
            int r4 = r4.playbackState
            if (r37 == 0) goto L_0x00c9
            goto L_0x00cd
        L_0x00c9:
            com.google.android.exoplayer2.PlaybackInfo r2 = r1.playbackInfo
            com.google.android.exoplayer2.ExoPlaybackException r2 = r2.playbackError
        L_0x00cd:
            r17 = r2
            r18 = 0
            if (r0 == 0) goto L_0x00d6
            com.google.android.exoplayer2.source.TrackGroupArray r2 = com.google.android.exoplayer2.source.TrackGroupArray.EMPTY
            goto L_0x00da
        L_0x00d6:
            com.google.android.exoplayer2.PlaybackInfo r2 = r1.playbackInfo
            com.google.android.exoplayer2.source.TrackGroupArray r2 = r2.trackGroups
        L_0x00da:
            r19 = r2
            if (r0 == 0) goto L_0x00e1
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r2 = r1.emptyTrackSelectorResult
            goto L_0x00e5
        L_0x00e1:
            com.google.android.exoplayer2.PlaybackInfo r2 = r1.playbackInfo
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r2 = r2.trackSelectorResult
        L_0x00e5:
            r20 = r2
            if (r0 == 0) goto L_0x00ee
            com.google.common.collect.ImmutableList r0 = com.google.common.collect.ImmutableList.m261of()
            goto L_0x00f2
        L_0x00ee:
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            java.util.List<com.google.android.exoplayer2.metadata.Metadata> r0 = r0.staticMetadata
        L_0x00f2:
            r21 = r0
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            boolean r0 = r0.playWhenReady
            r23 = r0
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            int r0 = r0.playbackSuppressionReason
            r24 = r0
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            com.google.android.exoplayer2.PlaybackParameters r0 = r0.playbackParameters
            r25 = r0
            r28 = 0
            r32 = 0
            r9 = r3
            r11 = r22
            r14 = r30
            r16 = r4
            r26 = r30
            r9.<init>(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r30, r32)
            r1.playbackInfo = r3
            if (r36 == 0) goto L_0x011f
            com.google.android.exoplayer2.MediaSourceList r0 = r1.mediaSourceList
            r0.release()
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.resetInternal(boolean, boolean, boolean, boolean):void");
    }

    private Pair<MediaSource.MediaPeriodId, Long> getPlaceholderFirstMediaPeriodPositionUs(Timeline timeline) {
        long j = 0;
        if (timeline.isEmpty()) {
            return Pair.create(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L);
        }
        Timeline timeline2 = timeline;
        Pair<Object, Long> periodPositionUs = timeline2.getPeriodPositionUs(this.window, this.period, timeline.getFirstWindowIndex(this.shuffleModeEnabled), C0963C.TIME_UNSET);
        MediaSource.MediaPeriodId resolveMediaPeriodIdForAdsAfterPeriodPositionChange = this.queue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline, periodPositionUs.first, 0);
        long longValue = ((Long) periodPositionUs.second).longValue();
        if (resolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
            timeline.getPeriodByUid(resolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, this.period);
            if (resolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == this.period.getFirstAdIndexToPlay(resolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex)) {
                j = this.period.getAdResumePositionUs();
            }
            longValue = j;
        }
        return Pair.create(resolveMediaPeriodIdForAdsAfterPeriodPositionChange, Long.valueOf(longValue));
    }

    private void sendMessageInternal(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == C0963C.TIME_UNSET) {
            sendMessageToTarget(playerMessage);
        } else if (this.playbackInfo.timeline.isEmpty()) {
            this.pendingMessages.add(new PendingMessageInfo(playerMessage));
        } else {
            PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
            if (resolvePendingMessagePosition(pendingMessageInfo, this.playbackInfo.timeline, this.playbackInfo.timeline, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                this.pendingMessages.add(pendingMessageInfo);
                Collections.sort(this.pendingMessages);
                return;
            }
            playerMessage.markAsProcessed(false);
        }
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getLooper() == this.playbackLooper) {
            deliverMessage(playerMessage);
            if (this.playbackInfo.playbackState == 3 || this.playbackInfo.playbackState == 2) {
                this.handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.handler.obtainMessage(15, playerMessage).sendToTarget();
    }

    private void sendMessageToTargetThread(PlayerMessage playerMessage) {
        Looper looper = playerMessage.getLooper();
        if (!looper.getThread().isAlive()) {
            Log.m157w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
            return;
        }
        this.clock.createHandler(looper, (Handler.Callback) null).post(new ExoPlayerImplInternal$$ExternalSyntheticLambda2(this, playerMessage));
    }

    /* renamed from: lambda$sendMessageToTargetThread$1$com-google-android-exoplayer2-ExoPlayerImplInternal */
    public /* synthetic */ void mo15639xacec0129(PlayerMessage playerMessage) {
        try {
            deliverMessage(playerMessage);
        } catch (ExoPlaybackException e) {
            Log.m154e(TAG, "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private void deliverMessage(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (!playerMessage.isCanceled()) {
            try {
                playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
            } finally {
                playerMessage.markAsProcessed(true);
            }
        }
    }

    private void resolvePendingMessagePositions(Timeline timeline, Timeline timeline2) {
        if (!timeline.isEmpty() || !timeline2.isEmpty()) {
            for (int size = this.pendingMessages.size() - 1; size >= 0; size--) {
                if (!resolvePendingMessagePosition(this.pendingMessages.get(size), timeline, timeline2, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                    this.pendingMessages.get(size).message.markAsProcessed(false);
                    this.pendingMessages.remove(size);
                }
            }
            Collections.sort(this.pendingMessages);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[EDGE_INSN: B:66:0x0066->B:21:0x0066 ?: BREAK  
    EDGE_INSN: B:67:0x0066->B:21:0x0066 ?: BREAK  
    EDGE_INSN: B:69:0x0066->B:21:0x0066 ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b5 A[SYNTHETIC, Splitter:B:46:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x009f A[EDGE_INSN: B:72:0x009f->B:85:0x009f ?: BREAK  
    EDGE_INSN: B:73:0x009f->B:85:0x009f ?: BREAK  
    EDGE_INSN: B:74:0x009f->B:85:0x009f ?: BREAK  
    EDGE_INSN: B:75:0x009f->B:85:0x009f ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void maybeTriggerPendingMessages(long r8, long r10) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r7 = this;
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r0 = r7.pendingMessages
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00ff
            com.google.android.exoplayer2.PlaybackInfo r0 = r7.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.periodId
            boolean r0 = r0.isAd()
            if (r0 == 0) goto L_0x0014
            goto L_0x00ff
        L_0x0014:
            boolean r0 = r7.deliverPendingMessageAtStartPositionRequired
            if (r0 == 0) goto L_0x001e
            r0 = 1
            long r8 = r8 - r0
            r0 = 0
            r7.deliverPendingMessageAtStartPositionRequired = r0
        L_0x001e:
            com.google.android.exoplayer2.PlaybackInfo r0 = r7.playbackInfo
            com.google.android.exoplayer2.Timeline r0 = r0.timeline
            com.google.android.exoplayer2.PlaybackInfo r1 = r7.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r1.periodId
            java.lang.Object r1 = r1.periodUid
            int r0 = r0.getIndexOfPeriod(r1)
            int r1 = r7.nextPendingMessageIndexHint
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r2 = r7.pendingMessages
            int r2 = r2.size()
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
            if (r1 <= 0) goto L_0x0046
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            int r4 = r1 + -1
            java.lang.Object r3 = r3.get(r4)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0047
        L_0x0046:
            r3 = r2
        L_0x0047:
            if (r3 == 0) goto L_0x0066
            int r4 = r3.resolvedPeriodIndex
            if (r4 > r0) goto L_0x0057
            int r4 = r3.resolvedPeriodIndex
            if (r4 != r0) goto L_0x0066
            long r3 = r3.resolvedPeriodTimeUs
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x0066
        L_0x0057:
            int r1 = r1 + -1
            if (r1 <= 0) goto L_0x0046
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            int r4 = r1 + -1
            java.lang.Object r3 = r3.get(r4)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0047
        L_0x0066:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0077
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            java.lang.Object r3 = r3.get(r1)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0078
        L_0x0077:
            r3 = r2
        L_0x0078:
            if (r3 == 0) goto L_0x009f
            java.lang.Object r4 = r3.resolvedPeriodUid
            if (r4 == 0) goto L_0x009f
            int r4 = r3.resolvedPeriodIndex
            if (r4 < r0) goto L_0x008c
            int r4 = r3.resolvedPeriodIndex
            if (r4 != r0) goto L_0x009f
            long r4 = r3.resolvedPeriodTimeUs
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x009f
        L_0x008c:
            int r1 = r1 + 1
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0077
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            java.lang.Object r3 = r3.get(r1)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0078
        L_0x009f:
            if (r3 == 0) goto L_0x00fd
            java.lang.Object r4 = r3.resolvedPeriodUid
            if (r4 == 0) goto L_0x00fd
            int r4 = r3.resolvedPeriodIndex
            if (r4 != r0) goto L_0x00fd
            long r4 = r3.resolvedPeriodTimeUs
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x00fd
            long r4 = r3.resolvedPeriodTimeUs
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 > 0) goto L_0x00fd
            com.google.android.exoplayer2.PlayerMessage r4 = r3.message     // Catch:{ all -> 0x00e6 }
            r7.sendMessageToTarget(r4)     // Catch:{ all -> 0x00e6 }
            com.google.android.exoplayer2.PlayerMessage r4 = r3.message
            boolean r4 = r4.getDeleteAfterDelivery()
            if (r4 != 0) goto L_0x00ce
            com.google.android.exoplayer2.PlayerMessage r3 = r3.message
            boolean r3 = r3.isCanceled()
            if (r3 == 0) goto L_0x00cb
            goto L_0x00ce
        L_0x00cb:
            int r1 = r1 + 1
            goto L_0x00d3
        L_0x00ce:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            r3.remove(r1)
        L_0x00d3:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x00e4
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            java.lang.Object r3 = r3.get(r1)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x009f
        L_0x00e4:
            r3 = r2
            goto L_0x009f
        L_0x00e6:
            r8 = move-exception
            com.google.android.exoplayer2.PlayerMessage r9 = r3.message
            boolean r9 = r9.getDeleteAfterDelivery()
            if (r9 != 0) goto L_0x00f7
            com.google.android.exoplayer2.PlayerMessage r9 = r3.message
            boolean r9 = r9.isCanceled()
            if (r9 == 0) goto L_0x00fc
        L_0x00f7:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r9 = r7.pendingMessages
            r9.remove(r1)
        L_0x00fc:
            throw r8
        L_0x00fd:
            r7.nextPendingMessageIndexHint = r1
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.maybeTriggerPendingMessages(long, long):void");
    }

    private void ensureStopped(Renderer renderer) {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private void disableRenderer(Renderer renderer) throws ExoPlaybackException {
        if (isRendererEnabled(renderer)) {
            this.mediaClock.onRendererDisabled(renderer);
            ensureStopped(renderer);
            renderer.disable();
            this.enabledRendererCount--;
        }
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        float f = this.mediaClock.getPlaybackParameters().speed;
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z = true;
        while (playingPeriod != null && playingPeriod.prepared) {
            TrackSelectorResult selectTracks = playingPeriod.selectTracks(f, this.playbackInfo.timeline);
            if (!selectTracks.isEquivalent(playingPeriod.getTrackSelectorResult())) {
                if (z) {
                    MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                    boolean removeAfter = this.queue.removeAfter(playingPeriod2);
                    boolean[] zArr = new boolean[this.renderers.length];
                    long applyTrackSelection = playingPeriod2.applyTrackSelection(selectTracks, this.playbackInfo.positionUs, removeAfter, zArr);
                    boolean z2 = (this.playbackInfo.playbackState == 4 || applyTrackSelection == this.playbackInfo.positionUs) ? false : true;
                    MediaPeriodHolder mediaPeriodHolder = playingPeriod2;
                    boolean[] zArr2 = zArr;
                    this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, applyTrackSelection, this.playbackInfo.requestedContentPositionUs, this.playbackInfo.discontinuityStartPositionUs, z2, 5);
                    if (z2) {
                        resetRendererPosition(applyTrackSelection);
                    }
                    boolean[] zArr3 = new boolean[this.renderers.length];
                    int i = 0;
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i];
                        zArr3[i] = isRendererEnabled(renderer);
                        SampleStream sampleStream = mediaPeriodHolder.sampleStreams[i];
                        if (zArr3[i]) {
                            if (sampleStream != renderer.getStream()) {
                                disableRenderer(renderer);
                            } else if (zArr2[i]) {
                                renderer.resetPosition(this.rendererPositionUs);
                            }
                        }
                        i++;
                    }
                    enableRenderers(zArr3);
                } else {
                    this.queue.removeAfter(playingPeriod);
                    if (playingPeriod.prepared) {
                        playingPeriod.applyTrackSelection(selectTracks, Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
                    }
                }
                handleLoadingMediaPeriodChanged(true);
                if (this.playbackInfo.playbackState != 4) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (playingPeriod == readingPeriod) {
                z = false;
            }
            playingPeriod = playingPeriod.getNext();
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float f) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlaybackSpeed(f);
                }
            }
        }
    }

    private void notifyTrackSelectionDiscontinuity() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onDiscontinuity();
                }
            }
        }
    }

    private boolean shouldTransitionToReadyState(boolean z) {
        if (this.enabledRendererCount == 0) {
            return isTimelineReady();
        }
        if (!z) {
            return false;
        }
        if (!this.playbackInfo.isLoading) {
            return true;
        }
        long targetLiveOffsetUs = shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, this.queue.getPlayingPeriod().info.f148id) ? this.livePlaybackSpeedControl.getTargetLiveOffsetUs() : C0963C.TIME_UNSET;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z2 = loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal;
        boolean z3 = loadingPeriod.info.f148id.isAd() && !loadingPeriod.prepared;
        if (z2 || z3 || this.loadControl.shouldStartPlayback(getTotalBufferedDurationUs(), this.mediaClock.getPlaybackParameters().speed, this.isRebuffering, targetLiveOffsetUs)) {
            return true;
        }
        return false;
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j = playingPeriod.info.durationUs;
        return playingPeriod.prepared && (j == C0963C.TIME_UNSET || this.playbackInfo.positionUs < j || !shouldPlayWhenReady());
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x017b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleMediaSourceListInfoRefreshed(com.google.android.exoplayer2.Timeline r28, boolean r29) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r27 = this;
            r11 = r27
            r12 = r28
            com.google.android.exoplayer2.PlaybackInfo r2 = r11.playbackInfo
            com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition r3 = r11.pendingInitialSeekPosition
            com.google.android.exoplayer2.MediaPeriodQueue r4 = r11.queue
            int r5 = r11.repeatMode
            boolean r6 = r11.shuffleModeEnabled
            com.google.android.exoplayer2.Timeline$Window r7 = r11.window
            com.google.android.exoplayer2.Timeline$Period r8 = r11.period
            r1 = r28
            com.google.android.exoplayer2.ExoPlayerImplInternal$PositionUpdateForPlaylistChange r7 = resolvePositionForPlaylistChange(r1, r2, r3, r4, r5, r6, r7, r8)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r9 = r7.periodId
            long r13 = r7.requestedContentPositionUs
            boolean r0 = r7.forceBufferingState
            long r5 = r7.periodPositionUs
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r1.periodId
            boolean r1 = r1.equals(r9)
            r10 = 1
            r15 = 0
            if (r1 == 0) goto L_0x0038
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            long r1 = r1.positionUs
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            r16 = 0
            goto L_0x003a
        L_0x0038:
            r16 = 1
        L_0x003a:
            r17 = 3
            r8 = 0
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4 = 4
            boolean r1 = r7.endPlayback     // Catch:{ all -> 0x0141 }
            if (r1 == 0) goto L_0x0053
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo     // Catch:{ all -> 0x0141 }
            int r1 = r1.playbackState     // Catch:{ all -> 0x0141 }
            if (r1 == r10) goto L_0x0050
            r11.setState(r4)     // Catch:{ all -> 0x0141 }
        L_0x0050:
            r11.resetInternal(r15, r15, r15, r10)     // Catch:{ all -> 0x0141 }
        L_0x0053:
            if (r16 != 0) goto L_0x0077
            com.google.android.exoplayer2.MediaPeriodQueue r1 = r11.queue     // Catch:{ all -> 0x0070 }
            long r3 = r11.rendererPositionUs     // Catch:{ all -> 0x0070 }
            long r22 = r27.getMaxRendererReadPositionUs()     // Catch:{ all -> 0x0070 }
            r2 = r28
            r10 = -1
            r20 = 4
            r25 = r5
            r5 = r22
            boolean r0 = r1.updateQueuedPeriods(r2, r3, r5)     // Catch:{ all -> 0x013c }
            if (r0 != 0) goto L_0x00b5
            r11.seekToCurrentPosition(r15)     // Catch:{ all -> 0x013c }
            goto L_0x00b5
        L_0x0070:
            r0 = move-exception
            r10 = -1
            r20 = 4
        L_0x0074:
            r15 = r8
            goto L_0x0146
        L_0x0077:
            r25 = r5
            r10 = -1
            r20 = 4
            boolean r1 = r28.isEmpty()     // Catch:{ all -> 0x013c }
            if (r1 != 0) goto L_0x00b5
            com.google.android.exoplayer2.MediaPeriodQueue r1 = r11.queue     // Catch:{ all -> 0x00b1 }
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r1.getPlayingPeriod()     // Catch:{ all -> 0x00b1 }
        L_0x0088:
            if (r1 == 0) goto L_0x00a6
            com.google.android.exoplayer2.MediaPeriodInfo r2 = r1.info     // Catch:{ all -> 0x013c }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r2.f148id     // Catch:{ all -> 0x013c }
            boolean r2 = r2.equals(r9)     // Catch:{ all -> 0x013c }
            if (r2 == 0) goto L_0x00a1
            com.google.android.exoplayer2.MediaPeriodQueue r2 = r11.queue     // Catch:{ all -> 0x013c }
            com.google.android.exoplayer2.MediaPeriodInfo r3 = r1.info     // Catch:{ all -> 0x013c }
            com.google.android.exoplayer2.MediaPeriodInfo r2 = r2.getUpdatedMediaPeriodInfo(r12, r3)     // Catch:{ all -> 0x013c }
            r1.info = r2     // Catch:{ all -> 0x013c }
            r1.updateClipping()     // Catch:{ all -> 0x013c }
        L_0x00a1:
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r1.getNext()     // Catch:{ all -> 0x013c }
            goto L_0x0088
        L_0x00a6:
            r5 = r25
            long r0 = r11.seekToPeriodPosition(r9, r5, r0)     // Catch:{ all -> 0x00af }
            r21 = r0
            goto L_0x00b9
        L_0x00af:
            r0 = move-exception
            goto L_0x0074
        L_0x00b1:
            r0 = move-exception
            r5 = r25
            goto L_0x0074
        L_0x00b5:
            r5 = r25
            r21 = r5
        L_0x00b9:
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r4 = r0.timeline
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r0.periodId
            boolean r0 = r7.setTargetLiveOffset
            if (r0 == 0) goto L_0x00c8
            r6 = r21
            goto L_0x00ca
        L_0x00c8:
            r6 = r18
        L_0x00ca:
            r0 = 0
            r1 = r27
            r2 = r28
            r3 = r9
            r15 = r8
            r8 = r0
            r1.updatePlaybackSpeedSettingsForNewPeriod(r2, r3, r4, r5, r6, r8)
            if (r16 != 0) goto L_0x00df
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo
            long r0 = r0.requestedContentPositionUs
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x011d
        L_0x00df:
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.periodId
            java.lang.Object r0 = r0.periodUid
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r1 = r1.timeline
            if (r16 == 0) goto L_0x0100
            if (r29 == 0) goto L_0x0100
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0100
            com.google.android.exoplayer2.Timeline$Period r2 = r11.period
            com.google.android.exoplayer2.Timeline$Period r1 = r1.getPeriodByUid(r0, r2)
            boolean r1 = r1.isPlaceholder
            if (r1 != 0) goto L_0x0100
            r24 = 1
            goto L_0x0102
        L_0x0100:
            r24 = 0
        L_0x0102:
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            long r7 = r1.discontinuityStartPositionUs
            int r0 = r12.getIndexOfPeriod(r0)
            if (r0 != r10) goto L_0x010e
            r10 = 4
            goto L_0x010f
        L_0x010e:
            r10 = 3
        L_0x010f:
            r1 = r27
            r2 = r9
            r3 = r21
            r5 = r13
            r9 = r24
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.handlePositionDiscontinuity(r2, r3, r5, r7, r9, r10)
            r11.playbackInfo = r0
        L_0x011d:
            r27.resetPendingPauseAtEndOfPeriod()
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r0 = r0.timeline
            r11.resolvePendingMessagePositions(r12, r0)
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo
            com.google.android.exoplayer2.PlaybackInfo r0 = r0.copyWithTimeline(r12)
            r11.playbackInfo = r0
            boolean r0 = r28.isEmpty()
            if (r0 != 0) goto L_0x0137
            r11.pendingInitialSeekPosition = r15
        L_0x0137:
            r1 = 0
            r11.handleLoadingMediaPeriodChanged(r1)
            return
        L_0x013c:
            r0 = move-exception
            r15 = r8
            r5 = r25
            goto L_0x0146
        L_0x0141:
            r0 = move-exception
            r15 = r8
            r10 = -1
            r20 = 4
        L_0x0146:
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r4 = r1.timeline
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r8 = r1.periodId
            boolean r1 = r7.setTargetLiveOffset
            if (r1 == 0) goto L_0x0154
            r18 = r5
        L_0x0154:
            r21 = 0
            r1 = r27
            r2 = r28
            r3 = r9
            r25 = r5
            r5 = r8
            r6 = r18
            r8 = r21
            r1.updatePlaybackSpeedSettingsForNewPeriod(r2, r3, r4, r5, r6, r8)
            if (r16 != 0) goto L_0x016f
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            long r1 = r1.requestedContentPositionUs
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x01ad
        L_0x016f:
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r1.periodId
            java.lang.Object r1 = r1.periodUid
            com.google.android.exoplayer2.PlaybackInfo r2 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r2 = r2.timeline
            if (r16 == 0) goto L_0x0190
            if (r29 == 0) goto L_0x0190
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0190
            com.google.android.exoplayer2.Timeline$Period r3 = r11.period
            com.google.android.exoplayer2.Timeline$Period r2 = r2.getPeriodByUid(r1, r3)
            boolean r2 = r2.isPlaceholder
            if (r2 != 0) goto L_0x0190
            r24 = 1
            goto L_0x0192
        L_0x0190:
            r24 = 0
        L_0x0192:
            com.google.android.exoplayer2.PlaybackInfo r2 = r11.playbackInfo
            long r7 = r2.discontinuityStartPositionUs
            int r1 = r12.getIndexOfPeriod(r1)
            if (r1 != r10) goto L_0x019e
            r10 = 4
            goto L_0x019f
        L_0x019e:
            r10 = 3
        L_0x019f:
            r1 = r27
            r2 = r9
            r3 = r25
            r5 = r13
            r9 = r24
            com.google.android.exoplayer2.PlaybackInfo r1 = r1.handlePositionDiscontinuity(r2, r3, r5, r7, r9, r10)
            r11.playbackInfo = r1
        L_0x01ad:
            r27.resetPendingPauseAtEndOfPeriod()
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r1 = r1.timeline
            r11.resolvePendingMessagePositions(r12, r1)
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.PlaybackInfo r1 = r1.copyWithTimeline(r12)
            r11.playbackInfo = r1
            boolean r1 = r28.isEmpty()
            if (r1 != 0) goto L_0x01c7
            r11.pendingInitialSeekPosition = r15
        L_0x01c7:
            r1 = 0
            r11.handleLoadingMediaPeriodChanged(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.handleMediaSourceListInfoRefreshed(com.google.android.exoplayer2.Timeline, boolean):void");
    }

    private void updatePlaybackSpeedSettingsForNewPeriod(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j, boolean z) throws ExoPlaybackException {
        if (!shouldUseLivePlaybackSpeedControl(timeline, mediaPeriodId)) {
            PlaybackParameters playbackParameters = mediaPeriodId.isAd() ? PlaybackParameters.DEFAULT : this.playbackInfo.playbackParameters;
            if (!this.mediaClock.getPlaybackParameters().equals(playbackParameters)) {
                setMediaClockPlaybackParameters(playbackParameters);
                handlePlaybackParameters(this.playbackInfo.playbackParameters, playbackParameters.speed, false, false);
                return;
            }
            return;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        this.livePlaybackSpeedControl.setLiveConfiguration((MediaItem.LiveConfiguration) C1229Util.castNonNull(this.window.liveConfiguration));
        if (j != C0963C.TIME_UNSET) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(getLiveOffsetUs(timeline, mediaPeriodId.periodUid, j));
            return;
        }
        Object obj = this.window.uid;
        Object obj2 = null;
        if (!timeline2.isEmpty()) {
            obj2 = timeline2.getWindow(timeline2.getPeriodByUid(mediaPeriodId2.periodUid, this.period).windowIndex, this.window).uid;
        }
        if (!C1229Util.areEqual(obj2, obj) || z) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(C0963C.TIME_UNSET);
        }
    }

    private long getMaxRendererReadPositionUs() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return 0;
        }
        long rendererOffset = readingPeriod.getRendererOffset();
        if (!readingPeriod.prepared) {
            return rendererOffset;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return rendererOffset;
            }
            if (isRendererEnabled(rendererArr[i]) && this.renderers[i].getStream() == readingPeriod.sampleStreams[i]) {
                long readingPositionUs = this.renderers[i].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                rendererOffset = Math.max(readingPositionUs, rendererOffset);
            }
            i++;
        }
    }

    private void updatePeriods() throws ExoPlaybackException {
        if (!this.playbackInfo.timeline.isEmpty() && this.mediaSourceList.isPrepared()) {
            maybeUpdateLoadingPeriod();
            maybeUpdateReadingPeriod();
            maybeUpdateReadingRenderers();
            maybeUpdatePlayingPeriod();
        }
    }

    private void maybeUpdateLoadingPeriod() throws ExoPlaybackException {
        MediaPeriodInfo nextMediaPeriodInfo;
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod() && (nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo)) != null) {
            MediaPeriodHolder enqueueNextMediaPeriodHolder = this.queue.enqueueNextMediaPeriodHolder(this.rendererCapabilities, this.trackSelector, this.loadControl.getAllocator(), this.mediaSourceList, nextMediaPeriodInfo, this.emptyTrackSelectorResult);
            enqueueNextMediaPeriodHolder.mediaPeriod.prepare(this, nextMediaPeriodInfo.startPositionUs);
            if (this.queue.getPlayingPeriod() == enqueueNextMediaPeriodHolder) {
                resetRendererPosition(nextMediaPeriodInfo.startPositionUs);
            }
            handleLoadingMediaPeriodChanged(false);
        }
        if (this.shouldContinueLoading) {
            this.shouldContinueLoading = isLoadingPossible();
            updateIsLoading();
            return;
        }
        maybeContinueLoading();
    }

    private void maybeUpdateReadingPeriod() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod != null) {
            int i = 0;
            if (readingPeriod.getNext() == null || this.pendingPauseAtEndOfPeriod) {
                if (readingPeriod.info.isFinal || this.pendingPauseAtEndOfPeriod) {
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i < rendererArr.length) {
                            Renderer renderer = rendererArr[i];
                            SampleStream sampleStream = readingPeriod.sampleStreams[i];
                            if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                                setCurrentStreamFinal(renderer, (readingPeriod.info.durationUs == C0963C.TIME_UNSET || readingPeriod.info.durationUs == Long.MIN_VALUE) ? -9223372036854775807L : readingPeriod.getRendererOffset() + readingPeriod.info.durationUs);
                            }
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            } else if (hasReadingPeriodFinishedReading()) {
                if (readingPeriod.getNext().prepared || this.rendererPositionUs >= readingPeriod.getNext().getStartPositionRendererTime()) {
                    TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
                    MediaPeriodHolder advanceReadingPeriod = this.queue.advanceReadingPeriod();
                    TrackSelectorResult trackSelectorResult2 = advanceReadingPeriod.getTrackSelectorResult();
                    updatePlaybackSpeedSettingsForNewPeriod(this.playbackInfo.timeline, advanceReadingPeriod.info.f148id, this.playbackInfo.timeline, readingPeriod.info.f148id, C0963C.TIME_UNSET, false);
                    if (!advanceReadingPeriod.prepared || advanceReadingPeriod.mediaPeriod.readDiscontinuity() == C0963C.TIME_UNSET) {
                        for (int i2 = 0; i2 < this.renderers.length; i2++) {
                            boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i2);
                            boolean isRendererEnabled2 = trackSelectorResult2.isRendererEnabled(i2);
                            if (isRendererEnabled && !this.renderers[i2].isCurrentStreamFinal()) {
                                boolean z = this.rendererCapabilities[i2].getTrackType() == -2;
                                RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i2];
                                RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i2];
                                if (!isRendererEnabled2 || !rendererConfiguration2.equals(rendererConfiguration) || z) {
                                    setCurrentStreamFinal(this.renderers[i2], advanceReadingPeriod.getStartPositionRendererTime());
                                }
                            }
                        }
                        return;
                    }
                    setAllRendererStreamsFinal(advanceReadingPeriod.getStartPositionRendererTime());
                }
            }
        }
    }

    private void maybeUpdateReadingRenderers() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod != null && this.queue.getPlayingPeriod() != readingPeriod && !readingPeriod.allRenderersInCorrectState && replaceStreamsOrDisableRendererForTransition()) {
            enableRenderers();
        }
    }

    private boolean replaceStreamsOrDisableRendererForTransition() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        int i = 0;
        boolean z = false;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return !z;
            }
            Renderer renderer = rendererArr[i];
            if (isRendererEnabled(renderer)) {
                boolean z2 = renderer.getStream() != readingPeriod.sampleStreams[i];
                if (!trackSelectorResult.isRendererEnabled(i) || z2) {
                    if (!renderer.isCurrentStreamFinal()) {
                        renderer.replaceStream(getFormats(trackSelectorResult.selections[i]), readingPeriod.sampleStreams[i], readingPeriod.getStartPositionRendererTime(), readingPeriod.getRendererOffset());
                    } else if (renderer.isEnded()) {
                        disableRenderer(renderer);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    private void maybeUpdatePlayingPeriod() throws ExoPlaybackException {
        boolean z = false;
        while (shouldAdvancePlayingPeriod()) {
            if (z) {
                maybeNotifyPlaybackInfoChanged();
            }
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(this.queue.advancePlayingPeriod());
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodHolder.info.f148id, mediaPeriodHolder.info.startPositionUs, mediaPeriodHolder.info.requestedContentPositionUs, mediaPeriodHolder.info.startPositionUs, !(this.playbackInfo.periodId.periodUid.equals(mediaPeriodHolder.info.f148id.periodUid) && this.playbackInfo.periodId.adGroupIndex == -1 && mediaPeriodHolder.info.f148id.adGroupIndex == -1 && this.playbackInfo.periodId.nextAdGroupIndex != mediaPeriodHolder.info.f148id.nextAdGroupIndex), 0);
            resetPendingPauseAtEndOfPeriod();
            updatePlaybackPositions();
            z = true;
        }
    }

    private void resetPendingPauseAtEndOfPeriod() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        this.pendingPauseAtEndOfPeriod = playingPeriod != null && playingPeriod.info.isLastInTimelineWindow && this.pauseAtEndOfWindow;
    }

    private boolean shouldAdvancePlayingPeriod() {
        MediaPeriodHolder playingPeriod;
        MediaPeriodHolder next;
        if (shouldPlayWhenReady() && !this.pendingPauseAtEndOfPeriod && (playingPeriod = this.queue.getPlayingPeriod()) != null && (next = playingPeriod.getNext()) != null && this.rendererPositionUs >= next.getStartPositionRendererTime() && next.allRenderersInCorrectState) {
            return true;
        }
        return false;
    }

    private boolean hasReadingPeriodFinishedReading() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (!readingPeriod.prepared) {
            return false;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return true;
            }
            Renderer renderer = rendererArr[i];
            SampleStream sampleStream = readingPeriod.sampleStreams[i];
            if (renderer.getStream() != sampleStream || (sampleStream != null && !renderer.hasReadStreamToEnd() && !hasReachedServerSideInsertedAdsTransition(renderer, readingPeriod))) {
                return false;
            }
            i++;
        }
        return false;
    }

    private boolean hasReachedServerSideInsertedAdsTransition(Renderer renderer, MediaPeriodHolder mediaPeriodHolder) {
        MediaPeriodHolder next = mediaPeriodHolder.getNext();
        return mediaPeriodHolder.info.isFollowedByTransitionToSameStream && next.prepared && ((renderer instanceof TextRenderer) || (renderer instanceof MetadataRenderer) || renderer.getReadingPositionUs() >= next.getStartPositionRendererTime());
    }

    private void setAllRendererStreamsFinal(long j) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getStream() != null) {
                setCurrentStreamFinal(renderer, j);
            }
        }
    }

    private void setCurrentStreamFinal(Renderer renderer, long j) {
        renderer.setCurrentStreamFinal();
        if (renderer instanceof TextRenderer) {
            ((TextRenderer) renderer).setFinalStreamEndPositionUs(j);
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            loadingPeriod.handlePrepared(this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.timeline);
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
            if (loadingPeriod == this.queue.getPlayingPeriod()) {
                resetRendererPosition(loadingPeriod.info.startPositionUs);
                enableRenderers();
                this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, loadingPeriod.info.startPositionUs, this.playbackInfo.requestedContentPositionUs, loadingPeriod.info.startPositionUs, false, 5);
            }
            maybeContinueLoading();
        }
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        }
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, boolean z) throws ExoPlaybackException {
        handlePlaybackParameters(playbackParameters, playbackParameters.speed, true, z);
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, float f, boolean z, boolean z2) throws ExoPlaybackException {
        if (z) {
            if (z2) {
                this.playbackInfoUpdate.incrementPendingOperationAcks(1);
            }
            this.playbackInfo = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
        }
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
        for (Renderer renderer : this.renderers) {
            if (renderer != null) {
                renderer.setPlaybackSpeed(f, playbackParameters.speed);
            }
        }
    }

    private void maybeContinueLoading() {
        boolean shouldContinueLoading2 = shouldContinueLoading();
        this.shouldContinueLoading = shouldContinueLoading2;
        if (shouldContinueLoading2) {
            this.queue.getLoadingPeriod().continueLoading(this.rendererPositionUs);
        }
        updateIsLoading();
    }

    private boolean shouldContinueLoading() {
        long j;
        if (!isLoadingPossible()) {
            return false;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long totalBufferedDurationUs = getTotalBufferedDurationUs(loadingPeriod.getNextLoadPositionUs());
        if (loadingPeriod == this.queue.getPlayingPeriod()) {
            j = loadingPeriod.toPeriodTime(this.rendererPositionUs);
        } else {
            j = loadingPeriod.toPeriodTime(this.rendererPositionUs) - loadingPeriod.info.startPositionUs;
        }
        long j2 = j;
        boolean shouldContinueLoading2 = this.loadControl.shouldContinueLoading(j2, totalBufferedDurationUs, this.mediaClock.getPlaybackParameters().speed);
        if (shouldContinueLoading2 || totalBufferedDurationUs >= PLAYBACK_BUFFER_EMPTY_THRESHOLD_US) {
            return shouldContinueLoading2;
        }
        if (this.backBufferDurationUs <= 0 && !this.retainBackBufferFromKeyframe) {
            return shouldContinueLoading2;
        }
        this.queue.getPlayingPeriod().mediaPeriod.discardBuffer(this.playbackInfo.positionUs, false);
        return this.loadControl.shouldContinueLoading(j2, totalBufferedDurationUs, this.mediaClock.getPlaybackParameters().speed);
    }

    private boolean isLoadingPossible() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null || loadingPeriod.getNextLoadPositionUs() == Long.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private void updateIsLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z = this.shouldContinueLoading || (loadingPeriod != null && loadingPeriod.mediaPeriod.isLoading());
        if (z != this.playbackInfo.isLoading) {
            this.playbackInfo = this.playbackInfo.copyWithIsLoading(z);
        }
    }

    private PlaybackInfo handlePositionDiscontinuity(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, boolean z, int i) {
        ImmutableList<Metadata> immutableList;
        TrackSelectorResult trackSelectorResult;
        TrackGroupArray trackGroupArray;
        TrackGroupArray trackGroupArray2;
        TrackSelectorResult trackSelectorResult2;
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long j4 = j2;
        this.deliverPendingMessageAtStartPositionRequired = this.deliverPendingMessageAtStartPositionRequired || j != this.playbackInfo.positionUs || !mediaPeriodId.equals(this.playbackInfo.periodId);
        resetPendingPauseAtEndOfPeriod();
        TrackGroupArray trackGroupArray3 = this.playbackInfo.trackGroups;
        TrackSelectorResult trackSelectorResult3 = this.playbackInfo.trackSelectorResult;
        List list = this.playbackInfo.staticMetadata;
        if (this.mediaSourceList.isPrepared()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            if (playingPeriod == null) {
                trackGroupArray2 = TrackGroupArray.EMPTY;
            } else {
                trackGroupArray2 = playingPeriod.getTrackGroups();
            }
            if (playingPeriod == null) {
                trackSelectorResult2 = this.emptyTrackSelectorResult;
            } else {
                trackSelectorResult2 = playingPeriod.getTrackSelectorResult();
            }
            ImmutableList<Metadata> extractMetadataFromTrackSelectionArray = extractMetadataFromTrackSelectionArray(trackSelectorResult2.selections);
            if (!(playingPeriod == null || playingPeriod.info.requestedContentPositionUs == j4)) {
                playingPeriod.info = playingPeriod.info.copyWithRequestedContentPositionUs(j4);
            }
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
            immutableList = extractMetadataFromTrackSelectionArray;
        } else {
            if (!mediaPeriodId.equals(this.playbackInfo.periodId)) {
                trackGroupArray3 = TrackGroupArray.EMPTY;
                trackSelectorResult3 = this.emptyTrackSelectorResult;
                list = ImmutableList.m261of();
            }
            trackGroupArray = trackGroupArray3;
            trackSelectorResult = trackSelectorResult3;
            immutableList = list;
        }
        if (z) {
            this.playbackInfoUpdate.setPositionDiscontinuity(i);
        }
        return this.playbackInfo.copyWithNewPosition(mediaPeriodId, j, j2, j3, getTotalBufferedDurationUs(), trackGroupArray, trackSelectorResult, immutableList);
    }

    private ImmutableList<Metadata> extractMetadataFromTrackSelectionArray(ExoTrackSelection[] exoTrackSelectionArr) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        boolean z = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Format format = exoTrackSelection.getFormat(0);
                if (format.metadata == null) {
                    builder.add((Object) new Metadata(new Metadata.Entry[0]));
                } else {
                    builder.add((Object) format.metadata);
                    z = true;
                }
            }
        }
        return z ? builder.build() : ImmutableList.m261of();
    }

    private void enableRenderers() throws ExoPlaybackException {
        enableRenderers(new boolean[this.renderers.length]);
    }

    private void enableRenderers(boolean[] zArr) throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        for (int i = 0; i < this.renderers.length; i++) {
            if (!trackSelectorResult.isRendererEnabled(i) && this.renderersToReset.remove(this.renderers[i])) {
                this.renderers[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.renderers.length; i2++) {
            if (trackSelectorResult.isRendererEnabled(i2)) {
                enableRenderer(i2, zArr[i2]);
            }
        }
        readingPeriod.allRenderersInCorrectState = true;
    }

    private void enableRenderer(int i, boolean z) throws ExoPlaybackException {
        Renderer renderer = this.renderers[i];
        if (!isRendererEnabled(renderer)) {
            MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
            boolean z2 = readingPeriod == this.queue.getPlayingPeriod();
            TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
            RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i];
            Format[] formats = getFormats(trackSelectorResult.selections[i]);
            boolean z3 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
            boolean z4 = !z && z3;
            this.enabledRendererCount++;
            this.renderersToReset.add(renderer);
            renderer.enable(rendererConfiguration, formats, readingPeriod.sampleStreams[i], this.rendererPositionUs, z4, z2, readingPeriod.getStartPositionRendererTime(), readingPeriod.getRendererOffset());
            renderer.handleMessage(11, new Renderer.WakeupListener() {
                public void onSleep() {
                    boolean unused = ExoPlayerImplInternal.this.requestForRendererSleep = true;
                }

                public void onWakeup() {
                    ExoPlayerImplInternal.this.handler.sendEmptyMessage(2);
                }
            });
            this.mediaClock.onRendererEnabled(renderer);
            if (z3) {
                renderer.start();
            }
        }
    }

    private void handleLoadingMediaPeriodChanged(boolean z) {
        long j;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.f148id;
        boolean z2 = !this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (z2) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (loadingPeriod == null) {
            j = playbackInfo2.positionUs;
        } else {
            j = loadingPeriod.getBufferedPositionUs();
        }
        playbackInfo2.bufferedPositionUs = j;
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((z2 || z) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
        }
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private long getTotalBufferedDurationUs(long j) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0;
        }
        return Math.max(0, j - loadingPeriod.toPeriodTime(this.rendererPositionUs));
    }

    private void updateLoadControlTrackSelection(TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.renderers, trackGroupArray, trackSelectorResult.selections);
    }

    private boolean shouldPlayWhenReady() {
        return this.playbackInfo.playWhenReady && this.playbackInfo.playbackSuppressionReason == 0;
    }

    private static PositionUpdateForPlaylistChange resolvePositionForPlaylistChange(Timeline timeline, PlaybackInfo playbackInfo2, SeekPosition seekPosition, MediaPeriodQueue mediaPeriodQueue, int i, boolean z, Timeline.Window window2, Timeline.Period period2) {
        long j;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        MediaSource.MediaPeriodId mediaPeriodId;
        int i3;
        long j2;
        long j3;
        MediaPeriodQueue mediaPeriodQueue2;
        long j4;
        long j5;
        int i4;
        boolean z5;
        int i5;
        int i6;
        boolean z6;
        boolean z7;
        boolean z8;
        Timeline timeline2 = timeline;
        PlaybackInfo playbackInfo3 = playbackInfo2;
        SeekPosition seekPosition2 = seekPosition;
        boolean z9 = z;
        Timeline.Period period3 = period2;
        if (timeline.isEmpty()) {
            return new PositionUpdateForPlaylistChange(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0, C0963C.TIME_UNSET, false, true, false);
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo3.periodId;
        Object obj = mediaPeriodId2.periodUid;
        boolean isUsingPlaceholderPeriod = isUsingPlaceholderPeriod(playbackInfo3, period3);
        if (playbackInfo3.periodId.isAd() || isUsingPlaceholderPeriod) {
            j = playbackInfo3.requestedContentPositionUs;
        } else {
            j = playbackInfo3.positionUs;
        }
        long j6 = j;
        boolean z10 = true;
        if (seekPosition2 != null) {
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId2;
            i2 = -1;
            Pair<Object, Long> resolveSeekPositionUs = resolveSeekPositionUs(timeline, seekPosition, true, i, z, window2, period2);
            if (resolveSeekPositionUs == null) {
                i6 = timeline2.getFirstWindowIndex(z9);
                j2 = j6;
                z8 = false;
                z7 = false;
                z6 = true;
            } else {
                if (seekPosition2.windowPositionUs == C0963C.TIME_UNSET) {
                    i6 = timeline2.getPeriodByUid(resolveSeekPositionUs.first, period3).windowIndex;
                    j2 = j6;
                    z8 = false;
                } else {
                    obj = resolveSeekPositionUs.first;
                    j2 = ((Long) resolveSeekPositionUs.second).longValue();
                    z8 = true;
                    i6 = -1;
                }
                z7 = playbackInfo3.playbackState == 4;
                z6 = false;
            }
            Timeline.Window window3 = window2;
            z2 = z8;
            z4 = z7;
            z3 = z6;
            i3 = i6;
            mediaPeriodId = mediaPeriodId3;
        } else {
            MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId2;
            i2 = -1;
            if (playbackInfo3.timeline.isEmpty()) {
                i4 = timeline2.getFirstWindowIndex(z9);
            } else if (timeline2.getIndexOfPeriod(obj) == -1) {
                Object resolveSubsequentPeriod = resolveSubsequentPeriod(window2, period2, i, z, obj, playbackInfo3.timeline, timeline);
                if (resolveSubsequentPeriod == null) {
                    i5 = timeline2.getFirstWindowIndex(z9);
                    z5 = true;
                } else {
                    i5 = timeline2.getPeriodByUid(resolveSubsequentPeriod, period3).windowIndex;
                    z5 = false;
                }
                Timeline.Window window4 = window2;
                i3 = i5;
                z3 = z5;
                j4 = j6;
                mediaPeriodId = mediaPeriodId4;
                z4 = false;
                z2 = false;
            } else if (j6 == C0963C.TIME_UNSET) {
                i4 = timeline2.getPeriodByUid(obj, period3).windowIndex;
            } else if (isUsingPlaceholderPeriod) {
                mediaPeriodId = mediaPeriodId4;
                playbackInfo3.timeline.getPeriodByUid(mediaPeriodId.periodUid, period3);
                if (playbackInfo3.timeline.getWindow(period3.windowIndex, window2).firstPeriodIndex == playbackInfo3.timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) {
                    Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window2, period2, timeline2.getPeriodByUid(obj, period3).windowIndex, j6 + period2.getPositionInWindowUs());
                    obj = periodPositionUs.first;
                    j5 = ((Long) periodPositionUs.second).longValue();
                } else {
                    j5 = j6;
                }
                i3 = -1;
                z4 = false;
                z3 = false;
                z2 = true;
            } else {
                Timeline.Window window5 = window2;
                mediaPeriodId = mediaPeriodId4;
                j4 = j6;
                i3 = -1;
                z4 = false;
                z3 = false;
                z2 = false;
            }
            Timeline.Window window6 = window2;
            i3 = i4;
            j4 = j6;
            mediaPeriodId = mediaPeriodId4;
            z4 = false;
            z3 = false;
            z2 = false;
        }
        if (i3 != i2) {
            Pair<Object, Long> periodPositionUs2 = timeline.getPeriodPositionUs(window2, period2, i3, C0963C.TIME_UNSET);
            obj = periodPositionUs2.first;
            j2 = ((Long) periodPositionUs2.second).longValue();
            mediaPeriodQueue2 = mediaPeriodQueue;
            j3 = -9223372036854775807L;
        } else {
            mediaPeriodQueue2 = mediaPeriodQueue;
            j3 = j2;
        }
        MediaSource.MediaPeriodId resolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodQueue2.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline2, obj, j2);
        boolean z11 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange.nextAdGroupIndex == i2 || (mediaPeriodId.nextAdGroupIndex != i2 && resolveMediaPeriodIdForAdsAfterPeriodPositionChange.nextAdGroupIndex >= mediaPeriodId.nextAdGroupIndex);
        if (!mediaPeriodId.periodUid.equals(obj) || mediaPeriodId.isAd() || resolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd() || !z11) {
            z10 = false;
        }
        MediaSource.MediaPeriodId mediaPeriodId5 = mediaPeriodId;
        boolean isIgnorableServerSideAdInsertionPeriodChange = isIgnorableServerSideAdInsertionPeriodChange(isUsingPlaceholderPeriod, mediaPeriodId, j6, resolveMediaPeriodIdForAdsAfterPeriodPositionChange, timeline2.getPeriodByUid(obj, period3), j3);
        if (z10 || isIgnorableServerSideAdInsertionPeriodChange) {
            resolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodId5;
        }
        if (resolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
            if (resolveMediaPeriodIdForAdsAfterPeriodPositionChange.equals(mediaPeriodId5)) {
                j2 = playbackInfo3.positionUs;
            } else {
                timeline2.getPeriodByUid(resolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, period3);
                j2 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == period3.getFirstAdIndexToPlay(resolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) ? period2.getAdResumePositionUs() : 0;
            }
        }
        return new PositionUpdateForPlaylistChange(resolveMediaPeriodIdForAdsAfterPeriodPositionChange, j2, j3, z4, z3, z2);
    }

    private static boolean isIgnorableServerSideAdInsertionPeriodChange(boolean z, MediaSource.MediaPeriodId mediaPeriodId, long j, MediaSource.MediaPeriodId mediaPeriodId2, Timeline.Period period2, long j2) {
        if (z || j != j2 || !mediaPeriodId.periodUid.equals(mediaPeriodId2.periodUid)) {
            return false;
        }
        if (!mediaPeriodId.isAd() || !period2.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex)) {
            if (!mediaPeriodId2.isAd() || !period2.isServerSideInsertedAdGroup(mediaPeriodId2.adGroupIndex)) {
                return false;
            }
            return true;
        } else if (period2.getAdState(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) == 4 || period2.getAdState(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) == 2) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isUsingPlaceholderPeriod(PlaybackInfo playbackInfo2, Timeline.Period period2) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo2.periodId;
        Timeline timeline = playbackInfo2.timeline;
        return timeline.isEmpty() || timeline.getPeriodByUid(mediaPeriodId.periodUid, period2).isPlaceholder;
    }

    private static boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i, boolean z, Timeline.Window window2, Timeline.Period period2) {
        long j;
        PendingMessageInfo pendingMessageInfo2 = pendingMessageInfo;
        Timeline timeline3 = timeline;
        Timeline timeline4 = timeline2;
        Timeline.Window window3 = window2;
        Timeline.Period period3 = period2;
        if (pendingMessageInfo2.resolvedPeriodUid == null) {
            if (pendingMessageInfo2.message.getPositionMs() == Long.MIN_VALUE) {
                j = C0963C.TIME_UNSET;
            } else {
                j = C1229Util.msToUs(pendingMessageInfo2.message.getPositionMs());
            }
            Pair<Object, Long> resolveSeekPositionUs = resolveSeekPositionUs(timeline, new SeekPosition(pendingMessageInfo2.message.getTimeline(), pendingMessageInfo2.message.getMediaItemIndex(), j), false, i, z, window2, period2);
            if (resolveSeekPositionUs == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(timeline3.getIndexOfPeriod(resolveSeekPositionUs.first), ((Long) resolveSeekPositionUs.second).longValue(), resolveSeekPositionUs.first);
            if (pendingMessageInfo2.message.getPositionMs() == Long.MIN_VALUE) {
                resolvePendingMessageEndOfStreamPosition(timeline3, pendingMessageInfo, window3, period3);
            }
            return true;
        }
        int indexOfPeriod = timeline3.getIndexOfPeriod(pendingMessageInfo2.resolvedPeriodUid);
        if (indexOfPeriod == -1) {
            return false;
        }
        if (pendingMessageInfo2.message.getPositionMs() == Long.MIN_VALUE) {
            resolvePendingMessageEndOfStreamPosition(timeline3, pendingMessageInfo, window3, period3);
            return true;
        }
        pendingMessageInfo2.resolvedPeriodIndex = indexOfPeriod;
        timeline4.getPeriodByUid(pendingMessageInfo2.resolvedPeriodUid, period3);
        if (period3.isPlaceholder && timeline4.getWindow(period3.windowIndex, window3).firstPeriodIndex == timeline4.getIndexOfPeriod(pendingMessageInfo2.resolvedPeriodUid)) {
            long positionInWindowUs = pendingMessageInfo2.resolvedPeriodTimeUs + period2.getPositionInWindowUs();
            Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window2, period2, timeline3.getPeriodByUid(pendingMessageInfo2.resolvedPeriodUid, period3).windowIndex, positionInWindowUs);
            pendingMessageInfo.setResolvedPosition(timeline3.getIndexOfPeriod(periodPositionUs.first), ((Long) periodPositionUs.second).longValue(), periodPositionUs.first);
        }
        return true;
    }

    private static void resolvePendingMessageEndOfStreamPosition(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window2, Timeline.Period period2) {
        int i = timeline.getWindow(timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period2).windowIndex, window2).lastPeriodIndex;
        pendingMessageInfo.setResolvedPosition(i, period2.durationUs != C0963C.TIME_UNSET ? period2.durationUs - 1 : Long.MAX_VALUE, timeline.getPeriod(i, period2, true).uid);
    }

    private static Pair<Object, Long> resolveSeekPositionUs(Timeline timeline, SeekPosition seekPosition, boolean z, int i, boolean z2, Timeline.Window window2, Timeline.Period period2) {
        Object resolveSubsequentPeriod;
        Timeline timeline2 = timeline;
        SeekPosition seekPosition2 = seekPosition;
        Timeline.Period period3 = period2;
        Timeline timeline3 = seekPosition2.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        Timeline timeline4 = timeline3.isEmpty() ? timeline2 : timeline3;
        try {
            Pair<Object, Long> periodPositionUs = timeline4.getPeriodPositionUs(window2, period2, seekPosition2.windowIndex, seekPosition2.windowPositionUs);
            if (timeline.equals(timeline4)) {
                return periodPositionUs;
            }
            if (timeline.getIndexOfPeriod(periodPositionUs.first) == -1) {
                Timeline.Window window3 = window2;
                if (z && (resolveSubsequentPeriod = resolveSubsequentPeriod(window2, period2, i, z2, periodPositionUs.first, timeline4, timeline)) != null) {
                    return timeline.getPeriodPositionUs(window2, period2, timeline.getPeriodByUid(resolveSubsequentPeriod, period3).windowIndex, C0963C.TIME_UNSET);
                }
                return null;
            } else if (!timeline4.getPeriodByUid(periodPositionUs.first, period3).isPlaceholder || timeline4.getWindow(period3.windowIndex, window2).firstPeriodIndex != timeline4.getIndexOfPeriod(periodPositionUs.first)) {
                return periodPositionUs;
            } else {
                return timeline.getPeriodPositionUs(window2, period2, timeline.getPeriodByUid(periodPositionUs.first, period3).windowIndex, seekPosition2.windowPositionUs);
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    static Object resolveSubsequentPeriod(Timeline.Window window2, Timeline.Period period2, int i, boolean z, Object obj, Timeline timeline, Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int i2 = indexOfPeriod;
        int i3 = -1;
        for (int i4 = 0; i4 < periodCount && i3 == -1; i4++) {
            i2 = timeline.getNextPeriodIndex(i2, period2, window2, i, z);
            if (i2 == -1) {
                break;
            }
            i3 = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i2));
        }
        if (i3 == -1) {
            return null;
        }
        return timeline2.getUidOfPeriod(i3);
    }

    private static Format[] getFormats(ExoTrackSelection exoTrackSelection) {
        int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = exoTrackSelection.getFormat(i);
        }
        return formatArr;
    }

    private static boolean isRendererEnabled(Renderer renderer) {
        return renderer.getState() != 0;
    }

    private static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline2, int i, long j) {
            this.timeline = timeline2;
            this.windowIndex = i;
            this.windowPositionUs = j;
        }
    }

    private static final class PositionUpdateForPlaylistChange {
        public final boolean endPlayback;
        public final boolean forceBufferingState;
        public final MediaSource.MediaPeriodId periodId;
        public final long periodPositionUs;
        public final long requestedContentPositionUs;
        public final boolean setTargetLiveOffset;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.periodId = mediaPeriodId;
            this.periodPositionUs = j;
            this.requestedContentPositionUs = j2;
            this.forceBufferingState = z;
            this.endPlayback = z2;
            this.setTargetLiveOffset = z3;
        }
    }

    private static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public void setResolvedPosition(int i, long j, Object obj) {
            this.resolvedPeriodIndex = i;
            this.resolvedPeriodTimeUs = j;
            this.resolvedPeriodUid = obj;
        }

        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            Object obj = this.resolvedPeriodUid;
            if ((obj == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
            if (i != 0) {
                return i;
            }
            return C1229Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
        }
    }

    private static final class MediaSourceListUpdateMessage {
        /* access modifiers changed from: private */
        public final List<MediaSourceList.MediaSourceHolder> mediaSourceHolders;
        /* access modifiers changed from: private */
        public final long positionUs;
        /* access modifiers changed from: private */
        public final ShuffleOrder shuffleOrder;
        /* access modifiers changed from: private */
        public final int windowIndex;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder2, int i, long j) {
            this.mediaSourceHolders = list;
            this.shuffleOrder = shuffleOrder2;
            this.windowIndex = i;
            this.positionUs = j;
        }
    }

    private static class MoveMediaItemsMessage {
        public final int fromIndex;
        public final int newFromIndex;
        public final ShuffleOrder shuffleOrder;
        public final int toIndex;

        public MoveMediaItemsMessage(int i, int i2, int i3, ShuffleOrder shuffleOrder2) {
            this.fromIndex = i;
            this.toIndex = i2;
            this.newFromIndex = i3;
            this.shuffleOrder = shuffleOrder2;
        }
    }
}
