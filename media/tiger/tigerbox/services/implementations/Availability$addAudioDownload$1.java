package media.tiger.tigerbox.services.implementations;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.services.implementations.Availability;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.Availability$addAudioDownload$1", mo34424f = "Availability.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: Availability.kt */
final class Availability$addAudioDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Availability.AudioDownload $download;
    int label;
    final /* synthetic */ Availability this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$addAudioDownload$1(Availability availability, Availability.AudioDownload audioDownload, Continuation<? super Availability$addAudioDownload$1> continuation) {
        super(2, continuation);
        this.this$0 = availability;
        this.$download = audioDownload;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Availability$addAudioDownload$1(this.this$0, this.$download, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Availability$addAudioDownload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List access$getAudioDownloadsInProgress = this.this$0.getAudioDownloadsInProgress();
            Availability availability = this.this$0;
            Availability.AudioDownload audioDownload = this.$download;
            synchronized (access$getAudioDownloadsInProgress) {
                if (!availability.getAudioDownloadsInProgress().contains(audioDownload)) {
                    availability.getAudioDownloadsInProgress().add(audioDownload);
                    availability.updateAudioDownloadLocalStorage();
                }
                Unit unit = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
