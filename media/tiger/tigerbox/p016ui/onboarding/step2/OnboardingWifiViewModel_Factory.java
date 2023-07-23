package media.tiger.tigerbox.p016ui.onboarding.step2;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.WifiService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiViewModel_Factory */
public final class OnboardingWifiViewModel_Factory implements Factory<OnboardingWifiViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<InfoSoundService> infoSoundServiceProvider;
    private final Provider<StorageService> storageProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public OnboardingWifiViewModel_Factory(Provider<WifiService> provider, Provider<StorageService> provider2, Provider<InfoSoundService> provider3, Provider<ButtonService> provider4, Provider<ConfigurationProperties> provider5, Provider<LightControlService> provider6) {
        this.wifiServiceProvider = provider;
        this.storageProvider = provider2;
        this.infoSoundServiceProvider = provider3;
        this.buttonServiceProvider = provider4;
        this.configurationPropertiesProvider = provider5;
        this._lightControlProvider = provider6;
    }

    public OnboardingWifiViewModel get() {
        OnboardingWifiViewModel newInstance = newInstance(this.wifiServiceProvider.get(), this.storageProvider.get(), this.infoSoundServiceProvider.get(), this.buttonServiceProvider.get(), this.configurationPropertiesProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static OnboardingWifiViewModel_Factory create(Provider<WifiService> provider, Provider<StorageService> provider2, Provider<InfoSoundService> provider3, Provider<ButtonService> provider4, Provider<ConfigurationProperties> provider5, Provider<LightControlService> provider6) {
        return new OnboardingWifiViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static OnboardingWifiViewModel newInstance(WifiService wifiService, StorageService storageService, InfoSoundService infoSoundService, ButtonService buttonService, ConfigurationProperties configurationProperties) {
        return new OnboardingWifiViewModel(wifiService, storageService, infoSoundService, buttonService, configurationProperties);
    }
}
