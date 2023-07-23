package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.DatabaseMigrationService;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.data.repository.AccessTokenRepository;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.TimeService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.StorageModule_ProvideAccessTokenRepositoryFactory */
public final class StorageModule_ProvideAccessTokenRepositoryFactory implements Factory<AccessTokenRepository> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<DatabaseMigrationService> databaseMigrationServiceProvider;
    private final Provider<TigerBoxDatabase> tigerBoxDatabaseProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;
    private final Provider<TimeService> timeServiceProvider;

    public StorageModule_ProvideAccessTokenRepositoryFactory(Provider<DatabaseMigrationService> provider, Provider<TimeService> provider2, Provider<TigerBoxWebService> provider3, Provider<TigerBoxDatabase> provider4, Provider<ConfigurationProperties> provider5) {
        this.databaseMigrationServiceProvider = provider;
        this.timeServiceProvider = provider2;
        this.tigerBoxWebServiceProvider = provider3;
        this.tigerBoxDatabaseProvider = provider4;
        this.configurationPropertiesProvider = provider5;
    }

    public AccessTokenRepository get() {
        return provideAccessTokenRepository(this.databaseMigrationServiceProvider.get(), this.timeServiceProvider.get(), this.tigerBoxWebServiceProvider.get(), this.tigerBoxDatabaseProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static StorageModule_ProvideAccessTokenRepositoryFactory create(Provider<DatabaseMigrationService> provider, Provider<TimeService> provider2, Provider<TigerBoxWebService> provider3, Provider<TigerBoxDatabase> provider4, Provider<ConfigurationProperties> provider5) {
        return new StorageModule_ProvideAccessTokenRepositoryFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static AccessTokenRepository provideAccessTokenRepository(DatabaseMigrationService databaseMigrationService, TimeService timeService, TigerBoxWebService tigerBoxWebService, TigerBoxDatabase tigerBoxDatabase, ConfigurationProperties configurationProperties) {
        return (AccessTokenRepository) Preconditions.checkNotNullFromProvides(StorageModule.INSTANCE.provideAccessTokenRepository(databaseMigrationService, timeService, tigerBoxWebService, tigerBoxDatabase, configurationProperties));
    }
}
