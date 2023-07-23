package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersTimeLimitItem;

public abstract class ItemTimersLimitsCustomBinding extends ViewDataBinding {
    @Bindable
    protected TimersTimeLimitItem mTimersTimeLimitItem;
    public final TextView timersSetupItemTitle;

    public abstract void setTimersTimeLimitItem(TimersTimeLimitItem timersTimeLimitItem);

    protected ItemTimersLimitsCustomBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.timersSetupItemTitle = textView;
    }

    public TimersTimeLimitItem getTimersTimeLimitItem() {
        return this.mTimersTimeLimitItem;
    }

    public static ItemTimersLimitsCustomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTimersLimitsCustomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTimersLimitsCustomBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_timers_limits_custom, viewGroup, z, obj);
    }

    public static ItemTimersLimitsCustomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTimersLimitsCustomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTimersLimitsCustomBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_timers_limits_custom, (ViewGroup) null, false, obj);
    }

    public static ItemTimersLimitsCustomBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTimersLimitsCustomBinding bind(View view, Object obj) {
        return (ItemTimersLimitsCustomBinding) bind(obj, view, C2814R.C2819layout.item_timers_limits_custom);
    }
}
