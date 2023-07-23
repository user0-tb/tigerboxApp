package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.DatabaseMigrationService;
import media.tiger.tigerbox.EngageDeepSleep;
import media.tiger.tigerbox.InitServices;
import media.tiger.tigerbox.RestartServicesSafely;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.properties.AndroidSystemProperties;
import media.tiger.tigerbox.p016ui.main.maincontent.GenerateCsr;
import media.tiger.tigerbox.p016ui.main.maincontent.GetProductListRequest;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DownloadForOta;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler;
import media.tiger.tigerbox.services.interfaces.AdbEnabler;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.DataMigrationService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.usecase.RequestPemCertificateUseCase;
import media.tiger.tigerbox.webserver.WebServer;

@Metadata(mo33736d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u001a\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0007J\b\u0010#\u001a\u00020$H\u0007J\u0012\u0010%\u001a\u00020&2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006'"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/di/ProcessModule;", "", "()V", "provideAdbEnabler", "Lmedia/tiger/tigerbox/services/interfaces/AdbEnabler;", "context", "Landroid/content/Context;", "provideAndroidSystemProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/AndroidSystemProperties;", "provideDatabaseMigrationService", "Lmedia/tiger/tigerbox/DatabaseMigrationService;", "dataMigrationService", "Lmedia/tiger/tigerbox/services/interfaces/DataMigrationService;", "provideEngageDeepSleep", "Lmedia/tiger/tigerbox/EngageDeepSleep;", "provideGenerateCsr", "Lmedia/tiger/tigerbox/ui/main/maincontent/GenerateCsr;", "requestPemCertificateUseCase", "Lmedia/tiger/tigerbox/usecase/RequestPemCertificateUseCase;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "webServer", "Lmedia/tiger/tigerbox/webserver/WebServer;", "provideGetProductListRequest", "Lmedia/tiger/tigerbox/ui/main/maincontent/GetProductListRequest;", "tigerBoxWebService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "provideInitServices", "Lmedia/tiger/tigerbox/InitServices;", "powerManagementService", "Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;", "provideLargeDownloadHandler", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler;", "provideRestartServicesSafely", "Lmedia/tiger/tigerbox/RestartServicesSafely;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@Module
/* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule */
/* compiled from: ProcessModule.kt */
public final class ProcessModule {
    public static final ProcessModule INSTANCE = new ProcessModule();

    private ProcessModule() {
    }

    @Singleton
    @Provides
    public final GenerateCsr provideGenerateCsr(RequestPemCertificateUseCase requestPemCertificateUseCase, StorageService storageService, MetaDataService metaDataService, WebServer webServer) {
        Intrinsics.checkNotNullParameter(requestPemCertificateUseCase, "requestPemCertificateUseCase");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(metaDataService, "metaDataService");
        Intrinsics.checkNotNullParameter(webServer, "webServer");
        return new GenerateCsr(requestPemCertificateUseCase, storageService, metaDataService, webServer);
    }

    @Singleton
    @Provides
    public final LargeDownloadHandler provideLargeDownloadHandler() {
        return DownloadForOta.INSTANCE;
    }

    @Singleton
    @Provides
    public final GetProductListRequest provideGetProductListRequest(TigerBoxWebService tigerBoxWebService, AvailabilityService availabilityService) {
        Intrinsics.checkNotNullParameter(tigerBoxWebService, "tigerBoxWebService");
        Intrinsics.checkNotNullParameter(availabilityService, "availabilityService");
        return new GetProductListRequest(tigerBoxWebService, availabilityService);
    }

    @Singleton
    @Provides
    public final InitServices provideInitServices(@ApplicationContext Context context, PowerManagementService powerManagementService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(powerManagementService, "powerManagementService");
        return new InitServices(context, powerManagementService);
    }

    @Singleton
    @Provides
    public final DatabaseMigrationService provideDatabaseMigrationService(DataMigrationService dataMigrationService) {
        Intrinsics.checkNotNullParameter(dataMigrationService, "dataMigrationService");
        return new DatabaseMigrationService(dataMigrationService);
    }

    @Singleton
    @Provides
    public final EngageDeepSleep provideEngageDeepSleep(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new EngageDeepSleep(context);
    }

    @Singleton
    @Provides
    public final RestartServicesSafely provideRestartServicesSafely(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new RestartServicesSafely(context);
    }

    @Provides
    public final AndroidSystemProperties provideAndroidSystemProperties() {
        return AndroidSystemProperties.INSTANCE;
    }

    @Provides
    public final AdbEnabler provideAdbEnabler(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ProcessModule$provideAdbEnabler$1(context);
    }
}
