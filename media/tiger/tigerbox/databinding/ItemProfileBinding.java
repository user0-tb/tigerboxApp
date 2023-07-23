package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.model.domain.ProfilesItem;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;

public abstract class ItemProfileBinding extends ViewDataBinding {
    @Bindable
    protected BindingClickListener<ProfilesItem> mProfileClickListener;
    @Bindable
    protected ProfilesItem mProfileItem;
    public final ConstraintLayout productConstraintLayout;
    public final ImageView profileImage;
    public final ImageView profileImageSelection;
    public final TextView profileNickName;

    public abstract void setProfileClickListener(BindingClickListener<ProfilesItem> bindingClickListener);

    public abstract void setProfileItem(ProfilesItem profilesItem);

    protected ItemProfileBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.productConstraintLayout = constraintLayout;
        this.profileImage = imageView;
        this.profileImageSelection = imageView2;
        this.profileNickName = textView;
    }

    public BindingClickListener<ProfilesItem> getProfileClickListener() {
        return this.mProfileClickListener;
    }

    public ProfilesItem getProfileItem() {
        return this.mProfileItem;
    }

    public static ItemProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProfileBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_profile, viewGroup, z, obj);
    }

    public static ItemProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProfileBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProfileBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_profile, (ViewGroup) null, false, obj);
    }

    public static ItemProfileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProfileBinding bind(View view, Object obj) {
        return (ItemProfileBinding) bind(obj, view, C2814R.C2819layout.item_profile);
    }
}
