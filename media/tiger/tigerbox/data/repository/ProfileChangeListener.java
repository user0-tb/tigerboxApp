package media.tiger.tigerbox.data.repository;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/repository/ProfileChangeListener;", "", "didChangeProfile", "", "id", "", "didUpdateProfilesInfo", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUserRepository.kt */
public interface ProfileChangeListener {

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerBoxUserRepository.kt */
    public static final class DefaultImpls {
        public static void didChangeProfile(ProfileChangeListener profileChangeListener, int i) {
        }

        public static void didUpdateProfilesInfo(ProfileChangeListener profileChangeListener) {
        }
    }

    void didChangeProfile(int i);

    void didUpdateProfilesInfo();
}
