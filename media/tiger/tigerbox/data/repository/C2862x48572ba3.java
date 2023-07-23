package media.tiger.tigerbox.data.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.infrastructure.functional.EitherKt;
import media.tiger.tigerbox.model.dto.DeviceInformation;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "either", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$updateActiveProfileForCurrentDevice$onDeviceInformationResult$1 */
/* compiled from: TigerBoxUserRepository.kt */
final class C2862x48572ba3 extends Lambda implements Function1<Either<? extends Failure, ? extends DeviceInformation>, Unit> {
    final /* synthetic */ DefaultTigerBoxAccountRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2862x48572ba3(DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository) {
        super(1);
        this.this$0 = defaultTigerBoxAccountRepository;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, DeviceInformation>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Either<? extends Failure, DeviceInformation> either) {
        Intrinsics.checkNotNullParameter(either, "either");
        if (either.isRight()) {
            DeviceInformation deviceInformation = (DeviceInformation) EitherKt.get(either);
            Timber.Forest forest = Timber.Forest;
            forest.mo50221i("setActiveProfileBasedOnDeviceIdentifier: deviceInformation " + deviceInformation, new Object[0]);
            Integer currentProfileId = deviceInformation.getCurrentProfileId();
            if (currentProfileId != null) {
                this.this$0.setActiveProfile(currentProfileId.intValue());
            }
        }
    }
}
