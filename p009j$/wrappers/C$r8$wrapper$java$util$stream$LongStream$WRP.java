package p009j$.wrappers;

import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import p009j$.util.Objects;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$stream$LongStream$-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$stream$LongStream$WRP implements LongStream {
    final /* synthetic */ p009j$.util.stream.LongStream wrappedValue;

    private /* synthetic */ C$r8$wrapper$java$util$stream$LongStream$WRP(p009j$.util.stream.LongStream longStream) {
        this.wrappedValue = longStream;
    }

    public static /* synthetic */ LongStream convert(p009j$.util.stream.LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$stream$LongStream$WRP(longStream);
    }

    public /* synthetic */ boolean allMatch(LongPredicate longPredicate) {
        return this.wrappedValue.allMatch$2(C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(longPredicate));
    }

    public /* synthetic */ boolean anyMatch(LongPredicate longPredicate) {
        return this.wrappedValue.anyMatch$2(C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(longPredicate));
    }

    public /* synthetic */ DoubleStream asDoubleStream() {
        return C$r8$wrapper$java$util$stream$DoubleStream$WRP.convert(this.wrappedValue.asDoubleStream());
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

    public /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return this.wrappedValue.collect(C$r8$wrapper$java$util$function$Supplier$VWRP.convert(supplier), objLongConsumer == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(objLongConsumer), C$r8$wrapper$java$util$function$BiConsumer$VWRP.convert(biConsumer));
    }

    public /* synthetic */ long count() {
        return this.wrappedValue.count();
    }

    public /* synthetic */ LongStream distinct() {
        return convert(this.wrappedValue.distinct());
    }

    public /* synthetic */ LongStream filter(LongPredicate longPredicate) {
        return convert(this.wrappedValue.filter(C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(longPredicate)));
    }

    public /* synthetic */ OptionalLong findAny() {
        return Objects.convert(this.wrappedValue.findAny());
    }

    public /* synthetic */ OptionalLong findFirst() {
        return Objects.convert(this.wrappedValue.findFirst());
    }

    public /* synthetic */ LongStream flatMap(LongFunction longFunction) {
        return convert(this.wrappedValue.flatMap(longFunction == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(longFunction)));
    }

    public /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.wrappedValue.forEach(C$r8$wrapper$java$util$function$LongConsumer$VWRP.convert(longConsumer));
    }

    public /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.wrappedValue.forEachOrdered(C$r8$wrapper$java$util$function$LongConsumer$VWRP.convert(longConsumer));
    }

    public /* synthetic */ boolean isParallel() {
        return this.wrappedValue.isParallel();
    }

    public /* synthetic */ LongStream limit(long j) {
        return convert(this.wrappedValue.limit(j));
    }

    public /* synthetic */ LongStream map(LongUnaryOperator longUnaryOperator) {
        return convert(this.wrappedValue.map(longUnaryOperator == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(longUnaryOperator)));
    }

    public /* synthetic */ DoubleStream mapToDouble(LongToDoubleFunction longToDoubleFunction) {
        return C$r8$wrapper$java$util$stream$DoubleStream$WRP.convert(this.wrappedValue.mapToDouble$1(longToDoubleFunction == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(longToDoubleFunction)));
    }

    public /* synthetic */ IntStream mapToInt(LongToIntFunction longToIntFunction) {
        return C$r8$wrapper$java$util$stream$IntStream$WRP.convert(this.wrappedValue.mapToInt$1(longToIntFunction == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(longToIntFunction)));
    }

    public /* synthetic */ Stream mapToObj(LongFunction longFunction) {
        return C$r8$wrapper$java$util$stream$Stream$WRP.convert(this.wrappedValue.mapToObj(longFunction == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(longFunction)));
    }

    public /* synthetic */ OptionalLong max() {
        return Objects.convert(this.wrappedValue.max());
    }

    public /* synthetic */ OptionalLong min() {
        return Objects.convert(this.wrappedValue.min());
    }

    public /* synthetic */ boolean noneMatch(LongPredicate longPredicate) {
        return this.wrappedValue.noneMatch$2(C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(longPredicate));
    }

    public /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C$r8$wrapper$java$util$stream$BaseStream$WRP.convert(this.wrappedValue.onClose(runnable));
    }

    public /* synthetic */ LongStream peek(LongConsumer longConsumer) {
        return convert(this.wrappedValue.peek(C$r8$wrapper$java$util$function$LongConsumer$VWRP.convert(longConsumer)));
    }

    public /* synthetic */ long reduce(long j, LongBinaryOperator longBinaryOperator) {
        return this.wrappedValue.reduce(j, longBinaryOperator == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(longBinaryOperator));
    }

    public /* synthetic */ LongStream skip(long j) {
        return convert(this.wrappedValue.skip(j));
    }

    public /* synthetic */ LongStream sorted() {
        return convert(this.wrappedValue.sorted());
    }

    public /* synthetic */ long sum() {
        return this.wrappedValue.sum();
    }

    public LongSummaryStatistics summaryStatistics() {
        this.wrappedValue.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.LongSummaryStatistics");
    }

    public /* synthetic */ long[] toArray() {
        return this.wrappedValue.toArray();
    }

    public /* synthetic */ BaseStream unordered() {
        return C$r8$wrapper$java$util$stream$BaseStream$WRP.convert(this.wrappedValue.unordered());
    }

    public /* synthetic */ OptionalLong reduce(LongBinaryOperator longBinaryOperator) {
        return Objects.convert(this.wrappedValue.reduce(longBinaryOperator == null ? null : new C$r8$wrapper$java$util$function$IntPredicate$VWRP(longBinaryOperator)));
    }
}
