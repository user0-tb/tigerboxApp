package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import java.util.Objects;
import media.tiger.tigerbox.C2814R;

public final class OfflineModeListHeaderBinding implements ViewBinding {
    public final TextView offlineModeListHeader;
    private final TextView rootView;

    private OfflineModeListHeaderBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.offlineModeListHeader = textView2;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static OfflineModeListHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static OfflineModeListHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.offline_mode_list_header, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static OfflineModeListHeaderBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new OfflineModeListHeaderBinding(textView, textView);
    }
}
