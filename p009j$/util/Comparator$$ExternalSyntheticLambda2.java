package p009j$.util;

import java.io.Serializable;
import java.util.Comparator;
import p009j$.util.function.Function;
import p009j$.util.function.ToDoubleFunction;
import p009j$.util.function.ToIntFunction;
import p009j$.util.function.ToLongFunction;

/* renamed from: j$.util.Comparator$$ExternalSyntheticLambda2 */
public final /* synthetic */ class Comparator$$ExternalSyntheticLambda2 implements Comparator, Serializable {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Comparator$$ExternalSyntheticLambda2(Function function) {
        this.f$0 = function;
    }

    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                Function function = (Function) this.f$0;
                return ((Comparable) function.apply(obj)).compareTo(function.apply(obj2));
            case 1:
                ToDoubleFunction toDoubleFunction = (ToDoubleFunction) this.f$0;
                return Double.compare(toDoubleFunction.applyAsDouble(obj), toDoubleFunction.applyAsDouble(obj2));
            case 2:
                ToIntFunction toIntFunction = (ToIntFunction) this.f$0;
                return Integer.compare(toIntFunction.applyAsInt(obj), toIntFunction.applyAsInt(obj2));
            default:
                ToLongFunction toLongFunction = (ToLongFunction) this.f$0;
                return Long.compare(toLongFunction.applyAsLong(obj), toLongFunction.applyAsLong(obj2));
        }
    }

    public /* synthetic */ Comparator$$ExternalSyntheticLambda2(ToDoubleFunction toDoubleFunction) {
        this.f$0 = toDoubleFunction;
    }

    public /* synthetic */ Comparator$$ExternalSyntheticLambda2(ToIntFunction toIntFunction) {
        this.f$0 = toIntFunction;
    }

    public /* synthetic */ Comparator$$ExternalSyntheticLambda2(ToLongFunction toLongFunction) {
        this.f$0 = toLongFunction;
    }
}
