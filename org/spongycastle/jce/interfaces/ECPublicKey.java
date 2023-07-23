package org.spongycastle.jce.interfaces;

import java.security.PublicKey;
import org.spongycastle.math.p030ec.ECPoint;

public interface ECPublicKey extends ECKey, PublicKey {
    ECPoint getQ();
}
