package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;

public abstract class ItemWifiListBinding extends ViewDataBinding {
    @Bindable
    protected BindingClickListener<WifiItem> mClickListener;
    @Bindable
    protected WifiItem mWifiItem;
    public final ImageView wifiListItemConnectedIcon;
    public final ProgressBar wifiListItemConnectingIcon;
    public final FrameLayout wifiListItemIconContainer;
    public final ImageView wifiListItemLevelIcon;
    public final TextView wifiListItemSsidName;

    public abstract void setClickListener(BindingClickListener<WifiItem> bindingClickListener);

    public abstract void setWifiItem(WifiItem wifiItem);

    protected ItemWifiListBinding(Object obj, View view, int i, ImageView imageView, ProgressBar progressBar, FrameLayout frameLayout, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.wifiListItemConnectedIcon = imageView;
        this.wifiListItemConnectingIcon = progressBar;
        this.wifiListItemIconContainer = frameLayout;
        this.wifiListItemLevelIcon = imageView2;
        this.wifiListItemSsidName = textView;
    }

    public BindingClickListener<WifiItem> getClickListener() {
        return this.mClickListener;
    }

    public WifiItem getWifiItem() {
        return this.mWifiItem;
    }

    public static ItemWifiListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWifiListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemWifiListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_wifi_list, viewGroup, z, obj);
    }

    public static ItemWifiListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWifiListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemWifiListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_wifi_list, (ViewGroup) null, false, obj);
    }

    public static ItemWifiListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWifiListBinding bind(View view, Object obj) {
        return (ItemWifiListBinding) bind(obj, view, C2814R.C2819layout.item_wifi_list);
    }
}
