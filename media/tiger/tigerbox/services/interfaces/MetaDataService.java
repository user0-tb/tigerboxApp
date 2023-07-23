package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;
import media.tiger.tigerbox.webserver.dto.DeviceInfoDto;
import media.tiger.tigerbox.webserver.dto.UpdateDeviceInfoDto;

@Metadata(mo33736d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u00100\u001a\u000201H&J\b\u00102\u001a\u000203H&J\u0010\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u000fH&J\u0010\u00106\u001a\u0002012\u0006\u00107\u001a\u000208H&J\u0010\u00109\u001a\u0002012\u0006\u00107\u001a\u00020:H&J\u0010\u0010;\u001a\u0002012\u0006\u00107\u001a\u00020:H&J\b\u0010<\u001a\u000201H&J\u0010\u0010=\u001a\u0002012\u0006\u00107\u001a\u000208H&J\u0010\u0010>\u001a\u0002012\u0006\u00107\u001a\u00020:H&J\u0010\u0010?\u001a\u0002012\u0006\u00107\u001a\u00020:H&J\u0010\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020BH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0018\u0010\u0016\u001a\u00020\u0017X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u00020\u001dX¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\u0018\u0010$\u001a\u00020\u0017X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR\u0012\u0010'\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0012\u0010)\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0005R\u0012\u0010+\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u0018\u0010-\u001a\u00020\u0017X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001b¨\u0006C"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "", "availableDiskSpace", "", "getAvailableDiskSpace", "()Ljava/lang/String;", "batteryPercentage", "getBatteryPercentage", "cpuId", "getCpuId", "domain", "getDomain", "firmwareVersion", "getFirmwareVersion", "headphonesPlugged", "", "getHeadphonesPlugged", "()Z", "ipAddress", "getIpAddress", "macAddress", "getMacAddress", "maxVolume", "", "getMaxVolume", "()I", "setMaxVolume", "(I)V", "musicVolumeUnit", "", "getMusicVolumeUnit", "()F", "setMusicVolumeUnit", "(F)V", "netHostname", "getNetHostname", "screenBrightness", "getScreenBrightness", "setScreenBrightness", "serialNumber", "getSerialNumber", "usedDiskSpace", "getUsedDiskSpace", "userEmail", "getUserEmail", "volume", "getVolume", "setVolume", "clearAllDataAndReboot", "", "getDeviceInfo", "Lmedia/tiger/tigerbox/webserver/dto/DeviceInfoDto;", "notifyHeadphonesStateChanged", "plugged", "registerDisplayNameChangeListener", "listener", "Lmedia/tiger/tigerbox/services/interfaces/DisplayNameChangedListener;", "registerMaxVolumeChangeListener", "Lmedia/tiger/tigerbox/services/interfaces/VolumeChangedListener;", "registerVolumeChangeListener", "saveSystemState", "unregisterDisplayNameChangeListener", "unregisterMaxVolumeChangeListener", "unregisterVolumeChangeListener", "updateDeviceInfo", "updateDeviceInfoDto", "Lmedia/tiger/tigerbox/webserver/dto/UpdateDeviceInfoDto;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: MetaDataService.kt */
public interface MetaDataService {
    void clearAllDataAndReboot();

    String getAvailableDiskSpace();

    String getBatteryPercentage();

    String getCpuId();

    DeviceInfoDto getDeviceInfo();

    String getDomain();

    String getFirmwareVersion();

    boolean getHeadphonesPlugged();

    String getIpAddress();

    String getMacAddress();

    int getMaxVolume();

    float getMusicVolumeUnit();

    String getNetHostname();

    int getScreenBrightness();

    String getSerialNumber();

    String getUsedDiskSpace();

    String getUserEmail();

    int getVolume();

    void notifyHeadphonesStateChanged(boolean z);

    void registerDisplayNameChangeListener(DisplayNameChangedListener displayNameChangedListener);

    void registerMaxVolumeChangeListener(VolumeChangedListener volumeChangedListener);

    void registerVolumeChangeListener(VolumeChangedListener volumeChangedListener);

    void saveSystemState();

    void setMaxVolume(int i);

    void setMusicVolumeUnit(float f);

    void setScreenBrightness(int i);

    void setVolume(int i);

    void unregisterDisplayNameChangeListener(DisplayNameChangedListener displayNameChangedListener);

    void unregisterMaxVolumeChangeListener(VolumeChangedListener volumeChangedListener);

    void unregisterVolumeChangeListener(VolumeChangedListener volumeChangedListener);

    void updateDeviceInfo(UpdateDeviceInfoDto updateDeviceInfoDto);
}
