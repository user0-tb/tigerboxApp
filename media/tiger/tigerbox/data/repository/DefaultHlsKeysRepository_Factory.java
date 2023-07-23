package media.tiger.tigerbox.data.repository;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;

public final class DefaultHlsKeysRepository_Factory implements Factory<DefaultHlsKeysRepository> {
    private final Provider<SharedPreferences> encryptedSharedPreferencesProvider;
    private final Provider<TigerBoxDatabase> tigerBoxDataBaseProvider;

    public DefaultHlsKeysRepository_Factory(Provider<TigerBoxDatabase> provider, Provider<SharedPreferences> provider2) {
        this.tigerBoxDataBaseProvider = provider;
        this.encryptedSharedPreferencesProvider = provider2;
    }

    public DefaultHlsKeysRepository get() {
        return newInstance(this.tigerBoxDataBaseProvider.get(), this.encryptedSharedPreferencesProvider.get());
    }

    public static DefaultHlsKeysRepository_Factory create(Provider<TigerBoxDatabase> provider, Provider<SharedPreferences> provider2) {
        return new DefaultHlsKeysRepository_Factory(provider, provider2);
    }

    public static DefaultHlsKeysRepository newInstance(TigerBoxDatabase tigerBoxDatabase, SharedPreferences sharedPreferences) {
        return new DefaultHlsKeysRepository(tigerBoxDatabase, sharedPreferences);
    }
}
