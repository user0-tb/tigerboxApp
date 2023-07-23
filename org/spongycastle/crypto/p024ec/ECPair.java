package org.spongycastle.crypto.p024ec;

import org.spongycastle.math.p030ec.ECPoint;

/* renamed from: org.spongycastle.crypto.ec.ECPair */
public class ECPair {

    /* renamed from: x */
    private final ECPoint f928x;

    /* renamed from: y */
    private final ECPoint f929y;

    public ECPair(ECPoint eCPoint, ECPoint eCPoint2) {
        this.f928x = eCPoint;
        this.f929y = eCPoint2;
    }

    public ECPoint getX() {
        return this.f928x;
    }

    public ECPoint getY() {
        return this.f929y;
    }

    public boolean equals(ECPair eCPair) {
        return eCPair.getX().equals(getX()) && eCPair.getY().equals(getY());
    }

    public boolean equals(Object obj) {
        if (obj instanceof ECPair) {
            return equals((ECPair) obj);
        }
        return false;
    }

    public int hashCode() {
        return this.f928x.hashCode() + (this.f929y.hashCode() * 37);
    }
}
