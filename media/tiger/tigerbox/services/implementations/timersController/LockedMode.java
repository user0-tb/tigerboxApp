package media.tiger.tigerbox.services.implementations.timersController;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.timersController.LockedModeService;
import media.tiger.tigerbox.services.interfaces.timersController.TimeLimitTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.WindowedLimitTimeService;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/timersController/LockedMode;", "Lmedia/tiger/tigerbox/services/interfaces/timersController/LockedModeService;", "timeLimit", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitTimerService;", "windowedLimit", "Lmedia/tiger/tigerbox/services/interfaces/timersController/WindowedLimitTimeService;", "(Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitTimerService;Lmedia/tiger/tigerbox/services/interfaces/timersController/WindowedLimitTimeService;)V", "checkLockedMode", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeReason;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: LockedMode.kt */
public final class LockedMode implements LockedModeService {
    private final TimeLimitTimerService timeLimit;
    private final WindowedLimitTimeService windowedLimit;

    public LockedMode(TimeLimitTimerService timeLimitTimerService, WindowedLimitTimeService windowedLimitTimeService) {
        Intrinsics.checkNotNullParameter(timeLimitTimerService, "timeLimit");
        Intrinsics.checkNotNullParameter(windowedLimitTimeService, "windowedLimit");
        this.timeLimit = timeLimitTimerService;
        this.windowedLimit = windowedLimitTimeService;
    }

    public LockedModeReason checkLockedMode() {
        if (!this.windowedLimit.checkWindowedLimit()) {
            return LockedModeReason.WINDOWED_LIMIT;
        }
        if (!this.timeLimit.checkLimit()) {
            return LockedModeReason.USAGE_LIMIT;
        }
        return LockedModeReason.NONE;
    }
}
