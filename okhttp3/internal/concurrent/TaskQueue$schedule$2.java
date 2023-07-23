package okhttp3.internal.concurrent;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo33737d2 = {"okhttp3/internal/concurrent/TaskQueue$schedule$2", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TaskQueue.kt */
public final class TaskQueue$schedule$2 extends Task {
    final /* synthetic */ Function0<Long> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaskQueue$schedule$2(String str, Function0<Long> function0) {
        super(str, false, 2, (DefaultConstructorMarker) null);
        this.$block = function0;
    }

    public long runOnce() {
        return this.$block.invoke().longValue();
    }
}
