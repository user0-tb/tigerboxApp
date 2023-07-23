package media.tiger.tigerbox.p016ui.main.seemoreproducts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.ItemProductBinding;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.p016ui.main.maincontent.OnItemClickListener;
import media.tiger.tigerbox.p016ui.main.maincontent.OnItemLongClickListener;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductRowAdapter;
import media.tiger.tigerbox.p016ui.main.seemoreproducts.ProductListItem;

@Metadata(mo33736d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001b\u001cB!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lmedia/tiger/tigerbox/ui/main/seemoreproducts/ProductListItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onItemClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;", "onItemLongClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;", "headerText", "", "(Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;Ljava/lang/String;)V", "addHeader", "", "Lmedia/tiger/tigerbox/ui/main/seemoreproducts/ProductListItem$Header;", "addHeaderAndSubmitList", "", "list", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "getItemViewType", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "HeaderViewHolder", "SeeMoreProductItemViewHolder", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreListAdapter */
/* compiled from: SeeMoreListAdapter.kt */
public final class SeeMoreListAdapter extends ListAdapter<ProductListItem, RecyclerView.ViewHolder> {
    private final String headerText;
    private final OnItemClickListener onItemClick;
    private final OnItemLongClickListener onItemLongClick;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SeeMoreListAdapter(OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(onItemClickListener, onItemLongClickListener, (i & 4) != 0 ? "" : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeeMoreListAdapter(OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener, String str) {
        super(new SeeMoreViewHolderProductItemDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClick");
        Intrinsics.checkNotNullParameter(str, "headerText");
        this.onItemClick = onItemClickListener;
        this.onItemLongClick = onItemLongClickListener;
        this.headerText = str;
    }

    public final void addHeaderAndSubmitList(List<ProductDomain> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (!list.isEmpty()) {
            Collection addHeader = addHeader();
            Iterable<ProductDomain> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (ProductDomain productItem : iterable) {
                arrayList.add(new ProductListItem.ProductItem(productItem));
            }
            submitList(CollectionsKt.plus(addHeader, (List) arrayList));
            return;
        }
        submitList((List) null);
    }

    private final List<ProductListItem.Header> addHeader() {
        if (this.headerText.length() > 0) {
            return CollectionsKt.listOf(ProductListItem.Header.INSTANCE);
        }
        return CollectionsKt.emptyList();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            return HeaderViewHolder.Companion.createFrom(viewGroup, this.headerText);
        }
        if (i == 1) {
            return SeeMoreProductItemViewHolder.Companion.createFrom(viewGroup, this.onItemClick, this.onItemLongClick);
        }
        throw new ClassCastException("Unknown viewType " + i);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof SeeMoreProductItemViewHolder) {
            Object item = getItem(i);
            Objects.requireNonNull(item, "null cannot be cast to non-null type media.tiger.tigerbox.ui.main.seemoreproducts.ProductListItem.ProductItem");
            ((SeeMoreProductItemViewHolder) viewHolder).bind((ProductListItem.ProductItem) item);
        }
    }

    public int getItemViewType(int i) {
        ProductListItem productListItem = (ProductListItem) getItem(i);
        if (productListItem instanceof ProductListItem.Header) {
            return 0;
        }
        if (productListItem instanceof ProductListItem.ProductItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreListAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreListAdapter$HeaderViewHolder */
    /* compiled from: SeeMoreListAdapter.kt */
    public static final class HeaderViewHolder extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreListAdapter$HeaderViewHolder$Companion;", "", "()V", "createFrom", "Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreListAdapter$HeaderViewHolder;", "parent", "Landroid/view/ViewGroup;", "headerText", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreListAdapter$HeaderViewHolder$Companion */
        /* compiled from: SeeMoreListAdapter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final HeaderViewHolder createFrom(ViewGroup viewGroup, String str) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                Intrinsics.checkNotNullParameter(str, "headerText");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C2814R.C2819layout.offline_mode_list_header, viewGroup, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) inflate;
                textView.setText(str);
                return new HeaderViewHolder(textView);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreListAdapter$SeeMoreProductItemViewHolder;", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductRowAdapter$ProductItemViewHolder;", "binding", "Lmedia/tiger/tigerbox/databinding/ItemProductBinding;", "onItemClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;", "onItemLongClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;", "(Lmedia/tiger/tigerbox/databinding/ItemProductBinding;Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;)V", "bind", "", "item", "Lmedia/tiger/tigerbox/ui/main/seemoreproducts/ProductListItem$ProductItem;", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreListAdapter$SeeMoreProductItemViewHolder */
    /* compiled from: SeeMoreListAdapter.kt */
    public static final class SeeMoreProductItemViewHolder extends ProductRowAdapter.ProductItemViewHolder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final ItemProductBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SeeMoreProductItemViewHolder(ItemProductBinding itemProductBinding, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
            super(itemProductBinding, onItemClickListener, onItemLongClickListener);
            Intrinsics.checkNotNullParameter(itemProductBinding, "binding");
            Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClick");
            this.binding = itemProductBinding;
            itemProductBinding.ripple.setOnClickListener(new C2979x26ba1835(onItemClickListener, this));
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final void m2467_init_$lambda0(OnItemClickListener onItemClickListener, SeeMoreProductItemViewHolder seeMoreProductItemViewHolder, View view) {
            Intrinsics.checkNotNullParameter(onItemClickListener, "$onItemClick");
            Intrinsics.checkNotNullParameter(seeMoreProductItemViewHolder, "this$0");
            onItemClickListener.onProductItemClick(seeMoreProductItemViewHolder.getProduct(), -1);
        }

        @Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreListAdapter$SeeMoreProductItemViewHolder$Companion;", "", "()V", "createFrom", "Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreListAdapter$SeeMoreProductItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "onItemClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;", "onItemLongClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreListAdapter$SeeMoreProductItemViewHolder$Companion */
        /* compiled from: SeeMoreListAdapter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final SeeMoreProductItemViewHolder createFrom(ViewGroup viewGroup, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClick");
                ItemProductBinding inflate = ItemProductBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
                return new SeeMoreProductItemViewHolder(inflate, onItemClickListener, onItemLongClickListener);
            }
        }

        public final void bind(ProductListItem.ProductItem productItem) {
            Intrinsics.checkNotNullParameter(productItem, "item");
            ItemProductBinding itemProductBinding = this.binding;
            setProduct(productItem.getProductDomain());
            itemProductBinding.setBindingProduct(productItem.getProductDomain());
            itemProductBinding.productAction.setBindingProduct(productItem.getProductDomain());
        }
    }
}
