package p012io.shipbook.shipbooksdk.Events;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import kotlin.Metadata;
import p012io.shipbook.shipbooksdk.InnerLog;

@Metadata(mo33736d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo33737d2 = {"io/shipbook/shipbooksdk/Events/ActionEventManager$registerView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Events.ActionEventManager$registerView$3 */
/* compiled from: ActionEventManager.kt */
public final class ActionEventManager$registerView$3 implements TextWatcher {
    final /* synthetic */ View $view;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    ActionEventManager$registerView$3(View view) {
        this.$view = view;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if ((((EditText) this.$view).getInputType() & 128) == 128) {
            InnerLog.d$default(InnerLog.INSTANCE, "actionEvent", "is password", (Throwable) null, 4, (Object) null);
        } else {
            ActionEventManager.INSTANCE.createActionEvent("textChanged", String.valueOf(charSequence), this.$view);
        }
    }
}
