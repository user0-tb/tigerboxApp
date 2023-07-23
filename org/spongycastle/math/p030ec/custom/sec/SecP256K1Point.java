package org.spongycastle.math.p030ec.custom.sec;

import org.spongycastle.math.p030ec.ECCurve;
import org.spongycastle.math.p030ec.ECFieldElement;
import org.spongycastle.math.p030ec.ECPoint;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecP256K1Point */
public class SecP256K1Point extends ECPoint.AbstractFp {
    public SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.withCompression = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.withCompression = z;
    }

    /* access modifiers changed from: protected */
    public ECPoint detach() {
        return new SecP256K1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public ECPoint add(ECPoint eCPoint) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        if (this == eCPoint) {
            return twice();
        }
        ECCurve curve = getCurve();
        SecP256K1FieldElement secP256K1FieldElement = (SecP256K1FieldElement) this.f1270x;
        SecP256K1FieldElement secP256K1FieldElement2 = (SecP256K1FieldElement) this.f1271y;
        SecP256K1FieldElement secP256K1FieldElement3 = (SecP256K1FieldElement) eCPoint.getXCoord();
        SecP256K1FieldElement secP256K1FieldElement4 = (SecP256K1FieldElement) eCPoint.getYCoord();
        SecP256K1FieldElement secP256K1FieldElement5 = (SecP256K1FieldElement) this.f1272zs[0];
        SecP256K1FieldElement secP256K1FieldElement6 = (SecP256K1FieldElement) eCPoint.getZCoord(0);
        int[] createExt = Nat256.createExt();
        int[] create = Nat256.create();
        int[] create2 = Nat256.create();
        int[] create3 = Nat256.create();
        boolean isOne = secP256K1FieldElement5.isOne();
        if (isOne) {
            iArr2 = secP256K1FieldElement3.f1307x;
            iArr = secP256K1FieldElement4.f1307x;
        } else {
            SecP256K1Field.square(secP256K1FieldElement5.f1307x, create2);
            SecP256K1Field.multiply(create2, secP256K1FieldElement3.f1307x, create);
            SecP256K1Field.multiply(create2, secP256K1FieldElement5.f1307x, create2);
            SecP256K1Field.multiply(create2, secP256K1FieldElement4.f1307x, create2);
            iArr2 = create;
            iArr = create2;
        }
        boolean isOne2 = secP256K1FieldElement6.isOne();
        if (isOne2) {
            iArr4 = secP256K1FieldElement.f1307x;
            iArr3 = secP256K1FieldElement2.f1307x;
        } else {
            SecP256K1Field.square(secP256K1FieldElement6.f1307x, create3);
            SecP256K1Field.multiply(create3, secP256K1FieldElement.f1307x, createExt);
            SecP256K1Field.multiply(create3, secP256K1FieldElement6.f1307x, create3);
            SecP256K1Field.multiply(create3, secP256K1FieldElement2.f1307x, create3);
            iArr4 = createExt;
            iArr3 = create3;
        }
        int[] create4 = Nat256.create();
        SecP256K1Field.subtract(iArr4, iArr2, create4);
        SecP256K1Field.subtract(iArr3, iArr, create);
        if (!Nat256.isZero(create4)) {
            SecP256K1Field.square(create4, create2);
            int[] create5 = Nat256.create();
            SecP256K1Field.multiply(create2, create4, create5);
            SecP256K1Field.multiply(create2, iArr4, create2);
            SecP256K1Field.negate(create5, create5);
            Nat256.mul(iArr3, create5, createExt);
            SecP256K1Field.reduce32(Nat256.addBothTo(create2, create2, create5), create5);
            SecP256K1FieldElement secP256K1FieldElement7 = new SecP256K1FieldElement(create3);
            SecP256K1Field.square(create, secP256K1FieldElement7.f1307x);
            SecP256K1Field.subtract(secP256K1FieldElement7.f1307x, create5, secP256K1FieldElement7.f1307x);
            SecP256K1FieldElement secP256K1FieldElement8 = new SecP256K1FieldElement(create5);
            SecP256K1Field.subtract(create2, secP256K1FieldElement7.f1307x, secP256K1FieldElement8.f1307x);
            SecP256K1Field.multiplyAddToExt(secP256K1FieldElement8.f1307x, create, createExt);
            SecP256K1Field.reduce(createExt, secP256K1FieldElement8.f1307x);
            SecP256K1FieldElement secP256K1FieldElement9 = new SecP256K1FieldElement(create4);
            if (!isOne) {
                SecP256K1Field.multiply(secP256K1FieldElement9.f1307x, secP256K1FieldElement5.f1307x, secP256K1FieldElement9.f1307x);
            }
            if (!isOne2) {
                SecP256K1Field.multiply(secP256K1FieldElement9.f1307x, secP256K1FieldElement6.f1307x, secP256K1FieldElement9.f1307x);
            }
            return new SecP256K1Point(curve, secP256K1FieldElement7, secP256K1FieldElement8, new ECFieldElement[]{secP256K1FieldElement9}, this.withCompression);
        } else if (Nat256.isZero(create)) {
            return twice();
        } else {
            return curve.getInfinity();
        }
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP256K1FieldElement secP256K1FieldElement = (SecP256K1FieldElement) this.f1271y;
        if (secP256K1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP256K1FieldElement secP256K1FieldElement2 = (SecP256K1FieldElement) this.f1270x;
        SecP256K1FieldElement secP256K1FieldElement3 = (SecP256K1FieldElement) this.f1272zs[0];
        int[] create = Nat256.create();
        SecP256K1Field.square(secP256K1FieldElement.f1307x, create);
        int[] create2 = Nat256.create();
        SecP256K1Field.square(create, create2);
        int[] create3 = Nat256.create();
        SecP256K1Field.square(secP256K1FieldElement2.f1307x, create3);
        SecP256K1Field.reduce32(Nat256.addBothTo(create3, create3, create3), create3);
        SecP256K1Field.multiply(create, secP256K1FieldElement2.f1307x, create);
        SecP256K1Field.reduce32(Nat.shiftUpBits(8, create, 2, 0), create);
        int[] create4 = Nat256.create();
        SecP256K1Field.reduce32(Nat.shiftUpBits(8, create2, 3, 0, create4), create4);
        SecP256K1FieldElement secP256K1FieldElement4 = new SecP256K1FieldElement(create2);
        SecP256K1Field.square(create3, secP256K1FieldElement4.f1307x);
        SecP256K1Field.subtract(secP256K1FieldElement4.f1307x, create, secP256K1FieldElement4.f1307x);
        SecP256K1Field.subtract(secP256K1FieldElement4.f1307x, create, secP256K1FieldElement4.f1307x);
        SecP256K1FieldElement secP256K1FieldElement5 = new SecP256K1FieldElement(create);
        SecP256K1Field.subtract(create, secP256K1FieldElement4.f1307x, secP256K1FieldElement5.f1307x);
        SecP256K1Field.multiply(secP256K1FieldElement5.f1307x, create3, secP256K1FieldElement5.f1307x);
        SecP256K1Field.subtract(secP256K1FieldElement5.f1307x, create4, secP256K1FieldElement5.f1307x);
        SecP256K1FieldElement secP256K1FieldElement6 = new SecP256K1FieldElement(create3);
        SecP256K1Field.twice(secP256K1FieldElement.f1307x, secP256K1FieldElement6.f1307x);
        if (!secP256K1FieldElement3.isOne()) {
            SecP256K1Field.multiply(secP256K1FieldElement6.f1307x, secP256K1FieldElement3.f1307x, secP256K1FieldElement6.f1307x);
        }
        return new SecP256K1Point(curve, secP256K1FieldElement4, secP256K1FieldElement5, new ECFieldElement[]{secP256K1FieldElement6}, this.withCompression);
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        if (this == eCPoint) {
            return threeTimes();
        }
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return twice();
        }
        if (this.f1271y.isZero()) {
            return eCPoint;
        }
        return twice().add(eCPoint);
    }

    public ECPoint threeTimes() {
        return (isInfinity() || this.f1271y.isZero()) ? this : twice().add(this);
    }

    public ECPoint negate() {
        if (isInfinity()) {
            return this;
        }
        return new SecP256K1Point(this.curve, this.f1270x, this.f1271y.negate(), this.f1272zs, this.withCompression);
    }
}
