package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentTigerTicketValidBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ImageView ticketBoxBackground;
    public final TextView ticketStepMessage;
    public final TextView ticketStepTitle;

    private FragmentTigerTicketValidBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.ticketBoxBackground = imageView;
        this.ticketStepMessage = textView;
        this.ticketStepTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTigerTicketValidBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentTigerTicketValidBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_tiger_ticket_valid, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentTigerTicketValidBinding bind(View view) {
        int i = C2814R.C2817id.f1777ticket_boxbackground;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1777ticket_boxbackground);
        if (imageView != null) {
            i = C2814R.C2817id.ticket_step_message;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.ticket_step_message);
            if (textView != null) {
                i = C2814R.C2817id.ticket_step_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.ticket_step_title);
                if (textView2 != null) {
                    return new FragmentTigerTicketValidBinding((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
