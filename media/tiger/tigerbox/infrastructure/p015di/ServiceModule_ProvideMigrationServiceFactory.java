package media.tiger.tigerbox.infrastructure.p015di;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.services.interfaces.DataMigrationService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideMigrationServiceFactory */
public final class ServiceModule_ProvideMigrationServiceFactory implements Factory<DataMigrationService> {
    private final Provider<SharedPreferences> encryptedSharedPreferencesProvider;
    private final Provider<TigerBoxDatabase> tigerBoxDatabaseProvider;

    public ServiceModule_ProvideMigrationServiceFactory(Provider<SharedPreferences> provider, Provider<TigerBoxDatabase> provider2) {
        this.encryptedSharedPreferencesProvider = provider;
        this.tigerBoxDatabaseProvider = provider2;
    }

    public DataMigrationService get() {
        return provideMigrationService(this.encryptedSharedPreferencesProvider.get(), this.tigerBoxDatabaseProvider.get());
    }

    public static ServiceModule_ProvideMigrationServiceFactory create(Provider<SharedPreferences> provider, Provider<TigerBoxDatabase> provider2) {
        return new ServiceModule_ProvideMigrationServiceFactory(provider, provider2);
    }

    public static DataMigrationService provideMigrationService(SharedPreferences sharedPreferences, TigerBoxDatabase tigerBoxDatabase) {
        return (DataMigrationService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideMigrationService(sharedPreferences, tigerBoxDatabase));
    }
}
