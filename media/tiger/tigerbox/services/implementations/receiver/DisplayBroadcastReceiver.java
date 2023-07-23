package media.tiger.tigerbox.services.implementations.receiver;

import android.content.Context;
import android.content.Intent;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.implementations.DisplayService;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/receiver/DisplayBroadcastReceiver;", "Lmedia/tiger/tigerbox/infrastructure/di/InjectableBroadcastReceiver;", "()V", "displayService", "Lmedia/tiger/tigerbox/services/implementations/DisplayService;", "getDisplayService", "()Lmedia/tiger/tigerbox/services/implementations/DisplayService;", "setDisplayService", "(Lmedia/tiger/tigerbox/services/implementations/DisplayService;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* compiled from: DisplayBroadcastReceiver.kt */
public final class DisplayBroadcastReceiver extends Hilt_DisplayBroadcastReceiver {
    @Inject
    public DisplayService displayService;

    public final DisplayService getDisplayService() {
        DisplayService displayService2 = this.displayService;
        if (displayService2 != null) {
            return displayService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("displayService");
        return null;
    }

    public final void setDisplayService(DisplayService displayService2) {
        Intrinsics.checkNotNullParameter(displayService2, "<set-?>");
        this.displayService = displayService2;
    }

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent != null) {
            String action = intent.getAction();
            if (action == null) {
                action = "";
            }
            Intrinsics.checkNotNullExpressionValue(action, "it.action ?: \"\"");
            switch (action.hashCode()) {
                case -2128145023:
                    if (!action.equals("android.intent.action.SCREEN_OFF")) {
                        return;
                    }
                    break;
                case -1754776619:
                    if (!action.equals(DisplayService.ACTION_SCREEN_DIMS)) {
                        return;
                    }
                    break;
                case -1454123155:
                    if (!action.equals("android.intent.action.SCREEN_ON")) {
                        return;
                    }
                    break;
                case 1819692659:
                    if (!action.equals(DisplayService.SCREEN_DIMS_STATUS)) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            getDisplayService().handleAction(action, intent);
        }
    }
}
