package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.PlaybackPositionsRepository;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.PlaybackPositionService;
import media.tiger.tigerbox.usecase.GetPlayStatesUseCase;
import media.tiger.tigerbox.usecase.PostPlayStateUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvidePlaybackPositionServiceFactory */
public final class ServiceModule_ProvidePlaybackPositionServiceFactory implements Factory<PlaybackPositionService> {
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<GetPlayStatesUseCase> getPlayStatesUseCaseProvider;
    private final Provider<GetTigerBoxAccountUseCase> getTigerBoxAccountUseCaseProvider;
    private final Provider<PlaybackPositionsRepository> playbackPositionsRepositoryProvider;
    private final Provider<PostPlayStateUseCase> postPlayStateUseCaseProvider;

    public ServiceModule_ProvidePlaybackPositionServiceFactory(Provider<AudioPlayerService> provider, Provider<PlaybackPositionsRepository> provider2, Provider<GetPlayStatesUseCase> provider3, Provider<PostPlayStateUseCase> provider4, Provider<GetTigerBoxAccountUseCase> provider5) {
        this.audioPlayerServiceProvider = provider;
        this.playbackPositionsRepositoryProvider = provider2;
        this.getPlayStatesUseCaseProvider = provider3;
        this.postPlayStateUseCaseProvider = provider4;
        this.getTigerBoxAccountUseCaseProvider = provider5;
    }

    public PlaybackPositionService get() {
        return providePlaybackPositionService(this.audioPlayerServiceProvider.get(), this.playbackPositionsRepositoryProvider.get(), this.getPlayStatesUseCaseProvider.get(), this.postPlayStateUseCaseProvider.get(), this.getTigerBoxAccountUseCaseProvider.get());
    }

    public static ServiceModule_ProvidePlaybackPositionServiceFactory create(Provider<AudioPlayerService> provider, Provider<PlaybackPositionsRepository> provider2, Provider<GetPlayStatesUseCase> provider3, Provider<PostPlayStateUseCase> provider4, Provider<GetTigerBoxAccountUseCase> provider5) {
        return new ServiceModule_ProvidePlaybackPositionServiceFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static PlaybackPositionService providePlaybackPositionService(AudioPlayerService audioPlayerService, PlaybackPositionsRepository playbackPositionsRepository, GetPlayStatesUseCase getPlayStatesUseCase, PostPlayStateUseCase postPlayStateUseCase, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase) {
        return (PlaybackPositionService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.providePlaybackPositionService(audioPlayerService, playbackPositionsRepository, getPlayStatesUseCase, postPlayStateUseCase, getTigerBoxAccountUseCase));
    }
}
