package media.tiger.tigerbox.p016ui.settings.timersSetup;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;

/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupViewModel_Factory */
public final class TimersSetupViewModel_Factory implements Factory<TimersSetupViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<HeaderProvider> headerProvider;
    private final Provider<ShutDownTimerService> shutDownTimerServiceProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TimersControllerService> timersCtrlServiceProvider;

    public TimersSetupViewModel_Factory(Provider<TimersControllerService> provider, Provider<ShutDownTimerService> provider2, Provider<StorageService> provider3, Provider<ButtonService> provider4, Provider<HeaderProvider> provider5, Provider<LightControlService> provider6) {
        this.timersCtrlServiceProvider = provider;
        this.shutDownTimerServiceProvider = provider2;
        this.storageServiceProvider = provider3;
        this.buttonServiceProvider = provider4;
        this.headerProvider = provider5;
        this._lightControlProvider = provider6;
    }

    public TimersSetupViewModel get() {
        TimersSetupViewModel newInstance = newInstance(this.timersCtrlServiceProvider.get(), this.shutDownTimerServiceProvider.get(), this.storageServiceProvider.get(), this.buttonServiceProvider.get(), this.headerProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static TimersSetupViewModel_Factory create(Provider<TimersControllerService> provider, Provider<ShutDownTimerService> provider2, Provider<StorageService> provider3, Provider<ButtonService> provider4, Provider<HeaderProvider> provider5, Provider<LightControlService> provider6) {
        return new TimersSetupViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static TimersSetupViewModel newInstance(TimersControllerService timersControllerService, ShutDownTimerService shutDownTimerService, StorageService storageService, ButtonService buttonService, HeaderProvider headerProvider2) {
        return new TimersSetupViewModel(timersControllerService, shutDownTimerService, storageService, buttonService, headerProvider2);
    }
}
