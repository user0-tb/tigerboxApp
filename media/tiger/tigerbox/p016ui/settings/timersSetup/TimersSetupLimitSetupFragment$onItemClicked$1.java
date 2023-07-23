package media.tiger.tigerbox.p016ui.settings.timersSetup;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "index", "", "item", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersTimeLimitItem;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupFragment$onItemClicked$1 */
/* compiled from: TimersSetupLimitSetupFragment.kt */
final class TimersSetupLimitSetupFragment$onItemClicked$1 extends Lambda implements Function2<Integer, TimersTimeLimitItem, Unit> {
    final /* synthetic */ TimersSetupLimitSetupFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimersSetupLimitSetupFragment$onItemClicked$1(TimersSetupLimitSetupFragment timersSetupLimitSetupFragment) {
        super(2);
        this.this$0 = timersSetupLimitSetupFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (TimersTimeLimitItem) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, TimersTimeLimitItem timersTimeLimitItem) {
        Intrinsics.checkNotNullParameter(timersTimeLimitItem, "item");
        int size = this.this$0.getTimerLimitViewModel().getItemsList().size();
        for (int i2 = 0; i2 < size; i2++) {
            TimersTimeLimitItem timersTimeLimitItem2 = this.this$0.getTimerLimitViewModel().getItemsList().get(i2);
            if (timersTimeLimitItem2.getSelected()) {
                timersTimeLimitItem2.setSelected(false);
                RecyclerView.Adapter adapter = this.this$0.getBinding().timersLimitRecyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyItemChanged(i2);
                }
            }
        }
        timersTimeLimitItem.setSelected(true);
        if (timersTimeLimitItem instanceof TimersSpecificTimeLimitItem) {
            this.this$0.getBinding().hmPicker.setVisibility(8);
        } else if (timersTimeLimitItem instanceof TimersCustomTimeLimitItem) {
            this.this$0.getBinding().hmPicker.setVisibility(0);
        }
        RecyclerView.Adapter adapter2 = this.this$0.getBinding().timersLimitRecyclerView.getAdapter();
        if (adapter2 != null) {
            adapter2.notifyItemChanged(i);
        }
    }
}
