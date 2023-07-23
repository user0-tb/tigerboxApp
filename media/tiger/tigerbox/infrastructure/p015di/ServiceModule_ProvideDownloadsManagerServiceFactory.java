package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.network.DownloadsWebService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideDownloadsManagerServiceFactory */
public final class ServiceModule_ProvideDownloadsManagerServiceFactory implements Factory<DownloadsManagerService> {
    private final Provider<Context> contextProvider;
    private final Provider<DownloadsWebService> webDlServiceProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public ServiceModule_ProvideDownloadsManagerServiceFactory(Provider<Context> provider, Provider<WifiService> provider2, Provider<DownloadsWebService> provider3) {
        this.contextProvider = provider;
        this.wifiServiceProvider = provider2;
        this.webDlServiceProvider = provider3;
    }

    public DownloadsManagerService get() {
        return provideDownloadsManagerService(this.contextProvider.get(), this.wifiServiceProvider.get(), this.webDlServiceProvider.get());
    }

    public static ServiceModule_ProvideDownloadsManagerServiceFactory create(Provider<Context> provider, Provider<WifiService> provider2, Provider<DownloadsWebService> provider3) {
        return new ServiceModule_ProvideDownloadsManagerServiceFactory(provider, provider2, provider3);
    }

    public static DownloadsManagerService provideDownloadsManagerService(Context context, WifiService wifiService, DownloadsWebService downloadsWebService) {
        return (DownloadsManagerService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideDownloadsManagerService(context, wifiService, downloadsWebService));
    }
}
