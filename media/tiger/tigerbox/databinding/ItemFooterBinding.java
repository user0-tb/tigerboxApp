package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;

public abstract class ItemFooterBinding extends ViewDataBinding {
    public final TextView footerItem;
    @Bindable
    protected BindingClickListener<Integer> mFooterClickListener;
    @Bindable
    protected Integer mFooterRowId;

    public abstract void setFooterClickListener(BindingClickListener<Integer> bindingClickListener);

    public abstract void setFooterRowId(Integer num);

    protected ItemFooterBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.footerItem = textView;
    }

    public BindingClickListener<Integer> getFooterClickListener() {
        return this.mFooterClickListener;
    }

    public Integer getFooterRowId() {
        return this.mFooterRowId;
    }

    public static ItemFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFooterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_footer, viewGroup, z, obj);
    }

    public static ItemFooterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFooterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFooterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_footer, (ViewGroup) null, false, obj);
    }

    public static ItemFooterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFooterBinding bind(View view, Object obj) {
        return (ItemFooterBinding) bind(obj, view, C2814R.C2819layout.item_footer);
    }
}
