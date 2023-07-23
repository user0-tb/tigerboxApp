package media.tiger.tigerbox.p016ui.onboarding.step4;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseViewModel_Factory */
public final class OnboardingBackendResponseViewModel_Factory implements Factory<OnboardingBackendResponseViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<RemoveAccountDataUseCase> removeAccountDataUseCaseProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public OnboardingBackendResponseViewModel_Factory(Provider<RemoveAccountDataUseCase> provider, Provider<WifiService> provider2, Provider<LightControlService> provider3) {
        this.removeAccountDataUseCaseProvider = provider;
        this.wifiServiceProvider = provider2;
        this._lightControlProvider = provider3;
    }

    public OnboardingBackendResponseViewModel get() {
        OnboardingBackendResponseViewModel newInstance = newInstance(this.removeAccountDataUseCaseProvider.get(), this.wifiServiceProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static OnboardingBackendResponseViewModel_Factory create(Provider<RemoveAccountDataUseCase> provider, Provider<WifiService> provider2, Provider<LightControlService> provider3) {
        return new OnboardingBackendResponseViewModel_Factory(provider, provider2, provider3);
    }

    public static OnboardingBackendResponseViewModel newInstance(RemoveAccountDataUseCase removeAccountDataUseCase, WifiService wifiService) {
        return new OnboardingBackendResponseViewModel(removeAccountDataUseCase, wifiService);
    }
}
