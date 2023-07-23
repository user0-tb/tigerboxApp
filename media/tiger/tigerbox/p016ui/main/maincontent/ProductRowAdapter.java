package media.tiger.tigerbox.p016ui.main.maincontent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.andexert.library.RippleView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.ItemProductActionBinding;
import media.tiger.tigerbox.databinding.ItemProductBinding;
import media.tiger.tigerbox.model.domain.OfflineAvailabilityState;
import media.tiger.tigerbox.model.domain.ProductDomain;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductRowAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductRowAdapter$ProductItemViewHolder;", "onItemClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;", "onItemLongClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;", "rowId", "", "(Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;I)V", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ProductItemViewHolder", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductRowAdapter */
/* compiled from: ProductRowAdapter.kt */
public final class ProductRowAdapter extends ListAdapter<ProductDomain, ProductItemViewHolder> {
    private final OnItemClickListener onItemClick;
    private final OnItemLongClickListener onItemLongClick;
    private final int rowId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductRowAdapter(OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener, int i) {
        super(new ProductItemDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClick");
        this.onItemClick = onItemClickListener;
        this.onItemLongClick = onItemLongClickListener;
        this.rowId = i;
    }

    public ProductItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return ProductItemViewHolder.Companion.createFrom(viewGroup, this.onItemClick, this.onItemLongClick);
    }

    public void onBindViewHolder(ProductItemViewHolder productItemViewHolder, int i) {
        Intrinsics.checkNotNullParameter(productItemViewHolder, "holder");
        try {
            Object item = getItem(i);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
            productItemViewHolder.bind((ProductDomain) item, i, this.rowId);
        } catch (Exception e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("ProductRowAdapter onBindViewHolder exception " + e, new Object[0]);
        }
    }

    @Metadata(mo33736d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductRowAdapter$ProductItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lmedia/tiger/tigerbox/databinding/ItemProductBinding;", "onItemClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;", "onItemLongClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;", "(Lmedia/tiger/tigerbox/databinding/ItemProductBinding;Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;)V", "product", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "getProduct", "()Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "setProduct", "(Lmedia/tiger/tigerbox/model/domain/ProductDomain;)V", "productItemPosition", "", "selectedRowId", "bind", "", "item", "itemPosition", "rowId", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductRowAdapter$ProductItemViewHolder */
    /* compiled from: ProductRowAdapter.kt */
    public static class ProductItemViewHolder extends RecyclerView.ViewHolder {
        public static final int CLICK_TYPE = 2131361795;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final ItemProductBinding binding;
        public ProductDomain product;
        private int productItemPosition = -1;
        private int selectedRowId;

        @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductRowAdapter$ProductItemViewHolder$WhenMappings */
        /* compiled from: ProductRowAdapter.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[OfflineAvailabilityState.values().length];
                iArr[OfflineAvailabilityState.AVAILABLE.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProductItemViewHolder(ItemProductBinding itemProductBinding, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
            super(itemProductBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemProductBinding, "binding");
            Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClick");
            this.binding = itemProductBinding;
            itemProductBinding.ripple.setOnClickListener(new C2960x34745f83(this, onItemClickListener));
            if (onItemLongClickListener != null) {
                View root = itemProductBinding.productAction.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.productAction.root");
                ItemProductActionBinding itemProductActionBinding = (ItemProductActionBinding) DataBindingUtil.getBinding(root);
                if (itemProductActionBinding != null) {
                    itemProductActionBinding.setExitButtonListener(new C2959x34745f82(this, itemProductActionBinding));
                }
                if (itemProductActionBinding != null) {
                    itemProductActionBinding.setAcceptButtonListener(new C2961x34745f84(this, onItemLongClickListener, root));
                }
                itemProductBinding.ripple.setOnRippleCompleteListener(new C2963x34745f86(this, root, onItemLongClickListener));
                itemProductBinding.ripple.setOnLongClickListener(new C2962x34745f85(this));
            }
        }

        public ProductDomain getProduct() {
            ProductDomain productDomain = this.product;
            if (productDomain != null) {
                return productDomain;
            }
            Intrinsics.throwUninitializedPropertyAccessException("product");
            return null;
        }

        public void setProduct(ProductDomain productDomain) {
            Intrinsics.checkNotNullParameter(productDomain, "<set-?>");
            this.product = productDomain;
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final void m2411_init_$lambda0(ProductItemViewHolder productItemViewHolder, OnItemClickListener onItemClickListener, View view) {
            Intrinsics.checkNotNullParameter(productItemViewHolder, "this$0");
            Intrinsics.checkNotNullParameter(onItemClickListener, "$onItemClick");
            productItemViewHolder.binding.ripple.setTag(C2814R.C2817id.CLICK_TYPE, false);
            if (productItemViewHolder.getProduct().isBanner()) {
                onItemClickListener.onBannerItemClick(productItemViewHolder.selectedRowId, productItemViewHolder.productItemPosition);
            } else {
                onItemClickListener.onProductItemClick(productItemViewHolder.getProduct(), productItemViewHolder.selectedRowId);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-1  reason: not valid java name */
        public static final void m2412_init_$lambda1(ProductItemViewHolder productItemViewHolder, ItemProductActionBinding itemProductActionBinding, View view) {
            Intrinsics.checkNotNullParameter(productItemViewHolder, "this$0");
            productItemViewHolder.getProduct().setSelected(false);
            ConstraintLayout constraintLayout = itemProductActionBinding != null ? itemProductActionBinding.productActionContainer : null;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-2  reason: not valid java name */
        public static final void m2413_init_$lambda2(ProductItemViewHolder productItemViewHolder, OnItemLongClickListener onItemLongClickListener, View view, View view2) {
            Intrinsics.checkNotNullParameter(productItemViewHolder, "this$0");
            Intrinsics.checkNotNullParameter(view, "$productAction");
            if (WhenMappings.$EnumSwitchMapping$0[productItemViewHolder.getProduct().getOfflineAvailabilityState().ordinal()] == 1) {
                onItemLongClickListener.removeDownloadedProduct(productItemViewHolder.getProduct());
            } else {
                onItemLongClickListener.startDownloadOfProduct(productItemViewHolder.getProduct());
            }
            view.setVisibility(8);
            productItemViewHolder.getProduct().setSelected(false);
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-3  reason: not valid java name */
        public static final void m2414_init_$lambda3(ProductItemViewHolder productItemViewHolder, View view, OnItemLongClickListener onItemLongClickListener, RippleView rippleView) {
            Intrinsics.checkNotNullParameter(productItemViewHolder, "this$0");
            Intrinsics.checkNotNullParameter(view, "$productAction");
            if (Intrinsics.areEqual(productItemViewHolder.binding.ripple.getTag(C2814R.C2817id.CLICK_TYPE), (Object) true)) {
                if (!productItemViewHolder.getProduct().isBanner() && productItemViewHolder.getProduct().getOfflineAvailabilityState() != OfflineAvailabilityState.IN_PROGRESS) {
                    view.setVisibility(0);
                    productItemViewHolder.getProduct().setSelected(true);
                }
                onItemLongClickListener.onItemLongClickListener(productItemViewHolder.getProduct());
            }
            productItemViewHolder.binding.ripple.setTag(C2814R.C2817id.CLICK_TYPE, (Object) null);
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-4  reason: not valid java name */
        public static final boolean m2415_init_$lambda4(ProductItemViewHolder productItemViewHolder, View view) {
            Intrinsics.checkNotNullParameter(productItemViewHolder, "this$0");
            productItemViewHolder.binding.ripple.setTag(C2814R.C2817id.CLICK_TYPE, true);
            productItemViewHolder.binding.ripple.animate();
            return true;
        }

        @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductRowAdapter$ProductItemViewHolder$Companion;", "", "()V", "CLICK_TYPE", "", "createFrom", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductRowAdapter$ProductItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "onItemClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;", "onItemLongClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductRowAdapter$ProductItemViewHolder$Companion */
        /* compiled from: ProductRowAdapter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ProductItemViewHolder createFrom(ViewGroup viewGroup, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClick");
                ItemProductBinding inflate = ItemProductBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
                return new ProductItemViewHolder(inflate, onItemClickListener, onItemLongClickListener);
            }
        }

        public final void bind(ProductDomain productDomain, int i, int i2) {
            Intrinsics.checkNotNullParameter(productDomain, "item");
            this.selectedRowId = i2;
            ItemProductBinding itemProductBinding = this.binding;
            setProduct(productDomain);
            this.productItemPosition = i;
            itemProductBinding.setBindingProduct(productDomain);
            itemProductBinding.productAction.setBindingProduct(productDomain);
        }
    }
}
