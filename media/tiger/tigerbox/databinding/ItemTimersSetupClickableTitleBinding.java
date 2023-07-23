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

public abstract class ItemTimersSetupClickableTitleBinding extends ViewDataBinding {
    @Bindable
    protected TimersSetupItem mTimersSetupItem;
    public final TextView timersSetupItemTitle;

    public abstract void setTimersSetupItem(TimersSetupItem timersSetupItem);

    protected ItemTimersSetupClickableTitleBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.timersSetupItemTitle = textView;
    }

    public TimersSetupItem getTimersSetupItem() {
        return this.mTimersSetupItem;
    }

    public static ItemTimersSetupClickableTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTimersSetupClickableTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTimersSetupClickableTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_timers_setup_clickable_title, viewGroup, z, obj);
    }

    public static ItemTimersSetupClickableTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTimersSetupClickableTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTimersSetupClickableTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_timers_setup_clickable_title, (ViewGroup) null, false, obj);
    }

    public static ItemTimersSetupClickableTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTimersSetupClickableTitleBinding bind(View view, Object obj) {
        return (ItemTimersSetupClickableTitleBinding) bind(obj, view, C2814R.C2819layout.item_timers_setup_clickable_title);
    }
}
