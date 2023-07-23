package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class IncludeMediaPlayerControlsBinding extends ViewDataBinding {
    @Bindable
    protected Boolean mPlaying;
    public final IncludePlayerDeviceControlsBinding mediaPlayerControlsDeviceControls;
    public final Guideline mediaPlayerControlsGuideline;
    public final IncludePlayerTrackControlsBinding mediaPlayerControlsTrackControls;

    public abstract void setPlaying(Boolean bool);

    protected IncludeMediaPlayerControlsBinding(Object obj, View view, int i, IncludePlayerDeviceControlsBinding includePlayerDeviceControlsBinding, Guideline guideline, IncludePlayerTrackControlsBinding includePlayerTrackControlsBinding) {
        super(obj, view, i);
        this.mediaPlayerControlsDeviceControls = includePlayerDeviceControlsBinding;
        this.mediaPlayerControlsGuideline = guideline;
        this.mediaPlayerControlsTrackControls = includePlayerTrackControlsBinding;
    }

    public Boolean getPlaying() {
        return this.mPlaying;
    }

    public static IncludeMediaPlayerControlsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludeMediaPlayerControlsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeMediaPlayerControlsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.include_media_player_controls, viewGroup, z, obj);
    }

    public static IncludeMediaPlayerControlsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludeMediaPlayerControlsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeMediaPlayerControlsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.include_media_player_controls, (ViewGroup) null, false, obj);
    }

    public static IncludeMediaPlayerControlsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludeMediaPlayerControlsBinding bind(View view, Object obj) {
        return (IncludeMediaPlayerControlsBinding) bind(obj, view, C2814R.C2819layout.include_media_player_controls);
    }
}
