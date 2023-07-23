package org.spongycastle.math.p030ec.endo;

import java.math.BigInteger;

/* renamed from: org.spongycastle.math.ec.endo.GLVEndomorphism */
public interface GLVEndomorphism extends ECEndomorphism {
    BigInteger[] decomposeScalar(BigInteger bigInteger);
}
