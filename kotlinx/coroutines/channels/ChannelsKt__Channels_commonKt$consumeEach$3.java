package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 176)
@DebugMetadata(mo34423c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", mo34424f = "Channels.common.kt", mo34425i = {0, 0}, mo34426l = {129}, mo34427m = "consumeEach", mo34428n = {"action", "channel$iv"}, mo34429s = {"L$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$consumeEach$3<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__Channels_commonKt$consumeEach$3(Continuation<? super ChannelsKt__Channels_commonKt$consumeEach$3> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__Channels_commonKt.consumeEach((BroadcastChannel) null, (Function1) null, (Continuation<? super Unit>) this);
    }
}
