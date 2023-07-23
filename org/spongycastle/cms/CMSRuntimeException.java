package org.spongycastle.cms;

public class CMSRuntimeException extends RuntimeException {

    /* renamed from: e */
    Exception f771e;

    public CMSRuntimeException(String str) {
        super(str);
    }

    public CMSRuntimeException(String str, Exception exc) {
        super(str);
        this.f771e = exc;
    }

    public Exception getUnderlyingException() {
        return this.f771e;
    }

    public Throwable getCause() {
        return this.f771e;
    }
}
