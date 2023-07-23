package media.tiger.tigerbox.usecase;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.interactor.UseCase;
import media.tiger.tigerbox.model.domain.PinInfo;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J%\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000f\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/TigerTicketValidatePinUseCase;", "Lmedia/tiger/tigerbox/infrastructure/interactor/UseCase;", "Lmedia/tiger/tigerbox/usecase/TigerTicketValidatePinUseCase$RequestParams;", "Lmedia/tiger/tigerbox/model/domain/PinInfo;", "tigerBoxWebService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "extractNumber", "", "str", "run", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "params", "(Lmedia/tiger/tigerbox/usecase/TigerTicketValidatePinUseCase$RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RequestParams", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerTicketValidatePinUseCase.kt */
public final class TigerTicketValidatePinUseCase extends UseCase<RequestParams, PinInfo> {
    private final TigerBoxWebService tigerBoxWebService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public TigerTicketValidatePinUseCase(TigerBoxWebService tigerBoxWebService2, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        Intrinsics.checkNotNullParameter(tigerBoxWebService2, "tigerBoxWebService");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.tigerBoxWebService = tigerBoxWebService2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase.RequestParams r13, kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, media.tiger.tigerbox.model.domain.PinInfo>> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase$run$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase$run$1 r0 = (media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase$run$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase$run$1 r0 = new media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase$run$1
            r0.<init>(r12, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r13 = r0.L$0
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r13 = (media.tiger.tigerbox.infrastructure.functional.RequestUtils) r13
            kotlin.ResultKt.throwOnFailure(r14)
            r2 = r13
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r14)
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r14 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.TigerBoxWebService r2 = r12.tigerBoxWebService
            java.lang.String r4 = r13.getCodeNumber()
            java.lang.String r13 = r13.getPinNumber()
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r13 = r2.validateTicket(r4, r13, r0)
            if (r13 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r2 = r14
            r14 = r13
        L_0x0053:
            r3 = r14
            media.tiger.tigerbox.data.network.ApiResponse r3 = (media.tiger.tigerbox.data.network.ApiResponse) r3
            media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase$run$2 r13 = media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase$run$2.INSTANCE
            r4 = r13
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            media.tiger.tigerbox.model.domain.PinInfo r13 = new media.tiger.tigerbox.model.domain.PinInfo
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 12
            r11 = 0
            r5 = r13
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r6 = 0
            r7 = 0
            r8 = 24
            r9 = 0
            media.tiger.tigerbox.infrastructure.functional.Either r13 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r2, r3, r4, r5, r6, r7, r8, r9)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase.run(media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase$RequestParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/TigerTicketValidatePinUseCase$RequestParams;", "", "codeNumber", "", "pinNumber", "(Ljava/lang/String;Ljava/lang/String;)V", "getCodeNumber", "()Ljava/lang/String;", "getPinNumber", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerTicketValidatePinUseCase.kt */
    public static final class RequestParams {
        private final String codeNumber;
        private final String pinNumber;

        public static /* synthetic */ RequestParams copy$default(RequestParams requestParams, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = requestParams.codeNumber;
            }
            if ((i & 2) != 0) {
                str2 = requestParams.pinNumber;
            }
            return requestParams.copy(str, str2);
        }

        public final String component1() {
            return this.codeNumber;
        }

        public final String component2() {
            return this.pinNumber;
        }

        public final RequestParams copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "codeNumber");
            Intrinsics.checkNotNullParameter(str2, "pinNumber");
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
            return Intrinsics.areEqual((Object) this.codeNumber, (Object) requestParams.codeNumber) && Intrinsics.areEqual((Object) this.pinNumber, (Object) requestParams.pinNumber);
        }

        public int hashCode() {
            return (this.codeNumber.hashCode() * 31) + this.pinNumber.hashCode();
        }

        public String toString() {
            return "RequestParams(codeNumber=" + this.codeNumber + ", pinNumber=" + this.pinNumber + ')';
        }

        public RequestParams(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "codeNumber");
            Intrinsics.checkNotNullParameter(str2, "pinNumber");
            this.codeNumber = str;
            this.pinNumber = str2;
        }

        public final String getCodeNumber() {
            return this.codeNumber;
        }

        public final String getPinNumber() {
            return this.pinNumber;
        }
    }

    private final String extractNumber(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        boolean z = false;
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                sb.append(c);
                z = true;
            } else if (z) {
                break;
            }
        }
        return sb.toString();
    }
}
