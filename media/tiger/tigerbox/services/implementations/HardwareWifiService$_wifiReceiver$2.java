package media.tiger.tigerbox.services.implementations;

import android.content.BroadcastReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo33737d2 = {"<anonymous>", "media/tiger/tigerbox/services/implementations/HardwareWifiService$_wifiReceiver$2$1", "invoke", "()Lmedia/tiger/tigerbox/services/implementations/HardwareWifiService$_wifiReceiver$2$1;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HardwareWifiService.kt */
final class HardwareWifiService$_wifiReceiver$2 extends Lambda implements Function0<C28801> {
    final /* synthetic */ HardwareWifiService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HardwareWifiService$_wifiReceiver$2(HardwareWifiService hardwareWifiService) {
        super(0);
        this.this$0 = hardwareWifiService;
    }

    public final C28801 invoke() {
        final HardwareWifiService hardwareWifiService = this.this$0;
        return new BroadcastReceiver() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: android.net.NetworkInfo$State} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.net.NetworkInfo$State} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.net.NetworkInfo$State} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.net.NetworkInfo$State} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: android.net.wifi.WifiConfiguration} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: android.net.NetworkInfo$State} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onReceive(android.content.Context r5, android.content.Intent r6) {
                /*
                    r4 = this;
                    if (r6 != 0) goto L_0x0003
                    return
                L_0x0003:
                    java.lang.String r5 = r6.getAction()
                    if (r5 == 0) goto L_0x014b
                    int r0 = r5.hashCode()
                    r1 = -385684331(0xffffffffe902ec95, float:-9.892349E24)
                    if (r0 == r1) goto L_0x0136
                    r1 = -343630553(0xffffffffeb849d27, float:-3.2064068E26)
                    r2 = 0
                    if (r0 == r1) goto L_0x00d0
                    r1 = 233521600(0xdeb41c0, float:1.4498822E-30)
                    if (r0 == r1) goto L_0x001f
                    goto L_0x014b
                L_0x001f:
                    java.lang.String r0 = "android.net.wifi.supplicant.STATE_CHANGE"
                    boolean r5 = r5.equals(r0)
                    if (r5 != 0) goto L_0x0029
                    goto L_0x014b
                L_0x0029:
                    r5 = -5
                    java.lang.String r0 = "supplicantError"
                    int r5 = r6.getIntExtra(r0, r5)
                    media.tiger.tigerbox.services.implementations.HardwareWifiService r0 = r1
                    android.net.wifi.WifiManager r0 = r0.wifiManager
                    android.net.wifi.WifiInfo r0 = r0.getConnectionInfo()
                    java.lang.String r0 = r0.getSSID()
                    java.lang.String r1 = "newState"
                    android.os.Parcelable r6 = r6.getParcelableExtra(r1)
                    boolean r1 = r6 instanceof android.net.wifi.SupplicantState
                    if (r1 == 0) goto L_0x004b
                    android.net.wifi.SupplicantState r6 = (android.net.wifi.SupplicantState) r6
                    goto L_0x004c
                L_0x004b:
                    r6 = r2
                L_0x004c:
                    android.net.wifi.SupplicantState r1 = android.net.wifi.SupplicantState.DISCONNECTED
                    if (r6 != r1) goto L_0x014b
                    r6 = 1
                    if (r5 != r6) goto L_0x014b
                    media.tiger.tigerbox.services.implementations.HardwareWifiService r5 = r1
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r1 = "Wrong password for ["
                    r6.append(r1)
                    r6.append(r0)
                    r1 = 93
                    r6.append(r1)
                    java.lang.String r6 = r6.toString()
                    r5.log(r6)
                    media.tiger.tigerbox.services.implementations.HardwareWifiService r5 = r1
                    android.net.wifi.WifiManager r5 = r5.wifiManager
                    java.util.List r5 = r5.getConfiguredNetworks()
                    if (r5 == 0) goto L_0x00c7
                    media.tiger.tigerbox.services.implementations.HardwareWifiService r6 = r1
                    java.lang.Iterable r5 = (java.lang.Iterable) r5
                    java.util.Iterator r5 = r5.iterator()
                L_0x0082:
                    boolean r1 = r5.hasNext()
                    if (r1 == 0) goto L_0x0098
                    java.lang.Object r1 = r5.next()
                    r3 = r1
                    android.net.wifi.WifiConfiguration r3 = (android.net.wifi.WifiConfiguration) r3
                    java.lang.String r3 = r3.SSID
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
                    if (r3 == 0) goto L_0x0082
                    r2 = r1
                L_0x0098:
                    android.net.wifi.WifiConfiguration r2 = (android.net.wifi.WifiConfiguration) r2
                    if (r2 == 0) goto L_0x00c7
                    android.net.wifi.WifiManager r5 = r6.wifiManager
                    int r0 = r2.networkId
                    r5.removeNetwork(r0)
                    android.net.wifi.WifiManager r5 = r6.wifiManager
                    r5.saveConfiguration()
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r0 = "Network configuration for ["
                    r5.append(r0)
                    java.lang.String r0 = r2.SSID
                    r5.append(r0)
                    java.lang.String r0 = "] removed because of bad password"
                    r5.append(r0)
                    java.lang.String r5 = r5.toString()
                    r6.log(r5)
                L_0x00c7:
                    media.tiger.tigerbox.services.implementations.HardwareWifiService r5 = r1
                    media.tiger.tigerbox.services.interfaces.WifiService$FailReason r6 = media.tiger.tigerbox.services.interfaces.WifiService.FailReason.AUTHENTICATION
                    r5.connectionFail(r6)
                    goto L_0x014b
                L_0x00d0:
                    java.lang.String r0 = "android.net.wifi.STATE_CHANGE"
                    boolean r5 = r5.equals(r0)
                    if (r5 != 0) goto L_0x00da
                    goto L_0x014b
                L_0x00da:
                    java.lang.String r5 = "networkInfo"
                    android.os.Parcelable r5 = r6.getParcelableExtra(r5)
                    android.net.NetworkInfo r5 = (android.net.NetworkInfo) r5
                    media.tiger.tigerbox.services.implementations.HardwareWifiService r6 = r1
                    android.net.wifi.WifiManager r6 = r6.wifiManager
                    android.net.wifi.WifiInfo r6 = r6.getConnectionInfo()
                    java.lang.String r6 = r6.getSSID()
                    if (r6 == 0) goto L_0x014b
                    if (r5 == 0) goto L_0x00f9
                    android.net.NetworkInfo$State r0 = r5.getState()
                    goto L_0x00fa
                L_0x00f9:
                    r0 = r2
                L_0x00fa:
                    android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.CONNECTING
                    if (r0 != r1) goto L_0x0115
                    media.tiger.tigerbox.services.implementations.HardwareWifiService r5 = r1
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "CONNECTING: "
                    r0.append(r1)
                    r0.append(r6)
                    java.lang.String r6 = r0.toString()
                    r5.log(r6)
                    goto L_0x014b
                L_0x0115:
                    if (r5 == 0) goto L_0x011b
                    android.net.NetworkInfo$State r2 = r5.getState()
                L_0x011b:
                    android.net.NetworkInfo$State r5 = android.net.NetworkInfo.State.DISCONNECTED
                    if (r2 != r5) goto L_0x014b
                    media.tiger.tigerbox.services.implementations.HardwareWifiService r5 = r1
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "DISCONNECTED: "
                    r0.append(r1)
                    r0.append(r6)
                    java.lang.String r6 = r0.toString()
                    r5.log(r6)
                    goto L_0x014b
                L_0x0136:
                    java.lang.String r0 = "android.net.wifi.RSSI_CHANGED"
                    boolean r5 = r5.equals(r0)
                    if (r5 != 0) goto L_0x013f
                    goto L_0x014b
                L_0x013f:
                    media.tiger.tigerbox.services.implementations.HardwareWifiService r5 = r1
                    r0 = -1
                    java.lang.String r1 = "newRssi"
                    int r6 = r6.getIntExtra(r1, r0)
                    r5.onWifiSignalChanged(r6)
                L_0x014b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.HardwareWifiService$_wifiReceiver$2.C28801.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
    }
}
