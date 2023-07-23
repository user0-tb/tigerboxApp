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

public abstract class FragmentOnboardingBatteryWarningBinding extends ViewDataBinding {
    @Bindable
    protected Integer mBatteryPercent;
    @Bindable
    protected Boolean mIsCharging;
    public final TextView onboardingBatteryWarningBody;
    public final Button onboardingBatteryWarningButton;
    public final ImageView onboardingBatteryWarningImage;
    public final TextView onboardingBatteryWarningTitle;

    public abstract void setBatteryPercent(Integer num);

    public abstract void setIsCharging(Boolean bool);

    protected FragmentOnboardingBatteryWarningBinding(Object obj, View view, int i, TextView textView, Button button, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.onboardingBatteryWarningBody = textView;
        this.onboardingBatteryWarningButton = button;
        this.onboardingBatteryWarningImage = imageView;
        this.onboardingBatteryWarningTitle = textView2;
    }

    public Boolean getIsCharging() {
        return this.mIsCharging;
    }

    public Integer getBatteryPercent() {
        return this.mBatteryPercent;
    }

    public static FragmentOnboardingBatteryWarningBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingBatteryWarningBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentOnboardingBatteryWarningBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_onboarding_battery_warning, viewGroup, z, obj);
    }

    public static FragmentOnboardingBatteryWarningBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingBatteryWarningBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentOnboardingBatteryWarningBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_onboarding_battery_warning, (ViewGroup) null, false, obj);
    }

    public static FragmentOnboardingBatteryWarningBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingBatteryWarningBinding bind(View view, Object obj) {
        return (FragmentOnboardingBatteryWarningBinding) bind(obj, view, C2814R.C2819layout.fragment_onboarding_battery_warning);
    }
}
