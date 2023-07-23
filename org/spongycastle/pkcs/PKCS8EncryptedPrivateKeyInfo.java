package org.spongycastle.pkcs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.cert.CertIOException;
import org.spongycastle.operator.InputDecryptorProvider;
import org.spongycastle.util.p033io.Streams;

public class PKCS8EncryptedPrivateKeyInfo {
    private EncryptedPrivateKeyInfo encryptedPrivateKeyInfo;

    private static EncryptedPrivateKeyInfo parseBytes(byte[] bArr) throws IOException {
        try {
            return EncryptedPrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr));
        } catch (ClassCastException e) {
            throw new CertIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new CertIOException("malformed data: " + e2.getMessage(), e2);
        }
    }

    public PKCS8EncryptedPrivateKeyInfo(EncryptedPrivateKeyInfo encryptedPrivateKeyInfo2) {
        this.encryptedPrivateKeyInfo = encryptedPrivateKeyInfo2;
    }

    public PKCS8EncryptedPrivateKeyInfo(byte[] bArr) throws IOException {
        this(parseBytes(bArr));
    }

    public EncryptedPrivateKeyInfo toASN1Structure() {
        return this.encryptedPrivateKeyInfo;
    }

    public byte[] getEncoded() throws IOException {
        return this.encryptedPrivateKeyInfo.getEncoded();
    }

    public PrivateKeyInfo decryptPrivateKeyInfo(InputDecryptorProvider inputDecryptorProvider) throws PKCSException {
        try {
            return PrivateKeyInfo.getInstance(Streams.readAll(inputDecryptorProvider.get(this.encryptedPrivateKeyInfo.getEncryptionAlgorithm()).getInputStream(new ByteArrayInputStream(this.encryptedPrivateKeyInfo.getEncryptedData()))));
        } catch (Exception e) {
            throw new PKCSException("unable to read encrypted data: " + e.getMessage(), e);
        }
    }
}
