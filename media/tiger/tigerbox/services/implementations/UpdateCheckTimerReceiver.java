package media.tiger.tigerbox.services.implementations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/UpdateCheckTimerReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: UpdateCheckTimer.kt */
public final class UpdateCheckTimerReceiver extends BroadcastReceiver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static UpdateCheckTimer checkUpdateTimer;

    public void onReceive(Context context, Intent intent) {
        UpdateCheckTimer updateCheckTimer;
        if (intent != null) {
            String action = intent.getAction();
            if (action == null) {
                action = "";
            }
            Intrinsics.checkNotNullExpressionValue(action, "it.action ?: \"\"");
            if (Intrinsics.areEqual((Object) action, (Object) UpdateCheckTimer.CHECK_UPDATE_TIMER) && (updateCheckTimer = checkUpdateTimer) != null) {
                updateCheckTimer.handleAction$app_tigerBoxRelease(action, intent);
            }
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/UpdateCheckTimerReceiver$Companion;", "", "()V", "checkUpdateTimer", "Lmedia/tiger/tigerbox/services/implementations/UpdateCheckTimer;", "getCheckUpdateTimer", "()Lmedia/tiger/tigerbox/services/implementations/UpdateCheckTimer;", "setCheckUpdateTimer", "(Lmedia/tiger/tigerbox/services/implementations/UpdateCheckTimer;)V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: UpdateCheckTimer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpdateCheckTimer getCheckUpdateTimer() {
            return UpdateCheckTimerReceiver.checkUpdateTimer;
        }

        public final void setCheckUpdateTimer(UpdateCheckTimer updateCheckTimer) {
            UpdateCheckTimerReceiver.checkUpdateTimer = updateCheckTimer;
        }
    }
}
