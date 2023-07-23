package org.spongycastle.math.p030ec.custom.sec;

import com.google.android.exoplayer2.RendererCapabilities;
import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat384;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecP384R1Field */
public class SecP384R1Field {

    /* renamed from: M */
    private static final long f1315M = 4294967295L;

    /* renamed from: P */
    static final int[] f1316P = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};
    private static final int P11 = -1;
    static final int[] PExt = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};
    private static final int PExt23 = -1;
    private static final int[] PExtInv = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && Nat.gte(12, iArr3, f1316P))) {
            addPInvTo(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(24, iArr, iArr2, iArr3) != 0 || (iArr3[23] == -1 && Nat.gte(24, iArr3, PExt))) {
            int[] iArr4 = PExtInv;
            if (Nat.addTo(iArr4.length, iArr4, iArr3) != 0) {
                Nat.incAt(24, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (Nat.inc(12, iArr, iArr2) != 0 || (iArr2[11] == -1 && Nat.gte(12, iArr2, f1316P))) {
            addPInvTo(iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat.fromBigInteger(RendererCapabilities.MODE_SUPPORT_MASK, bigInteger);
        if (fromBigInteger[11] == -1) {
            int[] iArr = f1316P;
            if (Nat.gte(12, fromBigInteger, iArr)) {
                Nat.subFrom(12, iArr, fromBigInteger);
            }
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            Nat.shiftDownBit(12, iArr, 0, iArr2);
        } else {
            Nat.shiftDownBit(12, iArr2, Nat.add(12, iArr, f1316P, iArr2));
        }
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = Nat.create(24);
        Nat384.mul(iArr, iArr2, create);
        reduce(create, iArr3);
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (Nat.isZero(12, iArr)) {
            Nat.zero(12, iArr2);
        } else {
            Nat.sub(12, f1316P, iArr, iArr2);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[16]) & f1315M;
        long j2 = ((long) iArr[17]) & f1315M;
        long j3 = ((long) iArr[18]) & f1315M;
        long j4 = ((long) iArr[19]) & f1315M;
        long j5 = ((long) iArr[20]) & f1315M;
        long j6 = ((long) iArr[21]) & f1315M;
        long j7 = j4;
        long j8 = ((long) iArr[22]) & f1315M;
        long j9 = j3;
        long j10 = ((long) iArr[23]) & f1315M;
        long j11 = j;
        long j12 = ((((long) iArr[12]) & f1315M) + j5) - 1;
        long j13 = j5;
        long j14 = (((long) iArr[13]) & f1315M) + j8;
        long j15 = (((long) iArr[14]) & f1315M) + j8 + j10;
        long j16 = (((long) iArr[15]) & f1315M) + j10;
        long j17 = j2 + j6;
        long j18 = j6 - j10;
        long j19 = j8 - j10;
        long j20 = (((long) iArr[0]) & f1315M) + j12 + j18 + 0;
        iArr3[0] = (int) j20;
        long j21 = (j20 >> 32) + (((((long) iArr[1]) & f1315M) + j10) - j12) + j14;
        iArr3[1] = (int) j21;
        long j22 = (j21 >> 32) + (((((long) iArr[2]) & f1315M) - j6) - j14) + j15;
        iArr3[2] = (int) j22;
        long j23 = (j22 >> 32) + (((((long) iArr[3]) & f1315M) + j12) - j15) + j16 + j18;
        iArr3[3] = (int) j23;
        long j24 = (j23 >> 32) + ((((((((long) iArr[4]) & f1315M) + j11) + j6) + j12) + j14) - j16) + j18;
        iArr3[4] = (int) j24;
        long j25 = (j24 >> 32) + ((((long) iArr[5]) & f1315M) - j11) + j14 + j15 + j17;
        iArr3[5] = (int) j25;
        long j26 = (j25 >> 32) + (((((long) iArr[6]) & f1315M) + j9) - j2) + j15 + j16;
        iArr3[6] = (int) j26;
        long j27 = (j26 >> 32) + ((((((long) iArr[7]) & f1315M) + j11) + j7) - j9) + j16;
        iArr3[7] = (int) j27;
        long j28 = (j27 >> 32) + (((((((long) iArr[8]) & f1315M) + j11) + j2) + j13) - j7);
        iArr3[8] = (int) j28;
        long j29 = (j28 >> 32) + (((((long) iArr[9]) & f1315M) + j9) - j13) + j17;
        iArr3[9] = (int) j29;
        long j30 = (j29 >> 32) + ((((((long) iArr[10]) & f1315M) + j9) + j7) - j18) + j19;
        iArr3[10] = (int) j30;
        long j31 = (j30 >> 32) + ((((((long) iArr[11]) & f1315M) + j7) + j13) - j19);
        iArr3[11] = (int) j31;
        reduce32((int) ((j31 >> 32) + 1), iArr3);
    }

    public static void reduce32(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = ((long) i) & f1315M;
            long j3 = (((long) iArr[0]) & f1315M) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = (j3 >> 32) + ((((long) iArr[1]) & f1315M) - j2);
            iArr[1] = (int) j4;
            long j5 = j4 >> 32;
            if (j5 != 0) {
                long j6 = j5 + (((long) iArr[2]) & f1315M);
                iArr[2] = (int) j6;
                j5 = j6 >> 32;
            }
            long j7 = j5 + (((long) iArr[3]) & f1315M) + j2;
            iArr[3] = (int) j7;
            long j8 = (j7 >> 32) + (f1315M & ((long) iArr[4])) + j2;
            iArr[4] = (int) j8;
            j = j8 >> 32;
        } else {
            j = 0;
        }
        if ((j != 0 && Nat.incAt(12, iArr, 5) != 0) || (iArr[11] == -1 && Nat.gte(12, iArr, f1316P))) {
            addPInvTo(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] create = Nat.create(24);
        Nat384.square(iArr, create);
        reduce(create, iArr2);
    }

    public static void squareN(int[] iArr, int i, int[] iArr2) {
        int[] create = Nat.create(24);
        Nat384.square(iArr, create);
        reduce(create, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat384.square(iArr2, create);
                reduce(create, iArr2);
            } else {
                return;
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(12, iArr, iArr2, iArr3) != 0) {
            subPInvFrom(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(24, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = PExtInv;
            if (Nat.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                Nat.decAt(24, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (Nat.shiftUpBit(12, iArr, 0, iArr2) != 0 || (iArr2[11] == -1 && Nat.gte(12, iArr2, f1316P))) {
            addPInvTo(iArr2);
        }
    }

    private static void addPInvTo(int[] iArr) {
        long j = (((long) iArr[0]) & f1315M) + 1;
        iArr[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & f1315M) - 1);
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (((long) iArr[2]) & f1315M);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = j3 + (((long) iArr[3]) & f1315M) + 1;
        iArr[3] = (int) j5;
        long j6 = (j5 >> 32) + (f1315M & ((long) iArr[4])) + 1;
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            Nat.incAt(12, iArr, 5);
        }
    }

    private static void subPInvFrom(int[] iArr) {
        long j = (((long) iArr[0]) & f1315M) - 1;
        iArr[0] = (int) j;
        long j2 = (j >> 32) + (((long) iArr[1]) & f1315M) + 1;
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (((long) iArr[2]) & f1315M);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = j3 + ((((long) iArr[3]) & f1315M) - 1);
        iArr[3] = (int) j5;
        long j6 = (j5 >> 32) + ((f1315M & ((long) iArr[4])) - 1);
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            Nat.decAt(12, iArr, 5);
        }
    }
}
