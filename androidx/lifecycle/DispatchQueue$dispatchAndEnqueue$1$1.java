package androidx.lifecycle;

import kotlin.Metadata;

@Metadata(mo33735bv = {1, 0, 3}, mo33736d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, mo33737d2 = {"", "<anonymous>"}, mo33738k = 3, mo33739mv = {1, 5, 1})
/* compiled from: DispatchQueue.kt */
final class DispatchQueue$dispatchAndEnqueue$1$1 implements Runnable {
    final /* synthetic */ Runnable $runnable;
    final /* synthetic */ DispatchQueue this$0;

    DispatchQueue$dispatchAndEnqueue$1$1(DispatchQueue dispatchQueue, Runnable runnable) {
        this.this$0 = dispatchQueue;
        this.$runnable = runnable;
    }

    public final void run() {
        this.this$0.enqueue(this.$runnable);
    }
}
