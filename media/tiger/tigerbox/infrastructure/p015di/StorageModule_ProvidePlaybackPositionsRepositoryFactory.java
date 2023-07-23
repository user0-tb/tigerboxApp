package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.data.repository.PlaybackPositionsRepository;

/* renamed from: media.tiger.tigerbox.infrastructure.di.StorageModule_ProvidePlaybackPositionsRepositoryFactory */
public final class StorageModule_ProvidePlaybackPositionsRepositoryFactory implements Factory<PlaybackPositionsRepository> {
    private final Provider<TigerBoxDatabase> tigerBoxDatabaseProvider;

    public StorageModule_ProvidePlaybackPositionsRepositoryFactory(Provider<TigerBoxDatabase> provider) {
        this.tigerBoxDatabaseProvider = provider;
    }

    public PlaybackPositionsRepository get() {
        return providePlaybackPositionsRepository(this.tigerBoxDatabaseProvider.get());
    }

    public static StorageModule_ProvidePlaybackPositionsRepositoryFactory create(Provider<TigerBoxDatabase> provider) {
        return new StorageModule_ProvidePlaybackPositionsRepositoryFactory(provider);
    }

    public static PlaybackPositionsRepository providePlaybackPositionsRepository(TigerBoxDatabase tigerBoxDatabase) {
        return (PlaybackPositionsRepository) Preconditions.checkNotNullFromProvides(StorageModule.INSTANCE.providePlaybackPositionsRepository(tigerBoxDatabase));
    }
}
