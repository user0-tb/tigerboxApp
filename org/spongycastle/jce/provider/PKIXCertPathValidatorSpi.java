package org.spongycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathValidatorSpi extends CertPathValidatorSpi {
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        ExtendedPKIXParameters extendedPKIXParameters;
        PublicKey publicKey;
        X500Principal x500Principal;
        HashSet hashSet;
        List list;
        ArrayList[] arrayListArr;
        int i;
        HashSet hashSet2;
        CertPath certPath2 = certPath;
        CertPathParameters certPathParameters2 = certPathParameters;
        if (certPathParameters2 instanceof PKIXParameters) {
            if (certPathParameters2 instanceof ExtendedPKIXParameters) {
                extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters2;
            } else {
                extendedPKIXParameters = ExtendedPKIXParameters.getInstance((PKIXParameters) certPathParameters2);
            }
            if (extendedPKIXParameters.getTrustAnchors() != null) {
                List<? extends Certificate> certificates = certPath.getCertificates();
                int size = certificates.size();
                if (!certificates.isEmpty()) {
                    Set initialPolicies = extendedPKIXParameters.getInitialPolicies();
                    try {
                        TrustAnchor findTrustAnchor = CertPathValidatorUtilities.findTrustAnchor((X509Certificate) certificates.get(certificates.size() - 1), extendedPKIXParameters.getTrustAnchors(), extendedPKIXParameters.getSigProvider());
                        if (findTrustAnchor != null) {
                            int i2 = size + 1;
                            ArrayList[] arrayListArr2 = new ArrayList[i2];
                            for (int i3 = 0; i3 < i2; i3++) {
                                arrayListArr2[i3] = new ArrayList();
                            }
                            HashSet hashSet3 = new HashSet();
                            hashSet3.add(RFC3280CertPathUtilities.ANY_POLICY);
                            PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet3, (PolicyNode) null, new HashSet(), RFC3280CertPathUtilities.ANY_POLICY, false);
                            arrayListArr2[0].add(pKIXPolicyNode);
                            PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
                            HashSet hashSet4 = new HashSet();
                            int i4 = extendedPKIXParameters.isExplicitPolicyRequired() ? 0 : i2;
                            int i5 = extendedPKIXParameters.isAnyPolicyInhibited() ? 0 : i2;
                            if (extendedPKIXParameters.isPolicyMappingInhibited()) {
                                i2 = 0;
                            }
                            X509Certificate trustedCert = findTrustAnchor.getTrustedCert();
                            if (trustedCert != null) {
                                try {
                                    X500Principal subjectPrincipal = CertPathValidatorUtilities.getSubjectPrincipal(trustedCert);
                                    publicKey = trustedCert.getPublicKey();
                                    x500Principal = subjectPrincipal;
                                } catch (IllegalArgumentException e) {
                                    throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e, certPath2, -1);
                                }
                            } else {
                                x500Principal = new X500Principal(findTrustAnchor.getCAName());
                                publicKey = findTrustAnchor.getCAPublicKey();
                            }
                            try {
                                AlgorithmIdentifier algorithmIdentifier = CertPathValidatorUtilities.getAlgorithmIdentifier(publicKey);
                                algorithmIdentifier.getAlgorithm();
                                algorithmIdentifier.getParameters();
                                if (extendedPKIXParameters.getTargetConstraints() == null || extendedPKIXParameters.getTargetConstraints().match((X509Certificate) certificates.get(0))) {
                                    List<PKIXCertPathChecker> certPathCheckers = extendedPKIXParameters.getCertPathCheckers();
                                    for (PKIXCertPathChecker init : certPathCheckers) {
                                        init.init(false);
                                        x500Principal = x500Principal;
                                    }
                                    X500Principal x500Principal2 = x500Principal;
                                    int i6 = size;
                                    PublicKey publicKey2 = publicKey;
                                    X509Certificate x509Certificate = trustedCert;
                                    PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
                                    int i7 = i2;
                                    int i8 = i5;
                                    int size2 = certificates.size() - 1;
                                    X509Certificate x509Certificate2 = null;
                                    while (size2 >= 0) {
                                        X509Certificate x509Certificate3 = (X509Certificate) certificates.get(size2);
                                        int i9 = size - size2;
                                        List<? extends Certificate> list2 = certificates;
                                        boolean z = size2 == certificates.size() + -1;
                                        int i10 = i9;
                                        CertPath certPath3 = certPath;
                                        int i11 = i8;
                                        TrustAnchor trustAnchor = findTrustAnchor;
                                        int i12 = i4;
                                        Set set = initialPolicies;
                                        int i13 = i7;
                                        List list3 = certPathCheckers;
                                        int i14 = size2;
                                        boolean z2 = z;
                                        PKIXNameConstraintValidator pKIXNameConstraintValidator2 = pKIXNameConstraintValidator;
                                        ArrayList[] arrayListArr3 = arrayListArr2;
                                        RFC3280CertPathUtilities.processCertA(certPath3, extendedPKIXParameters, size2, publicKey2, z2, x500Principal2, x509Certificate);
                                        RFC3280CertPathUtilities.processCertBC(certPath2, i14, pKIXNameConstraintValidator2);
                                        PKIXPolicyNode processCertE = RFC3280CertPathUtilities.processCertE(certPath2, i14, RFC3280CertPathUtilities.processCertD(certPath3, i14, hashSet4, pKIXPolicyNode2, arrayListArr3, i11));
                                        RFC3280CertPathUtilities.processCertF(certPath2, i14, processCertE, i12);
                                        if (i10 == size) {
                                            list = list3;
                                            arrayListArr = arrayListArr3;
                                            pKIXPolicyNode2 = processCertE;
                                            i8 = i11;
                                            i7 = i13;
                                            i = i12;
                                        } else if (x509Certificate3 == null || x509Certificate3.getVersion() != 1) {
                                            RFC3280CertPathUtilities.prepareNextCertA(certPath2, i14);
                                            arrayListArr = arrayListArr3;
                                            PKIXPolicyNode prepareCertB = RFC3280CertPathUtilities.prepareCertB(certPath2, i14, arrayListArr, processCertE, i13);
                                            RFC3280CertPathUtilities.prepareNextCertG(certPath2, i14, pKIXNameConstraintValidator2);
                                            int prepareNextCertH1 = RFC3280CertPathUtilities.prepareNextCertH1(certPath2, i14, i12);
                                            int prepareNextCertH2 = RFC3280CertPathUtilities.prepareNextCertH2(certPath2, i14, i13);
                                            int prepareNextCertH3 = RFC3280CertPathUtilities.prepareNextCertH3(certPath2, i14, i11);
                                            int prepareNextCertI1 = RFC3280CertPathUtilities.prepareNextCertI1(certPath2, i14, prepareNextCertH1);
                                            int prepareNextCertI2 = RFC3280CertPathUtilities.prepareNextCertI2(certPath2, i14, prepareNextCertH2);
                                            int prepareNextCertJ = RFC3280CertPathUtilities.prepareNextCertJ(certPath2, i14, prepareNextCertH3);
                                            RFC3280CertPathUtilities.prepareNextCertK(certPath2, i14);
                                            i6 = RFC3280CertPathUtilities.prepareNextCertM(certPath2, i14, RFC3280CertPathUtilities.prepareNextCertL(certPath2, i14, i6));
                                            RFC3280CertPathUtilities.prepareNextCertN(certPath2, i14);
                                            Set criticalExtensionOIDs = x509Certificate3.getCriticalExtensionOIDs();
                                            if (criticalExtensionOIDs != null) {
                                                hashSet2 = new HashSet(criticalExtensionOIDs);
                                                hashSet2.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                                hashSet2.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                                hashSet2.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                                hashSet2.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                                hashSet2.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                                hashSet2.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                                hashSet2.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                                hashSet2.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                                hashSet2.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                                hashSet2.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                            } else {
                                                hashSet2 = new HashSet();
                                            }
                                            list = list3;
                                            RFC3280CertPathUtilities.prepareNextCertO(certPath2, i14, hashSet2, list);
                                            X500Principal subjectPrincipal2 = CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate3);
                                            try {
                                                PublicKey nextWorkingKey = CertPathValidatorUtilities.getNextWorkingKey(certPath.getCertificates(), i14);
                                                AlgorithmIdentifier algorithmIdentifier2 = CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey);
                                                algorithmIdentifier2.getAlgorithm();
                                                algorithmIdentifier2.getParameters();
                                                pKIXPolicyNode2 = prepareCertB;
                                                x500Principal2 = subjectPrincipal2;
                                                publicKey2 = nextWorkingKey;
                                                x509Certificate = x509Certificate3;
                                                int i15 = prepareNextCertI2;
                                                i = prepareNextCertI1;
                                                i8 = prepareNextCertJ;
                                                i7 = i15;
                                            } catch (CertPathValidatorException e2) {
                                                throw new CertPathValidatorException("Next working key could not be retrieved.", e2, certPath2, i14);
                                            }
                                        } else {
                                            throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", (Throwable) null, certPath2, i14);
                                        }
                                        int i16 = i14 - 1;
                                        arrayListArr2 = arrayListArr;
                                        certPathCheckers = list;
                                        pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                                        certificates = list2;
                                        findTrustAnchor = trustAnchor;
                                        initialPolicies = set;
                                        size2 = i16;
                                        x509Certificate2 = x509Certificate3;
                                    }
                                    List list4 = certPathCheckers;
                                    Set set2 = initialPolicies;
                                    TrustAnchor trustAnchor2 = findTrustAnchor;
                                    int i17 = size2;
                                    ArrayList[] arrayListArr4 = arrayListArr2;
                                    int i18 = i17 + 1;
                                    int wrapupCertB = RFC3280CertPathUtilities.wrapupCertB(certPath2, i18, RFC3280CertPathUtilities.wrapupCertA(i4, x509Certificate2));
                                    Set criticalExtensionOIDs2 = x509Certificate2.getCriticalExtensionOIDs();
                                    if (criticalExtensionOIDs2 != null) {
                                        hashSet = new HashSet(criticalExtensionOIDs2);
                                        hashSet.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                        hashSet.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                        hashSet.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                        hashSet.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                        hashSet.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                        hashSet.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                        hashSet.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                        hashSet.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                        hashSet.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                        hashSet.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                        hashSet.remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
                                    } else {
                                        hashSet = new HashSet();
                                    }
                                    RFC3280CertPathUtilities.wrapupCertF(certPath2, i18, list4, hashSet);
                                    X509Certificate x509Certificate4 = x509Certificate2;
                                    PKIXPolicyNode wrapupCertG = RFC3280CertPathUtilities.wrapupCertG(certPath, extendedPKIXParameters, set2, i18, arrayListArr4, pKIXPolicyNode2, hashSet4);
                                    if (wrapupCertB > 0 || wrapupCertG != null) {
                                        return new PKIXCertPathValidatorResult(trustAnchor2, wrapupCertG, x509Certificate4.getPublicKey());
                                    }
                                    throw new CertPathValidatorException("Path processing failed on policy.", (Throwable) null, certPath2, i17);
                                }
                                throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", (Throwable) null, certPath2, 0);
                            } catch (CertPathValidatorException e3) {
                                throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e3, certPath2, -1);
                            }
                        } else {
                            throw new CertPathValidatorException("Trust anchor for certification path not found.", (Throwable) null, certPath2, -1);
                        }
                    } catch (AnnotatedException e4) {
                        throw new CertPathValidatorException(e4.getMessage(), e4, certPath2, certificates.size() - 1);
                    }
                } else {
                    throw new CertPathValidatorException("Certification path is empty.", (Throwable) null, certPath2, 0);
                }
            } else {
                throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
            }
        } else {
            throw new InvalidAlgorithmParameterException("Parameters must be a " + PKIXParameters.class.getName() + " instance.");
        }
    }
}
