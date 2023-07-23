package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;

public class CramerShoupParameters implements CipherParameters {

    /* renamed from: H */
    private Digest f1108H;

    /* renamed from: g1 */
    private BigInteger f1109g1;

    /* renamed from: g2 */
    private BigInteger f1110g2;

    /* renamed from: p */
    private BigInteger f1111p;

    public CramerShoupParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest) {
        this.f1111p = bigInteger;
        this.f1109g1 = bigInteger2;
        this.f1110g2 = bigInteger3;
        this.f1108H = digest;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        CramerShoupParameters cramerShoupParameters = (CramerShoupParameters) obj;
        if (!cramerShoupParameters.getP().equals(this.f1111p) || !cramerShoupParameters.getG1().equals(this.f1109g1) || !cramerShoupParameters.getG2().equals(this.f1110g2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG1().hashCode()) ^ getG2().hashCode();
    }

    public BigInteger getG1() {
        return this.f1109g1;
    }

    public BigInteger getG2() {
        return this.f1110g2;
    }

    public BigInteger getP() {
        return this.f1111p;
    }

    public Digest getH() {
        this.f1108H.reset();
        return this.f1108H;
    }
}
