package media.tiger.tigerbox.services.implementations.timersController;

import android.app.AlarmManager;
import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.Constants;
import media.tiger.tigerbox.services.implementations.PendingIntentFactory;
import media.tiger.tigerbox.services.implementations.timersController.WindowedLimits;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.timersController.WindowedLimitTimeListener;
import media.tiger.tigerbox.services.interfaces.timersController.WindowedLimitTimeService;
import p009j$.time.LocalTime;
import p009j$.time.format.DateTimeFormatter;
import p009j$.time.format.DateTimeParseException;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0015H\u0016J\u0018\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\"H\u0002J\u0010\u0010+\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0015H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/timersController/WindowedLimitTimer;", "Lmedia/tiger/tigerbox/services/interfaces/timersController/WindowedLimitTimeService;", "context", "Landroid/content/Context;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "alarmManager", "Landroid/app/AlarmManager;", "intentFactory", "Lmedia/tiger/tigerbox/services/implementations/PendingIntentFactory;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/TimeService;Landroid/app/AlarmManager;Lmedia/tiger/tigerbox/services/implementations/PendingIntentFactory;)V", "getContext", "()Landroid/content/Context;", "getStorageService", "()Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "getTimeService", "()Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "windowedLimitListenerSubscribers", "", "Lmedia/tiger/tigerbox/services/interfaces/timersController/WindowedLimitTimeListener;", "checkIsInThePast", "", "calendar", "Ljava/util/Calendar;", "checkSingleLimit", "currentTime", "Ljava/time/LocalTime;", "windowedStart", "", "windowedEnd", "checkWindowedLimit", "initiate", "", "notify", "isInWindowLimit", "registerWindowLimitListener", "listener", "setAlarm", "time", "intentAction", "setupAlarms", "unregisterWindowLimitListener", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WindowedLimitTimer.kt */
public final class WindowedLimitTimer implements WindowedLimitTimeService {
    private final AlarmManager alarmManager;
    private final Context context;
    private final PendingIntentFactory intentFactory;
    private final StorageService storageService;
    private final TimeService timeService;
    private List<WindowedLimitTimeListener> windowedLimitListenerSubscribers;

    public WindowedLimitTimer(Context context2, StorageService storageService2, TimeService timeService2, AlarmManager alarmManager2, PendingIntentFactory pendingIntentFactory) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(timeService2, "timeService");
        Intrinsics.checkNotNullParameter(alarmManager2, "alarmManager");
        Intrinsics.checkNotNullParameter(pendingIntentFactory, "intentFactory");
        this.context = context2;
        this.storageService = storageService2;
        this.timeService = timeService2;
        this.alarmManager = alarmManager2;
        this.intentFactory = pendingIntentFactory;
        this.windowedLimitListenerSubscribers = new ArrayList();
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WindowedLimitTimer(Context context2, StorageService storageService2, TimeService timeService2, AlarmManager alarmManager2, PendingIntentFactory pendingIntentFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, storageService2, timeService2, alarmManager2, (i & 16) != 0 ? WindowedLimitPendingIntentFactory.INSTANCE : pendingIntentFactory);
    }

    public void initiate() {
        setupAlarms();
        notify(checkWindowedLimit());
    }

    private final void setupAlarms() {
        int i = 0;
        for (Object next : this.storageService.getWindowedLimit().getLimits()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            WindowedLimits.WindowedLimit windowedLimit = (WindowedLimits.WindowedLimit) next;
            if (windowedLimit.isValid()) {
                String windowStart = windowedLimit.getWindowStart();
                setAlarm(windowStart, "alarmStart" + i);
                String windowEnd = windowedLimit.getWindowEnd();
                setAlarm(windowEnd, "alarmEnd" + i);
            }
            i = i2;
        }
    }

    private final void setAlarm(String str, String str2) {
        try {
            LocalTime parse = LocalTime.parse(str, DateTimeFormatter.ISO_LOCAL_TIME);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(time, DateTimeFormatter.ISO_LOCAL_TIME)");
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.timeService.getCurrentSystemTimeMillis());
            instance.set(11, parse.getHour());
            instance.set(12, parse.getMinute());
            instance.set(13, 0);
            instance.set(14, 0);
            Intrinsics.checkNotNullExpressionValue(instance, "alarmCalendar");
            if (checkIsInThePast(instance)) {
                instance.add(5, 1);
            }
            this.alarmManager.setExact(0, instance.getTimeInMillis(), this.intentFactory.makePendingIntent(this.context, str2));
        } catch (DateTimeParseException e) {
            Timber.Forest.tag("WindowedLimitTimer").mo50218e(e);
        }
    }

    private final boolean checkIsInThePast(Calendar calendar) {
        return this.timeService.getCurrentSystemTimeMillis() >= calendar.getTimeInMillis();
    }

    private final boolean checkSingleLimit(LocalTime localTime, String str, String str2) {
        if (!(str.length() == 0)) {
            if (!(str2.length() == 0)) {
                try {
                    LocalTime parse = LocalTime.parse(str, DateTimeFormatter.ISO_LOCAL_TIME);
                    LocalTime parse2 = LocalTime.parse(str2, DateTimeFormatter.ISO_LOCAL_TIME);
                    if (!localTime.isAfter(parse) || !localTime.isBefore(parse2)) {
                        return false;
                    }
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWindowedLimit() {
        List<WindowedLimits.WindowedLimit> limits = this.storageService.getWindowedLimit().getLimits();
        if (limits.isEmpty()) {
            return true;
        }
        LocalTime parse = LocalTime.parse(this.timeService.getCurrentTime(), DateTimeFormatter.ofPattern(Constants.TIME_DATE_FORMAT));
        Iterator it = limits.iterator();
        while (true) {
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                WindowedLimits.WindowedLimit windowedLimit = (WindowedLimits.WindowedLimit) it.next();
                if (!z) {
                    Intrinsics.checkNotNullExpressionValue(parse, "currentTime");
                    if (checkSingleLimit(parse, windowedLimit.getWindowStart(), windowedLimit.getWindowEnd())) {
                    }
                }
                z = true;
            }
        }
    }

    private final void notify(boolean z) {
        for (WindowedLimitTimeListener onWindowedLimitCheck : this.windowedLimitListenerSubscribers) {
            onWindowedLimitCheck.onWindowedLimitCheck(z);
        }
    }

    public void registerWindowLimitListener(WindowedLimitTimeListener windowedLimitTimeListener) {
        Intrinsics.checkNotNullParameter(windowedLimitTimeListener, "listener");
        if (!this.windowedLimitListenerSubscribers.contains(windowedLimitTimeListener)) {
            this.windowedLimitListenerSubscribers.add(windowedLimitTimeListener);
        }
    }

    public void unregisterWindowLimitListener(WindowedLimitTimeListener windowedLimitTimeListener) {
        Intrinsics.checkNotNullParameter(windowedLimitTimeListener, "listener");
        this.windowedLimitListenerSubscribers.remove(windowedLimitTimeListener);
    }
}
