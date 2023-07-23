package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PublicKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f1250a;

    /* renamed from: p */
    private BigInteger f1251p;

    /* renamed from: q */
    private BigInteger f1252q;

    /* renamed from: y */
    private BigInteger f1253y;

    public GOST3410PublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f1253y = bigInteger;
        this.f1251p = bigInteger2;
        this.f1252q = bigInteger3;
        this.f1250a = bigInteger4;
    }

    public BigInteger getY() {
        return this.f1253y;
    }

    public BigInteger getP() {
        return this.f1251p;
    }

    public BigInteger getQ() {
        return this.f1252q;
    }

    public BigInteger getA() {
        return this.f1250a;
    }
}
