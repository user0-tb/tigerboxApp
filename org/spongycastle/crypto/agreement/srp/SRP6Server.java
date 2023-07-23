package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;

public class SRP6Server {

    /* renamed from: A */
    protected BigInteger f795A;

    /* renamed from: B */
    protected BigInteger f796B;
    protected BigInteger Key;

    /* renamed from: M1 */
    protected BigInteger f797M1;

    /* renamed from: M2 */
    protected BigInteger f798M2;

    /* renamed from: N */
    protected BigInteger f799N;

    /* renamed from: S */
    protected BigInteger f800S;

    /* renamed from: b */
    protected BigInteger f801b;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f802g;
    protected SecureRandom random;

    /* renamed from: u */
    protected BigInteger f803u;

    /* renamed from: v */
    protected BigInteger f804v;

    public void init(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest2, SecureRandom secureRandom) {
        this.f799N = bigInteger;
        this.f802g = bigInteger2;
        this.f804v = bigInteger3;
        this.random = secureRandom;
        this.digest = digest2;
    }

    public BigInteger generateServerCredentials() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.f799N, this.f802g);
        this.f801b = selectPrivateValue();
        BigInteger mod = calculateK.multiply(this.f804v).mod(this.f799N).add(this.f802g.modPow(this.f801b, this.f799N)).mod(this.f799N);
        this.f796B = mod;
        return mod;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger validatePublicValue = SRP6Util.validatePublicValue(this.f799N, bigInteger);
        this.f795A = validatePublicValue;
        this.f803u = SRP6Util.calculateU(this.digest, this.f799N, validatePublicValue, this.f796B);
        BigInteger calculateS = calculateS();
        this.f800S = calculateS;
        return calculateS;
    }

    /* access modifiers changed from: protected */
    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f799N, this.f802g, this.random);
    }

    private BigInteger calculateS() {
        return this.f804v.modPow(this.f803u, this.f799N).multiply(this.f795A).mod(this.f799N).modPow(this.f801b, this.f799N);
    }

    public boolean verifyClientEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f795A;
        if (bigInteger4 == null || (bigInteger2 = this.f796B) == null || (bigInteger3 = this.f800S) == null) {
            throw new CryptoException("Impossible to compute and verify M1: some data are missing from the previous operations (A,B,S)");
        } else if (!SRP6Util.calculateM1(this.digest, this.f799N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        } else {
            this.f797M1 = bigInteger;
            return true;
        }
    }

    public BigInteger calculateServerEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f795A;
        if (bigInteger3 == null || (bigInteger = this.f797M1) == null || (bigInteger2 = this.f800S) == null) {
            throw new CryptoException("Impossible to compute M2: some data are missing from the previous operations (A,M1,S)");
        }
        BigInteger calculateM2 = SRP6Util.calculateM2(this.digest, this.f799N, bigInteger3, bigInteger, bigInteger2);
        this.f798M2 = calculateM2;
        return calculateM2;
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.f800S;
        if (bigInteger == null || this.f797M1 == null || this.f798M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger calculateKey = SRP6Util.calculateKey(this.digest, this.f799N, bigInteger);
        this.Key = calculateKey;
        return calculateKey;
    }
}
