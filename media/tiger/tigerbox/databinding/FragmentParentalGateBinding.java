package media.tiger.tigerbox.databinding;

import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public abstract class FragmentParentalGateBinding extends ViewDataBinding {
    public final ImageButton fragmentParentalGateBackSpace;
    public final ImageButton fragmentParentalGateButton0;
    public final ImageButton fragmentParentalGateButton1;
    public final ImageButton fragmentParentalGateButton2;
    public final ImageButton fragmentParentalGateButton3;
    public final ImageButton fragmentParentalGateButton4;
    public final ImageButton fragmentParentalGateButton5;
    public final ImageButton fragmentParentalGateButton6;
    public final ImageButton fragmentParentalGateButton7;
    public final ImageButton fragmentParentalGateButton8;
    public final ImageButton fragmentParentalGateButton9;
    public final Button fragmentParentalGateCancel;
    public final TextView fragmentParentalGateCustomPinDescription;
    public final Guideline fragmentParentalGateGuideline;
    public final LinearLayout fragmentParentalGateInfoArea;
    public final LinearLayout fragmentParentalGateNumpad;
    public final TextView fragmentParentalGatePin;
    public final TextView fragmentParentalGateRandomPinAsText;
    public final TextView fragmentParentalGateRandomPinDescription;
    public final TextView fragmentParentalGateTitle;
    @Bindable
    protected Spanned mAccountPin;
    @Bindable
    protected UnTypedBindingClickListener mBackSpaceListener;
    @Bindable
    protected UnTypedBindingClickListener mCancelListener;
    @Bindable
    protected Boolean mHasError;
    @Bindable
    protected Boolean mHasRandomPin;
    @Bindable
    protected BindingClickListener<Character> mNumberClickListener;
    @Bindable
    protected Spanned mPinText;

    public abstract void setAccountPin(Spanned spanned);

    public abstract void setBackSpaceListener(UnTypedBindingClickListener unTypedBindingClickListener);

    public abstract void setCancelListener(UnTypedBindingClickListener unTypedBindingClickListener);

    public abstract void setHasError(Boolean bool);

    public abstract void setHasRandomPin(Boolean bool);

    public abstract void setNumberClickListener(BindingClickListener<Character> bindingClickListener);

    public abstract void setPinText(Spanned spanned);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected FragmentParentalGateBinding(Object obj, View view, int i, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, Button button, TextView textView, Guideline guideline, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.fragmentParentalGateBackSpace = imageButton;
        this.fragmentParentalGateButton0 = imageButton2;
        this.fragmentParentalGateButton1 = imageButton3;
        this.fragmentParentalGateButton2 = imageButton4;
        this.fragmentParentalGateButton3 = imageButton5;
        this.fragmentParentalGateButton4 = imageButton6;
        this.fragmentParentalGateButton5 = imageButton7;
        this.fragmentParentalGateButton6 = imageButton8;
        this.fragmentParentalGateButton7 = imageButton9;
        this.fragmentParentalGateButton8 = imageButton10;
        this.fragmentParentalGateButton9 = imageButton11;
        this.fragmentParentalGateCancel = button;
        this.fragmentParentalGateCustomPinDescription = textView;
        this.fragmentParentalGateGuideline = guideline;
        this.fragmentParentalGateInfoArea = linearLayout;
        this.fragmentParentalGateNumpad = linearLayout2;
        this.fragmentParentalGatePin = textView2;
        this.fragmentParentalGateRandomPinAsText = textView3;
        this.fragmentParentalGateRandomPinDescription = textView4;
        this.fragmentParentalGateTitle = textView5;
    }

    public BindingClickListener<Character> getNumberClickListener() {
        return this.mNumberClickListener;
    }

    public UnTypedBindingClickListener getBackSpaceListener() {
        return this.mBackSpaceListener;
    }

    public UnTypedBindingClickListener getCancelListener() {
        return this.mCancelListener;
    }

    public Spanned getPinText() {
        return this.mPinText;
    }

    public Boolean getHasError() {
        return this.mHasError;
    }

    public Spanned getAccountPin() {
        return this.mAccountPin;
    }

    public Boolean getHasRandomPin() {
        return this.mHasRandomPin;
    }

    public static FragmentParentalGateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentParentalGateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentParentalGateBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_parental_gate, viewGroup, z, obj);
    }

    public static FragmentParentalGateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentParentalGateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentParentalGateBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_parental_gate, (ViewGroup) null, false, obj);
    }

    public static FragmentParentalGateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentParentalGateBinding bind(View view, Object obj) {
        return (FragmentParentalGateBinding) bind(obj, view, C2814R.C2819layout.fragment_parental_gate);
    }
}
