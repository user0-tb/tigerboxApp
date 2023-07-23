package media.tiger.tigerbox.p016ui.main.card;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase;

/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel_Factory */
public final class TigerTicketInputPinViewModel_Factory implements Factory<TigerTicketInputPinViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<TigerCardsManagerService> tigerCardsManagerServiceProvider;
    private final Provider<TigerTicketValidatePinUseCase> tigerTicketValidatePinUseCaseProvider;

    public TigerTicketInputPinViewModel_Factory(Provider<ButtonService> provider, Provider<TigerCardsManagerService> provider2, Provider<TigerTicketValidatePinUseCase> provider3, Provider<LightControlService> provider4) {
        this.buttonServiceProvider = provider;
        this.tigerCardsManagerServiceProvider = provider2;
        this.tigerTicketValidatePinUseCaseProvider = provider3;
        this._lightControlProvider = provider4;
    }

    public TigerTicketInputPinViewModel get() {
        TigerTicketInputPinViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.tigerCardsManagerServiceProvider.get(), this.tigerTicketValidatePinUseCaseProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static TigerTicketInputPinViewModel_Factory create(Provider<ButtonService> provider, Provider<TigerCardsManagerService> provider2, Provider<TigerTicketValidatePinUseCase> provider3, Provider<LightControlService> provider4) {
        return new TigerTicketInputPinViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static TigerTicketInputPinViewModel newInstance(ButtonService buttonService, TigerCardsManagerService tigerCardsManagerService, TigerTicketValidatePinUseCase tigerTicketValidatePinUseCase) {
        return new TigerTicketInputPinViewModel(buttonService, tigerCardsManagerService, tigerTicketValidatePinUseCase);
    }
}
