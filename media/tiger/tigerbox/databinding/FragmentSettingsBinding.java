package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentSettingsBinding extends ViewDataBinding {
    public final IncludeDialogHeaderBarBinding fragmentHeaderBar;
    @Bindable
    protected Boolean mSubscriptionAboutToExpired;
    @Bindable
    protected String mSubscriptionEndDate;
    @Bindable
    protected Boolean mSubscriptionExpired;
    @Bindable
    protected Boolean mSubscriptionVisible;
    public final ConstraintLayout settingsContainer;
    public final RecyclerView settingsRecyclerView;
    public final TextView settingsSubscriptionInfo;

    public abstract void setSubscriptionAboutToExpired(Boolean bool);

    public abstract void setSubscriptionEndDate(String str);

    public abstract void setSubscriptionExpired(Boolean bool);

    public abstract void setSubscriptionVisible(Boolean bool);

    protected FragmentSettingsBinding(Object obj, View view, int i, IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.fragmentHeaderBar = includeDialogHeaderBarBinding;
        this.settingsContainer = constraintLayout;
        this.settingsRecyclerView = recyclerView;
        this.settingsSubscriptionInfo = textView;
    }

    public String getSubscriptionEndDate() {
        return this.mSubscriptionEndDate;
    }

    public Boolean getSubscriptionExpired() {
        return this.mSubscriptionExpired;
    }

    public Boolean getSubscriptionVisible() {
        return this.mSubscriptionVisible;
    }

    public Boolean getSubscriptionAboutToExpired() {
        return this.mSubscriptionAboutToExpired;
    }

    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_settings, viewGroup, z, obj);
    }

    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_settings, (ViewGroup) null, false, obj);
    }

    public static FragmentSettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsBinding bind(View view, Object obj) {
        return (FragmentSettingsBinding) bind(obj, view, C2814R.C2819layout.fragment_settings);
    }
}
