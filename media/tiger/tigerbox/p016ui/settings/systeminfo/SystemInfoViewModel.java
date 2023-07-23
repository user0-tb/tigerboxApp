package media.tiger.tigerbox.p016ui.settings.systeminfo;

import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;

@Metadata(mo33736d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0017\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001a\u0010\u0010R\u001b\u0010\u001c\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001d\u0010\u0010R\u001b\u0010\u001f\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b \u0010\u0010R\u001b\u0010\"\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b#\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b&\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8FX\u0002¢\u0006\f\n\u0004\b,\u0010\u0012\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b/\u0010\u0012\u001a\u0004\b.\u0010\u0010R\u001b\u00100\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b2\u0010\u0012\u001a\u0004\b1\u0010\u0010R\u001b\u00103\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b5\u0010\u0012\u001a\u0004\b4\u0010\u0010¨\u00066"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoViewModel;", "Lmedia/tiger/tigerbox/ui/common/FullScreenViewModel;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "headerProvider", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "(Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;)V", "availableDiskSpace", "", "getAvailableDiskSpace", "()Ljava/lang/String;", "availableDiskSpace$delegate", "Lkotlin/Lazy;", "batteryPercentage", "getBatteryPercentage", "batteryPercentage$delegate", "configName", "getConfigName", "configName$delegate", "cpuId", "getCpuId", "cpuId$delegate", "firmwareVersion", "getFirmwareVersion", "firmwareVersion$delegate", "ipAddress", "getIpAddress", "ipAddress$delegate", "macAddress", "getMacAddress", "macAddress$delegate", "softwareVersion", "getSoftwareVersion", "softwareVersion$delegate", "storageUpdateDate", "", "getStorageUpdateDate", "()J", "storageUpdateDate$delegate", "usedDiskSpace", "getUsedDiskSpace", "usedDiskSpace$delegate", "userEmail", "getUserEmail", "userEmail$delegate", "versionDate", "getVersionDate", "versionDate$delegate", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel */
/* compiled from: SystemInfoViewModel.kt */
public final class SystemInfoViewModel extends FullScreenViewModel {
    private final Lazy availableDiskSpace$delegate = LazyKt.lazy(new SystemInfoViewModel$availableDiskSpace$2(this));
    private final Lazy batteryPercentage$delegate = LazyKt.lazy(new SystemInfoViewModel$batteryPercentage$2(this));
    private final Lazy configName$delegate = LazyKt.lazy(new SystemInfoViewModel$configName$2(this));
    /* access modifiers changed from: private */
    public final ConfigurationProperties configurationProperties;
    private final Lazy cpuId$delegate = LazyKt.lazy(new SystemInfoViewModel$cpuId$2(this));
    private final Lazy firmwareVersion$delegate = LazyKt.lazy(new SystemInfoViewModel$firmwareVersion$2(this));
    private final Lazy ipAddress$delegate = LazyKt.lazy(new SystemInfoViewModel$ipAddress$2(this));
    private final Lazy macAddress$delegate = LazyKt.lazy(new SystemInfoViewModel$macAddress$2(this));
    /* access modifiers changed from: private */
    public final MetaDataService metaDataService;
    private final Lazy softwareVersion$delegate = LazyKt.lazy(new SystemInfoViewModel$softwareVersion$2(this));
    /* access modifiers changed from: private */
    public final StorageService storageService;
    private final Lazy storageUpdateDate$delegate = LazyKt.lazy(new SystemInfoViewModel$storageUpdateDate$2(this));
    private final Lazy usedDiskSpace$delegate = LazyKt.lazy(new SystemInfoViewModel$usedDiskSpace$2(this));
    private final Lazy userEmail$delegate = LazyKt.lazy(new SystemInfoViewModel$userEmail$2(this));
    private final Lazy versionDate$delegate = LazyKt.lazy(new SystemInfoViewModel$versionDate$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public SystemInfoViewModel(ConfigurationProperties configurationProperties2, StorageService storageService2, MetaDataService metaDataService2, ButtonService buttonService, HeaderProvider headerProvider) {
        super(buttonService, headerProvider);
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(headerProvider, "headerProvider");
        this.configurationProperties = configurationProperties2;
        this.storageService = storageService2;
        this.metaDataService = metaDataService2;
    }

    public final String getVersionDate() {
        return (String) this.versionDate$delegate.getValue();
    }

    public final long getStorageUpdateDate() {
        return ((Number) this.storageUpdateDate$delegate.getValue()).longValue();
    }

    public final String getConfigName() {
        return (String) this.configName$delegate.getValue();
    }

    public final String getCpuId() {
        return (String) this.cpuId$delegate.getValue();
    }

    public final String getUserEmail() {
        return (String) this.userEmail$delegate.getValue();
    }

    public final String getIpAddress() {
        return (String) this.ipAddress$delegate.getValue();
    }

    public final String getMacAddress() {
        return (String) this.macAddress$delegate.getValue();
    }

    public final String getFirmwareVersion() {
        return (String) this.firmwareVersion$delegate.getValue();
    }

    public final String getSoftwareVersion() {
        return (String) this.softwareVersion$delegate.getValue();
    }

    public final String getBatteryPercentage() {
        return (String) this.batteryPercentage$delegate.getValue();
    }

    public final String getAvailableDiskSpace() {
        return (String) this.availableDiskSpace$delegate.getValue();
    }

    public final String getUsedDiskSpace() {
        return (String) this.usedDiskSpace$delegate.getValue();
    }
}
