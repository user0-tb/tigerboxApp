package media.tiger.tigerbox.p016ui.settings.timersSetup;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel_MembersInjector */
public final class TimersSetupLimitSetupViewModel_MembersInjector implements MembersInjector<TimersSetupLimitSetupViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public TimersSetupLimitSetupViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<TimersSetupLimitSetupViewModel> create(Provider<LightControlService> provider) {
        return new TimersSetupLimitSetupViewModel_MembersInjector(provider);
    }

    public void injectMembers(TimersSetupLimitSetupViewModel timersSetupLimitSetupViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(timersSetupLimitSetupViewModel, this._lightControlProvider.get());
    }
}
