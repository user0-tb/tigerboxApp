package media.tiger.tigerbox.p016ui.common.wifi;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.databinding.ItemWifiListBinding;
import media.tiger.tigerbox.model.domain.ConnectionState;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiListAdapter$WifiItemViewHolder;", "onClick", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "(Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "WifiItemViewHolder", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiListAdapter */
/* compiled from: WifiListAdapter.kt */
public final class WifiListAdapter extends ListAdapter<WifiItem, WifiItemViewHolder> {
    private final BindingClickListener<WifiItem> onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WifiListAdapter(BindingClickListener<WifiItem> bindingClickListener) {
        super(new WifiItemDiffCallback());
        Intrinsics.checkNotNullParameter(bindingClickListener, "onClick");
        this.onClick = bindingClickListener;
    }

    public WifiItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return WifiItemViewHolder.Companion.createFrom(viewGroup);
    }

    public void onBindViewHolder(WifiItemViewHolder wifiItemViewHolder, int i) {
        Intrinsics.checkNotNullParameter(wifiItemViewHolder, "holder");
        WifiItem wifiItem = (WifiItem) getItem(i);
        Intrinsics.checkNotNullExpressionValue(wifiItem, "item");
        wifiItemViewHolder.bind(wifiItem, this.onClick);
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiListAdapter$WifiItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lmedia/tiger/tigerbox/databinding/ItemWifiListBinding;", "(Lmedia/tiger/tigerbox/databinding/ItemWifiListBinding;)V", "bind", "", "item", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "onClick", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiListAdapter$WifiItemViewHolder */
    /* compiled from: WifiListAdapter.kt */
    public static final class WifiItemViewHolder extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final ItemWifiListBinding binding;

        @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiListAdapter$WifiItemViewHolder$WhenMappings */
        /* compiled from: WifiListAdapter.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ConnectionState.values().length];
                iArr[ConnectionState.CONNECTING.ordinal()] = 1;
                iArr[ConnectionState.CONNECTED.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WifiItemViewHolder(ItemWifiListBinding itemWifiListBinding) {
            super(itemWifiListBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemWifiListBinding, "binding");
            this.binding = itemWifiListBinding;
        }

        @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiListAdapter$WifiItemViewHolder$Companion;", "", "()V", "createFrom", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiListAdapter$WifiItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiListAdapter$WifiItemViewHolder$Companion */
        /* compiled from: WifiListAdapter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final WifiItemViewHolder createFrom(ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                ItemWifiListBinding inflate = ItemWifiListBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …lse\n                    )");
                return new WifiItemViewHolder(inflate);
            }
        }

        public final void bind(WifiItem wifiItem, BindingClickListener<WifiItem> bindingClickListener) {
            Intrinsics.checkNotNullParameter(wifiItem, "item");
            Intrinsics.checkNotNullParameter(bindingClickListener, "onClick");
            ItemWifiListBinding itemWifiListBinding = this.binding;
            itemWifiListBinding.setWifiItem(wifiItem);
            int i = WhenMappings.$EnumSwitchMapping$0[wifiItem.getConnectionState().ordinal()];
            if (i == 1) {
                itemWifiListBinding.wifiListItemConnectedIcon.setVisibility(4);
                itemWifiListBinding.wifiListItemConnectingIcon.setVisibility(0);
            } else if (i != 2) {
                itemWifiListBinding.wifiListItemConnectedIcon.setVisibility(4);
                itemWifiListBinding.wifiListItemConnectingIcon.setVisibility(4);
            } else {
                itemWifiListBinding.wifiListItemConnectedIcon.setVisibility(0);
                itemWifiListBinding.wifiListItemConnectingIcon.setVisibility(4);
            }
            itemWifiListBinding.setClickListener(bindingClickListener);
        }
    }
}
