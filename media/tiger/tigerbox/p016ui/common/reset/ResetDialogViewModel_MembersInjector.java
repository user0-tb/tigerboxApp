package media.tiger.tigerbox.p016ui.common.reset;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.common.reset.ResetDialogViewModel_MembersInjector */
public final class ResetDialogViewModel_MembersInjector implements MembersInjector<ResetDialogViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public ResetDialogViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<ResetDialogViewModel> create(Provider<LightControlService> provider) {
        return new ResetDialogViewModel_MembersInjector(provider);
    }

    public void injectMembers(ResetDialogViewModel resetDialogViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(resetDialogViewModel, this._lightControlProvider.get());
    }
}
