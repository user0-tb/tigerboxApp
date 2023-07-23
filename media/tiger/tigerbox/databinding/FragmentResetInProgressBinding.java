package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentResetInProgressBinding implements ViewBinding {
    public final TextView resetInProgressMessage;
    public final ProgressBar resetInProgressSpinner;
    public final TextView resetInProgressTitle;
    private final ConstraintLayout rootView;
    public final ConstraintLayout wildcardReassigningStep2Container;

    private FragmentResetInProgressBinding(ConstraintLayout constraintLayout, TextView textView, ProgressBar progressBar, TextView textView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.resetInProgressMessage = textView;
        this.resetInProgressSpinner = progressBar;
        this.resetInProgressTitle = textView2;
        this.wildcardReassigningStep2Container = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentResetInProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentResetInProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_reset_in_progress, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentResetInProgressBinding bind(View view) {
        int i = C2814R.C2817id.f1747resetInProgressmessage;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1747resetInProgressmessage);
        if (textView != null) {
            i = C2814R.C2817id.f1748resetInProgressspinner;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, C2814R.C2817id.f1748resetInProgressspinner);
            if (progressBar != null) {
                i = C2814R.C2817id.f1749resetInProgresstitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1749resetInProgresstitle);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new FragmentResetInProgressBinding(constraintLayout, textView, progressBar, textView2, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
