package org.spongycastle.openssl;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.p020x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.cert.X509AttributeCertificateHolder;
import org.spongycastle.cert.X509CRLHolder;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.pkcs.PKCS10CertificationRequest;
import org.spongycastle.util.Strings;
import org.spongycastle.util.p033io.pem.PemGenerationException;
import org.spongycastle.util.p033io.pem.PemHeader;
import org.spongycastle.util.p033io.pem.PemObject;
import org.spongycastle.util.p033io.pem.PemObjectGenerator;

public class MiscPEMGenerator implements PemObjectGenerator {
    private static final ASN1ObjectIdentifier[] dsaOids = {X9ObjectIdentifiers.id_dsa, OIWObjectIdentifiers.dsaWithSHA1};
    private static final byte[] hexEncodingTable = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    private final PEMEncryptor encryptor;
    private final Object obj;

    public MiscPEMGenerator(Object obj2) {
        this.obj = obj2;
        this.encryptor = null;
    }

    public MiscPEMGenerator(Object obj2, PEMEncryptor pEMEncryptor) {
        this.obj = obj2;
        this.encryptor = pEMEncryptor;
    }

    private PemObject createPemObject(Object obj2) throws IOException {
        byte[] bArr;
        String str;
        if (obj2 instanceof PemObject) {
            return (PemObject) obj2;
        }
        if (obj2 instanceof PemObjectGenerator) {
            return ((PemObjectGenerator) obj2).generate();
        }
        if (obj2 instanceof X509CertificateHolder) {
            bArr = ((X509CertificateHolder) obj2).getEncoded();
            str = "CERTIFICATE";
        } else if (obj2 instanceof X509CRLHolder) {
            bArr = ((X509CRLHolder) obj2).getEncoded();
            str = "X509 CRL";
        } else if (obj2 instanceof PrivateKeyInfo) {
            PrivateKeyInfo privateKeyInfo = (PrivateKeyInfo) obj2;
            ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
            if (algorithm.equals(PKCSObjectIdentifiers.rsaEncryption)) {
                bArr = privateKeyInfo.parsePrivateKey().toASN1Primitive().getEncoded();
                str = "RSA PRIVATE KEY";
            } else {
                ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = dsaOids;
                if (algorithm.equals(aSN1ObjectIdentifierArr[0]) || algorithm.equals(aSN1ObjectIdentifierArr[1])) {
                    DSAParameter instance = DSAParameter.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    aSN1EncodableVector.add(new ASN1Integer(0));
                    aSN1EncodableVector.add(new ASN1Integer(instance.getP()));
                    aSN1EncodableVector.add(new ASN1Integer(instance.getQ()));
                    aSN1EncodableVector.add(new ASN1Integer(instance.getG()));
                    BigInteger value = ASN1Integer.getInstance(privateKeyInfo.parsePrivateKey()).getValue();
                    aSN1EncodableVector.add(new ASN1Integer(instance.getG().modPow(value, instance.getP())));
                    aSN1EncodableVector.add(new ASN1Integer(value));
                    bArr = new DERSequence(aSN1EncodableVector).getEncoded();
                    str = "DSA PRIVATE KEY";
                } else if (algorithm.equals(X9ObjectIdentifiers.id_ecPublicKey)) {
                    bArr = privateKeyInfo.parsePrivateKey().toASN1Primitive().getEncoded();
                    str = "EC PRIVATE KEY";
                } else {
                    throw new IOException("Cannot identify private key");
                }
            }
        } else if (obj2 instanceof SubjectPublicKeyInfo) {
            bArr = ((SubjectPublicKeyInfo) obj2).getEncoded();
            str = "PUBLIC KEY";
        } else if (obj2 instanceof X509AttributeCertificateHolder) {
            bArr = ((X509AttributeCertificateHolder) obj2).getEncoded();
            str = "ATTRIBUTE CERTIFICATE";
        } else if (obj2 instanceof PKCS10CertificationRequest) {
            bArr = ((PKCS10CertificationRequest) obj2).getEncoded();
            str = "CERTIFICATE REQUEST";
        } else if (obj2 instanceof ContentInfo) {
            bArr = ((ContentInfo) obj2).getEncoded();
            str = "PKCS7";
        } else {
            throw new PemGenerationException("unknown object passed - can't encode.");
        }
        PEMEncryptor pEMEncryptor = this.encryptor;
        if (pEMEncryptor == null) {
            return new PemObject(str, bArr);
        }
        String upperCase = Strings.toUpperCase(pEMEncryptor.getAlgorithm());
        if (upperCase.equals("DESEDE")) {
            upperCase = "DES-EDE3-CBC";
        }
        byte[] iv = this.encryptor.getIV();
        byte[] encrypt = this.encryptor.encrypt(bArr);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new PemHeader("Proc-Type", "4,ENCRYPTED"));
        arrayList.add(new PemHeader("DEK-Info", upperCase + "," + getHexEncoded(iv)));
        return new PemObject(str, arrayList, encrypt);
    }

    private String getHexEncoded(byte[] bArr) throws IOException {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i != bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 2;
            byte[] bArr2 = hexEncodingTable;
            cArr[i2] = (char) bArr2[b >>> 4];
            cArr[i2 + 1] = (char) bArr2[b & Ascii.f278SI];
        }
        return new String(cArr);
    }

    public PemObject generate() throws PemGenerationException {
        try {
            return createPemObject(this.obj);
        } catch (IOException e) {
            throw new PemGenerationException("encoding exception: " + e.getMessage(), e);
        }
    }
}
