package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentInfoDialogBinding extends ViewDataBinding {
    public final ImageView closeButton;
    public final TextView infoDialogBody;
    public final Button infoDialogCancelButton;
    public final ImageView infoDialogErrorIcon;
    public final Guideline infoDialogGuideline;
    public final Button infoDialogSubmitButton;
    public final ImageView infoDialogSwipeIndicator;
    public final TextView infoDialogTitle;
    @Bindable
    protected boolean mCloseButtonVisible;
    @Bindable
    protected boolean mTitleVisible;
    public final ConstraintLayout onboardingErrorDialogContent;

    public abstract void setCloseButtonVisible(boolean z);

    public abstract void setTitleVisible(boolean z);

    protected FragmentInfoDialogBinding(Object obj, View view, int i, ImageView imageView, TextView textView, Button button, ImageView imageView2, Guideline guideline, Button button2, ImageView imageView3, TextView textView2, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.closeButton = imageView;
        this.infoDialogBody = textView;
        this.infoDialogCancelButton = button;
        this.infoDialogErrorIcon = imageView2;
        this.infoDialogGuideline = guideline;
        this.infoDialogSubmitButton = button2;
        this.infoDialogSwipeIndicator = imageView3;
        this.infoDialogTitle = textView2;
        this.onboardingErrorDialogContent = constraintLayout;
    }

    public boolean getTitleVisible() {
        return this.mTitleVisible;
    }

    public boolean getCloseButtonVisible() {
        return this.mCloseButtonVisible;
    }

    public static FragmentInfoDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInfoDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentInfoDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_info_dialog, viewGroup, z, obj);
    }

    public static FragmentInfoDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInfoDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentInfoDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_info_dialog, (ViewGroup) null, false, obj);
    }

    public static FragmentInfoDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInfoDialogBinding bind(View view, Object obj) {
        return (FragmentInfoDialogBinding) bind(obj, view, C2814R.C2819layout.fragment_info_dialog);
    }
}
