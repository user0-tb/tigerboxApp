package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.model.domain.PinInfo;
import media.tiger.tigerbox.model.domain.TigerTicketValidationResponse;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/domain/PinInfo;", "response", "Lmedia/tiger/tigerbox/model/domain/TigerTicketValidationResponse;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerTicketValidatePinUseCase.kt */
final class TigerTicketValidatePinUseCase$run$2 extends Lambda implements Function1<TigerTicketValidationResponse, PinInfo> {
    public static final TigerTicketValidatePinUseCase$run$2 INSTANCE = new TigerTicketValidatePinUseCase$run$2();

    TigerTicketValidatePinUseCase$run$2() {
        super(1);
    }

    public final PinInfo invoke(TigerTicketValidationResponse tigerTicketValidationResponse) {
        Intrinsics.checkNotNullParameter(tigerTicketValidationResponse, "response");
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("TigerTicketValidatePinUseCase response " + tigerTicketValidationResponse, new Object[0]);
        boolean valid = tigerTicketValidationResponse.getValid();
        int code = tigerTicketValidationResponse.getCode();
        String value = tigerTicketValidationResponse.getValue();
        return new PinInfo(valid, code, (value != null ? StringsKt.toIntOrNull(value) : null) == null ? -1 : Integer.parseInt(tigerTicketValidationResponse.getValue()), tigerTicketValidationResponse.getErrorCode());
    }
}
