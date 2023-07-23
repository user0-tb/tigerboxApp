package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.view.CircleProgressImageView;

public abstract class IncludePlayerDeviceControlsBinding extends ViewDataBinding {
    @Bindable
    protected Boolean mLightControlEnabled;
    public final CircleProgressImageView mediaPlayerControlsLightControl;
    public final CircleProgressImageView mediaPlayerControlsTrackControl;
    public final CircleProgressImageView mediaPlayerControlsVolumeControl;

    public abstract void setLightControlEnabled(Boolean bool);

    protected IncludePlayerDeviceControlsBinding(Object obj, View view, int i, CircleProgressImageView circleProgressImageView, CircleProgressImageView circleProgressImageView2, CircleProgressImageView circleProgressImageView3) {
        super(obj, view, i);
        this.mediaPlayerControlsLightControl = circleProgressImageView;
        this.mediaPlayerControlsTrackControl = circleProgressImageView2;
        this.mediaPlayerControlsVolumeControl = circleProgressImageView3;
    }

    public Boolean getLightControlEnabled() {
        return this.mLightControlEnabled;
    }

    public static IncludePlayerDeviceControlsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludePlayerDeviceControlsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludePlayerDeviceControlsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.include_player_device_controls, viewGroup, z, obj);
    }

    public static IncludePlayerDeviceControlsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludePlayerDeviceControlsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludePlayerDeviceControlsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.include_player_device_controls, (ViewGroup) null, false, obj);
    }

    public static IncludePlayerDeviceControlsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludePlayerDeviceControlsBinding bind(View view, Object obj) {
        return (IncludePlayerDeviceControlsBinding) bind(obj, view, C2814R.C2819layout.include_player_device_controls);
    }
}
