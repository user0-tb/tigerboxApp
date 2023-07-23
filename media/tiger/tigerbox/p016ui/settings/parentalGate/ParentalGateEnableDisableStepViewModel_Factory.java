package media.tiger.tigerbox.p016ui.settings.parentalGate;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;

/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel_Factory */
public final class ParentalGateEnableDisableStepViewModel_Factory implements Factory<ParentalGateEnableDisableStepViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<StorageService> storageServiceProvider;

    public ParentalGateEnableDisableStepViewModel_Factory(Provider<ButtonService> provider, Provider<StorageService> provider2, Provider<LightControlService> provider3) {
        this.buttonServiceProvider = provider;
        this.storageServiceProvider = provider2;
        this._lightControlProvider = provider3;
    }

    public ParentalGateEnableDisableStepViewModel get() {
        ParentalGateEnableDisableStepViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.storageServiceProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static ParentalGateEnableDisableStepViewModel_Factory create(Provider<ButtonService> provider, Provider<StorageService> provider2, Provider<LightControlService> provider3) {
        return new ParentalGateEnableDisableStepViewModel_Factory(provider, provider2, provider3);
    }

    public static ParentalGateEnableDisableStepViewModel newInstance(ButtonService buttonService, StorageService storageService) {
        return new ParentalGateEnableDisableStepViewModel(buttonService, storageService);
    }
}
