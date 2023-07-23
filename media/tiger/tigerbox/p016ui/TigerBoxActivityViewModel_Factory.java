package media.tiger.tigerbox.p016ui;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.SafeguardService;

/* renamed from: media.tiger.tigerbox.ui.TigerBoxActivityViewModel_Factory */
public final class TigerBoxActivityViewModel_Factory implements Factory<TigerBoxActivityViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<DisplayService> displayServiceProvider;
    private final Provider<SafeguardService> safeguardServiceProvider;

    public TigerBoxActivityViewModel_Factory(Provider<DisplayService> provider, Provider<SafeguardService> provider2, Provider<ButtonService> provider3, Provider<LightControlService> provider4) {
        this.displayServiceProvider = provider;
        this.safeguardServiceProvider = provider2;
        this.buttonServiceProvider = provider3;
        this._lightControlProvider = provider4;
    }

    public TigerBoxActivityViewModel get() {
        TigerBoxActivityViewModel newInstance = newInstance(this.displayServiceProvider.get(), this.safeguardServiceProvider.get(), this.buttonServiceProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static TigerBoxActivityViewModel_Factory create(Provider<DisplayService> provider, Provider<SafeguardService> provider2, Provider<ButtonService> provider3, Provider<LightControlService> provider4) {
        return new TigerBoxActivityViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static TigerBoxActivityViewModel newInstance(DisplayService displayService, SafeguardService safeguardService, ButtonService buttonService) {
        return new TigerBoxActivityViewModel(displayService, safeguardService, buttonService);
    }
}
