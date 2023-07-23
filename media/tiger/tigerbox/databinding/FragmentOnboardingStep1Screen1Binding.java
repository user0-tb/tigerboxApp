package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentOnboardingStep1Screen1Binding implements ViewBinding {
    public final TextView onboardingStep1Body;
    public final Button onboardingStep1Button;
    public final ImageView onboardingStep1Image;
    public final TextView onboardingStep1Title;
    public final ConstraintLayout relativeLayout;
    private final ConstraintLayout rootView;

    private FragmentOnboardingStep1Screen1Binding(ConstraintLayout constraintLayout, TextView textView, Button button, ImageView imageView, TextView textView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.onboardingStep1Body = textView;
        this.onboardingStep1Button = button;
        this.onboardingStep1Image = imageView;
        this.onboardingStep1Title = textView2;
        this.relativeLayout = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOnboardingStep1Screen1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOnboardingStep1Screen1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_onboarding_step1_screen1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOnboardingStep1Screen1Binding bind(View view) {
        int i = C2814R.C2817id.f1697onboardingstep1body;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1697onboardingstep1body);
        if (textView != null) {
            i = C2814R.C2817id.f1698onboardingstep1button;
            Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1698onboardingstep1button);
            if (button != null) {
                i = C2814R.C2817id.f1699onboardingstep1image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1699onboardingstep1image);
                if (imageView != null) {
                    i = C2814R.C2817id.f1700onboardingstep1title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1700onboardingstep1title);
                    if (textView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        return new FragmentOnboardingStep1Screen1Binding(constraintLayout, textView, button, imageView, textView2, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
