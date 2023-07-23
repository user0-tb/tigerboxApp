package media.tiger.tigerbox.services.implementations;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import media.tiger.tigerbox.model.domain.ConnectionState;
import media.tiger.tigerbox.model.domain.WifiItem;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo33737d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.services.implementations.HardwareWifiService$onWifiScanComplete$$inlined$sortedByDescending$1 */
/* compiled from: Comparisons.kt */
public final class C2879x288d6ba8<T> implements Comparator {
    public final int compare(T t, T t2) {
        boolean z = true;
        Comparable valueOf = Boolean.valueOf(((WifiItem) t2).getConnectionState() == ConnectionState.CONNECTED);
        if (((WifiItem) t).getConnectionState() != ConnectionState.CONNECTED) {
            z = false;
        }
        return ComparisonsKt.compareValues(valueOf, Boolean.valueOf(z));
    }
}
