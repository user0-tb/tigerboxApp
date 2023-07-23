package org.spongycastle.x509.util;

public class StreamParsingException extends Exception {

    /* renamed from: _e */
    Throwable f1514_e;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.f1514_e = th;
    }

    public Throwable getCause() {
        return this.f1514_e;
    }
}
