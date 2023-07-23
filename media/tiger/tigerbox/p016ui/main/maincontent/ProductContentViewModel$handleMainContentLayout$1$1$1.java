package media.tiger.tigerbox.p016ui.main.maincontent;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.model.domain.ProductRowDomain;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$handleMainContentLayout$1$1$1", mo34424f = "ProductContentViewModel.kt", mo34425i = {}, mo34426l = {370}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$handleMainContentLayout$1$1$1 */
/* compiled from: ProductContentViewModel.kt */
final class ProductContentViewModel$handleMainContentLayout$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ List<ProductRowDomain> $newList;
    final /* synthetic */ ProductRowDomain $row;
    int label;
    final /* synthetic */ ProductContentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductContentViewModel$handleMainContentLayout$1$1$1(ProductContentViewModel productContentViewModel, ProductRowDomain productRowDomain, int i, List<ProductRowDomain> list, Continuation<? super ProductContentViewModel$handleMainContentLayout$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = productContentViewModel;
        this.$row = productRowDomain;
        this.$index = i;
        this.$newList = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductContentViewModel$handleMainContentLayout$1$1$1(this.this$0, this.$row, this.$index, this.$newList, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((ProductContentViewModel$handleMainContentLayout$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GetProductListRequest access$getGetProductListRequest$p = this.this$0.getProductListRequest;
            ProductRowDomain productRowDomain = this.$row;
            this.label = 1;
            obj = access$getGetProductListRequest$p.invoke(productRowDomain, productRowDomain.getUrl(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final ProductContentViewModel productContentViewModel = this.this$0;
        final ProductRowDomain productRowDomain2 = this.$row;
        final int i2 = this.$index;
        final List<ProductRowDomain> list = this.$newList;
        final ProductContentViewModel productContentViewModel2 = this.this$0;
        final ProductRowDomain productRowDomain3 = this.$row;
        final List<ProductRowDomain> list2 = this.$newList;
        return ((Either) obj).fold(new Function1<Failure, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Failure failure) {
                Object obj;
                ProductRowDomain productRowDomain;
                List<ProductDomain> products;
                Intrinsics.checkNotNullParameter(failure, "failure");
                List value = productContentViewModel.getMainContent().getValue();
                if (value != null) {
                    ProductRowDomain productRowDomain2 = productRowDomain2;
                    Iterator it = value.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.areEqual((Object) productRowDomain2.getTitle(), (Object) ((ProductRowDomain) obj).getTitle())) {
                            break;
                        }
                    }
                    ProductRowDomain productRowDomain3 = (ProductRowDomain) obj;
                    if (productRowDomain3 != null) {
                        int i = i2;
                        List<ProductRowDomain> list = list;
                        if (i >= 0 && i < list.size() && (productRowDomain = (ProductRowDomain) CollectionsKt.getOrNull(list, i)) != null && (products = productRowDomain.getProducts()) != null) {
                            products.addAll(productRowDomain3.getProducts());
                        }
                    }
                }
                Function1<Failure, Unit> onFail = productContentViewModel.getOnFail();
                if (onFail != null) {
                    onFail.invoke(failure);
                }
            }
        }, new Function1<List<? extends ProductDomain>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<ProductDomain>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<ProductDomain> list) {
                Intrinsics.checkNotNullParameter(list, "list");
                productContentViewModel2.filterNonBannerWithContent(productRowDomain3, list2, list);
            }
        });
    }
}
