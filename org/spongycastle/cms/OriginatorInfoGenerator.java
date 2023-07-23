package org.spongycastle.cms;

import java.util.ArrayList;
import java.util.List;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.cms.OriginatorInfo;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.util.Store;

public class OriginatorInfoGenerator {
    private final List origCRLs;
    private final List origCerts;

    public OriginatorInfoGenerator(X509CertificateHolder x509CertificateHolder) {
        ArrayList arrayList = new ArrayList(1);
        this.origCerts = arrayList;
        this.origCRLs = null;
        arrayList.add(x509CertificateHolder.toASN1Structure());
    }

    public OriginatorInfoGenerator(Store store) throws CMSException {
        this(store, (Store) null);
    }

    public OriginatorInfoGenerator(Store store, Store store2) throws CMSException {
        this.origCerts = CMSUtils.getCertificatesFromStore(store);
        if (store2 != null) {
            this.origCRLs = CMSUtils.getCRLsFromStore(store2);
        } else {
            this.origCRLs = null;
        }
    }

    public OriginatorInformation generate() {
        if (this.origCRLs != null) {
            return new OriginatorInformation(new OriginatorInfo(CMSUtils.createDerSetFromList(this.origCerts), CMSUtils.createDerSetFromList(this.origCRLs)));
        }
        return new OriginatorInformation(new OriginatorInfo(CMSUtils.createDerSetFromList(this.origCerts), (ASN1Set) null));
    }
}
