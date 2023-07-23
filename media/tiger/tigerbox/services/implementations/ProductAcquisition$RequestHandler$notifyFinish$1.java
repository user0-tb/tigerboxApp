package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.services.implementations.ProductAcquisition;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.ProductAcquisition$RequestHandler$notifyFinish$1", mo34424f = "ProductAcquisition.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: ProductAcquisition.kt */
final class ProductAcquisition$RequestHandler$notifyFinish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProductAcquisitionService.ErrorCode $error;
    int label;
    final /* synthetic */ ProductAcquisition.RequestHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductAcquisition$RequestHandler$notifyFinish$1(ProductAcquisition.RequestHandler requestHandler, ProductAcquisitionService.ErrorCode errorCode, Continuation<? super ProductAcquisition$RequestHandler$notifyFinish$1> continuation) {
        super(2, continuation);
        this.this$0 = requestHandler;
        this.$error = errorCode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductAcquisition$RequestHandler$notifyFinish$1(this.this$0, this.$error, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProductAcquisition$RequestHandler$notifyFinish$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<ProductAcquisitionService.StepType, ProductAcquisitionService.ErrorCode, Unit> stepLambda = this.this$0.getActiveRequest().getStepLambda();
            if (stepLambda != null) {
                stepLambda.invoke(ProductAcquisitionService.StepType.ACQUISITION_FINISHED, this.$error);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
