package org.spongycastle.math.p030ec.endo;

import java.math.BigInteger;

/* renamed from: org.spongycastle.math.ec.endo.GLVTypeBParameters */
public class GLVTypeBParameters {
    protected final BigInteger beta;
    protected final int bits;

    /* renamed from: g1 */
    protected final BigInteger f1323g1;

    /* renamed from: g2 */
    protected final BigInteger f1324g2;
    protected final BigInteger lambda;

    /* renamed from: v1 */
    protected final BigInteger[] f1325v1;

    /* renamed from: v2 */
    protected final BigInteger[] f1326v2;

    public GLVTypeBParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger3, BigInteger bigInteger4, int i) {
        this.beta = bigInteger;
        this.lambda = bigInteger2;
        this.f1325v1 = bigIntegerArr;
        this.f1326v2 = bigIntegerArr2;
        this.f1323g1 = bigInteger3;
        this.f1324g2 = bigInteger4;
        this.bits = i;
    }

    public BigInteger getBeta() {
        return this.beta;
    }

    public BigInteger getLambda() {
        return this.lambda;
    }

    public BigInteger[] getV1() {
        return this.f1325v1;
    }

    public BigInteger[] getV2() {
        return this.f1326v2;
    }

    public BigInteger getG1() {
        return this.f1323g1;
    }

    public BigInteger getG2() {
        return this.f1324g2;
    }

    public int getBits() {
        return this.bits;
    }
}
