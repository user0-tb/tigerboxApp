package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class FragmentMediaPlayerChapterListBinding implements ViewBinding {
    public final IncludeDialogHeaderBarBinding fragmentHeaderBar;
    public final LinearLayout mediaPlayerChapterListContainer;
    public final RecyclerView mediaPlayerChapterListRecyclerView;
    public final TextView mediaPlayerChapterListTitle;
    private final LinearLayout rootView;

    private FragmentMediaPlayerChapterListBinding(LinearLayout linearLayout, IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.fragmentHeaderBar = includeDialogHeaderBarBinding;
        this.mediaPlayerChapterListContainer = linearLayout2;
        this.mediaPlayerChapterListRecyclerView = recyclerView;
        this.mediaPlayerChapterListTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMediaPlayerChapterListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentMediaPlayerChapterListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.fragment_media_player_chapter_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentMediaPlayerChapterListBinding bind(View view) {
        int i = C2814R.C2817id.f1530fragmentheaderBar;
        View findChildViewById = ViewBindings.findChildViewById(view, C2814R.C2817id.f1530fragmentheaderBar);
        if (findChildViewById != null) {
            IncludeDialogHeaderBarBinding bind = IncludeDialogHeaderBarBinding.bind(findChildViewById);
            LinearLayout linearLayout = (LinearLayout) view;
            i = C2814R.C2817id.f1632mediaPlayerchapterListrecycler_view;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1632mediaPlayerchapterListrecycler_view);
            if (recyclerView != null) {
                i = C2814R.C2817id.f1633mediaPlayerchapterListtitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, C2814R.C2817id.f1633mediaPlayerchapterListtitle);
                if (textView != null) {
                    return new FragmentMediaPlayerChapterListBinding(linearLayout, bind, linearLayout, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
