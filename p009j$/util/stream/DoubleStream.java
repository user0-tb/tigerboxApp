package p009j$.util.stream;

import p009j$.util.DoubleSummaryStatistics;
import p009j$.util.OptionalDouble;
import p009j$.util.PrimitiveIterator;
import p009j$.util.Spliterator;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.DoubleBinaryOperator;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.DoubleFunction;
import p009j$.util.function.DoubleToLongFunction;
import p009j$.util.function.ObjDoubleConsumer;
import p009j$.util.function.Supplier;
import p009j$.wrappers.C$r8$wrapper$java$util$function$IntPredicate$VWRP;

/* renamed from: j$.util.stream.DoubleStream */
public interface DoubleStream extends BaseStream {
    boolean allMatch(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    boolean anyMatch(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    OptionalDouble average();

    Stream boxed();

    Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer);

    long count();

    DoubleStream distinct();

    DoubleStream filter(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    OptionalDouble findAny();

    OptionalDouble findFirst();

    DoubleStream flatMap(DoubleFunction doubleFunction);

    void forEach(DoubleConsumer doubleConsumer);

    void forEachOrdered(DoubleConsumer doubleConsumer);

    PrimitiveIterator.OfDouble iterator();

    DoubleStream limit(long j);

    DoubleStream map(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    IntStream mapToInt(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    LongStream mapToLong(DoubleToLongFunction doubleToLongFunction);

    Stream mapToObj(DoubleFunction doubleFunction);

    OptionalDouble max();

    OptionalDouble min();

    boolean noneMatch(C$r8$wrapper$java$util$function$IntPredicate$VWRP r1);

    DoubleStream parallel();

    DoubleStream peek(DoubleConsumer doubleConsumer);

    double reduce(double d, DoubleBinaryOperator doubleBinaryOperator);

    OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator);

    DoubleStream sequential();

    DoubleStream skip(long j);

    DoubleStream sorted();

    Spliterator.OfDouble spliterator();

    double sum();

    DoubleSummaryStatistics summaryStatistics();

    double[] toArray();
}
