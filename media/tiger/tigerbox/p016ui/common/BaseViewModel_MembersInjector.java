package media.tiger.tigerbox.p016ui.common;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.common.BaseViewModel_MembersInjector */
public final class BaseViewModel_MembersInjector implements MembersInjector<BaseViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public BaseViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<BaseViewModel> create(Provider<LightControlService> provider) {
        return new BaseViewModel_MembersInjector(provider);
    }

    public void injectMembers(BaseViewModel baseViewModel) {
        inject_lightControl(baseViewModel, this._lightControlProvider.get());
    }

    public static void inject_lightControl(BaseViewModel baseViewModel, LightControlService lightControlService) {
        baseViewModel._lightControl = lightControlService;
    }
}
