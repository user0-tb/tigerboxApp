package media.tiger.tigerbox.services.implementations;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.dto.ReleaseInformation;
import media.tiger.tigerbox.p016ui.onboarding.step2.RequiresUpdate;
import media.tiger.tigerbox.p016ui.onboarding.step3.InstallFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DownloadFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateListener;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TigerButtonLightEvent;
import media.tiger.tigerbox.services.interfaces.TigerButtonLightEventKt;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.usecase.CheckForUpdateUseCase;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 I2\u00020\u0001:\u0001IBm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020:H\u0002J\u0010\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020 H\u0002J\u0010\u0010C\u001a\u00020:2\u0006\u0010B\u001a\u00020 H\u0016J\u0010\u0010D\u001a\u00020:2\u0006\u0010B\u001a\u00020 H\u0016J\u0010\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u000204H\u0016J\u0010\u0010G\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010H\u001a\u00020:2\u0006\u0010F\u001a\u000204H\u0016R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u0004\u0018\u00010\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010)R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010)R\u0016\u0010/\u001a\u0004\u0018\u00010 8VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0002068VX\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/FirmwareUpdate;", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService;", "context", "Landroid/content/Context;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "batteryService", "Lmedia/tiger/tigerbox/services/interfaces/BatteryService;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "audioService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "lightControlService", "Lmedia/tiger/tigerbox/services/interfaces/LightControlService;", "checkForUpdateUseCase", "Lmedia/tiger/tigerbox/usecase/CheckForUpdateUseCase;", "validateUpdateSignature", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature;", "downloadFirmware", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware;", "decryptFirmware", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware;", "installFirmware", "Lmedia/tiger/tigerbox/ui/onboarding/step3/InstallFirmware;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "requiresUpdate", "Lmedia/tiger/tigerbox/ui/onboarding/step2/RequiresUpdate;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/BatteryService;Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Lmedia/tiger/tigerbox/services/interfaces/LightControlService;Lmedia/tiger/tigerbox/usecase/CheckForUpdateUseCase;Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature;Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware;Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware;Lmedia/tiger/tigerbox/ui/onboarding/step3/InstallFirmware;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;Lmedia/tiger/tigerbox/ui/onboarding/step2/RequiresUpdate;)V", "_failReason", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$FailReason;", "_latestValidRelease", "Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "_progressPercentage", "", "failReason", "getFailReason", "()Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$FailReason;", "hasAlreadyShownUpdateDialogue", "", "getHasAlreadyShownUpdateDialogue", "()Z", "setHasAlreadyShownUpdateDialogue", "(Z)V", "hasEnoughBattery", "getHasEnoughBattery", "isForced", "latestValidRelease", "getLatestValidRelease", "()Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "listeners", "", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateListener;", "progressPercentage", "", "getProgressPercentage", "()I", "alertListenersWithStateChange", "", "state", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$State;", "checkForUpdate", "reason", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$CheckReason;", "checkUpdateSignature", "decryptUpdate", "release", "downloadUpdate", "installUpdate", "registerFirmwareUpdateListener", "listener", "reset", "unregisterFirmwareUpdateListener", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: FirmwareUpdate.kt */
public final class FirmwareUpdate implements FirmwareUpdateService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final double DOWNLOAD_PERCENT_UNIT = 0.7d;
    /* access modifiers changed from: private */
    public FirmwareUpdateService.FailReason _failReason;
    /* access modifiers changed from: private */
    public ReleaseInformation.Release _latestValidRelease;
    /* access modifiers changed from: private */
    public double _progressPercentage;
    private final AudioPlayerService audioService;
    private final AvailabilityService availabilityService;
    private final BatteryService batteryService;
    private final CheckForUpdateUseCase checkForUpdateUseCase;
    private final ConfigurationProperties configurationProperties;
    private final Context context;
    private final DecryptFirmware decryptFirmware;
    private final DownloadFirmware downloadFirmware;
    private boolean hasAlreadyShownUpdateDialogue;
    private final InstallFirmware installFirmware;
    /* access modifiers changed from: private */
    public final LightControlService lightControlService;
    private final List<FirmwareUpdateListener> listeners = new ArrayList();
    /* access modifiers changed from: private */
    public final RequiresUpdate requiresUpdate;
    private final StorageService storageService;
    private final ValidateUpdateSignature validateUpdateSignature;

    public FirmwareUpdate(Context context2, StorageService storageService2, BatteryService batteryService2, AvailabilityService availabilityService2, AudioPlayerService audioPlayerService, LightControlService lightControlService2, CheckForUpdateUseCase checkForUpdateUseCase2, ValidateUpdateSignature validateUpdateSignature2, DownloadFirmware downloadFirmware2, DecryptFirmware decryptFirmware2, InstallFirmware installFirmware2, ConfigurationProperties configurationProperties2, RequiresUpdate requiresUpdate2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(batteryService2, "batteryService");
        Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
        Intrinsics.checkNotNullParameter(audioPlayerService, "audioService");
        Intrinsics.checkNotNullParameter(lightControlService2, "lightControlService");
        Intrinsics.checkNotNullParameter(checkForUpdateUseCase2, "checkForUpdateUseCase");
        Intrinsics.checkNotNullParameter(validateUpdateSignature2, "validateUpdateSignature");
        Intrinsics.checkNotNullParameter(downloadFirmware2, "downloadFirmware");
        Intrinsics.checkNotNullParameter(decryptFirmware2, "decryptFirmware");
        Intrinsics.checkNotNullParameter(installFirmware2, "installFirmware");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        Intrinsics.checkNotNullParameter(requiresUpdate2, "requiresUpdate");
        this.context = context2;
        this.storageService = storageService2;
        this.batteryService = batteryService2;
        this.availabilityService = availabilityService2;
        this.audioService = audioPlayerService;
        this.lightControlService = lightControlService2;
        this.checkForUpdateUseCase = checkForUpdateUseCase2;
        this.validateUpdateSignature = validateUpdateSignature2;
        this.downloadFirmware = downloadFirmware2;
        this.decryptFirmware = decryptFirmware2;
        this.installFirmware = installFirmware2;
        this.configurationProperties = configurationProperties2;
        this.requiresUpdate = requiresUpdate2;
        checkForUpdate(FirmwareUpdateService.CheckReason.AUTOMATIC);
    }

    public boolean getHasEnoughBattery() {
        return this.batteryService.getBatteryPercent() > Float.parseFloat(this.configurationProperties.getProperty("required.battery.for.update.percent"));
    }

    private final void reset(FirmwareUpdateService.CheckReason checkReason) {
        this._progressPercentage = 0.0d;
        if (checkReason == FirmwareUpdateService.CheckReason.AUTOMATIC) {
            setHasAlreadyShownUpdateDialogue(false);
        }
        this._failReason = null;
        this._latestValidRelease = null;
    }

    public FirmwareUpdateService.FailReason getFailReason() {
        return this._failReason;
    }

    public ReleaseInformation.Release getLatestValidRelease() {
        return this._latestValidRelease;
    }

    public boolean getHasAlreadyShownUpdateDialogue() {
        return this.hasAlreadyShownUpdateDialogue;
    }

    public void setHasAlreadyShownUpdateDialogue(boolean z) {
        this.hasAlreadyShownUpdateDialogue = z;
    }

    public boolean isForced() {
        ReleaseInformation.Release latestValidRelease = getLatestValidRelease();
        return latestValidRelease != null ? Intrinsics.areEqual((Object) true, (Object) latestValidRelease.getForced()) : false;
    }

    public int getProgressPercentage() {
        return (int) this._progressPercentage;
    }

    public void checkForUpdate(FirmwareUpdateService.CheckReason checkReason) {
        Intrinsics.checkNotNullParameter(checkReason, "reason");
        reset(checkReason);
        alertListenersWithStateChange(FirmwareUpdateService.State.BeginCheckForUpdate);
        this.checkForUpdateUseCase.invoke(Unit.INSTANCE, CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new FirmwareUpdate$checkForUpdate$1(this));
    }

    /* access modifiers changed from: private */
    public final void checkUpdateSignature() {
        Timber.Forest.mo50221i("Check update signature", new Object[0]);
        this.validateUpdateSignature.invoke(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new FirmwareUpdate$checkUpdateSignature$1(this), new FirmwareUpdate$checkUpdateSignature$2(this));
    }

    public void downloadUpdate(ReleaseInformation.Release release) {
        Intrinsics.checkNotNullParameter(release, "release");
        Timber.Forest.mo50221i("Starting firmware update download.", new Object[0]);
        this._progressPercentage = 0.0d;
        this.availabilityService.freeSpaceForUpdateIfNeeded();
        this.audioService.stop();
        this.lightControlService.addTigerButtonLightEvents(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_UPDATE_IN_PROGRESS));
        alertListenersWithStateChange(FirmwareUpdateService.State.BeginDownloadingFirmware);
        this.downloadFirmware.invokeAsync(release, CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new FirmwareUpdate$downloadUpdate$1(this), new FirmwareUpdate$downloadUpdate$2(this), new FirmwareUpdate$downloadUpdate$3(this, release));
    }

    /* access modifiers changed from: private */
    public final void decryptUpdate(ReleaseInformation.Release release) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("Begin Decrypting firmware: [" + release + ']', new Object[0]);
        this.decryptFirmware.invoke(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), release, new FirmwareUpdate$decryptUpdate$1(this), new FirmwareUpdate$decryptUpdate$2(this), new FirmwareUpdate$decryptUpdate$3(this));
    }

    public void installUpdate(ReleaseInformation.Release release) {
        Intrinsics.checkNotNullParameter(release, "release");
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("Begin installing firmware: [" + release + ']', new Object[0]);
        this.storageService.setGoToLogin(true);
        alertListenersWithStateChange(FirmwareUpdateService.State.BeginInstallingFirmware);
        this.storageService.setAttemptedUpdateVersion(release.getVersion());
        this.storageService.setUpdateDate(release.getReleased());
        this.storageService.deleteFirmware();
        alertListenersWithStateChange(FirmwareUpdateService.State.InstallingFirmwareDone);
        reset(FirmwareUpdateService.CheckReason.AUTOMATIC);
        this.installFirmware.invoke();
    }

    public void registerFirmwareUpdateListener(FirmwareUpdateListener firmwareUpdateListener) {
        Intrinsics.checkNotNullParameter(firmwareUpdateListener, "listener");
        this.listeners.add(firmwareUpdateListener);
    }

    public void unregisterFirmwareUpdateListener(FirmwareUpdateListener firmwareUpdateListener) {
        Intrinsics.checkNotNullParameter(firmwareUpdateListener, "listener");
        if (this.listeners.contains(firmwareUpdateListener)) {
            this.listeners.remove(firmwareUpdateListener);
        }
    }

    /* access modifiers changed from: private */
    public final void alertListenersWithStateChange(FirmwareUpdateService.State state) {
        for (FirmwareUpdateListener firmwareUpdateStateHasChanged : this.listeners) {
            firmwareUpdateStateHasChanged.firmwareUpdateStateHasChanged(state);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/FirmwareUpdate$Companion;", "", "()V", "DOWNLOAD_PERCENT_UNIT", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: FirmwareUpdate.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
