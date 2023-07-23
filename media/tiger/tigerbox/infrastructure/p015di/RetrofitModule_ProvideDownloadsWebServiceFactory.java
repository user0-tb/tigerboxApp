package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.network.DownloadsWebService;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import okhttp3.OkHttpClient;

/* renamed from: media.tiger.tigerbox.infrastructure.di.RetrofitModule_ProvideDownloadsWebServiceFactory */
public final class RetrofitModule_ProvideDownloadsWebServiceFactory implements Factory<DownloadsWebService> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<OkHttpClient> downloadsOkHttpClientProvider;

    public RetrofitModule_ProvideDownloadsWebServiceFactory(Provider<OkHttpClient> provider, Provider<ConfigurationProperties> provider2) {
        this.downloadsOkHttpClientProvider = provider;
        this.configurationPropertiesProvider = provider2;
    }

    public DownloadsWebService get() {
        return provideDownloadsWebService(this.downloadsOkHttpClientProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static RetrofitModule_ProvideDownloadsWebServiceFactory create(Provider<OkHttpClient> provider, Provider<ConfigurationProperties> provider2) {
        return new RetrofitModule_ProvideDownloadsWebServiceFactory(provider, provider2);
    }

    public static DownloadsWebService provideDownloadsWebService(OkHttpClient okHttpClient, ConfigurationProperties configurationProperties) {
        return (DownloadsWebService) Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.provideDownloadsWebService(okHttpClient, configurationProperties));
    }
}
