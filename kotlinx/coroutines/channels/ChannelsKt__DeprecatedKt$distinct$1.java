package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(mo33736d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H@"}, mo33737d2 = {"<anonymous>", "E", "it"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1", mo34424f = "Deprecated.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: Deprecated.kt */
final class ChannelsKt__DeprecatedKt$distinct$1 extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {
    /* synthetic */ Object L$0;
    int label;

    ChannelsKt__DeprecatedKt$distinct$1(Continuation<? super ChannelsKt__DeprecatedKt$distinct$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$distinct$1 channelsKt__DeprecatedKt$distinct$1 = new ChannelsKt__DeprecatedKt$distinct$1(continuation);
        channelsKt__DeprecatedKt$distinct$1.L$0 = obj;
        return channelsKt__DeprecatedKt$distinct$1;
    }

    public final Object invoke(E e, Continuation<? super E> continuation) {
        return ((ChannelsKt__DeprecatedKt$distinct$1) create(e, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.L$0;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
