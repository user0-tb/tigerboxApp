package media.tiger.tigerbox.p016ui.main.mediaplayer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.OfflineAvailabilityState;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackListener;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;

@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002\u0019$\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002EFB7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010&\u001a\u00020'H\u0017J\u0006\u0010(\u001a\u00020'J\u0006\u0010)\u001a\u00020'J\u0006\u0010*\u001a\u00020'J\u0012\u0010+\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020'H\u0016J\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\u00020'2\u0006\u0010,\u001a\u00020-2\u0006\u00103\u001a\u000204H\u0016J(\u00105\u001a\u00020'2\u0006\u0010,\u001a\u00020-2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002042\u0006\u00103\u001a\u000204H\u0016J\u0006\u00109\u001a\u00020'J\u0010\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020'H\u0002J\b\u0010>\u001a\u00020'H\u0002J\u0006\u0010?\u001a\u00020'J\u0006\u0010@\u001a\u00020'J\u0006\u0010A\u001a\u00020'J\u0006\u0010B\u001a\u00020'J\u000e\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u000204R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e8F¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0010\u0010#\u001a\u00020$X\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006G"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel;", "Lmedia/tiger/tigerbox/ui/common/FullScreenViewModel;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackListener;", "audioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "lightControl", "Lmedia/tiger/tigerbox/services/interfaces/LightControlService;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "headerProvider", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Lmedia/tiger/tigerbox/services/interfaces/LightControlService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;)V", "_playbackState", "Landroidx/lifecycle/MutableLiveData;", "Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel$PlaybackState;", "_viewState", "Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel$ViewState;", "isNightlightEnabled", "", "()Z", "lightIntensityListener", "media/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel$lightIntensityListener$1", "Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel$lightIntensityListener$1;", "playbackInProgress", "getPlaybackInProgress", "playbackState", "Landroidx/lifecycle/LiveData;", "getPlaybackState", "()Landroidx/lifecycle/LiveData;", "viewState", "getViewState", "volumeChangeListener", "media/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel$volumeChangeListener$1", "Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel$volumeChangeListener$1;", "onCleared", "", "onNextClicked", "onOfflineModeEnabled", "onPlayClicked", "onPlaybackItemChanged", "item", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "onPlaybackPlaylistChangeReady", "onPlaybackStateChanged", "state", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;", "onPlaybackTrackDidChange", "trackIndex", "", "onPlaybackTrackPositionChanged", "seconds", "", "percent", "onPreviousClicked", "onProductAcquisitionError", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "postPlaybackState", "postViewState", "registerListeners", "requestOnlyVolume", "stopPlayingNonCardsProducts", "stopPlayingProduct", "updatePlayPosition", "progressPercent", "PlaybackState", "ViewState", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel */
/* compiled from: MediaPlayerViewModel.kt */
public final class MediaPlayerViewModel extends FullScreenViewModel implements AudioPlaybackListener {
    private final MutableLiveData<PlaybackState> _playbackState = new MutableLiveData<>();
    private final MutableLiveData<ViewState> _viewState = new MutableLiveData<>();
    private final AudioPlayerService audioPlayerService;
    private final AvailabilityService availabilityService;
    private final LightControlService lightControl;
    private final MediaPlayerViewModel$lightIntensityListener$1 lightIntensityListener = new MediaPlayerViewModel$lightIntensityListener$1(this);
    private final MetaDataService metaDataService;
    private final MediaPlayerViewModel$volumeChangeListener$1 volumeChangeListener = new MediaPlayerViewModel$volumeChangeListener$1(this);

    public void onProductAcquisitionError(ProductAcquisitionService.ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "error");
    }

    public void onPlaybackBeginScrubbing(AudioItem audioItem, long j, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackBeginScrubbing(this, audioItem, j, i);
    }

    public void onPlaybackEndScrubbing(AudioItem audioItem, long j, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackEndScrubbing(this, audioItem, j, i);
    }

    public void onPlaybackPlaylistWillChange() {
        AudioPlaybackListener.DefaultImpls.onPlaybackPlaylistWillChange(this);
    }

    public void onPlaybackTrackWillChange(AudioItem audioItem, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackTrackWillChange(this, audioItem, i);
    }

    public void onProductPlaybackEnd(AudioItem audioItem) {
        AudioPlaybackListener.DefaultImpls.onProductPlaybackEnd(this, audioItem);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public MediaPlayerViewModel(AudioPlayerService audioPlayerService2, AvailabilityService availabilityService2, MetaDataService metaDataService2, LightControlService lightControlService, ButtonService buttonService, HeaderProvider headerProvider) {
        super(buttonService, headerProvider);
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        Intrinsics.checkNotNullParameter(lightControlService, "lightControl");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(headerProvider, "headerProvider");
        this.audioPlayerService = audioPlayerService2;
        this.availabilityService = availabilityService2;
        this.metaDataService = metaDataService2;
        this.lightControl = lightControlService;
    }

    public final LiveData<ViewState> getViewState() {
        return this._viewState;
    }

    public final LiveData<PlaybackState> getPlaybackState() {
        return this._playbackState;
    }

    private final boolean getPlaybackInProgress() {
        return this.audioPlayerService.getState() == AudioPlaybackState.PREPARING || this.audioPlayerService.getState() == AudioPlaybackState.PLAYING || this.audioPlayerService.getState() == AudioPlaybackState.BUFFERING;
    }

    public final void requestOnlyVolume() {
        this._viewState.postValue(new ViewState((AudioProductInfo) null, Integer.valueOf(this.metaDataService.getMaxVolume() <= 0 ? 0 : (this.metaDataService.getVolume() * 100) / this.metaDataService.getMaxVolume()), (Boolean) null, (Integer) null, 13, (DefaultConstructorMarker) null));
    }

    public final void registerListeners() {
        this.metaDataService.registerVolumeChangeListener(this.volumeChangeListener);
        this.audioPlayerService.registerListener(this);
        this.lightControl.registerLightIntensityChangeListener(this.lightIntensityListener);
        postViewState();
        postPlaybackState();
    }

    public void onCleared() {
        this.metaDataService.unregisterVolumeChangeListener(this.volumeChangeListener);
        this.audioPlayerService.unregisterListener(this);
        this.lightControl.unregisterLightIntensityChangeListener(this.lightIntensityListener);
        super.onCleared();
    }

    public final void onPreviousClicked() {
        this.audioPlayerService.playPrevious();
    }

    public final void onNextClicked() {
        this.audioPlayerService.playNext();
    }

    public final void onPlayClicked() {
        this.audioPlayerService.togglePlayPause();
    }

    public final boolean isNightlightEnabled() {
        return this.lightControl.isTigerLightEnabled();
    }

    public final void updatePlayPosition(int i) {
        this.audioPlayerService.setCurrentTrackPosition((long) ((((float) i) / 100.0f) * ((float) this.audioPlayerService.getCurrentTrackDuration())));
    }

    public void onPlaybackPlaylistChangeReady() {
        postViewState();
        postPlaybackState();
    }

    public void onPlaybackItemChanged(AudioItem audioItem) {
        postViewState();
        postPlaybackState();
    }

    public void onPlaybackTrackDidChange(AudioItem audioItem, int i) {
        Intrinsics.checkNotNullParameter(audioItem, "item");
        postPlaybackState();
        postViewState();
    }

    public void onPlaybackTrackPositionChanged(AudioItem audioItem, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(audioItem, "item");
        postPlaybackState();
    }

    public void onPlaybackStateChanged(AudioPlaybackState audioPlaybackState) {
        Intrinsics.checkNotNullParameter(audioPlaybackState, "state");
        postViewState();
        postPlaybackState();
    }

    public final void onOfflineModeEnabled() {
        AudioProductInfo product;
        AudioItem currentItem = this.audioPlayerService.getCurrentItem();
        if (!(currentItem == null || (product = currentItem.getProduct()) == null || OfflineAvailabilityState.AVAILABLE == AvailabilityService.DefaultImpls.offlineAvailabilityStateFor$default(this.availabilityService, product.getId(), false, 2, (Object) null))) {
            this.audioPlayerService.stop();
        }
        postViewState();
    }

    public final void stopPlayingNonCardsProducts() {
        this.audioPlayerService.stopPlayingNonCardsProducts();
    }

    public final void stopPlayingProduct() {
        this.audioPlayerService.stop();
        postViewState();
    }

    /* access modifiers changed from: private */
    public final void postViewState() {
        this._viewState.postValue(new ViewState(this.audioPlayerService.getCurrentProductInfo(), Integer.valueOf(this.metaDataService.getMaxVolume() <= 0 ? 0 : (this.metaDataService.getVolume() * 100) / this.metaDataService.getMaxVolume()), Boolean.valueOf(this.lightControl.isTigerLightEnabled()), Integer.valueOf(this.lightControl.getTigerLightIntensity())));
    }

    private final void postPlaybackState() {
        this._playbackState.postValue(new PlaybackState(Boolean.valueOf(getPlaybackInProgress()), this.audioPlayerService.getState(), Integer.valueOf(this.audioPlayerService.getTrackIndex() + 1), Long.valueOf(this.audioPlayerService.getCurrentTrackPosition()), Long.valueOf(this.audioPlayerService.getCurrentTrackDuration() - this.audioPlayerService.getCurrentTrackPosition()), Integer.valueOf(this.audioPlayerService.getPlaylistProgress()), Integer.valueOf(this.audioPlayerService.getCurrentTrackProgress()), this.audioPlayerService.getHasNext(), this.audioPlayerService.getHasPrevious()));
    }

    @Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel$ViewState;", "", "audioProduct", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "volumePercent", "", "lightOn", "", "lightPercent", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getAudioProduct", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "getLightOn", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLightPercent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVolumePercent", "component1", "component2", "component3", "component4", "copy", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel$ViewState;", "equals", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel$ViewState */
    /* compiled from: MediaPlayerViewModel.kt */
    public static final class ViewState {
        private final AudioProductInfo audioProduct;
        private final Boolean lightOn;
        private final Integer lightPercent;
        private final Integer volumePercent;

        public ViewState() {
            this((AudioProductInfo) null, (Integer) null, (Boolean) null, (Integer) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, AudioProductInfo audioProductInfo, Integer num, Boolean bool, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                audioProductInfo = viewState.audioProduct;
            }
            if ((i & 2) != 0) {
                num = viewState.volumePercent;
            }
            if ((i & 4) != 0) {
                bool = viewState.lightOn;
            }
            if ((i & 8) != 0) {
                num2 = viewState.lightPercent;
            }
            return viewState.copy(audioProductInfo, num, bool, num2);
        }

        public final AudioProductInfo component1() {
            return this.audioProduct;
        }

        public final Integer component2() {
            return this.volumePercent;
        }

        public final Boolean component3() {
            return this.lightOn;
        }

        public final Integer component4() {
            return this.lightPercent;
        }

        public final ViewState copy(AudioProductInfo audioProductInfo, Integer num, Boolean bool, Integer num2) {
            return new ViewState(audioProductInfo, num, bool, num2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) obj;
            return Intrinsics.areEqual((Object) this.audioProduct, (Object) viewState.audioProduct) && Intrinsics.areEqual((Object) this.volumePercent, (Object) viewState.volumePercent) && Intrinsics.areEqual((Object) this.lightOn, (Object) viewState.lightOn) && Intrinsics.areEqual((Object) this.lightPercent, (Object) viewState.lightPercent);
        }

        public int hashCode() {
            AudioProductInfo audioProductInfo = this.audioProduct;
            int i = 0;
            int hashCode = (audioProductInfo == null ? 0 : audioProductInfo.hashCode()) * 31;
            Integer num = this.volumePercent;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Boolean bool = this.lightOn;
            int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            Integer num2 = this.lightPercent;
            if (num2 != null) {
                i = num2.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "ViewState(audioProduct=" + this.audioProduct + ", volumePercent=" + this.volumePercent + ", lightOn=" + this.lightOn + ", lightPercent=" + this.lightPercent + ')';
        }

        public ViewState(AudioProductInfo audioProductInfo, Integer num, Boolean bool, Integer num2) {
            this.audioProduct = audioProductInfo;
            this.volumePercent = num;
            this.lightOn = bool;
            this.lightPercent = num2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ViewState(AudioProductInfo audioProductInfo, Integer num, Boolean bool, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : audioProductInfo, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : num2);
        }

        public final AudioProductInfo getAudioProduct() {
            return this.audioProduct;
        }

        public final Integer getVolumePercent() {
            return this.volumePercent;
        }

        public final Boolean getLightOn() {
            return this.lightOn;
        }

        public final Integer getLightPercent() {
            return this.lightPercent;
        }
    }

    @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003Jv\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0007HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0002\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001e\u0010\u0011R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001f\u0010\u0011¨\u00060"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel$PlaybackState;", "", "isPlaying", "", "playbackState", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;", "currentTrackIndex", "", "currentTrackPosition", "", "currentTrackRemaining", "playlistProgress", "trackProgress", "hasNext", "hasPrevious", "(Ljava/lang/Boolean;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;ZZ)V", "getCurrentTrackIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCurrentTrackPosition", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCurrentTrackRemaining", "getHasNext", "()Z", "getHasPrevious", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPlaybackState", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;", "getPlaylistProgress", "getTrackProgress", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;ZZ)Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel$PlaybackState;", "equals", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel$PlaybackState */
    /* compiled from: MediaPlayerViewModel.kt */
    public static final class PlaybackState {
        private final Integer currentTrackIndex;
        private final Long currentTrackPosition;
        private final Long currentTrackRemaining;
        private final boolean hasNext;
        private final boolean hasPrevious;
        private final Boolean isPlaying;
        private final AudioPlaybackState playbackState;
        private final Integer playlistProgress;
        private final Integer trackProgress;

        public PlaybackState() {
            this((Boolean) null, (AudioPlaybackState) null, (Integer) null, (Long) null, (Long) null, (Integer) null, (Integer) null, false, false, 511, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PlaybackState copy$default(PlaybackState playbackState2, Boolean bool, AudioPlaybackState audioPlaybackState, Integer num, Long l, Long l2, Integer num2, Integer num3, boolean z, boolean z2, int i, Object obj) {
            PlaybackState playbackState3 = playbackState2;
            int i2 = i;
            return playbackState2.copy((i2 & 1) != 0 ? playbackState3.isPlaying : bool, (i2 & 2) != 0 ? playbackState3.playbackState : audioPlaybackState, (i2 & 4) != 0 ? playbackState3.currentTrackIndex : num, (i2 & 8) != 0 ? playbackState3.currentTrackPosition : l, (i2 & 16) != 0 ? playbackState3.currentTrackRemaining : l2, (i2 & 32) != 0 ? playbackState3.playlistProgress : num2, (i2 & 64) != 0 ? playbackState3.trackProgress : num3, (i2 & 128) != 0 ? playbackState3.hasNext : z, (i2 & 256) != 0 ? playbackState3.hasPrevious : z2);
        }

        public final Boolean component1() {
            return this.isPlaying;
        }

        public final AudioPlaybackState component2() {
            return this.playbackState;
        }

        public final Integer component3() {
            return this.currentTrackIndex;
        }

        public final Long component4() {
            return this.currentTrackPosition;
        }

        public final Long component5() {
            return this.currentTrackRemaining;
        }

        public final Integer component6() {
            return this.playlistProgress;
        }

        public final Integer component7() {
            return this.trackProgress;
        }

        public final boolean component8() {
            return this.hasNext;
        }

        public final boolean component9() {
            return this.hasPrevious;
        }

        public final PlaybackState copy(Boolean bool, AudioPlaybackState audioPlaybackState, Integer num, Long l, Long l2, Integer num2, Integer num3, boolean z, boolean z2) {
            return new PlaybackState(bool, audioPlaybackState, num, l, l2, num2, num3, z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlaybackState)) {
                return false;
            }
            PlaybackState playbackState2 = (PlaybackState) obj;
            return Intrinsics.areEqual((Object) this.isPlaying, (Object) playbackState2.isPlaying) && this.playbackState == playbackState2.playbackState && Intrinsics.areEqual((Object) this.currentTrackIndex, (Object) playbackState2.currentTrackIndex) && Intrinsics.areEqual((Object) this.currentTrackPosition, (Object) playbackState2.currentTrackPosition) && Intrinsics.areEqual((Object) this.currentTrackRemaining, (Object) playbackState2.currentTrackRemaining) && Intrinsics.areEqual((Object) this.playlistProgress, (Object) playbackState2.playlistProgress) && Intrinsics.areEqual((Object) this.trackProgress, (Object) playbackState2.trackProgress) && this.hasNext == playbackState2.hasNext && this.hasPrevious == playbackState2.hasPrevious;
        }

        public int hashCode() {
            Boolean bool = this.isPlaying;
            int i = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            AudioPlaybackState audioPlaybackState = this.playbackState;
            int hashCode2 = (hashCode + (audioPlaybackState == null ? 0 : audioPlaybackState.hashCode())) * 31;
            Integer num = this.currentTrackIndex;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Long l = this.currentTrackPosition;
            int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.currentTrackRemaining;
            int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Integer num2 = this.playlistProgress;
            int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.trackProgress;
            if (num3 != null) {
                i = num3.hashCode();
            }
            int i2 = (hashCode6 + i) * 31;
            boolean z = this.hasNext;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i3 = (i2 + (z ? 1 : 0)) * 31;
            boolean z3 = this.hasPrevious;
            if (!z3) {
                z2 = z3;
            }
            return i3 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "PlaybackState(isPlaying=" + this.isPlaying + ", playbackState=" + this.playbackState + ", currentTrackIndex=" + this.currentTrackIndex + ", currentTrackPosition=" + this.currentTrackPosition + ", currentTrackRemaining=" + this.currentTrackRemaining + ", playlistProgress=" + this.playlistProgress + ", trackProgress=" + this.trackProgress + ", hasNext=" + this.hasNext + ", hasPrevious=" + this.hasPrevious + ')';
        }

        public PlaybackState(Boolean bool, AudioPlaybackState audioPlaybackState, Integer num, Long l, Long l2, Integer num2, Integer num3, boolean z, boolean z2) {
            this.isPlaying = bool;
            this.playbackState = audioPlaybackState;
            this.currentTrackIndex = num;
            this.currentTrackPosition = l;
            this.currentTrackRemaining = l2;
            this.playlistProgress = num2;
            this.trackProgress = num3;
            this.hasNext = z;
            this.hasPrevious = z2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ PlaybackState(java.lang.Boolean r11, media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState r12, java.lang.Integer r13, java.lang.Long r14, java.lang.Long r15, java.lang.Integer r16, java.lang.Integer r17, boolean r18, boolean r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
            /*
                r10 = this;
                r0 = r20
                r1 = r0 & 1
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r1 = r2
                goto L_0x000a
            L_0x0009:
                r1 = r11
            L_0x000a:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0010
                r3 = r2
                goto L_0x0011
            L_0x0010:
                r3 = r12
            L_0x0011:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x0017
                r4 = r2
                goto L_0x0018
            L_0x0017:
                r4 = r13
            L_0x0018:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x001e
                r5 = r2
                goto L_0x001f
            L_0x001e:
                r5 = r14
            L_0x001f:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0025
                r6 = r2
                goto L_0x0026
            L_0x0025:
                r6 = r15
            L_0x0026:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x002c
                r7 = r2
                goto L_0x002e
            L_0x002c:
                r7 = r16
            L_0x002e:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x0033
                goto L_0x0035
            L_0x0033:
                r2 = r17
            L_0x0035:
                r8 = r0 & 128(0x80, float:1.794E-43)
                r9 = 1
                if (r8 == 0) goto L_0x003c
                r8 = 1
                goto L_0x003e
            L_0x003c:
                r8 = r18
            L_0x003e:
                r0 = r0 & 256(0x100, float:3.59E-43)
                if (r0 == 0) goto L_0x0043
                goto L_0x0045
            L_0x0043:
                r9 = r19
            L_0x0045:
                r11 = r10
                r12 = r1
                r13 = r3
                r14 = r4
                r15 = r5
                r16 = r6
                r17 = r7
                r18 = r2
                r19 = r8
                r20 = r9
                r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerViewModel.PlaybackState.<init>(java.lang.Boolean, media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState, java.lang.Integer, java.lang.Long, java.lang.Long, java.lang.Integer, java.lang.Integer, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final Boolean isPlaying() {
            return this.isPlaying;
        }

        public final AudioPlaybackState getPlaybackState() {
            return this.playbackState;
        }

        public final Integer getCurrentTrackIndex() {
            return this.currentTrackIndex;
        }

        public final Long getCurrentTrackPosition() {
            return this.currentTrackPosition;
        }

        public final Long getCurrentTrackRemaining() {
            return this.currentTrackRemaining;
        }

        public final Integer getPlaylistProgress() {
            return this.playlistProgress;
        }

        public final Integer getTrackProgress() {
            return this.trackProgress;
        }

        public final boolean getHasNext() {
            return this.hasNext;
        }

        public final boolean getHasPrevious() {
            return this.hasPrevious;
        }
    }
}
