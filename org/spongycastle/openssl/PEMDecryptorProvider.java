package org.spongycastle.openssl;

import org.spongycastle.operator.OperatorCreationException;

public interface PEMDecryptorProvider {
    PEMDecryptor get(String str) throws OperatorCreationException;
}
