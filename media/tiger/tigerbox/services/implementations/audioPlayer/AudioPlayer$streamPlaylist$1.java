package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioPlayer.kt */
final class AudioPlayer$streamPlaylist$1 extends Lambda implements Function1<ProductAcquisitionService.ErrorCode, Unit> {
    final /* synthetic */ Function1<ProductAcquisitionService.ErrorCode, Unit> $onAcquisitionReady;
    final /* synthetic */ AudioPlayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AudioPlayer$streamPlaylist$1(AudioPlayer audioPlayer, Function1<? super ProductAcquisitionService.ErrorCode, Unit> function1) {
        super(1);
        this.this$0 = audioPlayer;
        this.$onAcquisitionReady = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProductAcquisitionService.ErrorCode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductAcquisitionService.ErrorCode errorCode) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("ON STREAM READY " + errorCode, new Object[0]);
        this.this$0._isPreparingPlaylist = false;
        this.this$0.notifyAllOnPlaybackPlaylistChangeReady();
        this.$onAcquisitionReady.invoke(errorCode);
    }
}
