package media.tiger.tigerbox.services.implementations.receiver;

import android.content.Context;
import android.content.Intent;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.implementations.HeadsetService;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/receiver/HeadsetBroadcastReceiver;", "Lmedia/tiger/tigerbox/infrastructure/di/InjectableBroadcastReceiver;", "()V", "headsetService", "Lmedia/tiger/tigerbox/services/implementations/HeadsetService;", "getHeadsetService", "()Lmedia/tiger/tigerbox/services/implementations/HeadsetService;", "setHeadsetService", "(Lmedia/tiger/tigerbox/services/implementations/HeadsetService;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* compiled from: HeadsetBroadcastReceiver.kt */
public final class HeadsetBroadcastReceiver extends Hilt_HeadsetBroadcastReceiver {
    @Inject
    public HeadsetService headsetService;

    public final HeadsetService getHeadsetService() {
        HeadsetService headsetService2 = this.headsetService;
        if (headsetService2 != null) {
            return headsetService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("headsetService");
        return null;
    }

    public final void setHeadsetService(HeadsetService headsetService2) {
        Intrinsics.checkNotNullParameter(headsetService2, "<set-?>");
        this.headsetService = headsetService2;
    }

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent != null) {
            String action = intent.getAction();
            if (action == null) {
                action = "";
            }
            Intrinsics.checkNotNullExpressionValue(action, "it.action ?: \"\"");
            if (Intrinsics.areEqual((Object) action, (Object) "android.intent.action.HEADSET_PLUG")) {
                getHeadsetService().handleAction(action, intent);
            }
        }
    }
}
