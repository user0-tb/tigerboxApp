package media.tiger.tigerbox.services.implementations.timersController;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.extension.TimeKt;
import media.tiger.tigerbox.infrastructure.Constants;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.implementations.receiver.DateChangeBroadcastReceiver;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.timersController.TimeLimitListener;
import media.tiger.tigerbox.services.interfaces.timersController.TimeLimitTimerService;
import p009j$.time.LocalDate;
import p009j$.time.LocalTime;
import p009j$.time.format.DateTimeFormatter;
import p009j$.time.format.DateTimeParseException;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020 H\u0016J\b\u0010&\u001a\u00020 H\u0002J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020$H\u0016J\b\u0010)\u001a\u00020 H\u0002J\b\u0010*\u001a\u00020 H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0016H\u0016J\u0010\u0010-\u001a\u00020 2\u0006\u0010(\u001a\u00020$H\u0002J\b\u0010.\u001a\u00020 H\u0002J\u0018\u0010/\u001a\u00020$2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020$H\u0016J\u0010\u00103\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0016H\u0016J\u0010\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\u0010H\u0016J\u0010\u00106\u001a\u00020$2\u0006\u00100\u001a\u000201H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00067"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimitTimer;", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitTimerService;", "context", "Landroid/content/Context;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "alarmManager", "Landroid/app/AlarmManager;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/TimeService;Landroid/app/AlarmManager;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "getContext", "()Landroid/content/Context;", "initialTimeLimitTimerSeconds", "", "remainingTimeLimitTimerSeconds", "getStorageService", "()Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "timeLimitListenerSubscribers", "", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitListener;", "getTimeService", "()Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "timer", "Landroid/os/CountDownTimer;", "getTimer", "()Landroid/os/CountDownTimer;", "setTimer", "(Landroid/os/CountDownTimer;)V", "changeLockedMode", "", "newValue", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeReason;", "checkLimit", "", "continueTimer", "goToLockScreen", "initiate", "shouldStartTimer", "notifyTick", "pauseTimer", "registerTimeLimitTimerListener", "listener", "resetTimerState", "startMidnightTimer", "startTimer", "timeLimit", "Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;", "reset", "unregisterTimeLimitTimerListener", "updateTimerRemainingSeconds", "usageSeconds", "validateTimeLimit", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TimeLimitTimer.kt */
public final class TimeLimitTimer implements TimeLimitTimerService {
    private final AlarmManager alarmManager;
    private final ConfigurationProperties configurationProperties;
    private final Context context;
    private int initialTimeLimitTimerSeconds;
    /* access modifiers changed from: private */
    public int remainingTimeLimitTimerSeconds;
    private final StorageService storageService;
    private List<TimeLimitListener> timeLimitListenerSubscribers = new ArrayList();
    private final TimeService timeService;
    private CountDownTimer timer;

    public TimeLimitTimer(Context context2, StorageService storageService2, TimeService timeService2, AlarmManager alarmManager2, ConfigurationProperties configurationProperties2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(timeService2, "timeService");
        Intrinsics.checkNotNullParameter(alarmManager2, "alarmManager");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        this.context = context2;
        this.storageService = storageService2;
        this.timeService = timeService2;
        this.alarmManager = alarmManager2;
        this.configurationProperties = configurationProperties2;
        this.initialTimeLimitTimerSeconds = storageService2.getTimeLimit().getInitialLimitSeconds();
        this.remainingTimeLimitTimerSeconds = storageService2.getTimeLimit().getRemainingSeconds();
    }

    public final Context getContext() {
        return this.context;
    }

    public final StorageService getStorageService() {
        return this.storageService;
    }

    public final TimeService getTimeService() {
        return this.timeService;
    }

    public final CountDownTimer getTimer() {
        return this.timer;
    }

    public final void setTimer(CountDownTimer countDownTimer) {
        this.timer = countDownTimer;
    }

    public void registerTimeLimitTimerListener(TimeLimitListener timeLimitListener) {
        Intrinsics.checkNotNullParameter(timeLimitListener, "listener");
        if (!this.timeLimitListenerSubscribers.contains(timeLimitListener)) {
            this.timeLimitListenerSubscribers.add(timeLimitListener);
        }
    }

    public void unregisterTimeLimitTimerListener(TimeLimitListener timeLimitListener) {
        Intrinsics.checkNotNullParameter(timeLimitListener, "listener");
        this.timeLimitListenerSubscribers.remove(timeLimitListener);
    }

    public boolean checkLimit() {
        return !this.storageService.getTimeLimit().isEnded();
    }

    public void initiate(boolean z) {
        startMidnightTimer();
        TimeLimit timeLimit = this.storageService.getTimeLimit();
        if (timeLimit.hasSetLimit()) {
            try {
                if (LocalDate.parse(timeLimit.getDateCreated(), DateTimeFormatter.ofPattern(Constants.TIME_DATE_FORMAT)).isBefore(LocalDate.parse(this.timeService.getCurrentTime(), DateTimeFormatter.ofPattern(Constants.TIME_DATE_FORMAT)))) {
                    resetTimerState(z);
                } else if (z) {
                    startTimer(timeLimit, false);
                }
            } catch (DateTimeParseException e) {
                Timber.Forest.tag("TimeLimitTimer").mo50218e(e);
            }
        }
    }

    private final void startMidnightTimer() {
        LocalTime parse = LocalTime.parse(this.configurationProperties.getProperty("locked.mode.timer.reset"), DateTimeFormatter.ISO_LOCAL_TIME);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.timeService.getCurrentSystemTimeMillis());
        instance.add(5, 1);
        instance.set(11, parse.getHour());
        instance.set(12, parse.getMinute());
        instance.set(13, 1);
        instance.set(14, 0);
        this.alarmManager.setExact(0, instance.getTimeInMillis(), PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, DateChangeBroadcastReceiver.class), 0));
    }

    private final boolean validateTimeLimit(TimeLimit timeLimit) {
        if (timeLimit.getInitialLimitSeconds() < 0) {
            changeLockedMode(LockedModeReason.NONE);
            return false;
        } else if (timeLimit.getRemainingSeconds() != 0) {
            changeLockedMode(LockedModeReason.NONE);
            return true;
        } else {
            goToLockScreen();
            return false;
        }
    }

    public boolean startTimer(TimeLimit timeLimit, boolean z) {
        Intrinsics.checkNotNullParameter(timeLimit, "timeLimit");
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        int max = Math.max(0, timeLimit.getInitialLimitSeconds() - Math.max(0, this.initialTimeLimitTimerSeconds - this.remainingTimeLimitTimerSeconds));
        this.storageService.setTimeLimit(timeLimit);
        this.initialTimeLimitTimerSeconds = timeLimit.getInitialLimitSeconds();
        this.remainingTimeLimitTimerSeconds = timeLimit.getRemainingSeconds();
        if (z) {
            max = timeLimit.getInitialLimitSeconds();
        }
        if (validateTimeLimit(timeLimit)) {
            CountDownTimer timeLimitTimer$startTimer$1 = new TimeLimitTimer$startTimer$1(this, TimeKt.secondsToMillis(max));
            this.timer = timeLimitTimer$startTimer$1;
            timeLimitTimer$startTimer$1.start();
            return true;
        }
        this.remainingTimeLimitTimerSeconds = 0;
        notifyTick();
        return false;
    }

    public void pauseTimer() {
        this.storageService.setTimeLimit(TimeLimit.copy$default(this.storageService.getTimeLimit(), (String) null, 0, this.remainingTimeLimitTimerSeconds, 3, (Object) null));
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void continueTimer() {
        startTimer(TimeLimit.copy$default(this.storageService.getTimeLimit(), (String) null, 0, this.remainingTimeLimitTimerSeconds, 3, (Object) null), false);
    }

    public void updateTimerRemainingSeconds(int i) {
        this.remainingTimeLimitTimerSeconds = i;
    }

    private final void resetTimerState(boolean z) {
        TimeLimit timeLimit = this.storageService.getTimeLimit();
        String currentTime = this.timeService.getCurrentTime();
        if (currentTime == null) {
            currentTime = "";
        }
        TimeLimit copy$default = TimeLimit.copy$default(timeLimit, currentTime, 0, timeLimit.getInitialLimitSeconds(), 2, (Object) null);
        this.storageService.setTimeLimit(copy$default);
        this.remainingTimeLimitTimerSeconds = timeLimit.getInitialLimitSeconds();
        if (z) {
            startTimer(copy$default, false);
        }
    }

    /* access modifiers changed from: private */
    public final void goToLockScreen() {
        StorageService storageService2 = this.storageService;
        TimeLimit timeLimit = storageService2.getTimeLimit();
        String currentTime = this.timeService.getCurrentTime();
        if (currentTime == null) {
            currentTime = "";
        }
        storageService2.setTimeLimit(TimeLimit.copy$default(timeLimit, currentTime, 0, 0, 2, (Object) null));
        this.remainingTimeLimitTimerSeconds = 0;
        notifyTick();
        changeLockedMode(LockedModeReason.USAGE_LIMIT);
    }

    private final void changeLockedMode(LockedModeReason lockedModeReason) {
        for (TimeLimitListener onLockModeChanged : this.timeLimitListenerSubscribers) {
            onLockModeChanged.onLockModeChanged(lockedModeReason);
        }
    }

    /* access modifiers changed from: private */
    public final void notifyTick() {
        for (TimeLimitListener onTimeLimitTick : this.timeLimitListenerSubscribers) {
            onTimeLimitTick.onTimeLimitTick(this.remainingTimeLimitTimerSeconds);
        }
    }
}
