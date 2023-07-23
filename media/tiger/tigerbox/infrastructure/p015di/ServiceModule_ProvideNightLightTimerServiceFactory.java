package media.tiger.tigerbox.infrastructure.p015di;

import android.app.AlarmManager;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.NightLightTimerService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideNightLightTimerServiceFactory */
public final class ServiceModule_ProvideNightLightTimerServiceFactory implements Factory<NightLightTimerService> {
    private final Provider<AlarmManager> alarmManagerProvider;
    private final Provider<Context> contextProvider;
    private final Provider<LightControlService> lightControlProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TimeService> timeServiceProvider;

    public ServiceModule_ProvideNightLightTimerServiceFactory(Provider<Context> provider, Provider<LightControlService> provider2, Provider<StorageService> provider3, Provider<TimeService> provider4, Provider<AlarmManager> provider5) {
        this.contextProvider = provider;
        this.lightControlProvider = provider2;
        this.storageServiceProvider = provider3;
        this.timeServiceProvider = provider4;
        this.alarmManagerProvider = provider5;
    }

    public NightLightTimerService get() {
        return provideNightLightTimerService(this.contextProvider.get(), this.lightControlProvider.get(), this.storageServiceProvider.get(), this.timeServiceProvider.get(), this.alarmManagerProvider.get());
    }

    public static ServiceModule_ProvideNightLightTimerServiceFactory create(Provider<Context> provider, Provider<LightControlService> provider2, Provider<StorageService> provider3, Provider<TimeService> provider4, Provider<AlarmManager> provider5) {
        return new ServiceModule_ProvideNightLightTimerServiceFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static NightLightTimerService provideNightLightTimerService(Context context, LightControlService lightControlService, StorageService storageService, TimeService timeService, AlarmManager alarmManager) {
        return (NightLightTimerService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideNightLightTimerService(context, lightControlService, storageService, timeService, alarmManager));
    }
}
