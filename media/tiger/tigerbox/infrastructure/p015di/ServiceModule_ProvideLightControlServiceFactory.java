package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideLightControlServiceFactory */
public final class ServiceModule_ProvideLightControlServiceFactory implements Factory<LightControlService> {
    private final Provider<StorageService> storageServiceProvider;

    public ServiceModule_ProvideLightControlServiceFactory(Provider<StorageService> provider) {
        this.storageServiceProvider = provider;
    }

    public LightControlService get() {
        return provideLightControlService(this.storageServiceProvider.get());
    }

    public static ServiceModule_ProvideLightControlServiceFactory create(Provider<StorageService> provider) {
        return new ServiceModule_ProvideLightControlServiceFactory(provider);
    }

    public static LightControlService provideLightControlService(StorageService storageService) {
        return (LightControlService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideLightControlService(storageService));
    }
}
