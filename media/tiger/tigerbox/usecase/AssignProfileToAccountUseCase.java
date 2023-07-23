package media.tiger.tigerbox.usecase;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.interactor.UseCase;
import media.tiger.tigerbox.model.dto.DeviceInformation;
import okhttp3.MediaType;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/AssignProfileToAccountUseCase;", "Lmedia/tiger/tigerbox/infrastructure/interactor/UseCase;", "Lmedia/tiger/tigerbox/usecase/AssignProfileToAccountUseCase$RequestParams;", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "tigerBoxWebService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "JSON_TYPE", "Lokhttp3/MediaType;", "run", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "params", "(Lmedia/tiger/tigerbox/usecase/AssignProfileToAccountUseCase$RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RequestParams", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AssignProfileToAccountUseCase.kt */
public final class AssignProfileToAccountUseCase extends UseCase<RequestParams, DeviceInformation> {
    private final MediaType JSON_TYPE = MediaType.Companion.parse("application/json; charset=UTF-8");
    private final TigerBoxWebService tigerBoxWebService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public AssignProfileToAccountUseCase(TigerBoxWebService tigerBoxWebService2, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        Intrinsics.checkNotNullParameter(tigerBoxWebService2, "tigerBoxWebService");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.tigerBoxWebService = tigerBoxWebService2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase.RequestParams r11, kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, media.tiger.tigerbox.model.dto.DeviceInformation>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase$run$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase$run$1 r0 = (media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase$run$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase$run$1 r0 = new media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase$run$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r11 = r0.L$0
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r11 = (media.tiger.tigerbox.infrastructure.functional.RequestUtils) r11
            kotlin.ResultKt.throwOnFailure(r12)
            r2 = r11
            goto L_0x0071
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r12)
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r12 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.TigerBoxWebService r2 = r10.tigerBoxWebService
            java.lang.String r4 = r11.getUrl()
            okhttp3.RequestBody$Companion r5 = okhttp3.RequestBody.Companion
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "{\n\"currentProfileId\": "
            r6.append(r7)
            int r11 = r11.getProfileId()
            r6.append(r11)
            java.lang.String r11 = "\n}"
            r6.append(r11)
            java.lang.String r11 = r6.toString()
            okhttp3.MediaType r6 = r10.JSON_TYPE
            okhttp3.RequestBody r11 = r5.create((java.lang.String) r11, (okhttp3.MediaType) r6)
            r0.L$0 = r12
            r0.label = r3
            java.lang.Object r11 = r2.assignCurrentProfileToAccount(r4, r11, r0)
            if (r11 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r2 = r12
            r12 = r11
        L_0x0071:
            r3 = r12
            media.tiger.tigerbox.data.network.ApiResponse r3 = (media.tiger.tigerbox.data.network.ApiResponse) r3
            media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase$run$2 r11 = media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase$run$2.INSTANCE
            r4 = r11
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            media.tiger.tigerbox.model.dto.DeviceInformation r5 = new media.tiger.tigerbox.model.dto.DeviceInformation
            r5.<init>()
            media.tiger.tigerbox.infrastructure.exception.LoginFailure$SendProfileOfBoxNotSuccessful r11 = media.tiger.tigerbox.infrastructure.exception.LoginFailure.SendProfileOfBoxNotSuccessful.INSTANCE
            r6 = r11
            media.tiger.tigerbox.infrastructure.exception.Failure r6 = (media.tiger.tigerbox.infrastructure.exception.Failure) r6
            r7 = 0
            r8 = 16
            r9 = 0
            media.tiger.tigerbox.infrastructure.functional.Either r11 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r2, r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase.run(media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase$RequestParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/AssignProfileToAccountUseCase$RequestParams;", "", "url", "", "profileId", "", "(Ljava/lang/String;I)V", "getProfileId", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AssignProfileToAccountUseCase.kt */
    public static final class RequestParams {
        private final int profileId;
        private final String url;

        public static /* synthetic */ RequestParams copy$default(RequestParams requestParams, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = requestParams.url;
            }
            if ((i2 & 2) != 0) {
                i = requestParams.profileId;
            }
            return requestParams.copy(str, i);
        }

        public final String component1() {
            return this.url;
        }

        public final int component2() {
            return this.profileId;
        }

        public final RequestParams copy(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new RequestParams(str, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestParams)) {
                return false;
            }
            RequestParams requestParams = (RequestParams) obj;
            return Intrinsics.areEqual((Object) this.url, (Object) requestParams.url) && this.profileId == requestParams.profileId;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + this.profileId;
        }

        public String toString() {
            return "RequestParams(url=" + this.url + ", profileId=" + this.profileId + ')';
        }

        public RequestParams(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "url");
            this.url = str;
            this.profileId = i;
        }

        public final String getUrl() {
            return this.url;
        }

        public final int getProfileId() {
            return this.profileId;
        }
    }
}
