package org.spongycastle.cert.path.validations;

import java.util.Collection;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.cert.X509CRLHolder;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cert.path.CertPathValidation;
import org.spongycastle.cert.path.CertPathValidationContext;
import org.spongycastle.cert.path.CertPathValidationException;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Selector;
import org.spongycastle.util.Store;

public class CRLValidation implements CertPathValidation {
    private Store crls;
    /* access modifiers changed from: private */
    public X500Name workingIssuerName;

    public CRLValidation(X500Name x500Name, Store store) {
        this.workingIssuerName = x500Name;
        this.crls = store;
    }

    public void validate(CertPathValidationContext certPathValidationContext, X509CertificateHolder x509CertificateHolder) throws CertPathValidationException {
        Collection<X509CRLHolder> matches = this.crls.getMatches(new Selector() {
            public Object clone() {
                return this;
            }

            public boolean match(Object obj) {
                return ((X509CRLHolder) obj).getIssuer().equals(CRLValidation.this.workingIssuerName);
            }
        });
        if (!matches.isEmpty()) {
            for (X509CRLHolder revokedCertificate : matches) {
                if (revokedCertificate.getRevokedCertificate(x509CertificateHolder.getSerialNumber()) != null) {
                    throw new CertPathValidationException("Certificate revoked");
                }
            }
            this.workingIssuerName = x509CertificateHolder.getSubject();
            return;
        }
        throw new CertPathValidationException("CRL for " + this.workingIssuerName + " not found");
    }

    public Memoable copy() {
        return new CRLValidation(this.workingIssuerName, this.crls);
    }

    public void reset(Memoable memoable) {
        CRLValidation cRLValidation = (CRLValidation) memoable;
        this.workingIssuerName = cRLValidation.workingIssuerName;
        this.crls = cRLValidation.crls;
    }
}
