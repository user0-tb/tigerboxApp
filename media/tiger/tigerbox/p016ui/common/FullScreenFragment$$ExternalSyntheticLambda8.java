package media.tiger.tigerbox.p016ui.common;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding;
import media.tiger.tigerbox.model.domain.WifiStrength;

/* renamed from: media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda8 */
public final /* synthetic */ class FullScreenFragment$$ExternalSyntheticLambda8 implements Observer {
    public final /* synthetic */ FullScreenViewModel f$0;
    public final /* synthetic */ IncludeDialogHeaderBarBinding f$1;

    public /* synthetic */ FullScreenFragment$$ExternalSyntheticLambda8(FullScreenViewModel fullScreenViewModel, IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding) {
        this.f$0 = fullScreenViewModel;
        this.f$1 = includeDialogHeaderBarBinding;
    }

    public final void onChanged(Object obj) {
        FullScreenFragment.m2364onViewCreated$lambda14$lambda2(this.f$0, this.f$1, (WifiStrength) obj);
    }
}
