package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;

public final class DeviceSearchUseCase_Factory implements Factory<DeviceSearchUseCase> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public DeviceSearchUseCase_Factory(Provider<TigerBoxWebService> provider, Provider<CoroutineDispatcher> provider2) {
        this.tigerBoxWebServiceProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public DeviceSearchUseCase get() {
        return newInstance(this.tigerBoxWebServiceProvider.get(), this.dispatcherProvider.get());
    }

    public static DeviceSearchUseCase_Factory create(Provider<TigerBoxWebService> provider, Provider<CoroutineDispatcher> provider2) {
        return new DeviceSearchUseCase_Factory(provider, provider2);
    }

    public static DeviceSearchUseCase newInstance(TigerBoxWebService tigerBoxWebService, CoroutineDispatcher coroutineDispatcher) {
        return new DeviceSearchUseCase(tigerBoxWebService, coroutineDispatcher);
    }
}
