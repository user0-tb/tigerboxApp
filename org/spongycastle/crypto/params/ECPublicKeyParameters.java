package org.spongycastle.crypto.params;

import org.spongycastle.math.p030ec.ECPoint;

public class ECPublicKeyParameters extends ECKeyParameters {

    /* renamed from: Q */
    ECPoint f1140Q;

    public ECPublicKeyParameters(ECPoint eCPoint, ECDomainParameters eCDomainParameters) {
        super(false, eCDomainParameters);
        this.f1140Q = eCPoint.normalize();
    }

    public ECPoint getQ() {
        return this.f1140Q;
    }
}
