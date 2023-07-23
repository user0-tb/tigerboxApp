package media.tiger.tigerbox;

import android.content.Context;
import android.content.IntentFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.implementations.receiver.DisplayBroadcastReceiver;
import media.tiger.tigerbox.services.implementations.receiver.HeadsetBroadcastReceiver;
import media.tiger.tigerbox.services.implementations.receiver.NfcBroadcastReceiver;
import media.tiger.tigerbox.services.interfaces.NfcService;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/InitServices;", "", "context", "Landroid/content/Context;", "powerManagementService", "Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;)V", "invoke", "", "prepareDisplayListener", "prepareHeadsetListener", "prepareNfcListener", "preparePowerListenerService", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: InitServices.kt */
public final class InitServices {
    private final Context context;
    private final PowerManagementService powerManagementService;

    public InitServices(Context context2, PowerManagementService powerManagementService2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(powerManagementService2, "powerManagementService");
        this.context = context2;
        this.powerManagementService = powerManagementService2;
    }

    public final void invoke() {
        prepareHeadsetListener();
        preparePowerListenerService();
        prepareDisplayListener();
        prepareNfcListener();
    }

    private final void prepareHeadsetListener() {
        this.context.registerReceiver(new HeadsetBroadcastReceiver(), new IntentFilter("android.intent.action.HEADSET_PLUG"));
    }

    private final void prepareDisplayListener() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        Unit unit = Unit.INSTANCE;
        this.context.registerReceiver(new DisplayBroadcastReceiver(), intentFilter);
    }

    private final void prepareNfcListener() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NfcService.OLD_NFC_OUT);
        intentFilter.addAction(NfcService.NFC_IN);
        intentFilter.addAction(NfcService.NFC_OUT);
        intentFilter.addAction("android.nfc.action.NDEF_DISCOVERED");
        intentFilter.addAction("android.nfc.action.TECH_DISCOVERED");
        intentFilter.addAction("android.nfc.action.TAG_DISCOVERED");
        intentFilter.addAction(NfcBroadcastReceiver.NFC_TRIGGER_ERROR);
        Unit unit = Unit.INSTANCE;
        this.context.registerReceiver(new NfcBroadcastReceiver(), intentFilter);
    }

    private final void preparePowerListenerService() {
        this.powerManagementService.startListeningForPowerRelatedChanges();
    }
}
