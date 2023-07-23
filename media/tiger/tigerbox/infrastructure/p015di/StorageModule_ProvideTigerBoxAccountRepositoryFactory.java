package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.DatabaseMigrationService;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.p016ui.onboarding.ReauthenticationLoginHandler;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.StorageModule_ProvideTigerBoxAccountRepositoryFactory */
public final class StorageModule_ProvideTigerBoxAccountRepositoryFactory implements Factory<TigerBoxAccountRepository> {
    private final Provider<DatabaseMigrationService> databaseMigrationServiceProvider;
    private final Provider<ReauthenticationLoginHandler> loginHandlerProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TigerBoxDatabase> tigerBoxDatabaseProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;
    private final Provider<TimeService> timeServiceProvider;

    public StorageModule_ProvideTigerBoxAccountRepositoryFactory(Provider<DatabaseMigrationService> provider, Provider<TimeService> provider2, Provider<TigerBoxWebService> provider3, Provider<TigerBoxDatabase> provider4, Provider<StorageService> provider5, Provider<ReauthenticationLoginHandler> provider6) {
        this.databaseMigrationServiceProvider = provider;
        this.timeServiceProvider = provider2;
        this.tigerBoxWebServiceProvider = provider3;
        this.tigerBoxDatabaseProvider = provider4;
        this.storageServiceProvider = provider5;
        this.loginHandlerProvider = provider6;
    }

    public TigerBoxAccountRepository get() {
        return provideTigerBoxAccountRepository(this.databaseMigrationServiceProvider.get(), this.timeServiceProvider.get(), this.tigerBoxWebServiceProvider.get(), this.tigerBoxDatabaseProvider.get(), this.storageServiceProvider.get(), this.loginHandlerProvider.get());
    }

    public static StorageModule_ProvideTigerBoxAccountRepositoryFactory create(Provider<DatabaseMigrationService> provider, Provider<TimeService> provider2, Provider<TigerBoxWebService> provider3, Provider<TigerBoxDatabase> provider4, Provider<StorageService> provider5, Provider<ReauthenticationLoginHandler> provider6) {
        return new StorageModule_ProvideTigerBoxAccountRepositoryFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static TigerBoxAccountRepository provideTigerBoxAccountRepository(DatabaseMigrationService databaseMigrationService, TimeService timeService, TigerBoxWebService tigerBoxWebService, TigerBoxDatabase tigerBoxDatabase, StorageService storageService, ReauthenticationLoginHandler reauthenticationLoginHandler) {
        return (TigerBoxAccountRepository) Preconditions.checkNotNullFromProvides(StorageModule.INSTANCE.provideTigerBoxAccountRepository(databaseMigrationService, timeService, tigerBoxWebService, tigerBoxDatabase, storageService, reauthenticationLoginHandler));
    }
}
