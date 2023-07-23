package org.spongycastle.math.p030ec;

import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.math.p030ec.ECFieldElement;

/* renamed from: org.spongycastle.math.ec.ECPoint */
public abstract class ECPoint {
    protected static ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];
    protected ECCurve curve;
    protected Hashtable preCompTable;
    protected boolean withCompression;

    /* renamed from: x */
    protected ECFieldElement f1270x;

    /* renamed from: y */
    protected ECFieldElement f1271y;

    /* renamed from: zs */
    protected ECFieldElement[] f1272zs;

    public abstract ECPoint add(ECPoint eCPoint);

    /* access modifiers changed from: protected */
    public abstract ECPoint detach();

    /* access modifiers changed from: protected */
    public abstract boolean getCompressionYTilde();

    public abstract ECPoint negate();

    /* access modifiers changed from: protected */
    public abstract boolean satisfiesCurveEquation();

    public abstract ECPoint subtract(ECPoint eCPoint);

    public abstract ECPoint twice();

    protected static ECFieldElement[] getInitialZCoords(ECCurve eCCurve) {
        int coordinateSystem = eCCurve == null ? 0 : eCCurve.getCoordinateSystem();
        if (coordinateSystem == 0 || coordinateSystem == 5) {
            return EMPTY_ZS;
        }
        ECFieldElement fromBigInteger = eCCurve.fromBigInteger(ECConstants.ONE);
        if (!(coordinateSystem == 1 || coordinateSystem == 2)) {
            if (coordinateSystem == 3) {
                return new ECFieldElement[]{fromBigInteger, fromBigInteger, fromBigInteger};
            } else if (coordinateSystem == 4) {
                return new ECFieldElement[]{fromBigInteger, eCCurve.getA()};
            } else if (coordinateSystem != 6) {
                throw new IllegalArgumentException("unknown coordinate system");
            }
        }
        return new ECFieldElement[]{fromBigInteger};
    }

    protected ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, getInitialZCoords(eCCurve));
    }

    protected ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        this.preCompTable = null;
        this.curve = eCCurve;
        this.f1270x = eCFieldElement;
        this.f1271y = eCFieldElement2;
        this.f1272zs = eCFieldElementArr;
    }

    /* access modifiers changed from: protected */
    public boolean satisfiesCofactor() {
        BigInteger cofactor = this.curve.getCofactor();
        return cofactor == null || cofactor.equals(ECConstants.ONE) || !ECAlgorithms.referenceMultiply(this, cofactor).isInfinity();
    }

    public final ECPoint getDetachedPoint() {
        return normalize().detach();
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    /* access modifiers changed from: protected */
    public int getCurveCoordinateSystem() {
        ECCurve eCCurve = this.curve;
        if (eCCurve == null) {
            return 0;
        }
        return eCCurve.getCoordinateSystem();
    }

    public ECFieldElement getX() {
        return normalize().getXCoord();
    }

    public ECFieldElement getY() {
        return normalize().getYCoord();
    }

    public ECFieldElement getAffineXCoord() {
        checkNormalized();
        return getXCoord();
    }

    public ECFieldElement getAffineYCoord() {
        checkNormalized();
        return getYCoord();
    }

    public ECFieldElement getXCoord() {
        return this.f1270x;
    }

    public ECFieldElement getYCoord() {
        return this.f1271y;
    }

    public ECFieldElement getZCoord(int i) {
        if (i >= 0) {
            ECFieldElement[] eCFieldElementArr = this.f1272zs;
            if (i < eCFieldElementArr.length) {
                return eCFieldElementArr[i];
            }
        }
        return null;
    }

    public ECFieldElement[] getZCoords() {
        ECFieldElement[] eCFieldElementArr = this.f1272zs;
        int length = eCFieldElementArr.length;
        if (length == 0) {
            return eCFieldElementArr;
        }
        ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[length];
        System.arraycopy(eCFieldElementArr, 0, eCFieldElementArr2, 0, length);
        return eCFieldElementArr2;
    }

    /* access modifiers changed from: protected */
    public final ECFieldElement getRawXCoord() {
        return this.f1270x;
    }

    /* access modifiers changed from: protected */
    public final ECFieldElement getRawYCoord() {
        return this.f1271y;
    }

    /* access modifiers changed from: protected */
    public final ECFieldElement[] getRawZCoords() {
        return this.f1272zs;
    }

    /* access modifiers changed from: protected */
    public void checkNormalized() {
        if (!isNormalized()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    public boolean isNormalized() {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        if (curveCoordinateSystem == 0 || curveCoordinateSystem == 5 || isInfinity() || this.f1272zs[0].isOne()) {
            return true;
        }
        return false;
    }

    public ECPoint normalize() {
        int curveCoordinateSystem;
        if (isInfinity() || (curveCoordinateSystem = getCurveCoordinateSystem()) == 0 || curveCoordinateSystem == 5) {
            return this;
        }
        ECFieldElement zCoord = getZCoord(0);
        if (zCoord.isOne()) {
            return this;
        }
        return normalize(zCoord.invert());
    }

    /* access modifiers changed from: package-private */
    public ECPoint normalize(ECFieldElement eCFieldElement) {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        if (curveCoordinateSystem != 1) {
            if (curveCoordinateSystem == 2 || curveCoordinateSystem == 3 || curveCoordinateSystem == 4) {
                ECFieldElement square = eCFieldElement.square();
                return createScaledPoint(square, square.multiply(eCFieldElement));
            } else if (curveCoordinateSystem != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return createScaledPoint(eCFieldElement, eCFieldElement);
    }

    /* access modifiers changed from: protected */
    public ECPoint createScaledPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord().multiply(eCFieldElement2), this.withCompression);
    }

    public boolean isInfinity() {
        if (!(this.f1270x == null || this.f1271y == null)) {
            ECFieldElement[] eCFieldElementArr = this.f1272zs;
            if (eCFieldElementArr.length <= 0 || !eCFieldElementArr[0].isZero()) {
                return false;
            }
        }
        return true;
    }

    public boolean isCompressed() {
        return this.withCompression;
    }

    public boolean isValid() {
        if (!isInfinity() && getCurve() != null && (!satisfiesCurveEquation() || !satisfiesCofactor())) {
            return false;
        }
        return true;
    }

    public ECPoint scaleX(ECFieldElement eCFieldElement) {
        return isInfinity() ? this : getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord(), getRawZCoords(), this.withCompression);
    }

    public ECPoint scaleY(ECFieldElement eCFieldElement) {
        return isInfinity() ? this : getCurve().createRawPoint(getRawXCoord(), getRawYCoord().multiply(eCFieldElement), getRawZCoords(), this.withCompression);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(org.spongycastle.math.p030ec.ECPoint r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            org.spongycastle.math.ec.ECCurve r1 = r8.getCurve()
            org.spongycastle.math.ec.ECCurve r2 = r9.getCurve()
            r3 = 1
            if (r1 != 0) goto L_0x0011
            r4 = 1
            goto L_0x0012
        L_0x0011:
            r4 = 0
        L_0x0012:
            if (r2 != 0) goto L_0x0016
            r5 = 1
            goto L_0x0017
        L_0x0016:
            r5 = 0
        L_0x0017:
            boolean r6 = r8.isInfinity()
            boolean r7 = r9.isInfinity()
            if (r6 != 0) goto L_0x006f
            if (r7 == 0) goto L_0x0024
            goto L_0x006f
        L_0x0024:
            if (r4 == 0) goto L_0x0029
            if (r5 == 0) goto L_0x0029
            goto L_0x002f
        L_0x0029:
            if (r4 == 0) goto L_0x0031
            org.spongycastle.math.ec.ECPoint r9 = r9.normalize()
        L_0x002f:
            r1 = r8
            goto L_0x0051
        L_0x0031:
            if (r5 == 0) goto L_0x0038
            org.spongycastle.math.ec.ECPoint r1 = r8.normalize()
            goto L_0x0051
        L_0x0038:
            boolean r2 = r1.equals((org.spongycastle.math.p030ec.ECCurve) r2)
            if (r2 != 0) goto L_0x003f
            return r0
        L_0x003f:
            r2 = 2
            org.spongycastle.math.ec.ECPoint[] r2 = new org.spongycastle.math.p030ec.ECPoint[r2]
            r2[r0] = r8
            org.spongycastle.math.ec.ECPoint r9 = r1.importPoint(r9)
            r2[r3] = r9
            r1.normalizeAll(r2)
            r1 = r2[r0]
            r9 = r2[r3]
        L_0x0051:
            org.spongycastle.math.ec.ECFieldElement r2 = r1.getXCoord()
            org.spongycastle.math.ec.ECFieldElement r4 = r9.getXCoord()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x006e
            org.spongycastle.math.ec.ECFieldElement r1 = r1.getYCoord()
            org.spongycastle.math.ec.ECFieldElement r9 = r9.getYCoord()
            boolean r9 = r1.equals(r9)
            if (r9 == 0) goto L_0x006e
            r0 = 1
        L_0x006e:
            return r0
        L_0x006f:
            if (r6 == 0) goto L_0x007e
            if (r7 == 0) goto L_0x007e
            if (r4 != 0) goto L_0x007d
            if (r5 != 0) goto L_0x007d
            boolean r9 = r1.equals((org.spongycastle.math.p030ec.ECCurve) r2)
            if (r9 == 0) goto L_0x007e
        L_0x007d:
            r0 = 1
        L_0x007e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.p030ec.ECPoint.equals(org.spongycastle.math.ec.ECPoint):boolean");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ECPoint)) {
            return false;
        }
        return equals((ECPoint) obj);
    }

    public int hashCode() {
        int i;
        ECCurve curve2 = getCurve();
        if (curve2 == null) {
            i = 0;
        } else {
            i = ~curve2.hashCode();
        }
        if (isInfinity()) {
            return i;
        }
        ECPoint normalize = normalize();
        return (i ^ (normalize.getXCoord().hashCode() * 17)) ^ (normalize.getYCoord().hashCode() * 257);
    }

    public String toString() {
        if (isInfinity()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(getRawXCoord());
        stringBuffer.append(',');
        stringBuffer.append(getRawYCoord());
        for (ECFieldElement append : this.f1272zs) {
            stringBuffer.append(',');
            stringBuffer.append(append);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public byte[] getEncoded() {
        return getEncoded(this.withCompression);
    }

    public byte[] getEncoded(boolean z) {
        if (isInfinity()) {
            return new byte[1];
        }
        ECPoint normalize = normalize();
        byte[] encoded = normalize.getXCoord().getEncoded();
        if (z) {
            byte[] bArr = new byte[(encoded.length + 1)];
            bArr[0] = (byte) (normalize.getCompressionYTilde() ? 3 : 2);
            System.arraycopy(encoded, 0, bArr, 1, encoded.length);
            return bArr;
        }
        byte[] encoded2 = normalize.getYCoord().getEncoded();
        byte[] bArr2 = new byte[(encoded.length + encoded2.length + 1)];
        bArr2[0] = 4;
        System.arraycopy(encoded, 0, bArr2, 1, encoded.length);
        System.arraycopy(encoded2, 0, bArr2, encoded.length + 1, encoded2.length);
        return bArr2;
    }

    public ECPoint timesPow2(int i) {
        if (i >= 0) {
            ECPoint eCPoint = this;
            while (true) {
                i--;
                if (i < 0) {
                    return eCPoint;
                }
                eCPoint = eCPoint.twice();
            }
        } else {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        return twice().add(eCPoint);
    }

    public ECPoint threeTimes() {
        return twicePlus(this);
    }

    public ECPoint multiply(BigInteger bigInteger) {
        return getCurve().getMultiplier().multiply(this, bigInteger);
    }

    /* renamed from: org.spongycastle.math.ec.ECPoint$AbstractFp */
    public static abstract class AbstractFp extends ECPoint {
        protected AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        protected AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        /* access modifiers changed from: protected */
        public boolean getCompressionYTilde() {
            return getAffineYCoord().testBitZero();
        }

        /* access modifiers changed from: protected */
        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement = this.f1270x;
            ECFieldElement eCFieldElement2 = this.f1271y;
            ECFieldElement a = this.curve.getA();
            ECFieldElement b = this.curve.getB();
            ECFieldElement square = eCFieldElement2.square();
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 0) {
                if (curveCoordinateSystem == 1) {
                    ECFieldElement eCFieldElement3 = this.f1272zs[0];
                    if (!eCFieldElement3.isOne()) {
                        ECFieldElement square2 = eCFieldElement3.square();
                        ECFieldElement multiply = eCFieldElement3.multiply(square2);
                        square = square.multiply(eCFieldElement3);
                        a = a.multiply(square2);
                        b = b.multiply(multiply);
                    }
                } else if (curveCoordinateSystem == 2 || curveCoordinateSystem == 3 || curveCoordinateSystem == 4) {
                    ECFieldElement eCFieldElement4 = this.f1272zs[0];
                    if (!eCFieldElement4.isOne()) {
                        ECFieldElement square3 = eCFieldElement4.square();
                        ECFieldElement square4 = square3.square();
                        ECFieldElement multiply2 = square3.multiply(square4);
                        a = a.multiply(square4);
                        b = b.multiply(multiply2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return square.equals(eCFieldElement.square().add(a).multiply(eCFieldElement).add(b));
        }

        public ECPoint subtract(ECPoint eCPoint) {
            if (eCPoint.isInfinity()) {
                return this;
            }
            return add(eCPoint.negate());
        }
    }

    /* renamed from: org.spongycastle.math.ec.ECPoint$Fp */
    public static class C3206Fp extends AbstractFp {
        public C3206Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public C3206Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
                this.withCompression = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        C3206Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.withCompression = z;
        }

        /* access modifiers changed from: protected */
        public ECPoint detach() {
            return new C3206Fp((ECCurve) null, getAffineXCoord(), getAffineYCoord());
        }

        public ECFieldElement getZCoord(int i) {
            if (i == 1 && 4 == getCurveCoordinateSystem()) {
                return getJacobianModifiedW();
            }
            return super.getZCoord(i);
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
                int r2 = r3.getCoordinateSystem()
                org.spongycastle.math.ec.ECFieldElement r4 = r0.f1270x
                org.spongycastle.math.ec.ECFieldElement r5 = r0.f1271y
                org.spongycastle.math.ec.ECFieldElement r6 = r1.f1270x
                org.spongycastle.math.ec.ECFieldElement r7 = r1.f1271y
                if (r2 == 0) goto L_0x01e4
                r8 = 1
                r9 = 0
                if (r2 == r8) goto L_0x014c
                r10 = 4
                r11 = 2
                if (r2 == r11) goto L_0x003e
                if (r2 != r10) goto L_0x0036
                goto L_0x003e
            L_0x0036:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "unsupported coordinate system"
                r1.<init>(r2)
                throw r1
            L_0x003e:
                org.spongycastle.math.ec.ECFieldElement[] r12 = r0.f1272zs
                r12 = r12[r9]
                org.spongycastle.math.ec.ECFieldElement[] r1 = r1.f1272zs
                r1 = r1[r9]
                boolean r13 = r12.isOne()
                if (r13 != 0) goto L_0x00a9
                boolean r15 = r12.equals(r1)
                if (r15 == 0) goto L_0x00a9
                org.spongycastle.math.ec.ECFieldElement r1 = r4.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r7 = r5.subtract(r7)
                boolean r15 = r1.isZero()
                if (r15 == 0) goto L_0x0070
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x006b
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x006b:
                org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
                return r1
            L_0x0070:
                org.spongycastle.math.ec.ECFieldElement r15 = r1.square()
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiply(r15)
                org.spongycastle.math.ec.ECFieldElement r6 = r6.multiply(r15)
                org.spongycastle.math.ec.ECFieldElement r14 = r4.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r5 = r14.multiply(r5)
                org.spongycastle.math.ec.ECFieldElement r14 = r7.square()
                org.spongycastle.math.ec.ECFieldElement r14 = r14.subtract(r4)
                org.spongycastle.math.ec.ECFieldElement r6 = r14.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiply(r7)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r5)
                if (r13 == 0) goto L_0x00a0
                r14 = r15
                goto L_0x00a5
            L_0x00a0:
                org.spongycastle.math.ec.ECFieldElement r1 = r1.multiply(r12)
                r14 = 0
            L_0x00a5:
                r5 = r4
                r4 = r6
                goto L_0x012c
            L_0x00a9:
                if (r13 == 0) goto L_0x00ac
                goto L_0x00bc
            L_0x00ac:
                org.spongycastle.math.ec.ECFieldElement r14 = r12.square()
                org.spongycastle.math.ec.ECFieldElement r6 = r14.multiply(r6)
                org.spongycastle.math.ec.ECFieldElement r14 = r14.multiply(r12)
                org.spongycastle.math.ec.ECFieldElement r7 = r14.multiply(r7)
            L_0x00bc:
                boolean r14 = r1.isOne()
                if (r14 == 0) goto L_0x00c3
                goto L_0x00d3
            L_0x00c3:
                org.spongycastle.math.ec.ECFieldElement r15 = r1.square()
                org.spongycastle.math.ec.ECFieldElement r4 = r15.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r15 = r15.multiply(r1)
                org.spongycastle.math.ec.ECFieldElement r5 = r15.multiply(r5)
            L_0x00d3:
                org.spongycastle.math.ec.ECFieldElement r6 = r4.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r7 = r5.subtract(r7)
                boolean r15 = r6.isZero()
                if (r15 == 0) goto L_0x00f1
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x00ec
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x00ec:
                org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
                return r1
            L_0x00f1:
                org.spongycastle.math.ec.ECFieldElement r15 = r6.square()
                org.spongycastle.math.ec.ECFieldElement r8 = r15.multiply(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r15.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r9 = r7.square()
                org.spongycastle.math.ec.ECFieldElement r9 = r9.add(r8)
                org.spongycastle.math.ec.ECFieldElement r11 = r0.two(r4)
                org.spongycastle.math.ec.ECFieldElement r9 = r9.subtract(r11)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r9)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiplyMinusProduct(r7, r8, r5)
                if (r13 != 0) goto L_0x011c
                org.spongycastle.math.ec.ECFieldElement r5 = r6.multiply(r12)
                goto L_0x011d
            L_0x011c:
                r5 = r6
            L_0x011d:
                if (r14 != 0) goto L_0x0124
                org.spongycastle.math.ec.ECFieldElement r1 = r5.multiply(r1)
                goto L_0x0125
            L_0x0124:
                r1 = r5
            L_0x0125:
                r5 = r4
                r4 = r9
                if (r1 != r6) goto L_0x012b
                r14 = r15
                goto L_0x012c
            L_0x012b:
                r14 = 0
            L_0x012c:
                if (r2 != r10) goto L_0x013c
                org.spongycastle.math.ec.ECFieldElement r2 = r0.calculateJacobianModifiedW(r1, r14)
                r6 = 2
                org.spongycastle.math.ec.ECFieldElement[] r6 = new org.spongycastle.math.p030ec.ECFieldElement[r6]
                r7 = 0
                r6[r7] = r1
                r8 = 1
                r6[r8] = r2
                goto L_0x0143
            L_0x013c:
                r7 = 0
                r8 = 1
                org.spongycastle.math.ec.ECFieldElement[] r2 = new org.spongycastle.math.p030ec.ECFieldElement[r8]
                r2[r7] = r1
                r6 = r2
            L_0x0143:
                org.spongycastle.math.ec.ECPoint$Fp r1 = new org.spongycastle.math.ec.ECPoint$Fp
                boolean r7 = r0.withCompression
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                return r1
            L_0x014c:
                org.spongycastle.math.ec.ECFieldElement[] r2 = r0.f1272zs
                r8 = 0
                r2 = r2[r8]
                org.spongycastle.math.ec.ECFieldElement[] r1 = r1.f1272zs
                r1 = r1[r8]
                boolean r8 = r2.isOne()
                boolean r9 = r1.isOne()
                if (r8 == 0) goto L_0x0160
                goto L_0x0164
            L_0x0160:
                org.spongycastle.math.ec.ECFieldElement r7 = r7.multiply(r2)
            L_0x0164:
                if (r9 == 0) goto L_0x0167
                goto L_0x016b
            L_0x0167:
                org.spongycastle.math.ec.ECFieldElement r5 = r5.multiply(r1)
            L_0x016b:
                org.spongycastle.math.ec.ECFieldElement r7 = r7.subtract(r5)
                if (r8 == 0) goto L_0x0172
                goto L_0x0176
            L_0x0172:
                org.spongycastle.math.ec.ECFieldElement r6 = r6.multiply(r2)
            L_0x0176:
                if (r9 == 0) goto L_0x0179
                goto L_0x017d
            L_0x0179:
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiply(r1)
            L_0x017d:
                org.spongycastle.math.ec.ECFieldElement r6 = r6.subtract(r4)
                boolean r10 = r6.isZero()
                if (r10 == 0) goto L_0x0197
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x0192
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x0192:
                org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
                return r1
            L_0x0197:
                if (r8 == 0) goto L_0x019b
                r2 = r1
                goto L_0x01a2
            L_0x019b:
                if (r9 == 0) goto L_0x019e
                goto L_0x01a2
            L_0x019e:
                org.spongycastle.math.ec.ECFieldElement r2 = r2.multiply(r1)
            L_0x01a2:
                org.spongycastle.math.ec.ECFieldElement r1 = r6.square()
                org.spongycastle.math.ec.ECFieldElement r8 = r1.multiply(r6)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r4 = r7.square()
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiply(r2)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r8)
                org.spongycastle.math.ec.ECFieldElement r9 = r0.two(r1)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r9)
                org.spongycastle.math.ec.ECFieldElement r6 = r6.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.subtract(r4)
                org.spongycastle.math.ec.ECFieldElement r5 = r1.multiplyMinusProduct(r7, r5, r8)
                org.spongycastle.math.ec.ECFieldElement r1 = r8.multiply(r2)
                org.spongycastle.math.ec.ECPoint$Fp r8 = new org.spongycastle.math.ec.ECPoint$Fp
                r2 = 1
                org.spongycastle.math.ec.ECFieldElement[] r7 = new org.spongycastle.math.p030ec.ECFieldElement[r2]
                r2 = 0
                r7[r2] = r1
                boolean r1 = r0.withCompression
                r2 = r8
                r4 = r6
                r6 = r7
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                return r8
            L_0x01e4:
                org.spongycastle.math.ec.ECFieldElement r1 = r6.subtract(r4)
                org.spongycastle.math.ec.ECFieldElement r2 = r7.subtract(r5)
                boolean r7 = r1.isZero()
                if (r7 == 0) goto L_0x0202
                boolean r1 = r2.isZero()
                if (r1 == 0) goto L_0x01fd
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x01fd:
                org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
                return r1
            L_0x0202:
                org.spongycastle.math.ec.ECFieldElement r1 = r2.divide(r1)
                org.spongycastle.math.ec.ECFieldElement r2 = r1.square()
                org.spongycastle.math.ec.ECFieldElement r2 = r2.subtract(r4)
                org.spongycastle.math.ec.ECFieldElement r2 = r2.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r2)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.subtract(r5)
                org.spongycastle.math.ec.ECPoint$Fp r4 = new org.spongycastle.math.ec.ECPoint$Fp
                boolean r5 = r0.withCompression
                r4.<init>(r3, r2, r1, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.p030ec.ECPoint.C3206Fp.add(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
        }

        public ECPoint twice() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement6 = this.f1271y;
            if (eCFieldElement6.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement7 = this.f1270x;
            if (coordinateSystem == 0) {
                ECFieldElement divide = three(eCFieldElement7.square()).add(getCurve().getA()).divide(two(eCFieldElement6));
                ECFieldElement subtract = divide.square().subtract(two(eCFieldElement7));
                return new C3206Fp(curve, subtract, divide.multiply(eCFieldElement7.subtract(subtract)).subtract(eCFieldElement6), this.withCompression);
            } else if (coordinateSystem == 1) {
                ECFieldElement eCFieldElement8 = this.f1272zs[0];
                boolean isOne = eCFieldElement8.isOne();
                ECFieldElement a = curve.getA();
                if (!a.isZero() && !isOne) {
                    a = a.multiply(eCFieldElement8.square());
                }
                ECFieldElement add = a.add(three(eCFieldElement7.square()));
                if (isOne) {
                    eCFieldElement = eCFieldElement6;
                } else {
                    eCFieldElement = eCFieldElement6.multiply(eCFieldElement8);
                }
                ECFieldElement square = isOne ? eCFieldElement6.square() : eCFieldElement.multiply(eCFieldElement6);
                ECFieldElement four = four(eCFieldElement7.multiply(square));
                ECFieldElement subtract2 = add.square().subtract(two(four));
                ECFieldElement two = two(eCFieldElement);
                ECFieldElement multiply = subtract2.multiply(two);
                ECFieldElement two2 = two(square);
                return new C3206Fp(curve, multiply, four.subtract(subtract2).multiply(add).subtract(two(two2.square())), new ECFieldElement[]{two(isOne ? two(two2) : two.square()).multiply(eCFieldElement)}, this.withCompression);
            } else if (coordinateSystem == 2) {
                ECFieldElement eCFieldElement9 = this.f1272zs[0];
                boolean isOne2 = eCFieldElement9.isOne();
                ECFieldElement square2 = eCFieldElement6.square();
                ECFieldElement square3 = square2.square();
                ECFieldElement a2 = curve.getA();
                ECFieldElement negate = a2.negate();
                if (negate.toBigInteger().equals(BigInteger.valueOf(3))) {
                    if (isOne2) {
                        eCFieldElement5 = eCFieldElement9;
                    } else {
                        eCFieldElement5 = eCFieldElement9.square();
                    }
                    eCFieldElement2 = three(eCFieldElement7.add(eCFieldElement5).multiply(eCFieldElement7.subtract(eCFieldElement5)));
                    eCFieldElement3 = four(square2.multiply(eCFieldElement7));
                } else {
                    ECFieldElement three = three(eCFieldElement7.square());
                    if (isOne2) {
                        eCFieldElement2 = three.add(a2);
                    } else if (!a2.isZero()) {
                        if (isOne2) {
                            eCFieldElement4 = eCFieldElement9;
                        } else {
                            eCFieldElement4 = eCFieldElement9.square();
                        }
                        ECFieldElement square4 = eCFieldElement4.square();
                        eCFieldElement2 = negate.bitLength() < a2.bitLength() ? three.subtract(square4.multiply(negate)) : three.add(square4.multiply(a2));
                    } else {
                        eCFieldElement2 = three;
                    }
                    eCFieldElement3 = four(eCFieldElement7.multiply(square2));
                }
                ECFieldElement subtract3 = eCFieldElement2.square().subtract(two(eCFieldElement3));
                ECFieldElement subtract4 = eCFieldElement3.subtract(subtract3).multiply(eCFieldElement2).subtract(eight(square3));
                ECFieldElement two3 = two(eCFieldElement6);
                if (!isOne2) {
                    two3 = two3.multiply(eCFieldElement9);
                }
                return new C3206Fp(curve, subtract3, subtract4, new ECFieldElement[]{two3}, this.withCompression);
            } else if (coordinateSystem == 4) {
                return twiceJacobianModified(true);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
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
            ECFieldElement eCFieldElement = this.f1271y;
            if (eCFieldElement.isZero()) {
                return eCPoint;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElement2 = this.f1270x;
                ECFieldElement eCFieldElement3 = eCPoint.f1270x;
                ECFieldElement eCFieldElement4 = eCPoint.f1271y;
                ECFieldElement subtract = eCFieldElement3.subtract(eCFieldElement2);
                ECFieldElement subtract2 = eCFieldElement4.subtract(eCFieldElement);
                if (!subtract.isZero()) {
                    ECFieldElement square = subtract.square();
                    ECFieldElement subtract3 = square.multiply(two(eCFieldElement2).add(eCFieldElement3)).subtract(subtract2.square());
                    if (subtract3.isZero()) {
                        return curve.getInfinity();
                    }
                    ECFieldElement invert = subtract3.multiply(subtract).invert();
                    ECFieldElement multiply = subtract3.multiply(invert).multiply(subtract2);
                    ECFieldElement subtract4 = two(eCFieldElement).multiply(square).multiply(subtract).multiply(invert).subtract(multiply);
                    ECFieldElement add = subtract4.subtract(multiply).multiply(multiply.add(subtract4)).add(eCFieldElement3);
                    return new C3206Fp(curve, add, eCFieldElement2.subtract(add).multiply(subtract4).subtract(eCFieldElement), this.withCompression);
                } else if (subtract2.isZero()) {
                    return threeTimes();
                } else {
                    return this;
                }
            } else if (coordinateSystem != 4) {
                return twice().add(eCPoint);
            } else {
                return twiceJacobianModified(false).add(eCPoint);
            }
        }

        public ECPoint threeTimes() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.f1271y;
            if (eCFieldElement.isZero()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElement2 = this.f1270x;
                ECFieldElement two = two(eCFieldElement);
                ECFieldElement square = two.square();
                ECFieldElement add = three(eCFieldElement2.square()).add(getCurve().getA());
                ECFieldElement subtract = three(eCFieldElement2).multiply(square).subtract(add.square());
                if (subtract.isZero()) {
                    return getCurve().getInfinity();
                }
                ECFieldElement invert = subtract.multiply(two).invert();
                ECFieldElement multiply = subtract.multiply(invert).multiply(add);
                ECFieldElement subtract2 = square.square().multiply(invert).subtract(multiply);
                ECFieldElement add2 = subtract2.subtract(multiply).multiply(multiply.add(subtract2)).add(eCFieldElement2);
                return new C3206Fp(curve, add2, eCFieldElement2.subtract(add2).multiply(subtract2).subtract(eCFieldElement), this.withCompression);
            } else if (coordinateSystem != 4) {
                return twice().add(this);
            } else {
                return twiceJacobianModified(false).add(this);
            }
        }

        public ECPoint timesPow2(int i) {
            int i2 = i;
            if (i2 < 0) {
                throw new IllegalArgumentException("'e' cannot be negative");
            } else if (i2 == 0 || isInfinity()) {
                return this;
            } else {
                if (i2 == 1) {
                    return twice();
                }
                ECCurve curve = getCurve();
                ECFieldElement eCFieldElement = this.f1271y;
                if (eCFieldElement.isZero()) {
                    return curve.getInfinity();
                }
                int coordinateSystem = curve.getCoordinateSystem();
                ECFieldElement a = curve.getA();
                ECFieldElement eCFieldElement2 = this.f1270x;
                ECFieldElement fromBigInteger = this.f1272zs.length < 1 ? curve.fromBigInteger(ECConstants.ONE) : this.f1272zs[0];
                if (!fromBigInteger.isOne()) {
                    if (coordinateSystem == 1) {
                        ECFieldElement square = fromBigInteger.square();
                        eCFieldElement2 = eCFieldElement2.multiply(fromBigInteger);
                        eCFieldElement = eCFieldElement.multiply(square);
                        a = calculateJacobianModifiedW(fromBigInteger, square);
                    } else if (coordinateSystem == 2) {
                        a = calculateJacobianModifiedW(fromBigInteger, (ECFieldElement) null);
                    } else if (coordinateSystem == 4) {
                        a = getJacobianModifiedW();
                    }
                }
                int i3 = 0;
                ECFieldElement eCFieldElement3 = a;
                ECFieldElement eCFieldElement4 = eCFieldElement;
                ECFieldElement eCFieldElement5 = eCFieldElement2;
                ECFieldElement eCFieldElement6 = eCFieldElement3;
                while (i3 < i2) {
                    if (eCFieldElement4.isZero()) {
                        return curve.getInfinity();
                    }
                    ECFieldElement three = three(eCFieldElement5.square());
                    ECFieldElement two = two(eCFieldElement4);
                    ECFieldElement multiply = two.multiply(eCFieldElement4);
                    ECFieldElement two2 = two(eCFieldElement5.multiply(multiply));
                    ECFieldElement two3 = two(multiply.square());
                    if (!eCFieldElement6.isZero()) {
                        three = three.add(eCFieldElement6);
                        eCFieldElement6 = two(two3.multiply(eCFieldElement6));
                    }
                    ECFieldElement subtract = three.square().subtract(two(two2));
                    eCFieldElement4 = three.multiply(two2.subtract(subtract)).subtract(two3);
                    fromBigInteger = fromBigInteger.isOne() ? two : two.multiply(fromBigInteger);
                    i3++;
                    eCFieldElement5 = subtract;
                }
                if (coordinateSystem == 0) {
                    ECFieldElement invert = fromBigInteger.invert();
                    ECFieldElement square2 = invert.square();
                    return new C3206Fp(curve, eCFieldElement5.multiply(square2), eCFieldElement4.multiply(square2.multiply(invert)), this.withCompression);
                } else if (coordinateSystem == 1) {
                    return new C3206Fp(curve, eCFieldElement5.multiply(fromBigInteger), eCFieldElement4, new ECFieldElement[]{fromBigInteger.multiply(fromBigInteger.square())}, this.withCompression);
                } else if (coordinateSystem == 2) {
                    return new C3206Fp(curve, eCFieldElement5, eCFieldElement4, new ECFieldElement[]{fromBigInteger}, this.withCompression);
                } else if (coordinateSystem == 4) {
                    return new C3206Fp(curve, eCFieldElement5, eCFieldElement4, new ECFieldElement[]{fromBigInteger, eCFieldElement6}, this.withCompression);
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
        }

        /* access modifiers changed from: protected */
        public ECFieldElement two(ECFieldElement eCFieldElement) {
            return eCFieldElement.add(eCFieldElement);
        }

        /* access modifiers changed from: protected */
        public ECFieldElement three(ECFieldElement eCFieldElement) {
            return two(eCFieldElement).add(eCFieldElement);
        }

        /* access modifiers changed from: protected */
        public ECFieldElement four(ECFieldElement eCFieldElement) {
            return two(two(eCFieldElement));
        }

        /* access modifiers changed from: protected */
        public ECFieldElement eight(ECFieldElement eCFieldElement) {
            return four(two(eCFieldElement));
        }

        /* access modifiers changed from: protected */
        public ECFieldElement doubleProductFromSquares(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3, ECFieldElement eCFieldElement4) {
            return eCFieldElement.add(eCFieldElement2).square().subtract(eCFieldElement3).subtract(eCFieldElement4);
        }

        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            if (curve.getCoordinateSystem() != 0) {
                return new C3206Fp(curve, this.f1270x, this.f1271y.negate(), this.f1272zs, this.withCompression);
            }
            return new C3206Fp(curve, this.f1270x, this.f1271y.negate(), this.withCompression);
        }

        /* access modifiers changed from: protected */
        public ECFieldElement calculateJacobianModifiedW(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            ECFieldElement a = getCurve().getA();
            if (a.isZero() || eCFieldElement.isOne()) {
                return a;
            }
            if (eCFieldElement2 == null) {
                eCFieldElement2 = eCFieldElement.square();
            }
            ECFieldElement square = eCFieldElement2.square();
            ECFieldElement negate = a.negate();
            if (negate.bitLength() < a.bitLength()) {
                return square.multiply(negate).negate();
            }
            return square.multiply(a);
        }

        /* access modifiers changed from: protected */
        public ECFieldElement getJacobianModifiedW() {
            ECFieldElement eCFieldElement = this.f1272zs[1];
            if (eCFieldElement != null) {
                return eCFieldElement;
            }
            ECFieldElement[] eCFieldElementArr = this.f1272zs;
            ECFieldElement calculateJacobianModifiedW = calculateJacobianModifiedW(this.f1272zs[0], (ECFieldElement) null);
            eCFieldElementArr[1] = calculateJacobianModifiedW;
            return calculateJacobianModifiedW;
        }

        /* access modifiers changed from: protected */
        public C3206Fp twiceJacobianModified(boolean z) {
            ECFieldElement eCFieldElement = this.f1270x;
            ECFieldElement eCFieldElement2 = this.f1271y;
            ECFieldElement eCFieldElement3 = this.f1272zs[0];
            ECFieldElement jacobianModifiedW = getJacobianModifiedW();
            ECFieldElement add = three(eCFieldElement.square()).add(jacobianModifiedW);
            ECFieldElement two = two(eCFieldElement2);
            ECFieldElement multiply = two.multiply(eCFieldElement2);
            ECFieldElement two2 = two(eCFieldElement.multiply(multiply));
            ECFieldElement subtract = add.square().subtract(two(two2));
            ECFieldElement two3 = two(multiply.square());
            ECFieldElement subtract2 = add.multiply(two2.subtract(subtract)).subtract(two3);
            ECFieldElement two4 = z ? two(two3.multiply(jacobianModifiedW)) : null;
            if (!eCFieldElement3.isOne()) {
                two = two.multiply(eCFieldElement3);
            }
            return new C3206Fp(getCurve(), subtract, subtract2, new ECFieldElement[]{two, two4}, this.withCompression);
        }
    }

    /* renamed from: org.spongycastle.math.ec.ECPoint$AbstractF2m */
    public static abstract class AbstractF2m extends ECPoint {
        protected AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        protected AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        /* access modifiers changed from: protected */
        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement3 = this.f1270x;
            ECFieldElement a = curve.getA();
            ECFieldElement b = curve.getB();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 6) {
                ECFieldElement eCFieldElement4 = this.f1272zs[0];
                boolean isOne = eCFieldElement4.isOne();
                if (eCFieldElement3.isZero()) {
                    ECFieldElement square = this.f1271y.square();
                    if (!isOne) {
                        b = b.multiply(eCFieldElement4.square());
                    }
                    return square.equals(b);
                }
                ECFieldElement eCFieldElement5 = this.f1271y;
                ECFieldElement square2 = eCFieldElement3.square();
                if (isOne) {
                    eCFieldElement2 = eCFieldElement5.square().add(eCFieldElement5).add(a);
                    eCFieldElement = square2.square().add(b);
                } else {
                    ECFieldElement square3 = eCFieldElement4.square();
                    ECFieldElement square4 = square3.square();
                    eCFieldElement2 = eCFieldElement5.add(eCFieldElement4).multiplyPlusProduct(eCFieldElement5, a, square3);
                    eCFieldElement = square2.squarePlusProduct(b, square4);
                }
                return eCFieldElement2.multiply(square2).equals(eCFieldElement);
            }
            ECFieldElement eCFieldElement6 = this.f1271y;
            ECFieldElement multiply = eCFieldElement6.add(eCFieldElement3).multiply(eCFieldElement6);
            if (coordinateSystem != 0) {
                if (coordinateSystem == 1) {
                    ECFieldElement eCFieldElement7 = this.f1272zs[0];
                    if (!eCFieldElement7.isOne()) {
                        ECFieldElement multiply2 = eCFieldElement7.multiply(eCFieldElement7.square());
                        multiply = multiply.multiply(eCFieldElement7);
                        a = a.multiply(eCFieldElement7);
                        b = b.multiply(multiply2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return multiply.equals(eCFieldElement3.add(a).multiply(eCFieldElement3.square()).add(b));
        }
    }

    /* renamed from: org.spongycastle.math.ec.ECPoint$F2m */
    public static class F2m extends AbstractF2m {
        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
                if (eCFieldElement != null) {
                    ECFieldElement.F2m.checkFieldElements(this.f1270x, this.f1271y);
                    if (eCCurve != null) {
                        ECFieldElement.F2m.checkFieldElements(this.f1270x, this.curve.getA());
                    }
                }
                this.withCompression = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.withCompression = z;
        }

        /* access modifiers changed from: protected */
        public ECPoint detach() {
            return new F2m((ECCurve) null, getAffineXCoord(), getAffineYCoord());
        }

        public ECFieldElement getYCoord() {
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return this.f1271y;
            }
            ECFieldElement eCFieldElement = this.f1270x;
            ECFieldElement eCFieldElement2 = this.f1271y;
            if (isInfinity() || eCFieldElement.isZero()) {
                return eCFieldElement2;
            }
            ECFieldElement multiply = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
            if (6 != curveCoordinateSystem) {
                return multiply;
            }
            ECFieldElement eCFieldElement3 = this.f1272zs[0];
            return !eCFieldElement3.isOne() ? multiply.divide(eCFieldElement3) : multiply;
        }

        public ECPoint scaleX(ECFieldElement eCFieldElement) {
            if (isInfinity()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem == 5) {
                ECFieldElement rawXCoord = getRawXCoord();
                ECFieldElement rawYCoord = getRawYCoord();
                return getCurve().createRawPoint(rawXCoord, rawYCoord.add(rawXCoord).divide(eCFieldElement).add(rawXCoord.multiply(eCFieldElement)), getRawZCoords(), this.withCompression);
            } else if (curveCoordinateSystem != 6) {
                return super.scaleX(eCFieldElement);
            } else {
                ECFieldElement rawXCoord2 = getRawXCoord();
                ECFieldElement rawYCoord2 = getRawYCoord();
                ECFieldElement eCFieldElement2 = getRawZCoords()[0];
                ECFieldElement multiply = rawXCoord2.multiply(eCFieldElement.square());
                ECFieldElement add = rawYCoord2.add(rawXCoord2).add(multiply);
                ECFieldElement multiply2 = eCFieldElement2.multiply(eCFieldElement);
                return getCurve().createRawPoint(multiply, add, new ECFieldElement[]{multiply2}, this.withCompression);
            }
        }

        public ECPoint scaleY(ECFieldElement eCFieldElement) {
            if (isInfinity()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return super.scaleY(eCFieldElement);
            }
            ECFieldElement rawXCoord = getRawXCoord();
            return getCurve().createRawPoint(rawXCoord, getRawYCoord().add(rawXCoord).multiply(eCFieldElement).add(rawXCoord), getRawZCoords(), this.withCompression);
        }

        /* access modifiers changed from: protected */
        public boolean getCompressionYTilde() {
            ECFieldElement rawXCoord = getRawXCoord();
            if (rawXCoord.isZero()) {
                return false;
            }
            ECFieldElement rawYCoord = getRawYCoord();
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return rawYCoord.divide(rawXCoord).testBitZero();
            }
            if (rawYCoord.testBitZero() != rawXCoord.testBitZero()) {
                return true;
            }
            return false;
        }

        private static void checkPoints(ECPoint eCPoint, ECPoint eCPoint2) {
            if (eCPoint.curve != eCPoint2.curve) {
                throw new IllegalArgumentException("Only points on the same curve can be added or subtracted");
            }
        }

        public ECPoint add(ECPoint eCPoint) {
            checkPoints(this, eCPoint);
            return addSimple((F2m) eCPoint);
        }

        public F2m addSimple(F2m f2m) {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            ECFieldElement eCFieldElement7;
            ECFieldElement eCFieldElement8;
            F2m f2m2 = f2m;
            if (isInfinity()) {
                return f2m2;
            }
            if (f2m.isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement9 = this.f1270x;
            ECFieldElement eCFieldElement10 = f2m2.f1270x;
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElement11 = this.f1271y;
                ECFieldElement eCFieldElement12 = f2m2.f1271y;
                ECFieldElement add = eCFieldElement9.add(eCFieldElement10);
                ECFieldElement add2 = eCFieldElement11.add(eCFieldElement12);
                if (!add.isZero()) {
                    ECFieldElement divide = add2.divide(add);
                    ECFieldElement add3 = divide.square().add(divide).add(add).add(curve.getA());
                    return new F2m(curve, add3, divide.multiply(eCFieldElement9.add(add3)).add(add3).add(eCFieldElement11), this.withCompression);
                } else if (add2.isZero()) {
                    return (F2m) twice();
                } else {
                    return (F2m) curve.getInfinity();
                }
            } else if (coordinateSystem == 1) {
                ECFieldElement eCFieldElement13 = this.f1271y;
                ECFieldElement eCFieldElement14 = this.f1272zs[0];
                ECFieldElement eCFieldElement15 = f2m2.f1271y;
                ECFieldElement eCFieldElement16 = f2m2.f1272zs[0];
                boolean isOne = eCFieldElement16.isOne();
                ECFieldElement multiply = eCFieldElement14.multiply(eCFieldElement15);
                if (isOne) {
                    eCFieldElement = eCFieldElement13;
                } else {
                    eCFieldElement = eCFieldElement13.multiply(eCFieldElement16);
                }
                ECFieldElement add4 = multiply.add(eCFieldElement);
                ECFieldElement multiply2 = eCFieldElement14.multiply(eCFieldElement10);
                if (isOne) {
                    eCFieldElement2 = eCFieldElement9;
                } else {
                    eCFieldElement2 = eCFieldElement9.multiply(eCFieldElement16);
                }
                ECFieldElement add5 = multiply2.add(eCFieldElement2);
                if (!add5.isZero()) {
                    ECFieldElement square = add5.square();
                    ECFieldElement multiply3 = square.multiply(add5);
                    if (!isOne) {
                        eCFieldElement14 = eCFieldElement14.multiply(eCFieldElement16);
                    }
                    ECFieldElement add6 = add4.add(add5);
                    ECFieldElement add7 = add6.multiplyPlusProduct(add4, square, curve.getA()).multiply(eCFieldElement14).add(multiply3);
                    ECFieldElement multiply4 = add5.multiply(add7);
                    if (!isOne) {
                        square = square.multiply(eCFieldElement16);
                    }
                    return new F2m(curve, multiply4, add4.multiplyPlusProduct(eCFieldElement9, add5, eCFieldElement13).multiplyPlusProduct(square, add6, add7), new ECFieldElement[]{multiply3.multiply(eCFieldElement14)}, this.withCompression);
                } else if (add4.isZero()) {
                    return (F2m) twice();
                } else {
                    return (F2m) curve.getInfinity();
                }
            } else if (coordinateSystem != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            } else if (!eCFieldElement9.isZero()) {
                ECFieldElement eCFieldElement17 = this.f1271y;
                ECFieldElement eCFieldElement18 = this.f1272zs[0];
                ECFieldElement eCFieldElement19 = f2m2.f1271y;
                ECFieldElement eCFieldElement20 = f2m2.f1272zs[0];
                boolean isOne2 = eCFieldElement18.isOne();
                if (!isOne2) {
                    eCFieldElement4 = eCFieldElement10.multiply(eCFieldElement18);
                    eCFieldElement3 = eCFieldElement19.multiply(eCFieldElement18);
                } else {
                    eCFieldElement4 = eCFieldElement10;
                    eCFieldElement3 = eCFieldElement19;
                }
                boolean isOne3 = eCFieldElement20.isOne();
                if (!isOne3) {
                    eCFieldElement9 = eCFieldElement9.multiply(eCFieldElement20);
                    eCFieldElement5 = eCFieldElement17.multiply(eCFieldElement20);
                } else {
                    eCFieldElement5 = eCFieldElement17;
                }
                ECFieldElement add8 = eCFieldElement5.add(eCFieldElement3);
                ECFieldElement add9 = eCFieldElement9.add(eCFieldElement4);
                if (!add9.isZero()) {
                    if (eCFieldElement10.isZero()) {
                        ECPoint normalize = normalize();
                        ECFieldElement xCoord = normalize.getXCoord();
                        ECFieldElement yCoord = normalize.getYCoord();
                        ECFieldElement divide2 = yCoord.add(eCFieldElement19).divide(xCoord);
                        eCFieldElement6 = divide2.square().add(divide2).add(xCoord).add(curve.getA());
                        if (eCFieldElement6.isZero()) {
                            return new F2m(curve, eCFieldElement6, curve.getB().sqrt(), this.withCompression);
                        }
                        eCFieldElement8 = divide2.multiply(xCoord.add(eCFieldElement6)).add(eCFieldElement6).add(yCoord).divide(eCFieldElement6).add(eCFieldElement6);
                        eCFieldElement7 = curve.fromBigInteger(ECConstants.ONE);
                    } else {
                        ECFieldElement square2 = add9.square();
                        ECFieldElement multiply5 = add8.multiply(eCFieldElement9);
                        ECFieldElement multiply6 = add8.multiply(eCFieldElement4);
                        ECFieldElement multiply7 = multiply5.multiply(multiply6);
                        if (multiply7.isZero()) {
                            return new F2m(curve, multiply7, curve.getB().sqrt(), this.withCompression);
                        }
                        ECFieldElement multiply8 = add8.multiply(square2);
                        ECFieldElement multiply9 = !isOne3 ? multiply8.multiply(eCFieldElement20) : multiply8;
                        ECFieldElement squarePlusProduct = multiply6.add(square2).squarePlusProduct(multiply9, eCFieldElement17.add(eCFieldElement18));
                        if (!isOne2) {
                            multiply9 = multiply9.multiply(eCFieldElement18);
                        }
                        eCFieldElement6 = multiply7;
                        ECFieldElement eCFieldElement21 = squarePlusProduct;
                        eCFieldElement7 = multiply9;
                        eCFieldElement8 = eCFieldElement21;
                    }
                    return new F2m(curve, eCFieldElement6, eCFieldElement8, new ECFieldElement[]{eCFieldElement7}, this.withCompression);
                } else if (add8.isZero()) {
                    return (F2m) twice();
                } else {
                    return (F2m) curve.getInfinity();
                }
            } else if (eCFieldElement10.isZero()) {
                return (F2m) curve.getInfinity();
            } else {
                return f2m2.addSimple(this);
            }
        }

        public ECPoint subtract(ECPoint eCPoint) {
            checkPoints(this, eCPoint);
            return subtractSimple((F2m) eCPoint);
        }

        public F2m subtractSimple(F2m f2m) {
            if (f2m.isInfinity()) {
                return this;
            }
            return addSimple((F2m) f2m.negate());
        }

        public F2m tau() {
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement = this.f1270x;
            if (coordinateSystem != 0) {
                if (coordinateSystem != 1) {
                    if (coordinateSystem != 5) {
                        if (coordinateSystem != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                }
                ECFieldElement eCFieldElement2 = this.f1271y;
                ECFieldElement eCFieldElement3 = this.f1272zs[0];
                return new F2m(curve, eCFieldElement.square(), eCFieldElement2.square(), new ECFieldElement[]{eCFieldElement3.square()}, this.withCompression);
            }
            return new F2m(curve, eCFieldElement.square(), this.f1271y.square(), this.withCompression);
        }

        public ECPoint twice() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            ECFieldElement eCFieldElement7;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement8 = this.f1270x;
            if (eCFieldElement8.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 0) {
                ECCurve eCCurve = curve;
                ECFieldElement add = this.f1271y.divide(eCFieldElement8).add(eCFieldElement8);
                ECFieldElement add2 = add.square().add(add).add(eCCurve.getA());
                return new F2m(eCCurve, add2, eCFieldElement8.squarePlusProduct(add2, add.addOne()), this.withCompression);
            } else if (coordinateSystem == 1) {
                ECCurve eCCurve2 = curve;
                ECFieldElement eCFieldElement9 = this.f1271y;
                ECFieldElement eCFieldElement10 = this.f1272zs[0];
                boolean isOne = eCFieldElement10.isOne();
                if (isOne) {
                    eCFieldElement = eCFieldElement8;
                } else {
                    eCFieldElement = eCFieldElement8.multiply(eCFieldElement10);
                }
                if (!isOne) {
                    eCFieldElement9 = eCFieldElement9.multiply(eCFieldElement10);
                }
                ECFieldElement square = eCFieldElement8.square();
                ECFieldElement add3 = square.add(eCFieldElement9);
                ECFieldElement square2 = eCFieldElement.square();
                ECFieldElement add4 = add3.add(eCFieldElement);
                ECFieldElement multiplyPlusProduct = add4.multiplyPlusProduct(add3, square2, eCCurve2.getA());
                return new F2m(eCCurve2, eCFieldElement.multiply(multiplyPlusProduct), square.square().multiplyPlusProduct(eCFieldElement, multiplyPlusProduct, add4), new ECFieldElement[]{eCFieldElement.multiply(square2)}, this.withCompression);
            } else if (coordinateSystem == 6) {
                ECFieldElement eCFieldElement11 = this.f1271y;
                ECFieldElement eCFieldElement12 = this.f1272zs[0];
                boolean isOne2 = eCFieldElement12.isOne();
                if (isOne2) {
                    eCFieldElement2 = eCFieldElement11;
                } else {
                    eCFieldElement2 = eCFieldElement11.multiply(eCFieldElement12);
                }
                if (isOne2) {
                    eCFieldElement3 = eCFieldElement12;
                } else {
                    eCFieldElement3 = eCFieldElement12.square();
                }
                ECFieldElement a = curve.getA();
                if (isOne2) {
                    eCFieldElement4 = a;
                } else {
                    eCFieldElement4 = a.multiply(eCFieldElement3);
                }
                ECFieldElement add5 = eCFieldElement11.square().add(eCFieldElement2).add(eCFieldElement4);
                if (add5.isZero()) {
                    return new F2m(curve, add5, curve.getB().sqrt(), this.withCompression);
                }
                ECFieldElement square3 = add5.square();
                if (isOne2) {
                    eCFieldElement5 = add5;
                } else {
                    eCFieldElement5 = add5.multiply(eCFieldElement3);
                }
                ECFieldElement b = curve.getB();
                ECCurve eCCurve3 = curve;
                if (b.bitLength() < (curve.getFieldSize() >> 1)) {
                    ECFieldElement square4 = eCFieldElement11.add(eCFieldElement8).square();
                    if (b.isOne()) {
                        eCFieldElement7 = eCFieldElement4.add(eCFieldElement3).square();
                    } else {
                        eCFieldElement7 = eCFieldElement4.squarePlusProduct(b, eCFieldElement3.square());
                    }
                    eCFieldElement6 = square4.add(add5).add(eCFieldElement3).multiply(square4).add(eCFieldElement7).add(square3);
                    if (a.isZero()) {
                        eCFieldElement6 = eCFieldElement6.add(eCFieldElement5);
                    } else if (!a.isOne()) {
                        eCFieldElement6 = eCFieldElement6.add(a.addOne().multiply(eCFieldElement5));
                    }
                } else {
                    if (!isOne2) {
                        eCFieldElement8 = eCFieldElement8.multiply(eCFieldElement12);
                    }
                    eCFieldElement6 = eCFieldElement8.squarePlusProduct(add5, eCFieldElement2).add(square3).add(eCFieldElement5);
                }
                return new F2m(eCCurve3, square3, eCFieldElement6, new ECFieldElement[]{eCFieldElement5}, this.withCompression);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public ECPoint twicePlus(ECPoint eCPoint) {
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return twice();
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement = this.f1270x;
            if (eCFieldElement.isZero()) {
                return eCPoint;
            }
            if (curve.getCoordinateSystem() != 6) {
                return twice().add(eCPoint);
            }
            ECFieldElement eCFieldElement2 = eCPoint.f1270x;
            ECFieldElement eCFieldElement3 = eCPoint.f1272zs[0];
            if (eCFieldElement2.isZero() || !eCFieldElement3.isOne()) {
                return twice().add(eCPoint);
            }
            ECFieldElement eCFieldElement4 = this.f1271y;
            ECFieldElement eCFieldElement5 = this.f1272zs[0];
            ECFieldElement eCFieldElement6 = eCPoint.f1271y;
            ECFieldElement square = eCFieldElement.square();
            ECFieldElement square2 = eCFieldElement4.square();
            ECFieldElement square3 = eCFieldElement5.square();
            ECFieldElement add = curve.getA().multiply(square3).add(square2).add(eCFieldElement4.multiply(eCFieldElement5));
            ECFieldElement addOne = eCFieldElement6.addOne();
            ECFieldElement multiplyPlusProduct = curve.getA().add(addOne).multiply(square3).add(square2).multiplyPlusProduct(add, square, square3);
            ECFieldElement multiply = eCFieldElement2.multiply(square3);
            ECFieldElement square4 = multiply.add(add).square();
            if (square4.isZero()) {
                if (multiplyPlusProduct.isZero()) {
                    return eCPoint.twice();
                }
                return curve.getInfinity();
            } else if (multiplyPlusProduct.isZero()) {
                return new F2m(curve, multiplyPlusProduct, curve.getB().sqrt(), this.withCompression);
            } else {
                ECFieldElement multiply2 = multiplyPlusProduct.square().multiply(multiply);
                ECFieldElement multiply3 = multiplyPlusProduct.multiply(square4).multiply(square3);
                return new F2m(curve, multiply2, multiplyPlusProduct.add(square4).square().multiplyPlusProduct(add, addOne, multiply3), new ECFieldElement[]{multiply3}, this.withCompression);
            }
        }

        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.f1270x;
            if (eCFieldElement.isZero()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem == 0) {
                return new F2m(this.curve, eCFieldElement, this.f1271y.add(eCFieldElement), this.withCompression);
            } else if (curveCoordinateSystem == 1) {
                ECFieldElement eCFieldElement2 = this.f1271y;
                ECFieldElement eCFieldElement3 = this.f1272zs[0];
                return new F2m(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement), new ECFieldElement[]{eCFieldElement3}, this.withCompression);
            } else if (curveCoordinateSystem == 5) {
                return new F2m(this.curve, eCFieldElement, this.f1271y.addOne(), this.withCompression);
            } else if (curveCoordinateSystem == 6) {
                ECFieldElement eCFieldElement4 = this.f1271y;
                ECFieldElement eCFieldElement5 = this.f1272zs[0];
                return new F2m(this.curve, eCFieldElement, eCFieldElement4.add(eCFieldElement5), new ECFieldElement[]{eCFieldElement5}, this.withCompression);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }
    }
}
