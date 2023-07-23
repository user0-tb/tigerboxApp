package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentSystemInfoBinding implements ViewBinding {
    public final IncludeDialogHeaderBarBinding fragmentHeaderBar;
    private final ConstraintLayout rootView;
    public final RecyclerView systemInfoRecyclerView;

    private FragmentSystemInfoBinding(ConstraintLayout constraintLayout, IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.fragmentHeaderBar = includeDialogHeaderBarBinding;
        this.systemInfoRecyclerView = recyclerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSystemInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSystemInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_system_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSystemInfoBinding bind(View view) {
        int i = C2814R.C2817id.f1530fragmentheaderBar;
        View findChildViewById = ViewBindings.findChildViewById(view, C2814R.C2817id.f1530fragmentheaderBar);
        if (findChildViewById != null) {
            IncludeDialogHeaderBarBinding bind = IncludeDialogHeaderBarBinding.bind(findChildViewById);
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1773systemInforecycler_view);
            if (recyclerView != null) {
                return new FragmentSystemInfoBinding((ConstraintLayout) view, bind, recyclerView);
            }
            i = C2814R.C2817id.f1773systemInforecycler_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
