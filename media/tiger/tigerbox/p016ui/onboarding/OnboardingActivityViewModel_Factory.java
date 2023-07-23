package media.tiger.tigerbox.p016ui.onboarding;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.WifiService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.OnboardingActivityViewModel_Factory */
public final class OnboardingActivityViewModel_Factory implements Factory<OnboardingActivityViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<LightControlService> lightControllerProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public OnboardingActivityViewModel_Factory(Provider<WifiService> provider, Provider<LightControlService> provider2, Provider<LightControlService> provider3) {
        this.wifiServiceProvider = provider;
        this.lightControllerProvider = provider2;
        this._lightControlProvider = provider3;
    }

    public OnboardingActivityViewModel get() {
        OnboardingActivityViewModel newInstance = newInstance(this.wifiServiceProvider.get(), this.lightControllerProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static OnboardingActivityViewModel_Factory create(Provider<WifiService> provider, Provider<LightControlService> provider2, Provider<LightControlService> provider3) {
        return new OnboardingActivityViewModel_Factory(provider, provider2, provider3);
    }

    public static OnboardingActivityViewModel newInstance(WifiService wifiService, LightControlService lightControlService) {
        return new OnboardingActivityViewModel(wifiService, lightControlService);
    }
}
