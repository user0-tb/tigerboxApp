package media.tiger.tigerbox.p016ui.settings.timersSetup;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupViewModel_MembersInjector */
public final class TimersSetupViewModel_MembersInjector implements MembersInjector<TimersSetupViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public TimersSetupViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<TimersSetupViewModel> create(Provider<LightControlService> provider) {
        return new TimersSetupViewModel_MembersInjector(provider);
    }

    public void injectMembers(TimersSetupViewModel timersSetupViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(timersSetupViewModel, this._lightControlProvider.get());
    }
}
