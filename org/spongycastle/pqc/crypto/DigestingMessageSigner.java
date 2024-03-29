package org.spongycastle.pqc.crypto;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class DigestingMessageSigner implements Signer {
    private boolean forSigning;
    private final Digest messDigest;
    private final MessageSigner messSigner;

    public DigestingMessageSigner(MessageSigner messageSigner, Digest digest) {
        this.messSigner = messageSigner;
        this.messDigest = digest;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.forSigning = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("Signing Requires Private Key.");
        } else if (z || !asymmetricKeyParameter.isPrivate()) {
            reset();
            this.messSigner.init(z, cipherParameters);
        } else {
            throw new IllegalArgumentException("Verification Requires Public Key.");
        }
    }

    public byte[] generateSignature() {
        if (this.forSigning) {
            byte[] bArr = new byte[this.messDigest.getDigestSize()];
            this.messDigest.doFinal(bArr, 0);
            return this.messSigner.generateSignature(bArr);
        }
        throw new IllegalStateException("RainbowDigestSigner not initialised for signature generation.");
    }

    public boolean verify(byte[] bArr) {
        if (!this.forSigning) {
            byte[] bArr2 = new byte[this.messDigest.getDigestSize()];
            this.messDigest.doFinal(bArr2, 0);
            return this.messSigner.verifySignature(bArr2, bArr);
        }
        throw new IllegalStateException("RainbowDigestSigner not initialised for verification");
    }

    public void update(byte b) {
        this.messDigest.update(b);
    }

    public void update(byte[] bArr, int i, int i2) {
        this.messDigest.update(bArr, i, i2);
    }

    public void reset() {
        this.messDigest.reset();
    }

    public boolean verifySignature(byte[] bArr) {
        return verify(bArr);
    }
}
