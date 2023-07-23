package media.tiger.tigerbox.p016ui.common.reset;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.common.reset.ResetDialogViewModel_Factory */
public final class ResetDialogViewModel_Factory implements Factory<ResetDialogViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<InfoSoundService> infoSoundServiceProvider;

    public ResetDialogViewModel_Factory(Provider<ButtonService> provider, Provider<InfoSoundService> provider2, Provider<LightControlService> provider3) {
        this.buttonServiceProvider = provider;
        this.infoSoundServiceProvider = provider2;
        this._lightControlProvider = provider3;
    }

    public ResetDialogViewModel get() {
        ResetDialogViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.infoSoundServiceProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static ResetDialogViewModel_Factory create(Provider<ButtonService> provider, Provider<InfoSoundService> provider2, Provider<LightControlService> provider3) {
        return new ResetDialogViewModel_Factory(provider, provider2, provider3);
    }

    public static ResetDialogViewModel newInstance(ButtonService buttonService, InfoSoundService infoSoundService) {
        return new ResetDialogViewModel(buttonService, infoSoundService);
    }
}
