package media.tiger.tigerbox.p016ui.common;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.common.FullScreenViewModel_Factory */
public final class FullScreenViewModel_Factory implements Factory<FullScreenViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<HeaderProvider> headerProvider;

    public FullScreenViewModel_Factory(Provider<ButtonService> provider, Provider<HeaderProvider> provider2, Provider<LightControlService> provider3) {
        this.buttonServiceProvider = provider;
        this.headerProvider = provider2;
        this._lightControlProvider = provider3;
    }

    public FullScreenViewModel get() {
        FullScreenViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.headerProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static FullScreenViewModel_Factory create(Provider<ButtonService> provider, Provider<HeaderProvider> provider2, Provider<LightControlService> provider3) {
        return new FullScreenViewModel_Factory(provider, provider2, provider3);
    }

    public static FullScreenViewModel newInstance(ButtonService buttonService, HeaderProvider headerProvider2) {
        return new FullScreenViewModel(buttonService, headerProvider2);
    }
}
