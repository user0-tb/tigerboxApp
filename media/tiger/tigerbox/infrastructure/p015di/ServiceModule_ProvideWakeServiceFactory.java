package media.tiger.tigerbox.infrastructure.p015di;

import android.os.PowerManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.WakeService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideWakeServiceFactory */
public final class ServiceModule_ProvideWakeServiceFactory implements Factory<WakeService> {
    private final Provider<PowerManager> powerManagerProvider;

    public ServiceModule_ProvideWakeServiceFactory(Provider<PowerManager> provider) {
        this.powerManagerProvider = provider;
    }

    public WakeService get() {
        return provideWakeService(this.powerManagerProvider.get());
    }

    public static ServiceModule_ProvideWakeServiceFactory create(Provider<PowerManager> provider) {
        return new ServiceModule_ProvideWakeServiceFactory(provider);
    }

    public static WakeService provideWakeService(PowerManager powerManager) {
        return (WakeService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideWakeService(powerManager));
    }
}
