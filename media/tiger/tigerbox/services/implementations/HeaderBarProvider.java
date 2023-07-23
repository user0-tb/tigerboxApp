package media.tiger.tigerbox.services.implementations;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.BatterySummary;
import media.tiger.tigerbox.model.domain.WifiStrength;
import media.tiger.tigerbox.services.implementations.timersController.LockedModeReason;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;

@Metadata(mo33736d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0007\n\u0002\b\u0005\n\u0002\b\f\n\u0002\b\n\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0007&16=BNX\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\b\u0010d\u001a\u00020eH\u0016J\b\u0010f\u001a\u00020eH\u0016J\u0010\u0010g\u001a\u00020e2\u0006\u0010h\u001a\u00020\u001fH\u0016R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001a0\u001a0\u0016X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001a0\u001a0\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0010\u0010%\u001a\u00020&X\u0004¢\u0006\u0004\n\u0002\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170+8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0+8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010-R\u0010\u00100\u001a\u000201X\u0004¢\u0006\u0004\n\u0002\u00102R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u001a0+8VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010-R\u0010\u00105\u001a\u000206X\u0004¢\u0006\u0004\n\u0002\u00107R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001d0+8VX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010-R\u0010\u0010<\u001a\u00020=X\u0004¢\u0006\u0004\n\u0002\u0010>R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001f0+8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010-R\u0010\u0010A\u001a\u00020BX\u0004¢\u0006\u0004\n\u0002\u0010CR(\u0010D\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001a0\u001a0\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001f0+8VX\u0004¢\u0006\u0006\u001a\u0004\bL\u0010-R\u0010\u0010M\u001a\u00020NX\u0004¢\u0006\u0004\n\u0002\u0010OR!\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001a0+8VX\u0002¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bQ\u0010-R(\u0010T\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001a0\u001a0\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010F\"\u0004\bV\u0010HR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u00020XX\u0004¢\u0006\u0004\n\u0002\u0010YR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001f0+8VX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010-R\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001f0+8VX\u0004¢\u0006\u0006\u001a\u0004\b]\u0010-R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R!\u0010`\u001a\b\u0012\u0004\u0012\u00020a0+8VX\u0002¢\u0006\f\n\u0004\bc\u0010S\u001a\u0004\bb\u0010-¨\u0006i"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/HeaderBarProvider;", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "batteryService", "Lmedia/tiger/tigerbox/services/interfaces/BatteryService;", "shutDownTimerService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimerService;", "timersController", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "infoSoundService", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "audioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "firmwareUpdateService", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService;", "(Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/services/interfaces/BatteryService;Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimerService;Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService;)V", "_batterySummary", "Landroidx/lifecycle/MutableLiveData;", "Lmedia/tiger/tigerbox/model/domain/BatterySummary;", "kotlin.jvm.PlatformType", "_downloadsInProgress", "", "_firmwareUpdateAvailable", "_lockedMode", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeReason;", "_maxVolumeChanged", "", "_musicVolumeChanged", "_sleepTimeTick", "_timeLimitTick", "getAvailabilityService", "()Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "batteryChangesListener", "media/tiger/tigerbox/services/implementations/HeaderBarProvider$batteryChangesListener$1", "Lmedia/tiger/tigerbox/services/implementations/HeaderBarProvider$batteryChangesListener$1;", "getBatteryService", "()Lmedia/tiger/tigerbox/services/interfaces/BatteryService;", "batterySummary", "Landroidx/lifecycle/LiveData;", "getBatterySummary", "()Landroidx/lifecycle/LiveData;", "downloadsInProgress", "getDownloadsInProgress", "downloadsListener", "media/tiger/tigerbox/services/implementations/HeaderBarProvider$downloadsListener$1", "Lmedia/tiger/tigerbox/services/implementations/HeaderBarProvider$downloadsListener$1;", "firmwareUpdateAvailable", "getFirmwareUpdateAvailable", "firmwareUpdateListener", "media/tiger/tigerbox/services/implementations/HeaderBarProvider$firmwareUpdateListener$1", "Lmedia/tiger/tigerbox/services/implementations/HeaderBarProvider$firmwareUpdateListener$1;", "getInfoSoundService", "()Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "lockedMode", "getLockedMode", "lockedModeListener", "media/tiger/tigerbox/services/implementations/HeaderBarProvider$lockedModeListener$1", "Lmedia/tiger/tigerbox/services/implementations/HeaderBarProvider$lockedModeListener$1;", "maxVolumeChanged", "getMaxVolumeChanged", "maxVolumeListener", "media/tiger/tigerbox/services/implementations/HeaderBarProvider$maxVolumeListener$1", "Lmedia/tiger/tigerbox/services/implementations/HeaderBarProvider$maxVolumeListener$1;", "mediaPlayerOpened", "getMediaPlayerOpened", "()Landroidx/lifecycle/MutableLiveData;", "setMediaPlayerOpened", "(Landroidx/lifecycle/MutableLiveData;)V", "getMetaDataService", "()Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "musicVolumeChanged", "getMusicVolumeChanged", "musicVolumeListener", "media/tiger/tigerbox/services/implementations/HeaderBarProvider$musicVolumeListener$1", "Lmedia/tiger/tigerbox/services/implementations/HeaderBarProvider$musicVolumeListener$1;", "offlineMode", "getOfflineMode", "offlineMode$delegate", "Lkotlin/Lazy;", "settingsOpened", "getSettingsOpened", "setSettingsOpened", "sleepTimeListener", "media/tiger/tigerbox/services/implementations/HeaderBarProvider$sleepTimeListener$1", "Lmedia/tiger/tigerbox/services/implementations/HeaderBarProvider$sleepTimeListener$1;", "sleepTimeTick", "getSleepTimeTick", "timeLimitTick", "getTimeLimitTick", "getWifiService", "()Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "wifiSignalStrength", "Lmedia/tiger/tigerbox/model/domain/WifiStrength;", "getWifiSignalStrength", "wifiSignalStrength$delegate", "subscribe", "", "unsubscribe", "updateShutDownTimeTick", "seconds", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HeaderBarProvider.kt */
public final class HeaderBarProvider implements HeaderProvider {
    /* access modifiers changed from: private */
    public final MutableLiveData<BatterySummary> _batterySummary;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _downloadsInProgress = new MutableLiveData<>(false);
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _firmwareUpdateAvailable = new MutableLiveData<>(false);
    /* access modifiers changed from: private */
    public final MutableLiveData<LockedModeReason> _lockedMode = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Integer> _maxVolumeChanged = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Integer> _musicVolumeChanged = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Integer> _sleepTimeTick = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Integer> _timeLimitTick = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final AudioPlayerService audioPlayerService;
    private final AvailabilityService availabilityService;
    private final HeaderBarProvider$batteryChangesListener$1 batteryChangesListener = new HeaderBarProvider$batteryChangesListener$1(this);
    private final BatteryService batteryService;
    private final HeaderBarProvider$downloadsListener$1 downloadsListener = new HeaderBarProvider$downloadsListener$1(this);
    private final HeaderBarProvider$firmwareUpdateListener$1 firmwareUpdateListener = new HeaderBarProvider$firmwareUpdateListener$1(this);
    /* access modifiers changed from: private */
    public final FirmwareUpdateService firmwareUpdateService;
    private final InfoSoundService infoSoundService;
    private final HeaderBarProvider$lockedModeListener$1 lockedModeListener = new HeaderBarProvider$lockedModeListener$1(this);
    private final HeaderBarProvider$maxVolumeListener$1 maxVolumeListener = new HeaderBarProvider$maxVolumeListener$1(this);
    private MutableLiveData<Boolean> mediaPlayerOpened = new MutableLiveData<>(false);
    private final MetaDataService metaDataService;
    private final HeaderBarProvider$musicVolumeListener$1 musicVolumeListener = new HeaderBarProvider$musicVolumeListener$1(this);
    private final Lazy offlineMode$delegate = LazyKt.lazy(new HeaderBarProvider$offlineMode$2(this));
    private MutableLiveData<Boolean> settingsOpened = new MutableLiveData<>(false);
    private final ShutDownTimerService shutDownTimerService;
    private final HeaderBarProvider$sleepTimeListener$1 sleepTimeListener = new HeaderBarProvider$sleepTimeListener$1(this);
    private final TimersControllerService timersController;
    private final WifiService wifiService;
    private final Lazy wifiSignalStrength$delegate = LazyKt.lazy(new HeaderBarProvider$wifiSignalStrength$2(this));

    public HeaderBarProvider(WifiService wifiService2, BatteryService batteryService2, ShutDownTimerService shutDownTimerService2, TimersControllerService timersControllerService, AvailabilityService availabilityService2, MetaDataService metaDataService2, InfoSoundService infoSoundService2, AudioPlayerService audioPlayerService2, FirmwareUpdateService firmwareUpdateService2) {
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        Intrinsics.checkNotNullParameter(batteryService2, "batteryService");
        Intrinsics.checkNotNullParameter(shutDownTimerService2, "shutDownTimerService");
        Intrinsics.checkNotNullParameter(timersControllerService, "timersController");
        Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        Intrinsics.checkNotNullParameter(infoSoundService2, "infoSoundService");
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        Intrinsics.checkNotNullParameter(firmwareUpdateService2, "firmwareUpdateService");
        this.wifiService = wifiService2;
        this.batteryService = batteryService2;
        this.shutDownTimerService = shutDownTimerService2;
        this.timersController = timersControllerService;
        this.availabilityService = availabilityService2;
        this.metaDataService = metaDataService2;
        this.infoSoundService = infoSoundService2;
        this.audioPlayerService = audioPlayerService2;
        this.firmwareUpdateService = firmwareUpdateService2;
        this._batterySummary = new MutableLiveData<>(new BatterySummary(batteryService2.getBatteryPercent(), batteryService2.isCharging(), batteryService2.isPlugged()));
    }

    public final WifiService getWifiService() {
        return this.wifiService;
    }

    public final BatteryService getBatteryService() {
        return this.batteryService;
    }

    public final AvailabilityService getAvailabilityService() {
        return this.availabilityService;
    }

    public final MetaDataService getMetaDataService() {
        return this.metaDataService;
    }

    public final InfoSoundService getInfoSoundService() {
        return this.infoSoundService;
    }

    public LiveData<BatterySummary> getBatterySummary() {
        return this._batterySummary;
    }

    public LiveData<Integer> getSleepTimeTick() {
        return this._sleepTimeTick;
    }

    public LiveData<Integer> getTimeLimitTick() {
        return this._timeLimitTick;
    }

    public LiveData<LockedModeReason> getLockedMode() {
        return this._lockedMode;
    }

    public LiveData<Boolean> getDownloadsInProgress() {
        return this._downloadsInProgress;
    }

    public LiveData<Boolean> getFirmwareUpdateAvailable() {
        return this._firmwareUpdateAvailable;
    }

    public MutableLiveData<Boolean> getMediaPlayerOpened() {
        return this.mediaPlayerOpened;
    }

    public void setMediaPlayerOpened(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mediaPlayerOpened = mutableLiveData;
    }

    public MutableLiveData<Boolean> getSettingsOpened() {
        return this.settingsOpened;
    }

    public void setSettingsOpened(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.settingsOpened = mutableLiveData;
    }

    public LiveData<Integer> getMaxVolumeChanged() {
        return this._maxVolumeChanged;
    }

    public LiveData<Integer> getMusicVolumeChanged() {
        return this._musicVolumeChanged;
    }

    public LiveData<Boolean> getOfflineMode() {
        return (LiveData) this.offlineMode$delegate.getValue();
    }

    public LiveData<WifiStrength> getWifiSignalStrength() {
        return (LiveData) this.wifiSignalStrength$delegate.getValue();
    }

    public void updateShutDownTimeTick(int i) {
        this._sleepTimeTick.postValue(Integer.valueOf(i));
    }

    public void subscribe() {
        this.batteryService.subscribeToBatteryChanges(this.batteryChangesListener);
        this.shutDownTimerService.registerShutDownTimeListener(this.sleepTimeListener);
        AvailabilityService.DefaultImpls.registerListener$default(this.availabilityService, this.downloadsListener, false, 2, (Object) null);
        this.metaDataService.registerVolumeChangeListener(this.musicVolumeListener);
        this.metaDataService.registerMaxVolumeChangeListener(this.maxVolumeListener);
        this.timersController.registerLockedModeListener(this.lockedModeListener);
        this.firmwareUpdateService.registerFirmwareUpdateListener(this.firmwareUpdateListener);
    }

    public void unsubscribe() {
        this.batteryService.unsubscribeFromBatteryChanges(this.batteryChangesListener);
        this.shutDownTimerService.unregisterShutDownTimeListener(this.sleepTimeListener);
        this.availabilityService.unregisterListener(this.downloadsListener);
        this.metaDataService.unregisterVolumeChangeListener(this.musicVolumeListener);
        this.metaDataService.unregisterMaxVolumeChangeListener(this.maxVolumeListener);
        this.timersController.unregisterLockedModeListener(this.lockedModeListener);
        this.firmwareUpdateService.unregisterFirmwareUpdateListener(this.firmwareUpdateListener);
    }
}
