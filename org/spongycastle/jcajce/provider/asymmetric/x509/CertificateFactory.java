package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.asn1.x509.CertificateList;

public class CertificateFactory extends CertificateFactorySpi {
    private static final PEMUtil PEM_CERT_PARSER = new PEMUtil("CERTIFICATE");
    private static final PEMUtil PEM_CRL_PARSER = new PEMUtil("CRL");
    private InputStream currentCrlStream = null;
    private InputStream currentStream = null;
    private ASN1Set sCrlData = null;
    private int sCrlDataObjectCount = 0;
    private ASN1Set sData = null;
    private int sDataObjectCount = 0;

    private Certificate readDERCertificate(ASN1InputStream aSN1InputStream) throws IOException, CertificateParsingException {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1InputStream.readObject();
        if (aSN1Sequence.size() <= 1 || !(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            return new X509CertificateObject(org.spongycastle.asn1.x509.Certificate.getInstance(aSN1Sequence));
        }
        this.sData = SignedData.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).getCertificates();
        return getCertificate();
    }

    private Certificate getCertificate() throws CertificateParsingException {
        if (this.sData == null) {
            return null;
        }
        while (this.sDataObjectCount < this.sData.size()) {
            ASN1Set aSN1Set = this.sData;
            int i = this.sDataObjectCount;
            this.sDataObjectCount = i + 1;
            ASN1Encodable objectAt = aSN1Set.getObjectAt(i);
            if (objectAt instanceof ASN1Sequence) {
                return new X509CertificateObject(org.spongycastle.asn1.x509.Certificate.getInstance(objectAt));
            }
        }
        return null;
    }

    private Certificate readPEMCertificate(InputStream inputStream) throws IOException, CertificateParsingException {
        ASN1Sequence readPEMObject = PEM_CERT_PARSER.readPEMObject(inputStream);
        if (readPEMObject != null) {
            return new X509CertificateObject(org.spongycastle.asn1.x509.Certificate.getInstance(readPEMObject));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public CRL createCRL(CertificateList certificateList) throws CRLException {
        return new X509CRLObject(certificateList);
    }

    private CRL readPEMCRL(InputStream inputStream) throws IOException, CRLException {
        ASN1Sequence readPEMObject = PEM_CRL_PARSER.readPEMObject(inputStream);
        if (readPEMObject != null) {
            return createCRL(CertificateList.getInstance(readPEMObject));
        }
        return null;
    }

    private CRL readDERCRL(ASN1InputStream aSN1InputStream) throws IOException, CRLException {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1InputStream.readObject();
        if (aSN1Sequence.size() <= 1 || !(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            return createCRL(CertificateList.getInstance(aSN1Sequence));
        }
        this.sCrlData = SignedData.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).getCRLs();
        return getCRL();
    }

    private CRL getCRL() throws CRLException {
        ASN1Set aSN1Set = this.sCrlData;
        if (aSN1Set == null || this.sCrlDataObjectCount >= aSN1Set.size()) {
            return null;
        }
        ASN1Set aSN1Set2 = this.sCrlData;
        int i = this.sCrlDataObjectCount;
        this.sCrlDataObjectCount = i + 1;
        return createCRL(CertificateList.getInstance(aSN1Set2.getObjectAt(i)));
    }

    public Certificate engineGenerateCertificate(InputStream inputStream) throws CertificateException {
        InputStream inputStream2 = this.currentStream;
        if (inputStream2 == null) {
            this.currentStream = inputStream;
            this.sData = null;
            this.sDataObjectCount = 0;
        } else if (inputStream2 != inputStream) {
            this.currentStream = inputStream;
            this.sData = null;
            this.sDataObjectCount = 0;
        }
        try {
            ASN1Set aSN1Set = this.sData;
            if (aSN1Set == null) {
                PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
                int read = pushbackInputStream.read();
                if (read == -1) {
                    return null;
                }
                pushbackInputStream.unread(read);
                if (read != 48) {
                    return readPEMCertificate(pushbackInputStream);
                }
                return readDERCertificate(new ASN1InputStream((InputStream) pushbackInputStream));
            } else if (this.sDataObjectCount != aSN1Set.size()) {
                return getCertificate();
            } else {
                this.sData = null;
                this.sDataObjectCount = 0;
                return null;
            }
        } catch (Exception e) {
            throw new ExCertificateException(e);
        }
    }

    public Collection engineGenerateCertificates(InputStream inputStream) throws CertificateException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Certificate engineGenerateCertificate = engineGenerateCertificate(inputStream);
            if (engineGenerateCertificate == null) {
                return arrayList;
            }
            arrayList.add(engineGenerateCertificate);
        }
    }

    public CRL engineGenerateCRL(InputStream inputStream) throws CRLException {
        InputStream inputStream2 = this.currentCrlStream;
        if (inputStream2 == null) {
            this.currentCrlStream = inputStream;
            this.sCrlData = null;
            this.sCrlDataObjectCount = 0;
        } else if (inputStream2 != inputStream) {
            this.currentCrlStream = inputStream;
            this.sCrlData = null;
            this.sCrlDataObjectCount = 0;
        }
        try {
            ASN1Set aSN1Set = this.sCrlData;
            if (aSN1Set == null) {
                PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
                int read = pushbackInputStream.read();
                if (read == -1) {
                    return null;
                }
                pushbackInputStream.unread(read);
                if (read != 48) {
                    return readPEMCRL(pushbackInputStream);
                }
                return readDERCRL(new ASN1InputStream((InputStream) pushbackInputStream, true));
            } else if (this.sCrlDataObjectCount != aSN1Set.size()) {
                return getCRL();
            } else {
                this.sCrlData = null;
                this.sCrlDataObjectCount = 0;
                return null;
            }
        } catch (CRLException e) {
            throw e;
        } catch (Exception e2) {
            throw new CRLException(e2.toString());
        }
    }

    public Collection engineGenerateCRLs(InputStream inputStream) throws CRLException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            CRL engineGenerateCRL = engineGenerateCRL(inputStream);
            if (engineGenerateCRL == null) {
                return arrayList;
            }
            arrayList.add(engineGenerateCRL);
        }
    }

    public Iterator engineGetCertPathEncodings() {
        return PKIXCertPath.certPathEncodings.iterator();
    }

    public CertPath engineGenerateCertPath(InputStream inputStream) throws CertificateException {
        return engineGenerateCertPath(inputStream, "PkiPath");
    }

    public CertPath engineGenerateCertPath(InputStream inputStream, String str) throws CertificateException {
        return new PKIXCertPath(inputStream, str);
    }

    public CertPath engineGenerateCertPath(List list) throws CertificateException {
        for (Object next : list) {
            if (next != null && !(next instanceof X509Certificate)) {
                throw new CertificateException("list contains non X509Certificate object while creating CertPath\n" + next.toString());
            }
        }
        return new PKIXCertPath(list);
    }

    private class ExCertificateException extends CertificateException {
        private Throwable cause;

        public ExCertificateException(Throwable th) {
            this.cause = th;
        }

        public ExCertificateException(String str, Throwable th) {
            super(str);
            this.cause = th;
        }

        public Throwable getCause() {
            return this.cause;
        }
    }
}
