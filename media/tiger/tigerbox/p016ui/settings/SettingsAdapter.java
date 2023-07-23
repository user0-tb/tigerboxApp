package media.tiger.tigerbox.p016ui.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.ItemSettingsBinding;
import media.tiger.tigerbox.databinding.ItemSettingsCircleProgressBinding;
import media.tiger.tigerbox.p016ui.settings.SettingsViewHolders;

@Metadata(mo33736d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0014\u0010\u001b\u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\fX\u0004¢\u0006\u0002\n\u0000R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewHolders;", "itemsList", "", "Lmedia/tiger/tigerbox/ui/settings/SettingsItemData;", "clickListener", "Lkotlin/Function3;", "", "", "", "itemSelected", "Lkotlin/Function1;", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "getItemsList", "()Ljava/util/List;", "setItemsList", "(Ljava/util/List;)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "data", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsAdapter */
/* compiled from: SettingsAdapter.kt */
public final class SettingsAdapter extends RecyclerView.Adapter<SettingsViewHolders> {
    private final Function3<Integer, SettingsItemData, Boolean, Unit> clickListener;
    private final Function1<SettingsItemData, Boolean> itemSelected;
    private List<? extends SettingsItemData> itemsList;

    public final List<SettingsItemData> getItemsList() {
        return this.itemsList;
    }

    public final void setItemsList(List<? extends SettingsItemData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.itemsList = list;
    }

    public SettingsAdapter(List<? extends SettingsItemData> list, Function3<? super Integer, ? super SettingsItemData, ? super Boolean, Unit> function3, Function1<? super SettingsItemData, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "itemsList");
        Intrinsics.checkNotNullParameter(function3, "clickListener");
        Intrinsics.checkNotNullParameter(function1, "itemSelected");
        this.itemsList = list;
        this.clickListener = function3;
        this.itemSelected = function1;
    }

    public SettingsViewHolders onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case C2814R.C2819layout.item_settings:
                ItemSettingsBinding inflate = ItemSettingsBinding.inflate(from, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, parent, false)");
                return new SettingsViewHolders.SettingsItemViewHolder(inflate);
            case C2814R.C2819layout.item_settings_circle_progress:
                ItemSettingsCircleProgressBinding inflate2 = ItemSettingsCircleProgressBinding.inflate(from, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(inflater, parent, false)");
                return new SettingsViewHolders.SettingsCircleProgressViewHolder(inflate2);
            default:
                throw new IllegalStateException("Unknown viewType " + i);
        }
    }

    public void onBindViewHolder(SettingsViewHolders settingsViewHolders, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(settingsViewHolders, "holder");
        if (settingsViewHolders instanceof SettingsViewHolders.SettingsCircleProgressViewHolder) {
            SettingsCircleProgressItemData settingsCircleProgressItemData = (SettingsCircleProgressItemData) this.itemsList.get(i);
            ItemSettingsCircleProgressBinding binding = ((SettingsViewHolders.SettingsCircleProgressViewHolder) settingsViewHolders).getBinding();
            binding.setItem(settingsCircleProgressItemData);
            binding.itemIcon.setEnabled(false);
            if (settingsCircleProgressItemData.getProgress() == -1) {
                binding.itemIcon.setEnabled(this.itemSelected.invoke(settingsCircleProgressItemData).booleanValue());
                binding.itemIcon.setSelected(false);
                binding.itemIcon.setProgress(0);
                binding.itemIcon.setText(" ");
            } else {
                binding.itemIcon.setProgress(settingsCircleProgressItemData.getProgress());
                binding.itemIcon.setText(settingsCircleProgressItemData.getCircleItemText());
                binding.itemIcon.setSelected(this.itemSelected.invoke(settingsCircleProgressItemData).booleanValue());
            }
            TextView textView = binding.itemTitle;
            if (this.itemSelected.invoke(settingsCircleProgressItemData).booleanValue()) {
                i2 = binding.itemTitle.getResources().getColor(C2814R.C2815color.settings_item_title_selected_color);
            } else {
                i2 = binding.itemTitle.getResources().getColor(C2814R.C2815color.settings_item_title_color);
            }
            textView.setTextColor(i2);
            binding.getRoot().setOnClickListener(new SettingsAdapter$$ExternalSyntheticLambda0(this, i, settingsCircleProgressItemData));
            binding.getRoot().setOnLongClickListener(new SettingsAdapter$$ExternalSyntheticLambda2(this, i, settingsCircleProgressItemData));
        } else if (settingsViewHolders instanceof SettingsViewHolders.SettingsItemViewHolder) {
            SettingsItemData settingsItemData = (SettingsItemData) this.itemsList.get(i);
            ItemSettingsBinding binding2 = ((SettingsViewHolders.SettingsItemViewHolder) settingsViewHolders).getBinding();
            binding2.setItem(settingsItemData);
            binding2.setSelected(this.itemSelected.invoke(settingsItemData));
            binding2.itemIcon.setSelected(this.itemSelected.invoke(settingsItemData).booleanValue());
            binding2.getRoot().setOnClickListener(new SettingsAdapter$$ExternalSyntheticLambda1(this, i, settingsItemData));
            binding2.getRoot().setOnLongClickListener(new SettingsAdapter$$ExternalSyntheticLambda3(this, i, settingsItemData));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-2$lambda-0  reason: not valid java name */
    public static final void m2506onBindViewHolder$lambda2$lambda0(SettingsAdapter settingsAdapter, int i, SettingsCircleProgressItemData settingsCircleProgressItemData, View view) {
        Intrinsics.checkNotNullParameter(settingsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(settingsCircleProgressItemData, "$settingsItem");
        settingsAdapter.clickListener.invoke(Integer.valueOf(i), settingsCircleProgressItemData, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-2$lambda-1  reason: not valid java name */
    public static final boolean m2507onBindViewHolder$lambda2$lambda1(SettingsAdapter settingsAdapter, int i, SettingsCircleProgressItemData settingsCircleProgressItemData, View view) {
        Intrinsics.checkNotNullParameter(settingsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(settingsCircleProgressItemData, "$settingsItem");
        settingsAdapter.clickListener.invoke(Integer.valueOf(i), settingsCircleProgressItemData, true);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-5$lambda-3  reason: not valid java name */
    public static final void m2508onBindViewHolder$lambda5$lambda3(SettingsAdapter settingsAdapter, int i, SettingsItemData settingsItemData, View view) {
        Intrinsics.checkNotNullParameter(settingsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(settingsItemData, "$settingsItem");
        settingsAdapter.clickListener.invoke(Integer.valueOf(i), settingsItemData, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-5$lambda-4  reason: not valid java name */
    public static final boolean m2509onBindViewHolder$lambda5$lambda4(SettingsAdapter settingsAdapter, int i, SettingsItemData settingsItemData, View view) {
        Intrinsics.checkNotNullParameter(settingsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(settingsItemData, "$settingsItem");
        settingsAdapter.clickListener.invoke(Integer.valueOf(i), settingsItemData, true);
        return true;
    }

    public final void updateData(List<? extends SettingsItemData> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.itemsList = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.itemsList.size();
    }

    public int getItemViewType(int i) {
        return ((SettingsItemData) this.itemsList.get(i)) instanceof SettingsCircleProgressItemData ? C2814R.C2819layout.item_settings_circle_progress : C2814R.C2819layout.item_settings;
    }
}
