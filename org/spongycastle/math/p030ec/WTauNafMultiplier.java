package org.spongycastle.math.p030ec;

import java.math.BigInteger;
import org.spongycastle.math.p030ec.ECCurve;
import org.spongycastle.math.p030ec.ECPoint;

/* renamed from: org.spongycastle.math.ec.WTauNafMultiplier */
public class WTauNafMultiplier extends AbstractECMultiplier {
    static final String PRECOMP_NAME = "bc_wtnaf";

    /* access modifiers changed from: protected */
    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        if (eCPoint instanceof ECPoint.F2m) {
            ECPoint.F2m f2m = (ECPoint.F2m) eCPoint;
            ECCurve.F2m f2m2 = (ECCurve.F2m) f2m.getCurve();
            int m = f2m2.getM();
            byte byteValue = f2m2.getA().toBigInteger().byteValue();
            byte mu = f2m2.getMu();
            byte b = byteValue;
            return multiplyWTnaf(f2m, Tnaf.partModReduction(bigInteger, m, b, f2m2.getSi(), mu, (byte) 10), f2m2.getPreCompInfo(f2m, PRECOMP_NAME), b, mu);
        }
        throw new IllegalArgumentException("Only ECPoint.F2m can be used in WTauNafMultiplier");
    }

    private ECPoint.F2m multiplyWTnaf(ECPoint.F2m f2m, ZTauElement zTauElement, PreCompInfo preCompInfo, byte b, byte b2) {
        ZTauElement[] zTauElementArr = b == 0 ? Tnaf.alpha0 : Tnaf.alpha1;
        return multiplyFromWTnaf(f2m, Tnaf.tauAdicWNaf(b2, zTauElement, (byte) 4, BigInteger.valueOf(16), Tnaf.getTw(b2, 4), zTauElementArr), preCompInfo);
    }

    private static ECPoint.F2m multiplyFromWTnaf(ECPoint.F2m f2m, byte[] bArr, PreCompInfo preCompInfo) {
        ECPoint.F2m[] f2mArr;
        ECCurve.F2m f2m2 = (ECCurve.F2m) f2m.getCurve();
        byte byteValue = f2m2.getA().toBigInteger().byteValue();
        if (preCompInfo == null || !(preCompInfo instanceof WTauNafPreCompInfo)) {
            f2mArr = Tnaf.getPreComp(f2m, byteValue);
            WTauNafPreCompInfo wTauNafPreCompInfo = new WTauNafPreCompInfo();
            wTauNafPreCompInfo.setPreComp(f2mArr);
            f2m2.setPreCompInfo(f2m, PRECOMP_NAME, wTauNafPreCompInfo);
        } else {
            f2mArr = ((WTauNafPreCompInfo) preCompInfo).getPreComp();
        }
        ECPoint.F2m f2m3 = (ECPoint.F2m) f2m.getCurve().getInfinity();
        for (int length = bArr.length - 1; length >= 0; length--) {
            f2m3 = Tnaf.tau(f2m3);
            byte b = bArr[length];
            if (b != 0) {
                if (b > 0) {
                    f2m3 = f2m3.addSimple(f2mArr[b]);
                } else {
                    f2m3 = f2m3.subtractSimple(f2mArr[-b]);
                }
            }
        }
        return f2m3;
    }
}
