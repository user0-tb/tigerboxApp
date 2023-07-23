package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.domain.LatestRelease;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "it", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "Lmedia/tiger/tigerbox/model/domain/LatestRelease;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: FirmwareUpdate.kt */
final class FirmwareUpdate$checkForUpdate$1 extends Lambda implements Function1<Either<? extends Failure, ? extends LatestRelease>, Unit> {
    final /* synthetic */ FirmwareUpdate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FirmwareUpdate$checkForUpdate$1(FirmwareUpdate firmwareUpdate) {
        super(1);
        this.this$0 = firmwareUpdate;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, LatestRelease>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Either<? extends Failure, LatestRelease> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        final FirmwareUpdate firmwareUpdate = this.this$0;
        final FirmwareUpdate firmwareUpdate2 = this.this$0;
        either.fold(new Function1<Failure, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "fail");
                firmwareUpdate._failReason = FirmwareUpdateService.FailReason.SERVER_ERROR;
                Timber.Forest forest = Timber.Forest;
                forest.mo50221i("Check for update failed: [" + failure + ']', new Object[0]);
                firmwareUpdate.alertListenersWithStateChange(FirmwareUpdateService.State.CheckForUpdateFailed);
            }
        }, new Function1<LatestRelease, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LatestRelease) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LatestRelease latestRelease) {
                Intrinsics.checkNotNullParameter(latestRelease, "latestRelease");
                if (firmwareUpdate2.requiresUpdate.invoke(latestRelease)) {
                    firmwareUpdate2.checkUpdateSignature();
                    return;
                }
                Timber.Forest.mo50221i("Check for update - no update required.", new Object[0]);
                firmwareUpdate2.alertListenersWithStateChange(FirmwareUpdateService.State.NoUpdateRequired);
            }
        });
    }
}
