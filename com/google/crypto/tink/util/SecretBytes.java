package com.google.crypto.tink.util;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.subtle.Random;
import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

@Immutable
public final class SecretBytes {
    private final Bytes bytes;

    private SecretBytes(Bytes bytes2) {
        this.bytes = bytes2;
    }

    public static SecretBytes copyFrom(byte[] bArr, SecretKeyAccess secretKeyAccess) {
        Objects.requireNonNull(secretKeyAccess, "SecretKeyAccess required");
        return new SecretBytes(Bytes.copyFrom(bArr));
    }

    public static SecretBytes randomBytes(int i) {
        return new SecretBytes(Bytes.copyFrom(Random.randBytes(i)));
    }

    public byte[] toByteArray(SecretKeyAccess secretKeyAccess) {
        Objects.requireNonNull(secretKeyAccess, "SecretKeyAccess required");
        return this.bytes.toByteArray();
    }

    public int size() {
        return this.bytes.size();
    }

    public boolean equalsSecretBytes(SecretBytes secretBytes) {
        byte[] byteArray = this.bytes.toByteArray();
        byte[] byteArray2 = secretBytes.bytes.toByteArray();
        if (byteArray.length != byteArray2.length) {
            return false;
        }
        byte b = 0;
        for (int i = 0; i < byteArray.length; i++) {
            b |= byteArray[i] ^ byteArray2[i];
        }
        if (b == 0) {
            return true;
        }
        return false;
    }
}
