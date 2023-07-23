package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupItem;

public abstract class ItemTimersSetupTitleBinding extends ViewDataBinding {
    @Bindable
    protected TimersSetupItem mTimersSetupItem;
    public final TextView timersSetupItemLabel;

    public abstract void setTimersSetupItem(TimersSetupItem timersSetupItem);

    protected ItemTimersSetupTitleBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.timersSetupItemLabel = textView;
    }

    public TimersSetupItem getTimersSetupItem() {
        return this.mTimersSetupItem;
    }

    public static ItemTimersSetupTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTimersSetupTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTimersSetupTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_timers_setup_title, viewGroup, z, obj);
    }

    public static ItemTimersSetupTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTimersSetupTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTimersSetupTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_timers_setup_title, (ViewGroup) null, false, obj);
    }

    public static ItemTimersSetupTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTimersSetupTitleBinding bind(View view, Object obj) {
        return (ItemTimersSetupTitleBinding) bind(obj, view, C2814R.C2819layout.item_timers_setup_title);
    }
}
