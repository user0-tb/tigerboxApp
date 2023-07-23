package media.tiger.tigerbox.p016ui.settings.parentalGate;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel_MembersInjector */
public final class ParentalGateViewModel_MembersInjector implements MembersInjector<ParentalGateViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public ParentalGateViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<ParentalGateViewModel> create(Provider<LightControlService> provider) {
        return new ParentalGateViewModel_MembersInjector(provider);
    }

    public void injectMembers(ParentalGateViewModel parentalGateViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(parentalGateViewModel, this._lightControlProvider.get());
    }
}
