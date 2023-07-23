package p009j$.wrappers;

import p009j$.util.function.DoubleConsumer;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$function$DoubleConsumer$-V-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$function$DoubleConsumer$VWRP implements DoubleConsumer {
    final /* synthetic */ java.util.function.DoubleConsumer wrappedValue;

    private /* synthetic */ C$r8$wrapper$java$util$function$DoubleConsumer$VWRP(java.util.function.DoubleConsumer doubleConsumer) {
        this.wrappedValue = doubleConsumer;
    }

    public static /* synthetic */ DoubleConsumer convert(java.util.function.DoubleConsumer doubleConsumer) {
        if (doubleConsumer == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$function$DoubleConsumer$VWRP(doubleConsumer);
    }

    public /* synthetic */ void accept(double d) {
        this.wrappedValue.accept(d);
    }
}
