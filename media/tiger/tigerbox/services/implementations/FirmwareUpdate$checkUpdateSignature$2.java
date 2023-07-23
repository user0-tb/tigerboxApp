package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.dto.ReleaseInformation;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "latestRelease", "Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: FirmwareUpdate.kt */
final class FirmwareUpdate$checkUpdateSignature$2 extends Lambda implements Function1<ReleaseInformation.Release, Unit> {
    final /* synthetic */ FirmwareUpdate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FirmwareUpdate$checkUpdateSignature$2(FirmwareUpdate firmwareUpdate) {
        super(1);
        this.this$0 = firmwareUpdate;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ReleaseInformation.Release) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ReleaseInformation.Release release) {
        Intrinsics.checkNotNullParameter(release, "latestRelease");
        this.this$0._latestValidRelease = release;
        if (this.this$0.getHasEnoughBattery()) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50221i("Check for update, validate success. Latest release: [" + release.getUrl() + ']', new Object[0]);
            this.this$0.alertListenersWithStateChange(FirmwareUpdateService.State.CheckForUpdateSuccess);
            return;
        }
        Timber.Forest forest2 = Timber.Forest;
        forest2.mo50221i("Check for update, validate success. Latest release: [" + release.getUrl() + "]. Insufficient battery error.", new Object[0]);
        this.this$0.alertListenersWithStateChange(FirmwareUpdateService.State.CheckForUpdateSuccessInsufficientBatteryError);
    }
}
