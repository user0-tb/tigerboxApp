package media.tiger.tigerbox.p016ui.onboarding.step2;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.StorageService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step2.RequiresUpdate_Factory */
public final class RequiresUpdate_Factory implements Factory<RequiresUpdate> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<StorageService> storageProvider;

    public RequiresUpdate_Factory(Provider<StorageService> provider, Provider<ConfigurationProperties> provider2) {
        this.storageProvider = provider;
        this.configurationPropertiesProvider = provider2;
    }

    public RequiresUpdate get() {
        return newInstance(this.storageProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static RequiresUpdate_Factory create(Provider<StorageService> provider, Provider<ConfigurationProperties> provider2) {
        return new RequiresUpdate_Factory(provider, provider2);
    }

    public static RequiresUpdate newInstance(StorageService storageService, ConfigurationProperties configurationProperties) {
        return new RequiresUpdate(storageService, configurationProperties);
    }
}
