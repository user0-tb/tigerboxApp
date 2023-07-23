package media.tiger.tigerbox.p016ui.main.mediaplayer;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerViewModel;

/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerFragment$$ExternalSyntheticLambda7 */
public final /* synthetic */ class MediaPlayerFragment$$ExternalSyntheticLambda7 implements Observer {
    public final /* synthetic */ MediaPlayerFragment f$0;

    public /* synthetic */ MediaPlayerFragment$$ExternalSyntheticLambda7(MediaPlayerFragment mediaPlayerFragment) {
        this.f$0 = mediaPlayerFragment;
    }

    public final void onChanged(Object obj) {
        MediaPlayerFragment.m2440attachObservers$lambda7(this.f$0, (MediaPlayerViewModel.PlaybackState) obj);
    }
}
