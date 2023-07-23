package p012io.shipbook.shipbooksdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo33737d2 = {"io/shipbook/shipbooksdk/Log$broadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "contxt", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Log$broadcastReceiver$1 */
/* compiled from: Log.kt */
public final class Log$broadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ Log this$0;

    Log$broadcastReceiver$1(Log log) {
        this.this$0 = log;
    }

    public void onReceive(Context context, Intent intent) {
        InnerLog.d$default(InnerLog.INSTANCE, this.this$0.TAG, Intrinsics.stringPlus("got receiver configChange for tag ", this.this$0.getTag()), (Throwable) null, 4, (Object) null);
        this.this$0.severity = LogManager.INSTANCE.getSeverity(this.this$0.getTag());
        this.this$0.callStackSeverity = LogManager.INSTANCE.getCallStackSeverity(this.this$0.getTag());
    }
}
