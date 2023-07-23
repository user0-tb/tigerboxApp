package org.spongycastle.math.p030ec.custom.sec;

import org.spongycastle.math.p030ec.ECCurve;
import org.spongycastle.math.p030ec.ECFieldElement;
import org.spongycastle.math.p030ec.ECPoint;
import org.spongycastle.math.raw.Nat;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecP384R1Point */
public class SecP384R1Point extends ECPoint.AbstractFp {
    public SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.withCompression = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.withCompression = z;
    }

    /* access modifiers changed from: protected */
    public ECPoint detach() {
        return new SecP384R1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    /* JADX WARNING: type inference failed for: r17v0, types: [org.spongycastle.math.ec.ECPoint] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.math.p030ec.ECPoint add(org.spongycastle.math.p030ec.ECPoint r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            boolean r2 = r16.isInfinity()
            if (r2 == 0) goto L_0x000b
            return r1
        L_0x000b:
            boolean r2 = r17.isInfinity()
            if (r2 == 0) goto L_0x0012
            return r0
        L_0x0012:
            if (r0 != r1) goto L_0x0019
            org.spongycastle.math.ec.ECPoint r1 = r16.twice()
            return r1
        L_0x0019:
            org.spongycastle.math.ec.ECCurve r3 = r16.getCurve()
            org.spongycastle.math.ec.ECFieldElement r2 = r0.f1270x
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r2 = (org.spongycastle.math.p030ec.custom.sec.SecP384R1FieldElement) r2
            org.spongycastle.math.ec.ECFieldElement r4 = r0.f1271y
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r4 = (org.spongycastle.math.p030ec.custom.sec.SecP384R1FieldElement) r4
            org.spongycastle.math.ec.ECFieldElement r5 = r17.getXCoord()
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r5 = (org.spongycastle.math.p030ec.custom.sec.SecP384R1FieldElement) r5
            org.spongycastle.math.ec.ECFieldElement r6 = r17.getYCoord()
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r6 = (org.spongycastle.math.p030ec.custom.sec.SecP384R1FieldElement) r6
            org.spongycastle.math.ec.ECFieldElement[] r7 = r0.f1272zs
            r8 = 0
            r7 = r7[r8]
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r7 = (org.spongycastle.math.p030ec.custom.sec.SecP384R1FieldElement) r7
            org.spongycastle.math.ec.ECFieldElement r1 = r1.getZCoord(r8)
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r1 = (org.spongycastle.math.p030ec.custom.sec.SecP384R1FieldElement) r1
            r9 = 24
            int[] r10 = org.spongycastle.math.raw.Nat.create(r9)
            int[] r9 = org.spongycastle.math.raw.Nat.create(r9)
            r11 = 12
            int[] r12 = org.spongycastle.math.raw.Nat.create(r11)
            int[] r13 = org.spongycastle.math.raw.Nat.create(r11)
            boolean r14 = r7.isOne()
            if (r14 == 0) goto L_0x005d
            int[] r5 = r5.f1318x
            int[] r6 = r6.f1318x
            goto L_0x0073
        L_0x005d:
            int[] r15 = r7.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.square(r15, r12)
            int[] r5 = r5.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.multiply(r12, r5, r9)
            int[] r5 = r7.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.multiply(r12, r5, r12)
            int[] r5 = r6.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.multiply(r12, r5, r12)
            r5 = r9
            r6 = r12
        L_0x0073:
            boolean r15 = r1.isOne()
            if (r15 == 0) goto L_0x007e
            int[] r2 = r2.f1318x
            int[] r4 = r4.f1318x
            goto L_0x0094
        L_0x007e:
            int[] r8 = r1.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.square(r8, r13)
            int[] r2 = r2.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.multiply(r13, r2, r10)
            int[] r2 = r1.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.multiply(r13, r2, r13)
            int[] r2 = r4.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.multiply(r13, r2, r13)
            r2 = r10
            r4 = r13
        L_0x0094:
            int[] r8 = org.spongycastle.math.raw.Nat.create(r11)
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.subtract(r2, r5, r8)
            int[] r5 = org.spongycastle.math.raw.Nat.create(r11)
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.subtract(r4, r6, r5)
            boolean r6 = org.spongycastle.math.raw.Nat.isZero(r11, r8)
            if (r6 == 0) goto L_0x00b8
            boolean r1 = org.spongycastle.math.raw.Nat.isZero(r11, r5)
            if (r1 == 0) goto L_0x00b3
            org.spongycastle.math.ec.ECPoint r1 = r16.twice()
            return r1
        L_0x00b3:
            org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
            return r1
        L_0x00b8:
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.square(r8, r12)
            int[] r6 = org.spongycastle.math.raw.Nat.create(r11)
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.multiply(r12, r8, r6)
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.multiply(r12, r2, r12)
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.negate(r6, r6)
            org.spongycastle.math.raw.Nat384.mul(r4, r6, r10)
            int r2 = org.spongycastle.math.raw.Nat.addBothTo(r11, r12, r12, r6)
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.reduce32(r2, r6)
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r4 = new org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement
            r4.<init>((int[]) r13)
            int[] r2 = r4.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.square(r5, r2)
            int[] r2 = r4.f1318x
            int[] r11 = r4.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.subtract(r2, r6, r11)
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r11 = new org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement
            r11.<init>((int[]) r6)
            int[] r2 = r4.f1318x
            int[] r6 = r11.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.subtract(r12, r2, r6)
            int[] r2 = r11.f1318x
            org.spongycastle.math.raw.Nat384.mul(r2, r5, r9)
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.addExt(r10, r9, r10)
            int[] r2 = r11.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.reduce(r10, r2)
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r2 = new org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement
            r2.<init>((int[]) r8)
            if (r14 != 0) goto L_0x010c
            int[] r5 = r2.f1318x
            int[] r6 = r7.f1318x
            int[] r7 = r2.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.multiply(r5, r6, r7)
        L_0x010c:
            if (r15 != 0) goto L_0x0117
            int[] r5 = r2.f1318x
            int[] r1 = r1.f1318x
            int[] r6 = r2.f1318x
            org.spongycastle.math.p030ec.custom.sec.SecP384R1Field.multiply(r5, r1, r6)
        L_0x0117:
            r1 = 1
            org.spongycastle.math.ec.ECFieldElement[] r6 = new org.spongycastle.math.p030ec.ECFieldElement[r1]
            r1 = 0
            r6[r1] = r2
            org.spongycastle.math.ec.custom.sec.SecP384R1Point r1 = new org.spongycastle.math.ec.custom.sec.SecP384R1Point
            boolean r7 = r0.withCompression
            r2 = r1
            r5 = r11
            r2.<init>(r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.p030ec.custom.sec.SecP384R1Point.add(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP384R1FieldElement secP384R1FieldElement = (SecP384R1FieldElement) this.f1271y;
        if (secP384R1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP384R1FieldElement secP384R1FieldElement2 = (SecP384R1FieldElement) this.f1270x;
        SecP384R1FieldElement secP384R1FieldElement3 = (SecP384R1FieldElement) this.f1272zs[0];
        int[] create = Nat.create(12);
        int[] create2 = Nat.create(12);
        int[] create3 = Nat.create(12);
        SecP384R1Field.square(secP384R1FieldElement.f1318x, create3);
        int[] create4 = Nat.create(12);
        SecP384R1Field.square(create3, create4);
        boolean isOne = secP384R1FieldElement3.isOne();
        int[] iArr = secP384R1FieldElement3.f1318x;
        if (!isOne) {
            SecP384R1Field.square(secP384R1FieldElement3.f1318x, create2);
            iArr = create2;
        }
        SecP384R1Field.subtract(secP384R1FieldElement2.f1318x, iArr, create);
        SecP384R1Field.add(secP384R1FieldElement2.f1318x, iArr, create2);
        SecP384R1Field.multiply(create2, create, create2);
        SecP384R1Field.reduce32(Nat.addBothTo(12, create2, create2, create2), create2);
        SecP384R1Field.multiply(create3, secP384R1FieldElement2.f1318x, create3);
        SecP384R1Field.reduce32(Nat.shiftUpBits(12, create3, 2, 0), create3);
        SecP384R1Field.reduce32(Nat.shiftUpBits(12, create4, 3, 0, create), create);
        SecP384R1FieldElement secP384R1FieldElement4 = new SecP384R1FieldElement(create4);
        SecP384R1Field.square(create2, secP384R1FieldElement4.f1318x);
        SecP384R1Field.subtract(secP384R1FieldElement4.f1318x, create3, secP384R1FieldElement4.f1318x);
        SecP384R1Field.subtract(secP384R1FieldElement4.f1318x, create3, secP384R1FieldElement4.f1318x);
        SecP384R1FieldElement secP384R1FieldElement5 = new SecP384R1FieldElement(create3);
        SecP384R1Field.subtract(create3, secP384R1FieldElement4.f1318x, secP384R1FieldElement5.f1318x);
        SecP384R1Field.multiply(secP384R1FieldElement5.f1318x, create2, secP384R1FieldElement5.f1318x);
        SecP384R1Field.subtract(secP384R1FieldElement5.f1318x, create, secP384R1FieldElement5.f1318x);
        SecP384R1FieldElement secP384R1FieldElement6 = new SecP384R1FieldElement(create2);
        SecP384R1Field.twice(secP384R1FieldElement.f1318x, secP384R1FieldElement6.f1318x);
        if (!isOne) {
            SecP384R1Field.multiply(secP384R1FieldElement6.f1318x, secP384R1FieldElement3.f1318x, secP384R1FieldElement6.f1318x);
        }
        return new SecP384R1Point(curve, secP384R1FieldElement4, secP384R1FieldElement5, new ECFieldElement[]{secP384R1FieldElement6}, this.withCompression);
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
        return new SecP384R1Point(this.curve, this.f1270x, this.f1271y.negate(), this.f1272zs, this.withCompression);
    }
}
