package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;

public final class GetMainContentUseCase_Factory implements Factory<GetMainContentUseCase> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<TigerBoxAccountRepository> repositoryProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public GetMainContentUseCase_Factory(Provider<TigerBoxWebService> provider, Provider<TigerBoxAccountRepository> provider2, Provider<CoroutineDispatcher> provider3) {
        this.tigerBoxWebServiceProvider = provider;
        this.repositoryProvider = provider2;
        this.dispatcherProvider = provider3;
    }

    public GetMainContentUseCase get() {
        return newInstance(this.tigerBoxWebServiceProvider.get(), this.repositoryProvider.get(), this.dispatcherProvider.get());
    }

    public static GetMainContentUseCase_Factory create(Provider<TigerBoxWebService> provider, Provider<TigerBoxAccountRepository> provider2, Provider<CoroutineDispatcher> provider3) {
        return new GetMainContentUseCase_Factory(provider, provider2, provider3);
    }

    public static GetMainContentUseCase newInstance(TigerBoxWebService tigerBoxWebService, TigerBoxAccountRepository tigerBoxAccountRepository, CoroutineDispatcher coroutineDispatcher) {
        return new GetMainContentUseCase(tigerBoxWebService, tigerBoxAccountRepository, coroutineDispatcher);
    }
}
