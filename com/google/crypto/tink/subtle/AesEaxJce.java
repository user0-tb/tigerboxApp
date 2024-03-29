package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesEaxJce implements Aead {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int BLOCK_SIZE_IN_BYTES = 16;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    static final int TAG_SIZE_IN_BYTES = 16;
    private static final ThreadLocal<Cipher> localCtrCipher = new ThreadLocal<Cipher>() {
        /* access modifiers changed from: protected */
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };
    private static final ThreadLocal<Cipher> localEcbCipher = new ThreadLocal<Cipher>() {
        /* access modifiers changed from: protected */
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/ECB/NOPADDING");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };

    /* renamed from: b */
    private final byte[] f497b;
    private final int ivSizeInBytes;
    private final SecretKeySpec keySpec;

    /* renamed from: p */
    private final byte[] f498p;

    public AesEaxJce(byte[] bArr, int i) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        } else if (i == 12 || i == 16) {
            this.ivSizeInBytes = i;
            Validators.validateAesKeySize(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.keySpec = secretKeySpec;
            Cipher cipher = localEcbCipher.get();
            cipher.init(1, secretKeySpec);
            byte[] multiplyByX = multiplyByX(cipher.doFinal(new byte[16]));
            this.f497b = multiplyByX;
            this.f498p = multiplyByX(multiplyByX);
        } else {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
    }

    private static byte[] xor(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] multiplyByX(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i2 = i + 1;
            bArr2[i] = (byte) (((bArr[i] << 1) ^ ((bArr[i2] & 255) >>> 7)) & 255);
            i = i2;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    private byte[] pad(byte[] bArr) {
        if (bArr.length == 16) {
            return xor(bArr, this.f497b);
        }
        byte[] copyOf = Arrays.copyOf(this.f498p, 16);
        for (int i = 0; i < bArr.length; i++) {
            copyOf[i] = (byte) (copyOf[i] ^ bArr[i]);
        }
        copyOf[bArr.length] = (byte) (copyOf[bArr.length] ^ 128);
        return copyOf;
    }

    private byte[] omac(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(xor(bArr2, this.f497b));
        }
        byte[] doFinal = cipher.doFinal(bArr2);
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                doFinal[i5] = (byte) (doFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            doFinal = cipher.doFinal(doFinal);
            i4 += 16;
        }
        return cipher.doFinal(xor(doFinal, pad(Arrays.copyOfRange(bArr, i4 + i2, i2 + i3))));
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = bArr;
        int length = bArr3.length;
        int i = this.ivSizeInBytes;
        if (length <= (Integer.MAX_VALUE - i) - 16) {
            byte[] bArr4 = new byte[(bArr3.length + i + 16)];
            byte[] randBytes = Random.randBytes(i);
            System.arraycopy(randBytes, 0, bArr4, 0, this.ivSizeInBytes);
            Cipher cipher = localEcbCipher.get();
            cipher.init(1, this.keySpec);
            byte[] omac = omac(cipher, 0, randBytes, 0, randBytes.length);
            byte[] bArr5 = bArr2 == null ? new byte[0] : bArr2;
            byte[] omac2 = omac(cipher, 1, bArr5, 0, bArr5.length);
            Cipher cipher2 = localCtrCipher.get();
            cipher2.init(1, this.keySpec, new IvParameterSpec(omac));
            cipher2.doFinal(bArr, 0, bArr3.length, bArr4, this.ivSizeInBytes);
            byte[] omac3 = omac(cipher, 2, bArr4, this.ivSizeInBytes, bArr3.length);
            int length2 = bArr3.length + this.ivSizeInBytes;
            for (int i2 = 0; i2 < 16; i2++) {
                bArr4[length2 + i2] = (byte) ((omac2[i2] ^ omac[i2]) ^ omac3[i2]);
            }
            return bArr4;
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = (bArr.length - this.ivSizeInBytes) - 16;
        if (length >= 0) {
            Cipher cipher = localEcbCipher.get();
            cipher.init(1, this.keySpec);
            byte[] omac = omac(cipher, 0, bArr, 0, this.ivSizeInBytes);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] bArr3 = bArr2;
            byte[] omac2 = omac(cipher, 1, bArr3, 0, bArr3.length);
            byte[] omac3 = omac(cipher, 2, bArr, this.ivSizeInBytes, length);
            int length2 = bArr.length - 16;
            byte b = 0;
            for (int i = 0; i < 16; i++) {
                b = (byte) (b | (((bArr[length2 + i] ^ omac2[i]) ^ omac[i]) ^ omac3[i]));
            }
            if (b == 0) {
                Cipher cipher2 = localCtrCipher.get();
                cipher2.init(1, this.keySpec, new IvParameterSpec(omac));
                return cipher2.doFinal(bArr, this.ivSizeInBytes, length);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
