package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.implementations.DeepSleepTimerService;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvidePowerManagementServiceFactory */
public final class ServiceModule_ProvidePowerManagementServiceFactory implements Factory<PowerManagementService> {
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<BatteryService> batteryServiceProvider;
    private final Provider<Context> contextProvider;
    private final Provider<DeepSleepTimerService> deepSleepTimerServiceProvider;
    private final Provider<DisplayService> displayServiceProvider;

    public ServiceModule_ProvidePowerManagementServiceFactory(Provider<Context> provider, Provider<DisplayService> provider2, Provider<BatteryService> provider3, Provider<DeepSleepTimerService> provider4, Provider<AudioPlayerService> provider5) {
        this.contextProvider = provider;
        this.displayServiceProvider = provider2;
        this.batteryServiceProvider = provider3;
        this.deepSleepTimerServiceProvider = provider4;
        this.audioPlayerServiceProvider = provider5;
    }

    public PowerManagementService get() {
        return providePowerManagementService(this.contextProvider.get(), this.displayServiceProvider.get(), this.batteryServiceProvider.get(), this.deepSleepTimerServiceProvider.get(), this.audioPlayerServiceProvider.get());
    }

    public static ServiceModule_ProvidePowerManagementServiceFactory create(Provider<Context> provider, Provider<DisplayService> provider2, Provider<BatteryService> provider3, Provider<DeepSleepTimerService> provider4, Provider<AudioPlayerService> provider5) {
        return new ServiceModule_ProvidePowerManagementServiceFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static PowerManagementService providePowerManagementService(Context context, DisplayService displayService, BatteryService batteryService, DeepSleepTimerService deepSleepTimerService, AudioPlayerService audioPlayerService) {
        return (PowerManagementService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.providePowerManagementService(context, displayService, batteryService, deepSleepTimerService, audioPlayerService));
    }
}
