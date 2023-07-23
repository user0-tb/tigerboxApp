package org.spongycastle.eac;

import java.io.IOException;

public class EACIOException extends IOException {
    private Throwable cause;

    public EACIOException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public EACIOException(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }
}
