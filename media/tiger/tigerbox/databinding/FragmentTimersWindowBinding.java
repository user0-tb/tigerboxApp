package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentTimersWindowBinding extends ViewDataBinding {
    public final ImageButton deleteButton;
    public final TextView endLabel;
    public final TimePicker endPicker;
    public final IncludeDialogCloseButtonBinding fragmentCloseButton;
    public final Guideline guideline;
    public final Guideline guideline2;
    @Bindable
    protected Integer mLayoutTitleIdx;
    public final ConstraintLayout pickerLayout;
    public final TextView startLabel;
    public final TimePicker startPicker;
    public final Button submitButton;
    public final TextView title;

    public abstract void setLayoutTitleIdx(Integer num);

    protected FragmentTimersWindowBinding(Object obj, View view, int i, ImageButton imageButton, TextView textView, TimePicker timePicker, IncludeDialogCloseButtonBinding includeDialogCloseButtonBinding, Guideline guideline3, Guideline guideline4, ConstraintLayout constraintLayout, TextView textView2, TimePicker timePicker2, Button button, TextView textView3) {
        super(obj, view, i);
        this.deleteButton = imageButton;
        this.endLabel = textView;
        this.endPicker = timePicker;
        this.fragmentCloseButton = includeDialogCloseButtonBinding;
        this.guideline = guideline3;
        this.guideline2 = guideline4;
        this.pickerLayout = constraintLayout;
        this.startLabel = textView2;
        this.startPicker = timePicker2;
        this.submitButton = button;
        this.title = textView3;
    }

    public Integer getLayoutTitleIdx() {
        return this.mLayoutTitleIdx;
    }

    public static FragmentTimersWindowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimersWindowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTimersWindowBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_timers_window, viewGroup, z, obj);
    }

    public static FragmentTimersWindowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimersWindowBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTimersWindowBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_timers_window, (ViewGroup) null, false, obj);
    }

    public static FragmentTimersWindowBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimersWindowBinding bind(View view, Object obj) {
        return (FragmentTimersWindowBinding) bind(obj, view, C2814R.C2819layout.fragment_timers_window);
    }
}
