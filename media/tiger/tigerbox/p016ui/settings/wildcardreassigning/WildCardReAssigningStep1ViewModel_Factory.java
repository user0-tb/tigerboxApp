package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;

/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel_Factory */
public final class WildCardReAssigningStep1ViewModel_Factory implements Factory<WildCardReAssigningStep1ViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<TigerCardsManagerService> tigerCardsManagerServiceProvider;

    public WildCardReAssigningStep1ViewModel_Factory(Provider<ButtonService> provider, Provider<TigerCardsManagerService> provider2, Provider<LightControlService> provider3) {
        this.buttonServiceProvider = provider;
        this.tigerCardsManagerServiceProvider = provider2;
        this._lightControlProvider = provider3;
    }

    public WildCardReAssigningStep1ViewModel get() {
        WildCardReAssigningStep1ViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.tigerCardsManagerServiceProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static WildCardReAssigningStep1ViewModel_Factory create(Provider<ButtonService> provider, Provider<TigerCardsManagerService> provider2, Provider<LightControlService> provider3) {
        return new WildCardReAssigningStep1ViewModel_Factory(provider, provider2, provider3);
    }

    public static WildCardReAssigningStep1ViewModel newInstance(ButtonService buttonService, TigerCardsManagerService tigerCardsManagerService) {
        return new WildCardReAssigningStep1ViewModel(buttonService, tigerCardsManagerService);
    }
}
