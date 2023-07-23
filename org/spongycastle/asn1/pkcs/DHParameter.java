package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class DHParameter extends ASN1Object {

    /* renamed from: g */
    ASN1Integer f695g;

    /* renamed from: l */
    ASN1Integer f696l;

    /* renamed from: p */
    ASN1Integer f697p;

    public DHParameter(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f697p = new ASN1Integer(bigInteger);
        this.f695g = new ASN1Integer(bigInteger2);
        if (i != 0) {
            this.f696l = new ASN1Integer((long) i);
        } else {
            this.f696l = null;
        }
    }

    public static DHParameter getInstance(Object obj) {
        if (obj instanceof DHParameter) {
            return (DHParameter) obj;
        }
        if (obj != null) {
            return new DHParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private DHParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f697p = ASN1Integer.getInstance(objects.nextElement());
        this.f695g = ASN1Integer.getInstance(objects.nextElement());
        if (objects.hasMoreElements()) {
            this.f696l = (ASN1Integer) objects.nextElement();
        } else {
            this.f696l = null;
        }
    }

    public BigInteger getP() {
        return this.f697p.getPositiveValue();
    }

    public BigInteger getG() {
        return this.f695g.getPositiveValue();
    }

    public BigInteger getL() {
        ASN1Integer aSN1Integer = this.f696l;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f697p);
        aSN1EncodableVector.add(this.f695g);
        if (getL() != null) {
            aSN1EncodableVector.add(this.f696l);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
