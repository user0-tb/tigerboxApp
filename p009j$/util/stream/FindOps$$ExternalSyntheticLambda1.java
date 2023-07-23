package p009j$.util.stream;

import p009j$.util.OptionalDouble;
import p009j$.util.function.Predicate;

/* renamed from: j$.util.stream.FindOps$$ExternalSyntheticLambda1 */
public final /* synthetic */ class FindOps$$ExternalSyntheticLambda1 implements Predicate {
    public static final /* synthetic */ FindOps$$ExternalSyntheticLambda1 INSTANCE = new FindOps$$ExternalSyntheticLambda1();

    private /* synthetic */ FindOps$$ExternalSyntheticLambda1() {
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    /* renamed from: or */
    public /* synthetic */ Predicate mo6806or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return ((OptionalDouble) obj).isPresent();
    }
}
