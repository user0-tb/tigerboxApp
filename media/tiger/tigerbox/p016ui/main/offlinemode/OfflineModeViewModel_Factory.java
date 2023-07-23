package media.tiger.tigerbox.p016ui.main.offlinemode;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.WifiService;

/* renamed from: media.tiger.tigerbox.ui.main.offlinemode.OfflineModeViewModel_Factory */
public final class OfflineModeViewModel_Factory implements Factory<OfflineModeViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<TigerBoxAccountRepository> accountRepositoryProvider;
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<DisplayService> displayServiceProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TimeService> timeServiceProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public OfflineModeViewModel_Factory(Provider<AvailabilityService> provider, Provider<TigerBoxAccountRepository> provider2, Provider<StorageService> provider3, Provider<DisplayService> provider4, Provider<TimeService> provider5, Provider<WifiService> provider6, Provider<LightControlService> provider7) {
        this.availabilityServiceProvider = provider;
        this.accountRepositoryProvider = provider2;
        this.storageServiceProvider = provider3;
        this.displayServiceProvider = provider4;
        this.timeServiceProvider = provider5;
        this.wifiServiceProvider = provider6;
        this._lightControlProvider = provider7;
    }

    public OfflineModeViewModel get() {
        OfflineModeViewModel newInstance = newInstance(this.availabilityServiceProvider.get(), this.accountRepositoryProvider.get(), this.storageServiceProvider.get(), this.displayServiceProvider.get(), this.timeServiceProvider.get(), this.wifiServiceProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static OfflineModeViewModel_Factory create(Provider<AvailabilityService> provider, Provider<TigerBoxAccountRepository> provider2, Provider<StorageService> provider3, Provider<DisplayService> provider4, Provider<TimeService> provider5, Provider<WifiService> provider6, Provider<LightControlService> provider7) {
        return new OfflineModeViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static OfflineModeViewModel newInstance(AvailabilityService availabilityService, TigerBoxAccountRepository tigerBoxAccountRepository, StorageService storageService, DisplayService displayService, TimeService timeService, WifiService wifiService) {
        return new OfflineModeViewModel(availabilityService, tigerBoxAccountRepository, storageService, displayService, timeService, wifiService);
    }
}
