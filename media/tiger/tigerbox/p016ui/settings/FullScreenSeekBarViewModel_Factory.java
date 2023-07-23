package media.tiger.tigerbox.p016ui.settings;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;

/* renamed from: media.tiger.tigerbox.ui.settings.FullScreenSeekBarViewModel_Factory */
public final class FullScreenSeekBarViewModel_Factory implements Factory<FullScreenSeekBarViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<HeaderProvider> headerProvider;
    private final Provider<LightControlService> lightControlProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<ShutDownTimerService> shutDownTimerServiceProvider;
    private final Provider<StorageService> storageServiceProvider;

    public FullScreenSeekBarViewModel_Factory(Provider<ButtonService> provider, Provider<HeaderProvider> provider2, Provider<LightControlService> provider3, Provider<MetaDataService> provider4, Provider<ShutDownTimerService> provider5, Provider<StorageService> provider6, Provider<LightControlService> provider7) {
        this.buttonServiceProvider = provider;
        this.headerProvider = provider2;
        this.lightControlProvider = provider3;
        this.metaDataServiceProvider = provider4;
        this.shutDownTimerServiceProvider = provider5;
        this.storageServiceProvider = provider6;
        this._lightControlProvider = provider7;
    }

    public FullScreenSeekBarViewModel get() {
        FullScreenSeekBarViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.headerProvider.get(), this.lightControlProvider.get(), this.metaDataServiceProvider.get(), this.shutDownTimerServiceProvider.get(), this.storageServiceProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static FullScreenSeekBarViewModel_Factory create(Provider<ButtonService> provider, Provider<HeaderProvider> provider2, Provider<LightControlService> provider3, Provider<MetaDataService> provider4, Provider<ShutDownTimerService> provider5, Provider<StorageService> provider6, Provider<LightControlService> provider7) {
        return new FullScreenSeekBarViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static FullScreenSeekBarViewModel newInstance(ButtonService buttonService, HeaderProvider headerProvider2, LightControlService lightControlService, MetaDataService metaDataService, ShutDownTimerService shutDownTimerService, StorageService storageService) {
        return new FullScreenSeekBarViewModel(buttonService, headerProvider2, lightControlService, metaDataService, shutDownTimerService, storageService);
    }
}
