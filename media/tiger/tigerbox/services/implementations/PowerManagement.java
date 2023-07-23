package media.tiger.tigerbox.services.implementations;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.implementations.validators.ShouldEngageDeepSleep;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;

@Metadata(mo33736d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/PowerManagement;", "Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;", "context", "Landroid/content/Context;", "displayService", "Lmedia/tiger/tigerbox/services/implementations/DisplayService;", "batteryService", "Lmedia/tiger/tigerbox/services/interfaces/BatteryService;", "deepSleepTimerService", "Lmedia/tiger/tigerbox/services/implementations/DeepSleepTimerService;", "audioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/services/implementations/DisplayService;Lmedia/tiger/tigerbox/services/interfaces/BatteryService;Lmedia/tiger/tigerbox/services/implementations/DeepSleepTimerService;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;)V", "onError", "", "error", "(Lkotlin/Unit;)V", "onReceive", "event", "Lmedia/tiger/tigerbox/services/implementations/DisplayService$DisplayState;", "reboot", "setupScreenOffTimeout", "shutDown", "startListeningForPowerRelatedChanges", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PowerManagement.kt */
public final class PowerManagement implements PowerManagementService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int SCREEN_OFF_TIMEOUT_MILLI = 60000;
    private static final String SHUTDOWN_INTENT = "android.intent.action.ACTION_REQUEST_SHUTDOWN";
    private final AudioPlayerService audioPlayerService;
    private final BatteryService batteryService;
    private final Context context;
    private final DeepSleepTimerService deepSleepTimerService;
    private final DisplayService displayService;

    public void onError(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "error");
    }

    public PowerManagement(Context context2, DisplayService displayService2, BatteryService batteryService2, DeepSleepTimerService deepSleepTimerService2, AudioPlayerService audioPlayerService2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(displayService2, "displayService");
        Intrinsics.checkNotNullParameter(batteryService2, "batteryService");
        Intrinsics.checkNotNullParameter(deepSleepTimerService2, "deepSleepTimerService");
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        this.context = context2;
        this.displayService = displayService2;
        this.batteryService = batteryService2;
        this.deepSleepTimerService = deepSleepTimerService2;
        this.audioPlayerService = audioPlayerService2;
        setupScreenOffTimeout();
    }

    public void startListeningForPowerRelatedChanges() {
        this.displayService.subscribe(this);
    }

    public void onReceive(DisplayService.DisplayState displayState) {
        Intrinsics.checkNotNullParameter(displayState, NotificationCompat.CATEGORY_EVENT);
        if (ShouldEngageDeepSleep.INSTANCE.invoke(displayState, this.batteryService.isCharging(), (this.audioPlayerService.getState() == AudioPlaybackState.STOPPED || this.audioPlayerService.getState() == AudioPlaybackState.PAUSED) ? false : true)) {
            this.deepSleepTimerService.invoke();
        } else {
            this.deepSleepTimerService.stop();
        }
    }

    public void shutDown() {
        Intent intent = new Intent(SHUTDOWN_INTENT);
        intent.addFlags(268435456);
        this.context.startActivity(intent);
    }

    public void reboot() {
        Intent intent = new Intent("android.intent.action.REBOOT");
        intent.addFlags(268435456);
        this.context.startActivity(intent);
    }

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/PowerManagement$Companion;", "", "()V", "SCREEN_OFF_TIMEOUT_MILLI", "", "SHUTDOWN_INTENT", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: PowerManagement.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void setupScreenOffTimeout() {
        Settings.System.putInt(this.context.getContentResolver(), "screen_off_timeout", SCREEN_OFF_TIMEOUT_MILLI);
    }
}
