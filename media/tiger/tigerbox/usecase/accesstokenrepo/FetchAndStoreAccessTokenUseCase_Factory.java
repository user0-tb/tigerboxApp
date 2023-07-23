package media.tiger.tigerbox.usecase.accesstokenrepo;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.repository.AccessTokenRepository;

public final class FetchAndStoreAccessTokenUseCase_Factory implements Factory<FetchAndStoreAccessTokenUseCase> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<AccessTokenRepository> repositoryProvider;

    public FetchAndStoreAccessTokenUseCase_Factory(Provider<AccessTokenRepository> provider, Provider<CoroutineDispatcher> provider2) {
        this.repositoryProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public FetchAndStoreAccessTokenUseCase get() {
        return newInstance(this.repositoryProvider.get(), this.dispatcherProvider.get());
    }

    public static FetchAndStoreAccessTokenUseCase_Factory create(Provider<AccessTokenRepository> provider, Provider<CoroutineDispatcher> provider2) {
        return new FetchAndStoreAccessTokenUseCase_Factory(provider, provider2);
    }

    public static FetchAndStoreAccessTokenUseCase newInstance(AccessTokenRepository accessTokenRepository, CoroutineDispatcher coroutineDispatcher) {
        return new FetchAndStoreAccessTokenUseCase(accessTokenRepository, coroutineDispatcher);
    }
}
