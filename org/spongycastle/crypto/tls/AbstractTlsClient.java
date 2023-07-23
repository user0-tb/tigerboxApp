package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

public abstract class AbstractTlsClient extends AbstractTlsPeer implements TlsClient {
    protected TlsCipherFactory cipherFactory;
    protected short[] clientECPointFormats;
    protected TlsClientContext context;
    protected int[] namedCurves;
    protected int selectedCipherSuite;
    protected short selectedCompressionMethod;
    protected short[] serverECPointFormats;
    protected Vector supportedSignatureAlgorithms;

    public Vector getClientSupplementalData() throws IOException {
        return null;
    }

    public short[] getCompressionMethods() {
        return new short[]{0};
    }

    public TlsSession getSessionToResume() {
        return null;
    }

    public void notifyNewSessionTicket(NewSessionTicket newSessionTicket) throws IOException {
    }

    public void notifySessionID(byte[] bArr) {
    }

    public AbstractTlsClient() {
        this(new DefaultTlsCipherFactory());
    }

    public AbstractTlsClient(TlsCipherFactory tlsCipherFactory) {
        this.cipherFactory = tlsCipherFactory;
    }

    public void init(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
    }

    public ProtocolVersion getClientHelloRecordLayerVersion() {
        return getClientVersion();
    }

    public ProtocolVersion getClientVersion() {
        return ProtocolVersion.TLSv12;
    }

    public Hashtable getClientExtensions() throws IOException {
        Hashtable hashtable = null;
        if (TlsUtils.isSignatureAlgorithmsExtensionAllowed(this.context.getClientVersion())) {
            short[] sArr = {6, 5, 4, 3, 2};
            short[] sArr2 = {1};
            this.supportedSignatureAlgorithms = new Vector();
            for (int i = 0; i < 5; i++) {
                for (int i2 = 0; i2 < 1; i2++) {
                    this.supportedSignatureAlgorithms.addElement(new SignatureAndHashAlgorithm(sArr[i], sArr2[i2]));
                }
            }
            this.supportedSignatureAlgorithms.addElement(new SignatureAndHashAlgorithm(2, 2));
            hashtable = TlsExtensionsUtils.ensureExtensionsInitialised((Hashtable) null);
            TlsUtils.addSignatureAlgorithmsExtension(hashtable, this.supportedSignatureAlgorithms);
        }
        if (!TlsECCUtils.containsECCCipherSuites(getCipherSuites())) {
            return hashtable;
        }
        this.namedCurves = new int[]{23, 24};
        this.clientECPointFormats = new short[]{0, 1, 2};
        Hashtable ensureExtensionsInitialised = TlsExtensionsUtils.ensureExtensionsInitialised(hashtable);
        TlsECCUtils.addSupportedEllipticCurvesExtension(ensureExtensionsInitialised, this.namedCurves);
        TlsECCUtils.addSupportedPointFormatsExtension(ensureExtensionsInitialised, this.clientECPointFormats);
        return ensureExtensionsInitialised;
    }

    public ProtocolVersion getMinimumVersion() {
        return ProtocolVersion.TLSv10;
    }

    public void notifyServerVersion(ProtocolVersion protocolVersion) throws IOException {
        if (!getMinimumVersion().isEqualOrEarlierVersionOf(protocolVersion)) {
            throw new TlsFatalAlert(70);
        }
    }

    public void notifySelectedCipherSuite(int i) {
        this.selectedCipherSuite = i;
    }

    public void notifySelectedCompressionMethod(short s) {
        this.selectedCompressionMethod = s;
    }

    public void processServerExtensions(Hashtable hashtable) throws IOException {
        if (hashtable == null) {
            return;
        }
        if (hashtable.containsKey(TlsUtils.EXT_signature_algorithms)) {
            throw new TlsFatalAlert(47);
        } else if (TlsECCUtils.getSupportedEllipticCurvesExtension(hashtable) == null) {
            short[] supportedPointFormatsExtension = TlsECCUtils.getSupportedPointFormatsExtension(hashtable);
            this.serverECPointFormats = supportedPointFormatsExtension;
            if (supportedPointFormatsExtension != null && !TlsECCUtils.isECCCipherSuite(this.selectedCipherSuite)) {
                throw new TlsFatalAlert(47);
            }
        } else {
            throw new TlsFatalAlert(47);
        }
    }

    public void processServerSupplementalData(Vector vector) throws IOException {
        if (vector != null) {
            throw new TlsFatalAlert(10);
        }
    }

    public TlsCompression getCompression() throws IOException {
        if (this.selectedCompressionMethod == 0) {
            return new TlsNullCompression();
        }
        throw new TlsFatalAlert(80);
    }
}
