package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public abstract class FragmentProfilePictureBinding extends ViewDataBinding {
    public final IncludeDialogCloseButtonBinding fragmentCloseButton;
    public final TextView helpText;
    @Bindable
    protected String mImageUrl;
    @Bindable
    protected String mNickName;
    public final TextView profileNickName;
    public final ImageView profilePicture;

    public abstract void setImageUrl(String str);

    public abstract void setNickName(String str);

    protected FragmentProfilePictureBinding(Object obj, View view, int i, IncludeDialogCloseButtonBinding includeDialogCloseButtonBinding, TextView textView, TextView textView2, ImageView imageView) {
        super(obj, view, i);
        this.fragmentCloseButton = includeDialogCloseButtonBinding;
        this.helpText = textView;
        this.profileNickName = textView2;
        this.profilePicture = imageView;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getNickName() {
        return this.mNickName;
    }

    public static FragmentProfilePictureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfilePictureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentProfilePictureBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_profile_picture, viewGroup, z, obj);
    }

    public static FragmentProfilePictureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfilePictureBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentProfilePictureBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.fragment_profile_picture, (ViewGroup) null, false, obj);
    }

    public static FragmentProfilePictureBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfilePictureBinding bind(View view, Object obj) {
        return (FragmentProfilePictureBinding) bind(obj, view, C2814R.C2819layout.fragment_profile_picture);
    }
}
