package org.spongycastle.asn1;

import java.io.IOException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class DERVisibleString extends ASN1Primitive implements ASN1String {
    private byte[] string;

    /* access modifiers changed from: package-private */
    public boolean isConstructed() {
        return false;
    }

    public static DERVisibleString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERVisibleString)) {
            return (DERVisibleString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERVisibleString) fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static DERVisibleString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERVisibleString)) {
            return getInstance(object);
        }
        return new DERVisibleString(ASN1OctetString.getInstance(object).getOctets());
    }

    DERVisibleString(byte[] bArr) {
        this.string = bArr;
    }

    public DERVisibleString(String str) {
        this.string = Strings.toByteArray(str);
    }

    public String getString() {
        return Strings.fromByteArray(this.string);
    }

    public String toString() {
        return getString();
    }

    public byte[] getOctets() {
        return Arrays.clone(this.string);
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(26, this.string);
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERVisibleString)) {
            return false;
        }
        return Arrays.areEqual(this.string, ((DERVisibleString) aSN1Primitive).string);
    }

    public int hashCode() {
        return Arrays.hashCode(this.string);
    }
}
