package org.spongycastle.operator;

import java.io.InputStream;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public interface InputDecryptor {
    AlgorithmIdentifier getAlgorithmIdentifier();

    InputStream getInputStream(InputStream inputStream);
}
