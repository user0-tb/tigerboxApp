package media.tiger.tigerbox.p016ui.common;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding;
import media.tiger.tigerbox.model.domain.BatterySummary;

/* renamed from: media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda7 */
public final /* synthetic */ class FullScreenFragment$$ExternalSyntheticLambda7 implements Observer {
    public final /* synthetic */ IncludeDialogHeaderBarBinding f$0;

    public /* synthetic */ FullScreenFragment$$ExternalSyntheticLambda7(IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding) {
        this.f$0 = includeDialogHeaderBarBinding;
    }

    public final void onChanged(Object obj) {
        FullScreenFragment.m2365onViewCreated$lambda14$lambda3(this.f$0, (BatterySummary) obj);
    }
}
