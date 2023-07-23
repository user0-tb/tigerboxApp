package media.tiger.tigerbox.p016ui.common.wifi;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;

/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordViewModel_Factory */
public final class WifiEnterPasswordViewModel_Factory implements Factory<WifiEnterPasswordViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<StorageService> storageServiceProvider;

    public WifiEnterPasswordViewModel_Factory(Provider<StorageService> provider, Provider<ButtonService> provider2, Provider<LightControlService> provider3) {
        this.storageServiceProvider = provider;
        this.buttonServiceProvider = provider2;
        this._lightControlProvider = provider3;
    }

    public WifiEnterPasswordViewModel get() {
        WifiEnterPasswordViewModel newInstance = newInstance(this.storageServiceProvider.get(), this.buttonServiceProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static WifiEnterPasswordViewModel_Factory create(Provider<StorageService> provider, Provider<ButtonService> provider2, Provider<LightControlService> provider3) {
        return new WifiEnterPasswordViewModel_Factory(provider, provider2, provider3);
    }

    public static WifiEnterPasswordViewModel newInstance(StorageService storageService, ButtonService buttonService) {
        return new WifiEnterPasswordViewModel(storageService, buttonService);
    }
}
