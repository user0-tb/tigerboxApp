package media.tiger.tigerbox.p016ui.common.wifi;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.WifiService;

/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel_Factory */
public final class WifiViewModel_Factory implements Factory<WifiViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<InfoSoundService> infoSoundServiceProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public WifiViewModel_Factory(Provider<WifiService> provider, Provider<StorageService> provider2, Provider<InfoSoundService> provider3, Provider<ButtonService> provider4, Provider<ConfigurationProperties> provider5, Provider<LightControlService> provider6) {
        this.wifiServiceProvider = provider;
        this.storageServiceProvider = provider2;
        this.infoSoundServiceProvider = provider3;
        this.buttonServiceProvider = provider4;
        this.configurationPropertiesProvider = provider5;
        this._lightControlProvider = provider6;
    }

    public WifiViewModel get() {
        WifiViewModel newInstance = newInstance(this.wifiServiceProvider.get(), this.storageServiceProvider.get(), this.infoSoundServiceProvider.get(), this.buttonServiceProvider.get(), this.configurationPropertiesProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static WifiViewModel_Factory create(Provider<WifiService> provider, Provider<StorageService> provider2, Provider<InfoSoundService> provider3, Provider<ButtonService> provider4, Provider<ConfigurationProperties> provider5, Provider<LightControlService> provider6) {
        return new WifiViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static WifiViewModel newInstance(WifiService wifiService, StorageService storageService, InfoSoundService infoSoundService, ButtonService buttonService, ConfigurationProperties configurationProperties) {
        return new WifiViewModel(wifiService, storageService, infoSoundService, buttonService, configurationProperties);
    }
}
