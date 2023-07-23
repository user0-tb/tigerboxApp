package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.dto.TigerTicketAssignedProduct;
import media.tiger.tigerbox.usecase.TigerTicketGetProductUseCase;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$getTicketProduct$1", mo34424f = "TicketRedeemTicketNumberViewModel.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$getTicketProduct$1 */
/* compiled from: TicketRedeemTicketNumberViewModel.kt */
final class TicketRedeemTicketNumberViewModel$getTicketProduct$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $code;
    int label;
    final /* synthetic */ TicketRedeemTicketNumberViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TicketRedeemTicketNumberViewModel$getTicketProduct$1(TicketRedeemTicketNumberViewModel ticketRedeemTicketNumberViewModel, String str, Continuation<? super TicketRedeemTicketNumberViewModel$getTicketProduct$1> continuation) {
        super(2, continuation);
        this.this$0 = ticketRedeemTicketNumberViewModel;
        this.$code = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketRedeemTicketNumberViewModel$getTicketProduct$1(this.this$0, this.$code, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketRedeemTicketNumberViewModel$getTicketProduct$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TigerTicketGetProductUseCase access$getTigerTicketGetProductUseCase$p = this.this$0.tigerTicketGetProductUseCase;
            TigerTicketGetProductUseCase.TigerTicketProductParameters tigerTicketProductParameters = new TigerTicketGetProductUseCase.TigerTicketProductParameters(this.$code);
            CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this.this$0);
            final TicketRedeemTicketNumberViewModel ticketRedeemTicketNumberViewModel = this.this$0;
            access$getTigerTicketGetProductUseCase$p.invoke(tigerTicketProductParameters, viewModelScope, new Function1<Either<? extends Failure, ? extends TigerTicketAssignedProduct>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Either<? extends Failure, TigerTicketAssignedProduct>) (Either) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Either<? extends Failure, TigerTicketAssignedProduct> either) {
                    Intrinsics.checkNotNullParameter(either, "it");
                    either.fold(new Function1<Failure, Unit>(ticketRedeemTicketNumberViewModel) {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Failure) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Failure failure) {
                            Intrinsics.checkNotNullParameter(failure, "p0");
                            ((TicketRedeemTicketNumberViewModel) this.receiver).ticketProductFailureHandler(failure);
                        }
                    }, new Function1<TigerTicketAssignedProduct, Unit>(ticketRedeemTicketNumberViewModel) {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((TigerTicketAssignedProduct) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(TigerTicketAssignedProduct tigerTicketAssignedProduct) {
                            ((TicketRedeemTicketNumberViewModel) this.receiver).ticketProductSuccessHandler(tigerTicketAssignedProduct);
                        }
                    });
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
