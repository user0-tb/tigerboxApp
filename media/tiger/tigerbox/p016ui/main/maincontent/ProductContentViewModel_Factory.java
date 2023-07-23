package media.tiger.tigerbox.p016ui.main.maincontent;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.implementations.HeadsetService;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.NightLightTimerService;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.services.interfaces.UpdateCheckTimerService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.LastUsedProductService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.PlaybackPositionService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.PlaybackTrackingService;
import media.tiger.tigerbox.usecase.GetMainContentUseCase;
import media.tiger.tigerbox.usecase.ReportInformationUseCase;
import media.tiger.tigerbox.webserver.controller.MediaRestController;

/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel_Factory */
public final class ProductContentViewModel_Factory implements Factory<ProductContentViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<TigerBoxAccountRepository> accountRepositoryProvider;
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<BatteryService> batteryServiceProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<GenerateCsr> generateCsrProvider;
    private final Provider<GetMainContentUseCase> getMainContentUseCaseProvider;
    private final Provider<GetProductListRequest> getProductListRequestProvider;
    private final Provider<HeadsetService> headsetServiceProvider;
    private final Provider<InfoSoundService> infoSoundServiceProvider;
    private final Provider<LastUsedProductService> lastUsedProductServiceProvider;
    private final Provider<MediaRestController> mediaRestControllerProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<NightLightTimerService> nightNightLightTimerProvider;
    private final Provider<PlaybackPositionService> playbackPositionServiceProvider;
    private final Provider<PlaybackTrackingService> playbackTrackingServiceProvider;
    private final Provider<PowerManagementService> powerManagementServiceProvider;
    private final Provider<ProductAcquisitionService> productAcquisitionServiceProvider;
    private final Provider<ReportInformationUseCase> reportInformationUseCaseProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TigerCardsManagerService> tigerCardsManagerServiceProvider;
    private final Provider<UpdateCheckTimerService> updateCheckTimerProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public ProductContentViewModel_Factory(Provider<GetMainContentUseCase> provider, Provider<StorageService> provider2, Provider<ProductAcquisitionService> provider3, Provider<AvailabilityService> provider4, Provider<AudioPlayerService> provider5, Provider<TigerBoxAccountRepository> provider6, Provider<PlaybackPositionService> provider7, Provider<LastUsedProductService> provider8, Provider<PlaybackTrackingService> provider9, Provider<PowerManagementService> provider10, Provider<TigerCardsManagerService> provider11, Provider<NightLightTimerService> provider12, Provider<UpdateCheckTimerService> provider13, Provider<MediaRestController> provider14, Provider<MetaDataService> provider15, Provider<ReportInformationUseCase> provider16, Provider<ButtonService> provider17, Provider<HeadsetService> provider18, Provider<BatteryService> provider19, Provider<WifiService> provider20, Provider<GenerateCsr> provider21, Provider<GetProductListRequest> provider22, Provider<ConfigurationProperties> provider23, Provider<InfoSoundService> provider24, Provider<LightControlService> provider25) {
        this.getMainContentUseCaseProvider = provider;
        this.storageServiceProvider = provider2;
        this.productAcquisitionServiceProvider = provider3;
        this.availabilityServiceProvider = provider4;
        this.audioPlayerServiceProvider = provider5;
        this.accountRepositoryProvider = provider6;
        this.playbackPositionServiceProvider = provider7;
        this.lastUsedProductServiceProvider = provider8;
        this.playbackTrackingServiceProvider = provider9;
        this.powerManagementServiceProvider = provider10;
        this.tigerCardsManagerServiceProvider = provider11;
        this.nightNightLightTimerProvider = provider12;
        this.updateCheckTimerProvider = provider13;
        this.mediaRestControllerProvider = provider14;
        this.metaDataServiceProvider = provider15;
        this.reportInformationUseCaseProvider = provider16;
        this.buttonServiceProvider = provider17;
        this.headsetServiceProvider = provider18;
        this.batteryServiceProvider = provider19;
        this.wifiServiceProvider = provider20;
        this.generateCsrProvider = provider21;
        this.getProductListRequestProvider = provider22;
        this.configurationPropertiesProvider = provider23;
        this.infoSoundServiceProvider = provider24;
        this._lightControlProvider = provider25;
    }

    public ProductContentViewModel get() {
        ProductContentViewModel newInstance = newInstance(this.getMainContentUseCaseProvider.get(), this.storageServiceProvider.get(), this.productAcquisitionServiceProvider.get(), this.availabilityServiceProvider.get(), this.audioPlayerServiceProvider.get(), this.accountRepositoryProvider.get(), this.playbackPositionServiceProvider.get(), this.lastUsedProductServiceProvider.get(), this.playbackTrackingServiceProvider.get(), this.powerManagementServiceProvider.get(), this.tigerCardsManagerServiceProvider.get(), this.nightNightLightTimerProvider.get(), this.updateCheckTimerProvider.get(), this.mediaRestControllerProvider.get(), this.metaDataServiceProvider.get(), this.reportInformationUseCaseProvider.get(), this.buttonServiceProvider.get(), this.headsetServiceProvider.get(), this.batteryServiceProvider.get(), this.wifiServiceProvider.get(), this.generateCsrProvider.get(), this.getProductListRequestProvider.get(), this.configurationPropertiesProvider.get(), this.infoSoundServiceProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static ProductContentViewModel_Factory create(Provider<GetMainContentUseCase> provider, Provider<StorageService> provider2, Provider<ProductAcquisitionService> provider3, Provider<AvailabilityService> provider4, Provider<AudioPlayerService> provider5, Provider<TigerBoxAccountRepository> provider6, Provider<PlaybackPositionService> provider7, Provider<LastUsedProductService> provider8, Provider<PlaybackTrackingService> provider9, Provider<PowerManagementService> provider10, Provider<TigerCardsManagerService> provider11, Provider<NightLightTimerService> provider12, Provider<UpdateCheckTimerService> provider13, Provider<MediaRestController> provider14, Provider<MetaDataService> provider15, Provider<ReportInformationUseCase> provider16, Provider<ButtonService> provider17, Provider<HeadsetService> provider18, Provider<BatteryService> provider19, Provider<WifiService> provider20, Provider<GenerateCsr> provider21, Provider<GetProductListRequest> provider22, Provider<ConfigurationProperties> provider23, Provider<InfoSoundService> provider24, Provider<LightControlService> provider25) {
        return new ProductContentViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25);
    }

    public static ProductContentViewModel newInstance(GetMainContentUseCase getMainContentUseCase, StorageService storageService, ProductAcquisitionService productAcquisitionService, AvailabilityService availabilityService, AudioPlayerService audioPlayerService, TigerBoxAccountRepository tigerBoxAccountRepository, PlaybackPositionService playbackPositionService, LastUsedProductService lastUsedProductService, PlaybackTrackingService playbackTrackingService, PowerManagementService powerManagementService, TigerCardsManagerService tigerCardsManagerService, NightLightTimerService nightLightTimerService, UpdateCheckTimerService updateCheckTimerService, MediaRestController mediaRestController, MetaDataService metaDataService, ReportInformationUseCase reportInformationUseCase, ButtonService buttonService, HeadsetService headsetService, BatteryService batteryService, WifiService wifiService, GenerateCsr generateCsr, GetProductListRequest getProductListRequest, ConfigurationProperties configurationProperties, InfoSoundService infoSoundService) {
        return new ProductContentViewModel(getMainContentUseCase, storageService, productAcquisitionService, availabilityService, audioPlayerService, tigerBoxAccountRepository, playbackPositionService, lastUsedProductService, playbackTrackingService, powerManagementService, tigerCardsManagerService, nightLightTimerService, updateCheckTimerService, mediaRestController, metaDataService, reportInformationUseCase, buttonService, headsetService, batteryService, wifiService, generateCsr, getProductListRequest, configurationProperties, infoSoundService);
    }
}
