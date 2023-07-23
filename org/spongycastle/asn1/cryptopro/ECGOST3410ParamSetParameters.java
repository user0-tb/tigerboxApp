package org.spongycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

public class ECGOST3410ParamSetParameters extends ASN1Object {

    /* renamed from: a */
    ASN1Integer f669a;

    /* renamed from: b */
    ASN1Integer f670b;

    /* renamed from: p */
    ASN1Integer f671p;

    /* renamed from: q */
    ASN1Integer f672q;

    /* renamed from: x */
    ASN1Integer f673x;

    /* renamed from: y */
    ASN1Integer f674y;

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof ECGOST3410ParamSetParameters)) {
            return (ECGOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i, BigInteger bigInteger5) {
        this.f669a = new ASN1Integer(bigInteger);
        this.f670b = new ASN1Integer(bigInteger2);
        this.f671p = new ASN1Integer(bigInteger3);
        this.f672q = new ASN1Integer(bigInteger4);
        this.f673x = new ASN1Integer((long) i);
        this.f674y = new ASN1Integer(bigInteger5);
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f669a = (ASN1Integer) objects.nextElement();
        this.f670b = (ASN1Integer) objects.nextElement();
        this.f671p = (ASN1Integer) objects.nextElement();
        this.f672q = (ASN1Integer) objects.nextElement();
        this.f673x = (ASN1Integer) objects.nextElement();
        this.f674y = (ASN1Integer) objects.nextElement();
    }

    public BigInteger getP() {
        return this.f671p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f672q.getPositiveValue();
    }

    public BigInteger getA() {
        return this.f669a.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f669a);
        aSN1EncodableVector.add(this.f670b);
        aSN1EncodableVector.add(this.f671p);
        aSN1EncodableVector.add(this.f672q);
        aSN1EncodableVector.add(this.f673x);
        aSN1EncodableVector.add(this.f674y);
        return new DERSequence(aSN1EncodableVector);
    }
}
