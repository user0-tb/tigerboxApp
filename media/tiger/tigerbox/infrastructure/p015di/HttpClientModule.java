package media.tiger.tigerbox.infrastructure.p015di;

import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.network.AuthenticationInterceptor;
import media.tiger.tigerbox.infrastructure.functional.DownloadProgressUpdate;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.onboarding.ReauthenticationLoginHandler;
import media.tiger.tigerbox.usecase.accesstokenrepo.GetAccessTokenUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.RequestReAuthAndStoreTokenUseCase;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@Metadata(mo33736d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J0\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/di/HttpClientModule;", "", "()V", "provideAuthInterceptorOkHttpClient", "Lokhttp3/OkHttpClient;", "authenticationLoginHandler", "Lmedia/tiger/tigerbox/ui/onboarding/ReauthenticationLoginHandler;", "getAccessTokenUseCase", "Lmedia/tiger/tigerbox/usecase/accesstokenrepo/GetAccessTokenUseCase;", "requestReAuthAndStoreTokenUseCase", "Lmedia/tiger/tigerbox/usecase/accesstokenrepo/RequestReAuthAndStoreTokenUseCase;", "removeAccountDataUseCase", "Lmedia/tiger/tigerbox/usecase/accesstokenrepo/RemoveAccountDataUseCase;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "provideDownloadsOkHttpClient", "provideOtaWebServiceOkHttpClient", "downloadProgressNotifier", "Lmedia/tiger/tigerbox/infrastructure/functional/DownloadProgressUpdate;", "provideSimpleInterceptorOkHttpClient", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@Module
/* renamed from: media.tiger.tigerbox.infrastructure.di.HttpClientModule */
/* compiled from: HttpClientModule.kt */
public final class HttpClientModule {
    public static final HttpClientModule INSTANCE = new HttpClientModule();

    private HttpClientModule() {
    }

    @Provides
    public final OkHttpClient provideAuthInterceptorOkHttpClient(ReauthenticationLoginHandler reauthenticationLoginHandler, GetAccessTokenUseCase getAccessTokenUseCase, RequestReAuthAndStoreTokenUseCase requestReAuthAndStoreTokenUseCase, RemoveAccountDataUseCase removeAccountDataUseCase, ConfigurationProperties configurationProperties) {
        Intrinsics.checkNotNullParameter(reauthenticationLoginHandler, "authenticationLoginHandler");
        Intrinsics.checkNotNullParameter(getAccessTokenUseCase, "getAccessTokenUseCase");
        Intrinsics.checkNotNullParameter(requestReAuthAndStoreTokenUseCase, "requestReAuthAndStoreTokenUseCase");
        Intrinsics.checkNotNullParameter(removeAccountDataUseCase, "removeAccountDataUseCase");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        AuthenticationInterceptor authenticationInterceptor = new AuthenticationInterceptor(reauthenticationLoginHandler, getAccessTokenUseCase, requestReAuthAndStoreTokenUseCase, removeAccountDataUseCase, configurationProperties);
        return HttpClientModuleKt.createHttpClient(Boolean.parseBoolean(configurationProperties.getProperty("log.enabled")), authenticationInterceptor);
    }

    @Provides
    public final OkHttpClient provideDownloadsOkHttpClient(ReauthenticationLoginHandler reauthenticationLoginHandler, ConfigurationProperties configurationProperties, GetAccessTokenUseCase getAccessTokenUseCase, RequestReAuthAndStoreTokenUseCase requestReAuthAndStoreTokenUseCase, RemoveAccountDataUseCase removeAccountDataUseCase) {
        Intrinsics.checkNotNullParameter(reauthenticationLoginHandler, "authenticationLoginHandler");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        Intrinsics.checkNotNullParameter(getAccessTokenUseCase, "getAccessTokenUseCase");
        Intrinsics.checkNotNullParameter(requestReAuthAndStoreTokenUseCase, "requestReAuthAndStoreTokenUseCase");
        Intrinsics.checkNotNullParameter(removeAccountDataUseCase, "removeAccountDataUseCase");
        return HttpClientModuleKt.createHttpClient(false, new AuthenticationInterceptor(reauthenticationLoginHandler, getAccessTokenUseCase, requestReAuthAndStoreTokenUseCase, removeAccountDataUseCase, configurationProperties));
    }

    @Provides
    public final OkHttpClient provideOtaWebServiceOkHttpClient(ConfigurationProperties configurationProperties, DownloadProgressUpdate downloadProgressUpdate) {
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        Intrinsics.checkNotNullParameter(downloadProgressUpdate, "downloadProgressNotifier");
        return HttpClientModuleKt.createHttpClient(Boolean.parseBoolean(configurationProperties.getProperty("log.enabled")), HttpClientModuleKt.provideDownloadProgressInterceptor(downloadProgressUpdate));
    }

    @Provides
    public final OkHttpClient provideSimpleInterceptorOkHttpClient(ConfigurationProperties configurationProperties) {
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        return HttpClientModuleKt.createHttpClient(Boolean.parseBoolean(configurationProperties.getProperty("log.enabled")), new Interceptor[0]);
    }
}
