package com.google.common.collect;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingObject {
    /* access modifiers changed from: protected */
    public abstract Object delegate();

    protected ForwardingObject() {
    }

    public String toString() {
        return delegate().toString();
    }
}
