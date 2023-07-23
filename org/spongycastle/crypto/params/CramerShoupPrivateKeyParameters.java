package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: pk */
    private CramerShoupPublicKeyParameters f1112pk;

    /* renamed from: x1 */
    private BigInteger f1113x1;

    /* renamed from: x2 */
    private BigInteger f1114x2;

    /* renamed from: y1 */
    private BigInteger f1115y1;

    /* renamed from: y2 */
    private BigInteger f1116y2;

    /* renamed from: z */
    private BigInteger f1117z;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        super(true, cramerShoupParameters);
        this.f1113x1 = bigInteger;
        this.f1114x2 = bigInteger2;
        this.f1115y1 = bigInteger3;
        this.f1116y2 = bigInteger4;
        this.f1117z = bigInteger5;
    }

    public BigInteger getX1() {
        return this.f1113x1;
    }

    public BigInteger getX2() {
        return this.f1114x2;
    }

    public BigInteger getY1() {
        return this.f1115y1;
    }

    public BigInteger getY2() {
        return this.f1116y2;
    }

    public BigInteger getZ() {
        return this.f1117z;
    }

    public void setPk(CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters) {
        this.f1112pk = cramerShoupPublicKeyParameters;
    }

    public CramerShoupPublicKeyParameters getPk() {
        return this.f1112pk;
    }

    public int hashCode() {
        return ((((this.f1113x1.hashCode() ^ this.f1114x2.hashCode()) ^ this.f1115y1.hashCode()) ^ this.f1116y2.hashCode()) ^ this.f1117z.hashCode()) ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPrivateKeyParameters)) {
            return false;
        }
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters) obj;
        if (!cramerShoupPrivateKeyParameters.getX1().equals(this.f1113x1) || !cramerShoupPrivateKeyParameters.getX2().equals(this.f1114x2) || !cramerShoupPrivateKeyParameters.getY1().equals(this.f1115y1) || !cramerShoupPrivateKeyParameters.getY2().equals(this.f1116y2) || !cramerShoupPrivateKeyParameters.getZ().equals(this.f1117z) || !super.equals(obj)) {
            return false;
        }
        return true;
    }
}
