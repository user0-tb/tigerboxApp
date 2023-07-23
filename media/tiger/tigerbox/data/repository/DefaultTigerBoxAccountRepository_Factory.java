package media.tiger.tigerbox.data.repository;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.DatabaseMigrationService;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.p016ui.onboarding.ReauthenticationLoginHandler;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;

public final class DefaultTigerBoxAccountRepository_Factory implements Factory<DefaultTigerBoxAccountRepository> {
    private final Provider<DatabaseMigrationService> databaseMigrationServiceProvider;
    private final Provider<ReauthenticationLoginHandler> reauthenticationLoginHandlerProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TigerBoxDatabase> tigerBoxDataBaseProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;
    private final Provider<TimeService> timeServiceProvider;

    public DefaultTigerBoxAccountRepository_Factory(Provider<DatabaseMigrationService> provider, Provider<TimeService> provider2, Provider<TigerBoxWebService> provider3, Provider<TigerBoxDatabase> provider4, Provider<StorageService> provider5, Provider<ReauthenticationLoginHandler> provider6) {
        this.databaseMigrationServiceProvider = provider;
        this.timeServiceProvider = provider2;
        this.tigerBoxWebServiceProvider = provider3;
        this.tigerBoxDataBaseProvider = provider4;
        this.storageServiceProvider = provider5;
        this.reauthenticationLoginHandlerProvider = provider6;
    }

    public DefaultTigerBoxAccountRepository get() {
        return newInstance(this.databaseMigrationServiceProvider.get(), this.timeServiceProvider.get(), this.tigerBoxWebServiceProvider.get(), this.tigerBoxDataBaseProvider.get(), this.storageServiceProvider.get(), this.reauthenticationLoginHandlerProvider.get());
    }

    public static DefaultTigerBoxAccountRepository_Factory create(Provider<DatabaseMigrationService> provider, Provider<TimeService> provider2, Provider<TigerBoxWebService> provider3, Provider<TigerBoxDatabase> provider4, Provider<StorageService> provider5, Provider<ReauthenticationLoginHandler> provider6) {
        return new DefaultTigerBoxAccountRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static DefaultTigerBoxAccountRepository newInstance(DatabaseMigrationService databaseMigrationService, TimeService timeService, TigerBoxWebService tigerBoxWebService, TigerBoxDatabase tigerBoxDatabase, StorageService storageService, ReauthenticationLoginHandler reauthenticationLoginHandler) {
        return new DefaultTigerBoxAccountRepository(databaseMigrationService, timeService, tigerBoxWebService, tigerBoxDatabase, storageService, reauthenticationLoginHandler);
    }
}
