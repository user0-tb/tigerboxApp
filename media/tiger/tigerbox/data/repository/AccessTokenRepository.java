package media.tiger.tigerbox.data.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.domain.AccessTokenDomain;
import media.tiger.tigerbox.usecase.accesstokenrepo.GetTokenParameters;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH&J\u0011\u0010\n\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ%\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000f\u001a\u00020\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/repository/AccessTokenRepository;", "", "tokens", "Lmedia/tiger/tigerbox/model/domain/AccessTokenDomain;", "getTokens", "()Lmedia/tiger/tigerbox/model/domain/AccessTokenDomain;", "loadInitialDatabaseData", "", "onDone", "Lkotlin/Function0;", "removeAccessToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAccessTokens", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "params", "Lmedia/tiger/tigerbox/usecase/accesstokenrepo/GetTokenParameters;", "(Lmedia/tiger/tigerbox/usecase/accesstokenrepo/GetTokenParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestReAuthentication", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AccessTokenRepository.kt */
public interface AccessTokenRepository {
    AccessTokenDomain getTokens();

    void loadInitialDatabaseData(Function0<Unit> function0);

    Object removeAccessToken(Continuation<? super Unit> continuation);

    Object requestAccessTokens(GetTokenParameters getTokenParameters, Continuation<? super Either<? extends Failure, AccessTokenDomain>> continuation);

    Object requestReAuthentication(Continuation<? super Either<? extends Failure, AccessTokenDomain>> continuation);
}
