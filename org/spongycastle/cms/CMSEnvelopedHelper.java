package org.spongycastle.cms;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.cms.KEKRecipientInfo;
import org.spongycastle.asn1.cms.KeyAgreeRecipientInfo;
import org.spongycastle.asn1.cms.KeyTransRecipientInfo;
import org.spongycastle.asn1.cms.PasswordRecipientInfo;
import org.spongycastle.asn1.cms.RecipientInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.operator.DigestCalculator;
import org.spongycastle.util.Integers;

class CMSEnvelopedHelper {
    private static final Map BASE_CIPHER_NAMES;
    private static final Map CIPHER_ALG_NAMES;
    static final CMSEnvelopedHelper INSTANCE = new CMSEnvelopedHelper();
    private static final Map KEYSIZES;
    private static final Map MAC_ALG_NAMES;

    CMSEnvelopedHelper() {
    }

    static {
        HashMap hashMap = new HashMap();
        KEYSIZES = hashMap;
        HashMap hashMap2 = new HashMap();
        BASE_CIPHER_NAMES = hashMap2;
        HashMap hashMap3 = new HashMap();
        CIPHER_ALG_NAMES = hashMap3;
        HashMap hashMap4 = new HashMap();
        MAC_ALG_NAMES = hashMap4;
        hashMap.put(CMSEnvelopedGenerator.DES_EDE3_CBC, Integers.valueOf(192));
        hashMap.put(CMSEnvelopedGenerator.AES128_CBC, Integers.valueOf(128));
        hashMap.put(CMSEnvelopedGenerator.AES192_CBC, Integers.valueOf(192));
        hashMap.put(CMSEnvelopedGenerator.AES256_CBC, Integers.valueOf(256));
        hashMap2.put(CMSEnvelopedGenerator.DES_EDE3_CBC, "DESEDE");
        hashMap2.put(CMSEnvelopedGenerator.AES128_CBC, "AES");
        hashMap2.put(CMSEnvelopedGenerator.AES192_CBC, "AES");
        hashMap2.put(CMSEnvelopedGenerator.AES256_CBC, "AES");
        hashMap3.put(CMSEnvelopedGenerator.DES_EDE3_CBC, "DESEDE/CBC/PKCS5Padding");
        hashMap3.put(CMSEnvelopedGenerator.AES128_CBC, "AES/CBC/PKCS5Padding");
        hashMap3.put(CMSEnvelopedGenerator.AES192_CBC, "AES/CBC/PKCS5Padding");
        hashMap3.put(CMSEnvelopedGenerator.AES256_CBC, "AES/CBC/PKCS5Padding");
        hashMap4.put(CMSEnvelopedGenerator.DES_EDE3_CBC, "DESEDEMac");
        hashMap4.put(CMSEnvelopedGenerator.AES128_CBC, "AESMac");
        hashMap4.put(CMSEnvelopedGenerator.AES192_CBC, "AESMac");
        hashMap4.put(CMSEnvelopedGenerator.AES256_CBC, "AESMac");
    }

    /* access modifiers changed from: package-private */
    public int getKeySize(String str) {
        Integer num = (Integer) KEYSIZES.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("no keysize for " + str);
    }

    static RecipientInformationStore buildRecipientInformationStore(ASN1Set aSN1Set, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable) {
        return buildRecipientInformationStore(aSN1Set, algorithmIdentifier, cMSSecureReadable, (AuthAttributesProvider) null);
    }

    static RecipientInformationStore buildRecipientInformationStore(ASN1Set aSN1Set, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != aSN1Set.size(); i++) {
            readRecipientInfo(arrayList, RecipientInfo.getInstance(aSN1Set.getObjectAt(i)), algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        }
        return new RecipientInformationStore(arrayList);
    }

    private static void readRecipientInfo(List list, RecipientInfo recipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        ASN1Encodable info = recipientInfo.getInfo();
        if (info instanceof KeyTransRecipientInfo) {
            list.add(new KeyTransRecipientInformation((KeyTransRecipientInfo) info, algorithmIdentifier, cMSSecureReadable, authAttributesProvider));
        } else if (info instanceof KEKRecipientInfo) {
            list.add(new KEKRecipientInformation((KEKRecipientInfo) info, algorithmIdentifier, cMSSecureReadable, authAttributesProvider));
        } else if (info instanceof KeyAgreeRecipientInfo) {
            KeyAgreeRecipientInformation.readRecipientInfo(list, (KeyAgreeRecipientInfo) info, algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        } else if (info instanceof PasswordRecipientInfo) {
            list.add(new PasswordRecipientInformation((PasswordRecipientInfo) info, algorithmIdentifier, cMSSecureReadable, authAttributesProvider));
        }
    }

    static class CMSDigestAuthenticatedSecureReadable implements CMSSecureReadable {
        /* access modifiers changed from: private */
        public DigestCalculator digestCalculator;
        private CMSReadable readable;

        public CMSDigestAuthenticatedSecureReadable(DigestCalculator digestCalculator2, CMSReadable cMSReadable) {
            this.digestCalculator = digestCalculator2;
            this.readable = cMSReadable;
        }

        public InputStream getInputStream() throws IOException, CMSException {
            return new FilterInputStream(this.readable.getInputStream()) {
                public int read() throws IOException {
                    int read = this.in.read();
                    if (read >= 0) {
                        CMSDigestAuthenticatedSecureReadable.this.digestCalculator.getOutputStream().write(read);
                    }
                    return read;
                }

                public int read(byte[] bArr, int i, int i2) throws IOException {
                    int read = this.in.read(bArr, i, i2);
                    if (read >= 0) {
                        CMSDigestAuthenticatedSecureReadable.this.digestCalculator.getOutputStream().write(bArr, i, read);
                    }
                    return read;
                }
            };
        }

        public byte[] getDigest() {
            return this.digestCalculator.getDigest();
        }
    }

    static class CMSAuthenticatedSecureReadable implements CMSSecureReadable {
        private AlgorithmIdentifier algorithm;
        private CMSReadable readable;

        CMSAuthenticatedSecureReadable(AlgorithmIdentifier algorithmIdentifier, CMSReadable cMSReadable) {
            this.algorithm = algorithmIdentifier;
            this.readable = cMSReadable;
        }

        public InputStream getInputStream() throws IOException, CMSException {
            return this.readable.getInputStream();
        }
    }

    static class CMSEnvelopedSecureReadable implements CMSSecureReadable {
        private AlgorithmIdentifier algorithm;
        private CMSReadable readable;

        CMSEnvelopedSecureReadable(AlgorithmIdentifier algorithmIdentifier, CMSReadable cMSReadable) {
            this.algorithm = algorithmIdentifier;
            this.readable = cMSReadable;
        }

        public InputStream getInputStream() throws IOException, CMSException {
            return this.readable.getInputStream();
        }
    }
}
