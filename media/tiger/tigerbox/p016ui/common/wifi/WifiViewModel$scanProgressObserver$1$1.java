package media.tiger.tigerbox.p016ui.common.wifi;

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
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.common.wifi.WifiViewModel$scanProgressObserver$1$1", mo34424f = "WifiViewModel.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$scanProgressObserver$1$1 */
/* compiled from: WifiViewModel.kt */
final class WifiViewModel$scanProgressObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WifiViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WifiViewModel$scanProgressObserver$1$1(WifiViewModel wifiViewModel, Continuation<? super WifiViewModel$scanProgressObserver$1$1> continuation) {
        super(2, continuation);
        this.this$0 = wifiViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiViewModel$scanProgressObserver$1$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WifiViewModel$scanProgressObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.refreshWifiList();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
