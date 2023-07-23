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

/* renamed from: media.tiger.tigerbox.infrastructure.di.HttpClientModule_ProvideDownloadsOkHttpClientFactory */
public final class HttpClientModule_ProvideDownloadsOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<ReauthenticationLoginHandler> authenticationLoginHandlerProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<GetAccessTokenUseCase> getAccessTokenUseCaseProvider;
    private final Provider<RemoveAccountDataUseCase> removeAccountDataUseCaseProvider;
    private final Provider<RequestReAuthAndStoreTokenUseCase> requestReAuthAndStoreTokenUseCaseProvider;

    public HttpClientModule_ProvideDownloadsOkHttpClientFactory(Provider<ReauthenticationLoginHandler> provider, Provider<ConfigurationProperties> provider2, Provider<GetAccessTokenUseCase> provider3, Provider<RequestReAuthAndStoreTokenUseCase> provider4, Provider<RemoveAccountDataUseCase> provider5) {
        this.authenticationLoginHandlerProvider = provider;
        this.configurationPropertiesProvider = provider2;
        this.getAccessTokenUseCaseProvider = provider3;
        this.requestReAuthAndStoreTokenUseCaseProvider = provider4;
        this.removeAccountDataUseCaseProvider = provider5;
    }

    public OkHttpClient get() {
        return provideDownloadsOkHttpClient(this.authenticationLoginHandlerProvider.get(), this.configurationPropertiesProvider.get(), this.getAccessTokenUseCaseProvider.get(), this.requestReAuthAndStoreTokenUseCaseProvider.get(), this.removeAccountDataUseCaseProvider.get());
    }

    public static HttpClientModule_ProvideDownloadsOkHttpClientFactory create(Provider<ReauthenticationLoginHandler> provider, Provider<ConfigurationProperties> provider2, Provider<GetAccessTokenUseCase> provider3, Provider<RequestReAuthAndStoreTokenUseCase> provider4, Provider<RemoveAccountDataUseCase> provider5) {
        return new HttpClientModule_ProvideDownloadsOkHttpClientFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static OkHttpClient provideDownloadsOkHttpClient(ReauthenticationLoginHandler reauthenticationLoginHandler, ConfigurationProperties configurationProperties, GetAccessTokenUseCase getAccessTokenUseCase, RequestReAuthAndStoreTokenUseCase requestReAuthAndStoreTokenUseCase, RemoveAccountDataUseCase removeAccountDataUseCase) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(HttpClientModule.INSTANCE.provideDownloadsOkHttpClient(reauthenticationLoginHandler, configurationProperties, getAccessTokenUseCase, requestReAuthAndStoreTokenUseCase, removeAccountDataUseCase));
    }
}
