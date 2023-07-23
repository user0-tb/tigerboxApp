package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class DSAParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f1131g;

    /* renamed from: p */
    private BigInteger f1132p;

    /* renamed from: q */
    private BigInteger f1133q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f1131g = bigInteger3;
        this.f1132p = bigInteger;
        this.f1133q = bigInteger2;
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f1131g = bigInteger3;
        this.f1132p = bigInteger;
        this.f1133q = bigInteger2;
        this.validation = dSAValidationParameters;
    }

    public BigInteger getP() {
        return this.f1132p;
    }

    public BigInteger getQ() {
        return this.f1133q;
    }

    public BigInteger getG() {
        return this.f1131g;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        if (!dSAParameters.getP().equals(this.f1132p) || !dSAParameters.getQ().equals(this.f1133q) || !dSAParameters.getG().equals(this.f1131g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }
}
