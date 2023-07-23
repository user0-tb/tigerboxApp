package com.google.common.collect;

import java.util.Iterator;
import p009j$.util.Iterator;
import p009j$.util.function.Consumer;
import p009j$.wrappers.C$r8$wrapper$java$util$function$Consumer$VWRP;

@ElementTypesAreNonnullByDefault
public abstract class UnmodifiableIterator<E> implements Iterator<E>, p009j$.util.Iterator {
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
    }

    protected UnmodifiableIterator() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
