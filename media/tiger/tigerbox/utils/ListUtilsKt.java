package media.tiger.tigerbox.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005\u001a$\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b¨\u0006\t"}, mo33737d2 = {"prepend", "", "T", "", "element", "(Ljava/util/List;Ljava/lang/Object;)V", "prependAll", "elementList", "", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ListUtils.kt */
public final class ListUtilsKt {
    public static final <T> void prepend(List<T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        list.add(0, t);
    }

    public static final <T> void prependAll(List<T> list, List<? extends T> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(list2, "elementList");
        list.addAll(0, list2);
    }
}
