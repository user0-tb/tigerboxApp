package media.tiger.tigerbox.p016ui.settings;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo33737d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.FullScreenSeekBarFragment$_maxValue$2 */
/* compiled from: FullScreenSeekBarFragment.kt */
final class FullScreenSeekBarFragment$_maxValue$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ FullScreenSeekBarFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FullScreenSeekBarFragment$_maxValue$2(FullScreenSeekBarFragment fullScreenSeekBarFragment) {
        super(0);
        this.this$0 = fullScreenSeekBarFragment;
    }

    public final Integer invoke() {
        return Integer.valueOf(this.this$0.getArgs().getSeekBarType().getMaxValue());
    }
}
