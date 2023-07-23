package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;

public final class WildCardReassignUseCase_Factory implements Factory<WildCardReassignUseCase> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public WildCardReassignUseCase_Factory(Provider<TigerBoxWebService> provider, Provider<ConfigurationProperties> provider2, Provider<CoroutineDispatcher> provider3) {
        this.tigerBoxWebServiceProvider = provider;
        this.configurationPropertiesProvider = provider2;
        this.dispatcherProvider = provider3;
    }

    public WildCardReassignUseCase get() {
        return newInstance(this.tigerBoxWebServiceProvider.get(), this.configurationPropertiesProvider.get(), this.dispatcherProvider.get());
    }

    public static WildCardReassignUseCase_Factory create(Provider<TigerBoxWebService> provider, Provider<ConfigurationProperties> provider2, Provider<CoroutineDispatcher> provider3) {
        return new WildCardReassignUseCase_Factory(provider, provider2, provider3);
    }

    public static WildCardReassignUseCase newInstance(TigerBoxWebService tigerBoxWebService, ConfigurationProperties configurationProperties, CoroutineDispatcher coroutineDispatcher) {
        return new WildCardReassignUseCase(tigerBoxWebService, configurationProperties, coroutineDispatcher);
    }
}
