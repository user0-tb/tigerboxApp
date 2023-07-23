package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.model.domain.ProductDomain;

public abstract class ItemProductActionBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener mAcceptButtonListener;
    @Bindable
    protected ProductDomain mBindingProduct;
    @Bindable
    protected View.OnClickListener mExitButtonListener;
    public final Button productActionAcceptButton;
    public final ConstraintLayout productActionContainer;
    public final ImageView productActionDownloadBoxImage;
    public final ImageView productActionExitButton;

    public abstract void setAcceptButtonListener(View.OnClickListener onClickListener);

    public abstract void setBindingProduct(ProductDomain productDomain);

    public abstract void setExitButtonListener(View.OnClickListener onClickListener);

    protected ItemProductActionBinding(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.productActionAcceptButton = button;
        this.productActionContainer = constraintLayout;
        this.productActionDownloadBoxImage = imageView;
        this.productActionExitButton = imageView2;
    }

    public View.OnClickListener getExitButtonListener() {
        return this.mExitButtonListener;
    }

    public ProductDomain getBindingProduct() {
        return this.mBindingProduct;
    }

    public View.OnClickListener getAcceptButtonListener() {
        return this.mAcceptButtonListener;
    }

    public static ItemProductActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductActionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_product_action, viewGroup, z, obj);
    }

    public static ItemProductActionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductActionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductActionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_product_action, (ViewGroup) null, false, obj);
    }

    public static ItemProductActionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductActionBinding bind(View view, Object obj) {
        return (ItemProductActionBinding) bind(obj, view, C2814R.C2819layout.item_product_action);
    }
}
