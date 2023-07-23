package media.tiger.tigerbox.p016ui.main.maincontent;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.ProductDomain;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductItemDiffCallback */
/* compiled from: ProductRowAdapter.kt */
public final class ProductItemDiffCallback extends DiffUtil.ItemCallback<ProductDomain> {
    public boolean areItemsTheSame(ProductDomain productDomain, ProductDomain productDomain2) {
        Intrinsics.checkNotNullParameter(productDomain, "oldItem");
        Intrinsics.checkNotNullParameter(productDomain2, "newItem");
        return productDomain.getId() == productDomain2.getId();
    }

    public boolean areContentsTheSame(ProductDomain productDomain, ProductDomain productDomain2) {
        Intrinsics.checkNotNullParameter(productDomain, "oldItem");
        Intrinsics.checkNotNullParameter(productDomain2, "newItem");
        return Intrinsics.areEqual((Object) productDomain, (Object) productDomain2);
    }
}
