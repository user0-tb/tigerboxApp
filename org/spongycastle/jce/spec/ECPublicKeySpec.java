package org.spongycastle.jce.spec;

import org.spongycastle.math.p030ec.ECPoint;

public class ECPublicKeySpec extends ECKeySpec {

    /* renamed from: q */
    private ECPoint f1238q;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        if (eCPoint.getCurve() != null) {
            this.f1238q = eCPoint.normalize();
        } else {
            this.f1238q = eCPoint;
        }
    }

    public ECPoint getQ() {
        return this.f1238q;
    }
}
