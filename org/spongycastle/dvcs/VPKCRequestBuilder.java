package org.spongycastle.dvcs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.spongycastle.asn1.dvcs.CertEtcToken;
import org.spongycastle.asn1.dvcs.DVCSRequestInformationBuilder;
import org.spongycastle.asn1.dvcs.DVCSTime;
import org.spongycastle.asn1.dvcs.Data;
import org.spongycastle.asn1.dvcs.ServiceType;
import org.spongycastle.asn1.dvcs.TargetEtcChain;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.cert.X509CertificateHolder;

public class VPKCRequestBuilder extends DVCSRequestBuilder {
    private List chains = new ArrayList();

    public VPKCRequestBuilder() {
        super(new DVCSRequestInformationBuilder(ServiceType.VPKC));
    }

    public void addTargetChain(X509CertificateHolder x509CertificateHolder) {
        this.chains.add(new TargetEtcChain(new CertEtcToken(0, x509CertificateHolder.toASN1Structure())));
    }

    public void addTargetChain(Extension extension) {
        this.chains.add(new TargetEtcChain(new CertEtcToken(extension)));
    }

    public void addTargetChain(TargetChain targetChain) {
        this.chains.add(targetChain.toASN1Structure());
    }

    public void setRequestTime(Date date) {
        this.requestInformationBuilder.setRequestTime(new DVCSTime(date));
    }

    public DVCSRequest build() throws DVCSException {
        List list = this.chains;
        return createDVCRequest(new Data((TargetEtcChain[]) list.toArray(new TargetEtcChain[list.size()])));
    }
}
