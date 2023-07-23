package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.PlaybackTrackingRepository;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.PlaybackTrackingService;
import media.tiger.tigerbox.usecase.PostTrackingEventUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvidePlaybackTrackingServiceFactory */
public final class ServiceModule_ProvidePlaybackTrackingServiceFactory implements Factory<PlaybackTrackingService> {
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<GetTigerBoxAccountUseCase> getTigerBoxAccountUseCaseProvider;
    private final Provider<PlaybackTrackingRepository> playbackTrackingRepositoryProvider;
    private final Provider<PostTrackingEventUseCase> postTrackingEventUseCaseProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public ServiceModule_ProvidePlaybackTrackingServiceFactory(Provider<AudioPlayerService> provider, Provider<PlaybackTrackingRepository> provider2, Provider<WifiService> provider3, Provider<StorageService> provider4, Provider<PostTrackingEventUseCase> provider5, Provider<GetTigerBoxAccountUseCase> provider6) {
        this.audioPlayerServiceProvider = provider;
        this.playbackTrackingRepositoryProvider = provider2;
        this.wifiServiceProvider = provider3;
        this.storageServiceProvider = provider4;
        this.postTrackingEventUseCaseProvider = provider5;
        this.getTigerBoxAccountUseCaseProvider = provider6;
    }

    public PlaybackTrackingService get() {
        return providePlaybackTrackingService(this.audioPlayerServiceProvider.get(), this.playbackTrackingRepositoryProvider.get(), this.wifiServiceProvider.get(), this.storageServiceProvider.get(), this.postTrackingEventUseCaseProvider.get(), this.getTigerBoxAccountUseCaseProvider.get());
    }

    public static ServiceModule_ProvidePlaybackTrackingServiceFactory create(Provider<AudioPlayerService> provider, Provider<PlaybackTrackingRepository> provider2, Provider<WifiService> provider3, Provider<StorageService> provider4, Provider<PostTrackingEventUseCase> provider5, Provider<GetTigerBoxAccountUseCase> provider6) {
        return new ServiceModule_ProvidePlaybackTrackingServiceFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PlaybackTrackingService providePlaybackTrackingService(AudioPlayerService audioPlayerService, PlaybackTrackingRepository playbackTrackingRepository, WifiService wifiService, StorageService storageService, PostTrackingEventUseCase postTrackingEventUseCase, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase) {
        return (PlaybackTrackingService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.providePlaybackTrackingService(audioPlayerService, playbackTrackingRepository, wifiService, storageService, postTrackingEventUseCase, getTigerBoxAccountUseCase));
    }
}
