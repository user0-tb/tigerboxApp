package media.tiger.tigerbox.p016ui.main.card;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel_MembersInjector */
public final class TigerTicketPurchaseViewModel_MembersInjector implements MembersInjector<TigerTicketPurchaseViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public TigerTicketPurchaseViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<TigerTicketPurchaseViewModel> create(Provider<LightControlService> provider) {
        return new TigerTicketPurchaseViewModel_MembersInjector(provider);
    }

    public void injectMembers(TigerTicketPurchaseViewModel tigerTicketPurchaseViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(tigerTicketPurchaseViewModel, this._lightControlProvider.get());
    }
}
