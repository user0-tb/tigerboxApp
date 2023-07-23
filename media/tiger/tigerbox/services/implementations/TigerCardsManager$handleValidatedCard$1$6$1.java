package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.dto.TigerTicketAssignedProduct;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "tigerTicketGetProductUseCaseResult", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerCardsManager.kt */
final class TigerCardsManager$handleValidatedCard$1$6$1 extends Lambda implements Function1<Either<? extends Failure, ? extends TigerTicketAssignedProduct>, Unit> {
    final /* synthetic */ TigerCardsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TigerCardsManager$handleValidatedCard$1$6$1(TigerCardsManager tigerCardsManager) {
        super(1);
        this.this$0 = tigerCardsManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, TigerTicketAssignedProduct>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Either<? extends Failure, TigerTicketAssignedProduct> either) {
        Intrinsics.checkNotNullParameter(either, "tigerTicketGetProductUseCaseResult");
        either.fold(new Function1<Failure, Unit>(this.this$0) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "p0");
                ((TigerCardsManager) this.receiver).handleTicketValidateFailure(failure);
            }
        }, new Function1<TigerTicketAssignedProduct, Unit>(this.this$0) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TigerTicketAssignedProduct) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(TigerTicketAssignedProduct tigerTicketAssignedProduct) {
                ((TigerCardsManager) this.receiver).handleTicketValidateResponse(tigerTicketAssignedProduct);
            }
        });
    }
}
