package media.tiger.tigerbox.p016ui.main;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.ActivityMainContentBinding;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductContentFragment;
import media.tiger.tigerbox.p016ui.main.maincontentheader.MainContentHeaderFragment;
import media.tiger.tigerbox.p016ui.main.miniplayer.MiniPlayerFragment;
import media.tiger.tigerbox.p016ui.main.profiles.MiniProfilesFragment;
import media.tiger.tigerbox.p016ui.main.update.UpdateCheck;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import media.tiger.tigerbox.p016ui.settings.SeekBarDialogType;
import media.tiger.tigerbox.services.implementations.timersController.LockedModeReason;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.timersController.LockedModeService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;
import media.tiger.tigerbox.utils.SwipeInterpreter;
import media.tiger.tigerbox.webserver.WebServer;
import org.spongycastle.i18n.MessageBundle;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000Ç\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001\u0015\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u00020ZH\u0016J\b\u0010^\u001a\u00020ZH\u0016J\b\u0010_\u001a\u00020ZH\u0016J\u0010\u0010`\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020bH\u0016J\b\u0010c\u001a\u00020ZH\u0016J\u0010\u0010d\u001a\u00020Z2\u0006\u0010e\u001a\u00020fH\u0016J\b\u0010g\u001a\u00020ZH\u0016J\b\u0010h\u001a\u00020ZH\u0016J\b\u0010i\u001a\u00020ZH\u0016J\b\u0010j\u001a\u00020ZH\u0016J\u000e\u0010k\u001a\u00020Z2\u0006\u0010a\u001a\u00020bJ\b\u0010l\u001a\u00020ZH\u0016J\b\u0010m\u001a\u00020ZH\u0016J\u0006\u0010n\u001a\u00020ZJ\u0012\u0010o\u001a\u00020Z2\b\u0010p\u001a\u0004\u0018\u00010qH\u0015J\b\u0010r\u001a\u00020ZH\u0014J\b\u0010s\u001a\u00020ZH\u0016J\b\u0010t\u001a\u00020ZH\u0014J\b\u0010u\u001a\u00020ZH\u0014J\b\u0010v\u001a\u00020ZH\u0002J\b\u0010w\u001a\u00020ZH\u0016J\b\u0010x\u001a\u00020ZH\u0016J\b\u0010y\u001a\u00020ZH\u0002J\b\u0010z\u001a\u00020ZH\u0016J\b\u0010{\u001a\u00020ZH\u0016J\b\u0010|\u001a\u00020ZH\u0016J\b\u0010}\u001a\u00020ZH\u0016J\b\u0010~\u001a\u00020ZH\u0016J\u0011\u0010\u001a\u00020Z2\u0007\u0010\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u0001\u001a\u00020ZH\u0002R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u000b04¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001e\u00107\u001a\u0002088\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\rR\u000e\u0010?\u001a\u00020@X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010A\u001a\u00020B8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0011\u0010G\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\bH\u0010*R\u001e\u0010I\u001a\u00020J8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\rR\u0014\u0010Q\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\bR\u0010\rR\u001e\u0010S\u001a\u00020T8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X¨\u0006\u0001"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/MainContentActivity;", "Lmedia/tiger/tigerbox/ui/TigerBoxActivity;", "Lmedia/tiger/tigerbox/ui/main/ProgressBarListener;", "Lmedia/tiger/tigerbox/ui/main/MainContentHeaderListener;", "Lmedia/tiger/tigerbox/ui/main/MiniPlayerListener;", "Lmedia/tiger/tigerbox/ui/main/OfflineModeListener;", "Lmedia/tiger/tigerbox/ui/main/SettingsListener;", "()V", "binding", "Lmedia/tiger/tigerbox/databinding/ActivityMainContentBinding;", "canResetDevice", "", "getCanResetDevice", "()Z", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "getConfigurationProperties", "()Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "setConfigurationProperties", "(Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "flagChangedListener", "media/tiger/tigerbox/ui/main/MainContentActivity$flagChangedListener$1", "Lmedia/tiger/tigerbox/ui/main/MainContentActivity$flagChangedListener$1;", "headerFragment", "Lmedia/tiger/tigerbox/ui/main/maincontentheader/MainContentHeaderFragment;", "lockedModeService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/LockedModeService;", "getLockedModeService", "()Lmedia/tiger/tigerbox/services/interfaces/timersController/LockedModeService;", "setLockedModeService", "(Lmedia/tiger/tigerbox/services/interfaces/timersController/LockedModeService;)V", "miniPlayerFragment", "Lmedia/tiger/tigerbox/ui/main/miniplayer/MiniPlayerFragment;", "miniProfilesFragment", "Lmedia/tiger/tigerbox/ui/main/profiles/MiniProfilesFragment;", "navController", "Landroidx/navigation/NavController;", "navHostFragment", "Landroidx/fragment/app/Fragment;", "navigateToMediaPlayer", "Lmedia/tiger/tigerbox/ui/binding/UnTypedBindingClickListener;", "getNavigateToMediaPlayer", "()Lmedia/tiger/tigerbox/ui/binding/UnTypedBindingClickListener;", "navigateToProfiles", "getNavigateToProfiles", "powerManagementService", "Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;", "getPowerManagementService", "()Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;", "setPowerManagementService", "(Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;)V", "settingsClickListener", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "getSettingsClickListener", "()Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "getStorageService", "()Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "setStorageService", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;)V", "supportsNfc", "getSupportsNfc", "swipeInterpreter", "Lmedia/tiger/tigerbox/utils/SwipeInterpreter;", "timersController", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "getTimersController", "()Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "setTimersController", "(Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;)V", "updateAvailableClickListener", "getUpdateAvailableClickListener", "updateCheck", "Lmedia/tiger/tigerbox/ui/main/update/UpdateCheck;", "getUpdateCheck", "()Lmedia/tiger/tigerbox/ui/main/update/UpdateCheck;", "setUpdateCheck", "(Lmedia/tiger/tigerbox/ui/main/update/UpdateCheck;)V", "useProfiles", "getUseProfiles", "useProfilesMainContentSwitch", "getUseProfilesMainContentSwitch", "webServer", "Lmedia/tiger/tigerbox/webserver/WebServer;", "getWebServer", "()Lmedia/tiger/tigerbox/webserver/WebServer;", "setWebServer", "(Lmedia/tiger/tigerbox/webserver/WebServer;)V", "changeHeaderTitle", "", "title", "", "disableCardsMode", "disableLockScreen", "disableOfflineMode", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "enableCardsMode", "enableLockScreen", "reason", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeReason;", "enableOfflineMode", "hideHeaderCloseButton", "hideMultiProductListInCardsMode", "hideProgressBar", "interpretSwipeForSettings", "maximizeMiniPlayer", "minimizeMiniPlayer", "navigateToParentalSettings", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOfflineModeEnabled", "onPause", "onResume", "onSwipeDown", "onTigerButtonPressed", "openVolumeControl", "showCardsModeScreen", "showHardwareSafeguardDialog", "showHeaderCloseButton", "showMultiProductListInCardsMode", "showProgressBar", "showResetDialog", "showSwipeIndicatorDialog", "isWifi", "updateFlagBasedUIElements", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.main.MainContentActivity */
/* compiled from: MainContentActivity.kt */
public final class MainContentActivity extends Hilt_MainContentActivity implements ProgressBarListener, MainContentHeaderListener, MiniPlayerListener, OfflineModeListener, SettingsListener {
    private ActivityMainContentBinding binding;
    @Inject
    public ConfigurationProperties configurationProperties;
    private final MainContentActivity$flagChangedListener$1 flagChangedListener = new MainContentActivity$flagChangedListener$1(this);
    private MainContentHeaderFragment headerFragment;
    @Inject
    public LockedModeService lockedModeService;
    private MiniPlayerFragment miniPlayerFragment;
    private MiniProfilesFragment miniProfilesFragment;
    /* access modifiers changed from: private */
    public NavController navController;
    private Fragment navHostFragment;
    private final UnTypedBindingClickListener navigateToMediaPlayer = new MainContentActivity$navigateToMediaPlayer$1(this);
    private final UnTypedBindingClickListener navigateToProfiles = new MainContentActivity$navigateToProfiles$1(this);
    @Inject
    public PowerManagementService powerManagementService;
    private final BindingClickListener<Boolean> settingsClickListener = new MainContentActivity$settingsClickListener$1(this);
    @Inject
    public StorageService storageService;
    private SwipeInterpreter swipeInterpreter = new SwipeInterpreter(new MainContentActivity$swipeInterpreter$1(this), (Function0) null, 2, (DefaultConstructorMarker) null);
    @Inject
    public TimersControllerService timersController;
    private final UnTypedBindingClickListener updateAvailableClickListener = new MainContentActivity$updateAvailableClickListener$1(this);
    @Inject
    public UpdateCheck updateCheck;
    @Inject
    public WebServer webServer;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.MainContentActivity$WhenMappings */
    /* compiled from: MainContentActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LockedModeReason.values().length];
            iArr[LockedModeReason.WINDOWED_LIMIT.ordinal()] = 1;
            iArr[LockedModeReason.USAGE_LIMIT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean getCanResetDevice() {
        return true;
    }

    public boolean getSupportsNfc() {
        return true;
    }

    public final WebServer getWebServer() {
        WebServer webServer2 = this.webServer;
        if (webServer2 != null) {
            return webServer2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webServer");
        return null;
    }

    public final void setWebServer(WebServer webServer2) {
        Intrinsics.checkNotNullParameter(webServer2, "<set-?>");
        this.webServer = webServer2;
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

    public final UpdateCheck getUpdateCheck() {
        UpdateCheck updateCheck2 = this.updateCheck;
        if (updateCheck2 != null) {
            return updateCheck2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("updateCheck");
        return null;
    }

    public final void setUpdateCheck(UpdateCheck updateCheck2) {
        Intrinsics.checkNotNullParameter(updateCheck2, "<set-?>");
        this.updateCheck = updateCheck2;
    }

    public final TimersControllerService getTimersController() {
        TimersControllerService timersControllerService = this.timersController;
        if (timersControllerService != null) {
            return timersControllerService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("timersController");
        return null;
    }

    public final void setTimersController(TimersControllerService timersControllerService) {
        Intrinsics.checkNotNullParameter(timersControllerService, "<set-?>");
        this.timersController = timersControllerService;
    }

    public final LockedModeService getLockedModeService() {
        LockedModeService lockedModeService2 = this.lockedModeService;
        if (lockedModeService2 != null) {
            return lockedModeService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lockedModeService");
        return null;
    }

    public final void setLockedModeService(LockedModeService lockedModeService2) {
        Intrinsics.checkNotNullParameter(lockedModeService2, "<set-?>");
        this.lockedModeService = lockedModeService2;
    }

    public final PowerManagementService getPowerManagementService() {
        PowerManagementService powerManagementService2 = this.powerManagementService;
        if (powerManagementService2 != null) {
            return powerManagementService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("powerManagementService");
        return null;
    }

    public final void setPowerManagementService(PowerManagementService powerManagementService2) {
        Intrinsics.checkNotNullParameter(powerManagementService2, "<set-?>");
        this.powerManagementService = powerManagementService2;
    }

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

    private final boolean getUseProfiles() {
        return getStorageService().getFlagProfilesEnabled();
    }

    /* access modifiers changed from: private */
    public final boolean getUseProfilesMainContentSwitch() {
        return getStorageService().getFlagProfilesMainContentSwitchEnabled();
    }

    public final BindingClickListener<Boolean> getSettingsClickListener() {
        return this.settingsClickListener;
    }

    public final UnTypedBindingClickListener getUpdateAvailableClickListener() {
        return this.updateAvailableClickListener;
    }

    public final UnTypedBindingClickListener getNavigateToMediaPlayer() {
        return this.navigateToMediaPlayer;
    }

    public final UnTypedBindingClickListener getNavigateToProfiles() {
        return this.navigateToProfiles;
    }

    /* access modifiers changed from: private */
    public final void updateFlagBasedUIElements() {
        Timber.Forest forest = Timber.Forest;
        int i = 0;
        forest.mo50221i("flagDidChanged updateFlagBasedUIElements " + getUseProfiles(), new Object[0]);
        ActivityMainContentBinding activityMainContentBinding = this.binding;
        if (activityMainContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding = null;
        }
        FragmentContainerView fragmentContainerView = activityMainContentBinding.miniProfilesFragment;
        if (!getUseProfiles()) {
            i = 8;
        }
        fragmentContainerView.setVisibility(i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityMainContentBinding inflate = ActivityMainContentBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        ActivityMainContentBinding activityMainContentBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(C2814R.C2817id.f1624mainContentnav_graph_fragment);
        if (findFragmentById != null) {
            this.navHostFragment = findFragmentById;
            Fragment findFragmentById2 = getSupportFragmentManager().findFragmentById(C2814R.C2817id.headerBarFragment);
            if (findFragmentById2 != null) {
                this.headerFragment = (MainContentHeaderFragment) findFragmentById2;
                Fragment findFragmentById3 = getSupportFragmentManager().findFragmentById(C2814R.C2817id.miniPlayerFragment);
                if (findFragmentById3 != null) {
                    this.miniPlayerFragment = (MiniPlayerFragment) findFragmentById3;
                    Fragment findFragmentById4 = getSupportFragmentManager().findFragmentById(C2814R.C2817id.miniProfilesFragment);
                    if (findFragmentById4 != null) {
                        this.miniProfilesFragment = (MiniProfilesFragment) findFragmentById4;
                        getStorageService().registerFlagChangeListener(this.flagChangedListener);
                        if (!getUseProfiles()) {
                            ActivityMainContentBinding activityMainContentBinding2 = this.binding;
                            if (activityMainContentBinding2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                activityMainContentBinding2 = null;
                            }
                            activityMainContentBinding2.miniProfilesFragment.setVisibility(8);
                        }
                        Fragment fragment = this.navHostFragment;
                        if (fragment == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("navHostFragment");
                            fragment = null;
                        }
                        this.navController = FragmentKt.findNavController(fragment);
                        ActivityMainContentBinding activityMainContentBinding3 = this.binding;
                        if (activityMainContentBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityMainContentBinding = activityMainContentBinding3;
                        }
                        activityMainContentBinding.mainContentLockModeButton.setOnClickListener(new MainContentActivity$$ExternalSyntheticLambda0(this));
                        getUpdateCheck().invoke(CoroutineScopeKt.MainScope());
                        getTimersController().initiateTimedLimit();
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m2385onCreate$lambda0(MainContentActivity mainContentActivity, View view) {
        Intrinsics.checkNotNullParameter(mainContentActivity, "this$0");
        mainContentActivity.getPowerManagementService().shutDown();
    }

    public final void interpretSwipeForSettings(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        SwipeInterpreter swipeInterpreter2 = this.swipeInterpreter;
        ActivityMainContentBinding activityMainContentBinding = this.binding;
        if (activityMainContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding = null;
        }
        ConstraintLayout root = activityMainContentBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        swipeInterpreter2.onTouch(root, motionEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        interpretSwipeForSettings(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Timber.Forest.mo50221i("MainContentActivity onResume", new Object[0]);
        getStorageService().registerFlagChangeListener(this.flagChangedListener);
        getTimersController().continueTimedLimitTimer();
        LockedModeReason checkLockedMode = getLockedModeService().checkLockedMode();
        if (checkLockedMode != LockedModeReason.NONE) {
            enableLockScreen(checkLockedMode);
        } else {
            disableLockScreen();
        }
        if (getStorageService().getTigerCardModeEnabled()) {
            enableCardsMode();
        } else {
            disableCardsMode();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        getTimersController().pauseTimedLimitTimer();
        getStorageService().unregisterFlagChangeListener(this.flagChangedListener);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        getWebServer().stopServer();
        MiniPlayerFragment miniPlayerFragment2 = this.miniPlayerFragment;
        if (miniPlayerFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniPlayerFragment");
            miniPlayerFragment2 = null;
        }
        miniPlayerFragment2.stopPlayback();
        getStorageService().unregisterFlagChangeListener(this.flagChangedListener);
        super.onDestroy();
    }

    public void showProgressBar() {
        ActivityMainContentBinding activityMainContentBinding = this.binding;
        if (activityMainContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding = null;
        }
        activityMainContentBinding.mainContentLoadingSpinner.setVisibility(0);
    }

    public void hideProgressBar() {
        ActivityMainContentBinding activityMainContentBinding = this.binding;
        if (activityMainContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding = null;
        }
        activityMainContentBinding.mainContentLoadingSpinner.setVisibility(8);
    }

    public void showHeaderCloseButton() {
        MainContentHeaderFragment mainContentHeaderFragment = this.headerFragment;
        if (mainContentHeaderFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerFragment");
            mainContentHeaderFragment = null;
        }
        mainContentHeaderFragment.showCloseButton();
    }

    public void hideHeaderCloseButton() {
        MainContentHeaderFragment mainContentHeaderFragment = this.headerFragment;
        if (mainContentHeaderFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerFragment");
            mainContentHeaderFragment = null;
        }
        mainContentHeaderFragment.hideCloseButton();
    }

    public void changeHeaderTitle(String str) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        MainContentHeaderFragment mainContentHeaderFragment = this.headerFragment;
        if (mainContentHeaderFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerFragment");
            mainContentHeaderFragment = null;
        }
        mainContentHeaderFragment.showHeaderTitle(str);
    }

    public void maximizeMiniPlayer() {
        MiniPlayerFragment miniPlayerFragment2 = this.miniPlayerFragment;
        if (miniPlayerFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniPlayerFragment");
            miniPlayerFragment2 = null;
        }
        miniPlayerFragment2.maximizeMiniPlayer();
    }

    public void minimizeMiniPlayer() {
        MiniPlayerFragment miniPlayerFragment2 = this.miniPlayerFragment;
        if (miniPlayerFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniPlayerFragment");
            miniPlayerFragment2 = null;
        }
        miniPlayerFragment2.minimizeMiniPlayer();
    }

    public void onOfflineModeEnabled() {
        MiniPlayerFragment miniPlayerFragment2 = this.miniPlayerFragment;
        if (miniPlayerFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniPlayerFragment");
            miniPlayerFragment2 = null;
        }
        miniPlayerFragment2.onOfflineModeEnabled();
    }

    public void enableOfflineMode() {
        Timber.Forest.mo50221i("MainContentActivity enableOfflineMode", new Object[0]);
        ActivityMainContentBinding activityMainContentBinding = this.binding;
        if (activityMainContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding = null;
        }
        activityMainContentBinding.mainContentLoadingSpinner.setVisibility(8);
        NavController navController2 = this.navController;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        OnboardingActivityKt.navigateActionSafe$default(navController2, C2814R.C2817id.action_to_offlineMode, (Bundle) null, 2, (Object) null);
    }

    public void disableOfflineMode() {
        Timber.Forest.mo50221i("MainContentActivity disableOfflineMode", new Object[0]);
        NavController navController2 = this.navController;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        OnboardingActivityKt.navigateActionSafe$default(navController2, C2814R.C2817id.action_to_mainContentProductList, (Bundle) null, 2, (Object) null);
    }

    public void enableLockScreen(LockedModeReason lockedModeReason) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(lockedModeReason, "reason");
        NavController navController2 = this.navController;
        ActivityMainContentBinding activityMainContentBinding = null;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        OnboardingActivityKt.navigateActionSafe$default(navController2, C2814R.C2817id.action_to_mainContentProductList, (Bundle) null, 2, (Object) null);
        MiniPlayerFragment miniPlayerFragment2 = this.miniPlayerFragment;
        if (miniPlayerFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniPlayerFragment");
            miniPlayerFragment2 = null;
        }
        miniPlayerFragment2.stopPlayback();
        ActivityMainContentBinding activityMainContentBinding2 = this.binding;
        if (activityMainContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding2 = null;
        }
        ImageView imageView = activityMainContentBinding2.mainContentLockModeIcon;
        int i = WhenMappings.$EnumSwitchMapping$0[lockedModeReason.ordinal()];
        imageView.setImageResource(i != 1 ? i != 2 ? 0 : C2814R.C2816drawable.tigerbox_locked_mode_hourglass_icon : C2814R.C2816drawable.tigerbox_locked_mode_time_schedule_icon);
        ActivityMainContentBinding activityMainContentBinding3 = this.binding;
        if (activityMainContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding3 = null;
        }
        ImageView imageView2 = activityMainContentBinding3.mainContentLockModeIcon;
        Context baseContext = getBaseContext();
        int i2 = WhenMappings.$EnumSwitchMapping$0[lockedModeReason.ordinal()];
        imageView2.setColorFilter(ContextCompat.getColor(baseContext, i2 != 1 ? i2 != 2 ? 0 : C2814R.C2815color.time_limit_lock_mode_icon : C2814R.C2815color.time_window_lock_mode_icon));
        ActivityMainContentBinding activityMainContentBinding4 = this.binding;
        if (activityMainContentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding4 = null;
        }
        activityMainContentBinding4.mainContentLockModeIcon.setVisibility(0);
        ActivityMainContentBinding activityMainContentBinding5 = this.binding;
        if (activityMainContentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding5 = null;
        }
        ConstraintLayout constraintLayout = activityMainContentBinding5.mainContentLockModeContainer;
        Context context = this;
        int i3 = WhenMappings.$EnumSwitchMapping$0[lockedModeReason.ordinal()];
        constraintLayout.setBackground(new ColorDrawable(ContextCompat.getColor(context, i3 != 1 ? i3 != 2 ? C2814R.C2815color.main_theme_color : C2814R.C2815color.time_limit_lock_mode_background : C2814R.C2815color.time_window_lock_mode_background)));
        ActivityMainContentBinding activityMainContentBinding6 = this.binding;
        if (activityMainContentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding6 = null;
        }
        activityMainContentBinding6.mainContentLockModeContainer.setVisibility(0);
        ActivityMainContentBinding activityMainContentBinding7 = this.binding;
        if (activityMainContentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding7 = null;
        }
        activityMainContentBinding7.mainContentLoadingSpinner.setVisibility(8);
        ActivityMainContentBinding activityMainContentBinding8 = this.binding;
        if (activityMainContentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainContentBinding = activityMainContentBinding8;
        }
        TextView textView = activityMainContentBinding.mainContentLockModeText;
        int i4 = WhenMappings.$EnumSwitchMapping$0[lockedModeReason.ordinal()];
        if (i4 == 1) {
            charSequence = getString(C2814R.string.locked_mode_window_limit_text);
        } else if (i4 == 2) {
            charSequence = getString(C2814R.string.locked_mode_usage_limit_text);
        }
        textView.setText(charSequence);
    }

    public void disableLockScreen() {
        ActivityMainContentBinding activityMainContentBinding = this.binding;
        if (activityMainContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding = null;
        }
        activityMainContentBinding.mainContentLockModeContainer.setVisibility(8);
    }

    public void enableCardsMode() {
        MiniPlayerFragment miniPlayerFragment2 = this.miniPlayerFragment;
        Fragment fragment = null;
        if (miniPlayerFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniPlayerFragment");
            miniPlayerFragment2 = null;
        }
        miniPlayerFragment2.stopPlayingNonCardsProducts();
        Fragment fragment2 = this.navHostFragment;
        if (fragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navHostFragment");
        } else {
            fragment = fragment2;
        }
        Fragment primaryNavigationFragment = fragment.getChildFragmentManager().getPrimaryNavigationFragment();
        if (primaryNavigationFragment == null) {
            showCardsModeScreen();
        } else if (!((ProductContentFragment) primaryNavigationFragment).supportsCardsMode()) {
            showCardsModeScreen();
        }
    }

    private final void showCardsModeScreen() {
        ActivityMainContentBinding activityMainContentBinding = this.binding;
        ActivityMainContentBinding activityMainContentBinding2 = null;
        if (activityMainContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding = null;
        }
        activityMainContentBinding.mainContentLoadingSpinner.setVisibility(8);
        ActivityMainContentBinding activityMainContentBinding3 = this.binding;
        if (activityMainContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding3 = null;
        }
        activityMainContentBinding3.mainContentNavGraphFragment.setVisibility(8);
        ActivityMainContentBinding activityMainContentBinding4 = this.binding;
        if (activityMainContentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainContentBinding2 = activityMainContentBinding4;
        }
        activityMainContentBinding2.mainContentCardModus.setVisibility(0);
    }

    public void disableCardsMode() {
        ActivityMainContentBinding activityMainContentBinding = this.binding;
        ActivityMainContentBinding activityMainContentBinding2 = null;
        if (activityMainContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding = null;
        }
        activityMainContentBinding.mainContentNavGraphFragment.setVisibility(0);
        ActivityMainContentBinding activityMainContentBinding3 = this.binding;
        if (activityMainContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainContentBinding2 = activityMainContentBinding3;
        }
        activityMainContentBinding2.mainContentCardModus.setVisibility(8);
    }

    public void showMultiProductListInCardsMode() {
        ActivityMainContentBinding activityMainContentBinding = this.binding;
        ActivityMainContentBinding activityMainContentBinding2 = null;
        if (activityMainContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainContentBinding = null;
        }
        activityMainContentBinding.mainContentNavGraphFragment.setVisibility(0);
        ActivityMainContentBinding activityMainContentBinding3 = this.binding;
        if (activityMainContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainContentBinding2 = activityMainContentBinding3;
        }
        activityMainContentBinding2.mainContentCardModus.setVisibility(8);
    }

    public void hideMultiProductListInCardsMode() {
        if (getStorageService().getTigerCardModeEnabled()) {
            ActivityMainContentBinding activityMainContentBinding = this.binding;
            ActivityMainContentBinding activityMainContentBinding2 = null;
            if (activityMainContentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMainContentBinding = null;
            }
            activityMainContentBinding.mainContentNavGraphFragment.setVisibility(8);
            ActivityMainContentBinding activityMainContentBinding3 = this.binding;
            if (activityMainContentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityMainContentBinding2 = activityMainContentBinding3;
            }
            activityMainContentBinding2.mainContentCardModus.setVisibility(0);
        }
    }

    public void openVolumeControl() {
        NavController navController2 = this.navController;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        navController2.navigate((int) C2814R.C2817id.fullScreenSeekBar, BundleKt.bundleOf(TuplesKt.m475to("seekBarType", SeekBarDialogType.VOLUME)));
    }

    /* access modifiers changed from: private */
    public final void onSwipeDown() {
        navigateToParentalSettings();
    }

    public final void navigateToParentalSettings() {
        if (getStorageService().getParentalGate()) {
            NavController navController2 = this.navController;
            if (navController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController2 = null;
            }
            OnboardingActivityKt.navigateActionSafe$default(navController2, C2814R.C2817id.action_to_parentalGate, (Bundle) null, 2, (Object) null);
            return;
        }
        NavController navController3 = this.navController;
        if (navController3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController3 = null;
        }
        OnboardingActivityKt.navigateActionSafe$default(navController3, C2814R.C2817id.action_to_parentalSettings, (Bundle) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showSwipeIndicatorDialog(boolean z) {
        NavController navController2 = this.navController;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        Pair[] pairArr = new Pair[1];
        pairArr[0] = TuplesKt.m475to("dialogType", z ? InfoDialogType.SWIPE_INDICATOR_WIFI : InfoDialogType.SWIPE_INDICATOR_GEAR);
        navController2.navigate((int) C2814R.C2817id.infoDialogFragment, BundleKt.bundleOf(pairArr));
    }

    public void showHardwareSafeguardDialog() {
        NavController navController2 = this.navController;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        navController2.navigate((int) C2814R.C2817id.infoDialogFragment, BundleKt.bundleOf(TuplesKt.m475to("dialogType", InfoDialogType.ERROR_SAFEGUARD_HARDWARE_900)));
    }

    public void onTigerButtonPressed() {
        NavController navController2 = this.navController;
        NavController navController3 = null;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        if (navController2.getBackQueue().size() > 2) {
            NavController navController4 = this.navController;
            if (navController4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController4 = null;
            }
            NavDestination destination = navController4.getBackQueue().last().getDestination();
            NavController navController5 = this.navController;
            if (navController5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController5 = null;
            }
            if (!Intrinsics.areEqual((Object) destination, (Object) navController5.findDestination((int) C2814R.C2817id.offlineModeFragment))) {
                NavController navController6 = this.navController;
                if (navController6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                } else {
                    navController3 = navController6;
                }
                navController3.popBackStack();
                return;
            }
        }
        super.onTigerButtonPressed();
    }

    public void showResetDialog() {
        NavController navController2 = this.navController;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        navController2.navigate((int) C2814R.C2817id.resetDialogFragment);
    }
}
