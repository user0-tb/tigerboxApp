package media.tiger.tigerbox.p016ui.main.maincontent;

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
import media.tiger.tigerbox.model.domain.ProductRowDomain;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$getProductList$1$2", mo34424f = "ProductContentViewModel.kt", mo34425i = {}, mo34426l = {574}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$getProductList$1$2 */
/* compiled from: ProductContentViewModel.kt */
final class ProductContentViewModel$getProductList$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProductRowDomain $clickedRow;
    final /* synthetic */ int $ordinal;
    int label;
    final /* synthetic */ ProductContentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductContentViewModel$getProductList$1$2(ProductContentViewModel productContentViewModel, ProductRowDomain productRowDomain, int i, Continuation<? super ProductContentViewModel$getProductList$1$2> continuation) {
        super(2, continuation);
        this.this$0 = productContentViewModel;
        this.$clickedRow = productRowDomain;
        this.$ordinal = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductContentViewModel$getProductList$1$2(this.this$0, this.$clickedRow, this.$ordinal, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProductContentViewModel$getProductList$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GetProductListRequest access$getGetProductListRequest$p = this.this$0.getProductListRequest;
            ProductRowDomain productRowDomain = this.$clickedRow;
            this.label = 1;
            obj = access$getGetProductListRequest$p.invoke(productRowDomain, productRowDomain.getBannerProducts().get(this.$ordinal).getUrl(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ((Either) obj).fold(new Function1<Failure, Unit>(this.this$0) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "p0");
                ((ProductContentViewModel) this.receiver).handleFailure(failure);
            }
        }, this.this$0.handleGetBannerProductListResponse(this.$clickedRow));
        return Unit.INSTANCE;
    }
}
