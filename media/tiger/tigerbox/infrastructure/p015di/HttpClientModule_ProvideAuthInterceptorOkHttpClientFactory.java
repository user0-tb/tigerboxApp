package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.onboarding.ReauthenticationLoginHandler;
import media.tiger.tigerbox.usecase.accesstokenrepo.GetAccessTokenUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.RequestReAuthAndStoreTokenUseCase;
import okhttp3.OkHttpClient;

/* renamed from: media.tiger.tigerbox.infrastructure.di.HttpClientModule_ProvideAuthInterceptorOkHttpClientFactory */
public final class HttpClientModule_ProvideAuthInterceptorOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<ReauthenticationLoginHandler> authenticationLoginHandlerProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<GetAccessTokenUseCase> getAccessTokenUseCaseProvider;
    private final Provider<RemoveAccountDataUseCase> removeAccountDataUseCaseProvider;
    private final Provider<RequestReAuthAndStoreTokenUseCase> requestReAuthAndStoreTokenUseCaseProvider;

    public HttpClientModule_ProvideAuthInterceptorOkHttpClientFactory(Provider<ReauthenticationLoginHandler> provider, Provider<GetAccessTokenUseCase> provider2, Provider<RequestReAuthAndStoreTokenUseCase> provider3, Provider<RemoveAccountDataUseCase> provider4, Provider<ConfigurationProperties> provider5) {
        this.authenticationLoginHandlerProvider = provider;
        this.getAccessTokenUseCaseProvider = provider2;
        this.requestReAuthAndStoreTokenUseCaseProvider = provider3;
        this.removeAccountDataUseCaseProvider = provider4;
        this.configurationPropertiesProvider = provider5;
    }

    public OkHttpClient get() {
        return provideAuthInterceptorOkHttpClient(this.authenticationLoginHandlerProvider.get(), this.getAccessTokenUseCaseProvider.get(), this.requestReAuthAndStoreTokenUseCaseProvider.get(), this.removeAccountDataUseCaseProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static HttpClientModule_ProvideAuthInterceptorOkHttpClientFactory create(Provider<ReauthenticationLoginHandler> provider, Provider<GetAccessTokenUseCase> provider2, Provider<RequestReAuthAndStoreTokenUseCase> provider3, Provider<RemoveAccountDataUseCase> provider4, Provider<ConfigurationProperties> provider5) {
        return new HttpClientModule_ProvideAuthInterceptorOkHttpClientFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static OkHttpClient provideAuthInterceptorOkHttpClient(ReauthenticationLoginHandler reauthenticationLoginHandler, GetAccessTokenUseCase getAccessTokenUseCase, RequestReAuthAndStoreTokenUseCase requestReAuthAndStoreTokenUseCase, RemoveAccountDataUseCase removeAccountDataUseCase, ConfigurationProperties configurationProperties) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(HttpClientModule.INSTANCE.provideAuthInterceptorOkHttpClient(reauthenticationLoginHandler, getAccessTokenUseCase, requestReAuthAndStoreTokenUseCase, removeAccountDataUseCase, configurationProperties));
    }
}
