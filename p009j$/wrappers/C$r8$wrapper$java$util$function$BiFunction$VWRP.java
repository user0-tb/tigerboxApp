package p009j$.wrappers;

import p009j$.util.function.BiFunction;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$function$BiFunction$-V-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$function$BiFunction$VWRP implements BiFunction {
    final /* synthetic */ java.util.function.BiFunction wrappedValue;

    private /* synthetic */ C$r8$wrapper$java$util$function$BiFunction$VWRP(java.util.function.BiFunction biFunction) {
        this.wrappedValue = biFunction;
    }

    public static /* synthetic */ BiFunction convert(java.util.function.BiFunction biFunction) {
        if (biFunction == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$function$BiFunction$VWRP(biFunction);
    }

    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.wrappedValue.apply(obj, obj2);
    }
}
