package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentFullscreenSeekbarBinding extends ViewDataBinding {
    public final IncludeDialogHeaderBarBinding fragmentHeaderBar;
    public final AppCompatToggleButton settingsSeekbarButton;
    public final ConstraintLayout settingsSeekbarContent;
    public final SeekBar settingsSeekbarSeekbar;
    public final LinearLayout settingsSeekbarSleepValue;

    protected FragmentFullscreenSeekbarBinding(Object obj, View view, int i, IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, AppCompatToggleButton appCompatToggleButton, ConstraintLayout constraintLayout, SeekBar seekBar, LinearLayout linearLayout) {
        super(obj, view, i);
        this.fragmentHeaderBar = includeDialogHeaderBarBinding;
        this.settingsSeekbarButton = appCompatToggleButton;
        this.settingsSeekbarContent = constraintLayout;
        this.settingsSeekbarSeekbar = seekBar;
        this.settingsSeekbarSleepValue = linearLayout;
    }

    public static FragmentFullscreenSeekbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFullscreenSeekbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentFullscreenSeekbarBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_fullscreen_seekbar, viewGroup, z, obj);
    }

    public static FragmentFullscreenSeekbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFullscreenSeekbarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentFullscreenSeekbarBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_fullscreen_seekbar, (ViewGroup) null, false, obj);
    }

    public static FragmentFullscreenSeekbarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFullscreenSeekbarBinding bind(View view, Object obj) {
        return (FragmentFullscreenSeekbarBinding) bind(obj, view, C2814R.C2819layout.fragment_fullscreen_seekbar);
    }
}
