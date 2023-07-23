package org.spongycastle.asn1.oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class ElGamalParameter extends ASN1Object {

    /* renamed from: g */
    ASN1Integer f693g;

    /* renamed from: p */
    ASN1Integer f694p;

    public ElGamalParameter(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f694p = new ASN1Integer(bigInteger);
        this.f693g = new ASN1Integer(bigInteger2);
    }

    private ElGamalParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f694p = (ASN1Integer) objects.nextElement();
        this.f693g = (ASN1Integer) objects.nextElement();
    }

    public static ElGamalParameter getInstance(Object obj) {
        if (obj instanceof ElGamalParameter) {
            return (ElGamalParameter) obj;
        }
        if (obj != null) {
            return new ElGamalParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getP() {
        return this.f694p.getPositiveValue();
    }

    public BigInteger getG() {
        return this.f693g.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f694p);
        aSN1EncodableVector.add(this.f693g);
        return new DERSequence(aSN1EncodableVector);
    }
}
