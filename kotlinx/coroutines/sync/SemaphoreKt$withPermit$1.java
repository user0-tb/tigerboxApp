package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 176)
@DebugMetadata(mo34423c = "kotlinx.coroutines.sync.SemaphoreKt", mo34424f = "Semaphore.kt", mo34425i = {0, 0}, mo34426l = {85}, mo34427m = "withPermit", mo34428n = {"$this$withPermit", "action"}, mo34429s = {"L$0", "L$1"})
/* compiled from: Semaphore.kt */
final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    SemaphoreKt$withPermit$1(Continuation<? super SemaphoreKt$withPermit$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SemaphoreKt.withPermit((Semaphore) null, (Function0) null, this);
    }
}
