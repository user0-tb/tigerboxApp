package org.spongycastle.jcajce.provider.asymmetric.p028ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.p020x9.X9IntegerConverter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.agreement.ECDHCBasicAgreement;
import org.spongycastle.crypto.agreement.ECMQVBasicAgreement;
import org.spongycastle.crypto.agreement.kdf.DHKDFParameters;
import org.spongycastle.crypto.agreement.kdf.ECDHKEKGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.MQVPublicParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.interfaces.MQVPublicKey;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;

/* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi */
public class KeyAgreementSpi extends javax.crypto.KeyAgreementSpi {
    private static final Hashtable algorithms;
    private static final X9IntegerConverter converter = new X9IntegerConverter();
    private static final Hashtable des;
    private static final Hashtable oids;
    private BasicAgreement agreement;
    private String kaAlgorithm;
    private DerivationFunction kdf;
    private ECDomainParameters parameters;
    private BigInteger result;

    static {
        Hashtable hashtable = new Hashtable();
        algorithms = hashtable;
        Hashtable hashtable2 = new Hashtable();
        oids = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        des = hashtable3;
        Integer valueOf = Integers.valueOf(64);
        Integer valueOf2 = Integers.valueOf(128);
        Integer valueOf3 = Integers.valueOf(192);
        Integer valueOf4 = Integers.valueOf(256);
        hashtable.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), valueOf2);
        hashtable.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), valueOf3);
        hashtable.put(NISTObjectIdentifiers.id_aes256_CBC.getId(), valueOf4);
        hashtable.put(NISTObjectIdentifiers.id_aes128_wrap.getId(), valueOf2);
        hashtable.put(NISTObjectIdentifiers.id_aes192_wrap.getId(), valueOf3);
        hashtable.put(NISTObjectIdentifiers.id_aes256_wrap.getId(), valueOf4);
        hashtable.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), valueOf3);
        hashtable.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), valueOf3);
        hashtable.put(OIWObjectIdentifiers.desCBC.getId(), valueOf);
        hashtable2.put("DESEDE", PKCSObjectIdentifiers.des_EDE3_CBC);
        hashtable2.put("AES", NISTObjectIdentifiers.id_aes256_CBC);
        hashtable2.put("DES", OIWObjectIdentifiers.desCBC);
        hashtable3.put("DES", "DES");
        hashtable3.put("DESEDE", "DES");
        hashtable3.put(OIWObjectIdentifiers.desCBC.getId(), "DES");
        hashtable3.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), "DES");
        hashtable3.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), "DES");
    }

    private byte[] bigIntToBytes(BigInteger bigInteger) {
        X9IntegerConverter x9IntegerConverter = converter;
        return x9IntegerConverter.integerToBytes(bigInteger, x9IntegerConverter.getByteLength(this.parameters.getCurve()));
    }

    protected KeyAgreementSpi(String str, BasicAgreement basicAgreement, DerivationFunction derivationFunction) {
        this.kaAlgorithm = str;
        this.agreement = basicAgreement;
        this.kdf = derivationFunction;
    }

    /* access modifiers changed from: protected */
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        CipherParameters cipherParameters;
        if (this.parameters == null) {
            throw new IllegalStateException(this.kaAlgorithm + " not initialised.");
        } else if (z) {
            if (this.agreement instanceof ECMQVBasicAgreement) {
                if (key instanceof MQVPublicKey) {
                    MQVPublicKey mQVPublicKey = (MQVPublicKey) key;
                    cipherParameters = new MQVPublicParameters((ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(mQVPublicKey.getStaticKey()), (ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(mQVPublicKey.getEphemeralKey()));
                } else {
                    throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(MQVPublicKey.class) + " for doPhase");
                }
            } else if (key instanceof PublicKey) {
                cipherParameters = ECUtil.generatePublicKeyParameter((PublicKey) key);
            } else {
                throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(ECPublicKey.class) + " for doPhase");
            }
            this.result = this.agreement.calculateAgreement(cipherParameters);
            return null;
        } else {
            throw new IllegalStateException(this.kaAlgorithm + " can only be between two parties.");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.kdf == null) {
            return bigIntToBytes(this.result);
        }
        throw new UnsupportedOperationException("KDF can only be used when algorithm is known");
    }

    /* access modifiers changed from: protected */
    public int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        byte[] engineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i >= engineGenerateSecret.length) {
            System.arraycopy(engineGenerateSecret, 0, bArr, i, engineGenerateSecret.length);
            return engineGenerateSecret.length;
        }
        throw new ShortBufferException(this.kaAlgorithm + " key agreement: need " + engineGenerateSecret.length + " bytes");
    }

    /* access modifiers changed from: protected */
    public SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        byte[] bigIntToBytes = bigIntToBytes(this.result);
        String upperCase = Strings.toUpperCase(str);
        Hashtable hashtable = oids;
        String id = hashtable.containsKey(upperCase) ? ((ASN1ObjectIdentifier) hashtable.get(upperCase)).getId() : str;
        if (this.kdf != null) {
            Hashtable hashtable2 = algorithms;
            if (hashtable2.containsKey(id)) {
                int intValue = ((Integer) hashtable2.get(id)).intValue();
                DHKDFParameters dHKDFParameters = new DHKDFParameters(new ASN1ObjectIdentifier(id), intValue, bigIntToBytes);
                int i = intValue / 8;
                bigIntToBytes = new byte[i];
                this.kdf.init(dHKDFParameters);
                this.kdf.generateBytes(bigIntToBytes, 0, i);
            } else {
                throw new NoSuchAlgorithmException("unknown algorithm encountered: " + str);
            }
        } else {
            Hashtable hashtable3 = algorithms;
            if (hashtable3.containsKey(id)) {
                int intValue2 = ((Integer) hashtable3.get(id)).intValue() / 8;
                byte[] bArr = new byte[intValue2];
                System.arraycopy(bigIntToBytes, 0, bArr, 0, intValue2);
                bigIntToBytes = bArr;
            }
        }
        if (des.containsKey(id)) {
            DESParameters.setOddParity(bigIntToBytes);
        }
        return new SecretKeySpec(bigIntToBytes, str);
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null) {
            initFromKey(key);
            return;
        }
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        initFromKey(key);
    }

    /* JADX WARNING: type inference failed for: r5v9, types: [org.spongycastle.crypto.params.AsymmetricKeyParameter] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initFromKey(java.security.Key r5) throws java.security.InvalidKeyException {
        /*
            r4 = this;
            org.spongycastle.crypto.BasicAgreement r0 = r4.agreement
            boolean r0 = r0 instanceof org.spongycastle.crypto.agreement.ECMQVBasicAgreement
            java.lang.String r1 = " for initialisation"
            java.lang.String r2 = " key agreement requires "
            if (r0 == 0) goto L_0x006a
            boolean r0 = r5 instanceof org.spongycastle.jce.interfaces.MQVPrivateKey
            if (r0 == 0) goto L_0x0047
            org.spongycastle.jce.interfaces.MQVPrivateKey r5 = (org.spongycastle.jce.interfaces.MQVPrivateKey) r5
            java.security.PrivateKey r0 = r5.getStaticPrivateKey()
            org.spongycastle.crypto.params.AsymmetricKeyParameter r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r0)
            org.spongycastle.crypto.params.ECPrivateKeyParameters r0 = (org.spongycastle.crypto.params.ECPrivateKeyParameters) r0
            java.security.PrivateKey r1 = r5.getEphemeralPrivateKey()
            org.spongycastle.crypto.params.AsymmetricKeyParameter r1 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r1)
            org.spongycastle.crypto.params.ECPrivateKeyParameters r1 = (org.spongycastle.crypto.params.ECPrivateKeyParameters) r1
            r2 = 0
            java.security.PublicKey r3 = r5.getEphemeralPublicKey()
            if (r3 == 0) goto L_0x0036
            java.security.PublicKey r5 = r5.getEphemeralPublicKey()
            org.spongycastle.crypto.params.AsymmetricKeyParameter r5 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePublicKeyParameter(r5)
            r2 = r5
            org.spongycastle.crypto.params.ECPublicKeyParameters r2 = (org.spongycastle.crypto.params.ECPublicKeyParameters) r2
        L_0x0036:
            org.spongycastle.crypto.params.MQVPrivateParameters r5 = new org.spongycastle.crypto.params.MQVPrivateParameters
            r5.<init>(r0, r1, r2)
            org.spongycastle.crypto.params.ECDomainParameters r0 = r0.getParameters()
            r4.parameters = r0
            org.spongycastle.crypto.BasicAgreement r0 = r4.agreement
            r0.init(r5)
            goto L_0x0081
        L_0x0047:
            java.security.InvalidKeyException r5 = new java.security.InvalidKeyException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.kaAlgorithm
            r0.append(r3)
            r0.append(r2)
            java.lang.Class<org.spongycastle.jce.interfaces.MQVPrivateKey> r2 = org.spongycastle.jce.interfaces.MQVPrivateKey.class
            java.lang.String r2 = getSimpleName(r2)
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x006a:
            boolean r0 = r5 instanceof java.security.PrivateKey
            if (r0 == 0) goto L_0x0082
            java.security.PrivateKey r5 = (java.security.PrivateKey) r5
            org.spongycastle.crypto.params.AsymmetricKeyParameter r5 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r5)
            org.spongycastle.crypto.params.ECPrivateKeyParameters r5 = (org.spongycastle.crypto.params.ECPrivateKeyParameters) r5
            org.spongycastle.crypto.params.ECDomainParameters r0 = r5.getParameters()
            r4.parameters = r0
            org.spongycastle.crypto.BasicAgreement r0 = r4.agreement
            r0.init(r5)
        L_0x0081:
            return
        L_0x0082:
            java.security.InvalidKeyException r5 = new java.security.InvalidKeyException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.kaAlgorithm
            r0.append(r3)
            r0.append(r2)
            java.lang.Class<org.spongycastle.jce.interfaces.ECPrivateKey> r2 = org.spongycastle.jce.interfaces.ECPrivateKey.class
            java.lang.String r2 = getSimpleName(r2)
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.p028ec.KeyAgreementSpi.initFromKey(java.security.Key):void");
    }

    private static String getSimpleName(Class cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DH */
    public static class C3183DH extends KeyAgreementSpi {
        public C3183DH() {
            super("ECDH", new ECDHBasicAgreement(), (DerivationFunction) null);
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHC */
    public static class DHC extends KeyAgreementSpi {
        public DHC() {
            super("ECDHC", new ECDHCBasicAgreement(), (DerivationFunction) null);
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQV */
    public static class MQV extends KeyAgreementSpi {
        public MQV() {
            super("ECMQV", new ECMQVBasicAgreement(), (DerivationFunction) null);
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDF */
    public static class DHwithSHA1KDF extends KeyAgreementSpi {
        public DHwithSHA1KDF() {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1KDF */
    public static class MQVwithSHA1KDF extends KeyAgreementSpi {
        public MQVwithSHA1KDF() {
            super("ECMQVwithSHA1KDF", new ECMQVBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
        }
    }
}
