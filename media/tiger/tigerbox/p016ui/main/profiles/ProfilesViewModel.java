package media.tiger.tigerbox.p016ui.main.profiles;

import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.model.domain.ProfilesItem;
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;
import media.tiger.tigerbox.model.dto.DeviceInformation;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u001c\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002-.B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020!H\u0017J\u000e\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0014J\u0006\u0010*\u001a\u00020!J\u0006\u0010+\u001a\u00020!J\u0006\u0010,\u001a\u00020!R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00188F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesViewModel;", "Lmedia/tiger/tigerbox/ui/common/FullScreenViewModel;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "accountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "assignProfileToAccountUseCase", "Lmedia/tiger/tigerbox/usecase/AssignProfileToAccountUseCase;", "audioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "headerProvider", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;Lmedia/tiger/tigerbox/usecase/AssignProfileToAccountUseCase;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;)V", "_miniViewState", "Landroidx/lifecycle/MutableLiveData;", "Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesViewModel$MiniViewState;", "_profilesList", "", "Lmedia/tiger/tigerbox/model/domain/ProfilesItem;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "miniViewState", "Landroidx/lifecycle/LiveData;", "getMiniViewState", "()Landroidx/lifecycle/LiveData;", "profileListener", "media/tiger/tigerbox/ui/main/profiles/ProfilesViewModel$profileListener$1", "Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesViewModel$profileListener$1;", "profilesList", "getProfilesList", "assignProfileSuccessHandler", "", "info", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "assignProfileToBackendFailureHandler", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "onCleared", "onClick", "data", "registerListeners", "unregisterListeners", "updateData", "Companion", "MiniViewState", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel */
/* compiled from: ProfilesViewModel.kt */
public final class ProfilesViewModel extends FullScreenViewModel {
    public static final String AVATARS_FOLDER = "file:///android_asset/avatars/";
    public static final String AVATAR_IMG_EXT = "png";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_AVATAR_IMAGE = "Tiger_Cool";
    private final MutableLiveData<MiniViewState> _miniViewState = new MutableLiveData<>();
    private final MutableLiveData<List<ProfilesItem>> _profilesList = new MutableLiveData<>();
    private final TigerBoxAccountRepository accountRepository;
    /* access modifiers changed from: private */
    public final AssignProfileToAccountUseCase assignProfileToAccountUseCase;
    private final AudioPlayerService audioPlayerService;
    private CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
    private final ProfilesViewModel$profileListener$1 profileListener = new ProfilesViewModel$profileListener$1(this);
    private final StorageService storageService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ProfilesViewModel(StorageService storageService2, TigerBoxAccountRepository tigerBoxAccountRepository, AssignProfileToAccountUseCase assignProfileToAccountUseCase2, AudioPlayerService audioPlayerService2, ButtonService buttonService, HeaderProvider headerProvider) {
        super(buttonService, headerProvider);
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository, "accountRepository");
        Intrinsics.checkNotNullParameter(assignProfileToAccountUseCase2, "assignProfileToAccountUseCase");
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(headerProvider, "headerProvider");
        this.storageService = storageService2;
        this.accountRepository = tigerBoxAccountRepository;
        this.assignProfileToAccountUseCase = assignProfileToAccountUseCase2;
        this.audioPlayerService = audioPlayerService2;
    }

    public final LiveData<MiniViewState> getMiniViewState() {
        return this._miniViewState;
    }

    public final LiveData<List<ProfilesItem>> getProfilesList() {
        return this._profilesList;
    }

    public final void onClick(ProfilesItem profilesItem) {
        DeviceInformation.Links links;
        DeviceInformation.Links.Link self;
        String href;
        Intrinsics.checkNotNullParameter(profilesItem, "data");
        this.audioPlayerService.stop();
        this.accountRepository.setActiveProfile(profilesItem.getId());
        DeviceInformation deviceInformation = this.storageService.getDeviceInformation();
        if (!(deviceInformation == null || (links = deviceInformation.get_links()) == null || (self = links.getSelf()) == null || (href = self.getHref()) == null)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProfilesViewModel$onClick$1$1(href, profilesItem, this, (Continuation<? super ProfilesViewModel$onClick$1$1>) null), 3, (Object) null);
        }
        updateData();
    }

    /* access modifiers changed from: private */
    public final void assignProfileToBackendFailureHandler(Failure failure) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50217e("assignProfileToBackendFailureHandler failure: " + failure, new Object[0]);
    }

    /* access modifiers changed from: private */
    public final void assignProfileSuccessHandler(DeviceInformation deviceInformation) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("assignProfileSuccessHandler info: " + deviceInformation, new Object[0]);
    }

    public final void updateData() {
        ArrayList arrayList = new ArrayList();
        int id = this.accountRepository.getActiveProfile().getId();
        int i = 0;
        for (Object next : this.accountRepository.getTigerBoxProfiles()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TigerBoxProfileDomain tigerBoxProfileDomain = (TigerBoxProfileDomain) next;
            String avatarUrl = tigerBoxProfileDomain.getAvatarUrl();
            if (avatarUrl == null) {
                avatarUrl = "file:///android_asset/avatars/Tiger_Cool.png";
            } else if (!URLUtil.isValidUrl(avatarUrl)) {
                avatarUrl = "file:///android_asset/avatars/" + avatarUrl + ".png";
            }
            ProfilesItem profilesItem = new ProfilesItem(tigerBoxProfileDomain.getId(), tigerBoxProfileDomain.getEmail(), tigerBoxProfileDomain.getNickName(), i, avatarUrl, tigerBoxProfileDomain.getId() == id);
            arrayList.add(profilesItem);
            if (profilesItem.isSelected()) {
                Timber.Forest.mo50221i("ProfilesViewModel did post " + profilesItem, new Object[0]);
                this._miniViewState.postValue(new MiniViewState(profilesItem));
            }
            i = i2;
        }
        this._profilesList.postValue(arrayList);
    }

    public final void registerListeners() {
        this.accountRepository.registerProfileChangeListener(this.profileListener);
        this.accountRepository.requestUpdatedProfilesInfoFromServer(ProfilesViewModel$registerListeners$1.INSTANCE);
    }

    public final void unregisterListeners() {
        this.accountRepository.unregisterProfileChangeListener(this.profileListener);
    }

    public void onCleared() {
        this.accountRepository.unregisterProfileChangeListener(this.profileListener);
        super.onCleared();
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesViewModel$MiniViewState;", "", "profile", "Lmedia/tiger/tigerbox/model/domain/ProfilesItem;", "(Lmedia/tiger/tigerbox/model/domain/ProfilesItem;)V", "getProfile", "()Lmedia/tiger/tigerbox/model/domain/ProfilesItem;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel$MiniViewState */
    /* compiled from: ProfilesViewModel.kt */
    public static final class MiniViewState {
        private final ProfilesItem profile;

        public MiniViewState() {
            this((ProfilesItem) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ MiniViewState copy$default(MiniViewState miniViewState, ProfilesItem profilesItem, int i, Object obj) {
            if ((i & 1) != 0) {
                profilesItem = miniViewState.profile;
            }
            return miniViewState.copy(profilesItem);
        }

        public final ProfilesItem component1() {
            return this.profile;
        }

        public final MiniViewState copy(ProfilesItem profilesItem) {
            return new MiniViewState(profilesItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MiniViewState) && Intrinsics.areEqual((Object) this.profile, (Object) ((MiniViewState) obj).profile);
        }

        public int hashCode() {
            ProfilesItem profilesItem = this.profile;
            if (profilesItem == null) {
                return 0;
            }
            return profilesItem.hashCode();
        }

        public String toString() {
            return "MiniViewState(profile=" + this.profile + ')';
        }

        public MiniViewState(ProfilesItem profilesItem) {
            this.profile = profilesItem;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MiniViewState(ProfilesItem profilesItem, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : profilesItem);
        }

        public final ProfilesItem getProfile() {
            return this.profile;
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesViewModel$Companion;", "", "()V", "AVATARS_FOLDER", "", "AVATAR_IMG_EXT", "DEFAULT_AVATAR_IMAGE", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel$Companion */
    /* compiled from: ProfilesViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
