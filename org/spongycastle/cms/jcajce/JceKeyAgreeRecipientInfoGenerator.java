package org.spongycastle.cms.jcajce;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.cms.KeyAgreeRecipientIdentifier;
import org.spongycastle.asn1.cms.RecipientEncryptedKey;
import org.spongycastle.asn1.cms.RecipientKeyIdentifier;
import org.spongycastle.asn1.cms.ecc.MQVuserKeyingMaterial;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.cms.CMSAlgorithm;
import org.spongycastle.cms.CMSEnvelopedGenerator;
import org.spongycastle.cms.CMSException;
import org.spongycastle.cms.KeyAgreeRecipientInfoGenerator;
import org.spongycastle.jce.spec.MQVPrivateKeySpec;
import org.spongycastle.jce.spec.MQVPublicKeySpec;
import org.spongycastle.operator.GenericKey;

public class JceKeyAgreeRecipientInfoGenerator extends KeyAgreeRecipientInfoGenerator {
    private KeyPair ephemeralKP;
    private EnvelopedDataHelper helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
    private SecureRandom random;
    private List recipientIDs = new ArrayList();
    private List recipientKeys = new ArrayList();
    private PrivateKey senderPrivateKey;
    private PublicKey senderPublicKey;

    public JceKeyAgreeRecipientInfoGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier, PrivateKey privateKey, PublicKey publicKey, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        super(aSN1ObjectIdentifier, SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()), aSN1ObjectIdentifier2);
        this.senderPublicKey = publicKey;
        this.senderPrivateKey = privateKey;
    }

    public JceKeyAgreeRecipientInfoGenerator setProvider(Provider provider) {
        this.helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        return this;
    }

    public JceKeyAgreeRecipientInfoGenerator setProvider(String str) {
        this.helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        return this;
    }

    public JceKeyAgreeRecipientInfoGenerator setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public JceKeyAgreeRecipientInfoGenerator addRecipient(X509Certificate x509Certificate) throws CertificateEncodingException {
        this.recipientIDs.add(new KeyAgreeRecipientIdentifier(CMSUtils.getIssuerAndSerialNumber(x509Certificate)));
        this.recipientKeys.add(x509Certificate.getPublicKey());
        return this;
    }

    public JceKeyAgreeRecipientInfoGenerator addRecipient(byte[] bArr, PublicKey publicKey) throws CertificateEncodingException {
        this.recipientIDs.add(new KeyAgreeRecipientIdentifier(new RecipientKeyIdentifier(bArr)));
        this.recipientKeys.add(publicKey);
        return this;
    }

    public ASN1Sequence generateRecipientEncryptedKeys(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, GenericKey genericKey) throws CMSException {
        init(algorithmIdentifier.getAlgorithm());
        PrivateKey privateKey = this.senderPrivateKey;
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        if (algorithm.getId().equals(CMSEnvelopedGenerator.ECMQV_SHA1KDF)) {
            privateKey = new MQVPrivateKeySpec(privateKey, this.ephemeralKP.getPrivate(), this.ephemeralKP.getPublic());
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i = 0;
        while (i != this.recipientIDs.size()) {
            PublicKey publicKey = (PublicKey) this.recipientKeys.get(i);
            KeyAgreeRecipientIdentifier keyAgreeRecipientIdentifier = (KeyAgreeRecipientIdentifier) this.recipientIDs.get(i);
            if (algorithm.getId().equals(CMSEnvelopedGenerator.ECMQV_SHA1KDF)) {
                publicKey = new MQVPublicKeySpec(publicKey, publicKey);
            }
            try {
                KeyAgreement createKeyAgreement = this.helper.createKeyAgreement(algorithm);
                createKeyAgreement.init(privateKey, this.random);
                createKeyAgreement.doPhase(publicKey, true);
                SecretKey generateSecret = createKeyAgreement.generateSecret(algorithmIdentifier2.getAlgorithm().getId());
                Cipher createCipher = this.helper.createCipher(algorithmIdentifier2.getAlgorithm());
                createCipher.init(3, generateSecret, this.random);
                aSN1EncodableVector.add(new RecipientEncryptedKey(keyAgreeRecipientIdentifier, new DEROctetString(createCipher.wrap(this.helper.getJceKey(genericKey)))));
                i++;
            } catch (GeneralSecurityException e) {
                throw new CMSException("cannot perform agreement step: " + e.getMessage(), e);
            }
        }
        return new DERSequence(aSN1EncodableVector);
    }

    /* access modifiers changed from: protected */
    public ASN1Encodable getUserKeyingMaterial(AlgorithmIdentifier algorithmIdentifier) throws CMSException {
        init(algorithmIdentifier.getAlgorithm());
        if (this.ephemeralKP != null) {
            return new MQVuserKeyingMaterial(createOriginatorPublicKey(SubjectPublicKeyInfo.getInstance(this.ephemeralKP.getPublic().getEncoded())), (ASN1OctetString) null);
        }
        return null;
    }

    private void init(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        if (this.random == null) {
            this.random = new SecureRandom();
        }
        if (aSN1ObjectIdentifier.equals(CMSAlgorithm.ECMQV_SHA1KDF) && this.ephemeralKP == null) {
            try {
                ECParameterSpec params = ((ECPublicKey) this.senderPublicKey).getParams();
                KeyPairGenerator createKeyPairGenerator = this.helper.createKeyPairGenerator(aSN1ObjectIdentifier);
                createKeyPairGenerator.initialize(params, this.random);
                this.ephemeralKP = createKeyPairGenerator.generateKeyPair();
            } catch (InvalidAlgorithmParameterException e) {
                throw new CMSException("cannot determine MQV ephemeral key pair parameters from public key: " + e);
            }
        }
    }
}
