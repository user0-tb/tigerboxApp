package p009j$.wrappers;

import p009j$.util.function.ToIntFunction;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$function$ToIntFunction$-V-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$function$ToIntFunction$VWRP implements ToIntFunction {
    final /* synthetic */ java.util.function.ToIntFunction wrappedValue;

    private /* synthetic */ C$r8$wrapper$java$util$function$ToIntFunction$VWRP(java.util.function.ToIntFunction toIntFunction) {
        this.wrappedValue = toIntFunction;
    }

    public static /* synthetic */ ToIntFunction convert(java.util.function.ToIntFunction toIntFunction) {
        if (toIntFunction == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$function$ToIntFunction$VWRP(toIntFunction);
    }

    public /* synthetic */ int applyAsInt(Object obj) {
        return this.wrappedValue.applyAsInt(obj);
    }
}
