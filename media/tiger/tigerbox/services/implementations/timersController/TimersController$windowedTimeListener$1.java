package media.tiger.tigerbox.services.implementations.timersController;

import kotlin.Metadata;
import media.tiger.tigerbox.services.interfaces.timersController.WindowedLimitTimeListener;

@Metadata(mo33736d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/timersController/TimersController$windowedTimeListener$1", "Lmedia/tiger/tigerbox/services/interfaces/timersController/WindowedLimitTimeListener;", "onWindowedLimitCheck", "", "isInWindowedLimit", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TimersController.kt */
public final class TimersController$windowedTimeListener$1 implements WindowedLimitTimeListener {
    final /* synthetic */ TimersController this$0;

    TimersController$windowedTimeListener$1(TimersController timersController) {
        this.this$0 = timersController;
    }

    public void onWindowedLimitCheck(boolean z) {
        if (z) {
            if (this.this$0.timeLimitTimer.checkLimit()) {
                this.this$0.disableLockMode();
            }
        } else if (!this.this$0.timeLimitTimer.checkLimit()) {
            this.this$0.enableLockMode(LockedModeReason.USAGE_LIMIT);
        } else {
            this.this$0.enableLockMode(LockedModeReason.WINDOWED_LIMIT);
        }
    }
}
