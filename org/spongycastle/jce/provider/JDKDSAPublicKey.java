package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.p020x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;

public class JDKDSAPublicKey implements DSAPublicKey {
    private static final long serialVersionUID = 1752452449903495175L;
    private DSAParams dsaSpec;

    /* renamed from: y */
    private BigInteger f1228y;

    public String getAlgorithm() {
        return "DSA";
    }

    public String getFormat() {
        return "X.509";
    }

    JDKDSAPublicKey(DSAPublicKeySpec dSAPublicKeySpec) {
        this.f1228y = dSAPublicKeySpec.getY();
        this.dsaSpec = new DSAParameterSpec(dSAPublicKeySpec.getP(), dSAPublicKeySpec.getQ(), dSAPublicKeySpec.getG());
    }

    JDKDSAPublicKey(DSAPublicKey dSAPublicKey) {
        this.f1228y = dSAPublicKey.getY();
        this.dsaSpec = dSAPublicKey.getParams();
    }

    JDKDSAPublicKey(DSAPublicKeyParameters dSAPublicKeyParameters) {
        this.f1228y = dSAPublicKeyParameters.getY();
        this.dsaSpec = new DSAParameterSpec(dSAPublicKeyParameters.getParameters().getP(), dSAPublicKeyParameters.getParameters().getQ(), dSAPublicKeyParameters.getParameters().getG());
    }

    JDKDSAPublicKey(BigInteger bigInteger, DSAParameterSpec dSAParameterSpec) {
        this.f1228y = bigInteger;
        this.dsaSpec = dSAParameterSpec;
    }

    JDKDSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            this.f1228y = ((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue();
            if (isNotNull(subjectPublicKeyInfo.getAlgorithm().getParameters())) {
                DSAParameter instance = DSAParameter.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
                this.dsaSpec = new DSAParameterSpec(instance.getP(), instance.getQ(), instance.getG());
            }
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    private boolean isNotNull(ASN1Encodable aSN1Encodable) {
        return aSN1Encodable != null && !DERNull.INSTANCE.equals(aSN1Encodable);
    }

    public byte[] getEncoded() {
        try {
            if (this.dsaSpec == null) {
                return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa), (ASN1Encodable) new ASN1Integer(this.f1228y)).getEncoded(ASN1Encoding.DER);
            }
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG())), (ASN1Encodable) new ASN1Integer(this.f1228y)).getEncoded(ASN1Encoding.DER);
        } catch (IOException unused) {
            return null;
        }
    }

    public DSAParams getParams() {
        return this.dsaSpec;
    }

    public BigInteger getY() {
        return this.f1228y;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append("DSA Public Key");
        stringBuffer.append(property);
        stringBuffer.append("            y: ");
        stringBuffer.append(getY().toString(16));
        stringBuffer.append(property);
        return stringBuffer.toString();
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAPublicKey)) {
            return false;
        }
        DSAPublicKey dSAPublicKey = (DSAPublicKey) obj;
        if (!getY().equals(dSAPublicKey.getY()) || !getParams().getG().equals(dSAPublicKey.getParams().getG()) || !getParams().getP().equals(dSAPublicKey.getParams().getP()) || !getParams().getQ().equals(dSAPublicKey.getParams().getQ())) {
            return false;
        }
        return true;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f1228y = (BigInteger) objectInputStream.readObject();
        this.dsaSpec = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f1228y);
        objectOutputStream.writeObject(this.dsaSpec.getP());
        objectOutputStream.writeObject(this.dsaSpec.getQ());
        objectOutputStream.writeObject(this.dsaSpec.getG());
    }
}
