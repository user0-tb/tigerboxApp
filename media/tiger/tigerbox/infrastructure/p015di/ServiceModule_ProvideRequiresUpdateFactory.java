package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.onboarding.step2.RequiresUpdate;
import media.tiger.tigerbox.services.interfaces.StorageService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideRequiresUpdateFactory */
public final class ServiceModule_ProvideRequiresUpdateFactory implements Factory<RequiresUpdate> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<StorageService> storageServiceProvider;

    public ServiceModule_ProvideRequiresUpdateFactory(Provider<StorageService> provider, Provider<ConfigurationProperties> provider2) {
        this.storageServiceProvider = provider;
        this.configurationPropertiesProvider = provider2;
    }

    public RequiresUpdate get() {
        return provideRequiresUpdate(this.storageServiceProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static ServiceModule_ProvideRequiresUpdateFactory create(Provider<StorageService> provider, Provider<ConfigurationProperties> provider2) {
        return new ServiceModule_ProvideRequiresUpdateFactory(provider, provider2);
    }

    public static RequiresUpdate provideRequiresUpdate(StorageService storageService, ConfigurationProperties configurationProperties) {
        return (RequiresUpdate) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideRequiresUpdate(storageService, configurationProperties));
    }
}
