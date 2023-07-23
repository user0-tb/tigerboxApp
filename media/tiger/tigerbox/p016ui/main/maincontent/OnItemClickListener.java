package media.tiger.tigerbox.p016ui.main.maincontent;

import kotlin.Metadata;
import media.tiger.tigerbox.model.domain.ProductDomain;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;", "", "onBannerItemClick", "", "rowId", "", "ordinal", "onProductItemClick", "product", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.OnItemClickListener */
/* compiled from: ProductListMainContentFragment.kt */
public interface OnItemClickListener {
    void onBannerItemClick(int i, int i2);

    void onProductItemClick(ProductDomain productDomain, int i);
}
