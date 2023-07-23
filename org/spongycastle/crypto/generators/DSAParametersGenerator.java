package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.DSAParameterGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAValidationParameters;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.encoders.Hex;

public class DSAParametersGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger ZERO = BigInteger.valueOf(0);

    /* renamed from: L */
    private int f1031L;

    /* renamed from: N */
    private int f1032N;
    private int certainty;
    private Digest digest;
    private SecureRandom random;
    private int usageIndex;
    private boolean use186_3;

    private static int getDefaultN(int i) {
        if (i > 1024) {
            return 256;
        }
        return CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256;
    }

    public DSAParametersGenerator() {
        this(new SHA1Digest());
    }

    public DSAParametersGenerator(Digest digest2) {
        this.digest = digest2;
    }

    public void init(int i, int i2, SecureRandom secureRandom) {
        this.use186_3 = false;
        this.f1031L = i;
        this.f1032N = getDefaultN(i);
        this.certainty = i2;
        this.random = secureRandom;
    }

    public void init(DSAParameterGenerationParameters dSAParameterGenerationParameters) {
        int i;
        this.use186_3 = true;
        this.f1031L = dSAParameterGenerationParameters.getL();
        this.f1032N = dSAParameterGenerationParameters.getN();
        this.certainty = dSAParameterGenerationParameters.getCertainty();
        this.random = dSAParameterGenerationParameters.getRandom();
        this.usageIndex = dSAParameterGenerationParameters.getUsageIndex();
        int i2 = this.f1031L;
        if (i2 < 1024 || i2 > 3072 || i2 % 1024 != 0) {
            throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
        } else if (i2 == 1024 && this.f1032N != 160) {
            throw new IllegalArgumentException("N must be 160 for L = 1024");
        } else if (i2 == 2048 && (i = this.f1032N) != 224 && i != 256) {
            throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
        } else if (i2 == 3072 && this.f1032N != 256) {
            throw new IllegalArgumentException("N must be 256 for L = 3072");
        } else if (this.digest.getDigestSize() * 8 < this.f1032N) {
            throw new IllegalStateException("Digest output size too small for value of N");
        }
    }

    public DSAParameters generateParameters() {
        return this.use186_3 ? generateParameters_FIPS186_3() : generateParameters_FIPS186_2();
    }

    private DSAParameters generateParameters_FIPS186_2() {
        int i = 20;
        byte[] bArr = new byte[20];
        byte[] bArr2 = new byte[20];
        byte[] bArr3 = new byte[20];
        byte[] bArr4 = new byte[20];
        int i2 = this.f1031L;
        int i3 = (i2 - 1) / CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256;
        int i4 = i2 / 8;
        byte[] bArr5 = new byte[i4];
        if (this.digest instanceof SHA1Digest) {
            while (true) {
                this.random.nextBytes(bArr);
                hash(this.digest, bArr, bArr2);
                System.arraycopy(bArr, 0, bArr3, 0, i);
                inc(bArr3);
                hash(this.digest, bArr3, bArr3);
                for (int i5 = 0; i5 != i; i5++) {
                    bArr4[i5] = (byte) (bArr2[i5] ^ bArr3[i5]);
                }
                bArr4[0] = (byte) (bArr4[0] | Byte.MIN_VALUE);
                bArr4[19] = (byte) (bArr4[19] | 1);
                BigInteger bigInteger = new BigInteger(1, bArr4);
                if (bigInteger.isProbablePrime(this.certainty)) {
                    byte[] clone = Arrays.clone(bArr);
                    inc(clone);
                    int i6 = 0;
                    while (i6 < 4096) {
                        int i7 = 0;
                        while (i7 < i3) {
                            inc(clone);
                            hash(this.digest, clone, bArr2);
                            i7++;
                            System.arraycopy(bArr2, 0, bArr5, i4 - (i7 * 20), i);
                        }
                        inc(clone);
                        hash(this.digest, clone, bArr2);
                        int i8 = i4 - (i3 * 20);
                        System.arraycopy(bArr2, 20 - i8, bArr5, 0, i8);
                        bArr5[0] = (byte) (bArr5[0] | Byte.MIN_VALUE);
                        BigInteger bigInteger2 = new BigInteger(1, bArr5);
                        BigInteger subtract = bigInteger2.subtract(bigInteger2.mod(bigInteger.shiftLeft(1)).subtract(ONE));
                        if (subtract.bitLength() == this.f1031L && subtract.isProbablePrime(this.certainty)) {
                            return new DSAParameters(subtract, bigInteger, calculateGenerator_FIPS186_2(subtract, bigInteger, this.random), new DSAValidationParameters(bArr, i6));
                        }
                        i6++;
                        i = 20;
                    }
                    continue;
                }
            }
        } else {
            throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
        }
    }

    private static BigInteger calculateGenerator_FIPS186_2(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger modPow;
        BigInteger divide = bigInteger.subtract(ONE).divide(bigInteger2);
        BigInteger subtract = bigInteger.subtract(TWO);
        do {
            modPow = BigIntegers.createRandomInRange(TWO, subtract, secureRandom).modPow(divide, bigInteger);
        } while (modPow.bitLength() <= 1);
        return modPow;
    }

    private DSAParameters generateParameters_FIPS186_3() {
        BigInteger subtract;
        int i;
        BigInteger subtract2;
        BigInteger calculateGenerator_FIPS186_3_Verifiable;
        Digest digest2 = this.digest;
        int digestSize = digest2.getDigestSize() * 8;
        byte[] bArr = new byte[(this.f1032N / 8)];
        int i2 = this.f1031L;
        int i3 = (i2 - 1) / digestSize;
        int i4 = 1;
        int i5 = (i2 - 1) % digestSize;
        byte[] bArr2 = new byte[digest2.getDigestSize()];
        loop0:
        while (true) {
            this.random.nextBytes(bArr);
            hash(digest2, bArr, bArr2);
            BigInteger bigInteger = new BigInteger(i4, bArr2);
            BigInteger bigInteger2 = ONE;
            BigInteger mod = bigInteger.mod(bigInteger2.shiftLeft(this.f1032N - i4));
            subtract = bigInteger2.shiftLeft(this.f1032N - i4).add(mod).add(bigInteger2).subtract(mod.mod(TWO));
            if (subtract.isProbablePrime(this.certainty)) {
                byte[] clone = Arrays.clone(bArr);
                int i6 = this.f1031L * 4;
                i = 0;
                while (i < i6) {
                    BigInteger bigInteger3 = ZERO;
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 <= i3) {
                        inc(clone);
                        hash(digest2, clone, bArr2);
                        BigInteger bigInteger4 = new BigInteger(i4, bArr2);
                        if (i7 == i3) {
                            bigInteger4 = bigInteger4.mod(ONE.shiftLeft(i5));
                        }
                        bigInteger3 = bigInteger3.add(bigInteger4.shiftLeft(i8));
                        i7++;
                        i8 += digestSize;
                        i4 = 1;
                    }
                    BigInteger bigInteger5 = ONE;
                    BigInteger add = bigInteger3.add(bigInteger5.shiftLeft(this.f1031L - 1));
                    subtract2 = add.subtract(add.mod(subtract.shiftLeft(1)).subtract(bigInteger5));
                    if (subtract2.bitLength() == this.f1031L && subtract2.isProbablePrime(this.certainty)) {
                        break loop0;
                    }
                    i++;
                    i4 = 1;
                }
                continue;
            }
        }
        int i9 = this.usageIndex;
        if (i9 < 0 || (calculateGenerator_FIPS186_3_Verifiable = calculateGenerator_FIPS186_3_Verifiable(digest2, subtract2, subtract, bArr, i9)) == null) {
            return new DSAParameters(subtract2, subtract, calculateGenerator_FIPS186_3_Unverifiable(subtract2, subtract, this.random), new DSAValidationParameters(bArr, i));
        }
        return new DSAParameters(subtract2, subtract, calculateGenerator_FIPS186_3_Verifiable, new DSAValidationParameters(bArr, i, this.usageIndex));
    }

    private static BigInteger calculateGenerator_FIPS186_3_Unverifiable(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return calculateGenerator_FIPS186_2(bigInteger, bigInteger2, secureRandom);
    }

    private static BigInteger calculateGenerator_FIPS186_3_Verifiable(Digest digest2, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, int i) {
        BigInteger divide = bigInteger.subtract(ONE).divide(bigInteger2);
        byte[] decode = Hex.decode("6767656E");
        int length = bArr.length + decode.length + 1 + 2;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(decode, 0, bArr2, bArr.length, decode.length);
        bArr2[length - 3] = (byte) i;
        byte[] bArr3 = new byte[digest2.getDigestSize()];
        for (int i2 = 1; i2 < 65536; i2++) {
            inc(bArr2);
            hash(digest2, bArr2, bArr3);
            BigInteger modPow = new BigInteger(1, bArr3).modPow(divide, bigInteger);
            if (modPow.compareTo(TWO) >= 0) {
                return modPow;
            }
        }
        return null;
    }

    private static void hash(Digest digest2, byte[] bArr, byte[] bArr2) {
        digest2.update(bArr, 0, bArr.length);
        digest2.doFinal(bArr2, 0);
    }

    private static void inc(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0) {
            byte b = (byte) ((bArr[length] + 1) & 255);
            bArr[length] = b;
            if (b == 0) {
                length--;
            } else {
                return;
            }
        }
    }
}
