package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;
import media.tiger.tigerbox.p016ui.view.CircleProgressImageView;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;

public abstract class FragmentMiniPlayerBinding extends ViewDataBinding {
    @Bindable
    protected AudioProductInfo mAudioProduct;
    @Bindable
    protected Boolean mIsPlaying;
    @Bindable
    protected UnTypedBindingClickListener mNavigateToMediaPlayer;
    public final LinearLayout miniPlayerContainer;
    public final CircleProgressImageView miniPlayerPlayPauseButton;
    public final ImageView miniPlayerProductCover;
    public final CircleProgressImageView miniPlayerVolumeButton;

    public abstract void setAudioProduct(AudioProductInfo audioProductInfo);

    public abstract void setIsPlaying(Boolean bool);

    public abstract void setNavigateToMediaPlayer(UnTypedBindingClickListener unTypedBindingClickListener);

    protected FragmentMiniPlayerBinding(Object obj, View view, int i, LinearLayout linearLayout, CircleProgressImageView circleProgressImageView, ImageView imageView, CircleProgressImageView circleProgressImageView2) {
        super(obj, view, i);
        this.miniPlayerContainer = linearLayout;
        this.miniPlayerPlayPauseButton = circleProgressImageView;
        this.miniPlayerProductCover = imageView;
        this.miniPlayerVolumeButton = circleProgressImageView2;
    }

    public UnTypedBindingClickListener getNavigateToMediaPlayer() {
        return this.mNavigateToMediaPlayer;
    }

    public AudioProductInfo getAudioProduct() {
        return this.mAudioProduct;
    }

    public Boolean getIsPlaying() {
        return this.mIsPlaying;
    }

    public static FragmentMiniPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMiniPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMiniPlayerBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_mini_player, viewGroup, z, obj);
    }

    public static FragmentMiniPlayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMiniPlayerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMiniPlayerBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_mini_player, (ViewGroup) null, false, obj);
    }

    public static FragmentMiniPlayerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMiniPlayerBinding bind(View view, Object obj) {
        return (FragmentMiniPlayerBinding) bind(obj, view, C2814R.C2819layout.fragment_mini_player);
    }
}
