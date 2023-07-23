package media.tiger.tigerbox.infrastructure.p015di;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.WakeService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.HlsKeyProviderService;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideAvailabilityServiceFactory */
public final class ServiceModule_ProvideAvailabilityServiceFactory implements Factory<AvailabilityService> {
    private final Provider<DownloadsManagerService> dlServiceProvider;
    private final Provider<GetTigerBoxAccountUseCase> getTigerBoxAccountUseCaseProvider;
    private final Provider<HlsKeyProviderService> hlsServiceProvider;
    private final Provider<LightControlService> lightControlServiceProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TimeService> timeServiceProvider;
    private final Provider<WakeService> wakeServiceProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public ServiceModule_ProvideAvailabilityServiceFactory(Provider<DownloadsManagerService> provider, Provider<GetTigerBoxAccountUseCase> provider2, Provider<SharedPreferences> provider3, Provider<WifiService> provider4, Provider<HlsKeyProviderService> provider5, Provider<LightControlService> provider6, Provider<TimeService> provider7, Provider<WakeService> provider8) {
        this.dlServiceProvider = provider;
        this.getTigerBoxAccountUseCaseProvider = provider2;
        this.sharedPreferencesProvider = provider3;
        this.wifiServiceProvider = provider4;
        this.hlsServiceProvider = provider5;
        this.lightControlServiceProvider = provider6;
        this.timeServiceProvider = provider7;
        this.wakeServiceProvider = provider8;
    }

    public AvailabilityService get() {
        return provideAvailabilityService(this.dlServiceProvider.get(), this.getTigerBoxAccountUseCaseProvider.get(), this.sharedPreferencesProvider.get(), this.wifiServiceProvider.get(), this.hlsServiceProvider.get(), this.lightControlServiceProvider.get(), this.timeServiceProvider.get(), this.wakeServiceProvider.get());
    }

    public static ServiceModule_ProvideAvailabilityServiceFactory create(Provider<DownloadsManagerService> provider, Provider<GetTigerBoxAccountUseCase> provider2, Provider<SharedPreferences> provider3, Provider<WifiService> provider4, Provider<HlsKeyProviderService> provider5, Provider<LightControlService> provider6, Provider<TimeService> provider7, Provider<WakeService> provider8) {
        return new ServiceModule_ProvideAvailabilityServiceFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static AvailabilityService provideAvailabilityService(DownloadsManagerService downloadsManagerService, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase, SharedPreferences sharedPreferences, WifiService wifiService, HlsKeyProviderService hlsKeyProviderService, LightControlService lightControlService, TimeService timeService, WakeService wakeService) {
        return (AvailabilityService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideAvailabilityService(downloadsManagerService, getTigerBoxAccountUseCase, sharedPreferences, wifiService, hlsKeyProviderService, lightControlService, timeService, wakeService));
    }
}
