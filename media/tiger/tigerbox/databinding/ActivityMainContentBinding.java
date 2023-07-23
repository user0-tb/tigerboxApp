package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import media.tiger.tigerbox.C2814R;

public final class ActivityMainContentBinding implements ViewBinding {
    public final FragmentContainerView headerBarFragment;
    public final ConstraintLayout mainContentActivityLayout;
    public final ImageView mainContentCardModesIcon;
    public final ConstraintLayout mainContentCardModus;
    public final FrameLayout mainContentContainer;
    public final ProgressBar mainContentLoadingSpinner;
    public final Button mainContentLockModeButton;
    public final ConstraintLayout mainContentLockModeContainer;
    public final ImageView mainContentLockModeIcon;
    public final TextView mainContentLockModeText;
    public final FragmentContainerView mainContentNavGraphFragment;
    public final FragmentContainerView miniPlayerFragment;
    public final FragmentContainerView miniProfilesFragment;
    private final ConstraintLayout rootView;

    private ActivityMainContentBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView, ConstraintLayout constraintLayout2, ImageView imageView, ConstraintLayout constraintLayout3, FrameLayout frameLayout, ProgressBar progressBar, Button button, ConstraintLayout constraintLayout4, ImageView imageView2, TextView textView, FragmentContainerView fragmentContainerView2, FragmentContainerView fragmentContainerView3, FragmentContainerView fragmentContainerView4) {
        this.rootView = constraintLayout;
        this.headerBarFragment = fragmentContainerView;
        this.mainContentActivityLayout = constraintLayout2;
        this.mainContentCardModesIcon = imageView;
        this.mainContentCardModus = constraintLayout3;
        this.mainContentContainer = frameLayout;
        this.mainContentLoadingSpinner = progressBar;
        this.mainContentLockModeButton = button;
        this.mainContentLockModeContainer = constraintLayout4;
        this.mainContentLockModeIcon = imageView2;
        this.mainContentLockModeText = textView;
        this.mainContentNavGraphFragment = fragmentContainerView2;
        this.miniPlayerFragment = fragmentContainerView3;
        this.miniProfilesFragment = fragmentContainerView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMainContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2814R.C2819layout.activity_main_content, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainContentBinding bind(View view) {
        View view2 = view;
        int i = C2814R.C2817id.headerBarFragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view2, C2814R.C2817id.headerBarFragment);
        if (fragmentContainerView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view2;
            i = C2814R.C2817id.f1615mainContentcard_modesicon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, C2814R.C2817id.f1615mainContentcard_modesicon);
            if (imageView != null) {
                i = C2814R.C2817id.f1616mainContentcard_modus;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, C2814R.C2817id.f1616mainContentcard_modus);
                if (constraintLayout2 != null) {
                    i = C2814R.C2817id.f1617mainContentcontainer;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, C2814R.C2817id.f1617mainContentcontainer);
                    if (frameLayout != null) {
                        i = C2814R.C2817id.f1619mainContentloading_spinner;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, C2814R.C2817id.f1619mainContentloading_spinner);
                        if (progressBar != null) {
                            i = C2814R.C2817id.f1620mainContentlock_mode_button;
                            Button button = (Button) ViewBindings.findChildViewById(view2, C2814R.C2817id.f1620mainContentlock_mode_button);
                            if (button != null) {
                                i = C2814R.C2817id.f1621mainContentlock_mode_container;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view2, C2814R.C2817id.f1621mainContentlock_mode_container);
                                if (constraintLayout3 != null) {
                                    i = C2814R.C2817id.f1622mainContentlock_mode_icon;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, C2814R.C2817id.f1622mainContentlock_mode_icon);
                                    if (imageView2 != null) {
                                        i = C2814R.C2817id.f1623mainContentlock_mode_text;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, C2814R.C2817id.f1623mainContentlock_mode_text);
                                        if (textView != null) {
                                            i = C2814R.C2817id.f1624mainContentnav_graph_fragment;
                                            FragmentContainerView fragmentContainerView2 = (FragmentContainerView) ViewBindings.findChildViewById(view2, C2814R.C2817id.f1624mainContentnav_graph_fragment);
                                            if (fragmentContainerView2 != null) {
                                                i = C2814R.C2817id.miniPlayerFragment;
                                                FragmentContainerView fragmentContainerView3 = (FragmentContainerView) ViewBindings.findChildViewById(view2, C2814R.C2817id.miniPlayerFragment);
                                                if (fragmentContainerView3 != null) {
                                                    i = C2814R.C2817id.miniProfilesFragment;
                                                    FragmentContainerView fragmentContainerView4 = (FragmentContainerView) ViewBindings.findChildViewById(view2, C2814R.C2817id.miniProfilesFragment);
                                                    if (fragmentContainerView4 != null) {
                                                        return new ActivityMainContentBinding(constraintLayout, fragmentContainerView, constraintLayout, imageView, constraintLayout2, frameLayout, progressBar, button, constraintLayout3, imageView2, textView, fragmentContainerView2, fragmentContainerView3, fragmentContainerView4);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
