package media.tiger.tigerbox.p016ui.main.maincontentheader;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderBarViewModel_MembersInjector */
public final class MainContentHeaderBarViewModel_MembersInjector implements MembersInjector<MainContentHeaderBarViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public MainContentHeaderBarViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<MainContentHeaderBarViewModel> create(Provider<LightControlService> provider) {
        return new MainContentHeaderBarViewModel_MembersInjector(provider);
    }

    public void injectMembers(MainContentHeaderBarViewModel mainContentHeaderBarViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(mainContentHeaderBarViewModel, this._lightControlProvider.get());
    }
}
