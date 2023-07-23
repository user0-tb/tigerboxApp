package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentTigerTicketPurchaseBinding extends ViewDataBinding {
    public final ProgressBar progressBar;
    public final TextView ticketWaitPrompt;
    public final TextView ticketWaitTitle;

    protected FragmentTigerTicketPurchaseBinding(Object obj, View view, int i, ProgressBar progressBar2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.progressBar = progressBar2;
        this.ticketWaitPrompt = textView;
        this.ticketWaitTitle = textView2;
    }

    public static FragmentTigerTicketPurchaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTigerTicketPurchaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTigerTicketPurchaseBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_tiger_ticket_purchase, viewGroup, z, obj);
    }

    public static FragmentTigerTicketPurchaseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTigerTicketPurchaseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTigerTicketPurchaseBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_tiger_ticket_purchase, (ViewGroup) null, false, obj);
    }

    public static FragmentTigerTicketPurchaseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTigerTicketPurchaseBinding bind(View view, Object obj) {
        return (FragmentTigerTicketPurchaseBinding) bind(obj, view, C2814R.C2819layout.fragment_tiger_ticket_purchase);
    }
}
