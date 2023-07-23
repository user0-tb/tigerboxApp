package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.data.repository.PlaybackPositionsRepository;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.model.domain.PlaybackPositionDomain;
import media.tiger.tigerbox.model.dto.PlayState;
import media.tiger.tigerbox.model.dto.ProductPlayStates;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackListener;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.PlaybackPositionService;
import media.tiger.tigerbox.usecase.GetPlayStatesUseCase;
import media.tiger.tigerbox.usecase.GetProductPlayStatesParameters;
import media.tiger.tigerbox.usecase.PostPlayStateUseCase;
import media.tiger.tigerbox.usecase.PostProductPlayStateParameters;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0017\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u001b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0014\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0012\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J \u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J(\u00100\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u00101\u001a\u000202H\u0002R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00064"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/PlaybackPosition;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/PlaybackPositionService;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackListener;", "audioService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "playbackPositionsRepository", "Lmedia/tiger/tigerbox/data/repository/PlaybackPositionsRepository;", "getPlayStatesUseCase", "Lmedia/tiger/tigerbox/usecase/GetPlayStatesUseCase;", "postPlayStateUseCase", "Lmedia/tiger/tigerbox/usecase/PostPlayStateUseCase;", "getTigerBoxAccountUseCase", "Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Lmedia/tiger/tigerbox/data/repository/PlaybackPositionsRepository;Lmedia/tiger/tigerbox/usecase/GetPlayStatesUseCase;Lmedia/tiger/tigerbox/usecase/PostPlayStateUseCase;Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;)V", "activeUserId", "", "getActiveUserId", "()I", "checkPlayStateForProductId", "", "productId", "handlePlayStatesReqFailure", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "handlePlayStatesReqSuccess", "states", "Lmedia/tiger/tigerbox/model/dto/ProductPlayStates;", "handleUpdatePostStateReqFailure", "handleUpdatePostStateReqSuccess", "state", "(Lkotlin/Unit;)V", "instructPlayerOfPlaybackPositionWithWebState", "webState", "Lmedia/tiger/tigerbox/model/dto/ProductPlayStates$Embedded$Content;", "localPlaybackPosition", "Lmedia/tiger/tigerbox/model/domain/PlaybackPositionDomain;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPlaybackItemChanged", "item", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "onPlaybackPlaylistWillChange", "onPlaybackStateChanged", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;", "requestPlayStatesFor", "savePlaybackPosition", "trackNumber", "trackPosition", "", "sendStateToServer", "userId", "", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackPosition.kt */
public final class PlaybackPosition implements PlaybackPositionService, AudioPlaybackListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    /* access modifiers changed from: private */
    public final AudioPlayerService audioService;
    private GetPlayStatesUseCase getPlayStatesUseCase;
    private GetTigerBoxAccountUseCase getTigerBoxAccountUseCase;
    /* access modifiers changed from: private */
    public PlaybackPositionsRepository playbackPositionsRepository;
    private PostPlayStateUseCase postPlayStateUseCase;

    /* access modifiers changed from: private */
    public final void handleUpdatePostStateReqSuccess(Unit unit) {
    }

    public PlaybackPosition(AudioPlayerService audioPlayerService, PlaybackPositionsRepository playbackPositionsRepository2, GetPlayStatesUseCase getPlayStatesUseCase2, PostPlayStateUseCase postPlayStateUseCase2, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase2) {
        Intrinsics.checkNotNullParameter(audioPlayerService, "audioService");
        Intrinsics.checkNotNullParameter(playbackPositionsRepository2, "playbackPositionsRepository");
        Intrinsics.checkNotNullParameter(getPlayStatesUseCase2, "getPlayStatesUseCase");
        Intrinsics.checkNotNullParameter(postPlayStateUseCase2, "postPlayStateUseCase");
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase2, "getTigerBoxAccountUseCase");
        this.audioService = audioPlayerService;
        this.playbackPositionsRepository = playbackPositionsRepository2;
        this.getPlayStatesUseCase = getPlayStatesUseCase2;
        this.postPlayStateUseCase = postPlayStateUseCase2;
        this.getTigerBoxAccountUseCase = getTigerBoxAccountUseCase2;
        audioPlayerService.registerListener(this);
    }

    public void onPlaybackBeginScrubbing(AudioItem audioItem, long j, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackBeginScrubbing(this, audioItem, j, i);
    }

    public void onPlaybackEndScrubbing(AudioItem audioItem, long j, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackEndScrubbing(this, audioItem, j, i);
    }

    public void onPlaybackPlaylistChangeReady() {
        AudioPlaybackListener.DefaultImpls.onPlaybackPlaylistChangeReady(this);
    }

    public void onPlaybackTrackDidChange(AudioItem audioItem, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackTrackDidChange(this, audioItem, i);
    }

    public void onPlaybackTrackPositionChanged(AudioItem audioItem, long j, int i, int i2) {
        AudioPlaybackListener.DefaultImpls.onPlaybackTrackPositionChanged(this, audioItem, j, i, i2);
    }

    public void onPlaybackTrackWillChange(AudioItem audioItem, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackTrackWillChange(this, audioItem, i);
    }

    public void onProductAcquisitionError(ProductAcquisitionService.ErrorCode errorCode) {
        AudioPlaybackListener.DefaultImpls.onProductAcquisitionError(this, errorCode);
    }

    public void onProductPlaybackEnd(AudioItem audioItem) {
        AudioPlaybackListener.DefaultImpls.onProductPlaybackEnd(this, audioItem);
    }

    /* access modifiers changed from: private */
    public final int getActiveUserId() {
        return this.getTigerBoxAccountUseCase.invoke().getUser().getActiveProfileId();
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/PlaybackPosition$Companion;", "", "()V", "DATE_FORMAT", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: PlaybackPosition.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onPlaybackItemChanged(AudioItem audioItem) {
        if (audioItem != null && audioItem.getShouldResumePlayback()) {
            checkPlayStateForProductId(audioItem.getProduct().getId());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r4 = r4.getProduct();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPlaybackStateChanged(media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState r4) {
        /*
            r3 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState r0 = media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState.STOPPED
            if (r4 == r0) goto L_0x000d
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState r0 = media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState.PAUSED
            if (r4 != r0) goto L_0x0030
        L_0x000d:
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r4 = r3.audioService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r4 = r4.getCurrentItem()
            if (r4 == 0) goto L_0x0020
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r4 = r4.getProduct()
            if (r4 == 0) goto L_0x0020
            int r4 = r4.getId()
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r0 = r3.audioService
            int r0 = r0.getTrackIndex()
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r1 = r3.audioService
            long r1 = r1.getCurrentTrackPosition()
            r3.savePlaybackPosition(r0, r1, r4)
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition.onPlaybackStateChanged(media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r0 = r0.getProduct();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPlaybackPlaylistWillChange() {
        /*
            r4 = this;
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r0 = r4.audioService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState r0 = r0.getState()
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState r1 = media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState.PLAYING
            if (r0 != r1) goto L_0x002d
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r0 = r4.audioService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r0 = r0.getCurrentItem()
            if (r0 == 0) goto L_0x001d
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r0 = r0.getProduct()
            if (r0 == 0) goto L_0x001d
            int r0 = r0.getId()
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r1 = r4.audioService
            int r1 = r1.getTrackIndex()
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r2 = r4.audioService
            long r2 = r2.getCurrentTrackPosition()
            r4.savePlaybackPosition(r1, r2, r0)
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition.onPlaybackPlaylistWillChange():void");
    }

    private final void savePlaybackPosition(int i, long j, int i2) {
        int i3 = i;
        long j2 = j;
        int i4 = i2;
        if (i4 > 0) {
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = i3;
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = j2;
            AudioItem currentItem = this.audioService.getCurrentItem();
            if (currentItem != null && currentItem.getProduct().getId() == i4 && currentItem.getTracks().size() - 1 == i3) {
                long durationOf = currentItem.durationOf(i3);
                float f = 0.0f;
                if (durationOf > 0) {
                    f = ((float) j2) / ((float) durationOf);
                }
                if (((double) f) > 0.5d) {
                    intRef.element = 0;
                    longRef.element = 0;
                }
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new PlaybackPosition$savePlaybackPosition$2(this, i2, intRef, longRef, (Continuation<? super PlaybackPosition$savePlaybackPosition$2>) null), 3, (Object) null);
            sendStateToServer(intRef.element, longRef.element, i2, String.valueOf(getActiveUserId()));
        }
    }

    /* access modifiers changed from: private */
    public final Object localPlaybackPosition(int i, Continuation<? super PlaybackPositionDomain> continuation) {
        if (i <= 0) {
            return null;
        }
        return this.playbackPositionsRepository.getPlaybackPosition(getActiveUserId(), i, continuation);
    }

    private final void checkPlayStateForProductId(int i) {
        requestPlayStatesFor(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getProduct();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void instructPlayerOfPlaybackPositionWithWebState(media.tiger.tigerbox.model.dto.ProductPlayStates.Embedded.Content r12) {
        /*
            r11 = this;
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r0 = r11.audioService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r0 = r0.getCurrentItem()
            if (r0 == 0) goto L_0x0014
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r0 = r0.getProduct()
            if (r0 == 0) goto L_0x0014
            int r0 = r0.getId()
            r3 = r0
            goto L_0x0016
        L_0x0014:
            r0 = 0
            r3 = 0
        L_0x0016:
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r0)
            r7 = 0
            r8 = 0
            media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1 r9 = new media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1
            r6 = 0
            r1 = r9
            r2 = r11
            r5 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            r12 = r9
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r9 = 3
            r10 = 0
            r5 = r0
            r6 = r7
            r7 = r8
            r8 = r12
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition.instructPlayerOfPlaybackPositionWithWebState(media.tiger.tigerbox.model.dto.ProductPlayStates$Embedded$Content):void");
    }

    private final void requestPlayStatesFor(int i) {
        this.getPlayStatesUseCase.invoke(new GetProductPlayStatesParameters(String.valueOf(getActiveUserId()), String.valueOf(i)), CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new PlaybackPosition$requestPlayStatesFor$1(this));
    }

    /* access modifiers changed from: private */
    public final void handlePlayStatesReqFailure(Failure failure) {
        Timber.Tree tag = Timber.Forest.tag("PlaybackPosition");
        tag.mo50217e("handlePlayStatesReqFailure: " + failure, new Object[0]);
        instructPlayerOfPlaybackPositionWithWebState((ProductPlayStates.Embedded.Content) null);
    }

    /* access modifiers changed from: private */
    public final void handlePlayStatesReqSuccess(ProductPlayStates productPlayStates) {
        ProductPlayStates.Embedded.Content content = null;
        if (productPlayStates != null) {
            if (productPlayStates.get_embedded() != null) {
                for (ProductPlayStates.Embedded.Content next : productPlayStates.get_embedded().getProductPlayStates()) {
                    if (next.getId() >= (content != null ? content.getId() : 0)) {
                        content = next;
                    }
                }
            }
            if (content != null) {
                instructPlayerOfPlaybackPositionWithWebState(content);
                return;
            }
            return;
        }
        instructPlayerOfPlaybackPositionWithWebState((ProductPlayStates.Embedded.Content) null);
    }

    private final void sendStateToServer(int i, long j, int i2, String str) {
        try {
            this.postPlayStateUseCase.invoke(new PostProductPlayStateParameters(new PlayState(-1, i2, Integer.parseInt(str), i + 1, (int) j)), CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new PlaybackPosition$sendStateToServer$1(this));
        } catch (Exception e) {
            Timber.Tree tag = Timber.Forest.tag("PlaybackPosition");
            tag.mo50217e("PlayState exception: " + e.getMessage(), new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public final void handleUpdatePostStateReqFailure(Failure failure) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50217e("PlaybackPosition - updating server with playback failed " + failure, new Object[0]);
    }
}
