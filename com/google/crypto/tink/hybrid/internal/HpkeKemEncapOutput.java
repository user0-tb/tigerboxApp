package com.google.crypto.tink.hybrid.internal;

final class HpkeKemEncapOutput {
    private final byte[] encapsulatedKey;
    private final byte[] sharedSecret;

    HpkeKemEncapOutput(byte[] bArr, byte[] bArr2) {
        this.sharedSecret = bArr;
        this.encapsulatedKey = bArr2;
    }

    /* access modifiers changed from: package-private */
    public byte[] getSharedSecret() {
        return this.sharedSecret;
    }

    /* access modifiers changed from: package-private */
    public byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }
}
