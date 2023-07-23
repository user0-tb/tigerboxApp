package media.tiger.tigerbox.p016ui.main.maincontentheader;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.model.domain.WifiStrength;

/* renamed from: media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderFragment$$ExternalSyntheticLambda10 */
public final /* synthetic */ class MainContentHeaderFragment$$ExternalSyntheticLambda10 implements Observer {
    public final /* synthetic */ MainContentHeaderFragment f$0;

    public /* synthetic */ MainContentHeaderFragment$$ExternalSyntheticLambda10(MainContentHeaderFragment mainContentHeaderFragment) {
        this.f$0 = mainContentHeaderFragment;
    }

    public final void onChanged(Object obj) {
        MainContentHeaderFragment.m2420onCreateView$lambda1(this.f$0, (WifiStrength) obj);
    }
}
