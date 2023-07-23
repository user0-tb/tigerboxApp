package media.tiger.tigerbox.services.implementations;

import java.net.Socket;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.services.implementations.wifi.Endpoint;
import media.tiger.tigerbox.services.implementations.wifi.PingTask;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.HardwareWifiService$confirmOfflineMode$1", mo34424f = "HardwareWifiService.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: HardwareWifiService.kt */
final class HardwareWifiService$confirmOfflineMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HardwareWifiService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HardwareWifiService$confirmOfflineMode$1(HardwareWifiService hardwareWifiService, Continuation<? super HardwareWifiService$confirmOfflineMode$1> continuation) {
        super(2, continuation);
        this.this$0 = hardwareWifiService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HardwareWifiService$confirmOfflineMode$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HardwareWifiService$confirmOfflineMode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.isNetworkConnected()) {
                this.this$0.log("Network not connected, offline mode confirmed");
                this.this$0.enableOfflineMode();
            } else if (new PingTask(new Socket(), new Endpoint(this.this$0.serverUrl, this.this$0.serverPort)).invoke()) {
                this.this$0.log("Internet access available, offline mode not confirmed");
                this.this$0.disableOfflineMode();
            } else {
                this.this$0.log("No internet access, offline mode confirmed");
                this.this$0.enableOfflineMode();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
