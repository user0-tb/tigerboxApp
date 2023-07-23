package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import org.spongycastle.crypto.Digest;

public class SRP6VerifierGenerator {

    /* renamed from: N */
    protected BigInteger f805N;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f806g;

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2) {
        this.f805N = bigInteger;
        this.f806g = bigInteger2;
        this.digest = digest2;
    }

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f806g.modPow(SRP6Util.calculateX(this.digest, this.f805N, bArr, bArr2, bArr3), this.f805N);
    }
}
