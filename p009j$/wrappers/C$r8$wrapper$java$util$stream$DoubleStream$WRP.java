package p009j$.wrappers;

import java.util.DoubleSummaryStatistics;
import java.util.OptionalDouble;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import p009j$.util.Objects;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$stream$DoubleStream$-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$stream$DoubleStream$WRP implements DoubleStream {
    final /* synthetic */ p009j$.util.stream.DoubleStream wrappedValue;

    private /* synthetic */ C$r8$wrapper$java$util$stream$DoubleStream$WRP(p009j$.util.stream.DoubleStream doubleStream) {
        this.wrappedValue = doubleStream;
    }

    public static /* synthetic */ DoubleStream convert(p009j$.util.stream.DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$stream$DoubleStream$WRP(doubleStream);
    }

    public /* synthetic */ boolean allMatch(DoublePredicate doublePredicate) {
        return this.wrappedValue.allMatch(C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(doublePredicate));
    }

    public /* synthetic */ boolean anyMatch(DoublePredicate doublePredicate) {
        return this.wrappedValue.anyMatch(C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(doublePredicate));
    }

    public /* synthetic */ OptionalDouble average() {
        return Objects.convert(this.wrappedValue.average());
    }

    public /* synthetic */ Stream boxed() {
        return C$r8$wrapper$java$util$stream$Stream$WRP.convert(this.wrappedValue.boxed());
    }

    public /* synthetic */ void close() {
        this.wrappedValue.close();
    }

    public /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.wrappedValue.collect(C$r8$wrapper$java$util$function$Supplier$VWRP.convert(supplier), objDoubleConsumer == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(objDoubleConsumer), C$r8$wrapper$java$util$function$BiConsumer$VWRP.convert(biConsumer));
    }

    public /* synthetic */ long count() {
        return this.wrappedValue.count();
    }

    public /* synthetic */ DoubleStream distinct() {
        return convert(this.wrappedValue.distinct());
    }

    public /* synthetic */ DoubleStream filter(DoublePredicate doublePredicate) {
        return convert(this.wrappedValue.filter(C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(doublePredicate)));
    }

    public /* synthetic */ OptionalDouble findAny() {
        return Objects.convert(this.wrappedValue.findAny());
    }

    public /* synthetic */ OptionalDouble findFirst() {
        return Objects.convert(this.wrappedValue.findFirst());
    }

    public /* synthetic */ DoubleStream flatMap(DoubleFunction doubleFunction) {
        return convert(this.wrappedValue.flatMap(doubleFunction == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(doubleFunction)));
    }

    public /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.wrappedValue.forEach(C$r8$wrapper$java$util$function$DoubleConsumer$VWRP.convert(doubleConsumer));
    }

    public /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.wrappedValue.forEachOrdered(C$r8$wrapper$java$util$function$DoubleConsumer$VWRP.convert(doubleConsumer));
    }

    public /* synthetic */ boolean isParallel() {
        return this.wrappedValue.isParallel();
    }

    public /* synthetic */ DoubleStream limit(long j) {
        return convert(this.wrappedValue.limit(j));
    }

    public /* synthetic */ DoubleStream map(DoubleUnaryOperator doubleUnaryOperator) {
        return convert(this.wrappedValue.map(doubleUnaryOperator == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(doubleUnaryOperator)));
    }

    public /* synthetic */ IntStream mapToInt(DoubleToIntFunction doubleToIntFunction) {
        return C$r8$wrapper$java$util$stream$IntStream$WRP.convert(this.wrappedValue.mapToInt(doubleToIntFunction == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(doubleToIntFunction)));
    }

    public /* synthetic */ LongStream mapToLong(DoubleToLongFunction doubleToLongFunction) {
        return C$r8$wrapper$java$util$stream$LongStream$WRP.convert(this.wrappedValue.mapToLong(doubleToLongFunction == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(doubleToLongFunction)));
    }

    public /* synthetic */ Stream mapToObj(DoubleFunction doubleFunction) {
        return C$r8$wrapper$java$util$stream$Stream$WRP.convert(this.wrappedValue.mapToObj(doubleFunction == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(doubleFunction)));
    }

    public /* synthetic */ OptionalDouble max() {
        return Objects.convert(this.wrappedValue.max());
    }

    public /* synthetic */ OptionalDouble min() {
        return Objects.convert(this.wrappedValue.min());
    }

    public /* synthetic */ boolean noneMatch(DoublePredicate doublePredicate) {
        return this.wrappedValue.noneMatch(C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(doublePredicate));
    }

    public /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C$r8$wrapper$java$util$stream$BaseStream$WRP.convert(this.wrappedValue.onClose(runnable));
    }

    public /* synthetic */ DoubleStream peek(DoubleConsumer doubleConsumer) {
        return convert(this.wrappedValue.peek(C$r8$wrapper$java$util$function$DoubleConsumer$VWRP.convert(doubleConsumer)));
    }

    public /* synthetic */ double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
        return this.wrappedValue.reduce(d, doubleBinaryOperator == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(doubleBinaryOperator));
    }

    public /* synthetic */ DoubleStream skip(long j) {
        return convert(this.wrappedValue.skip(j));
    }

    public /* synthetic */ DoubleStream sorted() {
        return convert(this.wrappedValue.sorted());
    }

    public /* synthetic */ double sum() {
        return this.wrappedValue.sum();
    }

    public DoubleSummaryStatistics summaryStatistics() {
        this.wrappedValue.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.DoubleSummaryStatistics");
    }

    public /* synthetic */ double[] toArray() {
        return this.wrappedValue.toArray();
    }

    public /* synthetic */ BaseStream unordered() {
        return C$r8$wrapper$java$util$stream$BaseStream$WRP.convert(this.wrappedValue.unordered());
    }

    public /* synthetic */ OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return Objects.convert(this.wrappedValue.reduce(doubleBinaryOperator == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(doubleBinaryOperator)));
    }
}
