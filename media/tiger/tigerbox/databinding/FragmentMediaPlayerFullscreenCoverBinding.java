package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentMediaPlayerFullscreenCoverBinding extends ViewDataBinding {
    public final IncludeDialogCloseButtonBinding fragmentCloseButton;
    @Bindable
    protected String mImageUrl;
    public final ImageView medialPlayerFullscreenCoverImage;

    public abstract void setImageUrl(String str);

    protected FragmentMediaPlayerFullscreenCoverBinding(Object obj, View view, int i, IncludeDialogCloseButtonBinding includeDialogCloseButtonBinding, ImageView imageView) {
        super(obj, view, i);
        this.fragmentCloseButton = includeDialogCloseButtonBinding;
        this.medialPlayerFullscreenCoverImage = imageView;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public static FragmentMediaPlayerFullscreenCoverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMediaPlayerFullscreenCoverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMediaPlayerFullscreenCoverBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_media_player_fullscreen_cover, viewGroup, z, obj);
    }

    public static FragmentMediaPlayerFullscreenCoverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMediaPlayerFullscreenCoverBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMediaPlayerFullscreenCoverBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_media_player_fullscreen_cover, (ViewGroup) null, false, obj);
    }

    public static FragmentMediaPlayerFullscreenCoverBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMediaPlayerFullscreenCoverBinding bind(View view, Object obj) {
        return (FragmentMediaPlayerFullscreenCoverBinding) bind(obj, view, C2814R.C2819layout.fragment_media_player_fullscreen_cover);
    }
}
