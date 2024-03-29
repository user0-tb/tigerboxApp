package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.mac.internal.AesUtil;
import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Immutable
public final class PrfAesCmac implements Prf {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private final SecretKey keySpec;
    private byte[] subKey1;
    private byte[] subKey2;

    private static Cipher instance() throws GeneralSecurityException {
        if (FIPS.isCompatible()) {
            return EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    public PrfAesCmac(byte[] bArr) throws GeneralSecurityException {
        Validators.validateAesKeySize(bArr.length);
        this.keySpec = new SecretKeySpec(bArr, "AES");
        generateSubKeys();
    }

    public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArr2;
        if (i <= 16) {
            Cipher instance = instance();
            instance.init(1, this.keySpec);
            int max = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
            if (max * 16 == bArr.length) {
                bArr2 = Bytes.xor(bArr, (max - 1) * 16, this.subKey1, 0, 16);
            } else {
                bArr2 = Bytes.xor(AesUtil.cmacPad(Arrays.copyOfRange(bArr, (max - 1) * 16, bArr.length)), this.subKey2);
            }
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < max - 1; i2++) {
                bArr3 = instance.doFinal(Bytes.xor(bArr3, 0, bArr, i2 * 16, 16));
            }
            return Arrays.copyOf(instance.doFinal(Bytes.xor(bArr2, bArr3)), i);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }

    private void generateSubKeys() throws GeneralSecurityException {
        Cipher instance = instance();
        instance.init(1, this.keySpec);
        byte[] dbl = AesUtil.dbl(instance.doFinal(new byte[16]));
        this.subKey1 = dbl;
        this.subKey2 = AesUtil.dbl(dbl);
    }
}
