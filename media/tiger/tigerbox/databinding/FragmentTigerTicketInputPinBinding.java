package media.tiger.tigerbox.databinding;

import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public abstract class FragmentTigerTicketInputPinBinding extends ViewDataBinding {
    public final IncludeDialogCloseButtonBinding fragmentCloseButton;
    public final ImageButton fragmentTigerCardBackSpace;
    public final ImageButton fragmentTigerCardButton0;
    public final ImageButton fragmentTigerCardButton1;
    public final ImageButton fragmentTigerCardButton2;
    public final ImageButton fragmentTigerCardButton3;
    public final ImageButton fragmentTigerCardButton4;
    public final ImageButton fragmentTigerCardButton5;
    public final ImageButton fragmentTigerCardButton6;
    public final ImageButton fragmentTigerCardButton7;
    public final ImageButton fragmentTigerCardButton8;
    public final ImageButton fragmentTigerCardButton9;
    public final TextView fragmentTigerCardError;
    public final RelativeLayout fragmentTigerCardInfo;
    public final LinearLayout fragmentTigerCardNumpad;
    public final TextView fragmentTigerCardPin;
    public final TextView fragmentTigerCardTitle;
    @Bindable
    protected Integer mAttemptCount;
    @Bindable
    protected UnTypedBindingClickListener mBackSpaceListener;
    @Bindable
    protected Boolean mHasError;
    @Bindable
    protected BindingClickListener<Character> mNumberClickListener;
    @Bindable
    protected Spanned mPinText;

    public abstract void setAttemptCount(Integer num);

    public abstract void setBackSpaceListener(UnTypedBindingClickListener unTypedBindingClickListener);

    public abstract void setHasError(Boolean bool);

    public abstract void setNumberClickListener(BindingClickListener<Character> bindingClickListener);

    public abstract void setPinText(Spanned spanned);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected FragmentTigerTicketInputPinBinding(Object obj, View view, int i, IncludeDialogCloseButtonBinding includeDialogCloseButtonBinding, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, TextView textView, RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.fragmentCloseButton = includeDialogCloseButtonBinding;
        this.fragmentTigerCardBackSpace = imageButton;
        this.fragmentTigerCardButton0 = imageButton2;
        this.fragmentTigerCardButton1 = imageButton3;
        this.fragmentTigerCardButton2 = imageButton4;
        this.fragmentTigerCardButton3 = imageButton5;
        this.fragmentTigerCardButton4 = imageButton6;
        this.fragmentTigerCardButton5 = imageButton7;
        this.fragmentTigerCardButton6 = imageButton8;
        this.fragmentTigerCardButton7 = imageButton9;
        this.fragmentTigerCardButton8 = imageButton10;
        this.fragmentTigerCardButton9 = imageButton11;
        this.fragmentTigerCardError = textView;
        this.fragmentTigerCardInfo = relativeLayout;
        this.fragmentTigerCardNumpad = linearLayout;
        this.fragmentTigerCardPin = textView2;
        this.fragmentTigerCardTitle = textView3;
    }

    public BindingClickListener<Character> getNumberClickListener() {
        return this.mNumberClickListener;
    }

    public UnTypedBindingClickListener getBackSpaceListener() {
        return this.mBackSpaceListener;
    }

    public Spanned getPinText() {
        return this.mPinText;
    }

    public Boolean getHasError() {
        return this.mHasError;
    }

    public Integer getAttemptCount() {
        return this.mAttemptCount;
    }

    public static FragmentTigerTicketInputPinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTigerTicketInputPinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTigerTicketInputPinBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_tiger_ticket_input_pin, viewGroup, z, obj);
    }

    public static FragmentTigerTicketInputPinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTigerTicketInputPinBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTigerTicketInputPinBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_tiger_ticket_input_pin, (ViewGroup) null, false, obj);
    }

    public static FragmentTigerTicketInputPinBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTigerTicketInputPinBinding bind(View view, Object obj) {
        return (FragmentTigerTicketInputPinBinding) bind(obj, view, C2814R.C2819layout.fragment_tiger_ticket_input_pin);
    }
}
