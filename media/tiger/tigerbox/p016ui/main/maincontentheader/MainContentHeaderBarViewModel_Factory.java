package media.tiger.tigerbox.p016ui.main.maincontentheader;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;

/* renamed from: media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderBarViewModel_Factory */
public final class MainContentHeaderBarViewModel_Factory implements Factory<MainContentHeaderBarViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<HeaderProvider> headerProvider;
    private final Provider<StorageService> storageServiceProvider;

    public MainContentHeaderBarViewModel_Factory(Provider<StorageService> provider, Provider<HeaderProvider> provider2, Provider<LightControlService> provider3) {
        this.storageServiceProvider = provider;
        this.headerProvider = provider2;
        this._lightControlProvider = provider3;
    }

    public MainContentHeaderBarViewModel get() {
        MainContentHeaderBarViewModel newInstance = newInstance(this.storageServiceProvider.get(), this.headerProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static MainContentHeaderBarViewModel_Factory create(Provider<StorageService> provider, Provider<HeaderProvider> provider2, Provider<LightControlService> provider3) {
        return new MainContentHeaderBarViewModel_Factory(provider, provider2, provider3);
    }

    public static MainContentHeaderBarViewModel newInstance(StorageService storageService, HeaderProvider headerProvider2) {
        return new MainContentHeaderBarViewModel(storageService, headerProvider2);
    }
}
