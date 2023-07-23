package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.timersController.LockedModeService;
import media.tiger.tigerbox.services.interfaces.timersController.TimeLimitTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.WindowedLimitTimeService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideLockedModeFactory */
public final class ServiceModule_ProvideLockedModeFactory implements Factory<LockedModeService> {
    private final Provider<TimeLimitTimerService> timeLimitTimerProvider;
    private final Provider<WindowedLimitTimeService> windowedLimitProvider;

    public ServiceModule_ProvideLockedModeFactory(Provider<TimeLimitTimerService> provider, Provider<WindowedLimitTimeService> provider2) {
        this.timeLimitTimerProvider = provider;
        this.windowedLimitProvider = provider2;
    }

    public LockedModeService get() {
        return provideLockedMode(this.timeLimitTimerProvider.get(), this.windowedLimitProvider.get());
    }

    public static ServiceModule_ProvideLockedModeFactory create(Provider<TimeLimitTimerService> provider, Provider<WindowedLimitTimeService> provider2) {
        return new ServiceModule_ProvideLockedModeFactory(provider, provider2);
    }

    public static LockedModeService provideLockedMode(TimeLimitTimerService timeLimitTimerService, WindowedLimitTimeService windowedLimitTimeService) {
        return (LockedModeService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideLockedMode(timeLimitTimerService, windowedLimitTimeService));
    }
}
