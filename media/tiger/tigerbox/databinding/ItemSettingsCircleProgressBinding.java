package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.settings.SettingsCircleProgressItemData;
import media.tiger.tigerbox.p016ui.view.CircleProgressImageView;

public abstract class ItemSettingsCircleProgressBinding extends ViewDataBinding {
    public final CircleProgressImageView itemIcon;
    public final TextView itemTitle;
    @Bindable
    protected SettingsCircleProgressItemData mItem;

    public abstract void setItem(SettingsCircleProgressItemData settingsCircleProgressItemData);

    protected ItemSettingsCircleProgressBinding(Object obj, View view, int i, CircleProgressImageView circleProgressImageView, TextView textView) {
        super(obj, view, i);
        this.itemIcon = circleProgressImageView;
        this.itemTitle = textView;
    }

    public SettingsCircleProgressItemData getItem() {
        return this.mItem;
    }

    public static ItemSettingsCircleProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSettingsCircleProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSettingsCircleProgressBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_settings_circle_progress, viewGroup, z, obj);
    }

    public static ItemSettingsCircleProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSettingsCircleProgressBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSettingsCircleProgressBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_settings_circle_progress, (ViewGroup) null, false, obj);
    }

    public static ItemSettingsCircleProgressBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSettingsCircleProgressBinding bind(View view, Object obj) {
        return (ItemSettingsCircleProgressBinding) bind(obj, view, C2814R.C2819layout.item_settings_circle_progress);
    }
}
