package org.spongycastle.asn1.p020x9;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.math.p030ec.ECCurve;
import org.spongycastle.math.p030ec.ECPoint;

/* renamed from: org.spongycastle.asn1.x9.X9ECPoint */
public class X9ECPoint extends ASN1Object {

    /* renamed from: p */
    ECPoint f752p;

    public X9ECPoint(ECPoint eCPoint) {
        this.f752p = eCPoint.normalize();
    }

    public X9ECPoint(ECCurve eCCurve, ASN1OctetString aSN1OctetString) {
        this.f752p = eCCurve.decodePoint(aSN1OctetString.getOctets());
    }

    public ECPoint getPoint() {
        return this.f752p;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(this.f752p.getEncoded());
    }
}
