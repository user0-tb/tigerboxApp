package media.tiger.tigerbox.services.implementations;

import android.net.wifi.WifiConfiguration;
import android.os.CountDownTimer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.services.interfaces.WifiService;

@Metadata(mo33736d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/HardwareWifiService$startConnectionTimeoutTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HardwareWifiService.kt */
public final class HardwareWifiService$startConnectionTimeoutTimer$1 extends CountDownTimer {
    final /* synthetic */ HardwareWifiService this$0;

    public void onTick(long j) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HardwareWifiService$startConnectionTimeoutTimer$1(HardwareWifiService hardwareWifiService) {
        super(25000, 1000);
        this.this$0 = hardwareWifiService;
    }

    public void onFinish() {
        Object obj;
        String str;
        List<WifiConfiguration> configuredNetworks = this.this$0.wifiManager.getConfiguredNetworks();
        if (configuredNetworks != null) {
            HardwareWifiService hardwareWifiService = this.this$0;
            Iterator it = configuredNetworks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                WifiConfiguration wifiConfiguration = (WifiConfiguration) obj;
                StringBuilder sb = new StringBuilder();
                sb.append(Typography.quote);
                WifiItem access$getCurrentConnectingWifiItem$p = hardwareWifiService.currentConnectingWifiItem;
                if (access$getCurrentConnectingWifiItem$p == null || (str = access$getCurrentConnectingWifiItem$p.getSsid()) == null) {
                    str = "";
                }
                sb.append(str);
                sb.append(Typography.quote);
                if (Intrinsics.areEqual((Object) sb.toString(), (Object) wifiConfiguration.SSID)) {
                    break;
                }
            }
            WifiConfiguration wifiConfiguration2 = (WifiConfiguration) obj;
            if (wifiConfiguration2 != null) {
                hardwareWifiService.wifiManager.removeNetwork(wifiConfiguration2.networkId);
                hardwareWifiService.wifiManager.saveConfiguration();
                hardwareWifiService.log("Network configuration for [" + wifiConfiguration2.SSID + "] removed, timeout");
            }
        }
        this.this$0.connectionFail(WifiService.FailReason.OTHER);
    }
}
