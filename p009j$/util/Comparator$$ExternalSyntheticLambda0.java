package p009j$.util;

import java.io.Serializable;
import java.util.Comparator;
import p009j$.util.function.Function;

/* renamed from: j$.util.Comparator$$ExternalSyntheticLambda0 */
public final /* synthetic */ class Comparator$$ExternalSyntheticLambda0 implements Comparator, Serializable {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Comparator f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Comparator$$ExternalSyntheticLambda0(Comparator comparator, Function function) {
        this.f$0 = comparator;
        this.f$1 = function;
    }

    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                Comparator comparator = this.f$0;
                Comparator comparator2 = (Comparator) this.f$1;
                int compare = comparator.compare(obj, obj2);
                return compare != 0 ? compare : comparator2.compare(obj, obj2);
            default:
                Comparator comparator3 = this.f$0;
                Function function = (Function) this.f$1;
                return comparator3.compare(function.apply(obj), function.apply(obj2));
        }
    }

    public /* synthetic */ Comparator$$ExternalSyntheticLambda0(Comparator comparator, Comparator comparator2) {
        this.f$0 = comparator;
        this.f$1 = comparator2;
    }
}
