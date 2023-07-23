package media.tiger.tigerbox.p016ui.main.card;

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
import media.tiger.tigerbox.model.domain.TigerTicketPurchase;
import media.tiger.tigerbox.usecase.TigerTicketPurchaseUseCase;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel$purchase$1", mo34424f = "TigerTicketPurchaseViewModel.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel$purchase$1 */
/* compiled from: TigerTicketPurchaseViewModel.kt */
final class TigerTicketPurchaseViewModel$purchase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $code;
    final /* synthetic */ String $pin;
    int label;
    final /* synthetic */ TigerTicketPurchaseViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TigerTicketPurchaseViewModel$purchase$1(TigerTicketPurchaseViewModel tigerTicketPurchaseViewModel, String str, String str2, Continuation<? super TigerTicketPurchaseViewModel$purchase$1> continuation) {
        super(2, continuation);
        this.this$0 = tigerTicketPurchaseViewModel;
        this.$code = str;
        this.$pin = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TigerTicketPurchaseViewModel$purchase$1(this.this$0, this.$code, this.$pin, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TigerTicketPurchaseViewModel$purchase$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TigerTicketPurchaseUseCase access$getTigerTicketPurchaseUseCase$p = this.this$0.tigerTicketPurchaseUseCase;
            TigerTicketPurchaseUseCase.RequestParams requestParams = new TigerTicketPurchaseUseCase.RequestParams(this.$code, this.$pin);
            CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this.this$0);
            final TigerTicketPurchaseViewModel tigerTicketPurchaseViewModel = this.this$0;
            access$getTigerTicketPurchaseUseCase$p.invoke(requestParams, viewModelScope, new Function1<Either<? extends Failure, ? extends TigerTicketPurchase>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Either<? extends Failure, TigerTicketPurchase>) (Either) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Either<? extends Failure, TigerTicketPurchase> either) {
                    Intrinsics.checkNotNullParameter(either, "it");
                    either.fold(new Function1<Failure, Unit>(tigerTicketPurchaseViewModel) {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Failure) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Failure failure) {
                            Intrinsics.checkNotNullParameter(failure, "p0");
                            ((TigerTicketPurchaseViewModel) this.receiver).orderFailureHandler(failure);
                        }
                    }, new Function1<TigerTicketPurchase, Unit>(tigerTicketPurchaseViewModel) {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((TigerTicketPurchase) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(TigerTicketPurchase tigerTicketPurchase) {
                            ((TigerTicketPurchaseViewModel) this.receiver).orderSuccessHandler(tigerTicketPurchase);
                        }
                    });
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
