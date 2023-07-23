package media.tiger.tigerbox.p016ui.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.domain.ReportInformation;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "it", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "Lmedia/tiger/tigerbox/model/domain/ReportInformation;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsWifiViewModel$sendDeviceInformation$1 */
/* compiled from: SettingsWifiViewModel.kt */
final class SettingsWifiViewModel$sendDeviceInformation$1 extends Lambda implements Function1<Either<? extends Failure, ? extends ReportInformation>, Unit> {
    public static final SettingsWifiViewModel$sendDeviceInformation$1 INSTANCE = new SettingsWifiViewModel$sendDeviceInformation$1();

    SettingsWifiViewModel$sendDeviceInformation$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, ReportInformation>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Either<? extends Failure, ReportInformation> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        either.fold(C30151.INSTANCE, C30162.INSTANCE);
    }
}
