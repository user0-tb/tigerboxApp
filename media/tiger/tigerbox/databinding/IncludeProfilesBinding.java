package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import media.tiger.tigerbox.C2814R;

public abstract class IncludeProfilesBinding extends ViewDataBinding {
    public final RecyclerView profilesInnerRecyclerView;
    public final LinearLayout profilesRowContainer;

    protected IncludeProfilesBinding(Object obj, View view, int i, RecyclerView recyclerView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.profilesInnerRecyclerView = recyclerView;
        this.profilesRowContainer = linearLayout;
    }

    public static IncludeProfilesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludeProfilesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeProfilesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.include_profiles, viewGroup, z, obj);
    }

    public static IncludeProfilesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludeProfilesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeProfilesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.include_profiles, (ViewGroup) null, false, obj);
    }

    public static IncludeProfilesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IncludeProfilesBinding bind(View view, Object obj) {
        return (IncludeProfilesBinding) bind(obj, view, C2814R.C2819layout.include_profiles);
    }
}
