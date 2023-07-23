package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.model.domain.ProfilesItem;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public abstract class FragmentMiniProfilesBinding extends ViewDataBinding {
    @Bindable
    protected UnTypedBindingClickListener mNavigateListener;
    @Bindable
    protected ProfilesItem mProfile;
    public final ImageView profilesAvatar;
    public final LinearLayout profilesContainer;

    public abstract void setNavigateListener(UnTypedBindingClickListener unTypedBindingClickListener);

    public abstract void setProfile(ProfilesItem profilesItem);

    protected FragmentMiniProfilesBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.profilesAvatar = imageView;
        this.profilesContainer = linearLayout;
    }

    public UnTypedBindingClickListener getNavigateListener() {
        return this.mNavigateListener;
    }

    public ProfilesItem getProfile() {
        return this.mProfile;
    }

    public static FragmentMiniProfilesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMiniProfilesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMiniProfilesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_mini_profiles, viewGroup, z, obj);
    }

    public static FragmentMiniProfilesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMiniProfilesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMiniProfilesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_mini_profiles, (ViewGroup) null, false, obj);
    }

    public static FragmentMiniProfilesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMiniProfilesBinding bind(View view, Object obj) {
        return (FragmentMiniProfilesBinding) bind(obj, view, C2814R.C2819layout.fragment_mini_profiles);
    }
}
