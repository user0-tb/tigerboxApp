package media.tiger.tigerbox.p016ui.settings.timersSetup;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "index", "", "item", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupItem;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupFragment$onItemClicked$1 */
/* compiled from: TimersSetupFragment.kt */
final class TimersSetupFragment$onItemClicked$1 extends Lambda implements Function2<Integer, TimersSetupItem, Unit> {
    final /* synthetic */ TimersSetupFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimersSetupFragment$onItemClicked$1(TimersSetupFragment timersSetupFragment) {
        super(2);
        this.this$0 = timersSetupFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (TimersSetupItem) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, TimersSetupItem timersSetupItem) {
        Intrinsics.checkNotNullParameter(timersSetupItem, "item");
        if (timersSetupItem instanceof TimersSetupLimitItem) {
            this.this$0.showSetupLimitTimer((TimersSetupLimitItem) timersSetupItem);
        } else if (timersSetupItem instanceof TimersSetupSleepItem) {
            this.this$0.showSetupSleepTimer((TimersSetupSleepItem) timersSetupItem);
        } else if (timersSetupItem instanceof TimersSetupAddWindowItem) {
            this.this$0.showSetupWindowTimer((TimersSetupWindowItem) null);
        } else if (timersSetupItem instanceof TimersSetupWindowItem) {
            this.this$0.showSetupWindowTimer((TimersSetupWindowItem) timersSetupItem);
        }
    }
}
