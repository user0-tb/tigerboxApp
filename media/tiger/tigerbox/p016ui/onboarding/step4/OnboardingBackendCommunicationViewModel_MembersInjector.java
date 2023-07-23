package media.tiger.tigerbox.p016ui.onboarding.step4;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendCommunicationViewModel_MembersInjector */
public final class OnboardingBackendCommunicationViewModel_MembersInjector implements MembersInjector<OnboardingBackendCommunicationViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public OnboardingBackendCommunicationViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<OnboardingBackendCommunicationViewModel> create(Provider<LightControlService> provider) {
        return new OnboardingBackendCommunicationViewModel_MembersInjector(provider);
    }

    public void injectMembers(OnboardingBackendCommunicationViewModel onboardingBackendCommunicationViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(onboardingBackendCommunicationViewModel, this._lightControlProvider.get());
    }
}
