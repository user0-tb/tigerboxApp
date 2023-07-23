package p009j$.wrappers;

import p009j$.util.function.Function;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$function$Function$-V-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$function$Function$VWRP implements Function {
    final /* synthetic */ java.util.function.Function wrappedValue;

    private /* synthetic */ C$r8$wrapper$java$util$function$Function$VWRP(java.util.function.Function function) {
        this.wrappedValue = function;
    }

    public static /* synthetic */ Function convert(java.util.function.Function function) {
        if (function == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$function$Function$VWRP(function);
    }

    public /* synthetic */ Object apply(Object obj) {
        return this.wrappedValue.apply(obj);
    }
}
