package media.tiger.tigerbox.p016ui.main.mediaplayer;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerViewModel;

/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerFragment$$ExternalSyntheticLambda8 */
public final /* synthetic */ class MediaPlayerFragment$$ExternalSyntheticLambda8 implements Observer {
    public final /* synthetic */ MediaPlayerFragment f$0;

    public /* synthetic */ MediaPlayerFragment$$ExternalSyntheticLambda8(MediaPlayerFragment mediaPlayerFragment) {
        this.f$0 = mediaPlayerFragment;
    }

    public final void onChanged(Object obj) {
        MediaPlayerFragment.m2439attachObservers$lambda4(this.f$0, (MediaPlayerViewModel.ViewState) obj);
    }
}
