package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideSleepTimerServiceFactory */
public final class ServiceModule_ProvideSleepTimerServiceFactory implements Factory<ShutDownTimerService> {
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<PowerManagementService> powerManagementServiceProvider;

    public ServiceModule_ProvideSleepTimerServiceFactory(Provider<PowerManagementService> provider, Provider<AudioPlayerService> provider2) {
        this.powerManagementServiceProvider = provider;
        this.audioPlayerServiceProvider = provider2;
    }

    public ShutDownTimerService get() {
        return provideSleepTimerService(this.powerManagementServiceProvider.get(), this.audioPlayerServiceProvider.get());
    }

    public static ServiceModule_ProvideSleepTimerServiceFactory create(Provider<PowerManagementService> provider, Provider<AudioPlayerService> provider2) {
        return new ServiceModule_ProvideSleepTimerServiceFactory(provider, provider2);
    }

    public static ShutDownTimerService provideSleepTimerService(PowerManagementService powerManagementService, AudioPlayerService audioPlayerService) {
        return (ShutDownTimerService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideSleepTimerService(powerManagementService, audioPlayerService));
    }
}
