package org.spongycastle.pqc.crypto.gmss.util;

import java.lang.reflect.Array;
import org.spongycastle.crypto.Digest;

public class WinternitzOTSignature {
    private int checksumsize;
    private GMSSRandom gmssRandom;
    private int keysize;
    private int mdsize;
    private Digest messDigestOTS;
    private int messagesize;
    private byte[][] privateKeyOTS;

    /* renamed from: w */
    private int f1360w;

    public int getLog(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public WinternitzOTSignature(byte[] bArr, Digest digest, int i) {
        this.f1360w = i;
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        double d = (double) i;
        int ceil = (int) Math.ceil(((double) (digestSize << 3)) / d);
        this.messagesize = ceil;
        int log = getLog((ceil << i) + 1);
        this.checksumsize = log;
        int ceil2 = this.messagesize + ((int) Math.ceil(((double) log) / d));
        this.keysize = ceil2;
        int[] iArr = new int[2];
        iArr[1] = this.mdsize;
        iArr[0] = ceil2;
        this.privateKeyOTS = (byte[][]) Array.newInstance(byte.class, iArr);
        int i2 = this.mdsize;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        for (int i3 = 0; i3 < this.keysize; i3++) {
            this.privateKeyOTS[i3] = this.gmssRandom.nextSeed(bArr2);
        }
    }

    public byte[][] getPrivateKey() {
        return this.privateKeyOTS;
    }

    public byte[] getPublicKey() {
        int i = this.keysize;
        int i2 = this.mdsize;
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        byte[] bArr2 = new byte[i2];
        int i4 = 1 << this.f1360w;
        for (int i5 = 0; i5 < this.keysize; i5++) {
            Digest digest = this.messDigestOTS;
            byte[][] bArr3 = this.privateKeyOTS;
            digest.update(bArr3[i5], 0, bArr3[i5].length);
            byte[] bArr4 = new byte[this.messDigestOTS.getDigestSize()];
            this.messDigestOTS.doFinal(bArr4, 0);
            for (int i6 = 2; i6 < i4; i6++) {
                this.messDigestOTS.update(bArr4, 0, bArr4.length);
                bArr4 = new byte[this.messDigestOTS.getDigestSize()];
                this.messDigestOTS.doFinal(bArr4, 0);
            }
            int i7 = this.mdsize;
            System.arraycopy(bArr4, 0, bArr, i7 * i5, i7);
        }
        this.messDigestOTS.update(bArr, 0, i3);
        byte[] bArr5 = new byte[this.messDigestOTS.getDigestSize()];
        this.messDigestOTS.doFinal(bArr5, 0);
        return bArr5;
    }

    public byte[] getSignature(byte[] bArr) {
        int i;
        byte[] bArr2 = bArr;
        int i2 = this.keysize;
        int i3 = this.mdsize;
        byte[] bArr3 = new byte[(i2 * i3)];
        byte[] bArr4 = new byte[i3];
        this.messDigestOTS.update(bArr2, 0, bArr2.length);
        int digestSize = this.messDigestOTS.getDigestSize();
        byte[] bArr5 = new byte[digestSize];
        this.messDigestOTS.doFinal(bArr5, 0);
        int i4 = this.f1360w;
        int i5 = 8;
        if (8 % i4 == 0) {
            int i6 = 8 / i4;
            int i7 = (1 << i4) - 1;
            byte[] bArr6 = new byte[this.mdsize];
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < digestSize; i10++) {
                for (int i11 = 0; i11 < i6; i11++) {
                    int i12 = bArr5[i10] & i7;
                    i8 += i12;
                    System.arraycopy(this.privateKeyOTS[i9], 0, bArr6, 0, this.mdsize);
                    while (i12 > 0) {
                        this.messDigestOTS.update(bArr6, 0, bArr6.length);
                        bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr6, 0);
                        i12--;
                    }
                    int i13 = this.mdsize;
                    System.arraycopy(bArr6, 0, bArr3, i9 * i13, i13);
                    bArr5[i10] = (byte) (bArr5[i10] >>> this.f1360w);
                    i9++;
                }
            }
            int i14 = (this.messagesize << this.f1360w) - i8;
            int i15 = 0;
            while (i15 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i9], 0, bArr6, 0, this.mdsize);
                for (int i16 = i14 & i7; i16 > 0; i16--) {
                    this.messDigestOTS.update(bArr6, 0, bArr6.length);
                    bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr6, 0);
                }
                int i17 = this.mdsize;
                System.arraycopy(bArr6, 0, bArr3, i9 * i17, i17);
                int i18 = this.f1360w;
                i14 >>>= i18;
                i9++;
                i15 += i18;
            }
        } else if (i4 < 8) {
            int i19 = this.mdsize;
            int i20 = i19 / i4;
            int i21 = (1 << i4) - 1;
            byte[] bArr7 = new byte[i19];
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i22 < i20) {
                long j = 0;
                for (int i26 = 0; i26 < this.f1360w; i26++) {
                    j ^= (long) ((bArr5[i23] & 255) << (i26 << 3));
                    i23++;
                }
                int i27 = 0;
                while (i27 < i5) {
                    int i28 = i20;
                    int i29 = (int) (j & ((long) i21));
                    i25 += i29;
                    System.arraycopy(this.privateKeyOTS[i24], 0, bArr7, 0, this.mdsize);
                    while (i29 > 0) {
                        this.messDigestOTS.update(bArr7, 0, bArr7.length);
                        bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr7, 0);
                        i29--;
                    }
                    int i30 = this.mdsize;
                    System.arraycopy(bArr7, 0, bArr3, i24 * i30, i30);
                    j >>>= this.f1360w;
                    i24++;
                    i27++;
                    i20 = i28;
                    i5 = 8;
                }
                int i31 = i20;
                i22++;
                i5 = 8;
            }
            int i32 = this.mdsize % this.f1360w;
            int i33 = 0;
            long j2 = 0;
            while (i33 < i32) {
                j2 ^= (long) ((bArr5[i23] & 255) << (i33 << 3));
                i23++;
                i33++;
                i32 = i32;
            }
            int i34 = i32 << 3;
            int i35 = 0;
            while (i35 < i34) {
                int i36 = (int) (((long) i21) & j2);
                i25 += i36;
                System.arraycopy(this.privateKeyOTS[i24], 0, bArr7, 0, this.mdsize);
                while (i36 > 0) {
                    this.messDigestOTS.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr7, 0);
                    i36--;
                }
                int i37 = this.mdsize;
                System.arraycopy(bArr7, 0, bArr3, i24 * i37, i37);
                int i38 = this.f1360w;
                j2 >>>= i38;
                i24++;
                i35 += i38;
            }
            int i39 = (this.messagesize << this.f1360w) - i25;
            int i40 = 0;
            while (i40 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i24], 0, bArr7, 0, this.mdsize);
                for (int i41 = i39 & i21; i41 > 0; i41--) {
                    this.messDigestOTS.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr7, 0);
                }
                int i42 = this.mdsize;
                System.arraycopy(bArr7, 0, bArr3, i24 * i42, i42);
                int i43 = this.f1360w;
                i39 >>>= i43;
                i24++;
                i40 += i43;
            }
        } else if (i4 < 57) {
            int i44 = this.mdsize;
            int i45 = (i44 << 3) - i4;
            int i46 = (1 << i4) - 1;
            byte[] bArr8 = new byte[i44];
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            while (i48 <= i45) {
                int i50 = i48 % 8;
                i48 += this.f1360w;
                int i51 = (i48 + 7) >>> 3;
                int i52 = 0;
                long j3 = 0;
                for (int i53 = i48 >>> 3; i53 < i51; i53++) {
                    j3 ^= (long) ((bArr5[i53] & 255) << (i52 << 3));
                    i52++;
                }
                long j4 = (j3 >>> i50) & ((long) i46);
                i47 = (int) (((long) i47) + j4);
                System.arraycopy(this.privateKeyOTS[i49], 0, bArr8, 0, this.mdsize);
                while (j4 > 0) {
                    this.messDigestOTS.update(bArr8, 0, bArr8.length);
                    bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr8, 0);
                    j4--;
                }
                int i54 = this.mdsize;
                System.arraycopy(bArr8, 0, bArr3, i49 * i54, i54);
                i49++;
            }
            int i55 = i48 >>> 3;
            if (i55 < this.mdsize) {
                int i56 = i48 % 8;
                int i57 = 0;
                long j5 = 0;
                while (true) {
                    i = this.mdsize;
                    if (i55 >= i) {
                        break;
                    }
                    j5 ^= (long) ((bArr5[i55] & 255) << (i57 << 3));
                    i57++;
                    i55++;
                }
                long j6 = (j5 >>> i56) & ((long) i46);
                i47 = (int) (((long) i47) + j6);
                System.arraycopy(this.privateKeyOTS[i49], 0, bArr8, 0, i);
                while (j6 > 0) {
                    this.messDigestOTS.update(bArr8, 0, bArr8.length);
                    bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr8, 0);
                    j6--;
                }
                int i58 = this.mdsize;
                System.arraycopy(bArr8, 0, bArr3, i49 * i58, i58);
                i49++;
            }
            int i59 = (this.messagesize << this.f1360w) - i47;
            int i60 = i49;
            int i61 = 0;
            while (i61 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i60], 0, bArr8, 0, this.mdsize);
                for (long j7 = (long) (i59 & i46); j7 > 0; j7--) {
                    this.messDigestOTS.update(bArr8, 0, bArr8.length);
                    bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr8, 0);
                }
                int i62 = this.mdsize;
                System.arraycopy(bArr8, 0, bArr3, i60 * i62, i62);
                int i63 = this.f1360w;
                i59 >>>= i63;
                i60++;
                i61 += i63;
            }
        }
        return bArr3;
    }
}
