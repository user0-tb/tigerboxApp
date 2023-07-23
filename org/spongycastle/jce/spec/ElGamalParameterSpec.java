package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: g */
    private BigInteger f1239g;

    /* renamed from: p */
    private BigInteger f1240p;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f1240p = bigInteger;
        this.f1239g = bigInteger2;
    }

    public BigInteger getP() {
        return this.f1240p;
    }

    public BigInteger getG() {
        return this.f1239g;
    }
}
