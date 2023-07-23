package media.tiger.tigerbox.services.implementations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.BatterySummary;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.interfaces.BatteryChangesListener;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;

@Metadata(mo33736d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001&B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0017H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0017H\u0016R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/HardwareBatteryService;", "Lmedia/tiger/tigerbox/services/interfaces/BatteryService;", "context", "Landroid/content/Context;", "soundService", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "lightControlService", "Lmedia/tiger/tigerbox/services/interfaces/LightControlService;", "displayService", "Lmedia/tiger/tigerbox/services/implementations/DisplayService;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;Lmedia/tiger/tigerbox/services/interfaces/LightControlService;Lmedia/tiger/tigerbox/services/implementations/DisplayService;)V", "batteryStatusReceiver", "Landroid/content/BroadcastReceiver;", "getBatteryStatusReceiver", "()Landroid/content/BroadcastReceiver;", "batteryStatusReceiver$delegate", "Lkotlin/Lazy;", "didPlay20Sound", "", "didPlay5PercentBootSound", "didPlay5Sound", "listeners", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/services/interfaces/BatteryChangesListener;", "Lkotlin/collections/ArrayList;", "oldBatterySummary", "Lmedia/tiger/tigerbox/model/domain/BatterySummary;", "fetchBatteryStatus", "Landroid/content/Intent;", "getBatteryPercent", "", "isCharging", "isPlugged", "playBatteryBelow5PercentIfNeeded", "", "subscribeToBatteryChanges", "listener", "unsubscribeFromBatteryChanges", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HardwareBatteryService.kt */
public final class HardwareBatteryService implements BatteryService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int INVALID = -1;
    private static final int MAX_SCALE = 100;
    private final Lazy batteryStatusReceiver$delegate = LazyKt.lazy(new HardwareBatteryService$batteryStatusReceiver$2(this));
    private final Context context;
    /* access modifiers changed from: private */
    public boolean didPlay20Sound;
    private boolean didPlay5PercentBootSound;
    /* access modifiers changed from: private */
    public boolean didPlay5Sound;
    /* access modifiers changed from: private */
    public final DisplayService displayService;
    /* access modifiers changed from: private */
    public final LightControlService lightControlService;
    /* access modifiers changed from: private */
    public ArrayList<BatteryChangesListener> listeners = new ArrayList<>();
    /* access modifiers changed from: private */
    public BatterySummary oldBatterySummary = new BatterySummary(0.0f, false, false);
    /* access modifiers changed from: private */
    public final InfoSoundService soundService;

    public HardwareBatteryService(Context context2, InfoSoundService infoSoundService, LightControlService lightControlService2, DisplayService displayService2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(infoSoundService, "soundService");
        Intrinsics.checkNotNullParameter(lightControlService2, "lightControlService");
        Intrinsics.checkNotNullParameter(displayService2, "displayService");
        this.context = context2;
        this.soundService = infoSoundService;
        this.lightControlService = lightControlService2;
        this.displayService = displayService2;
        BroadcastReceiver batteryStatusReceiver = getBatteryStatusReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        Unit unit = Unit.INSTANCE;
        context2.registerReceiver(batteryStatusReceiver, intentFilter);
    }

    private final BroadcastReceiver getBatteryStatusReceiver() {
        return (BroadcastReceiver) this.batteryStatusReceiver$delegate.getValue();
    }

    private final Intent fetchBatteryStatus() {
        return this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public float getBatteryPercent() {
        Intent fetchBatteryStatus = fetchBatteryStatus();
        if (fetchBatteryStatus == null) {
            return -1.0f;
        }
        return ((float) (fetchBatteryStatus.getIntExtra("level", -1) * 100)) / ((float) fetchBatteryStatus.getIntExtra("scale", -1));
    }

    public boolean isCharging() {
        Intent fetchBatteryStatus = fetchBatteryStatus();
        int i = -1;
        if (fetchBatteryStatus != null) {
            i = fetchBatteryStatus.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        }
        return i == 2 || i == 5;
    }

    public boolean isPlugged() {
        Intent fetchBatteryStatus = fetchBatteryStatus();
        int i = -1;
        if (fetchBatteryStatus != null) {
            i = fetchBatteryStatus.getIntExtra("plugged", -1);
        }
        return i == 1 || i == 2 || i == 4;
    }

    public void subscribeToBatteryChanges(BatteryChangesListener batteryChangesListener) {
        Intrinsics.checkNotNullParameter(batteryChangesListener, "listener");
        if (!this.listeners.contains(batteryChangesListener)) {
            this.listeners.add(batteryChangesListener);
        }
    }

    public void unsubscribeFromBatteryChanges(BatteryChangesListener batteryChangesListener) {
        Intrinsics.checkNotNullParameter(batteryChangesListener, "listener");
        this.listeners.remove(batteryChangesListener);
    }

    public void playBatteryBelow5PercentIfNeeded() {
        if ((this.displayService.getCurrentState() != DisplayService.DisplayState.TIGERBOX_DISPLAY_OFF) && !this.didPlay5PercentBootSound && getBatteryPercent() <= 5.0f && !isPlugged()) {
            this.soundService.playSound(InfoSoundService.SoundType.LOW_BATTERY_5_SWITCH_ON);
            this.didPlay5PercentBootSound = true;
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/HardwareBatteryService$Companion;", "", "()V", "INVALID", "", "MAX_SCALE", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: HardwareBatteryService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
