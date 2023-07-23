package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009j$.util.Comparator;
import p009j$.util.function.Function;
import p009j$.util.function.ToDoubleFunction;
import p009j$.util.function.ToIntFunction;
import p009j$.util.function.ToLongFunction;
import p009j$.wrappers.C$r8$wrapper$java$util$function$Function$VWRP;
import p009j$.wrappers.C$r8$wrapper$java$util$function$ToDoubleFunction$VWRP;
import p009j$.wrappers.C$r8$wrapper$java$util$function$ToIntFunction$VWRP;
import p009j$.wrappers.C$r8$wrapper$java$util$function$ToLongFunction$VWRP;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u0003B\u001d\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003¢\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, mo33737d2 = {"Lkotlin/comparisons/ReversedComparator;", "T", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "(Ljava/util/Comparator;)V", "getComparator", "()Ljava/util/Comparator;", "compare", "", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)I", "reversed", "kotlin-stdlib"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
/* compiled from: Comparisons.kt */
final class ReversedComparator<T> implements Comparator<T>, p009j$.util.Comparator {
    private final Comparator<T> comparator;

    public /* synthetic */ Comparator thenComparing(Function function) {
        return Comparator.CC.$default$thenComparing((java.util.Comparator) this, function);
    }

    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator2) {
        return Comparator.CC.$default$thenComparing(this, function, comparator2);
    }

    public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator2) {
        return Comparator.CC.$default$thenComparing((java.util.Comparator) this, comparator2);
    }

    public /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function) {
        return thenComparing(C$r8$wrapper$java$util$function$Function$VWRP.convert(function));
    }

    public /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function, java.util.Comparator comparator2) {
        return thenComparing(C$r8$wrapper$java$util$function$Function$VWRP.convert(function), comparator2);
    }

    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
    }

    public /* synthetic */ java.util.Comparator thenComparingDouble(java.util.function.ToDoubleFunction toDoubleFunction) {
        return thenComparingDouble(C$r8$wrapper$java$util$function$ToDoubleFunction$VWRP.convert(toDoubleFunction));
    }

    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
    }

    public /* synthetic */ java.util.Comparator thenComparingInt(java.util.function.ToIntFunction toIntFunction) {
        return thenComparingInt(C$r8$wrapper$java$util$function$ToIntFunction$VWRP.convert(toIntFunction));
    }

    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
    }

    public /* synthetic */ java.util.Comparator thenComparingLong(java.util.function.ToLongFunction toLongFunction) {
        return thenComparingLong(C$r8$wrapper$java$util$function$ToLongFunction$VWRP.convert(toLongFunction));
    }

    public ReversedComparator(java.util.Comparator<T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        this.comparator = comparator2;
    }

    public final java.util.Comparator<T> getComparator() {
        return this.comparator;
    }

    public int compare(T t, T t2) {
        return this.comparator.compare(t2, t);
    }

    public final java.util.Comparator<T> reversed() {
        return this.comparator;
    }
}
