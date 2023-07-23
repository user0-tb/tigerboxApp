package media.tiger.tigerbox.usecase;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.interactor.RetryUseCase;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.dto.TigerCardValidState;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001\u0010B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ'\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f2\u0006\u0010\u000e\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/WildCardReassignUseCase;", "Lmedia/tiger/tigerbox/infrastructure/interactor/RetryUseCase;", "Lmedia/tiger/tigerbox/usecase/WildCardReassignUseCase$RequestParams;", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState;", "tigerBoxWebService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "params", "(Lmedia/tiger/tigerbox/usecase/WildCardReassignUseCase$RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RequestParams", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WildCardReassignUseCase.kt */
public final class WildCardReassignUseCase extends RetryUseCase<RequestParams, TigerCardValidState> {
    private final TigerBoxWebService tigerBoxWebService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public WildCardReassignUseCase(TigerBoxWebService tigerBoxWebService2, ConfigurationProperties configurationProperties, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher, Integer.parseInt(configurationProperties.getProperty("reconnection.attempts")));
        Intrinsics.checkNotNullParameter(tigerBoxWebService2, "tigerBoxWebService");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.tigerBoxWebService = tigerBoxWebService2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(media.tiger.tigerbox.usecase.WildCardReassignUseCase.RequestParams r11, kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, media.tiger.tigerbox.model.dto.TigerCardValidState>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof media.tiger.tigerbox.usecase.WildCardReassignUseCase$run$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            media.tiger.tigerbox.usecase.WildCardReassignUseCase$run$1 r0 = (media.tiger.tigerbox.usecase.WildCardReassignUseCase$run$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.usecase.WildCardReassignUseCase$run$1 r0 = new media.tiger.tigerbox.usecase.WildCardReassignUseCase$run$1
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
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r12)
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r12 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.TigerBoxWebService r2 = r10.tigerBoxWebService
            java.lang.String r4 = r11.getWildcardCode()
            java.lang.String r11 = r11.getWildcardUid()
            r0.L$0 = r12
            r0.label = r3
            java.lang.Object r11 = r2.reassignWildcard(r4, r11, r0)
            if (r11 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r2 = r12
            r12 = r11
        L_0x0053:
            r3 = r12
            media.tiger.tigerbox.data.network.ApiResponse r3 = (media.tiger.tigerbox.data.network.ApiResponse) r3
            media.tiger.tigerbox.usecase.WildCardReassignUseCase$run$2 r11 = media.tiger.tigerbox.usecase.WildCardReassignUseCase$run$2.INSTANCE
            r4 = r11
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 24
            r9 = 0
            media.tiger.tigerbox.infrastructure.functional.Either r11 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r2, r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.usecase.WildCardReassignUseCase.run(media.tiger.tigerbox.usecase.WildCardReassignUseCase$RequestParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/WildCardReassignUseCase$RequestParams;", "", "wildcardUid", "", "wildcardCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getWildcardCode", "()Ljava/lang/String;", "getWildcardUid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: WildCardReassignUseCase.kt */
    public static final class RequestParams {
        private final String wildcardCode;
        private final String wildcardUid;

        public static /* synthetic */ RequestParams copy$default(RequestParams requestParams, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = requestParams.wildcardUid;
            }
            if ((i & 2) != 0) {
                str2 = requestParams.wildcardCode;
            }
            return requestParams.copy(str, str2);
        }

        public final String component1() {
            return this.wildcardUid;
        }

        public final String component2() {
            return this.wildcardCode;
        }

        public final RequestParams copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "wildcardUid");
            Intrinsics.checkNotNullParameter(str2, "wildcardCode");
            return new RequestParams(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestParams)) {
                return false;
            }
            RequestParams requestParams = (RequestParams) obj;
            return Intrinsics.areEqual((Object) this.wildcardUid, (Object) requestParams.wildcardUid) && Intrinsics.areEqual((Object) this.wildcardCode, (Object) requestParams.wildcardCode);
        }

        public int hashCode() {
            return (this.wildcardUid.hashCode() * 31) + this.wildcardCode.hashCode();
        }

        public String toString() {
            return "RequestParams(wildcardUid=" + this.wildcardUid + ", wildcardCode=" + this.wildcardCode + ')';
        }

        public RequestParams(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "wildcardUid");
            Intrinsics.checkNotNullParameter(str2, "wildcardCode");
            this.wildcardUid = str;
            this.wildcardCode = str2;
        }

        public final String getWildcardUid() {
            return this.wildcardUid;
        }

        public final String getWildcardCode() {
            return this.wildcardCode;
        }
    }
}
