package media.tiger.tigerbox.usecase;

import java.security.KeyPair;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.network.ScalarTigerBoxWebService;
import media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain;
import media.tiger.tigerbox.model.domain.PemResponse;
import okhttp3.MediaType;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\n\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/RequestPemCertificateUseCase;", "Lmedia/tiger/tigerbox/infrastructure/interactor/UseCasePostOnMain;", "Lmedia/tiger/tigerbox/usecase/RequestPemCertificateUseCase$RequestPemCertificateParams;", "Lmedia/tiger/tigerbox/model/domain/PemResponse;", "scalarTigerBoxWebService", "Lmedia/tiger/tigerbox/data/network/ScalarTigerBoxWebService;", "(Lmedia/tiger/tigerbox/data/network/ScalarTigerBoxWebService;)V", "run", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "params", "(Lmedia/tiger/tigerbox/usecase/RequestPemCertificateUseCase$RequestPemCertificateParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "RequestPemCertificateParams", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RequestPemCertificateUseCase.kt */
public final class RequestPemCertificateUseCase extends UseCasePostOnMain<RequestPemCertificateParams, PemResponse> {
    private static final String CREDENTIAL_PARAMETER_NAME = "device_credential";
    private static final MediaType CREDENTIAL_PART_TYPE = MediaType.Companion.parse("text/plain; charset=UTF-8");
    private static final String CSR_PARAMETER_NAME = "csr";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final MediaType FILE_PART_TYPE = MediaType.Companion.parse("application/octet-stream");
    private final ScalarTigerBoxWebService scalarTigerBoxWebService;

    @Inject
    public RequestPemCertificateUseCase(ScalarTigerBoxWebService scalarTigerBoxWebService2) {
        Intrinsics.checkNotNullParameter(scalarTigerBoxWebService2, "scalarTigerBoxWebService");
        this.scalarTigerBoxWebService = scalarTigerBoxWebService2;
    }

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/RequestPemCertificateUseCase$Companion;", "", "()V", "CREDENTIAL_PARAMETER_NAME", "", "CREDENTIAL_PART_TYPE", "Lokhttp3/MediaType;", "CSR_PARAMETER_NAME", "FILE_PART_TYPE", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: RequestPemCertificateUseCase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(media.tiger.tigerbox.usecase.RequestPemCertificateUseCase.RequestPemCertificateParams r11, kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, ? extends media.tiger.tigerbox.model.domain.PemResponse>> r12) {
        /*
            r10 = this;
            boolean r1 = r12 instanceof media.tiger.tigerbox.usecase.RequestPemCertificateUseCase$run$1
            if (r1 == 0) goto L_0x0014
            r1 = r12
            media.tiger.tigerbox.usecase.RequestPemCertificateUseCase$run$1 r1 = (media.tiger.tigerbox.usecase.RequestPemCertificateUseCase$run$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0014
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.usecase.RequestPemCertificateUseCase$run$1 r1 = new media.tiger.tigerbox.usecase.RequestPemCertificateUseCase$run$1
            r1.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L_0x003e
            if (r3 != r4) goto L_0x0036
            java.lang.Object r2 = r1.L$2
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r2 = (media.tiger.tigerbox.infrastructure.functional.RequestUtils) r2
            java.lang.Object r3 = r1.L$1
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.L$0
            media.tiger.tigerbox.usecase.RequestPemCertificateUseCase$RequestPemCertificateParams r1 = (media.tiger.tigerbox.usecase.RequestPemCertificateUseCase.RequestPemCertificateParams) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00a2
        L_0x0036:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r0)
            media.tiger.tigerbox.webserver.certificate.GenerateCertificateSigningRequest r0 = media.tiger.tigerbox.webserver.certificate.GenerateCertificateSigningRequest.INSTANCE
            java.security.KeyPair r3 = r11.getKeyPair()
            java.lang.String r5 = r11.getDeviceIdentifier()
            java.lang.String r6 = r11.getDeviceCredential()
            java.lang.String r3 = r0.invoke(r3, r5, r6)
            okhttp3.MultipartBody$Part$Companion r0 = okhttp3.MultipartBody.Part.Companion
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r11.getDeviceIdentifier()
            r5.append(r6)
            java.lang.String r6 = ".local.csr"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            okhttp3.RequestBody$Companion r6 = okhttp3.RequestBody.Companion
            okhttp3.MediaType r7 = FILE_PART_TYPE
            okhttp3.RequestBody r6 = r6.create((java.lang.String) r3, (okhttp3.MediaType) r7)
            java.lang.String r7 = "csr"
            okhttp3.MultipartBody$Part r0 = r0.createFormData(r7, r5, r6)
            okhttp3.MultipartBody$Part$Companion r5 = okhttp3.MultipartBody.Part.Companion
            r6 = 0
            okhttp3.RequestBody$Companion r7 = okhttp3.RequestBody.Companion
            java.lang.String r8 = r11.getDeviceCredential()
            okhttp3.MediaType r9 = CREDENTIAL_PART_TYPE
            okhttp3.RequestBody r7 = r7.create((java.lang.String) r8, (okhttp3.MediaType) r9)
            java.lang.String r8 = "device_credential"
            okhttp3.MultipartBody$Part r5 = r5.createFormData(r8, r6, r7)
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r6 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.ScalarTigerBoxWebService r7 = r10.scalarTigerBoxWebService
            r1.L$0 = r11
            r1.L$1 = r3
            r1.L$2 = r6
            r1.label = r4
            java.lang.Object r0 = r7.requestCertificate(r5, r0, r1)
            if (r0 != r2) goto L_0x00a0
            return r2
        L_0x00a0:
            r1 = r11
            r2 = r6
        L_0x00a2:
            media.tiger.tigerbox.data.network.ApiResponse r0 = (media.tiger.tigerbox.data.network.ApiResponse) r0
            media.tiger.tigerbox.usecase.RequestPemCertificateUseCase$run$2 r4 = new media.tiger.tigerbox.usecase.RequestPemCertificateUseCase$run$2
            r4.<init>(r1, r3)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            media.tiger.tigerbox.model.domain.PemResponse$DefaultResponse r5 = media.tiger.tigerbox.model.domain.PemResponse.DefaultResponse.INSTANCE
            media.tiger.tigerbox.infrastructure.exception.GeneratingCertificateFailure$PemRequestFailure r1 = media.tiger.tigerbox.infrastructure.exception.GeneratingCertificateFailure.PemRequestFailure.INSTANCE
            r6 = r1
            media.tiger.tigerbox.infrastructure.exception.Failure r6 = (media.tiger.tigerbox.infrastructure.exception.Failure) r6
            r7 = 0
            r8 = 16
            r9 = 0
            r3 = r0
            media.tiger.tigerbox.infrastructure.functional.Either r0 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.usecase.RequestPemCertificateUseCase.run(media.tiger.tigerbox.usecase.RequestPemCertificateUseCase$RequestPemCertificateParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/RequestPemCertificateUseCase$RequestPemCertificateParams;", "", "keyPair", "Ljava/security/KeyPair;", "deviceIdentifier", "", "deviceCredential", "(Ljava/security/KeyPair;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceCredential", "()Ljava/lang/String;", "getDeviceIdentifier", "getKeyPair", "()Ljava/security/KeyPair;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: RequestPemCertificateUseCase.kt */
    public static final class RequestPemCertificateParams {
        private final String deviceCredential;
        private final String deviceIdentifier;
        private final KeyPair keyPair;

        public static /* synthetic */ RequestPemCertificateParams copy$default(RequestPemCertificateParams requestPemCertificateParams, KeyPair keyPair2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                keyPair2 = requestPemCertificateParams.keyPair;
            }
            if ((i & 2) != 0) {
                str = requestPemCertificateParams.deviceIdentifier;
            }
            if ((i & 4) != 0) {
                str2 = requestPemCertificateParams.deviceCredential;
            }
            return requestPemCertificateParams.copy(keyPair2, str, str2);
        }

        public final KeyPair component1() {
            return this.keyPair;
        }

        public final String component2() {
            return this.deviceIdentifier;
        }

        public final String component3() {
            return this.deviceCredential;
        }

        public final RequestPemCertificateParams copy(KeyPair keyPair2, String str, String str2) {
            Intrinsics.checkNotNullParameter(keyPair2, "keyPair");
            Intrinsics.checkNotNullParameter(str, "deviceIdentifier");
            Intrinsics.checkNotNullParameter(str2, "deviceCredential");
            return new RequestPemCertificateParams(keyPair2, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestPemCertificateParams)) {
                return false;
            }
            RequestPemCertificateParams requestPemCertificateParams = (RequestPemCertificateParams) obj;
            return Intrinsics.areEqual((Object) this.keyPair, (Object) requestPemCertificateParams.keyPair) && Intrinsics.areEqual((Object) this.deviceIdentifier, (Object) requestPemCertificateParams.deviceIdentifier) && Intrinsics.areEqual((Object) this.deviceCredential, (Object) requestPemCertificateParams.deviceCredential);
        }

        public int hashCode() {
            return (((this.keyPair.hashCode() * 31) + this.deviceIdentifier.hashCode()) * 31) + this.deviceCredential.hashCode();
        }

        public String toString() {
            return "RequestPemCertificateParams(keyPair=" + this.keyPair + ", deviceIdentifier=" + this.deviceIdentifier + ", deviceCredential=" + this.deviceCredential + ')';
        }

        public RequestPemCertificateParams(KeyPair keyPair2, String str, String str2) {
            Intrinsics.checkNotNullParameter(keyPair2, "keyPair");
            Intrinsics.checkNotNullParameter(str, "deviceIdentifier");
            Intrinsics.checkNotNullParameter(str2, "deviceCredential");
            this.keyPair = keyPair2;
            this.deviceIdentifier = str;
            this.deviceCredential = str2;
        }

        public final KeyPair getKeyPair() {
            return this.keyPair;
        }

        public final String getDeviceIdentifier() {
            return this.deviceIdentifier;
        }

        public final String getDeviceCredential() {
            return this.deviceCredential;
        }
    }
}
