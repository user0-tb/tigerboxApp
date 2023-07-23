package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentOnboardingWifiListBinding implements ViewBinding {
    public final Button onboardingWifiListContinue;
    public final TextView onboardingWifiListTitle;
    public final RecyclerView onboardingWifiListWifiList;
    private final ConstraintLayout rootView;
    public final ProgressBar wifiListScanInProgress;

    private FragmentOnboardingWifiListBinding(ConstraintLayout constraintLayout, Button button, TextView textView, RecyclerView recyclerView, ProgressBar progressBar) {
        this.rootView = constraintLayout;
        this.onboardingWifiListContinue = button;
        this.onboardingWifiListTitle = textView;
        this.onboardingWifiListWifiList = recyclerView;
        this.wifiListScanInProgress = progressBar;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOnboardingWifiListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOnboardingWifiListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_onboarding_wifi_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOnboardingWifiListBinding bind(View view) {
        int i = C2814R.C2817id.f1710onboardingwifiListcontinue;
        Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1710onboardingwifiListcontinue);
        if (button != null) {
            i = C2814R.C2817id.f1711onboardingwifiListtitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1711onboardingwifiListtitle);
            if (textView != null) {
                i = C2814R.C2817id.f1712onboardingwifiListwifi_list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1712onboardingwifiListwifi_list);
                if (recyclerView != null) {
                    i = C2814R.C2817id.wifiList_scanInProgress;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, C2814R.C2817id.wifiList_scanInProgress);
                    if (progressBar != null) {
                        return new FragmentOnboardingWifiListBinding((ConstraintLayout) view, button, textView, recyclerView, progressBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
