package media.tiger.tigerbox.p016ui.common.reset;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.common.reset.ResetInProgressViewModel_MembersInjector */
public final class ResetInProgressViewModel_MembersInjector implements MembersInjector<ResetInProgressViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public ResetInProgressViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<ResetInProgressViewModel> create(Provider<LightControlService> provider) {
        return new ResetInProgressViewModel_MembersInjector(provider);
    }

    public void injectMembers(ResetInProgressViewModel resetInProgressViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(resetInProgressViewModel, this._lightControlProvider.get());
    }
}
