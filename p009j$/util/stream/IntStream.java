package p009j$.util.stream;

import p009j$.util.IntSummaryStatistics;
import p009j$.util.OptionalDouble;
import p009j$.util.OptionalInt;
import p009j$.util.PrimitiveIterator;
import p009j$.util.Spliterator;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.IntBinaryOperator;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.IntFunction;
import p009j$.util.function.IntToLongFunction;
import p009j$.util.function.ObjIntConsumer;
import p009j$.util.function.Supplier;
import p009j$.wrappers.C$r8$wrapper$java$util$function$IntPredicate$VWRP;

/* renamed from: j$.util.stream.IntStream */
public interface IntStream extends BaseStream {
    boolean allMatch$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    boolean anyMatch$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    DoubleStream asDoubleStream();

    LongStream asLongStream();

    OptionalDouble average();

    Stream boxed();

    Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer);

    long count();

    IntStream distinct();

    IntStream filter(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    OptionalInt findAny();

    OptionalInt findFirst();

    IntStream flatMap(IntFunction intFunction);

    void forEach(IntConsumer intConsumer);

    void forEachOrdered(IntConsumer intConsumer);

    PrimitiveIterator.OfInt iterator();

    IntStream limit(long j);

    IntStream map(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    DoubleStream mapToDouble(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    LongStream mapToLong(IntToLongFunction intToLongFunction);

    Stream mapToObj(IntFunction intFunction);

    OptionalInt max();

    OptionalInt min();

    boolean noneMatch$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    IntStream parallel();

    IntStream peek(IntConsumer intConsumer);

    int reduce(int i, IntBinaryOperator intBinaryOperator);

    OptionalInt reduce(IntBinaryOperator intBinaryOperator);

    IntStream sequential();

    IntStream skip(long j);

    IntStream sorted();

    Spliterator.OfInt spliterator();

    int sum();

    IntSummaryStatistics summaryStatistics();

    int[] toArray();
}
