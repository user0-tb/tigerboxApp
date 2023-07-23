package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.OtaWebService;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;

public final class CheckForUpdateUseCase_Factory implements Factory<CheckForUpdateUseCase> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<OtaWebService> otaWebServiceProvider;

    public CheckForUpdateUseCase_Factory(Provider<OtaWebService> provider, Provider<CoroutineDispatcher> provider2, Provider<ConfigurationProperties> provider3) {
        this.otaWebServiceProvider = provider;
        this.dispatcherProvider = provider2;
        this.configurationPropertiesProvider = provider3;
    }

    public CheckForUpdateUseCase get() {
        return newInstance(this.otaWebServiceProvider.get(), this.dispatcherProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static CheckForUpdateUseCase_Factory create(Provider<OtaWebService> provider, Provider<CoroutineDispatcher> provider2, Provider<ConfigurationProperties> provider3) {
        return new CheckForUpdateUseCase_Factory(provider, provider2, provider3);
    }

    public static CheckForUpdateUseCase newInstance(OtaWebService otaWebService, CoroutineDispatcher coroutineDispatcher, ConfigurationProperties configurationProperties) {
        return new CheckForUpdateUseCase(otaWebService, coroutineDispatcher, configurationProperties);
    }
}
