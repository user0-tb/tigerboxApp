package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.C1229Util;
import com.google.android.exoplayer2.util.TraceUtil;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SynchronousMediaCodecAdapter implements MediaCodecAdapter {
    private final MediaCodec codec;
    private ByteBuffer[] inputByteBuffers;
    private ByteBuffer[] outputByteBuffers;

    public boolean needsReconfiguration() {
        return false;
    }

    public static class Factory implements MediaCodecAdapter.Factory {
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.mediacodec.MediaCodecAdapter createAdapter(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Configuration r6) throws java.io.IOException {
            /*
                r5 = this;
                r0 = 0
                android.media.MediaCodec r1 = r5.createCodec(r6)     // Catch:{ IOException -> 0x0031, RuntimeException -> 0x002f }
                java.lang.String r2 = "configureCodec"
                com.google.android.exoplayer2.util.TraceUtil.beginSection(r2)     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x002a }
                android.media.MediaFormat r2 = r6.mediaFormat     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x002a }
                android.view.Surface r3 = r6.surface     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x002a }
                android.media.MediaCrypto r4 = r6.crypto     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x002a }
                int r6 = r6.flags     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x002a }
                r1.configure(r2, r3, r4, r6)     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x002a }
                com.google.android.exoplayer2.util.TraceUtil.endSection()     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x002a }
                java.lang.String r6 = "startCodec"
                com.google.android.exoplayer2.util.TraceUtil.beginSection(r6)     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x002a }
                r1.start()     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x002a }
                com.google.android.exoplayer2.util.TraceUtil.endSection()     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x002a }
                com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter r6 = new com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x002a }
                r6.<init>(r1)     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x002a }
                return r6
            L_0x002a:
                r6 = move-exception
                goto L_0x002d
            L_0x002c:
                r6 = move-exception
            L_0x002d:
                r0 = r1
                goto L_0x0032
            L_0x002f:
                r6 = move-exception
                goto L_0x0032
            L_0x0031:
                r6 = move-exception
            L_0x0032:
                if (r0 == 0) goto L_0x0037
                r0.release()
            L_0x0037:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter.Factory.createAdapter(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Configuration):com.google.android.exoplayer2.mediacodec.MediaCodecAdapter");
        }

        /* access modifiers changed from: protected */
        public MediaCodec createCodec(MediaCodecAdapter.Configuration configuration) throws IOException {
            Assertions.checkNotNull(configuration.codecInfo);
            String str = configuration.codecInfo.name;
            TraceUtil.beginSection("createCodec:" + str);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            TraceUtil.endSection();
            return createByCodecName;
        }
    }

    private SynchronousMediaCodecAdapter(MediaCodec mediaCodec) {
        this.codec = mediaCodec;
        if (C1229Util.SDK_INT < 21) {
            this.inputByteBuffers = mediaCodec.getInputBuffers();
            this.outputByteBuffers = mediaCodec.getOutputBuffers();
        }
    }

    public int dequeueInputBufferIndex() {
        return this.codec.dequeueInputBuffer(0);
    }

    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer == -3 && C1229Util.SDK_INT < 21) {
                this.outputByteBuffers = this.codec.getOutputBuffers();
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public MediaFormat getOutputFormat() {
        return this.codec.getOutputFormat();
    }

    public ByteBuffer getInputBuffer(int i) {
        if (C1229Util.SDK_INT >= 21) {
            return this.codec.getInputBuffer(i);
        }
        return ((ByteBuffer[]) C1229Util.castNonNull(this.inputByteBuffers))[i];
    }

    public ByteBuffer getOutputBuffer(int i) {
        if (C1229Util.SDK_INT >= 21) {
            return this.codec.getOutputBuffer(i);
        }
        return ((ByteBuffer[]) C1229Util.castNonNull(this.outputByteBuffers))[i];
    }

    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.codec.queueInputBuffer(i, i2, i3, j, i4);
    }

    public void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.codec.queueSecureInputBuffer(i, i2, cryptoInfo.getFrameworkCryptoInfo(), j, i3);
    }

    public void releaseOutputBuffer(int i, boolean z) {
        this.codec.releaseOutputBuffer(i, z);
    }

    public void releaseOutputBuffer(int i, long j) {
        this.codec.releaseOutputBuffer(i, j);
    }

    public void flush() {
        this.codec.flush();
    }

    public void release() {
        this.inputByteBuffers = null;
        this.outputByteBuffers = null;
        this.codec.release();
    }

    public void setOnFrameRenderedListener(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.codec.setOnFrameRenderedListener(new SynchronousMediaCodecAdapter$$ExternalSyntheticLambda0(this, onFrameRenderedListener), handler);
    }

    /* renamed from: lambda$setOnFrameRenderedListener$0$com-google-android-exoplayer2-mediacodec-SynchronousMediaCodecAdapter */
    public /* synthetic */ void mo17366x143bf9f7(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j, long j2) {
        onFrameRenderedListener.onFrameRendered(this, j, j2);
    }

    public void setOutputSurface(Surface surface) {
        this.codec.setOutputSurface(surface);
    }

    public void setParameters(Bundle bundle) {
        this.codec.setParameters(bundle);
    }

    public void setVideoScalingMode(int i) {
        this.codec.setVideoScalingMode(i);
    }

    public PersistableBundle getMetrics() {
        return this.codec.getMetrics();
    }
}
