package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;

public final class GetSubscriptionsUseCase_Factory implements Factory<GetSubscriptionsUseCase> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public GetSubscriptionsUseCase_Factory(Provider<TigerBoxWebService> provider, Provider<CoroutineDispatcher> provider2) {
        this.tigerBoxWebServiceProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public GetSubscriptionsUseCase get() {
        return newInstance(this.tigerBoxWebServiceProvider.get(), this.dispatcherProvider.get());
    }

    public static GetSubscriptionsUseCase_Factory create(Provider<TigerBoxWebService> provider, Provider<CoroutineDispatcher> provider2) {
        return new GetSubscriptionsUseCase_Factory(provider, provider2);
    }

    public static GetSubscriptionsUseCase newInstance(TigerBoxWebService tigerBoxWebService, CoroutineDispatcher coroutineDispatcher) {
        return new GetSubscriptionsUseCase(tigerBoxWebService, coroutineDispatcher);
    }
}
