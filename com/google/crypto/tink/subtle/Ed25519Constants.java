package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Ed25519;
import java.lang.reflect.Array;
import java.math.BigInteger;

final class Ed25519Constants {

    /* renamed from: B2 */
    static final Ed25519.CachedXYT[] f506B2 = new Ed25519.CachedXYT[8];
    static final Ed25519.CachedXYT[][] B_TABLE = ((Ed25519.CachedXYT[][]) Array.newInstance(Ed25519.CachedXYT.class, new int[]{32, 8}));

    /* renamed from: D */
    static final long[] f507D;

    /* renamed from: D2 */
    static final long[] f508D2;
    private static final BigInteger D2_BI;
    private static final BigInteger D_BI;
    private static final BigInteger P_BI;
    static final long[] SQRTM1;
    private static final BigInteger SQRTM1_BI;

    static {
        BigInteger subtract = BigInteger.valueOf(2).pow(255).subtract(BigInteger.valueOf(19));
        P_BI = subtract;
        BigInteger mod = BigInteger.valueOf(-121665).multiply(BigInteger.valueOf(121666).modInverse(subtract)).mod(subtract);
        D_BI = mod;
        BigInteger mod2 = BigInteger.valueOf(2).multiply(mod).mod(subtract);
        D2_BI = mod2;
        BigInteger modPow = BigInteger.valueOf(2).modPow(subtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4)), subtract);
        SQRTM1_BI = modPow;
        Point point = new Point();
        BigInteger unused = point.f510y = BigInteger.valueOf(4).multiply(BigInteger.valueOf(5).modInverse(subtract)).mod(subtract);
        BigInteger unused2 = point.f509x = recoverX(point.f510y);
        f507D = Field25519.expand(toLittleEndian(mod));
        f508D2 = Field25519.expand(toLittleEndian(mod2));
        SQRTM1 = Field25519.expand(toLittleEndian(modPow));
        Point point2 = point;
        for (int i = 0; i < 32; i++) {
            Point point3 = point2;
            for (int i2 = 0; i2 < 8; i2++) {
                B_TABLE[i][i2] = getCachedXYT(point3);
                point3 = edwards(point3, point2);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                point2 = edwards(point2, point2);
            }
        }
        Point edwards = edwards(point, point);
        for (int i4 = 0; i4 < 8; i4++) {
            f506B2[i4] = getCachedXYT(point);
            point = edwards(point, edwards);
        }
    }

    private static class Point {
        /* access modifiers changed from: private */

        /* renamed from: x */
        public BigInteger f509x;
        /* access modifiers changed from: private */

        /* renamed from: y */
        public BigInteger f510y;

        private Point() {
        }
    }

    private static BigInteger recoverX(BigInteger bigInteger) {
        BigInteger subtract = bigInteger.pow(2).subtract(BigInteger.ONE);
        BigInteger add = D_BI.multiply(bigInteger.pow(2)).add(BigInteger.ONE);
        BigInteger bigInteger2 = P_BI;
        BigInteger multiply = subtract.multiply(add.modInverse(bigInteger2));
        BigInteger modPow = multiply.modPow(bigInteger2.add(BigInteger.valueOf(3)).divide(BigInteger.valueOf(8)), bigInteger2);
        if (!modPow.pow(2).subtract(multiply).mod(bigInteger2).equals(BigInteger.ZERO)) {
            modPow = modPow.multiply(SQRTM1_BI).mod(bigInteger2);
        }
        return modPow.testBit(0) ? bigInteger2.subtract(modPow) : modPow;
    }

    private static Point edwards(Point point, Point point2) {
        Point point3 = new Point();
        BigInteger multiply = D_BI.multiply(point.f509x.multiply(point2.f509x).multiply(point.f510y).multiply(point2.f510y));
        BigInteger bigInteger = P_BI;
        BigInteger mod = multiply.mod(bigInteger);
        BigInteger unused = point3.f509x = point.f509x.multiply(point2.f510y).add(point2.f509x.multiply(point.f510y)).multiply(BigInteger.ONE.add(mod).modInverse(bigInteger)).mod(bigInteger);
        BigInteger unused2 = point3.f510y = point.f510y.multiply(point2.f510y).add(point.f509x.multiply(point2.f509x)).multiply(BigInteger.ONE.subtract(mod).modInverse(bigInteger)).mod(bigInteger);
        return point3;
    }

    private static byte[] toLittleEndian(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            int i2 = (32 - i) - 1;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }

    private static Ed25519.CachedXYT getCachedXYT(Point point) {
        BigInteger add = point.f510y.add(point.f509x);
        BigInteger bigInteger = P_BI;
        return new Ed25519.CachedXYT(Field25519.expand(toLittleEndian(add.mod(bigInteger))), Field25519.expand(toLittleEndian(point.f510y.subtract(point.f509x).mod(bigInteger))), Field25519.expand(toLittleEndian(D2_BI.multiply(point.f509x).multiply(point.f510y).mod(bigInteger))));
    }

    private Ed25519Constants() {
    }
}
