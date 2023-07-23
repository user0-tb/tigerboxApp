package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentProfilesBinding extends ViewDataBinding {
    public final IncludeDialogHeaderBarBinding fragmentHeaderBar;
    public final TextView helpText;
    public final IncludeProfilesBinding profilesContent;
    public final ConstraintLayout profilesLayout;

    protected FragmentProfilesBinding(Object obj, View view, int i, IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, TextView textView, IncludeProfilesBinding includeProfilesBinding, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.fragmentHeaderBar = includeDialogHeaderBarBinding;
        this.helpText = textView;
        this.profilesContent = includeProfilesBinding;
        this.profilesLayout = constraintLayout;
    }

    public static FragmentProfilesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfilesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentProfilesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_profiles, viewGroup, z, obj);
    }

    public static FragmentProfilesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfilesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentProfilesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_profiles, (ViewGroup) null, false, obj);
    }

    public static FragmentProfilesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfilesBinding bind(View view, Object obj) {
        return (FragmentProfilesBinding) bind(obj, view, C2814R.C2819layout.fragment_profiles);
    }
}
