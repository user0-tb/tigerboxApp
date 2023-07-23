package media.tiger.tigerbox.p016ui.settings.parentalGate;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel_Factory */
public final class ParentalGateViewModel_Factory implements Factory<ParentalGateViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<TigerBoxAccountRepository> accountRepositoryProvider;
    private final Provider<ButtonService> buttonServiceProvider;

    public ParentalGateViewModel_Factory(Provider<ButtonService> provider, Provider<TigerBoxAccountRepository> provider2, Provider<LightControlService> provider3) {
        this.buttonServiceProvider = provider;
        this.accountRepositoryProvider = provider2;
        this._lightControlProvider = provider3;
    }

    public ParentalGateViewModel get() {
        ParentalGateViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.accountRepositoryProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static ParentalGateViewModel_Factory create(Provider<ButtonService> provider, Provider<TigerBoxAccountRepository> provider2, Provider<LightControlService> provider3) {
        return new ParentalGateViewModel_Factory(provider, provider2, provider3);
    }

    public static ParentalGateViewModel newInstance(ButtonService buttonService, TigerBoxAccountRepository tigerBoxAccountRepository) {
        return new ParentalGateViewModel(buttonService, tigerBoxAccountRepository);
    }
}
