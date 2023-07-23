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

public final class FragmentWildcardReassigningStep3Binding implements ViewBinding {
    public final ProgressBar onboardingBackendCommunicationConnectionIcon;
    private final ConstraintLayout rootView;
    public final TextView wildcardReassigningStep3Body;
    public final TextView wildcardReassigningStep3Title;

    private FragmentWildcardReassigningStep3Binding(ConstraintLayout constraintLayout, ProgressBar progressBar, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.onboardingBackendCommunicationConnectionIcon = progressBar;
        this.wildcardReassigningStep3Body = textView;
        this.wildcardReassigningStep3Title = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentWildcardReassigningStep3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentWildcardReassigningStep3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_wildcard_reassigning_step3, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentWildcardReassigningStep3Binding bind(View view) {
        int i = C2814R.C2817id.f1660onboardingbackendCommunicationconnection_icon;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, C2814R.C2817id.f1660onboardingbackendCommunicationconnection_icon);
        if (progressBar != null) {
            i = C2814R.C2817id.f1811wildcard_reassigningstep_3body;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1811wildcard_reassigningstep_3body);
            if (textView != null) {
                i = C2814R.C2817id.f1812wildcard_reassigningstep_3title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1812wildcard_reassigningstep_3title);
                if (textView2 != null) {
                    return new FragmentWildcardReassigningStep3Binding((ConstraintLayout) view, progressBar, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
