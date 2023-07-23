package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public abstract class FragmentTicketRedeemTicketNumberInputBinding extends ViewDataBinding {
    public final Guideline fragmentTigerTicketRedeemGuideline;
    @Bindable
    protected UnTypedBindingClickListener mCloseHandler;
    public final Button tigerTicketRedeemCancelButton;
    public final Button tigerTicketRedeemConfirmButton;
    public final TextInputEditText tigerTicketRedeemEditText;
    public final TextInputLayout tigerTicketRedeemEditTextLayout;
    public final TextView tigerTicketRedeemInputTitle;
    public final TextView tigerTicketRedeemMessage;
    public final TextView tigerTicketRedeemTitle;

    public abstract void setCloseHandler(UnTypedBindingClickListener unTypedBindingClickListener);

    protected FragmentTicketRedeemTicketNumberInputBinding(Object obj, View view, int i, Guideline guideline, Button button, Button button2, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.fragmentTigerTicketRedeemGuideline = guideline;
        this.tigerTicketRedeemCancelButton = button;
        this.tigerTicketRedeemConfirmButton = button2;
        this.tigerTicketRedeemEditText = textInputEditText;
        this.tigerTicketRedeemEditTextLayout = textInputLayout;
        this.tigerTicketRedeemInputTitle = textView;
        this.tigerTicketRedeemMessage = textView2;
        this.tigerTicketRedeemTitle = textView3;
    }

    public UnTypedBindingClickListener getCloseHandler() {
        return this.mCloseHandler;
    }

    public static FragmentTicketRedeemTicketNumberInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTicketRedeemTicketNumberInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTicketRedeemTicketNumberInputBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_ticket_redeem_ticket_number_input, viewGroup, z, obj);
    }

    public static FragmentTicketRedeemTicketNumberInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTicketRedeemTicketNumberInputBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTicketRedeemTicketNumberInputBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_ticket_redeem_ticket_number_input, (ViewGroup) null, false, obj);
    }

    public static FragmentTicketRedeemTicketNumberInputBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTicketRedeemTicketNumberInputBinding bind(View view, Object obj) {
        return (FragmentTicketRedeemTicketNumberInputBinding) bind(obj, view, C2814R.C2819layout.fragment_ticket_redeem_ticket_number_input);
    }
}
