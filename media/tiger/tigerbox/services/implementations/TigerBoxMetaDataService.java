package media.tiger.tigerbox.services.implementations;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.properties.AndroidSystemProperties;
import media.tiger.tigerbox.model.domain.BatteryState;
import media.tiger.tigerbox.model.dto.DeviceInformation;
import media.tiger.tigerbox.services.implementations.timersController.WindowedLimits;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.DisplayNameChangedListener;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.NightLightTimerService;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.VolumeChangedListener;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;
import media.tiger.tigerbox.utils.BytesUtilsKt;
import media.tiger.tigerbox.webserver.dto.DeviceInfoDto;
import media.tiger.tigerbox.webserver.dto.LogoLight;
import media.tiger.tigerbox.webserver.dto.NightLight;
import media.tiger.tigerbox.webserver.dto.UpdateDeviceInfoDto;
import media.tiger.tigerbox.webserver.dto.WindowedTimerDto;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000·\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001O\u0018\u0000 w2\u00020\u0001:\u0001wB}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 J\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020'H\u0002J\b\u0010c\u001a\u00020aH\u0002J\b\u0010d\u001a\u00020aH\u0002J\b\u0010e\u001a\u00020aH\u0016J\b\u0010f\u001a\u00020gH\u0016J\u0010\u0010h\u001a\u00020'2\u0006\u0010i\u001a\u00020'H\u0002J\u0010\u0010j\u001a\u00020a2\u0006\u0010k\u001a\u00020\"H\u0016J\u0010\u0010l\u001a\u00020a2\u0006\u0010m\u001a\u000200H\u0016J\u0010\u0010n\u001a\u00020a2\u0006\u0010m\u001a\u00020DH\u0016J\u0010\u0010o\u001a\u00020a2\u0006\u0010m\u001a\u00020DH\u0016J\b\u0010p\u001a\u00020aH\u0016J\u0010\u0010q\u001a\u00020a2\u0006\u0010m\u001a\u000200H\u0016J\u0010\u0010r\u001a\u00020a2\u0006\u0010m\u001a\u00020DH\u0016J\u0010\u0010s\u001a\u00020a2\u0006\u0010m\u001a\u00020DH\u0016J\u0010\u0010t\u001a\u00020a2\u0006\u0010u\u001a\u00020vH\u0016R\u001e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@BX\u000e¢\u0006\b\n\u0000\"\u0004\b$\u0010%R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010)R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b2\u0010)R\u0014\u00103\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010)R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010)R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010)R$\u0010>\u001a\u00020=2\u0006\u0010<\u001a\u00020=8V@VX\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020D0/X\u0004¢\u0006\u0002\n\u0000R$\u0010G\u001a\u00020F2\u0006\u0010E\u001a\u00020F8V@VX\u000e¢\u0006\f\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\bM\u0010)R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u00020OX\u0004¢\u0006\u0004\n\u0002\u0010PR$\u0010Q\u001a\u00020=2\u0006\u0010<\u001a\u00020=8V@VX\u000e¢\u0006\f\u001a\u0004\bR\u0010@\"\u0004\bS\u0010BR\u001b\u0010T\u001a\u00020'8VX\u0002¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bU\u0010)R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\bY\u0010)R\u0014\u0010Z\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010)R$\u0010\\\u001a\u00020=2\u0006\u0010!\u001a\u00020=8V@VX\u000e¢\u0006\f\u001a\u0004\b]\u0010@\"\u0004\b^\u0010BR\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020D0/X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006x"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/TigerBoxMetaDataService;", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "context", "Landroid/content/Context;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "batteryService", "Lmedia/tiger/tigerbox/services/interfaces/BatteryService;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "nightLightTimerService", "Lmedia/tiger/tigerbox/services/interfaces/NightLightTimerService;", "lightControlService", "Lmedia/tiger/tigerbox/services/interfaces/LightControlService;", "audioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "powerManagementService", "Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;", "shutDownTimerService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimerService;", "timersController", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "infoSoundService", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "systemProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/AndroidSystemProperties;", "getTigerBoxAccountUseCase", "Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/services/interfaces/BatteryService;Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;Lmedia/tiger/tigerbox/services/interfaces/NightLightTimerService;Lmedia/tiger/tigerbox/services/interfaces/LightControlService;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimerService;Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;Lmedia/tiger/tigerbox/services/interfaces/TimeService;Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;Lmedia/tiger/tigerbox/infrastructure/properties/AndroidSystemProperties;Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;)V", "newValue", "", "_headphonesPlugged", "set_headphonesPlugged", "(Z)V", "availableDiskSpace", "", "getAvailableDiskSpace", "()Ljava/lang/String;", "batteryPercentage", "getBatteryPercentage", "cpuId", "getCpuId", "displayNameChangedListeners", "", "Lmedia/tiger/tigerbox/services/interfaces/DisplayNameChangedListener;", "domain", "getDomain", "firmwareVersion", "getFirmwareVersion", "headphonesPlugged", "getHeadphonesPlugged", "()Z", "ipAddress", "getIpAddress", "macAddress", "getMacAddress", "value", "", "maxVolume", "getMaxVolume", "()I", "setMaxVolume", "(I)V", "maxVolumeChangedListeners", "Lmedia/tiger/tigerbox/services/interfaces/VolumeChangedListener;", "newUnit", "", "musicVolumeUnit", "getMusicVolumeUnit", "()F", "setMusicVolumeUnit", "(F)V", "netHostname", "getNetHostname", "powerOffReceiver", "media/tiger/tigerbox/services/implementations/TigerBoxMetaDataService$powerOffReceiver$1", "Lmedia/tiger/tigerbox/services/implementations/TigerBoxMetaDataService$powerOffReceiver$1;", "screenBrightness", "getScreenBrightness", "setScreenBrightness", "serialNumber", "getSerialNumber", "serialNumber$delegate", "Lkotlin/Lazy;", "usedDiskSpace", "getUsedDiskSpace", "userEmail", "getUserEmail", "volume", "getVolume", "setVolume", "volumeChangedListeners", "alertDisplayNameSubscribers", "", "name", "alertMaxVolumeSubscribers", "alertVolumeSubscribers", "clearAllDataAndReboot", "getDeviceInfo", "Lmedia/tiger/tigerbox/webserver/dto/DeviceInfoDto;", "getSystemProperty", "reference", "notifyHeadphonesStateChanged", "plugged", "registerDisplayNameChangeListener", "listener", "registerMaxVolumeChangeListener", "registerVolumeChangeListener", "saveSystemState", "unregisterDisplayNameChangeListener", "unregisterMaxVolumeChangeListener", "unregisterVolumeChangeListener", "updateDeviceInfo", "updateDeviceInfoDto", "Lmedia/tiger/tigerbox/webserver/dto/UpdateDeviceInfoDto;", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxMetaDataService.kt */
public final class TigerBoxMetaDataService implements MetaDataService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float MAX_HEADPHONES_VOLUME_UNIT = 0.75f;
    public static final int MAX_SAFE_VOLUME = 100;
    private boolean _headphonesPlugged;
    /* access modifiers changed from: private */
    public final AudioPlayerService audioPlayerService;
    /* access modifiers changed from: private */
    public final AvailabilityService availabilityService;
    private final BatteryService batteryService;
    /* access modifiers changed from: private */
    public final Context context;
    private final List<DisplayNameChangedListener> displayNameChangedListeners = new ArrayList();
    private final GetTigerBoxAccountUseCase getTigerBoxAccountUseCase;
    /* access modifiers changed from: private */
    public final InfoSoundService infoSoundService;
    /* access modifiers changed from: private */
    public final LightControlService lightControlService;
    private final List<VolumeChangedListener> maxVolumeChangedListeners = new ArrayList();
    /* access modifiers changed from: private */
    public final NightLightTimerService nightLightTimerService;
    /* access modifiers changed from: private */
    public final PowerManagementService powerManagementService;
    private final TigerBoxMetaDataService$powerOffReceiver$1 powerOffReceiver;
    private final Lazy serialNumber$delegate;
    /* access modifiers changed from: private */
    public final ShutDownTimerService shutDownTimerService;
    /* access modifiers changed from: private */
    public final StorageService storageService;
    private final AndroidSystemProperties systemProperties;
    /* access modifiers changed from: private */
    public final TimeService timeService;
    /* access modifiers changed from: private */
    public final TimersControllerService timersController;
    private final List<VolumeChangedListener> volumeChangedListeners = new ArrayList();
    /* access modifiers changed from: private */
    public final WifiService wifiService;

    public String getDomain() {
        return "tigerbox";
    }

    public TigerBoxMetaDataService(Context context2, StorageService storageService2, WifiService wifiService2, BatteryService batteryService2, AvailabilityService availabilityService2, NightLightTimerService nightLightTimerService2, LightControlService lightControlService2, AudioPlayerService audioPlayerService2, PowerManagementService powerManagementService2, ShutDownTimerService shutDownTimerService2, TimersControllerService timersControllerService, TimeService timeService2, InfoSoundService infoSoundService2, AndroidSystemProperties androidSystemProperties, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase2) {
        Context context3 = context2;
        StorageService storageService3 = storageService2;
        WifiService wifiService3 = wifiService2;
        BatteryService batteryService3 = batteryService2;
        AvailabilityService availabilityService3 = availabilityService2;
        NightLightTimerService nightLightTimerService3 = nightLightTimerService2;
        LightControlService lightControlService3 = lightControlService2;
        AudioPlayerService audioPlayerService3 = audioPlayerService2;
        PowerManagementService powerManagementService3 = powerManagementService2;
        ShutDownTimerService shutDownTimerService3 = shutDownTimerService2;
        TimersControllerService timersControllerService2 = timersControllerService;
        TimeService timeService3 = timeService2;
        InfoSoundService infoSoundService3 = infoSoundService2;
        AndroidSystemProperties androidSystemProperties2 = androidSystemProperties;
        GetTigerBoxAccountUseCase getTigerBoxAccountUseCase3 = getTigerBoxAccountUseCase2;
        Intrinsics.checkNotNullParameter(context3, "context");
        Intrinsics.checkNotNullParameter(storageService3, "storageService");
        Intrinsics.checkNotNullParameter(wifiService3, "wifiService");
        Intrinsics.checkNotNullParameter(batteryService3, "batteryService");
        Intrinsics.checkNotNullParameter(availabilityService3, "availabilityService");
        Intrinsics.checkNotNullParameter(nightLightTimerService3, "nightLightTimerService");
        Intrinsics.checkNotNullParameter(lightControlService3, "lightControlService");
        Intrinsics.checkNotNullParameter(audioPlayerService3, "audioPlayerService");
        Intrinsics.checkNotNullParameter(powerManagementService3, "powerManagementService");
        Intrinsics.checkNotNullParameter(shutDownTimerService3, "shutDownTimerService");
        Intrinsics.checkNotNullParameter(timersControllerService2, "timersController");
        Intrinsics.checkNotNullParameter(timeService3, "timeService");
        Intrinsics.checkNotNullParameter(infoSoundService3, "infoSoundService");
        Intrinsics.checkNotNullParameter(androidSystemProperties2, "systemProperties");
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase3, "getTigerBoxAccountUseCase");
        this.context = context3;
        this.storageService = storageService3;
        this.wifiService = wifiService3;
        this.batteryService = batteryService3;
        this.availabilityService = availabilityService3;
        this.nightLightTimerService = nightLightTimerService3;
        this.lightControlService = lightControlService3;
        this.audioPlayerService = audioPlayerService3;
        this.powerManagementService = powerManagementService3;
        this.shutDownTimerService = shutDownTimerService3;
        this.timersController = timersControllerService2;
        this.timeService = timeService3;
        this.infoSoundService = infoSoundService3;
        this.systemProperties = androidSystemProperties2;
        this.getTigerBoxAccountUseCase = getTigerBoxAccountUseCase3;
        TigerBoxMetaDataService$powerOffReceiver$1 tigerBoxMetaDataService$powerOffReceiver$1 = new TigerBoxMetaDataService$powerOffReceiver$1(this);
        this.powerOffReceiver = tigerBoxMetaDataService$powerOffReceiver$1;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
        Unit unit = Unit.INSTANCE;
        context3.registerReceiver(tigerBoxMetaDataService$powerOffReceiver$1, intentFilter);
        audioPlayerService3.updateStreamMusicVolume(getVolume());
        this.serialNumber$delegate = LazyKt.lazy(new TigerBoxMetaDataService$serialNumber$2(this));
    }

    public String getUserEmail() {
        return this.getTigerBoxAccountUseCase.invoke().getUser().getEmail();
    }

    public String getIpAddress() {
        return this.wifiService.getIpAddress();
    }

    public String getNetHostname() {
        return getCpuId() + '-' + getDomain() + ".local.";
    }

    public String getMacAddress() {
        return this.wifiService.getMacAddress();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCpuId() {
        /*
            r11 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/proc/cpuinfo"
            r0.<init>(r1)
            r1 = 0
            r2 = 1
            java.util.List r0 = kotlin.p013io.FilesKt.readLines$default(r0, r1, r2, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0013:
            boolean r3 = r0.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x002f
            java.lang.Object r3 = r0.next()
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r6 = "cpuid"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 2
            boolean r5 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r6, (boolean) r4, (int) r7, (java.lang.Object) r1)
            if (r5 == 0) goto L_0x0013
            goto L_0x0030
        L_0x002f:
            r3 = r1
        L_0x0030:
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x004e
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            char[] r6 = new char[r2]
            r0 = 58
            r6[r4] = r0
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r5, (char[]) r6, (boolean) r7, (int) r8, (int) r9, (java.lang.Object) r10)
            if (r0 == 0) goto L_0x004e
            java.lang.Object r0 = r0.get(r2)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L_0x004e:
            java.lang.String r0 = java.lang.String.valueOf(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r0)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.TigerBoxMetaDataService.getCpuId():java.lang.String");
    }

    public String getSerialNumber() {
        return (String) this.serialNumber$delegate.getValue();
    }

    public String getFirmwareVersion() {
        String str = Build.DISPLAY;
        Intrinsics.checkNotNullExpressionValue(str, "DISPLAY");
        return str;
    }

    public String getBatteryPercentage() {
        return String.valueOf((int) this.batteryService.getBatteryPercent());
    }

    public String getAvailableDiskSpace() {
        return BytesUtilsKt.bytesToString(this.availabilityService.getAvailableBytes());
    }

    public String getUsedDiskSpace() {
        return BytesUtilsKt.bytesToString(this.availabilityService.getTotalBytes() - this.availabilityService.getAvailableBytes());
    }

    public DeviceInfoDto getDeviceInfo() {
        String str;
        byte uByte = UStringsKt.toUByte(getBatteryPercentage());
        BatteryState r4 = BatteryState.Companion.m2338getBatteryStateFromPercentage7apg3OU(UStringsKt.toUByte(getBatteryPercentage()));
        String cpuId = getCpuId();
        String displayName = this.storageService.getDisplayName();
        DeviceInformation deviceInformation = this.storageService.getDeviceInformation();
        if (deviceInformation == null || (str = deviceInformation.getDeviceType()) == null) {
            str = "PREMIUMBOX";
        }
        String str2 = str;
        String firmwareVersion = getFirmwareVersion();
        List listOf = CollectionsKt.listOf((byte) 0, (byte) 100);
        LogoLight logoLight = new LogoLight(Boolean.valueOf(this.lightControlService.isTigerLightEnabled()), Integer.valueOf(this.lightControlService.getTigerLightIntensity()));
        byte r13 = UByte.m790constructorimpl((byte) getMaxVolume());
        float musicVolumeUnit = getMusicVolumeUnit();
        byte r16 = UByte.m790constructorimpl((byte) getVolume());
        boolean isMusicLightEnabled = this.lightControlService.isMusicLightEnabled();
        NightLight nightLightTimer = this.storageService.getNightLightTimer();
        short initialShutDownTimeSeconds = (short) this.shutDownTimerService.getInitialShutDownTimeSeconds();
        int initialLimitSeconds = this.storageService.getTimeLimit().getInitialLimitSeconds();
        Iterable limits = this.storageService.getWindowedLimit().getLimits();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(limits, 10));
        for (Iterator it = limits.iterator(); it.hasNext(); it = it) {
            WindowedLimits.WindowedLimit windowedLimit = (WindowedLimits.WindowedLimit) it.next();
            arrayList.add(new WindowedTimerDto(windowedLimit.getWindowStart(), windowedLimit.getWindowEnd()));
        }
        float f = musicVolumeUnit;
        long j = (long) 1048576;
        List list = listOf;
        LogoLight logoLight2 = logoLight;
        byte b = r13;
        float f2 = f;
        byte b2 = r16;
        boolean z = isMusicLightEnabled;
        NightLight nightLight = nightLightTimer;
        short s = initialShutDownTimeSeconds;
        int i = initialLimitSeconds;
        DeviceInfoDto deviceInfoDto = new DeviceInfoDto(uByte, r4, false, cpuId, displayName, str2, firmwareVersion, list, logoLight2, b, f2, b2, z, nightLight, s, i, (List) arrayList, 0, this.timeService.getCurrentInstantTime(), this.infoSoundService.getSystemSoundEnabled(), UInt.m866constructorimpl((int) (this.availabilityService.getAvailableBytes() / j)), UInt.m866constructorimpl((int) ((this.availabilityService.getTotalBytes() - this.availabilityService.getAvailableBytes()) / j)), CollectionsKt.listOf((byte) 0, Byte.valueOf((byte) this.audioPlayerService.getStreamMaxVolume())), true, (DefaultConstructorMarker) null);
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("Sending device info: " + deviceInfoDto, new Object[0]);
        return deviceInfoDto;
    }

    public void updateDeviceInfo(UpdateDeviceInfoDto updateDeviceInfoDto) {
        Intrinsics.checkNotNullParameter(updateDeviceInfoDto, "updateDeviceInfoDto");
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("Updating device info " + updateDeviceInfoDto, new Object[0]);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), (CoroutineContext) null, (CoroutineStart) null, new TigerBoxMetaDataService$updateDeviceInfo$1(updateDeviceInfoDto, this, (Continuation<? super TigerBoxMetaDataService$updateDeviceInfo$1>) null), 3, (Object) null);
    }

    private final void set_headphonesPlugged(boolean z) {
        this._headphonesPlugged = z;
        this.audioPlayerService.updateStreamMusicVolume(getVolume());
        alertVolumeSubscribers();
    }

    public boolean getHeadphonesPlugged() {
        return this._headphonesPlugged;
    }

    public void notifyHeadphonesStateChanged(boolean z) {
        set_headphonesPlugged(z);
        alertVolumeSubscribers();
    }

    public float getMusicVolumeUnit() {
        return this.storageService.getVolume(0.4f);
    }

    public void setMusicVolumeUnit(float f) {
        this.storageService.saveVolume(Math.max(Math.min(f, 1.0f), 0.0f));
        setVolume(getVolume());
    }

    public int getVolume() {
        return (int) (((float) getMaxVolume()) * this.storageService.getVolume(0.4f));
    }

    public void setVolume(int i) {
        this.storageService.saveVolume(getMaxVolume() <= 0 ? 0.0f : ((float) Math.max(Math.min(i, getMaxVolume()), 0)) / ((float) getMaxVolume()));
        this.audioPlayerService.updateStreamMusicVolume(i);
        alertVolumeSubscribers();
    }

    public void setMaxVolume(int i) {
        this.storageService.setCurrentMaxVolume(i);
    }

    public int getMaxVolume() {
        return (int) (((float) this.storageService.getCurrentMaxVolume()) * (getHeadphonesPlugged() ? 0.75f : 1.0f));
    }

    private final void alertVolumeSubscribers() {
        for (VolumeChangedListener onVolumeChanged : this.volumeChangedListeners) {
            onVolumeChanged.onVolumeChanged(getVolume());
        }
    }

    public void registerVolumeChangeListener(VolumeChangedListener volumeChangedListener) {
        Intrinsics.checkNotNullParameter(volumeChangedListener, "listener");
        this.volumeChangedListeners.add(volumeChangedListener);
    }

    public void unregisterVolumeChangeListener(VolumeChangedListener volumeChangedListener) {
        Intrinsics.checkNotNullParameter(volumeChangedListener, "listener");
        if (this.volumeChangedListeners.contains(volumeChangedListener)) {
            this.volumeChangedListeners.remove(volumeChangedListener);
        }
    }

    /* access modifiers changed from: private */
    public final void alertMaxVolumeSubscribers() {
        for (VolumeChangedListener onVolumeChanged : this.maxVolumeChangedListeners) {
            onVolumeChanged.onVolumeChanged(getVolume());
        }
    }

    public void registerMaxVolumeChangeListener(VolumeChangedListener volumeChangedListener) {
        Intrinsics.checkNotNullParameter(volumeChangedListener, "listener");
        this.maxVolumeChangedListeners.add(volumeChangedListener);
    }

    public void unregisterMaxVolumeChangeListener(VolumeChangedListener volumeChangedListener) {
        Intrinsics.checkNotNullParameter(volumeChangedListener, "listener");
        if (this.maxVolumeChangedListeners.contains(volumeChangedListener)) {
            this.maxVolumeChangedListeners.remove(volumeChangedListener);
        }
    }

    /* access modifiers changed from: private */
    public final void alertDisplayNameSubscribers(String str) {
        for (DisplayNameChangedListener onDisplayNameChanged : this.displayNameChangedListeners) {
            onDisplayNameChanged.onDisplayNameChanged(str);
        }
    }

    public void registerDisplayNameChangeListener(DisplayNameChangedListener displayNameChangedListener) {
        Intrinsics.checkNotNullParameter(displayNameChangedListener, "listener");
        if (!this.displayNameChangedListeners.contains(displayNameChangedListener)) {
            this.displayNameChangedListeners.add(displayNameChangedListener);
        }
    }

    public void unregisterDisplayNameChangeListener(DisplayNameChangedListener displayNameChangedListener) {
        Intrinsics.checkNotNullParameter(displayNameChangedListener, "listener");
        this.displayNameChangedListeners.remove(displayNameChangedListener);
    }

    public int getScreenBrightness() {
        return Settings.System.getInt(this.context.getContentResolver(), "screen_brightness", 255);
    }

    public void setScreenBrightness(int i) {
        Settings.System.putInt(this.context.getContentResolver(), "screen_brightness", Math.min(255, Math.max(i, 0)));
    }

    public void saveSystemState() {
        this.audioPlayerService.pause();
        this.lightControlService.prepareLightsForShutdown();
    }

    public void clearAllDataAndReboot() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new TigerBoxMetaDataService$clearAllDataAndReboot$1(this, (Continuation<? super TigerBoxMetaDataService$clearAllDataAndReboot$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final String getSystemProperty(String str) {
        return this.systemProperties.invoke(str);
    }

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/TigerBoxMetaDataService$Companion;", "", "()V", "MAX_HEADPHONES_VOLUME_UNIT", "", "MAX_SAFE_VOLUME", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerBoxMetaDataService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
