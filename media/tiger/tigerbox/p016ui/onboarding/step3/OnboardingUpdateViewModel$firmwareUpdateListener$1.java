package media.tiger.tigerbox.p016ui.onboarding.step3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.p016ui.onboarding.step3.OnboardingUpdateViewModel;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateListener;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateStep;

@Metadata(mo33736d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo33737d2 = {"media/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$firmwareUpdateListener$1", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateListener;", "firmwareUpdateStateHasChanged", "", "state", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$State;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$firmwareUpdateListener$1 */
/* compiled from: OnboardingUpdateViewModel.kt */
public final class OnboardingUpdateViewModel$firmwareUpdateListener$1 implements FirmwareUpdateListener {
    final /* synthetic */ OnboardingUpdateViewModel this$0;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$firmwareUpdateListener$1$WhenMappings */
    /* compiled from: OnboardingUpdateViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FirmwareUpdateService.State.values().length];
            iArr[FirmwareUpdateService.State.BeginCheckForUpdate.ordinal()] = 1;
            iArr[FirmwareUpdateService.State.NoUpdateRequired.ordinal()] = 2;
            iArr[FirmwareUpdateService.State.CheckForUpdateFailed.ordinal()] = 3;
            iArr[FirmwareUpdateService.State.CheckForUpdateSuccessInsufficientBatteryError.ordinal()] = 4;
            iArr[FirmwareUpdateService.State.CheckForUpdateSuccess.ordinal()] = 5;
            iArr[FirmwareUpdateService.State.BeginDownloadingFirmware.ordinal()] = 6;
            iArr[FirmwareUpdateService.State.DownloadingFirmwareProgressed.ordinal()] = 7;
            iArr[FirmwareUpdateService.State.DecryptingFirmwareProgressed.ordinal()] = 8;
            iArr[FirmwareUpdateService.State.DownloadingFirmwareFailed.ordinal()] = 9;
            iArr[FirmwareUpdateService.State.DownloadingFirmwareSuccess.ordinal()] = 10;
            iArr[FirmwareUpdateService.State.BeginInstallingFirmware.ordinal()] = 11;
            iArr[FirmwareUpdateService.State.InstallingFirmwareDone.ordinal()] = 12;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    OnboardingUpdateViewModel$firmwareUpdateListener$1(OnboardingUpdateViewModel onboardingUpdateViewModel) {
        this.this$0 = onboardingUpdateViewModel;
    }

    public void firmwareUpdateStateHasChanged(FirmwareUpdateService.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                this.this$0._viewState.postValue(OnboardingUpdateViewModel.ViewState.CheckingForUpdate.INSTANCE);
                return;
            case 2:
                this.this$0.noUpdateRequired();
                return;
            case 3:
                this.this$0.noUpdateRequired();
                return;
            case 4:
                this.this$0.readyToUpdateBatteryError();
                return;
            case 5:
                this.this$0.readyToUpdate();
                return;
            case 6:
            case 7:
                this.this$0.postStepProgress(FirmwareUpdateStep.DOWNLOAD_FIRMWARE, this.this$0.firmwareUpdateService.getProgressPercentage());
                return;
            case 8:
                this.this$0.postStepProgress(FirmwareUpdateStep.FIRMWARE_DECRYPT, this.this$0.firmwareUpdateService.getProgressPercentage());
                return;
            case 9:
                this.this$0.showError();
                return;
            case 10:
                this.this$0.readyToInstall();
                return;
            case 11:
            case 12:
                this.this$0.postStepProgress(FirmwareUpdateStep.COMPLETE, 100);
                return;
            default:
                return;
        }
    }
}
