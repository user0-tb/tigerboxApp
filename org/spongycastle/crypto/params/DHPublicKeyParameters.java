package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class DHPublicKeyParameters extends DHKeyParameters {

    /* renamed from: y */
    private BigInteger f1128y;

    public DHPublicKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(false, dHParameters);
        this.f1128y = bigInteger;
    }

    public BigInteger getY() {
        return this.f1128y;
    }

    public int hashCode() {
        return this.f1128y.hashCode() ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof DHPublicKeyParameters) && ((DHPublicKeyParameters) obj).getY().equals(this.f1128y) && super.equals(obj)) {
            return true;
        }
        return false;
    }
}
