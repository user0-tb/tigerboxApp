package org.spongycastle.crypto.util;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class PublicKeyFactory {
    public static AsymmetricKeyParameter createKey(byte[] bArr) throws IOException {
        return createKey(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
    }

    public static AsymmetricKeyParameter createKey(InputStream inputStream) throws IOException {
        return createKey(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: org.spongycastle.crypto.params.DSAParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: org.spongycastle.crypto.params.DSAParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: org.spongycastle.crypto.params.DSAParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: org.spongycastle.crypto.params.DHValidationParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: org.spongycastle.crypto.params.DSAParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: org.spongycastle.crypto.params.DSAParameters} */
    /* JADX WARNING: type inference failed for: r8v0, types: [org.spongycastle.crypto.params.ECDomainParameters] */
    /* JADX WARNING: type inference failed for: r3v9, types: [org.spongycastle.crypto.params.DHValidationParameters] */
    /* JADX WARNING: type inference failed for: r1v34, types: [org.spongycastle.crypto.params.ECDomainParameters] */
    /* JADX WARNING: type inference failed for: r1v35, types: [org.spongycastle.crypto.params.ECNamedDomainParameters] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.spongycastle.crypto.params.AsymmetricKeyParameter createKey(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r10) throws java.io.IOException {
        /*
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r10.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.rsaEncryption
            boolean r1 = r1.equals(r2)
            r2 = 0
            if (r1 != 0) goto L_0x01df
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.x509.X509ObjectIdentifiers.id_ea_rsa
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x001f
            goto L_0x01df
        L_0x001f:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.p020x9.X9ObjectIdentifiers.dhpublicnumber
            boolean r1 = r1.equals(r3)
            r3 = 0
            if (r1 == 0) goto L_0x0099
            org.spongycastle.asn1.ASN1Primitive r10 = r10.parsePublicKey()
            org.spongycastle.asn1.x9.DHPublicKey r10 = org.spongycastle.asn1.p020x9.DHPublicKey.getInstance(r10)
            org.spongycastle.asn1.ASN1Integer r10 = r10.getY()
            java.math.BigInteger r10 = r10.getValue()
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.x9.DHDomainParameters r0 = org.spongycastle.asn1.p020x9.DHDomainParameters.getInstance(r0)
            org.spongycastle.asn1.ASN1Integer r1 = r0.getP()
            java.math.BigInteger r5 = r1.getValue()
            org.spongycastle.asn1.ASN1Integer r1 = r0.getG()
            java.math.BigInteger r6 = r1.getValue()
            org.spongycastle.asn1.ASN1Integer r1 = r0.getQ()
            java.math.BigInteger r7 = r1.getValue()
            org.spongycastle.asn1.ASN1Integer r1 = r0.getJ()
            if (r1 == 0) goto L_0x006c
            org.spongycastle.asn1.ASN1Integer r1 = r0.getJ()
            java.math.BigInteger r1 = r1.getValue()
            r8 = r1
            goto L_0x006d
        L_0x006c:
            r8 = r3
        L_0x006d:
            org.spongycastle.asn1.x9.DHValidationParms r0 = r0.getValidationParms()
            if (r0 == 0) goto L_0x008c
            org.spongycastle.asn1.DERBitString r1 = r0.getSeed()
            byte[] r1 = r1.getBytes()
            org.spongycastle.asn1.ASN1Integer r0 = r0.getPgenCounter()
            java.math.BigInteger r0 = r0.getValue()
            org.spongycastle.crypto.params.DHValidationParameters r3 = new org.spongycastle.crypto.params.DHValidationParameters
            int r0 = r0.intValue()
            r3.<init>(r1, r0)
        L_0x008c:
            r9 = r3
            org.spongycastle.crypto.params.DHPublicKeyParameters r0 = new org.spongycastle.crypto.params.DHPublicKeyParameters
            org.spongycastle.crypto.params.DHParameters r1 = new org.spongycastle.crypto.params.DHParameters
            r4 = r1
            r4.<init>((java.math.BigInteger) r5, (java.math.BigInteger) r6, (java.math.BigInteger) r7, (java.math.BigInteger) r8, (org.spongycastle.crypto.params.DHValidationParameters) r9)
            r0.<init>(r10, r1)
            return r0
        L_0x0099:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.dhKeyAgreement
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00d5
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.pkcs.DHParameter r0 = org.spongycastle.asn1.pkcs.DHParameter.getInstance(r0)
            org.spongycastle.asn1.ASN1Primitive r10 = r10.parsePublicKey()
            org.spongycastle.asn1.ASN1Integer r10 = (org.spongycastle.asn1.ASN1Integer) r10
            java.math.BigInteger r1 = r0.getL()
            if (r1 != 0) goto L_0x00ba
            goto L_0x00be
        L_0x00ba:
            int r2 = r1.intValue()
        L_0x00be:
            org.spongycastle.crypto.params.DHParameters r1 = new org.spongycastle.crypto.params.DHParameters
            java.math.BigInteger r4 = r0.getP()
            java.math.BigInteger r0 = r0.getG()
            r1.<init>(r4, r0, r3, r2)
            org.spongycastle.crypto.params.DHPublicKeyParameters r0 = new org.spongycastle.crypto.params.DHPublicKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            r0.<init>(r10, r1)
            return r0
        L_0x00d5:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.oiw.OIWObjectIdentifiers.elGamalAlgorithm
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0106
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.oiw.ElGamalParameter r0 = org.spongycastle.asn1.oiw.ElGamalParameter.getInstance(r0)
            org.spongycastle.asn1.ASN1Primitive r10 = r10.parsePublicKey()
            org.spongycastle.asn1.ASN1Integer r10 = (org.spongycastle.asn1.ASN1Integer) r10
            org.spongycastle.crypto.params.ElGamalPublicKeyParameters r1 = new org.spongycastle.crypto.params.ElGamalPublicKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            org.spongycastle.crypto.params.ElGamalParameters r2 = new org.spongycastle.crypto.params.ElGamalParameters
            java.math.BigInteger r3 = r0.getP()
            java.math.BigInteger r0 = r0.getG()
            r2.<init>(r3, r0)
            r1.<init>(r10, r2)
            return r1
        L_0x0106:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.p020x9.X9ObjectIdentifiers.id_dsa
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01b0
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.oiw.OIWObjectIdentifiers.dsaWithSHA1
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0120
            goto L_0x01b0
        L_0x0120:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.p020x9.X9ObjectIdentifiers.id_ecPublicKey
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01a8
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.x9.X962Parameters r0 = org.spongycastle.asn1.p020x9.X962Parameters.getInstance(r0)
            boolean r1 = r0.isNamedCurve()
            if (r1 == 0) goto L_0x0166
            org.spongycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            r2 = r0
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r2
            org.spongycastle.asn1.x9.X9ECParameters r0 = org.spongycastle.crypto.p024ec.CustomNamedCurves.getByOID(r2)
            if (r0 != 0) goto L_0x014b
            org.spongycastle.asn1.x9.X9ECParameters r0 = org.spongycastle.asn1.p020x9.ECNamedCurveTable.getByOID(r2)
        L_0x014b:
            org.spongycastle.crypto.params.ECNamedDomainParameters r8 = new org.spongycastle.crypto.params.ECNamedDomainParameters
            org.spongycastle.math.ec.ECCurve r3 = r0.getCurve()
            org.spongycastle.math.ec.ECPoint r4 = r0.getG()
            java.math.BigInteger r5 = r0.getN()
            java.math.BigInteger r6 = r0.getH()
            byte[] r7 = r0.getSeed()
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0188
        L_0x0166:
            org.spongycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            org.spongycastle.asn1.x9.X9ECParameters r0 = org.spongycastle.asn1.p020x9.X9ECParameters.getInstance(r0)
            org.spongycastle.crypto.params.ECDomainParameters r8 = new org.spongycastle.crypto.params.ECDomainParameters
            org.spongycastle.math.ec.ECCurve r2 = r0.getCurve()
            org.spongycastle.math.ec.ECPoint r3 = r0.getG()
            java.math.BigInteger r4 = r0.getN()
            java.math.BigInteger r5 = r0.getH()
            byte[] r6 = r0.getSeed()
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6)
        L_0x0188:
            org.spongycastle.asn1.DEROctetString r1 = new org.spongycastle.asn1.DEROctetString
            org.spongycastle.asn1.DERBitString r10 = r10.getPublicKeyData()
            byte[] r10 = r10.getBytes()
            r1.<init>((byte[]) r10)
            org.spongycastle.asn1.x9.X9ECPoint r10 = new org.spongycastle.asn1.x9.X9ECPoint
            org.spongycastle.math.ec.ECCurve r0 = r0.getCurve()
            r10.<init>(r0, r1)
            org.spongycastle.crypto.params.ECPublicKeyParameters r0 = new org.spongycastle.crypto.params.ECPublicKeyParameters
            org.spongycastle.math.ec.ECPoint r10 = r10.getPoint()
            r0.<init>(r10, r8)
            return r0
        L_0x01a8:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.String r0 = "algorithm identifier in key not recognised"
            r10.<init>(r0)
            throw r10
        L_0x01b0:
            org.spongycastle.asn1.ASN1Primitive r10 = r10.parsePublicKey()
            org.spongycastle.asn1.ASN1Integer r10 = (org.spongycastle.asn1.ASN1Integer) r10
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            if (r0 == 0) goto L_0x01d5
            org.spongycastle.asn1.ASN1Primitive r0 = r0.toASN1Primitive()
            org.spongycastle.asn1.x509.DSAParameter r0 = org.spongycastle.asn1.x509.DSAParameter.getInstance(r0)
            org.spongycastle.crypto.params.DSAParameters r3 = new org.spongycastle.crypto.params.DSAParameters
            java.math.BigInteger r1 = r0.getP()
            java.math.BigInteger r2 = r0.getQ()
            java.math.BigInteger r0 = r0.getG()
            r3.<init>(r1, r2, r0)
        L_0x01d5:
            org.spongycastle.crypto.params.DSAPublicKeyParameters r0 = new org.spongycastle.crypto.params.DSAPublicKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            r0.<init>(r10, r3)
            return r0
        L_0x01df:
            org.spongycastle.asn1.ASN1Primitive r10 = r10.parsePublicKey()
            org.spongycastle.asn1.pkcs.RSAPublicKey r10 = org.spongycastle.asn1.pkcs.RSAPublicKey.getInstance(r10)
            org.spongycastle.crypto.params.RSAKeyParameters r0 = new org.spongycastle.crypto.params.RSAKeyParameters
            java.math.BigInteger r1 = r10.getModulus()
            java.math.BigInteger r10 = r10.getPublicExponent()
            r0.<init>(r2, r1, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.util.PublicKeyFactory.createKey(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):org.spongycastle.crypto.params.AsymmetricKeyParameter");
    }
}
