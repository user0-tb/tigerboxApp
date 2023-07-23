package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.network.OtaWebService;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import okhttp3.OkHttpClient;

/* renamed from: media.tiger.tigerbox.infrastructure.di.RetrofitModule_ProvideOtaWebServiceFactory */
public final class RetrofitModule_ProvideOtaWebServiceFactory implements Factory<OtaWebService> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<OkHttpClient> otaWebServiceOkHttpClientProvider;

    public RetrofitModule_ProvideOtaWebServiceFactory(Provider<OkHttpClient> provider, Provider<ConfigurationProperties> provider2) {
        this.otaWebServiceOkHttpClientProvider = provider;
        this.configurationPropertiesProvider = provider2;
    }

    public OtaWebService get() {
        return provideOtaWebService(this.otaWebServiceOkHttpClientProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static RetrofitModule_ProvideOtaWebServiceFactory create(Provider<OkHttpClient> provider, Provider<ConfigurationProperties> provider2) {
        return new RetrofitModule_ProvideOtaWebServiceFactory(provider, provider2);
    }

    public static OtaWebService provideOtaWebService(OkHttpClient okHttpClient, ConfigurationProperties configurationProperties) {
        return (OtaWebService) Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.provideOtaWebService(okHttpClient, configurationProperties));
    }
}
