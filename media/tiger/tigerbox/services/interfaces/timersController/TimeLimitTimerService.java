package media.tiger.tigerbox.services.interfaces.timersController;

import kotlin.Metadata;
import media.tiger.tigerbox.services.implementations.timersController.TimeLimit;

@Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitTimerService;", "", "checkLimit", "", "continueTimer", "", "initiate", "shouldStartTimer", "pauseTimer", "registerTimeLimitTimerListener", "listener", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitListener;", "startTimer", "timeLimit", "Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;", "reset", "unregisterTimeLimitTimerListener", "updateTimerRemainingSeconds", "usageSeconds", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TimeLimitTimerService.kt */
public interface TimeLimitTimerService {
    boolean checkLimit();

    void continueTimer();

    void initiate(boolean z);

    void pauseTimer();

    void registerTimeLimitTimerListener(TimeLimitListener timeLimitListener);

    boolean startTimer(TimeLimit timeLimit, boolean z);

    void unregisterTimeLimitTimerListener(TimeLimitListener timeLimitListener);

    void updateTimerRemainingSeconds(int i);
}
