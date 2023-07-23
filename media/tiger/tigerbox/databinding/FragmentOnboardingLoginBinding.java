package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentOnboardingLoginBinding extends ViewDataBinding {
    public final TextView onboardingLoginBody;
    public final Button onboardingLoginButton;
    public final Guideline onboardingLoginGuidelineHorizontal;
    public final TextInputEditText onboardingLoginPasswordEditText;
    public final TextInputLayout onboardingLoginPasswordEditTextLayout;
    public final TextView onboardingLoginPasswordTextView;
    public final TextView onboardingLoginTitle;
    public final EditText onboardingLoginUsernameEditText;
    public final TextView onboardingLoginUsernameTextView;

    protected FragmentOnboardingLoginBinding(Object obj, View view, int i, TextView textView, Button button, Guideline guideline, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextView textView2, TextView textView3, EditText editText, TextView textView4) {
        super(obj, view, i);
        this.onboardingLoginBody = textView;
        this.onboardingLoginButton = button;
        this.onboardingLoginGuidelineHorizontal = guideline;
        this.onboardingLoginPasswordEditText = textInputEditText;
        this.onboardingLoginPasswordEditTextLayout = textInputLayout;
        this.onboardingLoginPasswordTextView = textView2;
        this.onboardingLoginTitle = textView3;
        this.onboardingLoginUsernameEditText = editText;
        this.onboardingLoginUsernameTextView = textView4;
    }

    public static FragmentOnboardingLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentOnboardingLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_onboarding_login, viewGroup, z, obj);
    }

    public static FragmentOnboardingLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingLoginBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentOnboardingLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_onboarding_login, (ViewGroup) null, false, obj);
    }

    public static FragmentOnboardingLoginBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingLoginBinding bind(View view, Object obj) {
        return (FragmentOnboardingLoginBinding) bind(obj, view, C2814R.C2819layout.fragment_onboarding_login);
    }
}
