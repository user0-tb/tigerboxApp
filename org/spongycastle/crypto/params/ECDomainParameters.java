package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.math.p030ec.ECConstants;
import org.spongycastle.math.p030ec.ECCurve;
import org.spongycastle.math.p030ec.ECPoint;
import org.spongycastle.util.Arrays;

public class ECDomainParameters implements ECConstants {

    /* renamed from: G */
    private ECPoint f1136G;
    private ECCurve curve;

    /* renamed from: h */
    private BigInteger f1137h;

    /* renamed from: n */
    private BigInteger f1138n;
    private byte[] seed;

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this(eCCurve, eCPoint, bigInteger, ONE, (byte[]) null);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, eCPoint, bigInteger, bigInteger2, (byte[]) null);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.curve = eCCurve;
        this.f1136G = eCPoint.normalize();
        this.f1138n = bigInteger;
        this.f1137h = bigInteger2;
        this.seed = bArr;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.f1136G;
    }

    public BigInteger getN() {
        return this.f1138n;
    }

    public BigInteger getH() {
        return this.f1137h;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }
}
