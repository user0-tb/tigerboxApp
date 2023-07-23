package media.tiger.tigerbox.services.implementations;

import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.services.implementations.Availability;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.Availability$finishAudioDownload$1", mo34424f = "Availability.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: Availability.kt */
final class Availability$finishAudioDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Availability.AudioDownload $download;
    int label;
    final /* synthetic */ Availability this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$finishAudioDownload$1(Availability availability, Availability.AudioDownload audioDownload, Continuation<? super Availability$finishAudioDownload$1> continuation) {
        super(2, continuation);
        this.this$0 = availability;
        this.$download = audioDownload;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Availability$finishAudioDownload$1(this.this$0, this.$download, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Availability$finishAudioDownload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Job unused = this.this$0.removeAudioDownloadFromQueue(this.$download);
            this.this$0._activeAudioDownload = null;
            if (!this.$download.getCanceled()) {
                try {
                    new File(this.this$0.pathForProduct(this.$download.getProduct().getId()) + "/content.ready").createNewFile();
                } catch (Exception e) {
                    Timber.Tree tag = Timber.Forest.tag("Availability");
                    tag.mo50217e("Exception while creating file " + e, new Object[0]);
                }
                this.this$0.publishDidProgressDownloadingProduct(this.$download.getProduct().getId(), 100);
                Availability.touchProductInfo$default(this.this$0, this.$download.getProduct().getId(), 0, 2, (Object) null);
                boolean unused2 = this.this$0.freeSpaceIfNeeded();
                if (this.this$0.getAudioDownloadsInProgress().isEmpty()) {
                    Job unused3 = this.this$0.publishDownloadedProductsDidChange();
                }
            } else {
                this.this$0.removeProduct(this.$download.getProduct().getId());
                Job unused4 = this.this$0.publishDownloadedProductsDidChange();
            }
            this.this$0.checkPendingDownloads();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
