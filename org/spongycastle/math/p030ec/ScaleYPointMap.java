package org.spongycastle.math.p030ec;

/* renamed from: org.spongycastle.math.ec.ScaleYPointMap */
public class ScaleYPointMap implements ECPointMap {
    protected final ECFieldElement scale;

    public ScaleYPointMap(ECFieldElement eCFieldElement) {
        this.scale = eCFieldElement;
    }

    public ECPoint map(ECPoint eCPoint) {
        return eCPoint.scaleY(this.scale);
    }
}
