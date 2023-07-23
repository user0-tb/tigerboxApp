package media.tiger.tigerbox.services.implementations;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import media.tiger.tigerbox.model.domain.ConnectionState;
import media.tiger.tigerbox.model.domain.SecurityMode;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.model.domain.WifiStrength;
import media.tiger.tigerbox.services.implementations.HardwareWifiService;
import media.tiger.tigerbox.services.implementations.wifi.ConnectionCallback;
import media.tiger.tigerbox.services.interfaces.WifiService;

@Metadata(mo33736d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/HardwareWifiService$internetConnectionCallback$1", "Lmedia/tiger/tigerbox/services/implementations/wifi/ConnectionCallback;", "onConnectionLost", "", "onConnectionSuccess", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HardwareWifiService.kt */
public final class HardwareWifiService$internetConnectionCallback$1 implements ConnectionCallback {
    final /* synthetic */ HardwareWifiService this$0;

    HardwareWifiService$internetConnectionCallback$1(HardwareWifiService hardwareWifiService) {
        this.this$0 = hardwareWifiService;
    }

    public void onConnectionSuccess() {
        WifiService.ConnectionCallback connectionCallback;
        HardwareWifiService hardwareWifiService = this.this$0;
        hardwareWifiService.log("Connected to network: " + this.this$0.wifiManager.getConnectionInfo());
        this.this$0.disableOfflineMode();
        List access$getNetworkList$p = this.this$0.networkList;
        HardwareWifiService hardwareWifiService2 = this.this$0;
        synchronized (access$getNetworkList$p) {
            int i = 0;
            for (WifiItem wifiItem : hardwareWifiService2.networkList) {
                int i2 = i + 1;
                if (Intrinsics.areEqual((Object) Typography.quote + wifiItem.getSsid() + Typography.quote, (Object) hardwareWifiService2.wifiManager.getConnectionInfo().getSSID())) {
                    hardwareWifiService2.networkList.set(i, WifiItem.copy$default(wifiItem, (String) null, (String) null, (WifiStrength) null, (SecurityMode) null, ConnectionState.CONNECTED, false, 47, (Object) null));
                } else {
                    hardwareWifiService2.networkList.set(i, WifiItem.copy$default(wifiItem, (String) null, (String) null, (WifiStrength) null, (SecurityMode) null, ConnectionState.NOT_CONNECTED, false, 47, (Object) null));
                }
                i = i2;
            }
            Unit unit = Unit.INSTANCE;
        }
        this.this$0.stopConnectionTimeoutTimer();
        if (this.this$0.currentlyConnectedWifiItem() != null) {
            HardwareWifiService hardwareWifiService3 = this.this$0;
            HardwareWifiService.ConnectionPayload access$getConnectionPayload$p = hardwareWifiService3.connectionPayload;
            if (!(access$getConnectionPayload$p == null || (connectionCallback = access$getConnectionPayload$p.getConnectionCallback()) == null)) {
                connectionCallback.onSuccess();
            }
            hardwareWifiService3.connectionPayload = null;
            hardwareWifiService3.currentConnectingWifiItem = null;
        }
    }

    public void onConnectionLost() {
        this.this$0.log("Network connection lost");
        this.this$0.enableOfflineMode();
    }
}
