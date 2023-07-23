package org.spongycastle.crypto.p024ec;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.math.p030ec.ECPoint;

/* renamed from: org.spongycastle.crypto.ec.ECDecryptor */
public interface ECDecryptor {
    ECPoint decrypt(ECPair eCPair);

    void init(CipherParameters cipherParameters);
}
