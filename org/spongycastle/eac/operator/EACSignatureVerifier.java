package org.spongycastle.eac.operator;

import java.io.OutputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface EACSignatureVerifier {
    OutputStream getOutputStream();

    ASN1ObjectIdentifier getUsageIdentifier();

    boolean verify(byte[] bArr);
}
