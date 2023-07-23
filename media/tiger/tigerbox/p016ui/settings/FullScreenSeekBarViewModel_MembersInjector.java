package media.tiger.tigerbox.p016ui.settings;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.FullScreenSeekBarViewModel_MembersInjector */
public final class FullScreenSeekBarViewModel_MembersInjector implements MembersInjector<FullScreenSeekBarViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public FullScreenSeekBarViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<FullScreenSeekBarViewModel> create(Provider<LightControlService> provider) {
        return new FullScreenSeekBarViewModel_MembersInjector(provider);
    }

    public void injectMembers(FullScreenSeekBarViewModel fullScreenSeekBarViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(fullScreenSeekBarViewModel, this._lightControlProvider.get());
    }
}
