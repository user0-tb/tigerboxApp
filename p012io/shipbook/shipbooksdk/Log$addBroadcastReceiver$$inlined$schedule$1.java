package p012io.shipbook.shipbooksdk;

import java.util.TimerTask;
import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, mo33737d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Log$addBroadcastReceiver$$inlined$schedule$1 */
/* compiled from: Timer.kt */
public final class Log$addBroadcastReceiver$$inlined$schedule$1 extends TimerTask {
    final /* synthetic */ Log this$0;

    public Log$addBroadcastReceiver$$inlined$schedule$1(Log log) {
        this.this$0 = log;
    }

    public void run() {
        TimerTask timerTask = this;
        this.this$0.counter = this.this$0.counter + 1;
        if (this.this$0.counter < 5) {
            this.this$0.addBroadcastReceiver();
        } else {
            InnerLog.d$default(InnerLog.INSTANCE, this.this$0.TAG, "counter bigger than 5", (Throwable) null, 4, (Object) null);
        }
    }
}
