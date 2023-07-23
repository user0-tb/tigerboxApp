package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideHeaderBarFactory */
public final class ServiceModule_ProvideHeaderBarFactory implements Factory<HeaderProvider> {
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<BatteryService> batteryServiceProvider;
    private final Provider<FirmwareUpdateService> firmwareUpdateServiceProvider;
    private final Provider<InfoSoundService> infoSoundServiceProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<ShutDownTimerService> shutDownTimerServiceProvider;
    private final Provider<TimersControllerService> timersControllerServiceProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public ServiceModule_ProvideHeaderBarFactory(Provider<WifiService> provider, Provider<BatteryService> provider2, Provider<ShutDownTimerService> provider3, Provider<TimersControllerService> provider4, Provider<AvailabilityService> provider5, Provider<MetaDataService> provider6, Provider<InfoSoundService> provider7, Provider<AudioPlayerService> provider8, Provider<FirmwareUpdateService> provider9) {
        this.wifiServiceProvider = provider;
        this.batteryServiceProvider = provider2;
        this.shutDownTimerServiceProvider = provider3;
        this.timersControllerServiceProvider = provider4;
        this.availabilityServiceProvider = provider5;
        this.metaDataServiceProvider = provider6;
        this.infoSoundServiceProvider = provider7;
        this.audioPlayerServiceProvider = provider8;
        this.firmwareUpdateServiceProvider = provider9;
    }

    public HeaderProvider get() {
        return provideHeaderBar(this.wifiServiceProvider.get(), this.batteryServiceProvider.get(), this.shutDownTimerServiceProvider.get(), this.timersControllerServiceProvider.get(), this.availabilityServiceProvider.get(), this.metaDataServiceProvider.get(), this.infoSoundServiceProvider.get(), this.audioPlayerServiceProvider.get(), this.firmwareUpdateServiceProvider.get());
    }

    public static ServiceModule_ProvideHeaderBarFactory create(Provider<WifiService> provider, Provider<BatteryService> provider2, Provider<ShutDownTimerService> provider3, Provider<TimersControllerService> provider4, Provider<AvailabilityService> provider5, Provider<MetaDataService> provider6, Provider<InfoSoundService> provider7, Provider<AudioPlayerService> provider8, Provider<FirmwareUpdateService> provider9) {
        return new ServiceModule_ProvideHeaderBarFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static HeaderProvider provideHeaderBar(WifiService wifiService, BatteryService batteryService, ShutDownTimerService shutDownTimerService, TimersControllerService timersControllerService, AvailabilityService availabilityService, MetaDataService metaDataService, InfoSoundService infoSoundService, AudioPlayerService audioPlayerService, FirmwareUpdateService firmwareUpdateService) {
        return (HeaderProvider) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideHeaderBar(wifiService, batteryService, shutDownTimerService, timersControllerService, availabilityService, metaDataService, infoSoundService, audioPlayerService, firmwareUpdateService));
    }
}
