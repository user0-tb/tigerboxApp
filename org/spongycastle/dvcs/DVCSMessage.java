package org.spongycastle.dvcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cms.ContentInfo;

public abstract class DVCSMessage {
    private final ContentInfo contentInfo;

    public abstract ASN1Encodable getContent();

    protected DVCSMessage(ContentInfo contentInfo2) {
        this.contentInfo = contentInfo2;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentInfo.getContentType();
    }
}
