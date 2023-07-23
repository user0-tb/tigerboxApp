package media.tiger.tigerbox.p016ui.main.maincontent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackListener;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState;

@Metadata(mo33736d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo33737d2 = {"media/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$audioServiceListener$1", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackListener;", "onPlaybackItemChanged", "", "item", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "onProductAcquisitionError", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$audioServiceListener$1 */
/* compiled from: ProductContentViewModel.kt */
public final class ProductContentViewModel$audioServiceListener$1 implements AudioPlaybackListener {
    final /* synthetic */ ProductContentViewModel this$0;

    ProductContentViewModel$audioServiceListener$1(ProductContentViewModel productContentViewModel) {
        this.this$0 = productContentViewModel;
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

    public void onPlaybackPlaylistWillChange() {
        AudioPlaybackListener.DefaultImpls.onPlaybackPlaylistWillChange(this);
    }

    public void onPlaybackStateChanged(AudioPlaybackState audioPlaybackState) {
        AudioPlaybackListener.DefaultImpls.onPlaybackStateChanged(this, audioPlaybackState);
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

    public void onProductPlaybackEnd(AudioItem audioItem) {
        AudioPlaybackListener.DefaultImpls.onProductPlaybackEnd(this, audioItem);
    }

    public void onPlaybackItemChanged(AudioItem audioItem) {
        SingleLiveEvent access$get_startedAudioProduct$p = this.this$0._startedAudioProduct;
        AudioItem currentItem = this.this$0.audioPlayerService.getCurrentItem();
        access$get_startedAudioProduct$p.postValue(currentItem != null ? currentItem.getProduct() : null);
    }

    public void onProductAcquisitionError(ProductAcquisitionService.ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "error");
        this.this$0.handleAcquisitionError(errorCode);
    }
}
