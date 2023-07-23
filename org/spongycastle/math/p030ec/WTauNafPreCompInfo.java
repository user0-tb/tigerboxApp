package org.spongycastle.math.p030ec;

import org.spongycastle.math.p030ec.ECPoint;

/* renamed from: org.spongycastle.math.ec.WTauNafPreCompInfo */
public class WTauNafPreCompInfo implements PreCompInfo {
    protected ECPoint.F2m[] preComp = null;

    public ECPoint.F2m[] getPreComp() {
        return this.preComp;
    }

    public void setPreComp(ECPoint.F2m[] f2mArr) {
        this.preComp = f2mArr;
    }
}
