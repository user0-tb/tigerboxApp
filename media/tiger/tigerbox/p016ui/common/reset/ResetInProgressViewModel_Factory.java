package media.tiger.tigerbox.p016ui.common.reset;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;

/* renamed from: media.tiger.tigerbox.ui.common.reset.ResetInProgressViewModel_Factory */
public final class ResetInProgressViewModel_Factory implements Factory<ResetInProgressViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<InfoSoundService> soundServiceProvider;

    public ResetInProgressViewModel_Factory(Provider<ButtonService> provider, Provider<MetaDataService> provider2, Provider<InfoSoundService> provider3, Provider<LightControlService> provider4) {
        this.buttonServiceProvider = provider;
        this.metaDataServiceProvider = provider2;
        this.soundServiceProvider = provider3;
        this._lightControlProvider = provider4;
    }

    public ResetInProgressViewModel get() {
        ResetInProgressViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.metaDataServiceProvider.get(), this.soundServiceProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static ResetInProgressViewModel_Factory create(Provider<ButtonService> provider, Provider<MetaDataService> provider2, Provider<InfoSoundService> provider3, Provider<LightControlService> provider4) {
        return new ResetInProgressViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static ResetInProgressViewModel newInstance(ButtonService buttonService, MetaDataService metaDataService, InfoSoundService infoSoundService) {
        return new ResetInProgressViewModel(buttonService, metaDataService, infoSoundService);
    }
}
