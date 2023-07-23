package media.tiger.tigerbox.infrastructure.p015di;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.data.repository.HlsKeysRepository;

/* renamed from: media.tiger.tigerbox.infrastructure.di.StorageModule_ProvideHlsKeysRepositoryFactory */
public final class StorageModule_ProvideHlsKeysRepositoryFactory implements Factory<HlsKeysRepository> {
    private final Provider<SharedPreferences> encryptedSharedPreferencesProvider;
    private final Provider<TigerBoxDatabase> tigerBoxDatabaseProvider;

    public StorageModule_ProvideHlsKeysRepositoryFactory(Provider<TigerBoxDatabase> provider, Provider<SharedPreferences> provider2) {
        this.tigerBoxDatabaseProvider = provider;
        this.encryptedSharedPreferencesProvider = provider2;
    }

    public HlsKeysRepository get() {
        return provideHlsKeysRepository(this.tigerBoxDatabaseProvider.get(), this.encryptedSharedPreferencesProvider.get());
    }

    public static StorageModule_ProvideHlsKeysRepositoryFactory create(Provider<TigerBoxDatabase> provider, Provider<SharedPreferences> provider2) {
        return new StorageModule_ProvideHlsKeysRepositoryFactory(provider, provider2);
    }

    public static HlsKeysRepository provideHlsKeysRepository(TigerBoxDatabase tigerBoxDatabase, SharedPreferences sharedPreferences) {
        return (HlsKeysRepository) Preconditions.checkNotNullFromProvides(StorageModule.INSTANCE.provideHlsKeysRepository(tigerBoxDatabase, sharedPreferences));
    }
}
