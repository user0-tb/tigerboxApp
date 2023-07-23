package org.spongycastle.cert.jcajce;

import java.io.IOException;
import org.spongycastle.asn1.x509.AttributeCertificate;
import org.spongycastle.cert.X509AttributeCertificateHolder;
import org.spongycastle.x509.X509AttributeCertificate;

public class JcaX509AttributeCertificateHolder extends X509AttributeCertificateHolder {
    public JcaX509AttributeCertificateHolder(X509AttributeCertificate x509AttributeCertificate) throws IOException {
        super(AttributeCertificate.getInstance(x509AttributeCertificate.getEncoded()));
    }
}
