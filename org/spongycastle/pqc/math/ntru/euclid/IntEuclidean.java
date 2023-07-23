package org.spongycastle.pqc.math.ntru.euclid;

public class IntEuclidean {
    public int gcd;

    /* renamed from: x */
    public int f1505x;

    /* renamed from: y */
    public int f1506y;

    private IntEuclidean() {
    }

    public static IntEuclidean calculate(int i, int i2) {
        int i3 = 1;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        int i7 = i2;
        int i8 = i;
        int i9 = i7;
        while (i9 != 0) {
            int i10 = i8 / i9;
            int i11 = i8 % i9;
            i8 = i9;
            i9 = i11;
            int i12 = i4;
            i4 = i3 - (i10 * i4);
            i3 = i12;
            int i13 = i6 - (i10 * i5);
            i6 = i5;
            i5 = i13;
        }
        IntEuclidean intEuclidean = new IntEuclidean();
        intEuclidean.f1505x = i3;
        intEuclidean.f1506y = i6;
        intEuclidean.gcd = i8;
        return intEuclidean;
    }
}
