package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.settings.systeminfo.SystemInfoItem;

public abstract class ItemSystemInfoBinding extends ViewDataBinding {
    @Bindable
    protected SystemInfoItem mSystemInfoItem;
    public final Guideline systemInfoItemGuideline;
    public final TextView systemInfoItemLabel;
    public final TextView systemInfoItemValue;

    public abstract void setSystemInfoItem(SystemInfoItem systemInfoItem);

    protected ItemSystemInfoBinding(Object obj, View view, int i, Guideline guideline, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.systemInfoItemGuideline = guideline;
        this.systemInfoItemLabel = textView;
        this.systemInfoItemValue = textView2;
    }

    public SystemInfoItem getSystemInfoItem() {
        return this.mSystemInfoItem;
    }

    public static ItemSystemInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSystemInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSystemInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_system_info, viewGroup, z, obj);
    }

    public static ItemSystemInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSystemInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSystemInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_system_info, (ViewGroup) null, false, obj);
    }

    public static ItemSystemInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSystemInfoBinding bind(View view, Object obj) {
        return (ItemSystemInfoBinding) bind(obj, view, C2814R.C2819layout.item_system_info);
    }
}
