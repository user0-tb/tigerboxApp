package media.tiger.tigerbox.p016ui.settings.systeminfo;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.databinding.ItemSystemInfoBinding;

@Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoItem;", "Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoAdapter$SystemInfoItemViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SystemInfoItemViewHolder", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoAdapter */
/* compiled from: SystemInfoAdapter.kt */
public final class SystemInfoAdapter extends ListAdapter<SystemInfoItem, SystemInfoItemViewHolder> {
    public SystemInfoAdapter() {
        super(SystemInfoRowDiffCallback.INSTANCE);
    }

    public SystemInfoItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return SystemInfoItemViewHolder.Companion.createFrom(viewGroup);
    }

    public void onBindViewHolder(SystemInfoItemViewHolder systemInfoItemViewHolder, int i) {
        Intrinsics.checkNotNullParameter(systemInfoItemViewHolder, "holder");
        Object item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        systemInfoItemViewHolder.bind((SystemInfoItem) item);
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoAdapter$SystemInfoItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lmedia/tiger/tigerbox/databinding/ItemSystemInfoBinding;", "(Lmedia/tiger/tigerbox/databinding/ItemSystemInfoBinding;)V", "bind", "", "item", "Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoItem;", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoAdapter$SystemInfoItemViewHolder */
    /* compiled from: SystemInfoAdapter.kt */
    public static final class SystemInfoItemViewHolder extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final ItemSystemInfoBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SystemInfoItemViewHolder(ItemSystemInfoBinding itemSystemInfoBinding) {
            super(itemSystemInfoBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemSystemInfoBinding, "binding");
            this.binding = itemSystemInfoBinding;
        }

        @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoAdapter$SystemInfoItemViewHolder$Companion;", "", "()V", "createFrom", "Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoAdapter$SystemInfoItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoAdapter$SystemInfoItemViewHolder$Companion */
        /* compiled from: SystemInfoAdapter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final SystemInfoItemViewHolder createFrom(ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                ItemSystemInfoBinding inflate = ItemSystemInfoBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …lse\n                    )");
                return new SystemInfoItemViewHolder(inflate);
            }
        }

        public final void bind(SystemInfoItem systemInfoItem) {
            Intrinsics.checkNotNullParameter(systemInfoItem, "item");
            this.binding.setSystemInfoItem(systemInfoItem);
        }
    }
}
