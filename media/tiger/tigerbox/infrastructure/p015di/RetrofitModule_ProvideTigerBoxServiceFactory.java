package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import okhttp3.OkHttpClient;

/* renamed from: media.tiger.tigerbox.infrastructure.di.RetrofitModule_ProvideTigerBoxServiceFactory */
public final class RetrofitModule_ProvideTigerBoxServiceFactory implements Factory<TigerBoxWebService> {
    private final Provider<OkHttpClient> authOkHttpClientProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;

    public RetrofitModule_ProvideTigerBoxServiceFactory(Provider<OkHttpClient> provider, Provider<ConfigurationProperties> provider2) {
        this.authOkHttpClientProvider = provider;
        this.configurationPropertiesProvider = provider2;
    }

    public TigerBoxWebService get() {
        return provideTigerBoxService(this.authOkHttpClientProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static RetrofitModule_ProvideTigerBoxServiceFactory create(Provider<OkHttpClient> provider, Provider<ConfigurationProperties> provider2) {
        return new RetrofitModule_ProvideTigerBoxServiceFactory(provider, provider2);
    }

    public static TigerBoxWebService provideTigerBoxService(OkHttpClient okHttpClient, ConfigurationProperties configurationProperties) {
        return (TigerBoxWebService) Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.provideTigerBoxService(okHttpClient, configurationProperties));
    }
}
