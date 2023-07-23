package media.tiger.tigerbox.p016ui.settings.systeminfo;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;

/* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel_Factory */
public final class SystemInfoViewModel_Factory implements Factory<SystemInfoViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<HeaderProvider> headerProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<StorageService> storageServiceProvider;

    public SystemInfoViewModel_Factory(Provider<ConfigurationProperties> provider, Provider<StorageService> provider2, Provider<MetaDataService> provider3, Provider<ButtonService> provider4, Provider<HeaderProvider> provider5, Provider<LightControlService> provider6) {
        this.configurationPropertiesProvider = provider;
        this.storageServiceProvider = provider2;
        this.metaDataServiceProvider = provider3;
        this.buttonServiceProvider = provider4;
        this.headerProvider = provider5;
        this._lightControlProvider = provider6;
    }

    public SystemInfoViewModel get() {
        SystemInfoViewModel newInstance = newInstance(this.configurationPropertiesProvider.get(), this.storageServiceProvider.get(), this.metaDataServiceProvider.get(), this.buttonServiceProvider.get(), this.headerProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static SystemInfoViewModel_Factory create(Provider<ConfigurationProperties> provider, Provider<StorageService> provider2, Provider<MetaDataService> provider3, Provider<ButtonService> provider4, Provider<HeaderProvider> provider5, Provider<LightControlService> provider6) {
        return new SystemInfoViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static SystemInfoViewModel newInstance(ConfigurationProperties configurationProperties, StorageService storageService, MetaDataService metaDataService, ButtonService buttonService, HeaderProvider headerProvider2) {
        return new SystemInfoViewModel(configurationProperties, storageService, metaDataService, buttonService, headerProvider2);
    }
}
