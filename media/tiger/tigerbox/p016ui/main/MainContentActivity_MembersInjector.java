package media.tiger.tigerbox.p016ui.main;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.TigerBoxActivity_MembersInjector;
import media.tiger.tigerbox.p016ui.main.update.UpdateCheck;
import media.tiger.tigerbox.services.interfaces.NfcService;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.timersController.LockedModeService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;
import media.tiger.tigerbox.webserver.WebServer;

/* renamed from: media.tiger.tigerbox.ui.main.MainContentActivity_MembersInjector */
public final class MainContentActivity_MembersInjector implements MembersInjector<MainContentActivity> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<LockedModeService> lockedModeServiceProvider;
    private final Provider<NfcService> nfcServiceProvider;
    private final Provider<PowerManagementService> powerManagementServiceProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TimersControllerService> timersControllerProvider;
    private final Provider<UpdateCheck> updateCheckProvider;
    private final Provider<WebServer> webServerProvider;

    public MainContentActivity_MembersInjector(Provider<NfcService> provider, Provider<WebServer> provider2, Provider<StorageService> provider3, Provider<UpdateCheck> provider4, Provider<TimersControllerService> provider5, Provider<LockedModeService> provider6, Provider<PowerManagementService> provider7, Provider<ConfigurationProperties> provider8) {
        this.nfcServiceProvider = provider;
        this.webServerProvider = provider2;
        this.storageServiceProvider = provider3;
        this.updateCheckProvider = provider4;
        this.timersControllerProvider = provider5;
        this.lockedModeServiceProvider = provider6;
        this.powerManagementServiceProvider = provider7;
        this.configurationPropertiesProvider = provider8;
    }

    public static MembersInjector<MainContentActivity> create(Provider<NfcService> provider, Provider<WebServer> provider2, Provider<StorageService> provider3, Provider<UpdateCheck> provider4, Provider<TimersControllerService> provider5, Provider<LockedModeService> provider6, Provider<PowerManagementService> provider7, Provider<ConfigurationProperties> provider8) {
        return new MainContentActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public void injectMembers(MainContentActivity mainContentActivity) {
        TigerBoxActivity_MembersInjector.injectNfcService(mainContentActivity, this.nfcServiceProvider.get());
        injectWebServer(mainContentActivity, this.webServerProvider.get());
        injectStorageService(mainContentActivity, this.storageServiceProvider.get());
        injectUpdateCheck(mainContentActivity, this.updateCheckProvider.get());
        injectTimersController(mainContentActivity, this.timersControllerProvider.get());
        injectLockedModeService(mainContentActivity, this.lockedModeServiceProvider.get());
        injectPowerManagementService(mainContentActivity, this.powerManagementServiceProvider.get());
        injectConfigurationProperties(mainContentActivity, this.configurationPropertiesProvider.get());
    }

    public static void injectWebServer(MainContentActivity mainContentActivity, WebServer webServer) {
        mainContentActivity.webServer = webServer;
    }

    public static void injectStorageService(MainContentActivity mainContentActivity, StorageService storageService) {
        mainContentActivity.storageService = storageService;
    }

    public static void injectUpdateCheck(MainContentActivity mainContentActivity, UpdateCheck updateCheck) {
        mainContentActivity.updateCheck = updateCheck;
    }

    public static void injectTimersController(MainContentActivity mainContentActivity, TimersControllerService timersControllerService) {
        mainContentActivity.timersController = timersControllerService;
    }

    public static void injectLockedModeService(MainContentActivity mainContentActivity, LockedModeService lockedModeService) {
        mainContentActivity.lockedModeService = lockedModeService;
    }

    public static void injectPowerManagementService(MainContentActivity mainContentActivity, PowerManagementService powerManagementService) {
        mainContentActivity.powerManagementService = powerManagementService;
    }

    public static void injectConfigurationProperties(MainContentActivity mainContentActivity, ConfigurationProperties configurationProperties) {
        mainContentActivity.configurationProperties = configurationProperties;
    }
}
