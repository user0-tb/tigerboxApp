package media.tiger.tigerbox.p016ui.settings.timersSetup;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimeLimitTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;

/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel_Factory */
public final class TimersSetupLimitSetupViewModel_Factory implements Factory<TimersSetupLimitSetupViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<HeaderProvider> headerProvider;
    private final Provider<ShutDownTimerService> shutDownTimerServiceProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TimeLimitTimerService> timeLimitTimerProvider;
    private final Provider<TimeService> timeServiceProvider;
    private final Provider<TimersControllerService> timersControllerServiceProvider;

    public TimersSetupLimitSetupViewModel_Factory(Provider<StorageService> provider, Provider<TimeService> provider2, Provider<TimersControllerService> provider3, Provider<TimeLimitTimerService> provider4, Provider<ShutDownTimerService> provider5, Provider<ButtonService> provider6, Provider<HeaderProvider> provider7, Provider<LightControlService> provider8) {
        this.storageServiceProvider = provider;
        this.timeServiceProvider = provider2;
        this.timersControllerServiceProvider = provider3;
        this.timeLimitTimerProvider = provider4;
        this.shutDownTimerServiceProvider = provider5;
        this.buttonServiceProvider = provider6;
        this.headerProvider = provider7;
        this._lightControlProvider = provider8;
    }

    public TimersSetupLimitSetupViewModel get() {
        TimersSetupLimitSetupViewModel newInstance = newInstance(this.storageServiceProvider.get(), this.timeServiceProvider.get(), this.timersControllerServiceProvider.get(), this.timeLimitTimerProvider.get(), this.shutDownTimerServiceProvider.get(), this.buttonServiceProvider.get(), this.headerProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static TimersSetupLimitSetupViewModel_Factory create(Provider<StorageService> provider, Provider<TimeService> provider2, Provider<TimersControllerService> provider3, Provider<TimeLimitTimerService> provider4, Provider<ShutDownTimerService> provider5, Provider<ButtonService> provider6, Provider<HeaderProvider> provider7, Provider<LightControlService> provider8) {
        return new TimersSetupLimitSetupViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static TimersSetupLimitSetupViewModel newInstance(StorageService storageService, TimeService timeService, TimersControllerService timersControllerService, TimeLimitTimerService timeLimitTimerService, ShutDownTimerService shutDownTimerService, ButtonService buttonService, HeaderProvider headerProvider2) {
        return new TimersSetupLimitSetupViewModel(storageService, timeService, timersControllerService, timeLimitTimerService, shutDownTimerService, buttonService, headerProvider2);
    }
}
