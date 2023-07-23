package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.StorageService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideInfoSoundServiceFactory */
public final class ServiceModule_ProvideInfoSoundServiceFactory implements Factory<InfoSoundService> {
    private final Provider<Context> contextProvider;
    private final Provider<StorageService> storageServiceProvider;

    public ServiceModule_ProvideInfoSoundServiceFactory(Provider<Context> provider, Provider<StorageService> provider2) {
        this.contextProvider = provider;
        this.storageServiceProvider = provider2;
    }

    public InfoSoundService get() {
        return provideInfoSoundService(this.contextProvider.get(), this.storageServiceProvider.get());
    }

    public static ServiceModule_ProvideInfoSoundServiceFactory create(Provider<Context> provider, Provider<StorageService> provider2) {
        return new ServiceModule_ProvideInfoSoundServiceFactory(provider, provider2);
    }

    public static InfoSoundService provideInfoSoundService(Context context, StorageService storageService) {
        return (InfoSoundService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideInfoSoundService(context, storageService));
    }
}
