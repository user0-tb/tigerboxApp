package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.services.implementations.HeadsetService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideHeadsetServiceFactory */
public final class ServiceModule_ProvideHeadsetServiceFactory implements Factory<HeadsetService> {
    public HeadsetService get() {
        return provideHeadsetService();
    }

    public static ServiceModule_ProvideHeadsetServiceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static HeadsetService provideHeadsetService() {
        return (HeadsetService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideHeadsetService());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideHeadsetServiceFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ServiceModule_ProvideHeadsetServiceFactory INSTANCE = new ServiceModule_ProvideHeadsetServiceFactory();

        private InstanceHolder() {
        }
    }
}
