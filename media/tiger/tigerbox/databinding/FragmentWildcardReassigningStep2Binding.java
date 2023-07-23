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

public final class FragmentWildcardReassigningStep2Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView textView;
    public final Button wildcardReassigningStep2CancelButton;
    public final ConstraintLayout wildcardReassigningStep2Container;
    public final Button wildcardReassigningStep2OkButton;
    public final TextView wildcardReassigningStep2Text;
    public final TextView wildcardReassigningStep2Title;

    private FragmentWildcardReassigningStep2Binding(ConstraintLayout constraintLayout, TextView textView2, Button button, ConstraintLayout constraintLayout2, Button button2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.textView = textView2;
        this.wildcardReassigningStep2CancelButton = button;
        this.wildcardReassigningStep2Container = constraintLayout2;
        this.wildcardReassigningStep2OkButton = button2;
        this.wildcardReassigningStep2Text = textView3;
        this.wildcardReassigningStep2Title = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentWildcardReassigningStep2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentWildcardReassigningStep2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_wildcard_reassigning_step2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentWildcardReassigningStep2Binding bind(View view) {
        int i = C2814R.C2817id.textView;
        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.textView);
        if (textView2 != null) {
            i = C2814R.C2817id.f1807wildcard_reassigningstep_2cancel_button;
            Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1807wildcard_reassigningstep_2cancel_button);
            if (button != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = C2814R.C2817id.f1808wildcard_reassigningstep_2ok_button;
                Button button2 = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1808wildcard_reassigningstep_2ok_button);
                if (button2 != null) {
                    i = C2814R.C2817id.f1809wildcard_reassigningstep_2text;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1809wildcard_reassigningstep_2text);
                    if (textView3 != null) {
                        i = C2814R.C2817id.f1810wildcard_reassigningstep_2title;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1810wildcard_reassigningstep_2title);
                        if (textView4 != null) {
                            return new FragmentWildcardReassigningStep2Binding(constraintLayout, textView2, button, constraintLayout, button2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
