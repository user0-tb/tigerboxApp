package media.tiger.tigerbox.model.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/WifiItem;", "", "bssid", "", "ssid", "wifiStrength", "Lmedia/tiger/tigerbox/model/domain/WifiStrength;", "securityMode", "Lmedia/tiger/tigerbox/model/domain/SecurityMode;", "connectionState", "Lmedia/tiger/tigerbox/model/domain/ConnectionState;", "isHeader", "", "(Ljava/lang/String;Ljava/lang/String;Lmedia/tiger/tigerbox/model/domain/WifiStrength;Lmedia/tiger/tigerbox/model/domain/SecurityMode;Lmedia/tiger/tigerbox/model/domain/ConnectionState;Z)V", "getBssid", "()Ljava/lang/String;", "getConnectionState", "()Lmedia/tiger/tigerbox/model/domain/ConnectionState;", "()Z", "isSecure", "getSecurityMode", "()Lmedia/tiger/tigerbox/model/domain/SecurityMode;", "getSsid", "getWifiStrength", "()Lmedia/tiger/tigerbox/model/domain/WifiStrength;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WifiItemDomain.kt */
public final class WifiItem {
    private final String bssid;
    private final ConnectionState connectionState;
    private final boolean isHeader;
    private final SecurityMode securityMode;
    private final String ssid;
    private final WifiStrength wifiStrength;

    public static /* synthetic */ WifiItem copy$default(WifiItem wifiItem, String str, String str2, WifiStrength wifiStrength2, SecurityMode securityMode2, ConnectionState connectionState2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wifiItem.bssid;
        }
        if ((i & 2) != 0) {
            str2 = wifiItem.ssid;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            wifiStrength2 = wifiItem.wifiStrength;
        }
        WifiStrength wifiStrength3 = wifiStrength2;
        if ((i & 8) != 0) {
            securityMode2 = wifiItem.securityMode;
        }
        SecurityMode securityMode3 = securityMode2;
        if ((i & 16) != 0) {
            connectionState2 = wifiItem.connectionState;
        }
        ConnectionState connectionState3 = connectionState2;
        if ((i & 32) != 0) {
            z = wifiItem.isHeader;
        }
        return wifiItem.copy(str, str3, wifiStrength3, securityMode3, connectionState3, z);
    }

    public final String component1() {
        return this.bssid;
    }

    public final String component2() {
        return this.ssid;
    }

    public final WifiStrength component3() {
        return this.wifiStrength;
    }

    public final SecurityMode component4() {
        return this.securityMode;
    }

    public final ConnectionState component5() {
        return this.connectionState;
    }

    public final boolean component6() {
        return this.isHeader;
    }

    public final WifiItem copy(String str, String str2, WifiStrength wifiStrength2, SecurityMode securityMode2, ConnectionState connectionState2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "bssid");
        Intrinsics.checkNotNullParameter(str2, "ssid");
        Intrinsics.checkNotNullParameter(wifiStrength2, "wifiStrength");
        Intrinsics.checkNotNullParameter(securityMode2, "securityMode");
        Intrinsics.checkNotNullParameter(connectionState2, "connectionState");
        return new WifiItem(str, str2, wifiStrength2, securityMode2, connectionState2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WifiItem)) {
            return false;
        }
        WifiItem wifiItem = (WifiItem) obj;
        return Intrinsics.areEqual((Object) this.bssid, (Object) wifiItem.bssid) && Intrinsics.areEqual((Object) this.ssid, (Object) wifiItem.ssid) && this.wifiStrength == wifiItem.wifiStrength && this.securityMode == wifiItem.securityMode && this.connectionState == wifiItem.connectionState && this.isHeader == wifiItem.isHeader;
    }

    public int hashCode() {
        int hashCode = ((((((((this.bssid.hashCode() * 31) + this.ssid.hashCode()) * 31) + this.wifiStrength.hashCode()) * 31) + this.securityMode.hashCode()) * 31) + this.connectionState.hashCode()) * 31;
        boolean z = this.isHeader;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "WifiItem(bssid=" + this.bssid + ", ssid=" + this.ssid + ", wifiStrength=" + this.wifiStrength + ", securityMode=" + this.securityMode + ", connectionState=" + this.connectionState + ", isHeader=" + this.isHeader + ')';
    }

    public WifiItem(String str, String str2, WifiStrength wifiStrength2, SecurityMode securityMode2, ConnectionState connectionState2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "bssid");
        Intrinsics.checkNotNullParameter(str2, "ssid");
        Intrinsics.checkNotNullParameter(wifiStrength2, "wifiStrength");
        Intrinsics.checkNotNullParameter(securityMode2, "securityMode");
        Intrinsics.checkNotNullParameter(connectionState2, "connectionState");
        this.bssid = str;
        this.ssid = str2;
        this.wifiStrength = wifiStrength2;
        this.securityMode = securityMode2;
        this.connectionState = connectionState2;
        this.isHeader = z;
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public final WifiStrength getWifiStrength() {
        return this.wifiStrength;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WifiItem(String str, String str2, WifiStrength wifiStrength2, SecurityMode securityMode2, ConnectionState connectionState2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, wifiStrength2, (i & 8) != 0 ? SecurityMode.OPEN : securityMode2, (i & 16) != 0 ? ConnectionState.NOT_CONNECTED : connectionState2, (i & 32) != 0 ? false : z);
    }

    public final SecurityMode getSecurityMode() {
        return this.securityMode;
    }

    public final ConnectionState getConnectionState() {
        return this.connectionState;
    }

    public final boolean isHeader() {
        return this.isHeader;
    }

    public final boolean isSecure() {
        return this.securityMode != SecurityMode.OPEN;
    }
}
