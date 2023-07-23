package media.tiger.tigerbox.p016ui.main.mediaplayer;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.infrastructure.exception.Failure;

/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerFragment$$ExternalSyntheticLambda6 */
public final /* synthetic */ class MediaPlayerFragment$$ExternalSyntheticLambda6 implements Observer {
    public final /* synthetic */ MediaPlayerFragment f$0;

    public /* synthetic */ MediaPlayerFragment$$ExternalSyntheticLambda6(MediaPlayerFragment mediaPlayerFragment) {
        this.f$0 = mediaPlayerFragment;
    }

    public final void onChanged(Object obj) {
        MediaPlayerFragment.m2438attachObservers$lambda2(this.f$0, (Failure) obj);
    }
}
