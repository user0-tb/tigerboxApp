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

public final class FragmentOnboardingStep1Screen2Binding implements ViewBinding {
    public final TextView onboardingStep2Body;
    public final Button onboardingStep2Button;
    public final ConstraintLayout relativeLayout2;
    private final ConstraintLayout rootView;

    private FragmentOnboardingStep1Screen2Binding(ConstraintLayout constraintLayout, TextView textView, Button button, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.onboardingStep2Body = textView;
        this.onboardingStep2Button = button;
        this.relativeLayout2 = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOnboardingStep1Screen2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOnboardingStep1Screen2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_onboarding_step1_screen2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOnboardingStep1Screen2Binding bind(View view) {
        int i = C2814R.C2817id.f1701onboardingstep2body;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1701onboardingstep2body);
        if (textView != null) {
            i = C2814R.C2817id.f1702onboardingstep2button;
            Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1702onboardingstep2button);
            if (button != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new FragmentOnboardingStep1Screen2Binding(constraintLayout, textView, button, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
