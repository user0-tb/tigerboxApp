package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.dto.TigerTicketAssignedProduct;
import media.tiger.tigerbox.usecase.TigerTicketGetProductUseCase;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.usecase.TigerTicketGetProductUseCase", mo34424f = "TigerTicketGetProductUseCase.kt", mo34425i = {}, mo34426l = {26}, mo34427m = "run", mo34428n = {}, mo34429s = {})
/* compiled from: TigerTicketGetProductUseCase.kt */
final class TigerTicketGetProductUseCase$run$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TigerTicketGetProductUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TigerTicketGetProductUseCase$run$1(TigerTicketGetProductUseCase tigerTicketGetProductUseCase, Continuation<? super TigerTicketGetProductUseCase$run$1> continuation) {
        super(continuation);
        this.this$0 = tigerTicketGetProductUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run((TigerTicketGetProductUseCase.TigerTicketProductParameters) null, (Continuation<? super Either<? extends Failure, TigerTicketAssignedProduct>>) this);
    }
}
