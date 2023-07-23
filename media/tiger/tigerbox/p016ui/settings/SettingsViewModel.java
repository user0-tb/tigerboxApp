package media.tiger.tigerbox.p016ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.TigerBoxLogTree;
import media.tiger.tigerbox.WriteToFileExceptionHandler;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel;
import media.tiger.tigerbox.services.implementations.timersController.WindowedLimits;
import media.tiger.tigerbox.services.interfaces.AccountSubscriptionService;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.WildcardReassignStep;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000­\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0015*\u0003HUX\b\u0007\u0018\u00002\u00020\u0001:\u0003yz{B\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 J\u0006\u0010f\u001a\u00020gJ\u0006\u0010h\u001a\u00020gJ\u0006\u0010i\u001a\u00020gJ\b\u0010j\u001a\u00020gH\u0002J\u0006\u0010k\u001a\u00020gJ\u0006\u0010l\u001a\u00020gJ\u000e\u0010m\u001a\u00020g2\u0006\u0010n\u001a\u00020\"J\u0006\u0010o\u001a\u00020gJ\u0006\u0010p\u001a\u00020gJ\u0006\u0010q\u001a\u00020gJ\u0006\u0010r\u001a\u00020gJ\u0006\u0010s\u001a\u00020gJ\u0006\u0010t\u001a\u00020gJ\u0006\u0010u\u001a\u00020gJ\u0006\u0010v\u001a\u00020gJ\u0006\u0010w\u001a\u00020gJ\b\u0010x\u001a\u00020gH\u0002R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b,\u0010*R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R$\u00102\u001a\u00020\"2\u0006\u00101\u001a\u00020\"8F@FX\u000e¢\u0006\f\u001a\u0004\b3\u0010*\"\u0004\b4\u00105R\u0011\u00106\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b7\u0010*R\u0011\u00108\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b9\u0010*R\u0011\u0010:\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b;\u0010*R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010=\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b=\u0010*R\u0011\u0010>\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b>\u0010*R\u0011\u0010?\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b?\u0010*R$\u0010@\u001a\u00020\"2\u0006\u00101\u001a\u00020\"8F@FX\u000e¢\u0006\f\u001a\u0004\b@\u0010*\"\u0004\bA\u00105R$\u0010B\u001a\u00020\"2\u0006\u00101\u001a\u00020\"8F@FX\u000e¢\u0006\f\u001a\u0004\bB\u0010*\"\u0004\bC\u00105R\u0011\u0010D\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bD\u0010*R\u0011\u0010E\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bE\u0010*R\u0011\u0010F\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bF\u0010*R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u00020HX\u0004¢\u0006\u0004\n\u0002\u0010IR\u0011\u0010J\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bK\u0010*R\u0011\u0010L\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bM\u0010*R\u0011\u0010N\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bO\u0010*R\u0011\u0010P\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bQ\u0010*R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u00020UX\u0004¢\u0006\u0004\n\u0002\u0010VR\u0010\u0010W\u001a\u00020XX\u0004¢\u0006\u0004\n\u0002\u0010YR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010Z\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b[\u0010*R\u0011\u0010\\\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b]\u0010*R\u0011\u0010^\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b_\u0010*R\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020%0a¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020'0a¢\u0006\b\n\u0000\u001a\u0004\be\u0010cR\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006|"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel;", "Lmedia/tiger/tigerbox/ui/common/FullScreenViewModel;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "tigerCardsManagerService", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;", "subscriptionService", "Lmedia/tiger/tigerbox/services/interfaces/AccountSubscriptionService;", "lightControl", "Lmedia/tiger/tigerbox/services/interfaces/LightControlService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "infoSoundService", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "accountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "shutDownTimerService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimerService;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "writeToFileExceptionHandler", "Lmedia/tiger/tigerbox/WriteToFileExceptionHandler;", "boxLogTree", "Lmedia/tiger/tigerbox/TigerBoxLogTree;", "firmwareUpdateService", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService;", "headerProvider", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "(Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;Lmedia/tiger/tigerbox/services/interfaces/AccountSubscriptionService;Lmedia/tiger/tigerbox/services/interfaces/LightControlService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimerService;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;Lmedia/tiger/tigerbox/WriteToFileExceptionHandler;Lmedia/tiger/tigerbox/TigerBoxLogTree;Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService;Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;)V", "_isWifiEnabled", "", "_viewState", "Landroidx/lifecycle/MutableLiveData;", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel$ViewState;", "_wildcardReassignState", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel$WildcardState;", "canForceCrash", "getCanForceCrash", "()Z", "canSubmitLogs", "getCanSubmitLogs", "currentProfileName", "", "getCurrentProfileName", "()Ljava/lang/String;", "value", "hasAlreadyShownUpdateDialogue", "getHasAlreadyShownUpdateDialogue", "setHasAlreadyShownUpdateDialogue", "(Z)V", "hasAnyTimerSet", "getHasAnyTimerSet", "hasFirmwareUpdateAvailable", "getHasFirmwareUpdateAvailable", "hasLogsOrCrashes", "getHasLogsOrCrashes", "insertedNfcCardType", "isAutoplayEnabled", "isMusicLightEnabled", "isParentalGateEnabled", "isTigerButtonLightEnabled", "setTigerButtonLightEnabled", "isTigerCardModeEnabled", "setTigerCardModeEnabled", "isTigerLightEnabled", "isWifiEnabled", "isWildcardReassignModeEnabled", "lightIntensityListener", "media/tiger/tigerbox/ui/settings/SettingsViewModel$lightIntensityListener$1", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel$lightIntensityListener$1;", "showAdvanceTimers", "getShowAdvanceTimers", "showAutoPlay", "getShowAutoPlay", "showParentalGate", "getShowParentalGate", "showTicketManualRedemption", "getShowTicketManualRedemption", "subscriptionInfo", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel$SubscriptionViewState;", "systemSoundEnabledListener", "media/tiger/tigerbox/ui/settings/SettingsViewModel$systemSoundEnabledListener$1", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel$systemSoundEnabledListener$1;", "tigerCardListener", "media/tiger/tigerbox/ui/settings/SettingsViewModel$tigerCardListener$1", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel$tigerCardListener$1;", "timerActive", "getTimerActive", "useProfiles", "getUseProfiles", "useProfilesMainContentSwitchEnabled", "getUseProfilesMainContentSwitchEnabled", "viewState", "Landroidx/lifecycle/LiveData;", "getViewState", "()Landroidx/lifecycle/LiveData;", "wildcardReassignState", "getWildcardReassignState", "clearObservers", "", "deleteAllDownloadedProducts", "deleteProfileDownloadedProducts", "postViewState", "registerObservers", "requestState", "setWifiEnabled", "state", "toggleAutoplay", "toggleCardsMode", "toggleDiscoLight", "toggleSound", "toggleTigerButtonLight", "toggleTigerLight", "toggleWifi", "toggleWildcardReassign", "turnTigerLightOn", "updateSubscriptionInfo", "SubscriptionViewState", "ViewState", "WildcardState", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewModel */
/* compiled from: SettingsViewModel.kt */
public final class SettingsViewModel extends FullScreenViewModel {
    private boolean _isWifiEnabled;
    private final MutableLiveData<ViewState> _viewState;
    /* access modifiers changed from: private */
    public final MutableLiveData<WildcardState> _wildcardReassignState;
    private final TigerBoxAccountRepository accountRepository;
    /* access modifiers changed from: private */
    public final AvailabilityService availabilityService;
    private final TigerBoxLogTree boxLogTree;
    private final ConfigurationProperties configurationProperties;
    private final FirmwareUpdateService firmwareUpdateService;
    private final InfoSoundService infoSoundService;
    /* access modifiers changed from: private */
    public String insertedNfcCardType;
    private final LightControlService lightControl;
    private final SettingsViewModel$lightIntensityListener$1 lightIntensityListener;
    private final ShutDownTimerService shutDownTimerService;
    private final StorageService storageService;
    /* access modifiers changed from: private */
    public SubscriptionViewState subscriptionInfo;
    private final AccountSubscriptionService subscriptionService;
    private final SettingsViewModel$systemSoundEnabledListener$1 systemSoundEnabledListener;
    private final SettingsViewModel$tigerCardListener$1 tigerCardListener;
    private final TigerCardsManagerService tigerCardsManagerService;
    private final LiveData<ViewState> viewState;
    private final WifiService wifiService;
    private final LiveData<WildcardState> wildcardReassignState;
    private final WriteToFileExceptionHandler writeToFileExceptionHandler;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x00ae, code lost:
        r2 = r2.getFormattedEndDate();
     */
    /* JADX WARNING: Illegal instructions before constructor call */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SettingsViewModel(media.tiger.tigerbox.services.implementations.ButtonService r17, media.tiger.tigerbox.services.interfaces.TigerCardsManagerService r18, media.tiger.tigerbox.services.interfaces.AccountSubscriptionService r19, media.tiger.tigerbox.services.interfaces.LightControlService r20, media.tiger.tigerbox.services.interfaces.StorageService r21, media.tiger.tigerbox.services.interfaces.InfoSoundService r22, media.tiger.tigerbox.services.interfaces.WifiService r23, media.tiger.tigerbox.data.repository.TigerBoxAccountRepository r24, media.tiger.tigerbox.services.interfaces.AvailabilityService r25, media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService r26, media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties r27, media.tiger.tigerbox.WriteToFileExceptionHandler r28, media.tiger.tigerbox.TigerBoxLogTree r29, media.tiger.tigerbox.services.interfaces.FirmwareUpdateService r30, media.tiger.tigerbox.services.interfaces.HeaderProvider r31) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r27
            r12 = r28
            r13 = r29
            r14 = r30
            r15 = r31
            java.lang.String r0 = "buttonService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "tigerCardsManagerService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "subscriptionService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "lightControl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "storageService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "infoSoundService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "wifiService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "accountRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "availabilityService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "shutDownTimerService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "configurationProperties"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "writeToFileExceptionHandler"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "boxLogTree"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "firmwareUpdateService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "headerProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = r16
            r0.<init>(r1, r15)
            r0.tigerCardsManagerService = r2
            r0.subscriptionService = r3
            r0.lightControl = r4
            r0.storageService = r5
            r0.infoSoundService = r6
            r0.wifiService = r7
            r0.accountRepository = r8
            r0.availabilityService = r9
            r0.shutDownTimerService = r10
            r0.configurationProperties = r11
            r0.writeToFileExceptionHandler = r12
            r0.boxLogTree = r13
            r0.firmwareUpdateService = r14
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0._viewState = r1
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            r0.viewState = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0._wildcardReassignState = r1
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            r0.wildcardReassignState = r1
            boolean r1 = r23.getWifiEnabled()
            r0._isWifiEnabled = r1
            media.tiger.tigerbox.ui.settings.SettingsViewModel$SubscriptionViewState r1 = new media.tiger.tigerbox.ui.settings.SettingsViewModel$SubscriptionViewState
            media.tiger.tigerbox.model.domain.AccountSubscriptionDomain r2 = r19.getActiveSubscription()
            if (r2 == 0) goto L_0x00b4
            java.lang.String r2 = r2.getFormattedEndDate()
            if (r2 != 0) goto L_0x00b6
        L_0x00b4:
            java.lang.String r2 = ""
        L_0x00b6:
            media.tiger.tigerbox.services.interfaces.SubscriptionState r4 = r19.getActiveState()
            media.tiger.tigerbox.services.interfaces.SubscriptionState r5 = media.tiger.tigerbox.services.interfaces.SubscriptionState.EXPIRED
            r6 = 1
            r7 = 0
            if (r4 != r5) goto L_0x00c2
            r4 = 1
            goto L_0x00c3
        L_0x00c2:
            r4 = 0
        L_0x00c3:
            media.tiger.tigerbox.services.interfaces.SubscriptionState r5 = r19.getActiveState()
            media.tiger.tigerbox.services.interfaces.SubscriptionState r8 = media.tiger.tigerbox.services.interfaces.SubscriptionState.SUBSCRIBED_BUT_ABOUT_TO_EXPIRE
            if (r5 != r8) goto L_0x00cd
            r5 = 1
            goto L_0x00ce
        L_0x00cd:
            r5 = 0
        L_0x00ce:
            media.tiger.tigerbox.model.domain.AccountSubscriptionDomain r3 = r19.getActiveSubscription()
            if (r3 == 0) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r6 = 0
        L_0x00d6:
            r1.<init>(r2, r4, r5, r6)
            r0.subscriptionInfo = r1
            media.tiger.tigerbox.ui.settings.SettingsViewModel$lightIntensityListener$1 r1 = new media.tiger.tigerbox.ui.settings.SettingsViewModel$lightIntensityListener$1
            r1.<init>(r0)
            r0.lightIntensityListener = r1
            media.tiger.tigerbox.ui.settings.SettingsViewModel$systemSoundEnabledListener$1 r1 = new media.tiger.tigerbox.ui.settings.SettingsViewModel$systemSoundEnabledListener$1
            r1.<init>(r0)
            r0.systemSoundEnabledListener = r1
            media.tiger.tigerbox.ui.settings.SettingsViewModel$tigerCardListener$1 r1 = new media.tiger.tigerbox.ui.settings.SettingsViewModel$tigerCardListener$1
            r1.<init>(r0)
            r0.tigerCardListener = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.settings.SettingsViewModel.<init>(media.tiger.tigerbox.services.implementations.ButtonService, media.tiger.tigerbox.services.interfaces.TigerCardsManagerService, media.tiger.tigerbox.services.interfaces.AccountSubscriptionService, media.tiger.tigerbox.services.interfaces.LightControlService, media.tiger.tigerbox.services.interfaces.StorageService, media.tiger.tigerbox.services.interfaces.InfoSoundService, media.tiger.tigerbox.services.interfaces.WifiService, media.tiger.tigerbox.data.repository.TigerBoxAccountRepository, media.tiger.tigerbox.services.interfaces.AvailabilityService, media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService, media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties, media.tiger.tigerbox.WriteToFileExceptionHandler, media.tiger.tigerbox.TigerBoxLogTree, media.tiger.tigerbox.services.interfaces.FirmwareUpdateService, media.tiger.tigerbox.services.interfaces.HeaderProvider):void");
    }

    public final LiveData<ViewState> getViewState() {
        return this.viewState;
    }

    public final LiveData<WildcardState> getWildcardReassignState() {
        return this.wildcardReassignState;
    }

    public final boolean isTigerCardModeEnabled() {
        return this.storageService.getTigerCardModeEnabled();
    }

    public final void setTigerCardModeEnabled(boolean z) {
        this.storageService.setTigerCardModeEnabled(z);
    }

    public final boolean getHasFirmwareUpdateAvailable() {
        return this.firmwareUpdateService.getLatestValidRelease() != null;
    }

    public final boolean getHasAlreadyShownUpdateDialogue() {
        return this.firmwareUpdateService.getHasAlreadyShownUpdateDialogue();
    }

    public final void setHasAlreadyShownUpdateDialogue(boolean z) {
        this.firmwareUpdateService.setHasAlreadyShownUpdateDialogue(z);
    }

    public final boolean getUseProfiles() {
        return this.storageService.getFlagProfilesEnabled();
    }

    public final boolean getUseProfilesMainContentSwitchEnabled() {
        return this.storageService.getFlagProfilesMainContentSwitchEnabled();
    }

    public final String getCurrentProfileName() {
        TigerBoxProfileDomain activeProfile = this.accountRepository.getActiveProfile();
        return activeProfile != null ? activeProfile.getNickName() : "";
    }

    public final boolean isTigerButtonLightEnabled() {
        return this.lightControl.isTigerButtonLightEnabled();
    }

    public final void setTigerButtonLightEnabled(boolean z) {
        this.lightControl.setTigerButtonLightEnabled(z);
    }

    public final void toggleTigerButtonLight() {
        setTigerButtonLightEnabled(!isTigerButtonLightEnabled());
    }

    public final boolean isWildcardReassignModeEnabled() {
        return this.tigerCardsManagerService.getWildcardReassignModeEnabled();
    }

    public final boolean isWifiEnabled() {
        return this._isWifiEnabled;
    }

    public final boolean getTimerActive() {
        return this.shutDownTimerService.getCurrentShutDownTimeSeconds() > 0 || this.shutDownTimerService.getCurrentShutDownTimeSeconds() == -1;
    }

    public final boolean getHasAnyTimerSet() {
        boolean z = this.storageService.getTimeLimit().hasSetLimit() && !this.storageService.getTimeLimit().isEnded();
        boolean z2 = false;
        for (WindowedLimits.WindowedLimit isValid : this.storageService.getWindowedLimit().getLimits()) {
            if (isValid.isValid()) {
                z2 = true;
            }
        }
        if ((this.shutDownTimerService.getCurrentShutDownTimeSeconds() > 0 || this.shutDownTimerService.getCurrentShutDownTimeSeconds() == -1) || z2 || z) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void postViewState() {
        this._viewState.postValue(new ViewState(this.infoSoundService.getSystemSoundEnabled(), this.subscriptionInfo, this.lightControl.getTigerLightIntensity(), this.insertedNfcCardType));
    }

    public final boolean getHasLogsOrCrashes() {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("HAS LOGS OR CRAHES " + this.writeToFileExceptionHandler.getHasExceptions() + ' ' + this.boxLogTree.getHasLogs(), new Object[0]);
        if (this.writeToFileExceptionHandler.getHasExceptions() || this.boxLogTree.getHasLogs()) {
            return true;
        }
        return false;
    }

    public final void registerObservers() {
        this.tigerCardsManagerService.registerListener(this.tigerCardListener);
        this.lightControl.registerLightIntensityChangeListener(this.lightIntensityListener);
        this.infoSoundService.registerSystemSoundEnabledListener(this.systemSoundEnabledListener);
    }

    public final void clearObservers() {
        this.tigerCardsManagerService.unregisterListener(this.tigerCardListener);
        this.lightControl.unregisterLightIntensityChangeListener(this.lightIntensityListener);
        this.infoSoundService.unregisterSystemSoundEnabledListener(this.systemSoundEnabledListener);
    }

    public final void requestState() {
        updateSubscriptionInfo();
        postViewState();
    }

    public final boolean isTigerLightEnabled() {
        return this.lightControl.isTigerLightEnabled();
    }

    public final void toggleTigerLight() {
        LightControlService lightControlService = this.lightControl;
        lightControlService.setTigerLightEnabled(!lightControlService.isTigerLightEnabled());
        postViewState();
    }

    public final void turnTigerLightOn() {
        this.lightControl.setTigerLightEnabled(true);
        postViewState();
    }

    public final boolean isMusicLightEnabled() {
        return this.lightControl.isMusicLightEnabled();
    }

    public final void toggleDiscoLight() {
        LightControlService lightControlService = this.lightControl;
        lightControlService.setMusicLightEnabled(!lightControlService.isMusicLightEnabled());
    }

    public final boolean getShowAutoPlay() {
        return this.storageService.getFlagAutoplayEnabled();
    }

    public final boolean getShowTicketManualRedemption() {
        return this.storageService.getFlagManualTicketRedemptionEnabled();
    }

    public final boolean isAutoplayEnabled() {
        return this.storageService.getAutoplay();
    }

    public final void toggleAutoplay() {
        StorageService storageService2 = this.storageService;
        storageService2.setAutoplay(!storageService2.getAutoplay());
    }

    public final boolean isParentalGateEnabled() {
        return this.storageService.getParentalGate();
    }

    public final void toggleCardsMode() {
        setTigerCardModeEnabled(!isTigerCardModeEnabled());
    }

    public final void toggleWildcardReassign() {
        TigerCardsManagerService tigerCardsManagerService2 = this.tigerCardsManagerService;
        tigerCardsManagerService2.setWildcardReassignModeEnabled(!tigerCardsManagerService2.getWildcardReassignModeEnabled());
    }

    public final void deleteAllDownloadedProducts() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SettingsViewModel$deleteAllDownloadedProducts$1(this, (Continuation<? super SettingsViewModel$deleteAllDownloadedProducts$1>) null), 3, (Object) null);
    }

    public final void deleteProfileDownloadedProducts() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SettingsViewModel$deleteProfileDownloadedProducts$1(this, (Continuation<? super SettingsViewModel$deleteProfileDownloadedProducts$1>) null), 3, (Object) null);
    }

    public final void toggleSound() {
        InfoSoundService infoSoundService2 = this.infoSoundService;
        infoSoundService2.setSystemSoundEnabled(!infoSoundService2.getSystemSoundEnabled());
        postViewState();
    }

    public final boolean getCanSubmitLogs() {
        return this.storageService.getFlagSubmitLogsEnabled();
    }

    public final boolean getCanForceCrash() {
        return this.storageService.getFlagForceCrashEnabled();
    }

    public final boolean getShowParentalGate() {
        return this.storageService.getFlagPinEntryEnabled();
    }

    public final boolean getShowAdvanceTimers() {
        return this.storageService.getFlagAdvancedTimersEnabled();
    }

    public final void setWifiEnabled(boolean z) {
        this._isWifiEnabled = z;
        this.wifiService.setWifiEnabled(z);
    }

    public final void toggleWifi() {
        boolean z = !this._isWifiEnabled;
        this._isWifiEnabled = z;
        this.wifiService.setWifiEnabled(z);
    }

    private final void updateSubscriptionInfo() {
        this.subscriptionService.updateAccountSubscription(new SettingsViewModel$updateSubscriptionInfo$1(this));
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel$SubscriptionViewState;", "", "endDate", "", "expired", "", "aboutToExpire", "visible", "(Ljava/lang/String;ZZZ)V", "getAboutToExpire", "()Z", "getEndDate", "()Ljava/lang/String;", "getExpired", "getVisible", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewModel$SubscriptionViewState */
    /* compiled from: SettingsViewModel.kt */
    public static final class SubscriptionViewState {
        private final boolean aboutToExpire;
        private final String endDate;
        private final boolean expired;
        private final boolean visible;

        public static /* synthetic */ SubscriptionViewState copy$default(SubscriptionViewState subscriptionViewState, String str, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subscriptionViewState.endDate;
            }
            if ((i & 2) != 0) {
                z = subscriptionViewState.expired;
            }
            if ((i & 4) != 0) {
                z2 = subscriptionViewState.aboutToExpire;
            }
            if ((i & 8) != 0) {
                z3 = subscriptionViewState.visible;
            }
            return subscriptionViewState.copy(str, z, z2, z3);
        }

        public final String component1() {
            return this.endDate;
        }

        public final boolean component2() {
            return this.expired;
        }

        public final boolean component3() {
            return this.aboutToExpire;
        }

        public final boolean component4() {
            return this.visible;
        }

        public final SubscriptionViewState copy(String str, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(str, "endDate");
            return new SubscriptionViewState(str, z, z2, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubscriptionViewState)) {
                return false;
            }
            SubscriptionViewState subscriptionViewState = (SubscriptionViewState) obj;
            return Intrinsics.areEqual((Object) this.endDate, (Object) subscriptionViewState.endDate) && this.expired == subscriptionViewState.expired && this.aboutToExpire == subscriptionViewState.aboutToExpire && this.visible == subscriptionViewState.visible;
        }

        public int hashCode() {
            int hashCode = this.endDate.hashCode() * 31;
            boolean z = this.expired;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i = (hashCode + (z ? 1 : 0)) * 31;
            boolean z3 = this.aboutToExpire;
            if (z3) {
                z3 = true;
            }
            int i2 = (i + (z3 ? 1 : 0)) * 31;
            boolean z4 = this.visible;
            if (!z4) {
                z2 = z4;
            }
            return i2 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "SubscriptionViewState(endDate=" + this.endDate + ", expired=" + this.expired + ", aboutToExpire=" + this.aboutToExpire + ", visible=" + this.visible + ')';
        }

        public SubscriptionViewState(String str, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(str, "endDate");
            this.endDate = str;
            this.expired = z;
            this.aboutToExpire = z2;
            this.visible = z3;
        }

        public final String getEndDate() {
            return this.endDate;
        }

        public final boolean getExpired() {
            return this.expired;
        }

        public final boolean getAboutToExpire() {
            return this.aboutToExpire;
        }

        public final boolean getVisible() {
            return this.visible;
        }
    }

    @Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel$ViewState;", "", "audioEnabled", "", "subscription", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel$SubscriptionViewState;", "tigerLightIntensity", "", "insertedNfcCardType", "", "(ZLmedia/tiger/tigerbox/ui/settings/SettingsViewModel$SubscriptionViewState;ILjava/lang/String;)V", "getAudioEnabled", "()Z", "getInsertedNfcCardType", "()Ljava/lang/String;", "getSubscription", "()Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel$SubscriptionViewState;", "getTigerLightIntensity", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewModel$ViewState */
    /* compiled from: SettingsViewModel.kt */
    public static final class ViewState {
        private final boolean audioEnabled;
        private final String insertedNfcCardType;
        private final SubscriptionViewState subscription;
        private final int tigerLightIntensity;

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z, SubscriptionViewState subscriptionViewState, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = viewState.audioEnabled;
            }
            if ((i2 & 2) != 0) {
                subscriptionViewState = viewState.subscription;
            }
            if ((i2 & 4) != 0) {
                i = viewState.tigerLightIntensity;
            }
            if ((i2 & 8) != 0) {
                str = viewState.insertedNfcCardType;
            }
            return viewState.copy(z, subscriptionViewState, i, str);
        }

        public final boolean component1() {
            return this.audioEnabled;
        }

        public final SubscriptionViewState component2() {
            return this.subscription;
        }

        public final int component3() {
            return this.tigerLightIntensity;
        }

        public final String component4() {
            return this.insertedNfcCardType;
        }

        public final ViewState copy(boolean z, SubscriptionViewState subscriptionViewState, int i, String str) {
            Intrinsics.checkNotNullParameter(subscriptionViewState, "subscription");
            return new ViewState(z, subscriptionViewState, i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) obj;
            return this.audioEnabled == viewState.audioEnabled && Intrinsics.areEqual((Object) this.subscription, (Object) viewState.subscription) && this.tigerLightIntensity == viewState.tigerLightIntensity && Intrinsics.areEqual((Object) this.insertedNfcCardType, (Object) viewState.insertedNfcCardType);
        }

        public int hashCode() {
            boolean z = this.audioEnabled;
            if (z) {
                z = true;
            }
            int hashCode = (((((z ? 1 : 0) * true) + this.subscription.hashCode()) * 31) + this.tigerLightIntensity) * 31;
            String str = this.insertedNfcCardType;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ViewState(audioEnabled=" + this.audioEnabled + ", subscription=" + this.subscription + ", tigerLightIntensity=" + this.tigerLightIntensity + ", insertedNfcCardType=" + this.insertedNfcCardType + ')';
        }

        public ViewState(boolean z, SubscriptionViewState subscriptionViewState, int i, String str) {
            Intrinsics.checkNotNullParameter(subscriptionViewState, "subscription");
            this.audioEnabled = z;
            this.subscription = subscriptionViewState;
            this.tigerLightIntensity = i;
            this.insertedNfcCardType = str;
        }

        public final boolean getAudioEnabled() {
            return this.audioEnabled;
        }

        public final SubscriptionViewState getSubscription() {
            return this.subscription;
        }

        public final int getTigerLightIntensity() {
            return this.tigerLightIntensity;
        }

        public final String getInsertedNfcCardType() {
            return this.insertedNfcCardType;
        }
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel$WildcardState;", "", "step", "Lmedia/tiger/tigerbox/services/interfaces/WildcardReassignStep;", "(Lmedia/tiger/tigerbox/services/interfaces/WildcardReassignStep;)V", "getStep", "()Lmedia/tiger/tigerbox/services/interfaces/WildcardReassignStep;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewModel$WildcardState */
    /* compiled from: SettingsViewModel.kt */
    public static final class WildcardState {
        private final WildcardReassignStep step;

        public static /* synthetic */ WildcardState copy$default(WildcardState wildcardState, WildcardReassignStep wildcardReassignStep, int i, Object obj) {
            if ((i & 1) != 0) {
                wildcardReassignStep = wildcardState.step;
            }
            return wildcardState.copy(wildcardReassignStep);
        }

        public final WildcardReassignStep component1() {
            return this.step;
        }

        public final WildcardState copy(WildcardReassignStep wildcardReassignStep) {
            Intrinsics.checkNotNullParameter(wildcardReassignStep, "step");
            return new WildcardState(wildcardReassignStep);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WildcardState) && this.step == ((WildcardState) obj).step;
        }

        public int hashCode() {
            return this.step.hashCode();
        }

        public String toString() {
            return "WildcardState(step=" + this.step + ')';
        }

        public WildcardState(WildcardReassignStep wildcardReassignStep) {
            Intrinsics.checkNotNullParameter(wildcardReassignStep, "step");
            this.step = wildcardReassignStep;
        }

        public final WildcardReassignStep getStep() {
            return this.step;
        }
    }
}
