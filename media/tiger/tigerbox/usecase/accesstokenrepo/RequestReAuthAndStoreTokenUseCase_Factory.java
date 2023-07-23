package media.tiger.tigerbox.usecase.accesstokenrepo;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.repository.AccessTokenRepository;

public final class RequestReAuthAndStoreTokenUseCase_Factory implements Factory<RequestReAuthAndStoreTokenUseCase> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<AccessTokenRepository> repositoryProvider;

    public RequestReAuthAndStoreTokenUseCase_Factory(Provider<AccessTokenRepository> provider, Provider<CoroutineDispatcher> provider2) {
        this.repositoryProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public RequestReAuthAndStoreTokenUseCase get() {
        return newInstance(this.repositoryProvider, this.dispatcherProvider.get());
    }

    public static RequestReAuthAndStoreTokenUseCase_Factory create(Provider<AccessTokenRepository> provider, Provider<CoroutineDispatcher> provider2) {
        return new RequestReAuthAndStoreTokenUseCase_Factory(provider, provider2);
    }

    public static RequestReAuthAndStoreTokenUseCase newInstance(Provider<AccessTokenRepository> provider, CoroutineDispatcher coroutineDispatcher) {
        return new RequestReAuthAndStoreTokenUseCase(provider, coroutineDispatcher);
    }
}
