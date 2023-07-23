package org.spongycastle.cms.p023bc;

import org.spongycastle.asn1.cms.IssuerAndSerialNumber;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cms.KeyTransRecipientInfoGenerator;
import org.spongycastle.operator.AsymmetricKeyWrapper;
import org.spongycastle.operator.p031bc.BcAsymmetricKeyWrapper;

/* renamed from: org.spongycastle.cms.bc.BcKeyTransRecipientInfoGenerator */
public abstract class BcKeyTransRecipientInfoGenerator extends KeyTransRecipientInfoGenerator {
    public BcKeyTransRecipientInfoGenerator(X509CertificateHolder x509CertificateHolder, BcAsymmetricKeyWrapper bcAsymmetricKeyWrapper) {
        super(new IssuerAndSerialNumber(x509CertificateHolder.toASN1Structure()), (AsymmetricKeyWrapper) bcAsymmetricKeyWrapper);
    }

    public BcKeyTransRecipientInfoGenerator(byte[] bArr, BcAsymmetricKeyWrapper bcAsymmetricKeyWrapper) {
        super(bArr, (AsymmetricKeyWrapper) bcAsymmetricKeyWrapper);
    }
}
