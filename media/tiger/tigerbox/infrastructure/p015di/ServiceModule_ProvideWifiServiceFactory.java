package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.WifiService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideWifiServiceFactory */
public final class ServiceModule_ProvideWifiServiceFactory implements Factory<WifiService> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<Context> contextProvider;

    public ServiceModule_ProvideWifiServiceFactory(Provider<Context> provider, Provider<ConfigurationProperties> provider2) {
        this.contextProvider = provider;
        this.configurationPropertiesProvider = provider2;
    }

    public WifiService get() {
        return provideWifiService(this.contextProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static ServiceModule_ProvideWifiServiceFactory create(Provider<Context> provider, Provider<ConfigurationProperties> provider2) {
        return new ServiceModule_ProvideWifiServiceFactory(provider, provider2);
    }

    public static WifiService provideWifiService(Context context, ConfigurationProperties configurationProperties) {
        return (WifiService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideWifiService(context, configurationProperties));
    }
}
