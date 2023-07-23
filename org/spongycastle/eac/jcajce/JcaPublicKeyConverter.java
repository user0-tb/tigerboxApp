package org.spongycastle.eac.jcajce;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.EllipticCurve;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.eac.EACObjectIdentifiers;
import org.spongycastle.asn1.eac.ECDSAPublicKey;
import org.spongycastle.asn1.eac.PublicKeyDataObject;
import org.spongycastle.asn1.eac.RSAPublicKey;
import org.spongycastle.eac.EACException;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.jce.spec.ECPublicKeySpec;
import org.spongycastle.math.p030ec.ECCurve;
import org.spongycastle.math.p030ec.ECPoint;

public class JcaPublicKeyConverter {
    private EACHelper helper = new DefaultEACHelper();

    public JcaPublicKeyConverter setProvider(String str) {
        this.helper = new NamedEACHelper(str);
        return this;
    }

    public JcaPublicKeyConverter setProvider(Provider provider) {
        this.helper = new ProviderEACHelper(provider);
        return this;
    }

    public PublicKey getKey(PublicKeyDataObject publicKeyDataObject) throws EACException, InvalidKeySpecException {
        if (publicKeyDataObject.getUsage().mo43781on(EACObjectIdentifiers.id_TA_ECDSA)) {
            return getECPublicKeyPublicKey((ECDSAPublicKey) publicKeyDataObject);
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKeyDataObject;
        try {
            return this.helper.createKeyFactory("RSA").generatePublic(new RSAPublicKeySpec(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent()));
        } catch (NoSuchProviderException e) {
            throw new EACException("cannot find provider: " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new EACException("cannot find algorithm ECDSA: " + e2.getMessage(), e2);
        }
    }

    private PublicKey getECPublicKeyPublicKey(ECDSAPublicKey eCDSAPublicKey) throws EACException, InvalidKeySpecException {
        ECParameterSpec params = getParams(eCDSAPublicKey);
        try {
            return this.helper.createKeyFactory("ECDSA").generatePublic(new ECPublicKeySpec(params.getCurve().decodePoint(eCDSAPublicKey.getPublicPointY()), params));
        } catch (NoSuchProviderException e) {
            throw new EACException("cannot find provider: " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new EACException("cannot find algorithm ECDSA: " + e2.getMessage(), e2);
        }
    }

    private ECParameterSpec getParams(ECDSAPublicKey eCDSAPublicKey) {
        if (eCDSAPublicKey.hasParameters()) {
            ECCurve.C3204Fp fp = new ECCurve.C3204Fp(eCDSAPublicKey.getPrimeModulusP(), eCDSAPublicKey.getFirstCoefA(), eCDSAPublicKey.getSecondCoefB());
            return new ECParameterSpec(fp, fp.decodePoint(eCDSAPublicKey.getBasePointG()), eCDSAPublicKey.getOrderOfBasePointR(), eCDSAPublicKey.getCofactorF());
        }
        throw new IllegalArgumentException("Public key does not contains EC Params");
    }

    public PublicKeyDataObject getPublicKeyDataObject(ASN1ObjectIdentifier aSN1ObjectIdentifier, PublicKey publicKey) {
        if (publicKey instanceof java.security.interfaces.RSAPublicKey) {
            java.security.interfaces.RSAPublicKey rSAPublicKey = (java.security.interfaces.RSAPublicKey) publicKey;
            return new RSAPublicKey(aSN1ObjectIdentifier, rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        }
        ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
        java.security.spec.ECParameterSpec params = eCPublicKey.getParams();
        BigInteger p = ((ECFieldFp) params.getCurve().getField()).getP();
        BigInteger a = params.getCurve().getA();
        BigInteger b = params.getCurve().getB();
        byte[] encoded = convertPoint(convertCurve(params.getCurve()), params.getGenerator(), false).getEncoded();
        BigInteger order = params.getOrder();
        return new ECDSAPublicKey(aSN1ObjectIdentifier, p, a, b, encoded, order, convertPoint(convertCurve(params.getCurve()), eCPublicKey.getW(), false).getEncoded(), params.getCofactor());
    }

    private static ECPoint convertPoint(ECCurve eCCurve, java.security.spec.ECPoint eCPoint, boolean z) {
        return eCCurve.createPoint(eCPoint.getAffineX(), eCPoint.getAffineY(), z);
    }

    private static ECCurve convertCurve(EllipticCurve ellipticCurve) {
        ECField field = ellipticCurve.getField();
        BigInteger a = ellipticCurve.getA();
        BigInteger b = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            return new ECCurve.C3204Fp(((ECFieldFp) field).getP(), a, b);
        }
        throw new IllegalStateException("not implemented yet!!!");
    }
}
