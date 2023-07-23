package org.spongycastle.cms;

public class CMSException extends Exception {

    /* renamed from: e */
    Exception f770e;

    public CMSException(String str) {
        super(str);
    }

    public CMSException(String str, Exception exc) {
        super(str);
        this.f770e = exc;
    }

    public Exception getUnderlyingException() {
        return this.f770e;
    }

    public Throwable getCause() {
        return this.f770e;
    }
}
