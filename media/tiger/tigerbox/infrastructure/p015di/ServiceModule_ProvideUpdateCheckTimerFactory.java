package media.tiger.tigerbox.infrastructure.p015di;

import android.app.AlarmManager;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.UpdateCheckTimerService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideUpdateCheckTimerFactory */
public final class ServiceModule_ProvideUpdateCheckTimerFactory implements Factory<UpdateCheckTimerService> {
    private final Provider<AlarmManager> alarmManagerProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<Context> contextProvider;
    private final Provider<FirmwareUpdateService> firmwareUpdateServiceProvider;
    private final Provider<TimeService> timeServiceProvider;

    public ServiceModule_ProvideUpdateCheckTimerFactory(Provider<Context> provider, Provider<TimeService> provider2, Provider<AlarmManager> provider3, Provider<FirmwareUpdateService> provider4, Provider<ConfigurationProperties> provider5) {
        this.contextProvider = provider;
        this.timeServiceProvider = provider2;
        this.alarmManagerProvider = provider3;
        this.firmwareUpdateServiceProvider = provider4;
        this.configurationPropertiesProvider = provider5;
    }

    public UpdateCheckTimerService get() {
        return provideUpdateCheckTimer(this.contextProvider.get(), this.timeServiceProvider.get(), this.alarmManagerProvider.get(), this.firmwareUpdateServiceProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static ServiceModule_ProvideUpdateCheckTimerFactory create(Provider<Context> provider, Provider<TimeService> provider2, Provider<AlarmManager> provider3, Provider<FirmwareUpdateService> provider4, Provider<ConfigurationProperties> provider5) {
        return new ServiceModule_ProvideUpdateCheckTimerFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static UpdateCheckTimerService provideUpdateCheckTimer(Context context, TimeService timeService, AlarmManager alarmManager, FirmwareUpdateService firmwareUpdateService, ConfigurationProperties configurationProperties) {
        return (UpdateCheckTimerService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideUpdateCheckTimer(context, timeService, alarmManager, firmwareUpdateService, configurationProperties));
    }
}
