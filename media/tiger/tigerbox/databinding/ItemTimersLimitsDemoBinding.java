package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import java.util.Objects;
import media.tiger.tigerbox.C2814R;

public final class ItemTimersLimitsDemoBinding implements ViewBinding {
    private final LinearLayout rootView;

    private ItemTimersLimitsDemoBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemTimersLimitsDemoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemTimersLimitsDemoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.item_timers_limits_demo, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemTimersLimitsDemoBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ItemTimersLimitsDemoBinding((LinearLayout) view);
    }
}
