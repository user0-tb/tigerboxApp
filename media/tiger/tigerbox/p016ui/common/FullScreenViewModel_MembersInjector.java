package media.tiger.tigerbox.p016ui.common;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.common.FullScreenViewModel_MembersInjector */
public final class FullScreenViewModel_MembersInjector implements MembersInjector<FullScreenViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public FullScreenViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<FullScreenViewModel> create(Provider<LightControlService> provider) {
        return new FullScreenViewModel_MembersInjector(provider);
    }

    public void injectMembers(FullScreenViewModel fullScreenViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(fullScreenViewModel, this._lightControlProvider.get());
    }
}
