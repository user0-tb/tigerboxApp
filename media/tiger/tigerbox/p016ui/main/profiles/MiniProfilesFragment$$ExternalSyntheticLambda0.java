package media.tiger.tigerbox.p016ui.main.profiles;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.p016ui.main.profiles.ProfilesViewModel;

/* renamed from: media.tiger.tigerbox.ui.main.profiles.MiniProfilesFragment$$ExternalSyntheticLambda0 */
public final /* synthetic */ class MiniProfilesFragment$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ MiniProfilesFragment f$0;

    public /* synthetic */ MiniProfilesFragment$$ExternalSyntheticLambda0(MiniProfilesFragment miniProfilesFragment) {
        this.f$0 = miniProfilesFragment;
    }

    public final void onChanged(Object obj) {
        MiniProfilesFragment.m2458attachObservers$lambda0(this.f$0, (ProfilesViewModel.MiniViewState) obj);
    }
}
