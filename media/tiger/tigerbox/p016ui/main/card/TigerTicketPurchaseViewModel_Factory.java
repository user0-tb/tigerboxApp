package media.tiger.tigerbox.p016ui.main.card;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.usecase.TigerTicketPurchaseUseCase;

/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel_Factory */
public final class TigerTicketPurchaseViewModel_Factory implements Factory<TigerTicketPurchaseViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<TigerCardsManagerService> tigerCardsManagerServiceProvider;
    private final Provider<TigerTicketPurchaseUseCase> tigerTicketPurchaseUseCaseProvider;

    public TigerTicketPurchaseViewModel_Factory(Provider<ButtonService> provider, Provider<TigerCardsManagerService> provider2, Provider<TigerTicketPurchaseUseCase> provider3, Provider<LightControlService> provider4) {
        this.buttonServiceProvider = provider;
        this.tigerCardsManagerServiceProvider = provider2;
        this.tigerTicketPurchaseUseCaseProvider = provider3;
        this._lightControlProvider = provider4;
    }

    public TigerTicketPurchaseViewModel get() {
        TigerTicketPurchaseViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.tigerCardsManagerServiceProvider.get(), this.tigerTicketPurchaseUseCaseProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static TigerTicketPurchaseViewModel_Factory create(Provider<ButtonService> provider, Provider<TigerCardsManagerService> provider2, Provider<TigerTicketPurchaseUseCase> provider3, Provider<LightControlService> provider4) {
        return new TigerTicketPurchaseViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static TigerTicketPurchaseViewModel newInstance(ButtonService buttonService, TigerCardsManagerService tigerCardsManagerService, TigerTicketPurchaseUseCase tigerTicketPurchaseUseCase) {
        return new TigerTicketPurchaseViewModel(buttonService, tigerCardsManagerService, tigerTicketPurchaseUseCase);
    }
}
