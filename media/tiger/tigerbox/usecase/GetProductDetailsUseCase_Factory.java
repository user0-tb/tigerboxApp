package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;

public final class GetProductDetailsUseCase_Factory implements Factory<GetProductDetailsUseCase> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public GetProductDetailsUseCase_Factory(Provider<TigerBoxWebService> provider, Provider<CoroutineDispatcher> provider2) {
        this.tigerBoxWebServiceProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public GetProductDetailsUseCase get() {
        return newInstance(this.tigerBoxWebServiceProvider.get(), this.dispatcherProvider.get());
    }

    public static GetProductDetailsUseCase_Factory create(Provider<TigerBoxWebService> provider, Provider<CoroutineDispatcher> provider2) {
        return new GetProductDetailsUseCase_Factory(provider, provider2);
    }

    public static GetProductDetailsUseCase newInstance(TigerBoxWebService tigerBoxWebService, CoroutineDispatcher coroutineDispatcher) {
        return new GetProductDetailsUseCase(tigerBoxWebService, coroutineDispatcher);
    }
}
