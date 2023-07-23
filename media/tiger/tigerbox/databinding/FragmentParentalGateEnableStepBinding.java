package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentParentalGateEnableStepBinding implements ViewBinding {
    public final Button fragmentParentalGateEnableStepCancelButton;
    public final Guideline fragmentParentalGateEnableStepGuideline;
    public final TextView fragmentParentalGateEnableStepMessage;
    public final Button fragmentParentalGateEnableStepOkButton;
    public final TextView fragmentParentalGateEnableStepTitle;
    private final ConstraintLayout rootView;
    public final ConstraintLayout wildcardReassigningStep2Container;

    private FragmentParentalGateEnableStepBinding(ConstraintLayout constraintLayout, Button button, Guideline guideline, TextView textView, Button button2, TextView textView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.fragmentParentalGateEnableStepCancelButton = button;
        this.fragmentParentalGateEnableStepGuideline = guideline;
        this.fragmentParentalGateEnableStepMessage = textView;
        this.fragmentParentalGateEnableStepOkButton = button2;
        this.fragmentParentalGateEnableStepTitle = textView2;
        this.wildcardReassigningStep2Container = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentParentalGateEnableStepBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentParentalGateEnableStepBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_parental_gate_enable_step, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentParentalGateEnableStepBinding bind(View view) {
        int i = C2814R.C2817id.f1549fragmentparentalGateenableStepcancel_button;
        Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1549fragmentparentalGateenableStepcancel_button);
        if (button != null) {
            i = C2814R.C2817id.f1550fragmentparentalGateenableStepguideline;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, C2814R.C2817id.f1550fragmentparentalGateenableStepguideline);
            if (guideline != null) {
                i = C2814R.C2817id.f1551fragmentparentalGateenableStepmessage;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1551fragmentparentalGateenableStepmessage);
                if (textView != null) {
                    i = C2814R.C2817id.f1552fragmentparentalGateenableStepok_button;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1552fragmentparentalGateenableStepok_button);
                    if (button2 != null) {
                        i = C2814R.C2817id.f1553fragmentparentalGateenableSteptitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1553fragmentparentalGateenableSteptitle);
                        if (textView2 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            return new FragmentParentalGateEnableStepBinding(constraintLayout, button, guideline, textView, button2, textView2, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
