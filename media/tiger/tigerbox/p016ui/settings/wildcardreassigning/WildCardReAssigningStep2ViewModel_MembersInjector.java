package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep2ViewModel_MembersInjector */
public final class WildCardReAssigningStep2ViewModel_MembersInjector implements MembersInjector<WildCardReAssigningStep2ViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public WildCardReAssigningStep2ViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<WildCardReAssigningStep2ViewModel> create(Provider<LightControlService> provider) {
        return new WildCardReAssigningStep2ViewModel_MembersInjector(provider);
    }

    public void injectMembers(WildCardReAssigningStep2ViewModel wildCardReAssigningStep2ViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(wildCardReAssigningStep2ViewModel, this._lightControlProvider.get());
    }
}
