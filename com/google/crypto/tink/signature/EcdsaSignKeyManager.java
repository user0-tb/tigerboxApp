package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.EcdsaKeyFormat;
import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.proto.EcdsaPrivateKey;
import com.google.crypto.tink.proto.EcdsaPublicKey;
import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.signature.internal.SigUtil;
import com.google.crypto.tink.subtle.EcdsaSignJce;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.SelfKeyTestValidators;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class EcdsaSignKeyManager extends PrivateKeyTypeManager<EcdsaPrivateKey, EcdsaPublicKey> {
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    }

    public int getVersion() {
        return 0;
    }

    EcdsaSignKeyManager() {
        super(EcdsaPrivateKey.class, EcdsaPublicKey.class, new PrimitiveFactory<PublicKeySign, EcdsaPrivateKey>(PublicKeySign.class) {
            public PublicKeySign getPrimitive(EcdsaPrivateKey ecdsaPrivateKey) throws GeneralSecurityException {
                ECPrivateKey ecPrivateKey = EllipticCurves.getEcPrivateKey(SigUtil.toCurveType(ecdsaPrivateKey.getPublicKey().getParams().getCurve()), ecdsaPrivateKey.getKeyValue().toByteArray());
                SelfKeyTestValidators.validateEcdsa(ecPrivateKey, EllipticCurves.getEcPublicKey(SigUtil.toCurveType(ecdsaPrivateKey.getPublicKey().getParams().getCurve()), ecdsaPrivateKey.getPublicKey().getX().toByteArray(), ecdsaPrivateKey.getPublicKey().getY().toByteArray()), SigUtil.toHashType(ecdsaPrivateKey.getPublicKey().getParams().getHashType()), SigUtil.toEcdsaEncoding(ecdsaPrivateKey.getPublicKey().getParams().getEncoding()));
                return new EcdsaSignJce(ecPrivateKey, SigUtil.toHashType(ecdsaPrivateKey.getPublicKey().getParams().getHashType()), SigUtil.toEcdsaEncoding(ecdsaPrivateKey.getPublicKey().getParams().getEncoding()));
            }
        });
    }

    public EcdsaPublicKey getPublicKey(EcdsaPrivateKey ecdsaPrivateKey) throws GeneralSecurityException {
        return ecdsaPrivateKey.getPublicKey();
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    public EcdsaPrivateKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return EcdsaPrivateKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(EcdsaPrivateKey ecdsaPrivateKey) throws GeneralSecurityException {
        Validators.validateVersion(ecdsaPrivateKey.getVersion(), getVersion());
        SigUtil.validateEcdsaParams(ecdsaPrivateKey.getPublicKey().getParams());
    }

    public KeyTypeManager.KeyFactory<EcdsaKeyFormat, EcdsaPrivateKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<EcdsaKeyFormat, EcdsaPrivateKey>(EcdsaKeyFormat.class) {
            public void validateKeyFormat(EcdsaKeyFormat ecdsaKeyFormat) throws GeneralSecurityException {
                SigUtil.validateEcdsaParams(ecdsaKeyFormat.getParams());
            }

            public EcdsaKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return EcdsaKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public EcdsaPrivateKey createKey(EcdsaKeyFormat ecdsaKeyFormat) throws GeneralSecurityException {
                EcdsaParams params = ecdsaKeyFormat.getParams();
                KeyPair generateKeyPair = EllipticCurves.generateKeyPair(SigUtil.toCurveType(params.getCurve()));
                ECPoint w = ((ECPublicKey) generateKeyPair.getPublic()).getW();
                return (EcdsaPrivateKey) EcdsaPrivateKey.newBuilder().setVersion(EcdsaSignKeyManager.this.getVersion()).setPublicKey((EcdsaPublicKey) EcdsaPublicKey.newBuilder().setVersion(EcdsaSignKeyManager.this.getVersion()).setParams(params).setX(ByteString.copyFrom(w.getAffineX().toByteArray())).setY(ByteString.copyFrom(w.getAffineY().toByteArray())).build()).setKeyValue(ByteString.copyFrom(((ECPrivateKey) generateKeyPair.getPrivate()).getS().toByteArray())).build();
            }

            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<EcdsaKeyFormat>> keyFormats() throws GeneralSecurityException {
                HashMap hashMap = new HashMap();
                hashMap.put("ECDSA_P256", EcdsaSignKeyManager.createKeyFormat(HashType.SHA256, EllipticCurveType.NIST_P256, EcdsaSignatureEncoding.DER, KeyTemplate.OutputPrefixType.TINK));
                hashMap.put("ECDSA_P256_IEEE_P1363", EcdsaSignKeyManager.createKeyFormat(HashType.SHA256, EllipticCurveType.NIST_P256, EcdsaSignatureEncoding.IEEE_P1363, KeyTemplate.OutputPrefixType.TINK));
                hashMap.put("ECDSA_P256_RAW", EcdsaSignKeyManager.createKeyFormat(HashType.SHA256, EllipticCurveType.NIST_P256, EcdsaSignatureEncoding.IEEE_P1363, KeyTemplate.OutputPrefixType.RAW));
                hashMap.put("ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX", EcdsaSignKeyManager.createKeyFormat(HashType.SHA256, EllipticCurveType.NIST_P256, EcdsaSignatureEncoding.IEEE_P1363, KeyTemplate.OutputPrefixType.RAW));
                hashMap.put("ECDSA_P384", EcdsaSignKeyManager.createKeyFormat(HashType.SHA512, EllipticCurveType.NIST_P384, EcdsaSignatureEncoding.DER, KeyTemplate.OutputPrefixType.TINK));
                hashMap.put("ECDSA_P384_IEEE_P1363", EcdsaSignKeyManager.createKeyFormat(HashType.SHA512, EllipticCurveType.NIST_P384, EcdsaSignatureEncoding.IEEE_P1363, KeyTemplate.OutputPrefixType.TINK));
                hashMap.put("ECDSA_P384_SHA512", EcdsaSignKeyManager.createKeyFormat(HashType.SHA512, EllipticCurveType.NIST_P384, EcdsaSignatureEncoding.DER, KeyTemplate.OutputPrefixType.TINK));
                hashMap.put("ECDSA_P384_SHA384", EcdsaSignKeyManager.createKeyFormat(HashType.SHA384, EllipticCurveType.NIST_P384, EcdsaSignatureEncoding.DER, KeyTemplate.OutputPrefixType.TINK));
                hashMap.put("ECDSA_P521", EcdsaSignKeyManager.createKeyFormat(HashType.SHA512, EllipticCurveType.NIST_P521, EcdsaSignatureEncoding.DER, KeyTemplate.OutputPrefixType.TINK));
                hashMap.put("ECDSA_P521_IEEE_P1363", EcdsaSignKeyManager.createKeyFormat(HashType.SHA512, EllipticCurveType.NIST_P521, EcdsaSignatureEncoding.IEEE_P1363, KeyTemplate.OutputPrefixType.TINK));
                return Collections.unmodifiableMap(hashMap);
            }
        };
    }

    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    public static void registerPair(boolean z) throws GeneralSecurityException {
        Registry.registerAsymmetricKeyManagers(new EcdsaSignKeyManager(), new EcdsaVerifyKeyManager(), z);
    }

    @Deprecated
    public static final KeyTemplate ecdsaP256Template() {
        return createKeyTemplate(HashType.SHA256, EllipticCurveType.NIST_P256, EcdsaSignatureEncoding.DER, KeyTemplate.OutputPrefixType.TINK);
    }

    @Deprecated
    public static final KeyTemplate rawEcdsaP256Template() {
        return createKeyTemplate(HashType.SHA256, EllipticCurveType.NIST_P256, EcdsaSignatureEncoding.IEEE_P1363, KeyTemplate.OutputPrefixType.RAW);
    }

    public static KeyTemplate createKeyTemplate(HashType hashType, EllipticCurveType ellipticCurveType, EcdsaSignatureEncoding ecdsaSignatureEncoding, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.create(new EcdsaSignKeyManager().getKeyType(), ((EcdsaKeyFormat) EcdsaKeyFormat.newBuilder().setParams((EcdsaParams) EcdsaParams.newBuilder().setHashType(hashType).setCurve(ellipticCurveType).setEncoding(ecdsaSignatureEncoding).build()).build()).toByteArray(), outputPrefixType);
    }

    /* access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<EcdsaKeyFormat> createKeyFormat(HashType hashType, EllipticCurveType ellipticCurveType, EcdsaSignatureEncoding ecdsaSignatureEncoding, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>((EcdsaKeyFormat) EcdsaKeyFormat.newBuilder().setParams((EcdsaParams) EcdsaParams.newBuilder().setHashType(hashType).setCurve(ellipticCurveType).setEncoding(ecdsaSignatureEncoding).build()).build(), outputPrefixType);
    }
}
