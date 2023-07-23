package media.tiger.tigerbox.services.implementations;

import android.net.ConnectivityManager;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "Landroid/net/ConnectivityManager;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HardwareWifiService.kt */
final class HardwareWifiService$connectivityManager$2 extends Lambda implements Function0<ConnectivityManager> {
    final /* synthetic */ HardwareWifiService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HardwareWifiService$connectivityManager$2(HardwareWifiService hardwareWifiService) {
        super(0);
        this.this$0 = hardwareWifiService;
    }

    public final ConnectivityManager invoke() {
        Object systemService = this.this$0.context.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) systemService;
    }
}
