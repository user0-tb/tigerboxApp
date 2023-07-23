package media.tiger.tigerbox.usecase;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.interactor.RetryUseCase;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.dto.Acquisition;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/RequestAcquisitionUseCase;", "Lmedia/tiger/tigerbox/infrastructure/interactor/RetryUseCase;", "Lmedia/tiger/tigerbox/usecase/RequestAcquisitionParameters;", "Lmedia/tiger/tigerbox/model/dto/Acquisition;", "tigerBoxWebService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "params", "(Lmedia/tiger/tigerbox/usecase/RequestAcquisitionParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RequestAcquisitionUseCase.kt */
public final class RequestAcquisitionUseCase extends RetryUseCase<RequestAcquisitionParameters, Acquisition> {
    private final TigerBoxWebService tigerBoxWebService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public RequestAcquisitionUseCase(TigerBoxWebService tigerBoxWebService2, ConfigurationProperties configurationProperties, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher, Integer.parseInt(configurationProperties.getProperty("reconnection.attempts")));
        Intrinsics.checkNotNullParameter(tigerBoxWebService2, "tigerBoxWebService");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.tigerBoxWebService = tigerBoxWebService2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(media.tiger.tigerbox.usecase.RequestAcquisitionParameters r14, kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, media.tiger.tigerbox.model.dto.Acquisition>> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof media.tiger.tigerbox.usecase.RequestAcquisitionUseCase$run$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            media.tiger.tigerbox.usecase.RequestAcquisitionUseCase$run$1 r0 = (media.tiger.tigerbox.usecase.RequestAcquisitionUseCase$run$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.usecase.RequestAcquisitionUseCase$run$1 r0 = new media.tiger.tigerbox.usecase.RequestAcquisitionUseCase$run$1
            r0.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r14 = r0.L$0
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r14 = (media.tiger.tigerbox.infrastructure.functional.RequestUtils) r14
            kotlin.ResultKt.throwOnFailure(r15)
            r2 = r14
            goto L_0x0066
        L_0x002f:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r15)
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r15 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.TigerBoxWebService r2 = r13.tigerBoxWebService
            int r4 = r14.getAccountId()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            media.tiger.tigerbox.model.dto.AcquisitionBody r12 = new media.tiger.tigerbox.model.dto.AcquisitionBody
            int r6 = r14.getProductId()
            int r7 = r14.getAccountId()
            r8 = 0
            r9 = 0
            r10 = 12
            r11 = 0
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.L$0 = r15
            r0.label = r3
            java.lang.Object r14 = r2.requestAcquisition(r4, r12, r0)
            if (r14 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r2 = r15
            r15 = r14
        L_0x0066:
            r3 = r15
            media.tiger.tigerbox.data.network.ApiResponse r3 = (media.tiger.tigerbox.data.network.ApiResponse) r3
            media.tiger.tigerbox.usecase.RequestAcquisitionUseCase$run$2 r14 = media.tiger.tigerbox.usecase.RequestAcquisitionUseCase$run$2.INSTANCE
            r4 = r14
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            media.tiger.tigerbox.model.dto.Acquisition r5 = new media.tiger.tigerbox.model.dto.Acquisition
            r5.<init>()
            r6 = 0
            r7 = 0
            r8 = 24
            r9 = 0
            media.tiger.tigerbox.infrastructure.functional.Either r14 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r2, r3, r4, r5, r6, r7, r8, r9)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.usecase.RequestAcquisitionUseCase.run(media.tiger.tigerbox.usecase.RequestAcquisitionParameters, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
