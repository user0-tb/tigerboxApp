package org.spongycastle.jce.spec;

import java.math.BigInteger;

public class GOST3410PublicKeyParameterSetSpec {

    /* renamed from: a */
    private BigInteger f1247a;

    /* renamed from: p */
    private BigInteger f1248p;

    /* renamed from: q */
    private BigInteger f1249q;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f1248p = bigInteger;
        this.f1249q = bigInteger2;
        this.f1247a = bigInteger3;
    }

    public BigInteger getP() {
        return this.f1248p;
    }

    public BigInteger getQ() {
        return this.f1249q;
    }

    public BigInteger getA() {
        return this.f1247a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410PublicKeyParameterSetSpec)) {
            return false;
        }
        GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
        if (!this.f1247a.equals(gOST3410PublicKeyParameterSetSpec.f1247a) || !this.f1248p.equals(gOST3410PublicKeyParameterSetSpec.f1248p) || !this.f1249q.equals(gOST3410PublicKeyParameterSetSpec.f1249q)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f1247a.hashCode() ^ this.f1248p.hashCode()) ^ this.f1249q.hashCode();
    }
}
