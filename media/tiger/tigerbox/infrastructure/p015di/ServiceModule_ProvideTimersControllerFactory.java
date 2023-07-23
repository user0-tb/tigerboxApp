package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimeLimitTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;
import media.tiger.tigerbox.services.interfaces.timersController.WindowedLimitTimeService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideTimersControllerFactory */
public final class ServiceModule_ProvideTimersControllerFactory implements Factory<TimersControllerService> {
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<DisplayService> displayServiceProvider;
    private final Provider<TimeLimitTimerService> timeLimitTimerProvider;
    private final Provider<WindowedLimitTimeService> windowedLimitProvider;

    public ServiceModule_ProvideTimersControllerFactory(Provider<TimeLimitTimerService> provider, Provider<WindowedLimitTimeService> provider2, Provider<AudioPlayerService> provider3, Provider<DisplayService> provider4) {
        this.timeLimitTimerProvider = provider;
        this.windowedLimitProvider = provider2;
        this.audioPlayerServiceProvider = provider3;
        this.displayServiceProvider = provider4;
    }

    public TimersControllerService get() {
        return provideTimersController(this.timeLimitTimerProvider.get(), this.windowedLimitProvider.get(), this.audioPlayerServiceProvider.get(), this.displayServiceProvider.get());
    }

    public static ServiceModule_ProvideTimersControllerFactory create(Provider<TimeLimitTimerService> provider, Provider<WindowedLimitTimeService> provider2, Provider<AudioPlayerService> provider3, Provider<DisplayService> provider4) {
        return new ServiceModule_ProvideTimersControllerFactory(provider, provider2, provider3, provider4);
    }

    public static TimersControllerService provideTimersController(TimeLimitTimerService timeLimitTimerService, WindowedLimitTimeService windowedLimitTimeService, AudioPlayerService audioPlayerService, DisplayService displayService) {
        return (TimersControllerService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideTimersController(timeLimitTimerService, windowedLimitTimeService, audioPlayerService, displayService));
    }
}
