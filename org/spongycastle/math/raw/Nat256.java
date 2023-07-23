package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

public abstract class Nat256 {

    /* renamed from: M */
    private static final long f1331M = 4294967295L;

    public static int[] create() {
        return new int[8];
    }

    public static int[] createExt() {
        return new int[16];
    }

    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & f1331M) + (((long) iArr2[0]) & f1331M) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & f1331M) + (((long) iArr2[1]) & f1331M);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & f1331M) + (((long) iArr2[2]) & f1331M);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & f1331M) + (((long) iArr2[3]) & f1331M);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & f1331M) + (((long) iArr2[4]) & f1331M);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & f1331M) + (((long) iArr2[5]) & f1331M);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & f1331M) + (((long) iArr2[6]) & f1331M);
        iArr3[6] = (int) j7;
        long j8 = (j7 >>> 32) + (((long) iArr[7]) & f1331M) + (((long) iArr2[7]) & f1331M);
        iArr3[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int add(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = (((long) iArr[i + 0]) & f1331M) + (((long) iArr2[i2 + 0]) & f1331M) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & f1331M) + (((long) iArr2[i2 + 1]) & f1331M);
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & f1331M) + (((long) iArr2[i2 + 2]) & f1331M);
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & f1331M) + (((long) iArr2[i2 + 3]) & f1331M);
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & f1331M) + (((long) iArr2[i2 + 4]) & f1331M);
        iArr3[i3 + 4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & f1331M) + (((long) iArr2[i2 + 5]) & f1331M);
        iArr3[i3 + 5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & f1331M) + (((long) iArr2[i2 + 6]) & f1331M);
        iArr3[i3 + 6] = (int) j7;
        long j8 = (j7 >>> 32) + (((long) iArr[i + 7]) & f1331M) + (((long) iArr2[i2 + 7]) & f1331M);
        iArr3[i3 + 7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & f1331M) + (((long) iArr2[0]) & f1331M) + (((long) iArr3[0]) & f1331M) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & f1331M) + (((long) iArr2[1]) & f1331M) + (((long) iArr3[1]) & f1331M);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & f1331M) + (((long) iArr2[2]) & f1331M) + (((long) iArr3[2]) & f1331M);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & f1331M) + (((long) iArr2[3]) & f1331M) + (((long) iArr3[3]) & f1331M);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & f1331M) + (((long) iArr2[4]) & f1331M) + (((long) iArr3[4]) & f1331M);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & f1331M) + (((long) iArr2[5]) & f1331M) + (((long) iArr3[5]) & f1331M);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & f1331M) + (((long) iArr2[6]) & f1331M) + (((long) iArr3[6]) & f1331M);
        iArr3[6] = (int) j7;
        long j8 = (j7 >>> 32) + (((long) iArr[7]) & f1331M) + (((long) iArr2[7]) & f1331M) + (((long) iArr3[7]) & f1331M);
        iArr3[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int addBothTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        int i4 = i3 + 0;
        long j = (((long) iArr[i + 0]) & f1331M) + (((long) iArr2[i2 + 0]) & f1331M) + (((long) iArr3[i4]) & f1331M) + 0;
        iArr3[i4] = (int) j;
        int i5 = i3 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & f1331M) + (((long) iArr2[i2 + 1]) & f1331M) + (((long) iArr3[i5]) & f1331M);
        iArr3[i5] = (int) j2;
        int i6 = i3 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & f1331M) + (((long) iArr2[i2 + 2]) & f1331M) + (((long) iArr3[i6]) & f1331M);
        iArr3[i6] = (int) j3;
        int i7 = i3 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & f1331M) + (((long) iArr2[i2 + 3]) & f1331M) + (((long) iArr3[i7]) & f1331M);
        iArr3[i7] = (int) j4;
        int i8 = i3 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & f1331M) + (((long) iArr2[i2 + 4]) & f1331M) + (((long) iArr3[i8]) & f1331M);
        iArr3[i8] = (int) j5;
        int i9 = i3 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & f1331M) + (((long) iArr2[i2 + 5]) & f1331M) + (((long) iArr3[i9]) & f1331M);
        iArr3[i9] = (int) j6;
        int i10 = i3 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & f1331M) + (((long) iArr2[i2 + 6]) & f1331M) + (((long) iArr3[i10]) & f1331M);
        iArr3[i10] = (int) j7;
        int i11 = i3 + 7;
        long j8 = (j7 >>> 32) + (((long) iArr[i + 7]) & f1331M) + (((long) iArr2[i2 + 7]) & f1331M) + (((long) iArr3[i11]) & f1331M);
        iArr3[i11] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[0]) & f1331M) + (((long) iArr2[0]) & f1331M) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & f1331M) + (((long) iArr2[1]) & f1331M);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & f1331M) + (((long) iArr2[2]) & f1331M);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & f1331M) + (((long) iArr2[3]) & f1331M);
        iArr2[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & f1331M) + (((long) iArr2[4]) & f1331M);
        iArr2[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & f1331M) + (((long) iArr2[5]) & f1331M);
        iArr2[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & f1331M) + (((long) iArr2[6]) & f1331M);
        iArr2[6] = (int) j7;
        long j8 = (j7 >>> 32) + (((long) iArr[7]) & f1331M) + (f1331M & ((long) iArr2[7]));
        iArr2[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int addTo(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = i2 + 0;
        long j = (((long) i3) & f1331M) + (((long) iArr[i + 0]) & f1331M) + (((long) iArr2[i4]) & f1331M);
        iArr2[i4] = (int) j;
        int i5 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & f1331M) + (((long) iArr2[i5]) & f1331M);
        iArr2[i5] = (int) j2;
        int i6 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & f1331M) + (((long) iArr2[i6]) & f1331M);
        iArr2[i6] = (int) j3;
        int i7 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & f1331M) + (((long) iArr2[i7]) & f1331M);
        iArr2[i7] = (int) j4;
        int i8 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & f1331M) + (((long) iArr2[i8]) & f1331M);
        iArr2[i8] = (int) j5;
        int i9 = i2 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & f1331M) + (((long) iArr2[i9]) & f1331M);
        iArr2[i9] = (int) j6;
        int i10 = i2 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & f1331M) + (((long) iArr2[i10]) & f1331M);
        iArr2[i10] = (int) j7;
        int i11 = i2 + 7;
        long j8 = (j7 >>> 32) + (((long) iArr[i + 7]) & f1331M) + (f1331M & ((long) iArr2[i11]));
        iArr2[i11] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i + 0;
        int i4 = i2 + 0;
        long j = (((long) iArr[i3]) & f1331M) + (((long) iArr2[i4]) & f1331M) + 0;
        int i5 = (int) j;
        iArr[i3] = i5;
        iArr2[i4] = i5;
        int i6 = i + 1;
        int i7 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i6]) & f1331M) + (((long) iArr2[i7]) & f1331M);
        int i8 = (int) j2;
        iArr[i6] = i8;
        iArr2[i7] = i8;
        int i9 = i + 2;
        int i10 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i9]) & f1331M) + (((long) iArr2[i10]) & f1331M);
        int i11 = (int) j3;
        iArr[i9] = i11;
        iArr2[i10] = i11;
        int i12 = i + 3;
        int i13 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i12]) & f1331M) + (((long) iArr2[i13]) & f1331M);
        int i14 = (int) j4;
        iArr[i12] = i14;
        iArr2[i13] = i14;
        int i15 = i + 4;
        int i16 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i15]) & f1331M) + (((long) iArr2[i16]) & f1331M);
        int i17 = (int) j5;
        iArr[i15] = i17;
        iArr2[i16] = i17;
        int i18 = i + 5;
        int i19 = i2 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i18]) & f1331M) + (((long) iArr2[i19]) & f1331M);
        int i20 = (int) j6;
        iArr[i18] = i20;
        iArr2[i19] = i20;
        int i21 = i + 6;
        int i22 = i2 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i21]) & f1331M) + (((long) iArr2[i22]) & f1331M);
        int i23 = (int) j7;
        iArr[i21] = i23;
        iArr2[i22] = i23;
        int i24 = i + 7;
        int i25 = i2 + 7;
        long j8 = (j7 >>> 32) + (((long) iArr[i24]) & f1331M) + (f1331M & ((long) iArr2[i25]));
        int i26 = (int) j8;
        iArr[i24] = i26;
        iArr2[i25] = i26;
        return (int) (j8 >>> 32);
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
        iArr2[7] = iArr[7];
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
    public static boolean m614eq(int[] iArr, int[] iArr2) {
        for (int i = 7; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
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
        } else if ((i & 255) != i) {
            return 0;
        } else {
            i2 = iArr[i >>> 5] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i = 7; i >= 0; i--) {
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
        for (int i3 = 7; i3 >= 0; i3--) {
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
        for (int i = 1; i < 8; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i = 0; i < 8; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & f1331M;
        long j2 = ((long) iArr2[1]) & f1331M;
        long j3 = ((long) iArr2[2]) & f1331M;
        long j4 = ((long) iArr2[3]) & f1331M;
        long j5 = ((long) iArr2[4]) & f1331M;
        long j6 = j3;
        long j7 = ((long) iArr2[5]) & f1331M;
        long j8 = ((long) iArr2[6]) & f1331M;
        long j9 = ((long) iArr2[7]) & f1331M;
        long j10 = ((long) iArr[0]) & f1331M;
        long j11 = (j10 * j) + 0;
        iArr3[0] = (int) j11;
        long j12 = (j11 >>> 32) + (j10 * j2);
        iArr3[1] = (int) j12;
        long j13 = (j12 >>> 32) + (j10 * j6);
        iArr3[2] = (int) j13;
        long j14 = (j13 >>> 32) + (j10 * j4);
        iArr3[3] = (int) j14;
        long j15 = (j14 >>> 32) + (j10 * j5);
        iArr3[4] = (int) j15;
        long j16 = (j15 >>> 32) + (j10 * j7);
        iArr3[5] = (int) j16;
        long j17 = (j16 >>> 32) + (j10 * j8);
        iArr3[6] = (int) j17;
        long j18 = (j17 >>> 32) + (j10 * j9);
        iArr3[7] = (int) j18;
        int i = (int) (j18 >>> 32);
        iArr3[8] = i;
        int i2 = 1;
        for (int i3 = 8; i2 < i3; i3 = 8) {
            long j19 = ((long) iArr[i2]) & f1331M;
            int i4 = i2 + 0;
            long j20 = (j19 * j) + (((long) iArr3[i4]) & f1331M) + 0;
            iArr3[i4] = (int) j20;
            int i5 = i2 + 1;
            long j21 = j2;
            long j22 = (j20 >>> 32) + (j19 * j2) + (((long) iArr3[i5]) & f1331M);
            iArr3[i5] = (int) j22;
            int i6 = i2 + 2;
            long j23 = j7;
            long j24 = (j22 >>> 32) + (j19 * j6) + (((long) iArr3[i6]) & f1331M);
            iArr3[i6] = (int) j24;
            int i7 = i2 + 3;
            long j25 = (j24 >>> 32) + (j19 * j4) + (((long) iArr3[i7]) & f1331M);
            iArr3[i7] = (int) j25;
            int i8 = i2 + 4;
            long j26 = (j25 >>> 32) + (j19 * j5) + (((long) iArr3[i8]) & f1331M);
            iArr3[i8] = (int) j26;
            int i9 = i2 + 5;
            long j27 = (j26 >>> 32) + (j19 * j23) + (((long) iArr3[i9]) & f1331M);
            iArr3[i9] = (int) j27;
            int i10 = i2 + 6;
            long j28 = (j27 >>> 32) + (j19 * j8) + (((long) iArr3[i10]) & f1331M);
            iArr3[i10] = (int) j28;
            int i11 = i2 + 7;
            long j29 = (j28 >>> 32) + (j19 * j9) + (((long) iArr3[i11]) & f1331M);
            iArr3[i11] = (int) j29;
            iArr3[i2 + 8] = (int) (j29 >>> 32);
            i2 = i5;
            j = j;
            j2 = j21;
            j7 = j23;
        }
    }

    public static void mul(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2 + 0]) & f1331M;
        long j2 = ((long) iArr2[i2 + 1]) & f1331M;
        long j3 = ((long) iArr2[i2 + 2]) & f1331M;
        long j4 = ((long) iArr2[i2 + 3]) & f1331M;
        long j5 = ((long) iArr2[i2 + 4]) & f1331M;
        long j6 = ((long) iArr2[i2 + 5]) & f1331M;
        long j7 = ((long) iArr2[i2 + 6]) & f1331M;
        long j8 = ((long) iArr2[i2 + 7]) & f1331M;
        long j9 = ((long) iArr[i + 0]) & f1331M;
        long j10 = (j9 * j) + 0;
        long j11 = j;
        iArr3[i3 + 0] = (int) j10;
        long j12 = (j10 >>> 32) + (j9 * j2);
        long j13 = j2;
        iArr3[i3 + 1] = (int) j12;
        long j14 = (j12 >>> 32) + (j9 * j3);
        iArr3[i3 + 2] = (int) j14;
        long j15 = (j14 >>> 32) + (j9 * j4);
        iArr3[i3 + 3] = (int) j15;
        long j16 = (j15 >>> 32) + (j9 * j5);
        iArr3[i3 + 4] = (int) j16;
        long j17 = (j16 >>> 32) + (j9 * j6);
        iArr3[i3 + 5] = (int) j17;
        long j18 = (j17 >>> 32) + (j9 * j7);
        iArr3[i3 + 6] = (int) j18;
        long j19 = j8;
        long j20 = (j18 >>> 32) + (j9 * j19);
        iArr3[i3 + 7] = (int) j20;
        iArr3[i3 + 8] = (int) (j20 >>> 32);
        int i4 = 1;
        int i5 = i3;
        int i6 = 1;
        while (i6 < 8) {
            i5 += i4;
            long j21 = ((long) iArr[i + i6]) & f1331M;
            int i7 = i5 + 0;
            long j22 = (j21 * j11) + (((long) iArr3[i7]) & f1331M) + 0;
            iArr3[i7] = (int) j22;
            int i8 = i5 + 1;
            long j23 = j19;
            long j24 = (j22 >>> 32) + (j21 * j13) + (((long) iArr3[i8]) & f1331M);
            iArr3[i8] = (int) j24;
            int i9 = i5 + 2;
            long j25 = j3;
            long j26 = (j24 >>> 32) + (j21 * j3) + (((long) iArr3[i9]) & f1331M);
            iArr3[i9] = (int) j26;
            int i10 = i5 + 3;
            long j27 = (j26 >>> 32) + (j21 * j4) + (((long) iArr3[i10]) & f1331M);
            iArr3[i10] = (int) j27;
            int i11 = i5 + 4;
            long j28 = (j27 >>> 32) + (j21 * j5) + (((long) iArr3[i11]) & f1331M);
            iArr3[i11] = (int) j28;
            int i12 = i5 + 5;
            long j29 = (j28 >>> 32) + (j21 * j6) + (((long) iArr3[i12]) & f1331M);
            iArr3[i12] = (int) j29;
            int i13 = i5 + 6;
            long j30 = (j29 >>> 32) + (j21 * j7) + (((long) iArr3[i13]) & f1331M);
            iArr3[i13] = (int) j30;
            int i14 = i5 + 7;
            long j31 = (j30 >>> 32) + (j21 * j23) + (((long) iArr3[i14]) & f1331M);
            iArr3[i14] = (int) j31;
            iArr3[i5 + 8] = (int) (j31 >>> 32);
            i6++;
            j3 = j25;
            j19 = j23;
            j4 = j4;
            i4 = 1;
        }
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = f1331M;
        long j2 = ((long) iArr2[0]) & f1331M;
        long j3 = ((long) iArr2[1]) & f1331M;
        long j4 = ((long) iArr2[2]) & f1331M;
        long j5 = ((long) iArr2[3]) & f1331M;
        long j6 = ((long) iArr2[4]) & f1331M;
        long j7 = ((long) iArr2[5]) & f1331M;
        long j8 = j2;
        long j9 = ((long) iArr2[6]) & f1331M;
        long j10 = ((long) iArr2[7]) & f1331M;
        long j11 = 0;
        int i = 0;
        while (i < 8) {
            long j12 = j10;
            long j13 = ((long) iArr[i]) & j;
            int i2 = i + 0;
            long j14 = j7;
            long j15 = (j13 * j8) + (((long) iArr3[i2]) & j) + 0;
            iArr3[i2] = (int) j15;
            int i3 = i + 1;
            long j16 = j3;
            long j17 = (j15 >>> 32) + (j13 * j3) + (((long) iArr3[i3]) & j);
            iArr3[i3] = (int) j17;
            int i4 = i + 2;
            long j18 = (j17 >>> 32) + (j13 * j4) + (((long) iArr3[i4]) & j);
            iArr3[i4] = (int) j18;
            int i5 = i + 3;
            long j19 = (j18 >>> 32) + (j13 * j5) + (((long) iArr3[i5]) & j);
            iArr3[i5] = (int) j19;
            int i6 = i + 4;
            long j20 = (j19 >>> 32) + (j13 * j6) + (((long) iArr3[i6]) & j);
            iArr3[i6] = (int) j20;
            int i7 = i + 5;
            long j21 = (j20 >>> 32) + (j13 * j14) + (((long) iArr3[i7]) & j);
            iArr3[i7] = (int) j21;
            int i8 = i + 6;
            long j22 = (j21 >>> 32) + (j13 * j9) + (((long) iArr3[i8]) & j);
            iArr3[i8] = (int) j22;
            int i9 = i + 7;
            long j23 = (j22 >>> 32) + (j13 * j12) + (((long) iArr3[i9]) & j);
            iArr3[i9] = (int) j23;
            int i10 = i + 8;
            long j24 = (j23 >>> 32) + j11 + (((long) iArr3[i10]) & j);
            iArr3[i10] = (int) j24;
            j11 = j24 >>> 32;
            i = i3;
            j10 = j12;
            j7 = j14;
            j3 = j16;
            j = f1331M;
        }
        return (int) j11;
    }

    public static int mulAddTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2 + 0]) & f1331M;
        long j2 = ((long) iArr2[i2 + 1]) & f1331M;
        long j3 = ((long) iArr2[i2 + 2]) & f1331M;
        long j4 = ((long) iArr2[i2 + 3]) & f1331M;
        long j5 = ((long) iArr2[i2 + 4]) & f1331M;
        long j6 = ((long) iArr2[i2 + 5]) & f1331M;
        long j7 = ((long) iArr2[i2 + 6]) & f1331M;
        long j8 = ((long) iArr2[i2 + 7]) & f1331M;
        int i4 = i3;
        long j9 = 0;
        int i5 = 0;
        while (i5 < 8) {
            int i6 = i5;
            long j10 = ((long) iArr[i + i5]) & f1331M;
            int i7 = i4 + 0;
            long j11 = j;
            long j12 = (j10 * j) + (((long) iArr3[i7]) & f1331M) + 0;
            long j13 = j8;
            iArr3[i7] = (int) j12;
            int i8 = i4 + 1;
            long j14 = (j12 >>> 32) + (j10 * j2) + (((long) iArr3[i8]) & f1331M);
            iArr3[i8] = (int) j14;
            int i9 = i4 + 2;
            long j15 = (j14 >>> 32) + (j10 * j3) + (((long) iArr3[i9]) & f1331M);
            iArr3[i9] = (int) j15;
            int i10 = i4 + 3;
            long j16 = (j15 >>> 32) + (j10 * j4) + (((long) iArr3[i10]) & f1331M);
            iArr3[i10] = (int) j16;
            int i11 = i4 + 4;
            long j17 = (j16 >>> 32) + (j10 * j5) + (((long) iArr3[i11]) & f1331M);
            iArr3[i11] = (int) j17;
            int i12 = i4 + 5;
            long j18 = (j17 >>> 32) + (j10 * j6) + (((long) iArr3[i12]) & f1331M);
            iArr3[i12] = (int) j18;
            int i13 = i4 + 6;
            long j19 = (j18 >>> 32) + (j10 * j7) + (((long) iArr3[i13]) & f1331M);
            iArr3[i13] = (int) j19;
            int i14 = i4 + 7;
            long j20 = (j19 >>> 32) + (j10 * j13) + (((long) iArr3[i14]) & f1331M);
            iArr3[i14] = (int) j20;
            int i15 = i4 + 8;
            long j21 = (j20 >>> 32) + j9 + (((long) iArr3[i15]) & f1331M);
            iArr3[i15] = (int) j21;
            j9 = j21 >>> 32;
            i5 = i6 + 1;
            i4 = i8;
            j8 = j13;
            j = j11;
            j3 = j3;
            j2 = j2;
        }
        return (int) j9;
    }

    public static long mul33Add(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = ((long) i) & f1331M;
        long j2 = ((long) iArr[i2 + 0]) & f1331M;
        long j3 = (j * j2) + (((long) iArr2[i3 + 0]) & f1331M) + 0;
        iArr3[i4 + 0] = (int) j3;
        long j4 = ((long) iArr[i2 + 1]) & f1331M;
        long j5 = (j3 >>> 32) + (j * j4) + j2 + (((long) iArr2[i3 + 1]) & f1331M);
        iArr3[i4 + 1] = (int) j5;
        long j6 = j5 >>> 32;
        long j7 = ((long) iArr[i2 + 2]) & f1331M;
        long j8 = j6 + (j * j7) + j4 + (((long) iArr2[i3 + 2]) & f1331M);
        iArr3[i4 + 2] = (int) j8;
        long j9 = ((long) iArr[i2 + 3]) & f1331M;
        long j10 = (j8 >>> 32) + (j * j9) + j7 + (((long) iArr2[i3 + 3]) & f1331M);
        iArr3[i4 + 3] = (int) j10;
        long j11 = ((long) iArr[i2 + 4]) & f1331M;
        long j12 = (j10 >>> 32) + (j * j11) + j9 + (((long) iArr2[i3 + 4]) & f1331M);
        iArr3[i4 + 4] = (int) j12;
        long j13 = ((long) iArr[i2 + 5]) & f1331M;
        long j14 = (j12 >>> 32) + (j * j13) + j11 + (((long) iArr2[i3 + 5]) & f1331M);
        iArr3[i4 + 5] = (int) j14;
        long j15 = ((long) iArr[i2 + 6]) & f1331M;
        long j16 = (j14 >>> 32) + (j * j15) + j13 + (((long) iArr2[i3 + 6]) & f1331M);
        iArr3[i4 + 6] = (int) j16;
        long j17 = ((long) iArr[i2 + 7]) & f1331M;
        long j18 = (j16 >>> 32) + (j * j17) + j15 + (f1331M & ((long) iArr2[i3 + 7]));
        iArr3[i4 + 7] = (int) j18;
        return (j18 >>> 32) + j17;
    }

    public static int mulByWord(int i, int[] iArr) {
        long j = ((long) i) & f1331M;
        long j2 = ((((long) iArr[0]) & f1331M) * j) + 0;
        iArr[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((((long) iArr[1]) & f1331M) * j);
        iArr[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((((long) iArr[2]) & f1331M) * j);
        iArr[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((((long) iArr[3]) & f1331M) * j);
        iArr[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((((long) iArr[4]) & f1331M) * j);
        iArr[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((((long) iArr[5]) & f1331M) * j);
        iArr[5] = (int) j7;
        long j8 = (j7 >>> 32) + ((((long) iArr[6]) & f1331M) * j);
        iArr[6] = (int) j8;
        long j9 = (j8 >>> 32) + (j * (f1331M & ((long) iArr[7])));
        iArr[7] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int mulByWordAddTo(int i, int[] iArr, int[] iArr2) {
        long j = ((long) i) & f1331M;
        long j2 = ((((long) iArr2[0]) & f1331M) * j) + (((long) iArr[0]) & f1331M) + 0;
        iArr2[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((((long) iArr2[1]) & f1331M) * j) + (((long) iArr[1]) & f1331M);
        iArr2[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((((long) iArr2[2]) & f1331M) * j) + (((long) iArr[2]) & f1331M);
        iArr2[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((((long) iArr2[3]) & f1331M) * j) + (((long) iArr[3]) & f1331M);
        iArr2[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((((long) iArr2[4]) & f1331M) * j) + (((long) iArr[4]) & f1331M);
        iArr2[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((((long) iArr2[5]) & f1331M) * j) + (((long) iArr[5]) & f1331M);
        iArr2[5] = (int) j7;
        long j8 = (j7 >>> 32) + ((((long) iArr2[6]) & f1331M) * j) + (((long) iArr[6]) & f1331M);
        iArr2[6] = (int) j8;
        long j9 = (j8 >>> 32) + (j * (((long) iArr2[7]) & f1331M)) + (f1331M & ((long) iArr[7]));
        iArr2[7] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int mulWordAddTo(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = ((long) i) & f1331M;
        int i4 = i3 + 0;
        long j2 = ((((long) iArr[i2 + 0]) & f1331M) * j) + (((long) iArr2[i4]) & f1331M) + 0;
        iArr2[i4] = (int) j2;
        int i5 = i3 + 1;
        long j3 = (j2 >>> 32) + ((((long) iArr[i2 + 1]) & f1331M) * j) + (((long) iArr2[i5]) & f1331M);
        iArr2[i5] = (int) j3;
        int i6 = i3 + 2;
        long j4 = (j3 >>> 32) + ((((long) iArr[i2 + 2]) & f1331M) * j) + (((long) iArr2[i6]) & f1331M);
        iArr2[i6] = (int) j4;
        int i7 = i3 + 3;
        long j5 = (j4 >>> 32) + ((((long) iArr[i2 + 3]) & f1331M) * j) + (((long) iArr2[i7]) & f1331M);
        iArr2[i7] = (int) j5;
        int i8 = i3 + 4;
        long j6 = (j5 >>> 32) + ((((long) iArr[i2 + 4]) & f1331M) * j) + (((long) iArr2[i8]) & f1331M);
        iArr2[i8] = (int) j6;
        int i9 = i3 + 5;
        long j7 = (j6 >>> 32) + ((((long) iArr[i2 + 5]) & f1331M) * j) + (((long) iArr2[i9]) & f1331M);
        iArr2[i9] = (int) j7;
        int i10 = i3 + 6;
        long j8 = (j7 >>> 32) + ((((long) iArr[i2 + 6]) & f1331M) * j) + (((long) iArr2[i10]) & f1331M);
        iArr2[i10] = (int) j8;
        int i11 = i3 + 7;
        long j9 = (j8 >>> 32) + (j * (((long) iArr[i2 + 7]) & f1331M)) + (((long) iArr2[i11]) & f1331M);
        iArr2[i11] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int mul33DWordAdd(int i, long j, int[] iArr, int i2) {
        int[] iArr2 = iArr;
        int i3 = i2;
        long j2 = ((long) i) & f1331M;
        long j3 = j & f1331M;
        int i4 = i3 + 0;
        long j4 = (j2 * j3) + (((long) iArr2[i4]) & f1331M) + 0;
        iArr2[i4] = (int) j4;
        long j5 = j >>> 32;
        long j6 = (j2 * j5) + j3;
        int i5 = i3 + 1;
        long j7 = (j4 >>> 32) + j6 + (((long) iArr2[i5]) & f1331M);
        iArr2[i5] = (int) j7;
        int i6 = i3 + 2;
        long j8 = (j7 >>> 32) + j5 + (((long) iArr2[i6]) & f1331M);
        iArr2[i6] = (int) j8;
        int i7 = i3 + 3;
        long j9 = (j8 >>> 32) + (f1331M & ((long) iArr2[i7]));
        iArr2[i7] = (int) j9;
        if ((j9 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(8, iArr2, i3, 4);
    }

    public static int mul33WordAdd(int i, int i2, int[] iArr, int i3) {
        long j = ((long) i) & f1331M;
        long j2 = ((long) i2) & f1331M;
        int i4 = i3 + 0;
        long j3 = (j * j2) + (((long) iArr[i4]) & f1331M) + 0;
        iArr[i4] = (int) j3;
        int i5 = i3 + 1;
        long j4 = (j3 >>> 32) + j2 + (((long) iArr[i5]) & f1331M);
        iArr[i5] = (int) j4;
        long j5 = j4 >>> 32;
        int i6 = i3 + 2;
        long j6 = j5 + (((long) iArr[i6]) & f1331M);
        iArr[i6] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(8, iArr, i3, 3);
    }

    public static int mulWordDwordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = ((long) i) & f1331M;
        int i3 = i2 + 0;
        long j3 = ((j & f1331M) * j2) + (((long) iArr[i3]) & f1331M) + 0;
        iArr[i3] = (int) j3;
        long j4 = j2 * (j >>> 32);
        int i4 = i2 + 1;
        long j5 = (j3 >>> 32) + j4 + (((long) iArr[i4]) & f1331M);
        iArr[i4] = (int) j5;
        int i5 = i2 + 2;
        long j6 = (j5 >>> 32) + (((long) iArr[i5]) & f1331M);
        iArr[i5] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(8, iArr, i2, 3);
    }

    public static int mulWord(int i, int[] iArr, int[] iArr2, int i2) {
        long j = ((long) i) & f1331M;
        long j2 = 0;
        int i3 = 0;
        do {
            long j3 = j2 + ((((long) iArr[i3]) & f1331M) * j);
            iArr2[i2 + i3] = (int) j3;
            j2 = j3 >>> 32;
            i3++;
        } while (i3 < 8);
        return (int) j2;
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & f1331M;
        int i = 16;
        int i2 = 7;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            long j2 = ((long) iArr[i2]) & f1331M;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i3 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i6 << 31)) & f1331M) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & f1331M;
                long j7 = ((long) iArr2[2]) & f1331M;
                long j8 = j5 + (j6 * j);
                int i7 = (int) j8;
                iArr2[1] = (i7 << 1) | (((int) (j4 >>> 32)) & 1);
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[2]) & f1331M;
                long j11 = ((long) iArr2[3]) & f1331M;
                long j12 = j6;
                long j13 = ((long) iArr2[4]) & f1331M;
                long j14 = j9 + (j10 * j);
                int i8 = (int) j14;
                iArr2[2] = (i8 << 1) | (i7 >>> 31);
                long j15 = j11 + (j14 >>> 32) + (j10 * j12);
                long j16 = j13 + (j15 >>> 32);
                long j17 = j15 & f1331M;
                long j18 = ((long) iArr[3]) & f1331M;
                long j19 = j;
                long j20 = ((long) iArr2[5]) & f1331M;
                long j21 = ((long) iArr2[6]) & f1331M;
                long j22 = j17 + (j18 * j19);
                int i9 = (int) j22;
                iArr2[3] = (i9 << 1) | (i8 >>> 31);
                long j23 = j16 + (j22 >>> 32) + (j18 * j12);
                long j24 = j20 + (j23 >>> 32) + (j18 * j10);
                long j25 = j23 & f1331M;
                long j26 = j24 & f1331M;
                long j27 = ((long) iArr[4]) & f1331M;
                long j28 = j18;
                long j29 = ((long) iArr2[7]) & f1331M;
                long j30 = ((long) iArr2[8]) & f1331M;
                long j31 = j25 + (j27 * j19);
                int i10 = (int) j31;
                iArr2[4] = (i10 << 1) | (i9 >>> 31);
                int i11 = i10 >>> 31;
                long j32 = j26 + (j31 >>> 32) + (j27 * j12);
                long j33 = j21 + (j24 >>> 32) + (j32 >>> 32) + (j27 * j10);
                long j34 = j32 & f1331M;
                long j35 = j29 + (j33 >>> 32) + (j27 * j28);
                long j36 = j33 & f1331M;
                long j37 = j30 + (j35 >>> 32);
                long j38 = j35 & f1331M;
                long j39 = j27;
                long j40 = ((long) iArr[5]) & f1331M;
                long j41 = j37;
                long j42 = ((long) iArr2[9]) & f1331M;
                long j43 = ((long) iArr2[10]) & f1331M;
                long j44 = j34 + (j40 * j19);
                int i12 = (int) j44;
                iArr2[5] = (i12 << 1) | i11;
                int i13 = i12 >>> 31;
                long j45 = j36 + (j44 >>> 32) + (j40 * j12);
                long j46 = j38 + (j45 >>> 32) + (j40 * j10);
                long j47 = j45 & f1331M;
                long j48 = j41 + (j46 >>> 32) + (j40 * j28);
                long j49 = j46 & f1331M;
                long j50 = j42 + (j48 >>> 32) + (j40 * j39);
                long j51 = j48 & f1331M;
                long j52 = j50 & f1331M;
                long j53 = j40;
                long j54 = ((long) iArr[6]) & f1331M;
                long j55 = j43 + (j50 >>> 32);
                long j56 = ((long) iArr2[11]) & f1331M;
                long j57 = ((long) iArr2[12]) & f1331M;
                long j58 = j47 + (j54 * j19);
                int i14 = (int) j58;
                iArr2[6] = (i14 << 1) | i13;
                int i15 = i14 >>> 31;
                long j59 = j49 + (j58 >>> 32) + (j54 * j12);
                long j60 = j51 + (j59 >>> 32) + (j54 * j10);
                long j61 = j59 & f1331M;
                long j62 = j52 + (j60 >>> 32) + (j54 * j28);
                long j63 = j60 & f1331M;
                long j64 = j55 + (j62 >>> 32) + (j54 * j39);
                long j65 = j62 & f1331M;
                long j66 = j56 + (j64 >>> 32) + (j54 * j53);
                long j67 = j64 & f1331M;
                long j68 = j57 + (j66 >>> 32);
                long j69 = j66 & f1331M;
                long j70 = j54;
                long j71 = ((long) iArr[7]) & f1331M;
                long j72 = f1331M & ((long) iArr2[14]);
                long j73 = j61 + (j71 * j19);
                int i16 = (int) j73;
                iArr2[7] = (i16 << 1) | i15;
                long j74 = j63 + (j73 >>> 32) + (j71 * j12);
                long j75 = j65 + (j74 >>> 32) + (j10 * j71);
                long j76 = j67 + (j75 >>> 32) + (j71 * j28);
                long j77 = j69 + (j76 >>> 32) + (j71 * j39);
                long j78 = j77;
                long j79 = j68 + (j77 >>> 32) + (j71 * j53);
                long j80 = (((long) iArr2[13]) & f1331M) + (j79 >>> 32) + (j71 * j70);
                long j81 = j72 + (j80 >>> 32);
                int i17 = (int) j74;
                iArr2[8] = (i17 << 1) | (i16 >>> 31);
                int i18 = (int) j75;
                iArr2[9] = (i18 << 1) | (i17 >>> 31);
                int i19 = i18 >>> 31;
                int i20 = (int) j76;
                iArr2[10] = i19 | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) j78;
                iArr2[11] = i21 | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j79;
                iArr2[12] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j80;
                iArr2[13] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) j81;
                iArr2[14] = i27 | (i28 << 1);
                iArr2[15] = (i28 >>> 31) | ((iArr2[15] + ((int) (j81 >> 32))) << 1);
                return;
            }
            i2 = i4;
            i3 = i6;
        }
    }

    public static void square(int[] iArr, int i, int[] iArr2, int i2) {
        long j = ((long) iArr[i + 0]) & f1331M;
        int i3 = 0;
        int i4 = 16;
        int i5 = 7;
        while (true) {
            int i6 = i5 - 1;
            long j2 = ((long) iArr[i + i5]) & f1331M;
            long j3 = j2 * j2;
            int i7 = i4 - 1;
            iArr2[i2 + i7] = (i3 << 31) | ((int) (j3 >>> 33));
            i4 = i7 - 1;
            iArr2[i2 + i4] = (int) (j3 >>> 1);
            i3 = (int) j3;
            if (i6 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i3 << 31)) & f1331M) | (j4 >>> 33);
                iArr2[i2 + 0] = (int) j4;
                long j6 = ((long) iArr[i + 1]) & f1331M;
                int i8 = i2 + 2;
                long j7 = ((long) iArr2[i8]) & f1331M;
                long j8 = j5 + (j6 * j);
                int i9 = (int) j8;
                iArr2[i2 + 1] = (i9 << 1) | (((int) (j4 >>> 32)) & 1);
                int i10 = i9 >>> 31;
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[i + 2]) & f1331M;
                int i11 = i2 + 3;
                long j11 = j6;
                int i12 = i2 + 4;
                long j12 = ((long) iArr2[i11]) & f1331M;
                long j13 = ((long) iArr2[i12]) & f1331M;
                long j14 = j9 + (j10 * j);
                int i13 = (int) j14;
                iArr2[i8] = (i13 << 1) | i10;
                int i14 = i13 >>> 31;
                long j15 = j12 + (j14 >>> 32) + (j10 * j11);
                long j16 = j13 + (j15 >>> 32);
                long j17 = j15 & f1331M;
                long j18 = j10;
                long j19 = ((long) iArr[i + 3]) & f1331M;
                int i15 = i2 + 5;
                long j20 = ((long) iArr2[i15]) & f1331M;
                int i16 = i2 + 6;
                int i17 = i15;
                long j21 = ((long) iArr2[i16]) & f1331M;
                long j22 = j17 + (j19 * j);
                int i18 = (int) j22;
                iArr2[i11] = (i18 << 1) | i14;
                long j23 = j16 + (j22 >>> 32) + (j19 * j11);
                long j24 = j20 + (j23 >>> 32) + (j19 * j18);
                long j25 = j23 & f1331M;
                long j26 = j24 & f1331M;
                long j27 = ((long) iArr[i + 4]) & f1331M;
                int i19 = i2 + 7;
                long j28 = j19;
                long j29 = ((long) iArr2[i19]) & f1331M;
                int i20 = i2 + 8;
                int i21 = i19;
                long j30 = ((long) iArr2[i20]) & f1331M;
                long j31 = j25 + (j27 * j);
                int i22 = (int) j31;
                iArr2[i12] = (i18 >>> 31) | (i22 << 1);
                int i23 = i22 >>> 31;
                long j32 = j26 + (j31 >>> 32) + (j27 * j11);
                long j33 = j21 + (j24 >>> 32) + (j32 >>> 32) + (j27 * j18);
                long j34 = j32 & f1331M;
                long j35 = j29 + (j33 >>> 32) + (j27 * j28);
                long j36 = j33 & f1331M;
                long j37 = j35 & f1331M;
                long j38 = j27;
                long j39 = ((long) iArr[i + 5]) & f1331M;
                int i24 = i2 + 9;
                long j40 = j30 + (j35 >>> 32);
                int i25 = i2 + 10;
                int i26 = i24;
                long j41 = ((long) iArr2[i24]) & f1331M;
                long j42 = ((long) iArr2[i25]) & f1331M;
                long j43 = j34 + (j39 * j);
                int i27 = (int) j43;
                iArr2[i17] = i23 | (i27 << 1);
                int i28 = i27 >>> 31;
                long j44 = j36 + (j43 >>> 32) + (j39 * j11);
                long j45 = j37 + (j44 >>> 32) + (j39 * j18);
                long j46 = j44 & f1331M;
                long j47 = j40 + (j45 >>> 32) + (j39 * j28);
                long j48 = j45 & f1331M;
                long j49 = j41 + (j47 >>> 32) + (j39 * j38);
                long j50 = j47 & f1331M;
                long j51 = j49 & f1331M;
                long j52 = j39;
                long j53 = ((long) iArr[i + 6]) & f1331M;
                int i29 = i2 + 11;
                long j54 = j42 + (j49 >>> 32);
                int i30 = i2 + 12;
                int i31 = i29;
                long j55 = ((long) iArr2[i29]) & f1331M;
                long j56 = ((long) iArr2[i30]) & f1331M;
                long j57 = j46 + (j53 * j);
                int i32 = (int) j57;
                iArr2[i16] = i28 | (i32 << 1);
                int i33 = i32 >>> 31;
                long j58 = j48 + (j57 >>> 32) + (j53 * j11);
                long j59 = j50 + (j58 >>> 32) + (j53 * j18);
                long j60 = j58 & f1331M;
                long j61 = j51 + (j59 >>> 32) + (j53 * j28);
                long j62 = j59 & f1331M;
                long j63 = j54 + (j61 >>> 32) + (j53 * j38);
                long j64 = j61 & f1331M;
                long j65 = j55 + (j63 >>> 32) + (j53 * j52);
                long j66 = j63 & f1331M;
                long j67 = j56 + (j65 >>> 32);
                long j68 = j65 & f1331M;
                long j69 = j53;
                long j70 = ((long) iArr[i + 7]) & f1331M;
                int i34 = i2 + 13;
                long j71 = j67;
                int i35 = i2 + 14;
                int i36 = i34;
                long j72 = ((long) iArr2[i34]) & f1331M;
                long j73 = ((long) iArr2[i35]) & f1331M;
                long j74 = j60 + (j * j70);
                int i37 = (int) j74;
                iArr2[i21] = (i37 << 1) | i33;
                long j75 = j62 + (j74 >>> 32) + (j70 * j11);
                long j76 = j64 + (j75 >>> 32) + (j70 * j18);
                long j77 = j66 + (j76 >>> 32) + (j70 * j28);
                long j78 = j68 + (j77 >>> 32) + (j70 * j38);
                long j79 = j78;
                long j80 = j71 + (j78 >>> 32) + (j70 * j52);
                long j81 = j72 + (j80 >>> 32) + (j70 * j69);
                long j82 = j73 + (j81 >>> 32);
                int i38 = (int) j75;
                iArr2[i20] = (i37 >>> 31) | (i38 << 1);
                int i39 = i38 >>> 31;
                int i40 = (int) j76;
                iArr2[i26] = i39 | (i40 << 1);
                int i41 = i40 >>> 31;
                int i42 = (int) j77;
                iArr2[i25] = i41 | (i42 << 1);
                int i43 = (int) j79;
                iArr2[i31] = (i42 >>> 31) | (i43 << 1);
                int i44 = (int) j80;
                iArr2[i30] = (i43 >>> 31) | (i44 << 1);
                int i45 = i44 >>> 31;
                int i46 = (int) j81;
                iArr2[i36] = i45 | (i46 << 1);
                int i47 = i46 >>> 31;
                int i48 = (int) j82;
                iArr2[i35] = i47 | (i48 << 1);
                int i49 = i48 >>> 31;
                int i50 = i2 + 15;
                iArr2[i50] = i49 | ((iArr2[i50] + ((int) (j82 >> 32))) << 1);
                return;
            }
            i5 = i6;
        }
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & f1331M) - (((long) iArr2[0]) & f1331M)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & f1331M) - (((long) iArr2[1]) & f1331M));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[2]) & f1331M) - (((long) iArr2[2]) & f1331M));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[3]) & f1331M) - (((long) iArr2[3]) & f1331M));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[4]) & f1331M) - (((long) iArr2[4]) & f1331M));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[5]) & f1331M) - (((long) iArr2[5]) & f1331M));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr[6]) & f1331M) - (((long) iArr2[6]) & f1331M));
        iArr3[6] = (int) j7;
        long j8 = (j7 >> 32) + ((((long) iArr[7]) & f1331M) - (((long) iArr2[7]) & f1331M));
        iArr3[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static int sub(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((((long) iArr[i + 0]) & f1331M) - (((long) iArr2[i2 + 0]) & f1331M)) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[i + 1]) & f1331M) - (((long) iArr2[i2 + 1]) & f1331M));
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[i + 2]) & f1331M) - (((long) iArr2[i2 + 2]) & f1331M));
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[i + 3]) & f1331M) - (((long) iArr2[i2 + 3]) & f1331M));
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[i + 4]) & f1331M) - (((long) iArr2[i2 + 4]) & f1331M));
        iArr3[i3 + 4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[i + 5]) & f1331M) - (((long) iArr2[i2 + 5]) & f1331M));
        iArr3[i3 + 5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr[i + 6]) & f1331M) - (((long) iArr2[i2 + 6]) & f1331M));
        iArr3[i3 + 6] = (int) j7;
        long j8 = (j7 >> 32) + ((((long) iArr[i + 7]) & f1331M) - (((long) iArr2[i2 + 7]) & f1331M));
        iArr3[i3 + 7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((((long) iArr3[0]) & f1331M) - (((long) iArr[0]) & f1331M)) - (((long) iArr2[0]) & f1331M)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + (((((long) iArr3[1]) & f1331M) - (((long) iArr[1]) & f1331M)) - (((long) iArr2[1]) & f1331M));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + (((((long) iArr3[2]) & f1331M) - (((long) iArr[2]) & f1331M)) - (((long) iArr2[2]) & f1331M));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + (((((long) iArr3[3]) & f1331M) - (((long) iArr[3]) & f1331M)) - (((long) iArr2[3]) & f1331M));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + (((((long) iArr3[4]) & f1331M) - (((long) iArr[4]) & f1331M)) - (((long) iArr2[4]) & f1331M));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + (((((long) iArr3[5]) & f1331M) - (((long) iArr[5]) & f1331M)) - (((long) iArr2[5]) & f1331M));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + (((((long) iArr3[6]) & f1331M) - (((long) iArr[6]) & f1331M)) - (((long) iArr2[6]) & f1331M));
        iArr3[6] = (int) j7;
        long j8 = (j7 >> 32) + (((((long) iArr3[7]) & f1331M) - (((long) iArr[7]) & f1331M)) - (((long) iArr2[7]) & f1331M));
        iArr3[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & f1331M) - (((long) iArr[0]) & f1331M)) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr2[1]) & f1331M) - (((long) iArr[1]) & f1331M));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr2[2]) & f1331M) - (((long) iArr[2]) & f1331M));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr2[3]) & f1331M) - (((long) iArr[3]) & f1331M));
        iArr2[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr2[4]) & f1331M) - (((long) iArr[4]) & f1331M));
        iArr2[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr2[5]) & f1331M) - (((long) iArr[5]) & f1331M));
        iArr2[5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr2[6]) & f1331M) - (((long) iArr[6]) & f1331M));
        iArr2[6] = (int) j7;
        long j8 = (j7 >> 32) + ((((long) iArr2[7]) & f1331M) - (f1331M & ((long) iArr[7])));
        iArr2[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static int subFrom(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i2 + 0;
        long j = ((((long) iArr2[i3]) & f1331M) - (((long) iArr[i + 0]) & f1331M)) + 0;
        iArr2[i3] = (int) j;
        int i4 = i2 + 1;
        long j2 = (j >> 32) + ((((long) iArr2[i4]) & f1331M) - (((long) iArr[i + 1]) & f1331M));
        iArr2[i4] = (int) j2;
        int i5 = i2 + 2;
        long j3 = (j2 >> 32) + ((((long) iArr2[i5]) & f1331M) - (((long) iArr[i + 2]) & f1331M));
        iArr2[i5] = (int) j3;
        int i6 = i2 + 3;
        long j4 = (j3 >> 32) + ((((long) iArr2[i6]) & f1331M) - (((long) iArr[i + 3]) & f1331M));
        iArr2[i6] = (int) j4;
        int i7 = i2 + 4;
        long j5 = (j4 >> 32) + ((((long) iArr2[i7]) & f1331M) - (((long) iArr[i + 4]) & f1331M));
        iArr2[i7] = (int) j5;
        int i8 = i2 + 5;
        long j6 = (j5 >> 32) + ((((long) iArr2[i8]) & f1331M) - (((long) iArr[i + 5]) & f1331M));
        iArr2[i8] = (int) j6;
        int i9 = i2 + 6;
        long j7 = (j6 >> 32) + ((((long) iArr2[i9]) & f1331M) - (((long) iArr[i + 6]) & f1331M));
        iArr2[i9] = (int) j7;
        int i10 = i2 + 7;
        long j8 = (j7 >> 32) + ((((long) iArr2[i10]) & f1331M) - (((long) iArr[i + 7]) & f1331M));
        iArr2[i10] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 8; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.intToBigEndian(i2, bArr, (7 - i) << 2);
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
        iArr[6] = 0;
        iArr[7] = 0;
    }
}
