package media.tiger.tigerbox.services.implementations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.BatterySummary;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.interfaces.BatteryChangesListener;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.TigerButtonLightEvent;
import media.tiger.tigerbox.services.interfaces.TigerButtonLightEventKt;
import okhttp3.internal._UtilJvmKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo33737d2 = {"<anonymous>", "media/tiger/tigerbox/services/implementations/HardwareBatteryService$batteryStatusReceiver$2$1", "invoke", "()Lmedia/tiger/tigerbox/services/implementations/HardwareBatteryService$batteryStatusReceiver$2$1;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HardwareBatteryService.kt */
final class HardwareBatteryService$batteryStatusReceiver$2 extends Lambda implements Function0<C28781> {
    final /* synthetic */ HardwareBatteryService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HardwareBatteryService$batteryStatusReceiver$2(HardwareBatteryService hardwareBatteryService) {
        super(0);
        this.this$0 = hardwareBatteryService;
    }

    public final C28781 invoke() {
        final HardwareBatteryService hardwareBatteryService = this.this$0;
        return new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                List<BatteryChangesListener> immutableList = _UtilJvmKt.toImmutableList(hardwareBatteryService.listeners);
                String action = intent.getAction();
                if (action != null) {
                    int hashCode = action.hashCode();
                    if (hashCode != -1538406691) {
                        if (hashCode == 1019184907 && action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            for (BatteryChangesListener onCablePluggedIn : immutableList) {
                                onCablePluggedIn.onCablePluggedIn();
                            }
                        }
                    } else if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                        BatterySummary batterySummary = new BatterySummary(hardwareBatteryService.getBatteryPercent(), hardwareBatteryService.isCharging(), hardwareBatteryService.isPlugged());
                        if (!Intrinsics.areEqual((Object) hardwareBatteryService.oldBatterySummary, (Object) batterySummary)) {
                            hardwareBatteryService.oldBatterySummary = batterySummary;
                            for (BatteryChangesListener onStatusChanged : immutableList) {
                                onStatusChanged.onStatusChanged(batterySummary);
                            }
                            hardwareBatteryService.lightControlService.removeTigerButtonLightEvents(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.BATTERY_BETWEEN_5_10) | TigerButtonLightEventKt.toBit(TigerButtonLightEvent.BATTERY_UNDER_5) | TigerButtonLightEventKt.toBit(TigerButtonLightEvent.BATTERY_FULL_PLUGGED));
                            if (batterySummary.getBatteryPercent() < 5.0f && !hardwareBatteryService.isPlugged()) {
                                hardwareBatteryService.lightControlService.addTigerButtonLightEvents(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.BATTERY_UNDER_5));
                            } else if (batterySummary.getBatteryPercent() >= 5.0f && batterySummary.getBatteryPercent() < 11.0f && !hardwareBatteryService.isPlugged()) {
                                hardwareBatteryService.lightControlService.addTigerButtonLightEvents(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.BATTERY_BETWEEN_5_10));
                            } else if (batterySummary.getBatteryPercent() > 99.0f && hardwareBatteryService.isPlugged()) {
                                hardwareBatteryService.lightControlService.addTigerButtonLightEvents(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.BATTERY_FULL_PLUGGED));
                            }
                            boolean z = hardwareBatteryService.displayService.getCurrentState() != DisplayService.DisplayState.TIGERBOX_DISPLAY_OFF;
                            Timber.Forest forest = Timber.Forest;
                            forest.mo50221i("Battery changed " + batterySummary.getBatteryPercent() + " didPlay20Sound: " + hardwareBatteryService.didPlay20Sound + " didPlay5Sound " + hardwareBatteryService.didPlay5Sound + " isPlugged: " + hardwareBatteryService.isPlugged() + " screenIsOn: " + z, new Object[0]);
                            if (z) {
                                if (!hardwareBatteryService.didPlay20Sound && batterySummary.getBatteryPercent() > 5.0f && batterySummary.getBatteryPercent() <= 20.0f && !hardwareBatteryService.isPlugged()) {
                                    hardwareBatteryService.soundService.playSound(InfoSoundService.SoundType.LOW_BATTERY_20);
                                    hardwareBatteryService.didPlay20Sound = true;
                                }
                                if (!hardwareBatteryService.didPlay5Sound && batterySummary.getBatteryPercent() <= 5.0f && !hardwareBatteryService.isPlugged()) {
                                    hardwareBatteryService.soundService.playSound(InfoSoundService.SoundType.LOW_BATTERY_5);
                                    hardwareBatteryService.didPlay5Sound = true;
                                }
                            }
                        }
                    }
                }
            }
        };
    }
}
