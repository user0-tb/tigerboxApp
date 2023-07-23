package org.spongycastle.asn1.x500.style;

import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.X500NameStyle;
import org.spongycastle.i18n.MessageBundle;

public class RFC4519Style extends AbstractX500NameStyle {
    private static final Hashtable DefaultLookUp;
    private static final Hashtable DefaultSymbols;
    public static final X500NameStyle INSTANCE = new RFC4519Style();
    public static final ASN1ObjectIdentifier businessCategory;

    /* renamed from: c */
    public static final ASN1ObjectIdentifier f719c;

    /* renamed from: cn */
    public static final ASN1ObjectIdentifier f720cn;

    /* renamed from: dc */
    public static final ASN1ObjectIdentifier f721dc;
    public static final ASN1ObjectIdentifier description;
    public static final ASN1ObjectIdentifier destinationIndicator;
    public static final ASN1ObjectIdentifier distinguishedName;
    public static final ASN1ObjectIdentifier dnQualifier;
    public static final ASN1ObjectIdentifier enhancedSearchGuide;
    public static final ASN1ObjectIdentifier facsimileTelephoneNumber;
    public static final ASN1ObjectIdentifier generationQualifier;
    public static final ASN1ObjectIdentifier givenName;
    public static final ASN1ObjectIdentifier houseIdentifier;
    public static final ASN1ObjectIdentifier initials;
    public static final ASN1ObjectIdentifier internationalISDNNumber;

    /* renamed from: l */
    public static final ASN1ObjectIdentifier f722l;
    public static final ASN1ObjectIdentifier member;
    public static final ASN1ObjectIdentifier name;

    /* renamed from: o */
    public static final ASN1ObjectIdentifier f723o;

    /* renamed from: ou */
    public static final ASN1ObjectIdentifier f724ou;
    public static final ASN1ObjectIdentifier owner;
    public static final ASN1ObjectIdentifier physicalDeliveryOfficeName;
    public static final ASN1ObjectIdentifier postOfficeBox;
    public static final ASN1ObjectIdentifier postalAddress;
    public static final ASN1ObjectIdentifier postalCode;
    public static final ASN1ObjectIdentifier preferredDeliveryMethod;
    public static final ASN1ObjectIdentifier registeredAddress;
    public static final ASN1ObjectIdentifier roleOccupant;
    public static final ASN1ObjectIdentifier searchGuide;
    public static final ASN1ObjectIdentifier seeAlso;
    public static final ASN1ObjectIdentifier serialNumber;

    /* renamed from: sn */
    public static final ASN1ObjectIdentifier f725sn;

    /* renamed from: st */
    public static final ASN1ObjectIdentifier f726st;
    public static final ASN1ObjectIdentifier street;
    public static final ASN1ObjectIdentifier telephoneNumber;
    public static final ASN1ObjectIdentifier teletexTerminalIdentifier;
    public static final ASN1ObjectIdentifier telexNumber;
    public static final ASN1ObjectIdentifier title;
    public static final ASN1ObjectIdentifier uid;
    public static final ASN1ObjectIdentifier uniqueMember;
    public static final ASN1ObjectIdentifier userPassword;
    public static final ASN1ObjectIdentifier x121Address;
    public static final ASN1ObjectIdentifier x500UniqueIdentifier;
    protected final Hashtable defaultLookUp = copyHashTable(DefaultLookUp);
    protected final Hashtable defaultSymbols = copyHashTable(DefaultSymbols);

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.5.4.15");
        businessCategory = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.5.4.6");
        f719c = aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("2.5.4.3");
        f720cn = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        f721dc = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("2.5.4.13");
        description = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("2.5.4.27");
        destinationIndicator = aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier("2.5.4.49");
        distinguishedName = aSN1ObjectIdentifier7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier("2.5.4.46");
        dnQualifier = aSN1ObjectIdentifier8;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("2.5.4.47");
        enhancedSearchGuide = aSN1ObjectIdentifier9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier("2.5.4.23");
        facsimileTelephoneNumber = aSN1ObjectIdentifier10;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier("2.5.4.44");
        generationQualifier = aSN1ObjectIdentifier11;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier("2.5.4.42");
        givenName = aSN1ObjectIdentifier12;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = new ASN1ObjectIdentifier("2.5.4.51");
        houseIdentifier = aSN1ObjectIdentifier13;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = new ASN1ObjectIdentifier("2.5.4.43");
        initials = aSN1ObjectIdentifier14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = new ASN1ObjectIdentifier("2.5.4.25");
        internationalISDNNumber = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = new ASN1ObjectIdentifier("2.5.4.7");
        f722l = aSN1ObjectIdentifier17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = aSN1ObjectIdentifier17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = new ASN1ObjectIdentifier("2.5.4.31");
        member = aSN1ObjectIdentifier19;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = aSN1ObjectIdentifier19;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = new ASN1ObjectIdentifier("2.5.4.41");
        name = aSN1ObjectIdentifier21;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = aSN1ObjectIdentifier21;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = new ASN1ObjectIdentifier("2.5.4.10");
        f723o = aSN1ObjectIdentifier23;
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = aSN1ObjectIdentifier23;
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = new ASN1ObjectIdentifier("2.5.4.11");
        f724ou = aSN1ObjectIdentifier25;
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = aSN1ObjectIdentifier25;
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = new ASN1ObjectIdentifier("2.5.4.32");
        owner = aSN1ObjectIdentifier27;
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = aSN1ObjectIdentifier27;
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = new ASN1ObjectIdentifier("2.5.4.19");
        physicalDeliveryOfficeName = aSN1ObjectIdentifier29;
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = aSN1ObjectIdentifier29;
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = new ASN1ObjectIdentifier("2.5.4.16");
        postalAddress = aSN1ObjectIdentifier31;
        ASN1ObjectIdentifier aSN1ObjectIdentifier32 = aSN1ObjectIdentifier31;
        ASN1ObjectIdentifier aSN1ObjectIdentifier33 = new ASN1ObjectIdentifier("2.5.4.17");
        postalCode = aSN1ObjectIdentifier33;
        ASN1ObjectIdentifier aSN1ObjectIdentifier34 = aSN1ObjectIdentifier33;
        ASN1ObjectIdentifier aSN1ObjectIdentifier35 = new ASN1ObjectIdentifier("2.5.4.18");
        postOfficeBox = aSN1ObjectIdentifier35;
        ASN1ObjectIdentifier aSN1ObjectIdentifier36 = aSN1ObjectIdentifier35;
        ASN1ObjectIdentifier aSN1ObjectIdentifier37 = new ASN1ObjectIdentifier("2.5.4.28");
        preferredDeliveryMethod = aSN1ObjectIdentifier37;
        ASN1ObjectIdentifier aSN1ObjectIdentifier38 = aSN1ObjectIdentifier37;
        ASN1ObjectIdentifier aSN1ObjectIdentifier39 = new ASN1ObjectIdentifier("2.5.4.26");
        registeredAddress = aSN1ObjectIdentifier39;
        ASN1ObjectIdentifier aSN1ObjectIdentifier40 = aSN1ObjectIdentifier39;
        ASN1ObjectIdentifier aSN1ObjectIdentifier41 = new ASN1ObjectIdentifier("2.5.4.33");
        roleOccupant = aSN1ObjectIdentifier41;
        ASN1ObjectIdentifier aSN1ObjectIdentifier42 = aSN1ObjectIdentifier41;
        ASN1ObjectIdentifier aSN1ObjectIdentifier43 = new ASN1ObjectIdentifier("2.5.4.14");
        searchGuide = aSN1ObjectIdentifier43;
        ASN1ObjectIdentifier aSN1ObjectIdentifier44 = aSN1ObjectIdentifier43;
        ASN1ObjectIdentifier aSN1ObjectIdentifier45 = new ASN1ObjectIdentifier("2.5.4.34");
        seeAlso = aSN1ObjectIdentifier45;
        ASN1ObjectIdentifier aSN1ObjectIdentifier46 = aSN1ObjectIdentifier45;
        ASN1ObjectIdentifier aSN1ObjectIdentifier47 = new ASN1ObjectIdentifier("2.5.4.5");
        serialNumber = aSN1ObjectIdentifier47;
        ASN1ObjectIdentifier aSN1ObjectIdentifier48 = aSN1ObjectIdentifier47;
        ASN1ObjectIdentifier aSN1ObjectIdentifier49 = new ASN1ObjectIdentifier("2.5.4.4");
        f725sn = aSN1ObjectIdentifier49;
        ASN1ObjectIdentifier aSN1ObjectIdentifier50 = aSN1ObjectIdentifier49;
        ASN1ObjectIdentifier aSN1ObjectIdentifier51 = new ASN1ObjectIdentifier("2.5.4.8");
        f726st = aSN1ObjectIdentifier51;
        ASN1ObjectIdentifier aSN1ObjectIdentifier52 = aSN1ObjectIdentifier51;
        ASN1ObjectIdentifier aSN1ObjectIdentifier53 = new ASN1ObjectIdentifier("2.5.4.9");
        street = aSN1ObjectIdentifier53;
        ASN1ObjectIdentifier aSN1ObjectIdentifier54 = aSN1ObjectIdentifier53;
        ASN1ObjectIdentifier aSN1ObjectIdentifier55 = new ASN1ObjectIdentifier("2.5.4.20");
        telephoneNumber = aSN1ObjectIdentifier55;
        ASN1ObjectIdentifier aSN1ObjectIdentifier56 = aSN1ObjectIdentifier55;
        ASN1ObjectIdentifier aSN1ObjectIdentifier57 = new ASN1ObjectIdentifier("2.5.4.22");
        teletexTerminalIdentifier = aSN1ObjectIdentifier57;
        ASN1ObjectIdentifier aSN1ObjectIdentifier58 = aSN1ObjectIdentifier57;
        ASN1ObjectIdentifier aSN1ObjectIdentifier59 = new ASN1ObjectIdentifier("2.5.4.21");
        telexNumber = aSN1ObjectIdentifier59;
        ASN1ObjectIdentifier aSN1ObjectIdentifier60 = aSN1ObjectIdentifier59;
        ASN1ObjectIdentifier aSN1ObjectIdentifier61 = new ASN1ObjectIdentifier("2.5.4.12");
        title = aSN1ObjectIdentifier61;
        ASN1ObjectIdentifier aSN1ObjectIdentifier62 = aSN1ObjectIdentifier61;
        ASN1ObjectIdentifier aSN1ObjectIdentifier63 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        uid = aSN1ObjectIdentifier63;
        ASN1ObjectIdentifier aSN1ObjectIdentifier64 = aSN1ObjectIdentifier63;
        ASN1ObjectIdentifier aSN1ObjectIdentifier65 = new ASN1ObjectIdentifier("2.5.4.50");
        uniqueMember = aSN1ObjectIdentifier65;
        ASN1ObjectIdentifier aSN1ObjectIdentifier66 = aSN1ObjectIdentifier65;
        ASN1ObjectIdentifier aSN1ObjectIdentifier67 = new ASN1ObjectIdentifier("2.5.4.35");
        userPassword = aSN1ObjectIdentifier67;
        ASN1ObjectIdentifier aSN1ObjectIdentifier68 = aSN1ObjectIdentifier67;
        ASN1ObjectIdentifier aSN1ObjectIdentifier69 = new ASN1ObjectIdentifier("2.5.4.24");
        x121Address = aSN1ObjectIdentifier69;
        ASN1ObjectIdentifier aSN1ObjectIdentifier70 = aSN1ObjectIdentifier69;
        ASN1ObjectIdentifier aSN1ObjectIdentifier71 = new ASN1ObjectIdentifier("2.5.4.45");
        x500UniqueIdentifier = aSN1ObjectIdentifier71;
        Hashtable hashtable = new Hashtable();
        DefaultSymbols = hashtable;
        ASN1ObjectIdentifier aSN1ObjectIdentifier72 = aSN1ObjectIdentifier71;
        Hashtable hashtable2 = new Hashtable();
        DefaultLookUp = hashtable2;
        hashtable.put(aSN1ObjectIdentifier, "businessCategory");
        hashtable.put(aSN1ObjectIdentifier2, "c");
        hashtable.put(aSN1ObjectIdentifier3, "cn");
        hashtable.put(aSN1ObjectIdentifier4, "dc");
        hashtable.put(aSN1ObjectIdentifier5, "description");
        hashtable.put(aSN1ObjectIdentifier6, "destinationIndicator");
        hashtable.put(aSN1ObjectIdentifier7, "distinguishedName");
        hashtable.put(aSN1ObjectIdentifier8, "dnQualifier");
        hashtable.put(aSN1ObjectIdentifier9, "enhancedSearchGuide");
        hashtable.put(aSN1ObjectIdentifier10, "facsimileTelephoneNumber");
        hashtable.put(aSN1ObjectIdentifier11, "generationQualifier");
        hashtable.put(aSN1ObjectIdentifier12, "givenName");
        hashtable.put(aSN1ObjectIdentifier13, "houseIdentifier");
        hashtable.put(aSN1ObjectIdentifier14, "initials");
        ASN1ObjectIdentifier aSN1ObjectIdentifier73 = aSN1ObjectIdentifier14;
        hashtable.put(aSN1ObjectIdentifier16, "internationalISDNNumber");
        ASN1ObjectIdentifier aSN1ObjectIdentifier74 = aSN1ObjectIdentifier18;
        hashtable.put(aSN1ObjectIdentifier74, "l");
        ASN1ObjectIdentifier aSN1ObjectIdentifier75 = aSN1ObjectIdentifier74;
        ASN1ObjectIdentifier aSN1ObjectIdentifier76 = aSN1ObjectIdentifier20;
        hashtable.put(aSN1ObjectIdentifier76, "member");
        ASN1ObjectIdentifier aSN1ObjectIdentifier77 = aSN1ObjectIdentifier76;
        ASN1ObjectIdentifier aSN1ObjectIdentifier78 = aSN1ObjectIdentifier22;
        hashtable.put(aSN1ObjectIdentifier78, "name");
        ASN1ObjectIdentifier aSN1ObjectIdentifier79 = aSN1ObjectIdentifier78;
        ASN1ObjectIdentifier aSN1ObjectIdentifier80 = aSN1ObjectIdentifier24;
        hashtable.put(aSN1ObjectIdentifier80, "o");
        ASN1ObjectIdentifier aSN1ObjectIdentifier81 = aSN1ObjectIdentifier80;
        ASN1ObjectIdentifier aSN1ObjectIdentifier82 = aSN1ObjectIdentifier26;
        hashtable.put(aSN1ObjectIdentifier82, "ou");
        ASN1ObjectIdentifier aSN1ObjectIdentifier83 = aSN1ObjectIdentifier82;
        ASN1ObjectIdentifier aSN1ObjectIdentifier84 = aSN1ObjectIdentifier28;
        hashtable.put(aSN1ObjectIdentifier84, "owner");
        ASN1ObjectIdentifier aSN1ObjectIdentifier85 = aSN1ObjectIdentifier84;
        hashtable.put(aSN1ObjectIdentifier30, "physicalDeliveryOfficeName");
        hashtable.put(aSN1ObjectIdentifier32, "postalAddress");
        hashtable.put(aSN1ObjectIdentifier34, "postalCode");
        hashtable.put(aSN1ObjectIdentifier36, "postOfficeBox");
        hashtable.put(aSN1ObjectIdentifier38, "preferredDeliveryMethod");
        hashtable.put(aSN1ObjectIdentifier40, "registeredAddress");
        hashtable.put(aSN1ObjectIdentifier42, "roleOccupant");
        hashtable.put(aSN1ObjectIdentifier44, "searchGuide");
        hashtable.put(aSN1ObjectIdentifier46, "seeAlso");
        hashtable.put(aSN1ObjectIdentifier48, "serialNumber");
        ASN1ObjectIdentifier aSN1ObjectIdentifier86 = aSN1ObjectIdentifier50;
        hashtable.put(aSN1ObjectIdentifier86, "sn");
        ASN1ObjectIdentifier aSN1ObjectIdentifier87 = aSN1ObjectIdentifier86;
        ASN1ObjectIdentifier aSN1ObjectIdentifier88 = aSN1ObjectIdentifier52;
        hashtable.put(aSN1ObjectIdentifier88, "st");
        ASN1ObjectIdentifier aSN1ObjectIdentifier89 = aSN1ObjectIdentifier88;
        ASN1ObjectIdentifier aSN1ObjectIdentifier90 = aSN1ObjectIdentifier54;
        hashtable.put(aSN1ObjectIdentifier90, "street");
        ASN1ObjectIdentifier aSN1ObjectIdentifier91 = aSN1ObjectIdentifier90;
        hashtable.put(aSN1ObjectIdentifier56, "telephoneNumber");
        hashtable.put(aSN1ObjectIdentifier58, "teletexTerminalIdentifier");
        hashtable.put(aSN1ObjectIdentifier60, "telexNumber");
        ASN1ObjectIdentifier aSN1ObjectIdentifier92 = aSN1ObjectIdentifier62;
        hashtable.put(aSN1ObjectIdentifier92, MessageBundle.TITLE_ENTRY);
        Object obj = MessageBundle.TITLE_ENTRY;
        ASN1ObjectIdentifier aSN1ObjectIdentifier93 = aSN1ObjectIdentifier92;
        ASN1ObjectIdentifier aSN1ObjectIdentifier94 = aSN1ObjectIdentifier64;
        hashtable.put(aSN1ObjectIdentifier94, "uid");
        ASN1ObjectIdentifier aSN1ObjectIdentifier95 = aSN1ObjectIdentifier94;
        hashtable.put(aSN1ObjectIdentifier66, "uniqueMember");
        hashtable.put(aSN1ObjectIdentifier68, "userPassword");
        hashtable.put(aSN1ObjectIdentifier70, "x121Address");
        ASN1ObjectIdentifier aSN1ObjectIdentifier96 = aSN1ObjectIdentifier72;
        hashtable.put(aSN1ObjectIdentifier96, "x500UniqueIdentifier");
        Hashtable hashtable3 = hashtable2;
        hashtable3.put("businesscategory", aSN1ObjectIdentifier);
        hashtable3.put("c", aSN1ObjectIdentifier2);
        hashtable3.put("cn", aSN1ObjectIdentifier3);
        hashtable3.put("dc", aSN1ObjectIdentifier4);
        hashtable3.put("description", aSN1ObjectIdentifier5);
        hashtable3.put("destinationindicator", aSN1ObjectIdentifier6);
        hashtable3.put("distinguishedname", aSN1ObjectIdentifier7);
        hashtable3.put("dnqualifier", aSN1ObjectIdentifier8);
        hashtable3.put("enhancedsearchguide", aSN1ObjectIdentifier9);
        hashtable3.put("facsimiletelephonenumber", aSN1ObjectIdentifier10);
        hashtable3.put("generationqualifier", aSN1ObjectIdentifier11);
        hashtable3.put("givenname", aSN1ObjectIdentifier12);
        hashtable3.put("houseidentifier", aSN1ObjectIdentifier13);
        hashtable3.put("initials", aSN1ObjectIdentifier73);
        hashtable3.put("internationalisdnnumber", aSN1ObjectIdentifier16);
        hashtable3.put("l", aSN1ObjectIdentifier75);
        hashtable3.put("member", aSN1ObjectIdentifier77);
        hashtable3.put("name", aSN1ObjectIdentifier79);
        hashtable3.put("o", aSN1ObjectIdentifier81);
        hashtable3.put("ou", aSN1ObjectIdentifier83);
        hashtable3.put("owner", aSN1ObjectIdentifier85);
        hashtable3.put("physicaldeliveryofficename", aSN1ObjectIdentifier30);
        hashtable3.put("postaladdress", aSN1ObjectIdentifier32);
        hashtable3.put("postalcode", aSN1ObjectIdentifier34);
        hashtable3.put("postofficebox", aSN1ObjectIdentifier36);
        hashtable3.put("preferreddeliverymethod", aSN1ObjectIdentifier38);
        hashtable3.put("registeredaddress", aSN1ObjectIdentifier40);
        hashtable3.put("roleoccupant", aSN1ObjectIdentifier42);
        hashtable3.put("searchguide", aSN1ObjectIdentifier44);
        hashtable3.put("seealso", aSN1ObjectIdentifier46);
        hashtable3.put("serialnumber", aSN1ObjectIdentifier48);
        hashtable3.put("sn", aSN1ObjectIdentifier87);
        hashtable3.put("st", aSN1ObjectIdentifier89);
        hashtable3.put("street", aSN1ObjectIdentifier91);
        hashtable3.put("telephonenumber", aSN1ObjectIdentifier56);
        hashtable3.put("teletexterminalidentifier", aSN1ObjectIdentifier58);
        hashtable3.put("telexnumber", aSN1ObjectIdentifier60);
        hashtable3.put(obj, aSN1ObjectIdentifier93);
        hashtable3.put("uid", aSN1ObjectIdentifier95);
        hashtable3.put("uniquemember", aSN1ObjectIdentifier66);
        hashtable3.put("userpassword", aSN1ObjectIdentifier68);
        hashtable3.put("x121address", aSN1ObjectIdentifier70);
        hashtable3.put("x500uniqueidentifier", aSN1ObjectIdentifier96);
    }

    protected RFC4519Style() {
    }

    /* access modifiers changed from: protected */
    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (aSN1ObjectIdentifier.equals(f721dc)) {
            return new DERIA5String(str);
        }
        if (aSN1ObjectIdentifier.equals(f719c) || aSN1ObjectIdentifier.equals(serialNumber) || aSN1ObjectIdentifier.equals(dnQualifier) || aSN1ObjectIdentifier.equals(telephoneNumber)) {
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
        RDN[] rDNsFromString = IETFUtils.rDNsFromString(str, this);
        int length = rDNsFromString.length;
        RDN[] rdnArr = new RDN[length];
        for (int i = 0; i != rDNsFromString.length; i++) {
            rdnArr[(length - i) - 1] = rDNsFromString[i];
        }
        return rdnArr;
    }

    public String toString(X500Name x500Name) {
        StringBuffer stringBuffer = new StringBuffer();
        RDN[] rDNs = x500Name.getRDNs();
        boolean z = true;
        for (int length = rDNs.length - 1; length >= 0; length--) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            IETFUtils.appendRDN(stringBuffer, rDNs[length], this.defaultSymbols);
        }
        return stringBuffer.toString();
    }
}
