package media.tiger.tigerbox.usecase.accesstokenrepo;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.repository.AccessTokenRepository;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;

public final class RemoveAccountDataUseCase_Factory implements Factory<RemoveAccountDataUseCase> {
    private final Provider<AccessTokenRepository> accessTokenRepositoryProvider;
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<TigerBoxAccountRepository> tigerBoxAccountRepositoryProvider;

    public RemoveAccountDataUseCase_Factory(Provider<AccessTokenRepository> provider, Provider<TigerBoxAccountRepository> provider2, Provider<CoroutineDispatcher> provider3) {
        this.accessTokenRepositoryProvider = provider;
        this.tigerBoxAccountRepositoryProvider = provider2;
        this.dispatcherProvider = provider3;
    }

    public RemoveAccountDataUseCase get() {
        return newInstance(this.accessTokenRepositoryProvider, this.tigerBoxAccountRepositoryProvider, this.dispatcherProvider.get());
    }

    public static RemoveAccountDataUseCase_Factory create(Provider<AccessTokenRepository> provider, Provider<TigerBoxAccountRepository> provider2, Provider<CoroutineDispatcher> provider3) {
        return new RemoveAccountDataUseCase_Factory(provider, provider2, provider3);
    }

    public static RemoveAccountDataUseCase newInstance(Provider<AccessTokenRepository> provider, Provider<TigerBoxAccountRepository> provider2, CoroutineDispatcher coroutineDispatcher) {
        return new RemoveAccountDataUseCase(provider, provider2, coroutineDispatcher);
    }
}
