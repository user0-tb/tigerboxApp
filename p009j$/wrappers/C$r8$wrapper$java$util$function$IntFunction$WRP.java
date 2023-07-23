package p009j$.wrappers;

import java.util.function.IntFunction;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$function$IntFunction$-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$function$IntFunction$WRP implements IntFunction {
    final /* synthetic */ p009j$.util.function.IntFunction wrappedValue;

    private /* synthetic */ C$r8$wrapper$java$util$function$IntFunction$WRP(p009j$.util.function.IntFunction intFunction) {
        this.wrappedValue = intFunction;
    }

    public static /* synthetic */ IntFunction convert(p009j$.util.function.IntFunction intFunction) {
        if (intFunction == null) {
            return null;
        }
        return intFunction instanceof C$r8$wrapper$java$util$function$IntFunction$VWRP ? ((C$r8$wrapper$java$util$function$IntFunction$VWRP) intFunction).wrappedValue : new C$r8$wrapper$java$util$function$IntFunction$WRP(intFunction);
    }

    public /* synthetic */ Object apply(int i) {
        return this.wrappedValue.apply(i);
    }
}
