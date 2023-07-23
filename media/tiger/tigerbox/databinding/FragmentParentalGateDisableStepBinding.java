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

public final class FragmentParentalGateDisableStepBinding implements ViewBinding {
    public final Button fragmentParentalGateDisableStepCancelButton;
    public final Guideline fragmentParentalGateDisableStepGuideline;
    public final TextView fragmentParentalGateDisableStepMessage;
    public final Button fragmentParentalGateDisableStepOkButton;
    public final TextView fragmentParentalGateDisableStepTitle;
    private final ConstraintLayout rootView;
    public final ConstraintLayout wildcardReassigningStep2Container;

    private FragmentParentalGateDisableStepBinding(ConstraintLayout constraintLayout, Button button, Guideline guideline, TextView textView, Button button2, TextView textView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.fragmentParentalGateDisableStepCancelButton = button;
        this.fragmentParentalGateDisableStepGuideline = guideline;
        this.fragmentParentalGateDisableStepMessage = textView;
        this.fragmentParentalGateDisableStepOkButton = button2;
        this.fragmentParentalGateDisableStepTitle = textView2;
        this.wildcardReassigningStep2Container = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentParentalGateDisableStepBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentParentalGateDisableStepBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_parental_gate_disable_step, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentParentalGateDisableStepBinding bind(View view) {
        int i = C2814R.C2817id.f1544fragmentparentalGatedisableStepcancel_button;
        Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1544fragmentparentalGatedisableStepcancel_button);
        if (button != null) {
            i = C2814R.C2817id.f1545fragmentparentalGatedisableStepguideline;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, C2814R.C2817id.f1545fragmentparentalGatedisableStepguideline);
            if (guideline != null) {
                i = C2814R.C2817id.f1546fragmentparentalGatedisableStepmessage;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1546fragmentparentalGatedisableStepmessage);
                if (textView != null) {
                    i = C2814R.C2817id.f1547fragmentparentalGatedisableStepok_button;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1547fragmentparentalGatedisableStepok_button);
                    if (button2 != null) {
                        i = C2814R.C2817id.f1548fragmentparentalGatedisableSteptitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1548fragmentparentalGatedisableSteptitle);
                        if (textView2 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            return new FragmentParentalGateDisableStepBinding(constraintLayout, button, guideline, textView, button2, textView2, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
