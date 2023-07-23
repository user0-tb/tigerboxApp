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

public final class FragmentSendLogsInProgressBinding implements ViewBinding {
    public final ProgressBar resetInProgressSpinner;
    private final ConstraintLayout rootView;
    public final ConstraintLayout sendLogsInProgressContainer;
    public final TextView sendLogsInProgressMessage;
    public final TextView sendLogsInProgressTitle;

    private FragmentSendLogsInProgressBinding(ConstraintLayout constraintLayout, ProgressBar progressBar, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.resetInProgressSpinner = progressBar;
        this.sendLogsInProgressContainer = constraintLayout2;
        this.sendLogsInProgressMessage = textView;
        this.sendLogsInProgressTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSendLogsInProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSendLogsInProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_send_logs_in_progress, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSendLogsInProgressBinding bind(View view) {
        int i = C2814R.C2817id.f1748resetInProgressspinner;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, C2814R.C2817id.f1748resetInProgressspinner);
        if (progressBar != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = C2814R.C2817id.f1757sendLogsInProgressmessage;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1757sendLogsInProgressmessage);
            if (textView != null) {
                i = C2814R.C2817id.f1758sendLogsInProgresstitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1758sendLogsInProgresstitle);
                if (textView2 != null) {
                    return new FragmentSendLogsInProgressBinding(constraintLayout, progressBar, constraintLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
