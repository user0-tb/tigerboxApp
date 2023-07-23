package media.tiger.tigerbox.model.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, mo33737d2 = {"toSorted", "", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WifiItemDomain.kt */
public final class WifiItemDomainKt {
    public static final List<WifiItem> toSorted(List<WifiItem> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<WifiItem> mutableList = CollectionsKt.toMutableList(list);
        CollectionsKt.sortWith(mutableList, ComparisonsKt.compareBy((Function1<? super T, ? extends Comparable<?>>[]) new Function1[]{WifiItemDomainKt$toSorted$1$1.INSTANCE, WifiItemDomainKt$toSorted$1$2.INSTANCE}));
        return mutableList;
    }
}
