package media.tiger.tigerbox.developer;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.developer.AdbReceiver$onReceive$1$5", mo34424f = "AdbReceiver.kt", mo34425i = {}, mo34426l = {187}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: AdbReceiver.kt */
final class AdbReceiver$onReceive$1$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AdbReceiver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdbReceiver$onReceive$1$5(AdbReceiver adbReceiver, Continuation<? super AdbReceiver$onReceive$1$5> continuation) {
        super(2, continuation);
        this.this$0 = adbReceiver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdbReceiver$onReceive$1$5(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdbReceiver$onReceive$1$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest.mo50221i("WILL REMOVE ACCESS TOKEN", new Object[0]);
            this.label = 1;
            if (this.this$0.getAccessTokenRepository().removeAccessToken(this) == coroutine_suspended) {
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
