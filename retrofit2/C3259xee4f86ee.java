package retrofit2;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(mo33735bv = {1, 0, 3}, mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo33737d2 = {"<anonymous>", "", "run", "retrofit2/KotlinExtensions$suspendAndThrow$2$1"}, mo33738k = 3, mo33739mv = {1, 1, 15})
/* renamed from: retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 */
/* compiled from: KotlinExtensions.kt */
final class C3259xee4f86ee implements Runnable {
    final /* synthetic */ Continuation $continuation;
    final /* synthetic */ Exception $this_suspendAndThrow$inlined;

    C3259xee4f86ee(Continuation continuation, Exception exc) {
        this.$continuation = continuation;
        this.$this_suspendAndThrow$inlined = exc;
    }

    public final void run() {
        Continuation intercepted = IntrinsicsKt.intercepted(this.$continuation);
        Result.Companion companion = Result.Companion;
        intercepted.resumeWith(Result.m772constructorimpl(ResultKt.createFailure(this.$this_suspendAndThrow$inlined)));
    }
}
