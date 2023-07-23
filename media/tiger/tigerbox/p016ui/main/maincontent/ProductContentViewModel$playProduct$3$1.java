package media.tiger.tigerbox.p016ui.main.maincontent;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.ProductDomain;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, mo33737d2 = {"<anonymous>", "", "it", "", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$playProduct$3$1 */
/* compiled from: ProductContentViewModel.kt */
final class ProductContentViewModel$playProduct$3$1 extends Lambda implements Function1<List<ProductDomain>, Unit> {
    final /* synthetic */ ProductDomain $product;
    final /* synthetic */ ProductContentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductContentViewModel$playProduct$3$1(ProductContentViewModel productContentViewModel, ProductDomain productDomain) {
        super(1);
        this.this$0 = productContentViewModel;
        this.$product = productDomain;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<ProductDomain>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ProductDomain> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        this.this$0.startPlaybackWithRowProducts(this.$product, list);
    }
}
