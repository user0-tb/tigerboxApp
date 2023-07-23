package media.tiger.tigerbox.p016ui.main.maincontent;

import com.google.android.exoplayer2.RendererCapabilities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.model.domain.ProductRowDomain;
import media.tiger.tigerbox.model.domain.ProductSource;
import media.tiger.tigerbox.model.dto.ProductList;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0002\b\u0007"}, mo33737d2 = {"<anonymous>", "", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "productList", "Lmedia/tiger/tigerbox/model/dto/ProductList;", "headerResponseLink", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.GetProductListRequest$requestProductList$2 */
/* compiled from: GetProductListRequest.kt */
final class GetProductListRequest$requestProductList$2 extends Lambda implements Function2<ProductList, String, List<? extends ProductDomain>> {
    final /* synthetic */ ProductRowDomain $mainContentList;
    final /* synthetic */ GetProductListRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetProductListRequest$requestProductList$2(ProductRowDomain productRowDomain, GetProductListRequest getProductListRequest) {
        super(2);
        this.$mainContentList = productRowDomain;
        this.this$0 = getProductListRequest;
    }

    public final List<ProductDomain> invoke(ProductList productList, String str) {
        String str2;
        ProductList.ProductItem.Cover.ContentLocation contentLocation;
        ProductList productList2 = productList;
        Intrinsics.checkNotNullParameter(productList2, "productList");
        this.$mainContentList.setHeaderResponseLink(str == null ? "" : str);
        Iterable<ProductList.ProductItem> iterable = productList2;
        GetProductListRequest getProductListRequest = this.this$0;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProductList.ProductItem productItem : iterable) {
            int id = productItem.getId();
            String title = productItem.getTitle();
            String author = productItem.getAuthor();
            ProductList.ProductItem.Cover cover = productItem.getCover();
            String location = (cover == null || (contentLocation = cover.getContentLocation()) == null) ? null : contentLocation.getLocation();
            if (location == null) {
                str2 = "";
            } else {
                str2 = location;
            }
            ProductDomain productDomain = r6;
            ProductDomain productDomain2 = new ProductDomain(id, title, author, str2, false, AvailabilityService.DefaultImpls.offlineAvailabilityStateFor$default(getProductListRequest.availabilityService, productItem.getId(), false, 2, (Object) null), getProductListRequest.availabilityService.offlineAvailabilityReason(productItem.getId()), false, (ProductSource) null, RendererCapabilities.MODE_SUPPORT_MASK, (DefaultConstructorMarker) null);
            arrayList.add(productDomain);
        }
        return (List) arrayList;
    }
}
