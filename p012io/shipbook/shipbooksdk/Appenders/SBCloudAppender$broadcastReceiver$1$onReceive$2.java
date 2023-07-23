package p012io.shipbook.shipbooksdk.Appenders;

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
@DebugMetadata(mo34423c = "io.shipbook.shipbooksdk.Appenders.SBCloudAppender$broadcastReceiver$1$onReceive$2", mo34424f = "SBCloudAppender.kt", mo34425i = {}, mo34426l = {65}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: io.shipbook.shipbooksdk.Appenders.SBCloudAppender$broadcastReceiver$1$onReceive$2 */
/* compiled from: SBCloudAppender.kt */
final class SBCloudAppender$broadcastReceiver$1$onReceive$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SBCloudAppender this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SBCloudAppender$broadcastReceiver$1$onReceive$2(SBCloudAppender sBCloudAppender, Continuation<? super SBCloudAppender$broadcastReceiver$1$onReceive$2> continuation) {
        super(2, continuation);
        this.this$0 = sBCloudAppender;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SBCloudAppender$broadcastReceiver$1$onReceive$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SBCloudAppender$broadcastReceiver$1$onReceive$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.send(this) == coroutine_suspended) {
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
