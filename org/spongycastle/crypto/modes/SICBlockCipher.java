package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.SkippingStreamCipher;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;

public class SICBlockCipher extends StreamBlockCipher implements SkippingStreamCipher {

    /* renamed from: IV */
    private byte[] f1100IV;
    private final int blockSize;
    private int byteCount = 0;
    private final BlockCipher cipher;
    private byte[] counter;
    private byte[] counterOut;

    public SICBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.f1100IV = new byte[blockSize2];
        this.counter = new byte[blockSize2];
        this.counterOut = new byte[blockSize2];
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            byte[] bArr = this.f1100IV;
            System.arraycopy(iv, 0, bArr, 0, bArr.length);
            if (parametersWithIV.getParameters() != null) {
                this.cipher.init(true, parametersWithIV.getParameters());
            }
            reset();
            return;
        }
        throw new IllegalArgumentException("SIC mode requires ParametersWithIV");
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/SIC";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i, this.blockSize, bArr2, i2);
        return this.blockSize;
    }

    /* access modifiers changed from: protected */
    public byte calculateByte(byte b) throws DataLengthException, IllegalStateException {
        int i = this.byteCount;
        if (i == 0) {
            this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
            byte[] bArr = this.counterOut;
            int i2 = this.byteCount;
            this.byteCount = i2 + 1;
            return (byte) (b ^ bArr[i2]);
        }
        byte[] bArr2 = this.counterOut;
        int i3 = i + 1;
        this.byteCount = i3;
        byte b2 = (byte) (b ^ bArr2[i]);
        if (i3 == this.counter.length) {
            this.byteCount = 0;
            incrementCounter();
        }
        return b2;
    }

    private void incrementCounter() {
        int length = this.counter.length - 1;
        while (length >= 0) {
            byte[] bArr = this.counter;
            byte b = (byte) (bArr[length] + 1);
            bArr[length] = b;
            if (b == 0) {
                length--;
            } else {
                return;
            }
        }
    }

    private void decrementCounter() {
        byte[] bArr = this.counter;
        boolean z = false;
        if (bArr[0] == 0) {
            for (int length = bArr.length - 1; length > 0; length--) {
                if (this.counter[length] != 0) {
                    z = true;
                }
            }
            if (!z) {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int length2 = this.counter.length - 1;
        while (length2 >= 0) {
            byte[] bArr2 = this.counter;
            byte b = (byte) (bArr2[length2] - 1);
            bArr2[length2] = b;
            if (b == -1) {
                length2--;
            } else {
                return;
            }
        }
    }

    private void adjustCounter(long j) {
        long j2 = 0;
        if (j >= 0) {
            long j3 = (((long) this.byteCount) + j) / ((long) this.blockSize);
            while (j2 != j3) {
                incrementCounter();
                j2++;
            }
            this.byteCount = (int) ((j + ((long) this.byteCount)) - (((long) this.blockSize) * j3));
            return;
        }
        long j4 = ((-j) - ((long) this.byteCount)) / ((long) this.blockSize);
        while (j2 != j4) {
            decrementCounter();
            j2++;
        }
        int i = (int) (((long) this.byteCount) + j + (((long) this.blockSize) * j4));
        if (i >= 0) {
            this.byteCount = 0;
            return;
        }
        decrementCounter();
        this.byteCount = this.blockSize + i;
    }

    public void reset() {
        byte[] bArr = this.f1100IV;
        byte[] bArr2 = this.counter;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.cipher.reset();
        this.byteCount = 0;
    }

    public long skip(long j) {
        adjustCounter(j);
        this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
        return j;
    }

    public long seekTo(long j) {
        reset();
        return skip(j);
    }

    public long getPosition() {
        int length = this.f1100IV.length;
        byte[] bArr = new byte[length];
        System.arraycopy(this.counter, 0, bArr, 0, length);
        for (int i = length - 1; i >= 1; i--) {
            int i2 = bArr[i] - this.f1100IV[i];
            if (i2 < 0) {
                int i3 = i - 1;
                bArr[i3] = (byte) (bArr[i3] - 1);
                i2 += 256;
            }
            bArr[i] = (byte) i2;
        }
        return (Pack.bigEndianToLong(bArr, length - 8) * ((long) this.blockSize)) + ((long) this.byteCount);
    }
}
