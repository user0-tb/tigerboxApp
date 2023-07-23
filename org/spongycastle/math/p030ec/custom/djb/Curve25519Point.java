package org.spongycastle.math.p030ec.custom.djb;

import org.spongycastle.math.p030ec.ECCurve;
import org.spongycastle.math.p030ec.ECFieldElement;
import org.spongycastle.math.p030ec.ECPoint;
import org.spongycastle.math.raw.Nat256;

/* renamed from: org.spongycastle.math.ec.custom.djb.Curve25519Point */
public class Curve25519Point extends ECPoint.AbstractFp {
    public Curve25519Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public Curve25519Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.withCompression = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    Curve25519Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.withCompression = z;
    }

    /* access modifiers changed from: protected */
    public ECPoint detach() {
        return new Curve25519Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public ECFieldElement getZCoord(int i) {
        if (i == 1) {
            return getJacobianModifiedW();
        }
        return super.getZCoord(i);
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
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement) this.f1270x;
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) this.f1271y;
        Curve25519FieldElement curve25519FieldElement3 = (Curve25519FieldElement) this.f1272zs[0];
        Curve25519FieldElement curve25519FieldElement4 = (Curve25519FieldElement) eCPoint.getXCoord();
        Curve25519FieldElement curve25519FieldElement5 = (Curve25519FieldElement) eCPoint.getYCoord();
        Curve25519FieldElement curve25519FieldElement6 = (Curve25519FieldElement) eCPoint.getZCoord(0);
        int[] createExt = Nat256.createExt();
        int[] create = Nat256.create();
        int[] create2 = Nat256.create();
        int[] create3 = Nat256.create();
        boolean isOne = curve25519FieldElement3.isOne();
        if (isOne) {
            iArr2 = curve25519FieldElement4.f1280x;
            iArr = curve25519FieldElement5.f1280x;
        } else {
            Curve25519Field.square(curve25519FieldElement3.f1280x, create2);
            Curve25519Field.multiply(create2, curve25519FieldElement4.f1280x, create);
            Curve25519Field.multiply(create2, curve25519FieldElement3.f1280x, create2);
            Curve25519Field.multiply(create2, curve25519FieldElement5.f1280x, create2);
            iArr2 = create;
            iArr = create2;
        }
        boolean isOne2 = curve25519FieldElement6.isOne();
        if (isOne2) {
            iArr4 = curve25519FieldElement.f1280x;
            iArr3 = curve25519FieldElement2.f1280x;
        } else {
            Curve25519Field.square(curve25519FieldElement6.f1280x, create3);
            Curve25519Field.multiply(create3, curve25519FieldElement.f1280x, createExt);
            Curve25519Field.multiply(create3, curve25519FieldElement6.f1280x, create3);
            Curve25519Field.multiply(create3, curve25519FieldElement2.f1280x, create3);
            iArr4 = createExt;
            iArr3 = create3;
        }
        int[] create4 = Nat256.create();
        Curve25519Field.subtract(iArr4, iArr2, create4);
        Curve25519Field.subtract(iArr3, iArr, create);
        if (!Nat256.isZero(create4)) {
            int[] create5 = Nat256.create();
            Curve25519Field.square(create4, create5);
            int[] create6 = Nat256.create();
            Curve25519Field.multiply(create5, create4, create6);
            Curve25519Field.multiply(create5, iArr4, create2);
            Curve25519Field.negate(create6, create6);
            Nat256.mul(iArr3, create6, createExt);
            Curve25519Field.reduce27(Nat256.addBothTo(create2, create2, create6), create6);
            Curve25519FieldElement curve25519FieldElement7 = new Curve25519FieldElement(create3);
            Curve25519Field.square(create, curve25519FieldElement7.f1280x);
            Curve25519Field.subtract(curve25519FieldElement7.f1280x, create6, curve25519FieldElement7.f1280x);
            Curve25519FieldElement curve25519FieldElement8 = new Curve25519FieldElement(create6);
            Curve25519Field.subtract(create2, curve25519FieldElement7.f1280x, curve25519FieldElement8.f1280x);
            Curve25519Field.multiplyAddToExt(curve25519FieldElement8.f1280x, create, createExt);
            Curve25519Field.reduce(createExt, curve25519FieldElement8.f1280x);
            Curve25519FieldElement curve25519FieldElement9 = new Curve25519FieldElement(create4);
            if (!isOne) {
                Curve25519Field.multiply(curve25519FieldElement9.f1280x, curve25519FieldElement3.f1280x, curve25519FieldElement9.f1280x);
            }
            if (!isOne2) {
                Curve25519Field.multiply(curve25519FieldElement9.f1280x, curve25519FieldElement6.f1280x, curve25519FieldElement9.f1280x);
            }
            if (!isOne || !isOne2) {
                create5 = null;
            }
            return new Curve25519Point(curve, curve25519FieldElement7, curve25519FieldElement8, new ECFieldElement[]{curve25519FieldElement9, calculateJacobianModifiedW(curve25519FieldElement9, create5)}, this.withCompression);
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
        if (this.f1271y.isZero()) {
            return curve.getInfinity();
        }
        return twiceJacobianModified(true);
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
        return twiceJacobianModified(false).add(eCPoint);
    }

    public ECPoint threeTimes() {
        if (!isInfinity() && !this.f1271y.isZero()) {
            return twiceJacobianModified(false).add(this);
        }
        return this;
    }

    public ECPoint negate() {
        if (isInfinity()) {
            return this;
        }
        return new Curve25519Point(getCurve(), this.f1270x, this.f1271y.negate(), this.f1272zs, this.withCompression);
    }

    /* access modifiers changed from: protected */
    public Curve25519FieldElement calculateJacobianModifiedW(Curve25519FieldElement curve25519FieldElement, int[] iArr) {
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) getCurve().getA();
        if (curve25519FieldElement.isOne()) {
            return curve25519FieldElement2;
        }
        Curve25519FieldElement curve25519FieldElement3 = new Curve25519FieldElement();
        if (iArr == null) {
            iArr = curve25519FieldElement3.f1280x;
            Curve25519Field.square(curve25519FieldElement.f1280x, iArr);
        }
        Curve25519Field.square(iArr, curve25519FieldElement3.f1280x);
        Curve25519Field.multiply(curve25519FieldElement3.f1280x, curve25519FieldElement2.f1280x, curve25519FieldElement3.f1280x);
        return curve25519FieldElement3;
    }

    /* access modifiers changed from: protected */
    public Curve25519FieldElement getJacobianModifiedW() {
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement) this.f1272zs[1];
        if (curve25519FieldElement != null) {
            return curve25519FieldElement;
        }
        ECFieldElement[] eCFieldElementArr = this.f1272zs;
        Curve25519FieldElement calculateJacobianModifiedW = calculateJacobianModifiedW((Curve25519FieldElement) this.f1272zs[0], (int[]) null);
        eCFieldElementArr[1] = calculateJacobianModifiedW;
        return calculateJacobianModifiedW;
    }

    /* access modifiers changed from: protected */
    public Curve25519Point twiceJacobianModified(boolean z) {
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement) this.f1270x;
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) this.f1271y;
        Curve25519FieldElement curve25519FieldElement3 = (Curve25519FieldElement) this.f1272zs[0];
        Curve25519FieldElement jacobianModifiedW = getJacobianModifiedW();
        int[] create = Nat256.create();
        Curve25519Field.square(curve25519FieldElement.f1280x, create);
        Curve25519Field.reduce27(Nat256.addBothTo(create, create, create) + Nat256.addTo(jacobianModifiedW.f1280x, create), create);
        int[] create2 = Nat256.create();
        Curve25519Field.twice(curve25519FieldElement2.f1280x, create2);
        int[] create3 = Nat256.create();
        Curve25519Field.multiply(create2, curve25519FieldElement2.f1280x, create3);
        int[] create4 = Nat256.create();
        Curve25519Field.multiply(create3, curve25519FieldElement.f1280x, create4);
        Curve25519Field.twice(create4, create4);
        int[] create5 = Nat256.create();
        Curve25519Field.square(create3, create5);
        Curve25519Field.twice(create5, create5);
        Curve25519FieldElement curve25519FieldElement4 = new Curve25519FieldElement(create3);
        Curve25519Field.square(create, curve25519FieldElement4.f1280x);
        Curve25519Field.subtract(curve25519FieldElement4.f1280x, create4, curve25519FieldElement4.f1280x);
        Curve25519Field.subtract(curve25519FieldElement4.f1280x, create4, curve25519FieldElement4.f1280x);
        Curve25519FieldElement curve25519FieldElement5 = new Curve25519FieldElement(create4);
        Curve25519Field.subtract(create4, curve25519FieldElement4.f1280x, curve25519FieldElement5.f1280x);
        Curve25519Field.multiply(curve25519FieldElement5.f1280x, create, curve25519FieldElement5.f1280x);
        Curve25519Field.subtract(curve25519FieldElement5.f1280x, create5, curve25519FieldElement5.f1280x);
        Curve25519FieldElement curve25519FieldElement6 = new Curve25519FieldElement(create2);
        if (!Nat256.isOne(curve25519FieldElement3.f1280x)) {
            Curve25519Field.multiply(curve25519FieldElement6.f1280x, curve25519FieldElement3.f1280x, curve25519FieldElement6.f1280x);
        }
        Curve25519FieldElement curve25519FieldElement7 = null;
        if (z) {
            curve25519FieldElement7 = new Curve25519FieldElement(create5);
            Curve25519Field.multiply(curve25519FieldElement7.f1280x, jacobianModifiedW.f1280x, curve25519FieldElement7.f1280x);
            Curve25519Field.twice(curve25519FieldElement7.f1280x, curve25519FieldElement7.f1280x);
        }
        return new Curve25519Point(getCurve(), curve25519FieldElement4, curve25519FieldElement5, new ECFieldElement[]{curve25519FieldElement6, curve25519FieldElement7}, this.withCompression);
    }
}
