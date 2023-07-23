package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.usecase.TigerTicketGetProductUseCase;

/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel_Factory */
public final class TicketRedeemTicketNumberViewModel_Factory implements Factory<TicketRedeemTicketNumberViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<TigerCardsManagerService> tigerCardsManagerServiceProvider;
    private final Provider<TigerTicketGetProductUseCase> tigerTicketGetProductUseCaseProvider;

    public TicketRedeemTicketNumberViewModel_Factory(Provider<ButtonService> provider, Provider<TigerCardsManagerService> provider2, Provider<TigerTicketGetProductUseCase> provider3, Provider<LightControlService> provider4) {
        this.buttonServiceProvider = provider;
        this.tigerCardsManagerServiceProvider = provider2;
        this.tigerTicketGetProductUseCaseProvider = provider3;
        this._lightControlProvider = provider4;
    }

    public TicketRedeemTicketNumberViewModel get() {
        TicketRedeemTicketNumberViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.tigerCardsManagerServiceProvider.get(), this.tigerTicketGetProductUseCaseProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static TicketRedeemTicketNumberViewModel_Factory create(Provider<ButtonService> provider, Provider<TigerCardsManagerService> provider2, Provider<TigerTicketGetProductUseCase> provider3, Provider<LightControlService> provider4) {
        return new TicketRedeemTicketNumberViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static TicketRedeemTicketNumberViewModel newInstance(ButtonService buttonService, TigerCardsManagerService tigerCardsManagerService, TigerTicketGetProductUseCase tigerTicketGetProductUseCase) {
        return new TicketRedeemTicketNumberViewModel(buttonService, tigerCardsManagerService, tigerTicketGetProductUseCase);
    }
}
