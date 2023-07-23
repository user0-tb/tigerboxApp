package media.tiger.tigerbox.usecase;

import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.interactor.UseCase;
import media.tiger.tigerbox.model.domain.ProductRowDomain;

@Metadata(mo33736d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\r2\u0006\u0010\u000f\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/GetMainContentUseCase;", "Lmedia/tiger/tigerbox/infrastructure/interactor/UseCase;", "", "", "Lmedia/tiger/tigerbox/model/domain/ProductRowDomain;", "tigerBoxWebService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "repository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "params", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: GetMainContentUseCase.kt */
public final class GetMainContentUseCase extends UseCase<Object, List<? extends ProductRowDomain>> {
    private final TigerBoxAccountRepository repository;
    private final TigerBoxWebService tigerBoxWebService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public GetMainContentUseCase(TigerBoxWebService tigerBoxWebService2, TigerBoxAccountRepository tigerBoxAccountRepository, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        Intrinsics.checkNotNullParameter(tigerBoxWebService2, "tigerBoxWebService");
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository, "repository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.tigerBoxWebService = tigerBoxWebService2;
        this.repository = tigerBoxAccountRepository;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(java.lang.Object r10, kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, ? extends java.util.List<media.tiger.tigerbox.model.domain.ProductRowDomain>>> r11) {
        /*
            r9 = this;
            boolean r10 = r11 instanceof media.tiger.tigerbox.usecase.GetMainContentUseCase$run$1
            if (r10 == 0) goto L_0x0014
            r10 = r11
            media.tiger.tigerbox.usecase.GetMainContentUseCase$run$1 r10 = (media.tiger.tigerbox.usecase.GetMainContentUseCase$run$1) r10
            int r0 = r10.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0014
            int r11 = r10.label
            int r11 = r11 - r1
            r10.label = r11
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.usecase.GetMainContentUseCase$run$1 r10 = new media.tiger.tigerbox.usecase.GetMainContentUseCase$run$1
            r10.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r10.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r10 = r10.L$0
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r10 = (media.tiger.tigerbox.infrastructure.functional.RequestUtils) r10
            kotlin.ResultKt.throwOnFailure(r11)
            r1 = r10
            goto L_0x0059
        L_0x002f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r11)
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r11 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.TigerBoxWebService r1 = r9.tigerBoxWebService
            media.tiger.tigerbox.data.repository.TigerBoxAccountRepository r3 = r9.repository
            media.tiger.tigerbox.model.domain.TigerBoxProfileDomain r3 = r3.getActiveProfile()
            int r3 = r3.getId()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r10.L$0 = r11
            r10.label = r2
            java.lang.Object r10 = r1.getMainContent(r3, r10)
            if (r10 != r0) goto L_0x0057
            return r0
        L_0x0057:
            r1 = r11
            r11 = r10
        L_0x0059:
            r2 = r11
            media.tiger.tigerbox.data.network.ApiResponse r2 = (media.tiger.tigerbox.data.network.ApiResponse) r2
            media.tiger.tigerbox.usecase.GetMainContentUseCase$run$2 r10 = media.tiger.tigerbox.usecase.GetMainContentUseCase$run$2.INSTANCE
            r3 = r10
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            media.tiger.tigerbox.infrastructure.exception.ShopLayoutFailure$ShopLayoutNotSuccessful r10 = media.tiger.tigerbox.infrastructure.exception.ShopLayoutFailure.ShopLayoutNotSuccessful.INSTANCE
            r5 = r10
            media.tiger.tigerbox.infrastructure.exception.Failure r5 = (media.tiger.tigerbox.infrastructure.exception.Failure) r5
            r6 = 0
            r7 = 16
            r8 = 0
            media.tiger.tigerbox.infrastructure.functional.Either r10 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r1, r2, r3, r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.usecase.GetMainContentUseCase.run(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
