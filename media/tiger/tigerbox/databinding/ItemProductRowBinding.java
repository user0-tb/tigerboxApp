package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.model.domain.ProductRowDomain;

public abstract class ItemProductRowBinding extends ViewDataBinding {
    @Bindable
    protected ProductRowDomain mProductRow;
    public final RecyclerView mainContentInnerRecyclerView;
    public final LinearLayout mainContentProductRowContainer;
    public final TextView mainContentTitle;

    public abstract void setProductRow(ProductRowDomain productRowDomain);

    protected ItemProductRowBinding(Object obj, View view, int i, RecyclerView recyclerView, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.mainContentInnerRecyclerView = recyclerView;
        this.mainContentProductRowContainer = linearLayout;
        this.mainContentTitle = textView;
    }

    public ProductRowDomain getProductRow() {
        return this.mProductRow;
    }

    public static ItemProductRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductRowBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_product_row, viewGroup, z, obj);
    }

    public static ItemProductRowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductRowBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductRowBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_product_row, (ViewGroup) null, false, obj);
    }

    public static ItemProductRowBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductRowBinding bind(View view, Object obj) {
        return (ItemProductRowBinding) bind(obj, view, C2814R.C2819layout.item_product_row);
    }
}
