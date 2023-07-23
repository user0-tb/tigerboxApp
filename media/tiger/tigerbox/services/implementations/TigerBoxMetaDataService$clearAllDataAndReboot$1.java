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
import media.tiger.tigerbox.services.interfaces.DeleteType;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.TigerBoxMetaDataService$clearAllDataAndReboot$1", mo34424f = "TigerBoxMetaDataService.kt", mo34425i = {}, mo34426l = {397, 401}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: TigerBoxMetaDataService.kt */
final class TigerBoxMetaDataService$clearAllDataAndReboot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TigerBoxMetaDataService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TigerBoxMetaDataService$clearAllDataAndReboot$1(TigerBoxMetaDataService tigerBoxMetaDataService, Continuation<? super TigerBoxMetaDataService$clearAllDataAndReboot$1> continuation) {
        super(2, continuation);
        this.this$0 = tigerBoxMetaDataService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TigerBoxMetaDataService$clearAllDataAndReboot$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TigerBoxMetaDataService$clearAllDataAndReboot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.availabilityService.deleteAllDownloadedProducts(DeleteType.DELETE_ALL, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.this$0.powerManagementService.reboot();
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        new File(this.this$0.context.getApplicationContext().getApplicationInfo().dataDir + "/databases/tigerboxDatabase").delete();
        this.label = 2;
        if (this.this$0.storageService.clearAllData(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.powerManagementService.reboot();
        return Unit.INSTANCE;
    }
}
