package media.tiger.tigerbox.p016ui.main.maincontent;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.model.domain.ProductRowDomain;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, mo33737d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "responseList", "", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$handleGetBannerProductListResponse$1 */
/* compiled from: ProductContentViewModel.kt */
final class ProductContentViewModel$handleGetBannerProductListResponse$1 extends Lambda implements Function1<List<? extends ProductDomain>, Job> {
    final /* synthetic */ ProductRowDomain $clickedRow;
    final /* synthetic */ ProductContentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductContentViewModel$handleGetBannerProductListResponse$1(ProductContentViewModel productContentViewModel, ProductRowDomain productRowDomain) {
        super(1);
        this.this$0 = productContentViewModel;
        this.$clickedRow = productRowDomain;
    }

    public final Job invoke(List<ProductDomain> list) {
        Intrinsics.checkNotNullParameter(list, "responseList");
        List arrayList = new ArrayList();
        arrayList.addAll(list);
        this.this$0._productList.setValue(arrayList);
        ProductContentViewModel productContentViewModel = this.this$0;
        ProductRowDomain productRowDomain = this.$clickedRow;
        final ProductContentViewModel productContentViewModel2 = this.this$0;
        return productContentViewModel.fetchNextLinkProductListData(productRowDomain, arrayList, new Function1<List<ProductDomain>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<ProductDomain>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<ProductDomain> list) {
                Intrinsics.checkNotNullParameter(list, "it");
                productContentViewModel2._productList.setValue(list);
            }
        });
    }
}
