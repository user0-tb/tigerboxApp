package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.settings.SettingsItemData;

public abstract class ItemSettingsBinding extends ViewDataBinding {
    public final ImageView itemIcon;
    public final TextView itemTitle;
    @Bindable
    protected SettingsItemData mItem;
    @Bindable
    protected Boolean mSelected;

    public abstract void setItem(SettingsItemData settingsItemData);

    public abstract void setSelected(Boolean bool);

    protected ItemSettingsBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.itemIcon = imageView;
        this.itemTitle = textView;
    }

    public Boolean getSelected() {
        return this.mSelected;
    }

    public SettingsItemData getItem() {
        return this.mItem;
    }

    public static ItemSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_settings, viewGroup, z, obj);
    }

    public static ItemSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSettingsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_settings, (ViewGroup) null, false, obj);
    }

    public static ItemSettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSettingsBinding bind(View view, Object obj) {
        return (ItemSettingsBinding) bind(obj, view, C2814R.C2819layout.item_settings);
    }
}
