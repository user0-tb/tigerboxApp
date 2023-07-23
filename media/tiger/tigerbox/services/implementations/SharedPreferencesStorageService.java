package media.tiger.tigerbox.services.implementations;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.net.ssl.KeyManagerFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.Constants;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.domain.PemResponse;
import media.tiger.tigerbox.model.dto.Acquisition;
import media.tiger.tigerbox.model.dto.DeviceInformation;
import media.tiger.tigerbox.model.dto.ReportInformationDto;
import media.tiger.tigerbox.services.implementations.timersController.TimeLimit;
import media.tiger.tigerbox.services.implementations.timersController.WindowedLimits;
import media.tiger.tigerbox.services.interfaces.FlagChangeListener;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TigerButtonLightStatus;
import media.tiger.tigerbox.services.interfaces.TimerLimitChangeListener;
import media.tiger.tigerbox.utils.PemUtils;
import media.tiger.tigerbox.webserver.dto.NightLight;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 Ç\u00012\u00020\u0001:\u0002Ç\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0016J#\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140\u00012\u0007\u0010\u0001\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u0014\u0010\u0001\u001a\u0004\u0018\u00010\u00032\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u001c\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u001aH\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u000b\u0010\u0001\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020\u00142\b\u0010\u0001\u001a\u00030\u0001H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010 \u0001\u001a\u00020RH\u0016J\u0013\u0010¡\u0001\u001a\u00030\u00012\u0007\u0010 \u0001\u001a\u00020wH\u0016J\n\u0010¢\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010£\u0001\u001a\u00030\u00012\u0007\u0010¤\u0001\u001a\u00020\u001aH\u0016J#\u0010¥\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u001a2\u000f\u0010¦\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0016J\u0013\u0010§\u0001\u001a\u00020\u00142\b\u0010¨\u0001\u001a\u00030©\u0001H\u0016Ji\u0010ª\u0001\u001a\u00030\u00012\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u00012\t\u0010\u0015\u001a\u0005\u0018\u00010­\u00012\n\u0010®\u0001\u001a\u0005\u0018\u00010¯\u00012\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u00012\n\u0010²\u0001\u001a\u0005\u0018\u00010³\u00012\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u00012\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u00012\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\u0013\u0010º\u0001\u001a\u00020\u00142\b\u0010»\u0001\u001a\u00030¼\u0001H\u0016J\u0016\u0010½\u0001\u001a\u00030\u00012\n\u0010¾\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0014\u0010¿\u0001\u001a\u00030\u00012\b\u0010À\u0001\u001a\u00030\u0001H\u0016J\u001c\u0010Á\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00032\u0007\u0010Â\u0001\u001a\u00020\u0003H\u0016J\u0012\u0010Ã\u0001\u001a\u00030\u00012\u0006\u0010\u000e\u001a\u00020\u0014H\u0016J\n\u0010Ä\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010Å\u0001\u001a\u00030\u00012\u0007\u0010 \u0001\u001a\u00020RH\u0016J\u0013\u0010Æ\u0001\u001a\u00030\u00012\u0007\u0010 \u0001\u001a\u00020wH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u001a8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r8V@VX\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0011R\u0014\u0010*\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0011R\u0014\u0010,\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0017R\u0014\u0010.\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0017R\u0014\u00100\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0017R\u0014\u00102\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0017R\u0014\u00104\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0017R\u0014\u00106\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0017R\u0014\u00108\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0017R\u0014\u0010:\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0017R\u0014\u0010<\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0017R$\u0010>\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0017\"\u0004\b@\u0010\u0019R$\u0010A\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148V@VX\u000e¢\u0006\f\u001a\u0004\bA\u0010\u0017\"\u0004\bB\u0010\u0019R\u001b\u0010C\u001a\u00020D8VX\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020JX\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u001b\u0010M\u001a\u00020\u00038VX\u0002¢\u0006\f\n\u0004\bO\u0010H\u001a\u0004\bN\u0010\u0011R\u001e\u0010P\u001a\u0012\u0012\u0004\u0012\u00020R0Qj\b\u0012\u0004\u0012\u00020R`SX\u000e¢\u0006\u0002\n\u0000R$\u0010T\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148V@VX\u000e¢\u0006\f\u001a\u0004\bU\u0010\u0017\"\u0004\bV\u0010\u0019R$\u0010W\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\bX\u0010\u0011\"\u0004\bY\u0010\u0013R\u0014\u0010Z\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0017R$\u0010\\\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b]\u0010\u0017\"\u0004\b^\u0010\u0019R$\u0010_\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b`\u0010\u0017\"\u0004\ba\u0010\u0019R$\u0010c\u001a\u00020b2\u0006\u0010\u000e\u001a\u00020b8V@VX\u000e¢\u0006\f\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0014\u0010h\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\bi\u0010\u0017R$\u0010j\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148V@VX\u000e¢\u0006\f\u001a\u0004\bk\u0010\u0017\"\u0004\bl\u0010\u0019R$\u0010m\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u001a8V@VX\u000e¢\u0006\f\u001a\u0004\bn\u0010\u001d\"\u0004\bo\u0010\u001fR$\u0010q\u001a\u00020p2\u0006\u0010\u000e\u001a\u00020p8V@VX\u000e¢\u0006\f\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001e\u0010v\u001a\u0012\u0012\u0004\u0012\u00020w0Qj\b\u0012\u0004\u0012\u00020w`SX\u000e¢\u0006\u0002\n\u0000R$\u0010y\u001a\u00020x2\u0006\u0010\u000e\u001a\u00020x8V@VX\u000e¢\u0006\f\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R(\u0010\u001a\u00020~2\u0006\u0010\u000e\u001a\u00020~8V@VX\u000e¢\u0006\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006È\u0001"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/SharedPreferencesStorageService;", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "applicationDataDirectory", "", "applicationExternalStoragePath", "encryptedSharedPreferences", "Landroid/content/SharedPreferences;", "audioManager", "Landroid/media/AudioManager;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences;Landroid/media/AudioManager;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "_deviceInformation", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "value", "attemptedUpdateVersion", "getAttemptedUpdateVersion", "()Ljava/lang/String;", "setAttemptedUpdateVersion", "(Ljava/lang/String;)V", "", "autoplay", "getAutoplay", "()Z", "setAutoplay", "(Z)V", "", "currentMaxVolume", "getCurrentMaxVolume", "()I", "setCurrentMaxVolume", "(I)V", "deviceInformation", "getDeviceInformation", "()Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "setDeviceInformation", "(Lmedia/tiger/tigerbox/model/dto/DeviceInformation;)V", "displayName", "getDisplayName", "setDisplayName", "firmwareDownloadPath", "getFirmwareDownloadPath", "firmwareInstallPath", "getFirmwareInstallPath", "flagAdvancedTimersEnabled", "getFlagAdvancedTimersEnabled", "flagAutoLogsEnabled", "getFlagAutoLogsEnabled", "flagAutoplayEnabled", "getFlagAutoplayEnabled", "flagForceCrashEnabled", "getFlagForceCrashEnabled", "flagManualTicketRedemptionEnabled", "getFlagManualTicketRedemptionEnabled", "flagPinEntryEnabled", "getFlagPinEntryEnabled", "flagProfilesEnabled", "getFlagProfilesEnabled", "flagProfilesMainContentSwitchEnabled", "getFlagProfilesMainContentSwitchEnabled", "flagSubmitLogsEnabled", "getFlagSubmitLogsEnabled", "goToLogin", "getGoToLogin", "setGoToLogin", "isMuted", "setMuted", "keyManagerFactory", "Ljavax/net/ssl/KeyManagerFactory;", "getKeyManagerFactory", "()Ljavax/net/ssl/KeyManagerFactory;", "keyManagerFactory$delegate", "Lkotlin/Lazy;", "keyStore", "Ljava/security/KeyStore;", "getKeyStore", "()Ljava/security/KeyStore;", "keyStorePassword", "getKeyStorePassword", "keyStorePassword$delegate", "listeners", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/services/interfaces/FlagChangeListener;", "Lkotlin/collections/ArrayList;", "musicLightOn", "getMusicLightOn", "setMusicLightOn", "offlineRowTitle", "getOfflineRowTitle", "setOfflineRowTitle", "onboardingCompleted", "getOnboardingCompleted", "parentalGate", "getParentalGate", "setParentalGate", "tigerButtonLightEnabled", "getTigerButtonLightEnabled", "setTigerButtonLightEnabled", "Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;", "tigerButtonLightState", "getTigerButtonLightState", "()Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;", "setTigerButtonLightState", "(Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;)V", "tigerCardModeEnabled", "getTigerCardModeEnabled", "tigerLightEnabled", "getTigerLightEnabled", "setTigerLightEnabled", "tigerLightIntensity", "getTigerLightIntensity", "setTigerLightIntensity", "Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;", "timeLimit", "getTimeLimit", "()Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;", "setTimeLimit", "(Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;)V", "timeLimitListeners", "Lmedia/tiger/tigerbox/services/interfaces/TimerLimitChangeListener;", "Ljava/util/Date;", "updateDate", "getUpdateDate", "()Ljava/util/Date;", "setUpdateDate", "(Ljava/util/Date;)V", "Lmedia/tiger/tigerbox/services/implementations/timersController/WindowedLimits;", "windowedLimit", "getWindowedLimit", "()Lmedia/tiger/tigerbox/services/implementations/timersController/WindowedLimits;", "setWindowedLimit", "(Lmedia/tiger/tigerbox/services/implementations/timersController/WindowedLimits;)V", "clearAllData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearFeatureFlags", "completeOnboarding", "Lmedia/tiger/tigerbox/infrastructure/functional/Either$Right;", "complete", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFirmware", "findWifiPassword", "ssid", "generateCertificateKeyPair", "Ljava/security/KeyPair;", "getAcquisitions", "", "Lmedia/tiger/tigerbox/model/dto/Acquisition;", "productId", "getNightLightTimer", "Lmedia/tiger/tigerbox/webserver/dto/NightLight;", "getOfflineStartTimeAndDate", "getVolume", "", "default", "loadCertificate", "keyPair", "notifyFlagChanged", "notifyTimeLimitChanged", "registerFlagChangeListener", "listener", "registerTimeLimitChangeListener", "removeOfflineStartTimeAndDate", "replaceOfflineStartTimeAndDate", "daysBack", "saveAcquisitions", "acquisitions", "saveCertificateData", "certificateData", "Lmedia/tiger/tigerbox/model/domain/PemResponse$CertificateData;", "saveFeatureFlags", "submitLogs", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagSubmitLogs;", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagAutoplay;", "forceCrash", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagForceCrash;", "manualTicketRedemption", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagManualTicketRedemption;", "advancedTimers", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagAdvancedTimers;", "profiles", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagProfiles;", "pinEntry", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagPinEntry;", "autoLogs", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto$FlagAutoLogs;", "saveFirmware", "response", "Lokhttp3/ResponseBody;", "saveNightLightTimer", "timer", "saveVolume", "volume", "saveWifiPassword", "password", "setTigerCardModeEnabled", "storeOfflineStartTimeAndDate", "unregisterFlagChangeListener", "unregisterTimeLimitChangeListener", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: SharedPreferencesStorageService.kt */
public final class SharedPreferencesStorageService implements StorageService {
    private static final int BUFFER_SIZE = 4096;
    private static final TigerButtonLightStatus BUTTON_LIGHT_DEFAULT = TigerButtonLightStatus.GREEN;
    private static final boolean BUTTON_LIGHT_ENABLED_DEFAULT = true;
    public static final String CERTIFICATE_KEYPAIR_PRIVATE = "CERTIFICATE_KEYPAIR_PRIVATE";
    public static final String CERTIFICATE_KEYPAIR_PUBLIC = "CERTIFICATE_KEYPAIR_PUBLIC";
    public static final String CERTIFICATE_SIGNING_RAW = "CERTIFICATE_SIGNING_RAW";
    public static final String CERTIFICATE_SIGNING_REQUEST = "CERTIFICATE_SIGNING_REQUEST";
    private static final String CURRENT_MAX_VOLUME = "CURRENT_MAX_VOLUME";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final boolean DEFAULT_TIGER_LIGHT_ENABLED = false;
    private static final int DEFAULT_TIGER_LIGHT_INTENSITY = 80;
    public static final String DEVICE_INFO = "deviceInfo";
    private static final String DISPLAY_NAME = "DISPLAY_NAME";
    private static final String FIRMWARE_NAME = "downloaded_firmware.enc";
    private static final String FLAG_ADVANCED_TIMERS = "flag.advanceTimers";
    private static final String FLAG_AUTOPLAY = "flag.autoplay";
    private static final String FLAG_AUTO_LOGS = "flag.autoLogs";
    private static final String FLAG_FORCE_CRASH = "flag.forceCrash";
    private static final String FLAG_MANUAL_TICKET_REDEMPTION = "flag.ticketManualRedemption";
    private static final String FLAG_PIN_ENTRY = "flag.pinEntry";
    private static final String FLAG_PROFILES = "flag.profiles";
    private static final String FLAG_PROFILES_MAIN_CONTENT_SWITCH = "flag.profiles_main_content_switch";
    private static final String FLAG_SUBMIT_LOGS = "flag.submitLogs";
    private static final String GO_TO_LOGIN = "GO_TO_LOGIN";
    public static final String KEYSTORE_PASSWORD = "KEYSTORE_PASSWORD";
    public static final String KEY_AUTOPLAY_MODE = "tiger_playback_autoplay_enabled";
    public static final String KEY_NIGHT_LIGHT_TIMERS = "KEY_NIGHT_LIGHT_TIMERS";
    public static final String KEY_PARENTAL_GATE_ENABLED = "tiger_parental_gate_enabled";
    public static final String KEY_TIGER_CARD_MODE = "tiger_card_mode";
    private static final String KEY_TIGER_LIGHT_ENABLED = "KEY_TIGER_LIGHT_ENABLED";
    public static final String KEY_TIGER_LIGHT_INTENSITY = "light_tiger_intensity";
    private static final boolean MUSIC_LIGHT_DEFAULT = true;
    private static final String MUSIC_LIGHT_ON = "MUSIC_LIGHT_ON";
    private static final String OFFLINE_ROW_TITLE = "OFFLINE_ROW_TITLE";
    public static final String OFFLINE_START_TIME_AND_DATE = "offlineStartTimeAndDate";
    private static final String ONBOARDING_COMPLETED = "ONBOARDING_COMPLETED";
    private static final String OTA_FIRMWARE_FILE_NAME = "update.zip";
    public static final String P12_CHAIN = "P12_CHAIN";
    public static final String STREAM_VOLUME = "STREAM_VOLUME";
    public static final String STREAM_VOLUME_MUTED = "STREAM_VOLUME_MUTED";
    private static final String TIGER_BUTTON_LIGHT_ENABLED = "TIGER_BUTTON_LIGHT_ENABLED";
    private static final String TIGER_BUTTON_LIGHT_STATE = "TIGER_BUTTON_LIGHT_STATE";
    private static final String TIME_LIMIT = "TIME_LIMIT";
    private static final String UPDATE_DATE = "UPDATE_DATE";
    private static final String UPDATE_VERSION = "UPDATE_VERSION";
    private static final String WINDOWED_LIMIT = "WINDOWED_LIMIT";
    private DeviceInformation _deviceInformation;
    private final AudioManager audioManager;
    private final ConfigurationProperties configurationProperties;
    /* access modifiers changed from: private */
    public final SharedPreferences encryptedSharedPreferences;
    private final String firmwareDownloadPath;
    private final String firmwareInstallPath;
    private final Lazy keyManagerFactory$delegate;
    private final KeyStore keyStore;
    private final Lazy keyStorePassword$delegate = LazyKt.lazy(new SharedPreferencesStorageService$keyStorePassword$2(this));
    /* access modifiers changed from: private */
    public ArrayList<FlagChangeListener> listeners = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<TimerLimitChangeListener> timeLimitListeners = new ArrayList<>();

    @Inject
    public SharedPreferencesStorageService(String str, String str2, SharedPreferences sharedPreferences, AudioManager audioManager2, ConfigurationProperties configurationProperties2) {
        Intrinsics.checkNotNullParameter(str, "applicationDataDirectory");
        Intrinsics.checkNotNullParameter(str2, "applicationExternalStoragePath");
        Intrinsics.checkNotNullParameter(sharedPreferences, "encryptedSharedPreferences");
        Intrinsics.checkNotNullParameter(audioManager2, "audioManager");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        this.encryptedSharedPreferences = sharedPreferences;
        this.audioManager = audioManager2;
        this.configurationProperties = configurationProperties2;
        this.firmwareDownloadPath = str + File.separator + FIRMWARE_NAME;
        this.firmwareInstallPath = str2 + File.separator + OTA_FIRMWARE_FILE_NAME;
        KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(KeyStore.getDefaultType())");
        this.keyStore = instance;
        this.keyManagerFactory$delegate = LazyKt.lazy(new SharedPreferencesStorageService$keyManagerFactory$2(this));
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u00064"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/SharedPreferencesStorageService$Companion;", "", "()V", "BUFFER_SIZE", "", "BUTTON_LIGHT_DEFAULT", "Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;", "BUTTON_LIGHT_ENABLED_DEFAULT", "", "CERTIFICATE_KEYPAIR_PRIVATE", "", "CERTIFICATE_KEYPAIR_PUBLIC", "CERTIFICATE_SIGNING_RAW", "CERTIFICATE_SIGNING_REQUEST", "CURRENT_MAX_VOLUME", "DEFAULT_TIGER_LIGHT_ENABLED", "DEFAULT_TIGER_LIGHT_INTENSITY", "DEVICE_INFO", "DISPLAY_NAME", "FIRMWARE_NAME", "FLAG_ADVANCED_TIMERS", "FLAG_AUTOPLAY", "FLAG_AUTO_LOGS", "FLAG_FORCE_CRASH", "FLAG_MANUAL_TICKET_REDEMPTION", "FLAG_PIN_ENTRY", "FLAG_PROFILES", "FLAG_PROFILES_MAIN_CONTENT_SWITCH", "FLAG_SUBMIT_LOGS", "GO_TO_LOGIN", "KEYSTORE_PASSWORD", "KEY_AUTOPLAY_MODE", "KEY_NIGHT_LIGHT_TIMERS", "KEY_PARENTAL_GATE_ENABLED", "KEY_TIGER_CARD_MODE", "KEY_TIGER_LIGHT_ENABLED", "KEY_TIGER_LIGHT_INTENSITY", "MUSIC_LIGHT_DEFAULT", "MUSIC_LIGHT_ON", "OFFLINE_ROW_TITLE", "OFFLINE_START_TIME_AND_DATE", "ONBOARDING_COMPLETED", "OTA_FIRMWARE_FILE_NAME", "P12_CHAIN", "STREAM_VOLUME", "STREAM_VOLUME_MUTED", "TIGER_BUTTON_LIGHT_ENABLED", "TIGER_BUTTON_LIGHT_STATE", "TIME_LIMIT", "UPDATE_DATE", "UPDATE_VERSION", "WINDOWED_LIMIT", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: SharedPreferencesStorageService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public String getDisplayName() {
        String string = this.encryptedSharedPreferences.getString(DISPLAY_NAME, Constants.DEFAULT_BOX_NAME);
        return string == null ? Constants.DEFAULT_BOX_NAME : string;
    }

    public void setDisplayName(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$displayName$1(str));
    }

    public DeviceInformation getDeviceInformation() {
        if (this._deviceInformation == null) {
            String string = this.encryptedSharedPreferences.getString(DEVICE_INFO, (String) null);
            if (string == null) {
                return null;
            }
            this._deviceInformation = (DeviceInformation) new Gson().fromJson(string, DeviceInformation.class);
        }
        return this._deviceInformation;
    }

    public void setDeviceInformation(DeviceInformation deviceInformation) {
        String str;
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$deviceInformation$1(deviceInformation));
        if (deviceInformation == null || (str = deviceInformation.getDisplayName()) == null) {
            str = Constants.DEFAULT_BOX_NAME;
        }
        setDisplayName(str);
        this._deviceInformation = deviceInformation;
    }

    public boolean getMusicLightOn() {
        return this.encryptedSharedPreferences.getBoolean(MUSIC_LIGHT_ON, true);
    }

    public void setMusicLightOn(boolean z) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$musicLightOn$1(z));
    }

    public int getTigerLightIntensity() {
        return this.encryptedSharedPreferences.getInt(KEY_TIGER_LIGHT_INTENSITY, 80);
    }

    public void setTigerLightIntensity(int i) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$tigerLightIntensity$1(i));
    }

    public boolean getTigerLightEnabled() {
        return this.encryptedSharedPreferences.getBoolean(KEY_TIGER_LIGHT_ENABLED, false);
    }

    public void setTigerLightEnabled(boolean z) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$tigerLightEnabled$1(z));
    }

    public TigerButtonLightStatus getTigerButtonLightState() {
        SharedPreferences sharedPreferences = this.encryptedSharedPreferences;
        TigerButtonLightStatus tigerButtonLightStatus = BUTTON_LIGHT_DEFAULT;
        String string = sharedPreferences.getString(TIGER_BUTTON_LIGHT_STATE, tigerButtonLightStatus.name());
        if (string == null) {
            string = tigerButtonLightStatus.name();
        }
        Intrinsics.checkNotNullExpressionValue(string, "encryptedSharedPreferenc…BUTTON_LIGHT_DEFAULT.name");
        return TigerButtonLightStatus.valueOf(string);
    }

    public void setTigerButtonLightState(TigerButtonLightStatus tigerButtonLightStatus) {
        Intrinsics.checkNotNullParameter(tigerButtonLightStatus, "value");
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$tigerButtonLightState$1(tigerButtonLightStatus));
    }

    public boolean getTigerButtonLightEnabled() {
        return this.encryptedSharedPreferences.getBoolean(TIGER_BUTTON_LIGHT_ENABLED, BUTTON_LIGHT_ENABLED_DEFAULT);
    }

    public void setTigerButtonLightEnabled(boolean z) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$tigerButtonLightEnabled$1(z));
    }

    public boolean getGoToLogin() {
        return this.encryptedSharedPreferences.getBoolean(GO_TO_LOGIN, false);
    }

    public void setGoToLogin(boolean z) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$goToLogin$1(z));
    }

    public String getAttemptedUpdateVersion() {
        String string = this.encryptedSharedPreferences.getString(UPDATE_VERSION, "");
        return string == null ? "" : string;
    }

    public void setAttemptedUpdateVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$attemptedUpdateVersion$1(str));
    }

    public Date getUpdateDate() {
        return new Date(this.encryptedSharedPreferences.getLong(UPDATE_DATE, 0));
    }

    public void setUpdateDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "value");
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$updateDate$1(date));
    }

    public String getFirmwareDownloadPath() {
        return this.firmwareDownloadPath;
    }

    public String getFirmwareInstallPath() {
        return this.firmwareInstallPath;
    }

    public boolean getFlagSubmitLogsEnabled() {
        return Boolean.parseBoolean(this.configurationProperties.getProperty(FLAG_SUBMIT_LOGS));
    }

    public boolean getFlagAutoplayEnabled() {
        return Boolean.parseBoolean(this.configurationProperties.getProperty(FLAG_AUTOPLAY));
    }

    public boolean getFlagForceCrashEnabled() {
        return Boolean.parseBoolean(this.configurationProperties.getProperty(FLAG_FORCE_CRASH));
    }

    public boolean getFlagManualTicketRedemptionEnabled() {
        return Boolean.parseBoolean(this.configurationProperties.getProperty(FLAG_MANUAL_TICKET_REDEMPTION));
    }

    public boolean getFlagAdvancedTimersEnabled() {
        return Boolean.parseBoolean(this.configurationProperties.getProperty(FLAG_ADVANCED_TIMERS));
    }

    public boolean getFlagProfilesEnabled() {
        return Boolean.parseBoolean(this.configurationProperties.getProperty(FLAG_PROFILES));
    }

    public boolean getFlagProfilesMainContentSwitchEnabled() {
        return Boolean.parseBoolean(this.configurationProperties.getProperty(FLAG_PROFILES_MAIN_CONTENT_SWITCH));
    }

    public boolean getFlagPinEntryEnabled() {
        return Boolean.parseBoolean(this.configurationProperties.getProperty(FLAG_PIN_ENTRY));
    }

    public boolean getFlagAutoLogsEnabled() {
        return Boolean.parseBoolean(this.configurationProperties.getProperty(FLAG_AUTO_LOGS));
    }

    public void registerFlagChangeListener(FlagChangeListener flagChangeListener) {
        Intrinsics.checkNotNullParameter(flagChangeListener, "listener");
        if (!this.listeners.contains(flagChangeListener)) {
            this.listeners.add(flagChangeListener);
        }
    }

    public void unregisterFlagChangeListener(FlagChangeListener flagChangeListener) {
        Intrinsics.checkNotNullParameter(flagChangeListener, "listener");
        this.listeners.remove(flagChangeListener);
    }

    public void notifyFlagChanged() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), (CoroutineContext) null, (CoroutineStart) null, new SharedPreferencesStorageService$notifyFlagChanged$1(this, (Continuation<? super SharedPreferencesStorageService$notifyFlagChanged$1>) null), 3, (Object) null);
    }

    public Object completeOnboarding(boolean z, Continuation<? super Either.Right<Boolean>> continuation) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$completeOnboarding$2(z));
        return new Either.Right(Boxing.boxBoolean(true));
    }

    public boolean getOnboardingCompleted() {
        return this.encryptedSharedPreferences.getBoolean(ONBOARDING_COMPLETED, false);
    }

    public void saveWifiPassword(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        Intrinsics.checkNotNullParameter(str2, "password");
        if (!StringsKt.isBlank(str2)) {
            SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$saveWifiPassword$1(str, str2));
        }
    }

    public String findWifiPassword(String str) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        SharedPreferences sharedPreferences = this.encryptedSharedPreferences;
        return sharedPreferences.getString("WIFI_" + str, (String) null);
    }

    public boolean saveAcquisitions(int i, List<Acquisition> list) {
        Intrinsics.checkNotNullParameter(list, "acquisitions");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new SharedPreferencesStorageService$saveAcquisitions$1(i, list, this, (Continuation<? super SharedPreferencesStorageService$saveAcquisitions$1>) null), 3, (Object) null);
        return true;
    }

    public List<Acquisition> getAcquisitions(int i) {
        String string = this.encryptedSharedPreferences.getString("ACQUISITIONS_" + i, "");
        if (string == null) {
            return null;
        }
        return (List) new Gson().fromJson(string, new C2894xddb649b3().getType());
    }

    public void storeOfflineStartTimeAndDate() {
        if (!this.encryptedSharedPreferences.contains(OFFLINE_START_TIME_AND_DATE)) {
            SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, SharedPreferencesStorageService$storeOfflineStartTimeAndDate$1.INSTANCE);
        }
    }

    public void replaceOfflineStartTimeAndDate(int i) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$replaceOfflineStartTimeAndDate$1(i));
    }

    public void removeOfflineStartTimeAndDate() {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, SharedPreferencesStorageService$removeOfflineStartTimeAndDate$1.INSTANCE);
    }

    public String getOfflineStartTimeAndDate() {
        return this.encryptedSharedPreferences.getString(OFFLINE_START_TIME_AND_DATE, (String) null);
    }

    public boolean getTigerCardModeEnabled() {
        return this.encryptedSharedPreferences.getBoolean(KEY_TIGER_CARD_MODE, false);
    }

    public void setTigerCardModeEnabled(boolean z) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$setTigerCardModeEnabled$1(z));
    }

    public boolean getAutoplay() {
        if (getFlagAutoplayEnabled()) {
            return this.encryptedSharedPreferences.getBoolean(KEY_AUTOPLAY_MODE, false);
        }
        return false;
    }

    public void setAutoplay(boolean z) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$autoplay$1(z));
    }

    public boolean getParentalGate() {
        if (getFlagPinEntryEnabled()) {
            return this.encryptedSharedPreferences.getBoolean(KEY_PARENTAL_GATE_ENABLED, false);
        }
        return false;
    }

    public void setParentalGate(boolean z) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$parentalGate$1(z));
    }

    public int getCurrentMaxVolume() {
        return this.encryptedSharedPreferences.getInt(CURRENT_MAX_VOLUME, this.audioManager.getStreamMaxVolume(3));
    }

    public void setCurrentMaxVolume(int i) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$currentMaxVolume$1(i));
    }

    public TimeLimit getTimeLimit() {
        try {
            Object fromJson = new Gson().fromJson(this.encryptedSharedPreferences.getString(TIME_LIMIT, new Gson().toJson((Object) new TimeLimit(Constants.DEFAULT_DATE, -1, -1))), TimeLimit.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "{\n                Gson()…class.java)\n            }");
            return (TimeLimit) fromJson;
        } catch (JsonSyntaxException e) {
            Timber.Forest.tag("SharedPreferencesStorageService").mo50218e(e);
            return new TimeLimit(Constants.DEFAULT_DATE, -1, -1);
        }
    }

    public void setTimeLimit(TimeLimit timeLimit) {
        Intrinsics.checkNotNullParameter(timeLimit, "value");
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$timeLimit$1(timeLimit));
        notifyTimeLimitChanged();
    }

    public WindowedLimits getWindowedLimit() {
        try {
            Object fromJson = new Gson().fromJson(this.encryptedSharedPreferences.getString(WINDOWED_LIMIT, new Gson().toJson((Object) new WindowedLimits(CollectionsKt.emptyList()))), WindowedLimits.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "{\n                Gson()…class.java)\n            }");
            return (WindowedLimits) fromJson;
        } catch (JsonSyntaxException e) {
            Timber.Forest.tag("SharedPreferencesStorageService").mo50218e(e);
            return new WindowedLimits(CollectionsKt.emptyList());
        }
    }

    public void setWindowedLimit(WindowedLimits windowedLimits) {
        Intrinsics.checkNotNullParameter(windowedLimits, "value");
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$windowedLimit$1(windowedLimits));
        notifyTimeLimitChanged();
    }

    public void registerTimeLimitChangeListener(TimerLimitChangeListener timerLimitChangeListener) {
        Intrinsics.checkNotNullParameter(timerLimitChangeListener, "listener");
        if (!this.timeLimitListeners.contains(timerLimitChangeListener)) {
            this.timeLimitListeners.add(timerLimitChangeListener);
        }
    }

    public void unregisterTimeLimitChangeListener(TimerLimitChangeListener timerLimitChangeListener) {
        Intrinsics.checkNotNullParameter(timerLimitChangeListener, "listener");
        this.timeLimitListeners.remove(timerLimitChangeListener);
    }

    private final void notifyTimeLimitChanged() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), (CoroutineContext) null, (CoroutineStart) null, new SharedPreferencesStorageService$notifyTimeLimitChanged$1(this, (Continuation<? super SharedPreferencesStorageService$notifyTimeLimitChanged$1>) null), 3, (Object) null);
    }

    public float getVolume(float f) {
        return this.encryptedSharedPreferences.getFloat(STREAM_VOLUME, f);
    }

    public void saveVolume(float f) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$saveVolume$1(f));
    }

    public boolean isMuted() {
        return this.encryptedSharedPreferences.getBoolean(STREAM_VOLUME_MUTED, false);
    }

    public void setMuted(boolean z) {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$isMuted$1(z));
    }

    public NightLight getNightLightTimer() {
        String string = this.encryptedSharedPreferences.getString(KEY_NIGHT_LIGHT_TIMERS, "");
        boolean z = false;
        if (string != null) {
            if (string.length() > 0) {
                z = true;
            }
            if (z) {
                Object fromJson = new Gson().fromJson(string, NightLight.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(str, NightLight::class.java)");
                return (NightLight) fromJson;
            }
        }
        return new NightLight((String) null, (String) null, (Boolean) null, false, Boolean.valueOf(getTigerLightEnabled()), Integer.valueOf(getTigerLightIntensity()));
    }

    public void saveNightLightTimer(NightLight nightLight) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (nightLight != null) {
            T json = new Gson().toJson((Object) nightLight);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(it)");
            objectRef.element = json;
        }
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$saveNightLightTimer$2(objectRef));
    }

    public String getKeyStorePassword() {
        return (String) this.keyStorePassword$delegate.getValue();
    }

    public KeyStore getKeyStore() {
        return this.keyStore;
    }

    public KeyManagerFactory getKeyManagerFactory() {
        Object value = this.keyManagerFactory$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-keyManagerFactory>(...)");
        return (KeyManagerFactory) value;
    }

    public KeyPair generateCertificateKeyPair() {
        String string = this.encryptedSharedPreferences.getString(CERTIFICATE_KEYPAIR_PRIVATE, "");
        String string2 = this.encryptedSharedPreferences.getString(CERTIFICATE_KEYPAIR_PUBLIC, "");
        CharSequence charSequence = string;
        boolean z = true;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = string2;
            if (charSequence2 != null && !StringsKt.isBlank(charSequence2)) {
                z = false;
            }
            if (!z) {
                byte[] decode = Base64.decode(string, 0);
                byte[] decode2 = Base64.decode(string2, 0);
                PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(decode);
                KeyFactory instance = KeyFactory.getInstance("RSA");
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance(\"RSA\")");
                return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode2)), instance.generatePrivate(pKCS8EncodedKeySpec));
            }
        }
        KeyPairGenerator instance2 = KeyPairGenerator.getInstance("RSA");
        instance2.initialize(4096);
        KeyPair generateKeyPair = instance2.generateKeyPair();
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$generateCertificateKeyPair$1(generateKeyPair.getPrivate().getEncoded(), generateKeyPair.getPublic().getEncoded()));
        Intrinsics.checkNotNullExpressionValue(generateKeyPair, "keyPair");
        return generateKeyPair;
    }

    public boolean saveCertificateData(PemResponse.CertificateData certificateData) {
        Intrinsics.checkNotNullParameter(certificateData, "certificateData");
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$saveCertificateData$1(certificateData));
        X509Certificate[] x509CertificateArr = {certificateData.getCaCertificate(), certificateData.getPublicCertificate()};
        KeyStore keyStore2 = getKeyStore();
        try {
            keyStore2.load((KeyStore.LoadStoreParameter) null);
            char[] charArray = getKeyStorePassword().toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
            keyStore2.setKeyEntry(P12_CHAIN, certificateData.getKey(), charArray, (Certificate[]) x509CertificateArr);
            return true;
        } catch (Exception e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("saveCertificateData exception: " + e, new Object[0]);
            return false;
        }
    }

    public boolean loadCertificate(KeyPair keyPair) {
        Intrinsics.checkNotNullParameter(keyPair, "keyPair");
        String string = this.encryptedSharedPreferences.getString(CERTIFICATE_SIGNING_RAW, "");
        CharSequence charSequence = string;
        boolean z = true;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        String string2 = this.encryptedSharedPreferences.getString(CERTIFICATE_SIGNING_REQUEST, "");
        CharSequence charSequence2 = string2;
        if (!(charSequence2 == null || charSequence2.length() == 0)) {
            z = false;
        }
        if (z) {
            return false;
        }
        Pair<X509Certificate, X509Certificate> parseCertificateData = PemUtils.INSTANCE.parseCertificateData(string);
        X509Certificate component2 = parseCertificateData.component2();
        PrivateKey privateKey = keyPair.getPrivate();
        Intrinsics.checkNotNullExpressionValue(privateKey, "keyPair.private");
        return saveCertificateData(new PemResponse.CertificateData(privateKey, string2, component2, parseCertificateData.component1(), string));
    }

    public Object clearAllData(Continuation<? super Unit> continuation) {
        this.encryptedSharedPreferences.edit().clear().commit();
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
        throw r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean saveFirmware(okhttp3.ResponseBody r11) {
        /*
            r10 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r11.byteStream()     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004b, all -> 0x0047 }
            java.lang.String r4 = r10.getFirmwareDownloadPath()     // Catch:{ Exception -> 0x004b, all -> 0x0047 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x004b, all -> 0x0047 }
            r4 = r3
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ Exception -> 0x0045 }
            r5 = r4
            java.io.FileOutputStream r5 = (java.io.FileOutputStream) r5     // Catch:{ all -> 0x003e }
            r6 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x003e }
        L_0x001e:
            int r7 = r2.read(r6)     // Catch:{ all -> 0x003e }
            r8 = -1
            if (r7 == r8) goto L_0x0029
            r5.write(r6, r0, r7)     // Catch:{ all -> 0x003e }
            goto L_0x001e
        L_0x0029:
            r5.flush()     // Catch:{ all -> 0x003e }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003e }
            kotlin.p013io.CloseableKt.closeFinally(r4, r1)     // Catch:{ Exception -> 0x0045 }
            if (r2 == 0) goto L_0x0036
            r2.close()
        L_0x0036:
            r3.close()
            r11.close()
            r11 = 1
            return r11
        L_0x003e:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r5 = move-exception
            kotlin.p013io.CloseableKt.closeFinally(r4, r1)     // Catch:{ Exception -> 0x0045 }
            throw r5     // Catch:{ Exception -> 0x0045 }
        L_0x0045:
            r1 = move-exception
            goto L_0x0057
        L_0x0047:
            r0 = move-exception
            r3 = r1
        L_0x0049:
            r1 = r2
            goto L_0x0081
        L_0x004b:
            r3 = move-exception
            r9 = r3
            r3 = r1
            r1 = r9
            goto L_0x0057
        L_0x0050:
            r0 = move-exception
            r3 = r1
            goto L_0x0081
        L_0x0053:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        L_0x0057:
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest     // Catch:{ all -> 0x007f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
            r5.<init>()     // Catch:{ all -> 0x007f }
            java.lang.String r6 = "saveFirmware: "
            r5.append(r6)     // Catch:{ all -> 0x007f }
            r5.append(r1)     // Catch:{ all -> 0x007f }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x007f }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x007f }
            r4.mo50217e(r1, r5)     // Catch:{ all -> 0x007f }
            java.io.InputStream r2 = (java.io.InputStream) r2
            if (r2 == 0) goto L_0x0076
            r2.close()
        L_0x0076:
            if (r3 == 0) goto L_0x007b
            r3.close()
        L_0x007b:
            r11.close()
            return r0
        L_0x007f:
            r0 = move-exception
            goto L_0x0049
        L_0x0081:
            java.io.InputStream r1 = (java.io.InputStream) r1
            if (r1 == 0) goto L_0x0088
            r1.close()
        L_0x0088:
            if (r3 == 0) goto L_0x008d
            r3.close()
        L_0x008d:
            r11.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.SharedPreferencesStorageService.saveFirmware(okhttp3.ResponseBody):boolean");
    }

    public void deleteFirmware() {
        File file = new File(getFirmwareDownloadPath());
        if (file.exists()) {
            file.delete();
        }
    }

    public void clearFeatureFlags() {
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, SharedPreferencesStorageService$clearFeatureFlags$1.INSTANCE);
        notifyFlagChanged();
    }

    public void saveFeatureFlags(ReportInformationDto.FlagSubmitLogs flagSubmitLogs, ReportInformationDto.FlagAutoplay flagAutoplay, ReportInformationDto.FlagForceCrash flagForceCrash, ReportInformationDto.FlagManualTicketRedemption flagManualTicketRedemption, ReportInformationDto.FlagAdvancedTimers flagAdvancedTimers, ReportInformationDto.FlagProfiles flagProfiles, ReportInformationDto.FlagPinEntry flagPinEntry, ReportInformationDto.FlagAutoLogs flagAutoLogs) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "true";
        if (flagSubmitLogs != null) {
            this.configurationProperties.setVolatileProperty(FLAG_SUBMIT_LOGS, flagSubmitLogs.getEnabled() ? str7 : "false");
        }
        if (flagAutoplay != null) {
            ConfigurationProperties configurationProperties2 = this.configurationProperties;
            if (flagAutoplay.getEnabled()) {
                str6 = str7;
            } else {
                str6 = "false";
            }
            configurationProperties2.setVolatileProperty(FLAG_AUTOPLAY, str6);
        }
        if (flagForceCrash != null) {
            ConfigurationProperties configurationProperties3 = this.configurationProperties;
            if (flagForceCrash.getEnabled()) {
                str5 = str7;
            } else {
                str5 = "false";
            }
            configurationProperties3.setVolatileProperty(FLAG_FORCE_CRASH, str5);
        }
        if (flagManualTicketRedemption != null) {
            ConfigurationProperties configurationProperties4 = this.configurationProperties;
            if (flagManualTicketRedemption.getEnabled()) {
                str4 = str7;
            } else {
                str4 = "false";
            }
            configurationProperties4.setVolatileProperty(FLAG_MANUAL_TICKET_REDEMPTION, str4);
        }
        if (flagAdvancedTimers != null) {
            ConfigurationProperties configurationProperties5 = this.configurationProperties;
            if (flagAdvancedTimers.getEnabled()) {
                str3 = str7;
            } else {
                str3 = "false";
            }
            configurationProperties5.setVolatileProperty(FLAG_ADVANCED_TIMERS, str3);
        }
        if (flagProfiles != null) {
            ConfigurationProperties configurationProperties6 = this.configurationProperties;
            if (flagProfiles.getEnabled()) {
                str2 = str7;
            } else {
                str2 = "false";
            }
            configurationProperties6.setVolatileProperty(FLAG_PROFILES, str2);
        }
        if (flagPinEntry != null) {
            ConfigurationProperties configurationProperties7 = this.configurationProperties;
            if (flagPinEntry.getEnabled()) {
                str = str7;
            } else {
                str = "false";
            }
            configurationProperties7.setVolatileProperty(FLAG_PIN_ENTRY, str);
        }
        if (flagAutoLogs != null) {
            ConfigurationProperties configurationProperties8 = this.configurationProperties;
            if (!flagAutoLogs.getEnabled()) {
                str7 = "false";
            }
            configurationProperties8.setVolatileProperty(FLAG_AUTO_LOGS, str7);
        }
        notifyFlagChanged();
    }

    public String getOfflineRowTitle() {
        String string = this.encryptedSharedPreferences.getString(OFFLINE_ROW_TITLE, "");
        return string == null ? "" : string;
    }

    public void setOfflineRowTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        SharedPreferencesStorageServiceKt.save(this.encryptedSharedPreferences, new SharedPreferencesStorageService$offlineRowTitle$1(str));
    }
}
