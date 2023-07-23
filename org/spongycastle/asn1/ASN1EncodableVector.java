package org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Vector;

public class ASN1EncodableVector {

    /* renamed from: v */
    Vector f662v = new Vector();

    public void add(ASN1Encodable aSN1Encodable) {
        this.f662v.addElement(aSN1Encodable);
    }

    public void addAll(ASN1EncodableVector aSN1EncodableVector) {
        Enumeration elements = aSN1EncodableVector.f662v.elements();
        while (elements.hasMoreElements()) {
            this.f662v.addElement(elements.nextElement());
        }
    }

    public ASN1Encodable get(int i) {
        return (ASN1Encodable) this.f662v.elementAt(i);
    }

    public int size() {
        return this.f662v.size();
    }
}
