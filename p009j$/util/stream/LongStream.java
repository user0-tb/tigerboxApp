package p009j$.util.stream;

import p009j$.util.LongSummaryStatistics;
import p009j$.util.OptionalDouble;
import p009j$.util.OptionalLong;
import p009j$.util.PrimitiveIterator;
import p009j$.util.Spliterator;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.LongBinaryOperator;
import p009j$.util.function.LongConsumer;
import p009j$.util.function.LongFunction;
import p009j$.util.function.LongUnaryOperator;
import p009j$.util.function.ObjLongConsumer;
import p009j$.util.function.Supplier;
import p009j$.wrappers.C$r8$wrapper$java$util$function$IntPredicate$VWRP;

/* renamed from: j$.util.stream.LongStream */
public interface LongStream extends BaseStream {
    boolean allMatch$2(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    boolean anyMatch$2(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    DoubleStream asDoubleStream();

    OptionalDouble average();

    Stream boxed();

    Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer);

    long count();

    LongStream distinct();

    LongStream filter(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    OptionalLong findAny();

    OptionalLong findFirst();

    LongStream flatMap(LongFunction longFunction);

    void forEach(LongConsumer longConsumer);

    void forEachOrdered(LongConsumer longConsumer);

    PrimitiveIterator.OfLong iterator();

    LongStream limit(long j);

    LongStream map(LongUnaryOperator longUnaryOperator);

    DoubleStream mapToDouble$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    IntStream mapToInt$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    Stream mapToObj(LongFunction longFunction);

    OptionalLong max();

    OptionalLong min();

    boolean noneMatch$2(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    LongStream parallel();

    LongStream peek(LongConsumer longConsumer);

    long reduce(long j, LongBinaryOperator longBinaryOperator);

    OptionalLong reduce(LongBinaryOperator longBinaryOperator);

    LongStream sequential();

    LongStream skip(long j);

    LongStream sorted();

    Spliterator.OfLong spliterator();

    long sum();

    LongSummaryStatistics summaryStatistics();

    long[] toArray();
}
