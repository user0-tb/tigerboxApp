package p012io.shipbook.shipbooksdk.Events;

import android.view.View;
import android.widget.CompoundButton;

/* renamed from: io.shipbook.shipbooksdk.Events.ActionEventManager$$ExternalSyntheticLambda1 */
public final /* synthetic */ class ActionEventManager$$ExternalSyntheticLambda1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ CompoundButton.OnCheckedChangeListener f$1;

    public /* synthetic */ ActionEventManager$$ExternalSyntheticLambda1(View view, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f$0 = view;
        this.f$1 = onCheckedChangeListener;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ActionEventManager.m765registerView$lambda0(this.f$0, this.f$1, compoundButton, z);
    }
}
