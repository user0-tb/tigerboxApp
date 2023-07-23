package com.google.crypto.tink.subtle;

import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;

class XChaCha20 implements IndCpaCipher {
    static final int NONCE_LENGTH_IN_BYTES = 24;
    private final InsecureNonceXChaCha20 cipher;

    XChaCha20(byte[] bArr, int i) throws InvalidKeyException {
        this.cipher = new InsecureNonceXChaCha20(bArr, i);
    }

    public byte[] encrypt(byte[] bArr) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 24);
        byte[] randBytes = Random.randBytes(24);
        allocate.put(randBytes);
        this.cipher.encrypt(allocate, randBytes, bArr);
        return allocate.array();
    }

    public byte[] decrypt(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length >= 24) {
            return this.cipher.decrypt(Arrays.copyOf(bArr, 24), ByteBuffer.wrap(bArr, 24, bArr.length - 24));
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
