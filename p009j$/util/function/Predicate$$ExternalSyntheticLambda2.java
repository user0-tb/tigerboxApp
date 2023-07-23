package p009j$.util.function;

import p009j$.util.function.Predicate;

/* renamed from: j$.util.function.Predicate$$ExternalSyntheticLambda2 */
public final /* synthetic */ class Predicate$$ExternalSyntheticLambda2 implements Predicate {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Predicate f$0;
    public final /* synthetic */ Predicate f$1;

    public /* synthetic */ Predicate$$ExternalSyntheticLambda2(Predicate predicate, Predicate predicate2, int i) {
        this.$r8$classId = i;
        if (i != 1) {
            this.f$0 = predicate;
            this.f$1 = predicate2;
            return;
        }
        this.f$0 = predicate;
        this.f$1 = predicate2;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.$r8$classId) {
            case 0:
                return Predicate.CC.$default$and(this, predicate);
            default:
                return Predicate.CC.$default$and(this, predicate);
        }
    }

    public /* synthetic */ Predicate negate() {
        switch (this.$r8$classId) {
            case 0:
                return Predicate.CC.$default$negate(this);
            default:
                return Predicate.CC.$default$negate(this);
        }
    }

    /* renamed from: or */
    public /* synthetic */ Predicate mo6806or(Predicate predicate) {
        switch (this.$r8$classId) {
            case 0:
                return Predicate.CC.$default$or(this, predicate);
            default:
                return Predicate.CC.$default$or(this, predicate);
        }
    }

    public final boolean test(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Predicate predicate = this.f$0;
                Predicate predicate2 = this.f$1;
                if (!predicate.test(obj) || !predicate2.test(obj)) {
                    return false;
                }
                return true;
            default:
                Predicate predicate3 = this.f$0;
                Predicate predicate4 = this.f$1;
                if (predicate3.test(obj) || predicate4.test(obj)) {
                    return true;
                }
                return false;
        }
    }
}
