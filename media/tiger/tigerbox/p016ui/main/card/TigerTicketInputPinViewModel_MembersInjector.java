package media.tiger.tigerbox.p016ui.main.card;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel_MembersInjector */
public final class TigerTicketInputPinViewModel_MembersInjector implements MembersInjector<TigerTicketInputPinViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public TigerTicketInputPinViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<TigerTicketInputPinViewModel> create(Provider<LightControlService> provider) {
        return new TigerTicketInputPinViewModel_MembersInjector(provider);
    }

    public void injectMembers(TigerTicketInputPinViewModel tigerTicketInputPinViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(tigerTicketInputPinViewModel, this._lightControlProvider.get());
    }
}
