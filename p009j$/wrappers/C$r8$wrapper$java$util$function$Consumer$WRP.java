package p009j$.wrappers;

import java.util.function.Consumer;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$function$Consumer$-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$function$Consumer$WRP implements Consumer {
    final /* synthetic */ p009j$.util.function.Consumer wrappedValue;

    private /* synthetic */ C$r8$wrapper$java$util$function$Consumer$WRP(p009j$.util.function.Consumer consumer) {
        this.wrappedValue = consumer;
    }

    public static /* synthetic */ Consumer convert(p009j$.util.function.Consumer consumer) {
        if (consumer == null) {
            return null;
        }
        return consumer instanceof C$r8$wrapper$java$util$function$Consumer$VWRP ? ((C$r8$wrapper$java$util$function$Consumer$VWRP) consumer).wrappedValue : new C$r8$wrapper$java$util$function$Consumer$WRP(consumer);
    }

    public /* synthetic */ void accept(Object obj) {
        this.wrappedValue.accept(obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return convert(this.wrappedValue.andThen(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer)));
    }
}
