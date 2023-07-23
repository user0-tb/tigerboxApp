package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.network.ScalarTigerBoxWebService;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import okhttp3.OkHttpClient;

/* renamed from: media.tiger.tigerbox.infrastructure.di.RetrofitModule_ProvideScalarTigerBoxServiceFactory */
public final class RetrofitModule_ProvideScalarTigerBoxServiceFactory implements Factory<ScalarTigerBoxWebService> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public RetrofitModule_ProvideScalarTigerBoxServiceFactory(Provider<OkHttpClient> provider, Provider<ConfigurationProperties> provider2) {
        this.okHttpClientProvider = provider;
        this.configurationPropertiesProvider = provider2;
    }

    public ScalarTigerBoxWebService get() {
        return provideScalarTigerBoxService(this.okHttpClientProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static RetrofitModule_ProvideScalarTigerBoxServiceFactory create(Provider<OkHttpClient> provider, Provider<ConfigurationProperties> provider2) {
        return new RetrofitModule_ProvideScalarTigerBoxServiceFactory(provider, provider2);
    }

    public static ScalarTigerBoxWebService provideScalarTigerBoxService(OkHttpClient okHttpClient, ConfigurationProperties configurationProperties) {
        return (ScalarTigerBoxWebService) Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.provideScalarTigerBoxService(okHttpClient, configurationProperties));
    }
}
