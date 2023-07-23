package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class VMPCEngine implements StreamCipher {

    /* renamed from: P */
    protected byte[] f1025P = null;

    /* renamed from: n */
    protected byte f1026n = 0;

    /* renamed from: s */
    protected byte f1027s = 0;
    protected byte[] workingIV;
    protected byte[] workingKey;

    public String getAlgorithmName() {
        return "VMPC";
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
                byte[] iv = parametersWithIV.getIV();
                this.workingIV = iv;
                if (iv == null || iv.length < 1 || iv.length > 768) {
                    throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
                }
                byte[] key = keyParameter.getKey();
                this.workingKey = key;
                initKey(key, this.workingIV);
                return;
            }
            throw new IllegalArgumentException("VMPC init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC init parameters must include an IV");
    }

    /* access modifiers changed from: protected */
    public void initKey(byte[] bArr, byte[] bArr2) {
        this.f1027s = 0;
        this.f1025P = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.f1025P[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            byte[] bArr3 = this.f1025P;
            int i3 = i2 & 255;
            byte b = bArr3[(this.f1027s + bArr3[i3] + bArr[i2 % bArr.length]) & 255];
            this.f1027s = b;
            byte b2 = bArr3[i3];
            bArr3[i3] = bArr3[b & 255];
            bArr3[b & 255] = b2;
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.f1025P;
            int i5 = i4 & 255;
            byte b3 = bArr4[(this.f1027s + bArr4[i5] + bArr2[i4 % bArr2.length]) & 255];
            this.f1027s = b3;
            byte b4 = bArr4[i5];
            bArr4[i5] = bArr4[b3 & 255];
            bArr4[b3 & 255] = b4;
        }
        this.f1026n = 0;
    }

    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                byte[] bArr3 = this.f1025P;
                byte b = this.f1027s;
                byte b2 = this.f1026n;
                byte b3 = bArr3[(b + bArr3[b2 & 255]) & 255];
                this.f1027s = b3;
                byte b4 = bArr3[(bArr3[bArr3[b3 & 255] & 255] + 1) & 255];
                byte b5 = bArr3[b2 & 255];
                bArr3[b2 & 255] = bArr3[b3 & 255];
                bArr3[b3 & 255] = b5;
                this.f1026n = (byte) ((b2 + 1) & 255);
                bArr2[i4 + i3] = (byte) (bArr[i4 + i] ^ b4);
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        initKey(this.workingKey, this.workingIV);
    }

    public byte returnByte(byte b) {
        byte[] bArr = this.f1025P;
        byte b2 = this.f1027s;
        byte b3 = this.f1026n;
        byte b4 = bArr[(b2 + bArr[b3 & 255]) & 255];
        this.f1027s = b4;
        byte b5 = bArr[(bArr[bArr[b4 & 255] & 255] + 1) & 255];
        byte b6 = bArr[b3 & 255];
        bArr[b3 & 255] = bArr[b4 & 255];
        bArr[b4 & 255] = b6;
        this.f1026n = (byte) ((b3 + 1) & 255);
        return (byte) (b ^ b5);
    }
}
