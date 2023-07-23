package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel_MembersInjector */
public final class TicketRedeemTicketNumberViewModel_MembersInjector implements MembersInjector<TicketRedeemTicketNumberViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public TicketRedeemTicketNumberViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<TicketRedeemTicketNumberViewModel> create(Provider<LightControlService> provider) {
        return new TicketRedeemTicketNumberViewModel_MembersInjector(provider);
    }

    public void injectMembers(TicketRedeemTicketNumberViewModel ticketRedeemTicketNumberViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(ticketRedeemTicketNumberViewModel, this._lightControlProvider.get());
    }
}
