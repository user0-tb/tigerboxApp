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

public final class FragmentOnboardingStep1Screen3Binding implements ViewBinding {
    public final TextView onboardingStep3Body;
    public final Button onboardingStep3Button;
    public final TextView onboardingStep3Title;
    public final ConstraintLayout relativeLayout3;
    private final ConstraintLayout rootView;

    private FragmentOnboardingStep1Screen3Binding(ConstraintLayout constraintLayout, TextView textView, Button button, TextView textView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.onboardingStep3Body = textView;
        this.onboardingStep3Button = button;
        this.onboardingStep3Title = textView2;
        this.relativeLayout3 = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOnboardingStep1Screen3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOnboardingStep1Screen3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_onboarding_step1_screen3, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOnboardingStep1Screen3Binding bind(View view) {
        int i = C2814R.C2817id.f1703onboardingstep3body;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1703onboardingstep3body);
        if (textView != null) {
            i = C2814R.C2817id.f1704onboardingstep3button;
            Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1704onboardingstep3button);
            if (button != null) {
                i = C2814R.C2817id.f1705onboardingstep3title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1705onboardingstep3title);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new FragmentOnboardingStep1Screen3Binding(constraintLayout, textView, button, textView2, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
