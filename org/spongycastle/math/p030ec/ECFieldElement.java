package org.spongycastle.math.p030ec;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

/* renamed from: org.spongycastle.math.ec.ECFieldElement */
public abstract class ECFieldElement implements ECConstants {
    public abstract ECFieldElement add(ECFieldElement eCFieldElement);

    public abstract ECFieldElement addOne();

    public abstract ECFieldElement divide(ECFieldElement eCFieldElement);

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public abstract BigInteger toBigInteger();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public boolean isOne() {
        return bitLength() == 1;
    }

    public boolean isZero() {
        return toBigInteger().signum() == 0;
    }

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).subtract(eCFieldElement2.multiply(eCFieldElement3));
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).add(eCFieldElement2.multiply(eCFieldElement3));
    }

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return square().subtract(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return square().add(eCFieldElement.multiply(eCFieldElement2));
    }

    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public String toString() {
        return toBigInteger().toString(16);
    }

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
    }

    /* renamed from: org.spongycastle.math.ec.ECFieldElement$Fp */
    public static class C3205Fp extends ECFieldElement {

        /* renamed from: q */
        BigInteger f1267q;

        /* renamed from: r */
        BigInteger f1268r;

        /* renamed from: x */
        BigInteger f1269x;

        public String getFieldName() {
            return "Fp";
        }

        static BigInteger calculateResidue(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            if (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) {
                return null;
            }
            return ONE.shiftLeft(bitLength).subtract(bigInteger);
        }

        public C3205Fp(BigInteger bigInteger, BigInteger bigInteger2) {
            this(bigInteger, calculateResidue(bigInteger), bigInteger2);
        }

        C3205Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.f1267q = bigInteger;
            this.f1268r = bigInteger2;
            this.f1269x = bigInteger3;
        }

        public BigInteger toBigInteger() {
            return this.f1269x;
        }

        public int getFieldSize() {
            return this.f1267q.bitLength();
        }

        public BigInteger getQ() {
            return this.f1267q;
        }

        public ECFieldElement add(ECFieldElement eCFieldElement) {
            return new C3205Fp(this.f1267q, this.f1268r, modAdd(this.f1269x, eCFieldElement.toBigInteger()));
        }

        public ECFieldElement addOne() {
            BigInteger add = this.f1269x.add(ECConstants.ONE);
            if (add.compareTo(this.f1267q) == 0) {
                add = ECConstants.ZERO;
            }
            return new C3205Fp(this.f1267q, this.f1268r, add);
        }

        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return new C3205Fp(this.f1267q, this.f1268r, modSubtract(this.f1269x, eCFieldElement.toBigInteger()));
        }

        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new C3205Fp(this.f1267q, this.f1268r, modMult(this.f1269x, eCFieldElement.toBigInteger()));
        }

        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.f1269x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new C3205Fp(this.f1267q, this.f1268r, modReduce(bigInteger.multiply(bigInteger2).subtract(bigInteger3.multiply(bigInteger4))));
        }

        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.f1269x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new C3205Fp(this.f1267q, this.f1268r, modReduce(bigInteger.multiply(bigInteger2).add(bigInteger3.multiply(bigInteger4))));
        }

        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return new C3205Fp(this.f1267q, this.f1268r, modMult(this.f1269x, modInverse(eCFieldElement.toBigInteger())));
        }

        public ECFieldElement negate() {
            if (this.f1269x.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.f1267q;
            return new C3205Fp(bigInteger, this.f1268r, bigInteger.subtract(this.f1269x));
        }

        public ECFieldElement square() {
            BigInteger bigInteger = this.f1267q;
            BigInteger bigInteger2 = this.f1268r;
            BigInteger bigInteger3 = this.f1269x;
            return new C3205Fp(bigInteger, bigInteger2, modMult(bigInteger3, bigInteger3));
        }

        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.f1269x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new C3205Fp(this.f1267q, this.f1268r, modReduce(bigInteger.multiply(bigInteger).subtract(bigInteger2.multiply(bigInteger3))));
        }

        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.f1269x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new C3205Fp(this.f1267q, this.f1268r, modReduce(bigInteger.multiply(bigInteger).add(bigInteger2.multiply(bigInteger3))));
        }

        public ECFieldElement invert() {
            return new C3205Fp(this.f1267q, this.f1268r, modInverse(this.f1269x));
        }

        public ECFieldElement sqrt() {
            if (isZero() || isOne()) {
                return this;
            }
            if (!this.f1267q.testBit(0)) {
                throw new RuntimeException("not done yet");
            } else if (this.f1267q.testBit(1)) {
                BigInteger add = this.f1267q.shiftRight(2).add(ECConstants.ONE);
                BigInteger bigInteger = this.f1267q;
                return checkSqrt(new C3205Fp(bigInteger, this.f1268r, this.f1269x.modPow(add, bigInteger)));
            } else if (this.f1267q.testBit(2)) {
                BigInteger modPow = this.f1269x.modPow(this.f1267q.shiftRight(3), this.f1267q);
                BigInteger modMult = modMult(modPow, this.f1269x);
                if (modMult(modMult, modPow).equals(ECConstants.ONE)) {
                    return checkSqrt(new C3205Fp(this.f1267q, this.f1268r, modMult));
                }
                return checkSqrt(new C3205Fp(this.f1267q, this.f1268r, modMult(modMult, ECConstants.TWO.modPow(this.f1267q.shiftRight(2), this.f1267q))));
            } else {
                BigInteger shiftRight = this.f1267q.shiftRight(1);
                if (!this.f1269x.modPow(shiftRight, this.f1267q).equals(ECConstants.ONE)) {
                    return null;
                }
                BigInteger bigInteger2 = this.f1269x;
                BigInteger modDouble = modDouble(modDouble(bigInteger2));
                BigInteger add2 = shiftRight.add(ECConstants.ONE);
                BigInteger subtract = this.f1267q.subtract(ECConstants.ONE);
                Random random = new Random();
                while (true) {
                    BigInteger bigInteger3 = new BigInteger(this.f1267q.bitLength(), random);
                    if (bigInteger3.compareTo(this.f1267q) < 0 && modReduce(bigInteger3.multiply(bigInteger3).subtract(modDouble)).modPow(shiftRight, this.f1267q).equals(subtract)) {
                        BigInteger[] lucasSequence = lucasSequence(bigInteger3, bigInteger2, add2);
                        BigInteger bigInteger4 = lucasSequence[0];
                        BigInteger bigInteger5 = lucasSequence[1];
                        if (modMult(bigInteger5, bigInteger5).equals(modDouble)) {
                            return new C3205Fp(this.f1267q, this.f1268r, modHalfAbs(bigInteger5));
                        }
                        if (!bigInteger4.equals(ECConstants.ONE) && !bigInteger4.equals(subtract)) {
                            return null;
                        }
                    }
                }
            }
        }

        private ECFieldElement checkSqrt(ECFieldElement eCFieldElement) {
            if (eCFieldElement.square().equals(this)) {
                return eCFieldElement;
            }
            return null;
        }

        private BigInteger[] lucasSequence(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int bitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigInteger4 = ECConstants.ONE;
            BigInteger bigInteger5 = ECConstants.TWO;
            BigInteger bigInteger6 = ECConstants.ONE;
            BigInteger bigInteger7 = ECConstants.ONE;
            BigInteger bigInteger8 = bigInteger;
            for (int i = bitLength - 1; i >= lowestSetBit + 1; i--) {
                bigInteger6 = modMult(bigInteger6, bigInteger7);
                if (bigInteger3.testBit(i)) {
                    bigInteger7 = modMult(bigInteger6, bigInteger2);
                    bigInteger4 = modMult(bigInteger4, bigInteger8);
                    bigInteger5 = modReduce(bigInteger8.multiply(bigInteger5).subtract(bigInteger.multiply(bigInteger6)));
                    bigInteger8 = modReduce(bigInteger8.multiply(bigInteger8).subtract(bigInteger7.shiftLeft(1)));
                } else {
                    bigInteger4 = modReduce(bigInteger4.multiply(bigInteger5).subtract(bigInteger6));
                    BigInteger modReduce = modReduce(bigInteger8.multiply(bigInteger5).subtract(bigInteger.multiply(bigInteger6)));
                    bigInteger5 = modReduce(bigInteger5.multiply(bigInteger5).subtract(bigInteger6.shiftLeft(1)));
                    bigInteger8 = modReduce;
                    bigInteger7 = bigInteger6;
                }
            }
            BigInteger modMult = modMult(bigInteger6, bigInteger7);
            BigInteger modMult2 = modMult(modMult, bigInteger2);
            BigInteger modReduce2 = modReduce(bigInteger4.multiply(bigInteger5).subtract(modMult));
            BigInteger modReduce3 = modReduce(bigInteger8.multiply(bigInteger5).subtract(bigInteger.multiply(modMult)));
            BigInteger modMult3 = modMult(modMult, modMult2);
            for (int i2 = 1; i2 <= lowestSetBit; i2++) {
                modReduce2 = modMult(modReduce2, modReduce3);
                modReduce3 = modReduce(modReduce3.multiply(modReduce3).subtract(modMult3.shiftLeft(1)));
                modMult3 = modMult(modMult3, modMult3);
            }
            return new BigInteger[]{modReduce2, modReduce3};
        }

        /* access modifiers changed from: protected */
        public BigInteger modAdd(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger add = bigInteger.add(bigInteger2);
            return add.compareTo(this.f1267q) >= 0 ? add.subtract(this.f1267q) : add;
        }

        /* access modifiers changed from: protected */
        public BigInteger modDouble(BigInteger bigInteger) {
            BigInteger shiftLeft = bigInteger.shiftLeft(1);
            return shiftLeft.compareTo(this.f1267q) >= 0 ? shiftLeft.subtract(this.f1267q) : shiftLeft;
        }

        /* access modifiers changed from: protected */
        public BigInteger modHalf(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f1267q.add(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        /* access modifiers changed from: protected */
        public BigInteger modHalfAbs(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f1267q.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        /* access modifiers changed from: protected */
        public BigInteger modInverse(BigInteger bigInteger) {
            int fieldSize = getFieldSize();
            int i = (fieldSize + 31) >> 5;
            int[] fromBigInteger = Nat.fromBigInteger(fieldSize, this.f1267q);
            int[] fromBigInteger2 = Nat.fromBigInteger(fieldSize, bigInteger);
            int[] create = Nat.create(i);
            Mod.invert(fromBigInteger, fromBigInteger2, create);
            return Nat.toBigInteger(i, create);
        }

        /* access modifiers changed from: protected */
        public BigInteger modMult(BigInteger bigInteger, BigInteger bigInteger2) {
            return modReduce(bigInteger.multiply(bigInteger2));
        }

        /* access modifiers changed from: protected */
        public BigInteger modReduce(BigInteger bigInteger) {
            if (this.f1268r == null) {
                return bigInteger.mod(this.f1267q);
            }
            boolean z = bigInteger.signum() < 0;
            if (z) {
                bigInteger = bigInteger.abs();
            }
            int bitLength = this.f1267q.bitLength();
            boolean equals = this.f1268r.equals(ECConstants.ONE);
            while (bigInteger.bitLength() > bitLength + 1) {
                BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                if (!equals) {
                    shiftRight = shiftRight.multiply(this.f1268r);
                }
                bigInteger = shiftRight.add(subtract);
            }
            while (bigInteger.compareTo(this.f1267q) >= 0) {
                bigInteger = bigInteger.subtract(this.f1267q);
            }
            if (!z || bigInteger.signum() == 0) {
                return bigInteger;
            }
            return this.f1267q.subtract(bigInteger);
        }

        /* access modifiers changed from: protected */
        public BigInteger modSubtract(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger subtract = bigInteger.subtract(bigInteger2);
            return subtract.signum() < 0 ? subtract.add(this.f1267q) : subtract;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3205Fp)) {
                return false;
            }
            C3205Fp fp = (C3205Fp) obj;
            if (!this.f1267q.equals(fp.f1267q) || !this.f1269x.equals(fp.f1269x)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f1267q.hashCode() ^ this.f1269x.hashCode();
        }
    }

    /* renamed from: org.spongycastle.math.ec.ECFieldElement$F2m */
    public static class F2m extends ECFieldElement {
        public static final int GNB = 1;
        public static final int PPB = 3;
        public static final int TPB = 2;

        /* renamed from: ks */
        private int[] f1264ks;

        /* renamed from: m */
        private int f1265m;
        private int representation;

        /* renamed from: x */
        private LongArray f1266x;

        public String getFieldName() {
            return "F2m";
        }

        public ECFieldElement negate() {
            return this;
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            if (i3 == 0 && i4 == 0) {
                this.representation = 2;
                this.f1264ks = new int[]{i2};
            } else if (i3 >= i4) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else if (i3 > 0) {
                this.representation = 3;
                this.f1264ks = new int[]{i2, i3, i4};
            } else {
                throw new IllegalArgumentException("k2 must be larger than 0");
            }
            this.f1265m = i;
            this.f1266x = new LongArray(bigInteger);
        }

        public F2m(int i, int i2, BigInteger bigInteger) {
            this(i, i2, 0, 0, bigInteger);
        }

        private F2m(int i, int[] iArr, LongArray longArray) {
            this.f1265m = i;
            this.representation = iArr.length == 1 ? 2 : 3;
            this.f1264ks = iArr;
            this.f1266x = longArray;
        }

        public int bitLength() {
            return this.f1266x.degree();
        }

        public boolean isOne() {
            return this.f1266x.isOne();
        }

        public boolean isZero() {
            return this.f1266x.isZero();
        }

        public boolean testBitZero() {
            return this.f1266x.testBitZero();
        }

        public BigInteger toBigInteger() {
            return this.f1266x.toBigInteger();
        }

        public int getFieldSize() {
            return this.f1265m;
        }

        public static void checkFieldElements(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            if (!(eCFieldElement instanceof F2m) || !(eCFieldElement2 instanceof F2m)) {
                throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
            }
            F2m f2m = (F2m) eCFieldElement;
            F2m f2m2 = (F2m) eCFieldElement2;
            if (f2m.representation != f2m2.representation) {
                throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
            } else if (f2m.f1265m != f2m2.f1265m || !Arrays.areEqual(f2m.f1264ks, f2m2.f1264ks)) {
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            }
        }

        public ECFieldElement add(ECFieldElement eCFieldElement) {
            LongArray longArray = (LongArray) this.f1266x.clone();
            longArray.addShiftedByWords(((F2m) eCFieldElement).f1266x, 0);
            return new F2m(this.f1265m, this.f1264ks, longArray);
        }

        public ECFieldElement addOne() {
            return new F2m(this.f1265m, this.f1264ks, this.f1266x.addOne());
        }

        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return add(eCFieldElement);
        }

        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            int i = this.f1265m;
            int[] iArr = this.f1264ks;
            return new F2m(i, iArr, this.f1266x.modMultiply(((F2m) eCFieldElement).f1266x, i, iArr));
        }

        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: org.spongycastle.math.ec.LongArray} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.spongycastle.math.p030ec.ECFieldElement multiplyPlusProduct(org.spongycastle.math.p030ec.ECFieldElement r5, org.spongycastle.math.p030ec.ECFieldElement r6, org.spongycastle.math.p030ec.ECFieldElement r7) {
            /*
                r4 = this;
                org.spongycastle.math.ec.LongArray r0 = r4.f1266x
                org.spongycastle.math.ec.ECFieldElement$F2m r5 = (org.spongycastle.math.p030ec.ECFieldElement.F2m) r5
                org.spongycastle.math.ec.LongArray r5 = r5.f1266x
                org.spongycastle.math.ec.ECFieldElement$F2m r6 = (org.spongycastle.math.p030ec.ECFieldElement.F2m) r6
                org.spongycastle.math.ec.LongArray r6 = r6.f1266x
                org.spongycastle.math.ec.ECFieldElement$F2m r7 = (org.spongycastle.math.p030ec.ECFieldElement.F2m) r7
                org.spongycastle.math.ec.LongArray r7 = r7.f1266x
                int r1 = r4.f1265m
                int[] r2 = r4.f1264ks
                org.spongycastle.math.ec.LongArray r1 = r0.multiply(r5, r1, r2)
                int r2 = r4.f1265m
                int[] r3 = r4.f1264ks
                org.spongycastle.math.ec.LongArray r6 = r6.multiply(r7, r2, r3)
                if (r1 == r0) goto L_0x0022
                if (r1 != r5) goto L_0x0029
            L_0x0022:
                java.lang.Object r5 = r1.clone()
                r1 = r5
                org.spongycastle.math.ec.LongArray r1 = (org.spongycastle.math.p030ec.LongArray) r1
            L_0x0029:
                r5 = 0
                r1.addShiftedByWords(r6, r5)
                int r5 = r4.f1265m
                int[] r6 = r4.f1264ks
                r1.reduce(r5, r6)
                org.spongycastle.math.ec.ECFieldElement$F2m r5 = new org.spongycastle.math.ec.ECFieldElement$F2m
                int r6 = r4.f1265m
                int[] r7 = r4.f1264ks
                r5.<init>((int) r6, (int[]) r7, (org.spongycastle.math.p030ec.LongArray) r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.p030ec.ECFieldElement.F2m.multiplyPlusProduct(org.spongycastle.math.ec.ECFieldElement, org.spongycastle.math.ec.ECFieldElement, org.spongycastle.math.ec.ECFieldElement):org.spongycastle.math.ec.ECFieldElement");
        }

        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return multiply(eCFieldElement.invert());
        }

        public ECFieldElement square() {
            int i = this.f1265m;
            int[] iArr = this.f1264ks;
            return new F2m(i, iArr, this.f1266x.modSquare(i, iArr));
        }

        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return squarePlusProduct(eCFieldElement, eCFieldElement2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: org.spongycastle.math.ec.LongArray} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.spongycastle.math.p030ec.ECFieldElement squarePlusProduct(org.spongycastle.math.p030ec.ECFieldElement r5, org.spongycastle.math.p030ec.ECFieldElement r6) {
            /*
                r4 = this;
                org.spongycastle.math.ec.LongArray r0 = r4.f1266x
                org.spongycastle.math.ec.ECFieldElement$F2m r5 = (org.spongycastle.math.p030ec.ECFieldElement.F2m) r5
                org.spongycastle.math.ec.LongArray r5 = r5.f1266x
                org.spongycastle.math.ec.ECFieldElement$F2m r6 = (org.spongycastle.math.p030ec.ECFieldElement.F2m) r6
                org.spongycastle.math.ec.LongArray r6 = r6.f1266x
                int r1 = r4.f1265m
                int[] r2 = r4.f1264ks
                org.spongycastle.math.ec.LongArray r1 = r0.square(r1, r2)
                int r2 = r4.f1265m
                int[] r3 = r4.f1264ks
                org.spongycastle.math.ec.LongArray r5 = r5.multiply(r6, r2, r3)
                if (r1 != r0) goto L_0x0023
                java.lang.Object r6 = r1.clone()
                r1 = r6
                org.spongycastle.math.ec.LongArray r1 = (org.spongycastle.math.p030ec.LongArray) r1
            L_0x0023:
                r6 = 0
                r1.addShiftedByWords(r5, r6)
                int r5 = r4.f1265m
                int[] r6 = r4.f1264ks
                r1.reduce(r5, r6)
                org.spongycastle.math.ec.ECFieldElement$F2m r5 = new org.spongycastle.math.ec.ECFieldElement$F2m
                int r6 = r4.f1265m
                int[] r0 = r4.f1264ks
                r5.<init>((int) r6, (int[]) r0, (org.spongycastle.math.p030ec.LongArray) r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.p030ec.ECFieldElement.F2m.squarePlusProduct(org.spongycastle.math.ec.ECFieldElement, org.spongycastle.math.ec.ECFieldElement):org.spongycastle.math.ec.ECFieldElement");
        }

        public ECFieldElement invert() {
            int i = this.f1265m;
            int[] iArr = this.f1264ks;
            return new F2m(i, iArr, this.f1266x.modInverse(i, iArr));
        }

        public ECFieldElement sqrt() {
            LongArray longArray = this.f1266x;
            if (longArray.isOne() || longArray.isZero()) {
                return this;
            }
            int i = this.f1265m;
            return new F2m(this.f1265m, this.f1264ks, longArray.modSquareN(i - 1, i, this.f1264ks));
        }

        public int getRepresentation() {
            return this.representation;
        }

        public int getM() {
            return this.f1265m;
        }

        public int getK1() {
            return this.f1264ks[0];
        }

        public int getK2() {
            int[] iArr = this.f1264ks;
            if (iArr.length >= 2) {
                return iArr[1];
            }
            return 0;
        }

        public int getK3() {
            int[] iArr = this.f1264ks;
            if (iArr.length >= 3) {
                return iArr[2];
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            if (this.f1265m != f2m.f1265m || this.representation != f2m.representation || !Arrays.areEqual(this.f1264ks, f2m.f1264ks) || !this.f1266x.equals(f2m.f1266x)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f1266x.hashCode() ^ this.f1265m) ^ Arrays.hashCode(this.f1264ks);
        }
    }
}
