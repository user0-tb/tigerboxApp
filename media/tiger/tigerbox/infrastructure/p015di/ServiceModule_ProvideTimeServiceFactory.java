package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.services.interfaces.TimeService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideTimeServiceFactory */
public final class ServiceModule_ProvideTimeServiceFactory implements Factory<TimeService> {
    public TimeService get() {
        return provideTimeService();
    }

    public static ServiceModule_ProvideTimeServiceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TimeService provideTimeService() {
        return (TimeService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideTimeService());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideTimeServiceFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ServiceModule_ProvideTimeServiceFactory INSTANCE = new ServiceModule_ProvideTimeServiceFactory();

        private InstanceHolder() {
        }
    }
}
