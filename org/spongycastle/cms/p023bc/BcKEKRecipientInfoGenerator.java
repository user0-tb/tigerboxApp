package org.spongycastle.cms.p023bc;

import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.cms.KEKIdentifier;
import org.spongycastle.asn1.cms.OtherKeyAttribute;
import org.spongycastle.cms.KEKRecipientInfoGenerator;
import org.spongycastle.operator.p031bc.BcSymmetricKeyWrapper;

/* renamed from: org.spongycastle.cms.bc.BcKEKRecipientInfoGenerator */
public class BcKEKRecipientInfoGenerator extends KEKRecipientInfoGenerator {
    public BcKEKRecipientInfoGenerator(KEKIdentifier kEKIdentifier, BcSymmetricKeyWrapper bcSymmetricKeyWrapper) {
        super(kEKIdentifier, bcSymmetricKeyWrapper);
    }

    public BcKEKRecipientInfoGenerator(byte[] bArr, BcSymmetricKeyWrapper bcSymmetricKeyWrapper) {
        this(new KEKIdentifier(bArr, (ASN1GeneralizedTime) null, (OtherKeyAttribute) null), bcSymmetricKeyWrapper);
    }
}
