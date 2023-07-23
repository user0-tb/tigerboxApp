package org.spongycastle.util;

public class StoreException extends RuntimeException {

    /* renamed from: _e */
    private Throwable f1511_e;

    public StoreException(String str, Throwable th) {
        super(str);
        this.f1511_e = th;
    }

    public Throwable getCause() {
        return this.f1511_e;
    }
}
