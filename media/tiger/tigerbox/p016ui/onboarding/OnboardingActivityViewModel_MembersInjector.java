package media.tiger.tigerbox.p016ui.onboarding;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.OnboardingActivityViewModel_MembersInjector */
public final class OnboardingActivityViewModel_MembersInjector implements MembersInjector<OnboardingActivityViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public OnboardingActivityViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<OnboardingActivityViewModel> create(Provider<LightControlService> provider) {
        return new OnboardingActivityViewModel_MembersInjector(provider);
    }

    public void injectMembers(OnboardingActivityViewModel onboardingActivityViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(onboardingActivityViewModel, this._lightControlProvider.get());
    }
}
