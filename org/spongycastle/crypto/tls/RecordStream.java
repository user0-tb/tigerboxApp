package org.spongycastle.crypto.tls;

import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class RecordStream {
    private static int DEFAULT_PLAINTEXT_LIMIT = 16384;
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private int ciphertextLimit;
    private int compressedLimit;
    private TlsContext context = null;
    private TlsProtocol handler;
    private TlsHandshakeHash handshakeHash = null;
    private InputStream input;
    private OutputStream output;
    private TlsCipher pendingCipher = null;
    private TlsCompression pendingCompression = null;
    private int plaintextLimit;
    private TlsCipher readCipher = null;
    private TlsCompression readCompression = null;
    private long readSeqNo = 0;
    private ProtocolVersion readVersion = null;
    private boolean restrictReadVersion = true;
    private TlsCipher writeCipher = null;
    private TlsCompression writeCompression = null;
    private long writeSeqNo = 0;
    private ProtocolVersion writeVersion = null;

    RecordStream(TlsProtocol tlsProtocol, InputStream inputStream, OutputStream outputStream) {
        this.handler = tlsProtocol;
        this.input = inputStream;
        this.output = outputStream;
        TlsNullCompression tlsNullCompression = new TlsNullCompression();
        this.readCompression = tlsNullCompression;
        this.writeCompression = tlsNullCompression;
        TlsNullCipher tlsNullCipher = new TlsNullCipher(this.context);
        this.readCipher = tlsNullCipher;
        this.writeCipher = tlsNullCipher;
        setPlaintextLimit(DEFAULT_PLAINTEXT_LIMIT);
    }

    /* access modifiers changed from: package-private */
    public void init(TlsContext tlsContext) {
        this.context = tlsContext;
        DeferredHash deferredHash = new DeferredHash();
        this.handshakeHash = deferredHash;
        deferredHash.init(tlsContext);
    }

    /* access modifiers changed from: package-private */
    public int getPlaintextLimit() {
        return this.plaintextLimit;
    }

    /* access modifiers changed from: package-private */
    public void setPlaintextLimit(int i) {
        this.plaintextLimit = i;
        int i2 = i + 1024;
        this.compressedLimit = i2;
        this.ciphertextLimit = i2 + 1024;
    }

    /* access modifiers changed from: package-private */
    public ProtocolVersion getReadVersion() {
        return this.readVersion;
    }

    /* access modifiers changed from: package-private */
    public void setReadVersion(ProtocolVersion protocolVersion) {
        this.readVersion = protocolVersion;
    }

    /* access modifiers changed from: package-private */
    public void setWriteVersion(ProtocolVersion protocolVersion) {
        this.writeVersion = protocolVersion;
    }

    /* access modifiers changed from: package-private */
    public void setRestrictReadVersion(boolean z) {
        this.restrictReadVersion = z;
    }

    /* access modifiers changed from: package-private */
    public void setPendingConnectionState(TlsCompression tlsCompression, TlsCipher tlsCipher) {
        this.pendingCompression = tlsCompression;
        this.pendingCipher = tlsCipher;
    }

    /* access modifiers changed from: package-private */
    public void sentWriteCipherSpec() throws IOException {
        TlsCipher tlsCipher;
        TlsCompression tlsCompression = this.pendingCompression;
        if (tlsCompression == null || (tlsCipher = this.pendingCipher) == null) {
            throw new TlsFatalAlert(40);
        }
        this.writeCompression = tlsCompression;
        this.writeCipher = tlsCipher;
        this.writeSeqNo = 0;
    }

    /* access modifiers changed from: package-private */
    public void receivedReadCipherSpec() throws IOException {
        TlsCipher tlsCipher;
        TlsCompression tlsCompression = this.pendingCompression;
        if (tlsCompression == null || (tlsCipher = this.pendingCipher) == null) {
            throw new TlsFatalAlert(40);
        }
        this.readCompression = tlsCompression;
        this.readCipher = tlsCipher;
        this.readSeqNo = 0;
    }

    /* access modifiers changed from: package-private */
    public void finaliseHandshake() throws IOException {
        TlsCipher tlsCipher;
        TlsCompression tlsCompression = this.readCompression;
        TlsCompression tlsCompression2 = this.pendingCompression;
        if (tlsCompression == tlsCompression2 && this.writeCompression == tlsCompression2 && this.readCipher == (tlsCipher = this.pendingCipher) && this.writeCipher == tlsCipher) {
            this.pendingCompression = null;
            this.pendingCipher = null;
            return;
        }
        throw new TlsFatalAlert(40);
    }

    public boolean readRecord() throws IOException {
        byte[] readAllOrNothing = TlsUtils.readAllOrNothing(5, this.input);
        if (readAllOrNothing == null) {
            return false;
        }
        short readUint8 = TlsUtils.readUint8(readAllOrNothing, 0);
        checkType(readUint8, 10);
        if (this.restrictReadVersion) {
            ProtocolVersion readVersion2 = TlsUtils.readVersion(readAllOrNothing, 1);
            ProtocolVersion protocolVersion = this.readVersion;
            if (protocolVersion == null) {
                this.readVersion = readVersion2;
            } else if (!readVersion2.equals(protocolVersion)) {
                throw new TlsFatalAlert(47);
            }
        } else if ((TlsUtils.readVersionRaw(readAllOrNothing, 1) & InputDeviceCompat.SOURCE_ANY) != 768) {
            throw new TlsFatalAlert(47);
        }
        byte[] decodeAndVerify = decodeAndVerify(readUint8, this.input, TlsUtils.readUint16(readAllOrNothing, 3));
        this.handler.processRecord(readUint8, decodeAndVerify, 0, decodeAndVerify.length);
        return true;
    }

    /* access modifiers changed from: protected */
    public byte[] decodeAndVerify(short s, InputStream inputStream, int i) throws IOException {
        checkLength(i, this.ciphertextLimit, 22);
        byte[] readFully = TlsUtils.readFully(i, inputStream);
        TlsCipher tlsCipher = this.readCipher;
        long j = this.readSeqNo;
        this.readSeqNo = 1 + j;
        byte[] decodeCiphertext = tlsCipher.decodeCiphertext(j, s, readFully, 0, readFully.length);
        checkLength(decodeCiphertext.length, this.compressedLimit, 22);
        OutputStream decompress = this.readCompression.decompress(this.buffer);
        if (decompress != this.buffer) {
            decompress.write(decodeCiphertext, 0, decodeCiphertext.length);
            decompress.flush();
            decodeCiphertext = getBufferContents();
        }
        checkLength(decodeCiphertext.length, this.plaintextLimit, 30);
        if (decodeCiphertext.length >= 1 || s == 23) {
            return decodeCiphertext;
        }
        throw new TlsFatalAlert(47);
    }

    /* access modifiers changed from: protected */
    public void writeRecord(short s, byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2;
        short s2 = s;
        byte[] bArr3 = bArr;
        int i3 = i;
        int i4 = i2;
        if (this.writeVersion != null) {
            checkType(s, 80);
            checkLength(i4, this.plaintextLimit, 80);
            if (i4 >= 1 || s2 == 23) {
                if (s2 == 22) {
                    updateHandshakeData(bArr, i3, i4);
                }
                OutputStream compress = this.writeCompression.compress(this.buffer);
                if (compress == this.buffer) {
                    TlsCipher tlsCipher = this.writeCipher;
                    long j = this.writeSeqNo;
                    this.writeSeqNo = 1 + j;
                    bArr2 = tlsCipher.encodePlaintext(j, s, bArr, i, i2);
                } else {
                    compress.write(bArr, i3, i4);
                    compress.flush();
                    byte[] bufferContents = getBufferContents();
                    checkLength(bufferContents.length, i4 + 1024, 80);
                    TlsCipher tlsCipher2 = this.writeCipher;
                    long j2 = this.writeSeqNo;
                    this.writeSeqNo = 1 + j2;
                    bArr2 = tlsCipher2.encodePlaintext(j2, s, bufferContents, 0, bufferContents.length);
                }
                checkLength(bArr2.length, this.ciphertextLimit, 80);
                byte[] bArr4 = new byte[(bArr2.length + 5)];
                TlsUtils.writeUint8(s, bArr4, 0);
                TlsUtils.writeVersion(this.writeVersion, bArr4, 1);
                TlsUtils.writeUint16(bArr2.length, bArr4, 3);
                System.arraycopy(bArr2, 0, bArr4, 5, bArr2.length);
                this.output.write(bArr4);
                this.output.flush();
                return;
            }
            throw new TlsFatalAlert(80);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyHelloComplete() {
        this.handshakeHash = this.handshakeHash.notifyPRFDetermined();
    }

    /* access modifiers changed from: package-private */
    public TlsHandshakeHash getHandshakeHash() {
        return this.handshakeHash;
    }

    /* access modifiers changed from: package-private */
    public TlsHandshakeHash prepareToFinish() {
        TlsHandshakeHash tlsHandshakeHash = this.handshakeHash;
        this.handshakeHash = tlsHandshakeHash.stopTracking();
        return tlsHandshakeHash;
    }

    /* access modifiers changed from: package-private */
    public void updateHandshakeData(byte[] bArr, int i, int i2) {
        this.handshakeHash.update(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|2|3|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void safeClose() {
        /*
            r1 = this;
            java.io.InputStream r0 = r1.input     // Catch:{ IOException -> 0x0005 }
            r0.close()     // Catch:{ IOException -> 0x0005 }
        L_0x0005:
            java.io.OutputStream r0 = r1.output     // Catch:{ IOException -> 0x000a }
            r0.close()     // Catch:{ IOException -> 0x000a }
        L_0x000a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.RecordStream.safeClose():void");
    }

    /* access modifiers changed from: protected */
    public void flush() throws IOException {
        this.output.flush();
    }

    private byte[] getBufferContents() {
        byte[] byteArray = this.buffer.toByteArray();
        this.buffer.reset();
        return byteArray;
    }

    private static void checkType(short s, short s2) throws IOException {
        switch (s) {
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                return;
            default:
                throw new TlsFatalAlert(s2);
        }
    }

    private static void checkLength(int i, int i2, short s) throws IOException {
        if (i > i2) {
            throw new TlsFatalAlert(s);
        }
    }
}
