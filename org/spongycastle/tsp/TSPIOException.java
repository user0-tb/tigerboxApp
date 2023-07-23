package org.spongycastle.tsp;

import java.io.IOException;

public class TSPIOException extends IOException {
    Throwable underlyingException;

    public TSPIOException(String str) {
        super(str);
    }

    public TSPIOException(String str, Throwable th) {
        super(str);
        this.underlyingException = th;
    }

    public Exception getUnderlyingException() {
        return (Exception) this.underlyingException;
    }

    public Throwable getCause() {
        return this.underlyingException;
    }
}
