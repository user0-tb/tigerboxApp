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

public final class FragmentOnboardingConnectedWithInternetBinding implements ViewBinding {
    public final TextView onboardingConnectedWithInternetBody;
    public final Button onboardingConnectedWithInternetLoginButton;
    public final Button onboardingConnectedWithInternetRegistrationButton;
    public final TextView onboardingConnectedWithInternetTitle;
    private final ConstraintLayout rootView;

    private FragmentOnboardingConnectedWithInternetBinding(ConstraintLayout constraintLayout, TextView textView, Button button, Button button2, TextView textView2) {
        this.rootView = constraintLayout;
        this.onboardingConnectedWithInternetBody = textView;
        this.onboardingConnectedWithInternetLoginButton = button;
        this.onboardingConnectedWithInternetRegistrationButton = button2;
        this.onboardingConnectedWithInternetTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOnboardingConnectedWithInternetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOnboardingConnectedWithInternetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_onboarding_connected_with_internet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOnboardingConnectedWithInternetBinding bind(View view) {
        int i = C2814R.C2817id.f1671onboardingconnectedWithInternetbody;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1671onboardingconnectedWithInternetbody);
        if (textView != null) {
            i = C2814R.C2817id.f1672onboardingconnectedWithInternetlogin_button;
            Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1672onboardingconnectedWithInternetlogin_button);
            if (button != null) {
                i = C2814R.C2817id.f1673onboardingconnectedWithInternetregistration_button;
                Button button2 = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1673onboardingconnectedWithInternetregistration_button);
                if (button2 != null) {
                    i = C2814R.C2817id.f1674onboardingconnectedWithInternettitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1674onboardingconnectedWithInternettitle);
                    if (textView2 != null) {
                        return new FragmentOnboardingConnectedWithInternetBinding((ConstraintLayout) view, textView, button, button2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
