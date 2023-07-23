package org.spongycastle.crypto.util;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.p020x9.X962Parameters;
import org.spongycastle.asn1.p020x9.X9ECParameters;
import org.spongycastle.asn1.p020x9.X9ECPoint;
import org.spongycastle.asn1.p020x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSAPublicKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECNamedDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class SubjectPublicKeyInfoFactory {
    public static SubjectPublicKeyInfo createSubjectPublicKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter) throws IOException {
        X962Parameters x962Parameters;
        if (asymmetricKeyParameter instanceof RSAKeyParameters) {
            RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), (ASN1Encodable) new RSAPublicKey(rSAKeyParameters.getModulus(), rSAKeyParameters.getExponent()));
        } else if (asymmetricKeyParameter instanceof DSAPublicKeyParameters) {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa), (ASN1Encodable) new ASN1Integer(((DSAPublicKeyParameters) asymmetricKeyParameter).getY()));
        } else {
            if (asymmetricKeyParameter instanceof ECPublicKeyParameters) {
                ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) asymmetricKeyParameter;
                ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
                if (parameters == null) {
                    x962Parameters = new X962Parameters((ASN1Primitive) DERNull.INSTANCE);
                } else if (parameters instanceof ECNamedDomainParameters) {
                    x962Parameters = new X962Parameters(((ECNamedDomainParameters) parameters).getName());
                } else {
                    x962Parameters = new X962Parameters(new X9ECParameters(parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed()));
                }
                return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters), ((ASN1OctetString) new X9ECPoint(eCPublicKeyParameters.getQ()).toASN1Primitive()).getOctets());
            }
            throw new IOException("key parameters not recognised.");
        }
    }
}
