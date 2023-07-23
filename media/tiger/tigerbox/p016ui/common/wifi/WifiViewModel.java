package media.tiger.tigerbox.p016ui.common.wifi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.domain.ConnectionState;
import media.tiger.tigerbox.model.domain.SecurityMode;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.model.domain.WifiItemDomainKt;
import media.tiger.tigerbox.model.domain.WifiStrength;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.common.TimedRefreshHandler;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0019\b\u0017\u0018\u00002\u00020\u0001:\u0002QRB?\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011J\b\u0010<\u001a\u00020=H\u0002J\u0006\u0010>\u001a\u00020=J\u000e\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u000207J\b\u0010A\u001a\u00020=H\u0002J\u0010\u0010B\u001a\u00020=2\b\u0010C\u001a\u0004\u0018\u00010\"J\u0006\u0010D\u001a\u00020=J\u0006\u0010E\u001a\u00020=J\u0006\u0010F\u001a\u00020=J\b\u0010G\u001a\u00020=H\u0002J\u0006\u0010H\u001a\u00020=J\b\u0010I\u001a\u00020=H\u0002J\u0006\u0010J\u001a\u00020=J\u0010\u0010K\u001a\u00020=2\u0006\u0010+\u001a\u00020\u0014H\u0004J\u0006\u0010L\u001a\u00020=J\u0010\u0010M\u001a\u00020=2\u0006\u0010N\u001a\u00020OH\u0002J\b\u0010P\u001a\u00020=H\u0016R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(XD¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u001f\u00100\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010(0(0\u0016¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020(05X\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00170,¢\u0006\b\n\u0000\u001a\u0004\b;\u0010.R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel;", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "infoSoundService", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "delayPeriodMillis", "", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "(Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lkotlinx/coroutines/CoroutineScope;JLmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "(Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "_navigationEvent", "Lmedia/tiger/tigerbox/infrastructure/functional/SingleLiveEvent;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent;", "_viewState", "Landroidx/lifecycle/MutableLiveData;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$ViewState;", "connectionCallback", "media/tiger/tigerbox/ui/common/wifi/WifiViewModel$connectionCallback$1", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$connectionCallback$1;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "currentJob", "Lkotlinx/coroutines/Job;", "currentPassword", "", "getDelayPeriodMillis", "()J", "setDelayPeriodMillis", "(J)V", "enforceInternetConnectionCheck", "", "getEnforceInternetConnectionCheck", "()Z", "navigationEvent", "Landroidx/lifecycle/LiveData;", "getNavigationEvent", "()Landroidx/lifecycle/LiveData;", "savedOfflineMode", "scanInProgress", "kotlin.jvm.PlatformType", "getScanInProgress", "()Landroidx/lifecycle/MutableLiveData;", "scanProgressObserver", "Landroidx/lifecycle/Observer;", "selectedNetwork", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "timedRefreshHandler", "Lmedia/tiger/tigerbox/ui/common/TimedRefreshHandler;", "viewState", "getViewState", "attemptConnection", "", "exitView", "networkSelected", "wifiItem", "notifyWifiConnectionFailed", "passwordCaptured", "password", "refreshWifiList", "retryConnection", "retryPassword", "startDisplayingWifiNetworks", "startScanning", "stopLoadingDueToFailure", "stopScanning", "updateNavigationState", "viewPrepared", "wifiConnectionFailureHandler", "failReason", "Lmedia/tiger/tigerbox/services/interfaces/WifiService$FailReason;", "wifiConnectionSuccessHandler", "NavigationEvent", "ViewState", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel */
/* compiled from: WifiViewModel.kt */
public class WifiViewModel extends DialogViewModel {
    private final SingleLiveEvent<NavigationEvent> _navigationEvent;
    /* access modifiers changed from: private */
    public final MutableLiveData<ViewState> _viewState;
    private final WifiViewModel$connectionCallback$1 connectionCallback;
    private CoroutineScope coroutineScope;
    private Job currentJob;
    private String currentPassword;
    private long delayPeriodMillis;
    private final boolean enforceInternetConnectionCheck;
    private final InfoSoundService infoSoundService;
    private final LiveData<NavigationEvent> navigationEvent;
    private boolean savedOfflineMode;
    private final MutableLiveData<Boolean> scanInProgress;
    private final Observer<Boolean> scanProgressObserver;
    private WifiItem selectedNetwork;
    private final StorageService storageService;
    /* access modifiers changed from: private */
    public final TimedRefreshHandler timedRefreshHandler;
    private final LiveData<ViewState> viewState;
    /* access modifiers changed from: private */
    public final WifiService wifiService;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$WhenMappings */
    /* compiled from: WifiViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WifiService.FailReason.values().length];
            iArr[WifiService.FailReason.NO_INTERNET.ordinal()] = 1;
            iArr[WifiService.FailReason.AUTHENTICATION.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public WifiViewModel(WifiService wifiService2, StorageService storageService2, InfoSoundService infoSoundService2, ButtonService buttonService, ConfigurationProperties configurationProperties) {
        super(buttonService);
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(infoSoundService2, "infoSoundService");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        this.wifiService = wifiService2;
        this.storageService = storageService2;
        this.infoSoundService = infoSoundService2;
        this.delayPeriodMillis = Long.parseLong(configurationProperties.getProperty("wifi.refresh.delay"));
        this.coroutineScope = ViewModelKt.getViewModelScope(this);
        this.timedRefreshHandler = new TimedRefreshHandler();
        this.scanInProgress = new MutableLiveData<>(false);
        MutableLiveData<ViewState> mutableLiveData = new MutableLiveData<>();
        this._viewState = mutableLiveData;
        this.viewState = mutableLiveData;
        SingleLiveEvent<NavigationEvent> singleLiveEvent = new SingleLiveEvent<>();
        this._navigationEvent = singleLiveEvent;
        this.navigationEvent = singleLiveEvent;
        this.scanProgressObserver = new WifiViewModel$$ExternalSyntheticLambda0(this);
        this.connectionCallback = new WifiViewModel$connectionCallback$1(this);
    }

    /* access modifiers changed from: protected */
    public boolean getEnforceInternetConnectionCheck() {
        return this.enforceInternetConnectionCheck;
    }

    /* access modifiers changed from: protected */
    public final long getDelayPeriodMillis() {
        return this.delayPeriodMillis;
    }

    /* access modifiers changed from: protected */
    public final void setDelayPeriodMillis(long j) {
        this.delayPeriodMillis = j;
    }

    /* access modifiers changed from: protected */
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    /* access modifiers changed from: protected */
    public final void setCoroutineScope(CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "<set-?>");
        this.coroutineScope = coroutineScope2;
    }

    public final MutableLiveData<Boolean> getScanInProgress() {
        return this.scanInProgress;
    }

    public final LiveData<ViewState> getViewState() {
        return this.viewState;
    }

    public final LiveData<NavigationEvent> getNavigationEvent() {
        return this.navigationEvent;
    }

    /* access modifiers changed from: private */
    /* renamed from: scanProgressObserver$lambda-0  reason: not valid java name */
    public static final void m2383scanProgressObserver$lambda0(WifiViewModel wifiViewModel, Boolean bool) {
        Intrinsics.checkNotNullParameter(wifiViewModel, "this$0");
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("WifiViewModel scanInProgress: " + bool, new Object[0]);
        wifiViewModel.scanInProgress.postValue(bool);
        if (Intrinsics.areEqual((Object) bool, (Object) false)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new WifiViewModel$scanProgressObserver$1$1(wifiViewModel, (Continuation<? super WifiViewModel$scanProgressObserver$1$1>) null), 3, (Object) null);
        }
    }

    public final void viewPrepared() {
        startDisplayingWifiNetworks();
        this.wifiService.getScanningInProgress().observeForever(this.scanProgressObserver);
    }

    public final void exitView() {
        this.wifiService.getScanningInProgress().removeObserver(this.scanProgressObserver);
        Job job = this.currentJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (this.savedOfflineMode) {
            this.wifiService.setWifiEnabled(false);
        }
        this.wifiService.confirmOfflineMode();
    }

    public final void startScanning() {
        this.savedOfflineMode = !this.wifiService.getWifiEnabled();
        this.wifiService.scanForWifiNetworks();
    }

    public final void stopScanning() {
        this.wifiService.cancelConnectionRequest();
        this.wifiService.stopContinuousScan();
    }

    private final void startDisplayingWifiNetworks() {
        Job job = this.currentJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Timber.Forest.mo50221i("startDisplayingWifiNetworks", new Object[0]);
        this.currentJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new WifiViewModel$startDisplayingWifiNetworks$1(this, (Continuation<? super WifiViewModel$startDisplayingWifiNetworks$1>) null), 3, (Object) null);
    }

    public final void refreshWifiList() {
        Timber.Forest.mo50221i("refreshWifiList", new Object[0]);
        this._viewState.setValue(new ViewState.ShowNetworks(WifiItemDomainKt.toSorted(this.wifiService.getWifiNetworks())));
    }

    public final void networkSelected(WifiItem wifiItem) {
        Intrinsics.checkNotNullParameter(wifiItem, "wifiItem");
        this.selectedNetwork = wifiItem;
        this.currentPassword = null;
        this.savedOfflineMode = false;
        attemptConnection();
    }

    public final void passwordCaptured(String str) {
        this.currentPassword = str;
        attemptConnection();
    }

    public final void retryConnection() {
        attemptConnection();
    }

    private final void attemptConnection() {
        WifiItem wifiItem = this.selectedNetwork;
        if (wifiItem != null) {
            if (!wifiItem.isSecure() || this.currentPassword != null) {
                this.wifiService.connect(wifiItem, this.currentPassword, this.connectionCallback);
            } else {
                retryPassword();
            }
        }
    }

    public final void retryPassword() {
        WifiItem wifiItem = this.selectedNetwork;
        if (wifiItem != null) {
            this._navigationEvent.postValue(new NavigationEvent.AuthenticateNetwork(wifiItem));
        }
    }

    public void wifiConnectionSuccessHandler() {
        WifiItem wifiItem = this.selectedNetwork;
        if (wifiItem != null) {
            this._viewState.setValue(new ViewState.Connected(WifiItemDomainKt.toSorted(this.wifiService.getWifiNetworks())));
            String str = this.currentPassword;
            if (str != null) {
                this.storageService.saveWifiPassword(wifiItem.getSsid(), str);
            }
            this.infoSoundService.playSound(InfoSoundService.SoundType.NEW_WIFI_SUCCESS);
        }
    }

    private final void notifyWifiConnectionFailed() {
        this._navigationEvent.setValue(NavigationEvent.ConnectionFailed.INSTANCE);
        this.infoSoundService.playSound(InfoSoundService.SoundType.WIFI_CONNECTION_FAIL);
    }

    /* access modifiers changed from: private */
    public final void wifiConnectionFailureHandler(WifiService.FailReason failReason) {
        stopLoadingDueToFailure();
        int i = WhenMappings.$EnumSwitchMapping$0[failReason.ordinal()];
        if (i == 1) {
            Timber.Forest.mo50217e("No internet connection", new Object[0]);
            this._navigationEvent.setValue(NavigationEvent.InternetConnectionFailed.INSTANCE);
            this.infoSoundService.playSound(InfoSoundService.SoundType.WIFI_CONNECTION_FAIL);
        } else if (i != 2) {
            Timber.Forest.mo50217e("Wifi connection: Other", new Object[0]);
            notifyWifiConnectionFailed();
        } else {
            Timber.Forest.mo50217e("Wifi connection", new Object[0]);
            WifiItem wifiItem = this.selectedNetwork;
            if (wifiItem == null) {
                notifyWifiConnectionFailed();
            } else if (wifiItem.isSecure()) {
                this._navigationEvent.setValue(NavigationEvent.IncorrectPassword.INSTANCE);
                this.infoSoundService.playSound(InfoSoundService.SoundType.WIFI_CONNECTION_FAIL);
            } else {
                notifyWifiConnectionFailed();
            }
        }
    }

    private final void stopLoadingDueToFailure() {
        MutableLiveData<ViewState> mutableLiveData = this._viewState;
        Iterable<WifiItem> wifiNetworks = this.wifiService.getWifiNetworks();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(wifiNetworks, 10));
        for (WifiItem copy$default : wifiNetworks) {
            arrayList.add(WifiItem.copy$default(copy$default, (String) null, (String) null, (WifiStrength) null, (SecurityMode) null, ConnectionState.NOT_CONNECTED, false, 47, (Object) null));
        }
        mutableLiveData.setValue(new ViewState.ShowNetworks(WifiItemDomainKt.toSorted((List) arrayList)));
    }

    /* access modifiers changed from: protected */
    public final void updateNavigationState(NavigationEvent navigationEvent2) {
        Intrinsics.checkNotNullParameter(navigationEvent2, "navigationEvent");
        this._navigationEvent.postValue(navigationEvent2);
    }

    @Metadata(mo33736d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$ViewState;", "", "()V", "Connected", "ShowNetworks", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$ViewState$ShowNetworks;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$ViewState$Connected;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$ViewState */
    /* compiled from: WifiViewModel.kt */
    public static abstract class ViewState {
        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$ViewState$ShowNetworks;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$ViewState;", "list", "", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$ViewState$ShowNetworks */
        /* compiled from: WifiViewModel.kt */
        public static final class ShowNetworks extends ViewState {
            private final List<WifiItem> list;

            public static /* synthetic */ ShowNetworks copy$default(ShowNetworks showNetworks, List<WifiItem> list2, int i, Object obj) {
                if ((i & 1) != 0) {
                    list2 = showNetworks.list;
                }
                return showNetworks.copy(list2);
            }

            public final List<WifiItem> component1() {
                return this.list;
            }

            public final ShowNetworks copy(List<WifiItem> list2) {
                Intrinsics.checkNotNullParameter(list2, "list");
                return new ShowNetworks(list2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ShowNetworks) && Intrinsics.areEqual((Object) this.list, (Object) ((ShowNetworks) obj).list);
            }

            public int hashCode() {
                return this.list.hashCode();
            }

            public String toString() {
                return "ShowNetworks(list=" + this.list + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShowNetworks(List<WifiItem> list2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(list2, "list");
                this.list = list2;
            }

            public final List<WifiItem> getList() {
                return this.list;
            }
        }

        private ViewState() {
        }

        @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$ViewState$Connected;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$ViewState;", "list", "", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$ViewState$Connected */
        /* compiled from: WifiViewModel.kt */
        public static final class Connected extends ViewState {
            private final List<WifiItem> list;

            public static /* synthetic */ Connected copy$default(Connected connected, List<WifiItem> list2, int i, Object obj) {
                if ((i & 1) != 0) {
                    list2 = connected.list;
                }
                return connected.copy(list2);
            }

            public final List<WifiItem> component1() {
                return this.list;
            }

            public final Connected copy(List<WifiItem> list2) {
                Intrinsics.checkNotNullParameter(list2, "list");
                return new Connected(list2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Connected) && Intrinsics.areEqual((Object) this.list, (Object) ((Connected) obj).list);
            }

            public int hashCode() {
                return this.list.hashCode();
            }

            public String toString() {
                return "Connected(list=" + this.list + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Connected(List<WifiItem> list2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(list2, "list");
                this.list = list2;
            }

            public final List<WifiItem> getList() {
                return this.list;
            }
        }
    }

    @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent;", "", "()V", "AuthenticateNetwork", "ConnectionFailed", "IncorrectPassword", "InternetConnectionFailed", "ShowUpdateScreen", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent$IncorrectPassword;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent$ConnectionFailed;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent$InternetConnectionFailed;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent$ShowUpdateScreen;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent$AuthenticateNetwork;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$NavigationEvent */
    /* compiled from: WifiViewModel.kt */
    public static abstract class NavigationEvent {
        public /* synthetic */ NavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent$IncorrectPassword;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$NavigationEvent$IncorrectPassword */
        /* compiled from: WifiViewModel.kt */
        public static final class IncorrectPassword extends NavigationEvent {
            public static final IncorrectPassword INSTANCE = new IncorrectPassword();

            private IncorrectPassword() {
                super((DefaultConstructorMarker) null);
            }
        }

        private NavigationEvent() {
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent$ConnectionFailed;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$NavigationEvent$ConnectionFailed */
        /* compiled from: WifiViewModel.kt */
        public static final class ConnectionFailed extends NavigationEvent {
            public static final ConnectionFailed INSTANCE = new ConnectionFailed();

            private ConnectionFailed() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent$InternetConnectionFailed;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$NavigationEvent$InternetConnectionFailed */
        /* compiled from: WifiViewModel.kt */
        public static final class InternetConnectionFailed extends NavigationEvent {
            public static final InternetConnectionFailed INSTANCE = new InternetConnectionFailed();

            private InternetConnectionFailed() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent$ShowUpdateScreen;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$NavigationEvent$ShowUpdateScreen */
        /* compiled from: WifiViewModel.kt */
        public static final class ShowUpdateScreen extends NavigationEvent {
            public static final ShowUpdateScreen INSTANCE = new ShowUpdateScreen();

            private ShowUpdateScreen() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent$AuthenticateNetwork;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel$NavigationEvent;", "wifiItem", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "(Lmedia/tiger/tigerbox/model/domain/WifiItem;)V", "getWifiItem", "()Lmedia/tiger/tigerbox/model/domain/WifiItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$NavigationEvent$AuthenticateNetwork */
        /* compiled from: WifiViewModel.kt */
        public static final class AuthenticateNetwork extends NavigationEvent {
            private final WifiItem wifiItem;

            public static /* synthetic */ AuthenticateNetwork copy$default(AuthenticateNetwork authenticateNetwork, WifiItem wifiItem2, int i, Object obj) {
                if ((i & 1) != 0) {
                    wifiItem2 = authenticateNetwork.wifiItem;
                }
                return authenticateNetwork.copy(wifiItem2);
            }

            public final WifiItem component1() {
                return this.wifiItem;
            }

            public final AuthenticateNetwork copy(WifiItem wifiItem2) {
                Intrinsics.checkNotNullParameter(wifiItem2, "wifiItem");
                return new AuthenticateNetwork(wifiItem2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AuthenticateNetwork) && Intrinsics.areEqual((Object) this.wifiItem, (Object) ((AuthenticateNetwork) obj).wifiItem);
            }

            public int hashCode() {
                return this.wifiItem.hashCode();
            }

            public String toString() {
                return "AuthenticateNetwork(wifiItem=" + this.wifiItem + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AuthenticateNetwork(WifiItem wifiItem2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(wifiItem2, "wifiItem");
                this.wifiItem = wifiItem2;
            }

            public final WifiItem getWifiItem() {
                return this.wifiItem;
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WifiViewModel(WifiService wifiService2, StorageService storageService2, InfoSoundService infoSoundService2, ButtonService buttonService, CoroutineScope coroutineScope2, long j, ConfigurationProperties configurationProperties) {
        this(wifiService2, storageService2, infoSoundService2, buttonService, configurationProperties);
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(infoSoundService2, "infoSoundService");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        this.delayPeriodMillis = j;
        this.coroutineScope = coroutineScope2;
    }
}
