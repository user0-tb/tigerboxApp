package org.spongycastle.cert.selector;

import com.google.common.base.Ascii;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.util.Pack;

class MSOutlookKeyIdCalculator {
    MSOutlookKeyIdCalculator() {
    }

    static byte[] calculateKeyId(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        SHA1Digest sHA1Digest = new SHA1Digest();
        byte[] bArr = new byte[sHA1Digest.getDigestSize()];
        try {
            byte[] encoded = subjectPublicKeyInfo.getEncoded(ASN1Encoding.DER);
            sHA1Digest.update(encoded, 0, encoded.length);
            sHA1Digest.doFinal(bArr, 0);
            return bArr;
        } catch (IOException unused) {
            return new byte[0];
        }
    }

    private static abstract class GeneralDigest {
        private static final int BYTE_LENGTH = 64;
        private long byteCount;
        private byte[] xBuf;
        private int xBufOff;

        /* access modifiers changed from: protected */
        public abstract void processBlock();

        /* access modifiers changed from: protected */
        public abstract void processLength(long j);

        /* access modifiers changed from: protected */
        public abstract void processWord(byte[] bArr, int i);

        protected GeneralDigest() {
            this.xBuf = new byte[4];
            this.xBufOff = 0;
        }

        protected GeneralDigest(GeneralDigest generalDigest) {
            this.xBuf = new byte[generalDigest.xBuf.length];
            copyIn(generalDigest);
        }

        /* access modifiers changed from: protected */
        public void copyIn(GeneralDigest generalDigest) {
            byte[] bArr = generalDigest.xBuf;
            System.arraycopy(bArr, 0, this.xBuf, 0, bArr.length);
            this.xBufOff = generalDigest.xBufOff;
            this.byteCount = generalDigest.byteCount;
        }

        public void update(byte b) {
            byte[] bArr = this.xBuf;
            int i = this.xBufOff;
            int i2 = i + 1;
            this.xBufOff = i2;
            bArr[i] = b;
            if (i2 == bArr.length) {
                processWord(bArr, 0);
                this.xBufOff = 0;
            }
            this.byteCount++;
        }

        public void update(byte[] bArr, int i, int i2) {
            while (this.xBufOff != 0 && i2 > 0) {
                update(bArr[i]);
                i++;
                i2--;
            }
            while (i2 > this.xBuf.length) {
                processWord(bArr, i);
                byte[] bArr2 = this.xBuf;
                i += bArr2.length;
                i2 -= bArr2.length;
                this.byteCount += (long) bArr2.length;
            }
            while (i2 > 0) {
                update(bArr[i]);
                i++;
                i2--;
            }
        }

        public void finish() {
            long j = this.byteCount << 3;
            update(Byte.MIN_VALUE);
            while (this.xBufOff != 0) {
                update((byte) 0);
            }
            processLength(j);
            processBlock();
        }

        public void reset() {
            this.byteCount = 0;
            this.xBufOff = 0;
            int i = 0;
            while (true) {
                byte[] bArr = this.xBuf;
                if (i < bArr.length) {
                    bArr[i] = 0;
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static class SHA1Digest extends GeneralDigest {
        private static final int DIGEST_LENGTH = 20;

        /* renamed from: Y1 */
        private static final int f759Y1 = 1518500249;

        /* renamed from: Y2 */
        private static final int f760Y2 = 1859775393;

        /* renamed from: Y3 */
        private static final int f761Y3 = -1894007588;

        /* renamed from: Y4 */
        private static final int f762Y4 = -899497514;

        /* renamed from: H1 */
        private int f763H1;

        /* renamed from: H2 */
        private int f764H2;

        /* renamed from: H3 */
        private int f765H3;

        /* renamed from: H4 */
        private int f766H4;

        /* renamed from: H5 */
        private int f767H5;

        /* renamed from: X */
        private int[] f768X = new int[80];
        private int xOff;

        /* renamed from: f */
        private int m534f(int i, int i2, int i3) {
            return ((~i) & i3) | (i2 & i);
        }

        /* renamed from: g */
        private int m535g(int i, int i2, int i3) {
            return (i & i3) | (i & i2) | (i2 & i3);
        }

        /* renamed from: h */
        private int m536h(int i, int i2, int i3) {
            return (i ^ i2) ^ i3;
        }

        public String getAlgorithmName() {
            return "SHA-1";
        }

        public int getDigestSize() {
            return 20;
        }

        public SHA1Digest() {
            reset();
        }

        /* access modifiers changed from: protected */
        public void processWord(byte[] bArr, int i) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
            int[] iArr = this.f768X;
            int i5 = this.xOff;
            iArr[i5] = i4;
            int i6 = i5 + 1;
            this.xOff = i6;
            if (i6 == 16) {
                processBlock();
            }
        }

        /* access modifiers changed from: protected */
        public void processLength(long j) {
            if (this.xOff > 14) {
                processBlock();
            }
            int[] iArr = this.f768X;
            iArr[14] = (int) (j >>> 32);
            iArr[15] = (int) (j & -1);
        }

        public int doFinal(byte[] bArr, int i) {
            finish();
            Pack.intToBigEndian(this.f763H1, bArr, i);
            Pack.intToBigEndian(this.f764H2, bArr, i + 4);
            Pack.intToBigEndian(this.f765H3, bArr, i + 8);
            Pack.intToBigEndian(this.f766H4, bArr, i + 12);
            Pack.intToBigEndian(this.f767H5, bArr, i + 16);
            reset();
            return 20;
        }

        public void reset() {
            super.reset();
            this.f763H1 = 1732584193;
            this.f764H2 = -271733879;
            this.f765H3 = -1732584194;
            this.f766H4 = 271733878;
            this.f767H5 = -1009589776;
            this.xOff = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.f768X;
                if (i != iArr.length) {
                    iArr[i] = 0;
                    i++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: protected */
        public void processBlock() {
            for (int i = 16; i < 80; i++) {
                int[] iArr = this.f768X;
                int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
                iArr[i] = (i2 >>> 31) | (i2 << 1);
            }
            int i3 = this.f763H1;
            int i4 = this.f764H2;
            int i5 = this.f765H3;
            int i6 = this.f766H4;
            int i7 = this.f767H5;
            int i8 = 0;
            int i9 = 0;
            while (i8 < 4) {
                int i10 = i9 + 1;
                int f = i7 + ((i3 << 5) | (i3 >>> 27)) + m534f(i4, i5, i6) + this.f768X[i9] + f759Y1;
                int i11 = (i4 >>> 2) | (i4 << 30);
                int i12 = i10 + 1;
                int f2 = i6 + ((f << 5) | (f >>> 27)) + m534f(i3, i11, i5) + this.f768X[i10] + f759Y1;
                int i13 = (i3 >>> 2) | (i3 << 30);
                int i14 = i12 + 1;
                int f3 = i5 + ((f2 << 5) | (f2 >>> 27)) + m534f(f, i13, i11) + this.f768X[i12] + f759Y1;
                i7 = (f >>> 2) | (f << 30);
                int i15 = i14 + 1;
                i4 = i11 + ((f3 << 5) | (f3 >>> 27)) + m534f(f2, i7, i13) + this.f768X[i14] + f759Y1;
                i6 = (f2 >>> 2) | (f2 << 30);
                i3 = i13 + ((i4 << 5) | (i4 >>> 27)) + m534f(f3, i6, i7) + this.f768X[i15] + f759Y1;
                i5 = (f3 >>> 2) | (f3 << 30);
                i8++;
                i9 = i15 + 1;
            }
            int i16 = 0;
            while (i16 < 4) {
                int i17 = i9 + 1;
                int h = i7 + ((i3 << 5) | (i3 >>> 27)) + m536h(i4, i5, i6) + this.f768X[i9] + f760Y2;
                int i18 = (i4 >>> 2) | (i4 << 30);
                int i19 = i17 + 1;
                int h2 = i6 + ((h << 5) | (h >>> 27)) + m536h(i3, i18, i5) + this.f768X[i17] + f760Y2;
                int i20 = (i3 >>> 2) | (i3 << 30);
                int i21 = i19 + 1;
                int h3 = i5 + ((h2 << 5) | (h2 >>> 27)) + m536h(h, i20, i18) + this.f768X[i19] + f760Y2;
                i7 = (h >>> 2) | (h << 30);
                int i22 = i21 + 1;
                i4 = i18 + ((h3 << 5) | (h3 >>> 27)) + m536h(h2, i7, i20) + this.f768X[i21] + f760Y2;
                i6 = (h2 >>> 2) | (h2 << 30);
                i3 = i20 + ((i4 << 5) | (i4 >>> 27)) + m536h(h3, i6, i7) + this.f768X[i22] + f760Y2;
                i5 = (h3 >>> 2) | (h3 << 30);
                i16++;
                i9 = i22 + 1;
            }
            int i23 = 0;
            while (i23 < 4) {
                int i24 = i9 + 1;
                int g = i7 + ((i3 << 5) | (i3 >>> 27)) + m535g(i4, i5, i6) + this.f768X[i9] + f761Y3;
                int i25 = (i4 >>> 2) | (i4 << 30);
                int i26 = i24 + 1;
                int g2 = i6 + ((g << 5) | (g >>> 27)) + m535g(i3, i25, i5) + this.f768X[i24] + f761Y3;
                int i27 = (i3 >>> 2) | (i3 << 30);
                int i28 = i26 + 1;
                int g3 = i5 + ((g2 << 5) | (g2 >>> 27)) + m535g(g, i27, i25) + this.f768X[i26] + f761Y3;
                i7 = (g >>> 2) | (g << 30);
                int i29 = i28 + 1;
                i4 = i25 + ((g3 << 5) | (g3 >>> 27)) + m535g(g2, i7, i27) + this.f768X[i28] + f761Y3;
                i6 = (g2 >>> 2) | (g2 << 30);
                i3 = i27 + ((i4 << 5) | (i4 >>> 27)) + m535g(g3, i6, i7) + this.f768X[i29] + f761Y3;
                i5 = (g3 >>> 2) | (g3 << 30);
                i23++;
                i9 = i29 + 1;
            }
            int i30 = 0;
            while (i30 <= 3) {
                int i31 = i9 + 1;
                int h4 = i7 + ((i3 << 5) | (i3 >>> 27)) + m536h(i4, i5, i6) + this.f768X[i9] + f762Y4;
                int i32 = (i4 >>> 2) | (i4 << 30);
                int i33 = i31 + 1;
                int h5 = i6 + ((h4 << 5) | (h4 >>> 27)) + m536h(i3, i32, i5) + this.f768X[i31] + f762Y4;
                int i34 = (i3 >>> 2) | (i3 << 30);
                int i35 = i33 + 1;
                int h6 = i5 + ((h5 << 5) | (h5 >>> 27)) + m536h(h4, i34, i32) + this.f768X[i33] + f762Y4;
                i7 = (h4 >>> 2) | (h4 << 30);
                int i36 = i35 + 1;
                i4 = i32 + ((h6 << 5) | (h6 >>> 27)) + m536h(h5, i7, i34) + this.f768X[i35] + f762Y4;
                i6 = (h5 >>> 2) | (h5 << 30);
                i3 = i34 + ((i4 << 5) | (i4 >>> 27)) + m536h(h6, i6, i7) + this.f768X[i36] + f762Y4;
                i5 = (h6 >>> 2) | (h6 << 30);
                i30++;
                i9 = i36 + 1;
            }
            this.f763H1 += i3;
            this.f764H2 += i4;
            this.f765H3 += i5;
            this.f766H4 += i6;
            this.f767H5 += i7;
            this.xOff = 0;
            for (int i37 = 0; i37 < 16; i37++) {
                this.f768X[i37] = 0;
            }
        }
    }
}
