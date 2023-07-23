package org.spongycastle.cms.jcajce;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.cms.CMSAlgorithm;
import org.spongycastle.cms.CMSEnvelopedDataGenerator;
import org.spongycastle.cms.CMSEnvelopedGenerator;
import org.spongycastle.cms.CMSException;
import org.spongycastle.crypto.tls.AlertDescription;
import org.spongycastle.operator.DefaultSecretKeySizeProvider;
import org.spongycastle.operator.GenericKey;
import org.spongycastle.operator.SecretKeySizeProvider;
import org.spongycastle.operator.SymmetricKeyUnwrapper;
import org.spongycastle.operator.jcajce.JceAsymmetricKeyUnwrapper;

public class EnvelopedDataHelper {
    protected static final Map BASE_CIPHER_NAMES;
    protected static final Map CIPHER_ALG_NAMES;
    protected static final SecretKeySizeProvider KEY_SIZE_PROVIDER = DefaultSecretKeySizeProvider.INSTANCE;
    protected static final Map MAC_ALG_NAMES;
    private static final short[] rc2Ekb = {93, 190, 155, 139, 17, 153, AlertDescription.unsupported_extension, 77, 89, 243, 133, 166, 63, 183, 131, 197, 228, AlertDescription.unknown_psk_identity, 107, 58, 104, 90, 192, 71, 160, 100, 52, 12, 241, 208, 82, 165, 185, 30, 150, 67, 65, 216, 212, 44, 219, 248, 7, 119, 42, 202, 235, 239, 16, 28, 22, 13, 56, AlertDescription.bad_certificate_hash_value, 47, 137, 193, 249, 128, 196, 109, 174, 48, 61, 206, 32, 99, 254, 230, 26, 199, 184, 80, 232, 36, 23, 252, 37, AlertDescription.certificate_unobtainable, 187, 106, 163, 68, 83, 217, 162, 1, 171, 188, 182, 31, 152, 238, 154, 167, 45, 79, 158, 142, 172, 224, 198, 73, 70, 41, 244, 148, 138, 175, 225, 91, 195, 179, 123, 87, 209, 124, 156, 237, 135, 64, 140, 226, 203, 147, 20, 201, 97, 46, 229, 204, 246, 94, 168, 92, 214, 117, 141, 98, 149, 88, 105, 118, 161, 74, 181, 85, 9, 120, 51, 130, 215, 221, 121, 245, 27, 11, 222, 38, 33, 40, 116, 4, 151, 86, 223, 60, 240, 55, 57, 220, 255, 6, 164, 234, 66, 8, 218, 180, AlertDescription.bad_certificate_status_response, 176, 207, 18, 122, 78, 250, 108, 29, 132, 0, 200, 127, 145, 69, 170, 43, 194, 177, 143, 213, 186, 242, 173, 25, 178, 103, 54, 247, 15, 10, 146, 125, 227, 157, 233, 144, 62, 35, 39, 102, 19, 236, 129, 21, 189, 34, 191, 159, 126, 169, 81, 75, 76, 251, 2, 211, AlertDescription.unrecognized_name, 134, 49, 231, 59, 5, 3, 84, 96, 72, 101, 24, 210, 205, 95, 50, 136, 14, 53, 253};
    private static final short[] rc2Table = {189, 86, 234, 242, 162, 241, 172, 42, 176, 147, 209, 156, 27, 51, 253, 208, 48, 4, 182, 220, 125, 223, 50, 75, 247, 203, 69, 155, 49, 187, 33, 90, 65, 159, 225, 217, 74, 77, 158, 218, 160, 104, 44, 195, 39, 95, 128, 54, 62, 238, 251, 149, 26, 254, 206, 168, 52, 169, 19, 240, 166, 63, 216, 12, 120, 36, 175, 35, 82, 193, 103, 23, 245, 102, 144, 231, 232, 7, 184, 96, 72, 230, 30, 83, 243, 146, 164, AlertDescription.bad_certificate_hash_value, 140, 8, 21, AlertDescription.unsupported_extension, 134, 0, 132, 250, 244, 127, 138, 66, 25, 246, 219, 205, 20, 141, 80, 18, 186, 60, 6, 78, 236, 179, 53, 17, 161, 136, 142, 43, 148, 153, 183, AlertDescription.bad_certificate_status_response, 116, 211, 228, 191, 58, 222, 150, 14, 188, 10, 237, 119, 252, 55, 107, 3, 121, 137, 98, 198, 215, 192, 210, 124, 106, 139, 34, 163, 91, 5, 93, 2, 117, 213, 97, 227, 24, 143, 85, 81, 173, 31, 11, 94, 133, 229, 194, 87, 99, 202, 61, 108, 180, 197, 204, AlertDescription.unrecognized_name, 178, 145, 89, 13, 71, 32, 200, 79, 88, 224, 1, 226, 22, 56, 196, AlertDescription.certificate_unobtainable, 59, 15, 101, 70, 190, 126, 45, 123, 130, 249, 64, 181, 29, AlertDescription.unknown_psk_identity, 248, 235, 38, 199, 135, 151, 37, 84, 177, 40, 170, 152, 157, 165, 100, 109, 122, 212, 16, 129, 68, 239, 73, 214, 174, 46, 221, 118, 92, 47, 167, 28, 201, 9, 105, 154, 131, 207, 41, 57, 185, 233, 76, 255, 67, 171};
    private JcaJceExtHelper helper;

    interface JCECallback {
        Object doInJCE() throws CMSException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException;
    }

    static {
        HashMap hashMap = new HashMap();
        BASE_CIPHER_NAMES = hashMap;
        HashMap hashMap2 = new HashMap();
        CIPHER_ALG_NAMES = hashMap2;
        HashMap hashMap3 = new HashMap();
        MAC_ALG_NAMES = hashMap3;
        hashMap.put(CMSAlgorithm.DES_CBC, "DES");
        hashMap.put(CMSAlgorithm.DES_EDE3_CBC, "DESEDE");
        hashMap.put(CMSAlgorithm.AES128_CBC, "AES");
        hashMap.put(CMSAlgorithm.AES192_CBC, "AES");
        hashMap.put(CMSAlgorithm.AES256_CBC, "AES");
        hashMap.put(CMSAlgorithm.RC2_CBC, "RC2");
        hashMap.put(CMSAlgorithm.CAST5_CBC, "CAST5");
        hashMap.put(CMSAlgorithm.CAMELLIA128_CBC, "Camellia");
        hashMap.put(CMSAlgorithm.CAMELLIA192_CBC, "Camellia");
        hashMap.put(CMSAlgorithm.CAMELLIA256_CBC, "Camellia");
        hashMap.put(CMSAlgorithm.SEED_CBC, "SEED");
        hashMap.put(PKCSObjectIdentifiers.rc4, "RC4");
        hashMap2.put(CMSAlgorithm.DES_CBC, "DES/CBC/PKCS5Padding");
        hashMap2.put(CMSAlgorithm.RC2_CBC, "RC2/CBC/PKCS5Padding");
        hashMap2.put(CMSAlgorithm.DES_EDE3_CBC, "DESEDE/CBC/PKCS5Padding");
        hashMap2.put(CMSAlgorithm.AES128_CBC, "AES/CBC/PKCS5Padding");
        hashMap2.put(CMSAlgorithm.AES192_CBC, "AES/CBC/PKCS5Padding");
        hashMap2.put(CMSAlgorithm.AES256_CBC, "AES/CBC/PKCS5Padding");
        hashMap2.put(PKCSObjectIdentifiers.rsaEncryption, "RSA/ECB/PKCS1Padding");
        hashMap2.put(CMSAlgorithm.CAST5_CBC, "CAST5/CBC/PKCS5Padding");
        hashMap2.put(CMSAlgorithm.CAMELLIA128_CBC, "Camellia/CBC/PKCS5Padding");
        hashMap2.put(CMSAlgorithm.CAMELLIA192_CBC, "Camellia/CBC/PKCS5Padding");
        hashMap2.put(CMSAlgorithm.CAMELLIA256_CBC, "Camellia/CBC/PKCS5Padding");
        hashMap2.put(CMSAlgorithm.SEED_CBC, "SEED/CBC/PKCS5Padding");
        hashMap2.put(PKCSObjectIdentifiers.rc4, "RC4");
        hashMap3.put(CMSAlgorithm.DES_EDE3_CBC, "DESEDEMac");
        hashMap3.put(CMSAlgorithm.AES128_CBC, "AESMac");
        hashMap3.put(CMSAlgorithm.AES192_CBC, "AESMac");
        hashMap3.put(CMSAlgorithm.AES256_CBC, "AESMac");
        hashMap3.put(CMSAlgorithm.RC2_CBC, "RC2Mac");
    }

    EnvelopedDataHelper(JcaJceExtHelper jcaJceExtHelper) {
        this.helper = jcaJceExtHelper;
    }

    /* access modifiers changed from: package-private */
    public String getBaseCipherName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        return str == null ? aSN1ObjectIdentifier.getId() : str;
    }

    /* access modifiers changed from: package-private */
    public Key getJceKey(GenericKey genericKey) {
        if (genericKey.getRepresentation() instanceof Key) {
            return (Key) genericKey.getRepresentation();
        }
        if (genericKey.getRepresentation() instanceof byte[]) {
            return new SecretKeySpec((byte[]) genericKey.getRepresentation(), "ENC");
        }
        throw new IllegalArgumentException("unknown generic key type");
    }

    public Key getJceKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, GenericKey genericKey) {
        if (genericKey.getRepresentation() instanceof Key) {
            return (Key) genericKey.getRepresentation();
        }
        if (genericKey.getRepresentation() instanceof byte[]) {
            return new SecretKeySpec((byte[]) genericKey.getRepresentation(), getBaseCipherName(aSN1ObjectIdentifier));
        }
        throw new IllegalArgumentException("unknown generic key type");
    }

    public void keySizeCheck(AlgorithmIdentifier algorithmIdentifier, Key key) throws CMSException {
        int keySize = KEY_SIZE_PROVIDER.getKeySize(algorithmIdentifier);
        if (keySize > 0) {
            byte[] bArr = null;
            try {
                bArr = key.getEncoded();
            } catch (Exception unused) {
            }
            if (bArr != null && bArr.length * 8 != keySize) {
                throw new CMSException("Expected key size for algorithm OID not found in recipient.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.crypto.Cipher createCipher(org.spongycastle.asn1.ASN1ObjectIdentifier r4) throws org.spongycastle.cms.CMSException {
        /*
            r3 = this;
            java.util.Map r0 = CIPHER_ALG_NAMES     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            org.spongycastle.cms.jcajce.JcaJceExtHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            javax.crypto.Cipher r4 = r1.createCipher(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            org.spongycastle.cms.jcajce.JcaJceExtHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            javax.crypto.Cipher r4 = r0.createCipher(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            org.spongycastle.cms.CMSException r0 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot create cipher: "
            r1.append(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.jcajce.EnvelopedDataHelper.createCipher(org.spongycastle.asn1.ASN1ObjectIdentifier):javax.crypto.Cipher");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.crypto.Mac createMac(org.spongycastle.asn1.ASN1ObjectIdentifier r4) throws org.spongycastle.cms.CMSException {
        /*
            r3 = this;
            java.util.Map r0 = MAC_ALG_NAMES     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            org.spongycastle.cms.jcajce.JcaJceExtHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            javax.crypto.Mac r4 = r1.createMac(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            org.spongycastle.cms.jcajce.JcaJceExtHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            javax.crypto.Mac r4 = r0.createMac(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            org.spongycastle.cms.CMSException r0 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot create mac: "
            r1.append(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.jcajce.EnvelopedDataHelper.createMac(org.spongycastle.asn1.ASN1ObjectIdentifier):javax.crypto.Mac");
    }

    /* access modifiers changed from: package-private */
    public Cipher createRFC3211Wrapper(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        if (str != null) {
            try {
                return this.helper.createCipher(str + "RFC3211Wrap");
            } catch (GeneralSecurityException e) {
                throw new CMSException("cannot create cipher: " + e.getMessage(), e);
            }
        } else {
            throw new CMSException("no name for " + aSN1ObjectIdentifier);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.crypto.KeyAgreement createKeyAgreement(org.spongycastle.asn1.ASN1ObjectIdentifier r4) throws org.spongycastle.cms.CMSException {
        /*
            r3 = this;
            java.util.Map r0 = BASE_CIPHER_NAMES     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            org.spongycastle.cms.jcajce.JcaJceExtHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            javax.crypto.KeyAgreement r4 = r1.createKeyAgreement(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            org.spongycastle.cms.jcajce.JcaJceExtHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            javax.crypto.KeyAgreement r4 = r0.createKeyAgreement(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            org.spongycastle.cms.CMSException r0 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot create key pair generator: "
            r1.append(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.jcajce.EnvelopedDataHelper.createKeyAgreement(org.spongycastle.asn1.ASN1ObjectIdentifier):javax.crypto.KeyAgreement");
    }

    /* access modifiers changed from: package-private */
    public AlgorithmParameterGenerator createAlgorithmParameterGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws GeneralSecurityException {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        if (str != null) {
            try {
                return this.helper.createAlgorithmParameterGenerator(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.helper.createAlgorithmParameterGenerator(aSN1ObjectIdentifier.getId());
    }

    public Cipher createContentCipher(final Key key, final AlgorithmIdentifier algorithmIdentifier) throws CMSException {
        return (Cipher) execute(new JCECallback() {
            public Object doInJCE() throws CMSException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
                Cipher createCipher = EnvelopedDataHelper.this.createCipher(algorithmIdentifier.getAlgorithm());
                ASN1Encodable parameters = algorithmIdentifier.getParameters();
                String id = algorithmIdentifier.getAlgorithm().getId();
                if (parameters != null && !(parameters instanceof ASN1Null)) {
                    try {
                        AlgorithmParameters createAlgorithmParameters = EnvelopedDataHelper.this.createAlgorithmParameters(algorithmIdentifier.getAlgorithm());
                        CMSUtils.loadParameters(createAlgorithmParameters, parameters);
                        createCipher.init(2, key, createAlgorithmParameters);
                    } catch (NoSuchAlgorithmException e) {
                        if (id.equals(CMSAlgorithm.DES_CBC.getId()) || id.equals(CMSEnvelopedDataGenerator.DES_EDE3_CBC) || id.equals(CMSEnvelopedGenerator.IDEA_CBC) || id.equals(CMSEnvelopedDataGenerator.AES128_CBC) || id.equals(CMSEnvelopedDataGenerator.AES192_CBC) || id.equals(CMSEnvelopedDataGenerator.AES256_CBC)) {
                            createCipher.init(2, key, new IvParameterSpec(ASN1OctetString.getInstance(parameters).getOctets()));
                        } else {
                            throw e;
                        }
                    }
                } else if (id.equals(CMSAlgorithm.DES_CBC.getId()) || id.equals(CMSEnvelopedDataGenerator.DES_EDE3_CBC) || id.equals(CMSEnvelopedGenerator.IDEA_CBC) || id.equals(CMSEnvelopedGenerator.CAST5_CBC)) {
                    createCipher.init(2, key, new IvParameterSpec(new byte[8]));
                } else {
                    createCipher.init(2, key);
                }
                return createCipher;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Mac createContentMac(final Key key, final AlgorithmIdentifier algorithmIdentifier) throws CMSException {
        return (Mac) execute(new JCECallback() {
            public Object doInJCE() throws CMSException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
                Mac createMac = EnvelopedDataHelper.this.createMac(algorithmIdentifier.getAlgorithm());
                ASN1Encodable parameters = algorithmIdentifier.getParameters();
                algorithmIdentifier.getAlgorithm().getId();
                if (parameters == null || (parameters instanceof ASN1Null)) {
                    createMac.init(key);
                } else {
                    try {
                        AlgorithmParameters createAlgorithmParameters = EnvelopedDataHelper.this.createAlgorithmParameters(algorithmIdentifier.getAlgorithm());
                        CMSUtils.loadParameters(createAlgorithmParameters, parameters);
                        createMac.init(key, createAlgorithmParameters.getParameterSpec(IvParameterSpec.class));
                    } catch (NoSuchAlgorithmException e) {
                        throw e;
                    }
                }
                return createMac;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public AlgorithmParameters createAlgorithmParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws NoSuchAlgorithmException, NoSuchProviderException {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        if (str != null) {
            try {
                return this.helper.createAlgorithmParameters(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.helper.createAlgorithmParameters(aSN1ObjectIdentifier.getId());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.KeyPairGenerator createKeyPairGenerator(org.spongycastle.asn1.ASN1ObjectIdentifier r4) throws org.spongycastle.cms.CMSException {
        /*
            r3 = this;
            java.util.Map r0 = BASE_CIPHER_NAMES     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            org.spongycastle.cms.jcajce.JcaJceExtHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            java.security.KeyPairGenerator r4 = r1.createKeyPairGenerator(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            org.spongycastle.cms.jcajce.JcaJceExtHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            java.security.KeyPairGenerator r4 = r0.createKeyPairGenerator(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            org.spongycastle.cms.CMSException r0 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot create key pair generator: "
            r1.append(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.jcajce.EnvelopedDataHelper.createKeyPairGenerator(org.spongycastle.asn1.ASN1ObjectIdentifier):java.security.KeyPairGenerator");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.crypto.KeyGenerator createKeyGenerator(org.spongycastle.asn1.ASN1ObjectIdentifier r4) throws org.spongycastle.cms.CMSException {
        /*
            r3 = this;
            java.util.Map r0 = BASE_CIPHER_NAMES     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            org.spongycastle.cms.jcajce.JcaJceExtHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            javax.crypto.KeyGenerator r4 = r1.createKeyGenerator(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            org.spongycastle.cms.jcajce.JcaJceExtHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            javax.crypto.KeyGenerator r4 = r0.createKeyGenerator(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            org.spongycastle.cms.CMSException r0 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot create key generator: "
            r1.append(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.jcajce.EnvelopedDataHelper.createKeyGenerator(org.spongycastle.asn1.ASN1ObjectIdentifier):javax.crypto.KeyGenerator");
    }

    /* access modifiers changed from: package-private */
    public AlgorithmParameters generateParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, SecretKey secretKey, SecureRandom secureRandom) throws CMSException {
        try {
            AlgorithmParameterGenerator createAlgorithmParameterGenerator = createAlgorithmParameterGenerator(aSN1ObjectIdentifier);
            if (aSN1ObjectIdentifier.equals(CMSAlgorithm.RC2_CBC)) {
                byte[] bArr = new byte[8];
                secureRandom.nextBytes(bArr);
                createAlgorithmParameterGenerator.init(new RC2ParameterSpec(secretKey.getEncoded().length * 8, bArr), secureRandom);
            }
            return createAlgorithmParameterGenerator.generateParameters();
        } catch (InvalidAlgorithmParameterException e) {
            throw new CMSException("parameters generation error: " + e, e);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        } catch (GeneralSecurityException e2) {
            throw new CMSException("exception creating algorithm parameter generator: " + e2, e2);
        }
    }

    /* access modifiers changed from: package-private */
    public AlgorithmIdentifier getAlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmParameters algorithmParameters) throws CMSException {
        ASN1Encodable aSN1Encodable;
        if (algorithmParameters != null) {
            aSN1Encodable = CMSUtils.extractParameters(algorithmParameters);
        } else {
            aSN1Encodable = DERNull.INSTANCE;
        }
        return new AlgorithmIdentifier(aSN1ObjectIdentifier, aSN1Encodable);
    }

    static Object execute(JCECallback jCECallback) throws CMSException {
        try {
            return jCECallback.doInJCE();
        } catch (NoSuchAlgorithmException e) {
            throw new CMSException("can't find algorithm.", e);
        } catch (InvalidKeyException e2) {
            throw new CMSException("key invalid in message.", e2);
        } catch (NoSuchProviderException e3) {
            throw new CMSException("can't find provider.", e3);
        } catch (NoSuchPaddingException e4) {
            throw new CMSException("required padding not supported.", e4);
        } catch (InvalidAlgorithmParameterException e5) {
            throw new CMSException("algorithm parameters invalid.", e5);
        } catch (InvalidParameterSpecException e6) {
            throw new CMSException("MAC algorithm parameter spec invalid.", e6);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.KeyFactory createKeyFactory(org.spongycastle.asn1.ASN1ObjectIdentifier r4) throws org.spongycastle.cms.CMSException {
        /*
            r3 = this;
            java.util.Map r0 = BASE_CIPHER_NAMES     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            org.spongycastle.cms.jcajce.JcaJceExtHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            java.security.KeyFactory r4 = r1.createKeyFactory(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            org.spongycastle.cms.jcajce.JcaJceExtHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            java.security.KeyFactory r4 = r0.createKeyFactory(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            org.spongycastle.cms.CMSException r0 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot create key factory: "
            r1.append(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.jcajce.EnvelopedDataHelper.createKeyFactory(org.spongycastle.asn1.ASN1ObjectIdentifier):java.security.KeyFactory");
    }

    public JceAsymmetricKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey) {
        return this.helper.createAsymmetricUnwrapper(algorithmIdentifier, privateKey);
    }

    public SymmetricKeyUnwrapper createSymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, SecretKey secretKey) {
        return this.helper.createSymmetricUnwrapper(algorithmIdentifier, secretKey);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: short} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.asn1.x509.AlgorithmIdentifier getAlgorithmIdentifier(org.spongycastle.asn1.ASN1ObjectIdentifier r4, java.security.spec.AlgorithmParameterSpec r5) {
        /*
            r3 = this;
            boolean r0 = r5 instanceof javax.crypto.spec.IvParameterSpec
            if (r0 == 0) goto L_0x0015
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = new org.spongycastle.asn1.x509.AlgorithmIdentifier
            org.spongycastle.asn1.DEROctetString r1 = new org.spongycastle.asn1.DEROctetString
            javax.crypto.spec.IvParameterSpec r5 = (javax.crypto.spec.IvParameterSpec) r5
            byte[] r5 = r5.getIV()
            r1.<init>((byte[]) r5)
            r0.<init>(r4, r1)
            return r0
        L_0x0015:
            boolean r0 = r5 instanceof javax.crypto.spec.RC2ParameterSpec
            if (r0 == 0) goto L_0x0048
            javax.crypto.spec.RC2ParameterSpec r5 = (javax.crypto.spec.RC2ParameterSpec) r5
            int r0 = r5.getEffectiveKeyBits()
            r1 = -1
            if (r0 == r1) goto L_0x0039
            r1 = 256(0x100, float:3.59E-43)
            if (r0 >= r1) goto L_0x002a
            short[] r1 = rc2Table
            short r0 = r1[r0]
        L_0x002a:
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier
            org.spongycastle.asn1.pkcs.RC2CBCParameter r2 = new org.spongycastle.asn1.pkcs.RC2CBCParameter
            byte[] r5 = r5.getIV()
            r2.<init>(r0, r5)
            r1.<init>(r4, r2)
            return r1
        L_0x0039:
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = new org.spongycastle.asn1.x509.AlgorithmIdentifier
            org.spongycastle.asn1.pkcs.RC2CBCParameter r1 = new org.spongycastle.asn1.pkcs.RC2CBCParameter
            byte[] r5 = r5.getIV()
            r1.<init>((byte[]) r5)
            r0.<init>(r4, r1)
            return r0
        L_0x0048:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unknown parameter spec: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.jcajce.EnvelopedDataHelper.getAlgorithmIdentifier(org.spongycastle.asn1.ASN1ObjectIdentifier, java.security.spec.AlgorithmParameterSpec):org.spongycastle.asn1.x509.AlgorithmIdentifier");
    }
}
