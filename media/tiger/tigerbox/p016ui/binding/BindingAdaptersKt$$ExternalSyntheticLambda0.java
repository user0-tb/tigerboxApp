package media.tiger.tigerbox.p016ui.binding;

import android.view.View;
import media.tiger.tigerbox.p016ui.main.mediaplayer.OnMediaCoverImageClickListener;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;

/* renamed from: media.tiger.tigerbox.ui.binding.BindingAdaptersKt$$ExternalSyntheticLambda0 */
public final /* synthetic */ class BindingAdaptersKt$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ OnMediaCoverImageClickListener f$0;
    public final /* synthetic */ AudioProductInfo f$1;

    public /* synthetic */ BindingAdaptersKt$$ExternalSyntheticLambda0(OnMediaCoverImageClickListener onMediaCoverImageClickListener, AudioProductInfo audioProductInfo) {
        this.f$0 = onMediaCoverImageClickListener;
        this.f$1 = audioProductInfo;
    }

    public final void onClick(View view) {
        BindingAdaptersKt.m2358bindMediaCoverImageClickListener$lambda2$lambda1(this.f$0, this.f$1, view);
    }
}
