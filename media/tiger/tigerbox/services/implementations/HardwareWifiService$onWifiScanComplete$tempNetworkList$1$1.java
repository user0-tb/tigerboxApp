package media.tiger.tigerbox.services.implementations;

import android.net.wifi.ScanResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(mo33736d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, mo33737d2 = {"<anonymous>", "", "it", "Landroid/net/wifi/ScanResult;", "invoke", "(Landroid/net/wifi/ScanResult;)Ljava/lang/Boolean;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HardwareWifiService.kt */
final class HardwareWifiService$onWifiScanComplete$tempNetworkList$1$1 extends Lambda implements Function1<ScanResult, Boolean> {
    public static final HardwareWifiService$onWifiScanComplete$tempNetworkList$1$1 INSTANCE = new HardwareWifiService$onWifiScanComplete$tempNetworkList$1$1();

    HardwareWifiService$onWifiScanComplete$tempNetworkList$1$1() {
        super(1);
    }

    public final Boolean invoke(ScanResult scanResult) {
        Intrinsics.checkNotNullParameter(scanResult, "it");
        String str = scanResult.SSID;
        Intrinsics.checkNotNullExpressionValue(str, "it.SSID");
        return Boolean.valueOf(!StringsKt.isBlank(str));
    }
}
