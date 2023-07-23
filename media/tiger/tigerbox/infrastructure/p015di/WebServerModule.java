package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import com.tigermedia.tigerbox.mdns.DnsLibrary;
import com.tigermedia.tigerbox.mdns.MulticastDNS;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.LinkedHashMap;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.WakeService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;
import media.tiger.tigerbox.webserver.TigerBoxWebServer;
import media.tiger.tigerbox.webserver.WebServer;
import media.tiger.tigerbox.webserver.controller.BaseController;
import media.tiger.tigerbox.webserver.controller.DeviceInfoController;
import media.tiger.tigerbox.webserver.controller.MediaRestController;
import media.tiger.tigerbox.webserver.controller.ProfilesRestController;
import media.tiger.tigerbox.webserver.controller.RestController;

@Metadata(mo33736d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007Jb\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0007J`\u0010\"\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002¨\u0006$"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/di/WebServerModule;", "", "()V", "provideMDNSModule", "Lcom/tigermedia/tigerbox/mdns/MulticastDNS;", "provideMediaRestController", "Lmedia/tiger/tigerbox/webserver/controller/MediaRestController;", "webServer", "Lmedia/tiger/tigerbox/webserver/WebServer;", "provideProfilesRestController", "Lmedia/tiger/tigerbox/webserver/controller/ProfilesRestController;", "provideWebServer", "context", "Landroid/content/Context;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "audioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "audioProductAcquisitionService", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;", "wakeService", "Lmedia/tiger/tigerbox/services/interfaces/WakeService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "timeLimitController", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "accountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "registerControllers", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@Module
/* renamed from: media.tiger.tigerbox.infrastructure.di.WebServerModule */
/* compiled from: WebServerModule.kt */
public final class WebServerModule {
    public static final WebServerModule INSTANCE = new WebServerModule();

    private WebServerModule() {
    }

    @Provides
    public final MediaRestController provideMediaRestController(WebServer webServer) {
        Intrinsics.checkNotNullParameter(webServer, "webServer");
        RestController controller = webServer.getController("MediaRestController");
        if (controller != null) {
            return (MediaRestController) controller;
        }
        throw new IllegalStateException("MediaRestController has to be initialised");
    }

    @Provides
    public final ProfilesRestController provideProfilesRestController(WebServer webServer) {
        Intrinsics.checkNotNullParameter(webServer, "webServer");
        RestController controller = webServer.getController("ProfilesRestController");
        if (controller != null) {
            return (ProfilesRestController) controller;
        }
        throw new IllegalStateException("ProfilesRestController has to be initialised");
    }

    @Singleton
    @Provides
    public final WebServer provideWebServer(@ApplicationContext Context context, MetaDataService metaDataService, AvailabilityService availabilityService, AudioPlayerService audioPlayerService, ProductAcquisitionService productAcquisitionService, WakeService wakeService, StorageService storageService, ConfigurationProperties configurationProperties, TimersControllerService timersControllerService, TigerBoxAccountRepository tigerBoxAccountRepository, TimeService timeService) {
        Context context2 = context;
        StorageService storageService2 = storageService;
        ConfigurationProperties configurationProperties2 = configurationProperties;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(metaDataService, "metaDataService");
        AvailabilityService availabilityService2 = availabilityService;
        Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
        AudioPlayerService audioPlayerService2 = audioPlayerService;
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        ProductAcquisitionService productAcquisitionService2 = productAcquisitionService;
        Intrinsics.checkNotNullParameter(productAcquisitionService2, "audioProductAcquisitionService");
        WakeService wakeService2 = wakeService;
        Intrinsics.checkNotNullParameter(wakeService2, "wakeService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        TimersControllerService timersControllerService2 = timersControllerService;
        Intrinsics.checkNotNullParameter(timersControllerService2, "timeLimitController");
        TigerBoxAccountRepository tigerBoxAccountRepository2 = tigerBoxAccountRepository;
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository2, "accountRepository");
        TimeService timeService2 = timeService;
        Intrinsics.checkNotNullParameter(timeService2, "timeService");
        WebServer tigerBoxWebServer = new TigerBoxWebServer(context, Integer.parseInt(configurationProperties2.getProperty("webserver.port")), storageService2, metaDataService);
        registerControllers(tigerBoxWebServer, metaDataService, availabilityService2, audioPlayerService2, productAcquisitionService2, wakeService2, configurationProperties2, timersControllerService2, tigerBoxAccountRepository2, storageService2, timeService2);
        return tigerBoxWebServer;
    }

    private final void registerControllers(WebServer webServer, MetaDataService metaDataService, AvailabilityService availabilityService, AudioPlayerService audioPlayerService, ProductAcquisitionService productAcquisitionService, WakeService wakeService, ConfigurationProperties configurationProperties, TimersControllerService timersControllerService, TigerBoxAccountRepository tigerBoxAccountRepository, StorageService storageService, TimeService timeService) {
        new MediaRestController("/media", webServer, availabilityService, audioPlayerService, productAcquisitionService, new LinkedHashMap());
        new ProfilesRestController("/profiles", webServer, tigerBoxAccountRepository, metaDataService, new LinkedHashMap());
        new DeviceInfoController("/deviceInfo", webServer, metaDataService);
        new BaseController(DownloadsManager.FOLDERS_SEPARATOR, webServer, wakeService, configurationProperties, metaDataService);
    }

    @Singleton
    @Provides
    public final MulticastDNS provideMDNSModule() {
        return new DnsLibrary();
    }
}
