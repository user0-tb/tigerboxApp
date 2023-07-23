package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentOnboardingRegistrationBinding implements ViewBinding {
    public final TextView onboardingRegistrationBody;
    public final Button onboardingRegistrationButton;
    public final ImageView onboardingRegistrationQrCode;
    public final ImageView onboardingRegistrationTigerIcon;
    public final TextView onboardingRegistrationTitle;
    public final TextView onboardingRegistrationUrl;
    public final Guideline onboardingRegistrationVertGuideline;
    private final ConstraintLayout rootView;

    private FragmentOnboardingRegistrationBinding(ConstraintLayout constraintLayout, TextView textView, Button button, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3, Guideline guideline) {
        this.rootView = constraintLayout;
        this.onboardingRegistrationBody = textView;
        this.onboardingRegistrationButton = button;
        this.onboardingRegistrationQrCode = imageView;
        this.onboardingRegistrationTigerIcon = imageView2;
        this.onboardingRegistrationTitle = textView2;
        this.onboardingRegistrationUrl = textView3;
        this.onboardingRegistrationVertGuideline = guideline;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOnboardingRegistrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOnboardingRegistrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_onboarding_registration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOnboardingRegistrationBinding bind(View view) {
        int i = C2814R.C2817id.f1686onboardingregistrationbody;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1686onboardingregistrationbody);
        if (textView != null) {
            i = C2814R.C2817id.f1687onboardingregistrationbutton;
            Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1687onboardingregistrationbutton);
            if (button != null) {
                i = C2814R.C2817id.f1688onboardingregistrationqr_code;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1688onboardingregistrationqr_code);
                if (imageView != null) {
                    i = C2814R.C2817id.f1689onboardingregistrationtiger_icon;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1689onboardingregistrationtiger_icon);
                    if (imageView2 != null) {
                        i = C2814R.C2817id.f1690onboardingregistrationtitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1690onboardingregistrationtitle);
                        if (textView2 != null) {
                            i = C2814R.C2817id.f1691onboardingregistrationurl;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1691onboardingregistrationurl);
                            if (textView3 != null) {
                                i = C2814R.C2817id.f1692onboardingregistrationvert_guideline;
                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, C2814R.C2817id.f1692onboardingregistrationvert_guideline);
                                if (guideline != null) {
                                    return new FragmentOnboardingRegistrationBinding((ConstraintLayout) view, textView, button, imageView, imageView2, textView2, textView3, guideline);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
