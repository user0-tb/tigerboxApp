package media.tiger.tigerbox.p016ui.onboarding.step4;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseViewModel_MembersInjector */
public final class OnboardingBackendResponseViewModel_MembersInjector implements MembersInjector<OnboardingBackendResponseViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public OnboardingBackendResponseViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<OnboardingBackendResponseViewModel> create(Provider<LightControlService> provider) {
        return new OnboardingBackendResponseViewModel_MembersInjector(provider);
    }

    public void injectMembers(OnboardingBackendResponseViewModel onboardingBackendResponseViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(onboardingBackendResponseViewModel, this._lightControlProvider.get());
    }
}
