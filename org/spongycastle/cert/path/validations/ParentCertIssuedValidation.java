package org.spongycastle.cert.path.validations;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.cert.CertException;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cert.X509ContentVerifierProviderBuilder;
import org.spongycastle.cert.path.CertPathValidation;
import org.spongycastle.cert.path.CertPathValidationContext;
import org.spongycastle.cert.path.CertPathValidationException;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.util.Memoable;

public class ParentCertIssuedValidation implements CertPathValidation {
    private X509ContentVerifierProviderBuilder contentVerifierProvider;
    private AlgorithmIdentifier workingAlgId;
    private X500Name workingIssuerName;
    private SubjectPublicKeyInfo workingPublicKey;

    public ParentCertIssuedValidation(X509ContentVerifierProviderBuilder x509ContentVerifierProviderBuilder) {
        this.contentVerifierProvider = x509ContentVerifierProviderBuilder;
    }

    public void validate(CertPathValidationContext certPathValidationContext, X509CertificateHolder x509CertificateHolder) throws CertPathValidationException {
        SubjectPublicKeyInfo subjectPublicKeyInfo;
        X500Name x500Name = this.workingIssuerName;
        if (x500Name == null || x500Name.equals(x509CertificateHolder.getIssuer())) {
            SubjectPublicKeyInfo subjectPublicKeyInfo2 = this.workingPublicKey;
            if (subjectPublicKeyInfo2 != null) {
                try {
                    if (subjectPublicKeyInfo2.getAlgorithm().equals(this.workingAlgId)) {
                        subjectPublicKeyInfo = this.workingPublicKey;
                    } else {
                        subjectPublicKeyInfo = new SubjectPublicKeyInfo(this.workingAlgId, (ASN1Encodable) this.workingPublicKey.parsePublicKey());
                    }
                    if (!x509CertificateHolder.isSignatureValid(this.contentVerifierProvider.build(subjectPublicKeyInfo))) {
                        throw new CertPathValidationException("Certificate signature not for public key in parent");
                    }
                } catch (OperatorCreationException e) {
                    throw new CertPathValidationException("Unable to create verifier: " + e.getMessage(), e);
                } catch (CertException e2) {
                    throw new CertPathValidationException("Unable to validate signature: " + e2.getMessage(), e2);
                } catch (IOException e3) {
                    throw new CertPathValidationException("Unable to build public key: " + e3.getMessage(), e3);
                }
            }
            this.workingIssuerName = x509CertificateHolder.getSubject();
            SubjectPublicKeyInfo subjectPublicKeyInfo3 = x509CertificateHolder.getSubjectPublicKeyInfo();
            this.workingPublicKey = subjectPublicKeyInfo3;
            if (this.workingAlgId == null) {
                this.workingAlgId = subjectPublicKeyInfo3.getAlgorithm();
            } else if (!subjectPublicKeyInfo3.getAlgorithm().getAlgorithm().equals(this.workingAlgId.getAlgorithm())) {
                this.workingAlgId = this.workingPublicKey.getAlgorithm();
            } else if (!isNull(this.workingPublicKey.getAlgorithm().getParameters())) {
                this.workingAlgId = this.workingPublicKey.getAlgorithm();
            }
        } else {
            throw new CertPathValidationException("Certificate issue does not match parent");
        }
    }

    private boolean isNull(ASN1Encodable aSN1Encodable) {
        return aSN1Encodable == null || (aSN1Encodable instanceof ASN1Null);
    }

    public Memoable copy() {
        ParentCertIssuedValidation parentCertIssuedValidation = new ParentCertIssuedValidation(this.contentVerifierProvider);
        parentCertIssuedValidation.workingAlgId = this.workingAlgId;
        parentCertIssuedValidation.workingIssuerName = this.workingIssuerName;
        parentCertIssuedValidation.workingPublicKey = this.workingPublicKey;
        return parentCertIssuedValidation;
    }

    public void reset(Memoable memoable) {
        ParentCertIssuedValidation parentCertIssuedValidation = (ParentCertIssuedValidation) memoable;
        this.contentVerifierProvider = parentCertIssuedValidation.contentVerifierProvider;
        this.workingAlgId = parentCertIssuedValidation.workingAlgId;
        this.workingIssuerName = parentCertIssuedValidation.workingIssuerName;
        this.workingPublicKey = parentCertIssuedValidation.workingPublicKey;
    }
}
