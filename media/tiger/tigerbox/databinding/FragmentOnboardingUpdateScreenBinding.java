package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentOnboardingUpdateScreenBinding implements ViewBinding {
    public final FragmentOnboardingBatteryWarningBinding onboardingUpdateScreenBatteryWarning;
    public final FragmentOtaUpdateInProgressBinding onboardingUpdateScreenInProgress;
    public final FragmentOtaNoUpdateBinding onboardingUpdateScreenNoUpdate;
    public final FragmentOnboardingUpdateStartBinding onboardingUpdateScreenStartUpdate;
    private final FrameLayout rootView;
    public final ProgressBar updateLoadingSpinner;

    private FragmentOnboardingUpdateScreenBinding(FrameLayout frameLayout, FragmentOnboardingBatteryWarningBinding fragmentOnboardingBatteryWarningBinding, FragmentOtaUpdateInProgressBinding fragmentOtaUpdateInProgressBinding, FragmentOtaNoUpdateBinding fragmentOtaNoUpdateBinding, FragmentOnboardingUpdateStartBinding fragmentOnboardingUpdateStartBinding, ProgressBar progressBar) {
        this.rootView = frameLayout;
        this.onboardingUpdateScreenBatteryWarning = fragmentOnboardingBatteryWarningBinding;
        this.onboardingUpdateScreenInProgress = fragmentOtaUpdateInProgressBinding;
        this.onboardingUpdateScreenNoUpdate = fragmentOtaNoUpdateBinding;
        this.onboardingUpdateScreenStartUpdate = fragmentOnboardingUpdateStartBinding;
        this.updateLoadingSpinner = progressBar;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOnboardingUpdateScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOnboardingUpdateScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_onboarding_update_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOnboardingUpdateScreenBinding bind(View view) {
        int i = C2814R.C2817id.f1706onboardingupdateScreenbattery_warning;
        View findChildViewById = ViewBindings.findChildViewById(view, C2814R.C2817id.f1706onboardingupdateScreenbattery_warning);
        if (findChildViewById != null) {
            FragmentOnboardingBatteryWarningBinding bind = FragmentOnboardingBatteryWarningBinding.bind(findChildViewById);
            i = C2814R.C2817id.f1707onboardingupdateScreenin_progress;
            View findChildViewById2 = ViewBindings.findChildViewById(view, C2814R.C2817id.f1707onboardingupdateScreenin_progress);
            if (findChildViewById2 != null) {
                FragmentOtaUpdateInProgressBinding bind2 = FragmentOtaUpdateInProgressBinding.bind(findChildViewById2);
                i = C2814R.C2817id.f1708onboardingupdateScreenno_update;
                View findChildViewById3 = ViewBindings.findChildViewById(view, C2814R.C2817id.f1708onboardingupdateScreenno_update);
                if (findChildViewById3 != null) {
                    FragmentOtaNoUpdateBinding bind3 = FragmentOtaNoUpdateBinding.bind(findChildViewById3);
                    i = C2814R.C2817id.f1709onboardingupdateScreenstart_update;
                    View findChildViewById4 = ViewBindings.findChildViewById(view, C2814R.C2817id.f1709onboardingupdateScreenstart_update);
                    if (findChildViewById4 != null) {
                        FragmentOnboardingUpdateStartBinding bind4 = FragmentOnboardingUpdateStartBinding.bind(findChildViewById4);
                        i = C2814R.C2817id.f1791updateloading_spinner;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, C2814R.C2817id.f1791updateloading_spinner);
                        if (progressBar != null) {
                            return new FragmentOnboardingUpdateScreenBinding((FrameLayout) view, bind, bind2, bind3, bind4, progressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
