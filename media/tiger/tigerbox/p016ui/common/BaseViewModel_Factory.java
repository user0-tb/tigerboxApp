package media.tiger.tigerbox.p016ui.common;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.common.BaseViewModel_Factory */
public final class BaseViewModel_Factory implements Factory<BaseViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public BaseViewModel_Factory(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public BaseViewModel get() {
        BaseViewModel newInstance = newInstance();
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static BaseViewModel_Factory create(Provider<LightControlService> provider) {
        return new BaseViewModel_Factory(provider);
    }

    public static BaseViewModel newInstance() {
        return new BaseViewModel();
    }
}
