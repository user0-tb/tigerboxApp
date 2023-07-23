package org.spongycastle.crypto.modes.gcm;

import org.spongycastle.util.Arrays;

public class BasicGCMMultiplier implements GCMMultiplier {

    /* renamed from: H */
    private byte[] f1102H;

    public void init(byte[] bArr) {
        this.f1102H = Arrays.clone(bArr);
    }

    public void multiplyH(byte[] bArr) {
        GCMUtil.multiply(bArr, this.f1102H);
    }
}
