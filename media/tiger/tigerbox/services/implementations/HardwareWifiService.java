package media.tiger.tigerbox.services.implementations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.CountDownTimer;
import android.text.format.Formatter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.model.domain.ConnectionState;
import media.tiger.tigerbox.model.domain.SecurityMode;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.model.domain.WifiStrength;
import media.tiger.tigerbox.services.implementations.wifi.NetworkConnectivityCallback;
import media.tiger.tigerbox.services.interfaces.WifiService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001'\b\u0007\u0018\u00002\u00020\u0001:\u0001qB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020LH\u0016J\"\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020#2\b\u0010P\u001a\u0004\u0018\u00010\u00072\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0007H\u0002J\n\u0010Y\u001a\u0004\u0018\u00010#H\u0002J\b\u0010Z\u001a\u00020LH\u0002J\b\u0010[\u001a\u00020LH\u0002J\b\u0010\\\u001a\u00020LH\u0016J\u0010\u0010]\u001a\u00020\u00172\u0006\u0010^\u001a\u00020\tH\u0002J\u0010\u0010_\u001a\u00020\r2\u0006\u0010X\u001a\u00020\u0007H\u0002J\b\u0010`\u001a\u00020\rH\u0002J\u0010\u0010a\u001a\u00020L2\u0006\u0010b\u001a\u00020\u0007H\u0002J\b\u0010c\u001a\u00020LH\u0002J\u0010\u0010d\u001a\u00020L2\u0006\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020LH\u0002J\b\u0010g\u001a\u00020LH\u0016J\"\u0010h\u001a\u00020L2\u0006\u0010i\u001a\u00020W2\u0006\u0010j\u001a\u00020k2\b\u0010P\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010l\u001a\u00020LH\u0002J\b\u0010m\u001a\u00020LH\u0002J\b\u0010n\u001a\u00020LH\u0002J\b\u0010o\u001a\u00020LH\u0016J\f\u0010j\u001a\u00020k*\u00020pH\u0002R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00170\u00170\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0004¢\u0006\u0004\n\u0002\u0010(R\u0014\u0010)\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00078WX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020#01X\u0004¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\n \u000e*\u0004\u0018\u00010303X\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\r058VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\r058VX\u0004¢\u0006\u0006\u001a\u0004\b9\u00107R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R$\u0010;\u001a\u00020\r2\u0006\u0010:\u001a\u00020\r8V@VX\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010@\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\bB\u0010\u0015\u001a\u0004\bA\u0010\u0013R\u000e\u0010C\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020#0F8VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u0017058VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u00107¨\u0006r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/HardwareWifiService;", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "context", "Landroid/content/Context;", "refreshDelayMillis", "", "serverUrl", "", "serverPort", "", "(Landroid/content/Context;JLjava/lang/String;I)V", "_offlineMode", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_scanningInProgress", "_wifiReceiver", "Landroid/content/BroadcastReceiver;", "get_wifiReceiver", "()Landroid/content/BroadcastReceiver;", "_wifiReceiver$delegate", "Lkotlin/Lazy;", "_wifiSignalStrength", "Lmedia/tiger/tigerbox/model/domain/WifiStrength;", "connectionPayload", "Lmedia/tiger/tigerbox/services/implementations/HardwareWifiService$ConnectionPayload;", "connectionTimer", "Landroid/os/CountDownTimer;", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "continueScanning", "currentConnectingWifiItem", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "executor", "Ljava/util/concurrent/ExecutorService;", "internetConnectionCallback", "media/tiger/tigerbox/services/implementations/HardwareWifiService$internetConnectionCallback$1", "Lmedia/tiger/tigerbox/services/implementations/HardwareWifiService$internetConnectionCallback$1;", "ipAddress", "getIpAddress", "()Ljava/lang/String;", "macAddress", "getMacAddress", "networkCallback", "Lmedia/tiger/tigerbox/services/implementations/wifi/NetworkConnectivityCallback;", "networkList", "", "networkRequest", "Landroid/net/NetworkRequest;", "offlineMode", "Landroidx/lifecycle/LiveData;", "getOfflineMode", "()Landroidx/lifecycle/LiveData;", "scanningInProgress", "getScanningInProgress", "value", "wifiEnabled", "getWifiEnabled", "()Z", "setWifiEnabled", "(Z)V", "wifiListScanReceiver", "getWifiListScanReceiver", "wifiListScanReceiver$delegate", "wifiManager", "Landroid/net/wifi/WifiManager;", "wifiNetworks", "", "getWifiNetworks", "()Ljava/util/List;", "wifiSignalStrength", "getWifiSignalStrength", "cancelConnectionRequest", "", "confirmOfflineMode", "connect", "wifiItem", "password", "connectionCallback", "Lmedia/tiger/tigerbox/services/interfaces/WifiService$ConnectionCallback;", "connectionFail", "failReason", "Lmedia/tiger/tigerbox/services/interfaces/WifiService$FailReason;", "createWifiConfiguration", "Landroid/net/wifi/WifiConfiguration;", "ssid", "currentlyConnectedWifiItem", "disableOfflineMode", "enableOfflineMode", "forgetAllNetworks", "getStrength", "level", "isConnectedToSSID", "isNetworkConnected", "log", "message", "onWifiScanComplete", "onWifiSignalChanged", "rssi", "registerWifiReceiver", "scanForWifiNetworks", "setupSecurity", "wifiConfiguration", "securityMode", "Lmedia/tiger/tigerbox/model/domain/SecurityMode;", "startConnectionTimeoutTimer", "startScanning", "stopConnectionTimeoutTimer", "stopContinuousScan", "Landroid/net/wifi/ScanResult;", "ConnectionPayload", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HardwareWifiService.kt */
public final class HardwareWifiService implements WifiService {
    private final MutableLiveData<Boolean> _offlineMode;
    private final MutableLiveData<Boolean> _scanningInProgress;
    private final Lazy _wifiReceiver$delegate;
    private final MutableLiveData<WifiStrength> _wifiSignalStrength = new MutableLiveData<>(WifiStrength.WIFI_STRONG);
    /* access modifiers changed from: private */
    public ConnectionPayload connectionPayload;
    private CountDownTimer connectionTimer;
    private final Lazy connectivityManager$delegate = LazyKt.lazy(new HardwareWifiService$connectivityManager$2(this));
    /* access modifiers changed from: private */
    public final Context context;
    private boolean continueScanning;
    /* access modifiers changed from: private */
    public WifiItem currentConnectingWifiItem;
    private ExecutorService executor;
    private final HardwareWifiService$internetConnectionCallback$1 internetConnectionCallback;
    private NetworkConnectivityCallback networkCallback;
    /* access modifiers changed from: private */
    public final List<WifiItem> networkList = new ArrayList();
    private final NetworkRequest networkRequest;
    private final long refreshDelayMillis;
    /* access modifiers changed from: private */
    public final int serverPort;
    /* access modifiers changed from: private */
    public final String serverUrl;
    private final Lazy wifiListScanReceiver$delegate;
    /* access modifiers changed from: private */
    public final WifiManager wifiManager;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: HardwareWifiService.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SecurityMode.values().length];
            iArr[SecurityMode.OPEN.ordinal()] = 1;
            iArr[SecurityMode.WEP.ordinal()] = 2;
            iArr[SecurityMode.WPA.ordinal()] = 3;
            iArr[SecurityMode.WPA2.ordinal()] = 4;
            iArr[SecurityMode.WPA_EAP.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HardwareWifiService(Context context2, long j, String str, int i) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "serverUrl");
        this.context = context2;
        this.refreshDelayMillis = j;
        this.serverUrl = str;
        this.serverPort = i;
        Object systemService = context2.getApplicationContext().getSystemService("wifi");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        this.wifiManager = (WifiManager) systemService;
        this._scanningInProgress = new MutableLiveData<>(false);
        this._offlineMode = new MutableLiveData<>(false);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        this.executor = newSingleThreadExecutor;
        HardwareWifiService$internetConnectionCallback$1 hardwareWifiService$internetConnectionCallback$1 = new HardwareWifiService$internetConnectionCallback$1(this);
        this.internetConnectionCallback = hardwareWifiService$internetConnectionCallback$1;
        this.wifiListScanReceiver$delegate = LazyKt.lazy(new HardwareWifiService$wifiListScanReceiver$2(this));
        this._wifiReceiver$delegate = LazyKt.lazy(new HardwareWifiService$_wifiReceiver$2(this));
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(1).build();
        this.networkRequest = build;
        this.networkCallback = new NetworkConnectivityCallback(hardwareWifiService$internetConnectionCallback$1);
        log("init");
        registerWifiReceiver();
        getConnectivityManager().registerNetworkCallback(build, this.networkCallback);
        startScanning();
    }

    @Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/HardwareWifiService$ConnectionPayload;", "", "wifiItem", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "connectionCallback", "Lmedia/tiger/tigerbox/services/interfaces/WifiService$ConnectionCallback;", "(Lmedia/tiger/tigerbox/model/domain/WifiItem;Lmedia/tiger/tigerbox/services/interfaces/WifiService$ConnectionCallback;)V", "getConnectionCallback", "()Lmedia/tiger/tigerbox/services/interfaces/WifiService$ConnectionCallback;", "getWifiItem", "()Lmedia/tiger/tigerbox/model/domain/WifiItem;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: HardwareWifiService.kt */
    private static final class ConnectionPayload {
        private final WifiService.ConnectionCallback connectionCallback;
        private final WifiItem wifiItem;

        public static /* synthetic */ ConnectionPayload copy$default(ConnectionPayload connectionPayload, WifiItem wifiItem2, WifiService.ConnectionCallback connectionCallback2, int i, Object obj) {
            if ((i & 1) != 0) {
                wifiItem2 = connectionPayload.wifiItem;
            }
            if ((i & 2) != 0) {
                connectionCallback2 = connectionPayload.connectionCallback;
            }
            return connectionPayload.copy(wifiItem2, connectionCallback2);
        }

        public final WifiItem component1() {
            return this.wifiItem;
        }

        public final WifiService.ConnectionCallback component2() {
            return this.connectionCallback;
        }

        public final ConnectionPayload copy(WifiItem wifiItem2, WifiService.ConnectionCallback connectionCallback2) {
            Intrinsics.checkNotNullParameter(wifiItem2, "wifiItem");
            Intrinsics.checkNotNullParameter(connectionCallback2, "connectionCallback");
            return new ConnectionPayload(wifiItem2, connectionCallback2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConnectionPayload)) {
                return false;
            }
            ConnectionPayload connectionPayload = (ConnectionPayload) obj;
            return Intrinsics.areEqual((Object) this.wifiItem, (Object) connectionPayload.wifiItem) && Intrinsics.areEqual((Object) this.connectionCallback, (Object) connectionPayload.connectionCallback);
        }

        public int hashCode() {
            return (this.wifiItem.hashCode() * 31) + this.connectionCallback.hashCode();
        }

        public String toString() {
            return "ConnectionPayload(wifiItem=" + this.wifiItem + ", connectionCallback=" + this.connectionCallback + ')';
        }

        public ConnectionPayload(WifiItem wifiItem2, WifiService.ConnectionCallback connectionCallback2) {
            Intrinsics.checkNotNullParameter(wifiItem2, "wifiItem");
            Intrinsics.checkNotNullParameter(connectionCallback2, "connectionCallback");
            this.wifiItem = wifiItem2;
            this.connectionCallback = connectionCallback2;
        }

        public final WifiItem getWifiItem() {
            return this.wifiItem;
        }

        public final WifiService.ConnectionCallback getConnectionCallback() {
            return this.connectionCallback;
        }
    }

    private final ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) this.connectivityManager$delegate.getValue();
    }

    public boolean getWifiEnabled() {
        return this.wifiManager.isWifiEnabled();
    }

    public void setWifiEnabled(boolean z) {
        if (this.currentConnectingWifiItem != null) {
            this.wifiManager.setWifiEnabled(true);
        } else {
            this.wifiManager.setWifiEnabled(z);
        }
    }

    public LiveData<Boolean> getScanningInProgress() {
        return this._scanningInProgress;
    }

    public LiveData<Boolean> getOfflineMode() {
        return this._offlineMode;
    }

    public List<WifiItem> getWifiNetworks() {
        return this.networkList;
    }

    public LiveData<WifiStrength> getWifiSignalStrength() {
        return this._wifiSignalStrength;
    }

    public String getIpAddress() {
        String formatIpAddress = Formatter.formatIpAddress(this.wifiManager.getConnectionInfo().getIpAddress());
        Intrinsics.checkNotNullExpressionValue(formatIpAddress, "formatIpAddress(wifiMana…connectionInfo.ipAddress)");
        return formatIpAddress;
    }

    public String getMacAddress() {
        String macAddress = this.wifiManager.getConnectionInfo().getMacAddress();
        return macAddress == null ? "" : macAddress;
    }

    /* access modifiers changed from: private */
    public final WifiItem currentlyConnectedWifiItem() {
        String bssid = this.wifiManager.getConnectionInfo().getBSSID();
        try {
            List<ScanResult> scanResults = this.wifiManager.getScanResults();
            Intrinsics.checkNotNullExpressionValue(scanResults, "wifiManager.scanResults");
            for (Object next : scanResults) {
                if (Intrinsics.areEqual((Object) ((ScanResult) next).BSSID, (Object) bssid)) {
                    ScanResult scanResult = (ScanResult) next;
                    String str = scanResult.BSSID;
                    Intrinsics.checkNotNullExpressionValue(str, "scanResult.BSSID");
                    String str2 = scanResult.SSID;
                    Intrinsics.checkNotNullExpressionValue(str2, "scanResult.SSID");
                    WifiStrength strength = getStrength(scanResult.level);
                    Intrinsics.checkNotNullExpressionValue(scanResult, "scanResult");
                    return new WifiItem(str, str2, strength, securityMode(scanResult), ConnectionState.CONNECTED, false, 32, (DefaultConstructorMarker) null);
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } catch (NoSuchElementException unused) {
            Timber.Forest.mo50217e("No such element", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void connectionFail(WifiService.FailReason failReason) {
        WifiService.ConnectionCallback connectionCallback;
        WifiService.FailReason failReason2 = failReason;
        Timber.Forest forest = Timber.Forest;
        int i = 0;
        forest.mo50221i("Wifi connection failed " + failReason2, new Object[0]);
        stopConnectionTimeoutTimer();
        synchronized (this.networkList) {
            Iterator<WifiItem> it = this.networkList.iterator();
            while (true) {
                String str = null;
                if (!it.hasNext()) {
                    break;
                }
                int i2 = i + 1;
                WifiItem next = it.next();
                String ssid = next.getSsid();
                WifiItem wifiItem = this.currentConnectingWifiItem;
                if (wifiItem != null) {
                    str = wifiItem.getSsid();
                }
                if (Intrinsics.areEqual((Object) ssid, (Object) str)) {
                    this.networkList.set(i, WifiItem.copy$default(next, (String) null, (String) null, (WifiStrength) null, (SecurityMode) null, ConnectionState.NOT_CONNECTED, false, 47, (Object) null));
                }
                i = i2;
            }
            Unit unit = Unit.INSTANCE;
        }
        ConnectionPayload connectionPayload2 = this.connectionPayload;
        if (!(connectionPayload2 == null || (connectionCallback = connectionPayload2.getConnectionCallback()) == null)) {
            connectionCallback.onFail(failReason2);
        }
        this.connectionPayload = null;
        enableOfflineMode();
    }

    private final BroadcastReceiver getWifiListScanReceiver() {
        return (BroadcastReceiver) this.wifiListScanReceiver$delegate.getValue();
    }

    private final BroadcastReceiver get_wifiReceiver() {
        return (BroadcastReceiver) this._wifiReceiver$delegate.getValue();
    }

    public void connect(WifiItem wifiItem, String str, WifiService.ConnectionCallback connectionCallback) {
        int i;
        WifiItem wifiItem2 = wifiItem;
        String str2 = str;
        WifiService.ConnectionCallback connectionCallback2 = connectionCallback;
        Intrinsics.checkNotNullParameter(wifiItem2, "wifiItem");
        Intrinsics.checkNotNullParameter(connectionCallback2, "connectionCallback");
        setWifiEnabled(true);
        if (!isConnectedToSSID(wifiItem.getSsid())) {
            this.connectionPayload = new ConnectionPayload(wifiItem2, connectionCallback2);
            connectionCallback2.onConnecting(wifiItem.getSsid());
            this.currentConnectingWifiItem = null;
            synchronized (this.networkList) {
                i = 0;
                int i2 = 0;
                for (WifiItem next : this.networkList) {
                    int i3 = i2 + 1;
                    if (!Intrinsics.areEqual((Object) next.getSsid(), (Object) wifiItem.getSsid())) {
                        if (!Intrinsics.areEqual((Object) next.getBssid(), (Object) wifiItem.getBssid())) {
                            this.networkList.set(i2, WifiItem.copy$default(next, (String) null, (String) null, (WifiStrength) null, (SecurityMode) null, ConnectionState.NOT_CONNECTED, false, 47, (Object) null));
                            i2 = i3;
                        }
                    }
                    this.networkList.set(i2, WifiItem.copy$default(next, (String) null, (String) null, (WifiStrength) null, (SecurityMode) null, ConnectionState.CONNECTING, false, 47, (Object) null));
                    this.currentConnectingWifiItem = wifiItem2;
                    i2 = i3;
                }
                Unit unit = Unit.INSTANCE;
            }
            log("connect [" + wifiItem.getSsid() + "] [" + wifiItem.getSecurityMode() + ']');
            WifiConfiguration createWifiConfiguration = createWifiConfiguration(wifiItem.getSsid());
            setupSecurity(createWifiConfiguration, wifiItem.getSecurityMode(), str2);
            startConnectionTimeoutTimer();
            int addNetwork = this.wifiManager.addNetwork(createWifiConfiguration);
            log("    connect addNetworkResult [" + addNetwork + ']');
            if (addNetwork == -1 || !this.wifiManager.saveConfiguration()) {
                log("    connect onFail invoked");
                if (addNetwork == -1) {
                    if (str2 != null) {
                        i = str.length();
                    }
                    if (i < 8) {
                        connectionFail(WifiService.FailReason.AUTHENTICATION);
                        return;
                    }
                }
                connectionFail(WifiService.FailReason.OTHER);
                return;
            }
            log("    connect addNetworkResult valid and config saved");
            this.wifiManager.enableNetwork(addNetwork, true);
        }
    }

    public void cancelConnectionRequest() {
        this.connectionPayload = null;
    }

    private final WifiConfiguration createWifiConfiguration(String str) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = Typography.quote + str + Typography.quote;
        return wifiConfiguration;
    }

    private final void setupSecurity(WifiConfiguration wifiConfiguration, SecurityMode securityMode, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.quote);
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(Typography.quote);
        String sb2 = sb.toString();
        int i = WhenMappings.$EnumSwitchMapping$0[securityMode.ordinal()];
        int i2 = 0;
        if (i == 1) {
            wifiConfiguration.allowedKeyManagement.set(0);
        } else if (i == 2) {
            wifiConfiguration.wepKeys[0] = sb2;
            wifiConfiguration.wepTxKeyIndex = 0;
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.allowedAuthAlgorithms.set(1);
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.allowedGroupCiphers.set(0);
            wifiConfiguration.allowedGroupCiphers.set(1);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(3);
        } else if (i == 3 || i == 4) {
            wifiConfiguration.preSharedKey = sb2;
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedKeyManagement.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(3);
            BitSet bitSet = wifiConfiguration.allowedProtocols;
            if (securityMode == SecurityMode.WPA2) {
                i2 = 1;
            }
            bitSet.set(i2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0039 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onWifiScanComplete() {
        /*
            r27 = this;
            r1 = r27
            android.net.wifi.WifiManager r0 = r1.wifiManager
            android.net.wifi.WifiInfo r0 = r0.getConnectionInfo()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onWifiScanComplete current network: ["
            r2.append(r3)
            r2.append(r0)
            r3 = 93
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.log(r2)
            android.net.wifi.WifiManager r2 = r1.wifiManager
            java.util.List r2 = r2.getScanResults()
            java.lang.String r4 = "wifiManager.scanResults"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r2 = r2.iterator()
        L_0x0039:
            boolean r5 = r2.hasNext()
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0096
            java.lang.Object r5 = r2.next()
            r8 = r5
            android.net.wifi.ScanResult r8 = (android.net.wifi.ScanResult) r8
            r9 = 2
            kotlin.jvm.functions.Function1[] r9 = new kotlin.jvm.functions.Function1[r9]
            media.tiger.tigerbox.services.implementations.HardwareWifiService$onWifiScanComplete$tempNetworkList$1$1 r10 = media.tiger.tigerbox.services.implementations.HardwareWifiService$onWifiScanComplete$tempNetworkList$1$1.INSTANCE
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r9[r6] = r10
            media.tiger.tigerbox.services.implementations.HardwareWifiService$onWifiScanComplete$tempNetworkList$1$2 r10 = new media.tiger.tigerbox.services.implementations.HardwareWifiService$onWifiScanComplete$tempNetworkList$1$2
            r10.<init>(r1)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r9[r7] = r10
            java.util.List r9 = kotlin.collections.CollectionsKt.listOf(r9)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            boolean r10 = r9 instanceof java.util.Collection
            if (r10 == 0) goto L_0x006f
            r10 = r9
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x006f
        L_0x006d:
            r6 = 1
            goto L_0x0090
        L_0x006f:
            java.util.Iterator r9 = r9.iterator()
        L_0x0073:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x006d
            java.lang.Object r10 = r9.next()
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.String r11 = "candidate"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r11)
            java.lang.Object r10 = r10.invoke(r8)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x0073
        L_0x0090:
            if (r6 == 0) goto L_0x0039
            r4.add(r5)
            goto L_0x0039
        L_0x0096:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r2 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r5)
            r2.<init>(r5)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r4 = r4.iterator()
        L_0x00ab:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01ab
            java.lang.Object r5 = r4.next()
            android.net.wifi.ScanResult r5 = (android.net.wifi.ScanResult) r5
            java.lang.String r8 = r5.BSSID
            java.lang.String r9 = "item.BSSID"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r9)
            java.lang.String r9 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            r9 = 0
            if (r0 == 0) goto L_0x00de
            java.lang.String r10 = r0.getBSSID()
            if (r10 == 0) goto L_0x00de
            java.util.Locale r11 = java.util.Locale.ROOT
            java.lang.String r10 = r10.toLowerCase(r11)
            java.lang.String r11 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            goto L_0x00df
        L_0x00de:
            r10 = r9
        L_0x00df:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r10)
            if (r8 == 0) goto L_0x0118
            media.tiger.tigerbox.model.domain.WifiItem r8 = r1.currentConnectingWifiItem
            if (r8 != 0) goto L_0x0118
            media.tiger.tigerbox.model.domain.WifiItem r8 = new media.tiger.tigerbox.model.domain.WifiItem
            java.lang.String r11 = r0.getBSSID()
            java.lang.String r9 = "currentWifi.bssid"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r9)
            java.lang.String r12 = r5.SSID
            java.lang.String r9 = "item.SSID"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r9)
            int r9 = r5.level
            media.tiger.tigerbox.model.domain.WifiStrength r13 = r1.getStrength(r9)
            java.lang.String r9 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            media.tiger.tigerbox.model.domain.SecurityMode r14 = r1.securityMode(r5)
            media.tiger.tigerbox.model.domain.ConnectionState r15 = media.tiger.tigerbox.model.domain.ConnectionState.CONNECTED
            r16 = 0
            r17 = 32
            r18 = 0
            r10 = r8
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x01a6
        L_0x0118:
            media.tiger.tigerbox.model.domain.WifiItem r8 = r1.currentConnectingWifiItem
            if (r8 == 0) goto L_0x0176
            java.lang.String r8 = r5.BSSID
            java.lang.String r10 = "item.BSSID"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            java.util.Locale r10 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r10)
            java.lang.String r10 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            media.tiger.tigerbox.model.domain.WifiItem r10 = r1.currentConnectingWifiItem
            if (r10 == 0) goto L_0x0143
            java.lang.String r10 = r10.getBssid()
            if (r10 == 0) goto L_0x0143
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r9 = r10.toLowerCase(r9)
            java.lang.String r10 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
        L_0x0143:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x0176
            media.tiger.tigerbox.model.domain.WifiItem r8 = new media.tiger.tigerbox.model.domain.WifiItem
            media.tiger.tigerbox.model.domain.WifiItem r9 = r1.currentConnectingWifiItem
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            java.lang.String r10 = r9.getBssid()
            java.lang.String r11 = r5.SSID
            java.lang.String r9 = "item.SSID"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r9)
            int r9 = r5.level
            media.tiger.tigerbox.model.domain.WifiStrength r12 = r1.getStrength(r9)
            java.lang.String r9 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            media.tiger.tigerbox.model.domain.SecurityMode r13 = r1.securityMode(r5)
            media.tiger.tigerbox.model.domain.ConnectionState r14 = media.tiger.tigerbox.model.domain.ConnectionState.CONNECTING
            r15 = 0
            r16 = 32
            r17 = 0
            r9 = r8
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x01a6
        L_0x0176:
            media.tiger.tigerbox.model.domain.WifiItem r8 = new media.tiger.tigerbox.model.domain.WifiItem
            java.lang.String r9 = r5.BSSID
            java.lang.String r10 = "item.BSSID"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.lang.String r10 = r5.SSID
            java.lang.String r11 = "item.SSID"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            int r11 = r5.level
            media.tiger.tigerbox.model.domain.WifiStrength r21 = r1.getStrength(r11)
            java.lang.String r11 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r11)
            media.tiger.tigerbox.model.domain.SecurityMode r22 = r1.securityMode(r5)
            media.tiger.tigerbox.model.domain.ConnectionState r23 = media.tiger.tigerbox.model.domain.ConnectionState.NOT_CONNECTED
            r24 = 0
            r25 = 32
            r26 = 0
            r18 = r8
            r19 = r9
            r20 = r10
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26)
        L_0x01a6:
            r2.add(r8)
            goto L_0x00ab
        L_0x01ab:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            media.tiger.tigerbox.services.implementations.HardwareWifiService$onWifiScanComplete$$inlined$sortedByDescending$1 r0 = new media.tiger.tigerbox.services.implementations.HardwareWifiService$onWifiScanComplete$$inlined$sortedByDescending$1
            r0.<init>()
            java.util.Comparator r0 = (java.util.Comparator) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.sortedWith(r2, r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x01ca:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x01e5
            java.lang.Object r5 = r0.next()
            r8 = r5
            media.tiger.tigerbox.model.domain.WifiItem r8 = (media.tiger.tigerbox.model.domain.WifiItem) r8
            java.lang.String r8 = r8.getSsid()
            boolean r8 = r2.add(r8)
            if (r8 == 0) goto L_0x01ca
            r4.add(r5)
            goto L_0x01ca
        L_0x01e5:
            java.util.List r4 = (java.util.List) r4
            java.util.List<media.tiger.tigerbox.model.domain.WifiItem> r2 = r1.networkList
            monitor-enter(r2)
            java.util.List<media.tiger.tigerbox.model.domain.WifiItem> r0 = r1.networkList     // Catch:{ all -> 0x0225 }
            r0.clear()     // Catch:{ all -> 0x0225 }
            java.util.List<media.tiger.tigerbox.model.domain.WifiItem> r0 = r1.networkList     // Catch:{ all -> 0x0225 }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ all -> 0x0225 }
            r0.addAll(r4)     // Catch:{ all -> 0x0225 }
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r0 = r1._scanningInProgress     // Catch:{ all -> 0x0225 }
            java.util.List<media.tiger.tigerbox.model.domain.WifiItem> r4 = r1.networkList     // Catch:{ all -> 0x0225 }
            int r4 = r4.size()     // Catch:{ all -> 0x0225 }
            if (r4 != 0) goto L_0x0201
            r6 = 1
        L_0x0201:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0225 }
            r0.postValue(r4)     // Catch:{ all -> 0x0225 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0225 }
            r0.<init>()     // Catch:{ all -> 0x0225 }
            java.lang.String r4 = "onWifiScanComplete distinctBy: "
            r0.append(r4)     // Catch:{ all -> 0x0225 }
            java.util.List<media.tiger.tigerbox.model.domain.WifiItem> r4 = r1.networkList     // Catch:{ all -> 0x0225 }
            r0.append(r4)     // Catch:{ all -> 0x0225 }
            r0.append(r3)     // Catch:{ all -> 0x0225 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0225 }
            r1.log(r0)     // Catch:{ all -> 0x0225 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0225 }
            monitor-exit(r2)
            return
        L_0x0225:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.HardwareWifiService.onWifiScanComplete():void");
    }

    /* access modifiers changed from: private */
    public final void onWifiSignalChanged(int i) {
        this._wifiSignalStrength.postValue(getStrength(i));
    }

    private final void registerWifiReceiver() {
        log("registerWifiReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.RSSI_CHANGED");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        this.context.registerReceiver(get_wifiReceiver(), intentFilter);
    }

    /* access modifiers changed from: private */
    public final SecurityMode securityMode(ScanResult scanResult) {
        String str = scanResult.capabilities;
        Intrinsics.checkNotNullExpressionValue(str, "this.capabilities");
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "EAP", false, 2, (Object) null)) {
            return SecurityMode.WPA_EAP;
        }
        String str2 = scanResult.capabilities;
        Intrinsics.checkNotNullExpressionValue(str2, "this.capabilities");
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "WPA2", false, 2, (Object) null)) {
            return SecurityMode.WPA2;
        }
        String str3 = scanResult.capabilities;
        Intrinsics.checkNotNullExpressionValue(str3, "this.capabilities");
        if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "WPA", false, 2, (Object) null)) {
            return SecurityMode.WPA;
        }
        String str4 = scanResult.capabilities;
        Intrinsics.checkNotNullExpressionValue(str4, "this.capabilities");
        if (StringsKt.contains$default((CharSequence) str4, (CharSequence) "WEP", false, 2, (Object) null)) {
            return SecurityMode.WEP;
        }
        return SecurityMode.OPEN;
    }

    private final WifiStrength getStrength(int i) {
        int calculateSignalLevel = WifiManager.calculateSignalLevel(i, WifiStrength.Companion.getValuesWithConnection().size());
        if (calculateSignalLevel == 1) {
            return WifiStrength.WIFI_MEDIUM;
        }
        if (calculateSignalLevel != 2) {
            return WifiStrength.WIFI_WEAK;
        }
        return WifiStrength.WIFI_STRONG;
    }

    /* access modifiers changed from: private */
    public final boolean isNetworkConnected() {
        if (!this.wifiManager.isWifiEnabled() || this.wifiManager.getConnectionInfo().getNetworkId() == -1) {
            return false;
        }
        return true;
    }

    private final boolean isConnectedToSSID(String str) {
        WifiInfo connectionInfo = this.wifiManager.getConnectionInfo();
        String ssid = connectionInfo != null ? connectionInfo.getSSID() : null;
        if (!Intrinsics.areEqual((Object) ssid, (Object) Typography.quote + str + Typography.quote)) {
            return false;
        }
        log("Already connected to: " + this.wifiManager.getConnectionInfo().getSSID() + " BSSID: " + this.wifiManager.getConnectionInfo().getBSSID());
        return true;
    }

    private final void startConnectionTimeoutTimer() {
        log("Network connection timer started");
        CountDownTimer countDownTimer = this.connectionTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer hardwareWifiService$startConnectionTimeoutTimer$1 = new HardwareWifiService$startConnectionTimeoutTimer$1(this);
        this.connectionTimer = hardwareWifiService$startConnectionTimeoutTimer$1;
        hardwareWifiService$startConnectionTimeoutTimer$1.start();
    }

    /* access modifiers changed from: private */
    public final void stopConnectionTimeoutTimer() {
        log("Network connection timer stopped");
        CountDownTimer countDownTimer = this.connectionTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void forgetAllNetworks() {
        log("forgetAllNetworks");
        if (this.wifiManager.getConfiguredNetworks() != null) {
            List<WifiConfiguration> configuredNetworks = this.wifiManager.getConfiguredNetworks();
            Intrinsics.checkNotNullExpressionValue(configuredNetworks, "wifiManager.configuredNetworks");
            for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                this.wifiManager.removeNetwork(wifiConfiguration.networkId);
            }
            enableOfflineMode();
        }
    }

    public void scanForWifiNetworks() {
        log("scanForWifiNetworks");
        this.context.registerReceiver(getWifiListScanReceiver(), new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        if (!this.wifiManager.isWifiEnabled()) {
            setWifiEnabled(true);
        }
        this.continueScanning = true;
        startScanning();
    }

    private final void startScanning() {
        this.executor.shutdown();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        this.executor = newSingleThreadExecutor;
        newSingleThreadExecutor.execute(new HardwareWifiService$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startScanning$lambda-12  reason: not valid java name */
    public static final void m2342startScanning$lambda12(HardwareWifiService hardwareWifiService) {
        Intrinsics.checkNotNullParameter(hardwareWifiService, "this$0");
        while (hardwareWifiService.continueScanning) {
            hardwareWifiService._scanningInProgress.postValue(Boolean.valueOf(hardwareWifiService.networkList.size() == 0));
            hardwareWifiService.wifiManager.startScan();
            Thread.sleep(hardwareWifiService.refreshDelayMillis);
        }
    }

    public void stopContinuousScan() {
        log("stopContinuousScan");
        this.continueScanning = false;
        this._scanningInProgress.postValue(Boolean.valueOf(this.networkList.size() == 0));
        try {
            this.context.unregisterReceiver(getWifiListScanReceiver());
        } catch (IllegalArgumentException e) {
            Timber.Tree tag = Timber.Forest.tag("Tiger WiFi");
            tag.mo50217e("Receiver not registered: " + e, new Object[0]);
        }
        this.executor.shutdown();
    }

    public void confirmOfflineMode() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new HardwareWifiService$confirmOfflineMode$1(this, (Continuation<? super HardwareWifiService$confirmOfflineMode$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void enableOfflineMode() {
        Iterable<WifiItem> iterable = this.networkList;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (WifiItem copy$default : iterable) {
            arrayList.add(WifiItem.copy$default(copy$default, (String) null, (String) null, (WifiStrength) null, (SecurityMode) null, ConnectionState.NOT_CONNECTED, false, 47, (Object) null));
        }
        List list = (List) arrayList;
        synchronized (this.networkList) {
            this.networkList.clear();
            this.networkList.addAll(list);
            this._offlineMode.postValue(true);
            log("Offline mode enabled");
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void disableOfflineMode() {
        this._offlineMode.postValue(false);
        log("Offline mode disabled");
    }

    /* access modifiers changed from: private */
    public final void log(String str) {
        Timber.Forest.tag("Tiger WiFi").mo50214d(str, new Object[0]);
    }
}
