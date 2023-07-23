package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SHA384Digest extends LongDigest {
    private static final int DIGEST_LENGTH = 48;

    public String getAlgorithmName() {
        return "SHA-384";
    }

    public int getDigestSize() {
        return 48;
    }

    public SHA384Digest() {
    }

    public SHA384Digest(SHA384Digest sHA384Digest) {
        super(sHA384Digest);
    }

    public SHA384Digest(byte[] bArr) {
        restoreState(bArr);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.longToBigEndian(this.f820H1, bArr, i);
        Pack.longToBigEndian(this.f821H2, bArr, i + 8);
        Pack.longToBigEndian(this.f822H3, bArr, i + 16);
        Pack.longToBigEndian(this.f823H4, bArr, i + 24);
        Pack.longToBigEndian(this.f824H5, bArr, i + 32);
        Pack.longToBigEndian(this.f825H6, bArr, i + 40);
        reset();
        return 48;
    }

    public void reset() {
        super.reset();
        this.f820H1 = -3766243637369397544L;
        this.f821H2 = 7105036623409894663L;
        this.f822H3 = -7973340178411365097L;
        this.f823H4 = 1526699215303891257L;
        this.f824H5 = 7436329637833083697L;
        this.f825H6 = -8163818279084223215L;
        this.f826H7 = -2662702644619276377L;
        this.f827H8 = 5167115440072839076L;
    }

    public Memoable copy() {
        return new SHA384Digest(this);
    }

    public void reset(Memoable memoable) {
        super.copyIn((SHA384Digest) memoable);
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[getEncodedStateSize()];
        super.populateState(bArr);
        return bArr;
    }
}
