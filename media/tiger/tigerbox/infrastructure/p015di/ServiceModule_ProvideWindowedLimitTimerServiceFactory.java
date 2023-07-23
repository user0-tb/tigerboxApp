package media.tiger.tigerbox.infrastructure.p015di;

import android.app.AlarmManager;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.timersController.WindowedLimitTimeService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideWindowedLimitTimerServiceFactory */
public final class ServiceModule_ProvideWindowedLimitTimerServiceFactory implements Factory<WindowedLimitTimeService> {
    private final Provider<AlarmManager> alarmManagerProvider;
    private final Provider<Context> contextProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TimeService> timeServiceProvider;

    public ServiceModule_ProvideWindowedLimitTimerServiceFactory(Provider<Context> provider, Provider<StorageService> provider2, Provider<TimeService> provider3, Provider<AlarmManager> provider4) {
        this.contextProvider = provider;
        this.storageServiceProvider = provider2;
        this.timeServiceProvider = provider3;
        this.alarmManagerProvider = provider4;
    }

    public WindowedLimitTimeService get() {
        return provideWindowedLimitTimerService(this.contextProvider.get(), this.storageServiceProvider.get(), this.timeServiceProvider.get(), this.alarmManagerProvider.get());
    }

    public static ServiceModule_ProvideWindowedLimitTimerServiceFactory create(Provider<Context> provider, Provider<StorageService> provider2, Provider<TimeService> provider3, Provider<AlarmManager> provider4) {
        return new ServiceModule_ProvideWindowedLimitTimerServiceFactory(provider, provider2, provider3, provider4);
    }

    public static WindowedLimitTimeService provideWindowedLimitTimerService(Context context, StorageService storageService, TimeService timeService, AlarmManager alarmManager) {
        return (WindowedLimitTimeService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideWindowedLimitTimerService(context, storageService, timeService, alarmManager));
    }
}
