package media.tiger.tigerbox.services.interfaces;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import media.tiger.tigerbox.model.domain.BatterySummary;
import media.tiger.tigerbox.model.domain.WifiStrength;
import media.tiger.tigerbox.services.implementations.timersController.LockedModeReason;

@Metadata(mo33736d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010&\u001a\u00020'H&J\b\u0010(\u001a\u00020'H&J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0010H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006R\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0006R\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0006R\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0006¨\u0006+"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "", "batterySummary", "Landroidx/lifecycle/LiveData;", "Lmedia/tiger/tigerbox/model/domain/BatterySummary;", "getBatterySummary", "()Landroidx/lifecycle/LiveData;", "downloadsInProgress", "", "getDownloadsInProgress", "firmwareUpdateAvailable", "getFirmwareUpdateAvailable", "lockedMode", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeReason;", "getLockedMode", "maxVolumeChanged", "", "getMaxVolumeChanged", "mediaPlayerOpened", "Landroidx/lifecycle/MutableLiveData;", "getMediaPlayerOpened", "()Landroidx/lifecycle/MutableLiveData;", "setMediaPlayerOpened", "(Landroidx/lifecycle/MutableLiveData;)V", "musicVolumeChanged", "getMusicVolumeChanged", "offlineMode", "getOfflineMode", "settingsOpened", "getSettingsOpened", "setSettingsOpened", "sleepTimeTick", "getSleepTimeTick", "timeLimitTick", "getTimeLimitTick", "wifiSignalStrength", "Lmedia/tiger/tigerbox/model/domain/WifiStrength;", "getWifiSignalStrength", "subscribe", "", "unsubscribe", "updateShutDownTimeTick", "seconds", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HeaderProvider.kt */
public interface HeaderProvider {
    LiveData<BatterySummary> getBatterySummary();

    LiveData<Boolean> getDownloadsInProgress();

    LiveData<Boolean> getFirmwareUpdateAvailable();

    LiveData<LockedModeReason> getLockedMode();

    LiveData<Integer> getMaxVolumeChanged();

    MutableLiveData<Boolean> getMediaPlayerOpened();

    LiveData<Integer> getMusicVolumeChanged();

    LiveData<Boolean> getOfflineMode();

    MutableLiveData<Boolean> getSettingsOpened();

    LiveData<Integer> getSleepTimeTick();

    LiveData<Integer> getTimeLimitTick();

    LiveData<WifiStrength> getWifiSignalStrength();

    void setMediaPlayerOpened(MutableLiveData<Boolean> mutableLiveData);

    void setSettingsOpened(MutableLiveData<Boolean> mutableLiveData);

    void subscribe();

    void unsubscribe();

    void updateShutDownTimeTick(int i);
}
