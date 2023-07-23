package media.tiger.tigerbox.p016ui.onboarding.step4;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.interactor.UseCase;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.domain.AccessTokenDomain;
import media.tiger.tigerbox.model.dto.DeviceInformation;
import media.tiger.tigerbox.p016ui.common.BaseViewModel;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.usecase.AssignBoxToAccountParameters;
import media.tiger.tigerbox.usecase.AssignBoxToAccountUseCase;
import media.tiger.tigerbox.usecase.OnboardingCompleteActionUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.FetchAndStoreAccessTokenUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.GetTokenParameters;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.FetchAccountInfoUseCase;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dJ\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020%H\u0002R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendCommunicationViewModel;", "Lmedia/tiger/tigerbox/ui/common/BaseViewModel;", "fetchAndStoreAccessTokenUseCase", "Lmedia/tiger/tigerbox/usecase/accesstokenrepo/FetchAndStoreAccessTokenUseCase;", "getLoggedAccountInfoUseCase", "Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/FetchAccountInfoUseCase;", "assignBoxToAccountUseCase", "Lmedia/tiger/tigerbox/usecase/AssignBoxToAccountUseCase;", "tigerBoxAccountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "onboardingCompleteActionUseCase", "Lmedia/tiger/tigerbox/usecase/OnboardingCompleteActionUseCase;", "(Lmedia/tiger/tigerbox/usecase/accesstokenrepo/FetchAndStoreAccessTokenUseCase;Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/FetchAccountInfoUseCase;Lmedia/tiger/tigerbox/usecase/AssignBoxToAccountUseCase;Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;Lmedia/tiger/tigerbox/usecase/OnboardingCompleteActionUseCase;)V", "_backendCommunicationInProgress", "Landroidx/lifecycle/MutableLiveData;", "", "backendCommunicationInProgress", "Landroidx/lifecycle/LiveData;", "getBackendCommunicationInProgress", "()Landroidx/lifecycle/LiveData;", "assignBoxToAccount", "", "accessToken", "", "getToken", "username", "password", "handleAssignBoxToAccountReqSuccess", "deviceInformation", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "handleTokenResult", "Lmedia/tiger/tigerbox/model/domain/AccessTokenDomain;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendCommunicationViewModel */
/* compiled from: OnboardingBackendCommunicationViewModel.kt */
public final class OnboardingBackendCommunicationViewModel extends BaseViewModel {
    private final MutableLiveData<Boolean> _backendCommunicationInProgress;
    private final AssignBoxToAccountUseCase assignBoxToAccountUseCase;
    private final LiveData<Boolean> backendCommunicationInProgress;
    private final ConfigurationProperties configurationProperties;
    private final FetchAndStoreAccessTokenUseCase fetchAndStoreAccessTokenUseCase;
    private final FetchAccountInfoUseCase getLoggedAccountInfoUseCase;
    private final MetaDataService metaDataService;
    private final OnboardingCompleteActionUseCase onboardingCompleteActionUseCase;
    private final StorageService storageService;
    private final TigerBoxAccountRepository tigerBoxAccountRepository;

    @Inject
    public OnboardingBackendCommunicationViewModel(FetchAndStoreAccessTokenUseCase fetchAndStoreAccessTokenUseCase2, FetchAccountInfoUseCase fetchAccountInfoUseCase, AssignBoxToAccountUseCase assignBoxToAccountUseCase2, TigerBoxAccountRepository tigerBoxAccountRepository2, StorageService storageService2, MetaDataService metaDataService2, ConfigurationProperties configurationProperties2, OnboardingCompleteActionUseCase onboardingCompleteActionUseCase2) {
        Intrinsics.checkNotNullParameter(fetchAndStoreAccessTokenUseCase2, "fetchAndStoreAccessTokenUseCase");
        Intrinsics.checkNotNullParameter(fetchAccountInfoUseCase, "getLoggedAccountInfoUseCase");
        Intrinsics.checkNotNullParameter(assignBoxToAccountUseCase2, "assignBoxToAccountUseCase");
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository2, "tigerBoxAccountRepository");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        Intrinsics.checkNotNullParameter(onboardingCompleteActionUseCase2, "onboardingCompleteActionUseCase");
        this.fetchAndStoreAccessTokenUseCase = fetchAndStoreAccessTokenUseCase2;
        this.getLoggedAccountInfoUseCase = fetchAccountInfoUseCase;
        this.assignBoxToAccountUseCase = assignBoxToAccountUseCase2;
        this.tigerBoxAccountRepository = tigerBoxAccountRepository2;
        this.storageService = storageService2;
        this.metaDataService = metaDataService2;
        this.configurationProperties = configurationProperties2;
        this.onboardingCompleteActionUseCase = onboardingCompleteActionUseCase2;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._backendCommunicationInProgress = mutableLiveData;
        this.backendCommunicationInProgress = mutableLiveData;
    }

    public final LiveData<Boolean> getBackendCommunicationInProgress() {
        return this.backendCommunicationInProgress;
    }

    public final void getToken(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "username");
        Intrinsics.checkNotNullParameter(str2, "password");
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("getToken username " + str + " cpuId: " + this.metaDataService.getCpuId(), new Object[0]);
        FetchAndStoreAccessTokenUseCase fetchAndStoreAccessTokenUseCase2 = this.fetchAndStoreAccessTokenUseCase;
        StringBuilder sb = new StringBuilder();
        sb.append("Basic ");
        sb.append(this.configurationProperties.getProperty("auth.header"));
        fetchAndStoreAccessTokenUseCase2.invoke(new GetTokenParameters(sb.toString(), str, str2, this.metaDataService.getCpuId()), ViewModelKt.getViewModelScope(this), new OnboardingBackendCommunicationViewModel$getToken$1(this));
    }

    /* access modifiers changed from: private */
    public final void handleTokenResult(AccessTokenDomain accessTokenDomain) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("handleTokenResult accessToken " + accessTokenDomain, new Object[0]);
        Log.i("OnboardingBackendCommVM", "handleTokenResult");
        this.getLoggedAccountInfoUseCase.invoke(Unit.INSTANCE, ViewModelKt.getViewModelScope(this), new OnboardingBackendCommunicationViewModel$handleTokenResult$1(this, accessTokenDomain));
    }

    /* access modifiers changed from: private */
    public final void assignBoxToAccount(String str) {
        Log.i("OnboardingBackendCommVM", "assignBoxToAccount");
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("assignBoxToAccount accessToken " + str + " cpuId: " + this.metaDataService.getCpuId() + " serial " + this.metaDataService.getSerialNumber(), new Object[0]);
        this.assignBoxToAccountUseCase.invoke(new AssignBoxToAccountParameters(str, this.metaDataService.getCpuId(), this.metaDataService.getSerialNumber()), ViewModelKt.getViewModelScope(this), new OnboardingBackendCommunicationViewModel$assignBoxToAccount$1(this));
    }

    /* access modifiers changed from: private */
    public final void handleAssignBoxToAccountReqSuccess(DeviceInformation deviceInformation) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("handleAssignBoxToAccountReqSuccess deviceInformation " + deviceInformation + " threadId: " + Thread.currentThread().getId(), new Object[0]);
        this.storageService.setDeviceInformation(deviceInformation);
        this._backendCommunicationInProgress.postValue(false);
        UseCase.invoke$default(this.onboardingCompleteActionUseCase, true, ViewModelKt.getViewModelScope(this), (Function1) null, 4, (Object) null);
    }
}
