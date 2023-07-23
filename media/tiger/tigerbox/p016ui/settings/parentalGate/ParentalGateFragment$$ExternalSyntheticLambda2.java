package media.tiger.tigerbox.p016ui.settings.parentalGate;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateViewModel;

/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateFragment$$ExternalSyntheticLambda2 */
public final /* synthetic */ class ParentalGateFragment$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ ParentalGateFragment f$0;

    public /* synthetic */ ParentalGateFragment$$ExternalSyntheticLambda2(ParentalGateFragment parentalGateFragment) {
        this.f$0 = parentalGateFragment;
    }

    public final void onChanged(Object obj) {
        ParentalGateFragment.m2545setUpObservers$lambda3(this.f$0, (ParentalGateViewModel.NavigationState) obj);
    }
}
