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

public final class FragmentOtaStartUpdateBinding implements ViewBinding {
    public final TextView otaStartUpdateBody;
    public final Button otaStartUpdateCancelButton;
    public final ImageView otaStartUpdateOtaUpdateStars;
    public final TextView otaStartUpdateTitle;
    public final Button otaStartUpdateUpdateButton;
    private final ConstraintLayout rootView;

    private FragmentOtaStartUpdateBinding(ConstraintLayout constraintLayout, TextView textView, Button button, ImageView imageView, TextView textView2, Button button2) {
        this.rootView = constraintLayout;
        this.otaStartUpdateBody = textView;
        this.otaStartUpdateCancelButton = button;
        this.otaStartUpdateOtaUpdateStars = imageView;
        this.otaStartUpdateTitle = textView2;
        this.otaStartUpdateUpdateButton = button2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOtaStartUpdateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOtaStartUpdateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_ota_start_update, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOtaStartUpdateBinding bind(View view) {
        int i = C2814R.C2817id.f1717otaStartUpdatebody;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1717otaStartUpdatebody);
        if (textView != null) {
            i = C2814R.C2817id.f1718otaStartUpdatecancel_button;
            Button button = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1718otaStartUpdatecancel_button);
            if (button != null) {
                i = C2814R.C2817id.f1719otaStartUpdateota_update_stars;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1719otaStartUpdateota_update_stars);
                if (imageView != null) {
                    i = C2814R.C2817id.f1720otaStartUpdatetitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1720otaStartUpdatetitle);
                    if (textView2 != null) {
                        i = C2814R.C2817id.f1721otaStartUpdateupdate_button;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, C2814R.C2817id.f1721otaStartUpdateupdate_button);
                        if (button2 != null) {
                            return new FragmentOtaStartUpdateBinding((ConstraintLayout) view, textView, button, imageView, textView2, button2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
