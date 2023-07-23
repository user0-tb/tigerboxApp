package media.tiger.tigerbox.p016ui.settings.timersSetup;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.C2814R;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersTimeLimitItem;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel$itemsList$2 */
/* compiled from: TimersSetupLimitSetupViewModel.kt */
final class TimersSetupLimitSetupViewModel$itemsList$2 extends Lambda implements Function0<List<TimersTimeLimitItem>> {
    final /* synthetic */ TimersSetupLimitSetupViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimersSetupLimitSetupViewModel$itemsList$2(TimersSetupLimitSetupViewModel timersSetupLimitSetupViewModel) {
        super(0);
        this.this$0 = timersSetupLimitSetupViewModel;
    }

    public final List<TimersTimeLimitItem> invoke() {
        List<TimersTimeLimitItem> arrayList = new ArrayList<>();
        boolean z = true;
        if (this.this$0.isSleepTimer()) {
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_turn_off, this.this$0.getSleepTimeSeconds() == 0));
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_sleep_end_of_product, this.this$0.getSleepTimeSeconds() == -1));
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_sleep_5_minutes, this.this$0.getSleepTimeSeconds() == 300));
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_sleep_10_minutes, this.this$0.getSleepTimeSeconds() == 600));
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_sleep_15_minutes, this.this$0.getSleepTimeSeconds() == 900));
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_sleep_20_minutes, this.this$0.getSleepTimeSeconds() == 1200));
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_sleep_30_minutes, this.this$0.getSleepTimeSeconds() == 1800));
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_sleep_40_minutes, this.this$0.getSleepTimeSeconds() == 2400));
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_sleep_50_minutes, this.this$0.getSleepTimeSeconds() == 3000));
            if (this.this$0.getSleepTimeSeconds() != 3600) {
                z = false;
            }
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_sleep_1_hour, z));
            arrayList.add(new TimersCustomTimeLimitItem(C2814R.string.settings_timers_limit_custom, this.this$0.isCustomTime()));
        } else {
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_turn_off, this.this$0.getLimitSeconds() == -1));
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_limit_0_5_hours, this.this$0.getLimitSeconds() == 1800));
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_limit_1_hour, this.this$0.getLimitSeconds() == 3600));
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_limit_1_5_hours, this.this$0.getLimitSeconds() == 5400));
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_limit_2_hours, this.this$0.getLimitSeconds() == 7200));
            if (this.this$0.getLimitSeconds() != 9000) {
                z = false;
            }
            arrayList.add(new TimersSpecificTimeLimitItem(C2814R.string.settings_timers_limit_2_5_hours, z));
            arrayList.add(new TimersCustomTimeLimitItem(C2814R.string.settings_timers_limit_custom, this.this$0.isCustomTime()));
        }
        return arrayList;
    }
}
