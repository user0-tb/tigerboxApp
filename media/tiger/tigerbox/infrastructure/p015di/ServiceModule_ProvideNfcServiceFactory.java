package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.NfcService;
import media.tiger.tigerbox.services.interfaces.timersController.LockedModeService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideNfcServiceFactory */
public final class ServiceModule_ProvideNfcServiceFactory implements Factory<NfcService> {
    private final Provider<LockedModeService> lockedModeServiceProvider;

    public ServiceModule_ProvideNfcServiceFactory(Provider<LockedModeService> provider) {
        this.lockedModeServiceProvider = provider;
    }

    public NfcService get() {
        return provideNfcService(this.lockedModeServiceProvider.get());
    }

    public static ServiceModule_ProvideNfcServiceFactory create(Provider<LockedModeService> provider) {
        return new ServiceModule_ProvideNfcServiceFactory(provider);
    }

    public static NfcService provideNfcService(LockedModeService lockedModeService) {
        return (NfcService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideNfcService(lockedModeService));
    }
}
