package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentTimersSetupBinding extends ViewDataBinding {
    public final TextView description;
    public final IncludeDialogCloseButtonBinding fragmentCloseButton;
    public final RecyclerView timersSetupRecyclerView;
    public final TextView title;

    protected FragmentTimersSetupBinding(Object obj, View view, int i, TextView textView, IncludeDialogCloseButtonBinding includeDialogCloseButtonBinding, RecyclerView recyclerView, TextView textView2) {
        super(obj, view, i);
        this.description = textView;
        this.fragmentCloseButton = includeDialogCloseButtonBinding;
        this.timersSetupRecyclerView = recyclerView;
        this.title = textView2;
    }

    public static FragmentTimersSetupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimersSetupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTimersSetupBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_timers_setup, viewGroup, z, obj);
    }

    public static FragmentTimersSetupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimersSetupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTimersSetupBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_timers_setup, (ViewGroup) null, false, obj);
    }

    public static FragmentTimersSetupBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimersSetupBinding bind(View view, Object obj) {
        return (FragmentTimersSetupBinding) bind(obj, view, C2814R.C2819layout.fragment_timers_setup);
    }
}
