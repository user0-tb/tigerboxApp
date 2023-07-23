package org.spongycastle.openssl;

public interface PEMDecryptor {
    byte[] decrypt(byte[] bArr, byte[] bArr2) throws PEMException;
}
