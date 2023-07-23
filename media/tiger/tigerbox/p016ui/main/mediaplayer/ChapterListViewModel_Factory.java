package media.tiger.tigerbox.p016ui.main.mediaplayer;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;

/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.ChapterListViewModel_Factory */
public final class ChapterListViewModel_Factory implements Factory<ChapterListViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<HeaderProvider> headerProvider;
    private final Provider<StorageService> storageServiceProvider;

    public ChapterListViewModel_Factory(Provider<AudioPlayerService> provider, Provider<StorageService> provider2, Provider<ButtonService> provider3, Provider<HeaderProvider> provider4, Provider<LightControlService> provider5) {
        this.audioPlayerServiceProvider = provider;
        this.storageServiceProvider = provider2;
        this.buttonServiceProvider = provider3;
        this.headerProvider = provider4;
        this._lightControlProvider = provider5;
    }

    public ChapterListViewModel get() {
        ChapterListViewModel newInstance = newInstance(this.audioPlayerServiceProvider.get(), this.storageServiceProvider.get(), this.buttonServiceProvider.get(), this.headerProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static ChapterListViewModel_Factory create(Provider<AudioPlayerService> provider, Provider<StorageService> provider2, Provider<ButtonService> provider3, Provider<HeaderProvider> provider4, Provider<LightControlService> provider5) {
        return new ChapterListViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ChapterListViewModel newInstance(AudioPlayerService audioPlayerService, StorageService storageService, ButtonService buttonService, HeaderProvider headerProvider2) {
        return new ChapterListViewModel(audioPlayerService, storageService, buttonService, headerProvider2);
    }
}
