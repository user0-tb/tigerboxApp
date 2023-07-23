package media.tiger.tigerbox.p016ui.onboarding.step4;

import androidx.lifecycle.ViewModelKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.interactor.UseCase;
import media.tiger.tigerbox.p016ui.common.BaseViewModel;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendResponseViewModel;", "Lmedia/tiger/tigerbox/ui/common/BaseViewModel;", "removeAccountDataUseCase", "Lmedia/tiger/tigerbox/usecase/accesstokenrepo/RemoveAccountDataUseCase;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "(Lmedia/tiger/tigerbox/usecase/accesstokenrepo/RemoveAccountDataUseCase;Lmedia/tiger/tigerbox/services/interfaces/WifiService;)V", "removeStoredToken", "", "stopContinuousScan", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseViewModel */
/* compiled from: OnboardingBackendResponseViewModel.kt */
public final class OnboardingBackendResponseViewModel extends BaseViewModel {
    private final RemoveAccountDataUseCase removeAccountDataUseCase;
    private final WifiService wifiService;

    @Inject
    public OnboardingBackendResponseViewModel(RemoveAccountDataUseCase removeAccountDataUseCase2, WifiService wifiService2) {
        Intrinsics.checkNotNullParameter(removeAccountDataUseCase2, "removeAccountDataUseCase");
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        this.removeAccountDataUseCase = removeAccountDataUseCase2;
        this.wifiService = wifiService2;
    }

    public final void removeStoredToken() {
        UseCase.invoke$default(this.removeAccountDataUseCase, Unit.INSTANCE, ViewModelKt.getViewModelScope(this), (Function1) null, 4, (Object) null);
    }

    public final void stopContinuousScan() {
        this.wifiService.stopContinuousScan();
    }
}
