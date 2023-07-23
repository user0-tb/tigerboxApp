package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H&J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0012H&J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0012H&J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0012H&J\b\u0010\u001e\u001a\u00020\u0018H&J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H&J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00020\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/LightControlService;", "", "isMusicLightEnabled", "", "()Z", "setMusicLightEnabled", "(Z)V", "isTigerButtonLightEnabled", "setTigerButtonLightEnabled", "isTigerLightEnabled", "setTigerLightEnabled", "tigerButtonLightState", "Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;", "getTigerButtonLightState", "()Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;", "setTigerButtonLightState", "(Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;)V", "tigerLightIntensity", "", "getTigerLightIntensity", "()I", "setTigerLightIntensity", "(I)V", "addTigerButtonLightEvents", "", "eventsBitMask", "flickerTigerButtonLightGreen", "count", "flickerTigerButtonLightRed", "flickerTigerButtonLightYellow", "prepareLightsForShutdown", "registerLightIntensityChangeListener", "listener", "Lmedia/tiger/tigerbox/services/interfaces/LightIntensityChangedListener;", "removeTigerButtonLightEvents", "unregisterLightIntensityChangeListener", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: LightControlService.kt */
public interface LightControlService {
    void addTigerButtonLightEvents(int i);

    void flickerTigerButtonLightGreen(int i);

    void flickerTigerButtonLightRed(int i);

    void flickerTigerButtonLightYellow(int i);

    TigerButtonLightStatus getTigerButtonLightState();

    int getTigerLightIntensity();

    boolean isMusicLightEnabled();

    boolean isTigerButtonLightEnabled();

    boolean isTigerLightEnabled();

    void prepareLightsForShutdown();

    void registerLightIntensityChangeListener(LightIntensityChangedListener lightIntensityChangedListener);

    void removeTigerButtonLightEvents(int i);

    void setMusicLightEnabled(boolean z);

    void setTigerButtonLightEnabled(boolean z);

    void setTigerButtonLightState(TigerButtonLightStatus tigerButtonLightStatus);

    void setTigerLightEnabled(boolean z);

    void setTigerLightIntensity(int i);

    void unregisterLightIntensityChangeListener(LightIntensityChangedListener lightIntensityChangedListener);
}
