package media.tiger.tigerbox.developer;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.AccessTokenRepository;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.NfcService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.UpdateCheckTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;

public final class AdbReceiver_MembersInjector implements MembersInjector<AdbReceiver> {
    private final Provider<AccessTokenRepository> accessTokenRepositoryProvider;
    private final Provider<TigerBoxAccountRepository> accountRepositoryProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<NfcService> nfcServiceProvider;
    private final Provider<ProductAcquisitionService> productAcquisitionServiceProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TimersControllerService> timeLimitControllerProvider;
    private final Provider<TimeService> timeServiceProvider;
    private final Provider<UpdateCheckTimerService> updateCheckTimerServiceProvider;

    public AdbReceiver_MembersInjector(Provider<ConfigurationProperties> provider, Provider<ProductAcquisitionService> provider2, Provider<UpdateCheckTimerService> provider3, Provider<StorageService> provider4, Provider<NfcService> provider5, Provider<TimersControllerService> provider6, Provider<TigerBoxAccountRepository> provider7, Provider<AccessTokenRepository> provider8, Provider<TimeService> provider9) {
        this.configurationPropertiesProvider = provider;
        this.productAcquisitionServiceProvider = provider2;
        this.updateCheckTimerServiceProvider = provider3;
        this.storageServiceProvider = provider4;
        this.nfcServiceProvider = provider5;
        this.timeLimitControllerProvider = provider6;
        this.accountRepositoryProvider = provider7;
        this.accessTokenRepositoryProvider = provider8;
        this.timeServiceProvider = provider9;
    }

    public static MembersInjector<AdbReceiver> create(Provider<ConfigurationProperties> provider, Provider<ProductAcquisitionService> provider2, Provider<UpdateCheckTimerService> provider3, Provider<StorageService> provider4, Provider<NfcService> provider5, Provider<TimersControllerService> provider6, Provider<TigerBoxAccountRepository> provider7, Provider<AccessTokenRepository> provider8, Provider<TimeService> provider9) {
        return new AdbReceiver_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public void injectMembers(AdbReceiver adbReceiver) {
        injectConfigurationProperties(adbReceiver, this.configurationPropertiesProvider.get());
        injectProductAcquisitionService(adbReceiver, this.productAcquisitionServiceProvider.get());
        injectUpdateCheckTimerService(adbReceiver, this.updateCheckTimerServiceProvider.get());
        injectStorageService(adbReceiver, this.storageServiceProvider.get());
        injectNfcService(adbReceiver, this.nfcServiceProvider.get());
        injectTimeLimitController(adbReceiver, this.timeLimitControllerProvider.get());
        injectAccountRepository(adbReceiver, this.accountRepositoryProvider.get());
        injectAccessTokenRepository(adbReceiver, this.accessTokenRepositoryProvider.get());
        injectTimeService(adbReceiver, this.timeServiceProvider.get());
    }

    public static void injectConfigurationProperties(AdbReceiver adbReceiver, ConfigurationProperties configurationProperties) {
        adbReceiver.configurationProperties = configurationProperties;
    }

    public static void injectProductAcquisitionService(AdbReceiver adbReceiver, ProductAcquisitionService productAcquisitionService) {
        adbReceiver.productAcquisitionService = productAcquisitionService;
    }

    public static void injectUpdateCheckTimerService(AdbReceiver adbReceiver, UpdateCheckTimerService updateCheckTimerService) {
        adbReceiver.updateCheckTimerService = updateCheckTimerService;
    }

    public static void injectStorageService(AdbReceiver adbReceiver, StorageService storageService) {
        adbReceiver.storageService = storageService;
    }

    public static void injectNfcService(AdbReceiver adbReceiver, NfcService nfcService) {
        adbReceiver.nfcService = nfcService;
    }

    public static void injectTimeLimitController(AdbReceiver adbReceiver, TimersControllerService timersControllerService) {
        adbReceiver.timeLimitController = timersControllerService;
    }

    public static void injectAccountRepository(AdbReceiver adbReceiver, TigerBoxAccountRepository tigerBoxAccountRepository) {
        adbReceiver.accountRepository = tigerBoxAccountRepository;
    }

    public static void injectAccessTokenRepository(AdbReceiver adbReceiver, AccessTokenRepository accessTokenRepository) {
        adbReceiver.accessTokenRepository = accessTokenRepository;
    }

    public static void injectTimeService(AdbReceiver adbReceiver, TimeService timeService) {
        adbReceiver.timeService = timeService;
    }
}
