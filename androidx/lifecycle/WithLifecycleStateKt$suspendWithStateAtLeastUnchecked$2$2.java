package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(mo33735bv = {1, 0, 3}, mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n"}, mo33737d2 = {"R", "", "it", "", "<anonymous>"}, mo33738k = 3, mo33739mv = {1, 5, 1})
/* compiled from: WithLifecycleState.kt */
final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher;
    final /* synthetic */ C0545xfdb59cc4 $observer;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(CoroutineDispatcher coroutineDispatcher, Lifecycle lifecycle, C0545xfdb59cc4 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1) {
        super(1);
        this.$lifecycleDispatcher = coroutineDispatcher;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$observer = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        if (this.$lifecycleDispatcher.isDispatchNeeded(EmptyCoroutineContext.INSTANCE)) {
            final Lifecycle lifecycle = this.$this_suspendWithStateAtLeastUnchecked;
            final C0545xfdb59cc4 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = this.$observer;
            this.$lifecycleDispatcher.dispatch(EmptyCoroutineContext.INSTANCE, new Runnable() {
                public final void run() {
                    lifecycle.removeObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
                }
            });
            return;
        }
        this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this.$observer);
    }
}
