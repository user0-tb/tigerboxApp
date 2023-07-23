package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {

    /* renamed from: dP */
    private BigInteger f1165dP;

    /* renamed from: dQ */
    private BigInteger f1166dQ;

    /* renamed from: e */
    private BigInteger f1167e;

    /* renamed from: p */
    private BigInteger f1168p;

    /* renamed from: q */
    private BigInteger f1169q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(true, bigInteger, bigInteger3);
        this.f1167e = bigInteger2;
        this.f1168p = bigInteger4;
        this.f1169q = bigInteger5;
        this.f1165dP = bigInteger6;
        this.f1166dQ = bigInteger7;
        this.qInv = bigInteger8;
    }

    public BigInteger getPublicExponent() {
        return this.f1167e;
    }

    public BigInteger getP() {
        return this.f1168p;
    }

    public BigInteger getQ() {
        return this.f1169q;
    }

    public BigInteger getDP() {
        return this.f1165dP;
    }

    public BigInteger getDQ() {
        return this.f1166dQ;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}
