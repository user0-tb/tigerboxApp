package org.spongycastle.asn1.x500.style;

import androidx.exifinterface.media.ExifInterface;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.X500NameStyle;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;

public class BCStyle extends AbstractX500NameStyle {
    public static final ASN1ObjectIdentifier BUSINESS_CATEGORY;

    /* renamed from: C */
    public static final ASN1ObjectIdentifier f709C;

    /* renamed from: CN */
    public static final ASN1ObjectIdentifier f710CN;
    public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP;
    public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE;
    public static final ASN1ObjectIdentifier DATE_OF_BIRTH;

    /* renamed from: DC */
    public static final ASN1ObjectIdentifier f711DC;
    public static final ASN1ObjectIdentifier DMD_NAME = new ASN1ObjectIdentifier("2.5.4.54");
    public static final ASN1ObjectIdentifier DN_QUALIFIER;
    private static final Hashtable DefaultLookUp;
    private static final Hashtable DefaultSymbols;

    /* renamed from: E */
    public static final ASN1ObjectIdentifier f712E;
    public static final ASN1ObjectIdentifier EmailAddress;
    public static final ASN1ObjectIdentifier GENDER;
    public static final ASN1ObjectIdentifier GENERATION;
    public static final ASN1ObjectIdentifier GIVENNAME;
    public static final ASN1ObjectIdentifier INITIALS;
    public static final X500NameStyle INSTANCE = new BCStyle();

    /* renamed from: L */
    public static final ASN1ObjectIdentifier f713L;
    public static final ASN1ObjectIdentifier NAME;
    public static final ASN1ObjectIdentifier NAME_AT_BIRTH;

    /* renamed from: O */
    public static final ASN1ObjectIdentifier f714O;

    /* renamed from: OU */
    public static final ASN1ObjectIdentifier f715OU;
    public static final ASN1ObjectIdentifier PLACE_OF_BIRTH;
    public static final ASN1ObjectIdentifier POSTAL_ADDRESS;
    public static final ASN1ObjectIdentifier POSTAL_CODE;
    public static final ASN1ObjectIdentifier PSEUDONYM;
    public static final ASN1ObjectIdentifier SERIALNUMBER;

    /* renamed from: SN */
    public static final ASN1ObjectIdentifier f716SN;

    /* renamed from: ST */
    public static final ASN1ObjectIdentifier f717ST;
    public static final ASN1ObjectIdentifier STREET;
    public static final ASN1ObjectIdentifier SURNAME;

    /* renamed from: T */
    public static final ASN1ObjectIdentifier f718T;
    public static final ASN1ObjectIdentifier TELEPHONE_NUMBER;
    public static final ASN1ObjectIdentifier UID;
    public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER;
    public static final ASN1ObjectIdentifier UnstructuredAddress;
    public static final ASN1ObjectIdentifier UnstructuredName;
    protected final Hashtable defaultLookUp = copyHashTable(DefaultLookUp);
    protected final Hashtable defaultSymbols = copyHashTable(DefaultSymbols);

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.5.4.6");
        f709C = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.5.4.10");
        f714O = aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("2.5.4.11");
        f715OU = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("2.5.4.12");
        f718T = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("2.5.4.3");
        f710CN = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("2.5.4.5");
        f716SN = aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier("2.5.4.9");
        STREET = aSN1ObjectIdentifier7;
        SERIALNUMBER = aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier("2.5.4.7");
        f713L = aSN1ObjectIdentifier8;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("2.5.4.8");
        f717ST = aSN1ObjectIdentifier9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier("2.5.4.4");
        SURNAME = aSN1ObjectIdentifier10;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier("2.5.4.42");
        GIVENNAME = aSN1ObjectIdentifier11;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier("2.5.4.43");
        INITIALS = aSN1ObjectIdentifier12;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = new ASN1ObjectIdentifier("2.5.4.44");
        GENERATION = aSN1ObjectIdentifier13;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = new ASN1ObjectIdentifier("2.5.4.45");
        UNIQUE_IDENTIFIER = aSN1ObjectIdentifier14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = new ASN1ObjectIdentifier("2.5.4.15");
        BUSINESS_CATEGORY = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = new ASN1ObjectIdentifier("2.5.4.17");
        POSTAL_CODE = aSN1ObjectIdentifier17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = aSN1ObjectIdentifier17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = new ASN1ObjectIdentifier("2.5.4.46");
        DN_QUALIFIER = aSN1ObjectIdentifier19;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = aSN1ObjectIdentifier19;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = new ASN1ObjectIdentifier("2.5.4.65");
        PSEUDONYM = aSN1ObjectIdentifier21;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = aSN1ObjectIdentifier21;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1");
        DATE_OF_BIRTH = aSN1ObjectIdentifier23;
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = aSN1ObjectIdentifier23;
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2");
        PLACE_OF_BIRTH = aSN1ObjectIdentifier25;
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = aSN1ObjectIdentifier25;
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3");
        GENDER = aSN1ObjectIdentifier27;
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = aSN1ObjectIdentifier27;
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4");
        COUNTRY_OF_CITIZENSHIP = aSN1ObjectIdentifier29;
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = aSN1ObjectIdentifier29;
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5");
        COUNTRY_OF_RESIDENCE = aSN1ObjectIdentifier31;
        ASN1ObjectIdentifier aSN1ObjectIdentifier32 = aSN1ObjectIdentifier31;
        ASN1ObjectIdentifier aSN1ObjectIdentifier33 = new ASN1ObjectIdentifier("1.3.36.8.3.14");
        NAME_AT_BIRTH = aSN1ObjectIdentifier33;
        ASN1ObjectIdentifier aSN1ObjectIdentifier34 = aSN1ObjectIdentifier33;
        ASN1ObjectIdentifier aSN1ObjectIdentifier35 = new ASN1ObjectIdentifier("2.5.4.16");
        POSTAL_ADDRESS = aSN1ObjectIdentifier35;
        ASN1ObjectIdentifier aSN1ObjectIdentifier36 = aSN1ObjectIdentifier35;
        ASN1ObjectIdentifier aSN1ObjectIdentifier37 = X509ObjectIdentifiers.id_at_telephoneNumber;
        TELEPHONE_NUMBER = aSN1ObjectIdentifier37;
        ASN1ObjectIdentifier aSN1ObjectIdentifier38 = X509ObjectIdentifiers.id_at_name;
        NAME = aSN1ObjectIdentifier38;
        ASN1ObjectIdentifier aSN1ObjectIdentifier39 = aSN1ObjectIdentifier38;
        ASN1ObjectIdentifier aSN1ObjectIdentifier40 = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
        EmailAddress = aSN1ObjectIdentifier40;
        ASN1ObjectIdentifier aSN1ObjectIdentifier41 = aSN1ObjectIdentifier37;
        ASN1ObjectIdentifier aSN1ObjectIdentifier42 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
        UnstructuredName = aSN1ObjectIdentifier42;
        ASN1ObjectIdentifier aSN1ObjectIdentifier43 = aSN1ObjectIdentifier14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier44 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
        UnstructuredAddress = aSN1ObjectIdentifier44;
        f712E = aSN1ObjectIdentifier40;
        ASN1ObjectIdentifier aSN1ObjectIdentifier45 = aSN1ObjectIdentifier42;
        ASN1ObjectIdentifier aSN1ObjectIdentifier46 = aSN1ObjectIdentifier44;
        ASN1ObjectIdentifier aSN1ObjectIdentifier47 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        f711DC = aSN1ObjectIdentifier47;
        ASN1ObjectIdentifier aSN1ObjectIdentifier48 = aSN1ObjectIdentifier13;
        ASN1ObjectIdentifier aSN1ObjectIdentifier49 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        UID = aSN1ObjectIdentifier49;
        Hashtable hashtable = new Hashtable();
        DefaultSymbols = hashtable;
        ASN1ObjectIdentifier aSN1ObjectIdentifier50 = aSN1ObjectIdentifier12;
        Hashtable hashtable2 = new Hashtable();
        DefaultLookUp = hashtable2;
        hashtable.put(aSN1ObjectIdentifier, "C");
        hashtable.put(aSN1ObjectIdentifier2, "O");
        hashtable.put(aSN1ObjectIdentifier4, ExifInterface.GPS_DIRECTION_TRUE);
        hashtable.put(aSN1ObjectIdentifier3, "OU");
        hashtable.put(aSN1ObjectIdentifier5, "CN");
        hashtable.put(aSN1ObjectIdentifier8, "L");
        hashtable.put(aSN1ObjectIdentifier9, "ST");
        hashtable.put(aSN1ObjectIdentifier6, "SERIALNUMBER");
        hashtable.put(aSN1ObjectIdentifier40, ExifInterface.LONGITUDE_EAST);
        hashtable.put(aSN1ObjectIdentifier47, "DC");
        hashtable.put(aSN1ObjectIdentifier49, "UID");
        hashtable.put(aSN1ObjectIdentifier7, "STREET");
        hashtable.put(aSN1ObjectIdentifier10, "SURNAME");
        hashtable.put(aSN1ObjectIdentifier11, "GIVENNAME");
        ASN1ObjectIdentifier aSN1ObjectIdentifier51 = aSN1ObjectIdentifier11;
        hashtable.put(aSN1ObjectIdentifier50, "INITIALS");
        hashtable.put(aSN1ObjectIdentifier48, "GENERATION");
        hashtable.put(aSN1ObjectIdentifier46, "unstructuredAddress");
        hashtable.put(aSN1ObjectIdentifier45, "unstructuredName");
        hashtable.put(aSN1ObjectIdentifier43, "UniqueIdentifier");
        hashtable.put(aSN1ObjectIdentifier20, "DN");
        hashtable.put(aSN1ObjectIdentifier22, "Pseudonym");
        hashtable.put(aSN1ObjectIdentifier36, "PostalAddress");
        hashtable.put(aSN1ObjectIdentifier34, "NameAtBirth");
        hashtable.put(aSN1ObjectIdentifier30, "CountryOfCitizenship");
        hashtable.put(aSN1ObjectIdentifier32, "CountryOfResidence");
        hashtable.put(aSN1ObjectIdentifier28, "Gender");
        hashtable.put(aSN1ObjectIdentifier26, "PlaceOfBirth");
        hashtable.put(aSN1ObjectIdentifier24, "DateOfBirth");
        hashtable.put(aSN1ObjectIdentifier18, "PostalCode");
        hashtable.put(aSN1ObjectIdentifier16, "BusinessCategory");
        hashtable.put(aSN1ObjectIdentifier41, "TelephoneNumber");
        ASN1ObjectIdentifier aSN1ObjectIdentifier52 = aSN1ObjectIdentifier39;
        hashtable.put(aSN1ObjectIdentifier52, "Name");
        Hashtable hashtable3 = hashtable2;
        hashtable3.put("c", aSN1ObjectIdentifier);
        hashtable3.put("o", aSN1ObjectIdentifier2);
        hashtable3.put("t", aSN1ObjectIdentifier4);
        hashtable3.put("ou", aSN1ObjectIdentifier3);
        hashtable3.put("cn", aSN1ObjectIdentifier5);
        hashtable3.put("l", aSN1ObjectIdentifier8);
        hashtable3.put("st", aSN1ObjectIdentifier9);
        hashtable3.put("sn", aSN1ObjectIdentifier6);
        hashtable3.put("serialnumber", aSN1ObjectIdentifier6);
        hashtable3.put("street", aSN1ObjectIdentifier7);
        hashtable3.put("emailaddress", aSN1ObjectIdentifier40);
        hashtable3.put("dc", aSN1ObjectIdentifier47);
        hashtable3.put("e", aSN1ObjectIdentifier40);
        hashtable3.put("uid", aSN1ObjectIdentifier49);
        hashtable3.put("surname", aSN1ObjectIdentifier10);
        hashtable3.put("givenname", aSN1ObjectIdentifier51);
        hashtable3.put("initials", aSN1ObjectIdentifier50);
        hashtable3.put("generation", aSN1ObjectIdentifier48);
        hashtable3.put("unstructuredaddress", aSN1ObjectIdentifier46);
        hashtable3.put("unstructuredname", aSN1ObjectIdentifier45);
        hashtable3.put("uniqueidentifier", aSN1ObjectIdentifier43);
        hashtable3.put("dn", aSN1ObjectIdentifier20);
        hashtable3.put("pseudonym", aSN1ObjectIdentifier22);
        hashtable3.put("postaladdress", aSN1ObjectIdentifier36);
        hashtable3.put("nameofbirth", aSN1ObjectIdentifier34);
        hashtable3.put("countryofcitizenship", aSN1ObjectIdentifier30);
        hashtable3.put("countryofresidence", aSN1ObjectIdentifier32);
        hashtable3.put("gender", aSN1ObjectIdentifier28);
        hashtable3.put("placeofbirth", aSN1ObjectIdentifier26);
        hashtable3.put("dateofbirth", aSN1ObjectIdentifier24);
        hashtable3.put("postalcode", aSN1ObjectIdentifier18);
        hashtable3.put("businesscategory", aSN1ObjectIdentifier16);
        hashtable3.put("telephonenumber", aSN1ObjectIdentifier41);
        hashtable3.put("name", aSN1ObjectIdentifier52);
    }

    protected BCStyle() {
    }

    /* access modifiers changed from: protected */
    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (aSN1ObjectIdentifier.equals(EmailAddress) || aSN1ObjectIdentifier.equals(f711DC)) {
            return new DERIA5String(str);
        }
        if (aSN1ObjectIdentifier.equals(DATE_OF_BIRTH)) {
            return new ASN1GeneralizedTime(str);
        }
        if (aSN1ObjectIdentifier.equals(f709C) || aSN1ObjectIdentifier.equals(f716SN) || aSN1ObjectIdentifier.equals(DN_QUALIFIER) || aSN1ObjectIdentifier.equals(TELEPHONE_NUMBER)) {
            return new DERPrintableString(str);
        }
        return super.encodeStringValue(aSN1ObjectIdentifier, str);
    }

    public String oidToDisplayName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) DefaultSymbols.get(aSN1ObjectIdentifier);
    }

    public String[] oidToAttrNames(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return IETFUtils.findAttrNamesForOID(aSN1ObjectIdentifier, this.defaultLookUp);
    }

    public ASN1ObjectIdentifier attrNameToOID(String str) {
        return IETFUtils.decodeAttrName(str, this.defaultLookUp);
    }

    public RDN[] fromString(String str) {
        return IETFUtils.rDNsFromString(str, this);
    }

    public String toString(X500Name x500Name) {
        StringBuffer stringBuffer = new StringBuffer();
        RDN[] rDNs = x500Name.getRDNs();
        boolean z = true;
        for (RDN appendRDN : rDNs) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            IETFUtils.appendRDN(stringBuffer, appendRDN, this.defaultSymbols);
        }
        return stringBuffer.toString();
    }
}
