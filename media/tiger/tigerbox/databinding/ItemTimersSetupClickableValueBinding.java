package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupItem;

public abstract class ItemTimersSetupClickableValueBinding extends ViewDataBinding {
    @Bindable
    protected TimersSetupItem mTimersSetupItem;
    public final Guideline timersSetupItemGuideline;
    public final TextView timersSetupItemLength;
    public final TextView timersSetupItemTitle;

    public abstract void setTimersSetupItem(TimersSetupItem timersSetupItem);

    protected ItemTimersSetupClickableValueBinding(Object obj, View view, int i, Guideline guideline, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.timersSetupItemGuideline = guideline;
        this.timersSetupItemLength = textView;
        this.timersSetupItemTitle = textView2;
    }

    public TimersSetupItem getTimersSetupItem() {
        return this.mTimersSetupItem;
    }

    public static ItemTimersSetupClickableValueBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTimersSetupClickableValueBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTimersSetupClickableValueBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_timers_setup_clickable_value, viewGroup, z, obj);
    }

    public static ItemTimersSetupClickableValueBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTimersSetupClickableValueBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTimersSetupClickableValueBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_timers_setup_clickable_value, (ViewGroup) null, false, obj);
    }

    public static ItemTimersSetupClickableValueBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTimersSetupClickableValueBinding bind(View view, Object obj) {
        return (ItemTimersSetupClickableValueBinding) bind(obj, view, C2814R.C2819layout.item_timers_setup_clickable_value);
    }
}
