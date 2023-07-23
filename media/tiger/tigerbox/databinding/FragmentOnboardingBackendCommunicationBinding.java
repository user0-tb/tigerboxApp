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

public final class FragmentOnboardingBackendCommunicationBinding implements ViewBinding {
    public final TextView onboardingBackendCommunicationBody;
    public final ProgressBar onboardingBackendCommunicationConnectionIcon;
    public final TextView onboardingBackendCommunicationTitle;
    private final ConstraintLayout rootView;

    private FragmentOnboardingBackendCommunicationBinding(ConstraintLayout constraintLayout, TextView textView, ProgressBar progressBar, TextView textView2) {
        this.rootView = constraintLayout;
        this.onboardingBackendCommunicationBody = textView;
        this.onboardingBackendCommunicationConnectionIcon = progressBar;
        this.onboardingBackendCommunicationTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOnboardingBackendCommunicationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOnboardingBackendCommunicationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_onboarding_backend_communication, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOnboardingBackendCommunicationBinding bind(View view) {
        int i = C2814R.C2817id.f1659onboardingbackendCommunicationbody;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1659onboardingbackendCommunicationbody);
        if (textView != null) {
            i = C2814R.C2817id.f1660onboardingbackendCommunicationconnection_icon;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, C2814R.C2817id.f1660onboardingbackendCommunicationconnection_icon);
            if (progressBar != null) {
                i = C2814R.C2817id.f1661onboardingbackendCommunicationtitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1661onboardingbackendCommunicationtitle);
                if (textView2 != null) {
                    return new FragmentOnboardingBackendCommunicationBinding((ConstraintLayout) view, textView, progressBar, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
