package media.tiger.tigerbox.services.implementations.timersController;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.timersController.TimeLimitListener;

@Metadata(mo33736d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/timersController/TimersController$timeLimitListener$1", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitListener;", "onLockModeChanged", "", "newValue", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeReason;", "onTimeLimitTick", "remainingSeconds", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TimersController.kt */
public final class TimersController$timeLimitListener$1 implements TimeLimitListener {
    final /* synthetic */ TimersController this$0;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TimersController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LockedModeReason.values().length];
            iArr[LockedModeReason.NONE.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    TimersController$timeLimitListener$1(TimersController timersController) {
        this.this$0 = timersController;
    }

    public void onTimeLimitTick(int i) {
        this.this$0.notifyTick(i);
    }

    public void onLockModeChanged(LockedModeReason lockedModeReason) {
        Intrinsics.checkNotNullParameter(lockedModeReason, "newValue");
        if (!this.this$0.windowedLimit.checkWindowedLimit()) {
            return;
        }
        if (WhenMappings.$EnumSwitchMapping$0[lockedModeReason.ordinal()] == 1) {
            this.this$0.disableLockMode();
        } else {
            this.this$0.enableLockMode(LockedModeReason.USAGE_LIMIT);
        }
    }
}
