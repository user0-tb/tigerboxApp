package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.math.p030ec.ECCurve;
import org.spongycastle.math.p030ec.ECPoint;

public class ECParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: G */
    private ECPoint f1234G;
    private ECCurve curve;

    /* renamed from: h */
    private BigInteger f1235h;

    /* renamed from: n */
    private BigInteger f1236n;
    private byte[] seed;

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this.curve = eCCurve;
        this.f1234G = eCPoint.normalize();
        this.f1236n = bigInteger;
        this.f1235h = BigInteger.valueOf(1);
        this.seed = null;
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this.curve = eCCurve;
        this.f1234G = eCPoint.normalize();
        this.f1236n = bigInteger;
        this.f1235h = bigInteger2;
        this.seed = null;
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.curve = eCCurve;
        this.f1234G = eCPoint.normalize();
        this.f1236n = bigInteger;
        this.f1235h = bigInteger2;
        this.seed = bArr;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.f1234G;
    }

    public BigInteger getN() {
        return this.f1236n;
    }

    public BigInteger getH() {
        return this.f1235h;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ECParameterSpec)) {
            return false;
        }
        ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
        if (!getCurve().equals(eCParameterSpec.getCurve()) || !getG().equals(eCParameterSpec.getG())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return getCurve().hashCode() ^ getG().hashCode();
    }
}
