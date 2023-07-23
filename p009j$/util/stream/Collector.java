package p009j$.util.stream;

import java.util.Set;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Function;
import p009j$.util.function.Supplier;

/* renamed from: j$.util.stream.Collector */
public interface Collector<T, A, R> {

    /* renamed from: j$.util.stream.Collector$Characteristics */
    public enum Characteristics {
        CONCURRENT,
        UNORDERED,
        IDENTITY_FINISH
    }

    BiConsumer accumulator();

    Set characteristics();

    BinaryOperator combiner();

    Function finisher();

    Supplier supplier();
}
