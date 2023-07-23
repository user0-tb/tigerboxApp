package p009j$.wrappers;

import java.util.Set;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Function;
import p009j$.util.function.Supplier;
import p009j$.util.stream.Collector;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$stream$Collector$-V-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$stream$Collector$VWRP implements Collector {
    final /* synthetic */ java.util.stream.Collector wrappedValue;

    private /* synthetic */ C$r8$wrapper$java$util$stream$Collector$VWRP(java.util.stream.Collector collector) {
        this.wrappedValue = collector;
    }

    public static /* synthetic */ Collector convert(java.util.stream.Collector collector) {
        if (collector == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$stream$Collector$VWRP(collector);
    }

    public /* synthetic */ BiConsumer accumulator() {
        return C$r8$wrapper$java$util$function$BiConsumer$VWRP.convert(this.wrappedValue.accumulator());
    }

    public /* synthetic */ Set characteristics() {
        return this.wrappedValue.characteristics();
    }

    public /* synthetic */ BinaryOperator combiner() {
        return C$r8$wrapper$java$util$function$IntPredicate$VWRP.convert(this.wrappedValue.combiner());
    }

    public /* synthetic */ Function finisher() {
        return C$r8$wrapper$java$util$function$Function$VWRP.convert(this.wrappedValue.finisher());
    }

    public /* synthetic */ Supplier supplier() {
        return C$r8$wrapper$java$util$function$Supplier$VWRP.convert(this.wrappedValue.supplier());
    }
}
