package media.tiger.tigerbox.services.implementations.timersController;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimeLimitTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;
import media.tiger.tigerbox.services.interfaces.timersController.WindowedLimitTimeService;

@Metadata(mo33736d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u000f\u0012\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\rH\u0016J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0015H\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\rH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006)"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/timersController/TimersController;", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "timeLimitTimer", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitTimerService;", "windowedLimit", "Lmedia/tiger/tigerbox/services/interfaces/timersController/WindowedLimitTimeService;", "audioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "displayService", "Lmedia/tiger/tigerbox/services/implementations/DisplayService;", "(Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitTimerService;Lmedia/tiger/tigerbox/services/interfaces/timersController/WindowedLimitTimeService;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Lmedia/tiger/tigerbox/services/implementations/DisplayService;)V", "lockedModeListenerSubscribers", "", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeListener;", "timeLimitListener", "media/tiger/tigerbox/services/implementations/timersController/TimersController$timeLimitListener$1", "Lmedia/tiger/tigerbox/services/implementations/timersController/TimersController$timeLimitListener$1;", "windowedTimeListener", "media/tiger/tigerbox/services/implementations/timersController/TimersController$windowedTimeListener$1", "Lmedia/tiger/tigerbox/services/implementations/timersController/TimersController$windowedTimeListener$1;", "checkWindowedLimit", "", "continueTimedLimitTimer", "", "disableLockMode", "enableLockMode", "reason", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeReason;", "initiateTimedLimit", "initiateWindowedLimit", "notifyTick", "remainingSeconds", "", "pauseTimedLimitTimer", "registerLockedModeListener", "lockedModeListener", "startTimedLimitTimer", "timeLimit", "Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;", "reset", "unregisterLockedModeListener", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TimersController.kt */
public final class TimersController implements TimersControllerService {
    private final AudioPlayerService audioPlayerService;
    private final DisplayService displayService;
    private List<LockedModeListener> lockedModeListenerSubscribers = new ArrayList();
    private final TimersController$timeLimitListener$1 timeLimitListener = new TimersController$timeLimitListener$1(this);
    /* access modifiers changed from: private */
    public final TimeLimitTimerService timeLimitTimer;
    /* access modifiers changed from: private */
    public final WindowedLimitTimeService windowedLimit;
    private final TimersController$windowedTimeListener$1 windowedTimeListener = new TimersController$windowedTimeListener$1(this);

    public TimersController(TimeLimitTimerService timeLimitTimerService, WindowedLimitTimeService windowedLimitTimeService, AudioPlayerService audioPlayerService2, DisplayService displayService2) {
        Intrinsics.checkNotNullParameter(timeLimitTimerService, "timeLimitTimer");
        Intrinsics.checkNotNullParameter(windowedLimitTimeService, "windowedLimit");
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        Intrinsics.checkNotNullParameter(displayService2, "displayService");
        this.timeLimitTimer = timeLimitTimerService;
        this.windowedLimit = windowedLimitTimeService;
        this.audioPlayerService = audioPlayerService2;
        this.displayService = displayService2;
    }

    public void initiateTimedLimit() {
        boolean z = true;
        boolean z2 = this.displayService.getCurrentState() != DisplayService.DisplayState.TIGERBOX_DISPLAY_OFF;
        if (!this.windowedLimit.checkWindowedLimit() || !z2) {
            z = false;
        }
        this.timeLimitTimer.initiate(z);
    }

    private final boolean checkWindowedLimit() {
        return this.windowedLimit.checkWindowedLimit();
    }

    public void initiateWindowedLimit() {
        if (!checkWindowedLimit()) {
            this.timeLimitTimer.pauseTimer();
        } else {
            this.timeLimitTimer.continueTimer();
        }
        this.windowedLimit.initiate();
    }

    public void startTimedLimitTimer(TimeLimit timeLimit, boolean z) {
        Intrinsics.checkNotNullParameter(timeLimit, "timeLimit");
        this.timeLimitTimer.startTimer(timeLimit, z);
    }

    public void pauseTimedLimitTimer() {
        if (this.audioPlayerService.getState() != AudioPlaybackState.PLAYING) {
            this.timeLimitTimer.pauseTimer();
        }
    }

    public void continueTimedLimitTimer() {
        if (this.windowedLimit.checkWindowedLimit()) {
            this.timeLimitTimer.continueTimer();
        }
    }

    /* access modifiers changed from: private */
    public final void enableLockMode(LockedModeReason lockedModeReason) {
        for (LockedModeListener onEnableLockScreen : this.lockedModeListenerSubscribers) {
            onEnableLockScreen.onEnableLockScreen(lockedModeReason);
        }
    }

    /* access modifiers changed from: private */
    public final void disableLockMode() {
        for (LockedModeListener onDisableLockScreen : this.lockedModeListenerSubscribers) {
            onDisableLockScreen.onDisableLockScreen();
        }
    }

    /* access modifiers changed from: private */
    public final void notifyTick(int i) {
        for (LockedModeListener onTimeLimitTick : this.lockedModeListenerSubscribers) {
            onTimeLimitTick.onTimeLimitTick(i);
        }
    }

    public void registerLockedModeListener(LockedModeListener lockedModeListener) {
        Intrinsics.checkNotNullParameter(lockedModeListener, "lockedModeListener");
        if (!this.lockedModeListenerSubscribers.contains(lockedModeListener)) {
            this.lockedModeListenerSubscribers.add(lockedModeListener);
        }
        this.timeLimitTimer.registerTimeLimitTimerListener(this.timeLimitListener);
        this.windowedLimit.registerWindowLimitListener(this.windowedTimeListener);
    }

    public void unregisterLockedModeListener(LockedModeListener lockedModeListener) {
        Intrinsics.checkNotNullParameter(lockedModeListener, "lockedModeListener");
        this.lockedModeListenerSubscribers.remove(lockedModeListener);
        this.timeLimitTimer.unregisterTimeLimitTimerListener(this.timeLimitListener);
        this.windowedLimit.unregisterWindowLimitListener(this.windowedTimeListener);
    }
}
