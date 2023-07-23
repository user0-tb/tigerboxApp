package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.AndroidSystemProperties;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.NightLightTimerService;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideMetaDataServiceFactory */
public final class ServiceModule_ProvideMetaDataServiceFactory implements Factory<MetaDataService> {
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<BatteryService> batteryServiceProvider;
    private final Provider<Context> contextProvider;
    private final Provider<GetTigerBoxAccountUseCase> getTigerBoxAccountUseCaseProvider;
    private final Provider<InfoSoundService> infoSoundServiceProvider;
    private final Provider<LightControlService> lightControlServiceProvider;
    private final Provider<NightLightTimerService> nightLightTimerServiceProvider;
    private final Provider<PowerManagementService> powerManagementServiceProvider;
    private final Provider<ShutDownTimerService> shutDownTimerServiceProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<AndroidSystemProperties> systemPropertiesProvider;
    private final Provider<TimeService> systemTimeServiceProvider;
    private final Provider<TimersControllerService> timersControllerProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public ServiceModule_ProvideMetaDataServiceFactory(Provider<Context> provider, Provider<StorageService> provider2, Provider<WifiService> provider3, Provider<BatteryService> provider4, Provider<AvailabilityService> provider5, Provider<NightLightTimerService> provider6, Provider<LightControlService> provider7, Provider<AudioPlayerService> provider8, Provider<PowerManagementService> provider9, Provider<ShutDownTimerService> provider10, Provider<TimersControllerService> provider11, Provider<TimeService> provider12, Provider<InfoSoundService> provider13, Provider<AndroidSystemProperties> provider14, Provider<GetTigerBoxAccountUseCase> provider15) {
        this.contextProvider = provider;
        this.storageServiceProvider = provider2;
        this.wifiServiceProvider = provider3;
        this.batteryServiceProvider = provider4;
        this.availabilityServiceProvider = provider5;
        this.nightLightTimerServiceProvider = provider6;
        this.lightControlServiceProvider = provider7;
        this.audioPlayerServiceProvider = provider8;
        this.powerManagementServiceProvider = provider9;
        this.shutDownTimerServiceProvider = provider10;
        this.timersControllerProvider = provider11;
        this.systemTimeServiceProvider = provider12;
        this.infoSoundServiceProvider = provider13;
        this.systemPropertiesProvider = provider14;
        this.getTigerBoxAccountUseCaseProvider = provider15;
    }

    public MetaDataService get() {
        return provideMetaDataService(this.contextProvider.get(), this.storageServiceProvider.get(), this.wifiServiceProvider.get(), this.batteryServiceProvider.get(), this.availabilityServiceProvider.get(), this.nightLightTimerServiceProvider.get(), this.lightControlServiceProvider.get(), this.audioPlayerServiceProvider.get(), this.powerManagementServiceProvider.get(), this.shutDownTimerServiceProvider.get(), this.timersControllerProvider.get(), this.systemTimeServiceProvider.get(), this.infoSoundServiceProvider.get(), this.systemPropertiesProvider.get(), this.getTigerBoxAccountUseCaseProvider.get());
    }

    public static ServiceModule_ProvideMetaDataServiceFactory create(Provider<Context> provider, Provider<StorageService> provider2, Provider<WifiService> provider3, Provider<BatteryService> provider4, Provider<AvailabilityService> provider5, Provider<NightLightTimerService> provider6, Provider<LightControlService> provider7, Provider<AudioPlayerService> provider8, Provider<PowerManagementService> provider9, Provider<ShutDownTimerService> provider10, Provider<TimersControllerService> provider11, Provider<TimeService> provider12, Provider<InfoSoundService> provider13, Provider<AndroidSystemProperties> provider14, Provider<GetTigerBoxAccountUseCase> provider15) {
        return new ServiceModule_ProvideMetaDataServiceFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    public static MetaDataService provideMetaDataService(Context context, StorageService storageService, WifiService wifiService, BatteryService batteryService, AvailabilityService availabilityService, NightLightTimerService nightLightTimerService, LightControlService lightControlService, AudioPlayerService audioPlayerService, PowerManagementService powerManagementService, ShutDownTimerService shutDownTimerService, TimersControllerService timersControllerService, TimeService timeService, InfoSoundService infoSoundService, AndroidSystemProperties androidSystemProperties, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase) {
        return (MetaDataService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideMetaDataService(context, storageService, wifiService, batteryService, availabilityService, nightLightTimerService, lightControlService, audioPlayerService, powerManagementService, shutDownTimerService, timersControllerService, timeService, infoSoundService, androidSystemProperties, getTigerBoxAccountUseCase));
    }
}
