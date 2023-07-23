package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.andexert.library.RippleView;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.model.domain.ProductDomain;

public abstract class ItemProductBinding extends ViewDataBinding {
    @Bindable
    protected ProductDomain mBindingProduct;
    public final ItemProductActionBinding productAction;
    public final ConstraintLayout productConstraintLayout;
    public final View productDlStateDlBackground;
    public final ImageView productDlStateIcon;
    public final ImageView productImage;
    public final TextView productTitle;
    public final RippleView ripple;

    public abstract void setBindingProduct(ProductDomain productDomain);

    protected ItemProductBinding(Object obj, View view, int i, ItemProductActionBinding itemProductActionBinding, ConstraintLayout constraintLayout, View view2, ImageView imageView, ImageView imageView2, TextView textView, RippleView rippleView) {
        super(obj, view, i);
        this.productAction = itemProductActionBinding;
        this.productConstraintLayout = constraintLayout;
        this.productDlStateDlBackground = view2;
        this.productDlStateIcon = imageView;
        this.productImage = imageView2;
        this.productTitle = textView;
        this.ripple = rippleView;
    }

    public ProductDomain getBindingProduct() {
        return this.mBindingProduct;
    }

    public static ItemProductBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_product, viewGroup, z, obj);
    }

    public static ItemProductBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_product, (ViewGroup) null, false, obj);
    }

    public static ItemProductBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductBinding bind(View view, Object obj) {
        return (ItemProductBinding) bind(obj, view, C2814R.C2819layout.item_product);
    }
}
