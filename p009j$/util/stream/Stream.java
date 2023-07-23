package p009j$.util.stream;

import java.util.Comparator;
import java.util.Iterator;
import p009j$.util.Optional;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.BiFunction;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Consumer;
import p009j$.util.function.Function;
import p009j$.util.function.IntFunction;
import p009j$.util.function.Predicate;
import p009j$.util.function.Supplier;
import p009j$.util.function.ToDoubleFunction;
import p009j$.util.function.ToIntFunction;
import p009j$.util.function.ToLongFunction;

/* renamed from: j$.util.stream.Stream */
public interface Stream<T> extends BaseStream {
    boolean allMatch(Predicate predicate);

    boolean anyMatch(Predicate predicate);

    Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2);

    <R, A> R collect(Collector<? super T, A, R> collector);

    long count();

    Stream distinct();

    Stream filter(Predicate predicate);

    Optional findAny();

    Optional findFirst();

    Stream flatMap(Function function);

    DoubleStream flatMapToDouble(Function function);

    IntStream flatMapToInt(Function function);

    LongStream flatMapToLong(Function function);

    void forEach(Consumer consumer);

    void forEachOrdered(Consumer consumer);

    /* synthetic */ Iterator<T> iterator();

    Stream limit(long j);

    Stream map(Function function);

    DoubleStream mapToDouble(ToDoubleFunction toDoubleFunction);

    IntStream mapToInt(ToIntFunction toIntFunction);

    LongStream mapToLong(ToLongFunction toLongFunction);

    Optional max(Comparator comparator);

    Optional min(Comparator comparator);

    boolean noneMatch(Predicate predicate);

    Stream peek(Consumer consumer);

    Optional reduce(BinaryOperator binaryOperator);

    Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator);

    Object reduce(Object obj, BinaryOperator binaryOperator);

    Stream skip(long j);

    Stream sorted();

    Stream sorted(Comparator comparator);

    Object[] toArray();

    Object[] toArray(IntFunction intFunction);
}
