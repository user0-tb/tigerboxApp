package org.spongycastle.cert.crmf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.spongycastle.asn1.crmf.EncryptedValue;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.util.Strings;
import org.spongycastle.util.p033io.Streams;

public class EncryptedValueParser {
    private EncryptedValuePadder padder;
    private EncryptedValue value;

    public EncryptedValueParser(EncryptedValue encryptedValue) {
        this.value = encryptedValue;
    }

    public EncryptedValueParser(EncryptedValue encryptedValue, EncryptedValuePadder encryptedValuePadder) {
        this.value = encryptedValue;
        this.padder = encryptedValuePadder;
    }

    private byte[] decryptValue(ValueDecryptorGenerator valueDecryptorGenerator) throws CRMFException {
        if (this.value.getIntendedAlg() != null) {
            throw new UnsupportedOperationException();
        } else if (this.value.getValueHint() == null) {
            try {
                byte[] readAll = Streams.readAll(valueDecryptorGenerator.getValueDecryptor(this.value.getKeyAlg(), this.value.getSymmAlg(), this.value.getEncSymmKey().getBytes()).getInputStream(new ByteArrayInputStream(this.value.getEncValue().getBytes())));
                EncryptedValuePadder encryptedValuePadder = this.padder;
                return encryptedValuePadder != null ? encryptedValuePadder.getUnpaddedData(readAll) : readAll;
            } catch (IOException e) {
                throw new CRMFException("Cannot parse decrypted data: " + e.getMessage(), e);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public X509CertificateHolder readCertificateHolder(ValueDecryptorGenerator valueDecryptorGenerator) throws CRMFException {
        return new X509CertificateHolder(Certificate.getInstance(decryptValue(valueDecryptorGenerator)));
    }

    public char[] readPassphrase(ValueDecryptorGenerator valueDecryptorGenerator) throws CRMFException {
        return Strings.fromUTF8ByteArray(decryptValue(valueDecryptorGenerator)).toCharArray();
    }
}
