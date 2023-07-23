package org.spongycastle.crypto.prng.drbg;

import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.util.Arrays;

public class HMacSP800DRBG implements SP80090DRBG {
    private static final int MAX_BITS_REQUEST = 262144;
    private static final long RESEED_MAX = 140737488355328L;

    /* renamed from: _K */
    private byte[] f1179_K;

    /* renamed from: _V */
    private byte[] f1180_V;
    private EntropySource _entropySource;
    private Mac _hMac;
    private long _reseedCounter;

    public HMacSP800DRBG(Mac mac, int i, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        if (i > Utils.getMaxSecurityStrength(mac)) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        } else if (entropySource.entropySize() >= i) {
            this._entropySource = entropySource;
            this._hMac = mac;
            byte[] concatenate = Arrays.concatenate(entropySource.getEntropy(), bArr2, bArr);
            byte[] bArr3 = new byte[mac.getMacSize()];
            this.f1179_K = bArr3;
            byte[] bArr4 = new byte[bArr3.length];
            this.f1180_V = bArr4;
            Arrays.fill(bArr4, (byte) 1);
            hmac_DRBG_Update(concatenate);
            this._reseedCounter = 1;
        } else {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
    }

    private void hmac_DRBG_Update(byte[] bArr) {
        hmac_DRBG_Update_Func(bArr, (byte) 0);
        if (bArr != null) {
            hmac_DRBG_Update_Func(bArr, (byte) 1);
        }
    }

    private void hmac_DRBG_Update_Func(byte[] bArr, byte b) {
        this._hMac.init(new KeyParameter(this.f1179_K));
        Mac mac = this._hMac;
        byte[] bArr2 = this.f1180_V;
        mac.update(bArr2, 0, bArr2.length);
        this._hMac.update(b);
        if (bArr != null) {
            this._hMac.update(bArr, 0, bArr.length);
        }
        this._hMac.doFinal(this.f1179_K, 0);
        this._hMac.init(new KeyParameter(this.f1179_K));
        Mac mac2 = this._hMac;
        byte[] bArr3 = this.f1180_V;
        mac2.update(bArr3, 0, bArr3.length);
        this._hMac.doFinal(this.f1180_V, 0);
    }

    public int getBlockSize() {
        return this.f1180_V.length * 8;
    }

    public int generate(byte[] bArr, byte[] bArr2, boolean z) {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        } else if (this._reseedCounter > RESEED_MAX) {
            return -1;
        } else {
            if (z) {
                reseed(bArr2);
                bArr2 = null;
            }
            if (bArr2 != null) {
                hmac_DRBG_Update(bArr2);
            }
            int length2 = bArr.length;
            byte[] bArr3 = new byte[length2];
            int length3 = bArr.length / this.f1180_V.length;
            this._hMac.init(new KeyParameter(this.f1179_K));
            for (int i = 0; i < length3; i++) {
                Mac mac = this._hMac;
                byte[] bArr4 = this.f1180_V;
                mac.update(bArr4, 0, bArr4.length);
                this._hMac.doFinal(this.f1180_V, 0);
                byte[] bArr5 = this.f1180_V;
                System.arraycopy(bArr5, 0, bArr3, bArr5.length * i, bArr5.length);
            }
            byte[] bArr6 = this.f1180_V;
            if (bArr6.length * length3 < length2) {
                this._hMac.update(bArr6, 0, bArr6.length);
                this._hMac.doFinal(this.f1180_V, 0);
                byte[] bArr7 = this.f1180_V;
                System.arraycopy(bArr7, 0, bArr3, bArr7.length * length3, length2 - (length3 * bArr7.length));
            }
            hmac_DRBG_Update(bArr2);
            this._reseedCounter++;
            System.arraycopy(bArr3, 0, bArr, 0, bArr.length);
            return length;
        }
    }

    public void reseed(byte[] bArr) {
        hmac_DRBG_Update(Arrays.concatenate(this._entropySource.getEntropy(), bArr));
        this._reseedCounter = 1;
    }
}
