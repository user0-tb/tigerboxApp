package p012io.shipbook.shipbooksdk;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/BroadcastNames;", "", "()V", "CONFIG_CHANGE", "", "getCONFIG_CHANGE", "()Ljava/lang/String;", "CONNECTED", "getCONNECTED", "USER_CHANGE", "getUSER_CHANGE", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.BroadcastNames */
/* compiled from: BroadcastNames.kt */
public final class BroadcastNames {
    private static final String CONFIG_CHANGE = "io.shipbook.ShipBookSDK.config";
    private static final String CONNECTED = "io.shipbook.ShipBookSDK.connected";
    public static final BroadcastNames INSTANCE = new BroadcastNames();
    private static final String USER_CHANGE = "io.shipbook.ShipBookSDK.user";

    private BroadcastNames() {
    }

    public final String getCONFIG_CHANGE() {
        return CONFIG_CHANGE;
    }

    public final String getCONNECTED() {
        return CONNECTED;
    }

    public final String getUSER_CHANGE() {
        return USER_CHANGE;
    }
}
