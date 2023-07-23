package media.tiger.tigerbox.services.implementations.wifi;

import android.net.Network;
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
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.wifi.NetworkConnectivityCallback$onAvailable$1", mo34424f = "NetworkConnectivityCallback.kt", mo34425i = {}, mo34426l = {27}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: NetworkConnectivityCallback.kt */
final class NetworkConnectivityCallback$onAvailable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Network $network;
    int label;
    final /* synthetic */ NetworkConnectivityCallback this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetworkConnectivityCallback$onAvailable$1(NetworkConnectivityCallback networkConnectivityCallback, Network network, Continuation<? super NetworkConnectivityCallback$onAvailable$1> continuation) {
        super(2, continuation);
        this.this$0 = networkConnectivityCallback;
        this.$network = network;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetworkConnectivityCallback$onAvailable$1(this.this$0, this.$network, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NetworkConnectivityCallback$onAvailable$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.validNetworks.contains(this.$network)) {
                this.this$0.validNetworks.clear();
                this.this$0.validNetworks.add(this.$network);
                final NetworkConnectivityCallback networkConnectivityCallback = this.this$0;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C29171((Continuation<? super C29171>) null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.wifi.NetworkConnectivityCallback$onAvailable$1$1", mo34424f = "NetworkConnectivityCallback.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.services.implementations.wifi.NetworkConnectivityCallback$onAvailable$1$1 */
    /* compiled from: NetworkConnectivityCallback.kt */
    static final class C29171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29171(networkConnectivityCallback, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Timber.Forest.tag("Tiger WiFi:").mo50214d("Invoke internet connection callback", new Object[0]);
                networkConnectivityCallback.connectionCallback.onConnectionSuccess();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
