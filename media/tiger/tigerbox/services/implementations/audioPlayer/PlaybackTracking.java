package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.data.repository.PlaybackTrackingRepository;
import media.tiger.tigerbox.model.dto.PlaybackTrackingEvent;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackReason;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;
import media.tiger.tigerbox.services.interfaces.audioPlayer.PlaybackTrackingService;
import media.tiger.tigerbox.usecase.PostTrackingEventUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;
import p012io.shipbook.shipbooksdk.Log;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001e\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0002J\u0018\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020'H\u0002J\u0018\u00101\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020'H\u0002J\u0018\u00102\u001a\u0002032\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020'H\u0002J\b\u00104\u001a\u000203H\u0002J\u0010\u00105\u001a\u0002032\u0006\u0010/\u001a\u00020\u0014H\u0002J\b\u00106\u001a\u00020,H\u0002R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u0010\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020'8BX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u00067"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/PlaybackTracking;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/PlaybackTrackingService;", "audioService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "playbackTrackingRepository", "Lmedia/tiger/tigerbox/data/repository/PlaybackTrackingRepository;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "postTrackingEventUseCase", "Lmedia/tiger/tigerbox/usecase/PostTrackingEventUseCase;", "getTigerBoxAccountUseCase", "Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Lmedia/tiger/tigerbox/data/repository/PlaybackTrackingRepository;Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/usecase/PostTrackingEventUseCase;Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;)V", "activeAccountId", "", "getActiveAccountId", "()I", "activeEvent", "Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent;", "activeProductId", "getActiveProductId", "activeProductLength", "getActiveProductLength", "activeProductPosition", "getActiveProductPosition", "activeUserId", "getActiveUserId", "audioListener", "media/tiger/tigerbox/services/implementations/audioPlayer/PlaybackTracking$audioListener$1", "Lmedia/tiger/tigerbox/services/implementations/audioPlayer/PlaybackTracking$audioListener$1;", "currentPlayerState", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;", "deviceId", "", "getDeviceId", "()Ljava/lang/String;", "hadScrub", "", "shouldTrack", "getShouldTrack", "()Z", "beginTrackEvent", "", "endTrackEvent", "handlePostReqFailure", "event", "isNewEvent", "handlePostReqSuccess", "postEvent", "Lkotlinx/coroutines/Job;", "postUnsentEvents", "removeEventFromDatabase", "updateTrackEvent", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackTracking.kt */
public final class PlaybackTracking implements PlaybackTrackingService {
    private PlaybackTrackingEvent activeEvent;
    private final PlaybackTracking$audioListener$1 audioListener;
    /* access modifiers changed from: private */
    public final AudioPlayerService audioService;
    /* access modifiers changed from: private */
    public AudioPlaybackState currentPlayerState = AudioPlaybackState.STOPPED;
    private final GetTigerBoxAccountUseCase getTigerBoxAccountUseCase;
    /* access modifiers changed from: private */
    public boolean hadScrub;
    /* access modifiers changed from: private */
    public final PlaybackTrackingRepository playbackTrackingRepository;
    /* access modifiers changed from: private */
    public final PostTrackingEventUseCase postTrackingEventUseCase;
    private final StorageService storageService;

    public PlaybackTracking(AudioPlayerService audioPlayerService, PlaybackTrackingRepository playbackTrackingRepository2, WifiService wifiService, StorageService storageService2, PostTrackingEventUseCase postTrackingEventUseCase2, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase2) {
        Intrinsics.checkNotNullParameter(audioPlayerService, "audioService");
        Intrinsics.checkNotNullParameter(playbackTrackingRepository2, "playbackTrackingRepository");
        Intrinsics.checkNotNullParameter(wifiService, "wifiService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(postTrackingEventUseCase2, "postTrackingEventUseCase");
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase2, "getTigerBoxAccountUseCase");
        this.audioService = audioPlayerService;
        this.playbackTrackingRepository = playbackTrackingRepository2;
        this.storageService = storageService2;
        this.postTrackingEventUseCase = postTrackingEventUseCase2;
        this.getTigerBoxAccountUseCase = getTigerBoxAccountUseCase2;
        PlaybackTracking$audioListener$1 playbackTracking$audioListener$1 = new PlaybackTracking$audioListener$1(this);
        this.audioListener = playbackTracking$audioListener$1;
        Log.Companion.e$default(Log.Companion, "PlaybackTracking", " init", (Throwable) null, 4, (Object) null);
        audioPlayerService.registerListener(playbackTracking$audioListener$1);
        wifiService.getOfflineMode().observeForever(new PlaybackTracking$$ExternalSyntheticLambda0(this));
        Log.Companion.e$default(Log.Companion, "PlaybackTracking", " sending once events on startup", (Throwable) null, 4, (Object) null);
        postUnsentEvents();
    }

    private final int getActiveUserId() {
        return this.getTigerBoxAccountUseCase.invoke().getUser().getActiveProfileId();
    }

    private final int getActiveAccountId() {
        return this.getTigerBoxAccountUseCase.invoke().getUser().getAccountId();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getDeviceIdentifier();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getDeviceId() {
        /*
            r1 = this;
            media.tiger.tigerbox.services.interfaces.StorageService r0 = r1.storageService
            media.tiger.tigerbox.model.dto.DeviceInformation r0 = r0.getDeviceInformation()
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = r0.getDeviceIdentifier()
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = ""
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackTracking.getDeviceId():java.lang.String");
    }

    private final int getActiveProductId() {
        AudioProductInfo product;
        AudioItem currentItem = this.audioService.getCurrentItem();
        if (currentItem == null || (product = currentItem.getProduct()) == null) {
            return 0;
        }
        return product.getId();
    }

    private final int getActiveProductPosition() {
        return (int) this.audioService.getPlaylistPosition();
    }

    private final int getActiveProductLength() {
        AudioItem currentItem = this.audioService.getCurrentItem();
        if (currentItem != null) {
            return (int) currentItem.getDuration();
        }
        return 0;
    }

    private final boolean getShouldTrack() {
        return (this.audioService.getPlaybackReason() == AudioPlaybackReason.TIGERCARD || this.audioService.getPlaybackReason() == AudioPlaybackReason.WILDCARD_USER_CONTENT) ? false : true;
    }

    /* access modifiers changed from: private */
    public final void updateTrackEvent() {
        PlaybackTrackingEvent playbackTrackingEvent = this.activeEvent;
        if (playbackTrackingEvent != null) {
            synchronized (this) {
                this.activeEvent = PlaybackTrackingEvent.copy$default(playbackTrackingEvent, 0, 0, 0, PlaybackTrackingEvent.EventData.copy$default(playbackTrackingEvent.getData(), 0, getActiveProductPosition(), 0, (String) null, 13, (Object) null), (String) null, 23, (Object) null);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void endTrackEvent() {
        PlaybackTrackingEvent playbackTrackingEvent = this.activeEvent;
        if (playbackTrackingEvent != null && playbackTrackingEvent.getData().getEnd() > playbackTrackingEvent.getData().getStart()) {
            Timber.Forest.mo50236w("PlaybackTracking endTrackEvent", new Object[0]);
            postEvent(playbackTrackingEvent, true);
        }
        this.activeEvent = null;
    }

    /* access modifiers changed from: private */
    public final void beginTrackEvent() {
        synchronized (this) {
            endTrackEvent();
            if (getShouldTrack()) {
                this.activeEvent = new PlaybackTrackingEvent(getActiveAccountId(), getActiveUserId(), getActiveProductId(), new PlaybackTrackingEvent.EventData(getActiveProductPosition(), getActiveProductPosition(), getActiveProductLength(), getDeviceId()), (String) null, 16, (DefaultConstructorMarker) null);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final Job removeEventFromDatabase(PlaybackTrackingEvent playbackTrackingEvent) {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new PlaybackTracking$removeEventFromDatabase$1(playbackTrackingEvent, this, (Continuation<? super PlaybackTracking$removeEventFromDatabase$1>) null), 3, (Object) null);
    }

    private final Job postUnsentEvents() {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new PlaybackTracking$postUnsentEvents$1(this, (Continuation<? super PlaybackTracking$postUnsentEvents$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Job postEvent(PlaybackTrackingEvent playbackTrackingEvent, boolean z) {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new PlaybackTracking$postEvent$1(playbackTrackingEvent, z, this, (Continuation<? super PlaybackTracking$postEvent$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void handlePostReqFailure(PlaybackTrackingEvent playbackTrackingEvent, boolean z) {
        if (z) {
            Timber.Forest.mo50236w("PlaybackTracking post failed - will add to database", new Object[0]);
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new PlaybackTracking$handlePostReqFailure$1(playbackTrackingEvent, this, (Continuation<? super PlaybackTracking$handlePostReqFailure$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void handlePostReqSuccess(PlaybackTrackingEvent playbackTrackingEvent, boolean z) {
        if (!z) {
            Timber.Forest.mo50236w("PlaybackTracking post successful - will remove from database", new Object[0]);
            removeEventFromDatabase(playbackTrackingEvent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-4  reason: not valid java name */
    public static final void m2348_init_$lambda4(PlaybackTracking playbackTracking, Boolean bool) {
        Intrinsics.checkNotNullParameter(playbackTracking, "this$0");
        if (Intrinsics.areEqual((Object) bool, (Object) false)) {
            Log.Companion.e$default(Log.Companion, "PlaybackTracking", " we are online - we will send saved event", (Throwable) null, 4, (Object) null);
            playbackTracking.postUnsentEvents();
        }
    }
}
