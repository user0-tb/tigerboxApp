package media.tiger.tigerbox.p016ui.settings.systeminfo;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel_MembersInjector */
public final class SystemInfoViewModel_MembersInjector implements MembersInjector<SystemInfoViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public SystemInfoViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<SystemInfoViewModel> create(Provider<LightControlService> provider) {
        return new SystemInfoViewModel_MembersInjector(provider);
    }

    public void injectMembers(SystemInfoViewModel systemInfoViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(systemInfoViewModel, this._lightControlProvider.get());
    }
}
