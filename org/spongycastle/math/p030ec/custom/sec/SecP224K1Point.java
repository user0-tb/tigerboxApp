package org.spongycastle.math.p030ec.custom.sec;

import org.spongycastle.math.p030ec.ECCurve;
import org.spongycastle.math.p030ec.ECFieldElement;
import org.spongycastle.math.p030ec.ECPoint;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecP224K1Point */
public class SecP224K1Point extends ECPoint.AbstractFp {
    public SecP224K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP224K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.withCompression = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    SecP224K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.withCompression = z;
    }

    /* access modifiers changed from: protected */
    public ECPoint detach() {
        return new SecP224K1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
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
        SecP224K1FieldElement secP224K1FieldElement = (SecP224K1FieldElement) this.f1270x;
        SecP224K1FieldElement secP224K1FieldElement2 = (SecP224K1FieldElement) this.f1271y;
        SecP224K1FieldElement secP224K1FieldElement3 = (SecP224K1FieldElement) eCPoint.getXCoord();
        SecP224K1FieldElement secP224K1FieldElement4 = (SecP224K1FieldElement) eCPoint.getYCoord();
        SecP224K1FieldElement secP224K1FieldElement5 = (SecP224K1FieldElement) this.f1272zs[0];
        SecP224K1FieldElement secP224K1FieldElement6 = (SecP224K1FieldElement) eCPoint.getZCoord(0);
        int[] createExt = Nat224.createExt();
        int[] create = Nat224.create();
        int[] create2 = Nat224.create();
        int[] create3 = Nat224.create();
        boolean isOne = secP224K1FieldElement5.isOne();
        if (isOne) {
            iArr2 = secP224K1FieldElement3.f1296x;
            iArr = secP224K1FieldElement4.f1296x;
        } else {
            SecP224K1Field.square(secP224K1FieldElement5.f1296x, create2);
            SecP224K1Field.multiply(create2, secP224K1FieldElement3.f1296x, create);
            SecP224K1Field.multiply(create2, secP224K1FieldElement5.f1296x, create2);
            SecP224K1Field.multiply(create2, secP224K1FieldElement4.f1296x, create2);
            iArr2 = create;
            iArr = create2;
        }
        boolean isOne2 = secP224K1FieldElement6.isOne();
        if (isOne2) {
            iArr4 = secP224K1FieldElement.f1296x;
            iArr3 = secP224K1FieldElement2.f1296x;
        } else {
            SecP224K1Field.square(secP224K1FieldElement6.f1296x, create3);
            SecP224K1Field.multiply(create3, secP224K1FieldElement.f1296x, createExt);
            SecP224K1Field.multiply(create3, secP224K1FieldElement6.f1296x, create3);
            SecP224K1Field.multiply(create3, secP224K1FieldElement2.f1296x, create3);
            iArr4 = createExt;
            iArr3 = create3;
        }
        int[] create4 = Nat224.create();
        SecP224K1Field.subtract(iArr4, iArr2, create4);
        SecP224K1Field.subtract(iArr3, iArr, create);
        if (!Nat224.isZero(create4)) {
            SecP224K1Field.square(create4, create2);
            int[] create5 = Nat224.create();
            SecP224K1Field.multiply(create2, create4, create5);
            SecP224K1Field.multiply(create2, iArr4, create2);
            SecP224K1Field.negate(create5, create5);
            Nat224.mul(iArr3, create5, createExt);
            SecP224K1Field.reduce32(Nat224.addBothTo(create2, create2, create5), create5);
            SecP224K1FieldElement secP224K1FieldElement7 = new SecP224K1FieldElement(create3);
            SecP224K1Field.square(create, secP224K1FieldElement7.f1296x);
            SecP224K1Field.subtract(secP224K1FieldElement7.f1296x, create5, secP224K1FieldElement7.f1296x);
            SecP224K1FieldElement secP224K1FieldElement8 = new SecP224K1FieldElement(create5);
            SecP224K1Field.subtract(create2, secP224K1FieldElement7.f1296x, secP224K1FieldElement8.f1296x);
            SecP224K1Field.multiplyAddToExt(secP224K1FieldElement8.f1296x, create, createExt);
            SecP224K1Field.reduce(createExt, secP224K1FieldElement8.f1296x);
            SecP224K1FieldElement secP224K1FieldElement9 = new SecP224K1FieldElement(create4);
            if (!isOne) {
                SecP224K1Field.multiply(secP224K1FieldElement9.f1296x, secP224K1FieldElement5.f1296x, secP224K1FieldElement9.f1296x);
            }
            if (!isOne2) {
                SecP224K1Field.multiply(secP224K1FieldElement9.f1296x, secP224K1FieldElement6.f1296x, secP224K1FieldElement9.f1296x);
            }
            return new SecP224K1Point(curve, secP224K1FieldElement7, secP224K1FieldElement8, new ECFieldElement[]{secP224K1FieldElement9}, this.withCompression);
        } else if (Nat224.isZero(create)) {
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
        SecP224K1FieldElement secP224K1FieldElement = (SecP224K1FieldElement) this.f1271y;
        if (secP224K1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP224K1FieldElement secP224K1FieldElement2 = (SecP224K1FieldElement) this.f1270x;
        SecP224K1FieldElement secP224K1FieldElement3 = (SecP224K1FieldElement) this.f1272zs[0];
        int[] create = Nat224.create();
        SecP224K1Field.square(secP224K1FieldElement.f1296x, create);
        int[] create2 = Nat224.create();
        SecP224K1Field.square(create, create2);
        int[] create3 = Nat224.create();
        SecP224K1Field.square(secP224K1FieldElement2.f1296x, create3);
        SecP224K1Field.reduce32(Nat224.addBothTo(create3, create3, create3), create3);
        SecP224K1Field.multiply(create, secP224K1FieldElement2.f1296x, create);
        SecP224K1Field.reduce32(Nat.shiftUpBits(7, create, 2, 0), create);
        int[] create4 = Nat224.create();
        SecP224K1Field.reduce32(Nat.shiftUpBits(7, create2, 3, 0, create4), create4);
        SecP224K1FieldElement secP224K1FieldElement4 = new SecP224K1FieldElement(create2);
        SecP224K1Field.square(create3, secP224K1FieldElement4.f1296x);
        SecP224K1Field.subtract(secP224K1FieldElement4.f1296x, create, secP224K1FieldElement4.f1296x);
        SecP224K1Field.subtract(secP224K1FieldElement4.f1296x, create, secP224K1FieldElement4.f1296x);
        SecP224K1FieldElement secP224K1FieldElement5 = new SecP224K1FieldElement(create);
        SecP224K1Field.subtract(create, secP224K1FieldElement4.f1296x, secP224K1FieldElement5.f1296x);
        SecP224K1Field.multiply(secP224K1FieldElement5.f1296x, create3, secP224K1FieldElement5.f1296x);
        SecP224K1Field.subtract(secP224K1FieldElement5.f1296x, create4, secP224K1FieldElement5.f1296x);
        SecP224K1FieldElement secP224K1FieldElement6 = new SecP224K1FieldElement(create3);
        SecP224K1Field.twice(secP224K1FieldElement.f1296x, secP224K1FieldElement6.f1296x);
        if (!secP224K1FieldElement3.isOne()) {
            SecP224K1Field.multiply(secP224K1FieldElement6.f1296x, secP224K1FieldElement3.f1296x, secP224K1FieldElement6.f1296x);
        }
        return new SecP224K1Point(curve, secP224K1FieldElement4, secP224K1FieldElement5, new ECFieldElement[]{secP224K1FieldElement6}, this.withCompression);
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
        return new SecP224K1Point(this.curve, this.f1270x, this.f1271y.negate(), this.f1272zs, this.withCompression);
    }
}
