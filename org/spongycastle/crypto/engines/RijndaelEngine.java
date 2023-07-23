package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Array;
import okio.Utf8;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.crypto.tls.CipherSuite;

public class RijndaelEngine implements BlockCipher {
    private static final int MAXKC = 64;
    private static final int MAXROUNDS = 14;

    /* renamed from: S */
    private static final byte[] f1002S = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, -52, 52, -91, -27, -15, 113, -40, 49, Ascii.NAK, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, Ascii.DC2, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, Ascii.SUB, Ascii.ESC, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, 16, -1, -13, -46, -51, Ascii.f271FF, 19, -20, 95, -105, 68, Ascii.ETB, -60, -89, 126, 61, 100, 93, Ascii.f270EM, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, Ascii.DC4, -34, 94, Ascii.f282VT, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, Ascii.f272FS, -90, -76, -58, -24, -35, 116, Ascii.f281US, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, Ascii.f279SO, 97, 53, 87, -71, -122, -63, Ascii.f273GS, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, Ascii.f277RS, -121, -23, -50, 85, 40, -33, -116, -95, -119, Ascii.f269CR, -65, -26, 66, 104, 65, -103, 45, Ascii.f278SI, -80, 84, -69, Ascii.SYN};

    /* renamed from: Si */
    private static final byte[] f1003Si = {82, 9, 106, -43, 48, 54, -91, 56, -65, SignedBytes.MAX_POWER_OF_TWO, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, Ascii.f282VT, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, Ascii.SYN, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, Ascii.NAK, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, Ascii.f277RS, -113, -54, Utf8.REPLACEMENT_BYTE, Ascii.f278SI, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, Ascii.f272FS, 117, -33, 110, 71, -15, Ascii.SUB, 113, Ascii.f273GS, 41, -59, -119, 111, -73, 98, Ascii.f279SO, -86, Ascii.CAN, -66, Ascii.ESC, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, Ascii.f281US, -35, -88, 51, -120, 7, -57, 49, -79, Ascii.DC2, 16, 89, 39, Byte.MIN_VALUE, -20, 95, 96, 81, Byte.MAX_VALUE, -87, Ascii.f270EM, -75, 74, Ascii.f269CR, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, Ascii.ETB, 43, 4, 126, -70, 119, -42, 38, -31, 105, Ascii.DC4, 99, 85, 33, Ascii.f271FF, 125};
    private static final byte[] aLogtable = {0, 3, 5, Ascii.f278SI, 17, 51, 85, -1, Ascii.SUB, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, Ascii.f277RS, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, Ascii.f271FF, Ascii.DC4, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, Ascii.CAN, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, Byte.MAX_VALUE, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, 16, 48, 80, -16, Ascii.f282VT, Ascii.f273GS, 39, 105, -69, -42, 97, -93, -2, Ascii.f270EM, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, Ascii.SYN, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, Ascii.NAK, Utf8.REPLACEMENT_BYTE, 65, -61, 94, -30, 61, 71, -55, SignedBytes.MAX_POWER_OF_TWO, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, Byte.MIN_VALUE, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, Ascii.f281US, 33, 99, -91, -12, 7, 9, Ascii.ESC, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, Ascii.f279SO, Ascii.DC2, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, Ascii.f269CR, Ascii.ETB, 57, 75, -35, 124, -124, -105, -94, -3, Ascii.f272FS, 36, 108, -76, -57, 82, -10, 1, 3, 5, Ascii.f278SI, 17, 51, 85, -1, Ascii.SUB, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, Ascii.f277RS, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, Ascii.f271FF, Ascii.DC4, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, Ascii.CAN, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, Byte.MAX_VALUE, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, 16, 48, 80, -16, Ascii.f282VT, Ascii.f273GS, 39, 105, -69, -42, 97, -93, -2, Ascii.f270EM, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, Ascii.SYN, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, Ascii.NAK, Utf8.REPLACEMENT_BYTE, 65, -61, 94, -30, 61, 71, -55, SignedBytes.MAX_POWER_OF_TWO, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, Byte.MIN_VALUE, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, Ascii.f281US, 33, 99, -91, -12, 7, 9, Ascii.ESC, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, Ascii.f279SO, Ascii.DC2, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, Ascii.f269CR, Ascii.ETB, 57, 75, -35, 124, -124, -105, -94, -3, Ascii.f272FS, 36, 108, -76, -57, 82, -10, 1};
    private static final byte[] logtable = {0, 0, Ascii.f270EM, 1, 50, 2, Ascii.SUB, -58, 75, -57, Ascii.ESC, 104, 51, -18, -33, 3, 100, 4, -32, Ascii.f279SO, 52, -115, -127, -17, 76, 113, 8, -56, -8, 105, Ascii.f272FS, -63, 125, -62, Ascii.f273GS, -75, -7, -71, 39, 106, 77, -28, -90, 114, -102, -55, 9, 120, 101, 47, -118, 5, 33, Ascii.f278SI, -31, 36, Ascii.DC2, -16, -126, 69, 53, -109, -38, -114, -106, -113, -37, -67, 54, -48, -50, -108, 19, 92, -46, -15, SignedBytes.MAX_POWER_OF_TWO, 70, -125, 56, 102, -35, -3, 48, -65, 6, -117, 98, -77, 37, -30, -104, 34, -120, -111, 16, 126, 110, 72, -61, -93, -74, Ascii.f277RS, 66, 58, 107, 40, 84, -6, -123, 61, -70, 43, 121, 10, Ascii.NAK, -101, -97, 94, -54, 78, -44, -84, -27, -13, 115, -89, 87, -81, 88, -88, 80, -12, -22, -42, 116, 79, -82, -23, -43, -25, -26, -83, -24, 44, -41, 117, 122, -21, Ascii.SYN, Ascii.f282VT, -11, 89, -53, 95, -80, -100, -87, 81, -96, Byte.MAX_VALUE, Ascii.f271FF, -10, 111, Ascii.ETB, -60, 73, -20, -40, 67, Ascii.f281US, 45, -92, 118, 123, -73, -52, -69, 62, 90, -5, 96, -79, -122, 59, 82, -95, 108, -86, 85, 41, -99, -105, -78, -121, -112, 97, -66, -36, -4, PSSSigner.TRAILER_IMPLICIT, -107, -49, -51, 55, Utf8.REPLACEMENT_BYTE, 91, -47, 83, 57, -124, 60, 65, -94, 109, 71, Ascii.DC4, 42, -98, 93, 86, -14, -45, -85, 68, 17, -110, -39, 35, 32, 46, -119, -76, 124, -72, 38, 119, -103, -29, -91, 103, 74, -19, -34, -59, 49, -2, Ascii.CAN, Ascii.f269CR, 99, -116, Byte.MIN_VALUE, -64, -9, 112, 7};
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 77, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 47, 94, 188, 99, 198, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, 53, 106, 212, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, 125, 250, 239, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA};
    static byte[][] shifts0 = {new byte[]{0, 8, 16, Ascii.CAN}, new byte[]{0, 8, 16, Ascii.CAN}, new byte[]{0, 8, 16, Ascii.CAN}, new byte[]{0, 8, 16, 32}, new byte[]{0, 8, Ascii.CAN, 32}};
    static byte[][] shifts1 = {new byte[]{0, Ascii.CAN, 16, 8}, new byte[]{0, 32, Ascii.CAN, 16}, new byte[]{0, 40, 32, Ascii.CAN}, new byte[]{0, 48, 40, Ascii.CAN}, new byte[]{0, 56, 40, 32}};

    /* renamed from: A0 */
    private long f1004A0;

    /* renamed from: A1 */
    private long f1005A1;

    /* renamed from: A2 */
    private long f1006A2;

    /* renamed from: A3 */
    private long f1007A3;

    /* renamed from: BC */
    private int f1008BC;
    private long BC_MASK;
    private int ROUNDS;
    private int blockBits;
    private boolean forEncryption;
    private byte[] shifts0SC;
    private byte[] shifts1SC;
    private long[][] workingKey;

    public String getAlgorithmName() {
        return "Rijndael";
    }

    public void reset() {
    }

    private byte mul0x2(int i) {
        if (i != 0) {
            return aLogtable[(logtable[i] & 255) + Ascii.f270EM];
        }
        return 0;
    }

    private byte mul0x3(int i) {
        if (i != 0) {
            return aLogtable[(logtable[i] & 255) + 1];
        }
        return 0;
    }

    private byte mul0x9(int i) {
        if (i >= 0) {
            return aLogtable[i + 199];
        }
        return 0;
    }

    private byte mul0xb(int i) {
        if (i >= 0) {
            return aLogtable[i + 104];
        }
        return 0;
    }

    private byte mul0xd(int i) {
        if (i >= 0) {
            return aLogtable[i + 238];
        }
        return 0;
    }

    private byte mul0xe(int i) {
        if (i >= 0) {
            return aLogtable[i + 223];
        }
        return 0;
    }

    private void KeyAddition(long[] jArr) {
        this.f1004A0 ^= jArr[0];
        this.f1005A1 ^= jArr[1];
        this.f1006A2 ^= jArr[2];
        this.f1007A3 ^= jArr[3];
    }

    private long shift(long j, int i) {
        return ((j << (this.f1008BC - i)) | (j >>> i)) & this.BC_MASK;
    }

    private void ShiftRow(byte[] bArr) {
        this.f1005A1 = shift(this.f1005A1, bArr[1]);
        this.f1006A2 = shift(this.f1006A2, bArr[2]);
        this.f1007A3 = shift(this.f1007A3, bArr[3]);
    }

    private long applyS(long j, byte[] bArr) {
        long j2 = 0;
        for (int i = 0; i < this.f1008BC; i += 8) {
            j2 |= ((long) (bArr[(int) ((j >> i) & 255)] & 255)) << i;
        }
        return j2;
    }

    private void Substitution(byte[] bArr) {
        this.f1004A0 = applyS(this.f1004A0, bArr);
        this.f1005A1 = applyS(this.f1005A1, bArr);
        this.f1006A2 = applyS(this.f1006A2, bArr);
        this.f1007A3 = applyS(this.f1007A3, bArr);
    }

    private void MixColumn() {
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        for (int i = 0; i < this.f1008BC; i += 8) {
            int i2 = (int) ((this.f1004A0 >> i) & 255);
            int i3 = (int) ((this.f1005A1 >> i) & 255);
            int i4 = (int) ((this.f1006A2 >> i) & 255);
            int i5 = (int) ((this.f1007A3 >> i) & 255);
            j |= ((long) ((((mul0x2(i2) ^ mul0x3(i3)) ^ i4) ^ i5) & 255)) << i;
            j2 |= ((long) ((((mul0x2(i3) ^ mul0x3(i4)) ^ i5) ^ i2) & 255)) << i;
            j3 |= ((long) ((((mul0x2(i4) ^ mul0x3(i5)) ^ i2) ^ i3) & 255)) << i;
            j4 |= ((long) ((((mul0x2(i5) ^ mul0x3(i2)) ^ i3) ^ i4) & 255)) << i;
        }
        this.f1004A0 = j;
        this.f1005A1 = j2;
        this.f1006A2 = j3;
        this.f1007A3 = j4;
    }

    private void InvMixColumn() {
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        for (int i = 0; i < this.f1008BC; i += 8) {
            int i2 = (int) ((this.f1004A0 >> i) & 255);
            int i3 = (int) ((this.f1005A1 >> i) & 255);
            int i4 = (int) ((this.f1006A2 >> i) & 255);
            long j5 = j4;
            int i5 = (int) ((this.f1007A3 >> i) & 255);
            byte b = -1;
            byte b2 = i2 != 0 ? logtable[i2 & 255] & 255 : -1;
            byte b3 = i3 != 0 ? logtable[i3 & 255] & 255 : -1;
            byte b4 = i4 != 0 ? logtable[i4 & 255] & 255 : -1;
            if (i5 != 0) {
                b = logtable[i5 & 255] & 255;
            }
            j |= ((long) ((((mul0xe(b2) ^ mul0xb(b3)) ^ mul0xd(b4)) ^ mul0x9(b)) & 255)) << i;
            j2 |= ((long) ((((mul0xe(b3) ^ mul0xb(b4)) ^ mul0xd(b)) ^ mul0x9(b2)) & 255)) << i;
            j3 |= ((long) ((((mul0xe(b4) ^ mul0xb(b)) ^ mul0xd(b2)) ^ mul0x9(b3)) & 255)) << i;
            j4 = j5 | (((long) ((((mul0xe(b) ^ mul0xb(b2)) ^ mul0xd(b3)) ^ mul0x9(b4)) & 255)) << i);
        }
        this.f1004A0 = j;
        this.f1005A1 = j2;
        this.f1006A2 = j3;
        this.f1007A3 = j4;
    }

    private long[][] generateWorkingKey(byte[] bArr) {
        int i;
        int i2;
        byte[] bArr2 = bArr;
        int i3 = 8;
        int length = bArr2.length * 8;
        byte[][] bArr3 = (byte[][]) Array.newInstance(byte.class, new int[]{4, 64});
        long[][] jArr = (long[][]) Array.newInstance(long.class, new int[]{15, 4});
        int i4 = 4;
        if (length == 128) {
            i = 4;
        } else if (length == 160) {
            i = 5;
        } else if (length == 192) {
            i = 6;
        } else if (length == 224) {
            i = 7;
        } else if (length == 256) {
            i = 8;
        } else {
            throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
        }
        if (length >= this.blockBits) {
            this.ROUNDS = i + 6;
        } else {
            this.ROUNDS = (this.f1008BC / 8) + 6;
        }
        char c = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < bArr2.length) {
            bArr3[i5 % 4][i5 / 4] = bArr2[i6];
            i5++;
            i6++;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < i && i8 < (this.ROUNDS + 1) * (this.f1008BC / 8)) {
            int i9 = 0;
            while (i9 < i4) {
                int i10 = this.f1008BC;
                long[] jArr2 = jArr[i8 / (i10 / 8)];
                jArr2[i9] = (((long) (bArr3[i9][i7] & 255)) << ((i8 * 8) % i10)) | jArr2[i9];
                i9++;
                i4 = 4;
            }
            i7++;
            i8++;
            i4 = 4;
        }
        int i11 = 0;
        while (i8 < (this.ROUNDS + 1) * (this.f1008BC / i3)) {
            int i12 = 0;
            while (i12 < 4) {
                byte[] bArr4 = bArr3[i12];
                i12++;
                bArr4[c] = (byte) (bArr4[c] ^ f1002S[bArr3[i12 % 4][i - 1] & 255]);
            }
            byte[] bArr5 = bArr3[c];
            int i13 = i11 + 1;
            bArr5[c] = (byte) (rcon[i11] ^ bArr5[c]);
            if (i <= 6) {
                for (int i14 = 1; i14 < i; i14++) {
                    for (int i15 = 0; i15 < 4; i15++) {
                        byte[] bArr6 = bArr3[i15];
                        bArr6[i14] = (byte) (bArr6[i14] ^ bArr3[i15][i14 - 1]);
                    }
                }
            } else {
                int i16 = 1;
                while (true) {
                    i2 = 4;
                    if (i16 >= 4) {
                        break;
                    }
                    int i17 = 0;
                    while (i17 < i2) {
                        byte[] bArr7 = bArr3[i17];
                        bArr7[i16] = (byte) (bArr7[i16] ^ bArr3[i17][i16 - 1]);
                        i17++;
                        i2 = 4;
                    }
                    i16++;
                }
                for (int i18 = 0; i18 < 4; i18++) {
                    byte[] bArr8 = bArr3[i18];
                    bArr8[4] = (byte) (bArr8[4] ^ f1002S[bArr3[i18][3] & 255]);
                }
                int i19 = 5;
                while (i19 < i) {
                    int i20 = 0;
                    while (i20 < i2) {
                        byte[] bArr9 = bArr3[i20];
                        bArr9[i19] = (byte) (bArr9[i19] ^ bArr3[i20][i19 - 1]);
                        i20++;
                        i2 = 4;
                    }
                    i19++;
                    i2 = 4;
                }
            }
            int i21 = 0;
            while (i21 < i && i8 < (this.ROUNDS + 1) * (this.f1008BC / i3)) {
                for (int i22 = 0; i22 < 4; i22++) {
                    int i23 = this.f1008BC;
                    long[] jArr3 = jArr[i8 / (i23 / 8)];
                    jArr3[i22] = (((long) (bArr3[i22][i21] & 255)) << ((i8 * 8) % i23)) | jArr3[i22];
                }
                i21++;
                i8++;
                i3 = 8;
            }
            i11 = i13;
            c = 0;
            i3 = 8;
        }
        return jArr;
    }

    public RijndaelEngine() {
        this(128);
    }

    public RijndaelEngine(int i) {
        if (i == 128) {
            this.f1008BC = 32;
            this.BC_MASK = 4294967295L;
            this.shifts0SC = shifts0[0];
            this.shifts1SC = shifts1[0];
        } else if (i == 160) {
            this.f1008BC = 40;
            this.BC_MASK = 1099511627775L;
            this.shifts0SC = shifts0[1];
            this.shifts1SC = shifts1[1];
        } else if (i == 192) {
            this.f1008BC = 48;
            this.BC_MASK = 281474976710655L;
            this.shifts0SC = shifts0[2];
            this.shifts1SC = shifts1[2];
        } else if (i == 224) {
            this.f1008BC = 56;
            this.BC_MASK = 72057594037927935L;
            this.shifts0SC = shifts0[3];
            this.shifts1SC = shifts1[3];
        } else if (i == 256) {
            this.f1008BC = 64;
            this.BC_MASK = -1;
            this.shifts0SC = shifts0[4];
            this.shifts1SC = shifts1[4];
        } else {
            throw new IllegalArgumentException("unknown blocksize to Rijndael");
        }
        this.blockBits = i;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey());
            this.forEncryption = z;
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to Rijndael init - " + cipherParameters.getClass().getName());
    }

    public int getBlockSize() {
        return this.f1008BC / 2;
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.workingKey != null) {
            int i3 = this.f1008BC;
            if ((i3 / 2) + i > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if ((i3 / 2) + i2 <= bArr2.length) {
                if (this.forEncryption) {
                    unpackBlock(bArr, i);
                    encryptBlock(this.workingKey);
                    packBlock(bArr2, i2);
                } else {
                    unpackBlock(bArr, i);
                    decryptBlock(this.workingKey);
                    packBlock(bArr2, i2);
                }
                return this.f1008BC / 2;
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else {
            throw new IllegalStateException("Rijndael engine not initialised");
        }
    }

    private void unpackBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        this.f1004A0 = (long) (bArr[i] & 255);
        int i3 = i2 + 1;
        this.f1005A1 = (long) (bArr[i2] & 255);
        int i4 = i3 + 1;
        this.f1006A2 = (long) (bArr[i3] & 255);
        int i5 = i4 + 1;
        this.f1007A3 = (long) (bArr[i4] & 255);
        for (int i6 = 8; i6 != this.f1008BC; i6 += 8) {
            int i7 = i5 + 1;
            this.f1004A0 |= ((long) (bArr[i5] & 255)) << i6;
            int i8 = i7 + 1;
            this.f1005A1 |= ((long) (bArr[i7] & 255)) << i6;
            int i9 = i8 + 1;
            this.f1006A2 |= ((long) (bArr[i8] & 255)) << i6;
            i5 = i9 + 1;
            this.f1007A3 |= ((long) (bArr[i9] & 255)) << i6;
        }
    }

    private void packBlock(byte[] bArr, int i) {
        for (int i2 = 0; i2 != this.f1008BC; i2 += 8) {
            int i3 = i + 1;
            bArr[i] = (byte) ((int) (this.f1004A0 >> i2));
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((int) (this.f1005A1 >> i2));
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((int) (this.f1006A2 >> i2));
            i = i5 + 1;
            bArr[i5] = (byte) ((int) (this.f1007A3 >> i2));
        }
    }

    private void encryptBlock(long[][] jArr) {
        KeyAddition(jArr[0]);
        for (int i = 1; i < this.ROUNDS; i++) {
            Substitution(f1002S);
            ShiftRow(this.shifts0SC);
            MixColumn();
            KeyAddition(jArr[i]);
        }
        Substitution(f1002S);
        ShiftRow(this.shifts0SC);
        KeyAddition(jArr[this.ROUNDS]);
    }

    private void decryptBlock(long[][] jArr) {
        KeyAddition(jArr[this.ROUNDS]);
        Substitution(f1003Si);
        ShiftRow(this.shifts1SC);
        for (int i = this.ROUNDS - 1; i > 0; i--) {
            KeyAddition(jArr[i]);
            InvMixColumn();
            Substitution(f1003Si);
            ShiftRow(this.shifts1SC);
        }
        KeyAddition(jArr[0]);
    }
}
