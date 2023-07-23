package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

public abstract class Nat192 {

    /* renamed from: M */
    private static final long f1329M = 4294967295L;

    public static int[] create() {
        return new int[6];
    }

    public static int[] createExt() {
        return new int[12];
    }

    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & f1329M) + (((long) iArr2[0]) & f1329M) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & f1329M) + (((long) iArr2[1]) & f1329M);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & f1329M) + (((long) iArr2[2]) & f1329M);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & f1329M) + (((long) iArr2[3]) & f1329M);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & f1329M) + (((long) iArr2[4]) & f1329M);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & f1329M) + (((long) iArr2[5]) & f1329M);
        iArr3[5] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & f1329M) + (((long) iArr2[0]) & f1329M) + (((long) iArr3[0]) & f1329M) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & f1329M) + (((long) iArr2[1]) & f1329M) + (((long) iArr3[1]) & f1329M);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & f1329M) + (((long) iArr2[2]) & f1329M) + (((long) iArr3[2]) & f1329M);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & f1329M) + (((long) iArr2[3]) & f1329M) + (((long) iArr3[3]) & f1329M);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & f1329M) + (((long) iArr2[4]) & f1329M) + (((long) iArr3[4]) & f1329M);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & f1329M) + (((long) iArr2[5]) & f1329M) + (((long) iArr3[5]) & f1329M);
        iArr3[5] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[0]) & f1329M) + (((long) iArr2[0]) & f1329M) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & f1329M) + (((long) iArr2[1]) & f1329M);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & f1329M) + (((long) iArr2[2]) & f1329M);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & f1329M) + (((long) iArr2[3]) & f1329M);
        iArr2[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & f1329M) + (((long) iArr2[4]) & f1329M);
        iArr2[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & f1329M) + (f1329M & ((long) iArr2[5]));
        iArr2[5] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static int addTo(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = i2 + 0;
        long j = (((long) i3) & f1329M) + (((long) iArr[i + 0]) & f1329M) + (((long) iArr2[i4]) & f1329M);
        iArr2[i4] = (int) j;
        int i5 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & f1329M) + (((long) iArr2[i5]) & f1329M);
        iArr2[i5] = (int) j2;
        int i6 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & f1329M) + (((long) iArr2[i6]) & f1329M);
        iArr2[i6] = (int) j3;
        int i7 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & f1329M) + (((long) iArr2[i7]) & f1329M);
        iArr2[i7] = (int) j4;
        int i8 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & f1329M) + (((long) iArr2[i8]) & f1329M);
        iArr2[i8] = (int) j5;
        int i9 = i2 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & f1329M) + (f1329M & ((long) iArr2[i9]));
        iArr2[i9] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i + 0;
        int i4 = i2 + 0;
        long j = (((long) iArr[i3]) & f1329M) + (((long) iArr2[i4]) & f1329M) + 0;
        int i5 = (int) j;
        iArr[i3] = i5;
        iArr2[i4] = i5;
        int i6 = i + 1;
        int i7 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i6]) & f1329M) + (((long) iArr2[i7]) & f1329M);
        int i8 = (int) j2;
        iArr[i6] = i8;
        iArr2[i7] = i8;
        int i9 = i + 2;
        int i10 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i9]) & f1329M) + (((long) iArr2[i10]) & f1329M);
        int i11 = (int) j3;
        iArr[i9] = i11;
        iArr2[i10] = i11;
        int i12 = i + 3;
        int i13 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i12]) & f1329M) + (((long) iArr2[i13]) & f1329M);
        int i14 = (int) j4;
        iArr[i12] = i14;
        iArr2[i13] = i14;
        int i15 = i + 4;
        int i16 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i15]) & f1329M) + (((long) iArr2[i16]) & f1329M);
        int i17 = (int) j5;
        iArr[i15] = i17;
        iArr2[i16] = i17;
        int i18 = i + 5;
        int i19 = i2 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i18]) & f1329M) + (f1329M & ((long) iArr2[i19]));
        int i20 = (int) j6;
        iArr[i18] = i20;
        iArr2[i19] = i20;
        return (int) (j6 >>> 32);
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
    }

    public static boolean diff(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        boolean gte = gte(iArr, i, iArr2, i2);
        if (gte) {
            sub(iArr, i, iArr2, i2, iArr3, i3);
        } else {
            sub(iArr2, i2, iArr, i, iArr3, i3);
        }
        return gte;
    }

    /* renamed from: eq */
    public static boolean m612eq(int[] iArr, int[] iArr2) {
        for (int i = 5; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        int[] create = create();
        int i = 0;
        while (bigInteger.signum() != 0) {
            create[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i++;
        }
        return create;
    }

    public static int getBit(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 6) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i = 5; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    public static boolean gte(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 5; i3 >= 0; i3--) {
            int i4 = iArr[i + i3] ^ Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE ^ iArr2[i2 + i3];
            if (i4 < i5) {
                return false;
            }
            if (i4 > i5) {
                return true;
            }
        }
        return true;
    }

    public static boolean isOne(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 6; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i = 0; i < 6; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & f1329M;
        long j2 = ((long) iArr2[1]) & f1329M;
        long j3 = ((long) iArr2[2]) & f1329M;
        long j4 = ((long) iArr2[3]) & f1329M;
        long j5 = ((long) iArr2[4]) & f1329M;
        long j6 = j3;
        long j7 = ((long) iArr2[5]) & f1329M;
        long j8 = ((long) iArr[0]) & f1329M;
        long j9 = (j8 * j) + 0;
        iArr3[0] = (int) j9;
        long j10 = (j9 >>> 32) + (j8 * j2);
        iArr3[1] = (int) j10;
        long j11 = (j10 >>> 32) + (j8 * j6);
        iArr3[2] = (int) j11;
        long j12 = (j11 >>> 32) + (j8 * j4);
        iArr3[3] = (int) j12;
        long j13 = (j12 >>> 32) + (j8 * j5);
        iArr3[4] = (int) j13;
        long j14 = (j13 >>> 32) + (j8 * j7);
        iArr3[5] = (int) j14;
        int i = (int) (j14 >>> 32);
        iArr3[6] = i;
        int i2 = 1;
        for (int i3 = 6; i2 < i3; i3 = 6) {
            long j15 = ((long) iArr[i2]) & f1329M;
            int i4 = i2 + 0;
            long j16 = (j15 * j) + (((long) iArr3[i4]) & f1329M) + 0;
            iArr3[i4] = (int) j16;
            int i5 = i2 + 1;
            long j17 = j2;
            long j18 = (j16 >>> 32) + (j15 * j2) + (((long) iArr3[i5]) & f1329M);
            iArr3[i5] = (int) j18;
            int i6 = i2 + 2;
            long j19 = j7;
            long j20 = (j18 >>> 32) + (j15 * j6) + (((long) iArr3[i6]) & f1329M);
            iArr3[i6] = (int) j20;
            int i7 = i2 + 3;
            long j21 = (j20 >>> 32) + (j15 * j4) + (((long) iArr3[i7]) & f1329M);
            iArr3[i7] = (int) j21;
            int i8 = i2 + 4;
            long j22 = (j21 >>> 32) + (j15 * j5) + (((long) iArr3[i8]) & f1329M);
            iArr3[i8] = (int) j22;
            int i9 = i2 + 5;
            long j23 = (j22 >>> 32) + (j15 * j19) + (((long) iArr3[i9]) & f1329M);
            iArr3[i9] = (int) j23;
            iArr3[i2 + 6] = (int) (j23 >>> 32);
            i2 = i5;
            j = j;
            j2 = j17;
            j7 = j19;
        }
    }

    public static void mul(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2 + 0]) & f1329M;
        long j2 = ((long) iArr2[i2 + 1]) & f1329M;
        long j3 = ((long) iArr2[i2 + 2]) & f1329M;
        long j4 = ((long) iArr2[i2 + 3]) & f1329M;
        long j5 = ((long) iArr2[i2 + 4]) & f1329M;
        long j6 = ((long) iArr2[i2 + 5]) & f1329M;
        long j7 = ((long) iArr[i + 0]) & f1329M;
        long j8 = (j7 * j) + 0;
        long j9 = j;
        iArr3[i3 + 0] = (int) j8;
        long j10 = (j8 >>> 32) + (j7 * j2);
        long j11 = j2;
        iArr3[i3 + 1] = (int) j10;
        long j12 = (j10 >>> 32) + (j7 * j3);
        iArr3[i3 + 2] = (int) j12;
        long j13 = (j12 >>> 32) + (j7 * j4);
        iArr3[i3 + 3] = (int) j13;
        long j14 = (j13 >>> 32) + (j7 * j5);
        iArr3[i3 + 4] = (int) j14;
        long j15 = (j14 >>> 32) + (j7 * j6);
        iArr3[i3 + 5] = (int) j15;
        iArr3[i3 + 6] = (int) (j15 >>> 32);
        int i4 = 1;
        int i5 = i3;
        int i6 = 1;
        while (i6 < 6) {
            i5 += i4;
            long j16 = ((long) iArr[i + i6]) & f1329M;
            int i7 = i5 + 0;
            long j17 = (j16 * j9) + (((long) iArr3[i7]) & f1329M) + 0;
            iArr3[i7] = (int) j17;
            int i8 = i5 + 1;
            long j18 = j6;
            long j19 = (j17 >>> 32) + (j16 * j11) + (((long) iArr3[i8]) & f1329M);
            iArr3[i8] = (int) j19;
            int i9 = i5 + 2;
            long j20 = (j19 >>> 32) + (j16 * j3) + (((long) iArr3[i9]) & f1329M);
            iArr3[i9] = (int) j20;
            int i10 = i5 + 3;
            long j21 = (j20 >>> 32) + (j16 * j4) + (((long) iArr3[i10]) & f1329M);
            iArr3[i10] = (int) j21;
            int i11 = i5 + 4;
            long j22 = (j21 >>> 32) + (j16 * j5) + (((long) iArr3[i11]) & f1329M);
            iArr3[i11] = (int) j22;
            int i12 = i5 + 5;
            long j23 = (j22 >>> 32) + (j16 * j18) + (((long) iArr3[i12]) & f1329M);
            iArr3[i12] = (int) j23;
            iArr3[i5 + 6] = (int) (j23 >>> 32);
            i6++;
            j3 = j3;
            j6 = j18;
            i4 = 1;
        }
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = f1329M;
        long j2 = ((long) iArr2[0]) & f1329M;
        long j3 = ((long) iArr2[1]) & f1329M;
        long j4 = ((long) iArr2[2]) & f1329M;
        long j5 = ((long) iArr2[3]) & f1329M;
        long j6 = ((long) iArr2[4]) & f1329M;
        long j7 = ((long) iArr2[5]) & f1329M;
        long j8 = 0;
        while (i < 6) {
            long j9 = j7;
            long j10 = ((long) iArr[i]) & j;
            int i2 = i + 0;
            long j11 = j2;
            long j12 = (j10 * j2) + (((long) iArr3[i2]) & j) + 0;
            iArr3[i2] = (int) j12;
            int i3 = i + 1;
            long j13 = (j12 >>> 32) + (j10 * j3) + (((long) iArr3[i3]) & f1329M);
            iArr3[i3] = (int) j13;
            int i4 = i + 2;
            long j14 = (j13 >>> 32) + (j10 * j4) + (((long) iArr3[i4]) & f1329M);
            iArr3[i4] = (int) j14;
            int i5 = i + 3;
            long j15 = (j14 >>> 32) + (j10 * j5) + (((long) iArr3[i5]) & f1329M);
            iArr3[i5] = (int) j15;
            int i6 = i + 4;
            long j16 = (j15 >>> 32) + (j10 * j6) + (((long) iArr3[i6]) & f1329M);
            iArr3[i6] = (int) j16;
            int i7 = i + 5;
            long j17 = (j16 >>> 32) + (j10 * j9) + (((long) iArr3[i7]) & f1329M);
            iArr3[i7] = (int) j17;
            int i8 = i + 6;
            long j18 = (j17 >>> 32) + j8 + (((long) iArr3[i8]) & f1329M);
            iArr3[i8] = (int) j18;
            j8 = j18 >>> 32;
            i = i3;
            j = 4294967295L;
            j7 = j9;
            j2 = j11;
            j3 = j3;
            j4 = j4;
        }
        return (int) j8;
    }

    public static int mulAddTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = f1329M;
        long j2 = ((long) iArr2[i2 + 0]) & f1329M;
        long j3 = ((long) iArr2[i2 + 1]) & f1329M;
        long j4 = ((long) iArr2[i2 + 2]) & f1329M;
        long j5 = ((long) iArr2[i2 + 3]) & f1329M;
        long j6 = ((long) iArr2[i2 + 4]) & f1329M;
        long j7 = ((long) iArr2[i2 + 5]) & f1329M;
        int i4 = i3;
        int i5 = 0;
        long j8 = 0;
        while (i5 < 6) {
            int i6 = i5;
            long j9 = ((long) iArr[i + i5]) & j;
            int i7 = i4 + 0;
            long j10 = (j9 * j2) + (((long) iArr3[i7]) & j) + 0;
            iArr3[i7] = (int) j10;
            int i8 = i4 + 1;
            long j11 = j3;
            long j12 = (j10 >>> 32) + (j9 * j3) + (((long) iArr3[i8]) & f1329M);
            iArr3[i8] = (int) j12;
            int i9 = i4 + 2;
            long j13 = j4;
            long j14 = (j12 >>> 32) + (j9 * j4) + (((long) iArr3[i9]) & f1329M);
            iArr3[i9] = (int) j14;
            int i10 = i4 + 3;
            long j15 = (j14 >>> 32) + (j9 * j5) + (((long) iArr3[i10]) & f1329M);
            iArr3[i10] = (int) j15;
            int i11 = i4 + 4;
            long j16 = (j15 >>> 32) + (j9 * j6) + (((long) iArr3[i11]) & f1329M);
            iArr3[i11] = (int) j16;
            int i12 = i4 + 5;
            long j17 = (j16 >>> 32) + (j9 * j7) + (((long) iArr3[i12]) & f1329M);
            iArr3[i12] = (int) j17;
            int i13 = i4 + 6;
            long j18 = (j17 >>> 32) + j8 + (((long) iArr3[i13]) & f1329M);
            iArr3[i13] = (int) j18;
            j8 = j18 >>> 32;
            i5 = i6 + 1;
            i4 = i8;
            j2 = j2;
            j = 4294967295L;
            j3 = j11;
            j4 = j13;
        }
        return (int) j8;
    }

    public static long mul33Add(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = ((long) i) & f1329M;
        long j2 = ((long) iArr[i2 + 0]) & f1329M;
        long j3 = (j * j2) + (((long) iArr2[i3 + 0]) & f1329M) + 0;
        iArr3[i4 + 0] = (int) j3;
        long j4 = ((long) iArr[i2 + 1]) & f1329M;
        long j5 = (j3 >>> 32) + (j * j4) + j2 + (((long) iArr2[i3 + 1]) & f1329M);
        iArr3[i4 + 1] = (int) j5;
        long j6 = j5 >>> 32;
        long j7 = ((long) iArr[i2 + 2]) & f1329M;
        long j8 = j6 + (j * j7) + j4 + (((long) iArr2[i3 + 2]) & f1329M);
        iArr3[i4 + 2] = (int) j8;
        long j9 = ((long) iArr[i2 + 3]) & f1329M;
        long j10 = (j8 >>> 32) + (j * j9) + j7 + (((long) iArr2[i3 + 3]) & f1329M);
        iArr3[i4 + 3] = (int) j10;
        long j11 = ((long) iArr[i2 + 4]) & f1329M;
        long j12 = (j10 >>> 32) + (j * j11) + j9 + (((long) iArr2[i3 + 4]) & f1329M);
        iArr3[i4 + 4] = (int) j12;
        long j13 = ((long) iArr[i2 + 5]) & f1329M;
        long j14 = (j12 >>> 32) + (j * j13) + j11 + (f1329M & ((long) iArr2[i3 + 5]));
        iArr3[i4 + 5] = (int) j14;
        return (j14 >>> 32) + j13;
    }

    public static int mulWordAddExt(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = ((long) i) & f1329M;
        int i4 = i3 + 0;
        long j2 = ((((long) iArr[i2 + 0]) & f1329M) * j) + (((long) iArr2[i4]) & f1329M) + 0;
        iArr2[i4] = (int) j2;
        int i5 = i3 + 1;
        long j3 = (j2 >>> 32) + ((((long) iArr[i2 + 1]) & f1329M) * j) + (((long) iArr2[i5]) & f1329M);
        iArr2[i5] = (int) j3;
        int i6 = i3 + 2;
        long j4 = (j3 >>> 32) + ((((long) iArr[i2 + 2]) & f1329M) * j) + (((long) iArr2[i6]) & f1329M);
        iArr2[i6] = (int) j4;
        int i7 = i3 + 3;
        long j5 = (j4 >>> 32) + ((((long) iArr[i2 + 3]) & f1329M) * j) + (((long) iArr2[i7]) & f1329M);
        iArr2[i7] = (int) j5;
        int i8 = i3 + 4;
        long j6 = (j5 >>> 32) + ((((long) iArr[i2 + 4]) & f1329M) * j) + (((long) iArr2[i8]) & f1329M);
        iArr2[i8] = (int) j6;
        int i9 = i3 + 5;
        long j7 = (j6 >>> 32) + (j * (((long) iArr[i2 + 5]) & f1329M)) + (((long) iArr2[i9]) & f1329M);
        iArr2[i9] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int mul33DWordAdd(int i, long j, int[] iArr, int i2) {
        int[] iArr2 = iArr;
        int i3 = i2;
        long j2 = ((long) i) & f1329M;
        long j3 = j & f1329M;
        int i4 = i3 + 0;
        long j4 = (j2 * j3) + (((long) iArr2[i4]) & f1329M) + 0;
        iArr2[i4] = (int) j4;
        long j5 = j >>> 32;
        long j6 = (j2 * j5) + j3;
        int i5 = i3 + 1;
        long j7 = (j4 >>> 32) + j6 + (((long) iArr2[i5]) & f1329M);
        iArr2[i5] = (int) j7;
        int i6 = i3 + 2;
        long j8 = (j7 >>> 32) + j5 + (((long) iArr2[i6]) & f1329M);
        iArr2[i6] = (int) j8;
        int i7 = i3 + 3;
        long j9 = (j8 >>> 32) + (f1329M & ((long) iArr2[i7]));
        iArr2[i7] = (int) j9;
        if ((j9 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(6, iArr2, i3, 4);
    }

    public static int mul33WordAdd(int i, int i2, int[] iArr, int i3) {
        long j = ((long) i) & f1329M;
        long j2 = ((long) i2) & f1329M;
        int i4 = i3 + 0;
        long j3 = (j * j2) + (((long) iArr[i4]) & f1329M) + 0;
        iArr[i4] = (int) j3;
        int i5 = i3 + 1;
        long j4 = (j3 >>> 32) + j2 + (((long) iArr[i5]) & f1329M);
        iArr[i5] = (int) j4;
        long j5 = j4 >>> 32;
        int i6 = i3 + 2;
        long j6 = j5 + (((long) iArr[i6]) & f1329M);
        iArr[i6] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(6, iArr, i3, 3);
    }

    public static int mulWordDwordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = ((long) i) & f1329M;
        int i3 = i2 + 0;
        long j3 = ((j & f1329M) * j2) + (((long) iArr[i3]) & f1329M) + 0;
        iArr[i3] = (int) j3;
        long j4 = j2 * (j >>> 32);
        int i4 = i2 + 1;
        long j5 = (j3 >>> 32) + j4 + (((long) iArr[i4]) & f1329M);
        iArr[i4] = (int) j5;
        int i5 = i2 + 2;
        long j6 = (j5 >>> 32) + (((long) iArr[i5]) & f1329M);
        iArr[i5] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(6, iArr, i2, 3);
    }

    public static int mulWord(int i, int[] iArr, int[] iArr2, int i2) {
        long j = ((long) i) & f1329M;
        long j2 = 0;
        int i3 = 0;
        do {
            long j3 = j2 + ((((long) iArr[i3]) & f1329M) * j);
            iArr2[i2 + i3] = (int) j3;
            j2 = j3 >>> 32;
            i3++;
        } while (i3 < 6);
        return (int) j2;
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & f1329M;
        int i = 12;
        int i2 = 5;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            long j2 = ((long) iArr[i2]) & f1329M;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i3 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i6 << 31)) & f1329M) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & f1329M;
                long j7 = ((long) iArr2[2]) & f1329M;
                long j8 = j5 + (j6 * j);
                int i7 = (int) j8;
                iArr2[1] = (i7 << 1) | (((int) (j4 >>> 32)) & 1);
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[2]) & f1329M;
                long j11 = ((long) iArr2[3]) & f1329M;
                long j12 = j6;
                long j13 = ((long) iArr2[4]) & f1329M;
                long j14 = j9 + (j10 * j);
                int i8 = (int) j14;
                iArr2[2] = (i8 << 1) | (i7 >>> 31);
                long j15 = j11 + (j14 >>> 32) + (j10 * j12);
                long j16 = j13 + (j15 >>> 32);
                long j17 = j15 & f1329M;
                long j18 = ((long) iArr[3]) & f1329M;
                long j19 = j;
                long j20 = ((long) iArr2[5]) & f1329M;
                long j21 = ((long) iArr2[6]) & f1329M;
                long j22 = j17 + (j18 * j19);
                int i9 = (int) j22;
                iArr2[3] = (i9 << 1) | (i8 >>> 31);
                long j23 = j16 + (j22 >>> 32) + (j18 * j12);
                long j24 = j20 + (j23 >>> 32) + (j18 * j10);
                long j25 = j23 & f1329M;
                long j26 = j24 & f1329M;
                long j27 = ((long) iArr[4]) & f1329M;
                long j28 = j18;
                long j29 = ((long) iArr2[7]) & f1329M;
                long j30 = ((long) iArr2[8]) & f1329M;
                long j31 = j25 + (j27 * j19);
                int i10 = (int) j31;
                iArr2[4] = (i10 << 1) | (i9 >>> 31);
                int i11 = i10 >>> 31;
                long j32 = j26 + (j31 >>> 32) + (j27 * j12);
                long j33 = j21 + (j24 >>> 32) + (j32 >>> 32) + (j27 * j10);
                long j34 = j32 & f1329M;
                long j35 = j29 + (j33 >>> 32) + (j27 * j28);
                long j36 = j33 & f1329M;
                long j37 = j30 + (j35 >>> 32);
                long j38 = j35 & f1329M;
                long j39 = j27;
                long j40 = ((long) iArr[5]) & f1329M;
                long j41 = f1329M & ((long) iArr2[10]);
                long j42 = j34 + (j40 * j19);
                int i12 = (int) j42;
                iArr2[5] = (i12 << 1) | i11;
                long j43 = j36 + (j42 >>> 32) + (j40 * j12);
                long j44 = j38 + (j43 >>> 32) + (j10 * j40);
                long j45 = j37 + (j44 >>> 32) + (j40 * j28);
                long j46 = (((long) iArr2[9]) & f1329M) + (j45 >>> 32) + (j40 * j39);
                long j47 = j41 + (j46 >>> 32);
                int i13 = (int) j43;
                iArr2[6] = (i13 << 1) | (i12 >>> 31);
                int i14 = i13 >>> 31;
                int i15 = (int) j44;
                iArr2[7] = i14 | (i15 << 1);
                int i16 = i15 >>> 31;
                int i17 = (int) j45;
                iArr2[8] = i16 | (i17 << 1);
                int i18 = i17 >>> 31;
                int i19 = (int) j46;
                iArr2[9] = i18 | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) j47;
                iArr2[10] = i20 | (i21 << 1);
                iArr2[11] = (i21 >>> 31) | ((iArr2[11] + ((int) (j47 >> 32))) << 1);
                return;
            }
            i2 = i4;
            i3 = i6;
        }
    }

    public static void square(int[] iArr, int i, int[] iArr2, int i2) {
        long j = ((long) iArr[i + 0]) & f1329M;
        int i3 = 0;
        int i4 = 12;
        int i5 = 5;
        while (true) {
            int i6 = i5 - 1;
            long j2 = ((long) iArr[i + i5]) & f1329M;
            long j3 = j2 * j2;
            int i7 = i4 - 1;
            iArr2[i2 + i7] = (i3 << 31) | ((int) (j3 >>> 33));
            i4 = i7 - 1;
            iArr2[i2 + i4] = (int) (j3 >>> 1);
            i3 = (int) j3;
            if (i6 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i3 << 31)) & f1329M) | (j4 >>> 33);
                iArr2[i2 + 0] = (int) j4;
                long j6 = ((long) iArr[i + 1]) & f1329M;
                int i8 = i2 + 2;
                long j7 = ((long) iArr2[i8]) & f1329M;
                long j8 = j5 + (j6 * j);
                int i9 = (int) j8;
                iArr2[i2 + 1] = (i9 << 1) | (((int) (j4 >>> 32)) & 1);
                int i10 = i9 >>> 31;
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[i + 2]) & f1329M;
                int i11 = i2 + 3;
                long j11 = j6;
                int i12 = i2 + 4;
                long j12 = ((long) iArr2[i11]) & f1329M;
                long j13 = ((long) iArr2[i12]) & f1329M;
                long j14 = j9 + (j10 * j);
                int i13 = (int) j14;
                iArr2[i8] = (i13 << 1) | i10;
                int i14 = i13 >>> 31;
                long j15 = j12 + (j14 >>> 32) + (j10 * j11);
                long j16 = j13 + (j15 >>> 32);
                long j17 = j15 & f1329M;
                long j18 = j10;
                long j19 = ((long) iArr[i + 3]) & f1329M;
                int i15 = i2 + 5;
                long j20 = ((long) iArr2[i15]) & f1329M;
                int i16 = i2 + 6;
                int i17 = i15;
                long j21 = ((long) iArr2[i16]) & f1329M;
                long j22 = j17 + (j19 * j);
                int i18 = (int) j22;
                iArr2[i11] = (i18 << 1) | i14;
                long j23 = j16 + (j22 >>> 32) + (j19 * j11);
                long j24 = j20 + (j23 >>> 32) + (j19 * j18);
                long j25 = j23 & f1329M;
                long j26 = j24 & f1329M;
                long j27 = ((long) iArr[i + 4]) & f1329M;
                int i19 = i2 + 7;
                long j28 = j19;
                long j29 = ((long) iArr2[i19]) & f1329M;
                int i20 = i2 + 8;
                int i21 = i19;
                long j30 = ((long) iArr2[i20]) & f1329M;
                long j31 = j25 + (j27 * j);
                int i22 = (int) j31;
                iArr2[i12] = (i18 >>> 31) | (i22 << 1);
                int i23 = i22 >>> 31;
                long j32 = j26 + (j31 >>> 32) + (j27 * j11);
                long j33 = j21 + (j24 >>> 32) + (j32 >>> 32) + (j27 * j18);
                long j34 = j32 & f1329M;
                long j35 = j29 + (j33 >>> 32) + (j27 * j28);
                long j36 = j33 & f1329M;
                long j37 = j30 + (j35 >>> 32);
                long j38 = j35 & f1329M;
                long j39 = j27;
                long j40 = ((long) iArr[i + 5]) & f1329M;
                int i24 = i2 + 9;
                long j41 = j37;
                int i25 = i2 + 10;
                long j42 = ((long) iArr2[i24]) & f1329M;
                long j43 = ((long) iArr2[i25]) & f1329M;
                long j44 = j34 + (j * j40);
                int i26 = (int) j44;
                iArr2[i17] = (i26 << 1) | i23;
                long j45 = j36 + (j44 >>> 32) + (j40 * j11);
                long j46 = j38 + (j45 >>> 32) + (j40 * j18);
                long j47 = j41 + (j46 >>> 32) + (j40 * j28);
                long j48 = j42 + (j47 >>> 32) + (j40 * j39);
                long j49 = j43 + (j48 >>> 32);
                int i27 = (int) j45;
                iArr2[i16] = (i26 >>> 31) | (i27 << 1);
                int i28 = i27 >>> 31;
                int i29 = (int) j46;
                iArr2[i21] = i28 | (i29 << 1);
                int i30 = i29 >>> 31;
                int i31 = (int) j47;
                iArr2[i20] = i30 | (i31 << 1);
                int i32 = i31 >>> 31;
                int i33 = (int) j48;
                iArr2[i24] = i32 | (i33 << 1);
                int i34 = i33 >>> 31;
                int i35 = (int) j49;
                iArr2[i25] = i34 | (i35 << 1);
                int i36 = i35 >>> 31;
                int i37 = i2 + 11;
                iArr2[i37] = i36 | ((iArr2[i37] + ((int) (j49 >> 32))) << 1);
                return;
            }
            i5 = i6;
        }
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & f1329M) - (((long) iArr2[0]) & f1329M)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & f1329M) - (((long) iArr2[1]) & f1329M));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[2]) & f1329M) - (((long) iArr2[2]) & f1329M));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[3]) & f1329M) - (((long) iArr2[3]) & f1329M));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[4]) & f1329M) - (((long) iArr2[4]) & f1329M));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[5]) & f1329M) - (((long) iArr2[5]) & f1329M));
        iArr3[5] = (int) j6;
        return (int) (j6 >> 32);
    }

    public static int sub(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((((long) iArr[i + 0]) & f1329M) - (((long) iArr2[i2 + 0]) & f1329M)) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[i + 1]) & f1329M) - (((long) iArr2[i2 + 1]) & f1329M));
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[i + 2]) & f1329M) - (((long) iArr2[i2 + 2]) & f1329M));
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[i + 3]) & f1329M) - (((long) iArr2[i2 + 3]) & f1329M));
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[i + 4]) & f1329M) - (((long) iArr2[i2 + 4]) & f1329M));
        iArr3[i3 + 4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[i + 5]) & f1329M) - (((long) iArr2[i2 + 5]) & f1329M));
        iArr3[i3 + 5] = (int) j6;
        return (int) (j6 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((((long) iArr3[0]) & f1329M) - (((long) iArr[0]) & f1329M)) - (((long) iArr2[0]) & f1329M)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + (((((long) iArr3[1]) & f1329M) - (((long) iArr[1]) & f1329M)) - (((long) iArr2[1]) & f1329M));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + (((((long) iArr3[2]) & f1329M) - (((long) iArr[2]) & f1329M)) - (((long) iArr2[2]) & f1329M));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + (((((long) iArr3[3]) & f1329M) - (((long) iArr[3]) & f1329M)) - (((long) iArr2[3]) & f1329M));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + (((((long) iArr3[4]) & f1329M) - (((long) iArr[4]) & f1329M)) - (((long) iArr2[4]) & f1329M));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + (((((long) iArr3[5]) & f1329M) - (((long) iArr[5]) & f1329M)) - (((long) iArr2[5]) & f1329M));
        iArr3[5] = (int) j6;
        return (int) (j6 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & f1329M) - (((long) iArr[0]) & f1329M)) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr2[1]) & f1329M) - (((long) iArr[1]) & f1329M));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr2[2]) & f1329M) - (((long) iArr[2]) & f1329M));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr2[3]) & f1329M) - (((long) iArr[3]) & f1329M));
        iArr2[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr2[4]) & f1329M) - (((long) iArr[4]) & f1329M));
        iArr2[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr2[5]) & f1329M) - (f1329M & ((long) iArr[5])));
        iArr2[5] = (int) j6;
        return (int) (j6 >> 32);
    }

    public static int subFrom(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i2 + 0;
        long j = ((((long) iArr2[i3]) & f1329M) - (((long) iArr[i + 0]) & f1329M)) + 0;
        iArr2[i3] = (int) j;
        int i4 = i2 + 1;
        long j2 = (j >> 32) + ((((long) iArr2[i4]) & f1329M) - (((long) iArr[i + 1]) & f1329M));
        iArr2[i4] = (int) j2;
        int i5 = i2 + 2;
        long j3 = (j2 >> 32) + ((((long) iArr2[i5]) & f1329M) - (((long) iArr[i + 2]) & f1329M));
        iArr2[i5] = (int) j3;
        int i6 = i2 + 3;
        long j4 = (j3 >> 32) + ((((long) iArr2[i6]) & f1329M) - (((long) iArr[i + 3]) & f1329M));
        iArr2[i6] = (int) j4;
        int i7 = i2 + 4;
        long j5 = (j4 >> 32) + ((((long) iArr2[i7]) & f1329M) - (((long) iArr[i + 4]) & f1329M));
        iArr2[i7] = (int) j5;
        int i8 = i2 + 5;
        long j6 = (j5 >> 32) + ((((long) iArr2[i8]) & f1329M) - (((long) iArr[i + 5]) & f1329M));
        iArr2[i8] = (int) j6;
        return (int) (j6 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[24];
        for (int i = 0; i < 6; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.intToBigEndian(i2, bArr, (5 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
    }
}
