package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentSettingsWifiListBinding implements ViewBinding {
    public final IncludeDialogCloseButtonBinding fragmentCloseButton;
    private final LinearLayout rootView;
    public final RecyclerView settingsWifiListList;
    public final TextView settingsWifiListTitle;
    public final ProgressBar wifiListScanInProgress;

    private FragmentSettingsWifiListBinding(LinearLayout linearLayout, IncludeDialogCloseButtonBinding includeDialogCloseButtonBinding, RecyclerView recyclerView, TextView textView, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.fragmentCloseButton = includeDialogCloseButtonBinding;
        this.settingsWifiListList = recyclerView;
        this.settingsWifiListTitle = textView;
        this.wifiListScanInProgress = progressBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSettingsWifiListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSettingsWifiListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_settings_wifi_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSettingsWifiListBinding bind(View view) {
        int i = C2814R.C2817id.f1529fragmentclose_button;
        View findChildViewById = ViewBindings.findChildViewById(view, C2814R.C2817id.f1529fragmentclose_button);
        if (findChildViewById != null) {
            IncludeDialogCloseButtonBinding bind = IncludeDialogCloseButtonBinding.bind(findChildViewById);
            i = C2814R.C2817id.f1771settingswifiListlist;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1771settingswifiListlist);
            if (recyclerView != null) {
                i = C2814R.C2817id.f1772settingswifiListtitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1772settingswifiListtitle);
                if (textView != null) {
                    i = C2814R.C2817id.wifiList_scanInProgress;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, C2814R.C2817id.wifiList_scanInProgress);
                    if (progressBar != null) {
                        return new FragmentSettingsWifiListBinding((LinearLayout) view, bind, recyclerView, textView, progressBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
