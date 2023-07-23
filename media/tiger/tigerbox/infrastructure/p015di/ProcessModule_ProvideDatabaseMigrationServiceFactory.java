package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.DatabaseMigrationService;
import media.tiger.tigerbox.services.interfaces.DataMigrationService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule_ProvideDatabaseMigrationServiceFactory */
public final class ProcessModule_ProvideDatabaseMigrationServiceFactory implements Factory<DatabaseMigrationService> {
    private final Provider<DataMigrationService> dataMigrationServiceProvider;

    public ProcessModule_ProvideDatabaseMigrationServiceFactory(Provider<DataMigrationService> provider) {
        this.dataMigrationServiceProvider = provider;
    }

    public DatabaseMigrationService get() {
        return provideDatabaseMigrationService(this.dataMigrationServiceProvider.get());
    }

    public static ProcessModule_ProvideDatabaseMigrationServiceFactory create(Provider<DataMigrationService> provider) {
        return new ProcessModule_ProvideDatabaseMigrationServiceFactory(provider);
    }

    public static DatabaseMigrationService provideDatabaseMigrationService(DataMigrationService dataMigrationService) {
        return (DatabaseMigrationService) Preconditions.checkNotNullFromProvides(ProcessModule.INSTANCE.provideDatabaseMigrationService(dataMigrationService));
    }
}
