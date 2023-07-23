package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.main.update.UpdateCheck;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.usecase.ReportInformationUseCase;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideUpdateCheckFactory */
public final class ServiceModule_ProvideUpdateCheckFactory implements Factory<UpdateCheck> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<ReportInformationUseCase> reportSuccessfulUpdateProvider;
    private final Provider<StorageService> storageServiceProvider;

    public ServiceModule_ProvideUpdateCheckFactory(Provider<StorageService> provider, Provider<MetaDataService> provider2, Provider<ReportInformationUseCase> provider3, Provider<ConfigurationProperties> provider4) {
        this.storageServiceProvider = provider;
        this.metaDataServiceProvider = provider2;
        this.reportSuccessfulUpdateProvider = provider3;
        this.configurationPropertiesProvider = provider4;
    }

    public UpdateCheck get() {
        return provideUpdateCheck(this.storageServiceProvider.get(), this.metaDataServiceProvider.get(), this.reportSuccessfulUpdateProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static ServiceModule_ProvideUpdateCheckFactory create(Provider<StorageService> provider, Provider<MetaDataService> provider2, Provider<ReportInformationUseCase> provider3, Provider<ConfigurationProperties> provider4) {
        return new ServiceModule_ProvideUpdateCheckFactory(provider, provider2, provider3, provider4);
    }

    public static UpdateCheck provideUpdateCheck(StorageService storageService, MetaDataService metaDataService, ReportInformationUseCase reportInformationUseCase, ConfigurationProperties configurationProperties) {
        return (UpdateCheck) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideUpdateCheck(storageService, metaDataService, reportInformationUseCase, configurationProperties));
    }
}
