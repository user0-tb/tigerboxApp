package org.spongycastle.cert.path;

class CertPathValidationResultBuilder {
    public void addException(CertPathValidationException certPathValidationException) {
    }

    CertPathValidationResultBuilder() {
    }

    public CertPathValidationResult build() {
        return new CertPathValidationResult((CertPathValidationContext) null, 0, 0, (CertPathValidationException) null);
    }
}
