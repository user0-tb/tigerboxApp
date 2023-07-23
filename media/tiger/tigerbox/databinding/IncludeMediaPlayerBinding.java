package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class IncludeMediaPlayerBinding extends ViewDataBinding {
    @Bindable
    protected Boolean mPlaying;
    @Bindable
    protected long mTrackPosition;
    @Bindable
    protected int mTrackProgress;
    @Bindable
    protected long mTrackRemaining;
    public final IncludeMediaPlayerControlsBinding mediaPlayerControls;
    public final TextView mediaPlayerCurrentProgress;
    public final MediaPlayerCoverBinding mediaPlayerProduct;
    public final SeekBar mediaPlayerProgressSeekBar;
    public final TextView mediaPlayerTimeRemaining;

    public abstract void setPlaying(Boolean bool);

    public abstract void setTrackPosition(long j);

    public abstract void setTrackProgress(int i);

    public abstract void setTrackRemaining(long j);

    protected IncludeMediaPlayerBinding(Object obj, View view, int i, IncludeMediaPlayerControlsBinding includeMediaPlayerControlsBinding, TextView textView, MediaPlayerCoverBinding mediaPlayerCoverBinding, SeekBar seekBar, TextView textView2) {
        super(obj, view, i);
        this.mediaPlayerControls = includeMediaPlayerControlsBinding;
        this.mediaPlayerCurrentProgress = textView;
        this.mediaPlayerProduct = mediaPlayerCoverBinding;
        this.mediaPlayerProgressSeekBar = seekBar;
        this.mediaPlayerTimeRemaining = textView2;
    }

    public int getTrackProgress() {
        return this.mTrackProgress;
    }

    public long getTrackPosition() {
        return this.mTrackPosition;
    }

    public long getTrackRemaining() {
        return this.mTrackRemaining;
    }

    public Boolean getPlaying() {
        return this.mPlaying;
    }

    public static IncludeMediaPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludeMediaPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeMediaPlayerBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.include_media_player, viewGroup, z, obj);
    }

    public static IncludeMediaPlayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludeMediaPlayerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeMediaPlayerBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.include_media_player, (ViewGroup) null, false, obj);
    }

    public static IncludeMediaPlayerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludeMediaPlayerBinding bind(View view, Object obj) {
        return (IncludeMediaPlayerBinding) bind(obj, view, C2814R.C2819layout.include_media_player);
    }
}
