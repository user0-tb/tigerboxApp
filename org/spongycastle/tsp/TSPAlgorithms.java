package org.spongycastle.tsp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;

public interface TSPAlgorithms {
    public static final Set ALLOWED;
    public static final ASN1ObjectIdentifier GOST3411;
    public static final ASN1ObjectIdentifier MD5;
    public static final ASN1ObjectIdentifier RIPEMD128;
    public static final ASN1ObjectIdentifier RIPEMD160;
    public static final ASN1ObjectIdentifier RIPEMD256;
    public static final ASN1ObjectIdentifier SHA1;
    public static final ASN1ObjectIdentifier SHA224;
    public static final ASN1ObjectIdentifier SHA256;
    public static final ASN1ObjectIdentifier SHA384;
    public static final ASN1ObjectIdentifier SHA512;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.md5;
        MD5 = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = OIWObjectIdentifiers.idSHA1;
        SHA1 = aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_sha224;
        SHA224 = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_sha256;
        SHA256 = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_sha384;
        SHA384 = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_sha512;
        SHA512 = aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = TeleTrusTObjectIdentifiers.ripemd128;
        RIPEMD128 = aSN1ObjectIdentifier7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = TeleTrusTObjectIdentifiers.ripemd160;
        RIPEMD160 = aSN1ObjectIdentifier8;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = TeleTrusTObjectIdentifiers.ripemd256;
        RIPEMD256 = aSN1ObjectIdentifier9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = CryptoProObjectIdentifiers.gostR3411;
        GOST3411 = aSN1ObjectIdentifier10;
        ALLOWED = new HashSet(Arrays.asList(new ASN1ObjectIdentifier[]{aSN1ObjectIdentifier10, aSN1ObjectIdentifier, aSN1ObjectIdentifier2, aSN1ObjectIdentifier3, aSN1ObjectIdentifier4, aSN1ObjectIdentifier5, aSN1ObjectIdentifier6, aSN1ObjectIdentifier7, aSN1ObjectIdentifier8, aSN1ObjectIdentifier9}));
    }
}
