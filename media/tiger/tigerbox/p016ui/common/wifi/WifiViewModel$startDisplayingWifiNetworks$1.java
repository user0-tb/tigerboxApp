package media.tiger.tigerbox.p016ui.common.wifi;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import media.tiger.tigerbox.p016ui.common.TimedRefreshHandler;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.common.wifi.WifiViewModel$startDisplayingWifiNetworks$1", mo34424f = "WifiViewModel.kt", mo34425i = {}, mo34426l = {113}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$startDisplayingWifiNetworks$1 */
/* compiled from: WifiViewModel.kt */
final class WifiViewModel$startDisplayingWifiNetworks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WifiViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WifiViewModel$startDisplayingWifiNetworks$1(WifiViewModel wifiViewModel, Continuation<? super WifiViewModel$startDisplayingWifiNetworks$1> continuation) {
        super(2, continuation);
        this.this$0 = wifiViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiViewModel$startDisplayingWifiNetworks$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WifiViewModel$startDisplayingWifiNetworks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.common.wifi.WifiViewModel$startDisplayingWifiNetworks$1$1", mo34424f = "WifiViewModel.kt", mo34425i = {}, mo34426l = {116}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$startDisplayingWifiNetworks$1$1 */
    /* compiled from: WifiViewModel.kt */
    static final class C29241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29241(wifiViewModel, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow startImmediately$default = TimedRefreshHandler.startImmediately$default(wifiViewModel.timedRefreshHandler, wifiViewModel.getDelayPeriodMillis(), 0, 0, 6, (Object) null);
                final WifiViewModel wifiViewModel = wifiViewModel;
                this.label = 1;
                if (startImmediately$default.collect(new FlowCollector() {
                    public final Object emit(int i, Continuation<? super Unit> continuation) {
                        wifiViewModel.refreshWifiList();
                        return Unit.INSTANCE;
                    }

                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return emit(((Number) obj).intValue(), (Continuation<? super Unit>) continuation);
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final WifiViewModel wifiViewModel = this.this$0;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C29241((Continuation<? super C29241>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
