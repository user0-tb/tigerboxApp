package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentMainContentSeeMoreProductsBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ConstraintLayout seeMoreContainer;
    public final RecyclerView seeMoreRecyclerView;

    private FragmentMainContentSeeMoreProductsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.seeMoreContainer = constraintLayout2;
        this.seeMoreRecyclerView = recyclerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMainContentSeeMoreProductsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentMainContentSeeMoreProductsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_main_content_see_more_products, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentMainContentSeeMoreProductsBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1751seeMorerecycler_view);
        if (recyclerView != null) {
            return new FragmentMainContentSeeMoreProductsBinding(constraintLayout, constraintLayout, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C2814R.C2817id.f1751seeMorerecycler_view)));
    }
}
