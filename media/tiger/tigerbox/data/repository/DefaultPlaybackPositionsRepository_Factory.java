package media.tiger.tigerbox.data.repository;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;

public final class DefaultPlaybackPositionsRepository_Factory implements Factory<DefaultPlaybackPositionsRepository> {
    private final Provider<TigerBoxDatabase> tigerBoxDataBaseProvider;

    public DefaultPlaybackPositionsRepository_Factory(Provider<TigerBoxDatabase> provider) {
        this.tigerBoxDataBaseProvider = provider;
    }

    public DefaultPlaybackPositionsRepository get() {
        return newInstance(this.tigerBoxDataBaseProvider.get());
    }

    public static DefaultPlaybackPositionsRepository_Factory create(Provider<TigerBoxDatabase> provider) {
        return new DefaultPlaybackPositionsRepository_Factory(provider);
    }

    public static DefaultPlaybackPositionsRepository newInstance(TigerBoxDatabase tigerBoxDatabase) {
        return new DefaultPlaybackPositionsRepository(tigerBoxDatabase);
    }
}
