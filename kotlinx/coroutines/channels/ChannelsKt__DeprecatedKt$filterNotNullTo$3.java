package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", mo34424f = "Deprecated.kt", mo34425i = {0, 0, 1, 1}, mo34426l = {487, 242}, mo34427m = "filterNotNullTo", mo34428n = {"destination", "$this$consume$iv$iv", "destination", "$this$consume$iv$iv"}, mo34429s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: Deprecated.kt */
final class ChannelsKt__DeprecatedKt$filterNotNullTo$3<E, C extends SendChannel<? super E>> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__DeprecatedKt$filterNotNullTo$3(Continuation<? super ChannelsKt__DeprecatedKt$filterNotNullTo$3> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.filterNotNullTo((ReceiveChannel) null, (SendChannel) null, (Continuation) this);
    }
}
