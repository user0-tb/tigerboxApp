package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentWildcardReassigningStep1Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final Button wildcardReassigningStep1CancelButton;
    public final TextView wildcardReassigningStep1Text;
    public final TextView wildcardReassigningStep1Title;
    public final ConstraintLayout wildcardReassigningStep2Container;

    private FragmentWildcardReassigningStep1Binding(ConstraintLayout constraintLayout, Button button, TextView textView, TextView textView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.wildcardReassigningStep1CancelButton = button;
        this.wildcardReassigningStep1Text = textView;
        this.wildcardReassigningStep1Title = textView2;
        this.wildcardReassigningStep2Container = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentWildcardReassigningStep1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentWildcardReassigningStep1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_wildcard_reassigning_step1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentWildcardReassigningStep1Binding bind(View view) {
        int i = C2814R.C2817id.f1804wildcard_reassigningstep_1cancel_button;
        Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1804wildcard_reassigningstep_1cancel_button);
        if (button != null) {
            i = C2814R.C2817id.f1805wildcard_reassigningstep_1text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1805wildcard_reassigningstep_1text);
            if (textView != null) {
                i = C2814R.C2817id.f1806wildcard_reassigningstep_1title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1806wildcard_reassigningstep_1title);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new FragmentWildcardReassigningStep1Binding(constraintLayout, button, textView, textView2, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
