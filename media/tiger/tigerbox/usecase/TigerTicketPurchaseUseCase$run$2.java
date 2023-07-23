package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.TigerTicketPurchase;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/domain/TigerTicketPurchase;", "response", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerTicketPurchaseUseCase.kt */
final class TigerTicketPurchaseUseCase$run$2 extends Lambda implements Function1<TigerTicketPurchase, TigerTicketPurchase> {
    public static final TigerTicketPurchaseUseCase$run$2 INSTANCE = new TigerTicketPurchaseUseCase$run$2();

    TigerTicketPurchaseUseCase$run$2() {
        super(1);
    }

    public final TigerTicketPurchase invoke(TigerTicketPurchase tigerTicketPurchase) {
        Intrinsics.checkNotNullParameter(tigerTicketPurchase, "response");
        return tigerTicketPurchase;
    }
}
