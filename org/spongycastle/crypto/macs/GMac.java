package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class GMac implements Mac {
    private final GCMBlockCipher cipher;
    private final int macSizeBits;

    public GMac(GCMBlockCipher gCMBlockCipher) {
        this.cipher = gCMBlockCipher;
        this.macSizeBits = 128;
    }

    public GMac(GCMBlockCipher gCMBlockCipher, int i) {
        this.cipher = gCMBlockCipher;
        this.macSizeBits = i;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.cipher.init(true, new AEADParameters((KeyParameter) parametersWithIV.getParameters(), this.macSizeBits, parametersWithIV.getIV()));
            return;
        }
        throw new IllegalArgumentException("GMAC requires ParametersWithIV");
    }

    public String getAlgorithmName() {
        return this.cipher.getUnderlyingCipher().getAlgorithmName() + "-GMAC";
    }

    public int getMacSize() {
        return this.macSizeBits / 8;
    }

    public void update(byte b) throws IllegalStateException {
        this.cipher.processAADByte(b);
    }

    public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        this.cipher.processAADBytes(bArr, i, i2);
    }

    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        try {
            return this.cipher.doFinal(bArr, i);
        } catch (InvalidCipherTextException e) {
            throw new IllegalStateException(e.toString());
        }
    }

    public void reset() {
        this.cipher.reset();
    }
}
