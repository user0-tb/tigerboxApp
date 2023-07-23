package media.tiger.tigerbox.p016ui.settings.timersSetup;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupViewModel_MembersInjector */
public final class TimersSetupWindowSetupViewModel_MembersInjector implements MembersInjector<TimersSetupWindowSetupViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public TimersSetupWindowSetupViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<TimersSetupWindowSetupViewModel> create(Provider<LightControlService> provider) {
        return new TimersSetupWindowSetupViewModel_MembersInjector(provider);
    }

    public void injectMembers(TimersSetupWindowSetupViewModel timersSetupWindowSetupViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(timersSetupWindowSetupViewModel, this._lightControlProvider.get());
    }
}
