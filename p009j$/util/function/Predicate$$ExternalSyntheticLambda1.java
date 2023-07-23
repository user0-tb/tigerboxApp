package p009j$.util.function;

import java.util.Comparator;
import p009j$.util.function.Predicate;

/* renamed from: j$.util.function.Predicate$$ExternalSyntheticLambda1 */
public final /* synthetic */ class Predicate$$ExternalSyntheticLambda1 implements Predicate, BinaryOperator {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Predicate$$ExternalSyntheticLambda1(Predicate predicate) {
        this.$r8$classId = 0;
        this.f$0 = predicate;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public Object apply(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 1:
                return ((Comparator) this.f$0).compare(obj, obj2) >= 0 ? obj : obj2;
            default:
                return ((Comparator) this.f$0).compare(obj, obj2) <= 0 ? obj : obj2;
        }
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    /* renamed from: or */
    public /* synthetic */ Predicate mo6806or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public boolean test(Object obj) {
        return !((Predicate) this.f$0).test(obj);
    }

    public /* synthetic */ Predicate$$ExternalSyntheticLambda1(Comparator comparator, int i) {
        this.$r8$classId = i;
        if (i != 2) {
            this.f$0 = comparator;
        } else {
            this.f$0 = comparator;
        }
    }
}
