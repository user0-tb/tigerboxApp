package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentOfflineModeBinding implements ViewBinding {
    public final TextView mainContentOfflineModeText;
    public final TextView mainContentOfflineModeTitle;
    public final LinearLayout offlineModeOfflineModeContainer;
    public final RecyclerView offlineModeParentRecyclerView;
    private final ConstraintLayout rootView;

    private FragmentOfflineModeBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, LinearLayout linearLayout, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.mainContentOfflineModeText = textView;
        this.mainContentOfflineModeTitle = textView2;
        this.offlineModeOfflineModeContainer = linearLayout;
        this.offlineModeParentRecyclerView = recyclerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOfflineModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOfflineModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_offline_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOfflineModeBinding bind(View view) {
        int i = C2814R.C2817id.f1626mainContentofflineMode_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1626mainContentofflineMode_text);
        if (textView != null) {
            i = C2814R.C2817id.f1627mainContentofflineMode_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1627mainContentofflineMode_title);
            if (textView2 != null) {
                i = C2814R.C2817id.f1657offlineModeofflineMode_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, C2814R.C2817id.f1657offlineModeofflineMode_container);
                if (linearLayout != null) {
                    i = C2814R.C2817id.f1658offlineModeparent_recycler_view;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1658offlineModeparent_recycler_view);
                    if (recyclerView != null) {
                        return new FragmentOfflineModeBinding((ConstraintLayout) view, textView, textView2, linearLayout, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
