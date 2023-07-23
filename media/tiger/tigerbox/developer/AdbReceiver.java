package media.tiger.tigerbox.developer;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.Gson;
import dagger.hilt.android.AndroidEntryPoint;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.TigerBoxApplication;
import media.tiger.tigerbox.TigerBoxApplicationKt;
import media.tiger.tigerbox.data.repository.AccessTokenRepository;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.Constants;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.domain.TigerCard;
import media.tiger.tigerbox.p016ui.main.MainContentActivity;
import media.tiger.tigerbox.services.implementations.timersController.TimeLimit;
import media.tiger.tigerbox.services.implementations.timersController.WindowedLimits;
import media.tiger.tigerbox.services.interfaces.AcquisitionReason;
import media.tiger.tigerbox.services.interfaces.NfcService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionDelegate;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.UpdateCheckTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;
import okhttp3.HttpUrl;
import timber.log.Timber;

@AndroidEntryPoint
@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\u0005¢\u0006\u0002\u0010\u0002J\"\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@H\u0002J\u001c\u0010A\u001a\u00020:2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010F\u001a\u00020:2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u001a\u0010G\u001a\u00020:2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010H\u001a\u00020IH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0002048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006K"}, mo33737d2 = {"Lmedia/tiger/tigerbox/developer/AdbReceiver;", "Lmedia/tiger/tigerbox/infrastructure/di/InjectableBroadcastReceiver;", "()V", "accessTokenRepository", "Lmedia/tiger/tigerbox/data/repository/AccessTokenRepository;", "getAccessTokenRepository", "()Lmedia/tiger/tigerbox/data/repository/AccessTokenRepository;", "setAccessTokenRepository", "(Lmedia/tiger/tigerbox/data/repository/AccessTokenRepository;)V", "accountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "getAccountRepository", "()Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "setAccountRepository", "(Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;)V", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "getConfigurationProperties", "()Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "setConfigurationProperties", "(Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "nfcService", "Lmedia/tiger/tigerbox/services/interfaces/NfcService;", "getNfcService", "()Lmedia/tiger/tigerbox/services/interfaces/NfcService;", "setNfcService", "(Lmedia/tiger/tigerbox/services/interfaces/NfcService;)V", "productAcquisitionService", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;", "getProductAcquisitionService", "()Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;", "setProductAcquisitionService", "(Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;)V", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "getStorageService", "()Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "setStorageService", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;)V", "timeLimitController", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "getTimeLimitController", "()Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "setTimeLimitController", "(Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;)V", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "getTimeService", "()Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "setTimeService", "(Lmedia/tiger/tigerbox/services/interfaces/TimeService;)V", "updateCheckTimerService", "Lmedia/tiger/tigerbox/services/interfaces/UpdateCheckTimerService;", "getUpdateCheckTimerService", "()Lmedia/tiger/tigerbox/services/interfaces/UpdateCheckTimerService;", "setUpdateCheckTimerService", "(Lmedia/tiger/tigerbox/services/interfaces/UpdateCheckTimerService;)V", "downloadStep", "", "step", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$StepType;", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "productId", "", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "openSettings", "showOutput", "text", "", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AdbReceiver.kt */
public final class AdbReceiver extends Hilt_AdbReceiver {
    private static final String ACTION_CONFIG_CLEAR = "tigerbox.action.config.clear";
    private static final String ACTION_CONFIG_READ = "tigerbox.action.config.read";
    private static final String ACTION_CONFIG_SET = "tigerbox.action.config.set";
    private static final String ACTION_DOWNLOAD = "tigerbox.action.download";
    private static final String ACTION_OFFLINE_START = "tigerbox.action.offline";
    private static final String ACTION_RESET_ACCESS_TOKEN = "tigerbox.action.reset.access.token";
    private static final String ACTION_RESET_ACCOUNT = "tigerbox.action.reset.account";
    private static final String ACTION_SETTINGS = "tigerbox.action.settings";
    private static final String ACTION_TAP_CARD = "tigerbox.action.card";
    private static final String ACTION_TIME_LIMIT = "tigerbox.action.time.limit";
    private static final String ACTION_TOAST = "tigerbox.action.toast";
    private static final String ACTION_WINDOWED_LIMIT = "tigerbox.action.windowed.limit";
    private static final String BUNDLE_CARD_DATA = "tigerbox.card.data";
    private static final String BUNDLE_CARD_ID = "tigerbox.card.id";
    private static final String BUNDLE_DATA = "tigerbox.data";
    private static final String BUNDLE_LIMIT_LIMIT = "tigerbox.limit.limit";
    private static final String BUNDLE_LIMIT_WINDOWED_LIMITS = "tigerbox.limit.windowed.limits";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_CARD_DATA = "0028-g9b9Cy81bl";
    private static final String DEFAULT_CARD_ID = "04F4F682D67280";
    private static final String FIRMWARE_UPDATE_CHECKER_TIME_KEY = "firmware.update.checker.time";
    /* access modifiers changed from: private */
    public static WeakReference<MainContentActivity> currentActivity = new WeakReference<>((Object) null);
    @Inject
    public AccessTokenRepository accessTokenRepository;
    @Inject
    public TigerBoxAccountRepository accountRepository;
    @Inject
    public ConfigurationProperties configurationProperties;
    @Inject
    public NfcService nfcService;
    @Inject
    public ProductAcquisitionService productAcquisitionService;
    @Inject
    public StorageService storageService;
    @Inject
    public TimersControllerService timeLimitController;
    @Inject
    public TimeService timeService;
    @Inject
    public UpdateCheckTimerService updateCheckTimerService;

    public final ConfigurationProperties getConfigurationProperties() {
        ConfigurationProperties configurationProperties2 = this.configurationProperties;
        if (configurationProperties2 != null) {
            return configurationProperties2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationProperties");
        return null;
    }

    public final void setConfigurationProperties(ConfigurationProperties configurationProperties2) {
        Intrinsics.checkNotNullParameter(configurationProperties2, "<set-?>");
        this.configurationProperties = configurationProperties2;
    }

    public final ProductAcquisitionService getProductAcquisitionService() {
        ProductAcquisitionService productAcquisitionService2 = this.productAcquisitionService;
        if (productAcquisitionService2 != null) {
            return productAcquisitionService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("productAcquisitionService");
        return null;
    }

    public final void setProductAcquisitionService(ProductAcquisitionService productAcquisitionService2) {
        Intrinsics.checkNotNullParameter(productAcquisitionService2, "<set-?>");
        this.productAcquisitionService = productAcquisitionService2;
    }

    public final UpdateCheckTimerService getUpdateCheckTimerService() {
        UpdateCheckTimerService updateCheckTimerService2 = this.updateCheckTimerService;
        if (updateCheckTimerService2 != null) {
            return updateCheckTimerService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("updateCheckTimerService");
        return null;
    }

    public final void setUpdateCheckTimerService(UpdateCheckTimerService updateCheckTimerService2) {
        Intrinsics.checkNotNullParameter(updateCheckTimerService2, "<set-?>");
        this.updateCheckTimerService = updateCheckTimerService2;
    }

    public final StorageService getStorageService() {
        StorageService storageService2 = this.storageService;
        if (storageService2 != null) {
            return storageService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storageService");
        return null;
    }

    public final void setStorageService(StorageService storageService2) {
        Intrinsics.checkNotNullParameter(storageService2, "<set-?>");
        this.storageService = storageService2;
    }

    public final NfcService getNfcService() {
        NfcService nfcService2 = this.nfcService;
        if (nfcService2 != null) {
            return nfcService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nfcService");
        return null;
    }

    public final void setNfcService(NfcService nfcService2) {
        Intrinsics.checkNotNullParameter(nfcService2, "<set-?>");
        this.nfcService = nfcService2;
    }

    public final TimersControllerService getTimeLimitController() {
        TimersControllerService timersControllerService = this.timeLimitController;
        if (timersControllerService != null) {
            return timersControllerService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("timeLimitController");
        return null;
    }

    public final void setTimeLimitController(TimersControllerService timersControllerService) {
        Intrinsics.checkNotNullParameter(timersControllerService, "<set-?>");
        this.timeLimitController = timersControllerService;
    }

    public final TigerBoxAccountRepository getAccountRepository() {
        TigerBoxAccountRepository tigerBoxAccountRepository = this.accountRepository;
        if (tigerBoxAccountRepository != null) {
            return tigerBoxAccountRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("accountRepository");
        return null;
    }

    public final void setAccountRepository(TigerBoxAccountRepository tigerBoxAccountRepository) {
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository, "<set-?>");
        this.accountRepository = tigerBoxAccountRepository;
    }

    public final AccessTokenRepository getAccessTokenRepository() {
        AccessTokenRepository accessTokenRepository2 = this.accessTokenRepository;
        if (accessTokenRepository2 != null) {
            return accessTokenRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("accessTokenRepository");
        return null;
    }

    public final void setAccessTokenRepository(AccessTokenRepository accessTokenRepository2) {
        Intrinsics.checkNotNullParameter(accessTokenRepository2, "<set-?>");
        this.accessTokenRepository = accessTokenRepository2;
    }

    public final TimeService getTimeService() {
        TimeService timeService2 = this.timeService;
        if (timeService2 != null) {
            return timeService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("timeService");
        return null;
    }

    public final void setTimeService(TimeService timeService2) {
        Intrinsics.checkNotNullParameter(timeService2, "<set-?>");
        this.timeService = timeService2;
    }

    public void onReceive(Context context, Intent intent) {
        List list;
        int i;
        String string;
        int[] intArray;
        Set<String> keySet;
        Set<String> keySet2;
        super.onReceive(context, intent);
        Timber.Forest.mo50221i("AdbReceiver intent: " + intent, new Object[0]);
        if (intent != null) {
            Bundle extras = intent.getExtras();
            Timber.Forest.mo50221i("AdbReceiver extras: " + extras + " action: " + intent.getAction(), new Object[0]);
            String action = intent.getAction();
            if (action == null) {
                action = "";
            }
            Intrinsics.checkNotNullExpressionValue(action, "it.action ?: \"\"");
            String str = null;
            switch (action.hashCode()) {
                case -1928454778:
                    if (action.equals(ACTION_TAP_CARD)) {
                        String str2 = DEFAULT_CARD_ID;
                        String string2 = extras != null ? extras.getString(BUNDLE_CARD_ID, str2) : null;
                        if (string2 != null) {
                            Intrinsics.checkNotNullExpressionValue(string2, "extras?.getString(BUNDLE…RD_ID) ?: DEFAULT_CARD_ID");
                            str2 = string2;
                        }
                        String str3 = DEFAULT_CARD_DATA;
                        if (extras != null) {
                            str = extras.getString(BUNDLE_CARD_DATA, str3);
                        }
                        if (str != null) {
                            Intrinsics.checkNotNullExpressionValue(str, "extras?.getString(BUNDLE…ATA) ?: DEFAULT_CARD_DATA");
                            str3 = str;
                        }
                        getNfcService().loadCard(new TigerCard(str2, str3, "https://tgrmd.de/a/" + str3));
                        return;
                    }
                    break;
                case -1478378792:
                    if (action.equals(ACTION_RESET_ACCOUNT)) {
                        showOutput(context, "RESET ACCOUNT");
                        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AdbReceiver$onReceive$1$4(this, (Continuation<? super AdbReceiver$onReceive$1$4>) null), 3, (Object) null);
                        return;
                    }
                    break;
                case -1350960873:
                    if (action.equals(ACTION_CONFIG_CLEAR)) {
                        showOutput(context, "  --> CLEARING VOLATILE PROPERTIES");
                        getConfigurationProperties().clearVolatileProperties();
                        getStorageService().notifyFlagChanged();
                        return;
                    }
                    break;
                case -1204255598:
                    if (action.equals(ACTION_WINDOWED_LIMIT)) {
                        String str4 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                        if (extras != null) {
                            str = extras.getString(BUNDLE_LIMIT_WINDOWED_LIMITS, str4);
                        }
                        if (str != null) {
                            Intrinsics.checkNotNullExpressionValue(str, "extras?.getString(BUNDLE…WED_LIMITS, \"[]\") ?: \"[]\"");
                            str4 = str;
                        }
                        try {
                            Object fromJson = new Gson().fromJson(str4, WindowedLimits.WindowedLimit[].class);
                            Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(limitsSt…ndowedLimit>::class.java)");
                            list = ArraysKt.toList((T[]) (Object[]) fromJson);
                        } catch (Exception e) {
                            Timber.Forest.tag("SharedPreferencesStorageService").mo50218e(e);
                            list = CollectionsKt.emptyList();
                        }
                        getStorageService().setWindowedLimit(new WindowedLimits(list));
                        getTimeLimitController().initiateWindowedLimit();
                        return;
                    }
                    break;
                case -269663452:
                    if (action.equals(ACTION_RESET_ACCESS_TOKEN)) {
                        showOutput(context, "RESET ACCESS TOKEN");
                        Job unused2 = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AdbReceiver$onReceive$1$5(this, (Continuation<? super AdbReceiver$onReceive$1$5>) null), 3, (Object) null);
                        return;
                    }
                    break;
                case 363545201:
                    if (action.equals(ACTION_TOAST)) {
                        String str5 = "No data";
                        if (extras != null) {
                            str = extras.getString(BUNDLE_DATA, str5);
                        }
                        if (str != null) {
                            Intrinsics.checkNotNullExpressionValue(str, "extras?.getString(BUNDLE…, \"No data\") ?: \"No data\"");
                            str5 = str;
                        }
                        showOutput(context, str5);
                        return;
                    }
                    break;
                case 753790800:
                    if (action.equals(ACTION_TIME_LIMIT)) {
                        String currentTime = getTimeService().getCurrentTime();
                        if (currentTime == null) {
                            currentTime = Constants.DEFAULT_DATE;
                        }
                        if (extras == null || (string = extras.getString(BUNDLE_LIMIT_LIMIT, "")) == null) {
                            i = -1;
                        } else {
                            Intrinsics.checkNotNullExpressionValue(string, "getString(BUNDLE_LIMIT_LIMIT, \"\")");
                            i = Integer.parseInt(string);
                        }
                        getStorageService().setTimeLimit(getStorageService().getTimeLimit().copy(currentTime, i, i));
                        TimersControllerService.DefaultImpls.startTimedLimitTimer$default(getTimeLimitController(), new TimeLimit(currentTime, i, i), false, 2, (Object) null);
                        return;
                    }
                    break;
                case 1078775725:
                    if (action.equals(ACTION_OFFLINE_START)) {
                        String str6 = SessionDescription.SUPPORTED_SDP_VERSION;
                        if (extras != null) {
                            str = extras.getString(BUNDLE_DATA, str6);
                        }
                        if (str != null) {
                            Intrinsics.checkNotNullExpressionValue(str, "extras?.getString(BUNDLE_DATA, \"0\") ?: \"0\"");
                            str6 = str;
                        }
                        int parseInt = Integer.parseInt(str6);
                        if (parseInt <= 0) {
                            showOutput(context, "  --> CANNOT SET DAYS TO [" + parseInt + ']');
                            return;
                        }
                        showOutput(context, "  --> SETTING OFFLINE DAYS [" + parseInt + ']');
                        getStorageService().replaceOfflineStartTimeAndDate(parseInt);
                        return;
                    }
                    break;
                case 1272463358:
                    if (action.equals(ACTION_DOWNLOAD)) {
                        if (extras != null && (intArray = extras.getIntArray(BUNDLE_DATA)) != null) {
                            Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(BUNDLE_DATA)");
                            for (int i2 : intArray) {
                                showOutput(context, "  --> DOWNLOADING PRODUCT ID [" + i2 + ']');
                                getProductAcquisitionService().downloadProduct(i2, AcquisitionReason.MANUAL, (ProductAcquisitionDelegate) null, new AdbReceiver$onReceive$1$3$1(this, i2));
                            }
                            return;
                        }
                        return;
                    }
                    break;
                case 1279275929:
                    if (action.equals(ACTION_SETTINGS)) {
                        openSettings(context);
                        return;
                    }
                    break;
                case 1757975948:
                    if (action.equals(ACTION_CONFIG_READ)) {
                        if (extras != null && (keySet = extras.keySet()) != null) {
                            Intrinsics.checkNotNullExpressionValue(keySet, "keySet()");
                            for (String str7 : keySet) {
                                ConfigurationProperties configurationProperties2 = getConfigurationProperties();
                                Intrinsics.checkNotNullExpressionValue(str7, "key");
                                showOutput(context, '[' + str7 + "]: [" + configurationProperties2.getProperty(str7, "~~ NO VALUE ~~") + ']');
                            }
                            return;
                        }
                        return;
                    }
                    break;
                case 1857825196:
                    if (action.equals(ACTION_CONFIG_SET)) {
                        if (!(extras == null || (keySet2 = extras.keySet()) == null)) {
                            Intrinsics.checkNotNullExpressionValue(keySet2, "keySet()");
                            for (String str8 : keySet2) {
                                String string3 = extras.getString(str8);
                                CharSequence charSequence = string3;
                                if (!(charSequence == null || charSequence.length() == 0)) {
                                    showOutput(context, "  --> SET [" + str8 + "]: [" + string3 + ']');
                                    ConfigurationProperties configurationProperties3 = getConfigurationProperties();
                                    Intrinsics.checkNotNullExpressionValue(str8, "key");
                                    configurationProperties3.setVolatileProperty(str8, string3);
                                    if (Intrinsics.areEqual((Object) str8, (Object) FIRMWARE_UPDATE_CHECKER_TIME_KEY)) {
                                        getUpdateCheckTimerService().resetAlarm();
                                    }
                                } else {
                                    showOutput(context, "  --> DELETE [" + str8 + ']');
                                    ConfigurationProperties configurationProperties4 = getConfigurationProperties();
                                    Intrinsics.checkNotNullExpressionValue(str8, "key");
                                    configurationProperties4.removeVolatileProperty(str8);
                                }
                            }
                        }
                        getStorageService().notifyFlagChanged();
                        return;
                    }
                    break;
            }
            showOutput(context, "Unknown action: [" + action + ']');
        }
    }

    private final void showOutput(Context context, String str) {
        if (context != null) {
            TigerBoxApplicationKt.showToast$default(context, str, 0, 2, (Object) null);
        }
        Timber.Forest.tag("AdbReceiver").mo50221i(str, new Object[0]);
    }

    private final void openSettings(Context context) {
        try {
            MainContentActivity mainContentActivity = (MainContentActivity) currentActivity.get();
            if (mainContentActivity != null) {
                mainContentActivity.navigateToParentalSettings();
            }
        } catch (Exception unused) {
            showOutput(context, "Unable to open settings");
        }
    }

    /* access modifiers changed from: private */
    public final void downloadStep(ProductAcquisitionService.StepType stepType, ProductAcquisitionService.ErrorCode errorCode, int i) {
        if (errorCode != null) {
            showOutput((Context) null, "  --> DOWNLOAD FAILED: [" + i + "] [" + errorCode.name() + ']');
        } else if (stepType == ProductAcquisitionService.StepType.ACQUISITION_STARTED) {
            showOutput((Context) null, "  --> DOWNLOAD STARTED: [" + i + ']');
        } else if (stepType == ProductAcquisitionService.StepType.ACQUISITION_FINISHED) {
            showOutput((Context) null, "  --> DOWNLOAD COMPLETE: [" + i + ']');
        }
    }

    @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/developer/AdbReceiver$Companion;", "", "()V", "ACTION_CONFIG_CLEAR", "", "ACTION_CONFIG_READ", "ACTION_CONFIG_SET", "ACTION_DOWNLOAD", "ACTION_OFFLINE_START", "ACTION_RESET_ACCESS_TOKEN", "ACTION_RESET_ACCOUNT", "ACTION_SETTINGS", "ACTION_TAP_CARD", "ACTION_TIME_LIMIT", "ACTION_TOAST", "ACTION_WINDOWED_LIMIT", "BUNDLE_CARD_DATA", "BUNDLE_CARD_ID", "BUNDLE_DATA", "BUNDLE_LIMIT_LIMIT", "BUNDLE_LIMIT_WINDOWED_LIMITS", "DEFAULT_CARD_DATA", "DEFAULT_CARD_ID", "FIRMWARE_UPDATE_CHECKER_TIME_KEY", "currentActivity", "Ljava/lang/ref/WeakReference;", "Lmedia/tiger/tigerbox/ui/main/MainContentActivity;", "registerInstance", "", "application", "Lmedia/tiger/tigerbox/TigerBoxApplication;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AdbReceiver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void registerInstance(TigerBoxApplication tigerBoxApplication) {
            Intrinsics.checkNotNullParameter(tigerBoxApplication, MimeTypes.BASE_TYPE_APPLICATION);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(AdbReceiver.ACTION_TOAST);
            intentFilter.addAction(AdbReceiver.ACTION_CONFIG_READ);
            intentFilter.addAction(AdbReceiver.ACTION_CONFIG_SET);
            intentFilter.addAction(AdbReceiver.ACTION_CONFIG_CLEAR);
            intentFilter.addAction(AdbReceiver.ACTION_DOWNLOAD);
            intentFilter.addAction(AdbReceiver.ACTION_OFFLINE_START);
            intentFilter.addAction(AdbReceiver.ACTION_SETTINGS);
            intentFilter.addAction(AdbReceiver.ACTION_RESET_ACCOUNT);
            intentFilter.addAction(AdbReceiver.ACTION_RESET_ACCESS_TOKEN);
            intentFilter.addAction(AdbReceiver.ACTION_TAP_CARD);
            intentFilter.addAction(AdbReceiver.ACTION_TIME_LIMIT);
            intentFilter.addAction(AdbReceiver.ACTION_WINDOWED_LIMIT);
            Unit unit = Unit.INSTANCE;
            tigerBoxApplication.getBaseContext().registerReceiver(new AdbReceiver(), intentFilter);
            tigerBoxApplication.registerActivityLifecycleCallbacks(new AdbReceiver$Companion$registerInstance$2());
        }
    }
}
