package media.tiger.tigerbox.p016ui.main.miniplayer;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerViewModel;

/* renamed from: media.tiger.tigerbox.ui.main.miniplayer.MiniPlayerFragment$$ExternalSyntheticLambda3 */
public final /* synthetic */ class MiniPlayerFragment$$ExternalSyntheticLambda3 implements Observer {
    public final /* synthetic */ MiniPlayerFragment f$0;

    public /* synthetic */ MiniPlayerFragment$$ExternalSyntheticLambda3(MiniPlayerFragment miniPlayerFragment) {
        this.f$0 = miniPlayerFragment;
    }

    public final void onChanged(Object obj) {
        MiniPlayerFragment.m2444attachObservers$lambda2(this.f$0, (MediaPlayerViewModel.ViewState) obj);
    }
}
