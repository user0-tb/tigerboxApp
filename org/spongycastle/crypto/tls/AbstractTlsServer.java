package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.util.Arrays;

public abstract class AbstractTlsServer extends AbstractTlsPeer implements TlsServer {
    protected TlsCipherFactory cipherFactory;
    protected short[] clientECPointFormats;
    protected Hashtable clientExtensions;
    protected ProtocolVersion clientVersion;
    protected TlsServerContext context;
    protected boolean eccCipherSuitesOffered;
    protected boolean encryptThenMACOffered;
    protected short maxFragmentLengthOffered;
    protected int[] namedCurves;
    protected int[] offeredCipherSuites;
    protected short[] offeredCompressionMethods;
    protected int selectedCipherSuite;
    protected short selectedCompressionMethod;
    protected short[] serverECPointFormats;
    protected Hashtable serverExtensions;
    protected ProtocolVersion serverVersion;
    protected Vector supportedSignatureAlgorithms;
    protected boolean truncatedHMacOffered;

    /* access modifiers changed from: protected */
    public boolean allowEncryptThenMAC() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean allowTruncatedHMac() {
        return false;
    }

    public CertificateRequest getCertificateRequest() throws IOException {
        return null;
    }

    public CertificateStatus getCertificateStatus() throws IOException {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract int[] getCipherSuites();

    /* access modifiers changed from: protected */
    public short[] getCompressionMethods() {
        return new short[]{0};
    }

    public Vector getServerSupplementalData() throws IOException {
        return null;
    }

    public AbstractTlsServer() {
        this(new DefaultTlsCipherFactory());
    }

    public AbstractTlsServer(TlsCipherFactory tlsCipherFactory) {
        this.cipherFactory = tlsCipherFactory;
    }

    /* access modifiers changed from: protected */
    public Hashtable checkServerExtensions() {
        Hashtable ensureExtensionsInitialised = TlsExtensionsUtils.ensureExtensionsInitialised(this.serverExtensions);
        this.serverExtensions = ensureExtensionsInitialised;
        return ensureExtensionsInitialised;
    }

    /* access modifiers changed from: protected */
    public ProtocolVersion getMaximumVersion() {
        return ProtocolVersion.TLSv11;
    }

    /* access modifiers changed from: protected */
    public ProtocolVersion getMinimumVersion() {
        return ProtocolVersion.TLSv10;
    }

    /* access modifiers changed from: protected */
    public boolean supportsClientECCCapabilities(int[] iArr, short[] sArr) {
        if (iArr == null) {
            return TlsECCUtils.hasAnySupportedNamedCurves();
        }
        for (int i : iArr) {
            if (NamedCurve.isValid(i) && (!NamedCurve.refersToASpecificNamedCurve(i) || TlsECCUtils.isSupportedNamedCurve(i))) {
                return true;
            }
        }
        return false;
    }

    public void init(TlsServerContext tlsServerContext) {
        this.context = tlsServerContext;
    }

    public void notifyClientVersion(ProtocolVersion protocolVersion) throws IOException {
        this.clientVersion = protocolVersion;
    }

    public void notifyOfferedCipherSuites(int[] iArr) throws IOException {
        this.offeredCipherSuites = iArr;
        this.eccCipherSuitesOffered = TlsECCUtils.containsECCCipherSuites(iArr);
    }

    public void notifyOfferedCompressionMethods(short[] sArr) throws IOException {
        this.offeredCompressionMethods = sArr;
    }

    public void processClientExtensions(Hashtable hashtable) throws IOException {
        this.clientExtensions = hashtable;
        if (hashtable != null) {
            this.encryptThenMACOffered = TlsExtensionsUtils.hasEncryptThenMACExtension(hashtable);
            this.maxFragmentLengthOffered = TlsExtensionsUtils.getMaxFragmentLengthExtension(hashtable);
            this.truncatedHMacOffered = TlsExtensionsUtils.hasTruncatedHMacExtension(hashtable);
            Vector signatureAlgorithmsExtension = TlsUtils.getSignatureAlgorithmsExtension(hashtable);
            this.supportedSignatureAlgorithms = signatureAlgorithmsExtension;
            if (signatureAlgorithmsExtension == null || TlsUtils.isSignatureAlgorithmsExtensionAllowed(this.clientVersion)) {
                this.namedCurves = TlsECCUtils.getSupportedEllipticCurvesExtension(hashtable);
                this.clientECPointFormats = TlsECCUtils.getSupportedPointFormatsExtension(hashtable);
            } else {
                throw new TlsFatalAlert(47);
            }
        }
        if (this.eccCipherSuitesOffered) {
            return;
        }
        if (this.namedCurves != null || this.clientECPointFormats != null) {
            throw new TlsFatalAlert(47);
        }
    }

    public ProtocolVersion getServerVersion() throws IOException {
        if (getMinimumVersion().isEqualOrEarlierVersionOf(this.clientVersion)) {
            ProtocolVersion maximumVersion = getMaximumVersion();
            if (this.clientVersion.isEqualOrEarlierVersionOf(maximumVersion)) {
                ProtocolVersion protocolVersion = this.clientVersion;
                this.serverVersion = protocolVersion;
                return protocolVersion;
            } else if (this.clientVersion.isLaterVersionOf(maximumVersion)) {
                this.serverVersion = maximumVersion;
                return maximumVersion;
            }
        }
        throw new TlsFatalAlert(70);
    }

    public int getSelectedCipherSuite() throws IOException {
        boolean supportsClientECCCapabilities = supportsClientECCCapabilities(this.namedCurves, this.clientECPointFormats);
        int[] cipherSuites = getCipherSuites();
        int i = 0;
        while (i < cipherSuites.length) {
            int i2 = cipherSuites[i];
            if (!Arrays.contains(this.offeredCipherSuites, i2) || ((!supportsClientECCCapabilities && TlsECCUtils.isECCCipherSuite(i2)) || !TlsUtils.isValidCipherSuiteForVersion(i2, this.serverVersion))) {
                i++;
            } else {
                this.selectedCipherSuite = i2;
                return i2;
            }
        }
        throw new TlsFatalAlert(40);
    }

    public short getSelectedCompressionMethod() throws IOException {
        short[] compressionMethods = getCompressionMethods();
        for (int i = 0; i < compressionMethods.length; i++) {
            if (Arrays.contains(this.offeredCompressionMethods, compressionMethods[i])) {
                short s = compressionMethods[i];
                this.selectedCompressionMethod = s;
                return s;
            }
        }
        throw new TlsFatalAlert(40);
    }

    public Hashtable getServerExtensions() throws IOException {
        if (this.encryptThenMACOffered && allowEncryptThenMAC() && TlsUtils.isBlockCipherSuite(this.selectedCipherSuite)) {
            TlsExtensionsUtils.addEncryptThenMACExtension(checkServerExtensions());
        }
        if (this.maxFragmentLengthOffered >= 0) {
            TlsExtensionsUtils.addMaxFragmentLengthExtension(checkServerExtensions(), this.maxFragmentLengthOffered);
        }
        if (this.truncatedHMacOffered && allowTruncatedHMac()) {
            TlsExtensionsUtils.addTruncatedHMacExtension(checkServerExtensions());
        }
        if (this.clientECPointFormats != null && TlsECCUtils.isECCCipherSuite(this.selectedCipherSuite)) {
            this.serverECPointFormats = new short[]{0, 1, 2};
            TlsECCUtils.addSupportedPointFormatsExtension(checkServerExtensions(), this.serverECPointFormats);
        }
        return this.serverExtensions;
    }

    public void processClientSupplementalData(Vector vector) throws IOException {
        if (vector != null) {
            throw new TlsFatalAlert(10);
        }
    }

    public void notifyClientCertificate(Certificate certificate) throws IOException {
        throw new TlsFatalAlert(80);
    }

    public TlsCompression getCompression() throws IOException {
        if (this.selectedCompressionMethod == 0) {
            return new TlsNullCompression();
        }
        throw new TlsFatalAlert(80);
    }

    public NewSessionTicket getNewSessionTicket() throws IOException {
        return new NewSessionTicket(0, TlsUtils.EMPTY_BYTES);
    }
}
