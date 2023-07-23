package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.main.mediaplayer.OnMediaCoverImageClickListener;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;

public abstract class MediaPlayerCoverBinding extends ViewDataBinding {
    @Bindable
    protected OnMediaCoverImageClickListener mAudioCoverClickListener;
    @Bindable
    protected AudioProductInfo mAudioProduct;
    public final ConstraintLayout productConstraintLayout;
    public final ImageView productImage;
    public final TextView productTitle;

    public abstract void setAudioCoverClickListener(OnMediaCoverImageClickListener onMediaCoverImageClickListener);

    public abstract void setAudioProduct(AudioProductInfo audioProductInfo);

    protected MediaPlayerCoverBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.productConstraintLayout = constraintLayout;
        this.productImage = imageView;
        this.productTitle = textView;
    }

    public AudioProductInfo getAudioProduct() {
        return this.mAudioProduct;
    }

    public OnMediaCoverImageClickListener getAudioCoverClickListener() {
        return this.mAudioCoverClickListener;
    }

    public static MediaPlayerCoverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MediaPlayerCoverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MediaPlayerCoverBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.media_player_cover, viewGroup, z, obj);
    }

    public static MediaPlayerCoverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MediaPlayerCoverBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MediaPlayerCoverBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.media_player_cover, (ViewGroup) null, false, obj);
    }

    public static MediaPlayerCoverBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MediaPlayerCoverBinding bind(View view, Object obj) {
        return (MediaPlayerCoverBinding) bind(obj, view, C2814R.C2819layout.media_player_cover);
    }
}
