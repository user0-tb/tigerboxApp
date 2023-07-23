package media.tiger.tigerbox.p016ui.main.profiles;

import kotlin.Metadata;
import media.tiger.tigerbox.data.repository.ProfileChangeListener;

@Metadata(mo33736d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo33737d2 = {"media/tiger/tigerbox/ui/main/profiles/ProfilesViewModel$profileListener$1", "Lmedia/tiger/tigerbox/data/repository/ProfileChangeListener;", "didChangeProfile", "", "id", "", "didUpdateProfilesInfo", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel$profileListener$1 */
/* compiled from: ProfilesViewModel.kt */
public final class ProfilesViewModel$profileListener$1 implements ProfileChangeListener {
    final /* synthetic */ ProfilesViewModel this$0;

    ProfilesViewModel$profileListener$1(ProfilesViewModel profilesViewModel) {
        this.this$0 = profilesViewModel;
    }

    public void didChangeProfile(int i) {
        this.this$0.updateData();
    }

    public void didUpdateProfilesInfo() {
        this.this$0.updateData();
    }
}
