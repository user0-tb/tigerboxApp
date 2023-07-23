package media.tiger.tigerbox.model.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "", "Lmedia/tiger/tigerbox/model/domain/WifiStrength;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WifiItemDomain.kt */
final class WifiStrength$Companion$valuesWithConnection$2 extends Lambda implements Function0<List<? extends WifiStrength>> {
    public static final WifiStrength$Companion$valuesWithConnection$2 INSTANCE = new WifiStrength$Companion$valuesWithConnection$2();

    WifiStrength$Companion$valuesWithConnection$2() {
        super(0);
    }

    public final List<WifiStrength> invoke() {
        WifiStrength[] values = WifiStrength.values();
        Collection arrayList = new ArrayList();
        int length = values.length;
        for (int i = 0; i < length; i++) {
            WifiStrength wifiStrength = values[i];
            if (wifiStrength != WifiStrength.NO_WIFI) {
                arrayList.add(wifiStrength);
            }
        }
        return (List) arrayList;
    }
}
