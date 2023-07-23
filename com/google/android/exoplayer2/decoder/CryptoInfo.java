package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.C1229Util;

public final class CryptoInfo {
    public int clearBlocks;
    public int encryptedBlocks;
    private final MediaCodec.CryptoInfo frameworkCryptoInfo;

    /* renamed from: iv */
    public byte[] f151iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;
    private final PatternHolderV24 patternHolder;

    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.frameworkCryptoInfo = cryptoInfo;
        this.patternHolder = C1229Util.SDK_INT >= 24 ? new PatternHolderV24(cryptoInfo) : null;
    }

    public void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.f151iv = bArr2;
        this.mode = i2;
        this.encryptedBlocks = i3;
        this.clearBlocks = i4;
        this.frameworkCryptoInfo.numSubSamples = i;
        this.frameworkCryptoInfo.numBytesOfClearData = iArr;
        this.frameworkCryptoInfo.numBytesOfEncryptedData = iArr2;
        this.frameworkCryptoInfo.key = bArr;
        this.frameworkCryptoInfo.iv = bArr2;
        this.frameworkCryptoInfo.mode = i2;
        if (C1229Util.SDK_INT >= 24) {
            ((PatternHolderV24) Assertions.checkNotNull(this.patternHolder)).set(i3, i4);
        }
    }

    public MediaCodec.CryptoInfo getFrameworkCryptoInfo() {
        return this.frameworkCryptoInfo;
    }

    public void increaseClearDataFirstSubSampleBy(int i) {
        if (i != 0) {
            if (this.numBytesOfClearData == null) {
                int[] iArr = new int[1];
                this.numBytesOfClearData = iArr;
                this.frameworkCryptoInfo.numBytesOfClearData = iArr;
            }
            int[] iArr2 = this.numBytesOfClearData;
            iArr2[0] = iArr2[0] + i;
        }
    }

    private static final class PatternHolderV24 {
        private final MediaCodec.CryptoInfo frameworkCryptoInfo;
        private final MediaCodec.CryptoInfo.Pattern pattern;

        private PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
            this.frameworkCryptoInfo = cryptoInfo;
            this.pattern = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* access modifiers changed from: private */
        public void set(int i, int i2) {
            this.pattern.set(i, i2);
            this.frameworkCryptoInfo.setPattern(this.pattern);
        }
    }
}
