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

public abstract class IncludeDialogHeaderBarBinding extends ViewDataBinding {
    public final LinearLayout headerLimitTimer;
    public final TextView headerLimitTimerText;
    public final BatteryView includeHeaderBatteryView;
    public final ImageView includeHeaderCloseButton;
    public final TextView includeHeaderCountDownTime;
    public final ImageView includeHeaderDownloadMarker;
    public final ImageView includeHeaderSettingsIcon;
    public final ImageView includeHeaderUpdateAvailableIcon;
    public final ImageView includeHeaderWifiCtrl;
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

    public abstract void setBatterySummary(BatterySummary batterySummary);

    public abstract void setDownloadsInProgress(Boolean bool);

    public abstract void setFirmwareUpdateAvailable(Boolean bool);

    public abstract void setSettingsClickListener(BindingClickListener<Boolean> bindingClickListener);

    public abstract void setSettingsOpened(Boolean bool);

    public abstract void setUpdateAvailableClickListener(UnTypedBindingClickListener unTypedBindingClickListener);

    public abstract void setWifiItem(WifiItem wifiItem);

    protected IncludeDialogHeaderBarBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, BatteryView batteryView, ImageView imageView, TextView textView2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5) {
        super(obj, view, i);
        this.headerLimitTimer = linearLayout;
        this.headerLimitTimerText = textView;
        this.includeHeaderBatteryView = batteryView;
        this.includeHeaderCloseButton = imageView;
        this.includeHeaderCountDownTime = textView2;
        this.includeHeaderDownloadMarker = imageView2;
        this.includeHeaderSettingsIcon = imageView3;
        this.includeHeaderUpdateAvailableIcon = imageView4;
        this.includeHeaderWifiCtrl = imageView5;
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

    public Boolean getSettingsOpened() {
        return this.mSettingsOpened;
    }

    public Boolean getDownloadsInProgress() {
        return this.mDownloadsInProgress;
    }

    public Boolean getFirmwareUpdateAvailable() {
        return this.mFirmwareUpdateAvailable;
    }

    public WifiItem getWifiItem() {
        return this.mWifiItem;
    }

    public static IncludeDialogHeaderBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludeDialogHeaderBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeDialogHeaderBarBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.include_dialog_header_bar, viewGroup, z, obj);
    }

    public static IncludeDialogHeaderBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludeDialogHeaderBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeDialogHeaderBarBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.include_dialog_header_bar, (ViewGroup) null, false, obj);
    }

    public static IncludeDialogHeaderBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludeDialogHeaderBarBinding bind(View view, Object obj) {
        return (IncludeDialogHeaderBarBinding) bind(obj, view, C2814R.C2819layout.include_dialog_header_bar);
    }
}
