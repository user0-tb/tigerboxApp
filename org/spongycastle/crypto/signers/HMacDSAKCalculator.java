package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

public class HMacDSAKCalculator implements DSAKCalculator {
    private static final BigInteger ZERO = BigInteger.valueOf(0);

    /* renamed from: K */
    private final byte[] f1183K;

    /* renamed from: V */
    private final byte[] f1184V;
    private final HMac hMac;

    /* renamed from: n */
    private BigInteger f1185n;

    public boolean isDeterministic() {
        return true;
    }

    public HMacDSAKCalculator(Digest digest) {
        HMac hMac2 = new HMac(digest);
        this.hMac = hMac2;
        this.f1184V = new byte[hMac2.getMacSize()];
        this.f1183K = new byte[hMac2.getMacSize()];
    }

    public void init(BigInteger bigInteger, SecureRandom secureRandom) {
        throw new IllegalStateException("Operation not supported");
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f1185n = bigInteger;
        Arrays.fill(this.f1184V, (byte) 1);
        Arrays.fill(this.f1183K, (byte) 0);
        int bitLength = (bigInteger.bitLength() + 7) / 8;
        byte[] bArr2 = new byte[bitLength];
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger2);
        System.arraycopy(asUnsignedByteArray, 0, bArr2, bitLength - asUnsignedByteArray.length, asUnsignedByteArray.length);
        int bitLength2 = (bigInteger.bitLength() + 7) / 8;
        byte[] bArr3 = new byte[bitLength2];
        BigInteger bitsToInt = bitsToInt(bArr);
        if (bitsToInt.compareTo(bigInteger) > 0) {
            bitsToInt = bitsToInt.subtract(bigInteger);
        }
        byte[] asUnsignedByteArray2 = BigIntegers.asUnsignedByteArray(bitsToInt);
        System.arraycopy(asUnsignedByteArray2, 0, bArr3, bitLength2 - asUnsignedByteArray2.length, asUnsignedByteArray2.length);
        this.hMac.init(new KeyParameter(this.f1183K));
        HMac hMac2 = this.hMac;
        byte[] bArr4 = this.f1184V;
        hMac2.update(bArr4, 0, bArr4.length);
        this.hMac.update((byte) 0);
        this.hMac.update(bArr2, 0, bitLength);
        this.hMac.update(bArr3, 0, bitLength2);
        this.hMac.doFinal(this.f1183K, 0);
        this.hMac.init(new KeyParameter(this.f1183K));
        HMac hMac3 = this.hMac;
        byte[] bArr5 = this.f1184V;
        hMac3.update(bArr5, 0, bArr5.length);
        this.hMac.doFinal(this.f1184V, 0);
        HMac hMac4 = this.hMac;
        byte[] bArr6 = this.f1184V;
        hMac4.update(bArr6, 0, bArr6.length);
        this.hMac.update((byte) 1);
        this.hMac.update(bArr2, 0, bitLength);
        this.hMac.update(bArr3, 0, bitLength2);
        this.hMac.doFinal(this.f1183K, 0);
        this.hMac.init(new KeyParameter(this.f1183K));
        HMac hMac5 = this.hMac;
        byte[] bArr7 = this.f1184V;
        hMac5.update(bArr7, 0, bArr7.length);
        this.hMac.doFinal(this.f1184V, 0);
    }

    public BigInteger nextK() {
        int bitLength = (this.f1185n.bitLength() + 7) / 8;
        byte[] bArr = new byte[bitLength];
        while (true) {
            int i = 0;
            while (i < bitLength) {
                HMac hMac2 = this.hMac;
                byte[] bArr2 = this.f1184V;
                hMac2.update(bArr2, 0, bArr2.length);
                this.hMac.doFinal(this.f1184V, 0);
                int min = Math.min(bitLength - i, this.f1184V.length);
                System.arraycopy(this.f1184V, 0, bArr, i, min);
                i += min;
            }
            BigInteger bitsToInt = bitsToInt(bArr);
            if (bitsToInt.compareTo(ZERO) > 0 && bitsToInt.compareTo(this.f1185n) < 0) {
                return bitsToInt;
            }
            HMac hMac3 = this.hMac;
            byte[] bArr3 = this.f1184V;
            hMac3.update(bArr3, 0, bArr3.length);
            this.hMac.update((byte) 0);
            this.hMac.doFinal(this.f1183K, 0);
            this.hMac.init(new KeyParameter(this.f1183K));
            HMac hMac4 = this.hMac;
            byte[] bArr4 = this.f1184V;
            hMac4.update(bArr4, 0, bArr4.length);
            this.hMac.doFinal(this.f1184V, 0);
        }
    }

    private BigInteger bitsToInt(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, bArr);
        return bArr.length * 8 > this.f1185n.bitLength() ? bigInteger.shiftRight((bArr.length * 8) - this.f1185n.bitLength()) : bigInteger;
    }
}
