package org.spongycastle.cms;

public class CMSAttributeTableGenerationException extends CMSRuntimeException {

    /* renamed from: e */
    Exception f769e;

    public CMSAttributeTableGenerationException(String str) {
        super(str);
    }

    public CMSAttributeTableGenerationException(String str, Exception exc) {
        super(str);
        this.f769e = exc;
    }

    public Exception getUnderlyingException() {
        return this.f769e;
    }

    public Throwable getCause() {
        return this.f769e;
    }
}
