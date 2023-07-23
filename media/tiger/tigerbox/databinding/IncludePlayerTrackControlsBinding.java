package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class IncludePlayerTrackControlsBinding extends ViewDataBinding {
    @Bindable
    protected Boolean mPlaying;
    public final ImageButton mediaPlayerControlsNextControl;
    public final ImageButton mediaPlayerControlsPlayControl;
    public final ImageButton mediaPlayerControlsPreviousControl;

    public abstract void setPlaying(Boolean bool);

    protected IncludePlayerTrackControlsBinding(Object obj, View view, int i, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3) {
        super(obj, view, i);
        this.mediaPlayerControlsNextControl = imageButton;
        this.mediaPlayerControlsPlayControl = imageButton2;
        this.mediaPlayerControlsPreviousControl = imageButton3;
    }

    public Boolean getPlaying() {
        return this.mPlaying;
    }

    public static IncludePlayerTrackControlsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludePlayerTrackControlsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludePlayerTrackControlsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.include_player_track_controls, viewGroup, z, obj);
    }

    public static IncludePlayerTrackControlsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludePlayerTrackControlsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludePlayerTrackControlsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.include_player_track_controls, (ViewGroup) null, false, obj);
    }

    public static IncludePlayerTrackControlsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludePlayerTrackControlsBinding bind(View view, Object obj) {
        return (IncludePlayerTrackControlsBinding) bind(obj, view, C2814R.C2819layout.include_player_track_controls);
    }
}
