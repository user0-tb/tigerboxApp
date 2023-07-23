package media.tiger.tigerbox.p016ui.settings;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.usecase.ReportInformationUseCase;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsWifiViewModel_Factory */
public final class SettingsWifiViewModel_Factory implements Factory<SettingsWifiViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<TigerBoxAccountRepository> accountRepositoryProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<InfoSoundService> infoSoundServiceProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<ReportInformationUseCase> reportInformationUseCaseProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public SettingsWifiViewModel_Factory(Provider<WifiService> provider, Provider<StorageService> provider2, Provider<InfoSoundService> provider3, Provider<ButtonService> provider4, Provider<ConfigurationProperties> provider5, Provider<MetaDataService> provider6, Provider<ReportInformationUseCase> provider7, Provider<TigerBoxAccountRepository> provider8, Provider<LightControlService> provider9) {
        this.wifiServiceProvider = provider;
        this.storageServiceProvider = provider2;
        this.infoSoundServiceProvider = provider3;
        this.buttonServiceProvider = provider4;
        this.configurationPropertiesProvider = provider5;
        this.metaDataServiceProvider = provider6;
        this.reportInformationUseCaseProvider = provider7;
        this.accountRepositoryProvider = provider8;
        this._lightControlProvider = provider9;
    }

    public SettingsWifiViewModel get() {
        SettingsWifiViewModel newInstance = newInstance(this.wifiServiceProvider.get(), this.storageServiceProvider.get(), this.infoSoundServiceProvider.get(), this.buttonServiceProvider.get(), this.configurationPropertiesProvider.get(), this.metaDataServiceProvider.get(), this.reportInformationUseCaseProvider.get(), this.accountRepositoryProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static SettingsWifiViewModel_Factory create(Provider<WifiService> provider, Provider<StorageService> provider2, Provider<InfoSoundService> provider3, Provider<ButtonService> provider4, Provider<ConfigurationProperties> provider5, Provider<MetaDataService> provider6, Provider<ReportInformationUseCase> provider7, Provider<TigerBoxAccountRepository> provider8, Provider<LightControlService> provider9) {
        return new SettingsWifiViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static SettingsWifiViewModel newInstance(WifiService wifiService, StorageService storageService, InfoSoundService infoSoundService, ButtonService buttonService, ConfigurationProperties configurationProperties, MetaDataService metaDataService, ReportInformationUseCase reportInformationUseCase, TigerBoxAccountRepository tigerBoxAccountRepository) {
        return new SettingsWifiViewModel(wifiService, storageService, infoSoundService, buttonService, configurationProperties, metaDataService, reportInformationUseCase, tigerBoxAccountRepository);
    }
}
