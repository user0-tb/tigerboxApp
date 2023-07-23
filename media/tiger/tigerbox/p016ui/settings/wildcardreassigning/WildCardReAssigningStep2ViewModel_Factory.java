package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;

/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep2ViewModel_Factory */
public final class WildCardReAssigningStep2ViewModel_Factory implements Factory<WildCardReAssigningStep2ViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<GetTigerBoxAccountUseCase> getTigerBoxAccountUseCaseProvider;
    private final Provider<TigerCardsManagerService> tigerCardsManagerServiceProvider;

    public WildCardReAssigningStep2ViewModel_Factory(Provider<ButtonService> provider, Provider<TigerCardsManagerService> provider2, Provider<GetTigerBoxAccountUseCase> provider3, Provider<LightControlService> provider4) {
        this.buttonServiceProvider = provider;
        this.tigerCardsManagerServiceProvider = provider2;
        this.getTigerBoxAccountUseCaseProvider = provider3;
        this._lightControlProvider = provider4;
    }

    public WildCardReAssigningStep2ViewModel get() {
        WildCardReAssigningStep2ViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.tigerCardsManagerServiceProvider.get(), this.getTigerBoxAccountUseCaseProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static WildCardReAssigningStep2ViewModel_Factory create(Provider<ButtonService> provider, Provider<TigerCardsManagerService> provider2, Provider<GetTigerBoxAccountUseCase> provider3, Provider<LightControlService> provider4) {
        return new WildCardReAssigningStep2ViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static WildCardReAssigningStep2ViewModel newInstance(ButtonService buttonService, TigerCardsManagerService tigerCardsManagerService, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase) {
        return new WildCardReAssigningStep2ViewModel(buttonService, tigerCardsManagerService, getTigerBoxAccountUseCase);
    }
}
