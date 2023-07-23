package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.model.domain.BatterySummary;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;
import media.tiger.tigerbox.p016ui.view.BatteryView;

public abstract class FragmentHeaderBarBinding extends ViewDataBinding {
    public final BatteryView headerBatteryView;
    public final ImageView headerCloseButton;
    public final TextView headerContentTitle;
    public final TextView headerCountDownTime;
    public final ImageView headerDownloadMarker;
    public final LinearLayout headerLimitTimer;
    public final TextView headerLimitTimerText;
    public final ImageView headerWifiCtrl;
    @Bindable
    protected BatterySummary mBatterySummary;
    @Bindable
    protected Boolean mDownloadsInProgress;
    @Bindable
    protected Boolean mFirmwareUpdateAvailable;
    @Bindable
    protected BindingClickListener<Boolean> mSettingsClickListener;
    @Bindable
    protected Boolean mSettingsOpened;
    @Bindable
    protected UnTypedBindingClickListener mUpdateAvailableClickListener;
    @Bindable
    protected WifiItem mWifiItem;
    public final ImageView settingsIcon;
    public final ImageView updateAvailableIcon;

    public abstract void setBatterySummary(BatterySummary batterySummary);

    public abstract void setDownloadsInProgress(Boolean bool);

    public abstract void setFirmwareUpdateAvailable(Boolean bool);

    public abstract void setSettingsClickListener(BindingClickListener<Boolean> bindingClickListener);

    public abstract void setSettingsOpened(Boolean bool);

    public abstract void setUpdateAvailableClickListener(UnTypedBindingClickListener unTypedBindingClickListener);

    public abstract void setWifiItem(WifiItem wifiItem);

    protected FragmentHeaderBarBinding(Object obj, View view, int i, BatteryView batteryView, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, LinearLayout linearLayout, TextView textView3, ImageView imageView3, ImageView imageView4, ImageView imageView5) {
        super(obj, view, i);
        this.headerBatteryView = batteryView;
        this.headerCloseButton = imageView;
        this.headerContentTitle = textView;
        this.headerCountDownTime = textView2;
        this.headerDownloadMarker = imageView2;
        this.headerLimitTimer = linearLayout;
        this.headerLimitTimerText = textView3;
        this.headerWifiCtrl = imageView3;
        this.settingsIcon = imageView4;
        this.updateAvailableIcon = imageView5;
    }

    public BindingClickListener<Boolean> getSettingsClickListener() {
        return this.mSettingsClickListener;
    }

    public UnTypedBindingClickListener getUpdateAvailableClickListener() {
        return this.mUpdateAvailableClickListener;
    }

    public BatterySummary getBatterySummary() {
        return this.mBatterySummary;
    }

    public Boolean getDownloadsInProgress() {
        return this.mDownloadsInProgress;
    }

    public Boolean getFirmwareUpdateAvailable() {
        return this.mFirmwareUpdateAvailable;
    }

    public Boolean getSettingsOpened() {
        return this.mSettingsOpened;
    }

    public WifiItem getWifiItem() {
        return this.mWifiItem;
    }

    public static FragmentHeaderBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHeaderBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHeaderBarBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_header_bar, viewGroup, z, obj);
    }

    public static FragmentHeaderBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHeaderBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHeaderBarBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_header_bar, (ViewGroup) null, false, obj);
    }

    public static FragmentHeaderBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHeaderBarBinding bind(View view, Object obj) {
        return (FragmentHeaderBarBinding) bind(obj, view, C2814R.C2819layout.fragment_header_bar);
    }
}
