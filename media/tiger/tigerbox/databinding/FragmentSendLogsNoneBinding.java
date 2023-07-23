package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public abstract class FragmentSendLogsNoneBinding extends ViewDataBinding {
    public final Guideline fragmentSendLogsNoneGuideline;
    public final Guideline fragmentSendLogsNoneHGuideline;
    @Bindable
    protected UnTypedBindingClickListener mCloseHandler;
    public final Button sendLogsNoneConfirmButton;
    public final ImageView sendLogsNoneIcon;
    public final TextView sendLogsNoneMessage;
    public final TextView sendLogsNoneTitle;

    public abstract void setCloseHandler(UnTypedBindingClickListener unTypedBindingClickListener);

    protected FragmentSendLogsNoneBinding(Object obj, View view, int i, Guideline guideline, Guideline guideline2, Button button, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.fragmentSendLogsNoneGuideline = guideline;
        this.fragmentSendLogsNoneHGuideline = guideline2;
        this.sendLogsNoneConfirmButton = button;
        this.sendLogsNoneIcon = imageView;
        this.sendLogsNoneMessage = textView;
        this.sendLogsNoneTitle = textView2;
    }

    public UnTypedBindingClickListener getCloseHandler() {
        return this.mCloseHandler;
    }

    public static FragmentSendLogsNoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSendLogsNoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSendLogsNoneBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_send_logs_none, viewGroup, z, obj);
    }

    public static FragmentSendLogsNoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSendLogsNoneBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSendLogsNoneBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_send_logs_none, (ViewGroup) null, false, obj);
    }

    public static FragmentSendLogsNoneBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSendLogsNoneBinding bind(View view, Object obj) {
        return (FragmentSendLogsNoneBinding) bind(obj, view, C2814R.C2819layout.fragment_send_logs_none);
    }
}
