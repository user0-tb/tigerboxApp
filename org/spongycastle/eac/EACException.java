package org.spongycastle.eac;

public class EACException extends Exception {
    private Throwable cause;

    public EACException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public EACException(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }
}
