package org.spongycastle.crypto.tls;

import java.io.IOException;

class DTLSRecordLayer implements DatagramTransport {
    private static final int MAX_FRAGMENT_LENGTH = 16384;
    private static final int RECORD_HEADER_LENGTH = 13;
    private static final long RETRANSMIT_TIMEOUT = 240000;
    private static final long TCP_MSL = 120000;
    private volatile boolean closed = false;
    private final TlsContext context;
    private DTLSEpoch currentEpoch;
    private volatile ProtocolVersion discoveredPeerVersion = null;
    private volatile boolean failed = false;
    private volatile boolean inHandshake;
    private final TlsPeer peer;
    private DTLSEpoch pendingEpoch;
    private volatile int plaintextLimit;
    private DTLSEpoch readEpoch;
    private final ByteQueue recordQueue = new ByteQueue();
    private DTLSHandshakeRetransmit retransmit = null;
    private DTLSEpoch retransmitEpoch = null;
    private long retransmitExpiry = 0;
    private final DatagramTransport transport;
    private DTLSEpoch writeEpoch;

    private static long getMacSequenceNumber(int i, long j) {
        return ((((long) i) & 4294967295L) << 48) | j;
    }

    DTLSRecordLayer(DatagramTransport datagramTransport, TlsContext tlsContext, TlsPeer tlsPeer, short s) {
        this.transport = datagramTransport;
        this.context = tlsContext;
        this.peer = tlsPeer;
        this.inHandshake = true;
        DTLSEpoch dTLSEpoch = new DTLSEpoch(0, new TlsNullCipher(tlsContext));
        this.currentEpoch = dTLSEpoch;
        this.pendingEpoch = null;
        this.readEpoch = dTLSEpoch;
        this.writeEpoch = dTLSEpoch;
        setPlaintextLimit(16384);
    }

    /* access modifiers changed from: package-private */
    public void setPlaintextLimit(int i) {
        this.plaintextLimit = i;
    }

    /* access modifiers changed from: package-private */
    public ProtocolVersion getDiscoveredPeerVersion() {
        return this.discoveredPeerVersion;
    }

    /* access modifiers changed from: package-private */
    public ProtocolVersion resetDiscoveredPeerVersion() {
        ProtocolVersion protocolVersion = this.discoveredPeerVersion;
        this.discoveredPeerVersion = null;
        return protocolVersion;
    }

    /* access modifiers changed from: package-private */
    public void initPendingEpoch(TlsCipher tlsCipher) {
        if (this.pendingEpoch == null) {
            this.pendingEpoch = new DTLSEpoch(this.writeEpoch.getEpoch() + 1, tlsCipher);
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    public void handshakeSuccessful(DTLSHandshakeRetransmit dTLSHandshakeRetransmit) {
        DTLSEpoch dTLSEpoch = this.readEpoch;
        DTLSEpoch dTLSEpoch2 = this.currentEpoch;
        if (dTLSEpoch == dTLSEpoch2 || this.writeEpoch == dTLSEpoch2) {
            throw new IllegalStateException();
        }
        if (dTLSHandshakeRetransmit != null) {
            this.retransmit = dTLSHandshakeRetransmit;
            this.retransmitEpoch = dTLSEpoch2;
            this.retransmitExpiry = System.currentTimeMillis() + RETRANSMIT_TIMEOUT;
        }
        this.inHandshake = false;
        this.currentEpoch = this.pendingEpoch;
        this.pendingEpoch = null;
    }

    /* access modifiers changed from: package-private */
    public void resetWriteEpoch() {
        DTLSEpoch dTLSEpoch = this.retransmitEpoch;
        if (dTLSEpoch != null) {
            this.writeEpoch = dTLSEpoch;
        } else {
            this.writeEpoch = this.currentEpoch;
        }
    }

    public int getReceiveLimit() throws IOException {
        return Math.min(this.plaintextLimit, this.readEpoch.getCipher().getPlaintextLimit(this.transport.getReceiveLimit() - 13));
    }

    public int getSendLimit() throws IOException {
        return Math.min(this.plaintextLimit, this.writeEpoch.getCipher().getPlaintextLimit(this.transport.getSendLimit() - 13));
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [org.spongycastle.crypto.tls.DTLSHandshakeRetransmit, org.spongycastle.crypto.tls.DTLSEpoch] */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0074 A[Catch:{ IOException -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075 A[Catch:{ IOException -> 0x0131 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int receive(byte[] r19, int r20, int r21, int r22) throws java.io.IOException {
        /*
            r18 = this;
            r1 = r18
            r0 = 0
            r2 = r0
        L_0x0004:
            int r3 = r18.getReceiveLimit()
            r4 = r21
            int r3 = java.lang.Math.min(r4, r3)
            r5 = 13
            int r3 = r3 + r5
            if (r2 == 0) goto L_0x0016
            int r6 = r2.length
            if (r6 >= r3) goto L_0x0018
        L_0x0016:
            byte[] r2 = new byte[r3]
        L_0x0018:
            org.spongycastle.crypto.tls.DTLSHandshakeRetransmit r6 = r1.retransmit     // Catch:{ IOException -> 0x0131 }
            if (r6 == 0) goto L_0x002a
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0131 }
            long r8 = r1.retransmitExpiry     // Catch:{ IOException -> 0x0131 }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x002a
            r1.retransmit = r0     // Catch:{ IOException -> 0x0131 }
            r1.retransmitEpoch = r0     // Catch:{ IOException -> 0x0131 }
        L_0x002a:
            r13 = 0
            r14 = r22
            int r3 = r1.receiveRecord(r2, r13, r3, r14)     // Catch:{ IOException -> 0x0131 }
            if (r3 >= 0) goto L_0x0034
            return r3
        L_0x0034:
            if (r3 >= r5) goto L_0x003b
        L_0x0036:
            r5 = r19
            r6 = r20
            goto L_0x0004
        L_0x003b:
            r6 = 11
            int r6 = org.spongycastle.crypto.tls.TlsUtils.readUint16(r2, r6)     // Catch:{ IOException -> 0x0131 }
            int r6 = r6 + r5
            if (r3 == r6) goto L_0x0045
            goto L_0x0036
        L_0x0045:
            short r5 = org.spongycastle.crypto.tls.TlsUtils.readUint8(r2, r13)     // Catch:{ IOException -> 0x0131 }
            switch(r5) {
                case 20: goto L_0x004d;
                case 21: goto L_0x004d;
                case 22: goto L_0x004d;
                case 23: goto L_0x004d;
                case 24: goto L_0x004d;
                default: goto L_0x004c;
            }     // Catch:{ IOException -> 0x0131 }
        L_0x004c:
            goto L_0x0036
        L_0x004d:
            r6 = 3
            int r15 = org.spongycastle.crypto.tls.TlsUtils.readUint16(r2, r6)     // Catch:{ IOException -> 0x0131 }
            org.spongycastle.crypto.tls.DTLSEpoch r6 = r1.readEpoch     // Catch:{ IOException -> 0x0131 }
            int r6 = r6.getEpoch()     // Catch:{ IOException -> 0x0131 }
            if (r15 != r6) goto L_0x005f
            org.spongycastle.crypto.tls.DTLSEpoch r6 = r1.readEpoch     // Catch:{ IOException -> 0x0131 }
        L_0x005c:
            r16 = r6
            goto L_0x0072
        L_0x005f:
            r6 = 22
            if (r5 != r6) goto L_0x0070
            org.spongycastle.crypto.tls.DTLSEpoch r6 = r1.retransmitEpoch     // Catch:{ IOException -> 0x0131 }
            if (r6 == 0) goto L_0x0070
            int r6 = r6.getEpoch()     // Catch:{ IOException -> 0x0131 }
            if (r15 != r6) goto L_0x0070
            org.spongycastle.crypto.tls.DTLSEpoch r6 = r1.retransmitEpoch     // Catch:{ IOException -> 0x0131 }
            goto L_0x005c
        L_0x0070:
            r16 = r0
        L_0x0072:
            if (r16 != 0) goto L_0x0075
            goto L_0x0036
        L_0x0075:
            r6 = 5
            long r11 = org.spongycastle.crypto.tls.TlsUtils.readUint48(r2, r6)     // Catch:{ IOException -> 0x0131 }
            org.spongycastle.crypto.tls.DTLSReplayWindow r6 = r16.getReplayWindow()     // Catch:{ IOException -> 0x0131 }
            boolean r6 = r6.shouldDiscard(r11)     // Catch:{ IOException -> 0x0131 }
            if (r6 == 0) goto L_0x0085
            goto L_0x0036
        L_0x0085:
            r10 = 1
            org.spongycastle.crypto.tls.ProtocolVersion r9 = org.spongycastle.crypto.tls.TlsUtils.readVersion(r2, r10)     // Catch:{ IOException -> 0x0131 }
            org.spongycastle.crypto.tls.ProtocolVersion r6 = r1.discoveredPeerVersion     // Catch:{ IOException -> 0x0131 }
            if (r6 == 0) goto L_0x0097
            org.spongycastle.crypto.tls.ProtocolVersion r6 = r1.discoveredPeerVersion     // Catch:{ IOException -> 0x0131 }
            boolean r6 = r6.equals((org.spongycastle.crypto.tls.ProtocolVersion) r9)     // Catch:{ IOException -> 0x0131 }
            if (r6 != 0) goto L_0x0097
            goto L_0x0036
        L_0x0097:
            org.spongycastle.crypto.tls.TlsCipher r6 = r16.getCipher()     // Catch:{ IOException -> 0x0131 }
            int r7 = r16.getEpoch()     // Catch:{ IOException -> 0x0131 }
            long r7 = getMacSequenceNumber(r7, r11)     // Catch:{ IOException -> 0x0131 }
            r17 = 13
            int r3 = r3 + -13
            r0 = r9
            r9 = r5
            r10 = r2
            r13 = r11
            r11 = r17
            r12 = r3
            byte[] r3 = r6.decodeCiphertext(r7, r9, r10, r11, r12)     // Catch:{ IOException -> 0x0131 }
            org.spongycastle.crypto.tls.DTLSReplayWindow r6 = r16.getReplayWindow()     // Catch:{ IOException -> 0x0131 }
            r6.reportAuthenticated(r13)     // Catch:{ IOException -> 0x0131 }
            int r6 = r3.length     // Catch:{ IOException -> 0x0131 }
            int r7 = r1.plaintextLimit     // Catch:{ IOException -> 0x0131 }
            if (r6 <= r7) goto L_0x00c5
        L_0x00be:
            r5 = r19
            r6 = r20
            r0 = 0
            goto L_0x0004
        L_0x00c5:
            org.spongycastle.crypto.tls.ProtocolVersion r6 = r1.discoveredPeerVersion     // Catch:{ IOException -> 0x0131 }
            if (r6 != 0) goto L_0x00cb
            r1.discoveredPeerVersion = r0     // Catch:{ IOException -> 0x0131 }
        L_0x00cb:
            switch(r5) {
                case 20: goto L_0x0104;
                case 21: goto L_0x00e2;
                case 22: goto L_0x00d4;
                case 23: goto L_0x00cf;
                case 24: goto L_0x00be;
                default: goto L_0x00ce;
            }     // Catch:{ IOException -> 0x0131 }
        L_0x00ce:
            goto L_0x0119
        L_0x00cf:
            boolean r0 = r1.inHandshake     // Catch:{ IOException -> 0x0131 }
            if (r0 == 0) goto L_0x0119
            goto L_0x00be
        L_0x00d4:
            boolean r0 = r1.inHandshake     // Catch:{ IOException -> 0x0131 }
            if (r0 != 0) goto L_0x0119
            org.spongycastle.crypto.tls.DTLSHandshakeRetransmit r0 = r1.retransmit     // Catch:{ IOException -> 0x0131 }
            if (r0 == 0) goto L_0x00be
            int r5 = r3.length     // Catch:{ IOException -> 0x0131 }
            r6 = 0
            r0.receivedHandshakeRecord(r15, r3, r6, r5)     // Catch:{ IOException -> 0x0131 }
            goto L_0x00be
        L_0x00e2:
            int r0 = r3.length     // Catch:{ IOException -> 0x0131 }
            r5 = 2
            if (r0 != r5) goto L_0x00be
            r0 = 0
            byte r0 = r3[r0]     // Catch:{ IOException -> 0x0131 }
            short r0 = (short) r0     // Catch:{ IOException -> 0x0131 }
            r6 = 1
            byte r3 = r3[r6]     // Catch:{ IOException -> 0x0131 }
            short r3 = (short) r3     // Catch:{ IOException -> 0x0131 }
            org.spongycastle.crypto.tls.TlsPeer r6 = r1.peer     // Catch:{ IOException -> 0x0131 }
            r6.notifyAlertReceived(r0, r3)     // Catch:{ IOException -> 0x0131 }
            if (r0 == r5) goto L_0x00fb
            if (r3 != 0) goto L_0x00be
            r18.closeTransport()     // Catch:{ IOException -> 0x0131 }
            goto L_0x00be
        L_0x00fb:
            r1.fail(r3)     // Catch:{ IOException -> 0x0131 }
            org.spongycastle.crypto.tls.TlsFatalAlert r0 = new org.spongycastle.crypto.tls.TlsFatalAlert     // Catch:{ IOException -> 0x0131 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0131 }
            throw r0     // Catch:{ IOException -> 0x0131 }
        L_0x0104:
            r6 = 1
            r13 = 0
        L_0x0106:
            int r0 = r3.length     // Catch:{ IOException -> 0x0131 }
            if (r13 >= r0) goto L_0x00be
            short r0 = org.spongycastle.crypto.tls.TlsUtils.readUint8(r3, r13)     // Catch:{ IOException -> 0x0131 }
            if (r0 == r6) goto L_0x0110
            goto L_0x0116
        L_0x0110:
            org.spongycastle.crypto.tls.DTLSEpoch r0 = r1.pendingEpoch     // Catch:{ IOException -> 0x0131 }
            if (r0 == 0) goto L_0x0116
            r1.readEpoch = r0     // Catch:{ IOException -> 0x0131 }
        L_0x0116:
            int r13 = r13 + 1
            goto L_0x0106
        L_0x0119:
            boolean r0 = r1.inHandshake     // Catch:{ IOException -> 0x0131 }
            if (r0 != 0) goto L_0x0126
            org.spongycastle.crypto.tls.DTLSHandshakeRetransmit r0 = r1.retransmit     // Catch:{ IOException -> 0x0131 }
            if (r0 == 0) goto L_0x0126
            r0 = 0
            r1.retransmit = r0     // Catch:{ IOException -> 0x0131 }
            r1.retransmitEpoch = r0     // Catch:{ IOException -> 0x0131 }
        L_0x0126:
            int r0 = r3.length     // Catch:{ IOException -> 0x0131 }
            r5 = r19
            r6 = r20
            r2 = 0
            java.lang.System.arraycopy(r3, r2, r5, r6, r0)     // Catch:{ IOException -> 0x0131 }
            int r0 = r3.length     // Catch:{ IOException -> 0x0131 }
            return r0
        L_0x0131:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.DTLSRecordLayer.receive(byte[], int, int, int):int");
    }

    public void send(byte[] bArr, int i, int i2) throws IOException {
        short s;
        if (this.inHandshake || this.writeEpoch == this.retransmitEpoch) {
            s = 22;
            if (TlsUtils.readUint8(bArr, i) == 20) {
                DTLSEpoch dTLSEpoch = null;
                if (this.inHandshake) {
                    dTLSEpoch = this.pendingEpoch;
                } else if (this.writeEpoch == this.retransmitEpoch) {
                    dTLSEpoch = this.currentEpoch;
                }
                if (dTLSEpoch != null) {
                    sendRecord(20, new byte[]{1}, 0, 1);
                    this.writeEpoch = dTLSEpoch;
                } else {
                    throw new IllegalStateException();
                }
            }
        } else {
            s = 23;
        }
        sendRecord(s, bArr, i, i2);
    }

    public void close() throws IOException {
        if (!this.closed) {
            if (this.inHandshake) {
                warn(90, "User canceled handshake");
            }
            closeTransport();
        }
    }

    /* access modifiers changed from: package-private */
    public void fail(short s) {
        if (!this.closed) {
            try {
                raiseAlert(2, s, (String) null, (Exception) null);
            } catch (Exception unused) {
            }
            this.failed = true;
            closeTransport();
        }
    }

    /* access modifiers changed from: package-private */
    public void warn(short s, String str) throws IOException {
        raiseAlert(1, s, str, (Exception) null);
    }

    private void closeTransport() {
        if (!this.closed) {
            try {
                if (!this.failed) {
                    warn(0, (String) null);
                }
                this.transport.close();
            } catch (Exception unused) {
            }
            this.closed = true;
        }
    }

    private void raiseAlert(short s, short s2, String str, Exception exc) throws IOException {
        this.peer.notifyAlertRaised(s, s2, str, exc);
        sendRecord(21, new byte[]{(byte) s, (byte) s2}, 0, 2);
    }

    private int receiveRecord(byte[] bArr, int i, int i2, int i3) throws IOException {
        int readUint16;
        int i4;
        if (this.recordQueue.size() > 0) {
            if (this.recordQueue.size() >= 13) {
                byte[] bArr2 = new byte[2];
                this.recordQueue.read(bArr2, 0, 2, 11);
                i4 = TlsUtils.readUint16(bArr2, 0);
            } else {
                i4 = 0;
            }
            int min = Math.min(this.recordQueue.size(), i4 + 13);
            this.recordQueue.removeData(bArr, i, min, 0);
            return min;
        }
        int receive = this.transport.receive(bArr, i, i2, i3);
        if (receive < 13 || receive <= (readUint16 = TlsUtils.readUint16(bArr, i + 11) + 13)) {
            return receive;
        }
        this.recordQueue.addData(bArr, i + readUint16, receive - readUint16);
        return readUint16;
    }

    private void sendRecord(short s, byte[] bArr, int i, int i2) throws IOException {
        short s2 = s;
        int i3 = i2;
        if (i3 > this.plaintextLimit) {
            throw new TlsFatalAlert(80);
        } else if (i3 >= 1 || s2 == 23) {
            int epoch = this.writeEpoch.getEpoch();
            long allocateSequenceNumber = this.writeEpoch.allocateSequenceNumber();
            byte[] encodePlaintext = this.writeEpoch.getCipher().encodePlaintext(getMacSequenceNumber(epoch, allocateSequenceNumber), s, bArr, i, i2);
            int length = encodePlaintext.length + 13;
            byte[] bArr2 = new byte[length];
            TlsUtils.writeUint8(s, bArr2, 0);
            TlsUtils.writeVersion(this.discoveredPeerVersion != null ? this.discoveredPeerVersion : this.context.getClientVersion(), bArr2, 1);
            TlsUtils.writeUint16(epoch, bArr2, 3);
            TlsUtils.writeUint48(allocateSequenceNumber, bArr2, 5);
            TlsUtils.writeUint16(encodePlaintext.length, bArr2, 11);
            System.arraycopy(encodePlaintext, 0, bArr2, 13, encodePlaintext.length);
            this.transport.send(bArr2, 0, length);
        } else {
            throw new TlsFatalAlert(80);
        }
    }
}
