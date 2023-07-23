package media.tiger.tigerbox.services.implementations;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.UpdateCheckTimerService;
import p009j$.time.LocalTime;
import p009j$.time.format.DateTimeFormatter;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/UpdateCheckTimer;", "Lmedia/tiger/tigerbox/services/interfaces/UpdateCheckTimerService;", "context", "Landroid/content/Context;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "alarmManager", "Landroid/app/AlarmManager;", "firmwareUpdateService", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "intentFactory", "Lmedia/tiger/tigerbox/services/implementations/PendingIntentFactory;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/services/interfaces/TimeService;Landroid/app/AlarmManager;Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;Lmedia/tiger/tigerbox/services/implementations/PendingIntentFactory;)V", "cancelCheckUpdateAlarm", "", "handleAction", "action", "", "intent", "Landroid/content/Intent;", "handleAction$app_tigerBoxRelease", "resetAlarm", "setRepeatingCheckUpdateAlarm", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: UpdateCheckTimer.kt */
public final class UpdateCheckTimer implements UpdateCheckTimerService {
    public static final String CHECK_UPDATE_TIMER = "CHECK_UPDATE_TIMER";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TIMEZONE = "UTC";
    private final AlarmManager alarmManager;
    private final ConfigurationProperties configurationProperties;
    private final Context context;
    private final FirmwareUpdateService firmwareUpdateService;
    private final PendingIntentFactory intentFactory;
    private final TimeService timeService;

    public UpdateCheckTimer(Context context2, TimeService timeService2, AlarmManager alarmManager2, FirmwareUpdateService firmwareUpdateService2, ConfigurationProperties configurationProperties2, PendingIntentFactory pendingIntentFactory) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(timeService2, "timeService");
        Intrinsics.checkNotNullParameter(alarmManager2, "alarmManager");
        Intrinsics.checkNotNullParameter(firmwareUpdateService2, "firmwareUpdateService");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        Intrinsics.checkNotNullParameter(pendingIntentFactory, "intentFactory");
        this.context = context2;
        this.timeService = timeService2;
        this.alarmManager = alarmManager2;
        this.firmwareUpdateService = firmwareUpdateService2;
        this.configurationProperties = configurationProperties2;
        this.intentFactory = pendingIntentFactory;
        UpdateCheckTimerReceiver.Companion.setCheckUpdateTimer(this);
        setRepeatingCheckUpdateAlarm();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UpdateCheckTimer(Context context2, TimeService timeService2, AlarmManager alarmManager2, FirmwareUpdateService firmwareUpdateService2, ConfigurationProperties configurationProperties2, PendingIntentFactory pendingIntentFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, timeService2, alarmManager2, firmwareUpdateService2, configurationProperties2, (i & 32) != 0 ? UpdateCheckTimerAndroidPendingIntentFactory.INSTANCE : pendingIntentFactory);
    }

    public final void handleAction$app_tigerBoxRelease(String str, Intent intent) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("UpdateCheckTimer " + str + " intent " + intent, new Object[0]);
        if (Intrinsics.areEqual((Object) str, (Object) CHECK_UPDATE_TIMER)) {
            Timber.Forest.mo50221i("Firmware update check timer - will check for updates", new Object[0]);
            this.firmwareUpdateService.checkForUpdate(FirmwareUpdateService.CheckReason.AUTOMATIC);
        }
    }

    public void resetAlarm() {
        setRepeatingCheckUpdateAlarm();
    }

    private final void setRepeatingCheckUpdateAlarm() {
        cancelCheckUpdateAlarm();
        LocalTime parse = LocalTime.parse(this.configurationProperties.getProperty("firmware.update.checker.time"), DateTimeFormatter.ISO_LOCAL_TIME);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.timeService.getCurrentSystemTimeMillis());
        instance.set(11, parse.getHour());
        instance.set(12, parse.getMinute());
        instance.set(13, parse.getSecond());
        instance.set(14, 0);
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("UpdateCheckTimer set to " + parse.getHour() + ':' + parse.getMinute() + ':' + parse.getSecond(), new Object[0]);
        Timber.Forest forest2 = Timber.Forest;
        StringBuilder sb = new StringBuilder();
        sb.append("timeService.currentSystemTimeMillis: ");
        sb.append(this.timeService.getCurrentSystemTimeMillis());
        forest2.mo50221i(sb.toString(), new Object[0]);
        Timber.Forest forest3 = Timber.Forest;
        forest3.mo50221i("alarmCalendar.timeInMillis: " + instance.getTimeInMillis(), new Object[0]);
        this.alarmManager.setInexactRepeating(0, instance.getTimeInMillis(), 86400000, this.intentFactory.makePendingIntent(this.context, CHECK_UPDATE_TIMER));
    }

    private final void cancelCheckUpdateAlarm() {
        this.alarmManager.cancel(this.intentFactory.makePendingIntent(this.context, CHECK_UPDATE_TIMER));
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/UpdateCheckTimer$Companion;", "", "()V", "CHECK_UPDATE_TIMER", "", "TIMEZONE", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: UpdateCheckTimer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
