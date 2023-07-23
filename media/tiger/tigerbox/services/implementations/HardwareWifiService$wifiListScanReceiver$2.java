package media.tiger.tigerbox.services.implementations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo33737d2 = {"<anonymous>", "media/tiger/tigerbox/services/implementations/HardwareWifiService$wifiListScanReceiver$2$1", "invoke", "()Lmedia/tiger/tigerbox/services/implementations/HardwareWifiService$wifiListScanReceiver$2$1;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HardwareWifiService.kt */
final class HardwareWifiService$wifiListScanReceiver$2 extends Lambda implements Function0<C28811> {
    final /* synthetic */ HardwareWifiService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HardwareWifiService$wifiListScanReceiver$2(HardwareWifiService hardwareWifiService) {
        super(0);
        this.this$0 = hardwareWifiService;
    }

    public final C28811 invoke() {
        final HardwareWifiService hardwareWifiService = this.this$0;
        return new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    hardwareWifiService.onWifiScanComplete();
                }
            }
        };
    }
}
