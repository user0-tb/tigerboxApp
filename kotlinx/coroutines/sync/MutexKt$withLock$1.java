package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 176)
@DebugMetadata(mo34423c = "kotlinx.coroutines.sync.MutexKt", mo34424f = "Mutex.kt", mo34425i = {0, 0, 0}, mo34426l = {112}, mo34427m = "withLock", mo34428n = {"$this$withLock", "owner", "action"}, mo34429s = {"L$0", "L$1", "L$2"})
/* compiled from: Mutex.kt */
final class MutexKt$withLock$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    MutexKt$withLock$1(Continuation<? super MutexKt$withLock$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MutexKt.withLock((Mutex) null, (Object) null, (Function0) null, this);
    }
}
