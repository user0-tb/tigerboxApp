package media.tiger.tigerbox.p016ui.common.wifi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.ConnectionState;
import media.tiger.tigerbox.model.domain.SecurityMode;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.model.domain.WifiItemDomainKt;
import media.tiger.tigerbox.model.domain.WifiStrength;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel;
import media.tiger.tigerbox.services.interfaces.WifiService;

@Metadata(mo33736d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, mo33737d2 = {"media/tiger/tigerbox/ui/common/wifi/WifiViewModel$connectionCallback$1", "Lmedia/tiger/tigerbox/services/interfaces/WifiService$ConnectionCallback;", "onConnecting", "", "wifiItemSSID", "", "onFail", "failReason", "Lmedia/tiger/tigerbox/services/interfaces/WifiService$FailReason;", "onSuccess", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$connectionCallback$1 */
/* compiled from: WifiViewModel.kt */
public final class WifiViewModel$connectionCallback$1 implements WifiService.ConnectionCallback {
    final /* synthetic */ WifiViewModel this$0;

    WifiViewModel$connectionCallback$1(WifiViewModel wifiViewModel) {
        this.this$0 = wifiViewModel;
    }

    public void onSuccess() {
        this.this$0.wifiConnectionSuccessHandler();
    }

    public void onFail(WifiService.FailReason failReason) {
        Intrinsics.checkNotNullParameter(failReason, "failReason");
        this.this$0.wifiConnectionFailureHandler(failReason);
    }

    public void onConnecting(String str) {
        Intrinsics.checkNotNullParameter(str, "wifiItemSSID");
        Iterable<WifiItem> wifiNetworks = this.this$0.wifiService.getWifiNetworks();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(wifiNetworks, 10));
        for (WifiItem wifiItem : wifiNetworks) {
            arrayList.add(WifiItem.copy$default(wifiItem, (String) null, (String) null, (WifiStrength) null, (SecurityMode) null, Intrinsics.areEqual((Object) str, (Object) wifiItem.getSsid()) ? ConnectionState.CONNECTING : ConnectionState.NOT_CONNECTED, false, 47, (Object) null));
        }
        this.this$0._viewState.setValue(new WifiViewModel.ViewState.ShowNetworks(WifiItemDomainKt.toSorted((List) arrayList)));
    }
}
