package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PrivateKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f1243a;

    /* renamed from: p */
    private BigInteger f1244p;

    /* renamed from: q */
    private BigInteger f1245q;

    /* renamed from: x */
    private BigInteger f1246x;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f1246x = bigInteger;
        this.f1244p = bigInteger2;
        this.f1245q = bigInteger3;
        this.f1243a = bigInteger4;
    }

    public BigInteger getX() {
        return this.f1246x;
    }

    public BigInteger getP() {
        return this.f1244p;
    }

    public BigInteger getQ() {
        return this.f1245q;
    }

    public BigInteger getA() {
        return this.f1243a;
    }
}
