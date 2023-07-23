package media.tiger.tigerbox.usecase.tigerboxuserrepo;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;

public final class FetchAccountInfoUseCase_Factory implements Factory<FetchAccountInfoUseCase> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<TigerBoxAccountRepository> repositoryProvider;

    public FetchAccountInfoUseCase_Factory(Provider<TigerBoxAccountRepository> provider, Provider<CoroutineDispatcher> provider2) {
        this.repositoryProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public FetchAccountInfoUseCase get() {
        return newInstance(this.repositoryProvider.get(), this.dispatcherProvider.get());
    }

    public static FetchAccountInfoUseCase_Factory create(Provider<TigerBoxAccountRepository> provider, Provider<CoroutineDispatcher> provider2) {
        return new FetchAccountInfoUseCase_Factory(provider, provider2);
    }

    public static FetchAccountInfoUseCase newInstance(TigerBoxAccountRepository tigerBoxAccountRepository, CoroutineDispatcher coroutineDispatcher) {
        return new FetchAccountInfoUseCase(tigerBoxAccountRepository, coroutineDispatcher);
    }
}
