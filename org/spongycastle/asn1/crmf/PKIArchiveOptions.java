package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

public class PKIArchiveOptions extends ASN1Object implements ASN1Choice {
    public static final int archiveRemGenPrivKey = 2;
    public static final int encryptedPrivKey = 0;
    public static final int keyGenParameters = 1;
    private ASN1Encodable value;

    public static PKIArchiveOptions getInstance(Object obj) {
        if (obj == null || (obj instanceof PKIArchiveOptions)) {
            return (PKIArchiveOptions) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new PKIArchiveOptions((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("unknown object: " + obj);
    }

    private PKIArchiveOptions(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            this.value = EncryptedKey.getInstance(aSN1TaggedObject.getObject());
        } else if (tagNo == 1) {
            this.value = ASN1OctetString.getInstance(aSN1TaggedObject, false);
        } else if (tagNo == 2) {
            this.value = ASN1Boolean.getInstance(aSN1TaggedObject, false);
        } else {
            throw new IllegalArgumentException("unknown tag number: " + aSN1TaggedObject.getTagNo());
        }
    }

    public PKIArchiveOptions(EncryptedKey encryptedKey) {
        this.value = encryptedKey;
    }

    public PKIArchiveOptions(ASN1OctetString aSN1OctetString) {
        this.value = aSN1OctetString;
    }

    public PKIArchiveOptions(boolean z) {
        this.value = ASN1Boolean.getInstance(z);
    }

    public int getType() {
        ASN1Encodable aSN1Encodable = this.value;
        if (aSN1Encodable instanceof EncryptedKey) {
            return 0;
        }
        return aSN1Encodable instanceof ASN1OctetString ? 1 : 2;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1Encodable aSN1Encodable = this.value;
        if (aSN1Encodable instanceof EncryptedKey) {
            return new DERTaggedObject(true, 0, this.value);
        }
        if (aSN1Encodable instanceof ASN1OctetString) {
            return new DERTaggedObject(false, 1, this.value);
        }
        return new DERTaggedObject(false, 2, this.value);
    }
}
