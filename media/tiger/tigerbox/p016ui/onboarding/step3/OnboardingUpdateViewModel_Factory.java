package media.tiger.tigerbox.p016ui.onboarding.step3;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel_Factory */
public final class OnboardingUpdateViewModel_Factory implements Factory<OnboardingUpdateViewModel> {
    private final Provider<BatteryService> batteryServiceProvider;
    private final Provider<FirmwareUpdateService> firmwareUpdateServiceProvider;

    public OnboardingUpdateViewModel_Factory(Provider<FirmwareUpdateService> provider, Provider<BatteryService> provider2) {
        this.firmwareUpdateServiceProvider = provider;
        this.batteryServiceProvider = provider2;
    }

    public OnboardingUpdateViewModel get() {
        return newInstance(this.firmwareUpdateServiceProvider.get(), this.batteryServiceProvider.get());
    }

    public static OnboardingUpdateViewModel_Factory create(Provider<FirmwareUpdateService> provider, Provider<BatteryService> provider2) {
        return new OnboardingUpdateViewModel_Factory(provider, provider2);
    }

    public static OnboardingUpdateViewModel newInstance(FirmwareUpdateService firmwareUpdateService, BatteryService batteryService) {
        return new OnboardingUpdateViewModel(firmwareUpdateService, batteryService);
    }
}
