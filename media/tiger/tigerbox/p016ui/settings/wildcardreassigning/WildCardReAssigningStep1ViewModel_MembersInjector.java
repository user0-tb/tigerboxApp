package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel_MembersInjector */
public final class WildCardReAssigningStep1ViewModel_MembersInjector implements MembersInjector<WildCardReAssigningStep1ViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public WildCardReAssigningStep1ViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<WildCardReAssigningStep1ViewModel> create(Provider<LightControlService> provider) {
        return new WildCardReAssigningStep1ViewModel_MembersInjector(provider);
    }

    public void injectMembers(WildCardReAssigningStep1ViewModel wildCardReAssigningStep1ViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(wildCardReAssigningStep1ViewModel, this._lightControlProvider.get());
    }
}
