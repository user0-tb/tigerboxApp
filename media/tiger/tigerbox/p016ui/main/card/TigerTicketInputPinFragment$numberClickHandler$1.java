package media.tiger.tigerbox.p016ui.main.card;

import kotlin.Metadata;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;

@Metadata(mo33736d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, mo33737d2 = {"media/tiger/tigerbox/ui/main/card/TigerTicketInputPinFragment$numberClickHandler$1", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "", "onClick", "", "data", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinFragment$numberClickHandler$1 */
/* compiled from: TigerTicketInputPinFragment.kt */
public final class TigerTicketInputPinFragment$numberClickHandler$1 implements BindingClickListener<Character> {
    final /* synthetic */ TigerTicketInputPinFragment this$0;

    TigerTicketInputPinFragment$numberClickHandler$1(TigerTicketInputPinFragment tigerTicketInputPinFragment) {
        this.this$0 = tigerTicketInputPinFragment;
    }

    public /* bridge */ /* synthetic */ void onClick(Object obj) {
        onClick(((Character) obj).charValue());
    }

    public void onClick(char c) {
        this.this$0.getTigerTicketInputPinViewModel().numberPressed(c);
    }
}
