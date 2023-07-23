package media.tiger.tigerbox.p016ui.settings;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewModel_MembersInjector */
public final class SettingsViewModel_MembersInjector implements MembersInjector<SettingsViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public SettingsViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<SettingsViewModel> create(Provider<LightControlService> provider) {
        return new SettingsViewModel_MembersInjector(provider);
    }

    public void injectMembers(SettingsViewModel settingsViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(settingsViewModel, this._lightControlProvider.get());
    }
}
