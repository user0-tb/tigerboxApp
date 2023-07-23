package org.spongycastle.cms.jcajce;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.operator.InputExpander;
import org.spongycastle.operator.InputExpanderProvider;

public class ZlibExpanderProvider implements InputExpanderProvider {
    /* access modifiers changed from: private */
    public final long limit;

    public ZlibExpanderProvider() {
        this.limit = -1;
    }

    public ZlibExpanderProvider(long j) {
        this.limit = j;
    }

    public InputExpander get(final AlgorithmIdentifier algorithmIdentifier) {
        return new InputExpander() {
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return algorithmIdentifier;
            }

            public InputStream getInputStream(InputStream inputStream) {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream);
                return ZlibExpanderProvider.this.limit >= 0 ? new LimitedInputStream(inflaterInputStream, ZlibExpanderProvider.this.limit) : inflaterInputStream;
            }
        };
    }

    private static class LimitedInputStream extends FilterInputStream {
        private long remaining;

        public LimitedInputStream(InputStream inputStream, long j) {
            super(inputStream);
            this.remaining = j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
            if (r4 >= 0) goto L_0x001b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read() throws java.io.IOException {
            /*
                r8 = this;
                long r0 = r8.remaining
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 < 0) goto L_0x001c
                java.io.InputStream r0 = r8.in
                int r0 = r0.read()
                if (r0 < 0) goto L_0x001b
                long r4 = r8.remaining
                r6 = 1
                long r4 = r4 - r6
                r8.remaining = r4
                int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r1 < 0) goto L_0x001c
            L_0x001b:
                return r0
            L_0x001c:
                org.spongycastle.util.io.StreamOverflowException r0 = new org.spongycastle.util.io.StreamOverflowException
                java.lang.String r1 = "expanded byte limit exceeded"
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.jcajce.ZlibExpanderProvider.LimitedInputStream.read():int");
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (i2 < 1) {
                return super.read(bArr, i, i2);
            }
            long j = this.remaining;
            if (j < 1) {
                read();
                return -1;
            }
            if (j <= ((long) i2)) {
                i2 = (int) j;
            }
            int read = this.in.read(bArr, i, i2);
            if (read > 0) {
                this.remaining -= (long) read;
            }
            return read;
        }
    }
}
