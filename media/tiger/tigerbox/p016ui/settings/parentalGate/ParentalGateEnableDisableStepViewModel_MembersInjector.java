package media.tiger.tigerbox.p016ui.settings.parentalGate;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel_MembersInjector */
public final class ParentalGateEnableDisableStepViewModel_MembersInjector implements MembersInjector<ParentalGateEnableDisableStepViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public ParentalGateEnableDisableStepViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<ParentalGateEnableDisableStepViewModel> create(Provider<LightControlService> provider) {
        return new ParentalGateEnableDisableStepViewModel_MembersInjector(provider);
    }

    public void injectMembers(ParentalGateEnableDisableStepViewModel parentalGateEnableDisableStepViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(parentalGateEnableDisableStepViewModel, this._lightControlProvider.get());
    }
}
