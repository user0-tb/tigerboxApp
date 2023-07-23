package media.tiger.tigerbox.services.implementations.receiver;

import android.content.Context;
import android.content.Intent;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/receiver/DateChangeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "limitTimer", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "getLimitTimer", "()Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "setLimitTimer", "(Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* compiled from: DateChangeBroadcastReceiver.kt */
public final class DateChangeBroadcastReceiver extends Hilt_DateChangeBroadcastReceiver {
    @Inject
    public TimersControllerService limitTimer;

    public final TimersControllerService getLimitTimer() {
        TimersControllerService timersControllerService = this.limitTimer;
        if (timersControllerService != null) {
            return timersControllerService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("limitTimer");
        return null;
    }

    public final void setLimitTimer(TimersControllerService timersControllerService) {
        Intrinsics.checkNotNullParameter(timersControllerService, "<set-?>");
        this.limitTimer = timersControllerService;
    }

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        getLimitTimer().initiateTimedLimit();
    }
}
