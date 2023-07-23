package media.tiger.tigerbox.data.repository;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;

public final class DefaultPlaybackTrackingRepository_Factory implements Factory<DefaultPlaybackTrackingRepository> {
    private final Provider<TigerBoxDatabase> tigerBoxDataBaseProvider;

    public DefaultPlaybackTrackingRepository_Factory(Provider<TigerBoxDatabase> provider) {
        this.tigerBoxDataBaseProvider = provider;
    }

    public DefaultPlaybackTrackingRepository get() {
        return newInstance(this.tigerBoxDataBaseProvider.get());
    }

    public static DefaultPlaybackTrackingRepository_Factory create(Provider<TigerBoxDatabase> provider) {
        return new DefaultPlaybackTrackingRepository_Factory(provider);
    }

    public static DefaultPlaybackTrackingRepository newInstance(TigerBoxDatabase tigerBoxDatabase) {
        return new DefaultPlaybackTrackingRepository(tigerBoxDatabase);
    }
}
