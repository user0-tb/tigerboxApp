package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

public class RecipientIdentifier extends ASN1Object implements ASN1Choice {

    /* renamed from: id */
    private ASN1Encodable f667id;

    public RecipientIdentifier(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.f667id = issuerAndSerialNumber;
    }

    public RecipientIdentifier(ASN1OctetString aSN1OctetString) {
        this.f667id = new DERTaggedObject(false, 0, aSN1OctetString);
    }

    public RecipientIdentifier(ASN1Primitive aSN1Primitive) {
        this.f667id = aSN1Primitive;
    }

    public static RecipientIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof RecipientIdentifier)) {
            return (RecipientIdentifier) obj;
        }
        if (obj instanceof IssuerAndSerialNumber) {
            return new RecipientIdentifier((IssuerAndSerialNumber) obj);
        }
        if (obj instanceof ASN1OctetString) {
            return new RecipientIdentifier((ASN1OctetString) obj);
        }
        if (obj instanceof ASN1Primitive) {
            return new RecipientIdentifier((ASN1Primitive) obj);
        }
        throw new IllegalArgumentException("Illegal object in RecipientIdentifier: " + obj.getClass().getName());
    }

    public boolean isTagged() {
        return this.f667id instanceof ASN1TaggedObject;
    }

    public ASN1Encodable getId() {
        ASN1Encodable aSN1Encodable = this.f667id;
        if (aSN1Encodable instanceof ASN1TaggedObject) {
            return ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Encodable, false);
        }
        return IssuerAndSerialNumber.getInstance(aSN1Encodable);
    }

    public ASN1Primitive toASN1Primitive() {
        return this.f667id.toASN1Primitive();
    }
}
