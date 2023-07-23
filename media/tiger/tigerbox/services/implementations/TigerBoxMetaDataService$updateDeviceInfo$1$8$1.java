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
import media.tiger.tigerbox.services.implementations.timersController.TimeLimit;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.TigerBoxMetaDataService$updateDeviceInfo$1$8$1", mo34424f = "TigerBoxMetaDataService.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: TigerBoxMetaDataService.kt */
final class TigerBoxMetaDataService$updateDeviceInfo$1$8$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $initialLimitSeconds;
    final /* synthetic */ String $limitDate;
    int label;
    final /* synthetic */ TigerBoxMetaDataService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TigerBoxMetaDataService$updateDeviceInfo$1$8$1(TigerBoxMetaDataService tigerBoxMetaDataService, String str, int i, Continuation<? super TigerBoxMetaDataService$updateDeviceInfo$1$8$1> continuation) {
        super(2, continuation);
        this.this$0 = tigerBoxMetaDataService;
        this.$limitDate = str;
        this.$initialLimitSeconds = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TigerBoxMetaDataService$updateDeviceInfo$1$8$1(this.this$0, this.$limitDate, this.$initialLimitSeconds, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TigerBoxMetaDataService$updateDeviceInfo$1$8$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TimersControllerService access$getTimersController$p = this.this$0.timersController;
            String str = this.$limitDate;
            int i = this.$initialLimitSeconds;
            TimersControllerService.DefaultImpls.startTimedLimitTimer$default(access$getTimersController$p, new TimeLimit(str, i, i), false, 2, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
