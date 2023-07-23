package media.tiger.tigerbox.p016ui.main.seemoreproducts;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreViewHolderProductItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lmedia/tiger/tigerbox/ui/main/seemoreproducts/ProductListItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreViewHolderProductItemDiffCallback */
/* compiled from: SeeMoreListAdapter.kt */
public final class SeeMoreViewHolderProductItemDiffCallback extends DiffUtil.ItemCallback<ProductListItem> {
    public boolean areItemsTheSame(ProductListItem productListItem, ProductListItem productListItem2) {
        Intrinsics.checkNotNullParameter(productListItem, "oldItem");
        Intrinsics.checkNotNullParameter(productListItem2, "newItem");
        return productListItem.getId() == productListItem2.getId();
    }

    public boolean areContentsTheSame(ProductListItem productListItem, ProductListItem productListItem2) {
        Intrinsics.checkNotNullParameter(productListItem, "oldItem");
        Intrinsics.checkNotNullParameter(productListItem2, "newItem");
        return Intrinsics.areEqual((Object) productListItem, (Object) productListItem2);
    }
}
