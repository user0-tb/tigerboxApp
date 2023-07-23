package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.dto.Acquisition;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/dto/Acquisition;", "acquisition", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RequestAcquisitionUseCase.kt */
final class RequestAcquisitionUseCase$run$2 extends Lambda implements Function1<Acquisition, Acquisition> {
    public static final RequestAcquisitionUseCase$run$2 INSTANCE = new RequestAcquisitionUseCase$run$2();

    RequestAcquisitionUseCase$run$2() {
        super(1);
    }

    public final Acquisition invoke(Acquisition acquisition) {
        Intrinsics.checkNotNullParameter(acquisition, "acquisition");
        return acquisition;
    }
}
