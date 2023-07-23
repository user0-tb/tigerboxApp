package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.data.repository.PlaybackTrackingRepository;

/* renamed from: media.tiger.tigerbox.infrastructure.di.StorageModule_ProvidePlaybackTrackingRepositoryFactory */
public final class StorageModule_ProvidePlaybackTrackingRepositoryFactory implements Factory<PlaybackTrackingRepository> {
    private final Provider<TigerBoxDatabase> tigerBoxDatabaseProvider;

    public StorageModule_ProvidePlaybackTrackingRepositoryFactory(Provider<TigerBoxDatabase> provider) {
        this.tigerBoxDatabaseProvider = provider;
    }

    public PlaybackTrackingRepository get() {
        return providePlaybackTrackingRepository(this.tigerBoxDatabaseProvider.get());
    }

    public static StorageModule_ProvidePlaybackTrackingRepositoryFactory create(Provider<TigerBoxDatabase> provider) {
        return new StorageModule_ProvidePlaybackTrackingRepositoryFactory(provider);
    }

    public static PlaybackTrackingRepository providePlaybackTrackingRepository(TigerBoxDatabase tigerBoxDatabase) {
        return (PlaybackTrackingRepository) Preconditions.checkNotNullFromProvides(StorageModule.INSTANCE.providePlaybackTrackingRepository(tigerBoxDatabase));
    }
}
