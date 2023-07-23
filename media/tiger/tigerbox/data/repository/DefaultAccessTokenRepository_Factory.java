package media.tiger.tigerbox.data.repository;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.DatabaseMigrationService;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.TimeService;

public final class DefaultAccessTokenRepository_Factory implements Factory<DefaultAccessTokenRepository> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<DatabaseMigrationService> databaseMigrationServiceProvider;
    private final Provider<TigerBoxDatabase> tigerBoxDataBaseProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;
    private final Provider<TimeService> timeServiceProvider;

    public DefaultAccessTokenRepository_Factory(Provider<DatabaseMigrationService> provider, Provider<TimeService> provider2, Provider<TigerBoxWebService> provider3, Provider<TigerBoxDatabase> provider4, Provider<ConfigurationProperties> provider5) {
        this.databaseMigrationServiceProvider = provider;
        this.timeServiceProvider = provider2;
        this.tigerBoxWebServiceProvider = provider3;
        this.tigerBoxDataBaseProvider = provider4;
        this.configurationPropertiesProvider = provider5;
    }

    public DefaultAccessTokenRepository get() {
        return newInstance(this.databaseMigrationServiceProvider.get(), this.timeServiceProvider.get(), this.tigerBoxWebServiceProvider.get(), this.tigerBoxDataBaseProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static DefaultAccessTokenRepository_Factory create(Provider<DatabaseMigrationService> provider, Provider<TimeService> provider2, Provider<TigerBoxWebService> provider3, Provider<TigerBoxDatabase> provider4, Provider<ConfigurationProperties> provider5) {
        return new DefaultAccessTokenRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DefaultAccessTokenRepository newInstance(DatabaseMigrationService databaseMigrationService, TimeService timeService, TigerBoxWebService tigerBoxWebService, TigerBoxDatabase tigerBoxDatabase, ConfigurationProperties configurationProperties) {
        return new DefaultAccessTokenRepository(databaseMigrationService, timeService, tigerBoxWebService, tigerBoxDatabase, configurationProperties);
    }
}
