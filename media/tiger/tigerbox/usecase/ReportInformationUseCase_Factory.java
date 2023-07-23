package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.AdbEnabler;
import media.tiger.tigerbox.services.interfaces.StorageService;

public final class ReportInformationUseCase_Factory implements Factory<ReportInformationUseCase> {
    private final Provider<AdbEnabler> adbEnablerProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public ReportInformationUseCase_Factory(Provider<TigerBoxWebService> provider, Provider<StorageService> provider2, Provider<AdbEnabler> provider3, Provider<ConfigurationProperties> provider4, Provider<CoroutineDispatcher> provider5) {
        this.tigerBoxWebServiceProvider = provider;
        this.storageServiceProvider = provider2;
        this.adbEnablerProvider = provider3;
        this.configurationPropertiesProvider = provider4;
        this.dispatcherProvider = provider5;
    }

    public ReportInformationUseCase get() {
        return newInstance(this.tigerBoxWebServiceProvider.get(), this.storageServiceProvider.get(), this.adbEnablerProvider.get(), this.configurationPropertiesProvider.get(), this.dispatcherProvider.get());
    }

    public static ReportInformationUseCase_Factory create(Provider<TigerBoxWebService> provider, Provider<StorageService> provider2, Provider<AdbEnabler> provider3, Provider<ConfigurationProperties> provider4, Provider<CoroutineDispatcher> provider5) {
        return new ReportInformationUseCase_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ReportInformationUseCase newInstance(TigerBoxWebService tigerBoxWebService, StorageService storageService, AdbEnabler adbEnabler, ConfigurationProperties configurationProperties, CoroutineDispatcher coroutineDispatcher) {
        return new ReportInformationUseCase(tigerBoxWebService, storageService, adbEnabler, configurationProperties, coroutineDispatcher);
    }
}
