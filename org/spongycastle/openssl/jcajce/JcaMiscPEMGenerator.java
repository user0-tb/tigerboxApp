package org.spongycastle.openssl.jcajce;

import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.cert.jcajce.JcaX509AttributeCertificateHolder;
import org.spongycastle.cert.jcajce.JcaX509CRLHolder;
import org.spongycastle.cert.jcajce.JcaX509CertificateHolder;
import org.spongycastle.jce.PKCS10CertificationRequest;
import org.spongycastle.openssl.MiscPEMGenerator;
import org.spongycastle.openssl.PEMEncryptor;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509V2AttributeCertificate;

public class JcaMiscPEMGenerator extends MiscPEMGenerator {
    private String algorithm;
    private Object obj;
    private char[] password;
    private Provider provider;
    private SecureRandom random;

    public JcaMiscPEMGenerator(Object obj2) throws IOException {
        super(convertObject(obj2));
    }

    public JcaMiscPEMGenerator(Object obj2, PEMEncryptor pEMEncryptor) throws IOException {
        super(convertObject(obj2), pEMEncryptor);
    }

    private static Object convertObject(Object obj2) throws IOException {
        if (obj2 instanceof X509Certificate) {
            try {
                return new JcaX509CertificateHolder((X509Certificate) obj2);
            } catch (CertificateEncodingException e) {
                throw new IllegalArgumentException("Cannot encode object: " + e.toString());
            }
        } else if (obj2 instanceof X509CRL) {
            try {
                return new JcaX509CRLHolder((X509CRL) obj2);
            } catch (CRLException e2) {
                throw new IllegalArgumentException("Cannot encode object: " + e2.toString());
            }
        } else if (obj2 instanceof KeyPair) {
            return convertObject(((KeyPair) obj2).getPrivate());
        } else {
            if (obj2 instanceof PrivateKey) {
                return PrivateKeyInfo.getInstance(((Key) obj2).getEncoded());
            }
            if (obj2 instanceof PublicKey) {
                return SubjectPublicKeyInfo.getInstance(((PublicKey) obj2).getEncoded());
            }
            if (obj2 instanceof X509AttributeCertificate) {
                return new JcaX509AttributeCertificateHolder((X509V2AttributeCertificate) obj2);
            }
            return obj2 instanceof PKCS10CertificationRequest ? new org.spongycastle.pkcs.PKCS10CertificationRequest(((PKCS10CertificationRequest) obj2).getEncoded()) : obj2;
        }
    }
}
