package org.spongycastle.math.p030ec;

import java.math.BigInteger;

/* renamed from: org.spongycastle.math.ec.ReferenceMultiplier */
public class ReferenceMultiplier extends AbstractECMultiplier {
    /* access modifiers changed from: protected */
    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        return ECAlgorithms.referenceMultiply(eCPoint, bigInteger);
    }
}
