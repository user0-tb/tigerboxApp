package media.tiger.tigerbox.p016ui.common.wifi;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordViewModel_MembersInjector */
public final class WifiEnterPasswordViewModel_MembersInjector implements MembersInjector<WifiEnterPasswordViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public WifiEnterPasswordViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<WifiEnterPasswordViewModel> create(Provider<LightControlService> provider) {
        return new WifiEnterPasswordViewModel_MembersInjector(provider);
    }

    public void injectMembers(WifiEnterPasswordViewModel wifiEnterPasswordViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(wifiEnterPasswordViewModel, this._lightControlProvider.get());
    }
}
