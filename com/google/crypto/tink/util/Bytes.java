package com.google.crypto.tink.util;

import com.google.crypto.tink.subtle.Hex;
import com.google.errorprone.annotations.Immutable;
import java.util.Arrays;
import java.util.Objects;

@Immutable
public final class Bytes {
    private final byte[] data;

    public static Bytes copyFrom(byte[] bArr) {
        Objects.requireNonNull(bArr, "data must be non-null");
        return copyFrom(bArr, 0, bArr.length);
    }

    public static Bytes copyFrom(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "data must be non-null");
        return new Bytes(bArr, i, i2);
    }

    public byte[] toByteArray() {
        byte[] bArr = this.data;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public int size() {
        return this.data.length;
    }

    private Bytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Bytes)) {
            return false;
        }
        return Arrays.equals(((Bytes) obj).data, this.data);
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    public String toString() {
        return "Bytes(" + Hex.encode(this.data) + ")";
    }
}
