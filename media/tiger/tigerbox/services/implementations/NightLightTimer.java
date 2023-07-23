package media.tiger.tigerbox.services.implementations;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.NightLightTimerService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.webserver.dto.NightLight;
import p009j$.util.DesugarTimeZone;

@Metadata(mo33736d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 /2\u00020\u0001:\u0001/B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015H\u0002J\u001d\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0000¢\u0006\u0002\b$J\b\u0010%\u001a\u00020\u001cH\u0007J\b\u0010&\u001a\u00020\u001cH\u0007J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0010H\u0002J\u001a\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010+\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\u0012\u0010-\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0012\u0010\u0013¨\u00060"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/NightLightTimer;", "Lmedia/tiger/tigerbox/services/interfaces/NightLightTimerService;", "context", "Landroid/content/Context;", "lightControl", "Lmedia/tiger/tigerbox/services/interfaces/LightControlService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "alarmManager", "Landroid/app/AlarmManager;", "intentFactory", "Lmedia/tiger/tigerbox/services/implementations/PendingIntentFactory;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/services/interfaces/LightControlService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/TimeService;Landroid/app/AlarmManager;Lmedia/tiger/tigerbox/services/implementations/PendingIntentFactory;)V", "value", "Lmedia/tiger/tigerbox/webserver/dto/NightLight;", "timerInfo", "setTimerInfo", "(Lmedia/tiger/tigerbox/webserver/dto/NightLight;)V", "calendarAtNextFutureTime", "Ljava/util/Calendar;", "date", "Ljava/util/Date;", "calendarFromString", "str", "", "cancelAlarm", "", "action", "checkIsInThePast", "", "calendar", "handleAction", "intent", "Landroid/content/Intent;", "handleAction$app_tigerBoxRelease", "handleIntentLightOff", "handleIntentLightOn", "handleNightLightTimers", "info", "prepareAlarm", "timeStr", "setAlarm", "updateNightLightInfo", "updateNightLightTimer", "updatedNightLight", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: NightLightTimer.kt */
public final class NightLightTimer implements NightLightTimerService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NIGHT_LIGHT_OFF = "NIGHT_LIGHT_TIMER_OFF";
    public static final String NIGHT_LIGHT_ON = "NIGHT_LIGHT_TIMER_ON";
    private static final String TIMEZONE = "UTC";
    private final AlarmManager alarmManager;
    private final Context context;
    private final PendingIntentFactory intentFactory;
    private final LightControlService lightControl;
    private final StorageService storageService;
    private final TimeService timeService;
    private NightLight timerInfo;

    public NightLightTimer(Context context2, LightControlService lightControlService, StorageService storageService2, TimeService timeService2, AlarmManager alarmManager2, PendingIntentFactory pendingIntentFactory) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(lightControlService, "lightControl");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(timeService2, "timeService");
        Intrinsics.checkNotNullParameter(alarmManager2, "alarmManager");
        Intrinsics.checkNotNullParameter(pendingIntentFactory, "intentFactory");
        this.context = context2;
        this.lightControl = lightControlService;
        this.storageService = storageService2;
        this.timeService = timeService2;
        this.alarmManager = alarmManager2;
        this.intentFactory = pendingIntentFactory;
        NightLightTimerReceiver.Companion.setNightLightTimer(this);
        setTimerInfo(storageService2.getNightLightTimer());
        NightLight nightLight = this.timerInfo;
        if (nightLight != null) {
            handleNightLightTimers(nightLight);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NightLightTimer(Context context2, LightControlService lightControlService, StorageService storageService2, TimeService timeService2, AlarmManager alarmManager2, PendingIntentFactory pendingIntentFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, lightControlService, storageService2, timeService2, alarmManager2, (i & 32) != 0 ? AndroidPendingIntentFactory.INSTANCE : pendingIntentFactory);
    }

    private final void setTimerInfo(NightLight nightLight) {
        this.timerInfo = nightLight;
        this.storageService.saveNightLightTimer(nightLight);
    }

    public final void handleAction$app_tigerBoxRelease(String str, Intent intent) {
        Integer intensity;
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual((Object) str, (Object) NIGHT_LIGHT_OFF)) {
            this.lightControl.setTigerLightEnabled(false);
            updateNightLightInfo();
        } else if (Intrinsics.areEqual((Object) str, (Object) NIGHT_LIGHT_ON)) {
            this.lightControl.setTigerLightEnabled(true);
            NightLight nightLight = this.timerInfo;
            if (!(nightLight == null || (intensity = nightLight.getIntensity()) == null)) {
                this.lightControl.setTigerLightIntensity(intensity.intValue());
            }
            updateNightLightInfo();
        }
    }

    private final boolean checkIsInThePast(Calendar calendar) {
        return this.timeService.getCurrentSystemTimeMillis() >= calendar.getTimeInMillis();
    }

    private final void updateNightLightInfo() {
        NightLight nightLight = this.timerInfo;
        if (nightLight != null) {
            Intrinsics.checkNotNull(nightLight);
            boolean z = true;
            boolean z2 = nightLight.getEnableTime() == null;
            NightLight nightLight2 = this.timerInfo;
            Intrinsics.checkNotNull(nightLight2);
            boolean z3 = nightLight2.getDisableTime() == null;
            NightLight nightLight3 = this.timerInfo;
            Intrinsics.checkNotNull(nightLight3);
            Boolean repeate = nightLight3.getRepeate();
            if (repeate != null && !repeate.booleanValue()) {
                NightLight nightLight4 = this.timerInfo;
                Intrinsics.checkNotNull(nightLight4);
                String enableTime = nightLight4.getEnableTime();
                if (enableTime != null && checkIsInThePast(calendarFromString(enableTime))) {
                    NightLight nightLight5 = this.timerInfo;
                    Intrinsics.checkNotNull(nightLight5);
                    setTimerInfo(NightLight.copy$default(nightLight5, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, 61, (Object) null));
                    z2 = true;
                }
                NightLight nightLight6 = this.timerInfo;
                Intrinsics.checkNotNull(nightLight6);
                String disableTime = nightLight6.getDisableTime();
                if (disableTime != null) {
                    if (checkIsInThePast(calendarFromString(disableTime))) {
                        NightLight nightLight7 = this.timerInfo;
                        Intrinsics.checkNotNull(nightLight7);
                        setTimerInfo(NightLight.copy$default(nightLight7, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, 62, (Object) null));
                    } else {
                        z = z3;
                    }
                    z3 = z;
                }
                if (z2 && z3) {
                    NightLight nightLight8 = this.timerInfo;
                    Intrinsics.checkNotNull(nightLight8);
                    setTimerInfo(NightLight.copy$default(nightLight8, (String) null, (String) null, (Boolean) null, (Boolean) null, false, (Integer) null, 47, (Object) null));
                }
            }
            NightLight nightLight9 = this.timerInfo;
            Intrinsics.checkNotNull(nightLight9);
            handleNightLightTimers(nightLight9);
        }
    }

    public void updateNightLightTimer(NightLight nightLight) {
        NightLight nightLight2 = null;
        if ((nightLight != null ? nightLight.getDisableTime() : null) != null) {
            NightLight nightLight3 = this.timerInfo;
            setTimerInfo(nightLight3 != null ? NightLight.copy$default(nightLight3, nightLight.getDisableTime(), (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, 62, (Object) null) : null);
        }
        if ((nightLight != null ? nightLight.getEnableTime() : null) != null) {
            NightLight nightLight4 = this.timerInfo;
            setTimerInfo(nightLight4 != null ? NightLight.copy$default(nightLight4, (String) null, nightLight.getEnableTime(), (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, 61, (Object) null) : null);
        }
        if ((nightLight != null ? nightLight.getRepeate() : null) != null) {
            NightLight nightLight5 = this.timerInfo;
            setTimerInfo(nightLight5 != null ? NightLight.copy$default(nightLight5, (String) null, (String) null, nightLight.getRepeate(), (Boolean) null, (Boolean) null, (Integer) null, 59, (Object) null) : null);
        }
        if ((nightLight != null ? nightLight.getEnableTimer() : null) != null) {
            NightLight nightLight6 = this.timerInfo;
            setTimerInfo(nightLight6 != null ? NightLight.copy$default(nightLight6, (String) null, (String) null, (Boolean) null, nightLight.getEnableTimer(), (Boolean) null, (Integer) null, 55, (Object) null) : null);
        }
        if ((nightLight != null ? nightLight.getEnabled() : null) != null) {
            NightLight nightLight7 = this.timerInfo;
            setTimerInfo(nightLight7 != null ? NightLight.copy$default(nightLight7, (String) null, (String) null, (Boolean) null, (Boolean) null, nightLight.getEnabled(), (Integer) null, 47, (Object) null) : null);
        }
        if ((nightLight != null ? nightLight.getIntensity() : null) != null) {
            NightLight nightLight8 = this.timerInfo;
            if (nightLight8 != null) {
                nightLight2 = NightLight.copy$default(nightLight8, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, nightLight.getIntensity(), 31, (Object) null);
            }
            setTimerInfo(nightLight2);
        }
        NightLight nightLight9 = this.timerInfo;
        if (nightLight9 != null) {
            handleNightLightTimers(nightLight9);
        }
    }

    private final Calendar calendarAtNextFutureTime(Date date) {
        long currentSystemTimeMillis = this.timeService.getCurrentSystemTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(DesugarTimeZone.getTimeZone(TIMEZONE));
        instance.setTime(date);
        int i = instance.get(11);
        int i2 = instance.get(12);
        instance.set(13, 0);
        instance.set(14, 0);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeZone(DesugarTimeZone.getTimeZone(TIMEZONE));
        instance2.setTimeInMillis(currentSystemTimeMillis);
        Calendar instance3 = Calendar.getInstance();
        instance3.setTimeZone(DesugarTimeZone.getTimeZone(TIMEZONE));
        instance3.setTimeInMillis(currentSystemTimeMillis);
        instance3.set(11, i);
        instance3.set(12, i2);
        instance3.set(13, 0);
        instance3.set(14, 0);
        if (instance2.compareTo(instance3) >= 0) {
            instance3.add(5, 1);
        }
        Intrinsics.checkNotNullExpressionValue(instance3, "alarmCalendar");
        return instance3;
    }

    private final Calendar calendarFromString(String str) {
        return calendarAtNextFutureTime(this.timeService.parseUtcDateString(str));
    }

    private final void prepareAlarm(String str, String str2) {
        if (str != null) {
            setAlarm(calendarFromString(str), str2);
        }
    }

    private final void handleNightLightTimers(NightLight nightLight) {
        cancelAlarm(NIGHT_LIGHT_ON);
        cancelAlarm(NIGHT_LIGHT_OFF);
        boolean z = nightLight.getEnabled() != null && nightLight.getEnabled().booleanValue();
        if (nightLight.getEnableTime() != null && z) {
            prepareAlarm(nightLight.getEnableTime(), NIGHT_LIGHT_ON);
        }
        if (nightLight.getDisableTime() != null && z) {
            prepareAlarm(nightLight.getDisableTime(), NIGHT_LIGHT_OFF);
        }
    }

    private final void setAlarm(Calendar calendar, String str) {
        if (!checkIsInThePast(calendar)) {
            this.alarmManager.setTimeZone(TIMEZONE);
            this.alarmManager.setExact(0, calendar.getTimeInMillis(), this.intentFactory.makePendingIntent(this.context, str));
        }
    }

    private final void cancelAlarm(String str) {
        this.alarmManager.cancel(this.intentFactory.makePendingIntent(this.context, str));
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/NightLightTimer$Companion;", "", "()V", "NIGHT_LIGHT_OFF", "", "NIGHT_LIGHT_ON", "TIMEZONE", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NightLightTimer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void handleIntentLightOn() {
        handleAction$app_tigerBoxRelease(NIGHT_LIGHT_ON, new Intent());
    }

    public final void handleIntentLightOff() {
        handleAction$app_tigerBoxRelease(NIGHT_LIGHT_OFF, new Intent());
    }
}
