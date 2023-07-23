package org.spongycastle.math.p030ec.endo;

import org.spongycastle.math.p030ec.ECPointMap;

/* renamed from: org.spongycastle.math.ec.endo.ECEndomorphism */
public interface ECEndomorphism {
    ECPointMap getPointMap();

    boolean hasEfficientPointMap();
}
