package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentOnboardingUpdateStartBinding extends ViewDataBinding {
    @Bindable
    protected boolean mCancellable;
    public final Button onboardingCancelButton;
    public final TextView onboardingStartUpdateBody;
    public final Button onboardingStartUpdateButton;
    public final ImageView onboardingStartUpdateImage;
    public final TextView onboardingStartUpdateTitle;

    public abstract void setCancellable(boolean z);

    protected FragmentOnboardingUpdateStartBinding(Object obj, View view, int i, Button button, TextView textView, Button button2, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.onboardingCancelButton = button;
        this.onboardingStartUpdateBody = textView;
        this.onboardingStartUpdateButton = button2;
        this.onboardingStartUpdateImage = imageView;
        this.onboardingStartUpdateTitle = textView2;
    }

    public boolean getCancellable() {
        return this.mCancellable;
    }

    public static FragmentOnboardingUpdateStartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingUpdateStartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentOnboardingUpdateStartBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_onboarding_update_start, viewGroup, z, obj);
    }

    public static FragmentOnboardingUpdateStartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingUpdateStartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentOnboardingUpdateStartBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_onboarding_update_start, (ViewGroup) null, false, obj);
    }

    public static FragmentOnboardingUpdateStartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingUpdateStartBinding bind(View view, Object obj) {
        return (FragmentOnboardingUpdateStartBinding) bind(obj, view, C2814R.C2819layout.fragment_onboarding_update_start);
    }
}
