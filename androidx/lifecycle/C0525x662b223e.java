package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(mo33736d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, mo33737d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo33738k = 1, mo33739mv = {1, 5, 1}, mo33741xi = 48)
/* renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1 */
/* compiled from: Collect.kt */
public final class C0525x662b223e implements FlowCollector<T> {
    final /* synthetic */ LiveDataScope $$this$liveData$inlined;

    public C0525x662b223e(LiveDataScope liveDataScope) {
        this.$$this$liveData$inlined = liveDataScope;
    }

    public Object emit(T t, Continuation<? super Unit> continuation) {
        Object emit = this.$$this$liveData$inlined.emit(t, continuation);
        if (emit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return emit;
        }
        return Unit.INSTANCE;
    }
}
