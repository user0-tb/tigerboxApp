package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.crypto.prng.ThreadedSeedGenerator;
import org.spongycastle.crypto.tls.TlsProtocol;
import org.spongycastle.util.Arrays;

public class TlsClientProtocol extends TlsProtocol {
    protected TlsAuthentication authentication;
    protected CertificateRequest certificateRequest;
    protected CertificateStatus certificateStatus;
    protected TlsKeyExchange keyExchange;
    protected byte[] selectedSessionID;
    protected TlsClient tlsClient;
    protected TlsClientContextImpl tlsClientContext;

    private static SecureRandom createSecureRandom() {
        ThreadedSeedGenerator threadedSeedGenerator = new ThreadedSeedGenerator();
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(threadedSeedGenerator.generateSeed(20, true));
        return secureRandom;
    }

    public TlsClientProtocol(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, createSecureRandom());
    }

    public TlsClientProtocol(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        super(inputStream, outputStream, secureRandom);
        this.tlsClient = null;
        this.tlsClientContext = null;
        this.selectedSessionID = null;
        this.keyExchange = null;
        this.authentication = null;
        this.certificateStatus = null;
        this.certificateRequest = null;
    }

    public void connect(TlsClient tlsClient2) throws IOException {
        SessionParameters exportSessionParameters;
        if (tlsClient2 == null) {
            throw new IllegalArgumentException("'tlsClient' cannot be null");
        } else if (this.tlsClient == null) {
            this.tlsClient = tlsClient2;
            this.securityParameters = new SecurityParameters();
            this.securityParameters.entity = 1;
            this.tlsClientContext = new TlsClientContextImpl(this.secureRandom, this.securityParameters);
            this.securityParameters.clientRandom = createRandomBlock(tlsClient2.shouldUseGMTUnixTime(), this.tlsClientContext.getNonceRandomGenerator());
            this.tlsClient.init(this.tlsClientContext);
            this.recordStream.init(this.tlsClientContext);
            TlsSession sessionToResume = tlsClient2.getSessionToResume();
            if (!(sessionToResume == null || (exportSessionParameters = sessionToResume.exportSessionParameters()) == null)) {
                this.tlsSession = sessionToResume;
                this.sessionParameters = exportSessionParameters;
            }
            sendClientHelloMessage();
            this.connection_state = 1;
            completeHandshake();
        } else {
            throw new IllegalStateException("'connect' can only be called once");
        }
    }

    /* access modifiers changed from: protected */
    public void cleanupHandshake() {
        super.cleanupHandshake();
        this.selectedSessionID = null;
        this.keyExchange = null;
        this.authentication = null;
        this.certificateStatus = null;
        this.certificateRequest = null;
    }

    /* access modifiers changed from: protected */
    public AbstractTlsContext getContext() {
        return this.tlsClientContext;
    }

    /* access modifiers changed from: protected */
    public TlsPeer getPeer() {
        return this.tlsClient;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        r12.keyExchange.skipServerCredentials();
        r12.authentication = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        r12.keyExchange.skipServerKeyExchange();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006d, code lost:
        assertEmpty(r0);
        r12.connection_state = 8;
        r12.recordStream.getHandshakeHash().sealHashAlgorithms();
        r13 = r12.tlsClient.getClientSupplementalData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0081, code lost:
        if (r13 == null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        sendSupplementalDataMessage(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0086, code lost:
        r12.connection_state = 9;
        r13 = r12.certificateRequest;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008c, code lost:
        if (r13 != null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008e, code lost:
        r12.keyExchange.skipClientCredentials();
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0095, code lost:
        r13 = r12.authentication.getClientCredentials(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009b, code lost:
        if (r13 != null) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009d, code lost:
        r12.keyExchange.skipClientCredentials();
        sendCertificateMessage(org.spongycastle.crypto.tls.Certificate.EMPTY_CHAIN);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
        r12.keyExchange.processClientCredentials(r13);
        sendCertificateMessage(r13.getCertificate());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b4, code lost:
        r12.connection_state = 10;
        sendClientKeyExchangeMessage();
        r12.connection_state = 11;
        establishMasterSecret(getContext(), r12.keyExchange);
        r12.recordStream.setPendingConnectionState(getPeer().getCompression(), getPeer().getCipher());
        r14 = r12.recordStream.prepareToFinish();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e1, code lost:
        if (r13 == null) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e5, code lost:
        if ((r13 instanceof org.spongycastle.crypto.tls.TlsSignerCredentials) == false) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e7, code lost:
        r13 = (org.spongycastle.crypto.tls.TlsSignerCredentials) r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f1, code lost:
        if (org.spongycastle.crypto.tls.TlsUtils.isTLSv12(getContext()) == false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f3, code lost:
        r9 = r13.getSignatureAndHashAlgorithm();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f7, code lost:
        if (r9 == null) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f9, code lost:
        r14 = r14.getFinalHash(r9.getHash());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0109, code lost:
        throw new org.spongycastle.crypto.tls.TlsFatalAlert(80);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010a, code lost:
        r14 = getCurrentPRFHash(getContext(), r14, (byte[]) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0112, code lost:
        sendCertificateVerifyMessage(new org.spongycastle.crypto.tls.DigitallySigned(r9, r13.generateCertificateSignature(r14)));
        r12.connection_state = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0120, code lost:
        sendChangeCipherSpecMessage();
        sendFinishedMessage();
        r12.connection_state = 13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleHandshakeMessage(short r13, byte[] r14) throws java.io.IOException {
        /*
            r12 = this;
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r14)
            boolean r14 = r12.resumedSession
            r1 = 15
            r2 = 20
            r3 = 16
            r4 = 13
            r5 = 2
            r6 = 10
            if (r14 == 0) goto L_0x002d
            if (r13 != r2) goto L_0x0027
            short r13 = r12.connection_state
            if (r13 != r5) goto L_0x0027
            r12.processFinishedMessage(r0)
            r12.connection_state = r1
            r12.sendFinishedMessage()
            r12.connection_state = r4
            r12.connection_state = r3
            return
        L_0x0027:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x002d:
            r14 = 40
            if (r13 == 0) goto L_0x02c1
            r7 = 12
            r8 = 8
            r9 = 0
            if (r13 == r5) goto L_0x0249
            r10 = 14
            r11 = 4
            if (r13 == r11) goto L_0x022b
            if (r13 == r2) goto L_0x020b
            r1 = 22
            r2 = 5
            if (r13 == r1) goto L_0x01ea
            r1 = 23
            if (r13 == r1) goto L_0x01d7
            r1 = 6
            r3 = 3
            switch(r13) {
                case 11: goto L_0x0197;
                case 12: goto L_0x0170;
                case 13: goto L_0x012a;
                case 14: goto L_0x0053;
                default: goto L_0x004d;
            }
        L_0x004d:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x0053:
            short r13 = r12.connection_state
            switch(r13) {
                case 2: goto L_0x005e;
                case 3: goto L_0x0061;
                case 4: goto L_0x0068;
                case 5: goto L_0x0068;
                case 6: goto L_0x006d;
                case 7: goto L_0x006d;
                default: goto L_0x0058;
            }
        L_0x0058:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r14)
            throw r13
        L_0x005e:
            r12.handleSupplementalData(r9)
        L_0x0061:
            org.spongycastle.crypto.tls.TlsKeyExchange r13 = r12.keyExchange
            r13.skipServerCredentials()
            r12.authentication = r9
        L_0x0068:
            org.spongycastle.crypto.tls.TlsKeyExchange r13 = r12.keyExchange
            r13.skipServerKeyExchange()
        L_0x006d:
            assertEmpty(r0)
            r12.connection_state = r8
            org.spongycastle.crypto.tls.RecordStream r13 = r12.recordStream
            org.spongycastle.crypto.tls.TlsHandshakeHash r13 = r13.getHandshakeHash()
            r13.sealHashAlgorithms()
            org.spongycastle.crypto.tls.TlsClient r13 = r12.tlsClient
            java.util.Vector r13 = r13.getClientSupplementalData()
            if (r13 == 0) goto L_0x0086
            r12.sendSupplementalDataMessage(r13)
        L_0x0086:
            r13 = 9
            r12.connection_state = r13
            org.spongycastle.crypto.tls.CertificateRequest r13 = r12.certificateRequest
            if (r13 != 0) goto L_0x0095
            org.spongycastle.crypto.tls.TlsKeyExchange r13 = r12.keyExchange
            r13.skipClientCredentials()
            r13 = r9
            goto L_0x00b4
        L_0x0095:
            org.spongycastle.crypto.tls.TlsAuthentication r14 = r12.authentication
            org.spongycastle.crypto.tls.TlsCredentials r13 = r14.getClientCredentials(r13)
            if (r13 != 0) goto L_0x00a8
            org.spongycastle.crypto.tls.TlsKeyExchange r14 = r12.keyExchange
            r14.skipClientCredentials()
            org.spongycastle.crypto.tls.Certificate r14 = org.spongycastle.crypto.tls.Certificate.EMPTY_CHAIN
            r12.sendCertificateMessage(r14)
            goto L_0x00b4
        L_0x00a8:
            org.spongycastle.crypto.tls.TlsKeyExchange r14 = r12.keyExchange
            r14.processClientCredentials(r13)
            org.spongycastle.crypto.tls.Certificate r14 = r13.getCertificate()
            r12.sendCertificateMessage(r14)
        L_0x00b4:
            r12.connection_state = r6
            r12.sendClientKeyExchangeMessage()
            r14 = 11
            r12.connection_state = r14
            org.spongycastle.crypto.tls.AbstractTlsContext r14 = r12.getContext()
            org.spongycastle.crypto.tls.TlsKeyExchange r0 = r12.keyExchange
            establishMasterSecret(r14, r0)
            org.spongycastle.crypto.tls.RecordStream r14 = r12.recordStream
            org.spongycastle.crypto.tls.TlsPeer r0 = r12.getPeer()
            org.spongycastle.crypto.tls.TlsCompression r0 = r0.getCompression()
            org.spongycastle.crypto.tls.TlsPeer r1 = r12.getPeer()
            org.spongycastle.crypto.tls.TlsCipher r1 = r1.getCipher()
            r14.setPendingConnectionState(r0, r1)
            org.spongycastle.crypto.tls.RecordStream r14 = r12.recordStream
            org.spongycastle.crypto.tls.TlsHandshakeHash r14 = r14.prepareToFinish()
            if (r13 == 0) goto L_0x0120
            boolean r0 = r13 instanceof org.spongycastle.crypto.tls.TlsSignerCredentials
            if (r0 == 0) goto L_0x0120
            org.spongycastle.crypto.tls.TlsSignerCredentials r13 = (org.spongycastle.crypto.tls.TlsSignerCredentials) r13
            org.spongycastle.crypto.tls.AbstractTlsContext r0 = r12.getContext()
            boolean r0 = org.spongycastle.crypto.tls.TlsUtils.isTLSv12(r0)
            if (r0 == 0) goto L_0x010a
            org.spongycastle.crypto.tls.SignatureAndHashAlgorithm r9 = r13.getSignatureAndHashAlgorithm()
            if (r9 == 0) goto L_0x0102
            short r0 = r9.getHash()
            byte[] r14 = r14.getFinalHash(r0)
            goto L_0x0112
        L_0x0102:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r14 = 80
            r13.<init>(r14)
            throw r13
        L_0x010a:
            org.spongycastle.crypto.tls.AbstractTlsContext r0 = r12.getContext()
            byte[] r14 = getCurrentPRFHash(r0, r14, r9)
        L_0x0112:
            byte[] r13 = r13.generateCertificateSignature(r14)
            org.spongycastle.crypto.tls.DigitallySigned r14 = new org.spongycastle.crypto.tls.DigitallySigned
            r14.<init>(r9, r13)
            r12.sendCertificateVerifyMessage(r14)
            r12.connection_state = r7
        L_0x0120:
            r12.sendChangeCipherSpecMessage()
            r12.sendFinishedMessage()
            r12.connection_state = r4
            goto L_0x02e0
        L_0x012a:
            short r13 = r12.connection_state
            if (r13 == r11) goto L_0x0139
            if (r13 == r2) goto L_0x0139
            if (r13 != r1) goto L_0x0133
            goto L_0x013e
        L_0x0133:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x0139:
            org.spongycastle.crypto.tls.TlsKeyExchange r13 = r12.keyExchange
            r13.skipServerKeyExchange()
        L_0x013e:
            org.spongycastle.crypto.tls.TlsAuthentication r13 = r12.authentication
            if (r13 == 0) goto L_0x016a
            org.spongycastle.crypto.tls.AbstractTlsContext r13 = r12.getContext()
            org.spongycastle.crypto.tls.CertificateRequest r13 = org.spongycastle.crypto.tls.CertificateRequest.parse(r13, r0)
            r12.certificateRequest = r13
            assertEmpty(r0)
            org.spongycastle.crypto.tls.TlsKeyExchange r13 = r12.keyExchange
            org.spongycastle.crypto.tls.CertificateRequest r14 = r12.certificateRequest
            r13.validateCertificateRequest(r14)
            org.spongycastle.crypto.tls.RecordStream r13 = r12.recordStream
            org.spongycastle.crypto.tls.TlsHandshakeHash r13 = r13.getHandshakeHash()
            org.spongycastle.crypto.tls.CertificateRequest r14 = r12.certificateRequest
            java.util.Vector r14 = r14.getSupportedSignatureAlgorithms()
            org.spongycastle.crypto.tls.TlsUtils.trackHashAlgorithms(r13, r14)
            r13 = 7
            r12.connection_state = r13
            goto L_0x02e0
        L_0x016a:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r14)
            throw r13
        L_0x0170:
            short r13 = r12.connection_state
            if (r13 == r5) goto L_0x0181
            if (r13 == r3) goto L_0x0184
            if (r13 == r11) goto L_0x018b
            if (r13 != r2) goto L_0x017b
            goto L_0x018b
        L_0x017b:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x0181:
            r12.handleSupplementalData(r9)
        L_0x0184:
            org.spongycastle.crypto.tls.TlsKeyExchange r13 = r12.keyExchange
            r13.skipServerCredentials()
            r12.authentication = r9
        L_0x018b:
            org.spongycastle.crypto.tls.TlsKeyExchange r13 = r12.keyExchange
            r13.processServerKeyExchange(r0)
            assertEmpty(r0)
            r12.connection_state = r1
            goto L_0x02e0
        L_0x0197:
            short r13 = r12.connection_state
            if (r13 == r5) goto L_0x01a4
            if (r13 != r3) goto L_0x019e
            goto L_0x01a7
        L_0x019e:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x01a4:
            r12.handleSupplementalData(r9)
        L_0x01a7:
            org.spongycastle.crypto.tls.Certificate r13 = org.spongycastle.crypto.tls.Certificate.parse(r0)
            r12.peerCertificate = r13
            assertEmpty(r0)
            org.spongycastle.crypto.tls.Certificate r13 = r12.peerCertificate
            if (r13 == 0) goto L_0x01bc
            org.spongycastle.crypto.tls.Certificate r13 = r12.peerCertificate
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x01bf
        L_0x01bc:
            r13 = 0
            r12.allowCertificateStatus = r13
        L_0x01bf:
            org.spongycastle.crypto.tls.TlsKeyExchange r13 = r12.keyExchange
            org.spongycastle.crypto.tls.Certificate r14 = r12.peerCertificate
            r13.processServerCertificate(r14)
            org.spongycastle.crypto.tls.TlsClient r13 = r12.tlsClient
            org.spongycastle.crypto.tls.TlsAuthentication r13 = r13.getAuthentication()
            r12.authentication = r13
            org.spongycastle.crypto.tls.Certificate r14 = r12.peerCertificate
            r13.notifyServerCertificate(r14)
            r12.connection_state = r11
            goto L_0x02e0
        L_0x01d7:
            short r13 = r12.connection_state
            if (r13 != r5) goto L_0x01e4
            java.util.Vector r13 = readSupplementalDataMessage(r0)
            r12.handleSupplementalData(r13)
            goto L_0x02e0
        L_0x01e4:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x01ea:
            short r13 = r12.connection_state
            if (r13 != r11) goto L_0x0205
            boolean r13 = r12.allowCertificateStatus
            if (r13 == 0) goto L_0x01ff
            org.spongycastle.crypto.tls.CertificateStatus r13 = org.spongycastle.crypto.tls.CertificateStatus.parse(r0)
            r12.certificateStatus = r13
            assertEmpty(r0)
            r12.connection_state = r2
            goto L_0x02e0
        L_0x01ff:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x0205:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x020b:
            short r13 = r12.connection_state
            if (r13 == r4) goto L_0x0218
            if (r13 != r10) goto L_0x0212
            goto L_0x021c
        L_0x0212:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x0218:
            boolean r13 = r12.expectSessionTicket
            if (r13 != 0) goto L_0x0225
        L_0x021c:
            r12.processFinishedMessage(r0)
            r12.connection_state = r1
            r12.connection_state = r3
            goto L_0x02e0
        L_0x0225:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x022b:
            short r13 = r12.connection_state
            if (r13 != r4) goto L_0x0243
            boolean r13 = r12.expectSessionTicket
            if (r13 == 0) goto L_0x023d
            r12.invalidateSession()
            r12.receiveNewSessionTicketMessage(r0)
            r12.connection_state = r10
            goto L_0x02c1
        L_0x023d:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x0243:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x0249:
            short r13 = r12.connection_state
            r14 = 1
            if (r13 != r14) goto L_0x02bb
            r12.receiveServerHelloMessage(r0)
            r12.connection_state = r5
            org.spongycastle.crypto.tls.SecurityParameters r13 = r12.securityParameters
            short r13 = r13.maxFragmentLength
            if (r13 < 0) goto L_0x0265
            org.spongycastle.crypto.tls.SecurityParameters r13 = r12.securityParameters
            short r13 = r13.maxFragmentLength
            int r13 = r13 + r8
            int r13 = r14 << r13
            org.spongycastle.crypto.tls.RecordStream r14 = r12.recordStream
            r14.setPlaintextLimit(r13)
        L_0x0265:
            org.spongycastle.crypto.tls.SecurityParameters r13 = r12.securityParameters
            org.spongycastle.crypto.tls.AbstractTlsContext r14 = r12.getContext()
            org.spongycastle.crypto.tls.SecurityParameters r0 = r12.securityParameters
            int r0 = r0.getCipherSuite()
            int r14 = getPRFAlgorithm(r14, r0)
            r13.prfAlgorithm = r14
            org.spongycastle.crypto.tls.SecurityParameters r13 = r12.securityParameters
            r13.verifyDataLength = r7
            org.spongycastle.crypto.tls.RecordStream r13 = r12.recordStream
            r13.notifyHelloComplete()
            boolean r13 = r12.resumedSession
            if (r13 == 0) goto L_0x02ab
            org.spongycastle.crypto.tls.SecurityParameters r13 = r12.securityParameters
            org.spongycastle.crypto.tls.SessionParameters r14 = r12.sessionParameters
            byte[] r14 = r14.getMasterSecret()
            byte[] r14 = org.spongycastle.util.Arrays.clone((byte[]) r14)
            r13.masterSecret = r14
            org.spongycastle.crypto.tls.RecordStream r13 = r12.recordStream
            org.spongycastle.crypto.tls.TlsPeer r14 = r12.getPeer()
            org.spongycastle.crypto.tls.TlsCompression r14 = r14.getCompression()
            org.spongycastle.crypto.tls.TlsPeer r0 = r12.getPeer()
            org.spongycastle.crypto.tls.TlsCipher r0 = r0.getCipher()
            r13.setPendingConnectionState(r14, r0)
            r12.sendChangeCipherSpecMessage()
            goto L_0x02e0
        L_0x02ab:
            r12.invalidateSession()
            byte[] r13 = r12.selectedSessionID
            int r14 = r13.length
            if (r14 <= 0) goto L_0x02e0
            org.spongycastle.crypto.tls.TlsSessionImpl r14 = new org.spongycastle.crypto.tls.TlsSessionImpl
            r14.<init>(r13, r9)
            r12.tlsSession = r14
            goto L_0x02e0
        L_0x02bb:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r6)
            throw r13
        L_0x02c1:
            assertEmpty(r0)
            short r13 = r12.connection_state
            if (r13 != r3) goto L_0x02e0
            org.spongycastle.crypto.tls.AbstractTlsContext r13 = r12.getContext()
            boolean r13 = org.spongycastle.crypto.tls.TlsUtils.isSSL(r13)
            if (r13 != 0) goto L_0x02da
            r13 = 100
            java.lang.String r14 = "Renegotiation not supported"
            r12.raiseWarning(r13, r14)
            goto L_0x02e0
        L_0x02da:
            org.spongycastle.crypto.tls.TlsFatalAlert r13 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r13.<init>(r14)
            throw r13
        L_0x02e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsClientProtocol.handleHandshakeMessage(short, byte[]):void");
    }

    /* access modifiers changed from: protected */
    public void handleSupplementalData(Vector vector) throws IOException {
        this.tlsClient.processServerSupplementalData(vector);
        this.connection_state = 3;
        TlsKeyExchange keyExchange2 = this.tlsClient.getKeyExchange();
        this.keyExchange = keyExchange2;
        keyExchange2.init(getContext());
    }

    /* access modifiers changed from: protected */
    public void receiveNewSessionTicketMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        NewSessionTicket parse = NewSessionTicket.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        this.tlsClient.notifyNewSessionTicket(parse);
    }

    /* access modifiers changed from: protected */
    public void receiveServerHelloMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        ProtocolVersion readVersion = TlsUtils.readVersion(byteArrayInputStream);
        if (readVersion.isDTLS()) {
            throw new TlsFatalAlert(47);
        } else if (!readVersion.equals(this.recordStream.getReadVersion())) {
            throw new TlsFatalAlert(47);
        } else if (readVersion.isEqualOrEarlierVersionOf(getContext().getClientVersion())) {
            this.recordStream.setWriteVersion(readVersion);
            getContext().setServerVersion(readVersion);
            this.tlsClient.notifyServerVersion(readVersion);
            this.securityParameters.serverRandom = TlsUtils.readFully(32, (InputStream) byteArrayInputStream);
            byte[] readOpaque8 = TlsUtils.readOpaque8(byteArrayInputStream);
            this.selectedSessionID = readOpaque8;
            if (readOpaque8.length <= 32) {
                this.tlsClient.notifySessionID(readOpaque8);
                boolean z = false;
                this.resumedSession = this.selectedSessionID.length > 0 && this.tlsSession != null && Arrays.areEqual(this.selectedSessionID, this.tlsSession.getSessionID());
                int readUint16 = TlsUtils.readUint16(byteArrayInputStream);
                if (!Arrays.contains(this.offeredCipherSuites, readUint16) || readUint16 == 0 || readUint16 == 255 || !TlsUtils.isValidCipherSuiteForVersion(readUint16, readVersion)) {
                    throw new TlsFatalAlert(47);
                }
                this.tlsClient.notifySelectedCipherSuite(readUint16);
                short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                if (Arrays.contains(this.offeredCompressionMethods, readUint8)) {
                    this.tlsClient.notifySelectedCompressionMethod(readUint8);
                    this.serverExtensions = readExtensions(byteArrayInputStream);
                    if (this.serverExtensions != null) {
                        Enumeration keys = this.serverExtensions.keys();
                        while (keys.hasMoreElements()) {
                            Integer num = (Integer) keys.nextElement();
                            if (!num.equals(EXT_RenegotiationInfo)) {
                                boolean z2 = this.resumedSession;
                                if (TlsUtils.getExtensionData(this.clientExtensions, num) == null) {
                                    throw new TlsFatalAlert(AlertDescription.unsupported_extension);
                                }
                            }
                        }
                    }
                    byte[] extensionData = TlsUtils.getExtensionData(this.serverExtensions, EXT_RenegotiationInfo);
                    if (extensionData != null) {
                        this.secure_renegotiation = true;
                        if (!Arrays.constantTimeAreEqual(extensionData, createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                            throw new TlsFatalAlert(40);
                        }
                    }
                    this.tlsClient.notifySecureRenegotiation(this.secure_renegotiation);
                    Hashtable hashtable = this.clientExtensions;
                    Hashtable hashtable2 = this.serverExtensions;
                    if (this.resumedSession) {
                        if (readUint16 == this.sessionParameters.getCipherSuite() && readUint8 == this.sessionParameters.getCompressionAlgorithm()) {
                            hashtable = null;
                            hashtable2 = this.sessionParameters.readServerExtensions();
                        } else {
                            throw new TlsFatalAlert(47);
                        }
                    }
                    this.securityParameters.cipherSuite = readUint16;
                    this.securityParameters.compressionAlgorithm = readUint8;
                    if (hashtable2 != null) {
                        boolean hasEncryptThenMACExtension = TlsExtensionsUtils.hasEncryptThenMACExtension(hashtable2);
                        if (!hasEncryptThenMACExtension || TlsUtils.isBlockCipherSuite(readUint16)) {
                            this.securityParameters.encryptThenMAC = hasEncryptThenMACExtension;
                            this.securityParameters.maxFragmentLength = processMaxFragmentLengthExtension(hashtable, hashtable2, 47);
                            this.securityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(hashtable2);
                            this.allowCertificateStatus = !this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(hashtable2, TlsExtensionsUtils.EXT_status_request, 47);
                            if (!this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(hashtable2, TlsProtocol.EXT_SessionTicket, 47)) {
                                z = true;
                            }
                            this.expectSessionTicket = z;
                        } else {
                            throw new TlsFatalAlert(47);
                        }
                    }
                    if (hashtable != null) {
                        this.tlsClient.processServerExtensions(hashtable2);
                        return;
                    }
                    return;
                }
                throw new TlsFatalAlert(47);
            }
            throw new TlsFatalAlert(47);
        } else {
            throw new TlsFatalAlert(47);
        }
    }

    /* access modifiers changed from: protected */
    public void sendCertificateVerifyMessage(DigitallySigned digitallySigned) throws IOException {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, 15);
        digitallySigned.encode(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }

    /* access modifiers changed from: protected */
    public void sendClientHelloMessage() throws IOException {
        this.recordStream.setWriteVersion(this.tlsClient.getClientHelloRecordLayerVersion());
        ProtocolVersion clientVersion = this.tlsClient.getClientVersion();
        if (!clientVersion.isDTLS()) {
            getContext().setClientVersion(clientVersion);
            byte[] bArr = TlsUtils.EMPTY_BYTES;
            if (this.tlsSession != null && ((bArr = this.tlsSession.getSessionID()) == null || bArr.length > 32)) {
                bArr = TlsUtils.EMPTY_BYTES;
            }
            this.offeredCipherSuites = this.tlsClient.getCipherSuites();
            this.offeredCompressionMethods = this.tlsClient.getCompressionMethods();
            if (bArr.length > 0 && this.sessionParameters != null && (!Arrays.contains(this.offeredCipherSuites, this.sessionParameters.getCipherSuite()) || !Arrays.contains(this.offeredCompressionMethods, this.sessionParameters.getCompressionAlgorithm()))) {
                bArr = TlsUtils.EMPTY_BYTES;
            }
            this.clientExtensions = this.tlsClient.getClientExtensions();
            TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, 1);
            TlsUtils.writeVersion(clientVersion, handshakeMessage);
            handshakeMessage.write(this.securityParameters.getClientRandom());
            TlsUtils.writeOpaque8(bArr, handshakeMessage);
            boolean z = TlsUtils.getExtensionData(this.clientExtensions, EXT_RenegotiationInfo) == null;
            boolean z2 = !Arrays.contains(this.offeredCipherSuites, 255);
            if (z && z2) {
                this.offeredCipherSuites = Arrays.append(this.offeredCipherSuites, 255);
            }
            TlsUtils.writeUint16ArrayWithUint16Length(this.offeredCipherSuites, handshakeMessage);
            TlsUtils.writeUint8ArrayWithUint8Length(this.offeredCompressionMethods, handshakeMessage);
            if (this.clientExtensions != null) {
                writeExtensions(handshakeMessage, this.clientExtensions);
            }
            handshakeMessage.writeToRecordStream();
            return;
        }
        throw new TlsFatalAlert(80);
    }

    /* access modifiers changed from: protected */
    public void sendClientKeyExchangeMessage() throws IOException {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, 16);
        this.keyExchange.generateClientKeyExchange(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }
}
