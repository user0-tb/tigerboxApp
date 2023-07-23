package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import okhttp3.OkHttpClient;

/* renamed from: media.tiger.tigerbox.infrastructure.di.HttpClientModule_ProvideSimpleInterceptorOkHttpClientFactory */
public final class HttpClientModule_ProvideSimpleInterceptorOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;

    public HttpClientModule_ProvideSimpleInterceptorOkHttpClientFactory(Provider<ConfigurationProperties> provider) {
        this.configurationPropertiesProvider = provider;
    }

    public OkHttpClient get() {
        return provideSimpleInterceptorOkHttpClient(this.configurationPropertiesProvider.get());
    }

    public static HttpClientModule_ProvideSimpleInterceptorOkHttpClientFactory create(Provider<ConfigurationProperties> provider) {
        return new HttpClientModule_ProvideSimpleInterceptorOkHttpClientFactory(provider);
    }

    public static OkHttpClient provideSimpleInterceptorOkHttpClient(ConfigurationProperties configurationProperties) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(HttpClientModule.INSTANCE.provideSimpleInterceptorOkHttpClient(configurationProperties));
    }
}
