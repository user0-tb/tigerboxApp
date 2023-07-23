package media.tiger.tigerbox.p016ui.main.mediaplayer;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel_MembersInjector */
public final class MediaPlayerViewModel_MembersInjector implements MembersInjector<MediaPlayerViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public MediaPlayerViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<MediaPlayerViewModel> create(Provider<LightControlService> provider) {
        return new MediaPlayerViewModel_MembersInjector(provider);
    }

    public void injectMembers(MediaPlayerViewModel mediaPlayerViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(mediaPlayerViewModel, this._lightControlProvider.get());
    }
}
