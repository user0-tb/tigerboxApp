package media.tiger.tigerbox.utils;

import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/utils/PemUtils;", "", "()V", "CERTIFICATE_END", "", "CERTIFICATE_START", "parseCertificateData", "Lkotlin/Pair;", "Ljava/security/cert/X509Certificate;", "rawData", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PemUtils.kt */
public final class PemUtils {
    private static final String CERTIFICATE_END = "-----END CERTIFICATE-----";
    private static final String CERTIFICATE_START = "-----BEGIN CERTIFICATE-----";
    public static final PemUtils INSTANCE = new PemUtils();

    private PemUtils() {
    }

    public final Pair<X509Certificate, X509Certificate> parseCertificateData(String str) {
        Intrinsics.checkNotNullParameter(str, "rawData");
        String obj = StringsKt.trim((CharSequence) StringsKt.substringBeforeLast$default(str, CERTIFICATE_START, (String) null, 2, (Object) null)).toString();
        String obj2 = StringsKt.trim((CharSequence) StringsKt.substringAfter$default(str, obj, (String) null, 2, (Object) null)).toString();
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(\"X.509\")");
        byte[] bytes = obj2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        Certificate generateCertificate = instance.generateCertificate(new ByteArrayInputStream(bytes));
        Objects.requireNonNull(generateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        byte[] bytes2 = obj.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        Certificate generateCertificate2 = instance.generateCertificate(new ByteArrayInputStream(bytes2));
        Objects.requireNonNull(generateCertificate2, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        return new Pair<>((X509Certificate) generateCertificate, (X509Certificate) generateCertificate2);
    }
}
