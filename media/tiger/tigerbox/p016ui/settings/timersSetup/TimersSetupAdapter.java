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
import media.tiger.tigerbox.databinding.ItemTimersSetupClickableTitleBinding;
import media.tiger.tigerbox.databinding.ItemTimersSetupClickableValueBinding;
import media.tiger.tigerbox.databinding.ItemTimersSetupTitleBinding;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupViewHolders;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupViewHolders;", "itemsList", "Lkotlin/Function0;", "", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupItem;", "clickListener", "Lkotlin/Function2;", "", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupAdapter */
/* compiled from: TimersSetupAdapter.kt */
public final class TimersSetupAdapter extends RecyclerView.Adapter<TimersSetupViewHolders> {
    private final Function2<Integer, TimersSetupItem, Unit> clickListener;
    private Function0<? extends List<? extends TimersSetupItem>> itemsList;

    public TimersSetupAdapter(Function0<? extends List<? extends TimersSetupItem>> function0, Function2<? super Integer, ? super TimersSetupItem, Unit> function2) {
        Intrinsics.checkNotNullParameter(function0, "itemsList");
        Intrinsics.checkNotNullParameter(function2, "clickListener");
        this.itemsList = function0;
        this.clickListener = function2;
    }

    public TimersSetupViewHolders onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case C2814R.C2819layout.item_timers_setup_clickable_title:
                ItemTimersSetupClickableTitleBinding inflate = ItemTimersSetupClickableTitleBinding.inflate(from, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, parent, false)");
                return new TimersSetupViewHolders.TimersSetupCliclableTitleViewHolder(inflate);
            case C2814R.C2819layout.item_timers_setup_clickable_value:
                ItemTimersSetupClickableValueBinding inflate2 = ItemTimersSetupClickableValueBinding.inflate(from, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(inflater, parent, false)");
                return new TimersSetupViewHolders.TimersSetupCliclableValueViewHolder(inflate2);
            case C2814R.C2819layout.item_timers_setup_title:
                ItemTimersSetupTitleBinding inflate3 = ItemTimersSetupTitleBinding.inflate(from, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(inflater, parent, false)");
                return new TimersSetupViewHolders.TimersSetupTitleViewHolder(inflate3);
            default:
                throw new IllegalStateException("Unknown viewType " + i);
        }
    }

    public int getItemViewType(int i) {
        TimersSetupItem timersSetupItem = (TimersSetupItem) ((List) this.itemsList.invoke()).get(i);
        if (timersSetupItem instanceof TimersSetupAddWindowItem) {
            return C2814R.C2819layout.item_timers_setup_clickable_title;
        }
        if (!(timersSetupItem instanceof TimersSetupLimitItem) && !(timersSetupItem instanceof TimersSetupSleepItem) && !(timersSetupItem instanceof TimersSetupWindowItem)) {
            return C2814R.C2819layout.item_timers_setup_title;
        }
        return C2814R.C2819layout.item_timers_setup_clickable_value;
    }

    public int getItemCount() {
        return ((List) this.itemsList.invoke()).size();
    }

    public void onBindViewHolder(TimersSetupViewHolders timersSetupViewHolders, int i) {
        Intrinsics.checkNotNullParameter(timersSetupViewHolders, "holder");
        TimersSetupItem timersSetupItem = (TimersSetupItem) ((List) this.itemsList.invoke()).get(i);
        if (timersSetupViewHolders instanceof TimersSetupViewHolders.TimersSetupTitleViewHolder) {
            ((TimersSetupViewHolders.TimersSetupTitleViewHolder) timersSetupViewHolders).getBinding().setTimersSetupItem(timersSetupItem);
        } else if (timersSetupViewHolders instanceof TimersSetupViewHolders.TimersSetupCliclableTitleViewHolder) {
            ItemTimersSetupClickableTitleBinding binding = ((TimersSetupViewHolders.TimersSetupCliclableTitleViewHolder) timersSetupViewHolders).getBinding();
            binding.setTimersSetupItem(timersSetupItem);
            binding.getRoot().setOnClickListener(new TimersSetupAdapter$$ExternalSyntheticLambda1(this, i, timersSetupItem));
        } else if (timersSetupViewHolders instanceof TimersSetupViewHolders.TimersSetupCliclableValueViewHolder) {
            ItemTimersSetupClickableValueBinding binding2 = ((TimersSetupViewHolders.TimersSetupCliclableValueViewHolder) timersSetupViewHolders).getBinding();
            binding2.setTimersSetupItem(timersSetupItem);
            binding2.getRoot().setOnClickListener(new TimersSetupAdapter$$ExternalSyntheticLambda0(this, i, timersSetupItem));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-2$lambda-1  reason: not valid java name */
    public static final void m2550onBindViewHolder$lambda2$lambda1(TimersSetupAdapter timersSetupAdapter, int i, TimersSetupItem timersSetupItem, View view) {
        Intrinsics.checkNotNullParameter(timersSetupAdapter, "this$0");
        Intrinsics.checkNotNullParameter(timersSetupItem, "$aItem");
        timersSetupAdapter.clickListener.invoke(Integer.valueOf(i), timersSetupItem);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-4$lambda-3  reason: not valid java name */
    public static final void m2551onBindViewHolder$lambda4$lambda3(TimersSetupAdapter timersSetupAdapter, int i, TimersSetupItem timersSetupItem, View view) {
        Intrinsics.checkNotNullParameter(timersSetupAdapter, "this$0");
        Intrinsics.checkNotNullParameter(timersSetupItem, "$aItem");
        timersSetupAdapter.clickListener.invoke(Integer.valueOf(i), timersSetupItem);
    }
}
