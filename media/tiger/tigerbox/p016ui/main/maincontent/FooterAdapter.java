package media.tiger.tigerbox.p016ui.main.maincontent;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.databinding.ItemFooterBinding;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;

@Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/FooterAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "Lmedia/tiger/tigerbox/ui/main/maincontent/FooterAdapter$FooterViewHolder;", "onClick", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "", "rowId", "(Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FooterViewHolder", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.FooterAdapter */
/* compiled from: FooterAdapter.kt */
public final class FooterAdapter extends ListAdapter<ProductDomain, FooterViewHolder> {
    private final BindingClickListener<Integer> onClick;
    private int rowId;

    public int getItemCount() {
        return 1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FooterAdapter(BindingClickListener bindingClickListener, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bindingClickListener, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FooterAdapter(BindingClickListener<Integer> bindingClickListener, int i) {
        super(new DiffUtil.ItemCallback<ProductDomain>() {
            public boolean areItemsTheSame(ProductDomain productDomain, ProductDomain productDomain2) {
                Intrinsics.checkNotNullParameter(productDomain, "oldItem");
                Intrinsics.checkNotNullParameter(productDomain2, "newItem");
                return true;
            }

            public boolean areContentsTheSame(ProductDomain productDomain, ProductDomain productDomain2) {
                Intrinsics.checkNotNullParameter(productDomain, "oldItem");
                Intrinsics.checkNotNullParameter(productDomain2, "newItem");
                return Intrinsics.areEqual((Object) productDomain, (Object) productDomain2);
            }
        });
        Intrinsics.checkNotNullParameter(bindingClickListener, "onClick");
        this.onClick = bindingClickListener;
        this.rowId = i;
    }

    public FooterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemFooterBinding inflate = ItemFooterBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new FooterViewHolder(inflate, this.onClick);
    }

    public void onBindViewHolder(FooterViewHolder footerViewHolder, int i) {
        Intrinsics.checkNotNullParameter(footerViewHolder, "holder");
        footerViewHolder.bind(this.rowId);
    }

    @Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/FooterAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lmedia/tiger/tigerbox/databinding/ItemFooterBinding;", "onClick", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "", "(Lmedia/tiger/tigerbox/databinding/ItemFooterBinding;Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;)V", "bind", "", "rowId", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.FooterAdapter$FooterViewHolder */
    /* compiled from: FooterAdapter.kt */
    public static final class FooterViewHolder extends RecyclerView.ViewHolder {
        private final ItemFooterBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FooterViewHolder(ItemFooterBinding itemFooterBinding, BindingClickListener<Integer> bindingClickListener) {
            super(itemFooterBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemFooterBinding, "binding");
            Intrinsics.checkNotNullParameter(bindingClickListener, "onClick");
            this.binding = itemFooterBinding;
            itemFooterBinding.setFooterClickListener(bindingClickListener);
        }

        public final void bind(int i) {
            this.binding.setFooterRowId(Integer.valueOf(i));
        }
    }
}
