package p009j$.util;

import java.util.Objects;
import p009j$.util.function.Function;
import p009j$.util.function.ToDoubleFunction;
import p009j$.util.function.ToIntFunction;
import p009j$.util.function.ToLongFunction;

/* renamed from: j$.util.Comparator */
public interface Comparator<T> {
    int compare(T t, T t2);

    boolean equals(Object obj);

    java.util.Comparator<T> reversed();

    <U extends Comparable<? super U>> java.util.Comparator<T> thenComparing(Function<? super T, ? extends U> function);

    <U> java.util.Comparator<T> thenComparing(Function<? super T, ? extends U> function, java.util.Comparator<? super U> comparator);

    java.util.Comparator<T> thenComparing(java.util.Comparator<? super T> comparator);

    java.util.Comparator<T> thenComparingDouble(ToDoubleFunction<? super T> toDoubleFunction);

    java.util.Comparator<T> thenComparingInt(ToIntFunction<? super T> toIntFunction);

    java.util.Comparator<T> thenComparingLong(ToLongFunction<? super T> toLongFunction);

    /* renamed from: j$.util.Comparator$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static <U extends Comparable<? super U>> java.util.Comparator $default$thenComparing(java.util.Comparator comparator, Function function) {
            Objects.requireNonNull(function);
            return Objects.thenComparing(comparator, new Comparator$$ExternalSyntheticLambda2(function));
        }

        public static java.util.Comparator $default$thenComparingDouble(java.util.Comparator comparator, ToDoubleFunction toDoubleFunction) {
            Objects.requireNonNull(toDoubleFunction);
            return Objects.thenComparing(comparator, new Comparator$$ExternalSyntheticLambda2(toDoubleFunction));
        }

        public static java.util.Comparator $default$thenComparingInt(java.util.Comparator comparator, ToIntFunction toIntFunction) {
            Objects.requireNonNull(toIntFunction);
            return Objects.thenComparing(comparator, new Comparator$$ExternalSyntheticLambda2(toIntFunction));
        }

        public static java.util.Comparator $default$thenComparingLong(java.util.Comparator comparator, ToLongFunction toLongFunction) {
            Objects.requireNonNull(toLongFunction);
            return Objects.thenComparing(comparator, new Comparator$$ExternalSyntheticLambda2(toLongFunction));
        }

        public static java.util.Comparator naturalOrder() {
            return Comparators$NaturalOrderComparator.INSTANCE;
        }

        public static <U> java.util.Comparator $default$thenComparing(java.util.Comparator comparator, Function function, java.util.Comparator comparator2) {
            Objects.requireNonNull(function);
            Objects.requireNonNull(comparator2);
            return Objects.thenComparing(comparator, new Comparator$$ExternalSyntheticLambda0(comparator2, function));
        }

        public static java.util.Comparator $default$thenComparing(java.util.Comparator comparator, java.util.Comparator comparator2) {
            Objects.requireNonNull(comparator2);
            return new Comparator$$ExternalSyntheticLambda0(comparator, comparator2);
        }
    }
}
