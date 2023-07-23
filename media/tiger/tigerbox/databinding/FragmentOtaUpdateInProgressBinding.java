package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentOtaUpdateInProgressBinding extends ViewDataBinding {
    @Bindable
    protected String mUpdateLabel;
    @Bindable
    protected Integer mUpdatePercent;
    public final TextView otaUpdateInProgressBody;
    public final ImageView otaUpdateInProgressImage;
    public final ProgressBar otaUpdateInProgressProgressBar;
    public final TextView otaUpdateInProgressProgressLabel;
    public final TextView otaUpdateInProgressTitle;

    public abstract void setUpdateLabel(String str);

    public abstract void setUpdatePercent(Integer num);

    protected FragmentOtaUpdateInProgressBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ProgressBar progressBar, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.otaUpdateInProgressBody = textView;
        this.otaUpdateInProgressImage = imageView;
        this.otaUpdateInProgressProgressBar = progressBar;
        this.otaUpdateInProgressProgressLabel = textView2;
        this.otaUpdateInProgressTitle = textView3;
    }

    public Integer getUpdatePercent() {
        return this.mUpdatePercent;
    }

    public String getUpdateLabel() {
        return this.mUpdateLabel;
    }

    public static FragmentOtaUpdateInProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOtaUpdateInProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentOtaUpdateInProgressBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_ota_update_in_progress, viewGroup, z, obj);
    }

    public static FragmentOtaUpdateInProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOtaUpdateInProgressBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentOtaUpdateInProgressBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_ota_update_in_progress, (ViewGroup) null, false, obj);
    }

    public static FragmentOtaUpdateInProgressBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOtaUpdateInProgressBinding bind(View view, Object obj) {
        return (FragmentOtaUpdateInProgressBinding) bind(obj, view, C2814R.C2819layout.fragment_ota_update_in_progress);
    }
}
