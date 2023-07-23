package media.tiger.tigerbox.p016ui.onboarding.step2;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiViewModel_MembersInjector */
public final class OnboardingWifiViewModel_MembersInjector implements MembersInjector<OnboardingWifiViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public OnboardingWifiViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<OnboardingWifiViewModel> create(Provider<LightControlService> provider) {
        return new OnboardingWifiViewModel_MembersInjector(provider);
    }

    public void injectMembers(OnboardingWifiViewModel onboardingWifiViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(onboardingWifiViewModel, this._lightControlProvider.get());
    }
}
