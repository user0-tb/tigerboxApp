package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;

public final class GetValidTigerCardUseCase_Factory implements Factory<GetValidTigerCardUseCase> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public GetValidTigerCardUseCase_Factory(Provider<TigerBoxWebService> provider, Provider<ConfigurationProperties> provider2, Provider<CoroutineDispatcher> provider3) {
        this.tigerBoxWebServiceProvider = provider;
        this.configurationPropertiesProvider = provider2;
        this.dispatcherProvider = provider3;
    }

    public GetValidTigerCardUseCase get() {
        return newInstance(this.tigerBoxWebServiceProvider.get(), this.configurationPropertiesProvider.get(), this.dispatcherProvider.get());
    }

    public static GetValidTigerCardUseCase_Factory create(Provider<TigerBoxWebService> provider, Provider<ConfigurationProperties> provider2, Provider<CoroutineDispatcher> provider3) {
        return new GetValidTigerCardUseCase_Factory(provider, provider2, provider3);
    }

    public static GetValidTigerCardUseCase newInstance(TigerBoxWebService tigerBoxWebService, ConfigurationProperties configurationProperties, CoroutineDispatcher coroutineDispatcher) {
        return new GetValidTigerCardUseCase(tigerBoxWebService, configurationProperties, coroutineDispatcher);
    }
}
