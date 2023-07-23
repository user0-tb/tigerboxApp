package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public abstract class FragmentWifiEnterPasswordBinding extends ViewDataBinding {
    @Bindable
    protected UnTypedBindingClickListener mCloseHandler;
    @Bindable
    protected String mPassword;
    @Bindable
    protected String mWifiName;
    public final TextView wifiEnterPasswordSsidName;
    public final Button wifiEnterPswCancelButton;
    public final Button wifiEnterPswConfirmButton;
    public final TextInputEditText wifiEnterPswEditText;
    public final TextInputLayout wifiEnterPswEditTextLayout;
    public final TextView wifiEnterPswTitle;
    public final LinearLayout wifiEnterPswWifiName;

    public abstract void setCloseHandler(UnTypedBindingClickListener unTypedBindingClickListener);

    public abstract void setPassword(String str);

    public abstract void setWifiName(String str);

    protected FragmentWifiEnterPasswordBinding(Object obj, View view, int i, TextView textView, Button button, Button button2, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextView textView2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.wifiEnterPasswordSsidName = textView;
        this.wifiEnterPswCancelButton = button;
        this.wifiEnterPswConfirmButton = button2;
        this.wifiEnterPswEditText = textInputEditText;
        this.wifiEnterPswEditTextLayout = textInputLayout;
        this.wifiEnterPswTitle = textView2;
        this.wifiEnterPswWifiName = linearLayout;
    }

    public String getWifiName() {
        return this.mWifiName;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public UnTypedBindingClickListener getCloseHandler() {
        return this.mCloseHandler;
    }

    public static FragmentWifiEnterPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiEnterPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentWifiEnterPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_wifi_enter_password, viewGroup, z, obj);
    }

    public static FragmentWifiEnterPasswordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiEnterPasswordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentWifiEnterPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_wifi_enter_password, (ViewGroup) null, false, obj);
    }

    public static FragmentWifiEnterPasswordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiEnterPasswordBinding bind(View view, Object obj) {
        return (FragmentWifiEnterPasswordBinding) bind(obj, view, C2814R.C2819layout.fragment_wifi_enter_password);
    }
}
