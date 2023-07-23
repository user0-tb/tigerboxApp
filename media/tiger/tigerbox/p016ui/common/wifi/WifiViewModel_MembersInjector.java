package media.tiger.tigerbox.p016ui.common.wifi;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel_MembersInjector */
public final class WifiViewModel_MembersInjector implements MembersInjector<WifiViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public WifiViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<WifiViewModel> create(Provider<LightControlService> provider) {
        return new WifiViewModel_MembersInjector(provider);
    }

    public void injectMembers(WifiViewModel wifiViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(wifiViewModel, this._lightControlProvider.get());
    }
}
