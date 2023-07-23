package media.tiger.tigerbox.usecase.accesstokenrepo;

import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.repository.AccessTokenRepository;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.infrastructure.interactor.UseCaseWithReturn;
import media.tiger.tigerbox.model.domain.AccessTokenDomain;

@Metadata(mo33736d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ%\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\r\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/accesstokenrepo/RequestReAuthAndStoreTokenUseCase;", "Lmedia/tiger/tigerbox/infrastructure/interactor/UseCaseWithReturn;", "", "Lmedia/tiger/tigerbox/model/domain/AccessTokenDomain;", "repository", "Ljavax/inject/Provider;", "Lmedia/tiger/tigerbox/data/repository/AccessTokenRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Ljavax/inject/Provider;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "params", "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RequestReAuthAndStoreTokenUseCase.kt */
public final class RequestReAuthAndStoreTokenUseCase extends UseCaseWithReturn<Unit, AccessTokenDomain> {
    private final Provider<AccessTokenRepository> repository;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public RequestReAuthAndStoreTokenUseCase(Provider<AccessTokenRepository> provider, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        Intrinsics.checkNotNullParameter(provider, "repository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.repository = provider;
    }

    public Object run(Unit unit, Continuation<? super Either<? extends Failure, AccessTokenDomain>> continuation) {
        return this.repository.get().requestReAuthentication(continuation);
    }
}
