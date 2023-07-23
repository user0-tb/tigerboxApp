package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;

public class SRP6Client {

    /* renamed from: A */
    protected BigInteger f785A;

    /* renamed from: B */
    protected BigInteger f786B;
    protected BigInteger Key;

    /* renamed from: M1 */
    protected BigInteger f787M1;

    /* renamed from: M2 */
    protected BigInteger f788M2;

    /* renamed from: N */
    protected BigInteger f789N;

    /* renamed from: S */
    protected BigInteger f790S;

    /* renamed from: a */
    protected BigInteger f791a;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f792g;
    protected SecureRandom random;

    /* renamed from: u */
    protected BigInteger f793u;

    /* renamed from: x */
    protected BigInteger f794x;

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2, SecureRandom secureRandom) {
        this.f789N = bigInteger;
        this.f792g = bigInteger2;
        this.digest = digest2;
        this.random = secureRandom;
    }

    public BigInteger generateClientCredentials(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f794x = SRP6Util.calculateX(this.digest, this.f789N, bArr, bArr2, bArr3);
        BigInteger selectPrivateValue = selectPrivateValue();
        this.f791a = selectPrivateValue;
        BigInteger modPow = this.f792g.modPow(selectPrivateValue, this.f789N);
        this.f785A = modPow;
        return modPow;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger validatePublicValue = SRP6Util.validatePublicValue(this.f789N, bigInteger);
        this.f786B = validatePublicValue;
        this.f793u = SRP6Util.calculateU(this.digest, this.f789N, this.f785A, validatePublicValue);
        BigInteger calculateS = calculateS();
        this.f790S = calculateS;
        return calculateS;
    }

    /* access modifiers changed from: protected */
    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f789N, this.f792g, this.random);
    }

    private BigInteger calculateS() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.f789N, this.f792g);
        return this.f786B.subtract(this.f792g.modPow(this.f794x, this.f789N).multiply(calculateK).mod(this.f789N)).mod(this.f789N).modPow(this.f793u.multiply(this.f794x).add(this.f791a), this.f789N);
    }

    public BigInteger calculateClientEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f785A;
        if (bigInteger3 == null || (bigInteger = this.f786B) == null || (bigInteger2 = this.f790S) == null) {
            throw new CryptoException("Impossible to compute M1: some data are missing from the previous operations (A,B,S)");
        }
        BigInteger calculateM1 = SRP6Util.calculateM1(this.digest, this.f789N, bigInteger3, bigInteger, bigInteger2);
        this.f787M1 = calculateM1;
        return calculateM1;
    }

    public boolean verifyServerEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f785A;
        if (bigInteger4 == null || (bigInteger2 = this.f787M1) == null || (bigInteger3 = this.f790S) == null) {
            throw new CryptoException("Impossible to compute and verify M2: some data are missing from the previous operations (A,M1,S)");
        } else if (!SRP6Util.calculateM2(this.digest, this.f789N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        } else {
            this.f788M2 = bigInteger;
            return true;
        }
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.f790S;
        if (bigInteger == null || this.f787M1 == null || this.f788M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger calculateKey = SRP6Util.calculateKey(this.digest, this.f789N, bigInteger);
        this.Key = calculateKey;
        return calculateKey;
    }
}
