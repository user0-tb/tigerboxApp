package org.spongycastle.crypto.util;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class PrivateKeyFactory {
    public static AsymmetricKeyParameter createKey(byte[] bArr) throws IOException {
        return createKey(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
    }

    public static AsymmetricKeyParameter createKey(InputStream inputStream) throws IOException {
        return createKey(PrivateKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [org.spongycastle.crypto.params.ECDomainParameters] */
    /* JADX WARNING: type inference failed for: r1v20, types: [org.spongycastle.crypto.params.ECDomainParameters] */
    /* JADX WARNING: type inference failed for: r1v21, types: [org.spongycastle.crypto.params.ECNamedDomainParameters] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.spongycastle.crypto.params.AsymmetricKeyParameter createKey(org.spongycastle.asn1.pkcs.PrivateKeyInfo r10) throws java.io.IOException {
        /*
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r10.getPrivateKeyAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.rsaEncryption
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003f
            org.spongycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            org.spongycastle.asn1.pkcs.RSAPrivateKey r10 = org.spongycastle.asn1.pkcs.RSAPrivateKey.getInstance(r10)
            org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters r9 = new org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters
            java.math.BigInteger r1 = r10.getModulus()
            java.math.BigInteger r2 = r10.getPublicExponent()
            java.math.BigInteger r3 = r10.getPrivateExponent()
            java.math.BigInteger r4 = r10.getPrime1()
            java.math.BigInteger r5 = r10.getPrime2()
            java.math.BigInteger r6 = r10.getExponent1()
            java.math.BigInteger r7 = r10.getExponent2()
            java.math.BigInteger r8 = r10.getCoefficient()
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x003f:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.dhKeyAgreement
            boolean r1 = r1.equals(r2)
            r2 = 0
            if (r1 == 0) goto L_0x007d
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.pkcs.DHParameter r0 = org.spongycastle.asn1.pkcs.DHParameter.getInstance(r0)
            org.spongycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            org.spongycastle.asn1.ASN1Integer r10 = (org.spongycastle.asn1.ASN1Integer) r10
            java.math.BigInteger r1 = r0.getL()
            if (r1 != 0) goto L_0x0062
            r1 = 0
            goto L_0x0066
        L_0x0062:
            int r1 = r1.intValue()
        L_0x0066:
            org.spongycastle.crypto.params.DHParameters r3 = new org.spongycastle.crypto.params.DHParameters
            java.math.BigInteger r4 = r0.getP()
            java.math.BigInteger r0 = r0.getG()
            r3.<init>(r4, r0, r2, r1)
            org.spongycastle.crypto.params.DHPrivateKeyParameters r0 = new org.spongycastle.crypto.params.DHPrivateKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            r0.<init>(r10, r3)
            return r0
        L_0x007d:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.oiw.OIWObjectIdentifiers.elGamalAlgorithm
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ae
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.oiw.ElGamalParameter r0 = org.spongycastle.asn1.oiw.ElGamalParameter.getInstance(r0)
            org.spongycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            org.spongycastle.asn1.ASN1Integer r10 = (org.spongycastle.asn1.ASN1Integer) r10
            org.spongycastle.crypto.params.ElGamalPrivateKeyParameters r1 = new org.spongycastle.crypto.params.ElGamalPrivateKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            org.spongycastle.crypto.params.ElGamalParameters r2 = new org.spongycastle.crypto.params.ElGamalParameters
            java.math.BigInteger r3 = r0.getP()
            java.math.BigInteger r0 = r0.getG()
            r2.<init>(r3, r0)
            r1.<init>(r10, r2)
            return r1
        L_0x00ae:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.p020x9.X9ObjectIdentifiers.id_dsa
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00e9
            org.spongycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            org.spongycastle.asn1.ASN1Integer r10 = (org.spongycastle.asn1.ASN1Integer) r10
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            if (r0 == 0) goto L_0x00df
            org.spongycastle.asn1.ASN1Primitive r0 = r0.toASN1Primitive()
            org.spongycastle.asn1.x509.DSAParameter r0 = org.spongycastle.asn1.x509.DSAParameter.getInstance(r0)
            org.spongycastle.crypto.params.DSAParameters r2 = new org.spongycastle.crypto.params.DSAParameters
            java.math.BigInteger r1 = r0.getP()
            java.math.BigInteger r3 = r0.getQ()
            java.math.BigInteger r0 = r0.getG()
            r2.<init>(r1, r3, r0)
        L_0x00df:
            org.spongycastle.crypto.params.DSAPrivateKeyParameters r0 = new org.spongycastle.crypto.params.DSAPrivateKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            r0.<init>(r10, r2)
            return r0
        L_0x00e9:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.p020x9.X9ObjectIdentifiers.id_ecPublicKey
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0166
            org.spongycastle.asn1.x9.X962Parameters r1 = new org.spongycastle.asn1.x9.X962Parameters
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.ASN1Primitive r0 = (org.spongycastle.asn1.ASN1Primitive) r0
            r1.<init>((org.spongycastle.asn1.ASN1Primitive) r0)
            boolean r0 = r1.isNamedCurve()
            if (r0 == 0) goto L_0x0132
            org.spongycastle.asn1.ASN1Primitive r0 = r1.getParameters()
            r2 = r0
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r2
            org.spongycastle.asn1.x9.X9ECParameters r0 = org.spongycastle.crypto.p024ec.CustomNamedCurves.getByOID(r2)
            if (r0 != 0) goto L_0x0117
            org.spongycastle.asn1.x9.X9ECParameters r0 = org.spongycastle.asn1.p020x9.ECNamedCurveTable.getByOID(r2)
        L_0x0117:
            org.spongycastle.crypto.params.ECNamedDomainParameters r8 = new org.spongycastle.crypto.params.ECNamedDomainParameters
            org.spongycastle.math.ec.ECCurve r3 = r0.getCurve()
            org.spongycastle.math.ec.ECPoint r4 = r0.getG()
            java.math.BigInteger r5 = r0.getN()
            java.math.BigInteger r6 = r0.getH()
            byte[] r7 = r0.getSeed()
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0154
        L_0x0132:
            org.spongycastle.asn1.ASN1Primitive r0 = r1.getParameters()
            org.spongycastle.asn1.x9.X9ECParameters r0 = org.spongycastle.asn1.p020x9.X9ECParameters.getInstance(r0)
            org.spongycastle.crypto.params.ECDomainParameters r8 = new org.spongycastle.crypto.params.ECDomainParameters
            org.spongycastle.math.ec.ECCurve r2 = r0.getCurve()
            org.spongycastle.math.ec.ECPoint r3 = r0.getG()
            java.math.BigInteger r4 = r0.getN()
            java.math.BigInteger r5 = r0.getH()
            byte[] r6 = r0.getSeed()
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6)
        L_0x0154:
            org.spongycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            org.spongycastle.asn1.sec.ECPrivateKey r10 = org.spongycastle.asn1.sec.ECPrivateKey.getInstance(r10)
            java.math.BigInteger r10 = r10.getKey()
            org.spongycastle.crypto.params.ECPrivateKeyParameters r0 = new org.spongycastle.crypto.params.ECPrivateKeyParameters
            r0.<init>(r10, r8)
            return r0
        L_0x0166:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.String r0 = "algorithm identifier in key not recognised"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.util.PrivateKeyFactory.createKey(org.spongycastle.asn1.pkcs.PrivateKeyInfo):org.spongycastle.crypto.params.AsymmetricKeyParameter");
    }
}
