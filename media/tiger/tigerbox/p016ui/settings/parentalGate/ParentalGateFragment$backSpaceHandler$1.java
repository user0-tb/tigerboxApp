package media.tiger.tigerbox.p016ui.settings.parentalGate;

import kotlin.Metadata;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo33737d2 = {"media/tiger/tigerbox/ui/settings/parentalGate/ParentalGateFragment$backSpaceHandler$1", "Lmedia/tiger/tigerbox/ui/binding/UnTypedBindingClickListener;", "onClick", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateFragment$backSpaceHandler$1 */
/* compiled from: ParentalGateFragment.kt */
public final class ParentalGateFragment$backSpaceHandler$1 implements UnTypedBindingClickListener {
    final /* synthetic */ ParentalGateFragment this$0;

    ParentalGateFragment$backSpaceHandler$1(ParentalGateFragment parentalGateFragment) {
        this.this$0 = parentalGateFragment;
    }

    public void onClick() {
        this.this$0.getParentalGateViewModel().backSpacePressed();
    }
}
