package media.tiger.tigerbox.infrastructure.p015di;

import android.app.AlarmManager;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.timersController.TimeLimitTimerService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideTimeLimitTimerServiceFactory */
public final class ServiceModule_ProvideTimeLimitTimerServiceFactory implements Factory<TimeLimitTimerService> {
    private final Provider<AlarmManager> alarmManagerProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<Context> contextProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TimeService> timeServiceProvider;

    public ServiceModule_ProvideTimeLimitTimerServiceFactory(Provider<Context> provider, Provider<StorageService> provider2, Provider<TimeService> provider3, Provider<AlarmManager> provider4, Provider<ConfigurationProperties> provider5) {
        this.contextProvider = provider;
        this.storageServiceProvider = provider2;
        this.timeServiceProvider = provider3;
        this.alarmManagerProvider = provider4;
        this.configurationPropertiesProvider = provider5;
    }

    public TimeLimitTimerService get() {
        return provideTimeLimitTimerService(this.contextProvider.get(), this.storageServiceProvider.get(), this.timeServiceProvider.get(), this.alarmManagerProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static ServiceModule_ProvideTimeLimitTimerServiceFactory create(Provider<Context> provider, Provider<StorageService> provider2, Provider<TimeService> provider3, Provider<AlarmManager> provider4, Provider<ConfigurationProperties> provider5) {
        return new ServiceModule_ProvideTimeLimitTimerServiceFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static TimeLimitTimerService provideTimeLimitTimerService(Context context, StorageService storageService, TimeService timeService, AlarmManager alarmManager, ConfigurationProperties configurationProperties) {
        return (TimeLimitTimerService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideTimeLimitTimerService(context, storageService, timeService, alarmManager, configurationProperties));
    }
}
