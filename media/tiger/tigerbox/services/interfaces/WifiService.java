package media.tiger.tigerbox.services.interfaces;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.model.domain.WifiStrength;

@Metadata(mo33736d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002'(J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001dH&J$\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00162\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\u0006\u0010\"\u001a\u00020#H&J\b\u0010$\u001a\u00020\u001dH&J\b\u0010%\u001a\u00020\u001dH&J\b\u0010&\u001a\u00020\u001dH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u000f\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\f¨\u0006)"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "", "ipAddress", "", "getIpAddress", "()Ljava/lang/String;", "macAddress", "getMacAddress", "offlineMode", "Landroidx/lifecycle/LiveData;", "", "getOfflineMode", "()Landroidx/lifecycle/LiveData;", "scanningInProgress", "getScanningInProgress", "wifiEnabled", "getWifiEnabled", "()Z", "setWifiEnabled", "(Z)V", "wifiNetworks", "", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "getWifiNetworks", "()Ljava/util/List;", "wifiSignalStrength", "Lmedia/tiger/tigerbox/model/domain/WifiStrength;", "getWifiSignalStrength", "cancelConnectionRequest", "", "confirmOfflineMode", "connect", "wifiItem", "password", "connectionCallback", "Lmedia/tiger/tigerbox/services/interfaces/WifiService$ConnectionCallback;", "forgetAllNetworks", "scanForWifiNetworks", "stopContinuousScan", "ConnectionCallback", "FailReason", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WifiService.kt */
public interface WifiService {

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/WifiService$ConnectionCallback;", "", "onConnecting", "", "wifiItemSSID", "", "onFail", "failReason", "Lmedia/tiger/tigerbox/services/interfaces/WifiService$FailReason;", "onSuccess", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: WifiService.kt */
    public interface ConnectionCallback {
        void onConnecting(String str);

        void onFail(FailReason failReason);

        void onSuccess();
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/WifiService$FailReason;", "", "(Ljava/lang/String;I)V", "NO_INTERNET", "AUTHENTICATION", "OTHER", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: WifiService.kt */
    public enum FailReason {
        NO_INTERNET,
        AUTHENTICATION,
        OTHER
    }

    void cancelConnectionRequest();

    void confirmOfflineMode();

    void connect(WifiItem wifiItem, String str, ConnectionCallback connectionCallback);

    void forgetAllNetworks();

    String getIpAddress();

    String getMacAddress();

    LiveData<Boolean> getOfflineMode();

    LiveData<Boolean> getScanningInProgress();

    boolean getWifiEnabled();

    List<WifiItem> getWifiNetworks();

    LiveData<WifiStrength> getWifiSignalStrength();

    void scanForWifiNetworks();

    void setWifiEnabled(boolean z);

    void stopContinuousScan();

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: WifiService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void connect$default(WifiService wifiService, WifiItem wifiItem, String str, ConnectionCallback connectionCallback, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                wifiService.connect(wifiItem, str, connectionCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: connect");
        }
    }
}
