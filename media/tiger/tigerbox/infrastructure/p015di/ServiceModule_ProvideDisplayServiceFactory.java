package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.services.implementations.DisplayService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideDisplayServiceFactory */
public final class ServiceModule_ProvideDisplayServiceFactory implements Factory<DisplayService> {
    public DisplayService get() {
        return provideDisplayService();
    }

    public static ServiceModule_ProvideDisplayServiceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DisplayService provideDisplayService() {
        return (DisplayService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideDisplayService());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideDisplayServiceFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ServiceModule_ProvideDisplayServiceFactory INSTANCE = new ServiceModule_ProvideDisplayServiceFactory();

        private InstanceHolder() {
        }
    }
}
