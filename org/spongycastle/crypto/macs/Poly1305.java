package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;

public class Poly1305 implements Mac {
    private static final int BLOCK_SIZE = 16;
    private final BlockCipher cipher;
    private final byte[] currentBlock;
    private int currentBlockOffset;

    /* renamed from: h0 */
    private int f1047h0;

    /* renamed from: h1 */
    private int f1048h1;

    /* renamed from: h2 */
    private int f1049h2;

    /* renamed from: h3 */
    private int f1050h3;

    /* renamed from: h4 */
    private int f1051h4;

    /* renamed from: k0 */
    private int f1052k0;

    /* renamed from: k1 */
    private int f1053k1;

    /* renamed from: k2 */
    private int f1054k2;

    /* renamed from: k3 */
    private int f1055k3;

    /* renamed from: r0 */
    private int f1056r0;

    /* renamed from: r1 */
    private int f1057r1;

    /* renamed from: r2 */
    private int f1058r2;

    /* renamed from: r3 */
    private int f1059r3;

    /* renamed from: r4 */
    private int f1060r4;

    /* renamed from: s1 */
    private int f1061s1;

    /* renamed from: s2 */
    private int f1062s2;

    /* renamed from: s3 */
    private int f1063s3;

    /* renamed from: s4 */
    private int f1064s4;
    private final byte[] singleByte;

    private static final long mul32x32_64(int i, int i2) {
        return ((long) i) * ((long) i2);
    }

    public int getMacSize() {
        return 16;
    }

    public Poly1305() {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        this.cipher = null;
    }

    public Poly1305(BlockCipher blockCipher) {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        if (blockCipher.getBlockSize() == 16) {
            this.cipher = blockCipher;
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] bArr;
        if (this.cipher == null) {
            bArr = null;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
        }
        if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey(), bArr);
            reset();
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a key.");
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        if (this.cipher == null || (bArr2 != null && bArr2.length == 16)) {
            Poly1305KeyGenerator.checkKey(bArr);
            int littleEndianToInt = Pack.littleEndianToInt(bArr, 16);
            int littleEndianToInt2 = Pack.littleEndianToInt(bArr, 20);
            int littleEndianToInt3 = Pack.littleEndianToInt(bArr, 24);
            int littleEndianToInt4 = Pack.littleEndianToInt(bArr, 28);
            this.f1056r0 = 67108863 & littleEndianToInt;
            int i = ((littleEndianToInt >>> 26) | (littleEndianToInt2 << 6)) & 67108611;
            this.f1057r1 = i;
            int i2 = ((littleEndianToInt2 >>> 20) | (littleEndianToInt3 << 12)) & 67092735;
            this.f1058r2 = i2;
            int i3 = ((littleEndianToInt3 >>> 14) | (littleEndianToInt4 << 18)) & 66076671;
            this.f1059r3 = i3;
            int i4 = (littleEndianToInt4 >>> 8) & 1048575;
            this.f1060r4 = i4;
            this.f1061s1 = i * 5;
            this.f1062s2 = i2 * 5;
            this.f1063s3 = i3 * 5;
            this.f1064s4 = i4 * 5;
            BlockCipher blockCipher = this.cipher;
            if (blockCipher != null) {
                byte[] bArr3 = new byte[16];
                blockCipher.init(true, new KeyParameter(bArr, 0, 16));
                this.cipher.processBlock(bArr2, 0, bArr3, 0);
                bArr = bArr3;
            }
            this.f1052k0 = Pack.littleEndianToInt(bArr, 0);
            this.f1053k1 = Pack.littleEndianToInt(bArr, 4);
            this.f1054k2 = Pack.littleEndianToInt(bArr, 8);
            this.f1055k3 = Pack.littleEndianToInt(bArr, 12);
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
    }

    public String getAlgorithmName() {
        if (this.cipher == null) {
            return "Poly1305";
        }
        return "Poly1305-" + this.cipher.getAlgorithmName();
    }

    public void update(byte b) throws IllegalStateException {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        update(bArr, 0, 1);
    }

    public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        int i3 = 0;
        while (i2 > i3) {
            if (this.currentBlockOffset == 16) {
                processBlock();
                this.currentBlockOffset = 0;
            }
            int min = Math.min(i2 - i3, 16 - this.currentBlockOffset);
            System.arraycopy(bArr, i3 + i, this.currentBlock, this.currentBlockOffset, min);
            i3 += min;
            this.currentBlockOffset += min;
        }
    }

    private void processBlock() {
        int i = this.currentBlockOffset;
        if (i < 16) {
            this.currentBlock[i] = 1;
            for (int i2 = i + 1; i2 < 16; i2++) {
                this.currentBlock[i2] = 0;
            }
        }
        long littleEndianToInt = ((long) Pack.littleEndianToInt(this.currentBlock, 0)) & 4294967295L;
        long littleEndianToInt2 = ((long) Pack.littleEndianToInt(this.currentBlock, 4)) & 4294967295L;
        long littleEndianToInt3 = ((long) Pack.littleEndianToInt(this.currentBlock, 8)) & 4294967295L;
        long littleEndianToInt4 = 4294967295L & ((long) Pack.littleEndianToInt(this.currentBlock, 12));
        int i3 = (int) (((long) this.f1047h0) + (littleEndianToInt & 67108863));
        this.f1047h0 = i3;
        this.f1048h1 = (int) (((long) this.f1048h1) + ((((littleEndianToInt2 << 32) | littleEndianToInt) >>> 26) & 67108863));
        this.f1049h2 = (int) (((long) this.f1049h2) + (((littleEndianToInt2 | (littleEndianToInt3 << 32)) >>> 20) & 67108863));
        this.f1050h3 = (int) (((long) this.f1050h3) + ((((littleEndianToInt4 << 32) | littleEndianToInt3) >>> 14) & 67108863));
        int i4 = (int) (((long) this.f1051h4) + (littleEndianToInt4 >>> 8));
        this.f1051h4 = i4;
        if (this.currentBlockOffset == 16) {
            this.f1051h4 = i4 + 16777216;
        }
        long mul32x32_64 = mul32x32_64(i3, this.f1056r0) + mul32x32_64(this.f1048h1, this.f1064s4) + mul32x32_64(this.f1049h2, this.f1063s3) + mul32x32_64(this.f1050h3, this.f1062s2) + mul32x32_64(this.f1051h4, this.f1061s1);
        long mul32x32_642 = mul32x32_64(this.f1047h0, this.f1057r1) + mul32x32_64(this.f1048h1, this.f1056r0) + mul32x32_64(this.f1049h2, this.f1064s4) + mul32x32_64(this.f1050h3, this.f1063s3) + mul32x32_64(this.f1051h4, this.f1062s2);
        long mul32x32_643 = mul32x32_64(this.f1047h0, this.f1058r2) + mul32x32_64(this.f1048h1, this.f1057r1) + mul32x32_64(this.f1049h2, this.f1056r0) + mul32x32_64(this.f1050h3, this.f1064s4) + mul32x32_64(this.f1051h4, this.f1063s3);
        long mul32x32_644 = mul32x32_64(this.f1047h0, this.f1059r3) + mul32x32_64(this.f1048h1, this.f1058r2) + mul32x32_64(this.f1049h2, this.f1057r1) + mul32x32_64(this.f1050h3, this.f1056r0) + mul32x32_64(this.f1051h4, this.f1064s4);
        long mul32x32_645 = mul32x32_64(this.f1047h0, this.f1060r4) + mul32x32_64(this.f1048h1, this.f1059r3) + mul32x32_64(this.f1049h2, this.f1058r2) + mul32x32_64(this.f1050h3, this.f1057r1) + mul32x32_64(this.f1051h4, this.f1056r0);
        int i5 = ((int) mul32x32_64) & 67108863;
        this.f1047h0 = i5;
        long j = mul32x32_642 + (mul32x32_64 >>> 26);
        this.f1048h1 = ((int) j) & 67108863;
        long j2 = mul32x32_643 + ((j >>> 26) & -1);
        this.f1049h2 = ((int) j2) & 67108863;
        long j3 = mul32x32_644 + ((j2 >>> 26) & -1);
        this.f1050h3 = ((int) j3) & 67108863;
        long j4 = mul32x32_645 + (j3 >>> 26);
        this.f1051h4 = ((int) j4) & 67108863;
        this.f1047h0 = (int) (((long) i5) + ((j4 >>> 26) * 5));
    }

    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        if (i + 16 <= bArr.length) {
            if (this.currentBlockOffset > 0) {
                processBlock();
            }
            int i2 = this.f1047h0;
            int i3 = i2 >>> 26;
            int i4 = i2 & 67108863;
            this.f1047h0 = i4;
            int i5 = this.f1048h1 + i3;
            this.f1048h1 = i5;
            int i6 = i5 >>> 26;
            int i7 = i5 & 67108863;
            this.f1048h1 = i7;
            int i8 = this.f1049h2 + i6;
            this.f1049h2 = i8;
            int i9 = i8 >>> 26;
            int i10 = i8 & 67108863;
            this.f1049h2 = i10;
            int i11 = this.f1050h3 + i9;
            this.f1050h3 = i11;
            int i12 = i11 >>> 26;
            int i13 = i11 & 67108863;
            this.f1050h3 = i13;
            int i14 = this.f1051h4 + i12;
            this.f1051h4 = i14;
            int i15 = i14 >>> 26;
            int i16 = i14 & 67108863;
            this.f1051h4 = i16;
            int i17 = i4 + (i15 * 5);
            this.f1047h0 = i17;
            int i18 = i17 + 5;
            int i19 = (i18 >>> 26) + i7;
            int i20 = (i19 >>> 26) + i10;
            int i21 = (i20 >>> 26) + i13;
            int i22 = 67108863 & i21;
            int i23 = ((i21 >>> 26) + i16) - 67108864;
            int i24 = (i23 >>> 31) - 1;
            int i25 = ~i24;
            int i26 = (i17 & i25) | (i18 & 67108863 & i24);
            this.f1047h0 = i26;
            int i27 = (i7 & i25) | (i19 & 67108863 & i24);
            this.f1048h1 = i27;
            int i28 = (i10 & i25) | (i20 & 67108863 & i24);
            this.f1049h2 = i28;
            int i29 = (i22 & i24) | (i13 & i25);
            this.f1050h3 = i29;
            int i30 = (i16 & i25) | (i23 & i24);
            this.f1051h4 = i30;
            long j = (((long) (i26 | (i27 << 26))) & 4294967295L) + (((long) this.f1052k0) & 4294967295L);
            long j2 = (((long) ((i27 >>> 6) | (i28 << 20))) & 4294967295L) + (((long) this.f1053k1) & 4294967295L);
            long j3 = (((long) ((i28 >>> 12) | (i29 << 14))) & 4294967295L) + (((long) this.f1054k2) & 4294967295L);
            Pack.intToLittleEndian((int) j, bArr, i);
            long j4 = j2 + (j >>> 32);
            Pack.intToLittleEndian((int) j4, bArr, i + 4);
            long j5 = j3 + (j4 >>> 32);
            Pack.intToLittleEndian((int) j5, bArr, i + 8);
            Pack.intToLittleEndian((int) ((((long) ((i29 >>> 18) | (i30 << 8))) & 4294967295L) + (4294967295L & ((long) this.f1055k3)) + (j5 >>> 32)), bArr, i + 12);
            reset();
            return 16;
        }
        throw new DataLengthException("Output buffer is too short.");
    }

    public void reset() {
        this.currentBlockOffset = 0;
        this.f1051h4 = 0;
        this.f1050h3 = 0;
        this.f1049h2 = 0;
        this.f1048h1 = 0;
        this.f1047h0 = 0;
    }
}
