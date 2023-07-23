package p009j$.wrappers;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import p009j$.util.Objects;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$stream$IntStream$-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$stream$IntStream$WRP implements IntStream {
    final /* synthetic */ p009j$.util.stream.IntStream wrappedValue;

    private /* synthetic */ C$r8$wrapper$java$util$stream$IntStream$WRP(p009j$.util.stream.IntStream intStream) {
        this.wrappedValue = intStream;
    }

    public static /* synthetic */ IntStream convert(p009j$.util.stream.IntStream intStream) {
        if (intStream == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$stream$IntStream$WRP(intStream);
    }

    public /* synthetic */ boolean allMatch(IntPredicate intPredicate) {
        return this.wrappedValue.allMatch$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(intPredicate));
    }

    public /* synthetic */ boolean anyMatch(IntPredicate intPredicate) {
        return this.wrappedValue.anyMatch$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(intPredicate));
    }

    public /* synthetic */ DoubleStream asDoubleStream() {
        return C$r8$wrapper$java$util$stream$DoubleStream$WRP.convert(this.wrappedValue.asDoubleStream());
    }

    public /* synthetic */ LongStream asLongStream() {
        return C$r8$wrapper$java$util$stream$LongStream$WRP.convert(this.wrappedValue.asLongStream());
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

    public /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        return this.wrappedValue.collect(C$r8$wrapper$java$util$function$Supplier$VWRP.convert(supplier), objIntConsumer == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(objIntConsumer), C$r8$wrapper$java$util$function$BiConsumer$VWRP.convert(biConsumer));
    }

    public /* synthetic */ long count() {
        return this.wrappedValue.count();
    }

    public /* synthetic */ IntStream distinct() {
        return convert(this.wrappedValue.distinct());
    }

    public /* synthetic */ IntStream filter(IntPredicate intPredicate) {
        return convert(this.wrappedValue.filter(C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(intPredicate)));
    }

    public /* synthetic */ OptionalInt findAny() {
        return Objects.convert(this.wrappedValue.findAny());
    }

    public /* synthetic */ OptionalInt findFirst() {
        return Objects.convert(this.wrappedValue.findFirst());
    }

    public /* synthetic */ IntStream flatMap(IntFunction intFunction) {
        return convert(this.wrappedValue.flatMap(C$r8$wrapper$java$util$function$IntFunction$VWRP.convert(intFunction)));
    }

    public /* synthetic */ void forEach(IntConsumer intConsumer) {
        this.wrappedValue.forEach(C$r8$wrapper$java$util$function$IntConsumer$VWRP.convert(intConsumer));
    }

    public /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
        this.wrappedValue.forEachOrdered(C$r8$wrapper$java$util$function$IntConsumer$VWRP.convert(intConsumer));
    }

    public /* synthetic */ boolean isParallel() {
        return this.wrappedValue.isParallel();
    }

    public /* synthetic */ IntStream limit(long j) {
        return convert(this.wrappedValue.limit(j));
    }

    public /* synthetic */ IntStream map(IntUnaryOperator intUnaryOperator) {
        return convert(this.wrappedValue.map(intUnaryOperator == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(intUnaryOperator)));
    }

    public /* synthetic */ DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
        return C$r8$wrapper$java$util$stream$DoubleStream$WRP.convert(this.wrappedValue.mapToDouble(intToDoubleFunction == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(intToDoubleFunction)));
    }

    public /* synthetic */ LongStream mapToLong(IntToLongFunction intToLongFunction) {
        return C$r8$wrapper$java$util$stream$LongStream$WRP.convert(this.wrappedValue.mapToLong(intToLongFunction == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(intToLongFunction)));
    }

    public /* synthetic */ Stream mapToObj(IntFunction intFunction) {
        return C$r8$wrapper$java$util$stream$Stream$WRP.convert(this.wrappedValue.mapToObj(C$r8$wrapper$java$util$function$IntFunction$VWRP.convert(intFunction)));
    }

    public /* synthetic */ OptionalInt max() {
        return Objects.convert(this.wrappedValue.max());
    }

    public /* synthetic */ OptionalInt min() {
        return Objects.convert(this.wrappedValue.min());
    }

    public /* synthetic */ boolean noneMatch(IntPredicate intPredicate) {
        return this.wrappedValue.noneMatch$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(intPredicate));
    }

    public /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C$r8$wrapper$java$util$stream$BaseStream$WRP.convert(this.wrappedValue.onClose(runnable));
    }

    public /* synthetic */ IntStream peek(IntConsumer intConsumer) {
        return convert(this.wrappedValue.peek(C$r8$wrapper$java$util$function$IntConsumer$VWRP.convert(intConsumer)));
    }

    public /* synthetic */ int reduce(int i, IntBinaryOperator intBinaryOperator) {
        return this.wrappedValue.reduce(i, intBinaryOperator == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(intBinaryOperator));
    }

    public /* synthetic */ IntStream skip(long j) {
        return convert(this.wrappedValue.skip(j));
    }

    public /* synthetic */ IntStream sorted() {
        return convert(this.wrappedValue.sorted());
    }

    public /* synthetic */ int sum() {
        return this.wrappedValue.sum();
    }

    public IntSummaryStatistics summaryStatistics() {
        this.wrappedValue.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.IntSummaryStatistics");
    }

    public /* synthetic */ int[] toArray() {
        return this.wrappedValue.toArray();
    }

    public /* synthetic */ BaseStream unordered() {
        return C$r8$wrapper$java$util$stream$BaseStream$WRP.convert(this.wrappedValue.unordered());
    }

    public /* synthetic */ OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
        return Objects.convert(this.wrappedValue.reduce(intBinaryOperator == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(intBinaryOperator)));
    }
}
