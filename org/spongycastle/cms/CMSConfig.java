package org.spongycastle.cms;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public class CMSConfig {
    public static void setSigningEncryptionAlgorithmMapping(String str, String str2) {
        CMSSignedHelper.INSTANCE.setSigningEncryptionAlgorithmMapping(new ASN1ObjectIdentifier(str), str2);
    }

    public static void setSigningDigestAlgorithmMapping(String str, String str2) {
        CMSSignedHelper.INSTANCE.setSigningDigestAlgorithmMapping(new ASN1ObjectIdentifier(str), str2);
    }
}
