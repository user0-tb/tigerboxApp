package org.spongycastle.jce.provider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.jce.X509LDAPCertStoreParameters;

public class X509LDAPCertStoreSpi extends CertStoreSpi {
    private static String LDAP_PROVIDER = "com.sun.jndi.ldap.LdapCtxFactory";
    private static String REFERRALS_IGNORE = "ignore";
    private static final String SEARCH_SECURITY_LEVEL = "none";
    private static final String URL_CONTEXT_PREFIX = "com.sun.jndi.url";
    private X509LDAPCertStoreParameters params;

    public X509LDAPCertStoreSpi(CertStoreParameters certStoreParameters) throws InvalidAlgorithmParameterException {
        super(certStoreParameters);
        if (certStoreParameters instanceof X509LDAPCertStoreParameters) {
            this.params = (X509LDAPCertStoreParameters) certStoreParameters;
            return;
        }
        throw new InvalidAlgorithmParameterException(X509LDAPCertStoreSpi.class.getName() + ": parameter must be a " + X509LDAPCertStoreParameters.class.getName() + " object\n" + certStoreParameters.toString());
    }

    private DirContext connectLDAP() throws NamingException {
        Properties properties = new Properties();
        properties.setProperty("java.naming.factory.initial", LDAP_PROVIDER);
        properties.setProperty("java.naming.batchsize", SessionDescription.SUPPORTED_SDP_VERSION);
        properties.setProperty("java.naming.provider.url", this.params.getLdapURL());
        properties.setProperty("java.naming.factory.url.pkgs", URL_CONTEXT_PREFIX);
        properties.setProperty("java.naming.referral", REFERRALS_IGNORE);
        properties.setProperty("java.naming.security.authentication", "none");
        return new InitialDirContext(properties);
    }

    private String parseDN(String str, String str2) {
        int i;
        String substring = str.substring(str.toLowerCase().indexOf(str2.toLowerCase()) + str2.length());
        int indexOf = substring.indexOf(44);
        if (indexOf == -1) {
            indexOf = substring.length();
        }
        while (substring.charAt(i - 1) == '\\') {
            i = substring.indexOf(44, i + 1);
            if (i == -1) {
                i = substring.length();
            }
        }
        String substring2 = substring.substring(0, i);
        String substring3 = substring2.substring(substring2.indexOf(61) + 1);
        if (substring3.charAt(0) == ' ') {
            substring3 = substring3.substring(1);
        }
        if (substring3.startsWith("\"")) {
            substring3 = substring3.substring(1);
        }
        return substring3.endsWith("\"") ? substring3.substring(0, substring3.length() - 1) : substring3;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:12|13|14|(1:16)|17|(1:19)|20|21|(6:25|26|27|(2:29|43)(1:42)|41|22)|40) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0077 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081 A[Catch:{ Exception -> 0x009d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection engineGetCertificates(java.security.cert.CertSelector r7) throws java.security.cert.CertStoreException {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.security.cert.X509CertSelector
            if (r0 == 0) goto L_0x00b5
            java.security.cert.X509CertSelector r7 = (java.security.cert.X509CertSelector) r7
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.Set r1 = r6.getEndCertificates(r7)
            java.util.Set r2 = r6.getCACertificates(r7)
            r1.addAll(r2)
            java.util.Set r2 = r6.getCrossCertificates(r7)
            r1.addAll(r2)
            java.util.Iterator r1 = r1.iterator()
            java.lang.String r2 = "X.509"
            java.lang.String r3 = "SC"
            java.security.cert.CertificateFactory r2 = java.security.cert.CertificateFactory.getInstance(r2, r3)     // Catch:{ Exception -> 0x009d }
        L_0x0029:
            boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x009d }
            if (r3 == 0) goto L_0x009c
            java.lang.Object r3 = r1.next()     // Catch:{ Exception -> 0x009d }
            byte[] r3 = (byte[]) r3     // Catch:{ Exception -> 0x009d }
            byte[] r3 = (byte[]) r3     // Catch:{ Exception -> 0x009d }
            if (r3 == 0) goto L_0x0029
            int r4 = r3.length     // Catch:{ Exception -> 0x009d }
            if (r4 != 0) goto L_0x003d
            goto L_0x0029
        L_0x003d:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x009d }
            r4.<init>()     // Catch:{ Exception -> 0x009d }
            r4.add(r3)     // Catch:{ Exception -> 0x009d }
            org.spongycastle.asn1.ASN1InputStream r5 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
            r5.<init>((byte[]) r3)     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
            org.spongycastle.asn1.ASN1Primitive r3 = r5.readObject()     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
            org.spongycastle.asn1.x509.CertificatePair r3 = org.spongycastle.asn1.x509.CertificatePair.getInstance(r3)     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
            r4.clear()     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
            org.spongycastle.asn1.x509.Certificate r5 = r3.getForward()     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
            if (r5 == 0) goto L_0x0066
            org.spongycastle.asn1.x509.Certificate r5 = r3.getForward()     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
            byte[] r5 = r5.getEncoded()     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
            r4.add(r5)     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
        L_0x0066:
            org.spongycastle.asn1.x509.Certificate r5 = r3.getReverse()     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
            if (r5 == 0) goto L_0x0077
            org.spongycastle.asn1.x509.Certificate r3 = r3.getReverse()     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
            byte[] r3 = r3.getEncoded()     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
            r4.add(r3)     // Catch:{ IOException | IllegalArgumentException -> 0x0077 }
        L_0x0077:
            java.util.Iterator r3 = r4.iterator()     // Catch:{ Exception -> 0x009d }
        L_0x007b:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x009d }
            if (r4 == 0) goto L_0x0029
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x009d }
            java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x009d }
            byte[] r5 = (byte[]) r5     // Catch:{ Exception -> 0x009d }
            byte[] r5 = (byte[]) r5     // Catch:{ Exception -> 0x009d }
            r4.<init>(r5)     // Catch:{ Exception -> 0x009d }
            java.security.cert.Certificate r4 = r2.generateCertificate(r4)     // Catch:{ Exception -> 0x007b }
            boolean r5 = r7.match(r4)     // Catch:{ Exception -> 0x007b }
            if (r5 == 0) goto L_0x007b
            r0.add(r4)     // Catch:{ Exception -> 0x007b }
            goto L_0x007b
        L_0x009c:
            return r0
        L_0x009d:
            r7 = move-exception
            java.security.cert.CertStoreException r0 = new java.security.cert.CertStoreException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "certificate cannot be constructed from LDAP result: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x00b5:
            java.security.cert.CertStoreException r7 = new java.security.cert.CertStoreException
            java.lang.String r0 = "selector is not a X509CertSelector"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.X509LDAPCertStoreSpi.engineGetCertificates(java.security.cert.CertSelector):java.util.Collection");
    }

    private Set certSubjectSerialSearch(X509CertSelector x509CertSelector, String[] strArr, String str, String str2) throws CertStoreException {
        String str3;
        String str4;
        String str5;
        HashSet hashSet = new HashSet();
        try {
            if (x509CertSelector.getSubjectAsBytes() == null) {
                if (x509CertSelector.getSubjectAsString() == null) {
                    if (x509CertSelector.getCertificate() == null) {
                        hashSet.addAll(search(str, "*", strArr));
                        return hashSet;
                    }
                }
            }
            if (x509CertSelector.getCertificate() != null) {
                str4 = x509CertSelector.getCertificate().getSubjectX500Principal().getName("RFC1779");
                str3 = x509CertSelector.getCertificate().getSerialNumber().toString();
            } else {
                if (x509CertSelector.getSubjectAsBytes() != null) {
                    str5 = new X500Principal(x509CertSelector.getSubjectAsBytes()).getName("RFC1779");
                } else {
                    str5 = x509CertSelector.getSubjectAsString();
                }
                str4 = str5;
                str3 = null;
            }
            hashSet.addAll(search(str, "*" + parseDN(str4, str2) + "*", strArr));
            if (!(str3 == null || this.params.getSearchForSerialNumberIn() == null)) {
                hashSet.addAll(search(this.params.getSearchForSerialNumberIn(), "*" + str3 + "*", strArr));
            }
            return hashSet;
        } catch (IOException e) {
            throw new CertStoreException("exception processing selector: " + e);
        }
    }

    private Set getEndCertificates(X509CertSelector x509CertSelector) throws CertStoreException {
        return certSubjectSerialSearch(x509CertSelector, new String[]{this.params.getUserCertificateAttribute()}, this.params.getLdapUserCertificateAttributeName(), this.params.getUserCertificateSubjectAttributeName());
    }

    private Set getCACertificates(X509CertSelector x509CertSelector) throws CertStoreException {
        String[] strArr = {this.params.getCACertificateAttribute()};
        Set certSubjectSerialSearch = certSubjectSerialSearch(x509CertSelector, strArr, this.params.getLdapCACertificateAttributeName(), this.params.getCACertificateSubjectAttributeName());
        if (certSubjectSerialSearch.isEmpty()) {
            certSubjectSerialSearch.addAll(search((String) null, "*", strArr));
        }
        return certSubjectSerialSearch;
    }

    private Set getCrossCertificates(X509CertSelector x509CertSelector) throws CertStoreException {
        String[] strArr = {this.params.getCrossCertificateAttribute()};
        Set certSubjectSerialSearch = certSubjectSerialSearch(x509CertSelector, strArr, this.params.getLdapCrossCertificateAttributeName(), this.params.getCrossCertificateSubjectAttributeName());
        if (certSubjectSerialSearch.isEmpty()) {
            certSubjectSerialSearch.addAll(search((String) null, "*", strArr));
        }
        return certSubjectSerialSearch;
    }

    public Collection engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException {
        String str;
        String[] strArr = {this.params.getCertificateRevocationListAttribute()};
        if (cRLSelector instanceof X509CRLSelector) {
            X509CRLSelector x509CRLSelector = (X509CRLSelector) cRLSelector;
            HashSet hashSet = new HashSet();
            String ldapCertificateRevocationListAttributeName = this.params.getLdapCertificateRevocationListAttributeName();
            HashSet<byte[]> hashSet2 = new HashSet<>();
            if (x509CRLSelector.getIssuerNames() != null) {
                for (Object next : x509CRLSelector.getIssuerNames()) {
                    if (next instanceof String) {
                        str = parseDN((String) next, this.params.getCertificateRevocationListIssuerAttributeName());
                    } else {
                        str = parseDN(new X500Principal((byte[]) next).getName("RFC1779"), this.params.getCertificateRevocationListIssuerAttributeName());
                    }
                    hashSet2.addAll(search(ldapCertificateRevocationListAttributeName, "*" + str + "*", strArr));
                }
            } else {
                hashSet2.addAll(search(ldapCertificateRevocationListAttributeName, "*", strArr));
            }
            hashSet2.addAll(search((String) null, "*", strArr));
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME);
                for (byte[] byteArrayInputStream : hashSet2) {
                    CRL generateCRL = instance.generateCRL(new ByteArrayInputStream(byteArrayInputStream));
                    if (x509CRLSelector.match(generateCRL)) {
                        hashSet.add(generateCRL);
                    }
                }
                return hashSet;
            } catch (Exception e) {
                throw new CertStoreException("CRL cannot be constructed from LDAP result " + e);
            }
        } else {
            throw new CertStoreException("selector is not a X509CRLSelector");
        }
    }

    private Set search(String str, String str2, String[] strArr) throws CertStoreException {
        String str3 = str + "=" + str2;
        String str4 = null;
        if (str == null) {
            str3 = str4;
        }
        HashSet hashSet = new HashSet();
        try {
            DirContext connectLDAP = connectLDAP();
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(2);
            searchControls.setCountLimit(0);
            for (int i = 0; i < strArr.length; i++) {
                String[] strArr2 = {strArr[i]};
                searchControls.setReturningAttributes(strArr2);
                String str5 = "(&(" + str3 + ")(" + strArr2[0] + "=*))";
                if (str3 == null) {
                    str5 = "(" + strArr2[0] + "=*)";
                }
                NamingEnumeration search = connectLDAP.search(this.params.getBaseDN(), str5, searchControls);
                while (search.hasMoreElements()) {
                    NamingEnumeration all = ((Attribute) ((SearchResult) search.next()).getAttributes().getAll().next()).getAll();
                    while (all.hasMore()) {
                        hashSet.add(all.next());
                    }
                }
            }
            if (connectLDAP != null) {
                try {
                    connectLDAP.close();
                } catch (Exception unused) {
                }
            }
            return hashSet;
        } catch (Exception e) {
            throw new CertStoreException("Error getting results from LDAP directory " + e);
        } catch (Throwable th) {
            if (str4 != null) {
                try {
                    str4.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }
}
