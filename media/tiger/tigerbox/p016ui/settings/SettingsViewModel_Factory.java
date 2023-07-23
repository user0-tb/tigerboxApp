package media.tiger.tigerbox.p016ui.settings;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.TigerBoxLogTree;
import media.tiger.tigerbox.WriteToFileExceptionHandler;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.AccountSubscriptionService;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewModel_Factory */
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<TigerBoxAccountRepository> accountRepositoryProvider;
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<TigerBoxLogTree> boxLogTreeProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<FirmwareUpdateService> firmwareUpdateServiceProvider;
    private final Provider<HeaderProvider> headerProvider;
    private final Provider<InfoSoundService> infoSoundServiceProvider;
    private final Provider<LightControlService> lightControlProvider;
    private final Provider<ShutDownTimerService> shutDownTimerServiceProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<AccountSubscriptionService> subscriptionServiceProvider;
    private final Provider<TigerCardsManagerService> tigerCardsManagerServiceProvider;
    private final Provider<WifiService> wifiServiceProvider;
    private final Provider<WriteToFileExceptionHandler> writeToFileExceptionHandlerProvider;

    public SettingsViewModel_Factory(Provider<ButtonService> provider, Provider<TigerCardsManagerService> provider2, Provider<AccountSubscriptionService> provider3, Provider<LightControlService> provider4, Provider<StorageService> provider5, Provider<InfoSoundService> provider6, Provider<WifiService> provider7, Provider<TigerBoxAccountRepository> provider8, Provider<AvailabilityService> provider9, Provider<ShutDownTimerService> provider10, Provider<ConfigurationProperties> provider11, Provider<WriteToFileExceptionHandler> provider12, Provider<TigerBoxLogTree> provider13, Provider<FirmwareUpdateService> provider14, Provider<HeaderProvider> provider15, Provider<LightControlService> provider16) {
        this.buttonServiceProvider = provider;
        this.tigerCardsManagerServiceProvider = provider2;
        this.subscriptionServiceProvider = provider3;
        this.lightControlProvider = provider4;
        this.storageServiceProvider = provider5;
        this.infoSoundServiceProvider = provider6;
        this.wifiServiceProvider = provider7;
        this.accountRepositoryProvider = provider8;
        this.availabilityServiceProvider = provider9;
        this.shutDownTimerServiceProvider = provider10;
        this.configurationPropertiesProvider = provider11;
        this.writeToFileExceptionHandlerProvider = provider12;
        this.boxLogTreeProvider = provider13;
        this.firmwareUpdateServiceProvider = provider14;
        this.headerProvider = provider15;
        this._lightControlProvider = provider16;
    }

    public SettingsViewModel get() {
        SettingsViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.tigerCardsManagerServiceProvider.get(), this.subscriptionServiceProvider.get(), this.lightControlProvider.get(), this.storageServiceProvider.get(), this.infoSoundServiceProvider.get(), this.wifiServiceProvider.get(), this.accountRepositoryProvider.get(), this.availabilityServiceProvider.get(), this.shutDownTimerServiceProvider.get(), this.configurationPropertiesProvider.get(), this.writeToFileExceptionHandlerProvider.get(), this.boxLogTreeProvider.get(), this.firmwareUpdateServiceProvider.get(), this.headerProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static SettingsViewModel_Factory create(Provider<ButtonService> provider, Provider<TigerCardsManagerService> provider2, Provider<AccountSubscriptionService> provider3, Provider<LightControlService> provider4, Provider<StorageService> provider5, Provider<InfoSoundService> provider6, Provider<WifiService> provider7, Provider<TigerBoxAccountRepository> provider8, Provider<AvailabilityService> provider9, Provider<ShutDownTimerService> provider10, Provider<ConfigurationProperties> provider11, Provider<WriteToFileExceptionHandler> provider12, Provider<TigerBoxLogTree> provider13, Provider<FirmwareUpdateService> provider14, Provider<HeaderProvider> provider15, Provider<LightControlService> provider16) {
        return new SettingsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    public static SettingsViewModel newInstance(ButtonService buttonService, TigerCardsManagerService tigerCardsManagerService, AccountSubscriptionService accountSubscriptionService, LightControlService lightControlService, StorageService storageService, InfoSoundService infoSoundService, WifiService wifiService, TigerBoxAccountRepository tigerBoxAccountRepository, AvailabilityService availabilityService, ShutDownTimerService shutDownTimerService, ConfigurationProperties configurationProperties, WriteToFileExceptionHandler writeToFileExceptionHandler, TigerBoxLogTree tigerBoxLogTree, FirmwareUpdateService firmwareUpdateService, HeaderProvider headerProvider2) {
        return new SettingsViewModel(buttonService, tigerCardsManagerService, accountSubscriptionService, lightControlService, storageService, infoSoundService, wifiService, tigerBoxAccountRepository, availabilityService, shutDownTimerService, configurationProperties, writeToFileExceptionHandler, tigerBoxLogTree, firmwareUpdateService, headerProvider2);
    }
}
