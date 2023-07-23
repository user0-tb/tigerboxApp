package media.tiger.tigerbox.p016ui.main.offlinemode;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.main.offlinemode.OfflineModeViewModel_MembersInjector */
public final class OfflineModeViewModel_MembersInjector implements MembersInjector<OfflineModeViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public OfflineModeViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<OfflineModeViewModel> create(Provider<LightControlService> provider) {
        return new OfflineModeViewModel_MembersInjector(provider);
    }

    public void injectMembers(OfflineModeViewModel offlineModeViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(offlineModeViewModel, this._lightControlProvider.get());
    }
}
