package org.spongycastle.eac.operator.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.eac.EACObjectIdentifiers;
import org.spongycastle.eac.operator.EACSignatureVerifier;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.operator.OperatorStreamException;
import org.spongycastle.operator.RuntimeOperatorException;

public class JcaEACSignatureVerifierBuilder {
    private EACHelper helper = new DefaultEACHelper();

    public JcaEACSignatureVerifierBuilder setProvider(String str) {
        this.helper = new NamedEACHelper(str);
        return this;
    }

    public JcaEACSignatureVerifierBuilder setProvider(Provider provider) {
        this.helper = new ProviderEACHelper(provider);
        return this;
    }

    public EACSignatureVerifier build(final ASN1ObjectIdentifier aSN1ObjectIdentifier, PublicKey publicKey) throws OperatorCreationException {
        try {
            Signature signature = this.helper.getSignature(aSN1ObjectIdentifier);
            signature.initVerify(publicKey);
            final SignatureOutputStream signatureOutputStream = new SignatureOutputStream(signature);
            return new EACSignatureVerifier() {
                public ASN1ObjectIdentifier getUsageIdentifier() {
                    return aSN1ObjectIdentifier;
                }

                public OutputStream getOutputStream() {
                    return signatureOutputStream;
                }

                public boolean verify(byte[] bArr) {
                    try {
                        if (!aSN1ObjectIdentifier.mo43781on(EACObjectIdentifiers.id_TA_ECDSA)) {
                            return signatureOutputStream.verify(bArr);
                        }
                        try {
                            return signatureOutputStream.verify(JcaEACSignatureVerifierBuilder.derEncode(bArr));
                        } catch (Exception unused) {
                            return false;
                        }
                    } catch (SignatureException e) {
                        throw new RuntimeOperatorException("exception obtaining signature: " + e.getMessage(), e);
                    }
                }
            };
        } catch (NoSuchAlgorithmException e) {
            throw new OperatorCreationException("unable to find algorithm: " + e.getMessage(), e);
        } catch (NoSuchProviderException e2) {
            throw new OperatorCreationException("unable to find provider: " + e2.getMessage(), e2);
        } catch (InvalidKeyException e3) {
            throw new OperatorCreationException("invalid key: " + e3.getMessage(), e3);
        }
    }

    /* access modifiers changed from: private */
    public static byte[] derEncode(byte[] bArr) throws IOException {
        int length = bArr.length / 2;
        byte[] bArr2 = new byte[length];
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        System.arraycopy(bArr, length, bArr3, 0, length);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(new BigInteger(1, bArr2)));
        aSN1EncodableVector.add(new ASN1Integer(new BigInteger(1, bArr3)));
        return new DERSequence(aSN1EncodableVector).getEncoded();
    }

    private class SignatureOutputStream extends OutputStream {
        private Signature sig;

        SignatureOutputStream(Signature signature) {
            this.sig = signature;
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.sig.update(bArr, i, i2);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }

        public void write(byte[] bArr) throws IOException {
            try {
                this.sig.update(bArr);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }

        public void write(int i) throws IOException {
            try {
                this.sig.update((byte) i);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean verify(byte[] bArr) throws SignatureException {
            return this.sig.verify(bArr);
        }
    }
}
