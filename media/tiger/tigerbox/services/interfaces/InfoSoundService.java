package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\tH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "", "systemSoundEnabled", "", "getSystemSoundEnabled", "()Z", "setSystemSoundEnabled", "(Z)V", "playSound", "", "soundType", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService$SoundType;", "registerSystemSoundEnabledListener", "listener", "Lmedia/tiger/tigerbox/services/interfaces/SystemSoundEnabledListener;", "stop", "unregisterSystemSoundEnabledListener", "SoundType", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: InfoSoundService.kt */
public interface InfoSoundService {

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService$SoundType;", "", "(Ljava/lang/String;I)V", "NEW_WIFI_SUCCESS", "WIFI_CONNECTION_FAIL", "WELCOME", "LOW_BATTERY_5", "LOW_BATTERY_5_SWITCH_ON", "LOW_BATTERY_20", "SWITCH_OFF", "SWITCH_ON", "USER_RESET_CONFIRM", "USER_RESET_WAIT", "CABLE_PLUGGED_IN", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: InfoSoundService.kt */
    public enum SoundType {
        NEW_WIFI_SUCCESS,
        WIFI_CONNECTION_FAIL,
        WELCOME,
        LOW_BATTERY_5,
        LOW_BATTERY_5_SWITCH_ON,
        LOW_BATTERY_20,
        SWITCH_OFF,
        SWITCH_ON,
        USER_RESET_CONFIRM,
        USER_RESET_WAIT,
        CABLE_PLUGGED_IN
    }

    boolean getSystemSoundEnabled();

    void playSound(SoundType soundType);

    void registerSystemSoundEnabledListener(SystemSoundEnabledListener systemSoundEnabledListener);

    void setSystemSoundEnabled(boolean z);

    void stop();

    void unregisterSystemSoundEnabledListener(SystemSoundEnabledListener systemSoundEnabledListener);
}
