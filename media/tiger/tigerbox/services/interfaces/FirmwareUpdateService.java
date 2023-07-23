package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;
import media.tiger.tigerbox.model.dto.ReleaseInformation;

@Metadata(mo33736d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\"#$J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0010H&J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0010H&J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService;", "", "failReason", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$FailReason;", "getFailReason", "()Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$FailReason;", "hasAlreadyShownUpdateDialogue", "", "getHasAlreadyShownUpdateDialogue", "()Z", "setHasAlreadyShownUpdateDialogue", "(Z)V", "hasEnoughBattery", "getHasEnoughBattery", "isForced", "latestValidRelease", "Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "getLatestValidRelease", "()Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "progressPercentage", "", "getProgressPercentage", "()I", "checkForUpdate", "", "reason", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$CheckReason;", "downloadUpdate", "release", "installUpdate", "registerFirmwareUpdateListener", "listener", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateListener;", "unregisterFirmwareUpdateListener", "CheckReason", "FailReason", "State", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: FirmwareUpdateService.kt */
public interface FirmwareUpdateService {

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$CheckReason;", "", "(Ljava/lang/String;I)V", "MANUAL", "AUTOMATIC", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: FirmwareUpdateService.kt */
    public enum CheckReason {
        MANUAL,
        AUTOMATIC
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$FailReason;", "", "(Ljava/lang/String;I)V", "SERVER_ERROR", "INVALID_SIGNATURE", "ERROR_DOWNLOADING", "ERROR_DECRYPTING", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: FirmwareUpdateService.kt */
    public enum FailReason {
        SERVER_ERROR,
        INVALID_SIGNATURE,
        ERROR_DOWNLOADING,
        ERROR_DECRYPTING
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$State;", "", "(Ljava/lang/String;I)V", "NoUpdateRequired", "BeginCheckForUpdate", "CheckForUpdateFailed", "CheckForUpdateSuccess", "CheckForUpdateSuccessInsufficientBatteryError", "BeginDownloadingFirmware", "DownloadingFirmwareProgressed", "DecryptingFirmwareProgressed", "DownloadingFirmwareFailed", "DownloadingFirmwareSuccess", "BeginInstallingFirmware", "InstallingFirmwareDone", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: FirmwareUpdateService.kt */
    public enum State {
        NoUpdateRequired,
        BeginCheckForUpdate,
        CheckForUpdateFailed,
        CheckForUpdateSuccess,
        CheckForUpdateSuccessInsufficientBatteryError,
        BeginDownloadingFirmware,
        DownloadingFirmwareProgressed,
        DecryptingFirmwareProgressed,
        DownloadingFirmwareFailed,
        DownloadingFirmwareSuccess,
        BeginInstallingFirmware,
        InstallingFirmwareDone
    }

    void checkForUpdate(CheckReason checkReason);

    void downloadUpdate(ReleaseInformation.Release release);

    FailReason getFailReason();

    boolean getHasAlreadyShownUpdateDialogue();

    boolean getHasEnoughBattery();

    ReleaseInformation.Release getLatestValidRelease();

    int getProgressPercentage();

    void installUpdate(ReleaseInformation.Release release);

    boolean isForced();

    void registerFirmwareUpdateListener(FirmwareUpdateListener firmwareUpdateListener);

    void setHasAlreadyShownUpdateDialogue(boolean z);

    void unregisterFirmwareUpdateListener(FirmwareUpdateListener firmwareUpdateListener);
}
