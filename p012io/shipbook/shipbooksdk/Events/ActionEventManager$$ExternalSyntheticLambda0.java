package p012io.shipbook.shipbooksdk.Events;

import android.view.View;

/* renamed from: io.shipbook.shipbooksdk.Events.ActionEventManager$$ExternalSyntheticLambda0 */
public final /* synthetic */ class ActionEventManager$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ View.OnClickListener f$1;

    public /* synthetic */ ActionEventManager$$ExternalSyntheticLambda0(View view, View.OnClickListener onClickListener) {
        this.f$0 = view;
        this.f$1 = onClickListener;
    }

    public final void onClick(View view) {
        ActionEventManager.m766registerView$lambda1(this.f$0, this.f$1, view);
    }
}
