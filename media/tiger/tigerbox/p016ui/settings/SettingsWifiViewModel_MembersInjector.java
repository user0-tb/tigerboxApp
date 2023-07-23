package media.tiger.tigerbox.p016ui.settings;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsWifiViewModel_MembersInjector */
public final class SettingsWifiViewModel_MembersInjector implements MembersInjector<SettingsWifiViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public SettingsWifiViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<SettingsWifiViewModel> create(Provider<LightControlService> provider) {
        return new SettingsWifiViewModel_MembersInjector(provider);
    }

    public void injectMembers(SettingsWifiViewModel settingsWifiViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(settingsWifiViewModel, this._lightControlProvider.get());
    }
}
