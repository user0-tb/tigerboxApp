package media.tiger.tigerbox.services.interfaces;

import java.security.KeyPair;
import java.security.KeyStore;
import java.util.Date;
import java.util.List;
import javax.net.ssl.KeyManagerFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.domain.PemResponse;
import media.tiger.tigerbox.model.dto.Acquisition;
import media.tiger.tigerbox.model.dto.DeviceInformation;
import media.tiger.tigerbox.model.dto.ReportInformationDto;
import media.tiger.tigerbox.services.implementations.timersController.TimeLimit;
import media.tiger.tigerbox.services.implementations.timersController.WindowedLimits;
import media.tiger.tigerbox.webserver.dto.NightLight;
import okhttp3.ResponseBody;

@Metadata(mo33736d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0011\u0010p\u001a\u00020qH¦@ø\u0001\u0000¢\u0006\u0002\u0010rJ\b\u0010s\u001a\u00020qH&J\u001f\u0010t\u001a\b\u0012\u0004\u0012\u00020\t0u2\u0006\u0010v\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010wJ\b\u0010x\u001a\u00020qH&J\u0012\u0010y\u001a\u0004\u0018\u00010\u00032\u0006\u0010z\u001a\u00020\u0003H&J\b\u0010{\u001a\u00020|H&J\u0019\u0010}\u001a\n\u0012\u0004\u0012\u00020\u0018\u00010~2\u0007\u0010\u0001\u001a\u00020\u000fH&J\n\u0010\u0001\u001a\u00030\u0001H&J\u000b\u0010\u0001\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H&J\u0012\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020|H&J\t\u0010\u0001\u001a\u00020qH&J\u0013\u0010\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001H&J\u0013\u0010\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001H&J\t\u0010\u0001\u001a\u00020qH&J\u0012\u0010\u0001\u001a\u00020q2\u0007\u0010\u0001\u001a\u00020\u000fH&J!\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u000f2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~H&J\u0013\u0010\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u0001H&Jh\u0010\u0001\u001a\u00020q2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010 \u00012\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u00012\n\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001H&J\u0013\u0010§\u0001\u001a\u00020\t2\b\u0010¨\u0001\u001a\u00030©\u0001H&J\u0015\u0010ª\u0001\u001a\u00020q2\n\u0010«\u0001\u001a\u0005\u0018\u00010\u0001H&J\u0013\u0010¬\u0001\u001a\u00020q2\b\u0010­\u0001\u001a\u00030\u0001H&J\u001a\u0010®\u0001\u001a\u00020q2\u0006\u0010z\u001a\u00020\u00032\u0007\u0010¯\u0001\u001a\u00020\u0003H&J\u0012\u0010°\u0001\u001a\u00020q2\u0007\u0010±\u0001\u001a\u00020\tH&J\t\u0010²\u0001\u001a\u00020qH&J\u0013\u0010³\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001H&J\u0013\u0010´\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u0007R\u0012\u0010\u001d\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0005R\u0012\u0010\u001f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0005R\u0012\u0010!\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u000bR\u0012\u0010#\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u000bR\u0012\u0010%\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u000bR\u0012\u0010'\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u000bR\u0012\u0010)\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u000bR\u0012\u0010+\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u000bR\u0012\u0010-\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u000bR\u0012\u0010/\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u000bR\u0012\u00101\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u000bR\u0018\u00103\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b4\u0010\u000b\"\u0004\b5\u0010\rR\u0018\u00106\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b6\u0010\u000b\"\u0004\b7\u0010\rR\u0012\u00108\u001a\u000209X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0012\u0010<\u001a\u00020=X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0012\u0010@\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0005R\u0018\u0010B\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\bC\u0010\u000b\"\u0004\bD\u0010\rR\u0018\u0010E\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bF\u0010\u0005\"\u0004\bG\u0010\u0007R\u0012\u0010H\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u000bR\u0018\u0010J\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\bK\u0010\u000b\"\u0004\bL\u0010\rR\u0018\u0010M\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\bN\u0010\u000b\"\u0004\bO\u0010\rR\u0018\u0010P\u001a\u00020QX¦\u000e¢\u0006\f\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0012\u0010V\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u000bR\u0018\u0010X\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\bY\u0010\u000b\"\u0004\bZ\u0010\rR\u0018\u0010[\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\\\u0010\u0011\"\u0004\b]\u0010\u0013R\u0018\u0010^\u001a\u00020_X¦\u000e¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010d\u001a\u00020eX¦\u000e¢\u0006\f\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0018\u0010j\u001a\u00020kX¦\u000e¢\u0006\f\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o\u0002\u0004\n\u0002\b\u0019¨\u0006µ\u0001"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "", "attemptedUpdateVersion", "", "getAttemptedUpdateVersion", "()Ljava/lang/String;", "setAttemptedUpdateVersion", "(Ljava/lang/String;)V", "autoplay", "", "getAutoplay", "()Z", "setAutoplay", "(Z)V", "currentMaxVolume", "", "getCurrentMaxVolume", "()I", "setCurrentMaxVolume", "(I)V", "deviceInformation", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "getDeviceInformation", "()Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "setDeviceInformation", "(Lmedia/tiger/tigerbox/model/dto/DeviceInformation;)V", "displayName", "getDisplayName", "setDisplayName", "firmwareDownloadPath", "getFirmwareDownloadPath", "firmwareInstallPath", "getFirmwareInstallPath", "flagAdvancedTimersEnabled", "getFlagAdvancedTimersEnabled", "flagAutoLogsEnabled", "getFlagAutoLogsEnabled", "flagAutoplayEnabled", "getFlagAutoplayEnabled", "flagForceCrashEnabled", "getFlagForceCrashEnabled", "flagManualTicketRedemptionEnabled", "getFlagManualTicketRedemptionEnabled", "flagPinEntryEnabled", "getFlagPinEntryEnabled", "flagProfilesEnabled", "getFlagProfilesEnabled", "flagProfilesMainContentSwitchEnabled", "getFlagProfilesMainContentSwitchEnabled", "flagSubmitLogsEnabled", "getFlagSubmitLogsEnabled", "goToLogin", "getGoToLogin", "setGoToLogin", "isMuted", "setMuted", "keyManagerFactory", "Ljavax/net/ssl/KeyManagerFactory;", "getKeyManagerFactory", "()Ljavax/net/ssl/KeyManagerFactory;", "keyStore", "Ljava/security/KeyStore;", "getKeyStore", "()Ljava/security/KeyStore;", "keyStorePassword", "getKeyStorePassword", "musicLightOn", "getMusicLightOn", "setMusicLightOn", "offlineRowTitle", "getOfflineRowTitle", "setOfflineRowTitle", "onboardingCompleted", "getOnboardingCompleted", "parentalGate", "getParentalGate", "setParentalGate", "tigerButtonLightEnabled", "getTigerButtonLightEnabled", "setTigerButtonLightEnabled", "tigerButtonLightState", "Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;", "getTigerButtonLightState", "()Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;", "setTigerButtonLightState", "(Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;)V", "tigerCardModeEnabled", "getTigerCardModeEnabled", "tigerLightEnabled", "getTigerLightEnabled", "setTigerLightEnabled", "tigerLightIntensity", "getTigerLightIntensity", "setTigerLightIntensity", "timeLimit", "Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;", "getTimeLimit", "()Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;", "setTimeLimit", "(Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;)V", "updateDate", "Ljava/util/Date;", "getUpdateDate", "()Ljava/util/Date;", "setUpdateDate", "(Ljava/util/Date;)V", "windowedLimit", "Lmedia/tiger/tigerbox/services/implementations/timersController/WindowedLimits;", "getWindowedLimit", "()Lmedia/tiger/tigerbox/services/implementations/timersController/WindowedLimits;", "setWindowedLimit", "(Lmedia/tiger/tigerbox/services/implementations/timersController/WindowedLimits;)V", "clearAllData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearFeatureFlags", "completeOnboarding", "Lmedia/tiger/tigerbox/infrastructure/functional/Either$Right;", "complete", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFirmware", "findWifiPassword", "ssid", "generateCertificateKeyPair", "Ljava/security/KeyPair;", "getAcquisitions", "", "Lmedia/tiger/tigerbox/model/dto/Acquisition;", "productId", "getNightLightTimer", "Lmedia/tiger/tigerbox/webserver/dto/NightLight;", "getOfflineStartTimeAndDate", "getVolume", "", "default", "loadCertificate", "keyPair", "notifyFlagChanged", "registerFlagChangeListener", "listener", "Lmedia/tiger/tigerbox/services/interfaces/FlagChangeListener;", "registerTimeLimitChangeListener", "Lmedia/tiger/tigerbox/services/interfaces/TimerLimitChangeListener;", "removeOfflineStartTimeAndDate", "replaceOfflineStartTimeAndDate", "daysBack", "saveAcquisitions", "acquisitions", "saveCertificateData", "certificateData", "Lmedia/tiger/tigerbox/model/domain/PemResponse$CertificateData;", "saveFeatureFlags", "submitLogs", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagSubmitLogs;", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagAutoplay;", "forceCrash", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagForceCrash;", "manualTicketRedemption", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagManualTicketRedemption;", "advancedTimers", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagAdvancedTimers;", "profiles", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagProfiles;", "pinEntry", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagPinEntry;", "autoLogs", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagAutoLogs;", "saveFirmware", "response", "Lokhttp3/ResponseBody;", "saveNightLightTimer", "timer", "saveVolume", "volume", "saveWifiPassword", "password", "setTigerCardModeEnabled", "value", "storeOfflineStartTimeAndDate", "unregisterFlagChangeListener", "unregisterTimeLimitChangeListener", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: StorageService.kt */
public interface StorageService {
    Object clearAllData(Continuation<? super Unit> continuation);

    void clearFeatureFlags();

    Object completeOnboarding(boolean z, Continuation<? super Either.Right<Boolean>> continuation);

    void deleteFirmware();

    String findWifiPassword(String str);

    KeyPair generateCertificateKeyPair();

    List<Acquisition> getAcquisitions(int i);

    String getAttemptedUpdateVersion();

    boolean getAutoplay();

    int getCurrentMaxVolume();

    DeviceInformation getDeviceInformation();

    String getDisplayName();

    String getFirmwareDownloadPath();

    String getFirmwareInstallPath();

    boolean getFlagAdvancedTimersEnabled();

    boolean getFlagAutoLogsEnabled();

    boolean getFlagAutoplayEnabled();

    boolean getFlagForceCrashEnabled();

    boolean getFlagManualTicketRedemptionEnabled();

    boolean getFlagPinEntryEnabled();

    boolean getFlagProfilesEnabled();

    boolean getFlagProfilesMainContentSwitchEnabled();

    boolean getFlagSubmitLogsEnabled();

    boolean getGoToLogin();

    KeyManagerFactory getKeyManagerFactory();

    KeyStore getKeyStore();

    String getKeyStorePassword();

    boolean getMusicLightOn();

    NightLight getNightLightTimer();

    String getOfflineRowTitle();

    String getOfflineStartTimeAndDate();

    boolean getOnboardingCompleted();

    boolean getParentalGate();

    boolean getTigerButtonLightEnabled();

    TigerButtonLightStatus getTigerButtonLightState();

    boolean getTigerCardModeEnabled();

    boolean getTigerLightEnabled();

    int getTigerLightIntensity();

    TimeLimit getTimeLimit();

    Date getUpdateDate();

    float getVolume(float f);

    WindowedLimits getWindowedLimit();

    boolean isMuted();

    boolean loadCertificate(KeyPair keyPair);

    void notifyFlagChanged();

    void registerFlagChangeListener(FlagChangeListener flagChangeListener);

    void registerTimeLimitChangeListener(TimerLimitChangeListener timerLimitChangeListener);

    void removeOfflineStartTimeAndDate();

    void replaceOfflineStartTimeAndDate(int i);

    boolean saveAcquisitions(int i, List<Acquisition> list);

    boolean saveCertificateData(PemResponse.CertificateData certificateData);

    void saveFeatureFlags(ReportInformationDto.FlagSubmitLogs flagSubmitLogs, ReportInformationDto.FlagAutoplay flagAutoplay, ReportInformationDto.FlagForceCrash flagForceCrash, ReportInformationDto.FlagManualTicketRedemption flagManualTicketRedemption, ReportInformationDto.FlagAdvancedTimers flagAdvancedTimers, ReportInformationDto.FlagProfiles flagProfiles, ReportInformationDto.FlagPinEntry flagPinEntry, ReportInformationDto.FlagAutoLogs flagAutoLogs);

    boolean saveFirmware(ResponseBody responseBody);

    void saveNightLightTimer(NightLight nightLight);

    void saveVolume(float f);

    void saveWifiPassword(String str, String str2);

    void setAttemptedUpdateVersion(String str);

    void setAutoplay(boolean z);

    void setCurrentMaxVolume(int i);

    void setDeviceInformation(DeviceInformation deviceInformation);

    void setDisplayName(String str);

    void setGoToLogin(boolean z);

    void setMusicLightOn(boolean z);

    void setMuted(boolean z);

    void setOfflineRowTitle(String str);

    void setParentalGate(boolean z);

    void setTigerButtonLightEnabled(boolean z);

    void setTigerButtonLightState(TigerButtonLightStatus tigerButtonLightStatus);

    void setTigerCardModeEnabled(boolean z);

    void setTigerLightEnabled(boolean z);

    void setTigerLightIntensity(int i);

    void setTimeLimit(TimeLimit timeLimit);

    void setUpdateDate(Date date);

    void setWindowedLimit(WindowedLimits windowedLimits);

    void storeOfflineStartTimeAndDate();

    void unregisterFlagChangeListener(FlagChangeListener flagChangeListener);

    void unregisterTimeLimitChangeListener(TimerLimitChangeListener timerLimitChangeListener);
}
