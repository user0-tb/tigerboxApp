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

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.TigerBoxMetaDataService$updateDeviceInfo$1$9$3", mo34424f = "TigerBoxMetaDataService.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: TigerBoxMetaDataService.kt */
final class TigerBoxMetaDataService$updateDeviceInfo$1$9$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TigerBoxMetaDataService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TigerBoxMetaDataService$updateDeviceInfo$1$9$3(TigerBoxMetaDataService tigerBoxMetaDataService, Continuation<? super TigerBoxMetaDataService$updateDeviceInfo$1$9$3> continuation) {
        super(2, continuation);
        this.this$0 = tigerBoxMetaDataService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TigerBoxMetaDataService$updateDeviceInfo$1$9$3(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TigerBoxMetaDataService$updateDeviceInfo$1$9$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.timersController.initiateWindowedLimit();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
