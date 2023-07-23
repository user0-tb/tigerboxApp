package media.tiger.tigerbox;

import android.util.Log;
import dagger.hilt.android.HiltAndroidApp;
import java.net.URI;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.developer.AdbReceiver;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.SafeguardService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.usecase.PostCrashLogsUseCase;
import p012io.shipbook.shipbooksdk.ShipBook;

@Metadata(mo33736d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010H\u001a\u00020IH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010!\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b\"\u0010\u001eR\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0002018\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u0002078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u00020=8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u00020C8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006J"}, mo33737d2 = {"Lmedia/tiger/tigerbox/TigerBoxApplication;", "Landroid/app/Application;", "()V", "allowAdbTools", "", "getAllowAdbTools", "()Z", "allowLogging", "getAllowLogging", "allowOnlineLogs", "getAllowOnlineLogs", "allowToast", "getAllowToast", "autoLogs", "getAutoLogs", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "getConfigurationProperties", "()Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "setConfigurationProperties", "(Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "initServices", "Lmedia/tiger/tigerbox/InitServices;", "getInitServices", "()Lmedia/tiger/tigerbox/InitServices;", "setInitServices", "(Lmedia/tiger/tigerbox/InitServices;)V", "loggerApiKey", "", "getLoggerApiKey", "()Ljava/lang/String;", "loggerApiKey$delegate", "Lkotlin/Lazy;", "loggerAppId", "getLoggerAppId", "loggerAppId$delegate", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "getMetaDataService", "()Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "setMetaDataService", "(Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;)V", "postCrashLogsUseCase", "Lmedia/tiger/tigerbox/usecase/PostCrashLogsUseCase;", "getPostCrashLogsUseCase", "()Lmedia/tiger/tigerbox/usecase/PostCrashLogsUseCase;", "setPostCrashLogsUseCase", "(Lmedia/tiger/tigerbox/usecase/PostCrashLogsUseCase;)V", "safeguardService", "Lmedia/tiger/tigerbox/services/interfaces/SafeguardService;", "getSafeguardService", "()Lmedia/tiger/tigerbox/services/interfaces/SafeguardService;", "setSafeguardService", "(Lmedia/tiger/tigerbox/services/interfaces/SafeguardService;)V", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "getStorageService", "()Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "setStorageService", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;)V", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "getWifiService", "()Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "setWifiService", "(Lmedia/tiger/tigerbox/services/interfaces/WifiService;)V", "writeToFileExceptionHandler", "Lmedia/tiger/tigerbox/WriteToFileExceptionHandler;", "getWriteToFileExceptionHandler", "()Lmedia/tiger/tigerbox/WriteToFileExceptionHandler;", "setWriteToFileExceptionHandler", "(Lmedia/tiger/tigerbox/WriteToFileExceptionHandler;)V", "onCreate", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@HiltAndroidApp
/* compiled from: TigerBoxApplication.kt */
public final class TigerBoxApplication extends Hilt_TigerBoxApplication {
    @Inject
    public ConfigurationProperties configurationProperties;
    @Inject
    public InitServices initServices;
    private final Lazy loggerApiKey$delegate = LazyKt.lazy(new TigerBoxApplication$loggerApiKey$2(this));
    private final Lazy loggerAppId$delegate = LazyKt.lazy(new TigerBoxApplication$loggerAppId$2(this));
    @Inject
    public MetaDataService metaDataService;
    @Inject
    public PostCrashLogsUseCase postCrashLogsUseCase;
    @Inject
    public SafeguardService safeguardService;
    @Inject
    public StorageService storageService;
    @Inject
    public WifiService wifiService;
    @Inject
    public WriteToFileExceptionHandler writeToFileExceptionHandler;

    public final ConfigurationProperties getConfigurationProperties() {
        ConfigurationProperties configurationProperties2 = this.configurationProperties;
        if (configurationProperties2 != null) {
            return configurationProperties2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationProperties");
        return null;
    }

    public final void setConfigurationProperties(ConfigurationProperties configurationProperties2) {
        Intrinsics.checkNotNullParameter(configurationProperties2, "<set-?>");
        this.configurationProperties = configurationProperties2;
    }

    public final InitServices getInitServices() {
        InitServices initServices2 = this.initServices;
        if (initServices2 != null) {
            return initServices2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initServices");
        return null;
    }

    public final void setInitServices(InitServices initServices2) {
        Intrinsics.checkNotNullParameter(initServices2, "<set-?>");
        this.initServices = initServices2;
    }

    public final MetaDataService getMetaDataService() {
        MetaDataService metaDataService2 = this.metaDataService;
        if (metaDataService2 != null) {
            return metaDataService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("metaDataService");
        return null;
    }

    public final void setMetaDataService(MetaDataService metaDataService2) {
        Intrinsics.checkNotNullParameter(metaDataService2, "<set-?>");
        this.metaDataService = metaDataService2;
    }

    public final StorageService getStorageService() {
        StorageService storageService2 = this.storageService;
        if (storageService2 != null) {
            return storageService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storageService");
        return null;
    }

    public final void setStorageService(StorageService storageService2) {
        Intrinsics.checkNotNullParameter(storageService2, "<set-?>");
        this.storageService = storageService2;
    }

    public final WifiService getWifiService() {
        WifiService wifiService2 = this.wifiService;
        if (wifiService2 != null) {
            return wifiService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("wifiService");
        return null;
    }

    public final void setWifiService(WifiService wifiService2) {
        Intrinsics.checkNotNullParameter(wifiService2, "<set-?>");
        this.wifiService = wifiService2;
    }

    public final SafeguardService getSafeguardService() {
        SafeguardService safeguardService2 = this.safeguardService;
        if (safeguardService2 != null) {
            return safeguardService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("safeguardService");
        return null;
    }

    public final void setSafeguardService(SafeguardService safeguardService2) {
        Intrinsics.checkNotNullParameter(safeguardService2, "<set-?>");
        this.safeguardService = safeguardService2;
    }

    public final PostCrashLogsUseCase getPostCrashLogsUseCase() {
        PostCrashLogsUseCase postCrashLogsUseCase2 = this.postCrashLogsUseCase;
        if (postCrashLogsUseCase2 != null) {
            return postCrashLogsUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("postCrashLogsUseCase");
        return null;
    }

    public final void setPostCrashLogsUseCase(PostCrashLogsUseCase postCrashLogsUseCase2) {
        Intrinsics.checkNotNullParameter(postCrashLogsUseCase2, "<set-?>");
        this.postCrashLogsUseCase = postCrashLogsUseCase2;
    }

    public final WriteToFileExceptionHandler getWriteToFileExceptionHandler() {
        WriteToFileExceptionHandler writeToFileExceptionHandler2 = this.writeToFileExceptionHandler;
        if (writeToFileExceptionHandler2 != null) {
            return writeToFileExceptionHandler2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("writeToFileExceptionHandler");
        return null;
    }

    public final void setWriteToFileExceptionHandler(WriteToFileExceptionHandler writeToFileExceptionHandler2) {
        Intrinsics.checkNotNullParameter(writeToFileExceptionHandler2, "<set-?>");
        this.writeToFileExceptionHandler = writeToFileExceptionHandler2;
    }

    private final boolean getAllowLogging() {
        return Boolean.parseBoolean(getConfigurationProperties().getProperty("log.enabled"));
    }

    private final boolean getAutoLogs() {
        return getStorageService().getFlagAutoLogsEnabled();
    }

    private final boolean getAllowOnlineLogs() {
        return Boolean.parseBoolean(getConfigurationProperties().getProperty("log.allowOnline"));
    }

    public final boolean getAllowToast() {
        return Boolean.parseBoolean(getConfigurationProperties().getProperty("toast.enabled"));
    }

    private final boolean getAllowAdbTools() {
        return Boolean.parseBoolean(getConfigurationProperties().getProperty("adb.tools.enabled"));
    }

    private final String getLoggerApiKey() {
        return (String) this.loggerApiKey$delegate.getValue();
    }

    private final String getLoggerAppId() {
        return (String) this.loggerAppId$delegate.getValue();
    }

    public void onCreate() {
        Log.e("TigerBoxApplication", "onCreate - Before super.onCreate");
        super.onCreate();
        Log.e("TigerBoxApplication", "onCreate - After super.onCreate");
        if ((getAllowLogging() || getAutoLogs()) && getAllowOnlineLogs()) {
            ShipBook.Companion.start$default(ShipBook.Companion, this, getLoggerAppId(), getLoggerApiKey(), (Function1) null, (URI) null, 24, (Object) null);
        }
        if (getAllowAdbTools()) {
            AdbReceiver.Companion.registerInstance(this);
        }
        getInitServices().invoke();
        registerActivityLifecycleCallbacks(new TigerBoxApplication$onCreate$1(this));
    }
}
