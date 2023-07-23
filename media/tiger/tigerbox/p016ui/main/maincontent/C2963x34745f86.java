package media.tiger.tigerbox.p016ui.main.maincontent;

import android.view.View;
import com.andexert.library.RippleView;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductRowAdapter;

/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductRowAdapter$ProductItemViewHolder$$ExternalSyntheticLambda4 */
public final /* synthetic */ class C2963x34745f86 implements RippleView.OnRippleCompleteListener {
    public final /* synthetic */ ProductRowAdapter.ProductItemViewHolder f$0;
    public final /* synthetic */ View f$1;
    public final /* synthetic */ OnItemLongClickListener f$2;

    public /* synthetic */ C2963x34745f86(ProductRowAdapter.ProductItemViewHolder productItemViewHolder, View view, OnItemLongClickListener onItemLongClickListener) {
        this.f$0 = productItemViewHolder;
        this.f$1 = view;
        this.f$2 = onItemLongClickListener;
    }

    public final void onComplete(RippleView rippleView) {
        ProductRowAdapter.ProductItemViewHolder.m2414_init_$lambda3(this.f$0, this.f$1, this.f$2, rippleView);
    }
}
