package com.google.crypto.tink.subtle;

import com.google.common.base.Ascii;
import java.security.InvalidKeyException;
import java.util.Arrays;
import org.spongycastle.crypto.signers.PSSSigner;

final class Curve25519 {
    static final byte[][] BANNED_PUBLIC_KEYS = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-32, -21, 122, 124, 59, 65, -72, -82, Ascii.SYN, 86, -29, -6, -15, -97, -60, 106, -38, 9, -115, -21, -100, 50, -79, -3, -122, 98, 5, Ascii.SYN, 95, 73, -72, 0}, new byte[]{95, -100, -107, PSSSigner.TRAILER_IMPLICIT, -93, 80, -116, 36, -79, -48, -79, 85, -100, -125, -17, 91, 4, 68, 92, -60, 88, Ascii.f272FS, -114, -122, -40, 34, 78, -35, -48, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}};

    private static void monty(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5, long[] jArr6, long[] jArr7, long[] jArr8, long[] jArr9) {
        long[] jArr10 = jArr5;
        long[] jArr11 = jArr6;
        long[] jArr12 = jArr7;
        long[] jArr13 = jArr8;
        long[] copyOf = Arrays.copyOf(jArr10, 10);
        long[] jArr14 = new long[19];
        long[] jArr15 = new long[19];
        long[] jArr16 = new long[19];
        long[] jArr17 = new long[19];
        long[] jArr18 = new long[19];
        long[] jArr19 = new long[19];
        long[] jArr20 = new long[19];
        Field25519.sum(jArr5, jArr6);
        Field25519.sub(jArr11, copyOf);
        long[] copyOf2 = Arrays.copyOf(jArr12, 10);
        Field25519.sum(jArr7, jArr8);
        Field25519.sub(jArr13, copyOf2);
        Field25519.product(jArr17, jArr12, jArr11);
        Field25519.product(jArr18, jArr10, jArr13);
        Field25519.reduceSizeByModularReduction(jArr17);
        Field25519.reduceCoefficients(jArr17);
        Field25519.reduceSizeByModularReduction(jArr18);
        Field25519.reduceCoefficients(jArr18);
        System.arraycopy(jArr17, 0, copyOf2, 0, 10);
        Field25519.sum(jArr17, jArr18);
        Field25519.sub(jArr18, copyOf2);
        Field25519.square(jArr20, jArr17);
        Field25519.square(jArr19, jArr18);
        Field25519.product(jArr18, jArr19, jArr9);
        Field25519.reduceSizeByModularReduction(jArr18);
        Field25519.reduceCoefficients(jArr18);
        long[] jArr21 = jArr3;
        System.arraycopy(jArr20, 0, jArr3, 0, 10);
        System.arraycopy(jArr18, 0, jArr4, 0, 10);
        Field25519.square(jArr15, jArr10);
        Field25519.square(jArr16, jArr11);
        long[] jArr22 = jArr;
        Field25519.product(jArr, jArr15, jArr16);
        Field25519.reduceSizeByModularReduction(jArr);
        Field25519.reduceCoefficients(jArr);
        Field25519.sub(jArr16, jArr15);
        Arrays.fill(jArr14, 10, 18, 0);
        Field25519.scalarProduct(jArr14, jArr16, 121665);
        Field25519.reduceCoefficients(jArr14);
        Field25519.sum(jArr14, jArr15);
        long[] jArr23 = jArr2;
        Field25519.product(jArr2, jArr16, jArr14);
        Field25519.reduceSizeByModularReduction(jArr2);
        Field25519.reduceCoefficients(jArr2);
    }

    static void swapConditional(long[] jArr, long[] jArr2, int i) {
        int i2 = -i;
        for (int i3 = 0; i3 < 10; i3++) {
            int i4 = (((int) jArr2[i3]) ^ ((int) jArr[i3])) & i2;
            jArr[i3] = (long) (((int) jArr[i3]) ^ i4);
            jArr2[i3] = (long) (i4 ^ ((int) jArr2[i3]));
        }
    }

    static void copyConditional(long[] jArr, long[] jArr2, int i) {
        int i2 = -i;
        for (int i3 = 0; i3 < 10; i3++) {
            jArr[i3] = (long) (((((int) jArr2[i3]) ^ ((int) jArr[i3])) & i2) ^ ((int) jArr[i3]));
        }
    }

    static void curveMult(long[] jArr, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        long[] jArr2 = jArr;
        long[] expand = Field25519.expand(validatePubKeyAndClearMsb(bArr2));
        long[] jArr3 = new long[19];
        long[] jArr4 = new long[19];
        jArr4[0] = 1;
        long[] jArr5 = new long[19];
        jArr5[0] = 1;
        long[] jArr6 = new long[19];
        long[] jArr7 = new long[19];
        long[] jArr8 = new long[19];
        jArr8[0] = 1;
        long[] jArr9 = new long[19];
        long[] jArr10 = new long[19];
        jArr10[0] = 1;
        System.arraycopy(expand, 0, jArr3, 0, 10);
        int i = 0;
        while (i < 32) {
            byte b = bArr[(32 - i) - 1] & 255;
            long[] jArr11 = jArr7;
            long[] jArr12 = jArr8;
            long[] jArr13 = jArr3;
            long[] jArr14 = jArr4;
            long[] jArr15 = jArr9;
            int i2 = 0;
            long[] jArr16 = jArr10;
            long[] jArr17 = jArr6;
            long[] jArr18 = jArr5;
            long[] jArr19 = jArr17;
            while (i2 < 8) {
                int i3 = (b >> (7 - i2)) & 1;
                swapConditional(jArr18, jArr13, i3);
                swapConditional(jArr19, jArr14, i3);
                int i4 = i3;
                long[] jArr20 = jArr15;
                byte b2 = b;
                long[] jArr21 = jArr11;
                long[] jArr22 = jArr19;
                long[] jArr23 = jArr18;
                long[] jArr24 = jArr14;
                long[] jArr25 = jArr13;
                monty(jArr15, jArr16, jArr11, jArr12, jArr18, jArr19, jArr13, jArr14, expand);
                swapConditional(jArr20, jArr21, i4);
                long[] jArr26 = jArr12;
                swapConditional(jArr16, jArr26, i4);
                i2++;
                jArr14 = jArr26;
                jArr19 = jArr16;
                jArr18 = jArr20;
                jArr13 = jArr21;
                b = b2;
                jArr16 = jArr22;
                jArr15 = jArr23;
                jArr12 = jArr24;
                jArr11 = jArr25;
            }
            long[] jArr27 = jArr18;
            long[] jArr28 = jArr14;
            long[] jArr29 = jArr13;
            jArr8 = jArr12;
            i++;
            jArr10 = jArr16;
            jArr9 = jArr15;
            jArr7 = jArr11;
            jArr6 = jArr19;
            jArr5 = jArr27;
            jArr4 = jArr28;
            jArr3 = jArr29;
        }
        long[] jArr30 = new long[10];
        Field25519.inverse(jArr30, jArr6);
        Field25519.mult(jArr2, jArr5, jArr30);
        if (!isCollinear(expand, jArr2, jArr3, jArr4)) {
            throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: " + Hex.encode(bArr2));
        }
    }

    private static byte[] validatePubKeyAndClearMsb(byte[] bArr) throws InvalidKeyException {
        if (bArr.length == 32) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            copyOf[31] = (byte) (copyOf[31] & Byte.MAX_VALUE);
            int i = 0;
            while (true) {
                byte[][] bArr2 = BANNED_PUBLIC_KEYS;
                if (i >= bArr2.length) {
                    return copyOf;
                }
                if (!Bytes.equal(bArr2[i], copyOf)) {
                    i++;
                } else {
                    throw new InvalidKeyException("Banned public key: " + Hex.encode(bArr2[i]));
                }
            }
        } else {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
    }

    private static boolean isCollinear(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[11];
        long[] jArr8 = new long[11];
        long[] jArr9 = new long[11];
        Field25519.mult(jArr5, jArr, jArr2);
        Field25519.sum(jArr6, jArr, jArr2);
        long[] jArr10 = new long[10];
        jArr10[0] = 486662;
        Field25519.sum(jArr8, jArr6, jArr10);
        Field25519.mult(jArr8, jArr8, jArr4);
        Field25519.sum(jArr8, jArr3);
        Field25519.mult(jArr8, jArr8, jArr5);
        Field25519.mult(jArr8, jArr8, jArr3);
        Field25519.scalarProduct(jArr7, jArr8, 4);
        Field25519.reduceCoefficients(jArr7);
        Field25519.mult(jArr8, jArr5, jArr4);
        Field25519.sub(jArr8, jArr8, jArr4);
        Field25519.mult(jArr9, jArr6, jArr3);
        Field25519.sum(jArr8, jArr8, jArr9);
        Field25519.square(jArr8, jArr8);
        return Bytes.equal(Field25519.contract(jArr7), Field25519.contract(jArr8));
    }

    private Curve25519() {
    }
}
