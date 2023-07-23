package media.tiger.tigerbox.p016ui.settings.timersSetup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.ItemTimersLimitsCustomBinding;
import media.tiger.tigerbox.databinding.ItemTimersLimitsSpecificBinding;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitsViewHolders;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitsListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitsViewHolders;", "itemsList", "Lkotlin/Function0;", "", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersTimeLimitItem;", "clickListener", "Lkotlin/Function2;", "", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitsListAdapter */
/* compiled from: TimersSetupLimitsListAdapter.kt */
public final class TimersSetupLimitsListAdapter extends RecyclerView.Adapter<TimersSetupLimitsViewHolders> {
    private final Function2<Integer, TimersTimeLimitItem, Unit> clickListener;
    private Function0<? extends List<? extends TimersTimeLimitItem>> itemsList;

    public TimersSetupLimitsListAdapter(Function0<? extends List<? extends TimersTimeLimitItem>> function0, Function2<? super Integer, ? super TimersTimeLimitItem, Unit> function2) {
        Intrinsics.checkNotNullParameter(function0, "itemsList");
        Intrinsics.checkNotNullParameter(function2, "clickListener");
        this.itemsList = function0;
        this.clickListener = function2;
    }

    public TimersSetupLimitsViewHolders onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i == C2814R.C2819layout.item_timers_limits_custom) {
            ItemTimersLimitsCustomBinding inflate = ItemTimersLimitsCustomBinding.inflate(from, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, parent, false)");
            return new TimersSetupLimitsViewHolders.TimersSetupCustomTimeLimitViewHolder(inflate);
        } else if (i == C2814R.C2819layout.item_timers_limits_specific) {
            ItemTimersLimitsSpecificBinding inflate2 = ItemTimersLimitsSpecificBinding.inflate(from, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(inflater, parent, false)");
            return new TimersSetupLimitsViewHolders.TimersSetupSpecificTimeLimitViewHolder(inflate2);
        } else {
            throw new IllegalStateException("Unknown viewType " + i);
        }
    }

    public int getItemViewType(int i) {
        TimersTimeLimitItem timersTimeLimitItem = (TimersTimeLimitItem) ((List) this.itemsList.invoke()).get(i);
        if (!(timersTimeLimitItem instanceof TimersSpecificTimeLimitItem) && (timersTimeLimitItem instanceof TimersCustomTimeLimitItem)) {
            return C2814R.C2819layout.item_timers_limits_custom;
        }
        return C2814R.C2819layout.item_timers_limits_specific;
    }

    public int getItemCount() {
        return ((List) this.itemsList.invoke()).size();
    }

    public void onBindViewHolder(TimersSetupLimitsViewHolders timersSetupLimitsViewHolders, int i) {
        Intrinsics.checkNotNullParameter(timersSetupLimitsViewHolders, "holder");
        TimersTimeLimitItem timersTimeLimitItem = (TimersTimeLimitItem) ((List) this.itemsList.invoke()).get(i);
        if (timersSetupLimitsViewHolders instanceof TimersSetupLimitsViewHolders.TimersSetupSpecificTimeLimitViewHolder) {
            ItemTimersLimitsSpecificBinding binding = ((TimersSetupLimitsViewHolders.TimersSetupSpecificTimeLimitViewHolder) timersSetupLimitsViewHolders).getBinding();
            binding.setTimersTimeLimitItem(timersTimeLimitItem);
            binding.getRoot().setOnClickListener(new TimersSetupLimitsListAdapter$$ExternalSyntheticLambda1(this, i, timersTimeLimitItem));
        } else if (timersSetupLimitsViewHolders instanceof TimersSetupLimitsViewHolders.TimersSetupCustomTimeLimitViewHolder) {
            ItemTimersLimitsCustomBinding binding2 = ((TimersSetupLimitsViewHolders.TimersSetupCustomTimeLimitViewHolder) timersSetupLimitsViewHolders).getBinding();
            binding2.setTimersTimeLimitItem(timersTimeLimitItem);
            binding2.getRoot().setOnClickListener(new TimersSetupLimitsListAdapter$$ExternalSyntheticLambda0(this, i, timersTimeLimitItem));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2556onBindViewHolder$lambda1$lambda0(TimersSetupLimitsListAdapter timersSetupLimitsListAdapter, int i, TimersTimeLimitItem timersTimeLimitItem, View view) {
        Intrinsics.checkNotNullParameter(timersSetupLimitsListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(timersTimeLimitItem, "$aItem");
        timersSetupLimitsListAdapter.clickListener.invoke(Integer.valueOf(i), timersTimeLimitItem);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-3$lambda-2  reason: not valid java name */
    public static final void m2557onBindViewHolder$lambda3$lambda2(TimersSetupLimitsListAdapter timersSetupLimitsListAdapter, int i, TimersTimeLimitItem timersTimeLimitItem, View view) {
        Intrinsics.checkNotNullParameter(timersSetupLimitsListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(timersTimeLimitItem, "$aItem");
        timersSetupLimitsListAdapter.clickListener.invoke(Integer.valueOf(i), timersTimeLimitItem);
    }
}
