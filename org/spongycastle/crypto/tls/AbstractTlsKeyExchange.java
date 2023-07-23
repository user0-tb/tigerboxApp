package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public abstract class AbstractTlsKeyExchange implements TlsKeyExchange {
    protected TlsContext context;
    protected int keyExchange;
    protected Vector supportedSignatureAlgorithms;

    public void processClientCertificate(Certificate certificate) throws IOException {
    }

    public void processServerCertificate(Certificate certificate) throws IOException {
    }

    public boolean requiresServerKeyExchange() {
        return false;
    }

    public void skipClientCredentials() throws IOException {
    }

    protected AbstractTlsKeyExchange(int i, Vector vector) {
        this.keyExchange = i;
        this.supportedSignatureAlgorithms = vector;
    }

    public void init(TlsContext tlsContext) {
        this.context = tlsContext;
        ProtocolVersion clientVersion = tlsContext.getClientVersion();
        if (TlsUtils.isSignatureAlgorithmsExtensionAllowed(clientVersion)) {
            if (this.supportedSignatureAlgorithms == null) {
                int i = this.keyExchange;
                if (i != 1) {
                    if (i != 3) {
                        if (i != 5) {
                            if (i != 7) {
                                if (i != 9) {
                                    switch (i) {
                                        case 13:
                                        case 14:
                                            return;
                                        case 15:
                                        case 18:
                                        case 19:
                                            break;
                                        case 16:
                                        case 17:
                                            this.supportedSignatureAlgorithms = TlsUtils.getDefaultECDSASignatureAlgorithms();
                                            return;
                                        default:
                                            switch (i) {
                                                case 21:
                                                case 24:
                                                    return;
                                                case 22:
                                                    break;
                                                case 23:
                                                    break;
                                                default:
                                                    throw new IllegalStateException("unsupported key exchange algorithm");
                                            }
                                    }
                                }
                            }
                        }
                    }
                    this.supportedSignatureAlgorithms = TlsUtils.getDefaultDSSSignatureAlgorithms();
                    return;
                }
                this.supportedSignatureAlgorithms = TlsUtils.getDefaultRSASignatureAlgorithms();
            }
        } else if (this.supportedSignatureAlgorithms != null) {
            throw new IllegalStateException("supported_signature_algorithms not allowed for " + clientVersion);
        }
    }

    public void processServerCredentials(TlsCredentials tlsCredentials) throws IOException {
        processServerCertificate(tlsCredentials.getCertificate());
    }

    public byte[] generateServerKeyExchange() throws IOException {
        if (!requiresServerKeyExchange()) {
            return null;
        }
        throw new TlsFatalAlert(80);
    }

    public void skipServerKeyExchange() throws IOException {
        if (requiresServerKeyExchange()) {
            throw new TlsFatalAlert(10);
        }
    }

    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        if (!requiresServerKeyExchange()) {
            throw new TlsFatalAlert(10);
        }
    }

    public void processClientKeyExchange(InputStream inputStream) throws IOException {
        throw new TlsFatalAlert(80);
    }
}
