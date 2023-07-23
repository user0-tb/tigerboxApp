package p012io.shipbook.shipbooksdk.Appenders;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import p012io.shipbook.shipbooksdk.BroadcastNames;
import p012io.shipbook.shipbooksdk.InnerLog;
import p012io.shipbook.shipbooksdk.Networking.SessionManager;

@Metadata(mo33736d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo33737d2 = {"io/shipbook/shipbooksdk/Appenders/SBCloudAppender$broadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "contxt", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Appenders.SBCloudAppender$broadcastReceiver$1 */
/* compiled from: SBCloudAppender.kt */
public final class SBCloudAppender$broadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ SBCloudAppender this$0;

    SBCloudAppender$broadcastReceiver$1(SBCloudAppender sBCloudAppender) {
        this.this$0 = sBCloudAppender;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "contxt");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (Intrinsics.areEqual((Object) action, (Object) BroadcastNames.INSTANCE.getUSER_CHANGE())) {
            InnerLog.d$default(InnerLog.INSTANCE, this.this$0.TAG, "received user change", (Throwable) null, 4, (Object) null);
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, SessionManager.INSTANCE.getThreadContext(), (CoroutineStart) null, new SBCloudAppender$broadcastReceiver$1$onReceive$1(this.this$0, (Continuation<? super SBCloudAppender$broadcastReceiver$1$onReceive$1>) null), 2, (Object) null);
        } else if (Intrinsics.areEqual((Object) action, (Object) BroadcastNames.INSTANCE.getCONNECTED())) {
            InnerLog.d$default(InnerLog.INSTANCE, this.this$0.TAG, "received connected", (Throwable) null, 4, (Object) null);
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, SessionManager.INSTANCE.getThreadContext(), (CoroutineStart) null, new SBCloudAppender$broadcastReceiver$1$onReceive$2(this.this$0, (Continuation<? super SBCloudAppender$broadcastReceiver$1$onReceive$2>) null), 2, (Object) null);
        }
    }
}
