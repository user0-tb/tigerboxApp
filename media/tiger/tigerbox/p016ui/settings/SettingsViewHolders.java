package media.tiger.tigerbox.p016ui.settings;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import media.tiger.tigerbox.databinding.ItemSettingsBinding;
import media.tiger.tigerbox.databinding.ItemSettingsCircleProgressBinding;

@Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0001\u0002\u0007\b¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsViewHolders;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "SettingsCircleProgressViewHolder", "SettingsItemViewHolder", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewHolders$SettingsCircleProgressViewHolder;", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewHolders$SettingsItemViewHolder;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewHolders */
/* compiled from: SettingsAdapter.kt */
public abstract class SettingsViewHolders extends RecyclerView.ViewHolder {
    public /* synthetic */ SettingsViewHolders(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }

    private SettingsViewHolders(View view) {
        super(view);
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsViewHolders$SettingsCircleProgressViewHolder;", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewHolders;", "binding", "Lmedia/tiger/tigerbox/databinding/ItemSettingsCircleProgressBinding;", "(Lmedia/tiger/tigerbox/databinding/ItemSettingsCircleProgressBinding;)V", "getBinding", "()Lmedia/tiger/tigerbox/databinding/ItemSettingsCircleProgressBinding;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewHolders$SettingsCircleProgressViewHolder */
    /* compiled from: SettingsAdapter.kt */
    public static final class SettingsCircleProgressViewHolder extends SettingsViewHolders {
        private final ItemSettingsCircleProgressBinding binding;

        public final ItemSettingsCircleProgressBinding getBinding() {
            return this.binding;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public SettingsCircleProgressViewHolder(media.tiger.tigerbox.databinding.ItemSettingsCircleProgressBinding r3) {
            /*
                r2 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                android.view.View r0 = r3.getRoot()
                java.lang.String r1 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                r1 = 0
                r2.<init>(r0, r1)
                r2.binding = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.settings.SettingsViewHolders.SettingsCircleProgressViewHolder.<init>(media.tiger.tigerbox.databinding.ItemSettingsCircleProgressBinding):void");
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsViewHolders$SettingsItemViewHolder;", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewHolders;", "binding", "Lmedia/tiger/tigerbox/databinding/ItemSettingsBinding;", "(Lmedia/tiger/tigerbox/databinding/ItemSettingsBinding;)V", "getBinding", "()Lmedia/tiger/tigerbox/databinding/ItemSettingsBinding;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewHolders$SettingsItemViewHolder */
    /* compiled from: SettingsAdapter.kt */
    public static final class SettingsItemViewHolder extends SettingsViewHolders {
        private final ItemSettingsBinding binding;

        public final ItemSettingsBinding getBinding() {
            return this.binding;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public SettingsItemViewHolder(media.tiger.tigerbox.databinding.ItemSettingsBinding r3) {
            /*
                r2 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                android.view.View r0 = r3.getRoot()
                java.lang.String r1 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                r1 = 0
                r2.<init>(r0, r1)
                r2.binding = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.settings.SettingsViewHolders.SettingsItemViewHolder.<init>(media.tiger.tigerbox.databinding.ItemSettingsBinding):void");
        }
    }
}
