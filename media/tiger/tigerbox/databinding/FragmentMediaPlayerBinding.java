package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentMediaPlayerBinding extends ViewDataBinding {
    public final IncludeDialogHeaderBarBinding fragmentHeaderBar;
    public final IncludeMediaPlayerBinding mediaPlayerContent;
    public final ConstraintLayout mediaPlayerLayout;
    public final IncludeDataLoadingBinding mediaPlayerLoading;

    protected FragmentMediaPlayerBinding(Object obj, View view, int i, IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, IncludeMediaPlayerBinding includeMediaPlayerBinding, ConstraintLayout constraintLayout, IncludeDataLoadingBinding includeDataLoadingBinding) {
        super(obj, view, i);
        this.fragmentHeaderBar = includeDialogHeaderBarBinding;
        this.mediaPlayerContent = includeMediaPlayerBinding;
        this.mediaPlayerLayout = constraintLayout;
        this.mediaPlayerLoading = includeDataLoadingBinding;
    }

    public static FragmentMediaPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMediaPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMediaPlayerBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_media_player, viewGroup, z, obj);
    }

    public static FragmentMediaPlayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMediaPlayerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMediaPlayerBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_media_player, (ViewGroup) null, false, obj);
    }

    public static FragmentMediaPlayerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMediaPlayerBinding bind(View view, Object obj) {
        return (FragmentMediaPlayerBinding) bind(obj, view, C2814R.C2819layout.fragment_media_player);
    }
}
