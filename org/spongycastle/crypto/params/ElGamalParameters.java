package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class ElGamalParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f1141g;

    /* renamed from: l */
    private int f1142l;

    /* renamed from: p */
    private BigInteger f1143p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f1141g = bigInteger2;
        this.f1143p = bigInteger;
        this.f1142l = i;
    }

    public BigInteger getP() {
        return this.f1143p;
    }

    public BigInteger getG() {
        return this.f1141g;
    }

    public int getL() {
        return this.f1142l;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        if (!elGamalParameters.getP().equals(this.f1143p) || !elGamalParameters.getG().equals(this.f1141g) || elGamalParameters.getL() != this.f1142l) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.f1142l;
    }
}
