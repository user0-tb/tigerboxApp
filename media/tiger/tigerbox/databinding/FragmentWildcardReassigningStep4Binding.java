package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentWildcardReassigningStep4Binding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener mClickListener;
    public final TextView wildcardReassigningStep1Text;
    public final TextView wildcardReassigningStep1Title;
    public final Button wildcardReassigningStep4Button;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    protected FragmentWildcardReassigningStep4Binding(Object obj, View view, int i, TextView textView, TextView textView2, Button button) {
        super(obj, view, i);
        this.wildcardReassigningStep1Text = textView;
        this.wildcardReassigningStep1Title = textView2;
        this.wildcardReassigningStep4Button = button;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public static FragmentWildcardReassigningStep4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWildcardReassigningStep4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentWildcardReassigningStep4Binding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_wildcard_reassigning_step4, viewGroup, z, obj);
    }

    public static FragmentWildcardReassigningStep4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWildcardReassigningStep4Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentWildcardReassigningStep4Binding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_wildcard_reassigning_step4, (ViewGroup) null, false, obj);
    }

    public static FragmentWildcardReassigningStep4Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWildcardReassigningStep4Binding bind(View view, Object obj) {
        return (FragmentWildcardReassigningStep4Binding) bind(obj, view, C2814R.C2819layout.fragment_wildcard_reassigning_step4);
    }
}
