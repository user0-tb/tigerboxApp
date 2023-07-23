package media.tiger.tigerbox.p016ui.settings.timersSetup;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersTimeLimitItem;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupFragment$itemsList$1 */
/* compiled from: TimersSetupLimitSetupFragment.kt */
final class TimersSetupLimitSetupFragment$itemsList$1 extends Lambda implements Function0<List<? extends TimersTimeLimitItem>> {
    final /* synthetic */ TimersSetupLimitSetupFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimersSetupLimitSetupFragment$itemsList$1(TimersSetupLimitSetupFragment timersSetupLimitSetupFragment) {
        super(0);
        this.this$0 = timersSetupLimitSetupFragment;
    }

    public final List<TimersTimeLimitItem> invoke() {
        return this.this$0.getTimerLimitViewModel().getItemsList();
    }
}
