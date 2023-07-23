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

public abstract class FragmentSendLogsFinishedBinding extends ViewDataBinding {
    public final Guideline fragmentSendLogsFinishedGuideline;
    public final Guideline fragmentSendLogsFinishedHGuideline;
    @Bindable
    protected UnTypedBindingClickListener mCloseHandler;
    public final Button sendLogsFinishedConfirmButton;
    public final ImageView sendLogsFinishedIcon;
    public final TextView sendLogsFinishedMessage;
    public final TextView sendLogsFinishedTitle;

    public abstract void setCloseHandler(UnTypedBindingClickListener unTypedBindingClickListener);

    protected FragmentSendLogsFinishedBinding(Object obj, View view, int i, Guideline guideline, Guideline guideline2, Button button, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.fragmentSendLogsFinishedGuideline = guideline;
        this.fragmentSendLogsFinishedHGuideline = guideline2;
        this.sendLogsFinishedConfirmButton = button;
        this.sendLogsFinishedIcon = imageView;
        this.sendLogsFinishedMessage = textView;
        this.sendLogsFinishedTitle = textView2;
    }

    public UnTypedBindingClickListener getCloseHandler() {
        return this.mCloseHandler;
    }

    public static FragmentSendLogsFinishedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSendLogsFinishedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSendLogsFinishedBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_send_logs_finished, viewGroup, z, obj);
    }

    public static FragmentSendLogsFinishedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSendLogsFinishedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSendLogsFinishedBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_send_logs_finished, (ViewGroup) null, false, obj);
    }

    public static FragmentSendLogsFinishedBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSendLogsFinishedBinding bind(View view, Object obj) {
        return (FragmentSendLogsFinishedBinding) bind(obj, view, C2814R.C2819layout.fragment_send_logs_finished);
    }
}
