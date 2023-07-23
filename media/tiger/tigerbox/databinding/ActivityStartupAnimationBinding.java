package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class ActivityStartupAnimationBinding implements ViewBinding {
    public final RelativeLayout activityStartupAnimationLayout;
    private final RelativeLayout rootView;
    public final ImageView tigerboxTextAnimation;

    private ActivityStartupAnimationBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView) {
        this.rootView = relativeLayout;
        this.activityStartupAnimationLayout = relativeLayout2;
        this.tigerboxTextAnimation = imageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityStartupAnimationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityStartupAnimationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.activity_startup_animation, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityStartupAnimationBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, C2814R.C2817id.tigerbox_text_animation);
        if (imageView != null) {
            return new ActivityStartupAnimationBinding(relativeLayout, relativeLayout, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C2814R.C2817id.tigerbox_text_animation)));
    }
}
