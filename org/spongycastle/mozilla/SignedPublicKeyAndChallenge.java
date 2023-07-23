package org.spongycastle.mozilla;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.mozilla.PublicKeyAndChallenge;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;

public class SignedPublicKeyAndChallenge extends ASN1Object {
    private PublicKeyAndChallenge pkac;
    private DERBitString signature = ((DERBitString) this.spkacSeq.getObjectAt(2));
    private AlgorithmIdentifier signatureAlgorithm = AlgorithmIdentifier.getInstance(this.spkacSeq.getObjectAt(1));
    private ASN1Sequence spkacSeq;

    private static ASN1Sequence toDERSequence(byte[] bArr) {
        try {
            return (ASN1Sequence) new ASN1InputStream((InputStream) new ByteArrayInputStream(bArr)).readObject();
        } catch (Exception unused) {
            throw new IllegalArgumentException("badly encoded request");
        }
    }

    public SignedPublicKeyAndChallenge(byte[] bArr) {
        ASN1Sequence dERSequence = toDERSequence(bArr);
        this.spkacSeq = dERSequence;
        this.pkac = PublicKeyAndChallenge.getInstance(dERSequence.getObjectAt(0));
    }

    public ASN1Primitive toASN1Primitive() {
        return this.spkacSeq;
    }

    public PublicKeyAndChallenge getPublicKeyAndChallenge() {
        return this.pkac;
    }

    public boolean verify() throws NoSuchAlgorithmException, SignatureException, NoSuchProviderException, InvalidKeyException {
        return verify((String) null);
    }

    public boolean verify(String str) throws NoSuchAlgorithmException, SignatureException, NoSuchProviderException, InvalidKeyException {
        Signature signature2;
        if (str == null) {
            signature2 = Signature.getInstance(this.signatureAlgorithm.getAlgorithm().getId());
        } else {
            signature2 = Signature.getInstance(this.signatureAlgorithm.getAlgorithm().getId(), str);
        }
        signature2.initVerify(getPublicKey(str));
        try {
            signature2.update(new DERBitString((ASN1Encodable) this.pkac).getBytes());
            return signature2.verify(this.signature.getBytes());
        } catch (Exception unused) {
            throw new InvalidKeyException("error encoding public key");
        }
    }

    public PublicKey getPublicKey(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.pkac.getSubjectPublicKeyInfo();
        try {
            return KeyFactory.getInstance(subjectPublicKeyInfo.getAlgorithm().getAlgorithm().getId(), str).generatePublic(new X509EncodedKeySpec(new DERBitString((ASN1Encodable) subjectPublicKeyInfo).getBytes()));
        } catch (Exception unused) {
            throw new InvalidKeyException("error encoding public key");
        }
    }
}
