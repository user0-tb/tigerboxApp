package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class GOST3410PrivateKeyParameters extends GOST3410KeyParameters {

    /* renamed from: x */
    private BigInteger f1149x;

    public GOST3410PrivateKeyParameters(BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        super(true, gOST3410Parameters);
        this.f1149x = bigInteger;
    }

    public BigInteger getX() {
        return this.f1149x;
    }
}
