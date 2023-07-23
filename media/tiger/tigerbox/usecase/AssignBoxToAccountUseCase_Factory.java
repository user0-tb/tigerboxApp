package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;

public final class AssignBoxToAccountUseCase_Factory implements Factory<AssignBoxToAccountUseCase> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<TigerBoxAccountRepository> tigerBoxAccountRepositoryProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public AssignBoxToAccountUseCase_Factory(Provider<TigerBoxWebService> provider, Provider<TigerBoxAccountRepository> provider2, Provider<CoroutineDispatcher> provider3) {
        this.tigerBoxWebServiceProvider = provider;
        this.tigerBoxAccountRepositoryProvider = provider2;
        this.dispatcherProvider = provider3;
    }

    public AssignBoxToAccountUseCase get() {
        return newInstance(this.tigerBoxWebServiceProvider.get(), this.tigerBoxAccountRepositoryProvider.get(), this.dispatcherProvider.get());
    }

    public static AssignBoxToAccountUseCase_Factory create(Provider<TigerBoxWebService> provider, Provider<TigerBoxAccountRepository> provider2, Provider<CoroutineDispatcher> provider3) {
        return new AssignBoxToAccountUseCase_Factory(provider, provider2, provider3);
    }

    public static AssignBoxToAccountUseCase newInstance(TigerBoxWebService tigerBoxWebService, TigerBoxAccountRepository tigerBoxAccountRepository, CoroutineDispatcher coroutineDispatcher) {
        return new AssignBoxToAccountUseCase(tigerBoxWebService, tigerBoxAccountRepository, coroutineDispatcher);
    }
}
