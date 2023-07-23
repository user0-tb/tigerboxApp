package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;

public final class RequestAcquisitionUseCase_Factory implements Factory<RequestAcquisitionUseCase> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public RequestAcquisitionUseCase_Factory(Provider<TigerBoxWebService> provider, Provider<ConfigurationProperties> provider2, Provider<CoroutineDispatcher> provider3) {
        this.tigerBoxWebServiceProvider = provider;
        this.configurationPropertiesProvider = provider2;
        this.dispatcherProvider = provider3;
    }

    public RequestAcquisitionUseCase get() {
        return newInstance(this.tigerBoxWebServiceProvider.get(), this.configurationPropertiesProvider.get(), this.dispatcherProvider.get());
    }

    public static RequestAcquisitionUseCase_Factory create(Provider<TigerBoxWebService> provider, Provider<ConfigurationProperties> provider2, Provider<CoroutineDispatcher> provider3) {
        return new RequestAcquisitionUseCase_Factory(provider, provider2, provider3);
    }

    public static RequestAcquisitionUseCase newInstance(TigerBoxWebService tigerBoxWebService, ConfigurationProperties configurationProperties, CoroutineDispatcher coroutineDispatcher) {
        return new RequestAcquisitionUseCase(tigerBoxWebService, configurationProperties, coroutineDispatcher);
    }
}
