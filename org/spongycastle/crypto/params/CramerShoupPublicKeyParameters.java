package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: c */
    private BigInteger f1118c;

    /* renamed from: d */
    private BigInteger f1119d;

    /* renamed from: h */
    private BigInteger f1120h;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.f1118c = bigInteger;
        this.f1119d = bigInteger2;
        this.f1120h = bigInteger3;
    }

    public BigInteger getC() {
        return this.f1118c;
    }

    public BigInteger getD() {
        return this.f1119d;
    }

    public BigInteger getH() {
        return this.f1120h;
    }

    public int hashCode() {
        return ((this.f1118c.hashCode() ^ this.f1119d.hashCode()) ^ this.f1120h.hashCode()) ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPublicKeyParameters)) {
            return false;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
        if (!cramerShoupPublicKeyParameters.getC().equals(this.f1118c) || !cramerShoupPublicKeyParameters.getD().equals(this.f1119d) || !cramerShoupPublicKeyParameters.getH().equals(this.f1120h) || !super.equals(obj)) {
            return false;
        }
        return true;
    }
}
