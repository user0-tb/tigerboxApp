package media.tiger.tigerbox.p016ui.main.mediaplayer;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;

/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel_Factory */
public final class MediaPlayerViewModel_Factory implements Factory<MediaPlayerViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<HeaderProvider> headerProvider;
    private final Provider<LightControlService> lightControlProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;

    public MediaPlayerViewModel_Factory(Provider<AudioPlayerService> provider, Provider<AvailabilityService> provider2, Provider<MetaDataService> provider3, Provider<LightControlService> provider4, Provider<ButtonService> provider5, Provider<HeaderProvider> provider6, Provider<LightControlService> provider7) {
        this.audioPlayerServiceProvider = provider;
        this.availabilityServiceProvider = provider2;
        this.metaDataServiceProvider = provider3;
        this.lightControlProvider = provider4;
        this.buttonServiceProvider = provider5;
        this.headerProvider = provider6;
        this._lightControlProvider = provider7;
    }

    public MediaPlayerViewModel get() {
        MediaPlayerViewModel newInstance = newInstance(this.audioPlayerServiceProvider.get(), this.availabilityServiceProvider.get(), this.metaDataServiceProvider.get(), this.lightControlProvider.get(), this.buttonServiceProvider.get(), this.headerProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static MediaPlayerViewModel_Factory create(Provider<AudioPlayerService> provider, Provider<AvailabilityService> provider2, Provider<MetaDataService> provider3, Provider<LightControlService> provider4, Provider<ButtonService> provider5, Provider<HeaderProvider> provider6, Provider<LightControlService> provider7) {
        return new MediaPlayerViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static MediaPlayerViewModel newInstance(AudioPlayerService audioPlayerService, AvailabilityService availabilityService, MetaDataService metaDataService, LightControlService lightControlService, ButtonService buttonService, HeaderProvider headerProvider2) {
        return new MediaPlayerViewModel(audioPlayerService, availabilityService, metaDataService, lightControlService, buttonService, headerProvider2);
    }
}
