package media.tiger.tigerbox.usecase;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.PemResponse;
import media.tiger.tigerbox.usecase.RequestPemCertificateUseCase;
import media.tiger.tigerbox.utils.PemUtils;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/domain/PemResponse;", "stringResponse", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RequestPemCertificateUseCase.kt */
final class RequestPemCertificateUseCase$run$2 extends Lambda implements Function1<String, PemResponse> {
    final /* synthetic */ String $certificateSigningRequest;
    final /* synthetic */ RequestPemCertificateUseCase.RequestPemCertificateParams $params;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RequestPemCertificateUseCase$run$2(RequestPemCertificateUseCase.RequestPemCertificateParams requestPemCertificateParams, String str) {
        super(1);
        this.$params = requestPemCertificateParams;
        this.$certificateSigningRequest = str;
    }

    public final PemResponse invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "stringResponse");
        Pair<X509Certificate, X509Certificate> parseCertificateData = PemUtils.INSTANCE.parseCertificateData(str);
        X509Certificate component2 = parseCertificateData.component2();
        PrivateKey privateKey = this.$params.getKeyPair().getPrivate();
        Intrinsics.checkNotNullExpressionValue(privateKey, "params.keyPair.private");
        return new PemResponse.CertificateData(privateKey, this.$certificateSigningRequest, component2, parseCertificateData.component1(), str);
    }
}
