package p009j$.wrappers;

import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.DoubleBinaryOperator;
import p009j$.util.function.DoubleFunction;
import p009j$.util.function.DoubleToLongFunction;
import p009j$.util.function.IntBinaryOperator;
import p009j$.util.function.IntToLongFunction;
import p009j$.util.function.LongBinaryOperator;
import p009j$.util.function.LongFunction;
import p009j$.util.function.LongUnaryOperator;
import p009j$.util.function.ObjDoubleConsumer;
import p009j$.util.function.ObjIntConsumer;
import p009j$.util.function.ObjLongConsumer;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$function$IntPredicate$-V-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$function$IntPredicate$VWRP implements BinaryOperator, DoubleBinaryOperator, DoubleFunction, DoubleToLongFunction, IntBinaryOperator, IntToLongFunction, LongBinaryOperator, LongFunction, LongUnaryOperator, ObjDoubleConsumer, ObjIntConsumer, ObjLongConsumer {
    final /* synthetic */ Object wrappedValue;

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(java.util.function.BinaryOperator binaryOperator) {
        this.wrappedValue = binaryOperator;
    }

    public static /* synthetic */ BinaryOperator convert(java.util.function.BinaryOperator binaryOperator) {
        if (binaryOperator == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$function$IntPredicate$VWRP(binaryOperator);
    }

    public static /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP convert(DoublePredicate doublePredicate) {
        if (doublePredicate == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$function$IntPredicate$VWRP(doublePredicate);
    }

    public static /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP convert(IntPredicate intPredicate) {
        if (intPredicate == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$function$IntPredicate$VWRP(intPredicate);
    }

    public static /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP convert(LongPredicate longPredicate) {
        if (longPredicate == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$function$IntPredicate$VWRP(longPredicate);
    }

    public /* synthetic */ void accept(Object obj, double d) {
        ((java.util.function.ObjDoubleConsumer) this.wrappedValue).accept(obj, d);
    }

    public /* synthetic */ void accept(Object obj, int i) {
        ((java.util.function.ObjIntConsumer) this.wrappedValue).accept(obj, i);
    }

    public /* synthetic */ void accept(Object obj, long j) {
        ((java.util.function.ObjLongConsumer) this.wrappedValue).accept(obj, j);
    }

    public /* synthetic */ Object apply(double d) {
        return ((java.util.function.DoubleFunction) this.wrappedValue).apply(d);
    }

    public /* synthetic */ Object apply(long j) {
        return ((java.util.function.LongFunction) this.wrappedValue).apply(j);
    }

    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return ((java.util.function.BinaryOperator) this.wrappedValue).apply(obj, obj2);
    }

    public double applyAsDouble(double d) {
        return ((DoubleUnaryOperator) this.wrappedValue).applyAsDouble(d);
    }

    public /* synthetic */ double applyAsDouble(double d, double d2) {
        return ((java.util.function.DoubleBinaryOperator) this.wrappedValue).applyAsDouble(d, d2);
    }

    public double applyAsDouble(int i) {
        return ((IntToDoubleFunction) this.wrappedValue).applyAsDouble(i);
    }

    public double applyAsDouble(long j) {
        return ((LongToDoubleFunction) this.wrappedValue).applyAsDouble(j);
    }

    public int applyAsInt(double d) {
        return ((DoubleToIntFunction) this.wrappedValue).applyAsInt(d);
    }

    public int applyAsInt(int i) {
        return ((IntUnaryOperator) this.wrappedValue).applyAsInt(i);
    }

    public /* synthetic */ int applyAsInt(int i, int i2) {
        return ((java.util.function.IntBinaryOperator) this.wrappedValue).applyAsInt(i, i2);
    }

    public int applyAsInt(long j) {
        return ((LongToIntFunction) this.wrappedValue).applyAsInt(j);
    }

    public /* synthetic */ long applyAsLong(double d) {
        return ((java.util.function.DoubleToLongFunction) this.wrappedValue).applyAsLong(d);
    }

    public /* synthetic */ long applyAsLong(int i) {
        return ((java.util.function.IntToLongFunction) this.wrappedValue).applyAsLong(i);
    }

    public /* synthetic */ long applyAsLong(long j) {
        return ((java.util.function.LongUnaryOperator) this.wrappedValue).applyAsLong(j);
    }

    public /* synthetic */ long applyAsLong(long j, long j2) {
        return ((java.util.function.LongBinaryOperator) this.wrappedValue).applyAsLong(j, j2);
    }

    public boolean test(double d) {
        return ((DoublePredicate) this.wrappedValue).test(d);
    }

    public boolean test(int i) {
        return ((IntPredicate) this.wrappedValue).test(i);
    }

    public boolean test(long j) {
        return ((LongPredicate) this.wrappedValue).test(j);
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(java.util.function.DoubleBinaryOperator doubleBinaryOperator) {
        this.wrappedValue = doubleBinaryOperator;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(java.util.function.DoubleFunction doubleFunction) {
        this.wrappedValue = doubleFunction;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(DoublePredicate doublePredicate) {
        this.wrappedValue = doublePredicate;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(DoubleToIntFunction doubleToIntFunction) {
        this.wrappedValue = doubleToIntFunction;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(java.util.function.DoubleToLongFunction doubleToLongFunction) {
        this.wrappedValue = doubleToLongFunction;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(DoubleUnaryOperator doubleUnaryOperator) {
        this.wrappedValue = doubleUnaryOperator;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(java.util.function.IntBinaryOperator intBinaryOperator) {
        this.wrappedValue = intBinaryOperator;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(IntPredicate intPredicate) {
        this.wrappedValue = intPredicate;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(IntToDoubleFunction intToDoubleFunction) {
        this.wrappedValue = intToDoubleFunction;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(java.util.function.IntToLongFunction intToLongFunction) {
        this.wrappedValue = intToLongFunction;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(IntUnaryOperator intUnaryOperator) {
        this.wrappedValue = intUnaryOperator;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(java.util.function.LongBinaryOperator longBinaryOperator) {
        this.wrappedValue = longBinaryOperator;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(java.util.function.LongFunction longFunction) {
        this.wrappedValue = longFunction;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(LongPredicate longPredicate) {
        this.wrappedValue = longPredicate;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(LongToDoubleFunction longToDoubleFunction) {
        this.wrappedValue = longToDoubleFunction;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(LongToIntFunction longToIntFunction) {
        this.wrappedValue = longToIntFunction;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(java.util.function.LongUnaryOperator longUnaryOperator) {
        this.wrappedValue = longUnaryOperator;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(java.util.function.ObjDoubleConsumer objDoubleConsumer) {
        this.wrappedValue = objDoubleConsumer;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(java.util.function.ObjIntConsumer objIntConsumer) {
        this.wrappedValue = objIntConsumer;
    }

    public /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP(java.util.function.ObjLongConsumer objLongConsumer) {
        this.wrappedValue = objLongConsumer;
    }
}
