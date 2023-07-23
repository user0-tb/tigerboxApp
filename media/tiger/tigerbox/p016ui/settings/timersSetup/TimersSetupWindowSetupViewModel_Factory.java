package media.tiger.tigerbox.p016ui.settings.timersSetup;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;

/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupViewModel_Factory */
public final class TimersSetupWindowSetupViewModel_Factory implements Factory<TimersSetupWindowSetupViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<HeaderProvider> headerProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TimersControllerService> timeLimitControllerProvider;

    public TimersSetupWindowSetupViewModel_Factory(Provider<StorageService> provider, Provider<TimersControllerService> provider2, Provider<ButtonService> provider3, Provider<HeaderProvider> provider4, Provider<LightControlService> provider5) {
        this.storageServiceProvider = provider;
        this.timeLimitControllerProvider = provider2;
        this.buttonServiceProvider = provider3;
        this.headerProvider = provider4;
        this._lightControlProvider = provider5;
    }

    public TimersSetupWindowSetupViewModel get() {
        TimersSetupWindowSetupViewModel newInstance = newInstance(this.storageServiceProvider.get(), this.timeLimitControllerProvider.get(), this.buttonServiceProvider.get(), this.headerProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static TimersSetupWindowSetupViewModel_Factory create(Provider<StorageService> provider, Provider<TimersControllerService> provider2, Provider<ButtonService> provider3, Provider<HeaderProvider> provider4, Provider<LightControlService> provider5) {
        return new TimersSetupWindowSetupViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TimersSetupWindowSetupViewModel newInstance(StorageService storageService, TimersControllerService timersControllerService, ButtonService buttonService, HeaderProvider headerProvider2) {
        return new TimersSetupWindowSetupViewModel(storageService, timersControllerService, buttonService, headerProvider2);
    }
}
