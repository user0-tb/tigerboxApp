package media.tiger.tigerbox.services.interfaces.timersController;

import kotlin.Metadata;
import media.tiger.tigerbox.services.implementations.timersController.LockedModeReason;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitListener;", "", "onLockModeChanged", "", "newValue", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeReason;", "onTimeLimitTick", "remainingSeconds", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TimeLimitTimerService.kt */
public interface TimeLimitListener {
    void onLockModeChanged(LockedModeReason lockedModeReason);

    void onTimeLimitTick(int i);
}
