package media.tiger.tigerbox.p016ui.main.profiles;

import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.repository.ProfileChangeListener;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.MetaDataService;

@Metadata(mo33736d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0017J\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\u0017J\u0006\u0010\u001e\u001a\u00020\u0017R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006 "}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/profiles/ProfilePictureViewModel;", "Lmedia/tiger/tigerbox/ui/common/FullScreenViewModel;", "Lmedia/tiger/tigerbox/data/repository/ProfileChangeListener;", "accountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "headerProvider", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "(Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;)V", "_profileNickname", "Landroidx/lifecycle/MutableLiveData;", "", "_profilePictureUrl", "profileNickname", "Landroidx/lifecycle/LiveData;", "getProfileNickname", "()Landroidx/lifecycle/LiveData;", "profilePictureUrl", "getProfilePictureUrl", "didChangeProfile", "", "id", "", "didUpdateProfilesInfo", "onCleared", "registerListeners", "unregisterListeners", "updateData", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilePictureViewModel */
/* compiled from: ProfilePictureViewModel.kt */
public final class ProfilePictureViewModel extends FullScreenViewModel implements ProfileChangeListener {
    public static final String AVATARS_FOLDER = "file:///android_asset/avatars/";
    public static final String AVATAR_IMG_EXT = "png";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_AVATAR_IMAGE = "Tiger_Cool";
    private final MutableLiveData<String> _profileNickname = new MutableLiveData<>();
    private final MutableLiveData<String> _profilePictureUrl = new MutableLiveData<>();
    private final TigerBoxAccountRepository accountRepository;
    private final MetaDataService metaDataService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ProfilePictureViewModel(TigerBoxAccountRepository tigerBoxAccountRepository, MetaDataService metaDataService2, ButtonService buttonService, HeaderProvider headerProvider) {
        super(buttonService, headerProvider);
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository, "accountRepository");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(headerProvider, "headerProvider");
        this.accountRepository = tigerBoxAccountRepository;
        this.metaDataService = metaDataService2;
    }

    public final LiveData<String> getProfilePictureUrl() {
        return this._profilePictureUrl;
    }

    public final LiveData<String> getProfileNickname() {
        return this._profileNickname;
    }

    public void didChangeProfile(int i) {
        updateData();
    }

    public void didUpdateProfilesInfo() {
        updateData();
    }

    public final void updateData() {
        int id = this.accountRepository.getActiveProfile().getId();
        String str = "file:///android_asset/avatars/Tiger_Cool.png";
        String str2 = "";
        int i = 0;
        for (Object next : this.accountRepository.getTigerBoxProfiles()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TigerBoxProfileDomain tigerBoxProfileDomain = (TigerBoxProfileDomain) next;
            if (tigerBoxProfileDomain.getId() == id) {
                String avatarUrl = tigerBoxProfileDomain.getAvatarUrl();
                if (avatarUrl != null) {
                    if (!URLUtil.isValidUrl(avatarUrl)) {
                        avatarUrl = "file:///android_asset/avatars/" + avatarUrl + ".png";
                    }
                    str = avatarUrl;
                }
                str2 = tigerBoxProfileDomain.getNickName();
            }
            i = i2;
        }
        this._profilePictureUrl.postValue(str);
        this._profileNickname.postValue(str2);
    }

    public final void registerListeners() {
        this.accountRepository.registerProfileChangeListener(this);
        this.accountRepository.requestUpdatedProfilesInfoFromServer(ProfilePictureViewModel$registerListeners$1.INSTANCE);
    }

    public final void unregisterListeners() {
        this.accountRepository.unregisterProfileChangeListener(this);
    }

    public void onCleared() {
        this.accountRepository.unregisterProfileChangeListener(this);
        super.onCleared();
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/profiles/ProfilePictureViewModel$Companion;", "", "()V", "AVATARS_FOLDER", "", "AVATAR_IMG_EXT", "DEFAULT_AVATAR_IMAGE", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilePictureViewModel$Companion */
    /* compiled from: ProfilePictureViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
