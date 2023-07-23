package media.tiger.tigerbox.usecase.accesstokenrepo;

import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.repository.AccessTokenRepository;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.interactor.UseCase;

@Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B-\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/accesstokenrepo/RemoveAccountDataUseCase;", "Lmedia/tiger/tigerbox/infrastructure/interactor/UseCase;", "", "accessTokenRepository", "Ljavax/inject/Provider;", "Lmedia/tiger/tigerbox/data/repository/AccessTokenRepository;", "tigerBoxAccountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lmedia/tiger/tigerbox/infrastructure/functional/Either$Right;", "params", "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RemoveAccountDataUseCase.kt */
public final class RemoveAccountDataUseCase extends UseCase<Unit, Unit> {
    private final Provider<AccessTokenRepository> accessTokenRepository;
    private final Provider<TigerBoxAccountRepository> tigerBoxAccountRepository;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public RemoveAccountDataUseCase(Provider<AccessTokenRepository> provider, Provider<TigerBoxAccountRepository> provider2, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        Intrinsics.checkNotNullParameter(provider, "accessTokenRepository");
        Intrinsics.checkNotNullParameter(provider2, "tigerBoxAccountRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.accessTokenRepository = provider;
        this.tigerBoxAccountRepository = provider2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(kotlin.Unit r5, kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either.Right<kotlin.Unit>> r6) {
        /*
            r4 = this;
            boolean r5 = r6 instanceof media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase$run$1
            if (r5 == 0) goto L_0x0014
            r5 = r6
            media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase$run$1 r5 = (media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase$run$1) r5
            int r0 = r5.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0014
            int r6 = r5.label
            int r6 = r6 - r1
            r5.label = r6
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase$run$1 r5 = new media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase$run$1
            r5.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003d
            if (r1 == r3) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0068
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            java.lang.Object r1 = r5.L$0
            media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase r1 = (media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r6)
            javax.inject.Provider<media.tiger.tigerbox.data.repository.AccessTokenRepository> r6 = r4.accessTokenRepository
            java.lang.Object r6 = r6.get()
            media.tiger.tigerbox.data.repository.AccessTokenRepository r6 = (media.tiger.tigerbox.data.repository.AccessTokenRepository) r6
            r5.L$0 = r4
            r5.label = r3
            java.lang.Object r6 = r6.removeAccessToken(r5)
            if (r6 != r0) goto L_0x0053
            return r0
        L_0x0053:
            r1 = r4
        L_0x0054:
            javax.inject.Provider<media.tiger.tigerbox.data.repository.TigerBoxAccountRepository> r6 = r1.tigerBoxAccountRepository
            java.lang.Object r6 = r6.get()
            media.tiger.tigerbox.data.repository.TigerBoxAccountRepository r6 = (media.tiger.tigerbox.data.repository.TigerBoxAccountRepository) r6
            r1 = 0
            r5.L$0 = r1
            r5.label = r2
            java.lang.Object r5 = r6.removeTigerBoxAccountInfo(r5)
            if (r5 != r0) goto L_0x0068
            return r0
        L_0x0068:
            media.tiger.tigerbox.infrastructure.functional.Either$Right r5 = new media.tiger.tigerbox.infrastructure.functional.Either$Right
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r5.<init>(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase.run(kotlin.Unit, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
