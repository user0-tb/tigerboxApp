package media.tiger.tigerbox.p016ui;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.TigerBoxActivityViewModel_MembersInjector */
public final class TigerBoxActivityViewModel_MembersInjector implements MembersInjector<TigerBoxActivityViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public TigerBoxActivityViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<TigerBoxActivityViewModel> create(Provider<LightControlService> provider) {
        return new TigerBoxActivityViewModel_MembersInjector(provider);
    }

    public void injectMembers(TigerBoxActivityViewModel tigerBoxActivityViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(tigerBoxActivityViewModel, this._lightControlProvider.get());
    }
}
