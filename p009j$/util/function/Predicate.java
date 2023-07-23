package p009j$.util.function;

import java.util.Objects;

/* renamed from: j$.util.function.Predicate */
public interface Predicate<T> {

    /* renamed from: j$.util.function.Predicate$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Predicate $default$and(Predicate predicate, Predicate predicate2) {
            Objects.requireNonNull(predicate2);
            return new Predicate$$ExternalSyntheticLambda2(predicate, predicate2, 0);
        }

        public static Predicate $default$negate(Predicate predicate) {
            return new Predicate$$ExternalSyntheticLambda1(predicate);
        }

        public static Predicate $default$or(Predicate predicate, Predicate predicate2) {
            Objects.requireNonNull(predicate2);
            return new Predicate$$ExternalSyntheticLambda2(predicate, predicate2, 1);
        }
    }

    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    /* renamed from: or */
    Predicate<T> mo6806or(Predicate<? super T> predicate);

    boolean test(T t);
}
