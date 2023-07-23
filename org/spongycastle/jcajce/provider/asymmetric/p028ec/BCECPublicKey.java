package org.spongycastle.jcajce.provider.asymmetric.p028ec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.p020x9.X962Parameters;
import org.spongycastle.asn1.p020x9.X9ECParameters;
import org.spongycastle.asn1.p020x9.X9ECPoint;
import org.spongycastle.asn1.p020x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.p030ec.ECCurve;
import org.spongycastle.math.p030ec.ECPoint;

/* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.BCECPublicKey */
public class BCECPublicKey implements ECPublicKey, org.spongycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
    static final long serialVersionUID = 2422789860422731812L;
    private String algorithm = "EC";
    private transient ProviderConfiguration configuration;
    private transient ECParameterSpec ecSpec;

    /* renamed from: q */
    private transient ECPoint f1201q;
    private boolean withCompression;

    public String getFormat() {
        return "X.509";
    }

    public BCECPublicKey(String str, BCECPublicKey bCECPublicKey) {
        this.algorithm = str;
        this.f1201q = bCECPublicKey.f1201q;
        this.ecSpec = bCECPublicKey.ecSpec;
        this.withCompression = bCECPublicKey.withCompression;
        this.configuration = bCECPublicKey.configuration;
    }

    public BCECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.f1201q = EC5Util.convertPoint(params, eCPublicKeySpec.getW(), false);
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, org.spongycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        this.f1201q = eCPublicKeySpec.getQ();
        if (eCPublicKeySpec.getParams() != null) {
            EllipticCurve convertCurve = EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().getSeed());
            this.f1201q = EC5Util.convertCurve(convertCurve).createPoint(eCPublicKeySpec.getQ().getAffineXCoord().toBigInteger(), eCPublicKeySpec.getQ().getAffineYCoord().toBigInteger());
            this.ecSpec = EC5Util.convertSpec(convertCurve, eCPublicKeySpec.getParams());
        } else {
            if (this.f1201q.getCurve() == null) {
                this.f1201q = providerConfiguration.getEcImplicitlyCa().getCurve().createPoint(this.f1201q.getXCoord().toBigInteger(), this.f1201q.getYCoord().toBigInteger(), false);
            }
            this.ecSpec = null;
        }
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.f1201q = eCPublicKeyParameters.getQ();
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = eCParameterSpec;
        }
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
        }
        this.f1201q = EC5Util.convertCurve(this.ecSpec.getCurve()).createPoint(eCPublicKeyParameters.getQ().getAffineXCoord().toBigInteger(), eCPublicKeyParameters.getQ().getAffineYCoord().toBigInteger());
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        this.f1201q = eCPublicKeyParameters.getQ();
        this.ecSpec = null;
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(ECPublicKey eCPublicKey, ProviderConfiguration providerConfiguration) {
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.ecSpec = params;
        this.f1201q = EC5Util.convertPoint(params, eCPublicKey.getW(), false);
    }

    BCECPublicKey(String str, SubjectPublicKeyInfo subjectPublicKeyInfo, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        this.configuration = providerConfiguration;
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, new java.security.spec.ECPoint(eCDomainParameters.getG().getAffineXCoord().toBigInteger(), eCDomainParameters.getG().getAffineYCoord().toBigInteger()), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
    }

    /* JADX WARNING: type inference failed for: r11v6, types: [org.spongycastle.asn1.ASN1Primitive] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPubKeyInfo(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r11) {
        /*
            r10 = this;
            org.spongycastle.asn1.x9.X962Parameters r0 = new org.spongycastle.asn1.x9.X962Parameters
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r11.getAlgorithm()
            org.spongycastle.asn1.ASN1Encodable r1 = r1.getParameters()
            org.spongycastle.asn1.ASN1Primitive r1 = (org.spongycastle.asn1.ASN1Primitive) r1
            r0.<init>((org.spongycastle.asn1.ASN1Primitive) r1)
            boolean r1 = r0.isNamedCurve()
            if (r1 == 0) goto L_0x005d
            org.spongycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r0
            org.spongycastle.asn1.x9.X9ECParameters r1 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveByOid(r0)
            org.spongycastle.math.ec.ECCurve r2 = r1.getCurve()
            byte[] r3 = r1.getSeed()
            java.security.spec.EllipticCurve r6 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r2, r3)
            org.spongycastle.jce.spec.ECNamedCurveSpec r3 = new org.spongycastle.jce.spec.ECNamedCurveSpec
            java.lang.String r5 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getCurveName(r0)
            java.security.spec.ECPoint r7 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r0 = r1.getG()
            org.spongycastle.math.ec.ECFieldElement r0 = r0.getAffineXCoord()
            java.math.BigInteger r0 = r0.toBigInteger()
            org.spongycastle.math.ec.ECPoint r4 = r1.getG()
            org.spongycastle.math.ec.ECFieldElement r4 = r4.getAffineYCoord()
            java.math.BigInteger r4 = r4.toBigInteger()
            r7.<init>(r0, r4)
            java.math.BigInteger r8 = r1.getN()
            java.math.BigInteger r9 = r1.getH()
            r4 = r3
            r4.<init>((java.lang.String) r5, (java.security.spec.EllipticCurve) r6, (java.security.spec.ECPoint) r7, (java.math.BigInteger) r8, (java.math.BigInteger) r9)
            r10.ecSpec = r3
            goto L_0x00b5
        L_0x005d:
            boolean r1 = r0.isImplicitlyCA()
            if (r1 == 0) goto L_0x0071
            r0 = 0
            r10.ecSpec = r0
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r0 = r10.configuration
            org.spongycastle.jce.spec.ECParameterSpec r0 = r0.getEcImplicitlyCa()
            org.spongycastle.math.ec.ECCurve r2 = r0.getCurve()
            goto L_0x00b5
        L_0x0071:
            org.spongycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            org.spongycastle.asn1.x9.X9ECParameters r0 = org.spongycastle.asn1.p020x9.X9ECParameters.getInstance(r0)
            org.spongycastle.math.ec.ECCurve r2 = r0.getCurve()
            byte[] r1 = r0.getSeed()
            java.security.spec.EllipticCurve r1 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r2, r1)
            java.security.spec.ECParameterSpec r3 = new java.security.spec.ECParameterSpec
            java.security.spec.ECPoint r4 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r5 = r0.getG()
            org.spongycastle.math.ec.ECFieldElement r5 = r5.getAffineXCoord()
            java.math.BigInteger r5 = r5.toBigInteger()
            org.spongycastle.math.ec.ECPoint r6 = r0.getG()
            org.spongycastle.math.ec.ECFieldElement r6 = r6.getAffineYCoord()
            java.math.BigInteger r6 = r6.toBigInteger()
            r4.<init>(r5, r6)
            java.math.BigInteger r5 = r0.getN()
            java.math.BigInteger r0 = r0.getH()
            int r0 = r0.intValue()
            r3.<init>(r1, r4, r5, r0)
            r10.ecSpec = r3
        L_0x00b5:
            org.spongycastle.asn1.DERBitString r11 = r11.getPublicKeyData()
            byte[] r11 = r11.getBytes()
            org.spongycastle.asn1.DEROctetString r0 = new org.spongycastle.asn1.DEROctetString
            r0.<init>((byte[]) r11)
            r1 = 0
            byte r1 = r11[r1]
            r3 = 4
            if (r1 != r3) goto L_0x00f6
            r1 = 1
            byte r1 = r11[r1]
            int r3 = r11.length
            r4 = 2
            int r3 = r3 - r4
            if (r1 != r3) goto L_0x00f6
            byte r1 = r11[r4]
            r3 = 3
            if (r1 == r4) goto L_0x00d9
            byte r1 = r11[r4]
            if (r1 != r3) goto L_0x00f6
        L_0x00d9:
            org.spongycastle.asn1.x9.X9IntegerConverter r1 = new org.spongycastle.asn1.x9.X9IntegerConverter
            r1.<init>()
            int r1 = r1.getByteLength((org.spongycastle.math.p030ec.ECCurve) r2)
            int r4 = r11.length
            int r4 = r4 - r3
            if (r1 < r4) goto L_0x00f6
            org.spongycastle.asn1.ASN1Primitive r11 = org.spongycastle.asn1.ASN1Primitive.fromByteArray(r11)     // Catch:{ IOException -> 0x00ee }
            r0 = r11
            org.spongycastle.asn1.ASN1OctetString r0 = (org.spongycastle.asn1.ASN1OctetString) r0     // Catch:{ IOException -> 0x00ee }
            goto L_0x00f6
        L_0x00ee:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "error recovering public key"
            r11.<init>(r0)
            throw r11
        L_0x00f6:
            org.spongycastle.asn1.x9.X9ECPoint r11 = new org.spongycastle.asn1.x9.X9ECPoint
            r11.<init>(r2, r0)
            org.spongycastle.math.ec.ECPoint r11 = r11.getPoint()
            r10.f1201q = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.p028ec.BCECPublicKey.populateFromPubKeyInfo(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        X962Parameters x962Parameters;
        ASN1OctetString aSN1OctetString;
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            ASN1ObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) eCParameterSpec).getName());
            if (namedCurveOid == null) {
                namedCurveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.ecSpec).getName());
            }
            x962Parameters = new X962Parameters(namedCurveOid);
        } else if (eCParameterSpec == null) {
            x962Parameters = new X962Parameters((ASN1Primitive) DERNull.INSTANCE);
        } else {
            ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
            x962Parameters = new X962Parameters(new X9ECParameters(convertCurve, EC5Util.convertPoint(convertCurve, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf((long) this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        }
        ECCurve curve = engineGetQ().getCurve();
        if (this.ecSpec == null) {
            aSN1OctetString = (ASN1OctetString) new X9ECPoint(curve.createPoint(getQ().getXCoord().toBigInteger(), getQ().getYCoord().toBigInteger(), this.withCompression)).toASN1Primitive();
        } else {
            aSN1OctetString = (ASN1OctetString) new X9ECPoint(curve.createPoint(getQ().getAffineXCoord().toBigInteger(), getQ().getAffineYCoord().toBigInteger(), this.withCompression)).toASN1Primitive();
        }
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters), aSN1OctetString.getOctets()));
    }

    private void extractBytes(byte[] bArr, int i, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < 32) {
            byte[] bArr2 = new byte[32];
            System.arraycopy(byteArray, 0, bArr2, 32 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i2 = 0; i2 != 32; i2++) {
            bArr[i + i2] = byteArray[(byteArray.length - 1) - i2];
        }
    }

    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    public org.spongycastle.jce.spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.convertSpec(eCParameterSpec, this.withCompression);
    }

    public java.security.spec.ECPoint getW() {
        return new java.security.spec.ECPoint(this.f1201q.getAffineXCoord().toBigInteger(), this.f1201q.getAffineYCoord().toBigInteger());
    }

    public ECPoint getQ() {
        if (this.ecSpec == null) {
            return this.f1201q.getDetachedPoint();
        }
        return this.f1201q;
    }

    public ECPoint engineGetQ() {
        return this.f1201q;
    }

    /* access modifiers changed from: package-private */
    public org.spongycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec != null) {
            return EC5Util.convertSpec(eCParameterSpec, this.withCompression);
        }
        return this.configuration.getEcImplicitlyCa();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append("EC Public Key");
        stringBuffer.append(property);
        stringBuffer.append("            X: ");
        stringBuffer.append(this.f1201q.getAffineXCoord().toBigInteger().toString(16));
        stringBuffer.append(property);
        stringBuffer.append("            Y: ");
        stringBuffer.append(this.f1201q.getAffineYCoord().toBigInteger().toString(16));
        stringBuffer.append(property);
        return stringBuffer.toString();
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECPublicKey)) {
            return false;
        }
        BCECPublicKey bCECPublicKey = (BCECPublicKey) obj;
        if (!engineGetQ().equals(bCECPublicKey.engineGetQ()) || !engineGetSpec().equals(bCECPublicKey.engineGetSpec())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return engineGetQ().hashCode() ^ engineGetSpec().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
        this.configuration = BouncyCastleProvider.CONFIGURATION;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }
}
