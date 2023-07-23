package org.spongycastle.asn1.p019ua;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

/* renamed from: org.spongycastle.asn1.ua.DSTU4145BinaryField */
public class DSTU4145BinaryField extends ASN1Object {

    /* renamed from: j */
    private int f700j;

    /* renamed from: k */
    private int f701k;

    /* renamed from: l */
    private int f702l;

    /* renamed from: m */
    private int f703m;

    private DSTU4145BinaryField(ASN1Sequence aSN1Sequence) {
        this.f703m = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getPositiveValue().intValue();
        if (aSN1Sequence.getObjectAt(1) instanceof ASN1Integer) {
            this.f701k = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).getPositiveValue().intValue();
        } else if (aSN1Sequence.getObjectAt(1) instanceof ASN1Sequence) {
            ASN1Sequence instance = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
            this.f701k = ASN1Integer.getInstance(instance.getObjectAt(0)).getPositiveValue().intValue();
            this.f700j = ASN1Integer.getInstance(instance.getObjectAt(1)).getPositiveValue().intValue();
            this.f702l = ASN1Integer.getInstance(instance.getObjectAt(2)).getPositiveValue().intValue();
        } else {
            throw new IllegalArgumentException("object parse error");
        }
    }

    public static DSTU4145BinaryField getInstance(Object obj) {
        if (obj instanceof DSTU4145BinaryField) {
            return (DSTU4145BinaryField) obj;
        }
        if (obj != null) {
            return new DSTU4145BinaryField(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DSTU4145BinaryField(int i, int i2, int i3, int i4) {
        this.f703m = i;
        this.f701k = i2;
        this.f700j = i3;
        this.f702l = i4;
    }

    public int getM() {
        return this.f703m;
    }

    public int getK1() {
        return this.f701k;
    }

    public int getK2() {
        return this.f700j;
    }

    public int getK3() {
        return this.f702l;
    }

    public DSTU4145BinaryField(int i, int i2) {
        this(i, i2, 0, 0);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.f703m));
        if (this.f700j == 0) {
            aSN1EncodableVector.add(new ASN1Integer((long) this.f701k));
        } else {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f701k));
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f700j));
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f702l));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
