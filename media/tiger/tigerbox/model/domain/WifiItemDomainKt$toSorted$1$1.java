package media.tiger.tigerbox.model.domain;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "wifiItem", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WifiItemDomain.kt */
final class WifiItemDomainKt$toSorted$1$1 extends Lambda implements Function1<WifiItem, Comparable<?>> {
    public static final WifiItemDomainKt$toSorted$1$1 INSTANCE = new WifiItemDomainKt$toSorted$1$1();

    WifiItemDomainKt$toSorted$1$1() {
        super(1);
    }

    public final Comparable<?> invoke(WifiItem wifiItem) {
        Intrinsics.checkNotNullParameter(wifiItem, "wifiItem");
        return Boolean.valueOf(wifiItem.getConnectionState() != ConnectionState.CONNECTED);
    }
}
