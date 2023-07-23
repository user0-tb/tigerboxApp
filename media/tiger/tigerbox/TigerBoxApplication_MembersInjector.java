package media.tiger.tigerbox;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.SafeguardService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.usecase.PostCrashLogsUseCase;

public final class TigerBoxApplication_MembersInjector implements MembersInjector<TigerBoxApplication> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<InitServices> initServicesProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<PostCrashLogsUseCase> postCrashLogsUseCaseProvider;
    private final Provider<SafeguardService> safeguardServiceProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<WifiService> wifiServiceProvider;
    private final Provider<WriteToFileExceptionHandler> writeToFileExceptionHandlerProvider;

    public TigerBoxApplication_MembersInjector(Provider<ConfigurationProperties> provider, Provider<InitServices> provider2, Provider<MetaDataService> provider3, Provider<StorageService> provider4, Provider<WifiService> provider5, Provider<SafeguardService> provider6, Provider<PostCrashLogsUseCase> provider7, Provider<WriteToFileExceptionHandler> provider8) {
        this.configurationPropertiesProvider = provider;
        this.initServicesProvider = provider2;
        this.metaDataServiceProvider = provider3;
        this.storageServiceProvider = provider4;
        this.wifiServiceProvider = provider5;
        this.safeguardServiceProvider = provider6;
        this.postCrashLogsUseCaseProvider = provider7;
        this.writeToFileExceptionHandlerProvider = provider8;
    }

    public static MembersInjector<TigerBoxApplication> create(Provider<ConfigurationProperties> provider, Provider<InitServices> provider2, Provider<MetaDataService> provider3, Provider<StorageService> provider4, Provider<WifiService> provider5, Provider<SafeguardService> provider6, Provider<PostCrashLogsUseCase> provider7, Provider<WriteToFileExceptionHandler> provider8) {
        return new TigerBoxApplication_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public void injectMembers(TigerBoxApplication tigerBoxApplication) {
        injectConfigurationProperties(tigerBoxApplication, this.configurationPropertiesProvider.get());
        injectInitServices(tigerBoxApplication, this.initServicesProvider.get());
        injectMetaDataService(tigerBoxApplication, this.metaDataServiceProvider.get());
        injectStorageService(tigerBoxApplication, this.storageServiceProvider.get());
        injectWifiService(tigerBoxApplication, this.wifiServiceProvider.get());
        injectSafeguardService(tigerBoxApplication, this.safeguardServiceProvider.get());
        injectPostCrashLogsUseCase(tigerBoxApplication, this.postCrashLogsUseCaseProvider.get());
        injectWriteToFileExceptionHandler(tigerBoxApplication, this.writeToFileExceptionHandlerProvider.get());
    }

    public static void injectConfigurationProperties(TigerBoxApplication tigerBoxApplication, ConfigurationProperties configurationProperties) {
        tigerBoxApplication.configurationProperties = configurationProperties;
    }

    public static void injectInitServices(TigerBoxApplication tigerBoxApplication, InitServices initServices) {
        tigerBoxApplication.initServices = initServices;
    }

    public static void injectMetaDataService(TigerBoxApplication tigerBoxApplication, MetaDataService metaDataService) {
        tigerBoxApplication.metaDataService = metaDataService;
    }

    public static void injectStorageService(TigerBoxApplication tigerBoxApplication, StorageService storageService) {
        tigerBoxApplication.storageService = storageService;
    }

    public static void injectWifiService(TigerBoxApplication tigerBoxApplication, WifiService wifiService) {
        tigerBoxApplication.wifiService = wifiService;
    }

    public static void injectSafeguardService(TigerBoxApplication tigerBoxApplication, SafeguardService safeguardService) {
        tigerBoxApplication.safeguardService = safeguardService;
    }

    public static void injectPostCrashLogsUseCase(TigerBoxApplication tigerBoxApplication, PostCrashLogsUseCase postCrashLogsUseCase) {
        tigerBoxApplication.postCrashLogsUseCase = postCrashLogsUseCase;
    }

    public static void injectWriteToFileExceptionHandler(TigerBoxApplication tigerBoxApplication, WriteToFileExceptionHandler writeToFileExceptionHandler) {
        tigerBoxApplication.writeToFileExceptionHandler = writeToFileExceptionHandler;
    }
}
