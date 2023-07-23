package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public abstract class FragmentOnboardingBackendResponseBinding extends ViewDataBinding {
    @Bindable
    protected UnTypedBindingClickListener mClickListener;
    public final TextView onboardingBackendResponseBody;
    public final Button onboardingBackendResponseButton;
    public final TextView onboardingBackendResponseId;
    public final TextView onboardingBackendResponseTitle;

    public abstract void setClickListener(UnTypedBindingClickListener unTypedBindingClickListener);

    protected FragmentOnboardingBackendResponseBinding(Object obj, View view, int i, TextView textView, Button button, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.onboardingBackendResponseBody = textView;
        this.onboardingBackendResponseButton = button;
        this.onboardingBackendResponseId = textView2;
        this.onboardingBackendResponseTitle = textView3;
    }

    public UnTypedBindingClickListener getClickListener() {
        return this.mClickListener;
    }

    public static FragmentOnboardingBackendResponseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingBackendResponseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentOnboardingBackendResponseBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_onboarding_backend_response, viewGroup, z, obj);
    }

    public static FragmentOnboardingBackendResponseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingBackendResponseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentOnboardingBackendResponseBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_onboarding_backend_response, (ViewGroup) null, false, obj);
    }

    public static FragmentOnboardingBackendResponseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingBackendResponseBinding bind(View view, Object obj) {
        return (FragmentOnboardingBackendResponseBinding) bind(obj, view, C2814R.C2819layout.fragment_onboarding_backend_response);
    }
}
