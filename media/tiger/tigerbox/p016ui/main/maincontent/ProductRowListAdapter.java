package media.tiger.tigerbox.p016ui.main.maincontent;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.RendererCapabilities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.databinding.ItemProductRowBinding;
import media.tiger.tigerbox.model.domain.BannerProductDomain;
import media.tiger.tigerbox.model.domain.DownloadReason;
import media.tiger.tigerbox.model.domain.OfflineAvailabilityState;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.model.domain.ProductRowDomain;
import media.tiger.tigerbox.model.domain.ProductRowType;
import media.tiger.tigerbox.model.domain.ProductSource;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;
import media.tiger.tigerbox.p016ui.common.ScrollStateHolder;

@Metadata(mo33736d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B'\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bB/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0014H\u0001¢\u0006\u0002\b\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u001a\u0010 \u001a\u00020\u00182\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0014H\u0016R\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductRowListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lmedia/tiger/tigerbox/model/domain/ProductRowDomain;", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductRowListAdapter$ProductRowListViewHolder;", "onItemClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;", "onItemLongClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;", "onFooterItemClick", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "", "(Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;)V", "scrollStateHolder", "Lmedia/tiger/tigerbox/ui/common/ScrollStateHolder;", "(Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;Lmedia/tiger/tigerbox/ui/common/ScrollStateHolder;)V", "chunkedListMode", "", "viewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "chunkList", "", "list", "chunkList$app_tigerBoxRelease", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "submitList", "ProductRowListViewHolder", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductRowListAdapter */
/* compiled from: ProductRowListAdapter.kt */
public final class ProductRowListAdapter extends ListAdapter<ProductRowDomain, ProductRowListViewHolder> {
    private final boolean chunkedListMode;
    private final BindingClickListener<Integer> onFooterItemClick;
    private final OnItemClickListener onItemClick;
    private final OnItemLongClickListener onItemLongClick;
    private final ScrollStateHolder scrollStateHolder;
    private final RecyclerView.RecycledViewPool viewPool;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductRowListAdapter(OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener, BindingClickListener<Integer> bindingClickListener, ScrollStateHolder scrollStateHolder2) {
        super(ProductRowDiffCallback.INSTANCE);
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClick");
        Intrinsics.checkNotNullParameter(bindingClickListener, "onFooterItemClick");
        this.onItemClick = onItemClickListener;
        this.onItemLongClick = onItemLongClickListener;
        this.onFooterItemClick = bindingClickListener;
        this.scrollStateHolder = scrollStateHolder2;
        this.viewPool = new RecyclerView.RecycledViewPool();
    }

    public void submitList(List<ProductRowDomain> list) {
        if (this.chunkedListMode) {
            boolean z = false;
            if (list != null && (!list.isEmpty())) {
                z = true;
            }
            if (z) {
                super.submitList(chunkList$app_tigerBoxRelease(list));
                return;
            }
        }
        super.submitList(list != null ? new ArrayList(list) : null);
    }

    public ProductRowListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ProductRowListViewHolder createFrom = ProductRowListViewHolder.Companion.createFrom(viewGroup, this.onItemClick, this.onItemLongClick, this.onFooterItemClick, this.scrollStateHolder, this.viewPool);
        createFrom.onCreate();
        return createFrom;
    }

    public void onBindViewHolder(ProductRowListViewHolder productRowListViewHolder, int i) {
        Intrinsics.checkNotNullParameter(productRowListViewHolder, "holder");
        Object item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        productRowListViewHolder.bind((ProductRowDomain) item);
    }

    public void onViewRecycled(ProductRowListViewHolder productRowListViewHolder) {
        Intrinsics.checkNotNullParameter(productRowListViewHolder, "holder");
        super.onViewRecycled(productRowListViewHolder);
        productRowListViewHolder.onRecycled();
    }

    @Metadata(mo33736d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductRowListAdapter$ProductRowListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lmedia/tiger/tigerbox/ui/common/ScrollStateHolder$ScrollStateKeyProvider;", "binding", "Lmedia/tiger/tigerbox/databinding/ItemProductRowBinding;", "onItemClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;", "onItemLongClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;", "onFooterItemClick", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "", "scrollStateHolder", "Lmedia/tiger/tigerbox/ui/common/ScrollStateHolder;", "viewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "(Lmedia/tiger/tigerbox/databinding/ItemProductRowBinding;Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;Lmedia/tiger/tigerbox/ui/common/ScrollStateHolder;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "row", "Lmedia/tiger/tigerbox/model/domain/ProductRowDomain;", "bind", "", "item", "getScrollStateKey", "", "onCreate", "onRecycled", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductRowListAdapter$ProductRowListViewHolder */
    /* compiled from: ProductRowListAdapter.kt */
    public static final class ProductRowListViewHolder extends RecyclerView.ViewHolder implements ScrollStateHolder.ScrollStateKeyProvider {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final ItemProductRowBinding binding;
        private final LinearLayoutManager linearLayoutManager;
        private final BindingClickListener<Integer> onFooterItemClick;
        private final OnItemClickListener onItemClick;
        private final OnItemLongClickListener onItemLongClick;
        private ProductRowDomain row;
        private final ScrollStateHolder scrollStateHolder;
        private final RecyclerView.RecycledViewPool viewPool;

        @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductRowListAdapter$ProductRowListViewHolder$WhenMappings */
        /* compiled from: ProductRowListAdapter.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProductRowType.values().length];
                iArr[ProductRowType.BANNER.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProductRowListViewHolder(ItemProductRowBinding itemProductRowBinding, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener, BindingClickListener<Integer> bindingClickListener, ScrollStateHolder scrollStateHolder2, RecyclerView.RecycledViewPool recycledViewPool) {
            super(itemProductRowBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemProductRowBinding, "binding");
            Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClick");
            Intrinsics.checkNotNullParameter(bindingClickListener, "onFooterItemClick");
            Intrinsics.checkNotNullParameter(recycledViewPool, "viewPool");
            this.binding = itemProductRowBinding;
            this.onItemClick = onItemClickListener;
            this.onItemLongClick = onItemLongClickListener;
            this.onFooterItemClick = bindingClickListener;
            this.scrollStateHolder = scrollStateHolder2;
            this.viewPool = recycledViewPool;
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.itemView.getContext(), 0, false);
            linearLayoutManager2.setInitialPrefetchItemCount(4);
            this.linearLayoutManager = linearLayoutManager2;
            RecyclerView recyclerView = itemProductRowBinding.mainContentInnerRecyclerView;
            recyclerView.setLayoutManager(linearLayoutManager2);
            recyclerView.setHasFixedSize(true);
            recyclerView.setRecycledViewPool(recycledViewPool);
        }

        @Metadata(mo33736d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductRowListAdapter$ProductRowListViewHolder$Companion;", "", "()V", "createFrom", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductRowListAdapter$ProductRowListViewHolder;", "parent", "Landroid/view/ViewGroup;", "onItemClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;", "onItemLongClick", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;", "onFooterItemClick", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "", "scrollStateHolder", "Lmedia/tiger/tigerbox/ui/common/ScrollStateHolder;", "viewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductRowListAdapter$ProductRowListViewHolder$Companion */
        /* compiled from: ProductRowListAdapter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ProductRowListViewHolder createFrom(ViewGroup viewGroup, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener, BindingClickListener<Integer> bindingClickListener, ScrollStateHolder scrollStateHolder, RecyclerView.RecycledViewPool recycledViewPool) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClick");
                Intrinsics.checkNotNullParameter(bindingClickListener, "onFooterItemClick");
                Intrinsics.checkNotNullParameter(recycledViewPool, "viewPool");
                ItemProductRowBinding inflate = ItemProductRowBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
                return new ProductRowListViewHolder(inflate, onItemClickListener, onItemLongClickListener, bindingClickListener, scrollStateHolder, recycledViewPool);
            }
        }

        public String getScrollStateKey() {
            ProductRowDomain productRowDomain = this.row;
            return String.valueOf(productRowDomain != null ? Integer.valueOf(productRowDomain.getId()) : null);
        }

        public final void onCreate() {
            ScrollStateHolder scrollStateHolder2 = this.scrollStateHolder;
            if (scrollStateHolder2 != null) {
                RecyclerView recyclerView = this.binding.mainContentInnerRecyclerView;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.mainContentInnerRecyclerView");
                scrollStateHolder2.setupRecyclerView(recyclerView, this);
            }
        }

        public final void onRecycled() {
            ScrollStateHolder scrollStateHolder2 = this.scrollStateHolder;
            if (scrollStateHolder2 != null) {
                RecyclerView recyclerView = this.binding.mainContentInnerRecyclerView;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.mainContentInnerRecyclerView");
                scrollStateHolder2.saveScrollState(recyclerView, this);
            }
            this.row = null;
        }

        public final void bind(ProductRowDomain productRowDomain) {
            RecyclerView.Adapter adapter;
            ProductRowDomain productRowDomain2 = productRowDomain;
            Intrinsics.checkNotNullParameter(productRowDomain2, "item");
            this.row = productRowDomain2;
            ProductRowAdapter productRowAdapter = new ProductRowAdapter(this.onItemClick, this.onItemLongClick, productRowDomain.getId());
            ItemProductRowBinding itemProductRowBinding = this.binding;
            itemProductRowBinding.setProductRow(productRowDomain2);
            RecyclerView recyclerView = itemProductRowBinding.mainContentInnerRecyclerView;
            if (productRowDomain.getHasLoadMore()) {
                adapter = new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{productRowAdapter, new FooterAdapter(this.onFooterItemClick, productRowDomain.getId())});
            } else {
                adapter = productRowAdapter;
            }
            recyclerView.setAdapter(adapter);
            List arrayList = new ArrayList();
            if (WhenMappings.$EnumSwitchMapping$0[productRowDomain.getLayoutItemType().ordinal()] == 1) {
                Iterable<BannerProductDomain> bannerProducts = productRowDomain.getBannerProducts();
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(bannerProducts, 10));
                for (BannerProductDomain bannerProductDomain : bannerProducts) {
                    ProductDomain productDomain = r6;
                    ProductDomain productDomain2 = new ProductDomain(bannerProductDomain.getOrdinal(), bannerProductDomain.getTitle(), "", bannerProductDomain.getHdImageUrl(), true, OfflineAvailabilityState.NOT_AVAILABLE, DownloadReason.NONE, false, (ProductSource) null, RendererCapabilities.MODE_SUPPORT_MASK, (DefaultConstructorMarker) null);
                    arrayList2.add(productDomain);
                }
                arrayList.addAll((List) arrayList2);
            } else {
                arrayList.addAll(productRowDomain.getProducts());
            }
            ScrollStateHolder scrollStateHolder2 = this.scrollStateHolder;
            if (scrollStateHolder2 != null) {
                RecyclerView recyclerView2 = this.binding.mainContentInnerRecyclerView;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.mainContentInnerRecyclerView");
                scrollStateHolder2.restoreScrollState(recyclerView2, this);
            }
            productRowAdapter.submitList(arrayList);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProductRowListAdapter(OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener, BindingClickListener<Integer> bindingClickListener) {
        this(onItemClickListener, onItemLongClickListener, bindingClickListener, (ScrollStateHolder) null);
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClick");
        Intrinsics.checkNotNullParameter(bindingClickListener, "onFooterItemClick");
    }

    public final List<ProductRowDomain> chunkList$app_tigerBoxRelease(List<ProductRowDomain> list) {
        List<ProductDomain> products;
        List<List> chunked;
        List<ProductRowDomain> arrayList = new ArrayList<>();
        ProductRowDomain productRowDomain = list != null ? (ProductRowDomain) CollectionsKt.first(list) : null;
        if (!(productRowDomain == null || (products = productRowDomain.getProducts()) == null || (chunked = CollectionsKt.chunked(products, 10)) == null)) {
            for (List mutableList : chunked) {
                arrayList.add(new ProductRowDomain(productRowDomain.getId(), productRowDomain.getTitle(), ProductRowType.RESOURCE, productRowDomain.getProductSourceType(), productRowDomain.getUrl(), CollectionsKt.toMutableList(mutableList), productRowDomain.getBannerProducts(), productRowDomain.getHeaderResponseLink()));
            }
        }
        return arrayList;
    }
}
