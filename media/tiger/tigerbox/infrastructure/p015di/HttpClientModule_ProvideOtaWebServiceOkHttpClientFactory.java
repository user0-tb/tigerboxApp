package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.functional.DownloadProgressUpdate;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import okhttp3.OkHttpClient;

/* renamed from: media.tiger.tigerbox.infrastructure.di.HttpClientModule_ProvideOtaWebServiceOkHttpClientFactory */
public final class HttpClientModule_ProvideOtaWebServiceOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<DownloadProgressUpdate> downloadProgressNotifierProvider;

    public HttpClientModule_ProvideOtaWebServiceOkHttpClientFactory(Provider<ConfigurationProperties> provider, Provider<DownloadProgressUpdate> provider2) {
        this.configurationPropertiesProvider = provider;
        this.downloadProgressNotifierProvider = provider2;
    }

    public OkHttpClient get() {
        return provideOtaWebServiceOkHttpClient(this.configurationPropertiesProvider.get(), this.downloadProgressNotifierProvider.get());
    }

    public static HttpClientModule_ProvideOtaWebServiceOkHttpClientFactory create(Provider<ConfigurationProperties> provider, Provider<DownloadProgressUpdate> provider2) {
        return new HttpClientModule_ProvideOtaWebServiceOkHttpClientFactory(provider, provider2);
    }

    public static OkHttpClient provideOtaWebServiceOkHttpClient(ConfigurationProperties configurationProperties, DownloadProgressUpdate downloadProgressUpdate) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(HttpClientModule.INSTANCE.provideOtaWebServiceOkHttpClient(configurationProperties, downloadProgressUpdate));
    }
}
