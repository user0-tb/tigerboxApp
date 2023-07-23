package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentTimersLimitBinding extends ViewDataBinding {
    public final IncludeDialogCloseButtonBinding fragmentCloseButton;
    public final Guideline guideline;
    public final TimePicker hmPicker;
    public final ConstraintLayout hmPickerLayout;
    @Bindable
    protected String mLayoutTitle;
    public final Button submitButton;
    public final RecyclerView timersLimitRecyclerView;

    public abstract void setLayoutTitle(String str);

    protected FragmentTimersLimitBinding(Object obj, View view, int i, IncludeDialogCloseButtonBinding includeDialogCloseButtonBinding, Guideline guideline2, TimePicker timePicker, ConstraintLayout constraintLayout, Button button, RecyclerView recyclerView) {
        super(obj, view, i);
        this.fragmentCloseButton = includeDialogCloseButtonBinding;
        this.guideline = guideline2;
        this.hmPicker = timePicker;
        this.hmPickerLayout = constraintLayout;
        this.submitButton = button;
        this.timersLimitRecyclerView = recyclerView;
    }

    public String getLayoutTitle() {
        return this.mLayoutTitle;
    }

    public static FragmentTimersLimitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimersLimitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTimersLimitBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_timers_limit, viewGroup, z, obj);
    }

    public static FragmentTimersLimitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimersLimitBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTimersLimitBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_timers_limit, (ViewGroup) null, false, obj);
    }

    public static FragmentTimersLimitBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimersLimitBinding bind(View view, Object obj) {
        return (FragmentTimersLimitBinding) bind(obj, view, C2814R.C2819layout.fragment_timers_limit);
    }
}
