package media.tiger.tigerbox.p016ui.main.offlinemode;

import kotlin.Metadata;
import media.tiger.tigerbox.data.repository.ProfileChangeListener;

@Metadata(mo33736d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo33737d2 = {"media/tiger/tigerbox/ui/main/offlinemode/OfflineModeViewModel$profilesListener$1", "Lmedia/tiger/tigerbox/data/repository/ProfileChangeListener;", "didChangeProfile", "", "id", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.offlinemode.OfflineModeViewModel$profilesListener$1 */
/* compiled from: OfflineModeViewModel.kt */
public final class OfflineModeViewModel$profilesListener$1 implements ProfileChangeListener {
    final /* synthetic */ OfflineModeViewModel this$0;

    OfflineModeViewModel$profilesListener$1(OfflineModeViewModel offlineModeViewModel) {
        this.this$0 = offlineModeViewModel;
    }

    public void didUpdateProfilesInfo() {
        ProfileChangeListener.DefaultImpls.didUpdateProfilesInfo(this);
    }

    public void didChangeProfile(int i) {
        this.this$0._downloadedContent.setValue(this.this$0.availabilityService.downloadedProducts());
    }
}
