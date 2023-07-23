package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.services.interfaces.DeleteType;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.Availability$deleteAllDownloadedProducts$2", mo34424f = "Availability.kt", mo34425i = {}, mo34426l = {196}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: Availability.kt */
final class Availability$deleteAllDownloadedProducts$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ DeleteType $type;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Availability this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$deleteAllDownloadedProducts$2(DeleteType deleteType, Availability availability, Continuation<? super Availability$deleteAllDownloadedProducts$2> continuation) {
        super(2, continuation);
        this.$type = deleteType;
        this.this$0 = availability;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Availability$deleteAllDownloadedProducts$2 availability$deleteAllDownloadedProducts$2 = new Availability$deleteAllDownloadedProducts$2(this.$type, this.this$0, continuation);
        availability$deleteAllDownloadedProducts$2.L$0 = obj;
        return availability$deleteAllDownloadedProducts$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return ((Availability$deleteAllDownloadedProducts$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (this.$type == DeleteType.DELETE_ALL) {
                Availability.cancelAllDownloadsInProgress$default(this.this$0, (String) null, 1, (Object) null);
            } else if (this.$type == DeleteType.DELETE_ONLY_FOR_CURRENT_PROFILE) {
                Availability availability = this.this$0;
                availability.cancelAllDownloadsInProgress(availability.getCurrentProfileId());
            }
            CoroutineContext io = Dispatchers.getIO();
            this.label = 1;
            if (BuildersKt__Builders_commonKt.async$default(coroutineScope, io, (CoroutineStart) null, new Availability$deleteAllDownloadedProducts$2$deferred$1(this.this$0, this.$type, (Continuation<? super Availability$deleteAllDownloadedProducts$2$deferred$1>) null), 2, (Object) null).await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return this.this$0.publishDownloadedProductsDidChange();
    }
}
