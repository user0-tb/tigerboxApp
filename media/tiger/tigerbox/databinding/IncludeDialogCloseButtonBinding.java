package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.viewbinding.ViewBinding;
import java.util.Objects;
import media.tiger.tigerbox.C2814R;

public final class IncludeDialogCloseButtonBinding implements ViewBinding {
    private final ImageButton rootView;

    private IncludeDialogCloseButtonBinding(ImageButton imageButton) {
        this.rootView = imageButton;
    }

    public ImageButton getRoot() {
        return this.rootView;
    }

    public static IncludeDialogCloseButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IncludeDialogCloseButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.include_dialog_close_button, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IncludeDialogCloseButtonBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new IncludeDialogCloseButtonBinding((ImageButton) view);
    }
}
