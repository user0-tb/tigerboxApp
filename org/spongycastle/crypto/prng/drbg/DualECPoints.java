package org.spongycastle.crypto.prng.drbg;

import org.spongycastle.math.p030ec.ECPoint;

public class DualECPoints {
    private final int cofactor;

    /* renamed from: p */
    private final ECPoint f1174p;

    /* renamed from: q */
    private final ECPoint f1175q;
    private final int securityStrength;

    private static int log2(int i) {
        int i2 = 0;
        while (true) {
            i >>= 1;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    public DualECPoints(int i, ECPoint eCPoint, ECPoint eCPoint2, int i2) {
        if (eCPoint.getCurve().equals(eCPoint2.getCurve())) {
            this.securityStrength = i;
            this.f1174p = eCPoint;
            this.f1175q = eCPoint2;
            this.cofactor = i2;
            return;
        }
        throw new IllegalArgumentException("points need to be on the same curve");
    }

    public int getSeedLen() {
        return this.f1174p.getCurve().getFieldSize();
    }

    public int getMaxOutlen() {
        return ((this.f1174p.getCurve().getFieldSize() - (log2(this.cofactor) + 13)) / 8) * 8;
    }

    public ECPoint getP() {
        return this.f1174p;
    }

    public ECPoint getQ() {
        return this.f1175q;
    }

    public int getSecurityStrength() {
        return this.securityStrength;
    }

    public int getCofactor() {
        return this.cofactor;
    }
}
