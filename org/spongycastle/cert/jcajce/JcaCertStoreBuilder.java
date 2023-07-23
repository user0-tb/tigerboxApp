package org.spongycastle.cert.jcajce;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.cert.CRLException;
import java.security.cert.CertStore;
import java.security.cert.CertificateException;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.cert.X509CRLHolder;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.util.Selector;
import org.spongycastle.util.Store;

public class JcaCertStoreBuilder {
    private JcaX509CertificateConverter certificateConverter = new JcaX509CertificateConverter();
    private List certs = new ArrayList();
    private JcaX509CRLConverter crlConverter = new JcaX509CRLConverter();
    private List crls = new ArrayList();
    private Object provider;
    private String type = "Collection";

    public JcaCertStoreBuilder addCertificates(Store store) {
        this.certs.addAll(store.getMatches((Selector) null));
        return this;
    }

    public JcaCertStoreBuilder addCertificate(X509CertificateHolder x509CertificateHolder) {
        this.certs.add(x509CertificateHolder);
        return this;
    }

    public JcaCertStoreBuilder addCRLs(Store store) {
        this.crls.addAll(store.getMatches((Selector) null));
        return this;
    }

    public JcaCertStoreBuilder addCRL(X509CRLHolder x509CRLHolder) {
        this.crls.add(x509CRLHolder);
        return this;
    }

    public JcaCertStoreBuilder setProvider(String str) {
        this.certificateConverter.setProvider(str);
        this.crlConverter.setProvider(str);
        this.provider = str;
        return this;
    }

    public JcaCertStoreBuilder setProvider(Provider provider2) {
        this.certificateConverter.setProvider(provider2);
        this.crlConverter.setProvider(provider2);
        this.provider = provider2;
        return this;
    }

    public JcaCertStoreBuilder setType(String str) {
        this.type = str;
        return this;
    }

    public CertStore build() throws GeneralSecurityException {
        CollectionCertStoreParameters convertHolders = convertHolders(this.certificateConverter, this.crlConverter);
        Object obj = this.provider;
        if (obj instanceof String) {
            return CertStore.getInstance(this.type, convertHolders, (String) obj);
        }
        if (obj instanceof Provider) {
            return CertStore.getInstance(this.type, convertHolders, (Provider) obj);
        }
        return CertStore.getInstance(this.type, convertHolders);
    }

    private CollectionCertStoreParameters convertHolders(JcaX509CertificateConverter jcaX509CertificateConverter, JcaX509CRLConverter jcaX509CRLConverter) throws CertificateException, CRLException {
        ArrayList arrayList = new ArrayList(this.certs.size() + this.crls.size());
        for (X509CertificateHolder certificate : this.certs) {
            arrayList.add(jcaX509CertificateConverter.getCertificate(certificate));
        }
        for (X509CRLHolder crl : this.crls) {
            arrayList.add(jcaX509CRLConverter.getCRL(crl));
        }
        return new CollectionCertStoreParameters(arrayList);
    }
}
