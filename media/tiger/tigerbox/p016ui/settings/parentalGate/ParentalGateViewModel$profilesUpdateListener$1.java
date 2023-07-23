package media.tiger.tigerbox.p016ui.settings.parentalGate;

import kotlin.Metadata;
import media.tiger.tigerbox.data.repository.ProfileChangeListener;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo33737d2 = {"media/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$profilesUpdateListener$1", "Lmedia/tiger/tigerbox/data/repository/ProfileChangeListener;", "didChangeProfile", "", "id", "", "didUpdateProfilesInfo", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel$profilesUpdateListener$1 */
/* compiled from: ParentalGateViewModel.kt */
public final class ParentalGateViewModel$profilesUpdateListener$1 implements ProfileChangeListener {
    final /* synthetic */ ParentalGateViewModel this$0;

    public void didChangeProfile(int i) {
    }

    ParentalGateViewModel$profilesUpdateListener$1(ParentalGateViewModel parentalGateViewModel) {
        this.this$0 = parentalGateViewModel;
    }

    public void didUpdateProfilesInfo() {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("didUpdateProfilesInfo pin " + this.this$0.accountRepository.getTigerBoxUser().getPin(), new Object[0]);
        this.this$0.preparePinUse();
    }
}
