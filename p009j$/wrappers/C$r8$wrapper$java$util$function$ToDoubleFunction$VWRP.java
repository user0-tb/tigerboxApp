package p009j$.wrappers;

import p009j$.util.function.ToDoubleFunction;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$function$ToDoubleFunction$-V-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$function$ToDoubleFunction$VWRP implements ToDoubleFunction {
    final /* synthetic */ java.util.function.ToDoubleFunction wrappedValue;

    private /* synthetic */ C$r8$wrapper$java$util$function$ToDoubleFunction$VWRP(java.util.function.ToDoubleFunction toDoubleFunction) {
        this.wrappedValue = toDoubleFunction;
    }

    public static /* synthetic */ ToDoubleFunction convert(java.util.function.ToDoubleFunction toDoubleFunction) {
        if (toDoubleFunction == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$function$ToDoubleFunction$VWRP(toDoubleFunction);
    }

    public /* synthetic */ double applyAsDouble(Object obj) {
        return this.wrappedValue.applyAsDouble(obj);
    }
}
