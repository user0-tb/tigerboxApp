package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentOtaNoUpdateBinding implements ViewBinding {
    public final TextView otaNoUpdateBody;
    public final Button otaNoUpdateButton;
    public final ImageView otaNoUpdateImage;
    public final TextView otaNoUpdateTitle;
    private final ConstraintLayout rootView;

    private FragmentOtaNoUpdateBinding(ConstraintLayout constraintLayout, TextView textView, Button button, ImageView imageView, TextView textView2) {
        this.rootView = constraintLayout;
        this.otaNoUpdateBody = textView;
        this.otaNoUpdateButton = button;
        this.otaNoUpdateImage = imageView;
        this.otaNoUpdateTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOtaNoUpdateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOtaNoUpdateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_ota_no_update, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOtaNoUpdateBinding bind(View view) {
        int i = C2814R.C2817id.f1713otaNoUpdatebody;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1713otaNoUpdatebody);
        if (textView != null) {
            i = C2814R.C2817id.f1714otaNoUpdatebutton;
            Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1714otaNoUpdatebutton);
            if (button != null) {
                i = C2814R.C2817id.f1715otaNoUpdateimage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1715otaNoUpdateimage);
                if (imageView != null) {
                    i = C2814R.C2817id.f1716otaNoUpdatetitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1716otaNoUpdatetitle);
                    if (textView2 != null) {
                        return new FragmentOtaNoUpdateBinding((ConstraintLayout) view, textView, button, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
