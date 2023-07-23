package p012io.shipbook.shipbooksdk.Appenders;

import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import p012io.shipbook.shipbooksdk.Networking.SessionManager;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, mo33737d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Appenders.SBCloudAppender$createTimer$$inlined$timerTask$1 */
/* compiled from: Timer.kt */
public final class SBCloudAppender$createTimer$$inlined$timerTask$1 extends TimerTask {
    final /* synthetic */ SBCloudAppender this$0;

    public SBCloudAppender$createTimer$$inlined$timerTask$1(SBCloudAppender sBCloudAppender) {
        this.this$0 = sBCloudAppender;
    }

    public void run() {
        TimerTask timerTask = this;
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, SessionManager.INSTANCE.getThreadContext(), (CoroutineStart) null, new SBCloudAppender$createTimer$1$1(this.this$0, (Continuation<? super SBCloudAppender$createTimer$1$1>) null), 2, (Object) null);
    }
}
