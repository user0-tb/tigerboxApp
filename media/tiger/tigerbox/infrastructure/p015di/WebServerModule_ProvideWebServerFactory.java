package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.WakeService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;
import media.tiger.tigerbox.webserver.WebServer;

/* renamed from: media.tiger.tigerbox.infrastructure.di.WebServerModule_ProvideWebServerFactory */
public final class WebServerModule_ProvideWebServerFactory implements Factory<WebServer> {
    private final Provider<TigerBoxAccountRepository> accountRepositoryProvider;
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<ProductAcquisitionService> audioProductAcquisitionServiceProvider;
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<Context> contextProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TimersControllerService> timeLimitControllerProvider;
    private final Provider<TimeService> timeServiceProvider;
    private final Provider<WakeService> wakeServiceProvider;

    public WebServerModule_ProvideWebServerFactory(Provider<Context> provider, Provider<MetaDataService> provider2, Provider<AvailabilityService> provider3, Provider<AudioPlayerService> provider4, Provider<ProductAcquisitionService> provider5, Provider<WakeService> provider6, Provider<StorageService> provider7, Provider<ConfigurationProperties> provider8, Provider<TimersControllerService> provider9, Provider<TigerBoxAccountRepository> provider10, Provider<TimeService> provider11) {
        this.contextProvider = provider;
        this.metaDataServiceProvider = provider2;
        this.availabilityServiceProvider = provider3;
        this.audioPlayerServiceProvider = provider4;
        this.audioProductAcquisitionServiceProvider = provider5;
        this.wakeServiceProvider = provider6;
        this.storageServiceProvider = provider7;
        this.configurationPropertiesProvider = provider8;
        this.timeLimitControllerProvider = provider9;
        this.accountRepositoryProvider = provider10;
        this.timeServiceProvider = provider11;
    }

    public WebServer get() {
        return provideWebServer(this.contextProvider.get(), this.metaDataServiceProvider.get(), this.availabilityServiceProvider.get(), this.audioPlayerServiceProvider.get(), this.audioProductAcquisitionServiceProvider.get(), this.wakeServiceProvider.get(), this.storageServiceProvider.get(), this.configurationPropertiesProvider.get(), this.timeLimitControllerProvider.get(), this.accountRepositoryProvider.get(), this.timeServiceProvider.get());
    }

    public static WebServerModule_ProvideWebServerFactory create(Provider<Context> provider, Provider<MetaDataService> provider2, Provider<AvailabilityService> provider3, Provider<AudioPlayerService> provider4, Provider<ProductAcquisitionService> provider5, Provider<WakeService> provider6, Provider<StorageService> provider7, Provider<ConfigurationProperties> provider8, Provider<TimersControllerService> provider9, Provider<TigerBoxAccountRepository> provider10, Provider<TimeService> provider11) {
        return new WebServerModule_ProvideWebServerFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static WebServer provideWebServer(Context context, MetaDataService metaDataService, AvailabilityService availabilityService, AudioPlayerService audioPlayerService, ProductAcquisitionService productAcquisitionService, WakeService wakeService, StorageService storageService, ConfigurationProperties configurationProperties, TimersControllerService timersControllerService, TigerBoxAccountRepository tigerBoxAccountRepository, TimeService timeService) {
        return (WebServer) Preconditions.checkNotNullFromProvides(WebServerModule.INSTANCE.provideWebServer(context, metaDataService, availabilityService, audioPlayerService, productAcquisitionService, wakeService, storageService, configurationProperties, timersControllerService, tigerBoxAccountRepository, timeService));
    }
}
