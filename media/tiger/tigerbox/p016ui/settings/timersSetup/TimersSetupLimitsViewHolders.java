package media.tiger.tigerbox.p016ui.settings.timersSetup;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.databinding.ItemTimersLimitsCustomBinding;
import media.tiger.tigerbox.databinding.ItemTimersLimitsSpecificBinding;

@Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0001\u0002\u0007\b¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitsViewHolders;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TimersSetupCustomTimeLimitViewHolder", "TimersSetupSpecificTimeLimitViewHolder", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitsViewHolders$TimersSetupSpecificTimeLimitViewHolder;", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitsViewHolders$TimersSetupCustomTimeLimitViewHolder;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitsViewHolders */
/* compiled from: TimersSetupLimitsListAdapter.kt */
public abstract class TimersSetupLimitsViewHolders extends RecyclerView.ViewHolder {
    public /* synthetic */ TimersSetupLimitsViewHolders(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }

    private TimersSetupLimitsViewHolders(View view) {
        super(view);
    }

    @Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitsViewHolders$TimersSetupSpecificTimeLimitViewHolder;", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitsViewHolders;", "binding", "Lmedia/tiger/tigerbox/databinding/ItemTimersLimitsSpecificBinding;", "(Lmedia/tiger/tigerbox/databinding/ItemTimersLimitsSpecificBinding;)V", "getBinding", "()Lmedia/tiger/tigerbox/databinding/ItemTimersLimitsSpecificBinding;", "bind", "", "item", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSpecificTimeLimitItem;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitsViewHolders$TimersSetupSpecificTimeLimitViewHolder */
    /* compiled from: TimersSetupLimitsListAdapter.kt */
    public static final class TimersSetupSpecificTimeLimitViewHolder extends TimersSetupLimitsViewHolders {
        private final ItemTimersLimitsSpecificBinding binding;

        public final ItemTimersLimitsSpecificBinding getBinding() {
            return this.binding;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public TimersSetupSpecificTimeLimitViewHolder(media.tiger.tigerbox.databinding.ItemTimersLimitsSpecificBinding r3) {
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
            throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitsViewHolders.TimersSetupSpecificTimeLimitViewHolder.<init>(media.tiger.tigerbox.databinding.ItemTimersLimitsSpecificBinding):void");
        }

        public final void bind(TimersSpecificTimeLimitItem timersSpecificTimeLimitItem) {
            Intrinsics.checkNotNullParameter(timersSpecificTimeLimitItem, "item");
            this.binding.setTimersTimeLimitItem(timersSpecificTimeLimitItem);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitsViewHolders$TimersSetupCustomTimeLimitViewHolder;", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitsViewHolders;", "binding", "Lmedia/tiger/tigerbox/databinding/ItemTimersLimitsCustomBinding;", "(Lmedia/tiger/tigerbox/databinding/ItemTimersLimitsCustomBinding;)V", "getBinding", "()Lmedia/tiger/tigerbox/databinding/ItemTimersLimitsCustomBinding;", "bind", "", "item", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSpecificTimeLimitItem;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitsViewHolders$TimersSetupCustomTimeLimitViewHolder */
    /* compiled from: TimersSetupLimitsListAdapter.kt */
    public static final class TimersSetupCustomTimeLimitViewHolder extends TimersSetupLimitsViewHolders {
        private final ItemTimersLimitsCustomBinding binding;

        public final ItemTimersLimitsCustomBinding getBinding() {
            return this.binding;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public TimersSetupCustomTimeLimitViewHolder(media.tiger.tigerbox.databinding.ItemTimersLimitsCustomBinding r3) {
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
            throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitsViewHolders.TimersSetupCustomTimeLimitViewHolder.<init>(media.tiger.tigerbox.databinding.ItemTimersLimitsCustomBinding):void");
        }

        public final void bind(TimersSpecificTimeLimitItem timersSpecificTimeLimitItem) {
            Intrinsics.checkNotNullParameter(timersSpecificTimeLimitItem, "item");
            this.binding.setTimersTimeLimitItem(timersSpecificTimeLimitItem);
        }
    }
}
