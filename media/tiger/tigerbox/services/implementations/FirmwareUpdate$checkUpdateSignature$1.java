package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "failReason", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$FailReason;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: FirmwareUpdate.kt */
final class FirmwareUpdate$checkUpdateSignature$1 extends Lambda implements Function1<ValidateUpdateSignature.FailReason, Unit> {
    final /* synthetic */ FirmwareUpdate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FirmwareUpdate$checkUpdateSignature$1(FirmwareUpdate firmwareUpdate) {
        super(1);
        this.this$0 = firmwareUpdate;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ValidateUpdateSignature.FailReason) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ValidateUpdateSignature.FailReason failReason) {
        Intrinsics.checkNotNullParameter(failReason, "failReason");
        this.this$0._failReason = FirmwareUpdateService.FailReason.INVALID_SIGNATURE;
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("Check for update, signature validation failed: [" + failReason + ']', new Object[0]);
        this.this$0.alertListenersWithStateChange(FirmwareUpdateService.State.CheckForUpdateFailed);
    }
}
