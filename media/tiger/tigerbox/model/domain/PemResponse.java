package media.tiger.tigerbox.model.domain;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/PemResponse;", "", "()V", "CertificateData", "DefaultResponse", "Lmedia/tiger/tigerbox/model/domain/PemResponse$CertificateData;", "Lmedia/tiger/tigerbox/model/domain/PemResponse$DefaultResponse;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PemResponse.kt */
public abstract class PemResponse {
    public /* synthetic */ PemResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PemResponse() {
    }

    @Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/PemResponse$CertificateData;", "Lmedia/tiger/tigerbox/model/domain/PemResponse;", "key", "Ljava/security/PrivateKey;", "certificateSigningRequest", "", "publicCertificate", "Ljava/security/cert/X509Certificate;", "caCertificate", "rawString", "(Ljava/security/PrivateKey;Ljava/lang/String;Ljava/security/cert/X509Certificate;Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "getCaCertificate", "()Ljava/security/cert/X509Certificate;", "getCertificateSigningRequest", "()Ljava/lang/String;", "getKey", "()Ljava/security/PrivateKey;", "getPublicCertificate", "getRawString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: PemResponse.kt */
    public static final class CertificateData extends PemResponse {
        private final X509Certificate caCertificate;
        private final String certificateSigningRequest;
        private final PrivateKey key;
        private final X509Certificate publicCertificate;
        private final String rawString;

        public static /* synthetic */ CertificateData copy$default(CertificateData certificateData, PrivateKey privateKey, String str, X509Certificate x509Certificate, X509Certificate x509Certificate2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                privateKey = certificateData.key;
            }
            if ((i & 2) != 0) {
                str = certificateData.certificateSigningRequest;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                x509Certificate = certificateData.publicCertificate;
            }
            X509Certificate x509Certificate3 = x509Certificate;
            if ((i & 8) != 0) {
                x509Certificate2 = certificateData.caCertificate;
            }
            X509Certificate x509Certificate4 = x509Certificate2;
            if ((i & 16) != 0) {
                str2 = certificateData.rawString;
            }
            return certificateData.copy(privateKey, str3, x509Certificate3, x509Certificate4, str2);
        }

        public final PrivateKey component1() {
            return this.key;
        }

        public final String component2() {
            return this.certificateSigningRequest;
        }

        public final X509Certificate component3() {
            return this.publicCertificate;
        }

        public final X509Certificate component4() {
            return this.caCertificate;
        }

        public final String component5() {
            return this.rawString;
        }

        public final CertificateData copy(PrivateKey privateKey, String str, X509Certificate x509Certificate, X509Certificate x509Certificate2, String str2) {
            Intrinsics.checkNotNullParameter(privateKey, "key");
            Intrinsics.checkNotNullParameter(str, "certificateSigningRequest");
            Intrinsics.checkNotNullParameter(x509Certificate, "publicCertificate");
            Intrinsics.checkNotNullParameter(x509Certificate2, "caCertificate");
            Intrinsics.checkNotNullParameter(str2, "rawString");
            return new CertificateData(privateKey, str, x509Certificate, x509Certificate2, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CertificateData)) {
                return false;
            }
            CertificateData certificateData = (CertificateData) obj;
            return Intrinsics.areEqual((Object) this.key, (Object) certificateData.key) && Intrinsics.areEqual((Object) this.certificateSigningRequest, (Object) certificateData.certificateSigningRequest) && Intrinsics.areEqual((Object) this.publicCertificate, (Object) certificateData.publicCertificate) && Intrinsics.areEqual((Object) this.caCertificate, (Object) certificateData.caCertificate) && Intrinsics.areEqual((Object) this.rawString, (Object) certificateData.rawString);
        }

        public int hashCode() {
            return (((((((this.key.hashCode() * 31) + this.certificateSigningRequest.hashCode()) * 31) + this.publicCertificate.hashCode()) * 31) + this.caCertificate.hashCode()) * 31) + this.rawString.hashCode();
        }

        public String toString() {
            return "CertificateData(key=" + this.key + ", certificateSigningRequest=" + this.certificateSigningRequest + ", publicCertificate=" + this.publicCertificate + ", caCertificate=" + this.caCertificate + ", rawString=" + this.rawString + ')';
        }

        public final PrivateKey getKey() {
            return this.key;
        }

        public final String getCertificateSigningRequest() {
            return this.certificateSigningRequest;
        }

        public final X509Certificate getPublicCertificate() {
            return this.publicCertificate;
        }

        public final X509Certificate getCaCertificate() {
            return this.caCertificate;
        }

        public final String getRawString() {
            return this.rawString;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CertificateData(PrivateKey privateKey, String str, X509Certificate x509Certificate, X509Certificate x509Certificate2, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(privateKey, "key");
            Intrinsics.checkNotNullParameter(str, "certificateSigningRequest");
            Intrinsics.checkNotNullParameter(x509Certificate, "publicCertificate");
            Intrinsics.checkNotNullParameter(x509Certificate2, "caCertificate");
            Intrinsics.checkNotNullParameter(str2, "rawString");
            this.key = privateKey;
            this.certificateSigningRequest = str;
            this.publicCertificate = x509Certificate;
            this.caCertificate = x509Certificate2;
            this.rawString = str2;
        }
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/PemResponse$DefaultResponse;", "Lmedia/tiger/tigerbox/model/domain/PemResponse;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: PemResponse.kt */
    public static final class DefaultResponse extends PemResponse {
        public static final DefaultResponse INSTANCE = new DefaultResponse();

        private DefaultResponse() {
            super((DefaultConstructorMarker) null);
        }
    }
}
