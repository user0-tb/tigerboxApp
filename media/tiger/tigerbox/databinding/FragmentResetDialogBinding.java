package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentResetDialogBinding implements ViewBinding {
    public final Button fragmentResetDialogCancelButton;
    public final Guideline fragmentResetDialogGuideline;
    public final TextView fragmentResetDialogMessage;
    public final Button fragmentResetDialogOkButton;
    public final TextView fragmentResetDialogTitle;
    private final ConstraintLayout rootView;
    public final ConstraintLayout wildcardReassigningStep2Container;

    private FragmentResetDialogBinding(ConstraintLayout constraintLayout, Button button, Guideline guideline, TextView textView, Button button2, TextView textView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.fragmentResetDialogCancelButton = button;
        this.fragmentResetDialogGuideline = guideline;
        this.fragmentResetDialogMessage = textView;
        this.fragmentResetDialogOkButton = button2;
        this.fragmentResetDialogTitle = textView2;
        this.wildcardReassigningStep2Container = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentResetDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentResetDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_reset_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentResetDialogBinding bind(View view) {
        int i = C2814R.C2817id.f1561fragmentresetDialogcancel_button;
        Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1561fragmentresetDialogcancel_button);
        if (button != null) {
            i = C2814R.C2817id.f1562fragmentresetDialogguideline;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, C2814R.C2817id.f1562fragmentresetDialogguideline);
            if (guideline != null) {
                i = C2814R.C2817id.f1563fragmentresetDialogmessage;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1563fragmentresetDialogmessage);
                if (textView != null) {
                    i = C2814R.C2817id.f1564fragmentresetDialogok_button;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1564fragmentresetDialogok_button);
                    if (button2 != null) {
                        i = C2814R.C2817id.f1565fragmentresetDialogtitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1565fragmentresetDialogtitle);
                        if (textView2 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            return new FragmentResetDialogBinding(constraintLayout, button, guideline, textView, button2, textView2, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
