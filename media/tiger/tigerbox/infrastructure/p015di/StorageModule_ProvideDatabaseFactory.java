package media.tiger.tigerbox.infrastructure.p015di;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.services.interfaces.StorageService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.StorageModule_ProvideDatabaseFactory */
public final class StorageModule_ProvideDatabaseFactory implements Factory<TigerBoxDatabase> {
    private final Provider<Application> appProvider;
    private final Provider<StorageService> storageServiceProvider;

    public StorageModule_ProvideDatabaseFactory(Provider<Application> provider, Provider<StorageService> provider2) {
        this.appProvider = provider;
        this.storageServiceProvider = provider2;
    }

    public TigerBoxDatabase get() {
        return provideDatabase(this.appProvider.get(), this.storageServiceProvider.get());
    }

    public static StorageModule_ProvideDatabaseFactory create(Provider<Application> provider, Provider<StorageService> provider2) {
        return new StorageModule_ProvideDatabaseFactory(provider, provider2);
    }

    public static TigerBoxDatabase provideDatabase(Application application, StorageService storageService) {
        return (TigerBoxDatabase) Preconditions.checkNotNullFromProvides(StorageModule.INSTANCE.provideDatabase(application, storageService));
    }
}
