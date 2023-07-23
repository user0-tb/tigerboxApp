package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.proto.HpkePublicKey;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.SubtleUtil;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

final class HpkeContext {
    private static final byte[] EMPTY_IKM = new byte[0];
    private final HpkeAead aead;
    private final byte[] baseNonce;
    private final byte[] encapsulatedKey;
    private final byte[] key;
    private final BigInteger maxSequenceNumber;
    private BigInteger sequenceNumber = BigInteger.ZERO;

    private HpkeContext(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, HpkeAead hpkeAead) {
        this.encapsulatedKey = bArr;
        this.key = bArr2;
        this.baseNonce = bArr3;
        this.maxSequenceNumber = bigInteger;
        this.aead = hpkeAead;
    }

    static HpkeContext createContext(byte[] bArr, byte[] bArr2, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr3) throws GeneralSecurityException {
        HpkeKdf hpkeKdf2 = hpkeKdf;
        byte[] hpkeSuiteId = HpkeUtil.hpkeSuiteId(hpkeKem.getKemId(), hpkeKdf.getKdfId(), hpkeAead.getAeadId());
        byte[] bArr4 = HpkeUtil.EMPTY_SALT;
        byte[] bArr5 = EMPTY_IKM;
        byte[] concat = Bytes.concat(HpkeUtil.BASE_MODE, hpkeKdf2.labeledExtract(bArr4, bArr5, "psk_id_hash", hpkeSuiteId), hpkeKdf2.labeledExtract(HpkeUtil.EMPTY_SALT, bArr3, "info_hash", hpkeSuiteId));
        HpkeKdf hpkeKdf3 = hpkeKdf;
        byte[] labeledExtract = hpkeKdf2.labeledExtract(bArr2, bArr5, "secret", hpkeSuiteId);
        byte[] bArr6 = concat;
        byte[] bArr7 = hpkeSuiteId;
        return new HpkeContext(bArr, hpkeKdf3.labeledExpand(labeledExtract, bArr6, "key", bArr7, hpkeAead.getKeyLength()), hpkeKdf3.labeledExpand(labeledExtract, bArr6, "base_nonce", bArr7, hpkeAead.getNonceLength()), maxSequenceNumber(hpkeAead.getNonceLength()), hpkeAead);
    }

    static HpkeContext createSenderContext(HpkePublicKey hpkePublicKey, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr) throws GeneralSecurityException {
        HpkeKemEncapOutput encapsulate = hpkeKem.encapsulate(hpkePublicKey.getPublicKey().toByteArray());
        return createContext(encapsulate.getEncapsulatedKey(), encapsulate.getSharedSecret(), hpkeKem, hpkeKdf, hpkeAead, bArr);
    }

    static HpkeContext createRecipientContext(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr2) throws GeneralSecurityException {
        return createContext(bArr, hpkeKem.decapsulate(bArr, hpkeKemPrivateKey), hpkeKem, hpkeKdf, hpkeAead, bArr2);
    }

    private static BigInteger maxSequenceNumber(int i) {
        return BigInteger.ONE.shiftLeft(i * 8).subtract(BigInteger.ONE);
    }

    private void incrementSequenceNumber() throws GeneralSecurityException {
        if (this.sequenceNumber.compareTo(this.maxSequenceNumber) < 0) {
            this.sequenceNumber = this.sequenceNumber.add(BigInteger.ONE);
            return;
        }
        throw new GeneralSecurityException("message limit reached");
    }

    private byte[] computeNonce() throws GeneralSecurityException {
        return Bytes.xor(this.baseNonce, SubtleUtil.integer2Bytes(this.sequenceNumber, this.aead.getNonceLength()));
    }

    private synchronized byte[] computeNonceAndIncrementSequenceNumber() throws GeneralSecurityException {
        byte[] computeNonce;
        computeNonce = computeNonce();
        incrementSequenceNumber();
        return computeNonce;
    }

    /* access modifiers changed from: package-private */
    public byte[] getKey() {
        return this.key;
    }

    /* access modifiers changed from: package-private */
    public byte[] getBaseNonce() {
        return this.baseNonce;
    }

    /* access modifiers changed from: package-private */
    public byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    /* access modifiers changed from: package-private */
    public byte[] seal(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.aead.seal(this.key, computeNonceAndIncrementSequenceNumber(), bArr, bArr2);
    }

    /* access modifiers changed from: package-private */
    public byte[] open(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.aead.open(this.key, computeNonceAndIncrementSequenceNumber(), bArr, bArr2);
    }
}
