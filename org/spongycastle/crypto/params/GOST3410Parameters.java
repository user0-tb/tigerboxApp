package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class GOST3410Parameters implements CipherParameters {

    /* renamed from: a */
    private BigInteger f1146a;

    /* renamed from: p */
    private BigInteger f1147p;

    /* renamed from: q */
    private BigInteger f1148q;
    private GOST3410ValidationParameters validation;

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f1147p = bigInteger;
        this.f1148q = bigInteger2;
        this.f1146a = bigInteger3;
    }

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, GOST3410ValidationParameters gOST3410ValidationParameters) {
        this.f1146a = bigInteger3;
        this.f1147p = bigInteger;
        this.f1148q = bigInteger2;
        this.validation = gOST3410ValidationParameters;
    }

    public BigInteger getP() {
        return this.f1147p;
    }

    public BigInteger getQ() {
        return this.f1148q;
    }

    public BigInteger getA() {
        return this.f1146a;
    }

    public GOST3410ValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (this.f1147p.hashCode() ^ this.f1148q.hashCode()) ^ this.f1146a.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410Parameters)) {
            return false;
        }
        GOST3410Parameters gOST3410Parameters = (GOST3410Parameters) obj;
        if (!gOST3410Parameters.getP().equals(this.f1147p) || !gOST3410Parameters.getQ().equals(this.f1148q) || !gOST3410Parameters.getA().equals(this.f1146a)) {
            return false;
        }
        return true;
    }
}
